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

    dn(byte by2) {
        super(by2);
        this.c = ((df)this).a = (int)rpg.c.a.a(a[this.a]);
    }

    dn(byte by2, int n2) {
        this(by2);
        this.c = n2;
    }

    dn(byte by2, byte by3) {
        this(by2);
        if (this.b == 15) {
            this.d = by3;
        }
    }

    final void a(int n2, int n3) {
        rpg.c.a.a(a[this.a], this.d, this.b % ((df)this).a, n2, n3);
    }

    final void a() {
        ++this.b;
        if (this.b >= this.c) {
            ((df)this).a = true;
        }
    }
}

