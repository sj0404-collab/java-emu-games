/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bt {
    private byte[] a;

    public final byte[] a(String string) {
        int n = string.length();
        if (n >= 16) {
            string = string.substring(0, 16);
        } else {
            int n2 = 0;
            while (n2 < 16 - n) {
                string = string.concat("0");
                ++n2;
            }
        }
        this.a = string.getBytes();
        return this.a;
    }

    public final String a(String object) {
        String string = "";
        try {
            object = new String(this.a(this.a, bt.a(((String)object).getBytes()), false));
            int n = ((String)object).length();
            object = ((String)object).substring(0, n - 6);
            return object;
        }
        catch (Exception exception) {
            try {
                object = exception;
                exception.printStackTrace();
            }
            catch (Throwable throwable) {
                object = throwable;
                throw throwable;
            }
        }
        return string;
    }

    private static int a(byte[] byArray, int n) {
        return (byArray[n] << 8 & 0xFF00) + (byArray[n + 1] & 0xFF);
    }

    private static void a(int n, byte[] byArray, int n2) {
        byArray[n2] = (byte)(n >>> 8);
        byArray[n2 + 1] = (byte)n;
    }

    private static int a(int n, int n2) {
        if (n == 0) {
            n = 65537 - n2;
        } else if (n2 == 0) {
            n = 65537 - n;
        } else {
            n *= n2;
            n = n2 - n + ((n2 = n & 0xFFFF) < (n >>>= 16) ? 1 : 0);
        }
        return n & 0xFFFF;
    }

    private int[] a(byte[] byArray) {
        int[] nArray = new int[52];
        if (byArray.length < 16) {
            byte[] byArray2 = new byte[16];
            System.arraycopy(byArray, 0, byArray2, byArray2.length - byArray.length, byArray.length);
            byArray = byArray2;
        }
        int n = 0;
        while (n < 8) {
            nArray[n] = bt.a(byArray, n << 1);
            ++n;
        }
        n = 8;
        while (n < 52) {
            nArray[n] = (n & 7) < 6 ? ((nArray[n - 7] & 0x7F) << 9 | nArray[n - 6] >> 7) & 0xFFFF : ((n & 7) == 6 ? ((nArray[n - 7] & 0x7F) << 9 | nArray[n - 14] >> 7) & 0xFFFF : ((nArray[n - 15] & 0x7F) << 9 | nArray[n - 14] >> 7) & 0xFFFF);
            ++n;
        }
        return nArray;
    }

    private static int a(int n) {
        if (n < 2) {
            return n;
        }
        int n2 = 1;
        int n3 = 65537 / n;
        int n4 = 65537 % n;
        while (n4 != 1) {
            int n5 = n / n4;
            n2 = n2 + n3 * n5 & 0xFFFF;
            if ((n %= n4) == 1) {
                return n2;
            }
            n5 = n4 / n;
            n4 %= n;
            n3 = n3 + n2 * n5 & 0xFFFF;
        }
        return 1 - n3 & 0xFFFF;
    }

    private static byte[] a(byte[] byArray, int n) {
        int n2 = byArray.length;
        n -= n2 % n;
        int n3 = n2 + n;
        byte[] byArray2 = new byte[n3];
        System.arraycopy(byArray, 0, byArray2, 0, n2);
        int n4 = n2;
        while (n4 < n3) {
            byArray2[n4] = (byte)n;
            ++n4;
        }
        return byArray2;
    }

    private byte[] a(byte[] byArray, byte[] byArray2, boolean bl) {
        byArray = bt.a(byArray, 16);
        byArray2 = bt.a(byArray2, 8);
        int byArray3 = byArray2.length;
        int n = byArray3 / 8;
        byte[] byArray4 = new byte[byArray3];
        int n2 = 0;
        while (n2 < n) {
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            byte[] by;
            int[] nArray;
            Object object = new byte[16];
            Object[] objectArray = new byte[8];
            System.arraycopy(byArray, 0, object, 0, 16);
            System.arraycopy(byArray2, n2 << 3, objectArray, 0, 8);
            int n8 = 0;
            byte[] byArray5 = objectArray;
            objectArray = object;
            object = this;
            byte[] byArray6 = new byte[8];
            byte[] n9 = objectArray;
            objectArray = object;
            if (n8 != 0) {
                nArray = super.a(n9);
            } else {
                byte[] byArray7 = objectArray;
                objectArray = super.a(n9);
                by = byArray7;
                n7 = 52;
                n6 = 0;
                int[] nArray2 = new int[52];
                ++n6;
                int n10 = bt.a(objectArray[0]);
                ++n6;
                byte by2 = objectArray[1];
                n5 = 0 - by2 & 0xFFFF;
                ++n6;
                by2 = objectArray[2];
                n4 = 0 - by2 & 0xFFFF;
                ++n6;
                n3 = bt.a(objectArray[3]);
                --n7;
                nArray2[51] = n3;
                --n7;
                nArray2[50] = n4;
                --n7;
                nArray2[49] = n5;
                --n7;
                nArray2[48] = n10;
                n8 = 1;
                while (n8 < 8) {
                    n10 = objectArray[n6++];
                    n5 = objectArray[n6++];
                    nArray2[--n7] = n5;
                    nArray2[--n7] = n10;
                    n10 = bt.a(objectArray[n6++]);
                    by2 = objectArray[n6++];
                    n5 = 0 - by2 & 0xFFFF;
                    by2 = objectArray[n6++];
                    n4 = 0 - by2 & 0xFFFF;
                    n3 = bt.a(objectArray[n6++]);
                    nArray2[--n7] = n3;
                    nArray2[--n7] = n5;
                    nArray2[--n7] = n4;
                    nArray2[--n7] = n10;
                    ++n8;
                }
                n10 = objectArray[n6++];
                n5 = objectArray[n6++];
                nArray2[--n7] = n5;
                nArray2[--n7] = n10;
                n10 = bt.a(objectArray[n6++]);
                by2 = objectArray[n6++];
                n5 = 0 - by2 & 0xFFFF;
                by2 = objectArray[n6++];
                n4 = 0 - by2 & 0xFFFF;
                n3 = bt.a(objectArray[n6]);
                nArray2[--n7] = n3;
                nArray2[--n7] = n4;
                nArray2[--n7] = n5;
                nArray2[--n7] = n10;
                nArray = nArray2;
            }
            objectArray = nArray;
            by = byArray6;
            n9 = byArray5;
            Object[] n82 = objectArray;
            objectArray = object;
            int objectArray2 = 0;
            n7 = bt.a(n9, 0);
            n6 = bt.a(n9, 2);
            int nArray2 = bt.a(n9, 4);
            int byArray7 = bt.a(n9, 6);
            n5 = 0;
            while (n5 < 8) {
                n7 = bt.a(n7, (int)n82[objectArray2++]);
                n6 += n82[objectArray2++];
                nArray2 += n82[objectArray2++];
                byArray7 = bt.a(byArray7, (int)n82[objectArray2++]);
                n4 = n6 &= 0xFFFF;
                n3 = nArray2 &= 0xFFFF;
                nArray2 ^= n7;
                n6 ^= byArray7;
                nArray2 = bt.a(nArray2, (int)n82[objectArray2++]);
                n6 += nArray2;
                n6 &= 0xFFFF;
                n6 = bt.a(n6, (int)n82[objectArray2++]);
                nArray2 += n6;
                n7 ^= n6;
                byArray7 ^= (nArray2 &= 0xFFFF);
                n6 ^= n3;
                nArray2 ^= n4;
                ++n5;
            }
            bt.a(bt.a(n7, (int)n82[objectArray2++]), by, 0);
            bt.a(nArray2 + n82[objectArray2++], by, 2);
            bt.a(n6 + n82[objectArray2++], by, 4);
            bt.a(bt.a(byArray7, (int)n82[objectArray2]), by, 6);
            object = byArray6;
            System.arraycopy(byArray6, 0, byArray4, n2 << 3, 8);
            ++n2;
        }
        return byArray4;
    }

    private static byte[] a(byte[] byArray) {
        if (byArray.length % 2 != 0) {
            throw new IllegalArgumentException("Length Not Double Num");
        }
        byte[] byArray2 = new byte[byArray.length / 2];
        int n = 0;
        while (n < byArray.length) {
            String string = new String(byArray, n, 2);
            byArray2[n / 2] = (byte)Integer.parseInt(string, 16);
            n += 2;
        }
        return byArray2;
    }
}
