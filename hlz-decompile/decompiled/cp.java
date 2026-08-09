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

    public cp(short s, short s2, boolean bl) {
        super(s, s2, d, f, ((db)dl.a).a, true);
        this.i((byte)1);
        this.a((byte)8);
        this.f = bl;
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
                for (int i = 0; i < 2; ++i) {
                    if (doArray[i] == null || this.a((c)doArray[i]) > this.j) continue;
                    this.b(doArray[i], (int)this.a(), (byte)0);
                    ((am)this).c = this.k;
                }
            }
        }
    }

    protected final void c(int n, int n2) {
        this.a.a(this.i, this.q, ((do)this).f, n, n2);
    }

    public final void d(int n) {
    }

    public final void l() {
        this.o();
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

    protected final int a(int n) {
        super.a(n);
        return n;
    }
}
