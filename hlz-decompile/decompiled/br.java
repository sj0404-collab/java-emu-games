/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class br
extends am {
    private static final byte[] a = new byte[]{2, 3, 4, 1};
    byte f;
    byte g;
    private byte h;
    private byte i;
    private byte j;
    private byte k;

    public br(short s, short s2, byte by, byte by2) {
        super(s, s2, (byte)8, (byte)8);
        this.g = by;
        this.f = by2;
        this.p = 1;
        this.i = 0;
        this.q = (byte)2;
        this.h = 0;
        this.c = 0;
        this.k(dt.a[this.f]);
        if (this.t <= 0) {
            this.b(-1);
        }
        this.j = ((c)this).c;
        this.k = this.d;
        for (s = 0; s < 4; s = (short)((byte)(s + 1))) {
            if (!this.b(a[s])) continue;
            this.i(a[s]);
            return;
        }
    }

    private boolean b(byte by) {
        return (dt.b[this.f] & 1 << by) != 0;
    }

    public final void b(byte by) {
        if (this.b(by)) {
            this.i(by);
            return;
        }
        if (by != 1 && this.b((byte)2)) {
            this.i((byte)2);
        }
    }

    public final void a(int n, int n2) {
        if ((n = n + ((c)this).a + ((c)this).a) + 16 < 0 || n > bh.g + 16) {
            this.e = false;
            return;
        }
        if ((n2 = n2 + ((c)this).b + ((c)this).b) + 16 < 0 || n2 > bh.h + 16) {
            this.e = false;
            return;
        }
        this.e = true;
        if (!((c)this).c) {
            return;
        }
        this.a(n, n2, false);
        ((do)this).f = dt.a[this.f].a(this.i, this.q, ((do)this).f, n, n2);
        this.d(n, n2);
    }

    protected final boolean d() {
        return false;
    }

    final void d() {
        super.d();
        ++((do)this).f;
        br br2 = this;
        if (((c)br2).c) {
            int n;
            int n2 = n = !((c)br2).a && !((c)br2).b ? 1 : 0;
            if (br2.e || br2.p == 2 || br2.e()) {
                switch (br2.p) {
                    case 2: {
                        if (br2.c == 0 && n != 0) {
                            if (br2.e() && br2.f()) {
                                n = ((do)br2).f;
                                br2.a(r.a, (byte)1);
                                if (br2.p == 2) {
                                    br2.h();
                                    ((do)br2).f = n;
                                    break;
                                }
                                br2.a(16);
                                break;
                            }
                            br2.a(16);
                            break;
                        }
                        br2.h();
                        break;
                    }
                    case 0: 
                    case 1: {
                        if (br2.c != 0 || n == 0) break;
                        br2.i();
                    }
                }
            }
        }
        this.o(dt.a[this.f].a(this.i));
        if (this.c > 0) {
            this.c = (short)(this.c - 1);
        }
    }

    protected final void g() {
        this.a(16);
    }

    public final void c(byte by) {
        this.h = by;
    }

    public final byte a() {
        if (this.p == 1) {
            return this.h;
        }
        return -1;
    }

    protected final boolean a_() {
        if (r.d == 4) {
            return false;
        }
        return super.a_();
    }

    protected final void a_() {
        if (this.g != 1 && this.g != 47) {
            super.a_();
        }
    }

    protected final void b_() {
        if (this.g != 1 && this.g != 47) {
            super.b_();
        }
    }

    protected final boolean e() {
        if (r.d == 4) {
            return false;
        }
        return this.g == 1 || this.g == 47;
    }

    protected final void a(int n) {
        this.c = this.e() ? (short)0 : (short)n;
        this.a((byte)1);
        ((do)this).f = 0;
    }

    private boolean f() {
        int n = this.a(r.a);
        return n > 2 || !((c)r.a).a && !((c)r.a).b;
    }

    protected final void i() {
        if (((am)this).a == 0) {
            if (this.e()) {
                if (this.f()) {
                    this.a(r.a, (byte)1);
                    return;
                }
            } else if (((c)this).c && r.d == 3) {
                if (((c)this).c == this.j && this.d == this.k) {
                    byte by = dt.b[this.f];
                    byte by2 = this.q;
                    if (by == 30) {
                        by2 = (byte)((do.a.nextInt() & 0xFF) % 4 + 1);
                    } else if (by == 6) {
                        by2 = (byte)((do.a.nextInt() & 0xFF) % 2 + 1);
                    } else if (by == 24) {
                        by2 = (byte)((do.a.nextInt() & 0xFF) % 2 + 3);
                    }
                    this.a(by2, (do.a.nextInt() & 0xFF) % 3);
                    return;
                }
                if (((c)this).c != this.j) {
                    byte by = ((c)this).c > this.j ? (byte)3 : 4;
                    this.a(by, Math.abs(((c)this).c - this.j));
                    return;
                }
                if (this.d != this.k) {
                    byte by = this.d > this.k ? (byte)1 : 2;
                    this.a(by, Math.abs(this.d - this.k));
                }
            }
        }
    }

    public final void a(byte by) {
        if (by == 2 && this.t == 0) {
            this.k((byte)8);
        } else if (by == 1) {
            this.k(dt.a[this.f]);
        }
        super.a(by);
        this.i = this.p == 2 ? (byte)1 : 0;
    }

    final byte a(int n) {
        return dt.a[this.f].a((byte)n);
    }

    public final void d(byte by) {
        this.a((byte)99);
        this.i = by;
    }
}
