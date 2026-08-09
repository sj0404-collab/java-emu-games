/*
 * Decompiled with CFR 0.152.
 */
import rpg.b;
import rpg.c;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class cy
extends bn {
    private static final byte[] Z = new byte[]{4, 6};
    private ai a;

    public cy(ah ah2) {
        super(ah2, bn.b, (byte)4, bn.a);
        ((bn)this).a = 0;
        this.a = ((bn)this).a.a();
        this.i = 0;
        this.j = (byte)5;
        this.c = (byte)(this.c + 1);
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
            if (this.h) {
                this.h = false;
                ((bn)this).a.k();
            }
            ((ah)this).a.d = (byte)6;
            ((ah)this).a.g();
            return true;
        }
        if (((bn)this).a) {
            if (n2 == 1 || n3 == 50) {
                ((bn)this).a = false;
                this.b = true;
            } else if (!this.a(n2, n3, (byte)2)) {
                return true;
            }
            return true;
        }
        if (this.b) {
            if (n2 == 1 || n2 == 8 || n3 == 50 || n3 == 53) {
                this.d = Z[this.i];
                this.b = false;
                return true;
            }
            return this.b(n2, n3, (byte)2);
        }
        if (ah.f(n2, n3)) {
            if (((bn)this).a == 0) {
                return this.a(true, (byte)2);
            }
            cy cy2 = this;
            n3 = cy2.d < 2 ? 1 : 0;
            byte by2 = (byte)(n3 != 0 ? cy2.d : cy2.d - 2);
            byte by3 = cy2.a(by2, n3 != 0);
            n3 = by3;
            if (by3 >= 0 && (by2 = cy2.a.b(n3)) >= 0) {
                if (cy2.d < 2) {
                    if (cy2.i && by2 < cy2.j) {
                        cy2.a(dj.a.a(24, 28, 25));
                    } else {
                        cy2.a(dj.a.a(28, 25));
                    }
                } else if (cy2.i && by2 < cy2.j) {
                    if (by2 == 0) {
                        cy2.a(dj.a.a(24, 25));
                    } else {
                        cy2.a(dj.a.a(new int[]{24, 33, 34, 25}));
                    }
                } else if (by2 == 0) {
                    cy2.a(n3, by2, false, false);
                } else {
                    cy2.a(dj.a.a(new int[]{33, 34, 25}));
                }
            }
            return true;
        }
        if (this.a(n2, n3, Z[this.i] + 2, true)) {
            return true;
        }
        if (this.d(n2, n3)) {
            return true;
        }
        return true;
    }

    final void a(byte by2, byte by3) {
        this.g();
        if (by2 == 6) {
            by2 = this.d < 2 ? (byte)1 : 0;
            byte by4 = this.d;
            if (by2 == 0) {
                by4 = (byte)(by4 - 2);
            }
            by2 = this.a(by4, by2 != 0);
            by4 = this.a(by2);
            if (((bn)this).a == 0) {
                this.a(by3, by2, by4, (byte)2, false);
                return;
            }
            this.b(by3, by2, by4, (byte)2, false);
        }
    }

    protected final void a(cr cr2) {
        int n2 = this.g + 13;
        int n3 = n2 + 16;
        this.a(cr2, n2, n3, (byte)2);
        if (((bn)this).a == 0) {
            for (n2 = 0; n2 < 2; ++n2) {
                if (r.b[n2 + 2] < 0) continue;
                ah.b(cr2, 7 + (n2 << 1), this.f + 1 + n2 * 80, n3 + 10, 4, 0);
            }
        }
        n2 = this.f + 65;
        n3 = this.g + 174 - 14 - 1;
        cr2.a(0);
        ah.d(cr2, n2, n3, 35, 14);
        cr2.a(16755968);
        dv.a(cr2, n2 + 3, n3, rpg.f.a(rpg.b.q, ("" + (this.i + 1)).getBytes()), 0);
        this.a(cr2, (byte)2);
    }

    final byte a(byte by2, boolean bl2) {
        if (!bl2) {
            if (by2 < Z[this.i]) {
                return (byte)(by2 + this.i * Z[0]);
            }
            return -2;
        }
        if (((bn)this).a == 0) {
            return this.b[by2 + 2];
        }
        return this.b[by2];
    }

    final byte a(byte by2) {
        if (((bn)this).a == 1) {
            return this.a.b(by2);
        }
        return this.a.a(by2);
    }

    final boolean a(byte by2) {
        if (by2 < 0) {
            return false;
        }
        if (((bn)this).a == 0) {
            return r.a(by2, false);
        }
        return this.a.c(by2);
    }

    final void b() {
        this.b = ((bn)this).a == 0 ? r.b : this.a.a;
        ((bn)this).a = ((bn)this).a == 1 ? dj.c : dj.b;
        this.c = false;
    }

    final void c() {
        dj.b = new cx("/t/sa");
        dj.c = new cx("/t/sp");
    }

    protected final void c(byte by2) {
        this.e();
        by2 = ((bn)this).a == 0 ? (byte)(this.a.a(by2) ? 1 : 0) : (byte)(this.a.b(by2) ? 1 : 0);
        if (by2 != 0) {
            this.a(dj.a.a(58));
        }
    }

    protected final void b(byte by2, byte by3) {
        this.a.a((int)by2, by3);
        this.h = true;
    }

    protected final void d() {
        this.a.a((int)this.d);
        this.h = true;
    }

    protected final void a(cr cr2, byte by2, int n2, int n3) {
        cr2.a(rpg.c.g[by2], n2, n3, 20);
    }
}

