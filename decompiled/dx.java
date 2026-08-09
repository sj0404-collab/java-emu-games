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

    dx(at at2, byte by2) {
        super((byte)-20);
        this.a = at2;
        this.a = by2;
        ((df)this).a = this.a.a(by2);
        this.c = 1;
    }

    final void a(int n2, int n3) {
        this.a.a(this.a, (byte)1, this.b % ((df)this).a, n2, n3);
    }

    final void a() {
        ++this.b;
        if (this.b >= ((df)this).a) {
            ((df)this).a = true;
        }
    }
}

