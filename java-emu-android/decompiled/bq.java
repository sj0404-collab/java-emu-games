/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class bq
extends p {
    private byte a;
    private bs a = null;
    private bs b;
    private boolean h = false;

    public bq(ah ah2, byte by2) {
        super(ah2, (byte)12, (byte)3, (byte)4);
        this.a = by2;
        ((p)this).a = 0;
        this.h = true;
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
            byte by2;
            bq bq2 = this;
            x x2 = r.a;
            if (bq2.a != null) {
                x2.a(bq2.a);
                bq2.a = null;
            }
            if ((by2 = p.b[bq2.a]) >= 0) {
                bs bs2 = (bs)r.a().a(by2);
                x2.a(bq2.a, bs2);
            }
            x2.k();
            ((ah)this).a.d = this.a;
            ((ah)this).a.g();
            return true;
        }
        if (ah.f(n2, n3)) {
            n2 = this.d + ((p)this).a * 12;
            bs bs3 = this.a(n2);
            if (bs3 == null) {
                return true;
            }
            ((ah)this).b = new q(this, dj.a.a(39, 25), 1);
            return true;
        }
        if (n3 == 52 || n2 == 2) {
            if (((p)this).a) {
                ((p)this).a = (((p)this).a + ((p)this).b - 1) % ((p)this).b;
            } else if (((p)this).b) {
                ((p)this).b = false;
            } else if (((p)this).b > 1 && this.d % 4 == 0) {
                ((p)this).a = true;
            } else {
                this.b((byte)3);
                this.h = true;
            }
            return true;
        }
        if (n3 == 54 || n2 == 5) {
            if (((p)this).a) {
                ((p)this).a = false;
            } else if (((p)this).b) {
                ((p)this).a = (((p)this).a + 1) % ((p)this).b;
            } else if (((p)this).b > 1 && this.d % 4 == 3) {
                ((p)this).b = true;
            } else {
                this.b((byte)4);
                this.h = true;
            }
            return true;
        }
        if (this.e(n2, n3)) {
            this.h = true;
            return true;
        }
        return true;
    }

    final void a(byte by2, byte by3) {
        this.g();
        if (by2 == 6) {
            if (by3 == 0) {
                ((ah)this).b = new bi((ah)this, dj.a.a(57), '\u0000');
                bq bq2 = this;
                x x2 = r.a;
                x2.a(bq2.a, bq2.a);
                x2.k();
                byte by4 = p.a[bq2.a];
                if (by4 >= 0) {
                    rpg.c.a(rpg.c.a, (int)by4);
                }
                p.c = true;
                ((ah)this).a.g();
                return;
            }
            if (by3 == 1) {
                ((ah)this).b = new cv((ah)this, this.a);
            }
        }
    }

    protected final void a(cr cr2) {
        if (this.h) {
            int n2 = this.d + ((p)this).a * 12;
            this.b = this.a(n2);
            if (this.b != null) {
                bs bs2 = this.b;
                bq bq2 = this;
                x x2 = r.a;
                bq2.a = bs2;
                x2.a(bq2.a, bq2.a);
                x2.k();
                p.b = new int[7];
                p.b = p.a();
            }
            this.h = false;
        }
        this.a(cr2, this.a, this.b, this.b != null, this.a == 5);
    }

    protected final void b(cr cr2) {
        if (((p)this).a) {
            this.a(cr2, ah.d[((ah)this).h], this.f + 19 + 56, this.g + 17 + 21);
            return;
        }
        if (((p)this).b) {
            this.b(cr2, ah.d[((ah)this).h], this.f + 63 + 73 - 11, this.g + 17 + 21);
            return;
        }
        int n2 = this.d / this.f;
        int n3 = this.d % this.f;
        n3 = this.f + 19 + 56 + n3 * 15;
        n2 = this.g + 17 + n2 * 15;
        this.b(cr2, n3, n2, 13, 13);
    }

    private bs a(int n2) {
        byte[] byArray = p.a[this.a];
        bs bs2 = null;
        if (byArray != null && n2 < byArray.length) {
            bs2 = (bs)r.a().a(byArray[n2]);
        }
        return bs2;
    }
}

