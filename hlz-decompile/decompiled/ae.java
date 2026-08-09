/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

abstract class ae
extends ah {
    ae(ah ah2, byte by, byte by2, byte by3) {
        super(ah2, by, by2, by3);
    }

    ae(ah ah2, byte by) {
        this(ah2, by, 1, 1);
    }

    protected final void a(cr cr2, int n, int n2, int n3, int n4, int n5) {
        int n6 = ah.a(n3);
        int n7 = n;
        if (n5 == 8) {
            n7 = n - (n6 + 7 + ah.a(n4));
        } else if (n5 == 1) {
            n7 = n - (n6 + 7 + ah.a(n4) >> 1);
        }
        ah.b(cr2, n3, n7, n2, 4, 0);
        cr2.b(n7 + n6, n2, 7, 7);
        cr2.a(rpg.c.x, n7 + n6 - 7, n2, 20);
        ah.b(cr2, n4, n7 + n6 + 7, n2, 4, 0);
    }

    protected static void a(cr cr2, int n, int n2) {
        cr2.a(0xFFFFFF);
        for (int i = 0; i < 3; ++i) {
            cr2.e(n + (i << 2), n2, n + (i << 2) + 2, n2);
        }
    }

    protected final void a(byte[] byArray) {
        this.b = new bi((ah)this, byArray, '\u0000');
    }
}
