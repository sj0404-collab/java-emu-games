/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class cm
extends ah {
    private int a;
    private byte[] a = null;

    public cm(ah ah2, byte by, byte by2, int n, boolean bl, byte[] byArray) {
        super(ah2, by, (byte)0, (byte)0);
        byte by3 = r.e > n * 99 ? (byte)99 : (byte)(r.e / n);
        this.e = (byte)(this.e < 0 || this.e > 99 ? 99 : (int)this.e);
        byte by4 = by3 = by3 < 0 || by3 > 99 ? (byte)99 : by3;
        if (bl) {
            this.e = this.e > by3 ? by3 : this.e;
        }
        this.a = n;
        this.a = byArray;
        this.d = 1;
    }

    final boolean a(int n, int n2) {
        if (ah.g(n, n2)) {
            ((ah)this).a.a((byte)0, (byte)0);
            return true;
        }
        if (ah.f(n, n2)) {
            ((ah)this).a.a((byte)0, this.d);
        } else if (n == 1 || n2 == 50) {
            if (this.d < this.e) {
                this.d = (byte)(this.d + 10);
            }
            if (this.d > this.e) {
                this.d = this.e;
            }
        } else if (n == 6 || n2 == 56) {
            if (this.d == 1) {
                this.d = this.e;
            } else if (this.d > 10) {
                this.d = (byte)(this.d - 10);
            }
        } else if (n == 2 || n2 == 52) {
            if (this.d > 1) {
                this.d = (byte)(this.d - 1);
            }
        } else if ((n == 5 || n2 == 54) && this.d < this.e) {
            this.d = (byte)(this.d + 1);
        }
        this.a();
        return true;
    }

    protected final void a(cr cr2) {
        int n = 56;
        cr cr3 = cr2;
        int n2 = rpg.a.b - 56 >> 1;
        int n3 = rpg.a.a - 100 >> 1;
        cr3.b(n3, n2, 100, 56);
        ah.c(cr3, n3, n2, 100, 56);
        cr3.a(0);
        cr3.d(n3, n2, 100, 56);
        cr3.a(15723216);
        cr3.d(n3 + 1, n2 + 1, 98, 54);
        int n4 = n2;
        cr2.a(0);
        if (this.a != null) {
            dv.a(cr2, rpg.a.c, n4 + 5, this.a, 1, 1);
        }
        n2 = rpg.a.c - 21;
        ah.c(cr2, n2, n4 += 28, 42, 15, 0);
        ah.d(cr2, n2 + 1, n4 + 1, 40, 13, 0xFF0000);
        ah.a(cr2, n2 - 5, n4 + 6, 51, 0, false);
        ah.e(cr2, rpg.a.c, n4 - 5, 22);
        cr2.a(0xFFFFFF);
        dv.a(cr2, rpg.a.c + 1, n4 + 1, ("" + this.d).getBytes(), 0, 1);
        if (this.a > 0) {
            this.d(cr2, rpg.a.c + 40, n4 + 19, this.a * this.d);
        }
    }
}
