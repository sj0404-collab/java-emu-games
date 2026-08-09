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

    public p(ah ah2, byte by, byte by2, byte by3) {
        super(ah2, by, (byte)3, by3);
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
    protected final void a(cr cr2, byte by, dg dg2, boolean bl, boolean bl2) {
        void var5_10;
        int n;
        int byArray;
        int n2;
        int n3;
        int bs2;
        this.a(cr2, false, true, true, false);
        int n4 = this.g + 66;
        ah.c(cr2, this.f, n4, 16);
        this.a(cr2, this.f, n4 + 2, dg2, false, true);
        int n7 = this.f + 19;
        n4 = this.g + 24;
        for (bs2 = 0; bs2 < 6; bs2 = (byte)(bs2 + 1)) {
            n3 = bs2 / 3;
            this.a(cr2, (byte)bs2, n7 + n2 * 15, n4 + n3 * 15 + ((n2 = bs2 % 3) == 1 ? -7 : 0));
        }
        this.a(cr2, (byte)6, n7 + 15, n4 + 30 - 7);
        n3 = by;
        n2 = this.g + 17;
        n4 = this.f + 19 + 56;
        cr cr3 = cr2;
        p p2 = this;
        cr3.a(0xAAA27A);
        ah.d(cr3, n4 - 7, n2 - 2, 73, 48);
        cr3.a(15723216);
        ah.d(cr3, n4 - 6, n2 - 1, 71, 46);
        cr3.a(0xAAA27A);
        cr3.d(n4 - 7 + 5, n2 - 2, 62, 47);
        for (bs2 = 0; bs2 < 3; ++bs2) {
            for (byArray = 0; byArray < 4; ++byArray) {
                ah.d(cr3, n4 + byArray * 15, n2 + bs2 * 15, 14, 14);
            }
        }
        cr3.a(3550755);
        for (bs2 = 0; bs2 < 4; ++bs2) {
            for (byArray = 0; byArray < 3; ++byArray) {
                cr3.a(n4 + 1 + bs2 * 15, n2 + 1 + byArray * 15, 12, 12);
            }
        }
        if (a[n3] != null) {
            byte[] byArray2 = a[n3];
            n3 = byArray2.length;
            p2.b = n3 / 12 + 1;
            block5: for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 4; ++j) {
                    bs2 = j + (i << 2);
                    if ((bs2 += p2.a * 12) >= n3) continue block5;
                    bs bs3 = (bs)r.a().a(byArray2[bs2]);
                    if (bs3 == null) continue;
                    n = n4 + j * 15;
                    int n5 = n2 + i * 15;
                    bs3.a(cr3, n, n5);
                }
            }
            if (p2.b > 1) {
                p2.a(cr3, 0xAAA27A, n4 - 6, n2 + 21);
                p2.b(cr3, 0xAAA27A, n4 + 73 - 11, n2 + 21);
            }
        }
        n2 = var5_10;
        n4 = bl ? 1 : 0;
        cr3 = cr2;
        p2 = this;
        n3 = p2.f + 2;
        int n9 = 2 + (rpg.a.a >> 1);
        int n6 = p2.g + 100;
        cr3.b(p2.f, p2.g, 160, 174);
        cr3.a(3550755);
        cr3.a(n3 + 60, n6 - 1, 18, 68);
        cr3.a(n9 + 50, n6 - 1, 18, 68);
        cr3.a(rpg.c.l[2], n3, n6, 20);
        cr3.a(rpg.c.l[4], n3, n6 + 25, 20);
        cr3.a(rpg.c.l[5], n3, n6 + 50, 20);
        cr3.a(rpg.c.l[3], n9, n6, 20);
        cr3.a(rpg.c.l[6], n9, n6 + 25, 20);
        cr3.a(rpg.c.l[7], n9, n6 + 50, 20);
        for (n = 0; n < 3; n = (int)((byte)(n + 1))) {
            p2.a(cr3, n, n3 + 60 + 18, n6 + n * 25 + 5, n4 != 0, n2 != 0);
            p2.a(cr3, n + 3, n9 + 50 + 18, n6 + n * 25 + 5, n4 != 0, n2 != 0);
        }
    }

    private void a(cr cr2, byte by, int n, int n2) {
        if (b == null || b[by] < 0) {
            int n3 = n;
            int n4 = n2;
            n2 = by;
            n = n4;
            by = (byte)n3;
            cr2.b(by, n, 14, 14);
            cr2.a(rpg.c.n, by - n2 * 14, n, 20);
            bh.e(cr2);
            return;
        }
        dg dg2 = p.a(by);
        dg2.a(cr2, n, n2);
        cr2.a(15723216);
        cr2.d(n, n2, 13, 13);
    }

    private static void a(cr cr2, int n, int n2, byte by, int n3, boolean bl) {
        cr2.a(n3);
        for (n3 = 0; n3 < 3; ++n3) {
            if (by == 4) {
                cr2.e(n + n3, n2 - n3, n + n3, n2 + n3);
                continue;
            }
            cr2.e(n + 3 - n3 - 1, n2 - n3, n + 3 - n3 - 1, n2 + n3);
        }
    }

    protected final void a(cr cr2, int n, int n2, int n3) {
        p.a(cr2, n2, n3, (byte)4, n, false);
    }

    protected final void b(cr cr2, int n, int n2, int n3) {
        p.a(cr2, n2, n3, (byte)3, n, false);
    }

    private void a(cr cr2, int n, int n2, int n3, boolean bl, boolean bl2) {
        int n4 = n;
        if (n == 1 && bl2) {
            n4 = 6;
        }
        ah.b(cr2, a[n4], n2 - 26, n3, 8, 0);
        if (bl) {
            n = 0;
            if (b[n4] > 0) {
                n = b[n4] - a[n4];
            }
            if (n == 0) {
                this.b(cr2, n2 - 24, n3 + 2);
                return;
            }
            if (n > 0) {
                p.g(cr2, n2 - 20, n3 + 3, 0x6666FF);
            } else {
                p.g(cr2, n2 - 20, n3 + 3, 0xFF0000);
            }
            ah.b(cr2, b[n4], n2 - 1, n3, 8, 0);
            return;
        }
        this.b(cr2, n2 - 24, n3 + 2);
    }

    private static void g(cr cr2, int n, int n2, int n3) {
        int n4;
        cr2.a(3550755);
        for (n4 = 0; n4 < 4; ++n4) {
            cr2.e(n - n4, n2 - n4, n - n4, n2 + n4);
        }
        cr2.e(n - 4, n2 - 3, n - 4, n2 + 3);
        cr2.a(n3);
        for (n4 = 0; n4 < 3; ++n4) {
            cr2.e(n - 1 - n4, n2 - n4, n - 1 - n4, n2 + n4);
        }
    }

    private void b(cr cr2, int n, int n2) {
        cr2.a(3550755);
        cr2.a(n, n2, 5, 3);
        cr2.a(0xFFFFFF);
        cr2.e(n + 1, n2 + 1, n + 3, n2 + 1);
        ae.a(cr2, n + 12, n2 + 1);
    }

    protected static dg a(byte by) {
        dg dg2 = null;
        if (b != null && b[by] >= 0) {
            dg2 = r.a().a(b[by]);
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
