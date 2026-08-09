/*
 * Decompiled with CFR 0.152.
 */
import rpg.b;
import rpg.c;
import rpg.e;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class j
extends ah {
    public byte a;
    protected int a = 0;
    protected int b;
    protected int c = 0;
    protected int d;
    protected int e;
    public byte b = 0;
    public static boolean a = false;
    public static byte c = 0;

    public static byte[] a() {
        byte[] byArray = rpg.e.a.a(0);
        if (c == 0) {
            byte[][] byArrayArray = new byte[6][];
            byte[][] byArrayArray2 = byArrayArray;
            byArrayArray[0] = rpg.b.o;
            byArrayArray2[1] = rpg.b.p;
            byte[] byArray2 = rpg.e.a.a(0);
            byArrayArray2[2] = ("" + byArray2[0]).getBytes();
            byArrayArray2[3] = ("" + byArray2[1]).getBytes();
            byArrayArray2[4] = ("" + byArray2[0] / byArray2[1]).getBytes();
            byArrayArray2[5] = null;
            return bd.a(byArrayArray2, rpg.b.d);
        }
        if (c < byArray[1]) {
            byte[][] byArrayArray = new byte[8][];
            byte[][] byArrayArray3 = byArrayArray;
            byArrayArray[0] = rpg.b.o;
            byArrayArray3[1] = rpg.b.p;
            byte[] byArray3 = rpg.e.a.a(0);
            byArrayArray3[2] = ("" + byArray3[0]).getBytes();
            byArrayArray3[3] = ("" + byArray3[1]).getBytes();
            byArrayArray3[4] = ("" + byArray3[0] / byArray3[1]).getBytes();
            byArrayArray3[5] = ("" + c).getBytes();
            byArrayArray3[6] = ("" + (byArray[1] - c)).getBytes();
            byArrayArray3[7] = null;
            return bd.a(byArrayArray3, rpg.b.c);
        }
        return null;
    }

    public j(ah ah2, int n2, int n3, int n4, byte by2) {
        super(ah2, (byte)n2, (byte)n3, (byte)n4);
        this.a = by2;
    }

    public final byte a() {
        return ((ah)this).d;
    }

    public static void a(cr cr2, int n2, int n3, int n4, int n5) {
        cr2.b(n2 - 1, n3 - 1, n4 + 2, n5 + 2);
        int n6 = n4 / 20 + 1;
        int n7 = n5 / 20 + 1;
        for (int i2 = 0; i2 < n6; ++i2) {
            for (int i3 = 0; i3 < n7; ++i3) {
                cr2.a(rpg.c.v, n2 + i2 * 20, n3 + i3 * 20, 20);
            }
        }
        cr2.a(15723216);
        cr2.d(n2, n3, n4 - 1, n5 - 1);
        cr2.a(3550755);
        cr2.d(n2 - 1, n3 - 1, n4 + 1, n5 + 1);
    }
}

