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

    public final void b(byte n2) {
        int n3;
        byte[] byArray = c.a("/hero/hsd1");
        int n4 = 0;
        for (n3 = 0; n3 < n2; ++n3) {
            n4 += 56;
        }
        n3 = 0;
        this.a = new byte[24];
        this.a = new short[6];
        this.b = new short[6];
        for (n2 = 0; n2 < 8; ++n2) {
            System.arraycopy(byArray, n4, this.a, n3, 3);
            n3 += 3;
            if (n2 < 6) {
                this.a[n2] = f.b(byArray, n4 + 3);
                this.b[n2] = f.b(byArray, n4 + 5);
            }
            n4 += 7;
        }
    }

    public final int a(byte by2) {
        int n2 = by2 - 4;
        by2 = (byte)n2;
        if (n2 < 0 || by2 >= 6) {
            return 0;
        }
        return this.b[by2];
    }

    public final int b(byte by2) {
        int n2 = by2 - 4;
        by2 = (byte)n2;
        if (n2 < 0 || by2 >= 6) {
            return 0;
        }
        return this.a[by2];
    }

    protected final int c(byte by2) {
        int n2 = (by2 - 4) * 3;
        return this.a((int)r.a.a(by2), n2);
    }

    protected final int a(byte by2, int n2, boolean bl2) {
        int n3;
        int n4 = n3 = (by2 - 4) * 3;
        n3 = bl2 ? 1 : 0;
        int n5 = n2;
        n2 = r.a.a(by2);
        ct ct2 = this;
        n2 = ct2.a[n4] + ct2.a[n4 + 1] * n2;
        n2 = n3 != 0 ? (n2 += n5) : (n2 *= n5);
        return n2 /= ct2.a[n4 + 2];
    }

    private final int a(int n2, int n3) {
        n2 = this.a[n3] + this.a[n3 + 1] * n2;
        return n2 /= this.a[n3 + 2];
    }

    protected final int a(byte by2, boolean bl2) {
        int n2 = this.a(by2, this.a.a(bl2), false);
        by2 = (byte)n2;
        int n3 = n2 + this.a.c(bl2);
        by2 = (byte)n3;
        return n3;
    }

    protected final boolean a() {
        return this.a.a((byte)3) != null;
    }

    protected final boolean b() {
        return this.a.a((byte)5) != null;
    }

    public byte b() {
        int n2 = this.a((int)r.a.a((byte)10), 18);
        return (byte)(n2 > 4 ? 4 : n2);
    }

    protected final void c(byte by2) {
        if (x.h > 0 && by2 < 4) {
            bo.a(x.h);
        } else {
            this.a(by2);
        }
        x.h = (byte)-1;
    }

    protected final boolean a(byte by2, byte by3, int n2, boolean bl2, boolean bl3, boolean n3) {
        n2 = 0;
        Vector vector = this.a.a(by2);
        if (vector == null) {
            return false;
        }
        n3 = vector.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            db db2 = (db)vector.elementAt(i2);
            if (db2 == null || !db2.a(this.a, by3, -1, bl2, this.a.q, this.a(), bl3, true, false)) continue;
            n2 = 1;
        }
        return n2 != 0;
    }
}

