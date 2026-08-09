/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;
import rpg.d;
import rpg.g;

final class w
extends p {
    private boolean h = false;

    public w(ah ah2) {
        super(ah2, (byte)7, (byte)3, (byte)3);
        p.c = true;
    }

    public static void c() {
        if (p.b != null) {
            p.b = null;
        }
        if (p.a != null) {
            p.a = null;
        }
        if (p.a != null) {
            p.a = null;
        }
        if (p.b != null) {
            p.b = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (this.h) {
            this.h = false;
            return true;
        }
        if (ah.g(n2, n3)) {
            if (((ah)this).a instanceof dj) {
                ((ah)this).a.d = (byte)4;
            }
            ((ah)this).a.g();
            return true;
        }
        if (ah.f(n2, n3)) {
            n3 = this.d;
            w w2 = this;
            Object object = r.a.a((byte)n3);
            if (object == null) {
                if (w2.d == 5) {
                    if (!r.b()) {
                        w2.a(dj.a.a(38));
                        return true;
                    }
                    if (r.b != 2 && r.a.a((byte)3) == null) {
                        w2.a(dj.a.a(59));
                        return true;
                    }
                }
                byte[] byArray = p.a[w2.d];
                object = byArray;
                if (byArray != null) {
                    ((ah)w2).b = new bq(w2, w2.d);
                    return true;
                }
                w2.a(dj.a.a(60));
                return true;
            }
            byte[] byArray = p.a[w2.d];
            object = byArray;
            if (byArray != null) {
                ((ah)w2).b = new q(w2, dj.a.a(65, 66), 1);
                return true;
            }
            ((ah)w2).b = new bk((ah)w2, dj.a.a(67), 3, true);
            return true;
        }
        if (n3 == 52) return this.a((byte)3);
        if (n2 == 2) {
            return this.a((byte)3);
        }
        if (n3 == 54) return this.a((byte)4);
        if (n2 == 5) {
            return this.a((byte)4);
        }
        if (n3 == 50) return this.b((byte)3);
        if (n2 == 1) {
            return this.b((byte)3);
        }
        if (n3 == 56) return this.b((byte)4);
        if (n2 != 6) return true;
        return this.b((byte)4);
    }

    final void a(byte by2, byte by3) {
        this.g();
        if (by2 == 6) {
            if (by3 == 0) {
                byte[] byArray = p.a[this.d];
                if (byArray != null) {
                    ((ah)this).b = new bq(this, this.d);
                }
                return;
            }
            if (by3 == 1) {
                ((ah)this).b = new bk((ah)this, dj.a.a(67), 3, true, true);
                return;
            }
        } else if (by2 == 3 && by3 == 0) {
            by3 = this.d;
            w w2 = this;
            x x2 = r.a;
            x2.f(by3);
            x2.k();
            by3 = p.a[by3];
            if (by3 >= 0) {
                rpg.c.a(rpg.c.a, (int)by3);
            }
            p.c = true;
            w2.a(dj.a.a(68));
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean a(byte by2) {
        if (by2 == 4) {
            if (this.d != 6) {
                if (this.d % 3 == 2) {
                    this.d = (byte)(this.d - 2);
                    return true;
                }
                this.d = (byte)(this.d + 1);
                return true;
            }
        } else {
            if (this.d == 6) {
                this.d = (byte)3;
                return true;
            }
            if (this.d % 3 == 0) {
                this.d = (byte)(this.d + 2);
                return true;
            }
        }
        this.d = (byte)(this.d - 1);
        return true;
    }

    private boolean b(byte by2) {
        if (by2 == 4) {
            this.d = (byte)(this.d + this.f);
            if (this.d > 8) {
                this.d = 1;
            }
            if (this.d > 6) {
                this.d = (byte)6;
            }
        } else {
            this.d = this.d == 6 ? (byte)4 : (byte)(this.d - this.f);
            if (this.d == -2) {
                this.d = (byte)6;
            } else if (this.d < 0) {
                this.d = 1;
            }
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected final void a(cr cr2) {
        Object object;
        byte by2;
        block23: {
            if (!r.c) {
                r.c = true;
                rpg.d.a();
                this.h = true;
                r.a = rpg.c.a.a(13);
                j.a(cr2, rpg.g.a, rpg.g.b, 160, 174);
                cr2.a(15723216);
                cr2.d(rpg.g.a, rpg.g.b, 159, 173);
                cr2.a(3550755);
                if (r.a != null) {
                    dv.a(cr2, rpg.g.a + 10, rpg.g.b + 10, 150, 1, r.a);
                }
                return;
            }
            if (!p.c) break block23;
            p.b = new byte[7];
            for (int i2 = 0; i2 < 7; ++i2) {
                p.b[i2] = -1;
            }
            p.b = r.a().b();
            w w2 = this;
            p.a = new byte[7][];
            for (by2 = 0; by2 < 7; by2 = (byte)(by2 + 1)) {
                Object object2;
                block24: {
                    byte by3 = by2;
                    byte by4 = -1;
                    byte by5 = -1;
                    block0 : switch (by3) {
                        case 0: 
                        case 4: 
                        case 6: {
                            by4 = (byte)(by3 + 8);
                            if (!r.a()) break;
                            by4 = (byte)(by4 + 1);
                            break;
                        }
                        case 1: {
                            by4 = 10;
                            break;
                        }
                        case 2: {
                            by4 = 11;
                            break;
                        }
                        case 3: {
                            switch (r.b) {
                                case 0: {
                                    by4 = 0;
                                    by5 = 1;
                                    break block0;
                                }
                                case 1: 
                                case 5: {
                                    by4 = 4;
                                    break block0;
                                }
                                case 2: {
                                    by4 = 2;
                                    by5 = 3;
                                    break block0;
                                }
                                case 3: {
                                    by4 = 5;
                                    break block0;
                                }
                                case 4: {
                                    by4 = 6;
                                }
                            }
                            break;
                        }
                        case 5: {
                            switch (r.b) {
                                case 1: {
                                    by4 = 4;
                                    break block0;
                                }
                                case 3: {
                                    by4 = 5;
                                    break block0;
                                }
                                case 2: {
                                    by4 = 7;
                                    break block0;
                                }
                            }
                            object2 = null;
                            break block24;
                        }
                    }
                    object = r.a().a(by4, by5, true, r.a.b());
                    object2 = object;
                }
                if (object2 == null) continue;
                p.a[by2] = new byte[((dg)object).length];
                p.a[by2] = (byte[])object;
            }
            this.b();
            p.c = false;
        }
        by2 = this.d;
        object = p.a(by2);
        this.a(cr2, by2, (dg)object, false, this.d == 5);
    }

    protected final void b(cr cr2) {
        int n2 = this.d / this.f;
        int n3 = this.d % this.f;
        int n4 = this.f + 19 + n3 * 15;
        n3 = this.g + 24 + n2 * 15 + (n3 == 1 ? -7 : 0);
        if (n2 == 2) {
            n4 = this.f + 19 + 15;
            n3 = this.g + 24 + 30 - 7;
        }
        if (!this.h) {
            this.b(cr2, n4, n3, 13, 13);
        }
    }

    public static boolean a(dg dg2) {
        switch (dg2.g) {
            case 8: 
            case 12: 
            case 14: {
                return !r.a();
            }
            case 9: 
            case 13: 
            case 15: {
                return r.a();
            }
            case 10: 
            case 11: {
                return true;
            }
        }
        switch (r.b) {
            case 0: {
                if (dg2.g != 0 && dg2.g != 1) break;
                return true;
            }
            case 1: 
            case 5: {
                if (dg2.g != 4) break;
                return true;
            }
            case 2: {
                if (dg2.g != 2 && dg2.g != 3 && dg2.g != 7) break;
                return true;
            }
            case 3: {
                if (dg2.g != 5) break;
                return true;
            }
            case 4: {
                if (dg2.g != 6) break;
                return true;
            }
        }
        return false;
    }
}

