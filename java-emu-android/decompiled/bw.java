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

    public bw(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2, null);
        this.b(this.a);
        dl.a(this);
    }

    protected final void c() {
    }

    public final void m() {
    }

    protected final void a(byte by2) {
    }

    protected final void c(int n2, int n3) {
    }

    final void b(byte by2, int n2) {
        dl.a.b(by2, n2);
    }

    final void a(byte by2, byte by3, int n2) {
        dl.a.a(by2, by3, n2);
    }

    final boolean a(byte by2, int n2) {
        return dl.a.a(by2, n2);
    }

    protected final void a(do do_, int n2) {
        dl.a.a(do_, n2);
    }

    protected final void c(int n2) {
        dl.a.c(n2);
    }

    protected final int c() {
        return dl.a.c();
    }

    protected final boolean e() {
        return dl.a.e();
    }

    protected final void a(do do_, int n2, byte by2, byte by3) {
        super.a(do_, n2 / 4, by2, by3);
        do_ = this;
        if (!dl.a.e()) {
            ((db)this).m = 0;
            ((db)dl.a).m = (byte)2;
            dl.a.n = by2;
        }
    }

    protected final void o() {
        this.c(this.a);
        super.o();
    }
}

