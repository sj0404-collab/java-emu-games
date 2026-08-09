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

    public static void a(cr cr2, int n2, int n3, byte[] byArray, int n4) {
        dv.a(cr2, n2, n3, 1000, n4, byArray, 0, 0, byArray.length);
    }

    public static void a(cr cr2, int n2, int n3, int n4, int n5, byte[] byArray) {
        dv.a(cr2, n2, n3, n4, n5, byArray, 0, 0, byArray.length);
    }

    public static void a(cr cr2, int n2, int n3, byte[] byArray, int n4, int n5) {
        byte[] byArray2 = byArray;
        int n6 = dv.b(byArray, 0, 0);
        switch (n5) {
            case 4: {
                n6 = 0;
                break;
            }
            case 1: {
                n6 /= 2;
            }
        }
        dv.a(cr2, n2 - n6, n3, 1000, n4, byArray, 0, 0, byArray.length);
    }

    public static void a(cr cr2, int n2, int n3, int n4, int n5, byte[] byArray, int n6, int n7, int n8) {
        dv.a(cr2, n2, n3, n4, byArray, n6, n7, n8, 4);
    }

    public static void a(cr cr2, int n2, int n3, int n4, byte[] byArray, int n5, int n6, int n7, int n8) {
        try {
            int n9;
            int n10;
            if (!b) {
                return;
            }
            int n11 = n5;
            int n12 = n2;
            switch (n8) {
                case 4: {
                    n12 = n2;
                    break;
                }
                case 1: {
                    n12 = n2 - (dv.b(byArray, n5, n4) >> 1);
                }
            }
            int n13 = 0;
            for (n10 = 0; n10 < n5; ++n10) {
                if ((byArray[n10] & 0x80) != 0) {
                    ++n10;
                    continue;
                }
                n9 = dv.a(byArray[n10]);
                if (n9 == -1 || !a) continue;
                cr2.a(n9);
            }
            while (n11 < n5 + n6) {
                if ((byArray[n11] & 0xF0) == 240) {
                    if (n13 + b > n4) {
                        n13 = 0;
                        n3 += a + 2;
                        switch (n8) {
                            case 4: {
                                n12 = n2;
                                break;
                            }
                            case 1: {
                                n12 = n2 - (dv.b(byArray, n11, n4) >> 1);
                            }
                        }
                        continue;
                    }
                    n11 += 2;
                    n13 += b + 1;
                    continue;
                }
                if ((byArray[n11] & 0x80) != 0) {
                    if (n13 + 8 > n4) {
                        n13 = 0;
                        n3 += 12;
                        switch (n8) {
                            case 4: {
                                n12 = n2;
                                break;
                            }
                            case 1: {
                                n12 = n2 - (dv.b(byArray, n11, n4) >> 1);
                            }
                        }
                        continue;
                    }
                    n11 += 2;
                    n13 += 9;
                    continue;
                }
                n10 = dv.a(byArray[n11]);
                if (n10 != -1 && a) {
                    cr2.a(n10);
                    ++n11;
                    continue;
                }
                if (n13 == 0 && byArray[n11] == 32) {
                    ++n11;
                    continue;
                }
                n9 = b >> 2;
                n10 = a.indexOf((char)byArray[n11]);
                if (n10 >= 0 && n10 < b.length) {
                    n9 = b[n10];
                }
                if (n13 + n9 > n4 || byArray[n11] == 59) {
                    n13 = 0;
                    n3 += a + 2;
                    if (byArray[n11] == 59) {
                        ++n11;
                    }
                    switch (n8) {
                        case 4: {
                            n12 = n2;
                            break;
                        }
                        case 1: {
                            n12 = n2 - (dv.b(byArray, n11, n4) >> 1);
                        }
                    }
                    continue;
                }
                ++n11;
                n13 += n9;
            }
            n12 += n13;
            while (n11 < byArray.length && n11 < n5 + n7) {
                int n14;
                int n15;
                int n16;
                int n17;
                if ((byArray[n11] & 0xF0) == 240) {
                    if (n13 + b > n4) {
                        n13 = 0;
                        n3 += a + 2;
                        switch (n8) {
                            case 4: {
                                n12 = n2;
                                break;
                            }
                            case 1: {
                                n12 = n2 - (dv.b(byArray, n11, n4) >> 1);
                            }
                        }
                        continue;
                    }
                    n10 = byArray[n11++] & 0xF;
                    if ((n10 = (n10 << 8) + (n9 = byArray[n11++] & 0xFF)) < c) {
                        n6 = 0;
                        n17 = 0;
                        n16 = 0;
                        while (n16 < a[n10].length) {
                            n15 = 7;
                            n14 = b;
                            while (n14 > 0) {
                                if (n15 < 0) {
                                    ++n16;
                                    n15 = 7;
                                }
                                if ((a[n10][n16] & 1 << n15) != 0) {
                                    cr2.e(n12 + n17, n3 + n6, n12 + n17, n3 + n6);
                                }
                                ++n17;
                                --n14;
                                --n15;
                            }
                            ++n16;
                            ++n6;
                            n17 = 0;
                        }
                    }
                    n12 += b + 1;
                    n13 += b + 1;
                    continue;
                }
                if ((byArray[n11] & 0x80) != 0) {
                    if (n13 + 8 > n4) {
                        n13 = 0;
                        n3 += 12;
                        switch (n8) {
                            case 4: {
                                n12 = n2;
                                break;
                            }
                            case 1: {
                                n12 = n2 - (dv.b(byArray, n11, n4) >> 1);
                            }
                        }
                        continue;
                    }
                    n11 += 2;
                    n12 += 9;
                    n13 += 9;
                    continue;
                }
                n10 = dv.a(byArray[n11]);
                if (n10 != -1 && a) {
                    cr2.a(n10);
                    ++n11;
                    continue;
                }
                if (n13 == 0 && byArray[n11] == 32) {
                    ++n11;
                    continue;
                }
                n9 = b >> 2;
                n10 = a.indexOf((char)byArray[n11]);
                if (n10 >= 0 && n10 < b.length) {
                    n9 = b[n10];
                }
                if (n13 + n9 > n4 || byArray[n11] == 59) {
                    n13 = 0;
                    n3 += a + 2;
                    if (byArray[n11] == 59) {
                        ++n11;
                    }
                    switch (n8) {
                        case 4: {
                            n12 = n2;
                            break;
                        }
                        case 1: {
                            n12 = n2 - (dv.b(byArray, n11, n4) >> 1);
                        }
                    }
                    continue;
                }
                if (n10 >= 0 && n10 < e) {
                    n6 = 0;
                    n17 = 0;
                    n16 = 0;
                    while (n16 < a[n10].length) {
                        n15 = 7 - c[n10];
                        n14 = b[n10];
                        while (n14 > 0) {
                            if (n15 < 0) {
                                ++n16;
                                n15 = 7;
                            }
                            if ((a[n10][n16] & 1 << n15) != 0) {
                                cr2.e(n12 + n17, n3 + n6, n12 + n17, n3 + n6);
                            }
                            ++n17;
                            --n14;
                            --n15;
                        }
                        n16 += n16 + 1 & 1;
                        ++n16;
                        ++n6;
                        n17 = 0;
                    }
                }
                n12 += n9;
                n13 += n9;
                ++n11;
            }
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public static final int a(byte[] byArray, int n2, int n3, int n4) {
        int n5 = n2;
        int n6 = 0;
        int n7 = 0;
        while (n6 < n4 && n2 < byArray.length) {
            if (byArray[n2] == 32 && n7 == 0) {
                ++n2;
                continue;
            }
            if ((byArray[n2] & 0xF0) == 240) {
                if (n7 + b > n3) {
                    ++n6;
                    n7 = 0;
                    continue;
                }
                n7 += b + 1;
                n2 += 2;
                continue;
            }
            if ((byArray[n2] & 0x80) != 0) {
                if (n7 + 8 > n3) {
                    ++n6;
                    n7 = 0;
                    continue;
                }
                n7 += 9;
                n2 += 2;
                continue;
            }
            if (dv.a(byArray[n2])) {
                if (byArray[n2] == 59) {
                    ++n6;
                    n7 = 0;
                }
                ++n2;
                continue;
            }
            int n8 = b >> 2;
            int n9 = a.indexOf((char)byArray[n2]);
            if (n9 >= 0 && n9 < b.length) {
                n8 = b[n9];
            }
            if (n7 + n8 > n3) {
                ++n6;
                n7 = 0;
                continue;
            }
            n7 += n8;
            ++n2;
        }
        return n2 - n5;
    }

    public static final int a(byte[] byArray, int n2, int n3) {
        n3 = n2 + n3;
        boolean bl2 = false;
        while (n3 < byArray.length) {
            if (byArray[n3] == 32 || dv.a(byArray[n3])) {
                ++n3;
                continue;
            }
            if ((byArray[n3] & 0x80) != 0) {
                if (bl2) {
                    return n3 + 2 - n2;
                }
                bl2 = true;
                n3 += 2;
                continue;
            }
            if (bl2) {
                return n3 + 1 - n2;
            }
            bl2 = true;
            ++n3;
        }
        return byArray.length - n2;
    }

    public static final int a(byte[] byArray, int n2) {
        int n3 = 0;
        int n4 = dv.a(byArray, 0, n2, 0);
        while (n4 < byArray.length) {
            n4 = dv.a(byArray, 0, n2, ++n3);
        }
        return n3;
    }

    public static final int a(byte[] byArray) {
        return dv.b(byArray, 0, 0);
    }

    public static final int b(byte[] byArray, int n2, int n3) {
        int n4 = 1;
        while (n2 < byArray.length) {
            int n5 = n4;
            if ((byArray[n2] & 0xF0) == 240) {
                n4 += b + 1;
                n2 += 2;
            } else if ((byArray[n2] & 0x80) != 0) {
                n4 += 9;
                n2 += 2;
            } else {
                if (byArray[n2] == 59) break;
                if (dv.a(byArray[n2])) {
                    ++n2;
                } else {
                    int n6 = b >> 2;
                    int n7 = a.indexOf((char)byArray[n2]);
                    if (n7 >= 0 && n7 < b.length) {
                        n6 = b[n7];
                    }
                    n4 += n6;
                    ++n2;
                }
            }
            if (n3 <= 0 || n4 <= n3) continue;
            return n5;
        }
        if (n4 == 1) {
            return 0;
        }
        return n4;
    }

    private static final boolean a(byte by2) {
        if (by2 == 59) {
            return true;
        }
        for (int i2 = 0; i2 < a.length; ++i2) {
            if (by2 != a[i2]) continue;
            return true;
        }
        return false;
    }

    private static final int a(byte by2) {
        for (int i2 = 0; i2 < a.length; ++i2) {
            if (by2 != a[i2]) continue;
            return a[i2];
        }
        return -1;
    }

    public static final void a() {
        if (b) {
            return;
        }
        try {
            int n2;
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
            for (n2 = 0; n2 < c; ++n2) {
                dataInputStream.read(byArray);
                dv.a[n2] = dv.a(byArray);
            }
            dataInputStream.close();
            for (n2 = 0; n2 < e; ++n2) {
                int n3;
                int n4;
                int n5;
                int n6;
                int n7 = 0;
                for (n6 = 0; n6 < a[n2].length; ++n6) {
                    n5 = 7;
                    n4 = b;
                    while (n4 > 0) {
                        if (n5 < 0) {
                            ++n6;
                            n5 = 7;
                        }
                        dv.b[n7] = (a[n2][n6] & 1 << n5) != 0 ? 1 : 0;
                        ++n7;
                        --n4;
                        --n5;
                    }
                }
                n7 = 0;
                n6 = b - 1;
                for (n5 = 0; n5 < b; ++n5) {
                    n4 = 0;
                    for (n3 = 0; n3 < b.length; n3 += b) {
                        if (b[n5 + n3] != 1) continue;
                        n4 = 1;
                        break;
                    }
                    if (n4 == 0) continue;
                    n7 = n5;
                    break;
                }
                for (n5 = b - 1; n5 >= 0; --n5) {
                    n4 = 0;
                    for (n3 = 0; n3 < b.length; n3 += b) {
                        if (b[n5 + n3] != 1) continue;
                        n4 = 1;
                        break;
                    }
                    if (n4 == 0) continue;
                    n6 = n5;
                    break;
                }
                dv.c[n2] = (byte)n7;
                dv.b[n2] = (byte)(n6 - n7 + 2);
                if (c[n2] + b[n2] > b) {
                    dv.b[n2] = (byte)(b - c[n2]);
                }
                if (a.substring(n2, n2 + 1).equals(".")) {
                    int n8 = n2;
                    c[n8] = (byte)(c[n8] - 1);
                    int n9 = n2;
                    b[n9] = (byte)(b[n9] + 3);
                    continue;
                }
                if (!a.substring(n2, n2 + 1).equals(" ")) continue;
                dv.c[n2] = 0;
                dv.b[n2] = 6;
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
        int n2 = 0;
        int n3 = 0;
        while (n2 < byArray.length) {
            byArray2[n3] = byArray[n2];
            byArray2[n3 + 1] = (byte)(byArray[n2 + 1] & 0xF0);
            byArray2[n3 + 2] = byArray[n2 + 2];
            byArray2[n3 + 3] = (byte)((byArray[n2 + 1] & 0xF) << 4);
            n2 += 3;
            n3 += 4;
        }
        return byArray2;
    }

    static {
        e = 0;
    }
}

