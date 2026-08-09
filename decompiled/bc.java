/*
 * Decompiled with CFR 0.152.
 */
import rpg.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class bc
extends ar {
    private final byte[] a;
    private final byte[] b;
    private x a = new byte[]{18, 19, 18};
    private byte j;
    private byte k;
    private int b = new byte[]{3, 3, 7};

    bc(x x2, byte by2, byte by3, int n2) {
        super(by2, x2.q, (byte)(((c)x2).c + rpg.b.S[x2.q]), (byte)(((c)x2).d + rpg.b.T[x2.q]), true);
        this.a = x2;
        this.k = this.b[by2];
        this.b = n2;
        this.j = by3;
        this.c = rpg.c.a.a(this.a[by2]);
    }

    final void b() {
        if (this.k > 0) {
            this.c(((c)this).c, this.d);
            if (this.h == 2) {
                this.c(((c)this).c + rpg.b.X[this.i], this.d + rpg.b.X[this.i]);
                this.c(((c)this).c + rpg.b.W[this.i], this.d + rpg.b.W[this.i]);
            }
            byte by2 = (byte)(((c)this).c + rpg.b.S[this.i]);
            byte by3 = (byte)(this.d + rpg.b.T[this.i]);
            if (by2 >= 0 && by2 < ab.c && by3 >= 0 && by3 < ab.d) {
                if (!r.a.b((int)by2, (int)by3)) {
                    this.a((short)(by2 << 4), (short)((by3 << 4) + 1));
                    this.a();
                } else {
                    this.k = 0;
                }
                this.k = (byte)(this.k - 1);
            } else {
                this.e = true;
            }
            r.a.c(2, this.k);
            return;
        }
        this.e = true;
    }

    final void b(int n2, int n3) {
        n2 = n2 + ((c)this).a + ((c)this).a;
        n3 = n3 + ((c)this).b + ((c)this).b - (this.f ? ar.f : ar.g);
        rpg.c.a.a(this.a[this.h], this.i, ((ar)this).a, n2, n3);
    }

    private void c(int n2, int n3) {
        if (n2 < 0 || n3 < 0 || n2 >= ab.c || n3 >= ab.d) {
            return;
        }
        c c2 = r.a.a[n3][n2];
        if (c2 != null && c2 instanceof db && !(c2 instanceof an)) {
            ((db)c2).a(this.a, this.j, this.b, false, this.i, (byte)2, false, true, false);
        }
    }
}

