/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;
import rpg.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class ca
extends av {
    private static cx a;
    private static cw b;
    private static cw c;
    private int a;
    private int b = rpg.a.c;
    private int c = rpg.a.d + 1;
    private int d = 5;
    private boolean a = 0;

    public ca(ah ah2) {
        super(ah2, (byte)6, (byte)1, (byte)1);
        this.e = true;
        a = new cx("/t/j");
        b = cw.a("/gunsword.png");
        c = cw.a("/wizard.png");
    }

    final boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (ah.g(n, n2)) {
            ((ah)this).a.d = r.j;
            a = null;
            b = null;
            c = null;
            ((ah)this).a.g();
            return true;
        }
        if (ah.f(n, n2)) {
            if (this.a(((ah)this).d)) {
                r.b = ((ah)this).d;
                r.a(0);
                b = null;
                c = null;
            } else {
                ((ah)this).b = new bi((ah)this, a.a(4), '\u0000');
            }
            return true;
        }
        if (this.d(n, n2)) {
            this.d = 0;
            this.a = 0;
            this.a = ah.i(n, n2);
        }
        return true;
    }

    protected final void a(cr cr2) {
        rpg.a.a(cr2, true);
        r.b = ((ah)this).d;
        this.a(cr2, (byte)(((ah)this).d + 6));
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, rpg.g.b, rpg.c.i.a(4), 0, 1);
        if (((ah)this).b != null && this.e) {
            this.b(cr2);
        }
        ah.a(cr2, 3);
    }

    protected final void b(cr cr2) {
        cr2.b(this.f, this.c - 33, 160, 44);
        cr2.a(0);
        cr2.a(this.f, this.c - 33, 160, 44);
        int n = (((ah)this).d + this.e - 1) % this.e;
        int n2 = (((ah)this).d + 1) % this.e;
        if (this.d == 5) {
            rpg.c.a.a((byte)8, (byte)1, 0, this.b, this.c);
            ca.a(this.b - 35, this.c - 5, n2);
            ca.a(this.b + 35, this.c - 5, n);
            if (((ah)this).d >= 4) {
                int n3 = this.c;
                int n4 = this.b;
                int n5 = this.a;
                n2 = ((ah)this).d;
                ca ca2 = this;
                if (n2 == 4) {
                    if (!r.g) {
                        ca.a(n4, n3, n2);
                    } else if (b != null) {
                        int n6 = rpg.a.a.a();
                        n2 = rpg.a.a.b();
                        int n7 = rpg.a.a.c();
                        int n8 = rpg.a.a.d();
                        rpg.a.a.c(n4 - 28, n3 - 26, 42, 42);
                        int n9 = 0;
                        int n10 = 0;
                        if (n5 < 3) {
                            n9 = n5 == 0 ? 0 : (n5 == 1 ? 42 : 84);
                        } else if (n5 < 6) {
                            n10 = 42;
                            n9 = n5 == 3 ? 0 : (n5 == 4 ? 42 : 84);
                        } else if (n5 < 8) {
                            n10 = 84;
                            n9 = n5 == 6 ? 0 : 42;
                        } else {
                            n5 = 0;
                        }
                        rpg.a.a.a(b, n4 - 28 - n9, n3 - 26 - n10, 0);
                        rpg.a.a.b(n6, n2, n7, n8);
                    }
                } else if (n2 == 5) {
                    if (!r.h) {
                        ca.a(n4, n3, n2);
                    } else if (c != null) {
                        int n11 = rpg.a.a.a();
                        n2 = rpg.a.a.b();
                        int n12 = rpg.a.a.c();
                        int n13 = rpg.a.a.d();
                        rpg.a.a.c(n4 - 17, n3 - 22, 27, 27);
                        int n14 = 0;
                        int n15 = 0;
                        if (n5 < 3) {
                            n14 = n5 == 0 ? 0 : (n5 == 1 ? 27 : 54);
                        } else if (n5 < 6) {
                            n15 = 27;
                            n14 = n5 == 3 ? 0 : (n5 == 4 ? 27 : 54);
                        } else if (n5 < 8) {
                            n15 = 54;
                            n14 = n5 == 6 ? 0 : 27;
                        } else {
                            n5 = 0;
                        }
                        rpg.a.a.a(c, n4 - 17 - n14, n3 - 22 - n15, 0);
                        rpg.a.a.b(n11, n2, n12, n13);
                    }
                }
                this.a = n5 + 1;
            } else {
                this.a = rpg.c.a.a(((ah)this).d, (byte)1, this.a, this.b, this.c) + 1;
            }
        } else if (this.a) {
            int n16 = (n + this.e - 1) % this.e;
            ca.a(this.b - 70 + 7 * this.d, this.c - 5, n2);
            ca.a(this.b + 7 * this.d, this.c - this.d, n);
            ca.a(this.b + 35 + 7 * this.d, this.c - 5, n16);
            ca.a(this.b - 35 + 7 * this.d, this.c - 5 + this.d, (int)((ah)this).d);
        } else {
            int n17 = (n2 + 1) % this.e;
            ca.a(this.b - 35 - 7 * this.d, this.c - 5, n17);
            ca.a(this.b - 7 * this.d, this.c - this.d, n2);
            ca.a(this.b + 70 - 7 * this.d, this.c - 5, n);
            ca.a(this.b + 35 - 7 * this.d, this.c - 5 + this.d, (int)((ah)this).d);
        }
        if (this.d < 5) {
            ++this.d;
        }
    }

    private static void a(int n, int n2, int n3) {
        if (n3 >= 6) {
            return;
        }
        if (n3 >= 4) {
            if (n3 == 4) {
                if (b != null) {
                    n3 = rpg.a.a.a();
                    int n4 = rpg.a.a.b();
                    int n5 = rpg.a.a.c();
                    int n6 = rpg.a.a.d();
                    rpg.a.a.c(n - 28, n2 - 26, 42, 42);
                    rpg.a.a.a(b, n - 112, n2 - 110, 0);
                    rpg.a.a.b(n3, n4, n5, n6);
                    return;
                }
            } else if (n3 == 5 && c != null) {
                n3 = rpg.a.a.a();
                int n7 = rpg.a.a.b();
                int n8 = rpg.a.a.c();
                int n9 = rpg.a.a.d();
                rpg.a.a.c(n - 17, n2 - 22, 27, 27);
                rpg.a.a.a(c, n - 71, n2 - 76, 0);
                rpg.a.a.b(n3, n7, n8, n9);
                return;
            }
        } else {
            rpg.c.a.a((byte)(n3 + 4), (byte)1, 0, n, n2);
        }
    }

    static {
        b = null;
        c = null;
    }
}
