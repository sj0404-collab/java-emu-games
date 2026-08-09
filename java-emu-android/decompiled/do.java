/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import java.util.Vector;
import rpg.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class do
extends c {
    protected Vector a;
    protected Vector b;
    protected byte p;
    protected byte q;
    protected byte r;
    protected byte s = 0;
    protected int f;
    protected byte t = (byte)8;
    protected int g = -1;
    protected static Random a = new Random();

    public do(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, by2, by3);
        do do_ = this;
        this.p = 1;
        do_.f = 0;
        do_.r = do_.q;
        do_.g = -1;
        do_.b();
    }

    final void y() {
        this.a = new Vector(3);
    }

    void b() {
        this.y();
        this.b = new Vector(3);
    }

    void a(byte by2) {
        this.p = by2;
        this.f = -1;
    }

    final void i(byte by2) {
        this.q = this.r = by2;
    }

    final void o(int n2) {
        if (this.f >= n2) {
            this.f = 0;
        }
    }

    final void c(df df2) {
        int n2 = df2.b;
        do do_ = this;
        if (df.a((byte)n2)) {
            for (int i2 = n2 = do_.a.size() - 1; i2 >= 0; --i2) {
                df df3 = (df)do_.a.elementAt(i2);
                if (!df.a(df3.b)) continue;
                df3.a = true;
            }
        }
        this.a.addElement(df2);
    }

    void b(byte by2, int n2) {
        if (this.e(by2)) {
            this.b.addElement(new dn(by2, n2));
        }
    }

    void a(byte by2, byte by3, int n2) {
        if (this.e(by2)) {
            this.b.addElement(new cl(by2, by3, n2));
        }
    }

    boolean a(byte by2) {
        if (this.e(by2)) {
            this.b.addElement(new bj(by2));
            return true;
        }
        return false;
    }

    boolean a(byte by2, int n2) {
        if (this.e(by2)) {
            this.b.addElement(new bj(by2, n2));
            return true;
        }
        return false;
    }

    final boolean e(byte by2) {
        for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
            df df2 = (df)this.b.elementAt(i2);
            if (df2.b != by2) continue;
            return false;
        }
        return true;
    }

    protected final void z() {
        for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
            df df2 = (df)this.b.elementAt(i2);
            if (df2.a) {
                this.b(df2);
                this.b.removeElementAt(i2);
                continue;
            }
            this.a(df2);
        }
    }

    protected void a(df df2) {
    }

    protected void b(df df2) {
    }

    void d() {
        if (this.g > 0) {
            --this.g;
        }
        this.s();
    }

    final boolean k() {
        if (this.p == 2 || this.p == 5) {
            if (!this.a_()) {
                this.p(this.t);
                return true;
            }
            this.g();
        }
        return false;
    }

    protected boolean a_() {
        if (((c)this).a || ((c)this).b) {
            return false;
        }
        if (!r.a.a(this, this.q)) {
            this.a((byte)1);
            return true;
        }
        return false;
    }

    protected final void p(int n2) {
        this.b_();
        ((c)this).a = (short)(((c)this).a + rpg.b.S[this.q] * n2);
        ((c)this).b = (short)(((c)this).b + rpg.b.T[this.q] * n2);
        this.a();
        this.a_();
    }

    abstract void g();

    protected void a_() {
        ab ab2 = r.a;
        for (byte by2 = 0; by2 < this.e; by2 = (byte)(by2 + 1)) {
            ab2.a[this.d][this.c + by2] = this;
            if (((c)this).b) {
                ab2.a[this.d + 1][this.c + by2] = this;
                continue;
            }
            if (!((c)this).a) continue;
            ab2.a[this.d][this.c + 1 + by2] = this;
        }
    }

    protected void b_() {
        ab ab2 = r.a;
        for (byte by2 = 0; by2 < this.e; by2 = (byte)(by2 + 1)) {
            ab2.a[this.d][this.c + by2] = null;
            if (((c)this).b) {
                ab2.a[this.d + 1][this.c + by2] = null;
                continue;
            }
            if (!((c)this).a) continue;
            ab2.a[this.d][this.c + 1 + by2] = null;
        }
    }

    protected final void d(int n2, int n3) {
        for (int i2 = this.a.size() - 1; i2 >= 0; --i2) {
            df df2 = (df)this.a.elementAt(i2);
            df2.a(n2, n3, true);
            if (!df2.a) continue;
            this.a.removeElementAt(i2);
        }
    }

    protected final void b(int n2, int n3, boolean bl2) {
        for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
            df df2 = (df)this.b.elementAt(i2);
            df2.a(n2, n3, bl2);
        }
    }

    protected final c a(byte by2, c c2) {
        int n2;
        int n3 = this.d + rpg.b.T[by2];
        if (n3 < 0 || n3 >= ab.d) {
            return null;
        }
        ab ab2 = r.a;
        for (int i2 = 0; i2 < this.e && (n2 = this.c + rpg.b.S[by2] + i2) >= 0 && n2 < ab.c; ++i2) {
            c c3 = ab2.a[n3][n2];
            if (c3 == this || c3 == null || c2 != null && (c2 == null || c3 != c2)) continue;
            return c3;
        }
        return null;
    }

    protected final boolean l() {
        return this.f(this.q);
    }

    protected final boolean f(byte by2) {
        int n2 = this.c + rpg.b.S[by2];
        byte by3 = this.d + rpg.b.T[by2];
        if (n2 >= ab.c || by3 >= ab.d || n2 < 0 || by3 < 0) {
            return false;
        }
        if (!r.a.d(n2, by3)) {
            return false;
        }
        ab ab2 = r.a;
        by3 = rpg.b.W[by2];
        byte by4 = rpg.b.X[by2];
        byte by5 = rpg.b.U[by2];
        byte by6 = rpg.b.V[by2];
        if (ab2.a(this, by4) && ab2.a(this, by6)) {
            this.s = by2;
            this.a((byte)2);
            this.i(by4);
            return true;
        }
        if (ab2.a(this, by3) && ab2.a(this, by5)) {
            this.s = by2;
            this.a((byte)2);
            this.i(by3);
            return true;
        }
        return false;
    }

    protected final void A() {
        if (this.s != 0 && !((c)this).a && !((c)this).b) {
            this.i(this.s);
            this.s = 0;
        }
    }

    protected void j(byte by2) {
        if (r.a.a(this, by2)) {
            this.b_();
            ((c)this).a = (short)(((c)this).a + (rpg.b.S[by2] << 4));
            ((c)this).b = (short)(((c)this).b + (rpg.b.T[by2] << 4));
            this.a();
            this.a_();
        }
    }

    public int b() {
        return 0;
    }

    public byte b() {
        return 1;
    }

    public int c(byte by2) {
        return 0;
    }

    boolean a(do do_, int n2, byte by2) {
        return false;
    }

    protected final void k(byte by2) {
        this.t = by2;
    }

    protected final db b(byte by2) {
        c c2 = this.a(by2, null);
        if (c2 != null && c2 instanceof db && !(c2 instanceof an)) {
            return (db)c2;
        }
        return null;
    }

    protected final void q(int n2) {
        if (this.g > 0) {
            return;
        }
        this.g = n2;
        byte by2 = (byte)(this.t >> 1);
        do do_ = this;
        this.t = by2;
    }

    protected void s() {
        if (this.g == 0 && !((c)this).a && !((c)this).b) {
            this.g = -1;
            byte by2 = (byte)(this.t << 1);
            do do_ = this;
            this.t = by2;
        }
    }

    protected void a(do do_, int n2, byte by2, byte by3) {
    }

    public boolean c() {
        return true;
    }

    public boolean b() {
        return false;
    }

    public void b(int n2, int n3) {
    }

    public void n(int n2) {
    }

    protected final boolean m() {
        int n2;
        int n3 = 0;
        for (int i2 = n2 = this.b.size() - 1; i2 >= 0; --i2) {
            df df2 = (df)this.b.elementAt(i2);
            if (df2 == null) continue;
            df2.a = true;
            this.b(df2);
            this.b.removeElementAt(i2);
            ++n3;
        }
        return n3 > 0;
    }

    protected final Vector b(byte by2) {
        int n2;
        int n3;
        int n4;
        Vector<c> vector = new Vector<c>(4);
        ab ab2 = r.a;
        int n5 = this.c - 4;
        if (n5 < 0) {
            n5 = 0;
        }
        if ((n4 = this.d - 4) < 0) {
            n4 = 0;
        }
        if ((n3 = this.c + 4 + 1) > ab2.a[0].length) {
            n3 = ab2.a[0].length;
        }
        if ((n2 = this.d + 4) > ab2.a.length) {
            n2 = ab2.a.length;
        }
        while (n4 < n2) {
            for (int i2 = n5; i2 < n3; ++i2) {
                if (ab2.a[n4][i2] == null || ab2.a[n4][i2] == this || !(ab2.a[n4][i2] instanceof do)) continue;
                vector.addElement(ab2.a[n4][i2]);
            }
            ++n4;
        }
        return vector;
    }
}

