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

    public bp(byte by) {
        this.a = by;
    }

    public final int a() {
        return this.a.size();
    }

    public final dg a(int n) {
        if (n >= this.a.size() || n < 0) {
            return null;
        }
        return (dg)this.a.elementAt(n);
    }

    public final int a(dg dg2) {
        return this.a.indexOf(dg2);
    }

    private boolean a(dg dg2, byte by) {
        if (this.a.size() >= this.a) {
            return false;
        }
        dg2.i = by;
        this.a.addElement(dg2);
        return true;
    }

    private final boolean c(byte by, byte by2, int n) {
        dg dg2 = this.a(n);
        return dg2 != null && dg2.g == by && dg2.h == by2;
    }

    public final boolean a(byte by, byte by2, int n) {
        int n2;
        int n3;
        int n4;
        int n5;
        block5: {
            n5 = 0;
            bp bp2 = this;
            n5 = bp2.a.size();
            for (n4 = 0; n4 < n5; ++n4) {
                if (bp2.a.elementAt(n4) != null) continue;
                n3 = (byte)n4;
                break block5;
            }
            n3 = n2 = n5 < bp2.a ? (int)(n5 + 1) : -1;
        }
        if (n3 != -1) {
            return true;
        }
        if (!bp.a(by)) {
            return false;
        }
        n4 = this.a.size();
        for (int i = 0; i < n4; ++i) {
            if (!this.c(by, by2, i)) continue;
            bp bp3 = this;
            n5 = i;
            dg dg2 = bp3.a(n5);
            byte by3 = dg2 != null ? dg2.i : (byte)0;
            n2 = by3;
            if (by3 + n <= 99) {
                return true;
            }
            n -= 99 - n2;
        }
        return false;
    }

    public final int a(dg dg2, int n) {
        if (!this.a(dg2.g, dg2.h, n)) {
            return 0;
        }
        if (!bp.a(dg2.g)) {
            this.a(dg2, (byte)1);
            return 1;
        }
        int n2 = dg2.h;
        byte by = dg2.g;
        Object object = this;
        Object object2 = new byte[((bp)object).a];
        int n3 = 0;
        int n4 = ((bp)object).a.size();
        for (int n5 = 0; n5 < n4; n5 = (int)((byte)(n5 + 1))) {
            if (!((bp)object).c(by, (byte)n2, n5)) continue;
            object2[n3++] = n5;
        }
        byte[] byArray = new byte[n3];
        System.arraycopy(object2, 0, byArray, 0, n3);
        byte[] byArray2 = n3 == 0 ? null : byArray;
        object = byArray2;
        if (byArray2 != null) {
            n2 = n;
            for (n3 = 0; n3 < ((Object)object).length; ++n3) {
                dg dg3 = this.a((int)object[n3]);
                object2 = dg3;
                by = dg3.i;
                if (by == 99) continue;
                byte by2 = object2.i = (byte)((n2 += by) > 99 ? 99 : (byte)n2);
                if ((n2 -= object2.i) > 0) continue;
                return n;
            }
            if (this.a(dg2, (byte)n2)) {
                return n;
            }
            return n - n2;
        }
        if (this.a(dg2, (byte)n)) {
            return n;
        }
        return 0;
    }

    public final boolean b(byte by, byte by2, int n) {
        for (byte by3 = (byte)(this.a.size() - 1); by3 >= 0; by3 = (byte)(by3 - 1)) {
            dg dg2;
            if (!this.c(by, by2, by3) || (dg2 = (dg)this.a.elementAt(by3)).c()) continue;
            int n2 = dg2.i < n ? (int)dg2.i : n;
            this.a((int)by3, n2);
            if ((n -= n2) > 0) continue;
            this.b();
            return true;
        }
        this.b();
        return false;
    }

    public final void a(int n, int n2) {
        dg dg2 = this.a(n);
        if (dg2 != null) {
            dg2.i = (byte)(dg2.i - n2);
            if (dg2.i <= 0) {
                this.a(n);
            }
        }
    }

    public final void a(int n) {
        this.a.removeElementAt(n);
    }

    public final void a() {
        for (int i = this.a.size() - 1; i >= 0; --i) {
            dg dg2 = (dg)this.a.elementAt(i);
            if (dg2.g != 19) continue;
            this.a.removeElementAt(i);
        }
    }

    public final byte[] a(byte by, byte by2, boolean bl, byte by3) {
        bl = false;
        int n = this.a.size();
        byte[] byArray = new byte[n];
        for (int n2 = 0; n2 < n; n2 = (int)((byte)(n2 + 1))) {
            dg dg2 = (dg)this.a.elementAt(n2);
            if (dg2 == null || dg2.g != by && dg2.g != by2 || dg2 instanceof bs && ((bs)dg2).f >= 0 || ((bs)dg2).a > by3) continue;
            byArray[bl] = n2;
            bl += 1;
        }
        if (!bl) {
            return null;
        }
        byte[] byArray2 = new byte[bl];
        System.arraycopy(byArray, 0, byArray2, 0, bl ? 1 : 0);
        return byArray2;
    }

    public final int a(byte by, byte by2) {
        return this.a(by, by2, false);
    }

    public final int a(byte by, byte by2, boolean bl) {
        int n = 0;
        for (int i = 0; i < this.a.size(); ++i) {
            dg dg2 = (dg)this.a.elementAt(i);
            if (bl && dg2 != null && dg2.c() || dg2 == null || dg2.g != by || dg2.h != by2) continue;
            n += dg2.i;
        }
        return n;
    }

    public final dg a(byte by, byte by2) {
        int n;
        int n2;
        block2: {
            byte by3 = by2;
            by2 = (byte)20;
            bp bp2 = this;
            int n3 = bp2.a.size();
            for (int n4 = 0; n4 < n3; n4 = (int)((byte)(n4 + 1))) {
                if (!bp2.c(by2, by3, n4)) continue;
                n2 = n4;
                break block2;
            }
            n2 = n = -1;
        }
        if (n2 == -1) {
            return null;
        }
        return (dg)this.a.elementAt(n);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final byte[] a() {
        byte[] byArray;
        int n = this.a.size();
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)filterOutputStream).writeByte(n);
            for (int i = 0; i < n; ++i) {
                Object object = (dg)this.a.elementAt(i);
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
            int n = ((DataInputStream)filterInputStream).readByte();
            for (int i = 0; i < n; ++i) {
                byte by = ((DataInputStream)filterInputStream).readByte();
                if (by == 0) continue;
                Object object = new byte[by];
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
        int n;
        byte[] byArray = new byte[7];
        for (n = 0; n < 7; n = (int)((byte)(n + 1))) {
            byArray[n] = -1;
        }
        n = this.a.size();
        int n2 = 0;
        for (int n3 = 0; n3 < n; n3 = (int)((byte)(n3 + 1))) {
            dg dg2 = (dg)this.a.elementAt(n3);
            if (dg2 == null || !dg2.c()) continue;
            byArray[((bs)dg2).f] = n3;
            byte by = (byte)(n2 + 1);
            n2 = by;
            if (by >= 7) break;
        }
        return byArray;
    }

    private final void b() {
        Object object;
        int n;
        for (n = 0; n < this.a.size() - 1; n = (int)((byte)(n + 1))) {
            dg dg2 = (dg)this.a.elementAt(n);
            if (dg2 == null || !bp.a(dg2.g) || dg2.i >= 99) continue;
            for (byte by = (byte)(n + 1); by < this.a.size(); by = (byte)(by + 1)) {
                object = (dg)this.a.elementAt(by);
                if (object == null || ((dg)object).g != dg2.g || ((dg)object).h != dg2.h) continue;
                byte by2 = dg2.i;
                byte by3 = ((dg)object).i;
                if (by2 + by3 <= 99) {
                    dg2.a(by3);
                    this.a(by);
                    continue;
                }
                by2 = (byte)(99 - by2);
                dg2.a(by2);
                ((dg)object).i = (byte)(((dg)object).i - by2);
            }
        }
        object = this;
        int n2 = 0;
        for (n = ((bp)object).a.size() - 1; n >= 0; --n) {
            dg dg3 = (dg)((bp)object).a.elementAt(n);
            if (dg3 == null) {
                ((bp)object).a.removeElementAt(n);
                continue;
            }
            ++n2;
        }
    }

    private static boolean a(byte by) {
        return by >= 16;
    }
}
