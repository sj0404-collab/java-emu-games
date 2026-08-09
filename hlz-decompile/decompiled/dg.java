/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import rpg.a;
import rpg.c;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class dg {
    private byte a;
    public long a;
    public byte g;
    public byte h;
    public byte i;
    public int a;
    public byte[] c;
    public byte[] d;
    private boolean a;

    protected dg(byte by, byte by2) {
        this.i = 1;
        this.c = null;
        this.d = null;
        this.a = true;
        this.g = by;
        this.h = by2;
        this.i = 1;
    }

    public static final synchronized dg a(byte by, byte by2) {
        dg dg2 = by >= 0 && by <= 15 ? new bs(by, by2) : (by == 18 ? new d(by, by2) : (by == 17 ? new de(by, by2) : new dg(by, by2)));
        byte[] byArray = rpg.c.a("/itm/" + (by < 10 ? "0" : "") + by, (int)by2);
        if (!rpg.c.a(byArray)) {
            dg2 = null;
        } else {
            try {
                int n = dg2.a(byArray, 0);
                if (by == 19) {
                    dg2.a = byArray[n] != 0;
                }
            }
            catch (Exception exception) {
                dg2 = null;
            }
        }
        return dg2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final dg a(byte[] byArray) {
        dg dg2;
        block16: {
            dg2 = null;
            ByteArrayInputStream byteArrayInputStream = null;
            FilterInputStream filterInputStream = null;
            try {
                byteArrayInputStream = new ByteArrayInputStream(byArray);
                filterInputStream = new DataInputStream(byteArrayInputStream);
                byte by = ((DataInputStream)filterInputStream).readByte();
                byte by2 = ((DataInputStream)filterInputStream).readByte();
                dg2 = dg.a(by, by2);
                if (dg2 != null) {
                    dg2.a((DataInputStream)filterInputStream);
                }
            }
            catch (Exception exception) {
                dg2 = null;
                try {
                    filterInputStream.close();
                }
                catch (Exception exception2) {}
                try {
                    byteArrayInputStream.close();
                }
                catch (Exception exception3) {}
                break block16;
            }
            catch (Throwable throwable) {
                try {
                    filterInputStream.close();
                }
                catch (Exception exception) {}
                try {
                    byteArrayInputStream.close();
                    throw throwable;
                }
                catch (Exception exception) {}
                throw throwable;
            }
            try {
                filterInputStream.close();
            }
            catch (Exception exception) {}
            try {
                byteArrayInputStream.close();
            }
            catch (Exception exception) {}
        }
        if (dg2 == null) return dg2;
        if (dg2.a() == dg2.a) return dg2;
        return null;
    }

    public static final byte[] a(dg dg2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dg2.a = dg2.a();
        try {
            dataOutputStream = dg2.a(dataOutputStream);
            dataOutputStream.close();
            byteArrayOutputStream.close();
        }
        catch (Exception exception) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    protected byte a() {
        int n = 0 + dg.a(this.a, 10);
        n += dg.a(this.a, 100);
        n += dg.a(this.a, 100000);
        n += this.i << 3;
        n += this.g << 6;
        return (byte)((n += this.h << 3) % 100);
    }

    private static int a(long l, int n) {
        if (l == 0L) {
            return 0;
        }
        return (int)(l / (long)n % 10L);
    }

    protected DataOutputStream a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(this.g);
        dataOutputStream.writeByte(this.h);
        dataOutputStream.writeByte(this.i);
        dataOutputStream.writeLong(this.a);
        dataOutputStream.writeByte(this.a);
        return dataOutputStream;
    }

    protected void a(DataInputStream dataInputStream) {
        this.i = dataInputStream.readByte();
        this.a = dataInputStream.readLong();
        this.a = dataInputStream.readByte();
    }

    protected int a(byte[] byArray, int n) {
        byte by = byArray[n++];
        this.c = new byte[by];
        System.arraycopy(byArray, n, this.c, 0, by);
        this.a = f.a(byArray, n += by);
        n += 4;
        this.a = System.currentTimeMillis();
        by = byArray[n++];
        this.d = new byte[by];
        System.arraycopy(byArray, n, this.d, 0, by);
        return n += by;
    }

    public final void a(int n) {
        this.i = (byte)(this.i + n);
    }

    public final void a(cr cr2, int n, int n2) {
        this.a(cr2, n, n2, false, true);
    }

    public final void a(cr cr2, int n, int n2, boolean bl, boolean bl2) {
        if (bl) {
            cr2.b(n + 1, n2 + 1, 12, 12);
        } else {
            cr2.b(n, n2, 14, 14);
        }
        cr2.a(rpg.c.k[29], n, n2, 20);
        int n3 = this.g + (this.g == 20 ? this.h : (byte)0);
        cr2.a(rpg.c.k[n3], n + 7, n2 + 7, 3);
        rpg.a.a(cr2);
    }

    public final boolean a() {
        return this.g == 20 && this.h >= 2;
    }

    public final boolean b() {
        return this instanceof bs;
    }

    public final boolean c() {
        return this instanceof bs && ((bs)this).f >= 0;
    }

    public final boolean d() {
        return this.a;
    }

    public dg() {
    }

    public static void a(byte by) {
        cj.a.vibrate(80);
    }
}
