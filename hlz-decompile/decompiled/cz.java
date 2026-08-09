/*
 * Decompiled with CFR 0.152.
 */
import rpg.RPGHeroEx;
import rpg.a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class cz
extends ae {
    private cw[] a;
    private cx a;
    private byte[] a;
    private byte a = (byte)100;
    private byte b = (byte)2;

    cz(ah ah2) {
        super(ah2, (byte)3);
        this.e = (byte)3;
        this.a = new cw[3];
        for (int i = 0; i < 3; ++i) {
            this.a[i] = cw.a("/mg" + (i + 1) + ".png");
        }
        this.d = 0;
        this.a = (byte)100;
        this.b = (byte)2;
        this.a = new cx("/t/mg");
        this.a = this.a.a(0);
    }

    final boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (ah.g(n, n2)) {
            ((ah)this).a.d = (byte)8;
            ((ah)this).a.g();
            this.a = null;
            return true;
        }
        if (ah.f(n, n2)) {
            ((ah)this).b = new bk((ah)this, this.a.a(3), 3, true, true);
            return true;
        }
        if (n == 2 || n2 == 52) {
            this.b((byte)3);
            this.a = this.a.a(this.d);
            return true;
        }
        if (n == 5 || n2 == 54) {
            this.b((byte)4);
            this.a = this.a.a(this.d);
            return true;
        }
        return true;
    }

    protected final void a(cr cr2) {
        rpg.a.a(cr2, true);
        int n = rpg.a.d;
        cr2.a(this.a[this.d], rpg.a.c, n -= 50, 3);
        ah.a(cr2, rpg.a.c - (this.a >> 1), n, this.a, 0xFFFFFF, false);
        dv.a(cr2, rpg.a.c - 60, n += 80, 120, 1, this.a, 0, 0, this.a.length);
        this.a = (byte)(this.a + this.b);
        if (this.a >= 120 || this.a <= 100) {
            this.b = -this.b;
        }
        if (bh.a() != null) {
            bh.a();
            bh.e();
        }
        ah.a(cr2, 3);
    }

    final void a(byte by, byte by2) {
        this.g();
        if (by == 3 && by2 == 0) {
            RPGHeroEx.a.a("Tj" + (this.d + 1) + "URL");
        }
    }
}
