/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class da
extends bm {
    private byte b;
    private byte[] b;
    private byte c = 1;
    private byte i = 0;
    private byte j = 0;
    private static bp[] a = new bp[2];
    private boolean a;
    private dg a = null;
    private cx b = new cx("/t/ni");

    public da(ah ah2) {
        super(ah2);
        this.b();
        da.a[1] = r.a((byte)0);
        this.a = false;
    }

    private void b() {
        this.b = 0;
        this.a();
        ((ah)this).b = new bk(this, this.b.a(0), this.b.a(1, 2));
    }

    public final void a() {
        super.a();
        rpg.a.a = true;
    }

    private void c() {
        this.b = this.b.a(3 + this.c);
    }

    private static void a(byte by2, int n2) {
        for (int i2 = 0; i2 <= n2; ++i2) {
            a[0].a(dg.a(by2, (byte)i2), 1);
        }
    }

    private void d() {
        da.a[0] = null;
        da.a[0] = new bp(28);
        switch (this.c) {
            case 0: {
                this.j = (byte)5;
                if (this.i > this.j) {
                    this.i = (byte)(this.j - 1);
                }
                if (this.i == 0) {
                    da.a((byte)0, 13);
                    da.a((byte)1, 13);
                    return;
                }
                if (this.i == 1) {
                    da.a((byte)2, 13);
                    da.a((byte)3, 13);
                    return;
                }
                if (this.i == 2) {
                    da.a((byte)4, 13);
                    return;
                }
                if (this.i == 3) {
                    da.a((byte)5, 13);
                    return;
                }
                da.a((byte)6, 13);
                return;
            }
            case 1: {
                this.j = (byte)5;
                if (this.i > this.j) {
                    this.i = (byte)(this.j - 1);
                }
                if (this.i == 0) {
                    da.a((byte)10, 13);
                    return;
                }
                if (this.i == 1) {
                    da.a((byte)12, 13);
                    da.a((byte)13, 13);
                    return;
                }
                if (this.i == 2) {
                    da.a((byte)8, 13);
                    da.a((byte)9, 13);
                    return;
                }
                if (this.i == 3) {
                    da.a((byte)14, 13);
                    da.a((byte)15, 13);
                    return;
                }
                da.a((byte)7, 13);
                return;
            }
            case 2: {
                this.j = (byte)3;
                if (this.i > this.j) {
                    this.i = (byte)(this.j - 1);
                }
                if (this.i == 0) {
                    da.a((byte)20, 8);
                    return;
                }
                if (this.i == 1) {
                    da.a((byte)16, 11);
                    return;
                }
                da.a((byte)17, 15);
                return;
            }
            case 3: {
                this.j = (byte)3;
                if (this.i > this.j) {
                    this.i = (byte)(this.j - 1);
                }
                if (this.i == 0) {
                    da.a[1] = r.a((byte)0);
                    return;
                }
                if (this.i == 1) {
                    da.a[1] = r.a((byte)18);
                    return;
                }
                da.a[1] = r.a((byte)19);
            }
        }
    }

    private void a(dg dg2, byte by2) {
        dg2 = dg.a(dg2.g, dg2.h);
        if (r.a(dg2.g).a(dg2, (int)by2) <= 0) {
            ((bm)this).a = (byte)15;
            ((bm)this).a = ((bm)this).a.a(6);
            return;
        }
        ((bm)this).a = (byte)15;
        ((bm)this).a = this.b.a(21);
        r.e(0 - dg2.a * by2);
    }

    final void a(byte by2, byte by3) {
        this.g();
        this.a();
        if (by2 == -1 && by3 == -1) {
            ((bm)this).a = (byte)15;
            ((bm)this).a = this.b.a(20);
            return;
        }
        if (by2 == -2 && by3 == -2) {
            by3 = 0;
        }
        if (this.b == 0) {
            this.b = 1;
            this.a = false;
            this.i = 0;
            this.d = 0;
            this.c = by3 == 0 ? (byte)0 : (byte)3;
            this.c();
            this.d();
            return;
        }
        if (this.b == 2) {
            if (by3 == 0) {
                if (this.c < 3) {
                    if (r.e < this.a.a) {
                        if (j.a) {
                            ((bm)this).a = (byte)15;
                            ((bm)this).a = this.b.a(20);
                        } else {
                            ((ah)this).b = new bd(this);
                            ((bd)((ah)this).b).c();
                        }
                    } else if (this.a.g == 20) {
                        ((ah)this).b = new cm(this, 99, 1, this.a.a, true, ((bm)this).a.a(7));
                        this.b = (byte)3;
                    } else {
                        this.a(this.a, (byte)1);
                    }
                } else {
                    if (this.a.i > 1) {
                        ((ah)this).b = new cm(this, this.a.i, 1, this.a.a / 10, false, ((bm)this).a.a(7));
                        this.b = (byte)3;
                    } else {
                        r.a(this.a.g).b(this.a.g, this.a.h, 1);
                        r.e(this.a.a / 10);
                        ((bm)this).a = (byte)15;
                        ((bm)this).a = this.b.a(22);
                    }
                    if (this.a.g == 20) {
                        bh.d = true;
                    }
                }
                this.a();
            }
            return;
        }
        if (this.b == 3) {
            if (by3 > 0) {
                if (this.c < 3) {
                    this.a(this.a, by3);
                } else {
                    r.a(this.a.g).b(this.a.g, this.a.h, by3);
                    while (by3 > 0) {
                        r.e(this.a.a / 10);
                        by3 = (byte)(by3 - 1);
                    }
                    ((bm)this).a = (byte)15;
                    ((bm)this).a = this.b.a(22);
                }
                bh.d = true;
                this.a();
            }
            return;
        }
        m.b();
        this.a();
    }

    final boolean a(int n2, int n3) {
        if (((bm)this).a > 0) {
            ((bm)this).a = 0;
            ((bm)this).a = null;
            bh.c = true;
            return true;
        }
        if (ah.g(n2, n3)) {
            bh.c = true;
            if (this.b == 0) {
                if (((ah)this).a != null) {
                    ((ah)this).a.g();
                    return true;
                }
                m.b();
                this.a();
                return true;
            }
            if (this.b == 2 || this.b == 3) {
                if (((ah)this).b != null && ((ah)this).b instanceof bd && this.b(n2, n3)) {
                    return true;
                }
                this.b = 1;
                this.g();
                return true;
            }
        }
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
            this.b();
            this.a();
            return true;
        }
        if (n3 == 49) {
            if (this.c < 3) {
                this.c = (byte)((this.c + 3 - 1) % 3);
            }
            this.d();
            this.c();
            return true;
        }
        if (n3 == 51) {
            if (this.c < 3) {
                this.c = (byte)((this.c + 1) % 3);
            }
            this.d();
            this.c();
            return true;
        }
        if (this.a) {
            if (ah.i(n2, n3)) {
                this.a = false;
            } else if (n2 == 1 || n3 == 50) {
                this.i = (byte)((this.i + this.j - 1) % this.j);
                this.d();
            } else if (n2 == 6 || n3 == 56) {
                this.i = (byte)((this.i + 1) % this.j);
                this.d();
            }
        } else {
            if (ah.f(n2, n3)) {
                this.a = a[this.c < 3 ? 0 : 1].a(this.d);
                if (this.a == null) {
                    return true;
                }
                if (this.a.c()) {
                    ((bm)this).a = (byte)15;
                    ((bm)this).a = this.b.a(23);
                    this.a();
                } else {
                    byte[][] byArrayArray = new byte[2][];
                    byte[][] byArrayArray2 = byArrayArray;
                    byArrayArray[0] = rpg.b.m;
                    byArrayArray2[1] = rpg.b.n;
                    byte[] byArray = this.b.a(this.c < 3 ? 18 : 19);
                    if (this.c < 3 && this.a instanceof bs && !w.a(this.a)) {
                        byArray = rpg.f.a(rpg.b.J, byArray);
                    }
                    ((ah)this).b = new bk(this, byArray, byArrayArray2);
                    this.b = (byte)2;
                    this.a();
                }
                bh.c = true;
                return true;
            }
            this.e(n2, n3);
            if (this.d % this.f == 0 && this.j > 1 && ah.h(n2, n3)) {
                this.a = true;
                return true;
            }
            this.d(n2, n3);
        }
        return true;
    }

    protected final void a(cr cr2) {
        r.a.c();
        ah.a(cr2, 3);
        if (this.b == 0) {
            return;
        }
        this.a(cr2, false, true, this.b, this.c < 3);
        if (this.c < 3) {
            this.a(cr2, this.j, this.i, this.a);
        } else {
            this.a(cr2, this.i, this.a, (int)this.j, true);
        }
        int n2 = this.g + 80;
        int n3 = this.f + 8;
        ah.c(cr2, this.f, n2, 16);
        this.a(cr2, a[this.c < 3 ? 0 : 1]);
        int n4 = this.g + 174 - 11;
        dg dg2 = a[this.c < 3 ? 0 : 1].a(this.d);
        if (!this.a) {
            this.b(cr2);
        }
        if (dg2 != null) {
            this.a(cr2, this.f, n2 + 2, dg2);
        }
        cr2.a(3550755);
        cr2.a(n3, n4, 55, 11);
        cr2.a(n3 + 1, n4 - 1, 53, 1);
        if (dg2 != null) {
            this.d(cr2, n3 + 55 - 4, n4 + 2, this.c >= 3 ? dg2.a / 10 : dg2.a);
        }
        cr2.b(this.f, this.g, 160, 174);
        cr2.a(3550755);
        this.d(cr2, this.f + 111, n4 + 2, r.e);
        if (((bm)this).a > 0) {
            bm.a(cr2, this.f, this.g, ((bm)this).a, 1);
            this.a();
        }
    }
}

