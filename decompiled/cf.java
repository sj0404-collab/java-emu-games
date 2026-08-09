/*
 * Decompiled with CFR 0.152.
 */
abstract class cf
extends ec {
    protected boolean f = false;
    protected byte g = (byte)-1;
    protected byte h = (byte)100;

    public cf(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2, b.a[by2].a);
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
            int n2 = this.a((c)this.a);
            if (n2 < this.g) {
                this.u = (byte)2;
                this.a((byte)3);
                return;
            }
            if (n2 > this.h) {
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

    protected void c(int n2, int n3) {
        switch (this.p) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                ((db)this).a.a(this.i, this.q, ((do)this).f, n2, n3);
                return;
            }
            case 6: {
                rpg.c.a.a(this.i, (byte)1, ((do)this).f, n2, n3);
                return;
            }
            case 100: {
                ((db)this).a.a(this.i, (byte)1, ((do)this).f, n2, n3);
            }
        }
    }

    protected final void a(byte by2, byte by3, boolean bl2) {
        ab ab2 = r.a;
        byte by4 = bl2 ? (byte)0 : this.a.q;
        int n2 = 0;
        do {
            byte by5;
            byte by6;
            if (ab2.a(this, (int)(by6 = (byte)(by2 + rpg.b.S[by4])), (int)(by5 = (byte)(by3 + rpg.b.T[by4])))) {
                this.b_();
                this.a((short)(by6 << 4), (short)(by5 << 4));
                this.a();
                this.a_();
                this.i(rpg.b.Y[bl2 ? this.q : this.a.q]);
                return;
            }
            if ((by4 = (byte)(by4 + 1)) <= 4) continue;
            by4 = 1;
        } while (n2++ < 5);
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

    final void b(byte by2, int n2) {
        if (!this.d()) {
            super.b(by2, n2);
        }
    }

    final void a(byte by2, byte by3, int n2) {
        if (!this.d()) {
            super.a(by2, by3, n2);
        }
    }

    final boolean a(byte by2, int n2) {
        if (!this.d()) {
            return super.a(by2, n2);
        }
        return true;
    }

    final boolean a(byte by2) {
        if (!this.d()) {
            return super.a(by2);
        }
        return true;
    }

    protected final void c_() {
        this.i = 0;
        this.c = ((db)this).a.a(this.i);
    }
}

