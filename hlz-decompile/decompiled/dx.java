/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class dx
extends df {
    private at a;
    private byte a = 0;

    dx(at at2, byte by) {
        super((byte)-20);
        this.a = at2;
        this.a = by;
        ((df)this).a = this.a.a(by);
        this.c = 1;
    }

    final void a(int n, int n2) {
        this.a.a(this.a, (byte)1, this.b % ((df)this).a, n, n2);
    }

    final void a() {
        ++this.b;
        if (this.b >= ((df)this).a) {
            ((df)this).a = true;
        }
    }
}
