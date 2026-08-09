/*
 * Decompiled with CFR 0.152.
 */
final class ds
extends cf {
    public static ds a = null;

    public ds(short s, short s2, short s3, byte by) {
        super(s, s2, s3, by);
        this.h = (byte)3;
        this.Z = new byte[]{0};
        this.aa[0] = 10;
        if (this.e == 111 || this.e == 113) {
            a = this;
            this.f = true;
        }
        this.aa[0] = 10;
    }

    protected final boolean a(int n) {
        boolean bl = false;
        switch (this.u) {
            case 0: {
                bl = n == 4 || n == 7;
                break;
            }
            case 1: {
                bl = n == 4;
            }
        }
        return bl;
    }

    protected final boolean a() {
        return false;
    }

    protected final void e() {
        switch (this.u) {
            case 0: {
                if (((do)this).f == 4) {
                    this.f();
                    return;
                }
                this.g();
                return;
            }
            case 1: {
                this.a(((c)((ec)this).a).c, ((c)((ec)this).a).d, false);
            }
        }
    }

    protected final void c() {
        if (this.p == 6) {
            this.c_();
            return;
        }
        switch (this.p) {
            case 3: {
                switch (this.u) {
                    case 0: {
                        this.i = (byte)2;
                        break;
                    }
                    case 1: {
                        this.i = (byte)4;
                    }
                }
                break;
            }
            case 4: {
                this.i = (byte)3;
                break;
            }
            case 100: {
                this.i = (byte)5;
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

    protected final void e_() {
        if (this.i()) {
            if (cg.a == null || cg.a.d()) {
                if (cg.a != null) {
                    cg.a.l();
                    cg.a = null;
                }
                a = null;
                this.l();
                return;
            }
            this.a((byte)100);
        }
    }
}
