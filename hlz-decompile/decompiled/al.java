/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;
import rpg.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class al
extends ae {
    private byte[] a;
    private byte[] b;
    private short[] a;
    private int a = 160;

    al(ah ah2) {
        super(ah2, (byte)1);
        ah2 = this;
        this.a = rpg.c.f.a(0);
        ((al)ah2).b = rpg.c.f.a(1);
        short[] sArray = new short[20];
        int n = 0;
        for (int i = 0; i < ((al)ah2).b.length; i += dv.a(((al)ah2).b, i, ((al)ah2).a, 8)) {
            sArray[n++] = (short)i;
        }
        ((al)ah2).a = new short[n];
        System.arraycopy(sArray, 0, ((al)ah2).a, 0, ((al)ah2).a.length);
        ah2.e = (byte)((al)ah2).a.length;
        ah2.d = 0;
    }

    final boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (ah.f(n, n2) || ah.g(n, n2)) {
            if (n == -7) {
                ((ah)this).a.d = (byte)6;
                ((ah)this).a.g();
            }
            return true;
        }
        return this.c(n, n2);
    }

    protected final void a(cr cr2) {
        int n = rpg.a.d;
        rpg.a.a(cr2, true);
        n -= 36;
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, rpg.g.b, this.a, 0, 1);
        cr2.a(0xCCCCCC);
        short s = this.a[this.d];
        short s2 = this.d == this.e - 1 ? (short)this.b.length : this.a[this.d + 1];
        int n2 = rpg.a.a - this.a >> 1;
        dv.a(cr2, n2 + 5, n, this.a, 1, this.b, (int)s, 0, s2 - s);
        if (this.e > 1) {
            this.a(cr2, this.f + 160 - 10, n - 10, this.d + 1, this.e, 8);
        }
        this.f(cr2, n2 + this.a + 2, n - 2, this.d, this.e);
        ah.a(cr2, 2);
    }
}
