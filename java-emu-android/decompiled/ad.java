/*
 * Decompiled with CFR 0.152.
 */
final class ad
extends cf {
    public ad(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2);
        this.Z = rpg.c.a(ec.b, 21);
    }

    protected final void c() {
        if (this.p == 6) {
            this.c_();
            return;
        }
        switch (this.p) {
            case 3: {
                switch (this.u) {
                    case 1: {
                        this.i = (byte)7;
                        break;
                    }
                    case 4: {
                        this.i = (byte)3;
                        break;
                    }
                    case 5: {
                        this.i = (byte)4;
                        break;
                    }
                    case 6: {
                        this.i = (byte)5;
                        break;
                    }
                    case 7: {
                        this.i = (byte)6;
                    }
                }
                break;
            }
            case 4: {
                this.i = (byte)2;
                break;
            }
            case 2: {
                this.i = 1;
                break;
            }
            default: {
                this.i = 0;
            }
        }
        this.c = ((db)this).a.a(this.i);
    }

    protected final boolean a(int n2) {
        boolean bl2 = false;
        switch (this.u) {
            case 1: {
                bl2 = n2 == 4;
                break;
            }
            case 4: 
            case 5: {
                bl2 = n2 == 2 || n2 == 5 || n2 == 7;
                break;
            }
            case 6: {
                bl2 = n2 == 15;
                break;
            }
            case 7: {
                bl2 = n2 >= 3 && n2 % 2 == 0;
            }
        }
        return bl2;
    }

    protected final boolean a() {
        int n2 = (((ec)this).h + 1) % this.Z.length;
        byte by2 = this.Z[n2];
        boolean bl2 = false;
        switch (by2) {
            case 10: {
                bl2 = true;
                ((ec)this).h = n2;
                this.u = by2;
                this.h = (byte)3;
                break;
            }
            case 11: {
                bl2 = true;
                ((ec)this).h = n2;
                this.u = by2;
                this.h = (byte)100;
                break;
            }
            case 1: {
                if (this.a((c)this.a) < 3) {
                    ((ec)this).h = n2;
                    this.u = by2;
                    break;
                }
                bl2 = true;
                ((ec)this).h = n2;
                this.u = by2;
                this.a((byte)3);
                break;
            }
            case 6: 
            case 7: {
                bl2 = true;
                ((ec)this).h = n2;
                this.u = by2;
                this.a((byte)3);
            }
        }
        return bl2;
    }

    protected final void e() {
        switch (this.u) {
            case 1: {
                this.a(((c)this.a).c, ((c)this.a).d, false);
                return;
            }
            case 4: 
            case 5: {
                boolean bl2;
                this.a.e = 0;
                if (((do)this).f == 2) {
                    bl2 = this.f();
                } else {
                    boolean bl3 = bl2 = this.g();
                }
                if (!bl2) break;
                if (this.u == 4) {
                    if (!this.a.b()) {
                        this.a.n(50);
                    }
                    if (!this.a.b()) {
                        this.a.b(60, 30);
                    }
                    this.a.c(new dx(((db)this).a, 9));
                    return;
                }
                if (this.u != 5) break;
                this.c(this.a.e);
                this.a.c(new dx(((db)this).a, 8));
                return;
            }
            case 6: {
                for (int i2 = 0; i2 < 15; ++i2) {
                    int n2;
                    int n3 = ((c)this).c + (Math.abs(do.a.nextInt()) & 0xFF) % 7 + -3;
                    if (ab.a(n3, n2 = ((c)this).d + (Math.abs(do.a.nextInt()) & 0xFF) % 7 + -3)) continue;
                    new as(13, (short)(n3 << 4), (short)(n2 << 4), ((db)this).a, 10, true, this, this.a(), this.r, 3);
                }
                return;
            }
            case 7: {
                new as(13, ((c)this.a).a, ((c)this.a).b, ((db)this).a, 11, true, this, this.a(), this.r, 3);
            }
        }
    }

    protected final void c(int n2, int n3) {
        switch (this.p) {
            case 6: {
                rpg.c.a.a((byte)0, (byte)1, ((do)this).f, n2, n3);
                return;
            }
        }
        ((db)this).a.a(this.i, this.i == 5 ? (byte)1 : this.q, ((do)this).f, n2, n3);
    }
}

