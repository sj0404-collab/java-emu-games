/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class aq
extends ec {
    private byte[] a = rpg.c.a(ec.b, 0);
    private byte[] ac = rpg.c.a(ec.b, 1);
    private int b;
    private int i;
    private boolean f = false;

    public aq(short s, short s2, short s3, byte by) {
        super(s, s2, s3, by, b.a[by].a);
        this.Z = rpg.c.a(ec.b, 2);
        this.aa = rpg.c.a(ec.b, 3);
        this.ab = rpg.c.a(ec.b, 4);
        this.b(this.ac);
        this.h = 2;
        this.u = this.Z[this.h];
        this.f = false;
        ((db)this).i = 0;
        ((am)this).c = this.aa[this.u];
        this.i = this.b = this.e * 10 / 100;
    }

    protected final void m() {
        if (this.p != 30) {
            super.m();
            return;
        }
        if (this.i()) {
            this.a((byte)1);
        }
    }

    protected final int c() {
        if (this.f()) {
            return this.e;
        }
        return this.i;
    }

    private boolean f() {
        return this.i <= 0;
    }

    protected final int d() {
        if (this.f()) {
            return this.d;
        }
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected final void n() {
        if (((am)this).c <= 0 && !this.g) {
            this.C();
            this.a((byte)3);
            return;
        }
        int n = this.a((c)((ec)this).a);
        int n2 = this.b(((ec)this).a);
        int n3 = n;
        if (((c)((ec)this).a).c > ((c)this).c) {
            n3 = 0 - n;
        }
        int n4 = n2;
        if (((c)((ec)this).a).d > ((c)this).d) {
            n4 = 0 - n2;
        }
        byte by = 0;
        byte by2 = 0;
        if (n4 != 0) {
            byte by3 = by = n4 > 0 ? (byte)1 : 2;
        }
        if (n3 != 0) {
            byte by4 = by2 = n3 > 0 ? (byte)3 : 4;
        }
        if (n < n2) {
            this.i(by);
            return;
        }
        this.i(by2);
    }

    protected final void c(int n, int n2) {
        ((db)this).a.a(((db)this).i, ((db)this).i == 1 || ((db)this).i == 2 ? this.q : (byte)1, ((do)this).f, n, n2);
    }

    private final void C() {
        do {
            byte by = this.u;
            this.h = (this.h + 1) % this.Z.length;
            this.u = this.Z[this.h];
            if (by == 2 && this.f()) {
                this.h = 1;
                this.u = this.Z[this.h];
                this.f = true;
                return;
            }
            if (!this.f() || this.u != 0) continue;
            this.h = 0;
            this.u = this.Z[this.h];
            this.f = true;
            return;
        } while (this.u == 2 && !this.f());
    }

    protected final boolean a(int n) {
        return n == this.ab[this.u];
    }

    protected final void e() {
        switch (this.u) {
            case 0: {
                this.a(this.a, this.a(), true);
                return;
            }
            case 1: {
                for (int i = 0; i < 6; ++i) {
                    int n = ((c)((ec)this).a).c + (Math.abs(do.a.nextInt()) & 0xFF) % 4 - 2;
                    int n2 = ((c)((ec)this).a).d + (Math.abs(do.a.nextInt()) & 0xFF) % 4 - 2;
                    if (n < 0 || n >= ab.c || n2 < 0 || n2 >= ab.d) continue;
                    new as(1, (short)(n << 4), (short)(n2 << 4), ((db)this).a, 16, false, this, 0, 0, 0);
                }
                break;
            }
        }
    }

    protected final void j() {
        if (this.u == 1) {
            new cs(((c)((ec)this).a).a, ((c)((ec)this).a).b, ((db)this).a);
            new cs(((c)((ec)this).a).a, ((c)((ec)this).a).b, ((db)this).a);
        }
        this.a((int)this.aa[this.u]);
    }

    /*
     * Unable to fully structure code
     */
    protected final void c() {
        switch (this.p) {
            case 0: 
            case 1: 
            case 2: {
                if (this.i > 0) {
                    this.i = this.f != false ? 1 : 0;
                    break;
                }
                v0 = this;
                v1 = 2;
                ** GOTO lbl37
            }
            case 3: {
                switch (this.u) {
                    case 0: {
                        this.i = (byte)(this.f != false ? 6 : 5);
                        this.f = this.f == false;
                        break;
                    }
                    case 1: {
                        this.i = (byte)(this.i > 0 ? 3 : 4);
                        break;
                    }
                    case 2: {
                        this.i = (byte)20;
                        this.i = this.b;
                    }
                }
                break;
            }
            case 4: {
                if (this.i > 0) {
                    this.i = (byte)(this.f != false ? 8 : 7);
                    break;
                }
                v0 = this;
                v1 = 9;
                ** GOTO lbl37
            }
            case 6: 
            case 7: {
                break;
            }
            case 8: {
                break;
            }
            case 30: {
                v0 = this;
                v1 = this.f != false ? 15 : 14;
lbl37:
                // 3 sources

                v0.i = (byte)v1;
            }
        }
        this.c = this.a.a(this.i);
    }

    protected final void a(do do_, int n) {
        if (this.i > 0) {
            this.i -= n;
            if (this.i <= 0) {
                this.i = 0;
                this.a((byte)30);
                return;
            }
        } else {
            this.e -= n;
            if (this.e <= 0) {
                this.e = 0;
            }
        }
    }

    protected final void o() {
        r.a.d(this);
        this.c(this.ac);
    }
}
