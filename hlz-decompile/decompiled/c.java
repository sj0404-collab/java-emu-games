/*
 * Decompiled with CFR 0.152.
 */
import rpg.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
abstract class c
implements b {
    protected short a;
    protected short b;
    protected byte a;
    protected byte b;
    protected byte c;
    protected byte d;
    boolean a;
    boolean b;
    byte e = 1;
    boolean c = true;
    public c a;
    public c b;
    boolean d = false;

    public abstract void a(int var1, int var2);

    c(short s, short s2, byte by, byte by2) {
        this.a(s, s2);
        this.a = by;
        this.b = by2;
        this.a();
        s2 = 1;
        c c2 = this;
        this.c = s2;
    }

    protected final void a() {
        this.c = (byte)(this.a >> 4);
        this.d = (byte)(this.b >> 4);
        this.a = (this.a & 0xF) != 0;
        this.b = (this.b & 0xF) != 0;
    }

    final void a(short s, short s2) {
        this.a = s;
        this.b = s2;
    }

    public final void a(boolean bl) {
        this.c = bl;
    }

    final c a(byte by, byte by2, byte by3) {
        return c.a(this.c, this.d, by, by2, by3);
    }

    public static c a(byte by, byte by2, byte by3, byte by4, byte by5) {
        ab ab2 = r.a;
        by = (byte)(by + rpg.b.S[by3]);
        by2 = (byte)(by2 + rpg.b.T[by3]);
        switch (by4) {
            case 1: {
                int n = by2 - by5;
                by2 = (byte)n;
                if (n >= 0) break;
                return null;
            }
            case 2: {
                int n = by2 + by5;
                by2 = (byte)n;
                if (n < ab.d) break;
                return null;
            }
            case 3: {
                int n = by - by5;
                by = (byte)n;
                if (n >= 0) break;
                return null;
            }
            case 4: {
                int n = by + by5;
                by = (byte)n;
                if (n < ab.c) break;
                return null;
            }
            default: {
                if (by5 > 0) {
                    return null;
                }
                by = (byte)(by + rpg.b.S[by4]);
                by2 = (byte)(by2 + rpg.b.T[by4]);
            }
            case 0: {
                if (by >= 0 && by2 >= 0 && by < ab.c && by2 < ab.d) break;
                return null;
            }
        }
        return ab2.a[by2][by];
    }

    protected final byte a(c c2) {
        int n = this.b(c2);
        int n2 = c2.b(this);
        return (byte)Math.min(n, n2);
    }

    private int b(c c2) {
        int n = Math.abs(c2.c - this.c);
        int n2 = Math.abs(c2.c - (this.c + this.e - 1));
        return Math.min(n, n2);
    }

    protected final byte b(c c2) {
        int n = c2.d - this.d;
        return (byte)Math.abs(n);
    }

    protected final int a(c c2) {
        return this.a(c2) + this.b(c2);
    }
}
