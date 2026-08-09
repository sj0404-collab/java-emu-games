/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class ay
extends bn {
    private final byte[] Z = new byte[]{2, 4, 2};

    public ay(ah ah2) {
        super(ah2, bn.b, (byte)4, bn.a);
        this.i = 0;
        byte by = r.b;
        for (byte by2 = 0; by2 < by; by2 = (byte)(by2 + 1)) {
            this.i = (byte)(this.i + (x.d(by2) ? 4 : 2));
        }
        this.i = (byte)(this.i / 4);
    }

    final boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (ah.g(n, n2)) {
            ay ay2 = this;
            if (ay2.h) {
                ay2.a.c();
                ay2.a.k();
                ay2.h = false;
            }
            ((ah)this).a.d = (byte)5;
            ((ah)this).a.g();
            return true;
        }
        if (this.a) {
            if ((n == 1 || n2 == 50) && this.a == 1) {
                this.a = false;
                this.b = true;
            } else if (!this.a(n, n2, (byte)3)) {
                return true;
            }
            return true;
        }
        if (this.b) {
            if (n == 1 || n == 8 || n2 == 50 || n2 == 53) {
                this.d = (byte)(bn.a[this.a] - 2);
                this.b = false;
            } else {
                this.b(n, n2, (byte)5);
            }
            return true;
        }
        if (ah.f(n, n2)) {
            if (this.a == 2) {
                ay ay3 = this;
                n2 = ay3.a(ay3.d, false);
                byte by = r.a.a(n2);
                if (ay3.i && by < ay3.j) {
                    ay3.a(dj.a.a(24, 25));
                } else {
                    ay3.a(n2, by, true, true);
                }
                return true;
            }
            if (this.a == 0) {
                return this.a(false, this.Z[this.a]);
            }
            ay ay4 = this;
            n2 = ay4.d < ay4.Z[ay4.a] ? 1 : 0;
            byte by = (byte)(n2 != 0 ? ay4.d : ay4.d - ay4.Z[ay4.a]);
            byte by2 = ay4.a(by, n2 != 0);
            n2 = by2;
            if (by2 >= 0 && (by = ay4.a.b(n2)) >= 0) {
                if (ay4.d < ay4.Z[ay4.a]) {
                    if (ay4.i && by < ay4.j) {
                        ay4.a(dj.a.a(24, 28, 25));
                    } else {
                        ay4.a(dj.a.a(28, 25));
                    }
                } else if (ay4.i && by < ay4.j) {
                    if (by == 0) {
                        ay4.a(dj.a.a(24, 25));
                    } else {
                        ay4.a(dj.a.a(new int[]{24, 33, 34, 35, 36, 25}));
                    }
                } else if (by == 0) {
                    ay4.a(n2, by, false, true);
                } else {
                    ay4.a(dj.a.a(new int[]{33, 34, 35, 36, 25}));
                }
            }
            return true;
        }
        if (this.a(n, n2, (int)bn.a[this.a], this.a == 1)) {
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
            if (this.a == 2) {
                by = this.a(this.d, false);
                if (by2 == 0) {
                    this.c(by);
                    return;
                }
                this.a(by, this.a.a(by), true, true);
                return;
            }
            by = this.d < this.Z[this.a] ? (byte)1 : 0;
            byte by3 = this.d;
            if (by == 0) {
                by3 = (byte)(by3 - this.Z[this.a]);
            }
            by = this.a(by3, by != 0);
            if (this.a == 0) {
                by3 = r.a.a(by);
                this.a(by2, by, by3, this.Z[this.a], true);
                return;
            }
            by3 = this.a.b(by);
            this.b(by2, by, by3, this.Z[this.a], true);
        }
    }

    protected final void c(byte by) {
        this.e();
        if (this.a != 1) {
            r.a.a(r.b, by);
            return;
        }
        r.a.a((int)by);
    }

    protected final void a(cr cr2) {
        int n = this.g + 13;
        int n2 = n + 16;
        this.a(cr2, n, n2, this.Z[this.a]);
        if (this.a == 0) {
            for (n = 0; n < 2; ++n) {
                if (r.b[n] <= 0) continue;
                ah.b(cr2, 1 + (n << 1), this.f + 1 + n * 80, n2 + 10, 4, 0);
            }
        }
        if (this.a == 2) {
            for (n = 1; n < 4; ++n) {
                for (int i = 0; i < bn.a; ++i) {
                    int n3 = n2 + 10 + n * 29;
                    int n4 = this.f + 2 + i * 80;
                    cr cr3 = cr2;
                    ay ay2 = this;
                    bn.a(cr3, n4, n3, (byte)76, (byte)14, ay2.c, (byte)3, 15723216);
                }
            }
        }
        if (this.a == 1) {
            this.a(cr2, (byte)5);
        }
    }

    final boolean a(byte by) {
        if (this.a == 0) {
            return r.a(by, true);
        }
        return this.a.c(by);
    }

    final byte a(byte by) {
        if (this.a == 1) {
            return this.a.b(by);
        }
        return this.a.a(by);
    }

    /*
     * WARNING - void declaration
     */
    final byte a(byte by, boolean bl) {
        void var2_8;
        if (bl && this.a != 2) {
            return this.b[by];
        }
        byte by2 = by;
        switch (this.a) {
            case 0: {
                byte by3 = (byte)(by + 4);
                break;
            }
            case 1: {
                int n = bn.a[this.a] - this.Z[this.a];
                byte by4 = (byte)(by + this.i * n);
                break;
            }
            case 2: {
                byte by5 = (byte)(by + 10);
            }
        }
        return (byte)var2_8;
    }

    protected final byte b(byte by) {
        if (this.a != 1) {
            by = (byte)(by - 4);
        }
        return by;
    }

    protected final void b() {
        this.e = bn.b = bn.a[this.a];
        this.g = (byte)4;
        this.b = this.a == 0 ? r.b : this.a.a;
        this.a = this.a == 1 ? dj.c : dj.b;
        this.c = false;
    }

    final void c() {
        dj.b = new cx("/t/s" + r.b);
        dj.c = new cx("/t/ps");
    }

    protected final void b(byte by, byte by2) {
        this.a.a((int)by, by2);
        this.h = true;
    }

    protected final void d() {
        this.a.h((int)this.d);
        this.h = true;
    }

    protected final void a(cr cr2, byte by, int n, int n2) {
        bh.a(by + 4, n, n2);
    }
}
