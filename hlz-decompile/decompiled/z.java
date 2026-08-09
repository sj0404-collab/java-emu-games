/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;

final class z
extends df {
    private int d;
    private boolean c = false;
    private int e;
    private int f;
    private byte[] a;
    private int g;

    z(boolean bl, int n, byte[] byArray, int n2, int n3) {
        super((byte)-10);
        this.c = bl;
        this.d = n;
        this.a = byArray;
        this.b = false;
        if (bl) {
            this.e = n2 + 8;
            this.f = 0;
            this.g = bh.h;
        } else {
            this.e = 0;
            this.f = n3 - 8 + 2;
            this.g = bh.g;
        }
        ((df)this).a = byArray.length;
    }

    final void a(int n, int n2) {
        n += this.e;
        n2 += this.f;
        cr cr2 = rpg.a.a;
        cr2.a(this.d);
        byte by = this.a[this.b];
        if (this.c) {
            cr2.a(n - (by >> 1), 0, (int)by, this.g);
            return;
        }
        cr2.a(0, n2 - (by >> 1), this.g, (int)by);
    }
}
