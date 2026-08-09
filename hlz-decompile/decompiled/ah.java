/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class ah
implements b {
    protected static final int[] c = new int[]{0x660000, 0x3F3F3F, 0x996600, 39168, 39321, 0x990099};
    protected static final int[] d = new int[]{0x990000, 0xFF0000};
    protected ah a;
    protected ah b;
    protected byte d;
    protected byte e;
    protected byte f;
    protected byte g;
    protected byte h;
    private boolean a;
    boolean d;
    boolean e;
    protected int f;
    protected int g;
    private static cw b = cw.a("/sks/ok.png");
    public static final cw a = cw.a("/sks/back.png");
    public static boolean f = false;
    public static int h = 0;
    protected int i = -1;
    protected boolean g = false;

    public static void a(cr cr2, int n) {
        int n2 = cr2.a();
        int n3 = cr2.b();
        int n4 = cr2.c();
        int n5 = cr2.d();
        cr2.b(0, 0, rpg.a.a, rpg.a.b);
        try {
            if ((n & 1) != 0) {
                cr2.a(b, 0, rpg.a.b, 36);
            }
            if ((n & 2) != 0) {
                cr2.a(a, rpg.a.a, rpg.a.b, 40);
            }
            if (f) {
                cr2.a(rpg.c.k, rpg.a.a < 240 ? -32 : 0, rpg.a.b, 36);
            }
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
        cr2.b(n2, n3, n4, n5);
    }

    abstract boolean a(int var1, int var2);

    protected abstract void a(cr var1);

    public ah(ah ah2, byte by, byte by2, byte by3) {
        this.a = ah2;
        this.b = null;
        this.a = true;
        this.d = true;
        this.e = false;
        this.e = by;
        this.g = by2;
        this.f = by3;
        this.d = 0;
        this.f = rpg.a.a - 160 >> 1;
        this.g = rpg.a.b - 174 >> 1;
    }

    public ah(ah ah2, byte by) {
        this(null, 10, 1, 1);
    }

    void a(byte by, byte by2) {
        this.g();
    }

    final void g() {
        this.b = null;
        if (bh.a() != null) {
            bh.a();
            bh.e();
        }
        this.a();
    }

    void a() {
        this.d = true;
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void h() {
        while (true) {
            ah2.d = true;
            if (ah2.b == null) break;
            ah ah2 = ah2.b;
        }
    }

    public final void c(cr cr2) {
        if (rpg.a.a) {
            this.h();
            rpg.a.a = false;
        }
        this.d(cr2);
    }

    final void d(cr cr2) {
        boolean bl = false;
        if (this.i >= 0) {
            --this.i;
            if (this.i < 0 && this.b == null) {
                this.d = true;
                boolean bl2 = this.g = !this.g;
            }
        }
        if (this.d) {
            this.d = false;
            this.a(cr2);
            bl = true;
        }
        if (this.b == null) {
            if (this.a) {
                if (!bl) {
                    this.a(cr2);
                }
                this.a = false;
            }
            if (this.e) {
                this.b(cr2);
            }
        } else {
            this.b.d(cr2);
        }
        if (this.e) {
            this.h = (byte)(this.h + 1);
            this.i();
        }
    }

    protected void i() {
        if (this.h >= d.length) {
            this.h = 0;
        }
    }

    protected void b(cr cr2) {
    }

    public final void b(cr cr2, int n, int n2, int n3, int n4) {
        cr2.a(d[this.h]);
        cr2.d(n, n2, n3, n4);
    }

    final boolean b(int n, int n2) {
        if (this.b != null && this.b.a(n, n2)) {
            return true;
        }
        this.d = true;
        return false;
    }

    protected final boolean c(int n, int n2) {
        if (n2 == 50 || n == 1) {
            this.b((byte)3);
            return true;
        }
        if (n2 == 56 || n == 6) {
            this.b((byte)4);
            return true;
        }
        return false;
    }

    protected final boolean d(int n, int n2) {
        if (n2 == 52 || n == 2) {
            this.b((byte)3);
            return true;
        }
        if (n2 == 54 || n == 5) {
            this.b((byte)4);
            return true;
        }
        return false;
    }

    protected boolean e(int n, int n2) {
        if (n2 == 50 || n == 1) {
            this.a((byte)3);
            return true;
        }
        if (n2 == 56 || n == 6) {
            this.a((byte)4);
            return true;
        }
        return false;
    }

    protected final void a(byte by) {
        if (by == 4) {
            this.d = (byte)(this.d + this.f);
            if (this.d >= this.e) {
                this.d = (byte)(this.d - this.f * this.g);
                if (this.d < 0) {
                    this.d = 0;
                    return;
                }
            }
        } else {
            this.d = (byte)(this.d - this.f);
            if (this.d < 0) {
                this.d = (byte)(this.f * this.g + this.d);
                if (this.d >= this.e) {
                    this.d = (byte)(this.e - 1);
                }
            }
        }
    }

    public static final boolean f(int n, int n2) {
        return n == 8 || n2 == 53 || n == -6;
    }

    protected static boolean g(int n, int n2) {
        return n2 == 0 || n == -7;
    }

    protected static boolean h(int n, int n2) {
        return n == 2 || n2 == 52;
    }

    protected static boolean i(int n, int n2) {
        return n == 5 || n2 == 54;
    }

    protected final void j() {
        this.e = true;
        this.h = 0;
    }

    protected final void b(byte by) {
        if (by == 4) {
            this.d = (byte)(this.d + 1);
            if (this.d >= this.e) {
                this.d = 0;
                return;
            }
        } else {
            this.d = (byte)(this.d - 1);
            if (this.d < 0) {
                this.d = (byte)(this.e - 1);
            }
        }
    }

    protected static final void c(cr cr2, int n, int n2, int n3, int n4) {
        n3 = n3 / 20 + 1;
        n4 = n4 / 20 + 1;
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < n4; ++j) {
                cr2.a(rpg.c.v, n + i * 20, n2 + j * 20, 20);
            }
        }
    }

    protected static final void d(cr cr2, int n, int n2, int n3, int n4) {
        cr2.a(n + 1, n2, n3 - 2, n4);
        cr2.d(n, n2 + 1, n3 - 1, n4 - 3);
    }

    protected static final void a(cr cr2, int n, int n2, int n3, int n4, int n5, int n6) {
        cr2.a(n6);
        cr2.d(n, n2 - 1, n3 - 1, n4 - 1);
        cr2.d(n - 1, n2, n3 + 1, n4 - 3);
        cr2.a(n5);
        cr2.a(n, n2, n3, n4 - 2);
    }

    protected final void a(cr cr2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl2) {
            this.a(cr2, dj.a.a(dj.a), bl3, bl4);
            return;
        }
        this.a(cr2, null, bl3, bl4);
    }

    protected final void a(cr cr2, boolean bl, boolean bl2, byte[] byArray, boolean bl3) {
        this.a(cr2, null, true, bl3);
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, this.g - 1, byArray, 0, 1);
    }

    protected final void a(cr cr2, byte[] byArray, boolean bl, boolean bl2) {
        if (rpg.a.a > 120) {
            cr2.b(this.f - 2, this.g - 2, 164, 178);
            cr2.a(0);
            cr2.a(this.f - 2, this.g - 2, 164, 178);
        }
        cr2.b(this.f, this.g, 160, 174);
        if (bl) {
            ah.c(cr2, this.f, this.g + 13, 174, 161);
        }
        cr2.a(3550755);
        cr2.a(this.f, this.g, 160, 13);
        cr2.a(15723216);
        cr2.e(this.f, this.g + 13, this.f + 160, this.g + 13);
        if (byArray != null) {
            cr2.a(14597755);
            dv.a(cr2, rpg.a.c, this.g, byArray, 0, 1);
        }
        if (bl2) {
            ah.a(cr2, this.f + 1, this.g + 1, 1, true);
            ah.a(cr2, this.f + 160 - 2, this.g + 1, 3, false);
        }
    }

    private static void a(cr cr2, int n, int n2, int n3, boolean bl) {
        int n4;
        cr2.a(13682856);
        for (int i = 0; i < 2; ++i) {
            n4 = n + (bl ? i : -i);
            cr2.e(n4, n2 + 2 - i, n4, n2 + 9 - 3 + i);
        }
        n4 = bl ? n + 2 : n - 9 + 1;
        cr2.a(n4, n2, 7, 9);
        ah.b(cr2, n3, n4 + 1, n2 + 1, 4, 0);
    }

    protected final void a(cr cr2, byte by, boolean bl, int n, boolean bl2) {
        int n2 = this.g + 16;
        int n3 = (rpg.a.a - 105 >> 1) - 12;
        for (int i = 0; i < n; ++i) {
            int n4;
            cw[] cwArray;
            cr cr3;
            cr2.a(i == by ? (bl ? 0xFF0000 : 15723216) : 3550755);
            int n5 = n2 + i * 13;
            cr2.a(n3, n5, 11, 11);
            cr2.e(n3 + 11, n5 + 1, n3 + 11, n5 + 11 - 2);
            if (bl2) {
                cr3 = cr2;
                cwArray = rpg.c.b;
                n4 = i + (by == i ? 3 : 0);
            } else {
                cr3 = cr2;
                cwArray = rpg.c.b;
                n4 = by == i ? 3 : 0;
            }
            cr3.a(cwArray[n4], n3 + 1, n5 + 1, 20);
        }
    }

    protected static void c(cr cr2, int n, int n2, int n3) {
        cr2.a(15723216);
        cr2.d(n, n2 - 1, 159, n3 + 1);
        cr2.a(3550755);
        cr2.a(n, n2, 160, n3);
    }

    protected final void d(cr cr2, int n, int n2, int n3) {
        int n4 = ah.a(n3);
        rpg.a.a(cr2);
        cr2.a(rpg.c.u, n - n4, n2, 24);
        ah.b(cr2, n3, n, n2, 8, 0);
    }

    protected static int a(int n) {
        int n2 = 1;
        do {
            n2 += 4;
        } while ((n /= 10) != 0);
        return n2;
    }

    protected static void a(cr cr2, int n, int n2, int n3, int n4, boolean bl) {
        cr2.a(n4);
        for (n4 = 0; n4 < 3; ++n4) {
            cr2.e(n + n4, n2 - n4, n + n4, n2 + n4);
            cr2.e(n + n3 - n4 - 1, n2 - n4, n + n3 - n4 - 1, n2 + n4);
        }
    }

    protected static void e(cr cr2, int n, int n2, int n3) {
        for (int i = 0; i < 3; ++i) {
            cr2.e(n - i, n2 + i, n + i, n2 + i);
            cr2.e(n - 2 + i, n2 + n3 + i, n + 2 - i, n2 + n3 + i);
        }
    }

    protected static void a(cr cr2, byte[] byArray, int n, int n2, int n3) {
        cw cw2 = rpg.c.s;
        int n4 = cw2.a() / 10;
        int n5 = cw2.b();
        for (int i = 0; i < 9; ++i) {
            cr2.b(n + i * n3, n2, n4, n5);
            cr2.a(cw2, n + i * n3 - byArray[9 - i - 1] * n4, n2, 20);
        }
        rpg.a.a(cr2);
    }

    protected static void e(cr cr2, int n, int n2, int n3, int n4) {
        byte[] byArray = new byte[9];
        cw cw2 = rpg.c.s;
        int n5 = cw2.a() / 10;
        int n6 = cw2.b();
        int n7 = 0;
        do {
            byte by = (byte)(n % 10);
            int n8 = n7;
            n7 = (byte)(n7 + 1);
            byArray[n8] = by;
        } while ((n /= 10) != 0);
        for (n = 0; n < 9; ++n) {
            cr2.b(n2 + n * 7, n3, n5, n6);
            cr2.a(cw2, n2 + n * 7 - byArray[9 - n - 1] * n5, n3, 20);
        }
        rpg.a.a(cr2);
    }

    protected static void f(cr cr2, int n, int n2, int n3) {
        ah.b(cr2, n, n2 + 8, n3, 8, 0);
        cr2.b(n2 + 10, n3, 7, 7);
        cr2.a(rpg.c.x, n2 + 10, n3, 20);
        cr2.b(0, 0, rpg.a.a, rpg.a.b);
    }

    public static final void b(cr cr2, int n, int n2, int n3, int n4, int n5) {
        cw cw2;
        byte[] byArray = new byte[9];
        boolean bl = false;
        if (n5 == 0) {
            cw2 = rpg.c.s;
        } else {
            cw2 = rpg.c.h[n5 - 1];
            bl = true;
        }
        int n6 = cw2.a() / 10;
        int n7 = n6 - 1;
        int n8 = cw2.b();
        int n9 = 0;
        do {
            byte by = (byte)(n % 10);
            int n10 = n9;
            n9 = (byte)(n9 + 1);
            byArray[n10] = by;
        } while ((n /= 10) != 0);
        n = n2;
        if (n4 == 1) {
            n = n2 - n9 * n7 / 2;
        } else if (n4 == 8) {
            n = n2 - n9 * n7;
        }
        for (n2 = 0; n2 < n9; ++n2) {
            if (bl) {
                bh.e(cr2);
                cr2.c(n + n2 * n7, n3, n6, n8);
            } else {
                cr2.b(n + n2 * n7, n3, n6, n8);
            }
            cr2.a(cw2, n + n2 * n7 - byArray[n9 - n2 - 1] * n6, n3, 20);
        }
        if (n5 == 0) {
            rpg.a.a(cr2);
            return;
        }
        bh.e(cr2);
    }

    protected static void c(cr cr2, int n, int n2, int n3, int n4, int n5) {
        cr2.a(n5);
        cr2.a(n, n2 + 1, n3, n4 - 2);
        cr2.e(n + 1, n2, n + n3 - 2, n2);
        cr2.e(n + 1, n2 + n4 - 1, n + n3 - 2, n2 + n4 - 1);
    }

    protected static void d(cr cr2, int n, int n2, int n3, int n4, int n5) {
        cr2.a(0xFF0000);
        cr2.e(n, n2 + 1, n, n2 + 13 - 2);
        cr2.e(n + 40 - 1, n2 + 1, n + 40 - 1, n2 + 13 - 2);
        cr2.e(n + 1, n2, n + 40 - 2, n2);
        cr2.e(n + 1, n2 + 13 - 1, n + 40 - 2, n2 + 13 - 1);
    }

    protected final void a(cr cr2, int n, int n2, int n3, byte[] byArray, boolean bl) {
        ah.c(cr2, n, n2, 154, 14, bl ? 0x660000 : 3550755);
        cr2.a(13682856);
        dv.a(cr2, n + 77, n2 + 1, byArray, 0, 1);
    }

    protected final void f(cr cr2, int n, int n2, int n3, int n4) {
        if (n4 < 2) {
            return;
        }
        n4 = 60 / n4;
        cr2.a(0);
        cr2.a(n, n2, 4, 60);
        cr2.a(0x7F7F7F);
        cr2.d(n, n2, 4, 60);
        cr2.a(n, n2 + n3 * n4, 4, n4);
        ah.e(cr2, n + 2, n2 - 4, 66);
    }
}
