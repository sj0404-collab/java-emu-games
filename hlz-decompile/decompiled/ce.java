/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class ce
extends aw {
    private bp a;
    private dg a;
    private byte a;
    private boolean a = null;
    private byte b;

    public ce(ah ah2, byte by) {
        super(ah2, (byte)28, (byte)4, (byte)7);
        switch (by) {
            case 0: {
                this.a = r.a();
                break;
            }
            case 2: {
                this.a = r.b();
                break;
            }
            case 1: {
                this.a = r.c();
            }
        }
        this.b = this.a = by;
        this.a = true;
    }

    final boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (ah.g(n, n2)) {
            ((ah)this).a.g();
            return true;
        }
        if (this.a) {
            if (n2 == 50 || n == 1) {
                this.b = (byte)((this.b + 2) % 3);
            } else if (n2 == 56 || n == 6) {
                this.b = (byte)((this.b + 1) % 3);
            } else {
                if (n2 == 54 || n == 5 || ah.f(n, n2)) {
                    this.d = 0;
                    this.a = false;
                    return true;
                }
                return true;
            }
            ((ah)this).a.b = new ce(((ah)this).a, this.b);
            return true;
        }
        if (ah.f(n, n2)) {
            this.a = this.a.a(this.d);
            if (this.a == null) {
                return true;
            }
            if (this.a.a()) {
                ((ah)this).b = new q((ah)this, dj.a.a(43, 44, 42, 25));
            } else if (this.a.b() && !this.a.c() && w.a(this.a)) {
                ((ah)this).b = new q((ah)this, dj.a.a(65, 42, 25));
            } else if (ce.a(this.a)) {
                ((ah)this).b = new q((ah)this, dj.a.a(41, 42, 25));
            } else if (this.a.d()) {
                ((ah)this).b = new q((ah)this, dj.a.a(42, 25));
            } else {
                this.a(this.a);
            }
            return true;
        }
        if ((n2 == 52 || n == 2) && this.d % 7 == 0) {
            this.a = true;
            return true;
        }
        if (this.d(n, n2)) {
            return true;
        }
        this.e(n, n2);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    final void a(byte by, byte by2) {
        this.g();
        if (by == 6) {
            ce ce2 = this;
            if (ce2.a.a()) {
                switch (by2) {
                    case 0: 
                    case 1: {
                        r.a(by2 == 0, ce2.a.h);
                        return;
                    }
                    case 2: {
                        ce2.b();
                        return;
                    }
                    case 3: {
                        ce2.a(ce2.a);
                    }
                }
                return;
            }
            if (ce2.a.b() && !ce2.a.c() && w.a(ce2.a)) {
                if (by2 == 0) {
                    ((ah)ce2).b = new w(ce2);
                    return;
                }
                if (by2 == 1) {
                    ce2.b();
                    return;
                }
                if (by2 != 2) return;
                ce2.a(ce2.a);
                return;
            }
            if (ce.a(ce2.a)) {
                if (by2 == 0) {
                    if (r.a.d) {
                        ((ah)ce2).b = new bk((ah)ce2, dj.a.a(48), 5, true);
                        return;
                    }
                    ce2.a(dj.a.a(45));
                    return;
                }
                if (by2 == 1) {
                    ce2.b();
                    return;
                }
                if (by2 != 2) return;
                ce2.a(ce2.a);
                return;
            }
            if (!ce2.a.d()) return;
            if (by2 == 0) {
                ce2.b();
                return;
            }
            if (by2 != 1) return;
            ce2.a(ce2.a);
            return;
        }
        if (by == 4 && by2 == 0) {
            this.a.a(this.d);
            bh.d = true;
            return;
        }
        if (by != 5) return;
        if (by2 != 0) return;
        this.a.a((int)this.d, 1);
        r.a((byte)7, (byte)2);
    }

    private void b() {
        if (this.a.c()) {
            this.a(dj.a.a(47));
            return;
        }
        ((ah)this).b = new bk((ah)this, dj.a.a(46), 4, true, true);
    }

    protected final void a(cr cr2) {
        this.a(cr2, false, true, true, false);
        this.a(cr2, this.a, this.a, 3, true);
        this.a(cr2, this.a, this.a, this.a, (byte)7, (byte)4, r.e);
    }

    private static boolean a(dg dg2) {
        return dg2.g == 20 && dg2.h == 1;
    }
}
