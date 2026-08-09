/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dv {
    private static boolean b = false;
    public static boolean a = true;
    private static final byte[] a = new byte[]{38, 124, 36, 123, 125, 94, 92};
    private static final int[] a = new int[]{0xFFFFFF, 0xFFFF00, 1630207, 0xFF9F3F, 14597755, 65280, 0x7F7F7F};
    public static int a;
    private static int b;
    private static String a;
    private static int c;
    private static byte[][] a;
    private static int d;
    private static int[] b;
    private static byte[] b;
    private static byte[] c;
    private static int e;

    public static void a(cr cr2, int n, int n2, byte[] byArray, int n3) {
        dv.a(cr2, n, n2, 1000, n3, byArray, 0, 0, byArray.length);
    }

    public static void a(cr cr2, int n, int n2, int n3, int n4, byte[] byArray) {
        dv.a(cr2, n, n2, n3, n4, byArray, 0, 0, byArray.length);
    }

    public static void a(cr cr2, int n, int n2, byte[] byArray, int n3, int n4) {
        byte[] byArray2 = byArray;
        int n5 = dv.b(byArray, 0, 0);
        switch (n4) {
            case 4: {
                n5 = 0;
                break;
            }
            case 1: {
                n5 /= 2;
            }
        }
        dv.a(cr2, n - n5, n2, 1000, n3, byArray, 0, 0, byArray.length);
    }

    public static void a(cr cr2, int n, int n2, int n3, int n4, byte[] byArray, int n5, int n6, int n7) {
        dv.a(cr2, n, n2, n3, byArray, n5, n6, n7, 4);
    }

    public static void a(cr cr2, int n, int n2, int n3, byte[] byArray, int n4, int n5, int n6, int n7) {
        try {
            int n8;
            int n9;
            if (!b) {
                return;
            }
            int n10 = n4;
            int n11 = n;
            switch (n7) {
                case 4: {
                    n11 = n;
                    break;
                }
                case 1: {
                    n11 = n - (dv.b(byArray, n4, n3) >> 1);
                }
            }
            int n12 = 0;
            for (n9 = 0; n9 < n4; ++n9) {
                if ((byArray[n9] & 0x80) != 0) {
                    ++n9;
                    continue;
                }
                n8 = dv.a(byArray[n9]);
                if (n8 == -1 || !a) continue;
                cr2.a(n8);
            }
            while (n10 < n4 + n5) {
                if ((byArray[n10] & 0xF0) == 240) {
                    if (n12 + b > n3) {
                        n12 = 0;
                        n2 += a + 2;
                        switch (n7) {
                            case 4: {
                                n11 = n;
                                break;
                            }
                            case 1: {
                                n11 = n - (dv.b(byArray, n10, n3) >> 1);
                            }
                        }
                        continue;
                    }
                    n10 += 2;
                    n12 += b + 1;
                    continue;
                }
                if ((byArray[n10] & 0x80) != 0) {
                    if (n12 + 8 > n3) {
                        n12 = 0;
                        n2 += 12;
                        switch (n7) {
                            case 4: {
                                n11 = n;
                                break;
                            }
                            case 1: {
                                n11 = n - (dv.b(byArray, n10, n3) >> 1);
                            }
                        }
                        continue;
                    }
                    n10 += 2;
                    n12 += 9;
                    continue;
                }
                n9 = dv.a(byArray[n10]);
                if (n9 != -1 && a) {
                    cr2.a(n9);
                    ++n10;
                    continue;
                }
                if (n12 == 0 && byArray[n10] == 32) {
                    ++n10;
                    continue;
                }
                n8 = b >> 2;
                n9 = a.indexOf((char)byArray[n10]);
                if (n9 >= 0 && n9 < b.length) {
                    n8 = b[n9];
                }
                if (n12 + n8 > n3 || byArray[n10] == 59) {
                    n12 = 0;
                    n2 += a + 2;
                    if (byArray[n10] == 59) {
                        ++n10;
                    }
                    switch (n7) {
                        case 4: {
                            n11 = n;
                            break;
                        }
                        case 1: {
                            n11 = n - (dv.b(byArray, n10, n3) >> 1);
                        }
                    }
                    continue;
                }
                ++n10;
                n12 += n8;
            }
            n11 += n12;
            while (n10 < byArray.length && n10 < n4 + n6) {
                int n13;
                int n14;
                int n15;
                int n16;
                if ((byArray[n10] & 0xF0) == 240) {
                    if (n12 + b > n3) {
                        n12 = 0;
                        n2 += a + 2;
                        switch (n7) {
                            case 4: {
                                n11 = n;
                                break;
                            }
                            case 1: {
                                n11 = n - (dv.b(byArray, n10, n3) >> 1);
                            }
                        }
                        continue;
                    }
                    n9 = byArray[n10++] & 0xF;
                    if ((n9 = (n9 << 8) + (n8 = byArray[n10++] & 0xFF)) < c) {
                        n5 = 0;
                        n16 = 0;
                        n15 = 0;
                        while (n15 < a[n9].length) {
                            n14 = 7;
                            n13 = b;
                            while (n13 > 0) {
                                if (n14 < 0) {
                                    ++n15;
                                    n14 = 7;
                                }
                                if ((a[n9][n15] & 1 << n14) != 0) {
                                    cr2.e(n11 + n16, n2 + n5, n11 + n16, n2 + n5);
                                }
                                ++n16;
                                --n13;
                                --n14;
                            }
                            ++n15;
                            ++n5;
                            n16 = 0;
                        }
                    }
                    n11 += b + 1;
                    n12 += b + 1;
                    continue;
                }
                if ((byArray[n10] & 0x80) != 0) {
                    if (n12 + 8 > n3) {
                        n12 = 0;
                        n2 += 12;
                        switch (n7) {
                            case 4: {
                                n11 = n;
                                break;
                            }
                            case 1: {
                                n11 = n - (dv.b(byArray, n10, n3) >> 1);
                            }
                        }
                        continue;
                    }
                    n10 += 2;
                    n11 += 9;
                    n12 += 9;
                    continue;
                }
                n9 = dv.a(byArray[n10]);
                if (n9 != -1 && a) {
                    cr2.a(n9);
                    ++n10;
                    continue;
                }
                if (n12 == 0 && byArray[n10] == 32) {
                    ++n10;
                    continue;
                }
                n8 = b >> 2;
                n9 = a.indexOf((char)byArray[n10]);
                if (n9 >= 0 && n9 < b.length) {
                    n8 = b[n9];
                }
                if (n12 + n8 > n3 || byArray[n10] == 59) {
                    n12 = 0;
                    n2 += a + 2;
                    if (byArray[n10] == 59) {
                        ++n10;
                    }
                    switch (n7) {
                        case 4: {
                            n11 = n;
                            break;
                        }
                        case 1: {
                            n11 = n - (dv.b(byArray, n10, n3) >> 1);
                        }
                    }
                    continue;
                }
                if (n9 >= 0 && n9 < e) {
                    n5 = 0;
                    n16 = 0;
                    n15 = 0;
                    while (n15 < a[n9].length) {
                        n14 = 7 - c[n9];
                        n13 = b[n9];
                        while (n13 > 0) {
                            if (n14 < 0) {
                                ++n15;
                                n14 = 7;
                            }
                            if ((a[n9][n15] & 1 << n14) != 0) {
                                cr2.e(n11 + n16, n2 + n5, n11 + n16, n2 + n5);
                            }
                            ++n16;
                            --n13;
                            --n14;
                        }
                        n15 += n15 + 1 & 1;
                        ++n15;
                        ++n5;
                        n16 = 0;
                    }
                }
                n11 += n8;
                n12 += n8;
                ++n10;
            }
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public static final int a(byte[] byArray, int n, int n2, int n3) {
        int n4 = n;
        int n5 = 0;
        int n6 = 0;
        while (n5 < n3 && n < byArray.length) {
            if (byArray[n] == 32 && n6 == 0) {
                ++n;
                continue;
            }
            if ((byArray[n] & 0xF0) == 240) {
                if (n6 + b > n2) {
                    ++n5;
                    n6 = 0;
                    continue;
                }
                n6 += b + 1;
                n += 2;
                continue;
            }
            if ((byArray[n] & 0x80) != 0) {
                if (n6 + 8 > n2) {
                    ++n5;
                    n6 = 0;
                    continue;
                }
                n6 += 9;
                n += 2;
                continue;
            }
            if (dv.a(byArray[n])) {
                if (byArray[n] == 59) {
                    ++n5;
                    n6 = 0;
                }
                ++n;
                continue;
            }
            int n7 = b >> 2;
            int n8 = a.indexOf((char)byArray[n]);
            if (n8 >= 0 && n8 < b.length) {
                n7 = b[n8];
            }
            if (n6 + n7 > n2) {
                ++n5;
                n6 = 0;
                continue;
            }
            n6 += n7;
            ++n;
        }
        return n - n4;
    }

    public static final int a(byte[] byArray, int n, int n2) {
        n2 = n + n2;
        boolean bl = false;
        while (n2 < byArray.length) {
            if (byArray[n2] == 32 || dv.a(byArray[n2])) {
                ++n2;
                continue;
            }
            if ((byArray[n2] & 0x80) != 0) {
                if (bl) {
                    return n2 + 2 - n;
                }
                bl = true;
                n2 += 2;
                continue;
            }
            if (bl) {
                return n2 + 1 - n;
            }
            bl = true;
            ++n2;
        }
        return byArray.length - n;
    }

    public static final int a(byte[] byArray, int n) {
        int n2 = 0;
        int n3 = dv.a(byArray, 0, n, 0);
        while (n3 < byArray.length) {
            n3 = dv.a(byArray, 0, n, ++n2);
        }
        return n2;
    }

    public static final int a(byte[] byArray) {
        return dv.b(byArray, 0, 0);
    }

    public static final int b(byte[] byArray, int n, int n2) {
        int n3 = 1;
        while (n < byArray.length) {
            int n4 = n3;
            if ((byArray[n] & 0xF0) == 240) {
                n3 += b + 1;
                n += 2;
            } else if ((byArray[n] & 0x80) != 0) {
                n3 += 9;
                n += 2;
            } else {
                if (byArray[n] == 59) break;
                if (dv.a(byArray[n])) {
                    ++n;
                } else {
                    int n5 = b >> 2;
                    int n6 = a.indexOf((char)byArray[n]);
                    if (n6 >= 0 && n6 < b.length) {
                        n5 = b[n6];
                    }
                    n3 += n5;
                    ++n;
                }
            }
            if (n2 <= 0 || n3 <= n2) continue;
            return n4;
        }
        if (n3 == 1) {
            return 0;
        }
        return n3;
    }

    private static final boolean a(byte by) {
        if (by == 59) {
            return true;
        }
        for (int i = 0; i < a.length; ++i) {
            if (by != a[i]) continue;
            return true;
        }
        return false;
    }

    private static final int a(byte by) {
        for (int i = 0; i < a.length; ++i) {
            if (by != a[i]) continue;
            return a[i];
        }
        return -1;
    }

    public static final void a() {
        if (b) {
            return;
        }
        try {
            int n;
            DataInputStream dataInputStream = new DataInputStream("".getClass().getResourceAsStream("/dotFontSmall.dat"));
            c = dataInputStream.readShort();
            a = dataInputStream.readUTF();
            e = a.length();
            b = new byte[e];
            c = new byte[e];
            b = 12;
            a = 12;
            b = new int[b * a];
            d = 2;
            a = new byte[c][];
            byte[] byArray = new byte[a * d * 3 / 4];
            for (n = 0; n < c; ++n) {
                dataInputStream.read(byArray);
                dv.a[n] = dv.a(byArray);
            }
            dataInputStream.close();
            for (n = 0; n < e; ++n) {
                int n2;
                int n3;
                int n4;
                int n5;
                int n6 = 0;
                for (n5 = 0; n5 < a[n].length; ++n5) {
                    n4 = 7;
                    n3 = b;
                    while (n3 > 0) {
                        if (n4 < 0) {
                            ++n5;
                            n4 = 7;
                        }
                        dv.b[n6] = (a[n][n5] & 1 << n4) != 0 ? 1 : 0;
                        ++n6;
                        --n3;
                        --n4;
                    }
                }
                n6 = 0;
                n5 = b - 1;
                for (n4 = 0; n4 < b; ++n4) {
                    n3 = 0;
                    for (n2 = 0; n2 < b.length; n2 += b) {
                        if (b[n4 + n2] != 1) continue;
                        n3 = 1;
                        break;
                    }
                    if (n3 == 0) continue;
                    n6 = n4;
                    break;
                }
                for (n4 = b - 1; n4 >= 0; --n4) {
                    n3 = 0;
                    for (n2 = 0; n2 < b.length; n2 += b) {
                        if (b[n4 + n2] != 1) continue;
                        n3 = 1;
                        break;
                    }
                    if (n3 == 0) continue;
                    n5 = n4;
                    break;
                }
                dv.c[n] = (byte)n6;
                dv.b[n] = (byte)(n5 - n6 + 2);
                if (c[n] + b[n] > b) {
                    dv.b[n] = (byte)(b - c[n]);
                }
                if (a.substring(n, n + 1).equals(".")) {
                    int n7 = n;
                    c[n7] = (byte)(c[n7] - 1);
                    int n8 = n;
                    b[n8] = (byte)(b[n8] + 3);
                    continue;
                }
                if (!a.substring(n, n + 1).equals(" ")) continue;
                dv.c[n] = 0;
                dv.b[n] = 6;
            }
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
        b = true;
    }

    private static byte[] a(byte[] byArray) {
        byte[] byArray2 = new byte[(byArray.length << 2) / 3];
        int n = 0;
        int n2 = 0;
        while (n < byArray.length) {
            byArray2[n2] = byArray[n];
            byArray2[n2 + 1] = (byte)(byArray[n + 1] & 0xF0);
            byArray2[n2 + 2] = byArray[n + 2];
            byArray2[n2 + 3] = (byte)((byArray[n + 1] & 0xF) << 4);
            n += 3;
            n2 += 4;
        }
        return byArray2;
    }

    static {
        e = 0;
    }
}
