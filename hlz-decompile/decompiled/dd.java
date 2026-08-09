/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;
import rpg.c;
import rpg.f;
import rpg.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dd
extends av {
    private cx a;
    private byte a;

    public dd() {
        super(null, (byte)6, (byte)1, (byte)1);
        this.e = true;
        if (r.b == this.d) {
            this.a(5, 54);
            while (!this.a(this.d)) {
                this.a(5, 54);
            }
        }
        this.a = new cx("/t/j");
        this.a = 0;
        this.b = new bk(this, this.a.a(3), this.a.a(10, 11));
        bh.a();
        bh.e();
    }

    private void b() {
        this.a = null;
        m.b();
        bh.c = true;
    }

    final boolean a(int n, int n2) {
        if (this.b != null && this.b instanceof bd && this.b(n, n2)) {
            return true;
        }
        if (ah.g(n, n2) && this.a <= 1 || this.a >= 7) {
            this.b();
            return true;
        }
        if (this.b(n, n2)) {
            return true;
        }
        if (ah.f(n, n2)) {
            if (this.a(this.d)) {
                byte[] byArray = rpg.f.a(rpg.c.d.a(r.b + 1), this.a.a(5));
                byte[] byArray2 = rpg.f.a(rpg.c.d.a(this.d + 1), this.a.a(6));
                byArray = rpg.f.a(byArray, byArray2);
                int n3 = r.a.b() * r.l * 100;
                byte[] byArray3 = rpg.f.a(rpg.b.k, ("" + n3).getBytes());
                byArray3 = rpg.f.a(byArray3, rpg.b.l);
                this.b = new bk((ah)this, rpg.f.a(byArray, byArray3), 3, true);
            } else {
                this.b = new bi((ah)this, this.a.a(4), '\u0000');
            }
        } else if (ah.h(n, n2)) {
            this.d = (byte)((this.d - 1 + this.e) % this.e);
            if (r.b == this.d) {
                this.a(n, n2);
            }
        } else if (ah.i(n, n2)) {
            this.d = (byte)((this.d + 1) % this.e);
            if (r.b == this.d) {
                this.a(n, n2);
            }
        } else {
            return false;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    final void a(byte by, byte by2) {
        this.g();
        if (by == -1 && by2 == -1) {
            this.b = new bi((ah)this, this.a.a(9), '\u0000');
            this.a = (byte)8;
            bh.c = true;
            return;
        }
        if (by == -2 && by2 == -2) {
            by = (byte)3;
            by2 = 0;
        }
        if (by == 3) {
            if (this.a == 0) {
                if (by2 != 0) {
                    this.b();
                    return;
                }
                if (r.e >= 2000) {
                    r.e -= 2000;
                    r.a.q();
                    r.a.r();
                    this.b();
                    return;
                }
                if (j.a) {
                    this.b = new bi((ah)this, this.a.a(9), '\u0000');
                    this.a = (byte)8;
                    return;
                }
                this.b = new bd(this);
                ((bd)this.b).c();
                return;
            }
            if (this.a != 1) {
                if (this.a != 6) return;
                this.b();
                if (by2 != 0) return;
                r.a((byte)6, (byte)1);
                return;
            }
            if (by2 != 0) return;
            by = (byte)(r.a.b() * r.l * 100);
            if (r.e < by) {
                if (j.a) {
                    this.b = new bi((ah)this, this.a.a(9), '\u0000');
                    this.a = (byte)7;
                    return;
                }
                this.b = new bd(this);
                ((bd)this.b).c();
                return;
            }
            r.e -= by;
            if (r.l < 99) {
                r.l = (byte)(r.l + 1);
            }
            dd dd2 = this;
            this.b = new bi((ah)dd2, dd2.a.a(7));
            dd2.a = (byte)2;
            return;
        }
        if (this.a != 0) return;
        if (by2 == 0) {
            this.a = 1;
            return;
        }
        this.b = new bk((ah)this, this.a.a(12), 3, true);
    }

    protected final void a(cr object) {
        if (this.a == 8 || this.b != null && this.b instanceof bd) {
            bh.a().d();
        }
        ah.a((cr)object, 3);
        if (this.a == 0 || this.a == 8) {
            return;
        }
        int n = this.a((cr)object, this.d);
        int n2 = n + 2;
        ((cr)object).a(0);
        ((cr)object).a(this.f, n, 160, 65);
        ((cr)object).a(6379080);
        ah.d((cr)object, this.f - 1, n2, 80, 47);
        ah.d((cr)object, this.f - 1 + 80 + 2, n2, 80, 47);
        n = n + 47 + 4;
        ((cr)object).a(this.f, n, 160, 18);
        int n3 = rpg.a.c - 40;
        aj.a((cr)object, r.b, n3, n2 + 26, ah.c[r.b], 0, true, true);
        int n4 = rpg.a.c + 40;
        aj.a((cr)object, this.d, n4, n2 + 26, ah.c[this.d], 0, true, this.a(this.d));
        int n5 = this.d;
        int n6 = 2;
        while (n6 > 0) {
            if ((n5 = (n5 - 1 + 6) % 6) == r.b) continue;
            --n6;
        }
        for (n6 = 0; n6 < 5; ++n6) {
            aj.a((cr)object, (byte)n5, this.f + 4 + 15 + n6 * 31, n + 3, n5 != this.d ? 3550755 : ah.c[n5], 0xFF0000, n5 == this.d, this.a((byte)n5));
            n5 = (n5 + 1) % this.e;
            if (n5 != r.b) continue;
            n5 = (n5 + 1) % this.e;
        }
        ((cr)object).a(14597755);
        dv.a((cr)object, rpg.a.c, rpg.g.b, this.a.a(0), 0, 1);
        dv.a((cr)object, n3, n2 + 5, this.a.a(1), 0, 1);
        dv.a((cr)object, n4, n2 + 5, this.a.a(2), 0, 1);
        ((cr)object).a(rpg.c.m, rpg.a.c, n2 + 18, 17);
        object = this;
        x x2 = r.a;
        switch (((dd)object).a) {
            case 2: {
                break;
            }
            case 3: {
                n2 = r.a() ? 1 : 0;
                x2.a_(((ah)object).d);
                if (r.a() == n2) break;
                x2.a(x2.a((byte)0));
                x2.a(x2.a((byte)4));
                x2.a(x2.a((byte)6));
                break;
            }
            case 4: {
                x2.a(x2.a((byte)3));
                x2.a(x2.a((byte)5));
                rpg.c.a = rpg.c.a().a();
                break;
            }
            case 5: {
                ((ah)object).g();
                ((ah)object).b = new bk((ah)object, ((dd)object).a.a(8), 3, true);
                break;
            }
            default: {
                return;
            }
        }
        ((dd)object).a = (byte)(((dd)object).a + 1);
        ((ah)object).a();
    }
}
