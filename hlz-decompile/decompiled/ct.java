/*
 * Decompiled with CFR 0.152.
 */
import java.util.Vector;
import rpg.b;
import rpg.c;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
abstract class ct
implements b {
    protected x a;
    private byte[] a;
    private short[] a;
    private short[] b;

    public abstract boolean a(byte var1);

    public abstract boolean a(byte var1, int var2);

    public abstract boolean b(byte var1);

    protected abstract byte a();

    protected abstract void a(byte var1);

    ct(x x2) {
        this.a = x2;
    }

    public final void b(byte n) {
        int n2;
        byte[] byArray = c.a("/hero/hsd1");
        int n3 = 0;
        for (n2 = 0; n2 < n; ++n2) {
            n3 += 56;
        }
        n2 = 0;
        this.a = new byte[24];
        this.a = new short[6];
        this.b = new short[6];
        for (n = 0; n < 8; ++n) {
            System.arraycopy(byArray, n3, this.a, n2, 3);
            n2 += 3;
            if (n < 6) {
                this.a[n] = f.b(byArray, n3 + 3);
                this.b[n] = f.b(byArray, n3 + 5);
            }
            n3 += 7;
        }
    }

    public final int a(byte by) {
        int n = by - 4;
        by = (byte)n;
        if (n < 0 || by >= 6) {
            return 0;
        }
        return this.b[by];
    }

    public final int b(byte by) {
        int n = by - 4;
        by = (byte)n;
        if (n < 0 || by >= 6) {
            return 0;
        }
        return this.a[by];
    }

    protected final int c(byte by) {
        int n = (by - 4) * 3;
        return this.a((int)r.a.a(by), n);
    }

    protected final int a(byte by, int n, boolean bl) {
        int n2;
        int n3 = n2 = (by - 4) * 3;
        n2 = bl ? 1 : 0;
        int n4 = n;
        n = r.a.a(by);
        ct ct2 = this;
        n = ct2.a[n3] + ct2.a[n3 + 1] * n;
        n = n2 != 0 ? (n += n4) : (n *= n4);
        return n /= ct2.a[n3 + 2];
    }

    private final int a(int n, int n2) {
        n = this.a[n2] + this.a[n2 + 1] * n;
        return n /= this.a[n2 + 2];
    }

    protected final int a(byte by, boolean bl) {
        int n = this.a(by, this.a.a(bl), false);
        by = (byte)n;
        int n2 = n + this.a.c(bl);
        by = (byte)n2;
        return n2;
    }

    protected final boolean a() {
        return this.a.a((byte)3) != null;
    }

    protected final boolean b() {
        return this.a.a((byte)5) != null;
    }

    public byte b() {
        int n = this.a((int)r.a.a((byte)10), 18);
        return (byte)(n > 4 ? 4 : n);
    }

    protected final void c(byte by) {
        if (x.h > 0 && by < 4) {
            bo.a(x.h);
        } else {
            this.a(by);
        }
        x.h = (byte)-1;
    }

    protected final boolean a(byte by, byte by2, int n, boolean bl, boolean bl2, boolean n2) {
        n = 0;
        Vector vector = this.a.a(by);
        if (vector == null) {
            return false;
        }
        n2 = vector.size();
        for (int i = 0; i < n2; ++i) {
            db db2 = (db)vector.elementAt(i);
            if (db2 == null || !db2.a(this.a, by2, -1, bl, this.a.q, this.a(), bl2, true, false)) continue;
            n = 1;
        }
        return n != 0;
    }
}
