/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.rms.RecordStore
 */
package rpg;

import javax.microedition.rms.RecordStore;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class d {
    private static final String[] a = new String[]{"HOL.gamedata1", "HOL.gamedata2", "HOL.gamedata3"};
    private static final String[] b = new String[]{"HOL.item1", "HOL.item2", "HOL.item3"};
    private static final String[] c = new String[]{"HOL.slot1", "HOL.slot2", "HOL.slot3"};
    private static final byte[][] a = new byte[][]{{54, 15, 39, 72, 95}, {46, 37, 30, 14, 62, 80}, {26, 27, 60, 58, 70}};
    private static final byte[][] b = new byte[][]{{62, 35, 7, 1, 85, 38, 41}, {2, 78, 24, 7, 16, 91}, {84, 87, 4, 57, 83}};

    public static final void a() {
        try {
            r.m();
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public static final boolean a(byte[] byArray, byte by) {
        return d.a(a[by], byArray, a[by]);
    }

    public static final byte[] a(byte by) {
        return d.a(a[by], a[by]);
    }

    public static final boolean b(byte[] byArray, byte by) {
        return d.a(b[by], byArray, b[by]);
    }

    public static final byte[] b(byte by) {
        return d.a(b[by], b[by]);
    }

    public static final boolean c(byte[] byArray, byte by) {
        return d.a(c[by], byArray, b[by]);
    }

    public static final byte[] c(byte by) {
        return d.a(c[by], b[by]);
    }

    public static final boolean a(byte[] byArray) {
        return d.a("/d", byArray, b[0]);
    }

    public static final byte[] a() {
        return d.a("/d", b[0]);
    }

    public static final boolean b(byte[] byArray) {
        return d.a("HOL.storage", byArray, b[0]);
    }

    public static final byte[] b() {
        return d.a("HOL.storage", b[0]);
    }

    public static final boolean a() {
        byte[] byArray = new byte[16];
        byte[] byArray2 = byArray;
        byArray[0] = dj.b;
        byArray2[1] = dj.c;
        byArray2[2] = dj.i;
        byArray2[3] = dj.h ? (byte)1 : 0;
        byArray2[4] = dj.i ? (byte)1 : 0;
        byArray2[5] = dj.j ? (byte)1 : 0;
        byArray2[6] = j.a ? (byte)1 : 0;
        byArray2[7] = j.c;
        byArray2[8] = (byte)(r.g ? 1 : 0);
        byArray2[9] = (byte)(r.h ? 1 : 0);
        byArray2[10] = (byte)(r.i ? 1 : 0);
        byArray2[11] = (byte)(r.a ? 1 : 0);
        byArray2[12] = (byte)(r.b ? 1 : 0);
        byArray2[13] = (byte)(r.c ? 1 : 0);
        byArray2[14] = (byte)(r.d ? 1 : 0);
        byArray2[15] = (byte)(r.e ? 1 : 0);
        return d.a("HOL.gamestore", byArray2, b[0]);
    }

    public static final void b() {
        Object object = d.a("HOL.gamestore", b[0]);
        if (object == null) {
            d.a();
            return;
        }
        try {
            dj.b = object[0];
            dj.c = object[1];
            dj.i = object[2];
            dj.h = object[3] == 1;
            dj.i = object[4] == 1;
            dj.j = object[5] == 1;
            j.a = object[6] == 1;
            j.c = object[7];
            r.g = object[8] == 1;
            r.h = object[9] == 1;
            r.i = object[10] == 1;
            r.a = object[11] == 1;
            r.b = object[12] == 1;
            r.c = object[13] == 1;
            r.d = object[14] == 1;
            r.e = object[15] == 1;
            return;
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
            d.a();
            return;
        }
    }

    private static final boolean a(String object, byte[] object2, byte[] byArray) {
        boolean bl;
        bv bv2 = null;
        try {
            int n;
            byte[] byArray2 = new byte[2 + ((byte[])object2).length + 5];
            byte[] byArray3 = byArray;
            byte[] byArray4 = new byte[((byte[])object2).length];
            int n2 = 0;
            for (n = 0; n < ((byte[])object2).length; ++n) {
                if (++n2 == byArray3.length) {
                    n2 = 0;
                }
                byArray4[n] = (byte)(object2[n] ^ byArray3[n2]);
            }
            object2 = byArray4;
            f.a((short)(byArray2.length - 2), byArray2, 0);
            System.arraycopy(object2, 0, byArray2, 2, ((byte[])object2).length);
            object2 = d.a(object2, ((byte[])object2).length, byArray[0]);
            byArray2[byArray2.length - 5] = object2[0];
            byArray2[byArray2.length - 4] = object2[1];
            byArray2[byArray2.length - 3] = object2[2];
            byArray2[byArray2.length - 2] = object2[3];
            byArray2[byArray2.length - 1] = object2[4];
            bv2 = new bv((String)object, 0);
            n = byArray2.length;
            boolean bl2 = false;
            byArray3 = byArray2;
            object2 = bv2;
            if (bv2.a != null) {
                while (object2.a.startsWith("/")) {
                    object2.a = object2.a.substring(1);
                }
                while ((n2 = object2.a.indexOf("/")) > 0) {
                    object2.a = object2.a.substring(0, n2) + "." + object2.a.substring(n2 + 1);
                }
                if (byArray3 == null || n != byArray3.length) {
                    object2.a = new byte[n];
                    System.arraycopy(byArray3, 0, object2.a, 0, n);
                } else {
                    object2.a = byArray3;
                }
                try {
                    object = RecordStore.openRecordStore((String)object2.a, (boolean)true);
                    if (object.getNumRecords() == 0) {
                        object.addRecord(object2.a, 0, object2.a.length);
                    } else {
                        object.setRecord(1, object2.a, 0, object2.a.length);
                    }
                    object.closeRecordStore();
                }
                catch (Exception exception) {
                    object = exception;
                    exception.printStackTrace();
                }
            }
            object2 = bv2;
            bv2.a = null;
            bv2 = null;
            bl = true;
        }
        catch (Exception exception) {
            bl = false;
            if (bv2 != null) {
                try {
                    object2 = bv2;
                    bv2.a = null;
                }
                catch (Exception exception2) {}
            }
        }
        catch (Throwable throwable) {
            if (bv2 != null) {
                try {
                    object2 = bv2;
                    bv2.a = null;
                }
                catch (Exception exception) {}
            }
            throw throwable;
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final byte[] a(String object, byte[] object2) {
        bv bv2 = null;
        Object object3 = null;
        try {
            bv2 = new bv((String)object, 1);
            object3 = new byte[2];
            bv2.a((byte[])object3, 0, 2);
            object3 = new byte[(object3[0] & 0xFF) << 8 | object3[1] & 0xFF];
            bv2.a((byte[])object3, 0, ((byte[])object3).length);
            Object by = object2[0];
            object = object3;
            int n = ((byte[])object3).length;
            byte[] byArray = d.a((byte[])object, n - 5, (byte)by);
            object3 = !(object[n - 1] == byArray[4] && object[n - 2] == byArray[3] && object[n - 3] == byArray[2] && object[n - 4] == byArray[1] && object[n - 5] == byArray[0]) ? null : d.a(object3, (byte[])object2);
        }
        catch (Exception exception) {
            object3 = null;
            if (bv2 == null) return object3;
            try {
                object2 = bv2;
                bv2.a = null;
                return object3;
            }
            catch (Exception exception2) {
                return object3;
            }
        }
        catch (Throwable throwable) {
            if (bv2 == null) throw throwable;
            try {
                object2 = bv2;
                bv2.a = null;
                throw throwable;
            }
            catch (Exception exception) {}
            throw throwable;
        }
        try {
            object2 = bv2;
            bv2.a = null;
            return object3;
        }
        catch (Exception exception) {
            return object3;
        }
    }

    private static byte[] a(byte[] object, byte[] byArray) {
        if (((byte[])object).length <= 0) {
            return null;
        }
        int n = ((byte[])object).length - 5;
        byte[] byArray2 = new byte[n];
        int n2 = 0;
        try {
            for (int i = 0; i < n; ++i) {
                if (++n2 == byArray.length) {
                    n2 = 0;
                }
                byArray2[i] = (byte)(object[i] ^ byArray[n2]);
            }
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
            return null;
        }
        return byArray2;
    }

    private static final byte[] a(byte[] byArray, int n, byte by) {
        byte[] byArray2 = new byte[]{0, 0, 0, 0, 0};
        byte[] byArray3 = byArray2;
        byArray2[2] = 0;
        for (int i = 0; i < n; ++i) {
            byArray3[0] = (byte)(byArray3[0] + byArray[i]);
            byArray3[1] = (byte)(byArray3[1] + (byte)(byArray[i] << 1));
            byArray3[3] = (i & 1) == 1 ? (byte)(byArray3[3] + byArray[i]) : (byte)(byArray3[3] - byArray3[1]);
            byArray3[4] = (byte)(byArray3[4] + (byte)(byArray[i] ^ by));
        }
        return byArray3;
    }
}
