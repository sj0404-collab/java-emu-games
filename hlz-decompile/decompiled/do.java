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

    public do(short s, short s2, byte by, byte by2) {
        super(s, s2, by, by2);
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

    void a(byte by) {
        this.p = by;
        this.f = -1;
    }

    final void i(byte by) {
        this.q = this.r = by;
    }

    final void o(int n) {
        if (this.f >= n) {
            this.f = 0;
        }
    }

    final void c(df df2) {
        int n = df2.b;
        do do_ = this;
        if (df.a((byte)n)) {
            for (int i = n = do_.a.size() - 1; i >= 0; --i) {
                df df3 = (df)do_.a.elementAt(i);
                if (!df.a(df3.b)) continue;
                df3.a = true;
            }
        }
        this.a.addElement(df2);
    }

    void b(byte by, int n) {
        if (this.e(by)) {
            this.b.addElement(new dn(by, n));
        }
    }

    void a(byte by, byte by2, int n) {
        if (this.e(by)) {
            this.b.addElement(new cl(by, by2, n));
        }
    }

    boolean a(byte by) {
        if (this.e(by)) {
            this.b.addElement(new bj(by));
            return true;
        }
        return false;
    }

    boolean a(byte by, int n) {
        if (this.e(by)) {
            this.b.addElement(new bj(by, n));
            return true;
        }
        return false;
    }

    final boolean e(byte by) {
        for (int i = this.b.size() - 1; i >= 0; --i) {
            df df2 = (df)this.b.elementAt(i);
            if (df2.b != by) continue;
            return false;
        }
        return true;
    }

    protected final void z() {
        for (int i = this.b.size() - 1; i >= 0; --i) {
            df df2 = (df)this.b.elementAt(i);
            if (df2.a) {
                this.b(df2);
                this.b.removeElementAt(i);
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

    protected final void p(int n) {
        this.b_();
        ((c)this).a = (short)(((c)this).a + rpg.b.S[this.q] * n);
        ((c)this).b = (short)(((c)this).b + rpg.b.T[this.q] * n);
        this.a();
        this.a_();
    }

    abstract void g();

    protected void a_() {
        ab ab2 = r.a;
        for (byte by = 0; by < this.e; by = (byte)(by + 1)) {
            ab2.a[this.d][this.c + by] = this;
            if (((c)this).b) {
                ab2.a[this.d + 1][this.c + by] = this;
                continue;
            }
            if (!((c)this).a) continue;
            ab2.a[this.d][this.c + 1 + by] = this;
        }
    }

    protected void b_() {
        ab ab2 = r.a;
        for (byte by = 0; by < this.e; by = (byte)(by + 1)) {
            ab2.a[this.d][this.c + by] = null;
            if (((c)this).b) {
                ab2.a[this.d + 1][this.c + by] = null;
                continue;
            }
            if (!((c)this).a) continue;
            ab2.a[this.d][this.c + 1 + by] = null;
        }
    }

    protected final void d(int n, int n2) {
        for (int i = this.a.size() - 1; i >= 0; --i) {
            df df2 = (df)this.a.elementAt(i);
            df2.a(n, n2, true);
            if (!df2.a) continue;
            this.a.removeElementAt(i);
        }
    }

    protected final void b(int n, int n2, boolean bl) {
        for (int i = this.b.size() - 1; i >= 0; --i) {
            df df2 = (df)this.b.elementAt(i);
            df2.a(n, n2, bl);
        }
    }

    protected final c a(byte by, c c2) {
        int n;
        int n2 = this.d + rpg.b.T[by];
        if (n2 < 0 || n2 >= ab.d) {
            return null;
        }
        ab ab2 = r.a;
        for (int i = 0; i < this.e && (n = this.c + rpg.b.S[by] + i) >= 0 && n < ab.c; ++i) {
            c c3 = ab2.a[n2][n];
            if (c3 == this || c3 == null || c2 != null && (c2 == null || c3 != c2)) continue;
            return c3;
        }
        return null;
    }

    protected final boolean l() {
        return this.f(this.q);
    }

    protected final boolean f(byte by) {
        int n = this.c + rpg.b.S[by];
        byte by2 = this.d + rpg.b.T[by];
        if (n >= ab.c || by2 >= ab.d || n < 0 || by2 < 0) {
            return false;
        }
        if (!r.a.d(n, by2)) {
            return false;
        }
        ab ab2 = r.a;
        by2 = rpg.b.W[by];
        byte by3 = rpg.b.X[by];
        byte by4 = rpg.b.U[by];
        byte by5 = rpg.b.V[by];
        if (ab2.a(this, by3) && ab2.a(this, by5)) {
            this.s = by;
            this.a((byte)2);
            this.i(by3);
            return true;
        }
        if (ab2.a(this, by2) && ab2.a(this, by4)) {
            this.s = by;
            this.a((byte)2);
            this.i(by2);
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

    protected void j(byte by) {
        if (r.a.a(this, by)) {
            this.b_();
            ((c)this).a = (short)(((c)this).a + (rpg.b.S[by] << 4));
            ((c)this).b = (short)(((c)this).b + (rpg.b.T[by] << 4));
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

    public int c(byte by) {
        return 0;
    }

    boolean a(do do_, int n, byte by) {
        return false;
    }

    protected final void k(byte by) {
        this.t = by;
    }

    protected final db b(byte by) {
        c c2 = this.a(by, null);
        if (c2 != null && c2 instanceof db && !(c2 instanceof an)) {
            return (db)c2;
        }
        return null;
    }

    protected final void q(int n) {
        if (this.g > 0) {
            return;
        }
        this.g = n;
        byte by = (byte)(this.t >> 1);
        do do_ = this;
        this.t = by;
    }

    protected void s() {
        if (this.g == 0 && !((c)this).a && !((c)this).b) {
            this.g = -1;
            byte by = (byte)(this.t << 1);
            do do_ = this;
            this.t = by;
        }
    }

    protected void a(do do_, int n, byte by, byte by2) {
    }

    public boolean c() {
        return true;
    }

    public boolean b() {
        return false;
    }

    public void b(int n, int n2) {
    }

    public void n(int n) {
    }

    protected final boolean m() {
        int n;
        int n2 = 0;
        for (int i = n = this.b.size() - 1; i >= 0; --i) {
            df df2 = (df)this.b.elementAt(i);
            if (df2 == null) continue;
            df2.a = true;
            this.b(df2);
            this.b.removeElementAt(i);
            ++n2;
        }
        return n2 > 0;
    }

    protected final Vector b(byte by) {
        int n;
        int n2;
        int n3;
        Vector<c> vector = new Vector<c>(4);
        ab ab2 = r.a;
        int n4 = this.c - 4;
        if (n4 < 0) {
            n4 = 0;
        }
        if ((n3 = this.d - 4) < 0) {
            n3 = 0;
        }
        if ((n2 = this.c + 4 + 1) > ab2.a[0].length) {
            n2 = ab2.a[0].length;
        }
        if ((n = this.d + 4) > ab2.a.length) {
            n = ab2.a.length;
        }
        while (n3 < n) {
            for (int i = n4; i < n2; ++i) {
                if (ab2.a[n3][i] == null || ab2.a[n3][i] == this || !(ab2.a[n3][i] instanceof do)) continue;
                vector.addElement(ab2.a[n3][i]);
            }
            ++n3;
        }
        return vector;
    }
}
