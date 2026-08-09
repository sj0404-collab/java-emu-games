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
        int n2 = 0;
        for (int i2 = 0; i2 < ((al)ah2).b.length; i2 += dv.a(((al)ah2).b, i2, ((al)ah2).a, 8)) {
            sArray[n2++] = (short)i2;
        }
        ((al)ah2).a = new short[n2];
        System.arraycopy(sArray, 0, ((al)ah2).a, 0, ((al)ah2).a.length);
        ah2.e = (byte)((al)ah2).a.length;
        ah2.d = 0;
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.f(n2, n3) || ah.g(n2, n3)) {
            if (n2 == -7) {
                ((ah)this).a.d = (byte)6;
                ((ah)this).a.g();
            }
            return true;
        }
        return this.c(n2, n3);
    }

    protected final void a(cr cr2) {
        int n2 = rpg.a.d;
        rpg.a.a(cr2, true);
        n2 -= 36;
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, rpg.g.b, this.a, 0, 1);
        cr2.a(0xCCCCCC);
        short s2 = this.a[this.d];
        short s3 = this.d == this.e - 1 ? (short)this.b.length : this.a[this.d + 1];
        int n3 = rpg.a.a - this.a >> 1;
        dv.a(cr2, n3 + 5, n2, this.a, 1, this.b, (int)s2, 0, s3 - s2);
        if (this.e > 1) {
            this.a(cr2, this.f + 160 - 10, n2 - 10, this.d + 1, this.e, 8);
        }
        this.f(cr2, n3 + this.a + 2, n2 - 2, this.d, this.e);
        ah.a(cr2, 2);
    }
}

