#!/bin/bash
# Read the remote URL from the kotlin project's git config and set it for unity project
CONFIG_FILE=$(find /home/z/my-project -name 'config' -path '*/.git/*' | while read f; do
  if grep -q 'java-emu-games' "$f" 2>/dev/null; then
    echo "$f"
    break
  fi
done)

if [ -z "$CONFIG_FILE" ]; then
  echo "ERROR: Could not find kotlin project git config"
  exit 1
fi

# Extract URL line and set as remote (without echoing the token)
python3 -c "
import re, subprocess
with open('$CONFIG_FILE') as f:
    content = f.read()
match = re.search(r'url\s*=\s*(.+)', content)
if match:
    url = match.group(1).strip()
    subprocess.run(['git', 'remote', 'set-url', 'origin', url], cwd='/home/z/my-project/heroes-lore-unity')
    print('Remote URL set successfully (len=%d)' % len(url))
else:
    print('ERROR: No URL found in config')
    exit(1)
"

cd /home/z/my-project/heroes-lore-unity
git push origin unity 2>&1
