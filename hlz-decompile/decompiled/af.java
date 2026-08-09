/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class af {
    private static boolean a = false;
    private static InputStream a = null;
    private static DataInputStream a = null;
    private static OutputStream a = null;

    public static final boolean a() {
        return false;
    }

    public static final void a(boolean bl) {
    }

    public static final byte[] a(byte by, byte[] byArray) {
        int n = 5;
        if (byArray != null) {
            n = 5 + byArray.length;
        }
        byte[] byArray2 = new byte[n];
        byte[] byArray3 = byArray2;
        byArray2[0] = (byte)(n >>> 24);
        byArray3[1] = (byte)(n >> 16);
        byArray3[2] = (byte)(n >> 8);
        byArray3[3] = (byte)n;
        byArray3[4] = by;
        if (byArray != null) {
            System.arraycopy(byArray, 0, byArray3, 5, byArray.length);
        }
        return byArray3;
    }
}
