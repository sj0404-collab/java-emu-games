/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

final class o
extends aj {
    private byte a = 0;

    public o(ah ah2) {
        super(ah2, (byte)4);
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (this.a != 0) {
            return true;
        }
        if (ah.g(n2, n3)) {
            if (this.b != null) {
                this.g();
            } else if (dj.b) {
                r.a((byte)7, (byte)0);
            } else {
                ((ah)this).a.d = (byte)9;
                ((ah)this).a.g();
            }
            return true;
        }
        if (ah.f(n2, n3)) {
            return this.a();
        }
        this.c(n2, n3);
        return true;
    }

    protected final boolean a() {
        switch (this.d) {
            case 0: {
                if (r.a.e) {
                    this.b = new bk((ah)this, dj.a.a(18), 3, true, true);
                    break;
                }
                this.b = new bi((ah)this, dj.a.a(61), 20);
                break;
            }
            case 1: {
                ah.f = true;
                this.b = new bz((ah)this, true);
                break;
            }
            case 2: {
                ah.f = true;
                this.b = new au((ah)this, true);
                break;
            }
            case 3: {
                byte[] byArray = rpg.c.a.a(31);
                o o2 = this;
                this.b = new bk((ah)o2, byArray, 3, false, true);
                break;
            }
            default: {
                return false;
            }
        }
        this.d = true;
        return true;
    }

    final void a(byte by2, byte by3) {
        this.g();
        if (by2 == 3) {
            if (by3 == 0) {
                if (this.d == 3) {
                    r.a((byte)7, (byte)1);
                    return;
                }
                this.a = (byte)2;
                this.b = new bi((ah)this, dj.a.a(17), '\u0000');
                return;
            }
            if (dj.b) {
                r.a((byte)7, (byte)0);
                return;
            }
        } else if (by2 == 20 && dj.b) {
            r.a((byte)7, (byte)0);
        }
    }

    protected final void a(cr cr2) {
        if (this.a == 2) {
            this.a = 1;
            this.a();
        } else if (this.a == 1) {
            this.a = 0;
            try {
                r.k();
                this.g();
                if (dj.b) {
                    r.a((byte)7, (byte)0);
                } else {
                    this.b = new bi((ah)this, dj.a.a(16), '\u0000');
                }
            }
            catch (Exception exception) {}
        }
        if (dj.b) {
            return;
        }
        this.a(cr2, false, true, true, false);
        this.a(cr2, 49, 150, false);
    }
}

