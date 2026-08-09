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

    c(short s2, short s3, byte by2, byte by3) {
        this.a(s2, s3);
        this.a = by2;
        this.b = by3;
        this.a();
        s3 = 1;
        c c2 = this;
        this.c = s3;
    }

    protected final void a() {
        this.c = (byte)(this.a >> 4);
        this.d = (byte)(this.b >> 4);
        this.a = (this.a & 0xF) != 0;
        this.b = (this.b & 0xF) != 0;
    }

    final void a(short s2, short s3) {
        this.a = s2;
        this.b = s3;
    }

    public final void a(boolean bl2) {
        this.c = bl2;
    }

    final c a(byte by2, byte by3, byte by4) {
        return c.a(this.c, this.d, by2, by3, by4);
    }

    public static c a(byte by2, byte by3, byte by4, byte by5, byte by6) {
        ab ab2 = r.a;
        by2 = (byte)(by2 + rpg.b.S[by4]);
        by3 = (byte)(by3 + rpg.b.T[by4]);
        switch (by5) {
            case 1: {
                int n2 = by3 - by6;
                by3 = (byte)n2;
                if (n2 >= 0) break;
                return null;
            }
            case 2: {
                int n3 = by3 + by6;
                by3 = (byte)n3;
                if (n3 < ab.d) break;
                return null;
            }
            case 3: {
                int n4 = by2 - by6;
                by2 = (byte)n4;
                if (n4 >= 0) break;
                return null;
            }
            case 4: {
                int n5 = by2 + by6;
                by2 = (byte)n5;
                if (n5 < ab.c) break;
                return null;
            }
            default: {
                if (by6 > 0) {
                    return null;
                }
                by2 = (byte)(by2 + rpg.b.S[by5]);
                by3 = (byte)(by3 + rpg.b.T[by5]);
            }
            case 0: {
                if (by2 >= 0 && by3 >= 0 && by2 < ab.c && by3 < ab.d) break;
                return null;
            }
        }
        return ab2.a[by3][by2];
    }

    protected final byte a(c c2) {
        int n2 = this.b(c2);
        int n3 = c2.b(this);
        return (byte)Math.min(n2, n3);
    }

    private int b(c c2) {
        int n2 = Math.abs(c2.c - this.c);
        int n3 = Math.abs(c2.c - (this.c + this.e - 1));
        return Math.min(n2, n3);
    }

    protected final byte b(c c2) {
        int n2 = c2.d - this.d;
        return (byte)Math.abs(n2);
    }

    protected final int a(c c2) {
        return this.a(c2) + this.b(c2);
    }
}

