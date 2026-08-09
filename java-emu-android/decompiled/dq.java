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
        int n2;
        this.a = null;
        this.c = null;
        this.a = null;
        this.a = null;
        this.a = object;
        byte[] byArray = rpg.c.a(this.a.concat(".mpm"));
        object = byArray;
        if (byArray[0] == -1 || object[0] == -2) {
            int n3;
            this.b = object[0] == -1;
            this.a = 1;
            byte[] byArray2 = new byte[((Object)object).length - 1];
            System.arraycopy(object, 1, byArray2, 0, byArray2.length);
            int n4 = 0;
            ++n4;
            this.b = new int[(byArray2[0] & 0xFF) + 1];
            this.b[0] = 0;
            for (n3 = 1; n3 < this.b.length; ++n3) {
                this.b[n3] = 0xFF000000 | (byArray2[n4] & 0xFF) << 16 | (byArray2[n4 + 1] & 0xFF) << 8 | byArray2[n4 + 2] & 0xFF;
                n4 += 3;
            }
            this.a = new cq[1];
            n3 = 0;
            int n5 = byArray2[n4++] & 0xFF;
            int n6 = byArray2[n4++] & 0xFF;
            int n7 = n4;
            while (n4 < byArray2.length) {
                if (byArray2[n4] == -1) {
                    Object[] objectArray = new byte[n4 - n7];
                    System.arraycopy(byArray2, n7, objectArray, 0, objectArray.length);
                    cq cq2 = new cq();
                    new cq().b = (short)n5;
                    cq2.a = (short)n6;
                    cq2.a = objectArray;
                    if (n3 >= this.a.length) {
                        objectArray = new cq[n3 + 1];
                        System.arraycopy(this.a, 0, objectArray, 0, n3);
                        this.a = (cq[])objectArray;
                    }
                    this.a[n3++] = cq2;
                    if (n4 < byArray2.length - 1) {
                        int n8 = ++n4;
                        n5 = byArray2[n8] & 0xFF;
                        int n9 = ++n4;
                        n6 = byArray2[n9] & 0xFF;
                        n7 = ++n4;
                        continue;
                    }
                }
                ++n4;
            }
            return;
        }
        this.a = 0;
        this.c = dq.a((byte[])object, 0);
        int n10 = 0 + (2 + this.c.length);
        dq dq2 = this;
        int n11 = dq.a(dq2.c, 0);
        dq2.a = (n11 >> 27) % 2 == 1;
        dq2.b = (n11 >> 26) % 2 == 1;
        n11 = dq2.a();
        dq2.a = 0;
        for (n2 = 0; n2 < n11; ++n2) {
            if (dq2.a >= dq.a(dq2.c, 8 + n2 * 8) + '\u0001') continue;
            dq2.a = dq.a(dq2.c, 8 + n2 * 8) + '\u0001';
        }
        dq2.a = new int[dq2.a];
        for (n2 = 0; n2 < n11; ++n2) {
            char c2 = dq.a(dq2.c, 8 + n2 * 8);
            dq2.a[c2] = dq2.a[c2] + 1;
        }
        dq2.a = new Object[dq2.a];
        dq2.a = new char[n11];
        for (n2 = 0; n2 < n11; ++n2) {
            dq2.a[n2] = dq.a(dq2.c, 8 + n2 * 8 + 6);
        }
        dq2.b = dq.b(dq2.c, 12);
        dq2.c = dq.b(dq2.c, 13);
        for (int i2 = 0; i2 < this.a; ++i2) {
            byte[] byArray3 = dq.a((byte[])object, n10);
            this.a[i2] = byArray3;
            n10 += 2 + byArray3.length;
        }
    }

    private static byte[] a(byte[] byArray, int n2) {
        short s2 = (short)((byArray[n2] & 0xFF) << 8 | byArray[n2 + 1] & 0xFF);
        byte[] byArray2 = new byte[s2];
        System.arraycopy(byArray, n2 + 2, byArray2, 0, s2);
        return byArray2;
    }

    public final int a() {
        if (this.a == 1) {
            return this.a.length;
        }
        return dq.a(this.c, 4);
    }

    public final cw a(int n2) {
        if (this.a == 1) {
            cq cq2 = this.a[n2];
            int[] nArray = new int[cq2.b * cq2.a];
            int n3 = 0;
            int n4 = 0;
            while (n4 < cq2.a.length) {
                int n5 = cq2.a[n4++] & 0xFF;
                int n6 = cq2.a[n4++] & 0xFF;
                while (n6 > 0) {
                    nArray[n3++] = this.b[n5];
                    --n6;
                }
            }
            return cw.a(nArray, cq2.b, cq2.a, true);
        }
        byte[] byArray = this.b(n2);
        return cw.a(byArray, 0, byArray.length);
    }

    public final cw[] a() {
        boolean bl2 = true;
        dq dq2 = this;
        this.c = true;
        int n2 = this.a();
        cw[] cwArray = new cw[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            cwArray[i2] = this.a(i2);
        }
        return cwArray;
    }

    public final void a(cw[] cwArray, int n2) {
        n2 = 1;
        dq dq2 = this;
        this.c = true;
        int n3 = this.a();
        for (int i2 = 0; i2 < n3; ++i2) {
            cwArray[i2 + 0] = this.a(i2);
        }
    }

    public final cw b(int n2) {
        byte[] byArray;
        block12: {
            int n3;
            int n4;
            if (!this.b) {
                return this.a(n2);
            }
            if (this.a == 1) {
                int n5;
                int n6;
                int n7;
                cq cq2 = this.a[n2];
                int[] nArray = new int[cq2.b * cq2.a];
                int[] nArray2 = new int[cq2.b * cq2.a];
                int n8 = 0;
                int n9 = 0;
                while (n9 < cq2.a.length) {
                    n7 = cq2.a[n9++] & 0xFF;
                    for (n6 = n5 = cq2.a[n9++] & 0xFF; n6 > 0; --n6) {
                        nArray2[n8++] = this.b[n7];
                    }
                }
                for (n9 = 0; n9 < cq2.b; ++n9) {
                    n7 = 0;
                    n5 = n9;
                    n6 = cq2.b - n9 - 1;
                    while (n7 < cq2.a) {
                        nArray[n5] = nArray2[n6];
                        ++n7;
                        n5 += cq2.b;
                        n6 += cq2.b;
                    }
                }
                return cw.a(nArray, cq2.b, cq2.a, true);
            }
            byArray = this.b(n2);
            int n10 = dq.a(byArray, 16, 8, byArray.length);
            int n11 = dq.a(byArray, 0, 8, byArray.length);
            int n12 = dq.a(byArray, n11 + 8);
            int n13 = dq.a(byArray, n11 + 12);
            int n14 = byArray[n11 + 16];
            int n15 = n10;
            int n16 = n14;
            n11 = n13;
            n10 = n12;
            n14 = n15;
            byte[] byArray2 = byArray;
            dq dq2 = this;
            int n17 = 8 / n16;
            int n18 = (n10 - 1) / n17 + 1;
            int n19 = 255 >> 8 - n16;
            int n20 = n14 + 15;
            int n21 = (n18 + 1) * n11;
            int n22 = n10 / 2;
            int n23 = n20 + n21;
            int n24 = n23 + 4;
            n14 += 4;
            for (n4 = 0; n4 < n11; ++n4) {
                if (byArray2[n20 + (n18 + 1) * n4] == 0) {
                    continue;
                }
                break block12;
            }
            for (int i2 = 0; i2 < n11; ++i2) {
                n4 = n20 + (n18 + 1) * i2 + 1;
                for (int i3 = 0; i3 < n22; ++i3) {
                    n3 = n10 - 1 - i3;
                    int n25 = n4 + i3 / n17;
                    int n26 = n4 + n3 / n17;
                    int n27 = i3 % n17;
                    n3 %= n17;
                    n27 = (byte)((n17 - n27 - 1) * n16);
                    n3 = (byte)((n17 - n3 - 1) * n16);
                    byte by2 = (byte)(byArray2[n25] >> n27 & n19);
                    byte by3 = (byte)(byArray2[n26] >> n3 & n19);
                    byArray2[n25] = (byte)(byArray2[n25] & ~(n19 << n27) | by3 << n27);
                    byArray2[n26] = (byte)(byArray2[n26] & ~(n19 << n3) | by2 << n3);
                }
            }
            dq dq3 = dq2;
            dq2.e = 1;
            n17 = n21;
            n16 = n20;
            byte[] byArray3 = byArray2;
            dq3 = dq2;
            n18 = dq3.e & 0xFFFF;
            n19 = dq3.e >> 16 & 0xFFFF;
            while (n17 > 0) {
                n20 = n17 < 5552 ? n17 : 5552;
                n17 -= n20;
                while (n20-- > 0) {
                    n19 += (n18 += byArray3[n16++] & 0xFF);
                }
                n18 %= 65521;
                n19 %= 65521;
            }
            dq3.e = n19 << 16 | n18;
            dq3 = dq2;
            long l2 = dq3.e;
            System.arraycopy(dq.c((int)l2), 0, byArray2, n23, 4);
            dq3 = dq2;
            dq2.d = -1;
            dq2.a(byArray2, n14, n21 + 15);
            dq3 = dq2;
            n3 = ~dq3.d;
            System.arraycopy(dq.c(n3), 0, byArray2, n24, 4);
        }
        return cw.a(byArray, 0, byArray.length);
    }

    public final void a(int n2, int n3) {
        if (!this.a) {
            return;
        }
        int n4 = n3;
        int n5 = n2;
        n2 = 4;
        int n6 = this.b;
        byte[] byArray = this.c;
        dq dq2 = this;
        if (dq2.a == 1) {
            int n7 = -1;
            for (int i2 = 0; i2 < dq2.b.length; ++i2) {
                if (dq2.b[i2] != n5) continue;
                n7 = i2;
                break;
            }
            if (n7 >= 0) {
                dq2.b[n7] = n4;
            }
            return;
        }
        int n8 = dq.a(byArray, n6);
        int n9 = n6 + 8;
        int n10 = n9 + n8;
        int n11 = n5 >> 16;
        byte by2 = (byte)(n5 >> 8);
        n5 = (byte)n5;
        byte by3 = (byte)(n4 >> 16);
        byte by4 = (byte)(n4 >> 8);
        n4 = (byte)n4;
        for (int i3 = 0; i3 < n8 / 3; ++i3) {
            if (byArray[n9 + i3 * 3] != n11 || byArray[n9 + i3 * 3 + 1] != by2 || byArray[n9 + i3 * 3 + 2] != n5) continue;
            byArray[n9 + i3 * 3] = by3;
            byArray[n9 + i3 * 3 + 1] = by4;
            byArray[n9 + i3 * 3 + 2] = n4;
        }
        dq dq3 = dq2;
        dq2.d = -1;
        dq2.a(byArray, n6 + 4, n8 + 4);
        dq3 = dq2;
        n11 = ~dq3.d;
        System.arraycopy(dq.c(n11), 0, byArray, n10, 4);
    }

    private byte[] a(int n2) {
        n2 = dq.a(this.c, 8 + n2 * 8);
        if (this.c && this.a[n2] == null) {
            dq dq2 = this;
            for (int i2 = 0; i2 < dq2.a; ++i2) {
                dq2.a[i2] = null;
            }
            this.a[n2] = rpg.c.a(this.a.concat("_").concat(String.valueOf(n2)).concat(".mpd"));
        }
        return (byte[])this.a[n2];
    }

    private byte[] b(int n2) {
        if (this.a) {
            byte[] byArray = this.a(n2);
            int n3 = dq.a(this.c, 8 + (n2 << 3) + 2);
            int n4 = this.a(n2);
            int n5 = 8 + (this.c.length - ((dq.a(this.c, 4) << 3) + 8));
            n5 += n4;
            byte[] byArray2 = new byte[n5 += 12];
            System.arraycopy(a, 0, byArray2, 0, 8);
            int n6 = dq.a(byArray, 0, n3, n4);
            if (n6 == -1) {
                return null;
            }
            int n7 = dq.a(byArray, n6) + 12;
            System.arraycopy(byArray, n6, byArray2, 8, n7);
            int n8 = n7 + 8;
            block3: for (int i2 = 0; i2 < 18; ++i2) {
                if (!this.a(n2, i2)) continue;
                switch (i2) {
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 9: 
                    case 10: {
                        n6 = dq.a(byArray, i2, n3, n4);
                        if (n6 == -1) continue block3;
                        n7 = dq.a(byArray, n6) + 12;
                        System.arraycopy(byArray, n6, byArray2, n8, n7);
                        n8 += n7;
                    }
                }
            }
            n6 = this.b;
            n7 = dq.a(this.c, n6) + 12;
            System.arraycopy(this.c, n6, byArray2, n8, n7);
            n8 += n7;
            n6 = this.c;
            if (n6 != -1) {
                n7 = dq.a(this.c, n6) + 12;
                System.arraycopy(this.c, n6, byArray2, n8, n7);
                n8 += n7;
            }
            if (this.a(n2, 14) && (n6 = dq.a(byArray, 14, n3, n4)) != -1) {
                n7 = dq.a(byArray, n6) + 12;
                System.arraycopy(byArray, n6, byArray2, n8, n7);
                n8 += n7;
            }
            if (this.a(n2, 15) && (n6 = dq.a(byArray, 15, n3, n4)) != -1) {
                n7 = dq.a(byArray, n6) + 12;
                System.arraycopy(byArray, n6, byArray2, n8, n7);
                n8 += n7;
            }
            n6 = dq.a(byArray, 16, n3, n4);
            n7 = dq.a(byArray, n6) + 12;
            System.arraycopy(byArray, n6, byArray2, n8, n7);
            System.arraycopy(b, 0, byArray2, n8 += n7, 12);
            return byArray2;
        }
        byte[] byArray = this.a(n2);
        int n9 = dq.a(this.c, 8 + (n2 << 3) + 2);
        int n10 = this.a(n2);
        int n11 = n10 + 8;
        byte[] byArray3 = new byte[n11 += 12];
        System.arraycopy(a, 0, byArray3, 0, 8);
        System.arraycopy(byArray, n9, byArray3, 8, n10);
        int n12 = n10 + 8;
        System.arraycopy(b, 0, byArray3, n12, 12);
        return byArray3;
    }

    private int a(int n2) {
        byte[] byArray = this.a(n2);
        int n3 = dq.a(this.c, 8 + (n2 << 3) + 2);
        n2 = n2 == this.a() - 1 || dq.a(this.c, 8 + (n2 << 3)) != dq.a(this.c, 8 + (n2 + 1 << 3)) ? byArray.length : dq.a(this.c, 8 + (n2 + 1 << 3) + 2);
        return n2 - n3;
    }

    private static int a(byte[] byArray, int n2, int n3, int n4) {
        String string = a[n2];
        n4 = n4 == -1 ? byArray.length : n3 + n4;
        while (n3 < n4) {
            if (byArray[n3 + 4] == string.charAt(0) && byArray[n3 + 5] == string.charAt(1) && byArray[n3 + 6] == string.charAt(2) && byArray[n3 + 7] == string.charAt(3)) {
                return n3;
            }
            n3 += dq.a(byArray, n3) + 12;
        }
        return -1;
    }

    private static int a(byte[] byArray, int n2) {
        if (byArray.length - 4 < n2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int n3 = 0 + ((byArray[n2] & 0xFF) << 24);
        n3 += (byArray[n2 + 1] & 0xFF) << 16;
        n3 += (byArray[n2 + 2] & 0xFF) << 8;
        return n3 += byArray[n2 + 3] & 0xFF;
    }

    private static char a(byte[] byArray, int n2) {
        if (byArray.length - 2 < n2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        char c2 = (char)(0 + ((byArray[n2] & 0xFF) << 8));
        c2 = (char)(c2 + (byArray[n2 + 1] & 0xFF));
        return c2;
    }

    private boolean a(int n2, int n3) {
        n2 = this.a[n2];
        if (n3 <= 0 || n3 > 16) {
            return false;
        }
        return (n2 >> n3 - 1 & 1) == 1;
    }

    private static int b(byte[] byArray, int n2) {
        String string = a[n2];
        int n3 = byArray.length;
        for (int i2 = 0; i2 < n3 - 3; ++i2) {
            if (byArray[i2] != string.charAt(0) || byArray[i2 + 1] != string.charAt(1) || byArray[i2 + 2] != string.charAt(2) || byArray[i2 + 3] != string.charAt(3)) continue;
            return i2 - 4;
        }
        return -1;
    }

    private static byte[] c(int n2) {
        byte[] byArray = new byte[4];
        byte[] byArray2 = byArray;
        byArray[0] = (byte)(n2 >>> 24);
        byArray2[1] = (byte)(n2 >> 16);
        byArray2[2] = (byte)(n2 >> 8);
        byArray2[3] = (byte)n2;
        return byArray2;
    }

    private void a(byte[] byArray, int n2, int n3) {
        for (int i2 = n2; i2 < n3 + n2; ++i2) {
            this.d = this.d >>> 8 & 0xFFFFFF ^ c[(this.d ^ byArray[i2]) & 0xFF];
        }
    }

    static {
        for (int n2 = 0; n2 < 256; n2 = (int)((short)(n2 + 1))) {
            int n3 = n2;
            for (int n4 = 1; n4 < 9; n4 = (int)((byte)(n4 + 1))) {
                n3 = (n3 & 1) == 1 ? n3 >>> 1 ^ 0xEDB88320 : n3 >>> 1;
            }
            dq.c[n2] = n3;
        }
    }
}

