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
        byte by2 = r.b;
        for (byte by3 = 0; by3 < by2; by3 = (byte)(by3 + 1)) {
            this.i = (byte)(this.i + (x.d(by3) ? 4 : 2));
        }
        this.i = (byte)(this.i / 4);
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
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
            if ((n2 == 1 || n3 == 50) && this.a == 1) {
                this.a = false;
                this.b = true;
            } else if (!this.a(n2, n3, (byte)3)) {
                return true;
            }
            return true;
        }
        if (this.b) {
            if (n2 == 1 || n2 == 8 || n3 == 50 || n3 == 53) {
                this.d = (byte)(bn.a[this.a] - 2);
                this.b = false;
            } else {
                this.b(n2, n3, (byte)5);
            }
            return true;
        }
        if (ah.f(n2, n3)) {
            if (this.a == 2) {
                ay ay3 = this;
                n3 = ay3.a(ay3.d, false);
                byte by2 = r.a.a(n3);
                if (ay3.i && by2 < ay3.j) {
                    ay3.a(dj.a.a(24, 25));
                } else {
                    ay3.a(n3, by2, true, true);
                }
                return true;
            }
            if (this.a == 0) {
                return this.a(false, this.Z[this.a]);
            }
            ay ay4 = this;
            n3 = ay4.d < ay4.Z[ay4.a] ? 1 : 0;
            byte by3 = (byte)(n3 != 0 ? ay4.d : ay4.d - ay4.Z[ay4.a]);
            byte by4 = ay4.a(by3, n3 != 0);
            n3 = by4;
            if (by4 >= 0 && (by3 = ay4.a.b(n3)) >= 0) {
                if (ay4.d < ay4.Z[ay4.a]) {
                    if (ay4.i && by3 < ay4.j) {
                        ay4.a(dj.a.a(24, 28, 25));
                    } else {
                        ay4.a(dj.a.a(28, 25));
                    }
                } else if (ay4.i && by3 < ay4.j) {
                    if (by3 == 0) {
                        ay4.a(dj.a.a(24, 25));
                    } else {
                        ay4.a(dj.a.a(new int[]{24, 33, 34, 35, 36, 25}));
                    }
                } else if (by3 == 0) {
                    ay4.a(n3, by3, false, true);
                } else {
                    ay4.a(dj.a.a(new int[]{33, 34, 35, 36, 25}));
                }
            }
            return true;
        }
        if (this.a(n2, n3, (int)bn.a[this.a], this.a == 1)) {
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
            if (this.a == 2) {
                by2 = this.a(this.d, false);
                if (by3 == 0) {
                    this.c(by2);
                    return;
                }
                this.a(by2, this.a.a(by2), true, true);
                return;
            }
            by2 = this.d < this.Z[this.a] ? (byte)1 : 0;
            byte by4 = this.d;
            if (by2 == 0) {
                by4 = (byte)(by4 - this.Z[this.a]);
            }
            by2 = this.a(by4, by2 != 0);
            if (this.a == 0) {
                by4 = r.a.a(by2);
                this.a(by3, by2, by4, this.Z[this.a], true);
                return;
            }
            by4 = this.a.b(by2);
            this.b(by3, by2, by4, this.Z[this.a], true);
        }
    }

    protected final void c(byte by2) {
        this.e();
        if (this.a != 1) {
            r.a.a(r.b, by2);
            return;
        }
        r.a.a((int)by2);
    }

    protected final void a(cr cr2) {
        int n2 = this.g + 13;
        int n3 = n2 + 16;
        this.a(cr2, n2, n3, this.Z[this.a]);
        if (this.a == 0) {
            for (n2 = 0; n2 < 2; ++n2) {
                if (r.b[n2] <= 0) continue;
                ah.b(cr2, 1 + (n2 << 1), this.f + 1 + n2 * 80, n3 + 10, 4, 0);
            }
        }
        if (this.a == 2) {
            for (n2 = 1; n2 < 4; ++n2) {
                for (int i2 = 0; i2 < bn.a; ++i2) {
                    int n4 = n3 + 10 + n2 * 29;
                    int n5 = this.f + 2 + i2 * 80;
                    cr cr3 = cr2;
                    ay ay2 = this;
                    bn.a(cr3, n5, n4, (byte)76, (byte)14, ay2.c, (byte)3, 15723216);
                }
            }
        }
        if (this.a == 1) {
            this.a(cr2, (byte)5);
        }
    }

    final boolean a(byte by2) {
        if (this.a == 0) {
            return r.a(by2, true);
        }
        return this.a.c(by2);
    }

    final byte a(byte by2) {
        if (this.a == 1) {
            return this.a.b(by2);
        }
        return this.a.a(by2);
    }

    /*
     * WARNING - void declaration
     */
    final byte a(byte by2, boolean bl2) {
        void var2_8;
        if (bl2 && this.a != 2) {
            return this.b[by2];
        }
        byte by3 = by2;
        switch (this.a) {
            case 0: {
                byte by4 = (byte)(by2 + 4);
                break;
            }
            case 1: {
                int n2 = bn.a[this.a] - this.Z[this.a];
                byte by5 = (byte)(by2 + this.i * n2);
                break;
            }
            case 2: {
                byte by6 = (byte)(by2 + 10);
            }
        }
        return (byte)var2_8;
    }

    protected final byte b(byte by2) {
        if (this.a != 1) {
            by2 = (byte)(by2 - 4);
        }
        return by2;
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

    protected final void b(byte by2, byte by3) {
        this.a.a((int)by2, by3);
        this.h = true;
    }

    protected final void d() {
        this.a.h((int)this.d);
        this.h = true;
    }

    protected final void a(cr cr2, byte by2, int n2, int n3) {
        bh.a(by2 + 4, n2, n3);
    }
}

