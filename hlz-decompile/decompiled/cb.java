/*
 * Decompiled with CFR 0.152.
 */
import rpg.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class cb {
    private static ba a = null;
    private static ba b = null;
    private static cd a = null;
    private static ak a = null;
    private static byte[] a = null;
    private static int a = 0;
    private static byte[][] a = null;
    private static boolean a = false;

    public final int a(byte[] object, int n) {
        cb.c();
        a = null;
        a = new cd(this);
        a = new ba(this);
        b = new ba(this);
        n = a.a((byte[])object, n, 1);
        n = b.a((byte[])object, n, 2);
        int n2 = object[n] < 0 ? 256 + object[n] : object[n];
        ++n;
        a = null;
        if (n2 > 0) {
            int n3;
            a = new byte[n2][];
            for (n3 = 0; n3 < n2; ++n3) {
                int n4 = object[n] < 0 ? 256 + object[n] : object[n];
                ++n;
                cb.a[n3] = new byte[n4];
            }
            for (n3 = 0; n3 < n2; ++n3) {
                System.arraycopy(object, n, a[n3], 0, a[n3].length);
                n += a[n3].length + 1;
            }
        }
        object = a;
        a.a = 0;
        return n;
    }

    public static void c() {
        a = null;
        b = null;
        a = null;
        a = null;
        a = null;
        a = 0;
        a = null;
        a = false;
    }

    protected static boolean f() {
        return a != null && b != null && a != null;
    }

    protected static void d() {
        a = true;
    }

    public static final byte[] a(int n) {
        if (a == null) {
            return rpg.b.t;
        }
        if (n >= a.length) {
            return rpg.b.t;
        }
        return a[n];
    }

    public static final void e() {
        a = null;
    }

    protected static final void a(int n) {
        a.a(a);
        a = ak.a(cb.b.a);
        int n2 = a;
        for (int i = 0; i < n; ++i) {
            n2 += a[i] < 0 ? 256 + a[i] : a[i];
        }
        a.a(n2, n2 + (a[n] < 0 ? 256 + a[n] : a[n]));
        a = null;
    }

    private final boolean a(ak ak2) {
        boolean bl = false;
        while (!ak2.a()) {
            byte by = ak2.a();
            if (by >= 0 && by < cb.b.a) {
                ak ak3 = ak.a(cb.b.a);
                ak3.a(cb.b.a[by], (int)cb.b.a[by + 1]);
                a.a(ak3);
                bl = true;
                continue;
            }
            if (by == -1) {
                int n;
                int n2 = ak2.a();
                byte[] byArray = new byte[n2];
                for (n = 0; n < n2; ++n) {
                    byArray[n] = ak2.a();
                }
                ak ak4 = ak.a(ak2);
                int n3 = ak2.a();
                int n4 = ak2.a();
                for (n = 0; n < n2; ++n) {
                    n4 += byArray[n];
                }
                for (n = 0; n < n2; ++n) {
                    ak4.a(n3, n3 + byArray[n]);
                    if (this.a(ak4)) {
                        bl = true;
                        break;
                    }
                    n3 += byArray[n];
                }
                ak2.a(n4);
                continue;
            }
            if (this.a((byte)(-2 - by), ak2)) continue;
            return bl;
        }
        return bl;
    }

    public final boolean a(int n) {
        if (a == null || b == null) {
            return false;
        }
        if (a != null) {
            return false;
        }
        if (n >= cb.a.a.length - 1 || n < 0) {
            return false;
        }
        ak ak2 = cb.a.a;
        ak2.a(cb.a.a[n], (int)cb.a.a[n + 1]);
        this.a(ak2);
        return cb.a.a > 0;
    }

    public final boolean g() {
        if (a == null || b == null) {
            return false;
        }
        if (a != null) {
            return true;
        }
        do {
            boolean bl;
            block13: {
                int n;
                Object object;
                if (a == null) {
                    ak ak2;
                    object = a;
                    if (((cd)object).a > 0) {
                        ak ak3 = ((cd)object).a[0];
                        for (n = 1; n < ((cd)object).a; ++n) {
                            ((cd)object).a[n - 1] = ((cd)object).a[n];
                        }
                        ((cd)object).a[((cd)object).a - 1] = null;
                        --((cd)object).a;
                        ak2 = ak3;
                    } else {
                        ak2 = a = null;
                    }
                }
                if (a == null) continue;
                object = this;
                byte by = 0;
                ak ak4 = a;
                while (!ak4.a()) {
                    byte by2 = ak4.a();
                    n = 0;
                    if (by2 == -1) {
                        by = ak4.a();
                        n = ak4.a();
                    }
                    if (n == 0) {
                        if (((cb)object).b(by2, ak4)) continue;
                        bl = false;
                    } else {
                        byte[] byArray = new byte[n];
                        a = new byte[n];
                        int n2 = 0;
                        for (int i = 0; i < n; ++i) {
                            byArray[i] = ak4.a();
                            cb.a[i] = ak4.a();
                            n2 += a[i] < 0 ? 256 + a[i] : a[i];
                        }
                        a = ak4.a();
                        ((cb)object).a(by, byArray);
                        ak4.a(ak4.a() + n2);
                        bl = false;
                    }
                    break block13;
                }
                a = null;
                bl = true;
            }
            if (bl) continue;
            return true;
        } while (cb.a.a > 0);
        if (a) {
            a = false;
            return this.a(1);
        }
        return false;
    }

    protected abstract boolean a(byte var1, ak var2);

    protected abstract boolean b(byte var1, ak var2);

    protected abstract void a(byte var1, byte[] var2);
}
