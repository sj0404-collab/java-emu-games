/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;

final class q
extends j {
    private int j = 0;
    private byte[][] a = null;

    public q(ah ah2, byte[][] byArray, int n2) {
        super(ah2, byArray.length, byArray.length, 1, (byte)6);
        this.a = byArray;
        this.e = byArray.length;
        for (int i2 = 0; i2 < this.e; ++i2) {
            int n3 = dv.a(byArray[i2]);
            if (n3 <= this.j) continue;
            this.j = n3;
        }
        this.j += 5;
        this.d = this.e * 14 + 4;
        this.b = rpg.a.d - (this.d >> 1);
        ((j)this).a = rpg.a.c;
        if (n2 == 4) {
            ((j)this).a -= this.j + 3;
            return;
        }
        if (n2 == 8) {
            ((j)this).a += 3;
            return;
        }
        ((j)this).a -= this.j >> 1;
    }

    public q(ah ah2, byte[][] byArray) {
        this(ah2, byArray, 1);
    }

    final boolean a(int n2, int n3) {
        if (this.c(n2, n3)) {
            ((ah)this).d = true;
            return true;
        }
        if (ah.f(n2, n3)) {
            ((ah)this).a.a(((j)this).a, ((ah)this).d);
        } else if (ah.g(n2, n3)) {
            ((ah)this).a.g();
        }
        return true;
    }

    protected final void a(cr cr2) {
        j.a(cr2, ((j)this).a, this.b, this.j, this.d);
        cr2.a(3550755);
        cr2.a(((j)this).a + 2, this.b + 2 + ((ah)this).d * 14, this.j - 4, 14);
        int n2 = ((j)this).a + (this.j >> 1);
        for (int i2 = 0; i2 < this.e; ++i2) {
            cr2.a(i2 == ((ah)this).d ? 0xFFFFFF : 0);
            dv.a(cr2, n2 + 1, this.b + 2 + i2 * 14, this.a[i2], 0, 1);
        }
    }
}

