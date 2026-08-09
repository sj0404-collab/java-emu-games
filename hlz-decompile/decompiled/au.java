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

    au(ah ah2, boolean bl) {
        super(ah2, (byte)7);
        this.a = bl;
        this.d = 0;
        this.a = 0;
        this.a = this.a || rpg.a.a < 176 ? 140 : (rpg.a.a < 240 ? 120 : 140);
        this.c(this.a);
    }

    final boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (ah.f(n, n2) || ah.g(n, n2)) {
            if (n == -7) {
                ((ah)this).a.d = (byte)(this.a ? 2 : 5);
                ((ah)this).a.g();
                ah.f = false;
            }
            return true;
        }
        if (n == 2 || n2 == 52) {
            this.a = (byte)((this.a + 7 - 1) % 7);
            this.b = true;
            return true;
        }
        if (n == 5 || n2 == 54) {
            this.a = (byte)((this.a + 1) % 7);
            this.b = true;
            return true;
        }
        return this.c(n, n2);
    }

    private void c(byte by) {
        this.b = false;
        this.a = rpg.c.e.a(by);
        this.b = rpg.c.e.a(by + 7);
        short[] sArray = new short[20];
        int n = 0;
        for (int i = 0; i < this.b.length; i += dv.a(this.b, i, this.a, 5)) {
            sArray[n++] = (short)i;
        }
        this.a = new short[n];
        System.arraycopy(sArray, 0, this.a, 0, this.a.length);
        this.e = (byte)this.a.length;
        this.d = 0;
    }

    protected final void a(cr cr2) {
        short s;
        int n;
        if (this.b) {
            this.c(this.a);
        }
        int n2 = rpg.a.d;
        if (this.a) {
            this.a(cr2, false, false, true, false);
            if (this.a == 9) {
                cr2.a(4217367);
            } else {
                cr2.a(0);
            }
            n = this.g + 14;
            ah.d(cr2, this.f + 2, n, 156, 14);
            cr2.e(this.f, n += 15, this.f + 160 - 1, n);
            ah.d(cr2, this.f + 2, n += 2, 156, 134);
            n2 -= 43;
        } else {
            rpg.a.a(cr2, true);
            n2 -= 36;
            if (this.a == 9) {
                cr2.a(4217367);
                ah.d(cr2, rpg.a.a - this.a - 8 >> 1, n2 + 27 - 2, this.a + 8, 94);
            }
        }
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, rpg.g.b, rpg.c.b.a(8), 0, 1);
        dv.a(cr2, rpg.a.c, rpg.g.b + 15, this.a, 0, 1);
        ah.a(cr2, rpg.a.c - 75, rpg.g.b + 20, 150, 0xFFFFFF, false);
        cr2.a(0xCCCCCC);
        n = this.a[this.d];
        short s2 = s = this.d == this.e - 1 ? (short)this.b.length : this.a[this.d + 1];
        if (this.b[0] == 33) {
            if (n == 0) {
                n = 1;
            }
            dv.a = false;
        }
        int n3 = rpg.a.a - this.a >> 1;
        dv.a(cr2, n3, n2 + 27, this.a, 1, this.b, n, 0, s - n);
        dv.a = true;
        this.a(cr2, this.f + 160 - 10, n2 + 17, this.d + 1, this.e, 8);
        this.f(cr2, n3 + this.a + 2, n2 + 25, this.d, this.e);
        ah.a(cr2, 2);
    }
}
