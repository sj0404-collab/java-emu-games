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
        int n = this.f + 40;
        int n2 = this.g + 17;
        cr2.a(15723216);
        ah.d(cr2, n - 1, n2 - 1, 106, 61);
        for (int i = 0; i < 28; ++i) {
            dg dg2 = bp2.a(i);
            int n3 = i / 7;
            int n4 = i - n3 * 7;
            n4 = n + n4 * 15;
            n3 = n2 + n3 * 15;
            if (dg2 != null) {
                boolean bl = this.a(dg2);
                if (!bl) {
                    cr2.b(127);
                }
                dg2.a(cr2, n4, n3);
                if (!bl) {
                    cr2.b(255);
                }
                if (dg2.i > 1) {
                    ah.b(cr2, dg2.i, n4 + 14 - 1, n3 + 14 - 7, 8, 0);
                }
                if (!dg2.c()) continue;
                cr2.a(0xFF0000);
                cr2.d(n4, n3, 13, 13);
                continue;
            }
            cr2.a(0);
            ah.d(cr2, n4, n3, 14, 14);
        }
    }

    protected final void b(cr cr2) {
        int n = this.d / 7;
        int n2 = this.d % 7;
        n2 = this.f + 40 + n2 * 15;
        n = this.g + 17 + n * 15;
        bm.b(cr2, n2, n);
    }

    protected static void b(cr cr2, int n, int n2) {
        cr2.a(0x660000);
        cr2.d(n, n2 - 1, 13, 15);
        cr2.e(n - 1, n2, n - 1, n2 + 14 - 1);
        cr2.e(n + 14, n2, n + 14, n2 + 14 - 1);
        cr2.a(0xFF0000);
        cr2.e(n, n2 + 1, n, n2 + 14 - 1 - 1);
        cr2.e(n + 14 - 1, n2 + 1, n + 14 - 1, n2 + 14 - 1 - 1);
        cr2.e(n + 1, n2, n + 14 - 2, n2);
        cr2.e(n + 1, n2 + 14 - 1, n + 14 - 2, n2 + 14 - 1);
    }

    protected final void a(cr cr2, byte n, byte by, boolean bl) {
        int n2 = this.g + 16;
        byte[] byArray = new byte[1];
        byte[] byArray2 = byArray;
        byArray[0] = 65;
        for (int i = 0; i < n; ++i) {
            cr2.a(i == by ? (bl ? 0xFF0000 : 15723216) : 3550755);
            int n3 = n2 + i * 10 + 3;
            cr2.a(this.f + 20, n3, 11, 12);
            cr2.e(this.f + 11 + 20, n3 + 1, this.f + 11 + 20, n3 + 9 - 2);
            cr2.a(!bl && i == by ? 3550755 : 0xFFFFFF);
            dv.a(cr2, this.f + 2 + 20, n3 - 2, byArray2, 0);
            byArray2[0] = (byte)(byArray2[0] + 1);
        }
    }

    static void a(cr cr2, int n, int n2, byte[] byArray, int n3) {
        int n4 = 3 + n3 * 15;
        cr2.b(n + 10, n2 + (n4 + 174 >> 1), 140, n4);
        ah.c(cr2, n + 10, n2 + (n4 + 174 >> 1), 140, n4);
        cr2.a(0);
        cr2.d(n + 10, n2 + (n4 + 174 >> 1), 139, n4 - 1);
        cr2.a(0xFFFFFF);
        cr2.d(n + 10 + 1, n2 + (n4 + 174 >> 1) + 1, 137, n4 - 3);
        cr2.a(0);
        if (n3 < 2) {
            dv.a(cr2, n + 80, n2 + (n4 + 174 >> 1) + 2, byArray, 0, 1);
            return;
        }
        dv.a(cr2, n + 10 + 5, n2 + (n4 + 174 >> 1) + 2, byArray, 0, 4);
    }
}
