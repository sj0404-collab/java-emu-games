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

    public static void a(cr cr2, int n2) {
        int n3 = cr2.a();
        int n4 = cr2.b();
        int n5 = cr2.c();
        int n6 = cr2.d();
        cr2.b(0, 0, rpg.a.a, rpg.a.b);
        try {
            if ((n2 & 1) != 0) {
                cr2.a(b, 0, rpg.a.b, 36);
            }
            if ((n2 & 2) != 0) {
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
        cr2.b(n3, n4, n5, n6);
    }

    abstract boolean a(int var1, int var2);

    protected abstract void a(cr var1);

    public ah(ah ah2, byte by2, byte by3, byte by4) {
        this.a = ah2;
        this.b = null;
        this.a = true;
        this.d = true;
        this.e = false;
        this.e = by2;
        this.g = by3;
        this.f = by4;
        this.d = 0;
        this.f = rpg.a.a - 160 >> 1;
        this.g = rpg.a.b - 174 >> 1;
    }

    public ah(ah ah2, byte by2) {
        this(null, 10, 1, 1);
    }

    void a(byte by2, byte by3) {
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
        boolean bl2 = false;
        if (this.i >= 0) {
            --this.i;
            if (this.i < 0 && this.b == null) {
                this.d = true;
                boolean bl3 = this.g = !this.g;
            }
        }
        if (this.d) {
            this.d = false;
            this.a(cr2);
            bl2 = true;
        }
        if (this.b == null) {
            if (this.a) {
                if (!bl2) {
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

    public final void b(cr cr2, int n2, int n3, int n4, int n5) {
        cr2.a(d[this.h]);
        cr2.d(n2, n3, n4, n5);
    }

    final boolean b(int n2, int n3) {
        if (this.b != null && this.b.a(n2, n3)) {
            return true;
        }
        this.d = true;
        return false;
    }

    protected final boolean c(int n2, int n3) {
        if (n3 == 50 || n2 == 1) {
            this.b((byte)3);
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            this.b((byte)4);
            return true;
        }
        return false;
    }

    protected final boolean d(int n2, int n3) {
        if (n3 == 52 || n2 == 2) {
            this.b((byte)3);
            return true;
        }
        if (n3 == 54 || n2 == 5) {
            this.b((byte)4);
            return true;
        }
        return false;
    }

    protected boolean e(int n2, int n3) {
        if (n3 == 50 || n2 == 1) {
            this.a((byte)3);
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            this.a((byte)4);
            return true;
        }
        return false;
    }

    protected final void a(byte by2) {
        if (by2 == 4) {
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

    public static final boolean f(int n2, int n3) {
        return n2 == 8 || n3 == 53 || n2 == -6;
    }

    protected static boolean g(int n2, int n3) {
        return n3 == 0 || n2 == -7;
    }

    protected static boolean h(int n2, int n3) {
        return n2 == 2 || n3 == 52;
    }

    protected static boolean i(int n2, int n3) {
        return n2 == 5 || n3 == 54;
    }

    protected final void j() {
        this.e = true;
        this.h = 0;
    }

    protected final void b(byte by2) {
        if (by2 == 4) {
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

    protected static final void c(cr cr2, int n2, int n3, int n4, int n5) {
        n4 = n4 / 20 + 1;
        n5 = n5 / 20 + 1;
        for (int i2 = 0; i2 < n4; ++i2) {
            for (int i3 = 0; i3 < n5; ++i3) {
                cr2.a(rpg.c.v, n2 + i2 * 20, n3 + i3 * 20, 20);
            }
        }
    }

    protected static final void d(cr cr2, int n2, int n3, int n4, int n5) {
        cr2.a(n2 + 1, n3, n4 - 2, n5);
        cr2.d(n2, n3 + 1, n4 - 1, n5 - 3);
    }

    protected static final void a(cr cr2, int n2, int n3, int n4, int n5, int n6, int n7) {
        cr2.a(n7);
        cr2.d(n2, n3 - 1, n4 - 1, n5 - 1);
        cr2.d(n2 - 1, n3, n4 + 1, n5 - 3);
        cr2.a(n6);
        cr2.a(n2, n3, n4, n5 - 2);
    }

    protected final void a(cr cr2, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        if (bl3) {
            this.a(cr2, dj.a.a(dj.a), bl4, bl5);
            return;
        }
        this.a(cr2, null, bl4, bl5);
    }

    protected final void a(cr cr2, boolean bl2, boolean bl3, byte[] byArray, boolean bl4) {
        this.a(cr2, null, true, bl4);
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, this.g - 1, byArray, 0, 1);
    }

    protected final void a(cr cr2, byte[] byArray, boolean bl2, boolean bl3) {
        if (rpg.a.a > 120) {
            cr2.b(this.f - 2, this.g - 2, 164, 178);
            cr2.a(0);
            cr2.a(this.f - 2, this.g - 2, 164, 178);
        }
        cr2.b(this.f, this.g, 160, 174);
        if (bl2) {
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
        if (bl3) {
            ah.a(cr2, this.f + 1, this.g + 1, 1, true);
            ah.a(cr2, this.f + 160 - 2, this.g + 1, 3, false);
        }
    }

    private static void a(cr cr2, int n2, int n3, int n4, boolean bl2) {
        int n5;
        cr2.a(13682856);
        for (int i2 = 0; i2 < 2; ++i2) {
            n5 = n2 + (bl2 ? i2 : -i2);
            cr2.e(n5, n3 + 2 - i2, n5, n3 + 9 - 3 + i2);
        }
        n5 = bl2 ? n2 + 2 : n2 - 9 + 1;
        cr2.a(n5, n3, 7, 9);
        ah.b(cr2, n4, n5 + 1, n3 + 1, 4, 0);
    }

    protected final void a(cr cr2, byte by2, boolean bl2, int n2, boolean bl3) {
        int n3 = this.g + 16;
        int n4 = (rpg.a.a - 105 >> 1) - 12;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5;
            cw[] cwArray;
            cr cr3;
            cr2.a(i2 == by2 ? (bl2 ? 0xFF0000 : 15723216) : 3550755);
            int n6 = n3 + i2 * 13;
            cr2.a(n4, n6, 11, 11);
            cr2.e(n4 + 11, n6 + 1, n4 + 11, n6 + 11 - 2);
            if (bl3) {
                cr3 = cr2;
                cwArray = rpg.c.b;
                n5 = i2 + (by2 == i2 ? 3 : 0);
            } else {
                cr3 = cr2;
                cwArray = rpg.c.b;
                n5 = by2 == i2 ? 3 : 0;
            }
            cr3.a(cwArray[n5], n4 + 1, n6 + 1, 20);
        }
    }

    protected static void c(cr cr2, int n2, int n3, int n4) {
        cr2.a(15723216);
        cr2.d(n2, n3 - 1, 159, n4 + 1);
        cr2.a(3550755);
        cr2.a(n2, n3, 160, n4);
    }

    protected final void d(cr cr2, int n2, int n3, int n4) {
        int n5 = ah.a(n4);
        rpg.a.a(cr2);
        cr2.a(rpg.c.u, n2 - n5, n3, 24);
        ah.b(cr2, n4, n2, n3, 8, 0);
    }

    protected static int a(int n2) {
        int n3 = 1;
        do {
            n3 += 4;
        } while ((n2 /= 10) != 0);
        return n3;
    }

    protected static void a(cr cr2, int n2, int n3, int n4, int n5, boolean bl2) {
        cr2.a(n5);
        for (n5 = 0; n5 < 3; ++n5) {
            cr2.e(n2 + n5, n3 - n5, n2 + n5, n3 + n5);
            cr2.e(n2 + n4 - n5 - 1, n3 - n5, n2 + n4 - n5 - 1, n3 + n5);
        }
    }

    protected static void e(cr cr2, int n2, int n3, int n4) {
        for (int i2 = 0; i2 < 3; ++i2) {
            cr2.e(n2 - i2, n3 + i2, n2 + i2, n3 + i2);
            cr2.e(n2 - 2 + i2, n3 + n4 + i2, n2 + 2 - i2, n3 + n4 + i2);
        }
    }

    protected static void a(cr cr2, byte[] byArray, int n2, int n3, int n4) {
        cw cw2 = rpg.c.s;
        int n5 = cw2.a() / 10;
        int n6 = cw2.b();
        for (int i2 = 0; i2 < 9; ++i2) {
            cr2.b(n2 + i2 * n4, n3, n5, n6);
            cr2.a(cw2, n2 + i2 * n4 - byArray[9 - i2 - 1] * n5, n3, 20);
        }
        rpg.a.a(cr2);
    }

    protected static void e(cr cr2, int n2, int n3, int n4, int n5) {
        byte[] byArray = new byte[9];
        cw cw2 = rpg.c.s;
        int n6 = cw2.a() / 10;
        int n7 = cw2.b();
        int n8 = 0;
        do {
            byte by2 = (byte)(n2 % 10);
            int n9 = n8;
            n8 = (byte)(n8 + 1);
            byArray[n9] = by2;
        } while ((n2 /= 10) != 0);
        for (n2 = 0; n2 < 9; ++n2) {
            cr2.b(n3 + n2 * 7, n4, n6, n7);
            cr2.a(cw2, n3 + n2 * 7 - byArray[9 - n2 - 1] * n6, n4, 20);
        }
        rpg.a.a(cr2);
    }

    protected static void f(cr cr2, int n2, int n3, int n4) {
        ah.b(cr2, n2, n3 + 8, n4, 8, 0);
        cr2.b(n3 + 10, n4, 7, 7);
        cr2.a(rpg.c.x, n3 + 10, n4, 20);
        cr2.b(0, 0, rpg.a.a, rpg.a.b);
    }

    public static final void b(cr cr2, int n2, int n3, int n4, int n5, int n6) {
        cw cw2;
        byte[] byArray = new byte[9];
        boolean bl2 = false;
        if (n6 == 0) {
            cw2 = rpg.c.s;
        } else {
            cw2 = rpg.c.h[n6 - 1];
            bl2 = true;
        }
        int n7 = cw2.a() / 10;
        int n8 = n7 - 1;
        int n9 = cw2.b();
        int n10 = 0;
        do {
            byte by2 = (byte)(n2 % 10);
            int n11 = n10;
            n10 = (byte)(n10 + 1);
            byArray[n11] = by2;
        } while ((n2 /= 10) != 0);
        n2 = n3;
        if (n5 == 1) {
            n2 = n3 - n10 * n8 / 2;
        } else if (n5 == 8) {
            n2 = n3 - n10 * n8;
        }
        for (n3 = 0; n3 < n10; ++n3) {
            if (bl2) {
                bh.e(cr2);
                cr2.c(n2 + n3 * n8, n4, n7, n9);
            } else {
                cr2.b(n2 + n3 * n8, n4, n7, n9);
            }
            cr2.a(cw2, n2 + n3 * n8 - byArray[n10 - n3 - 1] * n7, n4, 20);
        }
        if (n6 == 0) {
            rpg.a.a(cr2);
            return;
        }
        bh.e(cr2);
    }

    protected static void c(cr cr2, int n2, int n3, int n4, int n5, int n6) {
        cr2.a(n6);
        cr2.a(n2, n3 + 1, n4, n5 - 2);
        cr2.e(n2 + 1, n3, n2 + n4 - 2, n3);
        cr2.e(n2 + 1, n3 + n5 - 1, n2 + n4 - 2, n3 + n5 - 1);
    }

    protected static void d(cr cr2, int n2, int n3, int n4, int n5, int n6) {
        cr2.a(0xFF0000);
        cr2.e(n2, n3 + 1, n2, n3 + 13 - 2);
        cr2.e(n2 + 40 - 1, n3 + 1, n2 + 40 - 1, n3 + 13 - 2);
        cr2.e(n2 + 1, n3, n2 + 40 - 2, n3);
        cr2.e(n2 + 1, n3 + 13 - 1, n2 + 40 - 2, n3 + 13 - 1);
    }

    protected final void a(cr cr2, int n2, int n3, int n4, byte[] byArray, boolean bl2) {
        ah.c(cr2, n2, n3, 154, 14, bl2 ? 0x660000 : 3550755);
        cr2.a(13682856);
        dv.a(cr2, n2 + 77, n3 + 1, byArray, 0, 1);
    }

    protected final void f(cr cr2, int n2, int n3, int n4, int n5) {
        if (n5 < 2) {
            return;
        }
        n5 = 60 / n5;
        cr2.a(0);
        cr2.a(n2, n3, 4, 60);
        cr2.a(0x7F7F7F);
        cr2.d(n2, n3, 4, 60);
        cr2.a(n2, n3 + n4 * n5, 4, n5);
        ah.e(cr2, n2 + 2, n3 - 4, 66);
    }
}

