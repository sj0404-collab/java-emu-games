/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;
import rpg.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class au
extends ae {
    private boolean a;
    private byte a;
    private byte[] a;
    private byte[] b;
    private short[] a;
    private int a;
    private boolean b;

    au(ah ah2, boolean bl2) {
        super(ah2, (byte)7);
        this.a = bl2;
        this.d = 0;
        this.a = 0;
        this.a = this.a || rpg.a.a < 176 ? 140 : (rpg.a.a < 240 ? 120 : 140);
        this.c(this.a);
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.f(n2, n3) || ah.g(n2, n3)) {
            if (n2 == -7) {
                ((ah)this).a.d = (byte)(this.a ? 2 : 5);
                ((ah)this).a.g();
                ah.f = false;
            }
            return true;
        }
        if (n2 == 2 || n3 == 52) {
            this.a = (byte)((this.a + 7 - 1) % 7);
            this.b = true;
            return true;
        }
        if (n2 == 5 || n3 == 54) {
            this.a = (byte)((this.a + 1) % 7);
            this.b = true;
            return true;
        }
        return this.c(n2, n3);
    }

    private void c(byte by2) {
        this.b = false;
        this.a = rpg.c.e.a(by2);
        this.b = rpg.c.e.a(by2 + 7);
        short[] sArray = new short[20];
        int n2 = 0;
        for (int i2 = 0; i2 < this.b.length; i2 += dv.a(this.b, i2, this.a, 5)) {
            sArray[n2++] = (short)i2;
        }
        this.a = new short[n2];
        System.arraycopy(sArray, 0, this.a, 0, this.a.length);
        this.e = (byte)this.a.length;
        this.d = 0;
    }

    protected final void a(cr cr2) {
        short s2;
        int n2;
        if (this.b) {
            this.c(this.a);
        }
        int n3 = rpg.a.d;
        if (this.a) {
            this.a(cr2, false, false, true, false);
            if (this.a == 9) {
                cr2.a(4217367);
            } else {
                cr2.a(0);
            }
            n2 = this.g + 14;
            ah.d(cr2, this.f + 2, n2, 156, 14);
            cr2.e(this.f, n2 += 15, this.f + 160 - 1, n2);
            ah.d(cr2, this.f + 2, n2 += 2, 156, 134);
            n3 -= 43;
        } else {
            rpg.a.a(cr2, true);
            n3 -= 36;
            if (this.a == 9) {
                cr2.a(4217367);
                ah.d(cr2, rpg.a.a - this.a - 8 >> 1, n3 + 27 - 2, this.a + 8, 94);
            }
        }
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, rpg.g.b, rpg.c.b.a(8), 0, 1);
        dv.a(cr2, rpg.a.c, rpg.g.b + 15, this.a, 0, 1);
        ah.a(cr2, rpg.a.c - 75, rpg.g.b + 20, 150, 0xFFFFFF, false);
        cr2.a(0xCCCCCC);
        n2 = this.a[this.d];
        short s3 = s2 = this.d == this.e - 1 ? (short)this.b.length : this.a[this.d + 1];
        if (this.b[0] == 33) {
            if (n2 == 0) {
                n2 = 1;
            }
            dv.a = false;
        }
        int n4 = rpg.a.a - this.a >> 1;
        dv.a(cr2, n4, n3 + 27, this.a, 1, this.b, n2, 0, s2 - n2);
        dv.a = true;
        this.a(cr2, this.f + 160 - 10, n3 + 17, this.d + 1, this.e, 8);
        this.f(cr2, n4 + this.a + 2, n3 + 25, this.d, this.e);
        ah.a(cr2, 2);
    }
}

