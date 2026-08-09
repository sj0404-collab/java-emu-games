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

    public bn(ah ah2, byte by2, byte by3, byte by4) {
        super(ah2, by2, (byte)4, by4);
        this.i = this.a.d > 0;
        this.c = true;
        this.e = true;
        this.h = false;
        this.j = (byte)3;
        this.c();
    }

    protected final boolean a(int n2, int n3, byte by2) {
        if (ah.h(n2, n3)) {
            this.a = (this.a + by2 - 1) % by2;
            this.c = true;
        } else if (ah.i(n2, n3)) {
            this.a = (this.a + 1) % by2;
            this.c = true;
        } else if (n2 == 6 || n2 == 8 || n3 == 56 || n3 == 53) {
            this.d = 0;
            this.a = false;
        } else {
            return false;
        }
        return true;
    }

    protected final boolean b(int n2, int n3, byte by2) {
        if (ah.h(n2, n3)) {
            this.i = (byte)((this.i + by2 - 1) % by2);
        } else if (ah.i(n2, n3)) {
            this.i = (byte)((this.i + 1) % by2);
        } else if (n2 == 6 || n3 == 56) {
            this.b = false;
            this.a = true;
        } else {
            return false;
        }
        return true;
    }

    protected final void a(cr cr2, int n2, int n3, byte by2) {
        int n4;
        int n5;
        if (this.c) {
            this.b();
        }
        by2 = (byte)(by2 >> 1);
        this.a(cr2, false, true, true, false);
        int n6 = rpg.a.c - 48;
        cr2.a(0);
        cr2.a(n6, n2, 96, 16);
        if (!this.a) {
            ah.a(cr2, n6 - 4, n2 + 7, 104, 0, false);
        }
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, n2 + 1, dj.a.a(20 + this.a), 0, 1);
        cr2.a(15723216);
        cr2.e(this.f, n3 + 1, this.f + 160 - 1, n3 + 1);
        cr2.e(this.f, n3 + 120, this.f + 160 - 1, n3 + 120);
        for (n6 = 0; n6 < by2; ++n6) {
            for (n5 = 0; n5 < a; ++n5) {
                n2 = (byte)(n5 + n6 * a);
                n2 = this.a((byte)n2, true);
                this.a(cr2, this.f + 2 + n5 * 80, n3 + 10 + n6 * 29, (byte)n2, true);
            }
        }
        if (this.a != 2) {
            n6 = n3 + 1 + by2 * 30;
            cr2.a(3550755);
            cr2.a(this.f, n6, 160, 30 * (4 - by2) - 1);
            n5 = 4 - by2;
            for (n6 = 0; n6 < n5; ++n6) {
                for (n4 = 0; n4 < a; ++n4) {
                    n2 = (byte)(n4 + n6 * a);
                    n2 = this.a((byte)n2, false);
                    this.a(cr2, this.f + 2 + n4 * 80, n3 + 10 + (n6 + by2) * 29, (byte)n2, this.a((byte)n2));
                }
            }
        }
        if (this.i) {
            n6 = this.f + 160 - 30 - 1;
            n4 = this.g + 174 - 10 - 1;
            cr2.a(3550755);
            cr2.a(n6, n4, 30, 10);
            cr2.a(rpg.c.c[1], n6 + 4, n4 + 1, 20);
            ah.b(cr2, this.a.d, n6 + 30 - 4, n4 + 1, 8, 0);
        }
    }

    protected final void b(cr cr2) {
        int n2 = this.g + 13;
        if (this.a) {
            int n3 = rpg.a.c - 48;
            ah.a(cr2, n3 - 4, n2 + 5, 104, this.a ? ah.d[((ah)this).h] : 0, false);
            cr2.d(n3 + 1, n2 + 1, 93, 13);
            return;
        }
        if (this.b) {
            int n4 = this.f + 1;
            int n5 = this.g + 174 - 14 - 2;
            cr2.a(ah.d[((ah)this).h]);
            cr2.d(n4, n5, 60, 14);
            return;
        }
        int n6 = this.d / a;
        int n7 = this.d % a;
        int n8 = n7 == 0 ? 0 : 4;
        n7 = this.f + 2 + (n7 * 76 + n8);
        n2 = n2 + 16 + 10 + n6 * 29;
        bn.a(cr2, n7, n2, (byte)76, (byte)14, (byte)(this.c + 2), (byte)4, ah.d[((ah)this).h]);
    }

    protected static void a(cr cr2, int n2, int n3, byte by2, byte by3, byte by4, byte by5, int n4) {
        by2 = (byte)(n2 + (76 - by4 >> 1));
        by3 = (byte)(n3 + 14 - 1);
        cr2.a(n4);
        n4 = by4 - 1;
        cr2.e(n2, n3, n2 + 75, n3);
        cr2.e(by2, by3 + by5, by2 + n4, by3 + by5);
        for (int i2 = 0; i2 < 2; ++i2) {
            cr2.e(n2 + i2 * 75, n3, n2 + i2 * 75, by3);
            cr2.e(by2 + i2 * n4, by3, by2 + i2 * n4, by3 + by5 - 1);
        }
        cr2.e(n2, by3, by2, by3);
        cr2.e(by2 + by4, by3, n2 + 75, by3);
    }

    private void a(cr cr2, int n2, int n3, byte by2, boolean by3) {
        byte by4;
        int n4 = n2 + (76 - this.c >> 1);
        int n5 = n3 + 14;
        if (by2 == -2) {
            bn.a(cr2, n2, n3, (byte)76, (byte)14, this.c, (byte)3, 0);
            return;
        }
        cr2.a(0);
        cr2.a(n2, n3, 76, 14);
        cr2.a(n4, n5, (int)this.c, 3);
        if (by2 < 0) {
            return;
        }
        byte by5 = this.a(by2);
        if (by5 > 0) {
            by4 = this.j == 3 ? (byte)7 : 4;
            cr2.a(by3 != 0 ? 16755968 : 9531436);
            for (by3 = 0; by3 < by5; by3 = (byte)(by3 + 1)) {
                cr2.a(n4 + 1 + by3 * (by4 + 1), n5, (int)by4, 2);
            }
        } else {
            if (by5 == -1) {
                cr2.a(rpg.c.h, n2 + 38, n3 + 1, 17);
                return;
            }
            if (by5 < -1) {
                return;
            }
        }
        cr2.a(by5 > 0 ? 0xFFFFFF : 0x7F7F7F);
        by4 = this.b(by2);
        by2 = (byte)(n2 + 38);
        if (this.a == 0) {
            this.a(cr2, by4, n2 + 1, n3 + 1);
            rpg.a.a(cr2);
            by2 = (byte)(by2 + 7);
        }
        dv.a(cr2, (int)by2, n3, this.a.a(by4 << 1), 1, 1);
    }

    protected final void a(cr cr2, byte by2) {
        int n2 = this.f + 1;
        int n3 = this.g + 174 - 14 - 1;
        cr2.a(3550755);
        cr2.a(n2, n3, 60, 14);
        cr2.a(14597755);
        dv.a(cr2, n2 + 29, n3, rpg.c.b.a(4), 0);
        this.a(cr2, n2 + 8, n3 + 1, this.i + 1, by2, 4);
        ah.a(cr2, n2 + 2, n3 + 4, 56, 0xFFFFFF, false);
    }

    protected final void a(byte[][] byArray) {
        int n2 = this.a == 2 ? (this.d % 2 == 1 ? 8 : 4) : (this.d % 2 == 0 ? 8 : 4);
        ((ah)this).b = new q(this, byArray, n2);
    }

    protected final void a(byte by2, byte by3, boolean bl2, boolean bl3) {
        if (bl2) {
            by2 = (byte)(by2 - 4);
        }
        ((ah)this).b = new h(this, by2, (byte)this.a, by3, bl3 ? (byte)3 : 5);
    }

    protected byte b(byte by2) {
        return by2;
    }

    protected final boolean a(int n2, int n3, int n4, boolean bl2) {
        if (n3 == 50 || n2 == 1) {
            if (this.d == 0 || this.d == 1) {
                this.a = true;
            } else {
                this.d = (byte)(this.d - 2);
            }
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            if (this.d >= n4 - 2) {
                if (bl2) {
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

    protected final boolean a(boolean bl2, byte by2) {
        int n2;
        byte by3 = this.d < by2 ? (byte)1 : 0;
        byte by4 = (byte)(by3 != 0 ? this.d : this.d - by2);
        if ((by3 = this.a(by4, by3 != 0)) < 0) {
            return true;
        }
        by4 = this.a(by3);
        if (by4 < 0) {
            return true;
        }
        int n3 = n2 = bl2 ? 2 : 0;
        if (this.d < by2) {
            if (this.i && by4 < this.j) {
                this.a(dj.a.a(24, 28, 25));
            } else {
                this.a(dj.a.a(28, 25));
            }
        } else if (this.i && by4 < this.j) {
            if (by4 == 0) {
                this.a(dj.a.a(24, 25));
            } else {
                this.a(dj.a.a(24, n2 + 29, n2 + 30, 25));
            }
        } else if (by4 == 0) {
            this.a(by3, by4, !bl2, !bl2);
        } else {
            this.a(dj.a.a(n2 + 29, n2 + 30, 25));
        }
        return true;
    }

    protected final void a(byte by2, byte by3, byte by4, byte by5, boolean bl2) {
        if (this.d < by5) {
            if (this.i && by4 < this.j) {
                if (by2 == 0) {
                    this.c(by3);
                    return;
                }
                if (by4 > 0 && by2 == 1) {
                    r.a(this.d, bl2);
                    return;
                }
                this.a(by3, by4, bl2, bl2);
                return;
            }
            if (by2 == 0) {
                r.a(this.d, bl2);
                return;
            }
            this.a(by3, by4, bl2, bl2);
            return;
        }
        if (this.i && by4 < this.j) {
            if (by2 == 0) {
                this.c(by3);
                return;
            }
            if (by4 > 0 && (by2 == 1 || by2 == 2)) {
                r.d(by2 - 1 + (bl2 ? 0 : 2), by3);
                return;
            }
            this.a(by3, by4, bl2, bl2);
            return;
        }
        if (by2 == 0 || by2 == 1) {
            r.d(by2 + (bl2 ? 0 : 2), by3);
            return;
        }
        this.a(by3, by4, bl2, bl2);
    }

    protected final void b(byte by2, byte by3, byte by4, byte by5, boolean bl2) {
        if (this.d < by5) {
            if (this.i && by4 < this.j) {
                if (by2 == 0) {
                    this.c(by3);
                    return;
                }
                if (by2 == 1) {
                    this.d();
                    return;
                }
                this.a(by3, by4, false, bl2);
                return;
            }
            if (by2 == 0) {
                this.d();
                return;
            }
            this.a(by3, by4, false, bl2);
            return;
        }
        if (this.i && by4 < this.j) {
            if (by2 == 0) {
                this.c(by3);
                return;
            }
            if (by4 > 0 && by2 > 0 && by2 <= by5) {
                this.b((byte)(by2 - 1), by3);
                return;
            }
            this.a(by3, by4, false, bl2);
            return;
        }
        if (by2 >= 0 && by2 <= by5 - 1) {
            this.b(by2, by3);
            return;
        }
        this.a(by3, by4, false, bl2);
    }

    protected final void e() {
        this.a.d = (short)(this.a.d - 1);
        this.i = this.a.d > 0;
        this.h = true;
    }
}

