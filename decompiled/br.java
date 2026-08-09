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

    public br(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, (byte)8, (byte)8);
        this.g = by2;
        this.f = by3;
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
        for (s2 = 0; s2 < 4; s2 = (short)((byte)(s2 + 1))) {
            if (!this.b(a[s2])) continue;
            this.i(a[s2]);
            return;
        }
    }

    private boolean b(byte by2) {
        return (dt.b[this.f] & 1 << by2) != 0;
    }

    public final void b(byte by2) {
        if (this.b(by2)) {
            this.i(by2);
            return;
        }
        if (by2 != 1 && this.b((byte)2)) {
            this.i((byte)2);
        }
    }

    public final void a(int n2, int n3) {
        if ((n2 = n2 + ((c)this).a + ((c)this).a) + 16 < 0 || n2 > bh.g + 16) {
            this.e = false;
            return;
        }
        if ((n3 = n3 + ((c)this).b + ((c)this).b) + 16 < 0 || n3 > bh.h + 16) {
            this.e = false;
            return;
        }
        this.e = true;
        if (!((c)this).c) {
            return;
        }
        this.a(n2, n3, false);
        ((do)this).f = dt.a[this.f].a(this.i, this.q, ((do)this).f, n2, n3);
        this.d(n2, n3);
    }

    protected final boolean d() {
        return false;
    }

    final void d() {
        super.d();
        ++((do)this).f;
        br br2 = this;
        if (((c)br2).c) {
            int n2;
            int n3 = n2 = !((c)br2).a && !((c)br2).b ? 1 : 0;
            if (br2.e || br2.p == 2 || br2.e()) {
                switch (br2.p) {
                    case 2: {
                        if (br2.c == 0 && n2 != 0) {
                            if (br2.e() && br2.f()) {
                                n2 = ((do)br2).f;
                                br2.a(r.a, (byte)1);
                                if (br2.p == 2) {
                                    br2.h();
                                    ((do)br2).f = n2;
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
                        if (br2.c != 0 || n2 == 0) break;
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

    public final void c(byte by2) {
        this.h = by2;
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

    protected final void a(int n2) {
        this.c = this.e() ? (short)0 : (short)n2;
        this.a((byte)1);
        ((do)this).f = 0;
    }

    private boolean f() {
        int n2 = this.a(r.a);
        return n2 > 2 || !((c)r.a).a && !((c)r.a).b;
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
                    byte by2 = dt.b[this.f];
                    byte by3 = this.q;
                    if (by2 == 30) {
                        by3 = (byte)((do.a.nextInt() & 0xFF) % 4 + 1);
                    } else if (by2 == 6) {
                        by3 = (byte)((do.a.nextInt() & 0xFF) % 2 + 1);
                    } else if (by2 == 24) {
                        by3 = (byte)((do.a.nextInt() & 0xFF) % 2 + 3);
                    }
                    this.a(by3, (do.a.nextInt() & 0xFF) % 3);
                    return;
                }
                if (((c)this).c != this.j) {
                    byte by4 = ((c)this).c > this.j ? (byte)3 : 4;
                    this.a(by4, Math.abs(((c)this).c - this.j));
                    return;
                }
                if (this.d != this.k) {
                    byte by5 = this.d > this.k ? (byte)1 : 2;
                    this.a(by5, Math.abs(this.d - this.k));
                }
            }
        }
    }

    public final void a(byte by2) {
        if (by2 == 2 && this.t == 0) {
            this.k((byte)8);
        } else if (by2 == 1) {
            this.k(dt.a[this.f]);
        }
        super.a(by2);
        this.i = this.p == 2 ? (byte)1 : 0;
    }

    final byte a(int n2) {
        return dt.a[this.f].a((byte)n2);
    }

    public final void d(byte by2) {
        this.a((byte)99);
        this.i = by2;
    }
}

