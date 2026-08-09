/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
abstract class bn
extends ae {
    protected static final byte[] a = new byte[]{8, 8, 2};
    protected static byte a = (byte)2;
    protected static byte b = (byte)(4 * a);
    protected byte c;
    protected int a;
    protected boolean a;
    protected boolean b;
    protected boolean c = (byte)25;
    protected byte i;
    protected cx a;
    protected boolean h;
    protected boolean i;
    protected byte[] b = false;
    protected byte j;
    protected x a = r.a;

    abstract void c();

    abstract void b();

    abstract byte a(byte var1, boolean var2);

    abstract byte a(byte var1);

    abstract boolean a(byte var1);

    protected abstract void c(byte var1);

    protected abstract void b(byte var1, byte var2);

    protected abstract void d();

    protected abstract void a(cr var1, byte var2, int var3, int var4);

    public bn(ah ah2, byte by, byte by2, byte by3) {
        super(ah2, by, (byte)4, by3);
        this.i = this.a.d > 0;
        this.c = true;
        this.e = true;
        this.h = false;
        this.j = (byte)3;
        this.c();
    }

    protected final boolean a(int n, int n2, byte by) {
        if (ah.h(n, n2)) {
            this.a = (this.a + by - 1) % by;
            this.c = true;
        } else if (ah.i(n, n2)) {
            this.a = (this.a + 1) % by;
            this.c = true;
        } else if (n == 6 || n == 8 || n2 == 56 || n2 == 53) {
            this.d = 0;
            this.a = false;
        } else {
            return false;
        }
        return true;
    }

    protected final boolean b(int n, int n2, byte by) {
        if (ah.h(n, n2)) {
            this.i = (byte)((this.i + by - 1) % by);
        } else if (ah.i(n, n2)) {
            this.i = (byte)((this.i + 1) % by);
        } else if (n == 6 || n2 == 56) {
            this.b = false;
            this.a = true;
        } else {
            return false;
        }
        return true;
    }

    protected final void a(cr cr2, int n, int n2, byte by) {
        int n3;
        int n4;
        if (this.c) {
            this.b();
        }
        by = (byte)(by >> 1);
        this.a(cr2, false, true, true, false);
        int n5 = rpg.a.c - 48;
        cr2.a(0);
        cr2.a(n5, n, 96, 16);
        if (!this.a) {
            ah.a(cr2, n5 - 4, n + 7, 104, 0, false);
        }
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, n + 1, dj.a.a(20 + this.a), 0, 1);
        cr2.a(15723216);
        cr2.e(this.f, n2 + 1, this.f + 160 - 1, n2 + 1);
        cr2.e(this.f, n2 + 120, this.f + 160 - 1, n2 + 120);
        for (n5 = 0; n5 < by; ++n5) {
            for (n4 = 0; n4 < a; ++n4) {
                n = (byte)(n4 + n5 * a);
                n = this.a((byte)n, true);
                this.a(cr2, this.f + 2 + n4 * 80, n2 + 10 + n5 * 29, (byte)n, true);
            }
        }
        if (this.a != 2) {
            n5 = n2 + 1 + by * 30;
            cr2.a(3550755);
            cr2.a(this.f, n5, 160, 30 * (4 - by) - 1);
            n4 = 4 - by;
            for (n5 = 0; n5 < n4; ++n5) {
                for (n3 = 0; n3 < a; ++n3) {
                    n = (byte)(n3 + n5 * a);
                    n = this.a((byte)n, false);
                    this.a(cr2, this.f + 2 + n3 * 80, n2 + 10 + (n5 + by) * 29, (byte)n, this.a((byte)n));
                }
            }
        }
        if (this.i) {
            n5 = this.f + 160 - 30 - 1;
            n3 = this.g + 174 - 10 - 1;
            cr2.a(3550755);
            cr2.a(n5, n3, 30, 10);
            cr2.a(rpg.c.c[1], n5 + 4, n3 + 1, 20);
            ah.b(cr2, this.a.d, n5 + 30 - 4, n3 + 1, 8, 0);
        }
    }

    protected final void b(cr cr2) {
        int n = this.g + 13;
        if (this.a) {
            int n2 = rpg.a.c - 48;
            ah.a(cr2, n2 - 4, n + 5, 104, this.a ? ah.d[((ah)this).h] : 0, false);
            cr2.d(n2 + 1, n + 1, 93, 13);
            return;
        }
        if (this.b) {
            int n3 = this.f + 1;
            int n4 = this.g + 174 - 14 - 2;
            cr2.a(ah.d[((ah)this).h]);
            cr2.d(n3, n4, 60, 14);
            return;
        }
        int n5 = this.d / a;
        int n6 = this.d % a;
        int n7 = n6 == 0 ? 0 : 4;
        n6 = this.f + 2 + (n6 * 76 + n7);
        n = n + 16 + 10 + n5 * 29;
        bn.a(cr2, n6, n, (byte)76, (byte)14, (byte)(this.c + 2), (byte)4, ah.d[((ah)this).h]);
    }

    protected static void a(cr cr2, int n, int n2, byte by, byte by2, byte by3, byte by4, int n3) {
        by = (byte)(n + (76 - by3 >> 1));
        by2 = (byte)(n2 + 14 - 1);
        cr2.a(n3);
        n3 = by3 - 1;
        cr2.e(n, n2, n + 75, n2);
        cr2.e(by, by2 + by4, by + n3, by2 + by4);
        for (int i = 0; i < 2; ++i) {
            cr2.e(n + i * 75, n2, n + i * 75, by2);
            cr2.e(by + i * n3, by2, by + i * n3, by2 + by4 - 1);
        }
        cr2.e(n, by2, by, by2);
        cr2.e(by + by3, by2, n + 75, by2);
    }

    private void a(cr cr2, int n, int n2, byte by, boolean by2) {
        byte by3;
        int n3 = n + (76 - this.c >> 1);
        int n4 = n2 + 14;
        if (by == -2) {
            bn.a(cr2, n, n2, (byte)76, (byte)14, this.c, (byte)3, 0);
            return;
        }
        cr2.a(0);
        cr2.a(n, n2, 76, 14);
        cr2.a(n3, n4, (int)this.c, 3);
        if (by < 0) {
            return;
        }
        byte by4 = this.a(by);
        if (by4 > 0) {
            by3 = this.j == 3 ? (byte)7 : 4;
            cr2.a(by2 != 0 ? 16755968 : 9531436);
            for (by2 = 0; by2 < by4; by2 = (byte)(by2 + 1)) {
                cr2.a(n3 + 1 + by2 * (by3 + 1), n4, (int)by3, 2);
            }
        } else {
            if (by4 == -1) {
                cr2.a(rpg.c.h, n + 38, n2 + 1, 17);
                return;
            }
            if (by4 < -1) {
                return;
            }
        }
        cr2.a(by4 > 0 ? 0xFFFFFF : 0x7F7F7F);
        by3 = this.b(by);
        by = (byte)(n + 38);
        if (this.a == 0) {
            this.a(cr2, by3, n + 1, n2 + 1);
            rpg.a.a(cr2);
            by = (byte)(by + 7);
        }
        dv.a(cr2, (int)by, n2, this.a.a(by3 << 1), 1, 1);
    }

    protected final void a(cr cr2, byte by) {
        int n = this.f + 1;
        int n2 = this.g + 174 - 14 - 1;
        cr2.a(3550755);
        cr2.a(n, n2, 60, 14);
        cr2.a(14597755);
        dv.a(cr2, n + 29, n2, rpg.c.b.a(4), 0);
        this.a(cr2, n + 8, n2 + 1, this.i + 1, by, 4);
        ah.a(cr2, n + 2, n2 + 4, 56, 0xFFFFFF, false);
    }

    protected final void a(byte[][] byArray) {
        int n = this.a == 2 ? (this.d % 2 == 1 ? 8 : 4) : (this.d % 2 == 0 ? 8 : 4);
        ((ah)this).b = new q(this, byArray, n);
    }

    protected final void a(byte by, byte by2, boolean bl, boolean bl2) {
        if (bl) {
            by = (byte)(by - 4);
        }
        ((ah)this).b = new h(this, by, (byte)this.a, by2, bl2 ? (byte)3 : 5);
    }

    protected byte b(byte by) {
        return by;
    }

    protected final boolean a(int n, int n2, int n3, boolean bl) {
        if (n2 == 50 || n == 1) {
            if (this.d == 0 || this.d == 1) {
                this.a = true;
            } else {
                this.d = (byte)(this.d - 2);
            }
            return true;
        }
        if (n2 == 56 || n == 6) {
            if (this.d >= n3 - 2) {
                if (bl) {
                    this.b = true;
                } else {
                    this.a = true;
                }
            } else {
                this.d = (byte)(this.d + a);
            }
            return true;
        }
        return false;
    }

    protected final boolean a(boolean bl, byte by) {
        int n;
        byte by2 = this.d < by ? (byte)1 : 0;
        byte by3 = (byte)(by2 != 0 ? this.d : this.d - by);
        if ((by2 = this.a(by3, by2 != 0)) < 0) {
            return true;
        }
        by3 = this.a(by2);
        if (by3 < 0) {
            return true;
        }
        int n2 = n = bl ? 2 : 0;
        if (this.d < by) {
            if (this.i && by3 < this.j) {
                this.a(dj.a.a(24, 28, 25));
            } else {
                this.a(dj.a.a(28, 25));
            }
        } else if (this.i && by3 < this.j) {
            if (by3 == 0) {
                this.a(dj.a.a(24, 25));
            } else {
                this.a(dj.a.a(24, n + 29, n + 30, 25));
            }
        } else if (by3 == 0) {
            this.a(by2, by3, !bl, !bl);
        } else {
            this.a(dj.a.a(n + 29, n + 30, 25));
        }
        return true;
    }

    protected final void a(byte by, byte by2, byte by3, byte by4, boolean bl) {
        if (this.d < by4) {
            if (this.i && by3 < this.j) {
                if (by == 0) {
                    this.c(by2);
                    return;
                }
                if (by3 > 0 && by == 1) {
                    r.a(this.d, bl);
                    return;
                }
                this.a(by2, by3, bl, bl);
                return;
            }
            if (by == 0) {
                r.a(this.d, bl);
                return;
            }
            this.a(by2, by3, bl, bl);
            return;
        }
        if (this.i && by3 < this.j) {
            if (by == 0) {
                this.c(by2);
                return;
            }
            if (by3 > 0 && (by == 1 || by == 2)) {
                r.d(by - 1 + (bl ? 0 : 2), by2);
                return;
            }
            this.a(by2, by3, bl, bl);
            return;
        }
        if (by == 0 || by == 1) {
            r.d(by + (bl ? 0 : 2), by2);
            return;
        }
        this.a(by2, by3, bl, bl);
    }

    protected final void b(byte by, byte by2, byte by3, byte by4, boolean bl) {
        if (this.d < by4) {
            if (this.i && by3 < this.j) {
                if (by == 0) {
                    this.c(by2);
                    return;
                }
                if (by == 1) {
                    this.d();
                    return;
                }
                this.a(by2, by3, false, bl);
                return;
            }
            if (by == 0) {
                this.d();
                return;
            }
            this.a(by2, by3, false, bl);
            return;
        }
        if (this.i && by3 < this.j) {
            if (by == 0) {
                this.c(by2);
                return;
            }
            if (by3 > 0 && by > 0 && by <= by4) {
                this.b((byte)(by - 1), by2);
                return;
            }
            this.a(by2, by3, false, bl);
            return;
        }
        if (by >= 0 && by <= by4 - 1) {
            this.b(by, by2);
            return;
        }
        this.a(by2, by3, false, bl);
    }

    protected final void e() {
        this.a.d = (short)(this.a.d - 1);
        this.i = this.a.d > 0;
        this.h = true;
    }
}
