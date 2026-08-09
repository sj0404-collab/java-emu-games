/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;

final class q
extends j {
    private int j = 0;
    private byte[][] a = null;

    public q(ah ah2, byte[][] byArray, int n) {
        super(ah2, byArray.length, byArray.length, 1, (byte)6);
        this.a = byArray;
        this.e = byArray.length;
        for (int i = 0; i < this.e; ++i) {
            int n2 = dv.a(byArray[i]);
            if (n2 <= this.j) continue;
            this.j = n2;
        }
        this.j += 5;
        this.d = this.e * 14 + 4;
        this.b = rpg.a.d - (this.d >> 1);
        ((j)this).a = rpg.a.c;
        if (n == 4) {
            ((j)this).a -= this.j + 3;
            return;
        }
        if (n == 8) {
            ((j)this).a += 3;
            return;
        }
        ((j)this).a -= this.j >> 1;
    }

    public q(ah ah2, byte[][] byArray) {
        this(ah2, byArray, 1);
    }

    final boolean a(int n, int n2) {
        if (this.c(n, n2)) {
            ((ah)this).d = true;
            return true;
        }
        if (ah.f(n, n2)) {
            ((ah)this).a.a(((j)this).a, ((ah)this).d);
        } else if (ah.g(n, n2)) {
            ((ah)this).a.g();
        }
        return true;
    }

    protected final void a(cr cr2) {
        j.a(cr2, ((j)this).a, this.b, this.j, this.d);
        cr2.a(3550755);
        cr2.a(((j)this).a + 2, this.b + 2 + ((ah)this).d * 14, this.j - 4, 14);
        int n = ((j)this).a + (this.j >> 1);
        for (int i = 0; i < this.e; ++i) {
            cr2.a(i == ((ah)this).d ? 0xFFFFFF : 0);
            dv.a(cr2, n + 1, this.b + 2 + i * 14, this.a[i], 0, 1);
        }
    }
}
