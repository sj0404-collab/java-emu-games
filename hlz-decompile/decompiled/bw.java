/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class bw
extends ec {
    private byte[] a = rpg.c.a(ec.b, 13);

    public bw(short s, short s2, short s3, byte by) {
        super(s, s2, s3, by, null);
        this.b(this.a);
        dl.a(this);
    }

    protected final void c() {
    }

    public final void m() {
    }

    protected final void a(byte by) {
    }

    protected final void c(int n, int n2) {
    }

    final void b(byte by, int n) {
        dl.a.b(by, n);
    }

    final void a(byte by, byte by2, int n) {
        dl.a.a(by, by2, n);
    }

    final boolean a(byte by, int n) {
        return dl.a.a(by, n);
    }

    protected final void a(do do_, int n) {
        dl.a.a(do_, n);
    }

    protected final void c(int n) {
        dl.a.c(n);
    }

    protected final int c() {
        return dl.a.c();
    }

    protected final boolean e() {
        return dl.a.e();
    }

    protected final void a(do do_, int n, byte by, byte by2) {
        super.a(do_, n / 4, by, by2);
        do_ = this;
        if (!dl.a.e()) {
            ((db)this).m = 0;
            ((db)dl.a).m = (byte)2;
            dl.a.n = by;
        }
    }

    protected final void o() {
        this.c(this.a);
        super.o();
    }
}
