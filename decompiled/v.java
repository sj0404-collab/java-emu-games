/*
 * Decompiled with CFR 0.152.
 */
final class v
extends cl {
    private int d;
    private int e;

    v(byte by2, byte by3, int n2, int n3, int n4, boolean bl2) {
        super(by2, by3, n2);
        this.d = n3 + 8;
        this.e = n4 + 8;
        this.b = bl2;
    }

    final void a(int n2, int n3) {
        if (this.a == null) {
            ((df)this).a = true;
            return;
        }
        this.a.a(this.a, (byte)1, this.b % ((df)this).a, n2 += this.d, n3 += this.e);
    }
}

