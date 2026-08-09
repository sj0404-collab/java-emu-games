/*
 * Decompiled with CFR 0.152.
 */
package rpg;

import java.util.Random;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class f {
    private static Random a = new Random();

    public static final byte[] a(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
        System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
        return byArray3;
    }

    public static long a(byte[] byArray, int n) {
        return (long)f.a(byArray, n) << 32 | (long)f.a(byArray, n + 4) & 0xFFFFFFFFL;
    }

    public static final int a(byte[] byArray, int n) {
        return (byArray[n] & 0xFF) << 24 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n + 2] & 0xFF) << 8 | byArray[n + 3] & 0xFF;
    }

    public static final int b(byte[] byArray, int n) {
        return (byArray[n + 3] & 0xFF) << 24 | (byArray[n + 2] & 0xFF) << 16 | (byArray[n + 1] & 0xFF) << 8 | byArray[n] & 0xFF;
    }

    public static final short a(byte[] byArray, int n) {
        return (short)((byArray[n + 1] & 0xFF) << 8 | byArray[n] & 0xFF);
    }

    public static final short b(byte[] byArray, int n) {
        return (short)((byArray[n] & 0xFF) << 8 | byArray[n + 1] & 0xFF);
    }

    public static final void a(int n, byte[] byArray, int n2) {
        byte[] byArray2 = new byte[]{0, 0, 0, 0};
        byArray2[0] = (byte)(n >>> 24);
        byArray2[1] = (byte)(n >> 16);
        byArray2[2] = (byte)(n >> 8);
        byArray2[3] = (byte)n;
        System.arraycopy(byArray2, 0, byArray, n2, 4);
    }

    public static final void a(short s, byte[] byArray, int n) {
        byArray[n] = (byte)(s >> 8);
        byArray[n + 1] = (byte)s;
    }

    public static void a(long l, byte[] byArray, int n) {
        int n2 = (int)(l >> 32);
        f.a(n2, byArray, n);
        n2 = (int)l;
        f.a(n2, byArray, n + 4);
    }

    public static final synchronized int a(int n, int n2) {
        if ((n2 = n2 - n + 1) == 0) {
            return 0;
        }
        n2 = Math.abs(a.nextInt()) % n2;
        return n + n2;
    }

    public static final int a(Random random, int n, int n2) {
        if ((n2 = n2 - n + 1) == 0) {
            return 0;
        }
        int n3 = Math.abs(random.nextInt()) % n2;
        return n + n3;
    }

    public static final long a() {
        return System.currentTimeMillis() / 1000L;
    }
}
