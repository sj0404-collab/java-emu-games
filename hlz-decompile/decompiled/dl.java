/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class dl
extends ec {
    private byte[] a = null;
    private byte[] ac = null;
    public static dl a = null;
    public static bw[] a = null;
    private byte f;
    private byte g;
    private boolean f = false;
    private final byte[] ad = new byte[]{-22, 24, 35, 24};
    private final byte[] ae = new byte[]{-30, 9, 50, 9};
    private byte[] af = new byte[]{-2, 4, 1, 3};
    private byte[] ag = new byte[]{6, 12, 8, 13};

    public dl(short s, short s2, short s3, byte by) {
        super((short)135, (short)100, s3, by, b.a[by].a);
        this.a = rpg.c.a(ec.b, 12);
        this.ac = rpg.c.a(ec.b, 14);
        this.Z = rpg.c.a(ec.b, 15);
        this.aa = rpg.c.a(ec.b, 16);
        this.ab = rpg.c.a(ec.b, 17);
        this.b(this.a);
        this.h = -1;
        a = this;
        this.i((byte)1);
        this.a((byte)1);
    }

    protected final void c() {
        this.i = this.p == 3 ? this.ac[this.u] : (byte)0;
        this.c = ((db)this).a.a(this.i);
    }

    protected final void c(int n, int n2) {
        ((db)this).a.a(this.i, (byte)1, ((do)this).f, n, n2);
    }

    protected final void n() {
        if (((am)this).c <= 0 && !((db)this).g) {
            dl dl2 = this;
            this.h = (dl2.h + 1) % dl2.Z.length;
            dl2.u = dl2.Z[dl2.h];
            if (dl2.u == 4 && !dl2.f) {
                dl2.h = (dl2.h + 1) % dl2.Z.length;
                dl2.u = dl2.Z[dl2.h];
            }
            switch (dl2.u) {
                case 3: {
                    dl2.f = false;
                }
            }
            dl2.a((byte)3);
            this.a((byte)3);
        }
    }

    private final boolean f() {
        return this.i == 7;
    }

    public final boolean a(x x2, byte by, int n, boolean bl, byte by2, byte by3, boolean bl2, boolean bl3, boolean bl4) {
        if (!this.f()) {
            return super.a(x2, by, -90, bl, by2, by3, bl2, bl3, bl4);
        }
        return super.a(x2, by, n, bl, by2, by3, bl2, bl3, bl4);
    }

    public final boolean a(int n, byte by) {
        if (!this.f()) {
            return super.a(-90, by);
        }
        return super.a(n, by);
    }

    protected final boolean a(do do_, int n, byte by) {
        if (!this.f()) {
            return super.a(do_, -90, by);
        }
        return super.a(do_, n, by);
    }

    protected final boolean a(int n) {
        switch (this.u) {
            case 0: 
            case 1: {
                if (n == 6) {
                    r.a.c(1, 1);
                    if (this.u == 0) {
                        new as(0, (short)(((c)this).a + this.ad[0]), (short)(((c)this).b + this.ad[1]), ((db)this).a, 11, false, a[0], this.a(), 2, 1);
                        break;
                    }
                    new as(0, (short)(((c)this).a + this.ad[2]), (short)(((c)this).b + this.ad[3]), ((db)this).a, 11, false, a[1], this.a(), 2, 1);
                    break;
                }
                if (n != 7) break;
                r.a.c(1, 2);
                break;
            }
            case 2: {
                if (n == 6) {
                    r.a.c(2, 2);
                    new as(0, (short)(((c)this).a + this.ad[0]), (short)(((c)this).b + this.ad[1]), ((db)this).a, 11, false, a[0], this.a(), 2, 1);
                    new as(0, (short)(((c)this).a + this.ad[2]), (short)(((c)this).b + this.ad[3]), ((db)this).a, 12, false, a[1], this.a(), 2, 1);
                    break;
                }
                if (n == 7) {
                    r.a.c(2, 1);
                    break;
                }
                if (n == 8) {
                    r.a.c(1, 2);
                    break;
                }
                if (n != 9) break;
                r.a.c(1, 1);
                break;
            }
            case 3: {
                if (this.f || n <= 2) break;
                x x2 = ((ec)this).a;
                if (((c)x2).a || ((c)x2).b) break;
                new as(0, (short)(((c)this).a + this.ae[0]), (short)(((c)this).b + this.ae[1]), ((db)this).a, 13, false, a[0], this.a(), 2, 1);
                new as(0, (short)(((c)this).a + this.ae[2]), (short)(((c)this).b + this.ae[3]), ((db)this).a, 13, false, a[1], this.a(), 2, 1);
                this.f = true;
                this.f = ((c)x2).c;
                this.g = ((c)x2).d;
                for (int n2 = 1; n2 <= 4; n2 = (int)((byte)(n2 + 1))) {
                    this.a((byte)(this.f + rpg.b.S[n2]), (byte)(this.g + rpg.b.T[n2]), false);
                }
                break;
            }
            case 4: {
                if (n == 5) {
                    new as(0, (short)(this.f << 4), (short)(this.g << 4), ((db)this).a, 16, false, this, this.a(), 2, 1);
                    break;
                }
                if (n != 7) break;
                new as(8, (short)(this.f << 4), (short)(this.g << 4), ((db)this).a, 17, false, this, this.a(), 2, 1);
                break;
            }
            case 5: {
                if (n <= 3 || n % 2 != 0) break;
                new as(13, ((c)((ec)this).a).a, ((c)((ec)this).a).b, ((db)this).a, 15, true, this, this.a(), 0, 6);
                break;
            }
            case 6: {
                if (n != 7) break;
                new as(9, (short)(((c)this).a + 8), (short)(((c)this).d + 4 << 4), ((db)this).a, 14, true, this, this.a(), 0, 15);
            }
        }
        return n == this.ab[this.u];
    }

    protected final void e() {
        do[] doArray = db.a();
        switch (this.u) {
            case 0: 
            case 1: {
                int n = (do.a.nextInt() & 0xFF) % (this.ag[1] - this.ag[0] + 1) + this.ag[0];
                int n2 = (do.a.nextInt() & 0xFF) % (this.ag[3] - this.ag[2] + 1) + this.ag[2];
                if (ab.a(n, n2)) break;
                this.a((byte)n, (byte)n2, true);
                return;
            }
            case 2: {
                for (int i = 0; i < 2; ++i) {
                    if (doArray[i] == null) continue;
                    do do_ = doArray[i];
                    dl dl2 = this;
                    if (!(do_.c >= ((c)dl2).c + dl2.af[0] && do_.c <= ((c)dl2).c + dl2.af[1] && do_.d >= ((c)dl2).d + dl2.af[2] && do_.d <= ((c)dl2).d + dl2.af[3])) continue;
                    this.b(doArray[i], (int)this.a(), (byte)2);
                }
                return;
            }
            case 4: {
                for (int i = 0; i < 2; ++i) {
                    if (doArray[i] == null || this.f != doArray[i].c || this.g != doArray[i].d) continue;
                    this.b(doArray[i], (int)this.a(), (byte)2);
                }
                ab ab2 = r.a;
                for (int n = 1; n <= 4; n = (int)((byte)(n + 1))) {
                    c c2 = ab2.a((int)((byte)(this.f + rpg.b.S[n])), (int)((byte)(this.g + rpg.b.T[n])));
                    if (c2 == null || !(c2 instanceof cp)) continue;
                    ((cp)c2).a((byte)6);
                }
                break;
            }
        }
    }

    protected final void o() {
        r.a.d(this);
        this.c(this.a);
        a[0].o();
        a[1].o();
        a = null;
    }

    public static final void a(bw bw2) {
        if (a == null) {
            a = new bw[2];
        }
        dl.a[dl.a[0] == null ? 0 : 1] = bw2;
        if (a[0] != null && a[1] != null && ((c)dl.a[0]).c > ((c)dl.a[1]).c) {
            dl.a[1] = a[0];
            dl.a[0] = bw2;
        }
    }

    private final void a(byte by, byte by2, boolean bl) {
        do[] doArray = db.a();
        for (int i = 0; i < 2; ++i) {
            if (doArray[i] == null || doArray[i].c != by || doArray[i].d != by2) continue;
            doArray[i].j((byte)2);
        }
        new cp((short)(by << 4), (short)(by2 << 4), bl);
    }
}
