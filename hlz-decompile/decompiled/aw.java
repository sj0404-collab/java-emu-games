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

    public aw(ah ah2, byte by, byte by2, byte by3) {
        super(ah2, by, by2, by3);
    }

    public aw(ah ah2, byte by) {
        this(ah2, by, 1, 1);
    }

    private void a(cr cr2, int n, int n2, byte by, byte by2) {
        cr2.b(this.f, this.g, 160, 174);
        if (by2 == -3) {
            cr2.a(15723216);
            for (by = 0; by < 2; by = (byte)(by + 1)) {
                cr2.e(n + 1, n2 + by * 13, n + 77 - 2, n2 + by * 13);
                cr2.e(n + by * 76, n2 + 1, n + by * 76, n2 + 14 - 2);
            }
            return;
        }
        cr2.a(6379080);
        ah.d(cr2, n, n2, 77, 14);
        if (by2 == -2) {
            return;
        }
        if (by2 == -1) {
            ae.a(cr2, n + 25, n2 + 6);
        } else {
            cr2.a(0xFFFFFF);
            dv.a(cr2, n + 38, n2 + 1, aw.a(by2), 1, 1);
        }
        aw.a(cr2, n + 1, n2 + 3, by2, false);
    }

    protected static byte[] a(byte by) {
        return rpg.c.g.a(by + 35);
    }

    private static void a(cr cr2, int n, int n2, byte by, boolean bl) {
        cr2.b(n, n2, 6, 6);
        if (by >= 0) {
            cr2.a(rpg.c.t, n - by * 6, n2, 20);
        } else if (bl) {
            if (by == -1) {
                cr2.a(0);
                cr2.a(n + 1, n2 + 1, 4, 4);
            }
            cr2.a(0xAAA27A);
            cr2.d(n, n2, 5, 5);
        } else {
            cr2.a(0);
            ah.d(cr2, n, n2, 6, 6);
        }
        rpg.a.a(cr2);
    }

    private static void b(cr cr2, int n, int n2, dg dg2, boolean bl) {
        if (bl) {
            cr2.a(e[((bs)dg2).b]);
        } else {
            cr2.a(0xFFFFFF);
        }
        if (dg2.c != null) {
            dv.a(cr2, n, n2, dg2.c, 0);
        }
    }

    private final void a(cr cr2, byte by, int n, int n2, int n3) {
        byte by2 = by;
        dv.a(cr2, n, n2, rpg.c.g.a(by2), 0, n3);
    }

    protected void a(cr cr2, byte by, int n, int n2, boolean bl) {
        cr2.a(r.a.b() < by ? 0xFF0000 : 0xFFFFFF);
        byte[] byArray = rpg.f.a(rpg.b.q, ("" + by).getBytes());
        byArray = rpg.f.a(byArray, rpg.b.i);
        dv.a(cr2, n, n2, byArray, 1);
    }

    private void a(cr cr2, int n, int n2, bs bs2) {
        int n3 = bs2.a();
        cr2.a(7368792);
        ah.d(cr2, n, n2, 45, 8);
        for (int i = 0; i < n3; ++i) {
            aw.a(cr2, n + 2 + i * 7, n2 + 1, bs2.a[i], true);
        }
        rpg.a.a(cr2);
    }

    protected final void a(cr cr2, int n, int n2, dg dg2) {
        this.a(cr2, n, n2, dg2, false);
    }

    protected final void a(cr cr2, int n, int n2, dg dg2, boolean bl) {
        this.a(cr2, n, n2, dg2, bl, false);
    }

    protected final void a(cr object, int n, int n2, dg dg2, boolean bl, boolean n3) {
        bs bs2;
        int n4;
        if (n3 != 0) {
            ah.c((cr)object, this.f, n2 - 2, 32);
        }
        if (dg2 == null) {
            ((cr)object).a(0x7F7F7F);
            int n5 = 24;
            dv.a((cr)object, n + 9, n2, rpg.c.g.a(n5), 0);
            return;
        }
        ((cr)object).b(this.f, this.g, 160, 174);
        byte by = dg2.g;
        int n6 = dg2 instanceof bs;
        aw.b((cr)object, n + 9, n2, dg2, n6 != 0);
        if (bl) {
            ((cr)object).a(14597755);
            this.a((cr)object, by, n + 160 - 9, n2, 8);
        } else if (n3 != 0) {
            ((cr)object).a(14597755);
            this.a((cr)object, by, n + 160 - 9, n2, 8);
            bs bs3 = (bs)dg2;
            if (bs3.a() > 0) {
                n6 = n + 9;
                n4 = n2 + 16;
                this.a((cr)object, n6, n4, bs3);
            }
        } else if (n6 != 0 && (bs2 = (bs)dg2).a() > 0) {
            n6 = n + 160 - 46;
            n4 = n2 + 2;
            this.a((cr)object, n6, n4, bs2);
        }
        if (!bl && n3 == 0) {
            dg dg3 = dg2;
            int n7 = n2 + 16 + 6;
            n2 = n;
            cr cr2 = object;
            object = this;
            n3 = dg3.g;
            by = dg3 instanceof bs;
            bs bs4 = null;
            cr2.a(0);
            if (by != 0) {
                bs4 = (bs)dg3;
            }
            n4 = n2 + 2;
            int n8 = n4 + 77 + 2;
            int n9 = n8 + 38;
            super.a(cr2, n2, n7, n7, 32);
            if (by == 0 || w.a(dg3)) {
                cr2.a(0xFFFFFF);
            } else {
                cr2.a(0xFF0000);
            }
            super.a(cr2, (byte)n3, n9, n7 + 1, 1);
            int n10 = n7 + 17;
            cr2.a(0);
            if (by != 0) {
                super.a(cr2, n2, n7, n10, by != 0 ? 33 : 34);
                ((aw)object).a(cr2, bs4.a, n8 + 8, n10 + 1, false);
                boolean bl2 = bs4.d > 0;
                super.a(cr2, n2, n7, n10 += 17, bl2 ? 52 : 51);
                object = bl2 ? new String("" + bs4.d) : (n3 == 11 ? (bs4.c > 0 ? new String("" + bs4.c) : new String("---")) : new String("" + bs4.b + "-" + bs4.c + "/" + bs4.e + "%"));
                cr2.a(0xFFFFFF);
                dv.a(cr2, n9, n10 + 1, ((String)object).getBytes(), 1, 1);
                return;
            }
            ah.d(cr2, n4, n10, 156, 36);
            cr2.a(0xFFFFFF);
            if (!(dg3 instanceof d) && dg3.d != null) {
                dv.a(cr2, n4 + 2, n10 + 2, 152, 0, dg3.d);
            }
        }
    }

    private final void a(cr cr2, int n, int n2, int n3, int n4) {
        int n5 = n4;
        byte[] byArray = rpg.c.g.a(n5);
        n2 = n3;
        cr cr3 = cr2;
        n4 = n + 2;
        int n6 = n4 + 77 + 2;
        cr3.a(0);
        ah.d(cr3, n4, n2, 77, 14);
        ah.d(cr3, n6, n2, 77, 14);
        cr3.e(n, n2 + 14 + 1, n + 160 - 1, n2 + 14 + 1);
        cr3.a(14597755);
        if (byArray != null) {
            dv.a(cr3, n4 + 38 + 1, n2 + 1, byArray, 0, 1);
        }
    }

    public final void b(cr cr2, int n, int n2, dg dg2) {
        byte by = dg2.g;
        boolean bl = dg2 instanceof bs;
        bs bs2 = null;
        int n3 = n + 20;
        cr2.a(0);
        cr2.a(n, n2, 160, 16);
        dg2.a(cr2, n + 1, n2 + 1, true, true);
        aw.b(cr2, n3, n2 + 3, dg2, bl);
        if (bl) {
            bs2 = (bs)dg2;
            n3 = 28 + bs2.b;
            dv.a(cr2, n + 160 - 3, n2 + 3, rpg.c.g.a(n3), 0, 8);
        }
        n3 = n + 2;
        int n4 = n3 + 77 + 2;
        int n5 = n4 + 38;
        int n6 = n2 + 16 + 1;
        this.a(cr2, n, n2, n6, 32);
        cr2.a(0xFFFFFF);
        this.a(cr2, by, n5, n6 + 1, 1);
        n6 += 17;
        cr2.a(0);
        if (bl) {
            this.a(cr2, n, n2, n6, bl ? 33 : 34);
            this.a(cr2, bs2.a, n4 + 8, n6 + 1, false);
            int n7 = bs2.d > 0 ? 1 : 0;
            this.a(cr2, n, n2, n6 += 17, n7 != 0 ? 52 : 51);
            String string = n7 != 0 ? new String("" + bs2.d) : (by == 11 ? (bs2.c > 0 ? new String("" + bs2.c) : new String("---")) : new String("" + bs2.b + "-" + bs2.c + "/" + bs2.e + "%"));
            cr2.a(0xFFFFFF);
            dv.a(cr2, n5, n6 + 1, string.getBytes(), 1, 1);
            n6 += 17;
            for (n7 = 0; n7 < 6; ++n7) {
                int n8 = n7 >> 1;
                n2 = n7 % 2;
                this.a(cr2, n3 + n2 * 79, n6 + n8 * 15, (byte)77, bs2.a[n7]);
            }
            return;
        }
        ah.d(cr2, n3, n6, 155, 119);
        cr2.a(0xFFFFFF);
        if (dg2.d != null) {
            dv.a(cr2, n3 + 2, n6 + 2, 151, 0, dg2.d);
        }
    }

    protected final void a(dg dg2) {
        this.b = new cv((ah)this, dg2);
    }

    protected void b(cr cr2) {
        this.e(cr2);
    }

    protected final void e(cr cr2) {
        int n = this.d / this.f;
        int n2 = this.d % this.f;
        n2 = this.f + 40 + n2 * 15;
        n = this.g + 17 + n * 15;
        int n3 = n2;
        n2 = n;
        n = n3;
        cr2.a(0x660000);
        cr2.d(n, n2 - 1, 13, 15);
        cr2.e(n - 1, n2, n - 1, n2 + 14 - 1);
        cr2.e(n + 14, n2, n + 14, n2 + 14 - 1);
        cr2.a(0xFF0000);
        cr2.e(n, n2 + 1, n, n2 + 14 - 1 - 1);
        cr2.e(n + 14 - 1, n2 + 1, n + 14 - 1, n2 + 14 - 1 - 1);
        cr2.e(n + 1, n2, n + 14 - 2, n2);
        cr2.e(n + 1, n2 + 14 - 1, n + 14 - 2, n2 + 14 - 1);
    }

    protected final void a(cr cr2, bp bp2, byte by, boolean bl, byte n, byte n2, int n3) {
        int n4;
        int n5;
        int n6 = this.g + 80;
        ah.c(cr2, this.f, n6, 16);
        int n7 = this.f + 40;
        int n8 = this.g + 17;
        int n9 = n * 14 + n;
        int n10 = n2 * 14 + n2;
        cr2.a(15723216);
        ah.d(cr2, n7 - 1, n8 - 1, n9 + 1, n10 + 1);
        for (n5 = 0; n5 < n2; ++n5) {
            for (n4 = 0; n4 < n; ++n4) {
                n10 = n7 + n4 * 15;
                int n11 = n8 + n5 * 15;
                dg dg2 = bp2.a(n5 * n + n4);
                if (dg2 != null) {
                    dg2.a(cr2, n10, n11);
                    if (dg2.i > 1) {
                        ah.b(cr2, dg2.i, n10 + 14 - 1, n11 + 14 - 7, 8, 0);
                    }
                    if (!dg2.c()) continue;
                    cr2.a(0xFF0000);
                    cr2.d(n10, n11, 13, 13);
                    continue;
                }
                cr2.a(0);
                ah.d(cr2, n10, n11, 14, 14);
            }
        }
        if (bl) {
            cr2.a(0xFFFFFF);
            int n12 = by + 25;
            dv.a(cr2, this.f + 9, n6 + 2, rpg.c.g.a(n12), 0);
        } else {
            this.b(cr2);
            this.a(cr2, this.f, n6 + 2, bp2.a(this.d));
        }
        cr2.b(this.f, this.g, 160, 174);
        cr2.a(3550755);
        n5 = this.f + 9;
        n4 = this.g + 174 - 14;
        dv.a(cr2, n5, n4, rpg.c.b.a(31), 0);
        this.d(cr2, this.f + 111, n4 + 2, n3);
    }
}
