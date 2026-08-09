/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;
import rpg.e;
import rpg.g;

final class bz
extends aj {
    private boolean a;

    bz(ah ah2, boolean bl2) {
        super(ah2, (byte)6);
        this.a = bl2;
        this.e = true;
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.f(n2, n3) || ah.g(n2, n3)) {
            if (n2 == -7) {
                try {
                    rpg.e.a().j();
                }
                catch (Exception exception) {}
                ah.f = false;
                ((ah)this).a.d = (byte)(this.a ? 1 : 4);
                ((ah)this).a.g();
            }
            return true;
        }
        if (ah.h(n2, n3)) {
            switch (this.d) {
                case 1: {
                    rpg.e.b = bz.a(rpg.e.b, (byte)4);
                    break;
                }
                case 2: {
                    rpg.e.c = bz.a(rpg.e.c, (byte)4);
                    break;
                }
                case 4: {
                    rpg.e.d = bz.a(rpg.e.d, (byte)2);
                }
            }
            bz.c(this.d);
            return true;
        }
        if (ah.i(n2, n3)) {
            switch (this.d) {
                case 1: {
                    byte by2 = rpg.e.b;
                    n3 = 4;
                    n2 = by2;
                    rpg.e.b = (byte)((by2 + 1) % n3);
                    break;
                }
                case 2: {
                    byte by3 = rpg.e.c;
                    n3 = 4;
                    n2 = by3;
                    rpg.e.c = (byte)((by3 + 1) % n3);
                    break;
                }
                case 4: {
                    byte by4 = rpg.e.d;
                    n3 = 2;
                    n2 = by4;
                    rpg.e.d = (byte)((by4 + 1) % n3);
                }
            }
            bz.c(this.d);
            return true;
        }
        return this.c(n2, n3);
    }

    private static byte a(byte by2, byte by3) {
        return (byte)((by2 + by3 - 1) % by3);
    }

    private static void c(byte by2) {
        switch (by2) {
            case 0: {
                if (!(rpg.e.c = !rpg.e.c)) break;
                bo.a((byte)0);
                rpg.e.a = false;
                return;
            }
            case 3: {
                if (!(rpg.e.a = !rpg.e.a)) break;
                bo.b();
                rpg.e.b = false;
                rpg.e.c = false;
                rpg.e.k();
                return;
            }
            case 1: {
                rpg.e.a(rpg.e.b);
                return;
            }
            case 5: {
                rpg.e.d = !rpg.e.d;
            }
        }
    }

    protected final void a(cr cr2) {
        int n2 = rpg.a.d;
        if (this.a) {
            this.a(cr2, false, false, true, false);
            n2 = this.a(cr2, -1, 158, false) + 1;
        } else {
            rpg.a.a(cr2, true);
            n2 = rpg.a.b <= 208 ? (n2 -= 60) : (n2 -= 32);
        }
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, rpg.g.b, rpg.c.b.a(7), 0, 1);
        int n3 = rpg.a.c - 50;
        cr2.a(0xFFFFFF);
        int n4 = 0;
        int n5 = n2;
        while (n4 < 6) {
            dv.a(cr2, n3, n5, rpg.c.b.a(n4 + 17), 0);
            ++n4;
            n5 += 15;
        }
        n3 = rpg.a.c + 24 + 5 + 8;
        this.a(cr2, n3, n2 - 1, rpg.e.c, (byte)0);
        cr2.a(this.d == 1 ? 0xFFFFFF : 12630160);
        dv.a(cr2, n3, n2 - 1 + 14 + 2, rpg.c.b.a(23 + rpg.e.b), 0, 1);
        int n6 = n2 - 1 + 28 + 2;
        int n7 = n3;
        cr cr3 = cr2;
        bz bz2 = this;
        if (rpg.e.c == 0) {
            int n8 = 2;
            n7 = n6;
            bz bz3 = bz2;
            cr3.a(bz3.d == 2 ? 0xFFFFFF : 12630160);
            dv.a(cr3, rpg.a.c + 24 + 5, n7 + 1, rpg.c.b.a(38), 0);
        } else {
            cr3.a(bz2.d == 2 ? 0xFFFFFF : 12630160);
            dv.a(cr3, n7, n6, ("" + rpg.e.c).getBytes(), 0, 1);
        }
        this.a(cr2, n3, n2 + 42 + 4 - 2, rpg.e.a, (byte)3);
        cr2.a(this.d == 4 ? 0xFFFFFF : 12630160);
        dv.a(cr2, n3, n2 + 56 + 6 - 2, rpg.c.b.a(35 + rpg.e.d), 0, 1);
        cr2.a(this.d == 5 ? 0xFFFFFF : 12630160);
        dv.a(cr2, n3, n2 + 70 + 6 - 2, rpg.c.b.a(rpg.e.d ? 37 : 38), 0, 1);
        ah.a(cr2, 2);
    }

    protected final void b(cr cr2) {
        int n2 = rpg.a.d + 4 + 15 * (this.d - 3) + (this.a ? -24 : 14);
        if (rpg.a.b <= 208 && !this.a) {
            n2 -= 28;
        }
        ah.a(cr2, rpg.a.c + 6, n2, 60, 0xFFFFFF, false);
    }

    private void a(cr cr2, int n2, int n3, boolean bl2, byte by2) {
        cr2.a(this.d == by2 ? 0xFFFFFF : 12630160);
        dv.a(cr2, n2, n3 + 1, rpg.c.b.a(bl2 ? 37 : 38), 0, 1);
    }
}

