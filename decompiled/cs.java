/*
 * Decompiled with CFR 0.152.
 */
final class cs
extends db {
    public static byte f = 0;
    public static short d;
    private int b = 0;

    public cs(short s2, short s3, at at2) {
        super(s2, s3, d, f, at2, true);
        this.a((byte)8);
        this.b = 50;
    }

    protected final void d() {
        --this.b;
        if (this.b == 0) {
            this.e = 0;
            this.a((byte)6);
        }
        super.d();
    }

    protected final void c() {
        switch (this.p) {
            case 8: {
                this.i = (byte)10;
                break;
            }
            case 3: {
                this.i = (byte)11;
                break;
            }
            case 6: {
                this.i = (byte)13;
                break;
            }
            default: {
                this.i = (byte)12;
            }
        }
        this.c = this.a.a(this.i);
    }

    protected final void c(int n2, int n3) {
        this.a.a(this.i, this.i == 12 ? this.q : (byte)1, ((do)this).f, n2, n3);
    }

    protected final void i() {
        if (((do)this).f == 1) {
            this.a(g.b_, this.a(), true);
        }
        if (this.i()) {
            this.a((byte)1);
        }
    }

    public final void l() {
        this.a((byte)7);
        r.a.d(this);
    }
}

