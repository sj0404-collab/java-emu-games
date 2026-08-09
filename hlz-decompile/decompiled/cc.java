/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class cc
extends bm {
    private byte b;
    private byte c = 0;
    private boolean a;
    private byte i = 0;
    private bp a;
    private dg a;
    private bs a;
    private d a;
    private byte j = 0;
    private int[] a;
    private dg[] a = new dg[3];
    private dg[] b;
    private byte[] b;
    private cx b;
    private boolean b = false;

    public cc(ah ah2, boolean bl) {
        super(ah2);
        int n;
        this.b = true;
        try {
            this.b = new cx("/t/ne");
        }
        catch (Exception exception) {}
        this.b = 1;
        this.a();
        this.c = (byte)2;
        this.i = 0;
        this.a = null;
        this.a = null;
        for (n = 0; n < 6; ++n) {
            this.b[n] = null;
        }
        for (n = 0; n < 3; ++n) {
            this.a[n] = null;
        }
        this.a = this.c == 1 ? r.a() : r.c();
        this.b = this.b.a(0 + this.c);
        this.a = false;
        this.a();
    }

    public cc(ah ah2) {
        super(null);
        try {
            this.b = new cx("/t/ne");
        }
        catch (Exception exception) {}
        this.b = 0;
        ((ah)this).b = new bk(this, this.b.a(0), this.b.a(1, 2));
        this.a();
    }

    public final void a() {
        super.a();
        rpg.a.a = true;
    }

    protected final boolean a(dg dg2) {
        if (this.c == 1) {
            if (dg2 != null) {
                if (this.i == 0) {
                    return dg2.b();
                }
                if (dg2.g == 17) {
                    return true;
                }
            }
        } else if (this.c == 2 && dg2 != null && dg2.g == 18) {
            return true;
        }
        return false;
    }

    private byte a(boolean n) {
        if (n != 0) {
            if (this.i <= 0) {
                return 7;
            }
            if (this.a == null) {
                if (this.i >= 7) {
                    return 0;
                }
                return 7;
            }
            if (this.i == 1) {
                return 0;
            }
            for (n = (int)((byte)(this.i - 2)); n >= 0; n = (int)((byte)(n - 1))) {
                if (this.a.a[n] != -1) continue;
                return (byte)(n + 1);
            }
            return 0;
        }
        if (this.i >= 7) {
            return 0;
        }
        if (this.a == null) {
            if (this.i == 0) {
                return 7;
            }
            return 0;
        }
        for (n = this.i; n < 6; n = (int)((byte)(n + 1))) {
            if (this.a.a[n] != -1) continue;
            return (byte)(n + 1);
        }
        return 7;
    }

    final void a(byte by, byte by2) {
        if (this.b == 0) {
            this.g();
            this.b = 1;
            this.a();
            this.c = (byte)(by2 + 1);
            this.i = 0;
            this.a = null;
            this.a = null;
            for (by = 0; by < 6; by = (byte)(by + 1)) {
                this.b[by] = null;
            }
            for (by = 0; by < 3; by = (byte)(by + 1)) {
                this.a[by] = null;
            }
            this.a = this.c == 1 ? r.a() : r.c();
            this.b = this.b.a(0 + this.c);
            this.a = false;
            return;
        }
        if (by == -1 && by2 == -1 && ((ah)this).b instanceof bd) {
            this.g();
            this.a();
            return;
        }
        this.g();
        m.b();
        this.a();
    }

    /*
     * Enabled aggressive block sorting
     */
    final boolean a(int n, int n2) {
        block55: {
            block54: {
                if (this.j > 0) {
                    return true;
                }
                if (((bm)this).a > 0) {
                    return true;
                }
                if (ah.g(n, n2)) {
                    if (this.b == 0) {
                        m.b();
                        this.a();
                        return true;
                    }
                    if (this.b == 1) {
                        if (this.a) {
                            this.a = false;
                            this.a();
                        } else {
                            if (((ah)this).b != null && ((ah)this).b instanceof bd && this.b(n, n2)) {
                                return true;
                            }
                            if (this.b) {
                                ((ah)this).a.g();
                            }
                            this.b = 0;
                            ((ah)this).b = new bk(this, this.b.a(0), this.b.a(1, 2));
                            this.a();
                            this.a = null;
                        }
                        bh.c = true;
                        return true;
                    }
                }
                if (this.b(n, n2)) {
                    return true;
                }
                if (this.a) {
                    if (ah.g(n, n2)) {
                        this.a = false;
                        return true;
                    }
                    if (!ah.f(n, n2)) {
                        this.d(n, n2);
                        this.e(n, n2);
                        return true;
                    }
                    this.a = this.a.a(this.d);
                    if (!this.a(this.a)) {
                        this.a = null;
                        return true;
                    }
                    this.a = false;
                    if (this.c == 2) {
                        if (!(this.a instanceof d)) {
                            ((bm)this).a = (byte)15;
                            ((bm)this).a = this.b.a(8);
                            return true;
                        }
                        this.a = (d)this.a;
                        this.a[0] = null;
                        this.a[1] = null;
                        this.a[2] = null;
                        if (this.a.b[0] != -1) {
                            this.a[0] = dg.a(this.a.b[0], this.a.b[1]);
                            this.a[0] = r.a(this.a.b[0]).a(this.a.b[0], this.a.b[1]);
                        }
                        if (this.a.b[2] != -1) {
                            this.a[1] = dg.a(this.a.b[2], this.a.b[3]);
                            this.a[1] = r.a(this.a.b[2]).a(this.a.b[2], this.a.b[3]);
                        }
                        if (this.a.b[4] == -1) return true;
                        this.a[2] = dg.a(this.a.b[4], this.a.b[5]);
                        this.a[2] = r.a(this.a.b[4]).a(this.a.b[4], this.a.b[5]);
                        return true;
                    }
                    if (this.c != 1) return true;
                    if (this.a instanceof bs) {
                        this.a = (bs)this.a;
                        n = 0;
                        while (n < 6) {
                            this.b[n] = null;
                            ++n;
                        }
                        return true;
                    }
                    if (this.a.g != 17) {
                        ((bm)this).a = (byte)15;
                        ((bm)this).a = this.b.a(9);
                        return true;
                    }
                    n = 0;
                    n2 = r.a((byte)17).a((byte)17, this.a.h);
                    this.b[this.i - 1] = this.a;
                    int n3 = 0;
                    while (true) {
                        if (n3 >= 6) {
                            if (n2 >= n) return true;
                            this.b[this.i - 1] = null;
                            ((bm)this).a = (byte)15;
                            ((bm)this).a = this.b.a(11);
                            return true;
                        }
                        if (this.b[n3] != null && this.b[n3].g == 17 && this.b[n3].h == this.a.h) {
                            ++n;
                        }
                        ++n3;
                    }
                }
                if (this.c != 1) break block54;
                if (n2 == 50 || n == 1) {
                    this.i = this.a(true);
                    break block55;
                } else if (n2 == 56 || n == 6) {
                    this.i = this.a(false);
                }
                break block55;
            }
            if (n2 == 50 || n == 1) {
                this.i = (byte)((this.i + 1) % 2);
            } else if (n2 == 56 || n == 6) {
                this.i = (byte)((this.i + 1) % 2);
            }
        }
        if (!ah.f(n, n2)) return true;
        if (this.i == 0) {
            this.a = true;
            this.a = this.c == 1 ? r.a() : r.c();
            return true;
        }
        if (this.c == 2) {
            if (this.a == null) {
                ((bm)this).a = (byte)15;
                ((bm)this).a = rpg.b.L;
                return true;
            }
            if (this.b) {
                cc cc2 = this;
                dg dg2 = dg.a(cc2.a.a[0], cc2.a.a[1]);
                if (!r.a(dg2.g).a(dg2.g, dg2.h, 1)) {
                    bd bd2 = (bd)((ah)cc2).a;
                    bd2.a(((bm)cc2).a.a(6), 0, dg2);
                    return true;
                }
                bd bd3 = (bd)((ah)cc2).a;
                bd3.a(((bm)cc2).a.a(3), 1, dg2);
                return true;
            }
            if (this.a[0] != 0 && this.a[1] != 0 && this.a[2] != 0) {
                this.j = (byte)15;
                ((bm)this).a = this.b.a(5 + (this.c - 1));
                return true;
            }
            if (!j.a) {
                ((ah)this).b = new bd(this);
                dg dg3 = dg.a(this.a.a[0], this.a.a[1]);
                ((bd)((ah)this).b).a(((bm)this).a.a(3), dg3);
                return true;
            }
        } else {
            if (this.c != 1) return true;
            if (this.i > 0 && this.i < 7) {
                this.a = true;
                this.a = r.a((byte)17);
                return true;
            }
            if (this.i != 7) return true;
            if (this.a == null) return false;
            if (this.a.a == null) {
                return false;
            }
            n2 = 0;
            for (n = 0; n < 6; ++n) {
                if (this.a.a[n] != -1) continue;
                ++n2;
            }
            if (n2 == 0) {
                ((bm)this).a = (byte)15;
                ((bm)this).a = this.b.a(10);
                return true;
            }
            byte[] byArray = new byte[16];
            byte[] byArray2 = new byte[16];
            boolean bl = false;
            boolean bl2 = false;
            for (n = 0; n < 16; ++n) {
                byArray[n] = 0;
                byArray2[n] = 0;
            }
            for (n = 0; n < 6; ++n) {
                if (this.a.a[n] >= 0) {
                    byte by = this.a.a[n];
                    byArray[by] = (byte)(byArray[by] + 1);
                    continue;
                }
                if (this.b[n] == null) continue;
                byte by = this.b[n].h;
                byArray2[by] = (byte)(byArray2[by] + 1);
                bl2 = true;
            }
            for (n = 0; n < 6; ++n) {
                if (byArray2[n] <= 1) continue;
                bl = true;
            }
            for (n = 0; n < 16; ++n) {
                if (byArray2[n] <= 0 || byArray[n] <= 0) continue;
                bl = true;
            }
            if (!bl2) {
                return false;
            }
            if (bl) {
                ((bm)this).a = (byte)15;
                ((bm)this).a = this.b.a(14);
                return true;
            }
            boolean bl3 = true;
            for (n = 0; n < 6; ++n) {
                if (this.b[n] == null || r.a(this.b[n].g).a(this.b[n].g, this.b[n].h) > 0) continue;
                bl3 = false;
            }
            if (bl3) {
                n = 0;
                while (true) {
                    if (n >= 6) {
                        r.a.k();
                        ((bm)this).a = (byte)15;
                        ((bm)this).a = ((bm)this).a.a(3);
                        return true;
                    }
                    if (this.b[n] != null) {
                        this.a.a[n] = this.b[n].h;
                        r.a(this.b[n].g).b(this.b[n].g, this.b[n].h, 1);
                    }
                    this.b[n] = null;
                    ++n;
                }
            }
        }
        ((bm)this).a = (byte)15;
        ((bm)this).a = this.b.a(7);
        return true;
    }

    protected final void a(cr cr2) {
        r.a.c();
        ah.a(cr2, 3);
        if (this.b == 0) {
            return;
        }
        if (this.c != 0) {
            int n;
            byte by;
            this.a(cr2, false, true, this.b, false);
            if (this.a) {
                this.a(cr2, (byte)0, false, 1, true);
                int n2 = this.g + 80;
                ah.c(cr2, this.f, n2, 16);
                this.a(cr2, this.a);
                int n3 = this.g + 174 - 11;
                this.b(cr2);
                dg dg2 = this.a.a(this.d);
                this.a(cr2, this.f, n2 + 2, dg2);
                cr2.b(this.f, this.g, 160, 174);
                cr2.a(3550755);
                this.d(cr2, this.f + 111, n3 + 2, r.e);
            } else {
                int n4;
                Object object;
                Object object2 = object = this.c == 1 ? this.a : this.a;
                if (this.a) {
                    object = this.a;
                }
                ah.c(cr2, this.f + 73, this.g + 15, 14, 14, 0);
                if (object != null) {
                    ((dg)object).a(cr2, this.f + 73, this.g + 15);
                }
                if (this.i == 0) {
                    bm.b(cr2, this.f + 73, this.g + 15);
                }
                ah.c(cr2, this.f, this.g + 31, 16);
                this.a(cr2, this.f, this.g + 31 + 2, (dg)object, this.c != 1);
                if (this.c == 1) {
                    for (int i = 0; i < 6; ++i) {
                        byte by2 = -3;
                        if (this.a != null) {
                            by2 = this.a.a[i];
                        }
                        if (this.b[i] != null) {
                            by2 = ((de)this.b[i]).a;
                        }
                        boolean bl = this.i == (byte)(i + 1);
                        by = by2;
                        n = this.g + 31 + 2 + 75 + (i / 2 << 4);
                        n4 = this.f + i % 2 * 80;
                        cr cr3 = cr2;
                        object = this;
                        if (by <= -2) continue;
                        ah.c(cr3, n4 + 1, n, 78, 15, bl ? 26214 : 7027456);
                        cr3.a(bl ? 0xFF0000 : 3550755);
                        cr3.e(n4 + 2, n, n4 + 80 - 3, n);
                        cr3.e(n4 + 2, n + 14, n4 + 80 - 3, n + 14);
                        cr3.e(n4 + 1, n + 1, n4 + 1, n + 14);
                        cr3.e(n4 + 80 - 2, n + 1, n4 + 80 - 2, n + 14);
                        object = aw.a(by);
                        ah.c(cr3, n4 + 4, n + 4, 5, 5, 3550755);
                        cr3.a(0);
                        cr3.a(n4 + 4 + 1, n + 4 + 1, 3, 3);
                        cr3.a(15723216);
                        dv.a(cr3, n4 + 40 + 5, n + 1, (byte[])object, 0, 1);
                    }
                    this.a(cr2, this.f + 3, this.g + 174 - 16, 154, this.b.a(3), this.i == 7);
                } else {
                    int n5;
                    for (n5 = 0; n5 < 3; ++n5) {
                        by = this.a[n5];
                        dg dg3 = this.a[n5];
                        n4 = n5;
                        cr cr4 = cr2;
                        object = this;
                        int n6 = ((ah)object).g + 31 + 5 + 27 + n4 * 15;
                        ah.c(cr4, ((ah)object).f + 3, n6, 90, 14, 3550755);
                        cr4.a(by == 0 ? 0xFF0000 : 15723216);
                        if (dg3 != null) {
                            dv.a(cr4, ((ah)object).f + 3 + 2, n6 + 1, dg3.c, 0);
                        }
                        ah.c(cr4, ((ah)object).f + 3 + 90 + 2, n6, 62, 14, 3550755);
                        cr4.a(15723216);
                        ah.b(cr4, by, ((ah)object).f + 3 + 90 + 2 + 62 - 3, n6 + 3, 8, 0);
                    }
                    this.a(cr2, this.f + 3, this.g + 174 - 16, 154, this.b.a(4), this.i == 1);
                    if (this.b) {
                        n5 = rpg.a.c;
                        int n7 = this.g + 174 - 46;
                        cr2.a(3550755);
                        dv.a(cr2, n5 - 1, n7 - 1, rpg.b.K, 0, 1);
                        dv.a(cr2, n5 - 1, n7, rpg.b.K, 0, 1);
                        dv.a(cr2, n5 - 1, n7 + 1, rpg.b.K, 0, 1);
                        dv.a(cr2, n5 + 1, n7 - 1, rpg.b.K, 0, 1);
                        dv.a(cr2, n5 + 1, n7, rpg.b.K, 0, 1);
                        dv.a(cr2, n5 + 1, n7 + 1, rpg.b.K, 0, 1);
                        dv.a(cr2, n5, n7 - 1, rpg.b.K, 0, 1);
                        dv.a(cr2, n5, n7 + 1, rpg.b.K, 0, 1);
                        cr2.a(0xFF0000);
                        dv.a(cr2, n5, n7, rpg.b.K, 0, 1);
                    }
                }
            }
            if (this.j > 0 || ((bm)this).a > 0) {
                bm.a(cr2, this.f, this.g, ((bm)this).a, 1);
                if (((bm)this).a > 0) {
                    ((bm)this).a = (byte)(((bm)this).a - 1);
                    if (((bm)this).a == 0) {
                        this.j = 0;
                        ((bm)this).a = 0;
                        ((bm)this).a = null;
                    }
                }
                if (this.j > 0) {
                    this.j = (byte)(this.j - 1);
                    if (this.j == 0) {
                        byte[] byArray;
                        cc cc2 = this;
                        dg dg4 = dg.a(cc2.a.a[0], cc2.a.a[1]);
                        if (!r.a(dg4.g).a(dg4.g, dg4.h, 1)) {
                            byArray = ((bm)cc2).a.a(6);
                        } else {
                            by = r.a(cc2.a.b[0]).a(cc2.a.b[0], cc2.a.b[1], true);
                            n = by == 0 ? 0 : 1;
                            by = r.a(cc2.a.b[2]).a(cc2.a.b[2], cc2.a.b[3], true);
                            n = by == 0 ? 0 : n;
                            by = r.a(cc2.a.b[4]).a(cc2.a.b[4], cc2.a.b[5], true);
                            n = by == 0 ? 0 : n;
                            if (n == 0) {
                                byArray = cc2.b.a(7);
                            } else if (r.a(dg4.g).a(dg4, 1) == 0) {
                                byArray = ((bm)cc2).a.a(6);
                            } else {
                                r.a(cc2.a.b[0]).b(cc2.a.b[0], cc2.a.b[1], 1);
                                r.a(cc2.a.b[2]).b(cc2.a.b[2], cc2.a.b[3], 1);
                                r.a(cc2.a.b[4]).b(cc2.a.b[4], cc2.a.b[5], 1);
                                cc2.a[0] = cc2.a[0] - 1;
                                cc2.a[1] = cc2.a[1] - 1;
                                cc2.a[2] = cc2.a[2] - 1;
                                byArray = ((bm)cc2).a.a(3);
                            }
                        }
                        ((bm)this).a = byArray;
                        this.j = 0;
                        ((bm)this).a = (byte)15;
                    }
                }
                this.a();
            }
        }
    }
}
