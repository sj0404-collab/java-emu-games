/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
abstract class p
extends aw {
    protected static final byte[] a = new byte[]{2, 0, -1, 6, 1, 7, 3};
    protected static byte[] b;
    protected static byte[][] a;
    protected static int[] a;
    protected static int[] b;
    protected int a;
    protected int b;
    protected boolean a = false;
    protected boolean b = false;
    protected static boolean c;

    public p(ah ah2, byte by2, byte by3, byte by4) {
        super(ah2, by2, (byte)3, by4);
        this.h = 0;
        this.a = 0;
        this.b = 1;
        this.b = false;
        this.a = false;
        ((ah)this).e = true;
    }

    /*
     * WARNING - void declaration
     */
    protected final void a(cr cr2, byte by2, dg dg2, boolean bl2, boolean bl3) {
        void var5_10;
        int n2;
        int byArray;
        int n3;
        int n4;
        int bs2;
        this.a(cr2, false, true, true, false);
        int n5 = this.g + 66;
        ah.c(cr2, this.f, n5, 16);
        this.a(cr2, this.f, n5 + 2, dg2, false, true);
        int n8 = this.f + 19;
        n5 = this.g + 24;
        for (bs2 = 0; bs2 < 6; bs2 = (byte)(bs2 + 1)) {
            n4 = bs2 / 3;
            this.a(cr2, (byte)bs2, n8 + n3 * 15, n5 + n4 * 15 + ((n3 = bs2 % 3) == 1 ? -7 : 0));
        }
        this.a(cr2, (byte)6, n8 + 15, n5 + 30 - 7);
        n4 = by2;
        n3 = this.g + 17;
        n5 = this.f + 19 + 56;
        cr cr3 = cr2;
        p p2 = this;
        cr3.a(0xAAA27A);
        ah.d(cr3, n5 - 7, n3 - 2, 73, 48);
        cr3.a(15723216);
        ah.d(cr3, n5 - 6, n3 - 1, 71, 46);
        cr3.a(0xAAA27A);
        cr3.d(n5 - 7 + 5, n3 - 2, 62, 47);
        for (bs2 = 0; bs2 < 3; ++bs2) {
            for (byArray = 0; byArray < 4; ++byArray) {
                ah.d(cr3, n5 + byArray * 15, n3 + bs2 * 15, 14, 14);
            }
        }
        cr3.a(3550755);
        for (bs2 = 0; bs2 < 4; ++bs2) {
            for (byArray = 0; byArray < 3; ++byArray) {
                cr3.a(n5 + 1 + bs2 * 15, n3 + 1 + byArray * 15, 12, 12);
            }
        }
        if (a[n4] != null) {
            byte[] byArray2 = a[n4];
            n4 = byArray2.length;
            p2.b = n4 / 12 + 1;
            block5: for (int i2 = 0; i2 < 3; ++i2) {
                for (int i3 = 0; i3 < 4; ++i3) {
                    bs2 = i3 + (i2 << 2);
                    if ((bs2 += p2.a * 12) >= n4) continue block5;
                    bs bs3 = (bs)r.a().a(byArray2[bs2]);
                    if (bs3 == null) continue;
                    n2 = n5 + i3 * 15;
                    int n6 = n3 + i2 * 15;
                    bs3.a(cr3, n2, n6);
                }
            }
            if (p2.b > 1) {
                p2.a(cr3, 0xAAA27A, n5 - 6, n3 + 21);
                p2.b(cr3, 0xAAA27A, n5 + 73 - 11, n3 + 21);
            }
        }
        n3 = var5_10;
        n5 = bl2 ? 1 : 0;
        cr3 = cr2;
        p2 = this;
        n4 = p2.f + 2;
        int n10 = 2 + (rpg.a.a >> 1);
        int n7 = p2.g + 100;
        cr3.b(p2.f, p2.g, 160, 174);
        cr3.a(3550755);
        cr3.a(n4 + 60, n7 - 1, 18, 68);
        cr3.a(n10 + 50, n7 - 1, 18, 68);
        cr3.a(rpg.c.l[2], n4, n7, 20);
        cr3.a(rpg.c.l[4], n4, n7 + 25, 20);
        cr3.a(rpg.c.l[5], n4, n7 + 50, 20);
        cr3.a(rpg.c.l[3], n10, n7, 20);
        cr3.a(rpg.c.l[6], n10, n7 + 25, 20);
        cr3.a(rpg.c.l[7], n10, n7 + 50, 20);
        for (n2 = 0; n2 < 3; n2 = (int)((byte)(n2 + 1))) {
            p2.a(cr3, n2, n4 + 60 + 18, n7 + n2 * 25 + 5, n5 != 0, n3 != 0);
            p2.a(cr3, n2 + 3, n10 + 50 + 18, n7 + n2 * 25 + 5, n5 != 0, n3 != 0);
        }
    }

    private void a(cr cr2, byte by2, int n2, int n3) {
        if (b == null || b[by2] < 0) {
            int n4 = n2;
            int n5 = n3;
            n3 = by2;
            n2 = n5;
            by2 = (byte)n4;
            cr2.b(by2, n2, 14, 14);
            cr2.a(rpg.c.n, by2 - n3 * 14, n2, 20);
            bh.e(cr2);
            return;
        }
        dg dg2 = p.a(by2);
        dg2.a(cr2, n2, n3);
        cr2.a(15723216);
        cr2.d(n2, n3, 13, 13);
    }

    private static void a(cr cr2, int n2, int n3, byte by2, int n4, boolean bl2) {
        cr2.a(n4);
        for (n4 = 0; n4 < 3; ++n4) {
            if (by2 == 4) {
                cr2.e(n2 + n4, n3 - n4, n2 + n4, n3 + n4);
                continue;
            }
            cr2.e(n2 + 3 - n4 - 1, n3 - n4, n2 + 3 - n4 - 1, n3 + n4);
        }
    }

    protected final void a(cr cr2, int n2, int n3, int n4) {
        p.a(cr2, n3, n4, (byte)4, n2, false);
    }

    protected final void b(cr cr2, int n2, int n3, int n4) {
        p.a(cr2, n3, n4, (byte)3, n2, false);
    }

    private void a(cr cr2, int n2, int n3, int n4, boolean bl2, boolean bl3) {
        int n5 = n2;
        if (n2 == 1 && bl3) {
            n5 = 6;
        }
        ah.b(cr2, a[n5], n3 - 26, n4, 8, 0);
        if (bl2) {
            n2 = 0;
            if (b[n5] > 0) {
                n2 = b[n5] - a[n5];
            }
            if (n2 == 0) {
                this.b(cr2, n3 - 24, n4 + 2);
                return;
            }
            if (n2 > 0) {
                p.g(cr2, n3 - 20, n4 + 3, 0x6666FF);
            } else {
                p.g(cr2, n3 - 20, n4 + 3, 0xFF0000);
            }
            ah.b(cr2, b[n5], n3 - 1, n4, 8, 0);
            return;
        }
        this.b(cr2, n3 - 24, n4 + 2);
    }

    private static void g(cr cr2, int n2, int n3, int n4) {
        int n5;
        cr2.a(3550755);
        for (n5 = 0; n5 < 4; ++n5) {
            cr2.e(n2 - n5, n3 - n5, n2 - n5, n3 + n5);
        }
        cr2.e(n2 - 4, n3 - 3, n2 - 4, n3 + 3);
        cr2.a(n4);
        for (n5 = 0; n5 < 3; ++n5) {
            cr2.e(n2 - 1 - n5, n3 - n5, n2 - 1 - n5, n3 + n5);
        }
    }

    private void b(cr cr2, int n2, int n3) {
        cr2.a(3550755);
        cr2.a(n2, n3, 5, 3);
        cr2.a(0xFFFFFF);
        cr2.e(n2 + 1, n3 + 1, n2 + 3, n3 + 1);
        ae.a(cr2, n2 + 12, n3 + 1);
    }

    protected static dg a(byte by2) {
        dg dg2 = null;
        if (b != null && b[by2] >= 0) {
            dg2 = r.a().a(b[by2]);
        }
        return dg2;
    }

    protected static int[] a() {
        x x2 = r.a;
        int[] nArray = new int[7];
        x2.k();
        nArray[0] = x2.e((byte)0);
        nArray[3] = x2.e((byte)1);
        nArray[1] = x2.b(false);
        nArray[4] = x2.f((byte)2);
        nArray[2] = x2.a;
        nArray[5] = x2.f((byte)0);
        nArray[6] = x2.b(true);
        return nArray;
    }

    protected final void b() {
        a = new int[7];
        a = p.a();
    }

    static {
        c = false;
    }
}

