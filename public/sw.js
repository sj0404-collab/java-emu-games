const CACHE_PREFIX = 'local-ai-shell-';
const CACHE = `${CACHE_PREFIX}v1`;
const root = new URL('./', self.location.href);
const shell = [
  new URL('./', root).href,
  new URL('index.html', root).href,
  new URL('manifest.webmanifest', root).href,
  new URL('local-ai.svg', root).href,
  new URL('icon-192.png', root).href,
  new URL('icon-512.png', root).href,
];

self.addEventListener('install', (event) => {
  event.waitUntil(cacheShell());
  self.skipWaiting();
});

async function cacheShell() {
  const cache = await caches.open(CACHE);
  await cache.addAll(shell);

  // Vite adds hashed JS/CSS filenames at build time. Read them from the cached
  // HTML so the PWA can reopen offline immediately after the first visit.
  const indexUrl = new URL('index.html', root);
  const indexResponse = await cache.match(indexUrl);
  const html = await indexResponse.text();
  const assets = [...html.matchAll(/\b(?:src|href)=["']([^"']+)["']/gi)]
    .map((match) => new URL(match[1], indexUrl))
    .filter((url) => url.origin === self.location.origin)
    .map((url) => url.href);

  await cache.addAll([...new Set(assets)]);
}

self.addEventListener('activate', (event) => {
  event.waitUntil(
    caches.keys()
      .then((keys) => Promise.all(
        keys
          .filter((key) => key.startsWith(CACHE_PREFIX) && key !== CACHE)
          .map((key) => caches.delete(key)),
      ))
      .then(() => self.clients.claim()),
  );
});

self.addEventListener('fetch', (event) => {
  const request = event.request;
  const url = new URL(request.url);
  if (request.method !== 'GET' || url.origin !== self.location.origin || url.pathname.includes('/v1/')) return;

  if (request.mode === 'navigate') {
    event.respondWith(
      fetch(request)
        .then((response) => {
          const copy = response.clone();
          caches.open(CACHE).then((cache) => cache.put(new URL('index.html', root), copy));
          return response;
        })
        .catch(() => caches.match(new URL('index.html', root))),
    );
    return;
  }

  event.respondWith(
    caches.match(request).then((cached) => {
      const network = fetch(request).then((response) => {
        if (response.ok) {
          caches.open(CACHE).then((cache) => cache.put(request, response.clone()));
        }
        return response;
      });
      return cached || network;
    }),
  );
});
