/*
 * Decompiled with CFR 0.152.
 */
import java.util.Vector;
import rpg.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class an
extends db {
    private x a = null;
    private short d = (short)-1;

    public static final void a(x do_, short s) {
        if (r.a != null) {
            do_ = r.a;
            ((db)r.a).a = null;
            ((db)do_).c(((db)do_).d);
            ((an)do_).a((byte)8);
            ((an)do_).d = s;
            return;
        }
        new an((x)do_, s);
    }

    private an(x x2, short s) {
        super(((c)x2).a, ((c)x2).b);
        this.a = x2;
        this.o = this.a.b();
        this.e = ((db)this).d = this.a.e((byte)0);
        this.g = this.f = (short)this.a.a;
        this.i = (short)this.a.d((byte)1);
        this.e = (short)-1;
        this.j = 1;
        this.d = s;
        ((am)this).e = true;
        ((db)this).a = null;
        ((db)this).a = rpg.c.a;
        this.k = (byte)3;
        this.l = (byte)2;
        if (this.a((byte)1, (byte)4)) {
            r.a.a(this);
            r.a = this;
        }
    }

    protected final boolean a(byte by, byte by2) {
        ((am)this).c = 0;
        if (this.a(((c)this.a).c, ((c)this.a).d, (byte)1, (byte)4)) {
            this.a((byte)8);
            return true;
        }
        this.a((byte)7);
        return false;
    }

    public final void a(int n, int n2) {
        n = n + ((c)this).a + ((c)this).a;
        n2 = n2 + ((c)this).b + ((c)this).b + 1;
        if (this.m > 0) {
            this.m = (byte)(this.m - 1);
            if (this.m % 2 == 0) {
                n += b.S[this.n] << 1;
                n2 += b.T[this.n] << 1;
            }
        }
        if (n < -16 || n2 < 0 || n > bh.g + 16 || n2 > bh.h + 32) {
            ((am)this).e = false;
            return;
        }
        ((am)this).e = true;
        this.a(n, n2, false);
        ((db)this).a.a(this.i, this.i == 4 ? (byte)1 : this.q, ((do)this).f, n, n2);
        this.b(n, n2, true);
        this.d(n, n2);
    }

    protected final void a(byte by) {
        if (by != 4) {
            super.a(by);
        }
    }

    protected final void c() {
        switch (this.p) {
            case 2: {
                this.i = (byte)2;
                break;
            }
            case 3: {
                this.i = (byte)6;
                break;
            }
            case 6: {
                this.i = (byte)4;
                break;
            }
            case 8: {
                this.i = (byte)16;
                break;
            }
            default: {
                this.i = 0;
            }
        }
        this.c = ((db)this).a.a(this.i);
    }

    public final void d() {
        this.d = (short)(this.d - 1);
        if (this.d < 0 && this.p != 6 && this.p != 7) {
            this.a((byte)6);
            return;
        }
        if (!((am)this).e || this.a((c)this.a) > 6 && this.b(this.a) > 6) {
            ((db)this).a = null;
            this.b_();
            if (!this.a((byte)1, (byte)8)) {
                this.d = 0;
                return;
            }
        } else {
            super.d();
        }
    }

    protected final void i() {
        if (this.i()) {
            this.a(0);
        }
    }

    protected final void e() {
        if (((db)this).a == this.a(this.q, ((db)this).a)) {
            this.b(((db)this).a, (int)this.a(), this.q);
        }
    }

    protected final void j() {
        this.a((int)this.k);
    }

    protected final void k() {
        do do_ = null;
        Vector vector = this.b((byte)4);
        while (vector.size() > 0) {
            int n = (do.a.nextInt() & 0xFF) % vector.size();
            c c2 = (c)vector.elementAt(n);
            if (c2 instanceof db && !(c2 instanceof an)) {
                do_ = (do)c2;
                break;
            }
            vector.removeElementAt(n);
        }
        if (do_ != null && this.b(do_)) {
            ((db)this).a = do_;
        }
    }

    public final byte b() {
        return this.a.b();
    }

    public final int b() {
        return this.a.b();
    }

    public final int c(byte by) {
        return this.a.c(by);
    }

    public final boolean a(do do_) {
        return this.a.a(do_);
    }

    protected final boolean a(int n) {
        return n == 1 || n == 4;
    }

    public final void l() {
        this.a = null;
        this.d = (short)-1;
        this.a((byte)7);
        r.a = null;
        r.a.d(this);
    }

    protected final void g() {
        if (((db)this).a == null || this.a((c)((db)this).a) > 1) {
            byte by = this.q;
            for (int i = 0; i < 4; ++i) {
                c c2 = this.a(by, null);
                if (c2 != null && c2 instanceof db) {
                    ((db)this).a = (do)c2;
                    this.i(by);
                    this.a((byte)3);
                    return;
                }
                by = b.X[by];
            }
        }
        super.g();
    }

    protected final boolean a(c c2) {
        if (c2 == null) {
            ((db)this).a = null;
            return false;
        }
        if (c2 instanceof do && ((do)c2).p == 7) {
            ((db)this).a = null;
            return false;
        }
        if (c2 instanceof db) {
            for (byte by = 1; by <= 4; by = (byte)(by + 1)) {
                if (this.a(by, c2) != c2) continue;
                this.i(by);
                return true;
            }
        }
        return super.a(c2);
    }

    public final int a() {
        return this.a.c();
    }

    public final short a() {
        int n;
        int n2 = n = ((do)this).f == 4 ? this.a.a(true) : this.a.a(false);
        if (!this.a.f && this.i) {
            return (short)((n << 2) / 5);
        }
        return (short)n;
    }
}
