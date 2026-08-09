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

    z(boolean bl2, int n2, byte[] byArray, int n3, int n4) {
        super((byte)-10);
        this.c = bl2;
        this.d = n2;
        this.a = byArray;
        this.b = false;
        if (bl2) {
            this.e = n3 + 8;
            this.f = 0;
            this.g = bh.h;
        } else {
            this.e = 0;
            this.f = n4 - 8 + 2;
            this.g = bh.g;
        }
        ((df)this).a = byArray.length;
    }

    final void a(int n2, int n3) {
        n2 += this.e;
        n3 += this.f;
        cr cr2 = rpg.a.a;
        cr2.a(this.d);
        byte by2 = this.a[this.b];
        if (this.c) {
            cr2.a(n2 - (by2 >> 1), 0, (int)by2, this.g);
            return;
        }
        cr2.a(0, n3 - (by2 >> 1), this.g, (int)by2);
    }
}

