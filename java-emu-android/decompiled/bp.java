/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;
import rpg.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bp
implements b {
    private Vector a;
    public byte a = new Vector(1);

    public bp(byte by2) {
        this.a = by2;
    }

    public final int a() {
        return this.a.size();
    }

    public final dg a(int n2) {
        if (n2 >= this.a.size() || n2 < 0) {
            return null;
        }
        return (dg)this.a.elementAt(n2);
    }

    public final int a(dg dg2) {
        return this.a.indexOf(dg2);
    }

    private boolean a(dg dg2, byte by2) {
        if (this.a.size() >= this.a) {
            return false;
        }
        dg2.i = by2;
        this.a.addElement(dg2);
        return true;
    }

    private final boolean c(byte by2, byte by3, int n2) {
        dg dg2 = this.a(n2);
        return dg2 != null && dg2.g == by2 && dg2.h == by3;
    }

    public final boolean a(byte by2, byte by3, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        block5: {
            n6 = 0;
            bp bp2 = this;
            n6 = bp2.a.size();
            for (n5 = 0; n5 < n6; ++n5) {
                if (bp2.a.elementAt(n5) != null) continue;
                n4 = (byte)n5;
                break block5;
            }
            n4 = n3 = n6 < bp2.a ? (int)(n6 + 1) : -1;
        }
        if (n4 != -1) {
            return true;
        }
        if (!bp.a(by2)) {
            return false;
        }
        n5 = this.a.size();
        for (int i2 = 0; i2 < n5; ++i2) {
            if (!this.c(by2, by3, i2)) continue;
            bp bp3 = this;
            n6 = i2;
            dg dg2 = bp3.a(n6);
            byte by4 = dg2 != null ? dg2.i : (byte)0;
            n3 = by4;
            if (by4 + n2 <= 99) {
                return true;
            }
            n2 -= 99 - n3;
        }
        return false;
    }

    public final int a(dg dg2, int n2) {
        if (!this.a(dg2.g, dg2.h, n2)) {
            return 0;
        }
        if (!bp.a(dg2.g)) {
            this.a(dg2, (byte)1);
            return 1;
        }
        int n3 = dg2.h;
        byte by2 = dg2.g;
        Object object = this;
        Object object2 = new byte[((bp)object).a];
        int n4 = 0;
        int n5 = ((bp)object).a.size();
        for (int n6 = 0; n6 < n5; n6 = (int)((byte)(n6 + 1))) {
            if (!((bp)object).c(by2, (byte)n3, n6)) continue;
            object2[n4++] = n6;
        }
        byte[] byArray = new byte[n4];
        System.arraycopy(object2, 0, byArray, 0, n4);
        byte[] byArray2 = n4 == 0 ? null : byArray;
        object = byArray2;
        if (byArray2 != null) {
            n3 = n2;
            for (n4 = 0; n4 < ((Object)object).length; ++n4) {
                dg dg3 = this.a((int)object[n4]);
                object2 = dg3;
                by2 = dg3.i;
                if (by2 == 99) continue;
                byte by3 = object2.i = (byte)((n3 += by2) > 99 ? 99 : (byte)n3);
                if ((n3 -= object2.i) > 0) continue;
                return n2;
            }
            if (this.a(dg2, (byte)n3)) {
                return n2;
            }
            return n2 - n3;
        }
        if (this.a(dg2, (byte)n2)) {
            return n2;
        }
        return 0;
    }

    public final boolean b(byte by2, byte by3, int n2) {
        for (byte by4 = (byte)(this.a.size() - 1); by4 >= 0; by4 = (byte)(by4 - 1)) {
            dg dg2;
            if (!this.c(by2, by3, by4) || (dg2 = (dg)this.a.elementAt(by4)).c()) continue;
            int n3 = dg2.i < n2 ? (int)dg2.i : n2;
            this.a((int)by4, n3);
            if ((n2 -= n3) > 0) continue;
            this.b();
            return true;
        }
        this.b();
        return false;
    }

    public final void a(int n2, int n3) {
        dg dg2 = this.a(n2);
        if (dg2 != null) {
            dg2.i = (byte)(dg2.i - n3);
            if (dg2.i <= 0) {
                this.a(n2);
            }
        }
    }

    public final void a(int n2) {
        this.a.removeElementAt(n2);
    }

    public final void a() {
        for (int i2 = this.a.size() - 1; i2 >= 0; --i2) {
            dg dg2 = (dg)this.a.elementAt(i2);
            if (dg2.g != 19) continue;
            this.a.removeElementAt(i2);
        }
    }

    public final byte[] a(byte by2, byte by3, boolean bl2, byte by4) {
        bl2 = false;
        int n2 = this.a.size();
        byte[] byArray = new byte[n2];
        for (int n3 = 0; n3 < n2; n3 = (int)((byte)(n3 + 1))) {
            dg dg2 = (dg)this.a.elementAt(n3);
            if (dg2 == null || dg2.g != by2 && dg2.g != by3 || dg2 instanceof bs && ((bs)dg2).f >= 0 || ((bs)dg2).a > by4) continue;
            byArray[bl2] = n3;
            bl2 += 1;
        }
        if (!bl2) {
            return null;
        }
        byte[] byArray2 = new byte[bl2];
        System.arraycopy(byArray, 0, byArray2, 0, bl2 ? 1 : 0);
        return byArray2;
    }

    public final int a(byte by2, byte by3) {
        return this.a(by2, by3, false);
    }

    public final int a(byte by2, byte by3, boolean bl2) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.a.size(); ++i2) {
            dg dg2 = (dg)this.a.elementAt(i2);
            if (bl2 && dg2 != null && dg2.c() || dg2 == null || dg2.g != by2 || dg2.h != by3) continue;
            n2 += dg2.i;
        }
        return n2;
    }

    public final dg a(byte by2, byte by3) {
        int n2;
        int n3;
        block2: {
            byte by4 = by3;
            by3 = (byte)20;
            bp bp2 = this;
            int n4 = bp2.a.size();
            for (int n5 = 0; n5 < n4; n5 = (int)((byte)(n5 + 1))) {
                if (!bp2.c(by3, by4, n5)) continue;
                n3 = n5;
                break block2;
            }
            n3 = n2 = -1;
        }
        if (n3 == -1) {
            return null;
        }
        return (dg)this.a.elementAt(n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final byte[] a() {
        byte[] byArray;
        int n2 = this.a.size();
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)filterOutputStream).writeByte(n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = (dg)this.a.elementAt(i2);
                if (object == null) {
                    ((DataOutputStream)filterOutputStream).writeByte(0);
                    continue;
                }
                object = dg.a((dg)object);
                ((DataOutputStream)filterOutputStream).writeByte(((Object)object).length);
                ((OutputStream)filterOutputStream).write((byte[])object);
            }
            byArray = byteArrayOutputStream.toByteArray();
        }
        catch (IOException iOException) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) return null;
                byteArrayOutputStream.close();
                return null;
            }
            catch (IOException iOException2) {
                return null;
            }
        }
        catch (Throwable throwable) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) throw throwable;
                byteArrayOutputStream.close();
                throw throwable;
            }
            catch (IOException iOException) {}
            throw throwable;
        }
        try {
            filterOutputStream.close();
            byteArrayOutputStream.close();
            return byArray;
        }
        catch (IOException iOException) {}
        return byArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = null;
        FilterInputStream filterInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(byArray);
            filterInputStream = new DataInputStream(byteArrayInputStream);
            int n2 = ((DataInputStream)filterInputStream).readByte();
            for (int i2 = 0; i2 < n2; ++i2) {
                byte by2 = ((DataInputStream)filterInputStream).readByte();
                if (by2 == 0) continue;
                Object object = new byte[by2];
                ((DataInputStream)filterInputStream).read((byte[])object);
                dg dg2 = dg.a(object);
                object = dg2;
                if (dg2 == null) continue;
                this.a.addElement(object);
            }
        }
        catch (IOException iOException) {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream == null) return;
                byteArrayInputStream.close();
                return;
            }
            catch (IOException iOException2) {
                return;
            }
        }
        catch (Throwable throwable) {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream == null) throw throwable;
                byteArrayInputStream.close();
                throw throwable;
            }
            catch (IOException iOException) {}
            throw throwable;
        }
        try {
            filterInputStream.close();
            byteArrayInputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public final byte[] b() {
        int n2;
        byte[] byArray = new byte[7];
        for (n2 = 0; n2 < 7; n2 = (int)((byte)(n2 + 1))) {
            byArray[n2] = -1;
        }
        n2 = this.a.size();
        int n3 = 0;
        for (int n4 = 0; n4 < n2; n4 = (int)((byte)(n4 + 1))) {
            dg dg2 = (dg)this.a.elementAt(n4);
            if (dg2 == null || !dg2.c()) continue;
            byArray[((bs)dg2).f] = n4;
            byte by2 = (byte)(n3 + 1);
            n3 = by2;
            if (by2 >= 7) break;
        }
        return byArray;
    }

    private final void b() {
        Object object;
        int n2;
        for (n2 = 0; n2 < this.a.size() - 1; n2 = (int)((byte)(n2 + 1))) {
            dg dg2 = (dg)this.a.elementAt(n2);
            if (dg2 == null || !bp.a(dg2.g) || dg2.i >= 99) continue;
            for (byte by2 = (byte)(n2 + 1); by2 < this.a.size(); by2 = (byte)(by2 + 1)) {
                object = (dg)this.a.elementAt(by2);
                if (object == null || ((dg)object).g != dg2.g || ((dg)object).h != dg2.h) continue;
                byte by3 = dg2.i;
                byte by4 = ((dg)object).i;
                if (by3 + by4 <= 99) {
                    dg2.a(by4);
                    this.a(by2);
                    continue;
                }
                by3 = (byte)(99 - by3);
                dg2.a(by3);
                ((dg)object).i = (byte)(((dg)object).i - by3);
            }
        }
        object = this;
        int n3 = 0;
        for (n2 = ((bp)object).a.size() - 1; n2 >= 0; --n2) {
            dg dg3 = (dg)((bp)object).a.elementAt(n2);
            if (dg3 == null) {
                ((bp)object).a.removeElementAt(n2);
                continue;
            }
            ++n3;
        }
    }

    private static boolean a(byte by2) {
        return by2 >= 16;
    }
}

