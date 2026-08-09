/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

abstract class ae
extends ah {
    ae(ah ah2, byte by2, byte by3, byte by4) {
        super(ah2, by2, by3, by4);
    }

    ae(ah ah2, byte by2) {
        this(ah2, by2, 1, 1);
    }

    protected final void a(cr cr2, int n2, int n3, int n4, int n5, int n6) {
        int n7 = ah.a(n4);
        int n8 = n2;
        if (n6 == 8) {
            n8 = n2 - (n7 + 7 + ah.a(n5));
        } else if (n6 == 1) {
            n8 = n2 - (n7 + 7 + ah.a(n5) >> 1);
        }
        ah.b(cr2, n4, n8, n3, 4, 0);
        cr2.b(n8 + n7, n3, 7, 7);
        cr2.a(rpg.c.x, n8 + n7 - 7, n3, 20);
        ah.b(cr2, n5, n8 + n7 + 7, n3, 4, 0);
    }

    protected static void a(cr cr2, int n2, int n3) {
        cr2.a(0xFFFFFF);
        for (int i2 = 0; i2 < 3; ++i2) {
            cr2.e(n2 + (i2 << 2), n3, n2 + (i2 << 2) + 2, n3);
        }
    }

    protected final void a(byte[] byArray) {
        this.b = new bi((ah)this, byArray, '\u0000');
    }
}

