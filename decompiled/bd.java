/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;
import rpg.c;
import rpg.d;
import rpg.e;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class bd
extends aj {
    private static cw[] a = new cw[6];
    public static boolean a = false;
    private dg a;
    private byte[] a = null;
    private static int a;
    private static int b;
    private static int c;

    public bd(ah ah2) {
        super(ah2, (byte)6);
        a = false;
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            if (this.d == 6 && n2 == -7) {
                r.d = (byte)3;
                dj.a().c();
                if (n2 == -7) {
                    r.a.e();
                    dj.c = false;
                }
            } else if ((this.d == 7 || this.d == 8) && n2 == -7) {
                dj.c = false;
                ((ah)this).a.a((byte)-1, (byte)-1);
            }
            return true;
        }
        if (ah.g(n2, n3)) {
            if (((ah)this).b != null) {
                this.g();
            } else if (dj.c) {
                dj.c = false;
                r.a((byte)7, (byte)0);
            } else {
                ((ah)this).a.g();
            }
            a = 34;
            return true;
        }
        if (ah.f(n2, n3)) {
            bd bd2 = this;
            switch (bd2.d) {
                case 0: {
                    if (a) {
                        ((ah)bd2).b = new bi((ah)bd2, rpg.b.M, 1);
                        break;
                    }
                    ((ah)bd2).b = new eb((ah)bd2, bd2.a((byte)0, (byte)0), 3, true);
                    break;
                }
                case 1: {
                    if (dj.i) {
                        ((ah)bd2).b = new bi((ah)bd2, bd2.a((byte)1, (byte)1), 1);
                        break;
                    }
                    ((ah)bd2).b = new eb((ah)bd2, bd2.a((byte)0, (byte)1), 3, true);
                    break;
                }
                case 2: {
                    if (dj.j) {
                        ((ah)bd2).b = new bi((ah)bd2, bd2.a((byte)1, (byte)2), 1);
                        break;
                    }
                    ((ah)bd2).b = new eb((ah)bd2, bd2.a((byte)0, (byte)2), 3, true);
                    break;
                }
                case 3: {
                    if (dj.h) {
                        ((ah)bd2).b = new bi((ah)bd2, bd2.a((byte)1, (byte)3), 1);
                        break;
                    }
                    ((ah)bd2).b = new eb((ah)bd2, bd2.a((byte)0, (byte)3), 3, true);
                    break;
                }
                case 4: {
                    if (a) {
                        ((ah)bd2).b = new bi((ah)bd2, rpg.b.M, 1);
                        break;
                    }
                    if (r.a == null || r.a.b() >= 99) {
                        ((ah)bd2).b = new bi((ah)bd2, rpg.b.O, 1);
                        break;
                    }
                    ((ah)bd2).b = new eb((ah)bd2, bd2.a((byte)0, (byte)4), 3, true);
                    break;
                }
                case 5: {
                    if (a) {
                        ((ah)bd2).b = new bi((ah)bd2, rpg.b.M, 1);
                        break;
                    }
                    ((ah)bd2).b = new cc((ah)bd2, true);
                    break;
                }
                default: {
                    return false;
                }
            }
            bd2.d = true;
            return true;
        }
        if (n3 == 50 || n2 == 1) {
            if (this.d > 0) {
                this.d = (byte)(this.d - 1);
            }
            if (a >= 34 - (6 - b) * 42 && this.d <= 6 - b) {
                a = -this.d * 42 + 34;
            }
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            if (this.d < 5) {
                this.d = (byte)(this.d + 1);
            }
            if (a > 34 - (6 - b) * 42) {
                a = -this.d * 42 + 34;
            }
            return true;
        }
        return true;
    }

    private byte[] a(byte by2, byte by3) {
        if (by2 == 2) {
            return rpg.b.u;
        }
        if (by2 == 0) {
            byte[][] byArrayArray = new byte[4][];
            if (this.d == 7) {
                by3 = 0;
            } else if (this.d == 8) {
                by3 = (byte)5;
            }
            byArrayArray[0] = rpg.b.f[by3];
            Object object = rpg.e.a.a(by3 + 1);
            byArrayArray[1] = ("" + object[0]).getBytes();
            byArrayArray[2] = ("" + object[1]).getBytes();
            byArrayArray[3] = ("" + object[0] / object[1]).getBytes();
            if (this.d == 5 || this.d == 8) {
                object = new byte[rpg.b.d.length][];
                for (int i2 = 1; i2 < ((byte[])object).length; ++i2) {
                    object[i2] = (byte)rpg.b.d[i2];
                }
                object[0] = (byte)rpg.b.N;
                byArrayArray[0] = this.a.c;
                if (this.d == 8) {
                    byte[] byArray = bd.a((byte[][])object, byArrayArray);
                    return rpg.f.a(rpg.b.Q, byArray);
                }
                return bd.a((byte[][])object, byArrayArray);
            }
            if (this.d == 7) {
                return rpg.f.a(rpg.b.P, bd.a(rpg.b.d, byArrayArray));
            }
            return bd.a(rpg.b.d, byArrayArray);
        }
        if (by2 == 3) {
            if (this.d == 5) {
                return this.a;
            }
            if (this.d == 4) {
                byte[][] byArrayArray = new byte[1][];
                byte[][] byArrayArray2 = byArrayArray;
                byArrayArray[0] = ("" + (r.a.b() + 5 > 99 ? 99 : r.a.b() + 5)).getBytes();
                byte[] byArray = bd.a(rpg.b.i, byArrayArray2);
                return byArray;
            }
            if (this.d == 7) {
                by3 = 0;
            } else if (this.d == 8) {
                return this.a;
            }
            byte[][] byArrayArray = new byte[1][];
            byte[][] byArrayArray3 = byArrayArray;
            byArrayArray[0] = rpg.b.f[by3];
            byte[] byArray = bd.a(rpg.b.e, byArrayArray3);
            return byArray;
        }
        if (by2 == 1) {
            byte[][] byArrayArray = new byte[1][];
            byte[][] byArrayArray4 = byArrayArray;
            byArrayArray[0] = rpg.b.f[by3];
            return bd.a(rpg.b.b, byArrayArray4);
        }
        return null;
    }

    public final void a(byte[] byArray, int n2, dg dg2) {
        this.g();
        if (n2 == 0) {
            ((ah)this).b = new bi((ah)this, byArray, 1);
            return;
        }
        if (n2 == 1) {
            this.a = dg2;
            this.a = byArray;
            ((ah)this).b = new eb((ah)this, this.a((byte)0, (byte)5), 3, true);
        }
    }

    final void a(byte by2, byte by3) {
        block19: {
            block16: {
                block18: {
                    block17: {
                        this.g();
                        if (by2 != 3 || by3 != 0) break block16;
                        by2 = this.d;
                        if (this.d == 7) {
                            by2 = 0;
                        } else if (this.d == 8) {
                            by2 = (byte)5;
                        }
                        if (!rpg.e.a.a(by2 + 1)) break block17;
                        ((ah)this).b = new bi((ah)this, this.a((byte)3, this.d), 1);
                        switch (this.d) {
                            case 0: {
                                r.e += 20000;
                                r.l();
                                break block18;
                            }
                            case 1: {
                                dj.i = true;
                                rpg.d.a();
                                break block18;
                            }
                            case 2: {
                                dj.j = true;
                                rpg.d.a();
                                break block18;
                            }
                            case 3: {
                                dj.h = true;
                                rpg.d.a();
                                break block18;
                            }
                            case 5: {
                                r.a(this.a.g).a(this.a, 1);
                                r.l();
                                break block18;
                            }
                            case 4: {
                                r.a.j();
                                r.k();
                                break block18;
                            }
                            case 6: {
                                r.d = (byte)3;
                                dj.a().c();
                                r.a.f();
                                break block18;
                            }
                            case 7: {
                                r.e += 20000;
                                r.l();
                                break block18;
                            }
                            case 8: {
                                r.a(this.a.g).a(this.a, 1);
                                r.l();
                            }
                        }
                        break block19;
                    }
                    ((ah)this).b = new bi((ah)this, this.a((byte)2, this.d), 1);
                }
                return;
            }
            if (by2 == 1 && (this.d == 7 || this.d == 8)) {
                ((ah)this).a.a((byte)-2, (byte)-2);
                return;
            }
            if (this.d == 6 && by2 == 1) {
                ((ah)this).b = new eb((ah)this, this.a((byte)0, (byte)6), 3, true);
            }
        }
    }

    public final void b() {
        this.d = (byte)6;
        ((ah)this).b = new eb((ah)this, this.a((byte)0, (byte)6), 3, true);
    }

    public final void c() {
        this.d = (byte)7;
        ((ah)this).b = new eb((ah)this, this.a((byte)0, (byte)7), 3, true);
    }

    public final void a(byte[] byArray, dg dg2) {
        this.d = (byte)8;
        this.a = dg2;
        this.a = byArray;
        ((ah)this).b = new eb((ah)this, this.a((byte)0, (byte)8), 3, true);
    }

    protected final void a(cr cr2) {
        if (this.d < 6) {
            int n2;
            int n3;
            cr2.a(0);
            cr2.b(0, 0, rpg.a.a, rpg.a.b);
            cr2.b(255);
            cr2.a(0, 0, rpg.a.a, rpg.a.b);
            if (rpg.c.k != null) {
                n3 = rpg.c.k.a();
                c = rpg.c.k.b();
                for (n2 = 0; n2 < rpg.a.a; n2 += n3) {
                    cr2.a(rpg.c.k, n2, 1, 20);
                    cr2.a(rpg.c.k, n2, rpg.a.b - 1, 36);
                }
            }
            n3 = a;
            n2 = n3 + 21;
            int n4 = rpg.a.a - 48 - 8;
            cr2.b(0, 34, rpg.a.a, rpg.a.b - 68);
            for (int i2 = 0; i2 < 6; ++i2) {
                int n5;
                cr2.a(1639940);
                cr2.a(0, n3, rpg.a.a, 42);
                cr2.a(0xC9C191);
                cr2.a(1, n3, rpg.a.a - 2, 1);
                cr2.a(a[i2], 24, n2, 3);
                if (i2 == this.d) {
                    cr2.b(40);
                    cr2.a(0xFFFF00);
                    cr2.a(0, n3, rpg.a.a, 42);
                    cr2.b(255);
                }
                cr2.a(0xFFFFFF);
                dv.a(cr2, 48, n3 + 6, n4, rpg.b.g[i2], 0, 0, rpg.b.g[i2].length, 4);
                int n6 = i2;
                switch (n6) {
                    case 1: {
                        if (dj.i) {
                            n5 = 1;
                            break;
                        }
                        n5 = 0;
                        break;
                    }
                    case 2: {
                        if (dj.j) {
                            n5 = 1;
                            break;
                        }
                        n5 = 0;
                        break;
                    }
                    case 3: {
                        if (dj.h) {
                            n5 = 1;
                            break;
                        }
                        n5 = 0;
                        break;
                    }
                    case 5: {
                        n5 = 0;
                        break;
                    }
                    case 4: {
                        if (a || r.a != null && r.a.b() < 99) {
                            n5 = 0;
                            break;
                        }
                        n5 = 1;
                        break;
                    }
                    default: {
                        n5 = n6 = 0;
                    }
                }
                if (n5 == 0) {
                    cr2.a(65535);
                    Object object = rpg.e.a.a(i2 + 1);
                    object = "" + object[0];
                    byte[][] byArrayArray = new byte[1][];
                    byte[][] byArrayArray2 = byArrayArray;
                    byArrayArray[0] = object.getBytes();
                    object = bd.a(rpg.b.h, byArrayArray2);
                    dv.a(cr2, rpg.a.a - 2 - dv.b(object, 0, n4), n3 + 42 - dv.a - 4, n4, object, 0, 0, ((byte[])object).length, 4);
                } else {
                    cr2.a(0x888888);
                    dv.a(cr2, rpg.a.a - 2 - dv.b(rpg.b.w, 0, n4), n3 + 42 - dv.a - 4, n4, rpg.b.w, 0, 0, rpg.b.w.length, 4);
                }
                n3 += 42;
                n2 += 42;
            }
            if (b != 6) {
                cr2.a(16765952);
                if (a == 34) {
                    cr2.b(rpg.a.c - 8, rpg.a.b - c, 16, 8);
                    cr2.a(rpg.a.c - 8, rpg.a.b - c, rpg.a.c + 8, rpg.a.b - c, rpg.a.c, rpg.a.b - c + 8);
                } else if (a < 34 && a > 34 - (6 - b) * 42) {
                    cr2.b(rpg.a.c - 8, c - 8, 16, 8);
                    cr2.a(rpg.a.c - 8, c, rpg.a.c + 8, c, rpg.a.c, c - 8);
                    cr2.b(rpg.a.c - 8, rpg.a.b - c, 16, 8);
                    cr2.a(rpg.a.c - 8, rpg.a.b - c, rpg.a.c + 8, rpg.a.b - c, rpg.a.c, rpg.a.b - c + 8);
                } else if (a == 34 - (6 - b) * 42) {
                    cr2.b(rpg.a.c - 8, c - 8, 16, 8);
                    cr2.a(rpg.a.c - 8, c, rpg.a.c + 8, c, rpg.a.c, c - 8);
                }
                cr2.b(0, 0, rpg.a.a, rpg.a.b);
            }
        } else {
            rpg.a.a = true;
        }
        ah.a(cr2, 3);
    }

    public static byte[] a(byte[][] byArray, byte[][] byArray2) {
        if (byArray == null || byArray2 == null || byArray.length != byArray2.length + 1) {
            return null;
        }
        byte[] byArray3 = byArray[0];
        for (int i2 = 0; i2 < byArray2.length; ++i2) {
            if (byArray2[i2] != null) {
                byArray3 = rpg.f.a(byArray3, byArray2[i2]);
            }
            if (byArray[i2 + 1] == null) continue;
            byArray3 = rpg.f.a(byArray3, byArray[i2 + 1]);
        }
        return byArray3;
    }

    static {
        for (int i2 = 0; i2 < 6; ++i2) {
            bd.a[i2] = cw.a("/mtx" + i2 + ".png");
        }
        a = 34;
        b = (rpg.a.b - 68) / 42;
    }
}

