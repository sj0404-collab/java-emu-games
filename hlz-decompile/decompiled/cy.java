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

    final boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (ah.g(n, n2)) {
            if (this.h) {
                this.h = false;
                ((bn)this).a.k();
            }
            ((ah)this).a.d = (byte)6;
            ((ah)this).a.g();
            return true;
        }
        if (((bn)this).a) {
            if (n == 1 || n2 == 50) {
                ((bn)this).a = false;
                this.b = true;
            } else if (!this.a(n, n2, (byte)2)) {
                return true;
            }
            return true;
        }
        if (this.b) {
            if (n == 1 || n == 8 || n2 == 50 || n2 == 53) {
                this.d = Z[this.i];
                this.b = false;
                return true;
            }
            return this.b(n, n2, (byte)2);
        }
        if (ah.f(n, n2)) {
            if (((bn)this).a == 0) {
                return this.a(true, (byte)2);
            }
            cy cy2 = this;
            n2 = cy2.d < 2 ? 1 : 0;
            byte by = (byte)(n2 != 0 ? cy2.d : cy2.d - 2);
            byte by2 = cy2.a(by, n2 != 0);
            n2 = by2;
            if (by2 >= 0 && (by = cy2.a.b(n2)) >= 0) {
                if (cy2.d < 2) {
                    if (cy2.i && by < cy2.j) {
                        cy2.a(dj.a.a(24, 28, 25));
                    } else {
                        cy2.a(dj.a.a(28, 25));
                    }
                } else if (cy2.i && by < cy2.j) {
                    if (by == 0) {
                        cy2.a(dj.a.a(24, 25));
                    } else {
                        cy2.a(dj.a.a(new int[]{24, 33, 34, 25}));
                    }
                } else if (by == 0) {
                    cy2.a(n2, by, false, false);
                } else {
                    cy2.a(dj.a.a(new int[]{33, 34, 25}));
                }
            }
            return true;
        }
        if (this.a(n, n2, Z[this.i] + 2, true)) {
            return true;
        }
        if (this.d(n, n2)) {
            return true;
        }
        return true;
    }

    final void a(byte by, byte by2) {
        this.g();
        if (by == 6) {
            by = this.d < 2 ? (byte)1 : 0;
            byte by3 = this.d;
            if (by == 0) {
                by3 = (byte)(by3 - 2);
            }
            by = this.a(by3, by != 0);
            by3 = this.a(by);
            if (((bn)this).a == 0) {
                this.a(by2, by, by3, (byte)2, false);
                return;
            }
            this.b(by2, by, by3, (byte)2, false);
        }
    }

    protected final void a(cr cr2) {
        int n = this.g + 13;
        int n2 = n + 16;
        this.a(cr2, n, n2, (byte)2);
        if (((bn)this).a == 0) {
            for (n = 0; n < 2; ++n) {
                if (r.b[n + 2] < 0) continue;
                ah.b(cr2, 7 + (n << 1), this.f + 1 + n * 80, n2 + 10, 4, 0);
            }
        }
        n = this.f + 65;
        n2 = this.g + 174 - 14 - 1;
        cr2.a(0);
        ah.d(cr2, n, n2, 35, 14);
        cr2.a(16755968);
        dv.a(cr2, n + 3, n2, rpg.f.a(rpg.b.q, ("" + (this.i + 1)).getBytes()), 0);
        this.a(cr2, (byte)2);
    }

    final byte a(byte by, boolean bl) {
        if (!bl) {
            if (by < Z[this.i]) {
                return (byte)(by + this.i * Z[0]);
            }
            return -2;
        }
        if (((bn)this).a == 0) {
            return this.b[by + 2];
        }
        return this.b[by];
    }

    final byte a(byte by) {
        if (((bn)this).a == 1) {
            return this.a.b(by);
        }
        return this.a.a(by);
    }

    final boolean a(byte by) {
        if (by < 0) {
            return false;
        }
        if (((bn)this).a == 0) {
            return r.a(by, false);
        }
        return this.a.c(by);
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

    protected final void c(byte by) {
        this.e();
        by = ((bn)this).a == 0 ? (byte)(this.a.a(by) ? 1 : 0) : (byte)(this.a.b(by) ? 1 : 0);
        if (by != 0) {
            this.a(dj.a.a(58));
        }
    }

    protected final void b(byte by, byte by2) {
        this.a.a((int)by, by2);
        this.h = true;
    }

    protected final void d() {
        this.a.a((int)this.d);
        this.h = true;
    }

    protected final void a(cr cr2, byte by, int n, int n2) {
        cr2.a(rpg.c.g[by], n, n2, 20);
    }
}
