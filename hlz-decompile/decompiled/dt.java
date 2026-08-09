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

    public static final void a(byte[] byArray, byte by, byte[] byArray2) {
        byte by2 = byArray[0];
        byte[] byArray3 = c.a("/en/cif/h" + (by2 < 10 ? "0" : "") + by2);
        dt.a[by] = new at();
        a[by].a(byArray3, true);
        byArray3 = new byte[4];
        System.arraycopy(byArray, 1, byArray3, 0, 4);
        byte[] byArray4 = new byte[4];
        System.arraycopy(byArray, 5, byArray4, 0, 4);
        dt.a(a[by], byArray3, byArray4, byArray2);
        dt.a[by].a = null;
        dt.a[by] = byArray[9];
        dt.b[by] = byArray[10];
    }

    private static void a(at at2, byte[] byArray, byte[] byArray2, byte[] byArray3) {
        for (int i = 0; i < byArray2.length; ++i) {
            if (byArray2[i] == 0) continue;
            String string = "/en/" + i + "/" + (byArray2[i] < 10 ? "0" : "") + byArray2[i];
            byte[] byArray4 = null;
            if (byArray[i] > 0) {
                byArray4 = c.a(byArray3, byArray[i] - 1);
            }
            at2.a(i, string, byArray4);
        }
        at2.a = null;
    }
}
