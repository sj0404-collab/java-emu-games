/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class cl
extends df {
    protected byte a;
    protected at a;
    private byte d;
    private static final byte[] a = new byte[]{0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 0, 0, 1, 0, 0, 0, 1};

    cl(byte by, byte by2, int n) {
        super(by);
        this.c = (byte)n;
        this.a = a[by - 30];
        this.d = by2;
        this.a = rpg.c.a[this.d];
        ((df)this).a = this.a.a(this.a);
        if (by == 41 || by == 37) {
            this.b = false;
        }
    }

    void a(int n, int n2) {
        if (this.a == null) {
            ((df)this).a = true;
            return;
        }
        this.a.a(this.a, (byte)1, this.b % ((df)this).a, n, n2);
    }
}
