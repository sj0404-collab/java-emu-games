/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;
import rpg.c;
import rpg.f;

abstract class aw
extends ae {
    public static final int[] e = new int[]{0xFFFFFF, 0xFFFF00, 16722152, 65280};

    public aw(ah ah2, byte by2, byte by3, byte by4) {
        super(ah2, by2, by3, by4);
    }

    public aw(ah ah2, byte by2) {
        this(ah2, by2, 1, 1);
    }

    private void a(cr cr2, int n2, int n3, byte by2, byte by3) {
        cr2.b(this.f, this.g, 160, 174);
        if (by3 == -3) {
            cr2.a(15723216);
            for (by2 = 0; by2 < 2; by2 = (byte)(by2 + 1)) {
                cr2.e(n2 + 1, n3 + by2 * 13, n2 + 77 - 2, n3 + by2 * 13);
                cr2.e(n2 + by2 * 76, n3 + 1, n2 + by2 * 76, n3 + 14 - 2);
            }
            return;
        }
        cr2.a(6379080);
        ah.d(cr2, n2, n3, 77, 14);
        if (by3 == -2) {
            return;
        }
        if (by3 == -1) {
            ae.a(cr2, n2 + 25, n3 + 6);
        } else {
            cr2.a(0xFFFFFF);
            dv.a(cr2, n2 + 38, n3 + 1, aw.a(by3), 1, 1);
        }
        aw.a(cr2, n2 + 1, n3 + 3, by3, false);
    }

    protected static byte[] a(byte by2) {
        return rpg.c.g.a(by2 + 35);
    }

    private static void a(cr cr2, int n2, int n3, byte by2, boolean bl2) {
        cr2.b(n2, n3, 6, 6);
        if (by2 >= 0) {
            cr2.a(rpg.c.t, n2 - by2 * 6, n3, 20);
        } else if (bl2) {
            if (by2 == -1) {
                cr2.a(0);
                cr2.a(n2 + 1, n3 + 1, 4, 4);
            }
            cr2.a(0xAAA27A);
            cr2.d(n2, n3, 5, 5);
        } else {
            cr2.a(0);
            ah.d(cr2, n2, n3, 6, 6);
        }
        rpg.a.a(cr2);
    }

    private static void b(cr cr2, int n2, int n3, dg dg2, boolean bl2) {
        if (bl2) {
            cr2.a(e[((bs)dg2).b]);
        } else {
            cr2.a(0xFFFFFF);
        }
        if (dg2.c != null) {
            dv.a(cr2, n2, n3, dg2.c, 0);
        }
    }

    private final void a(cr cr2, byte by2, int n2, int n3, int n4) {
        byte by3 = by2;
        dv.a(cr2, n2, n3, rpg.c.g.a(by3), 0, n4);
    }

    protected void a(cr cr2, byte by2, int n2, int n3, boolean bl2) {
        cr2.a(r.a.b() < by2 ? 0xFF0000 : 0xFFFFFF);
        byte[] byArray = rpg.f.a(rpg.b.q, ("" + by2).getBytes());
        byArray = rpg.f.a(byArray, rpg.b.i);
        dv.a(cr2, n2, n3, byArray, 1);
    }

    private void a(cr cr2, int n2, int n3, bs bs2) {
        int n4 = bs2.a();
        cr2.a(7368792);
        ah.d(cr2, n2, n3, 45, 8);
        for (int i2 = 0; i2 < n4; ++i2) {
            aw.a(cr2, n2 + 2 + i2 * 7, n3 + 1, bs2.a[i2], true);
        }
        rpg.a.a(cr2);
    }

    protected final void a(cr cr2, int n2, int n3, dg dg2) {
        this.a(cr2, n2, n3, dg2, false);
    }

    protected final void a(cr cr2, int n2, int n3, dg dg2, boolean bl2) {
        this.a(cr2, n2, n3, dg2, bl2, false);
    }

    protected final void a(cr object, int n2, int n3, dg dg2, boolean bl2, boolean n4) {
        bs bs2;
        int n5;
        if (n4 != 0) {
            ah.c((cr)object, this.f, n3 - 2, 32);
        }
        if (dg2 == null) {
            ((cr)object).a(0x7F7F7F);
            int n6 = 24;
            dv.a((cr)object, n2 + 9, n3, rpg.c.g.a(n6), 0);
            return;
        }
        ((cr)object).b(this.f, this.g, 160, 174);
        byte by2 = dg2.g;
        int n7 = dg2 instanceof bs;
        aw.b((cr)object, n2 + 9, n3, dg2, n7 != 0);
        if (bl2) {
            ((cr)object).a(14597755);
            this.a((cr)object, by2, n2 + 160 - 9, n3, 8);
        } else if (n4 != 0) {
            ((cr)object).a(14597755);
            this.a((cr)object, by2, n2 + 160 - 9, n3, 8);
            bs bs3 = (bs)dg2;
            if (bs3.a() > 0) {
                n7 = n2 + 9;
                n5 = n3 + 16;
                this.a((cr)object, n7, n5, bs3);
            }
        } else if (n7 != 0 && (bs2 = (bs)dg2).a() > 0) {
            n7 = n2 + 160 - 46;
            n5 = n3 + 2;
            this.a((cr)object, n7, n5, bs2);
        }
        if (!bl2 && n4 == 0) {
            dg dg3 = dg2;
            int n8 = n3 + 16 + 6;
            n3 = n2;
            cr cr2 = object;
            object = this;
            n4 = dg3.g;
            by2 = dg3 instanceof bs;
            bs bs4 = null;
            cr2.a(0);
            if (by2 != 0) {
                bs4 = (bs)dg3;
            }
            n5 = n3 + 2;
            int n9 = n5 + 77 + 2;
            int n10 = n9 + 38;
            super.a(cr2, n3, n8, n8, 32);
            if (by2 == 0 || w.a(dg3)) {
                cr2.a(0xFFFFFF);
            } else {
                cr2.a(0xFF0000);
            }
            super.a(cr2, (byte)n4, n10, n8 + 1, 1);
            int n11 = n8 + 17;
            cr2.a(0);
            if (by2 != 0) {
                super.a(cr2, n3, n8, n11, by2 != 0 ? 33 : 34);
                ((aw)object).a(cr2, bs4.a, n9 + 8, n11 + 1, false);
                boolean bl3 = bs4.d > 0;
                super.a(cr2, n3, n8, n11 += 17, bl3 ? 52 : 51);
                object = bl3 ? new String("" + bs4.d) : (n4 == 11 ? (bs4.c > 0 ? new String("" + bs4.c) : new String("---")) : new String("" + bs4.b + "-" + bs4.c + "/" + bs4.e + "%"));
                cr2.a(0xFFFFFF);
                dv.a(cr2, n10, n11 + 1, ((String)object).getBytes(), 1, 1);
                return;
            }
            ah.d(cr2, n5, n11, 156, 36);
            cr2.a(0xFFFFFF);
            if (!(dg3 instanceof d) && dg3.d != null) {
                dv.a(cr2, n5 + 2, n11 + 2, 152, 0, dg3.d);
            }
        }
    }

    private final void a(cr cr2, int n2, int n3, int n4, int n5) {
        int n6 = n5;
        byte[] byArray = rpg.c.g.a(n6);
        n3 = n4;
        cr cr3 = cr2;
        n5 = n2 + 2;
        int n7 = n5 + 77 + 2;
        cr3.a(0);
        ah.d(cr3, n5, n3, 77, 14);
        ah.d(cr3, n7, n3, 77, 14);
        cr3.e(n2, n3 + 14 + 1, n2 + 160 - 1, n3 + 14 + 1);
        cr3.a(14597755);
        if (byArray != null) {
            dv.a(cr3, n5 + 38 + 1, n3 + 1, byArray, 0, 1);
        }
    }

    public final void b(cr cr2, int n2, int n3, dg dg2) {
        byte by2 = dg2.g;
        boolean bl2 = dg2 instanceof bs;
        bs bs2 = null;
        int n4 = n2 + 20;
        cr2.a(0);
        cr2.a(n2, n3, 160, 16);
        dg2.a(cr2, n2 + 1, n3 + 1, true, true);
        aw.b(cr2, n4, n3 + 3, dg2, bl2);
        if (bl2) {
            bs2 = (bs)dg2;
            n4 = 28 + bs2.b;
            dv.a(cr2, n2 + 160 - 3, n3 + 3, rpg.c.g.a(n4), 0, 8);
        }
        n4 = n2 + 2;
        int n5 = n4 + 77 + 2;
        int n6 = n5 + 38;
        int n7 = n3 + 16 + 1;
        this.a(cr2, n2, n3, n7, 32);
        cr2.a(0xFFFFFF);
        this.a(cr2, by2, n6, n7 + 1, 1);
        n7 += 17;
        cr2.a(0);
        if (bl2) {
            this.a(cr2, n2, n3, n7, bl2 ? 33 : 34);
            this.a(cr2, bs2.a, n5 + 8, n7 + 1, false);
            int n8 = bs2.d > 0 ? 1 : 0;
            this.a(cr2, n2, n3, n7 += 17, n8 != 0 ? 52 : 51);
            String string = n8 != 0 ? new String("" + bs2.d) : (by2 == 11 ? (bs2.c > 0 ? new String("" + bs2.c) : new String("---")) : new String("" + bs2.b + "-" + bs2.c + "/" + bs2.e + "%"));
            cr2.a(0xFFFFFF);
            dv.a(cr2, n6, n7 + 1, string.getBytes(), 1, 1);
            n7 += 17;
            for (n8 = 0; n8 < 6; ++n8) {
                int n9 = n8 >> 1;
                n3 = n8 % 2;
                this.a(cr2, n4 + n3 * 79, n7 + n9 * 15, (byte)77, bs2.a[n8]);
            }
            return;
        }
        ah.d(cr2, n4, n7, 155, 119);
        cr2.a(0xFFFFFF);
        if (dg2.d != null) {
            dv.a(cr2, n4 + 2, n7 + 2, 151, 0, dg2.d);
        }
    }

    protected final void a(dg dg2) {
        this.b = new cv((ah)this, dg2);
    }

    protected void b(cr cr2) {
        this.e(cr2);
    }

    protected final void e(cr cr2) {
        int n2 = this.d / this.f;
        int n3 = this.d % this.f;
        n3 = this.f + 40 + n3 * 15;
        n2 = this.g + 17 + n2 * 15;
        int n4 = n3;
        n3 = n2;
        n2 = n4;
        cr2.a(0x660000);
        cr2.d(n2, n3 - 1, 13, 15);
        cr2.e(n2 - 1, n3, n2 - 1, n3 + 14 - 1);
        cr2.e(n2 + 14, n3, n2 + 14, n3 + 14 - 1);
        cr2.a(0xFF0000);
        cr2.e(n2, n3 + 1, n2, n3 + 14 - 1 - 1);
        cr2.e(n2 + 14 - 1, n3 + 1, n2 + 14 - 1, n3 + 14 - 1 - 1);
        cr2.e(n2 + 1, n3, n2 + 14 - 2, n3);
        cr2.e(n2 + 1, n3 + 14 - 1, n2 + 14 - 2, n3 + 14 - 1);
    }

    protected final void a(cr cr2, bp bp2, byte by2, boolean bl2, byte n2, byte n3, int n4) {
        int n5;
        int n6;
        int n7 = this.g + 80;
        ah.c(cr2, this.f, n7, 16);
        int n8 = this.f + 40;
        int n9 = this.g + 17;
        int n10 = n2 * 14 + n2;
        int n11 = n3 * 14 + n3;
        cr2.a(15723216);
        ah.d(cr2, n8 - 1, n9 - 1, n10 + 1, n11 + 1);
        for (n6 = 0; n6 < n3; ++n6) {
            for (n5 = 0; n5 < n2; ++n5) {
                n11 = n8 + n5 * 15;
                int n12 = n9 + n6 * 15;
                dg dg2 = bp2.a(n6 * n2 + n5);
                if (dg2 != null) {
                    dg2.a(cr2, n11, n12);
                    if (dg2.i > 1) {
                        ah.b(cr2, dg2.i, n11 + 14 - 1, n12 + 14 - 7, 8, 0);
                    }
                    if (!dg2.c()) continue;
                    cr2.a(0xFF0000);
                    cr2.d(n11, n12, 13, 13);
                    continue;
                }
                cr2.a(0);
                ah.d(cr2, n11, n12, 14, 14);
            }
        }
        if (bl2) {
            cr2.a(0xFFFFFF);
            int n13 = by2 + 25;
            dv.a(cr2, this.f + 9, n7 + 2, rpg.c.g.a(n13), 0);
        } else {
            this.b(cr2);
            this.a(cr2, this.f, n7 + 2, bp2.a(this.d));
        }
        cr2.b(this.f, this.g, 160, 174);
        cr2.a(3550755);
        n6 = this.f + 9;
        n5 = this.g + 174 - 14;
        dv.a(cr2, n6, n5, rpg.c.b.a(31), 0);
        this.d(cr2, this.f + 111, n5 + 2, n4);
    }
}

