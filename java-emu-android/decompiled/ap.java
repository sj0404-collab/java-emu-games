/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class ap
extends n {
    private byte a;
    private boolean c = true;
    private byte[] Z = new byte[9];
    private int a = 0;

    public ap(ah ah2) {
        super(ah2, (byte)2, (byte)2, (byte)1);
        this.d = 0;
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
            if (this.c) {
                ((ah)this).a.g();
            } else {
                this.g = (byte)2;
                ((ah)this).e = (byte)2;
                this.d = this.a;
                this.c = true;
            }
            return true;
        }
        if (ah.f(n2, n3)) {
            if (this.c) {
                this.a = this.d;
                this.d = this.Z[this.a];
                this.g = (byte)10;
                ((ah)this).e = (byte)10;
                this.c = false;
            } else {
                ap ap2 = this;
                n3 = 0;
                for (int i2 = ap2.Z.length - 1; i2 >= 0; --i2) {
                    n3 = n3 * 10 + ap2.Z[i2];
                }
                int n4 = n3;
                if (n4 != 0) {
                    if (this.a == 0) {
                        n3 = n4 <= r.e ? 1 : 0;
                    } else {
                        n3 = n4 <= n.b ? 1 : 0;
                        n4 = 0 - n4;
                    }
                    if (n3 == 0) {
                        this.a(rpg.c.h.a(25));
                    } else {
                        r.e -= n4;
                        r.l();
                        n.b += n4;
                        n.e();
                    }
                }
            }
            return true;
        }
        if (!this.c) {
            if (n3 == 52 || n2 == 2) {
                ++this.a;
                if (this.a > 8) {
                    this.a = 0;
                }
                this.d = this.Z[this.a];
                return true;
            }
            if (n3 == 54 || n2 == 5) {
                --this.a;
                if (this.a < 0) {
                    this.a = 8;
                }
                this.d = this.Z[this.a];
                return true;
            }
        }
        return this.e(n2, n3);
    }

    protected final boolean e(int n2, int n3) {
        if (this.c) {
            return super.e(n2, n3);
        }
        if (n3 == 50 || n2 == 1) {
            this.a((byte)4);
            this.Z[this.a] = this.d;
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            this.a((byte)3);
            this.Z[this.a] = this.d;
            return true;
        }
        return false;
    }

    protected final void a(cr cr2) {
        int n2;
        this.a(cr2, rpg.c.h.a(0), true, false);
        int n3 = 0;
        for (n2 = 0; n2 < 2; n2 = (int)((byte)(n2 + 1))) {
            boolean bl2 = this.c ? this.d == n2 : this.a == n2;
            n3 = this.g + 25 + n2 * 24;
            ah.a(cr2, this.f + 3, n3, 154, 18, bl2 ? 0x660000 : 3550755, bl2 ? 0xBD0000 : 7027456);
            cr2.a(bl2 ? 0xFFFFFF : 12630160);
            dv.a(cr2, rpg.a.c, n3, rpg.c.h.a(n2 + 20), 0, 1);
        }
        ah.a(cr2, this.Z, this.f + 14, n3 + 25, 7);
        if (!this.c) {
            ah.a(cr2, this.f + 8, n3 + 21 + 7, 123, 3550755, false);
            n2 = this.f + 16 + (8 - this.a) * 7;
            ah.e(cr2, n2, n3 + 15 + 6, 12);
        }
        cr2.a(0xFF0000);
        ah.d(cr2, this.f + 78 + 18, n3 + 15 + 7, 27, 14);
        cr2.a(0xFFFFFF);
        if (this.c) {
            if (this.d == 0) {
                dv.a(cr2, this.f + 80 + 18, n3 + 15 + 7, rpg.c.h.a(48), 0);
            } else {
                dv.a(cr2, this.f + 80 + 18, n3 + 15 + 7, rpg.c.h.a(49), 0);
            }
        } else if (this.a == 0) {
            dv.a(cr2, this.f + 80 + 18, n3 + 15 + 7, rpg.c.h.a(48), 0);
        } else {
            dv.a(cr2, this.f + 80 + 18, n3 + 15 + 7, rpg.c.h.a(49), 0);
        }
        cr2.a(15723216);
        cr2.e(this.f, n3 + 30 + 10, this.f + 160 - 1, n3 + 30 + 10);
        cr2.a(3550755);
        ah.d(cr2, this.f + 3, n3 + 33 + 10, 154, 73);
        n2 = this.c ? (this.d == 0 ? 1 : 0) : (this.a == 0 ? 1 : 0);
        cr2.a(n2 != 0 ? 9032496 : 12630160);
        dv.a(cr2, rpg.a.c, n3 + 34 + 10 + 5, rpg.c.h.a(23), 0, 1);
        ah.e(cr2, n.b, this.f + 28 + 20, n3 + 47 + 10 + 10, 7);
        cr2.a(n2 != 0 ? 12630160 : 9032496);
        dv.a(cr2, rpg.a.c, n3 + 63 + 10 + 15, rpg.c.h.a(24), 0, 1);
        ah.e(cr2, r.e, this.f + 28 + 20, n3 + 76 + 10 + 20, 7);
        cr2.a(0);
        ah.d(cr2, rpg.a.c - 6, n3 + 55 + 23, 9, 6);
        cr2.a(9032496);
        if (n2 != 0) {
            cr2.e(rpg.a.c - 2, n3 + 57 + 23, rpg.a.c - 2, n3 + 57 + 23);
            cr2.e(rpg.a.c - 3, n3 + 58 + 23, rpg.a.c - 1, n3 + 58 + 23);
            cr2.e(rpg.a.c - 4, n3 + 59 + 23, rpg.a.c, n3 + 59 + 23);
            return;
        }
        cr2.e(rpg.a.c - 4, n3 + 57 + 23, rpg.a.c, n3 + 57 + 23);
        cr2.e(rpg.a.c - 3, n3 + 58 + 23, rpg.a.c - 1, n3 + 58 + 23);
        cr2.e(rpg.a.c - 2, n3 + 59 + 23, rpg.a.c - 2, n3 + 59 + 23);
    }
}

