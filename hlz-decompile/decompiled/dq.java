/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dq {
    private static final String[] a = new String[]{"IHDR", "cHRM", "gAMA", "iCCP", "sBIT", "sRGB", "tEXt", "zTXt", "iTXt", "pHYs", "sPLT", "tIME", "PLTE", "tRNS", "hIST", "bKGD", "IDAT", "IEND"};
    private static final byte[] a = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] b = new byte[]{0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
    private String a;
    private boolean a;
    private boolean b;
    private int a;
    private int[] a;
    private byte[] c;
    private Object[] a;
    private char[] a;
    private int b;
    private int c;
    private boolean c = true;
    private byte a;
    private int[] b = null;
    private cq[] a = null;
    private static final int[] c = new int[256];
    private int d = -1;
    private int e = 1;

    public dq(String string) {
        this.a(string);
    }

    private void a(String object) {
        int n;
        this.a = null;
        this.c = null;
        this.a = null;
        this.a = null;
        this.a = object;
        byte[] byArray = rpg.c.a(this.a.concat(".mpm"));
        object = byArray;
        if (byArray[0] == -1 || object[0] == -2) {
            int n2;
            this.b = object[0] == -1;
            this.a = 1;
            byte[] byArray2 = new byte[((Object)object).length - 1];
            System.arraycopy(object, 1, byArray2, 0, byArray2.length);
            int n3 = 0;
            ++n3;
            this.b = new int[(byArray2[0] & 0xFF) + 1];
            this.b[0] = 0;
            for (n2 = 1; n2 < this.b.length; ++n2) {
                this.b[n2] = 0xFF000000 | (byArray2[n3] & 0xFF) << 16 | (byArray2[n3 + 1] & 0xFF) << 8 | byArray2[n3 + 2] & 0xFF;
                n3 += 3;
            }
            this.a = new cq[1];
            n2 = 0;
            int n4 = byArray2[n3++] & 0xFF;
            int n5 = byArray2[n3++] & 0xFF;
            int n6 = n3;
            while (n3 < byArray2.length) {
                if (byArray2[n3] == -1) {
                    Object[] objectArray = new byte[n3 - n6];
                    System.arraycopy(byArray2, n6, objectArray, 0, objectArray.length);
                    cq cq2 = new cq();
                    new cq().b = (short)n4;
                    cq2.a = (short)n5;
                    cq2.a = objectArray;
                    if (n2 >= this.a.length) {
                        objectArray = new cq[n2 + 1];
                        System.arraycopy(this.a, 0, objectArray, 0, n2);
                        this.a = (cq[])objectArray;
                    }
                    this.a[n2++] = cq2;
                    if (n3 < byArray2.length - 1) {
                        int n7 = ++n3;
                        n4 = byArray2[n7] & 0xFF;
                        int n8 = ++n3;
                        n5 = byArray2[n8] & 0xFF;
                        n6 = ++n3;
                        continue;
                    }
                }
                ++n3;
            }
            return;
        }
        this.a = 0;
        this.c = dq.a((byte[])object, 0);
        int n9 = 0 + (2 + this.c.length);
        dq dq2 = this;
        int n10 = dq.a(dq2.c, 0);
        dq2.a = (n10 >> 27) % 2 == 1;
        dq2.b = (n10 >> 26) % 2 == 1;
        n10 = dq2.a();
        dq2.a = 0;
        for (n = 0; n < n10; ++n) {
            if (dq2.a >= dq.a(dq2.c, 8 + n * 8) + '\u0001') continue;
            dq2.a = dq.a(dq2.c, 8 + n * 8) + '\u0001';
        }
        dq2.a = new int[dq2.a];
        for (n = 0; n < n10; ++n) {
            char c2 = dq.a(dq2.c, 8 + n * 8);
            dq2.a[c2] = dq2.a[c2] + 1;
        }
        dq2.a = new Object[dq2.a];
        dq2.a = new char[n10];
        for (n = 0; n < n10; ++n) {
            dq2.a[n] = dq.a(dq2.c, 8 + n * 8 + 6);
        }
        dq2.b = dq.b(dq2.c, 12);
        dq2.c = dq.b(dq2.c, 13);
        for (int i = 0; i < this.a; ++i) {
            byte[] byArray3 = dq.a((byte[])object, n9);
            this.a[i] = byArray3;
            n9 += 2 + byArray3.length;
        }
    }

    private static byte[] a(byte[] byArray, int n) {
        short s = (short)((byArray[n] & 0xFF) << 8 | byArray[n + 1] & 0xFF);
        byte[] byArray2 = new byte[s];
        System.arraycopy(byArray, n + 2, byArray2, 0, s);
        return byArray2;
    }

    public final int a() {
        if (this.a == 1) {
            return this.a.length;
        }
        return dq.a(this.c, 4);
    }

    public final cw a(int n) {
        if (this.a == 1) {
            cq cq2 = this.a[n];
            int[] nArray = new int[cq2.b * cq2.a];
            int n2 = 0;
            int n3 = 0;
            while (n3 < cq2.a.length) {
                int n4 = cq2.a[n3++] & 0xFF;
                int n5 = cq2.a[n3++] & 0xFF;
                while (n5 > 0) {
                    nArray[n2++] = this.b[n4];
                    --n5;
                }
            }
            return cw.a(nArray, cq2.b, cq2.a, true);
        }
        byte[] byArray = this.b(n);
        return cw.a(byArray, 0, byArray.length);
    }

    public final cw[] a() {
        boolean bl = true;
        dq dq2 = this;
        this.c = true;
        int n = this.a();
        cw[] cwArray = new cw[n];
        for (int i = 0; i < n; ++i) {
            cwArray[i] = this.a(i);
        }
        return cwArray;
    }

    public final void a(cw[] cwArray, int n) {
        n = 1;
        dq dq2 = this;
        this.c = true;
        int n2 = this.a();
        for (int i = 0; i < n2; ++i) {
            cwArray[i + 0] = this.a(i);
        }
    }

    public final cw b(int n) {
        byte[] byArray;
        block12: {
            int n2;
            int n3;
            if (!this.b) {
                return this.a(n);
            }
            if (this.a == 1) {
                int n4;
                int n5;
                int n6;
                cq cq2 = this.a[n];
                int[] nArray = new int[cq2.b * cq2.a];
                int[] nArray2 = new int[cq2.b * cq2.a];
                int n7 = 0;
                int n8 = 0;
                while (n8 < cq2.a.length) {
                    n6 = cq2.a[n8++] & 0xFF;
                    for (n5 = n4 = cq2.a[n8++] & 0xFF; n5 > 0; --n5) {
                        nArray2[n7++] = this.b[n6];
                    }
                }
                for (n8 = 0; n8 < cq2.b; ++n8) {
                    n6 = 0;
                    n4 = n8;
                    n5 = cq2.b - n8 - 1;
                    while (n6 < cq2.a) {
                        nArray[n4] = nArray2[n5];
                        ++n6;
                        n4 += cq2.b;
                        n5 += cq2.b;
                    }
                }
                return cw.a(nArray, cq2.b, cq2.a, true);
            }
            byArray = this.b(n);
            int n9 = dq.a(byArray, 16, 8, byArray.length);
            int n10 = dq.a(byArray, 0, 8, byArray.length);
            int n11 = dq.a(byArray, n10 + 8);
            int n12 = dq.a(byArray, n10 + 12);
            int n13 = byArray[n10 + 16];
            int n14 = n9;
            int n15 = n13;
            n10 = n12;
            n9 = n11;
            n13 = n14;
            byte[] byArray2 = byArray;
            dq dq2 = this;
            int n16 = 8 / n15;
            int n17 = (n9 - 1) / n16 + 1;
            int n18 = 255 >> 8 - n15;
            int n19 = n13 + 15;
            int n20 = (n17 + 1) * n10;
            int n21 = n9 / 2;
            int n22 = n19 + n20;
            int n23 = n22 + 4;
            n13 += 4;
            for (n3 = 0; n3 < n10; ++n3) {
                if (byArray2[n19 + (n17 + 1) * n3] == 0) {
                    continue;
                }
                break block12;
            }
            for (int i = 0; i < n10; ++i) {
                n3 = n19 + (n17 + 1) * i + 1;
                for (int j = 0; j < n21; ++j) {
                    n2 = n9 - 1 - j;
                    int n24 = n3 + j / n16;
                    int n25 = n3 + n2 / n16;
                    int n26 = j % n16;
                    n2 %= n16;
                    n26 = (byte)((n16 - n26 - 1) * n15);
                    n2 = (byte)((n16 - n2 - 1) * n15);
                    byte by = (byte)(byArray2[n24] >> n26 & n18);
                    byte by2 = (byte)(byArray2[n25] >> n2 & n18);
                    byArray2[n24] = (byte)(byArray2[n24] & ~(n18 << n26) | by2 << n26);
                    byArray2[n25] = (byte)(byArray2[n25] & ~(n18 << n2) | by << n2);
                }
            }
            dq dq3 = dq2;
            dq2.e = 1;
            n16 = n20;
            n15 = n19;
            byte[] byArray3 = byArray2;
            dq3 = dq2;
            n17 = dq3.e & 0xFFFF;
            n18 = dq3.e >> 16 & 0xFFFF;
            while (n16 > 0) {
                n19 = n16 < 5552 ? n16 : 5552;
                n16 -= n19;
                while (n19-- > 0) {
                    n18 += (n17 += byArray3[n15++] & 0xFF);
                }
                n17 %= 65521;
                n18 %= 65521;
            }
            dq3.e = n18 << 16 | n17;
            dq3 = dq2;
            long l = dq3.e;
            System.arraycopy(dq.c((int)l), 0, byArray2, n22, 4);
            dq3 = dq2;
            dq2.d = -1;
            dq2.a(byArray2, n13, n20 + 15);
            dq3 = dq2;
            n2 = ~dq3.d;
            System.arraycopy(dq.c(n2), 0, byArray2, n23, 4);
        }
        return cw.a(byArray, 0, byArray.length);
    }

    public final void a(int n, int n2) {
        if (!this.a) {
            return;
        }
        int n3 = n2;
        int n4 = n;
        n = 4;
        int n5 = this.b;
        byte[] byArray = this.c;
        dq dq2 = this;
        if (dq2.a == 1) {
            int n6 = -1;
            for (int i = 0; i < dq2.b.length; ++i) {
                if (dq2.b[i] != n4) continue;
                n6 = i;
                break;
            }
            if (n6 >= 0) {
                dq2.b[n6] = n3;
            }
            return;
        }
        int n7 = dq.a(byArray, n5);
        int n8 = n5 + 8;
        int n9 = n8 + n7;
        int n10 = n4 >> 16;
        byte by = (byte)(n4 >> 8);
        n4 = (byte)n4;
        byte by2 = (byte)(n3 >> 16);
        byte by3 = (byte)(n3 >> 8);
        n3 = (byte)n3;
        for (int i = 0; i < n7 / 3; ++i) {
            if (byArray[n8 + i * 3] != n10 || byArray[n8 + i * 3 + 1] != by || byArray[n8 + i * 3 + 2] != n4) continue;
            byArray[n8 + i * 3] = by2;
            byArray[n8 + i * 3 + 1] = by3;
            byArray[n8 + i * 3 + 2] = n3;
        }
        dq dq3 = dq2;
        dq2.d = -1;
        dq2.a(byArray, n5 + 4, n7 + 4);
        dq3 = dq2;
        n10 = ~dq3.d;
        System.arraycopy(dq.c(n10), 0, byArray, n9, 4);
    }

    private byte[] a(int n) {
        n = dq.a(this.c, 8 + n * 8);
        if (this.c && this.a[n] == null) {
            dq dq2 = this;
            for (int i = 0; i < dq2.a; ++i) {
                dq2.a[i] = null;
            }
            this.a[n] = rpg.c.a(this.a.concat("_").concat(String.valueOf(n)).concat(".mpd"));
        }
        return (byte[])this.a[n];
    }

    private byte[] b(int n) {
        if (this.a) {
            byte[] byArray = this.a(n);
            int n2 = dq.a(this.c, 8 + (n << 3) + 2);
            int n3 = this.a(n);
            int n4 = 8 + (this.c.length - ((dq.a(this.c, 4) << 3) + 8));
            n4 += n3;
            byte[] byArray2 = new byte[n4 += 12];
            System.arraycopy(a, 0, byArray2, 0, 8);
            int n5 = dq.a(byArray, 0, n2, n3);
            if (n5 == -1) {
                return null;
            }
            int n6 = dq.a(byArray, n5) + 12;
            System.arraycopy(byArray, n5, byArray2, 8, n6);
            int n7 = n6 + 8;
            block3: for (int i = 0; i < 18; ++i) {
                if (!this.a(n, i)) continue;
                switch (i) {
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 9: 
                    case 10: {
                        n5 = dq.a(byArray, i, n2, n3);
                        if (n5 == -1) continue block3;
                        n6 = dq.a(byArray, n5) + 12;
                        System.arraycopy(byArray, n5, byArray2, n7, n6);
                        n7 += n6;
                    }
                }
            }
            n5 = this.b;
            n6 = dq.a(this.c, n5) + 12;
            System.arraycopy(this.c, n5, byArray2, n7, n6);
            n7 += n6;
            n5 = this.c;
            if (n5 != -1) {
                n6 = dq.a(this.c, n5) + 12;
                System.arraycopy(this.c, n5, byArray2, n7, n6);
                n7 += n6;
            }
            if (this.a(n, 14) && (n5 = dq.a(byArray, 14, n2, n3)) != -1) {
                n6 = dq.a(byArray, n5) + 12;
                System.arraycopy(byArray, n5, byArray2, n7, n6);
                n7 += n6;
            }
            if (this.a(n, 15) && (n5 = dq.a(byArray, 15, n2, n3)) != -1) {
                n6 = dq.a(byArray, n5) + 12;
                System.arraycopy(byArray, n5, byArray2, n7, n6);
                n7 += n6;
            }
            n5 = dq.a(byArray, 16, n2, n3);
            n6 = dq.a(byArray, n5) + 12;
            System.arraycopy(byArray, n5, byArray2, n7, n6);
            System.arraycopy(b, 0, byArray2, n7 += n6, 12);
            return byArray2;
        }
        byte[] byArray = this.a(n);
        int n8 = dq.a(this.c, 8 + (n << 3) + 2);
        int n9 = this.a(n);
        int n10 = n9 + 8;
        byte[] byArray3 = new byte[n10 += 12];
        System.arraycopy(a, 0, byArray3, 0, 8);
        System.arraycopy(byArray, n8, byArray3, 8, n9);
        int n11 = n9 + 8;
        System.arraycopy(b, 0, byArray3, n11, 12);
        return byArray3;
    }

    private int a(int n) {
        byte[] byArray = this.a(n);
        int n2 = dq.a(this.c, 8 + (n << 3) + 2);
        n = n == this.a() - 1 || dq.a(this.c, 8 + (n << 3)) != dq.a(this.c, 8 + (n + 1 << 3)) ? byArray.length : dq.a(this.c, 8 + (n + 1 << 3) + 2);
        return n - n2;
    }

    private static int a(byte[] byArray, int n, int n2, int n3) {
        String string = a[n];
        n3 = n3 == -1 ? byArray.length : n2 + n3;
        while (n2 < n3) {
            if (byArray[n2 + 4] == string.charAt(0) && byArray[n2 + 5] == string.charAt(1) && byArray[n2 + 6] == string.charAt(2) && byArray[n2 + 7] == string.charAt(3)) {
                return n2;
            }
            n2 += dq.a(byArray, n2) + 12;
        }
        return -1;
    }

    private static int a(byte[] byArray, int n) {
        if (byArray.length - 4 < n) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int n2 = 0 + ((byArray[n] & 0xFF) << 24);
        n2 += (byArray[n + 1] & 0xFF) << 16;
        n2 += (byArray[n + 2] & 0xFF) << 8;
        return n2 += byArray[n + 3] & 0xFF;
    }

    private static char a(byte[] byArray, int n) {
        if (byArray.length - 2 < n) {
            throw new ArrayIndexOutOfBoundsException();
        }
        char c2 = (char)(0 + ((byArray[n] & 0xFF) << 8));
        c2 = (char)(c2 + (byArray[n + 1] & 0xFF));
        return c2;
    }

    private boolean a(int n, int n2) {
        n = this.a[n];
        if (n2 <= 0 || n2 > 16) {
            return false;
        }
        return (n >> n2 - 1 & 1) == 1;
    }

    private static int b(byte[] byArray, int n) {
        String string = a[n];
        int n2 = byArray.length;
        for (int i = 0; i < n2 - 3; ++i) {
            if (byArray[i] != string.charAt(0) || byArray[i + 1] != string.charAt(1) || byArray[i + 2] != string.charAt(2) || byArray[i + 3] != string.charAt(3)) continue;
            return i - 4;
        }
        return -1;
    }

    private static byte[] c(int n) {
        byte[] byArray = new byte[4];
        byte[] byArray2 = byArray;
        byArray[0] = (byte)(n >>> 24);
        byArray2[1] = (byte)(n >> 16);
        byArray2[2] = (byte)(n >> 8);
        byArray2[3] = (byte)n;
        return byArray2;
    }

    private void a(byte[] byArray, int n, int n2) {
        for (int i = n; i < n2 + n; ++i) {
            this.d = this.d >>> 8 & 0xFFFFFF ^ c[(this.d ^ byArray[i]) & 0xFF];
        }
    }

    static {
        for (int n = 0; n < 256; n = (int)((short)(n + 1))) {
            int n2 = n;
            for (int n3 = 1; n3 < 9; n3 = (int)((byte)(n3 + 1))) {
                n2 = (n2 & 1) == 1 ? n2 >>> 1 ^ 0xEDB88320 : n2 >>> 1;
            }
            dq.c[n] = n2;
        }
    }
}
