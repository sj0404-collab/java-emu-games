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

    bz(ah ah2, boolean bl) {
        super(ah2, (byte)6);
        this.a = bl;
        this.e = true;
    }

    final boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (ah.f(n, n2) || ah.g(n, n2)) {
            if (n == -7) {
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
        if (ah.h(n, n2)) {
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
        if (ah.i(n, n2)) {
            switch (this.d) {
                case 1: {
                    byte by = rpg.e.b;
                    n2 = 4;
                    n = by;
                    rpg.e.b = (byte)((by + 1) % n2);
                    break;
                }
                case 2: {
                    byte by = rpg.e.c;
                    n2 = 4;
                    n = by;
                    rpg.e.c = (byte)((by + 1) % n2);
                    break;
                }
                case 4: {
                    byte by = rpg.e.d;
                    n2 = 2;
                    n = by;
                    rpg.e.d = (byte)((by + 1) % n2);
                }
            }
            bz.c(this.d);
            return true;
        }
        return this.c(n, n2);
    }

    private static byte a(byte by, byte by2) {
        return (byte)((by + by2 - 1) % by2);
    }

    private static void c(byte by) {
        switch (by) {
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
        int n = rpg.a.d;
        if (this.a) {
            this.a(cr2, false, false, true, false);
            n = this.a(cr2, -1, 158, false) + 1;
        } else {
            rpg.a.a(cr2, true);
            n = rpg.a.b <= 208 ? (n -= 60) : (n -= 32);
        }
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, rpg.g.b, rpg.c.b.a(7), 0, 1);
        int n2 = rpg.a.c - 50;
        cr2.a(0xFFFFFF);
        int n3 = 0;
        int n4 = n;
        while (n3 < 6) {
            dv.a(cr2, n2, n4, rpg.c.b.a(n3 + 17), 0);
            ++n3;
            n4 += 15;
        }
        n2 = rpg.a.c + 24 + 5 + 8;
        this.a(cr2, n2, n - 1, rpg.e.c, (byte)0);
        cr2.a(this.d == 1 ? 0xFFFFFF : 12630160);
        dv.a(cr2, n2, n - 1 + 14 + 2, rpg.c.b.a(23 + rpg.e.b), 0, 1);
        int n5 = n - 1 + 28 + 2;
        int n6 = n2;
        cr cr3 = cr2;
        bz bz2 = this;
        if (rpg.e.c == 0) {
            int n7 = 2;
            n6 = n5;
            bz bz3 = bz2;
            cr3.a(bz3.d == 2 ? 0xFFFFFF : 12630160);
            dv.a(cr3, rpg.a.c + 24 + 5, n6 + 1, rpg.c.b.a(38), 0);
        } else {
            cr3.a(bz2.d == 2 ? 0xFFFFFF : 12630160);
            dv.a(cr3, n6, n5, ("" + rpg.e.c).getBytes(), 0, 1);
        }
        this.a(cr2, n2, n + 42 + 4 - 2, rpg.e.a, (byte)3);
        cr2.a(this.d == 4 ? 0xFFFFFF : 12630160);
        dv.a(cr2, n2, n + 56 + 6 - 2, rpg.c.b.a(35 + rpg.e.d), 0, 1);
        cr2.a(this.d == 5 ? 0xFFFFFF : 12630160);
        dv.a(cr2, n2, n + 70 + 6 - 2, rpg.c.b.a(rpg.e.d ? 37 : 38), 0, 1);
        ah.a(cr2, 2);
    }

    protected final void b(cr cr2) {
        int n = rpg.a.d + 4 + 15 * (this.d - 3) + (this.a ? -24 : 14);
        if (rpg.a.b <= 208 && !this.a) {
            n -= 28;
        }
        ah.a(cr2, rpg.a.c + 6, n, 60, 0xFFFFFF, false);
    }

    private void a(cr cr2, int n, int n2, boolean bl, byte by) {
        cr2.a(this.d == by ? 0xFFFFFF : 12630160);
        dv.a(cr2, n, n2 + 1, rpg.c.b.a(bl ? 37 : 38), 0, 1);
    }
}
