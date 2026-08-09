/*
 * Decompiled with CFR 0.152.
 */
import rpg.b;
import rpg.c;
import rpg.d;
import rpg.f;

final class co
extends aj {
    public co(ah ah2) {
        super(ah2, (byte)2);
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
            if (this.b != null) {
                this.g();
            } else {
                this.a.d = (byte)3;
                this.a.g();
            }
            return true;
        }
        if (n2 == 8 || n3 == 53 || n3 == -6) {
            co co2 = this;
            switch (co2.d) {
                case 0: {
                    co2.b = new da(co2);
                    break;
                }
                case 1: {
                    if (!r.e) {
                        byte[] byArray = rpg.c.a.a(28);
                        if (r.i) {
                            byArray = rpg.f.a(rpg.b.H, byArray);
                            r.i = false;
                            rpg.d.a();
                        }
                        co2.b = new bi((ah)co2, byArray, '\u0000');
                        ((bi)co2.b).b = true;
                        break;
                    }
                    r.k();
                    co2.b = new dk(co2);
                    break;
                }
                default: {
                    return false;
                }
            }
            co2.d = true;
            return true;
        }
        this.c(n2, n3);
        return true;
    }

    final void a(byte by, byte by2) {
        if (by == 3 && by2 == 0) {
            r.e = true;
            rpg.d.a();
            r.k();
            this.g();
            this.b = new dk(this);
            return;
        }
        this.g();
    }

    protected final void a(cr cr2) {
        this.a(cr2, false, true, true, false);
        this.a(cr2, 71, 150, false);
    }
}
