/*
 * Decompiled with CFR 0.152.
 */
final class v
extends cl {
    private int d;
    private int e;

    v(byte by, byte by2, int n, int n2, int n3, boolean bl) {
        super(by, by2, n);
        this.d = n2 + 8;
        this.e = n3 + 8;
        this.b = bl;
    }

    final void a(int n, int n2) {
        if (this.a == null) {
            ((df)this).a = true;
            return;
        }
        this.a.a(this.a, (byte)1, this.b % ((df)this).a, n += this.d, n2 += this.e);
    }
}
