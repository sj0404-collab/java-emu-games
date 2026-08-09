/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class cp
extends db {
    public static byte f;
    public static short d;
    private boolean f;

    public cp(short s2, short s3, boolean bl2) {
        super(s2, s3, d, f, ((db)dl.a).a, true);
        this.i((byte)1);
        this.a((byte)8);
        this.f = bl2;
    }

    protected final void c() {
        this.i = this.p == 8 ? (byte)8 : (this.p == 6 ? (byte)10 : (byte)9);
        this.c = this.a.a(this.i);
    }

    public final void m() {
        switch (this.p) {
            case 8: {
                if (!this.i()) break;
                this.a((byte)1);
                return;
            }
            case 6: {
                if (!this.i()) break;
                this.a((byte)7);
                return;
            }
            default: {
                if (!this.f || ((am)this).c != 0) break;
                do[] doArray = db.a();
                for (int i2 = 0; i2 < 2; ++i2) {
                    if (doArray[i2] == null || this.a((c)doArray[i2]) > this.j) continue;
                    this.b(doArray[i2], (int)this.a(), (byte)0);
                    ((am)this).c = this.k;
                }
            }
        }
    }

    protected final void c(int n2, int n3) {
        this.a.a(this.i, this.q, ((do)this).f, n2, n3);
    }

    public final void d(int n2) {
    }

    public final void l() {
        this.o();
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

    protected final int a(int n2) {
        super.a(n2);
        return n2;
    }
}

