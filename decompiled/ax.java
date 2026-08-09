/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;

final class ax
extends df {
    private int d;

    ax(byte by2) {
        super(by2);
        this.a = 4;
    }

    ax(byte by2, byte by3) {
        super(by2);
        if (this.b == -6) {
            this.a = 2;
            this.c = -1;
            this.d = by3;
            return;
        }
        this.a = 4;
        this.d = 0;
    }

    ax(byte by2, byte by3, int n2) {
        this(by2, by3);
        if (this.b == -6) {
            this.c = n2;
            return;
        }
        this.d = n2;
    }

    final void a(int n2, int n3) {
        cr cr2 = rpg.a.a;
        switch (this.b) {
            case -1: {
                cr2.a(rpg.c.i[this.b < 2 ? 3 : 2], n2, n3 - 35 - this.b * 3, 17);
                return;
            }
            case -2: {
                cr2.a(rpg.c.i[this.b < 2 ? 1 : 0], n2, n3 - 35 - this.b * 3, 17);
                return;
            }
            case -4: {
                ah.b(cr2, this.d, n2, n3 - 35 - (this.b << 2), 1, this.b < 2 ? 8 : 6);
                return;
            }
            case -5: {
                ah.b(cr2, this.d, n2, n3 - 35 - (this.b << 2), 1, this.b < 2 ? 7 : 5);
                return;
            }
            case -3: {
                cr2.a(rpg.c.j[this.b < 2 ? 0 : 1], n2, n3 - 35 - this.b * 3, 17);
                return;
            }
            case -6: {
                if (this.d < 8 || this.d == 10) {
                    cr2.a(rpg.c.a[0], n2, n3 - 36, 3);
                }
                cr2.a(rpg.c.a[this.d], n2, n3 - 38 + this.b % 2, 3);
            }
        }
    }
}

