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

    cl(byte by2, byte by3, int n2) {
        super(by2);
        this.c = (byte)n2;
        this.a = a[by2 - 30];
        this.d = by3;
        this.a = rpg.c.a[this.d];
        ((df)this).a = this.a.a(this.a);
        if (by2 == 41 || by2 == 37) {
            this.b = false;
        }
    }

    void a(int n2, int n3) {
        if (this.a == null) {
            ((df)this).a = true;
            return;
        }
        this.a.a(this.a, (byte)1, this.b % ((df)this).a, n2, n3);
    }
}

