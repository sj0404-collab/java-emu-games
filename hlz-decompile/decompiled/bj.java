/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

final class bj
extends df {
    bj(byte by) {
        super(by);
        byte by2 = rpg.c.a.a(this.b);
        this.a = by2;
        this.c = by2;
    }

    bj(byte by, int n) {
        this(by);
        this.c = n;
    }

    final void a(int n, int n2) {
        rpg.c.a.a(this.b, (byte)1, this.b % this.a, n, n2);
    }

    final void a() {
        ++this.b;
        if (this.b >= this.c) {
            this.a = true;
        }
    }
}
