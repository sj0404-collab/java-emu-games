/*
 * Decompiled with CFR 0.152.
 */
final class by
extends cf {
    public static short d = (short)-1;
    public static byte f;
    public static int b;

    public by(short s, short s2, short s3, byte by2) {
        super(s, s2, s3, by2);
        this.Z = rpg.c.a(ec.b, 20);
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
                        this.i = (byte)8;
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
                        this.i = (byte)6;
                        break;
                    }
                    case 7: {
                        this.i = (byte)5;
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

    protected final boolean a(int n) {
        boolean bl = false;
        switch (this.u) {
            case 1: {
                bl = n == 4;
                break;
            }
            case 4: 
            case 5: {
                bl = n == 5 || n == 7 || n == 10;
                break;
            }
            case 6: {
                bl = n == 5;
                break;
            }
            case 7: {
                bl = n == 14;
            }
        }
        return bl;
    }

    protected final boolean a() {
        int n = (((ec)this).h + 1) % this.Z.length;
        byte by2 = this.Z[n];
        boolean bl = false;
        switch (by2) {
            case 10: {
                bl = true;
                ((ec)this).h = n;
                this.u = by2;
                this.h = (byte)3;
                break;
            }
            case 11: {
                bl = true;
                ((ec)this).h = n;
                this.u = by2;
                this.h = (byte)100;
                break;
            }
            case 1: {
                if (this.a((c)this.a) < 3) {
                    ((ec)this).h = n;
                    this.u = by2;
                    break;
                }
                bl = true;
                ((ec)this).h = n;
                this.u = by2;
                this.a((byte)3);
                break;
            }
            case 6: {
                ((ec)this).h = n;
                this.u = by2;
                if (b > 0) break;
                bl = true;
                this.a((byte)3);
                break;
            }
            case 7: {
                bl = true;
                ((ec)this).h = n;
                this.u = by2;
                this.a((byte)3);
            }
        }
        return bl;
    }

    protected final void e() {
        switch (this.u) {
            case 1: {
                this.a(((c)this.a).c, ((c)this.a).d, false);
                return;
            }
            case 4: 
            case 5: {
                boolean bl;
                this.a.e = 0;
                if (((do)this).f == 5) {
                    bl = this.f();
                } else {
                    boolean bl2 = bl = this.g();
                }
                if (this.u != 5 || !bl) break;
                this.c(this.a.e);
                this.a.c(new dx(((db)this).a, 10));
                return;
            }
            case 6: {
                for (int i = 0; i < 5; ++i) {
                    new dz(((c)this).a, ((c)this).b, d, f);
                }
                return;
            }
            case 7: {
                for (int i = 0; i < 15; ++i) {
                    int n;
                    int n2 = ((c)this).c + (Math.abs(do.a.nextInt()) & 0xFF) % 9 + -4;
                    if (ab.a(n2, n = ((c)this).d + (Math.abs(do.a.nextInt()) & 0xFF) % 9 + -4)) continue;
                    new as(13, (short)(n2 << 4), (short)(n << 4), ((db)this).a, 9, true, this, this.a(), this.r, 3);
                }
                break;
            }
        }
    }

    protected final void c(int n, int n2) {
        switch (this.p) {
            case 6: {
                rpg.c.a.a((byte)0, (byte)1, ((do)this).f, n, n2);
                return;
            }
        }
        ((db)this).a.a(this.i, this.i == 5 ? (byte)1 : this.q, ((do)this).f, n, n2);
    }

    static {
        b = 0;
    }
}
