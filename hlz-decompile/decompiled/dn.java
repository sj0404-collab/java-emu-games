/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class dn
extends df {
    private static final byte[] a = new byte[]{17, 19, 8, 18, 17, 9, 16, 16, 17, 18, 19, 13};
    private byte a = (byte)(this.b - 11);
    private byte d = 1;

    dn(byte by) {
        super(by);
        this.c = ((df)this).a = (int)rpg.c.a.a(a[this.a]);
    }

    dn(byte by, int n) {
        this(by);
        this.c = n;
    }

    dn(byte by, byte by2) {
        this(by);
        if (this.b == 15) {
            this.d = by2;
        }
    }

    final void a(int n, int n2) {
        rpg.c.a.a(a[this.a], this.d, this.b % ((df)this).a, n, n2);
    }

    final void a() {
        ++this.b;
        if (this.b >= this.c) {
            ((df)this).a = true;
        }
    }
}
