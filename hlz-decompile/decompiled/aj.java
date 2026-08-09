/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;

abstract class aj
extends ae {
    aj(ah ah2, byte by, byte by2, byte by3) {
        super(ah2, by, by2, by3);
    }

    protected final int a(cr cr2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return this.a(cr2, false, true, true, false, false);
    }

    /*
     * WARNING - void declaration
     */
    protected final int a(cr cr2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        void var2_4;
        int n;
        int n2;
        int n3;
        int n4;
        void var3_7;
        void var6_17;
        void var5_14;
        void var4_10;
        void var3_5;
        this.a(cr2, bl, (boolean)var3_5, (boolean)var4_10, (boolean)var5_14);
        int n5 = this.g + 13;
        int n6 = n5 + 1;
        if (var6_17 != false) {
            var3_7 += 13;
        }
        aj.a(cr2, r.b, rpg.a.c, (int)var3_7, ah.c[r.b], 15723216, true, true);
        cr2.a(0);
        int n7 = this.f + 12;
        int n8 = 4;
        if (var6_17 != false) {
            n4 = rpg.a.c;
            n3 = 1;
        }
        int n9 = n5;
        if (var6_17 != false) {
            n2 = n5 + 28;
        }
        dv.a(cr2, n4, n5, rpg.c.d.a(0), 1, n3);
        if (var6_17 == false) {
            n = this.f + 160 - 30 + 7;
        }
        dv.a(cr2, n, n2, rpg.c.d.a(1 + r.b), 1, 1);
        cr2.a(15723216);
        cr2.e(this.f, (int)(var2_4 += 13), this.f + 160 - 1, (int)var2_4);
        if (var6_17 != false) {
            cr2.e(this.f, (int)(var2_4 + 13), this.f + 160 - 1, (int)(var2_4 + 13));
        }
        return (int)(var2_4 + true);
    }

    protected static void a(cr cr2, byte by, int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5 = n - 15 - 1;
        if (bl) {
            cr2.a(n4);
            cr2.d(n5 + 1, n2 - 1, 27, 13);
            cr2.d(n5, n2, 29, 11);
        }
        cr2.a(n3);
        ah.d(cr2, n5 + 1, n2, 28, 12);
        cr2.a(bl2 ? rpg.c.d[by] : rpg.c.h, n, n2 + 1, 17);
    }

    public aj(ah ah2, byte by) {
        super(ah2, by);
    }

    protected int a(cr cr2, int n, int n2, boolean bl) {
        int n3;
        int n4 = this.e;
        int n5 = this.g + 3;
        int n6 = rpg.a.c - (n2 >> 1);
        int n7 = rpg.a.c + (bl ? 5 : 0);
        int n8 = n5 = n5 + 9 + 4;
        for (n3 = 0; n3 < n4; ++n3) {
            byte by = this.d;
            cr2.a(n3 != by ? 7027456 : 0x810000);
            ah.d(cr2, n6, n8, n2, 14);
            cr2.a(n3 != by ? 3550755 : 0x660000);
            cr2.a(n6 + 1, n8 + 1, n2 - 2, 12);
            n8 += 15;
        }
        for (n3 = n4; n3 < 10; ++n3) {
            int n9 = 14;
            int n10 = n2;
            int n11 = n8;
            int n12 = n6;
            cr cr3 = cr2;
            cr3.a(15723216);
            cr3.e(n12 + 1, n11, n12 + n10 - 2, n11);
            cr3.e(n12 + 1, n11 + 14 - 1, n12 + n10 - 2, n11 + 14 - 1);
            cr3.e(n12, n11 + 1, n12, n11 + 14 - 2);
            cr3.e(n12 + n10 - 1, n11 + 1, n12 + n10 - 1, n11 + 14 - 2);
            n8 += 15;
        }
        if (n >= 0) {
            n8 = n5 + 1;
            for (n3 = 0; n3 < n4; ++n3) {
                if (n3 != this.d) {
                    if (bl && (n3 == 0 && j.a || n3 == 3 && !dj.h || n3 == 6 && !dj.a)) {
                        cr2.a(0x666666);
                    } else {
                        cr2.a(12630160);
                    }
                    dv.a(cr2, n7, n8, dj.a.a(n + n3), 0, 1);
                    if (bl) {
                        dv.a(cr2, n6 + 5, n8, ("" + (n3 == 9 ? 0 : n3 + 1) + ".").getBytes(), 0, 4);
                    }
                }
                if (bl) {
                    if (n3 == 1 && r.a.c > 0) {
                        if (this.i < 0) {
                            this.i = 10;
                        }
                        if (this.g) {
                            cr2.a(rpg.c.c[0], n7 + 50, n8 + 2, 20);
                        }
                    } else if ((n3 == 5 || n3 == 6 && dj.a) && r.a.d > 0) {
                        if (this.i < 0) {
                            this.i = 10;
                        }
                        if (this.g) {
                            cr2.a(rpg.c.c[1], n7 + 50, n8 + 2, 20);
                        }
                    }
                }
                n8 += 15;
            }
            cr2.a(0xFFFFFF);
            n8 = n5 + 1 + 15 * this.d;
            dv.a(cr2, n7, n8, dj.a.a(n + this.d), 0, 1);
            if (bl) {
                dv.a(cr2, n6 + 5, n8, ("" + (this.d == 9 ? 0 : this.d + 1) + ".").getBytes(), 0, 4);
            }
        }
        return n5;
    }
}
