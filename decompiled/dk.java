/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;

final class dk
extends n {
    public dk(ah ah2) {
        super(ah2, (byte)2);
        this.d = 0;
        this.j();
        n.d();
        r.m();
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
            ((ah)this).a.g();
            return true;
        }
        if (ah.f(n2, n3)) {
            switch (this.d) {
                case 0: {
                    ((ah)this).b = new ap(this);
                    break;
                }
                case 1: {
                    ((ah)this).b = new t(this, 0);
                }
            }
            return true;
        }
        return this.c(n2, n3);
    }

    protected final void a(cr cr2) {
        rpg.a.a(cr2, true);
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, rpg.a.d - 64, rpg.c.b.a(9), 0, 1);
        for (byte by2 = 0; by2 < 2; by2 = (byte)(by2 + 1)) {
            int n2 = this.g + 25 + by2 * 17;
            ah.a(cr2, this.f, n2, 160, 15, this.d == by2 ? 0x660000 : 3550755, this.d == by2 ? 0xBD0000 : 7027456);
            cr2.a(this.d == by2 ? 0xFFFFFF : 12630160);
            dv.a(cr2, rpg.a.c, n2, rpg.c.h.a(by2 + 18), 0, 1);
        }
        ah.a(cr2, 3);
    }
}

