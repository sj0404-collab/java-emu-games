/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class e
extends bm {
    private dg a;
    private int a;
    private int b;
    private int c = 0;
    private boolean a;
    private byte b;
    private bp a;
    private long a = 0L;
    private byte[] b;
    private cx b = new cx("/t/nb");

    public e(ah ah2) {
        super(null);
        this.a = r.a();
        this.b = this.b.a(0);
        this.c = r.a((byte)20).a((byte)20, (byte)0);
        bh.c = true;
    }

    protected final boolean a(dg dg2) {
        if (dg2 != null) {
            return dg2.b();
        }
        return false;
    }

    private static int a(dg dg2) {
        dg2 = (bs)dg2;
        for (int i2 = 0; i2 < ((bs)dg2).a.length && ((bs)dg2).a[i2] != -3; ++i2) {
            if (((bs)dg2).a[i2] != -2) continue;
            return (i2 + 1) * (i2 + 1);
        }
        return -1;
    }

    private static int b(dg dg2) {
        dg2 = (bs)dg2;
        for (int i2 = 0; i2 < ((bs)dg2).a.length && ((bs)dg2).a[i2] != -3; ++i2) {
            if (((bs)dg2).a[i2] != -2) continue;
            return (i2 + 1) * 100 * (((bs)dg2).b + 1);
        }
        return -1;
    }

    final void a(byte by2, byte by3) {
        this.g();
        this.a();
        if (by2 == -1 && by3 == -1) {
            ((bm)this).a = (byte)15;
            ((bm)this).a = ((bm)this).a.a(5);
            return;
        }
        if (by2 == -2 && by3 == -2) {
            if (this.a > r.e) {
                if (j.a) {
                    ((bm)this).a = (byte)15;
                    ((bm)this).a = ((bm)this).a.a(5);
                    return;
                }
                ((ah)this).b = new bd(this);
                ((bd)((ah)this).b).c();
                return;
            }
            if (this.b > this.c) {
                ((bm)this).a = (byte)15;
                ((bm)this).a = this.b.a(4);
                return;
            }
            bs bs2 = (bs)this.a;
            by3 = 0;
            for (int i2 = 0; i2 < bs2.a.length; ++i2) {
                if (bs2.a[i2] != -2) continue;
                by3 = 1;
            }
            if (by3 != 0) {
                this.a = 15L;
                ((bm)this).a = this.b.a(5);
                return;
            }
            ((bm)this).a = (byte)15;
            ((bm)this).a = ((bm)this).a.a(8);
        }
    }

    final boolean a(int n2, int n3) {
        if (((ah)this).b != null && ((ah)this).b instanceof bd && this.b(n2, n3)) {
            return true;
        }
        if (this.a > 0L) {
            return true;
        }
        if (((bm)this).a > 0) {
            ((bm)this).a = null;
            this.a = 0L;
            ((bm)this).a = 0;
            this.a();
            return true;
        }
        this.a();
        if (this.a) {
            if (ah.g(n2, n3)) {
                this.a = false;
                return true;
            }
            if (ah.f(n2, n3)) {
                this.a = this.a.a(this.d);
                if (!this.a(this.a)) {
                    this.a = null;
                    return true;
                }
                if (this.a != null) {
                    this.a = e.b(this.a);
                    this.b = e.a(this.a);
                }
                this.a = false;
                return true;
            }
            this.d(n2, n3);
            this.e(n2, n3);
        } else {
            if (n3 == 50 || n2 == 1) {
                this.b = (byte)((this.b + 1) % 2);
            } else if (n3 == 56 || n2 == 6) {
                this.b = (byte)((this.b + 1) % 2);
            }
            if (ah.f(n2, n3)) {
                if (this.b == 0) {
                    this.a = true;
                } else if (this.a == null) {
                    ((bm)this).a = (byte)15;
                    ((bm)this).a = this.b.a(6);
                } else if (this.a > r.e) {
                    if (j.a) {
                        ((bm)this).a = (byte)15;
                        ((bm)this).a = ((bm)this).a.a(5);
                    } else {
                        ((ah)this).b = new bd(this);
                        ((bd)((ah)this).b).c();
                    }
                } else if (this.b > this.c) {
                    ((bm)this).a = (byte)15;
                    ((bm)this).a = this.b.a(4);
                } else {
                    bs bs2 = (bs)this.a;
                    n3 = 0;
                    for (int i2 = 0; i2 < bs2.a.length; ++i2) {
                        if (bs2.a[i2] != -2) continue;
                        n3 = 1;
                    }
                    if (n3 != 0) {
                        this.a = 15L;
                        ((bm)this).a = this.b.a(5);
                    } else {
                        ((bm)this).a = (byte)15;
                        ((bm)this).a = ((bm)this).a.a(8);
                    }
                }
            } else if (ah.g(n2, n3)) {
                m.b();
                bh.c = true;
            }
        }
        return true;
    }

    public final void a() {
        super.a();
        rpg.a.a = true;
    }

    protected final void a(cr cr2) {
        int n2;
        r.a.c();
        this.a(cr2, false, true, this.b, false);
        ah.a(cr2, 3);
        if (this.a) {
            this.a(cr2, (byte)0, false, 1, true);
            int n3 = this.g + 80;
            ah.c(cr2, this.f, n3, 16);
            this.a(cr2, this.a);
            n2 = this.g + 174 - 11;
            this.b(cr2);
            dg dg2 = this.a.a(this.d);
            if (dg2 != null) {
                this.a(cr2, this.f, n3 + 2, dg2);
            }
            cr2.b(this.f, this.g, 160, 174);
            cr2.a(3550755);
            this.d(cr2, this.f + 111, n2 + 2, r.e);
        } else {
            ah.c(cr2, this.f + 73, this.g + 15, 14, 14, 0);
            if (this.a != null) {
                this.a.a(cr2, this.f + 73, this.g + 15);
            }
            if (this.b == 0) {
                bm.b(cr2, this.f + 73, this.g + 15);
            }
            ah.c(cr2, this.f, this.g + 31, 16);
            this.a(cr2, this.f, this.g + 31 + 2, this.a);
            this.a(cr2, this.f, this.g + 31 + 2 + 80, this.b.a(1), this.c, this.b);
            this.a(cr2, this.f, this.g + 31 + 2 + 80 + 15, this.b.a(2), r.e, this.a);
            this.a(cr2, this.f + 3, this.g + 174 - 16, 154, this.b.a(3), this.b == 1);
        }
        if (this.a > 0L || ((bm)this).a > 0) {
            if (this.a == 1L) {
                int n4;
                block10: {
                    dg dg3 = this.a;
                    dg3 = (bs)dg3;
                    for (n2 = 0; n2 < ((bs)dg3).a.length && ((bs)dg3).a[n2] != -3; ++n2) {
                        if (((bs)dg3).a[n2] != -2) continue;
                        ((bs)dg3).a[n2] = -1;
                        n4 = 0;
                        break block10;
                    }
                    n4 = 5;
                }
                int n5 = n4;
                ((bm)this).a = ((bm)this).a.a(n5 + 3);
                r.a((byte)20).b((byte)20, (byte)0, this.b);
                this.c = r.a((byte)20).a((byte)20, (byte)0);
                r.e -= this.a;
                this.a = e.b(this.a);
                this.b = e.a(this.a);
                this.a = 0L;
                ((bm)this).a = (byte)15;
            } else if (this.a > 0L) {
                --this.a;
            }
            bm.a(cr2, this.f, this.g, ((bm)this).a, 1);
            this.a();
        }
    }

    private void a(cr cr2, int n2, int n3, byte[] byArray, int n4, int n5) {
        ah.c(cr2, n2 + 3, n3, 80, 14, 3550755);
        cr2.a(15723216);
        dv.a(cr2, n2 + 3 + 2, n3, byArray, 0);
        if (n5 > 0) {
            cr2.a(n4 < n5 ? 0xFF0000 : 15723216);
            ah.b(cr2, n4, n2 + 3 + 80 - 3, n3 + 2, 8, 0);
        } else {
            dv.a(cr2, n2 + 3 + 80 - 3, n3 + 2, ((bm)this).a.a(2), 0, 8);
        }
        ah.c(cr2, n2 + 3 + 80 + 2, n3, 72, 14, 3550755);
        cr2.a(15723216);
        if (n5 > 0) {
            ah.b(cr2, n5, n2 + 3 + 80 + 2 + 72 - 3, n3 + 2, 8, 0);
            return;
        }
        dv.a(cr2, n2 + 3 + 80 + 2 + 72 - 3, n3 + 2, ((bm)this).a.a(2), 0, 8);
    }
}

