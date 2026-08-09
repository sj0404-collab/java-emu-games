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

    public h(ah ah2, byte by, byte by2, byte by3, byte by4) {
        super(ah2, (byte)0);
        this.a = by2;
        this.b = by;
        this.c = by3;
        this.i = by4;
        switch (by2) {
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

    final boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (ah.g(n, n2) || ah.f(n, n2)) {
            ((ah)this).a.g();
        }
        return true;
    }

    protected final void a(cr cr2) {
        int n;
        this.a(cr2, false, true, rpg.c.b.a(30), false);
        cr2.a(0);
        int n2 = this.g + 12;
        cr2.a(this.f, n2, 160, 16);
        int n3 = this.f + 2;
        int n4 = this.f + 2 + 70 + 2;
        int n5 = n2 + 16 + 1;
        int n6 = n5 + 14 + 3;
        int n7 = n6 + 14 + 3;
        for (n = 0; n < 2; ++n) {
            ah.d(cr2, n3, n5 + n * 17, 70, 14);
            ah.d(cr2, n4, n5 + n * 17, 84, 14);
            cr2.e(this.f, n6 - 2 + n * 17, this.f + 160, n6 - 2 + n * 17);
        }
        ah.d(cr2, this.f + 2, n7, 156, 102);
        cr2.a(14597755);
        for (n = 0; n < 2; ++n) {
            dv.a(cr2, this.f + 2 + 35, n5 + n * 17 + 1, dj.a.a(n + 26), 0, 1);
        }
        cr2.a(0xFFFFFF);
        dv.a(cr2, rpg.a.c, n2 + 1, this.a, 0, 1);
        dv.a(cr2, n4 + 42, n5 + 1, rpg.c.d.a(7 + this.a), 0, 1);
        dv.a(cr2, this.f + 2 + 10, n7 + 4, 136, 0, this.b);
        n2 = (44 - this.i + 1) / this.i;
        for (n3 = 0; n3 < this.i; ++n3) {
            cr2.a(this.c > n3 ? 16755968 : 3550755);
            cr2.a(n4 + 15 + n3 * (n2 + 1), n6 + 4, n2, 4);
        }
    }
}
