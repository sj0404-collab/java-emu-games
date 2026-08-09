/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class cu
extends db {
    public cu(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2, b.a[by2].a, false);
        this.p = 1;
        ((do)this).f = -1;
        this.c = this.a.a((byte)0);
    }

    public final void a(byte by2) {
        if (by2 == 6 || by2 == 7) {
            super.a(by2);
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

    protected final void a(do do_, int n2) {
        super.a(do_, n2);
        ((do)this).f = this.c - this.c * this.c() / this.d() - 1;
    }

    protected final void c(int n2, int n3) {
        switch (this.p) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                this.a.a((byte)0, (byte)1, ((do)this).f, n2, n3);
                return;
            }
            case 6: {
                super.c(n2, n3);
            }
        }
    }

    final void b(byte by2, int n2) {
    }

    final void a(byte by2, byte by3, int n2) {
    }

    final boolean a(byte by2, int n2) {
        return true;
    }

    final boolean a(byte by2) {
        return true;
    }
}

