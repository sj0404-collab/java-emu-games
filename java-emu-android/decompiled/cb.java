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

    public final int a(byte[] object, int n2) {
        cb.c();
        a = null;
        a = new cd(this);
        a = new ba(this);
        b = new ba(this);
        n2 = a.a((byte[])object, n2, 1);
        n2 = b.a((byte[])object, n2, 2);
        int n3 = object[n2] < 0 ? 256 + object[n2] : object[n2];
        ++n2;
        a = null;
        if (n3 > 0) {
            int n4;
            a = new byte[n3][];
            for (n4 = 0; n4 < n3; ++n4) {
                int n5 = object[n2] < 0 ? 256 + object[n2] : object[n2];
                ++n2;
                cb.a[n4] = new byte[n5];
            }
            for (n4 = 0; n4 < n3; ++n4) {
                System.arraycopy(object, n2, a[n4], 0, a[n4].length);
                n2 += a[n4].length + 1;
            }
        }
        object = a;
        a.a = 0;
        return n2;
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

    public static final byte[] a(int n2) {
        if (a == null) {
            return rpg.b.t;
        }
        if (n2 >= a.length) {
            return rpg.b.t;
        }
        return a[n2];
    }

    public static final void e() {
        a = null;
    }

    protected static final void a(int n2) {
        a.a(a);
        a = ak.a(cb.b.a);
        int n3 = a;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 += a[i2] < 0 ? 256 + a[i2] : a[i2];
        }
        a.a(n3, n3 + (a[n2] < 0 ? 256 + a[n2] : a[n2]));
        a = null;
    }

    private final boolean a(ak ak2) {
        boolean bl2 = false;
        while (!ak2.a()) {
            byte by2 = ak2.a();
            if (by2 >= 0 && by2 < cb.b.a) {
                ak ak3 = ak.a(cb.b.a);
                ak3.a(cb.b.a[by2], (int)cb.b.a[by2 + 1]);
                a.a(ak3);
                bl2 = true;
                continue;
            }
            if (by2 == -1) {
                int n2;
                int n3 = ak2.a();
                byte[] byArray = new byte[n3];
                for (n2 = 0; n2 < n3; ++n2) {
                    byArray[n2] = ak2.a();
                }
                ak ak4 = ak.a(ak2);
                int n4 = ak2.a();
                int n5 = ak2.a();
                for (n2 = 0; n2 < n3; ++n2) {
                    n5 += byArray[n2];
                }
                for (n2 = 0; n2 < n3; ++n2) {
                    ak4.a(n4, n4 + byArray[n2]);
                    if (this.a(ak4)) {
                        bl2 = true;
                        break;
                    }
                    n4 += byArray[n2];
                }
                ak2.a(n5);
                continue;
            }
            if (this.a((byte)(-2 - by2), ak2)) continue;
            return bl2;
        }
        return bl2;
    }

    public final boolean a(int n2) {
        if (a == null || b == null) {
            return false;
        }
        if (a != null) {
            return false;
        }
        if (n2 >= cb.a.a.length - 1 || n2 < 0) {
            return false;
        }
        ak ak2 = cb.a.a;
        ak2.a(cb.a.a[n2], (int)cb.a.a[n2 + 1]);
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
            boolean bl2;
            block13: {
                int n2;
                Object object;
                if (a == null) {
                    ak ak2;
                    object = a;
                    if (((cd)object).a > 0) {
                        ak ak3 = ((cd)object).a[0];
                        for (n2 = 1; n2 < ((cd)object).a; ++n2) {
                            ((cd)object).a[n2 - 1] = ((cd)object).a[n2];
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
                byte by2 = 0;
                ak ak4 = a;
                while (!ak4.a()) {
                    byte by3 = ak4.a();
                    n2 = 0;
                    if (by3 == -1) {
                        by2 = ak4.a();
                        n2 = ak4.a();
                    }
                    if (n2 == 0) {
                        if (((cb)object).b(by3, ak4)) continue;
                        bl2 = false;
                    } else {
                        byte[] byArray = new byte[n2];
                        a = new byte[n2];
                        int n3 = 0;
                        for (int i2 = 0; i2 < n2; ++i2) {
                            byArray[i2] = ak4.a();
                            cb.a[i2] = ak4.a();
                            n3 += a[i2] < 0 ? 256 + a[i2] : a[i2];
                        }
                        a = ak4.a();
                        ((cb)object).a(by2, byArray);
                        ak4.a(ak4.a() + n3);
                        bl2 = false;
                    }
                    break block13;
                }
                a = null;
                bl2 = true;
            }
            if (bl2) continue;
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

