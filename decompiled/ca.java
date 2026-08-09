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

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
            ((ah)this).a.d = r.j;
            a = null;
            b = null;
            c = null;
            ((ah)this).a.g();
            return true;
        }
        if (ah.f(n2, n3)) {
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
        if (this.d(n2, n3)) {
            this.d = 0;
            this.a = 0;
            this.a = ah.i(n2, n3);
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
        int n2 = (((ah)this).d + this.e - 1) % this.e;
        int n3 = (((ah)this).d + 1) % this.e;
        if (this.d == 5) {
            rpg.c.a.a((byte)8, (byte)1, 0, this.b, this.c);
            ca.a(this.b - 35, this.c - 5, n3);
            ca.a(this.b + 35, this.c - 5, n2);
            if (((ah)this).d >= 4) {
                int n4 = this.c;
                int n5 = this.b;
                int n6 = this.a;
                n3 = ((ah)this).d;
                ca ca2 = this;
                if (n3 == 4) {
                    if (!r.g) {
                        ca.a(n5, n4, n3);
                    } else if (b != null) {
                        int n7 = rpg.a.a.a();
                        n3 = rpg.a.a.b();
                        int n8 = rpg.a.a.c();
                        int n9 = rpg.a.a.d();
                        rpg.a.a.c(n5 - 28, n4 - 26, 42, 42);
                        int n10 = 0;
                        int n11 = 0;
                        if (n6 < 3) {
                            n10 = n6 == 0 ? 0 : (n6 == 1 ? 42 : 84);
                        } else if (n6 < 6) {
                            n11 = 42;
                            n10 = n6 == 3 ? 0 : (n6 == 4 ? 42 : 84);
                        } else if (n6 < 8) {
                            n11 = 84;
                            n10 = n6 == 6 ? 0 : 42;
                        } else {
                            n6 = 0;
                        }
                        rpg.a.a.a(b, n5 - 28 - n10, n4 - 26 - n11, 0);
                        rpg.a.a.b(n7, n3, n8, n9);
                    }
                } else if (n3 == 5) {
                    if (!r.h) {
                        ca.a(n5, n4, n3);
                    } else if (c != null) {
                        int n12 = rpg.a.a.a();
                        n3 = rpg.a.a.b();
                        int n13 = rpg.a.a.c();
                        int n14 = rpg.a.a.d();
                        rpg.a.a.c(n5 - 17, n4 - 22, 27, 27);
                        int n15 = 0;
                        int n16 = 0;
                        if (n6 < 3) {
                            n15 = n6 == 0 ? 0 : (n6 == 1 ? 27 : 54);
                        } else if (n6 < 6) {
                            n16 = 27;
                            n15 = n6 == 3 ? 0 : (n6 == 4 ? 27 : 54);
                        } else if (n6 < 8) {
                            n16 = 54;
                            n15 = n6 == 6 ? 0 : 27;
                        } else {
                            n6 = 0;
                        }
                        rpg.a.a.a(c, n5 - 17 - n15, n4 - 22 - n16, 0);
                        rpg.a.a.b(n12, n3, n13, n14);
                    }
                }
                this.a = n6 + 1;
            } else {
                this.a = rpg.c.a.a(((ah)this).d, (byte)1, this.a, this.b, this.c) + 1;
            }
        } else if (this.a) {
            int n17 = (n2 + this.e - 1) % this.e;
            ca.a(this.b - 70 + 7 * this.d, this.c - 5, n3);
            ca.a(this.b + 7 * this.d, this.c - this.d, n2);
            ca.a(this.b + 35 + 7 * this.d, this.c - 5, n17);
            ca.a(this.b - 35 + 7 * this.d, this.c - 5 + this.d, (int)((ah)this).d);
        } else {
            int n18 = (n3 + 1) % this.e;
            ca.a(this.b - 35 - 7 * this.d, this.c - 5, n18);
            ca.a(this.b - 7 * this.d, this.c - this.d, n3);
            ca.a(this.b + 70 - 7 * this.d, this.c - 5, n2);
            ca.a(this.b + 35 - 7 * this.d, this.c - 5 + this.d, (int)((ah)this).d);
        }
        if (this.d < 5) {
            ++this.d;
        }
    }

    private static void a(int n2, int n3, int n4) {
        if (n4 >= 6) {
            return;
        }
        if (n4 >= 4) {
            if (n4 == 4) {
                if (b != null) {
                    n4 = rpg.a.a.a();
                    int n5 = rpg.a.a.b();
                    int n6 = rpg.a.a.c();
                    int n7 = rpg.a.a.d();
                    rpg.a.a.c(n2 - 28, n3 - 26, 42, 42);
                    rpg.a.a.a(b, n2 - 112, n3 - 110, 0);
                    rpg.a.a.b(n4, n5, n6, n7);
                    return;
                }
            } else if (n4 == 5 && c != null) {
                n4 = rpg.a.a.a();
                int n8 = rpg.a.a.b();
                int n9 = rpg.a.a.c();
                int n10 = rpg.a.a.d();
                rpg.a.a.c(n2 - 17, n3 - 22, 27, 27);
                rpg.a.a.a(c, n2 - 71, n3 - 76, 0);
                rpg.a.a.b(n4, n8, n9, n10);
                return;
            }
        } else {
            rpg.c.a.a((byte)(n4 + 4), (byte)1, 0, n2, n3);
        }
    }

    static {
        b = null;
        c = null;
    }
}

