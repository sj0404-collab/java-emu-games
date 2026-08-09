/*
 * Decompiled with CFR 0.152.
 */
abstract class cf
extends ec {
    protected boolean f = false;
    protected byte g = (byte)-1;
    protected byte h = (byte)100;

    public cf(short s, short s2, short s3, byte by) {
        super(s, s2, s3, by, b.a[by].a);
        this.j = false;
        this.aa = rpg.c.a(ec.b, 18);
        this.a_();
    }

    protected final void k() {
        ((db)this).a = this.a;
    }

    protected final void n() {
        if (((am)this).c <= 0 && !((db)this).g) {
            this.k();
            int n = this.a((c)this.a);
            if (n < this.g) {
                this.u = (byte)2;
                this.a((byte)3);
                return;
            }
            if (n > this.h) {
                this.u = 1;
                this.a((byte)3);
                return;
            }
            if (!this.a() && !this.a((c)((db)this).a, ((db)this).j) && this.a((c)((db)this).a)) {
                cf cf2 = this;
                ((ec)this).h = (((ec)cf2).h + 1) % cf2.Z.length;
                cf2.u = cf2.Z[((ec)cf2).h];
                this.a((byte)3);
            }
        }
    }

    protected abstract boolean a();

    protected void c(int n, int n2) {
        switch (this.p) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                ((db)this).a.a(this.i, this.q, ((do)this).f, n, n2);
                return;
            }
            case 6: {
                rpg.c.a.a(this.i, (byte)1, ((do)this).f, n, n2);
                return;
            }
            case 100: {
                ((db)this).a.a(this.i, (byte)1, ((do)this).f, n, n2);
            }
        }
    }

    protected final void a(byte by, byte by2, boolean bl) {
        ab ab2 = r.a;
        byte by3 = bl ? (byte)0 : this.a.q;
        int n = 0;
        do {
            byte by4;
            byte by5;
            if (ab2.a(this, (int)(by5 = (byte)(by + rpg.b.S[by3])), (int)(by4 = (byte)(by2 + rpg.b.T[by3])))) {
                this.b_();
                this.a((short)(by5 << 4), (short)(by4 << 4));
                this.a();
                this.a_();
                this.i(rpg.b.Y[bl ? this.q : this.a.q]);
                return;
            }
            if ((by3 = (byte)(by3 + 1)) <= 4) continue;
            by3 = 1;
        } while (n++ < 5);
    }

    protected final boolean f() {
        byte[] byArray = new byte[]{rpg.b.S[this.q], rpg.b.T[this.q], (byte)(rpg.b.S[this.q] << 1), (byte)(rpg.b.T[this.q] << 1), (byte)(rpg.b.S[this.q] * 3), (byte)(rpg.b.T[this.q] * 3)};
        return this.a(byArray, this.a(), this.f);
    }

    protected final boolean g() {
        byte[] byArray = new byte[]{rpg.b.S[this.q], rpg.b.T[this.q], rpg.b.S[rpg.b.V[this.q]], rpg.b.T[rpg.b.V[this.q]], rpg.b.S[rpg.b.U[this.q]], rpg.b.T[rpg.b.U[this.q]]};
        return this.a(byArray, this.a(), this.f);
    }

    protected final boolean d() {
        return super.d() || this.p == 100;
    }

    final void b(byte by, int n) {
        if (!this.d()) {
            super.b(by, n);
        }
    }

    final void a(byte by, byte by2, int n) {
        if (!this.d()) {
            super.a(by, by2, n);
        }
    }

    final boolean a(byte by, int n) {
        if (!this.d()) {
            return super.a(by, n);
        }
        return true;
    }

    final boolean a(byte by) {
        if (!this.d()) {
            return super.a(by);
        }
        return true;
    }

    protected final void c_() {
        this.i = 0;
        this.c = ((db)this).a.a(this.i);
    }
}
