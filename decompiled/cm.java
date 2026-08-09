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

    public cm(ah ah2, byte by2, byte by3, int n2, boolean bl2, byte[] byArray) {
        super(ah2, by2, (byte)0, (byte)0);
        byte by4 = r.e > n2 * 99 ? (byte)99 : (byte)(r.e / n2);
        this.e = (byte)(this.e < 0 || this.e > 99 ? 99 : (int)this.e);
        byte by5 = by4 = by4 < 0 || by4 > 99 ? (byte)99 : by4;
        if (bl2) {
            this.e = this.e > by4 ? by4 : this.e;
        }
        this.a = n2;
        this.a = byArray;
        this.d = 1;
    }

    final boolean a(int n2, int n3) {
        if (ah.g(n2, n3)) {
            ((ah)this).a.a((byte)0, (byte)0);
            return true;
        }
        if (ah.f(n2, n3)) {
            ((ah)this).a.a((byte)0, this.d);
        } else if (n2 == 1 || n3 == 50) {
            if (this.d < this.e) {
                this.d = (byte)(this.d + 10);
            }
            if (this.d > this.e) {
                this.d = this.e;
            }
        } else if (n2 == 6 || n3 == 56) {
            if (this.d == 1) {
                this.d = this.e;
            } else if (this.d > 10) {
                this.d = (byte)(this.d - 10);
            }
        } else if (n2 == 2 || n3 == 52) {
            if (this.d > 1) {
                this.d = (byte)(this.d - 1);
            }
        } else if ((n2 == 5 || n3 == 54) && this.d < this.e) {
            this.d = (byte)(this.d + 1);
        }
        this.a();
        return true;
    }

    protected final void a(cr cr2) {
        int n2 = 56;
        cr cr3 = cr2;
        int n3 = rpg.a.b - 56 >> 1;
        int n4 = rpg.a.a - 100 >> 1;
        cr3.b(n4, n3, 100, 56);
        ah.c(cr3, n4, n3, 100, 56);
        cr3.a(0);
        cr3.d(n4, n3, 100, 56);
        cr3.a(15723216);
        cr3.d(n4 + 1, n3 + 1, 98, 54);
        int n5 = n3;
        cr2.a(0);
        if (this.a != null) {
            dv.a(cr2, rpg.a.c, n5 + 5, this.a, 1, 1);
        }
        n3 = rpg.a.c - 21;
        ah.c(cr2, n3, n5 += 28, 42, 15, 0);
        ah.d(cr2, n3 + 1, n5 + 1, 40, 13, 0xFF0000);
        ah.a(cr2, n3 - 5, n5 + 6, 51, 0, false);
        ah.e(cr2, rpg.a.c, n5 - 5, 22);
        cr2.a(0xFFFFFF);
        dv.a(cr2, rpg.a.c + 1, n5 + 1, ("" + this.d).getBytes(), 0, 1);
        if (this.a > 0) {
            this.d(cr2, rpg.a.c + 40, n5 + 19, this.a * this.d);
        }
    }
}

