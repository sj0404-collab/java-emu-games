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

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
            ((ah)this).a.d = 1;
            ((ah)this).a.g();
            return true;
        }
        if (ah.f(n2, n3)) {
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
        if (this.d(n2, n3)) {
            return true;
        }
        this.e(n2, n3);
        return true;
    }

    protected final void a(cr cr2) {
        int n2;
        int n3 = this.a(cr2, false, true, true, false);
        for (n2 = 0; n2 < 2; ++n2) {
            cr2.a(3550755);
            cr2.a(rpg.a.a - 160 >> 1, n3 + n2 * 77, 160, 22);
            cr2.a(15723216);
            cr2.d(rpg.a.a - 160 >> 1, n3 + n2 * 77 - 1, 159, 23);
        }
        n2 = this.f + 3;
        n3 = this.g + 29;
        cr2.a(rpg.c.l[0], n2, n3, 20);
        ah.b(cr2, this.a.b(), n2 + 42, n3 + 5, 8, 1);
        int n4 = this.a.d((byte)2);
        int n5 = this.a.e((byte)2);
        n2 = this.f + 54;
        cr2.a(rpg.c.l[1], n2, n3, 20);
        this.b(cr2, this.f + 160 - 3, n3 + 5, n4, n5, 8, 1);
        l.a(cr2, this.f + 3, n3 + 17, 14597755, 154, n4, n5, (byte)2);
        n4 = this.a.d((byte)0);
        n5 = this.a.e((byte)0);
        n2 = this.f + 3;
        n3 = this.g + 107;
        cr2.a(rpg.c.l[2], n2, n3, 20);
        this.b(cr2, rpg.a.c - 3, n3 + 5, n4, n5, 8, 1);
        l.a(cr2, this.f + 1, n3 + 18, 16737370, 78, n4, n5, (byte)0);
        n4 = this.a.d((byte)1);
        n5 = this.a.e((byte)1);
        n2 = rpg.a.c + 3;
        cr2.a(rpg.c.l[3], n2, n3, 20);
        this.b(cr2, this.f + 160 - 3, n3 + 5, n4, n5, 8, 1);
        l.a(cr2, rpg.a.c + 1, n3 + 18, 6707967, 78, n4, n5, (byte)1);
        n4 = this.f + 1;
        n3 = this.g + 132;
        cr2.a(rpg.c.l[4], n4, n3, 20);
        if (r.b()) {
            this.b(cr2, n4 + 43 + 1, n3 + 5, this.a.b(false), this.a.b(true), 4, 1);
        } else {
            ah.b(cr2, this.a.b(false), n4 + 43, n3 + 5, 4, 1);
        }
        n2 = this.f + 81;
        cr2.a(rpg.c.l[5], n2 + 10, n3, 20);
        ah.b(cr2, this.a.a, n2 + 43 + 10, n3 + 5, 4, 1);
        n3 = this.g + 152;
        cr2.a(rpg.c.l[6], n4, n3, 20);
        l.a(cr2, this.a.f((byte)2), this.f + 43, n3 + 5, 1);
        n2 = this.f + 81;
        cr2.a(rpg.c.l[7], n2 + 10, n3, 20);
        l.a(cr2, this.a.f((byte)0), n2 + 43 + 10, n3 + 5, 1);
        n2 = this.f + 45;
        n3 = this.g + 59;
        this.a(cr2, n2, n3, (byte)0);
        this.a(cr2, n2 + 53, n3, (byte)1);
        this.a(cr2, n2, n3 += 18, (byte)2);
        this.a(cr2, n2 + 53, n3, (byte)3);
    }

    private void a(cr cr2, int n2, int n3, byte by2) {
        int n4 = (by2 + 3) % 4;
        cr2.b(n2, n3, 26, 14);
        cr2.a(rpg.c.w, n2 - n4 * 26, n3, 20);
        ah.b(cr2, this.a.c(by2), n2 + 46, n3 + 3, 8, 1);
    }

    private void b(cr cr2, int n2, int n3, int n4, int n5, int n6, int n7) {
        n7 = l.a(n4, 1);
        int n8 = n2;
        if (n6 == 8) {
            n8 = n2 - (n7 + 7 + l.a(n5, 1));
        } else if (n6 == 1) {
            n8 = n2 - (n7 + 7 + l.a(n5, 1) >> 1);
        }
        ah.b(cr2, n4, n8, n3, 4, 1);
        cr2.b(n8 + n7, n3, 7, 7);
        cr2.a(rpg.c.x, n8 + n7 - 7, n3, 20);
        ah.b(cr2, n5, n8 + n7 + 7, n3, 4, 1);
    }

    private static int a(int n2, int n3) {
        cw cw2 = n3 == 0 ? rpg.c.s : rpg.c.h[n3 - 1];
        int n4 = cw2.a() / 10 - 1;
        int n5 = 0;
        do {
            n5 += n4;
        } while ((n2 /= 10) != 0);
        return n5;
    }

    private static void a(cr cr2, int n2, int n3, int n4, int n5) {
        ah.b(cr2, n2, n3 + 8, n4, 8, 1);
        cr2.b(n3 + 10, n4, 7, 7);
        cr2.a(rpg.c.x, n3 + 10, n4, 20);
        cr2.b(0, 0, rpg.a.a, rpg.a.b);
    }

    private static void a(cr cr2, int n2, int n3, int n4, int n5, int n6, int n7, byte by2) {
        cr2.a(0);
        cr2.a(n2, n3, n5, 3);
        n5 = (n5 - 2 - 6) * n6 / n7;
        if (n5 > 0) {
            cr2.a(n4);
            cr2.e(n2 + 1, n3 + 1, n2 + 1 + n5, n3 + 1);
        }
        cr2.a(rpg.c.m[by2], n2 + 1 + n5, n3, 20);
    }

    protected final void b(cr cr2) {
        int n2;
        int n3;
        if (this.a) {
            n3 = this.d / 2;
            n2 = this.d % 2;
            this.b(cr2, this.f + 45 + n2 * 53 + 30, this.g + 59 + n3 * 18 + 1, 18, 11);
        }
        cr2.b(this.f + 25 - 24, this.g + 80 - 26, 40, 38);
        ah.c(cr2, this.f, this.g + 13, 160, 161);
        n3 = this.f + 25;
        n2 = this.g + 80;
        cr2.a(rpg.c.e[0], n3, n2 + 6, 33);
        this.a = rpg.c.a.a(this.a.f, (byte)2, this.a, n3, n2) + 1;
        if (this.a) {
            cr2.a(3550755);
            cr2.a(n3 -= 13, n2, 26, 12);
            cr2.a(15723216);
            cr2.d(n3, n2, 26, 12);
            cr2.a(rpg.c.c[0], n3 + 2, n2 + 2, 20);
            ah.b(cr2, this.a.c, n3 + 26 - 2, n2 + 3, 8, 0);
        }
    }
}

