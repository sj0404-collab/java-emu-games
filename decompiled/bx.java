/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

final class bx
extends bi {
    private byte[] a = new byte[9];
    private int j = 0;

    public bx(k k2, byte[] byArray) {
        super((ah)k2, byArray, '\u0000');
        this.f = 1;
        this.g = (byte)10;
        ((ah)this).e = (byte)10;
        this.a(this.e + 3);
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
            bx bx2 = this;
            n3 = 0;
            for (int i2 = bx2.a.length - 1; i2 >= 0; --i2) {
                n3 = n3 * 10 + bx2.a[i2];
            }
            int n4 = n3;
            if (n4 > n.b) {
                ((ah)this).b = new bi((ah)this, c.h.a(25), '\u0000');
            } else {
                ((k)((ah)this).a).a = n4;
                ((ah)this).a.g();
            }
            return true;
        }
        if (n3 == 52 || n2 == 2) {
            ++this.j;
            if (this.j > 8) {
                this.j = 0;
            }
            ((ah)this).d = this.a[this.j];
            return true;
        }
        if (n3 == 54 || n2 == 5) {
            --this.j;
            if (this.j < 0) {
                this.j = 8;
            }
            ((ah)this).d = this.a[this.j];
            return true;
        }
        return this.e(n2, n3);
    }

    protected final boolean e(int n2, int n3) {
        if (n3 == 50 || n2 == 1) {
            this.a((byte)4);
            this.a[this.j] = ((ah)this).d;
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            this.a((byte)3);
            this.a[this.j] = ((ah)this).d;
            return true;
        }
        return false;
    }

    protected final void a(cr cr2) {
        super.a(cr2);
        int n2 = ((j)this).b + 25;
        int n3 = ((j)this).a + 20;
        ah.a(cr2, this.a, n3, n2 + 16, 8);
        ah.a(cr2, n3 - 8, n2 + 19, 86, 3550755, false);
        ah.e(cr2, n3 + 2 + (8 - this.j << 3), n2 + 12, 12);
        dv.a(cr2, ((j)this).a + 10, n2 + 33, c.b.a(31), 0);
        this.d(cr2, ((j)this).a + 105, n2 + 34, n.b);
    }
}

