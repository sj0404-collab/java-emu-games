/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class cu
extends db {
    public cu(short s, short s2, short s3, byte by) {
        super(s, s2, s3, by, b.a[by].a, false);
        this.p = 1;
        ((do)this).f = -1;
        this.c = this.a.a((byte)0);
    }

    public final void a(byte by) {
        if (by == 6 || by == 7) {
            super.a(by);
        }
    }

    public final void d() {
        if (this.p == 6) {
            ++((do)this).f;
        }
        this.z();
        if (this.p == 6) {
            this.e_();
        }
    }

    protected final void p() {
    }

    protected final void a(do do_, int n) {
        super.a(do_, n);
        ((do)this).f = this.c - this.c * this.c() / this.d() - 1;
    }

    protected final void c(int n, int n2) {
        switch (this.p) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                this.a.a((byte)0, (byte)1, ((do)this).f, n, n2);
                return;
            }
            case 6: {
                super.c(n, n2);
            }
        }
    }

    final void b(byte by, int n) {
    }

    final void a(byte by, byte by2, int n) {
    }

    final boolean a(byte by, int n) {
        return true;
    }

    final boolean a(byte by) {
        return true;
    }
}
