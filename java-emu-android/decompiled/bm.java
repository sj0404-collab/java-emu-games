/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class bm
extends aw {
    protected cx a;
    protected byte[] a;
    protected byte a = new cx("/t/n");

    public bm(ah ah2) {
        super(ah2, (byte)28, (byte)4, (byte)7);
        this.g = rpg.a.b < 240 ? rpg.a.b - 174 - 33 >> 1 : this.g;
        this.g = this.g < 0 ? 0 : this.g;
    }

    protected boolean a(dg dg2) {
        return true;
    }

    protected final void a(cr cr2, bp bp2) {
        int n2 = this.f + 40;
        int n3 = this.g + 17;
        cr2.a(15723216);
        ah.d(cr2, n2 - 1, n3 - 1, 106, 61);
        for (int i2 = 0; i2 < 28; ++i2) {
            dg dg2 = bp2.a(i2);
            int n4 = i2 / 7;
            int n5 = i2 - n4 * 7;
            n5 = n2 + n5 * 15;
            n4 = n3 + n4 * 15;
            if (dg2 != null) {
                boolean bl2 = this.a(dg2);
                if (!bl2) {
                    cr2.b(127);
                }
                dg2.a(cr2, n5, n4);
                if (!bl2) {
                    cr2.b(255);
                }
                if (dg2.i > 1) {
                    ah.b(cr2, dg2.i, n5 + 14 - 1, n4 + 14 - 7, 8, 0);
                }
                if (!dg2.c()) continue;
                cr2.a(0xFF0000);
                cr2.d(n5, n4, 13, 13);
                continue;
            }
            cr2.a(0);
            ah.d(cr2, n5, n4, 14, 14);
        }
    }

    protected final void b(cr cr2) {
        int n2 = this.d / 7;
        int n3 = this.d % 7;
        n3 = this.f + 40 + n3 * 15;
        n2 = this.g + 17 + n2 * 15;
        bm.b(cr2, n3, n2);
    }

    protected static void b(cr cr2, int n2, int n3) {
        cr2.a(0x660000);
        cr2.d(n2, n3 - 1, 13, 15);
        cr2.e(n2 - 1, n3, n2 - 1, n3 + 14 - 1);
        cr2.e(n2 + 14, n3, n2 + 14, n3 + 14 - 1);
        cr2.a(0xFF0000);
        cr2.e(n2, n3 + 1, n2, n3 + 14 - 1 - 1);
        cr2.e(n2 + 14 - 1, n3 + 1, n2 + 14 - 1, n3 + 14 - 1 - 1);
        cr2.e(n2 + 1, n3, n2 + 14 - 2, n3);
        cr2.e(n2 + 1, n3 + 14 - 1, n2 + 14 - 2, n3 + 14 - 1);
    }

    protected final void a(cr cr2, byte n2, byte by2, boolean bl2) {
        int n3 = this.g + 16;
        byte[] byArray = new byte[1];
        byte[] byArray2 = byArray;
        byArray[0] = 65;
        for (int i2 = 0; i2 < n2; ++i2) {
            cr2.a(i2 == by2 ? (bl2 ? 0xFF0000 : 15723216) : 3550755);
            int n4 = n3 + i2 * 10 + 3;
            cr2.a(this.f + 20, n4, 11, 12);
            cr2.e(this.f + 11 + 20, n4 + 1, this.f + 11 + 20, n4 + 9 - 2);
            cr2.a(!bl2 && i2 == by2 ? 3550755 : 0xFFFFFF);
            dv.a(cr2, this.f + 2 + 20, n4 - 2, byArray2, 0);
            byArray2[0] = (byte)(byArray2[0] + 1);
        }
    }

    static void a(cr cr2, int n2, int n3, byte[] byArray, int n4) {
        int n5 = 3 + n4 * 15;
        cr2.b(n2 + 10, n3 + (n5 + 174 >> 1), 140, n5);
        ah.c(cr2, n2 + 10, n3 + (n5 + 174 >> 1), 140, n5);
        cr2.a(0);
        cr2.d(n2 + 10, n3 + (n5 + 174 >> 1), 139, n5 - 1);
        cr2.a(0xFFFFFF);
        cr2.d(n2 + 10 + 1, n3 + (n5 + 174 >> 1) + 1, 137, n5 - 3);
        cr2.a(0);
        if (n4 < 2) {
            dv.a(cr2, n2 + 80, n3 + (n5 + 174 >> 1) + 2, byArray, 0, 1);
            return;
        }
        dv.a(cr2, n2 + 10 + 5, n3 + (n5 + 174 >> 1) + 2, byArray, 0, 4);
    }
}

