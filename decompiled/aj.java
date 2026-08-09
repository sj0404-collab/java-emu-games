/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;

abstract class aj
extends ae {
    aj(ah ah2, byte by2, byte by3, byte by4) {
        super(ah2, by2, by3, by4);
    }

    protected final int a(cr cr2, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        return this.a(cr2, false, true, true, false, false);
    }

    /*
     * WARNING - void declaration
     */
    protected final int a(cr cr2, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        void var2_4;
        int n2;
        int n3;
        int n4;
        int n5;
        void var3_7;
        void var6_17;
        void var5_14;
        void var4_10;
        void var3_5;
        this.a(cr2, bl2, (boolean)var3_5, (boolean)var4_10, (boolean)var5_14);
        int n6 = this.g + 13;
        int n7 = n6 + 1;
        if (var6_17 != false) {
            var3_7 += 13;
        }
        aj.a(cr2, r.b, rpg.a.c, (int)var3_7, ah.c[r.b], 15723216, true, true);
        cr2.a(0);
        int n8 = this.f + 12;
        int n9 = 4;
        if (var6_17 != false) {
            n5 = rpg.a.c;
            n4 = 1;
        }
        int n10 = n6;
        if (var6_17 != false) {
            n3 = n6 + 28;
        }
        dv.a(cr2, n5, n6, rpg.c.d.a(0), 1, n4);
        if (var6_17 == false) {
            n2 = this.f + 160 - 30 + 7;
        }
        dv.a(cr2, n2, n3, rpg.c.d.a(1 + r.b), 1, 1);
        cr2.a(15723216);
        cr2.e(this.f, (int)(var2_4 += 13), this.f + 160 - 1, (int)var2_4);
        if (var6_17 != false) {
            cr2.e(this.f, (int)(var2_4 + 13), this.f + 160 - 1, (int)(var2_4 + 13));
        }
        return (int)(var2_4 + true);
    }

    protected static void a(cr cr2, byte by2, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
        int n6 = n2 - 15 - 1;
        if (bl2) {
            cr2.a(n5);
            cr2.d(n6 + 1, n3 - 1, 27, 13);
            cr2.d(n6, n3, 29, 11);
        }
        cr2.a(n4);
        ah.d(cr2, n6 + 1, n3, 28, 12);
        cr2.a(bl3 ? rpg.c.d[by2] : rpg.c.h, n2, n3 + 1, 17);
    }

    public aj(ah ah2, byte by2) {
        super(ah2, by2);
    }

    protected int a(cr cr2, int n2, int n3, boolean bl2) {
        int n4;
        int n5 = this.e;
        int n6 = this.g + 3;
        int n7 = rpg.a.c - (n3 >> 1);
        int n8 = rpg.a.c + (bl2 ? 5 : 0);
        int n9 = n6 = n6 + 9 + 4;
        for (n4 = 0; n4 < n5; ++n4) {
            byte by2 = this.d;
            cr2.a(n4 != by2 ? 7027456 : 0x810000);
            ah.d(cr2, n7, n9, n3, 14);
            cr2.a(n4 != by2 ? 3550755 : 0x660000);
            cr2.a(n7 + 1, n9 + 1, n3 - 2, 12);
            n9 += 15;
        }
        for (n4 = n5; n4 < 10; ++n4) {
            int n10 = 14;
            int n11 = n3;
            int n12 = n9;
            int n13 = n7;
            cr cr3 = cr2;
            cr3.a(15723216);
            cr3.e(n13 + 1, n12, n13 + n11 - 2, n12);
            cr3.e(n13 + 1, n12 + 14 - 1, n13 + n11 - 2, n12 + 14 - 1);
            cr3.e(n13, n12 + 1, n13, n12 + 14 - 2);
            cr3.e(n13 + n11 - 1, n12 + 1, n13 + n11 - 1, n12 + 14 - 2);
            n9 += 15;
        }
        if (n2 >= 0) {
            n9 = n6 + 1;
            for (n4 = 0; n4 < n5; ++n4) {
                if (n4 != this.d) {
                    if (bl2 && (n4 == 0 && j.a || n4 == 3 && !dj.h || n4 == 6 && !dj.a)) {
                        cr2.a(0x666666);
                    } else {
                        cr2.a(12630160);
                    }
                    dv.a(cr2, n8, n9, dj.a.a(n2 + n4), 0, 1);
                    if (bl2) {
                        dv.a(cr2, n7 + 5, n9, ("" + (n4 == 9 ? 0 : n4 + 1) + ".").getBytes(), 0, 4);
                    }
                }
                if (bl2) {
                    if (n4 == 1 && r.a.c > 0) {
                        if (this.i < 0) {
                            this.i = 10;
                        }
                        if (this.g) {
                            cr2.a(rpg.c.c[0], n8 + 50, n9 + 2, 20);
                        }
                    } else if ((n4 == 5 || n4 == 6 && dj.a) && r.a.d > 0) {
                        if (this.i < 0) {
                            this.i = 10;
                        }
                        if (this.g) {
                            cr2.a(rpg.c.c[1], n8 + 50, n9 + 2, 20);
                        }
                    }
                }
                n9 += 15;
            }
            cr2.a(0xFFFFFF);
            n9 = n6 + 1 + 15 * this.d;
            dv.a(cr2, n8, n9, dj.a.a(n2 + this.d), 0, 1);
            if (bl2) {
                dv.a(cr2, n7 + 5, n9, ("" + (this.d == 9 ? 0 : this.d + 1) + ".").getBytes(), 0, 4);
            }
        }
        return n6;
    }
}

