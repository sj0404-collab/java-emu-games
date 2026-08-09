/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

final class bj
extends df {
    bj(byte by2) {
        super(by2);
        byte by3 = rpg.c.a.a(this.b);
        this.a = by3;
        this.c = by3;
    }

    bj(byte by2, int n2) {
        this(by2);
        this.c = n2;
    }

    final void a(int n2, int n3) {
        rpg.c.a.a(this.b, (byte)1, this.b % this.a, n2, n3);
    }

    final void a() {
        ++this.b;
        if (this.b >= this.c) {
            this.a = true;
        }
    }
}

