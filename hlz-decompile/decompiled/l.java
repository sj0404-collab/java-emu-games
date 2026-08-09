/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class l
extends aj {
    private boolean a;
    private x a;
    private int a = r.a;

    public l(ah ah2) {
        super(ah2, (byte)4, (byte)2, (byte)2);
        this.a.k();
        if (this.a.c > 0) {
            this.a = true;
        }
        this.e = true;
    }

    final boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (ah.g(n, n2)) {
            ((ah)this).a.d = 1;
            ((ah)this).a.g();
            return true;
        }
        if (ah.f(n, n2)) {
            if (this.a) {
                l l2 = this;
                if (l2.a && l2.d >= 0 && l2.d < 4) {
                    l2.a.c = (short)(l2.a.c - 1);
                    if (l2.a.c <= 0) {
                        l2.a = false;
                    }
                    l2.a.d(l2.d);
                    l2.a.k();
                    return true;
                }
                return false;
            }
            ((ah)this).a.d = 1;
            ((ah)this).a.g();
            return true;
        }
        if (!this.a) {
            return true;
        }
        if (this.d(n, n2)) {
            return true;
        }
        this.e(n, n2);
        return true;
    }

    protected final void a(cr cr2) {
        int n;
        int n2 = this.a(cr2, false, true, true, false);
        for (n = 0; n < 2; ++n) {
            cr2.a(3550755);
            cr2.a(rpg.a.a - 160 >> 1, n2 + n * 77, 160, 22);
            cr2.a(15723216);
            cr2.d(rpg.a.a - 160 >> 1, n2 + n * 77 - 1, 159, 23);
        }
        n = this.f + 3;
        n2 = this.g + 29;
        cr2.a(rpg.c.l[0], n, n2, 20);
        ah.b(cr2, this.a.b(), n + 42, n2 + 5, 8, 1);
        int n3 = this.a.d((byte)2);
        int n4 = this.a.e((byte)2);
        n = this.f + 54;
        cr2.a(rpg.c.l[1], n, n2, 20);
        this.b(cr2, this.f + 160 - 3, n2 + 5, n3, n4, 8, 1);
        l.a(cr2, this.f + 3, n2 + 17, 14597755, 154, n3, n4, (byte)2);
        n3 = this.a.d((byte)0);
        n4 = this.a.e((byte)0);
        n = this.f + 3;
        n2 = this.g + 107;
        cr2.a(rpg.c.l[2], n, n2, 20);
        this.b(cr2, rpg.a.c - 3, n2 + 5, n3, n4, 8, 1);
        l.a(cr2, this.f + 1, n2 + 18, 16737370, 78, n3, n4, (byte)0);
        n3 = this.a.d((byte)1);
        n4 = this.a.e((byte)1);
        n = rpg.a.c + 3;
        cr2.a(rpg.c.l[3], n, n2, 20);
        this.b(cr2, this.f + 160 - 3, n2 + 5, n3, n4, 8, 1);
        l.a(cr2, rpg.a.c + 1, n2 + 18, 6707967, 78, n3, n4, (byte)1);
        n3 = this.f + 1;
        n2 = this.g + 132;
        cr2.a(rpg.c.l[4], n3, n2, 20);
        if (r.b()) {
            this.b(cr2, n3 + 43 + 1, n2 + 5, this.a.b(false), this.a.b(true), 4, 1);
        } else {
            ah.b(cr2, this.a.b(false), n3 + 43, n2 + 5, 4, 1);
        }
        n = this.f + 81;
        cr2.a(rpg.c.l[5], n + 10, n2, 20);
        ah.b(cr2, this.a.a, n + 43 + 10, n2 + 5, 4, 1);
        n2 = this.g + 152;
        cr2.a(rpg.c.l[6], n3, n2, 20);
        l.a(cr2, this.a.f((byte)2), this.f + 43, n2 + 5, 1);
        n = this.f + 81;
        cr2.a(rpg.c.l[7], n + 10, n2, 20);
        l.a(cr2, this.a.f((byte)0), n + 43 + 10, n2 + 5, 1);
        n = this.f + 45;
        n2 = this.g + 59;
        this.a(cr2, n, n2, (byte)0);
        this.a(cr2, n + 53, n2, (byte)1);
        this.a(cr2, n, n2 += 18, (byte)2);
        this.a(cr2, n + 53, n2, (byte)3);
    }

    private void a(cr cr2, int n, int n2, byte by) {
        int n3 = (by + 3) % 4;
        cr2.b(n, n2, 26, 14);
        cr2.a(rpg.c.w, n - n3 * 26, n2, 20);
        ah.b(cr2, this.a.c(by), n + 46, n2 + 3, 8, 1);
    }

    private void b(cr cr2, int n, int n2, int n3, int n4, int n5, int n6) {
        n6 = l.a(n3, 1);
        int n7 = n;
        if (n5 == 8) {
            n7 = n - (n6 + 7 + l.a(n4, 1));
        } else if (n5 == 1) {
            n7 = n - (n6 + 7 + l.a(n4, 1) >> 1);
        }
        ah.b(cr2, n3, n7, n2, 4, 1);
        cr2.b(n7 + n6, n2, 7, 7);
        cr2.a(rpg.c.x, n7 + n6 - 7, n2, 20);
        ah.b(cr2, n4, n7 + n6 + 7, n2, 4, 1);
    }

    private static int a(int n, int n2) {
        cw cw2 = n2 == 0 ? rpg.c.s : rpg.c.h[n2 - 1];
        int n3 = cw2.a() / 10 - 1;
        int n4 = 0;
        do {
            n4 += n3;
        } while ((n /= 10) != 0);
        return n4;
    }

    private static void a(cr cr2, int n, int n2, int n3, int n4) {
        ah.b(cr2, n, n2 + 8, n3, 8, 1);
        cr2.b(n2 + 10, n3, 7, 7);
        cr2.a(rpg.c.x, n2 + 10, n3, 20);
        cr2.b(0, 0, rpg.a.a, rpg.a.b);
    }

    private static void a(cr cr2, int n, int n2, int n3, int n4, int n5, int n6, byte by) {
        cr2.a(0);
        cr2.a(n, n2, n4, 3);
        n4 = (n4 - 2 - 6) * n5 / n6;
        if (n4 > 0) {
            cr2.a(n3);
            cr2.e(n + 1, n2 + 1, n + 1 + n4, n2 + 1);
        }
        cr2.a(rpg.c.m[by], n + 1 + n4, n2, 20);
    }

    protected final void b(cr cr2) {
        int n;
        int n2;
        if (this.a) {
            n2 = this.d / 2;
            n = this.d % 2;
            this.b(cr2, this.f + 45 + n * 53 + 30, this.g + 59 + n2 * 18 + 1, 18, 11);
        }
        cr2.b(this.f + 25 - 24, this.g + 80 - 26, 40, 38);
        ah.c(cr2, this.f, this.g + 13, 160, 161);
        n2 = this.f + 25;
        n = this.g + 80;
        cr2.a(rpg.c.e[0], n2, n + 6, 33);
        this.a = rpg.c.a.a(this.a.f, (byte)2, this.a, n2, n) + 1;
        if (this.a) {
            cr2.a(3550755);
            cr2.a(n2 -= 13, n, 26, 12);
            cr2.a(15723216);
            cr2.d(n2, n, 26, 12);
            cr2.a(rpg.c.c[0], n2 + 2, n + 2, 20);
            ah.b(cr2, this.a.c, n2 + 26 - 2, n + 3, 8, 0);
        }
    }
}
