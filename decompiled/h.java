/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class h
extends ae {
    private byte a;
    private byte b;
    private byte[] a;
    private byte[] b;
    private byte c;
    private byte i;

    public h(ah ah2, byte by2, byte by3, byte by4, byte by5) {
        super(ah2, (byte)0);
        this.a = by3;
        this.b = by2;
        this.c = by4;
        this.i = by5;
        switch (by3) {
            case 0: 
            case 2: {
                this.a = dj.b.a(this.b << 1);
                this.b = dj.b.a((this.b << 1) + 1);
                return;
            }
            case 1: {
                this.a = dj.c.a(this.b << 1);
                this.b = dj.c.a((this.b << 1) + 1);
            }
        }
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3) || ah.f(n2, n3)) {
            ((ah)this).a.g();
        }
        return true;
    }

    protected final void a(cr cr2) {
        int n2;
        this.a(cr2, false, true, rpg.c.b.a(30), false);
        cr2.a(0);
        int n3 = this.g + 12;
        cr2.a(this.f, n3, 160, 16);
        int n4 = this.f + 2;
        int n5 = this.f + 2 + 70 + 2;
        int n6 = n3 + 16 + 1;
        int n7 = n6 + 14 + 3;
        int n8 = n7 + 14 + 3;
        for (n2 = 0; n2 < 2; ++n2) {
            ah.d(cr2, n4, n6 + n2 * 17, 70, 14);
            ah.d(cr2, n5, n6 + n2 * 17, 84, 14);
            cr2.e(this.f, n7 - 2 + n2 * 17, this.f + 160, n7 - 2 + n2 * 17);
        }
        ah.d(cr2, this.f + 2, n8, 156, 102);
        cr2.a(14597755);
        for (n2 = 0; n2 < 2; ++n2) {
            dv.a(cr2, this.f + 2 + 35, n6 + n2 * 17 + 1, dj.a.a(n2 + 26), 0, 1);
        }
        cr2.a(0xFFFFFF);
        dv.a(cr2, rpg.a.c, n3 + 1, this.a, 0, 1);
        dv.a(cr2, n5 + 42, n6 + 1, rpg.c.d.a(7 + this.a), 0, 1);
        dv.a(cr2, this.f + 2 + 10, n8 + 4, 136, 0, this.b);
        n3 = (44 - this.i + 1) / this.i;
        for (n4 = 0; n4 < this.i; ++n4) {
            cr2.a(this.c > n4 ? 16755968 : 3550755);
            cr2.a(n5 + 15 + n4 * (n3 + 1), n7 + 4, n3, 4);
        }
    }
}

