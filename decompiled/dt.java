/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dt
implements g {
    public static at[] a;
    public static byte[] a;
    public static byte[] b;

    public static final void a(byte[] byArray, byte by2, byte[] byArray2) {
        byte by3 = byArray[0];
        byte[] byArray3 = c.a("/en/cif/h" + (by3 < 10 ? "0" : "") + by3);
        dt.a[by2] = new at();
        a[by2].a(byArray3, true);
        byArray3 = new byte[4];
        System.arraycopy(byArray, 1, byArray3, 0, 4);
        byte[] byArray4 = new byte[4];
        System.arraycopy(byArray, 5, byArray4, 0, 4);
        dt.a(a[by2], byArray3, byArray4, byArray2);
        dt.a[by2].a = null;
        dt.a[by2] = byArray[9];
        dt.b[by2] = byArray[10];
    }

    private static void a(at at2, byte[] byArray, byte[] byArray2, byte[] byArray3) {
        for (int i2 = 0; i2 < byArray2.length; ++i2) {
            if (byArray2[i2] == 0) continue;
            String string = "/en/" + i2 + "/" + (byArray2[i2] < 10 ? "0" : "") + byArray2[i2];
            byte[] byArray4 = null;
            if (byArray[i2] > 0) {
                byArray4 = c.a(byArray3, byArray[i2] - 1);
            }
            at2.a(i2, string, byArray4);
        }
        at2.a = null;
    }
}

