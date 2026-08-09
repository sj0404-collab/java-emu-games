/*
 * Decompiled with CFR 0.152.
 */
import rpg.b;
import rpg.c;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class t
extends n {
    private byte a;
    private boolean c;
    private boolean h = false;
    private byte b = 0;
    private byte c = 1;
    private bp a;
    private dg a = null;

    public t(ah ah2, byte by2) {
        super(ah2, (byte)28, (byte)4, (byte)7);
        this.a = by2;
        this.c = this.a == 0;
        this.c((byte)0);
        this.d = 0;
        this.j();
    }

    private final void c(byte by2) {
        this.b = by2;
        this.d = 0;
        if (this.c) {
            this.c = (byte)3;
            this.a = by2 == 0 ? r.a() : (by2 == 2 ? r.b() : r.c());
        } else {
            this.c = (byte)n.a.length;
            this.a = n.a[this.b];
        }
        t t2 = this;
        this.g = (byte)(t2.a.a / 7);
        ((ah)t2).e = (byte)(t2.g * t2.f);
        if (t2.d > ((ah)t2).e) {
            t2.d = (byte)Math.min(((ah)t2).e - 1, 0);
        }
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
            ((ah)this).a.g();
            return true;
        }
        if ((n3 == 49 || n3 == 51) && this.a == 0) {
            t t2 = this;
            this.c = !t2.c;
            t2.c((byte)0);
            return true;
        }
        if (this.h) {
            if (n3 == 50 || n2 == 1) {
                this.b = (byte)((this.b + (this.c - 1)) % this.c);
            } else if (n3 == 56 || n2 == 6) {
                this.b = (byte)((this.b + 1) % this.c);
            } else {
                if (n3 == 54 || n2 == 5) {
                    this.d = 0;
                    this.h = false;
                    return true;
                }
                return true;
            }
            this.c(this.b);
            return true;
        }
        if (ah.f(n2, n3)) {
            this.a = this.a.a(this.d);
            if (this.a == 1) {
                ((k)((ah)this).a).a = this.a;
                ((ah)this).a.g();
            } else if (this.a != null) {
                ((ah)this).b = this.c ? new q((ah)this, rpg.c.h.a(48, 50, 16)) : new q((ah)this, rpg.c.h.a(49, 50, 16));
            }
            return true;
        }
        if ((n3 == 52 || n2 == 2) && this.d % this.f == 0) {
            this.h = true;
            return true;
        }
        if (this.d(n2, n3)) {
            return true;
        }
        return this.e(n2, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    final void a(byte by2, byte by3) {
        this.g();
        if (by2 == 6) {
            if (this.c) {
                switch (by3) {
                    case 0: {
                        if (this.a.c()) {
                            this.a(rpg.c.h.a(52));
                        }
                        if (!n.a[this.b].a(this.a.g, this.a.h, this.a.i)) {
                            this.a(rpg.c.h.a(55));
                            return;
                        }
                        if (this.a.c()) return;
                        if (n.a[this.b].a(this.a, (int)this.a.i) <= 0) return;
                        n.e();
                        this.a.a(this.d);
                        this.a = null;
                        this.b();
                        ((ah)this).b = new bi((ah)this, rpg.c.a.a(29), 1);
                        return;
                    }
                    case 1: {
                        t t2 = this;
                        if (t2.a.c()) {
                            t2.a(rpg.c.h.a(52));
                            break;
                        }
                        if (t2.a.d()) {
                            ((ah)t2).b = new bk((ah)t2, rpg.c.h.a(51), 4, true, true);
                            return;
                        }
                        t2.a(rpg.c.h.a(56));
                        break;
                    }
                    case 2: {
                        this.a(this.a);
                    }
                }
                return;
            }
            switch (by3) {
                case 0: {
                    bp bp2 = r.a(this.a.g);
                    if (!bp2.a(this.a.g, this.a.h, this.a.i)) {
                        this.a(rpg.c.h.a(55));
                        return;
                    }
                    if (bp2.a(this.a, (int)this.a.i) <= 0) return;
                    n.a[this.b].a(this.d);
                    this.b();
                    n.e();
                    this.a = null;
                    return;
                }
                case 1: {
                    ((ah)this).b = new bk((ah)this, rpg.c.h.a(51), 4, true, true);
                    return;
                }
                case 2: {
                    this.a(this.a);
                }
            }
            return;
        }
        if (by2 != 4) return;
        if (by3 != 0) return;
        if (this.c) {
            this.a.a(this.d);
            this.b();
            return;
        }
        n.a[this.b].a(this.d);
        n.e();
    }

    protected final void a(cr cr2) {
        this.a(cr2, rpg.c.h.a(this.c ? 47 : 0), true, this.a == 0);
        this.a(cr2, this.b, this.h, this.c ? 3 : n.a.length, this.c);
        this.a(cr2, this.a, this.c ? this.b : (byte)0, this.h, this.f, this.g, this.c ? r.e : n.b);
    }

    protected final void a(cr cr2, byte by2, int n2, int n3, boolean bl2) {
        cr2.a(0xFFFFFF);
        byte[] byArray = rpg.f.a(rpg.b.q, (" " + by2).getBytes());
        byArray = rpg.f.a(byArray, rpg.b.j);
        dv.a(cr2, n2, n3, byArray, 1);
    }

    protected final void b(cr cr2) {
        if (!this.h) {
            this.e(cr2);
        }
    }
}

