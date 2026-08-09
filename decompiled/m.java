/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import rpg.a;
import rpg.b;
import rpg.d;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class m
extends cb
implements b {
    private static m a;
    private static byte a;
    private static byte b;
    private static byte[] a;
    private static byte[] b;
    private static short a;
    private static short b;
    private static int a;
    private static x a;
    private static boolean a;
    private static int b;
    private static int c;
    private static byte c;
    private static int d;
    private static byte d;
    private static byte[] Z;
    private static byte[] aa;
    private static short c;
    private static short d;
    private static short e;
    private static short f;
    private static byte e;
    private static byte f;
    private static short g;
    private static short h;
    private static short i;
    private static br a;
    private static byte g;
    private static byte h;
    private static byte[] ab;
    private static boolean b;
    private static byte[] ac;
    private static j a;
    private static j b;
    private static byte[][] a;
    private static ah a;
    private static byte i;
    private static byte j;
    private static final byte[][] j;
    private static cw a;

    public static void a() {
        m.b();
        c = 0;
        a = r.a;
        if (r.a != null) {
            r.a.d = true;
        }
    }

    public static void b() {
        cb.e();
        m.h();
        d = -1;
        aa = null;
        a = null;
        g = (byte)-1;
        h = (byte)-1;
        m.ab[0] = -1;
        b = (byte)-1;
        b = false;
        d = (byte)-1;
        i = (byte)-1;
        a = null;
        a = null;
        a = null;
        ac = null;
        c = 255;
        b = 0;
        d = (byte)-1;
    }

    private static void a(byte[] byArray) {
        ac = byArray;
        b = false;
    }

    public static final void a(byte[] byArray, int n2) {
        a = null;
        System.gc();
        Runtime.getRuntime().gc();
        a = new m();
        a.a(byArray, n2);
    }

    protected final boolean a(byte by2, ak object) {
        switch (by2) {
            case 0: {
                ((ak)object).a(a, 2);
                r.b((int)a[0], a[1]);
                return true;
            }
            case 1: {
                ((ak)object).a(b, 2);
                g = b[0];
                g = (byte)(b[1] == 0 ? -1 : (int)g);
                return true;
            }
            case 6: {
                ((ak)object).a(a, 2);
                return a[0] == -1 || r.a((int)a[0]) == a[1];
            }
            case 2: {
                ((ak)object).a(a, 2);
                bp bp2 = r.a(a[0]);
                object = bp2.b();
                for (int i2 = 0; i2 < ((Object)object).length; ++i2) {
                    dg dg2;
                    if (object[i2] < 0 || (dg2 = bp2.a((int)object[i2])) == null || dg2.g != a[0] || dg2.h != a[1] || !dg2.c()) continue;
                    return true;
                }
                break;
            }
            case 3: {
                ((ak)object).a(a, 3);
                int n2 = r.a(a[0]).a(a[0], a[1]);
                by2 = (byte)n2;
                return n2 >= a[2];
            }
            case 4: {
                ((ak)object).a(a, 2);
                if (a[1] == 0) {
                    return a.b() <= a[0];
                }
                return a.b() >= a[0];
            }
            case 5: {
                by2 = (byte)((ak)object).a();
                ((ak)object).a(a, 1);
                if (a[0] == 0) {
                    return r.e <= by2;
                }
                return r.e >= by2;
            }
            case 7: {
                ((ak)object).a(a, 3);
                for (int i3 = 0; i3 < 3; ++i3) {
                    if (a[i3] == -1 || r.a(a[i3] & 0xFF)) continue;
                    return false;
                }
                return true;
            }
            case 8: {
                m.a[0] = ((ak)object).a();
                if (a[0] == 0) {
                    return r.h == 0;
                }
                return r.h > 0;
            }
            case 9: {
                m.a[0] = ((ak)object).a();
                return a[0] == a;
            }
            case 10: {
                ab.a = 0;
                return true;
            }
        }
        return false;
    }

    protected final boolean b(byte n2, ak object) {
        b = n2;
        ab ab2 = r.a;
        block0 : switch (n2) {
            case 0: {
                ((ak)object).a(b, 1);
                d = b[0];
                m.g();
                if (!b) break;
                r.c = r.a;
                r.d = r.b;
                break;
            }
            case 1: {
                ((ak)object).a(b, 2);
                d = (byte)-1;
                m.g();
                m.a((int)b[0], (int)b[1]);
                d = (byte)-2;
                break;
            }
            case 2: {
                ((ak)object).a(b, 2);
                d = (byte)-1;
                m.g();
                m.a((int)b[0], (int)b[1]);
                d = (byte)-2;
                break;
            }
            case 3: {
                ((ak)object).a(b, 2);
                n2 = j[r.b][b[0] - 1];
                a.h((byte)n2);
                a = x.a(n2) * b[1];
                break;
            }
            case 4: {
                ((ak)object).a(b, 1);
                a.a((byte)1);
                a.i(b[0]);
                break;
            }
            case 5: {
                ((ak)object).a(b, 1);
                ab.a(b[0]);
                break;
            }
            case 6: {
                ((ak)object).a(b, 2);
                m.a(a, (short)(b[0] << 4), (short)(b[1] << 4));
                break;
            }
            case 7: {
                ((ak)object).a(b, 1);
                if (b) {
                    ((c)m.a).a = (short)(((c)m.a).a + (rpg.b.S[m.a.q] * b[0] << 4));
                    ((c)m.a).b = (short)(((c)m.a).b + (rpg.b.T[m.a.q] * b[0] << 4));
                    m.a(a, ((c)m.a).a, ((c)m.a).b);
                    break;
                }
                a = (short)(((c)m.a).a + (rpg.b.S[m.a.q] * b[0] << 4));
                b = (short)(((c)m.a).b + (rpg.b.T[m.a.q] * b[0] << 4));
                a.a((byte)2);
                break;
            }
            case 9: {
                ((ak)object).a(b, 1);
                boolean bl2 = b[0] == 1;
                object = a;
                ((c)a).c = bl2;
                return true;
            }
            case 10: {
                ((ak)object).a(b, 1);
                a.k(b[0]);
                return true;
            }
            case 8: {
                a.a((byte)0, a.e((byte)0));
                a.a((byte)1, a.e((byte)1));
                a.a((byte)3, a.e((byte)3));
                break;
            }
            case 11: {
                n2 = ((ak)object).a();
                a.c(0 - n2);
                break;
            }
            case 12: {
                int n3;
                ((ak)object).a(b, 9);
                int n4 = n3 = r.h > 2 ? 2 : (int)r.h;
                if (b[n3 * 3] != -1 && r.a(b[n3 * 3]).a(b[n3 * 3], b[n3 * 3 + 1]) < b[n3 * 3 + 2]) {
                    m.a(rpg.c.g.a(54));
                    return false;
                }
                if (b[n3 * 3] == -1) break;
                r.a(b[n3 * 3]).b(b[n3 * 3], b[n3 * 3 + 1], b[n3 * 3 + 2]);
                break;
            }
            case 13: {
                n2 = ((ak)object).a();
                r.e(0 - n2);
                break;
            }
            case 14: {
                ((ak)object).a(b, 1);
                a = b[0];
                break;
            }
            case 15: {
                n2 = ((ak)object).a();
                a.c(n2);
                break;
            }
            case 16: {
                int n5;
                ((ak)object).a(b, 9);
                int n6 = n5 = r.h > 2 ? 2 : (int)r.h;
                if (b[n5 * 3] == -1) break;
                dg dg2 = dg.a(b[n5 * 3], b[n5 * 3 + 1]);
                int n7 = r.a(b[n5 * 3]).a(dg2, (int)b[n5 * 3 + 2]);
                if (n7 >= b[n5 * 3 + 2]) break;
                if (n7 > 0) {
                    r.a(b[n5 * 3]).b(dg2.g, dg2.h, n7);
                }
                --n5;
                while (n5 >= 0) {
                    if (b[n5 * 3 + 1] > 0) {
                        r.a(b[n5 * 3]).b(dg2.g, dg2.h, b[n5 * 3 + 1]);
                    }
                    --n5;
                }
                m.a(rpg.c.g.a(53));
                return false;
            }
            case 17: {
                n2 = 0;
                for (int i2 = 0; i2 < 3; ++i2) {
                    if (i2 == (r.h > 2 ? 2 : (int)r.h)) {
                        n2 = ((ak)object).a();
                        continue;
                    }
                    ((ak)object).a();
                }
                r.e(n2);
                break;
            }
            case 18: {
                byte by2 = (byte)rpg.f.a(0, 18);
                n2 = rpg.f.a(0, 183);
                int n8 = n2 = n2 < 0 ? n2 + 256 : n2;
                if (by2 <= 15) {
                    if (n2 > 28) {
                        by2 = 20;
                        n2 = 6;
                    } else {
                        object = dg.a(by2, (byte)n2);
                        if (object instanceof bs) {
                            object = (bs)object;
                            if (((bs)object).a >= a.b() + 10) {
                                by2 = 20;
                                n2 = 6;
                            }
                        }
                    }
                } else if (by2 == 16) {
                    n2 = (byte)(n2 / 16);
                } else if (by2 == 17) {
                    n2 = (byte)(n2 / 12);
                } else if (by2 == 18) {
                    n2 = (byte)(n2 / 4);
                }
                object = dg.a(by2, (byte)n2);
                if (r.a(((dg)object).g).a((dg)object, 1) > 0) break;
                m.a(rpg.c.g.a(53));
                return false;
            }
            case 19: {
                ((ak)object).a(b, 1);
                a.d((int)b[0]);
                break;
            }
            case 20: {
                n2 = 0;
                for (int i3 = 0; i3 < 3; ++i3) {
                    if (i3 == (r.h > 2 ? 2 : (int)r.h)) {
                        n2 = ((ak)object).b();
                        continue;
                    }
                    ((ak)object).b();
                }
                a.f(n2);
                break;
            }
            case 21: {
                ((ak)object).a(b, 6);
                rpg.c.a().a(b);
                break;
            }
            case 22: {
                bh.a().g();
                break;
            }
            case 23: {
                ((ak)object).a(ab, 4);
                int n9 = ab[0] < 0 ? 256 + ab[0] : ab[0];
                if (n9 == r.a.b) {
                    m.a(a, (short)(ab[1] << 4), (short)(ab[2] << 4));
                    h = 0;
                    m.ab[0] = -1;
                }
                return false;
            }
            case 24: {
                ((ak)object).a(b, 3);
                if (b[0] >= 0) {
                    br br2 = r.a.a[b[0]];
                    br2.d(b[1]);
                    a = br2.a((int)b[1]) * b[2];
                    break;
                }
                i = b[1];
                j = 0;
                break;
            }
            case 25: {
                ((ak)object).a(b, 2);
                ab2.b(b[0], b[1]);
                break;
            }
            case 26: {
                ((ak)object).a(b, 2);
                m.a(b[0], b[1], (byte)1);
                break;
            }
            case 27: {
                ((ak)object).a(b, 2);
                ab2.a(b[1], b[0]);
                return true;
            }
            case 28: {
                ((ak)object).a(b, 3);
                br br3 = r.a.a[b[0]];
                m.a(br3, (short)(b[1] << 4), (short)(b[2] << 4));
                break;
            }
            case 30: {
                ((ak)object).a(b, 2);
                this.a(b[0], b[1]);
                break;
            }
            case 31: {
                ((ak)object).a(b, 4);
                n2 = 3;
                while (true) {
                    int n10 = n2;
                    n2 = n2 - 1;
                    if (n10 <= 0) break block0;
                    this.a(b[n2], b[3]);
                }
            }
            case 32: {
                ((ak)object).a(b, 2);
                br br4 = ab2.a[b[0]];
                if (b[1] == 0) {
                    boolean bl3 = false;
                    object = br4;
                    ((c)br4).c = bl3;
                    br4.b_();
                } else {
                    boolean bl4 = true;
                    object = br4;
                    ((c)br4).c = bl4;
                    br4.a(((c)br4).a, ((c)br4).b);
                    br4.a_();
                }
                return true;
            }
            case 33: {
                ((ak)object).a(b, 2);
                br br5 = ab2.a[b[0]];
                br5.k(b[1]);
                return true;
            }
            case 29: {
                ((ak)object).a(b, 2);
                br br6 = ab2.a[b[0]];
                br6.b(b[1] == 0 ? -1 : 0);
                return true;
            }
            case 34: {
                break;
            }
            case 35: {
                ((ak)object).a(b, 2);
                f f2 = b[0] == 0 ? ab2.a[b[1]] : (b[0] == 1 ? ab2.b[b[1]] : ab2.c[b[1]]);
                boolean bl5 = false;
                object = f2;
                f2.c = bl5;
                break;
            }
            case 36: {
                break;
            }
            case 37: {
                ((ak)object).a(b, 3);
                f f3 = null;
                if (b[0] == 0) {
                    f3 = ab2.a[b[1]];
                } else if (b[0] == 1) {
                    f3 = ab2.b[b[1]];
                } else if (b[1] < ab2.c.length) {
                    f3 = ab2.c[b[1]];
                }
                if (f3 != null) {
                    boolean bl6 = b[2] == 1;
                    object = f3;
                    f3.c = bl6;
                }
                return true;
            }
            case 38: {
                m.h();
                a = new e(null);
                break;
            }
            case 39: {
                m.h();
                a = new dd();
                break;
            }
            case 40: {
                m.h();
                a = new cc(null);
                break;
            }
            case 41: {
                m.h();
                a = new da(null);
                break;
            }
            case 42: {
                ((ak)object).a(b, 1);
                if (b) break;
                i = 1;
                byte by3 = b[0];
                object = this;
                ((m)object).a(by3, (byte)-1, (byte)0);
                break;
            }
            case 43: {
                ((ak)object).a(b, 3);
                if (b) break;
                i = 0;
                this.a(b[2], b[0], b[1]);
                break;
            }
            case 44: {
                ((ak)object).a(b, 1);
                if (b) break;
                i = 0;
                byte by4 = b[0];
                object = this;
                ((m)object).a(by4, (byte)-1, (byte)0);
                break;
            }
            case 45: {
                ((ak)object).a(b, 1);
                r.a.e = b[0] == 1;
                break;
            }
            case 46: {
                ((ak)object).a(b, 2);
                if (b) {
                    d = -1;
                    c = b[0] == 1 ? 255 : 0;
                    break;
                }
                d = 0;
                a = b[0] == 1;
                c = b[1];
                break;
            }
            case 47: {
                ((ak)object).a(b, 1);
                if (!b) {
                    d = 0;
                }
                switch (b[0]) {
                    case 0: {
                        b = 0;
                        c = 255;
                        break;
                    }
                    case 1: {
                        b = 0xFFFFFF;
                        c = 0;
                        break;
                    }
                    case 2: {
                        b = 0;
                        c = 0;
                        break;
                    }
                    case 3: {
                        b = 0;
                        c = 255;
                        break;
                    }
                    case 4: {
                        b = 0;
                        c = 255;
                        if (b) {
                            d = -1;
                            break;
                        }
                        for (n2 = 0; n2 < Z.length; n2 = (int)((byte)(n2 + 1))) {
                            m.Z[n2] = (byte)rpg.f.a(-5, 5);
                        }
                        break;
                    }
                }
                break;
            }
            case 48: {
                ((ak)object).a(b, 2);
                int n11 = b = b[1] == 0 ? 0 : 0xFFFFFF;
                if (b) {
                    d = -1;
                    c = b[0] == 1 ? 255 : 0;
                    break;
                }
                a = b[0] == 1;
                d = 0;
                break;
            }
            case 49: {
                break;
            }
            case 50: {
                ((ak)object).a(b, 2);
                if (b) break;
                bo.c();
                bo.a(b[0]);
                break;
            }
            case 51: {
                br br7;
                if (ab2.a != null && (br7 = ab2.a()) != null) {
                    m.a(br7, ((c)m.a).a, ((c)m.a).b);
                    br7.b(0);
                    break;
                }
                return true;
            }
            case 52: {
                ((ak)object).a(b, 1);
                br br8 = ab2.a();
                if (br8 != null) {
                    boolean bl7 = b[0] == 1;
                    object = br8;
                    ((c)br8).c = bl7;
                }
                return true;
            }
            case 53: {
                ((ak)object).a(b, 2);
                n2 = b[0];
                int n12 = n2 = n2 < 0 ? n2 + 256 : n2;
                if (b[1] == 0) {
                    r.d(n2);
                } else {
                    r.c(n2);
                }
                cb.d();
                return true;
            }
            case 54: {
                ((ak)object).a(b, 2);
                r.a((int)b[0], b[1]);
                b = false;
                cb.d();
                return true;
            }
            case 55: {
                ((ak)object).a(b, 3);
                r.a.a(b[0], b[1], b[2]);
                break;
            }
            case 56: {
                ((ak)object).a(b, 3);
                if (b[2] == 0) {
                    int n13 = b[1] * ab.c + b[0];
                    r.a.a[n13] = (byte)(r.a.a[n13] | 0xC0);
                    break;
                }
                int n14 = b[1] * ab.c + b[0];
                r.a.a[n14] = (byte)(r.a.a[n14] & 0xFFFFFF3F);
                break;
            }
            case 57: {
                ((ak)object).a(b, 1);
                r.a.d = b[0] == 1;
                break;
            }
            case 58: {
                ((ak)object).a(b, 4);
                r.a((int)b[1], (int)b[2], (int)b[0]);
            }
        }
        return b;
    }

    private final void a(byte by2, byte by3) {
        br br2 = r.a.a[by2];
        if (b) {
            ((c)br2).a = (short)(((c)br2).a + (rpg.b.S[br2.q] * by3 << 4));
            ((c)br2).b = (short)(((c)br2).b + (rpg.b.T[br2.q] * by3 << 4));
            m.a(br2, ((c)br2).a, ((c)br2).b);
            return;
        }
        a = (short)(((c)br2).a + (rpg.b.S[br2.q] * by3 << 4));
        b = (short)(((c)br2).b + (rpg.b.T[br2.q] * by3 << 4));
        br2.c = (byte)(by3 << 1);
        m.a(by2, br2.q, (byte)2);
    }

    protected final void a(byte n2, byte[] byArray) {
        int n3 = n2 = n2 < 0 ? n2 + 256 : n2;
        if (byArray.length > 0) {
            b = false;
            a = new byte[byArray.length][];
            int n4 = byArray[0] < 0 ? 256 + byArray[0] : byArray[0];
            byte[] byArray2 = cb.a(n4);
            boolean bl2 = false;
            if (byArray2.length != rpg.b.c.length) {
                bl2 = true;
            } else {
                for (n4 = rpg.b.c.length - 1; n4 >= 0; --n4) {
                    if (byArray2[n4] == rpg.b.c[n4]) continue;
                    bl2 = true;
                    break;
                }
            }
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                n4 = byArray[i2] < 0 ? 256 + byArray[i2] : byArray[i2];
                m.a[i2] = cb.a(n4);
            }
            a = new bk(null, cb.a(n2), a, bl2);
            if (n2 == 17 && byArray[0] == 18 && byArray[1] == 24) {
                m.a.b = 1;
            }
        }
    }

    private static void f() {
        int n2 = rpg.a.a;
        if (a == null) {
            a = cw.a(n2, 37);
        }
        cr cr2 = a.a();
        cr2.b(0, 0, n2, 37);
        cr2.a(0);
        if (i == 0) {
            cr2.a(3, 3, n2 - 6, 31);
            cr2.a(0x3F3F3F);
            cr2.d(0, 0, n2 - 1, 36);
            cr2.d(2, 2, n2 - 5, 32);
            cr2.a(10452799);
            cr2.d(1, 1, n2 - 3, 34);
            return;
        }
        cr2.a(0, 0, n2, 37);
    }

    private void a(int n2, byte by2, byte by3) {
        m.f();
        e = by2;
        f = by3;
        aa = cb.a(n2 < 0 ? n2 + 256 : n2);
        c = 0;
        e = 0;
        d = 0;
        f = (short)aa.length;
        g = (short)-1;
        h = 0;
    }

    private static boolean h() {
        short s2;
        if (a == null) {
            return false;
        }
        cr cr2 = a.a();
        int n2 = 255;
        cr cr3 = cr2;
        cr3.b(n2);
        if (e == d) {
            c = (short)(c + e);
            d = 0;
            g = (short)(g + 1);
        }
        if (g >= h + 1) {
            return false;
        }
        if (d == 0) {
            d = (short)dv.a(aa, c, rpg.a.a - 20, 2);
            e = 0;
        }
        if ((e = (short)dv.a(aa, c, s2 = e)) > d) {
            e = (short)(e - (e - d));
        }
        cr2.b(0, 0, a.a(), a.b());
        cr2.a(0xFFFFFF);
        if (i == 0) {
            dv.a(cr2, 12, 7 + (g - h) * 14, rpg.a.a - 20, 1, aa, (int)c, (int)s2, (int)e);
        } else {
            dv.a(cr2, rpg.a.a >> 1, 7 + (g - h) * 14, rpg.a.a - 20, aa, c, (int)s2, (int)e, 1);
        }
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public static final boolean a() {
        block22: {
            block20: {
                block21: {
                    if (!cb.f()) {
                        r.c((byte)3);
                        return false;
                    }
                    if (m.a != null || m.ac != null) {
                        return true;
                    }
                    r.c((byte)4);
                    if (m.b) break block20;
                    if (m.a == null) break block21;
                    v0 = true;
                    break block22;
                }
                switch (m.b) {
                    case 0: {
                        ** GOTO lbl79
                    }
                    case 4: 
                    case 5: 
                    case 6: {
                        ** GOTO lbl79
                    }
                    case 7: {
                        if (m.a.a == m.a && m.a.b == m.b) ** GOTO lbl22
                        m.a.p = (byte)2;
                        v0 = true;
                        break block22;
lbl22:
                        // 1 sources

                        m.a.a((byte)1);
                        ** GOTO lbl79
                    }
                    case 42: 
                    case 43: 
                    case 44: {
                        if (m.aa == null) ** GOTO lbl79
                        m.h();
                        v0 = true;
                        break block22;
                    }
                    case 46: {
                        if (m.d < 0 || m.d >= 16) ** GOTO lbl35
                        ++m.d;
                        v0 = true;
                        break block22;
lbl35:
                        // 1 sources

                        m.c = (byte)-1;
                        ** GOTO lbl79
                    }
                    case 47: {
                        if (m.b[0] != 3) ** GOTO lbl45
                        if (m.d < 0 || m.d >= 8) ** GOTO lbl43
                        m.c = ++m.d % 2 == 0 ? 255 : 0;
                        v0 = true;
                        break block22;
lbl43:
                        // 1 sources

                        m.c = 255;
                        ** GOTO lbl79
lbl45:
                        // 1 sources

                        if (m.b[0] != 4) ** GOTO lbl79
                        if (m.d < 0 || m.d >= m.Z.length >> 1) ** GOTO lbl52
                        r.a.b = m.Z[m.d << 1];
                        r.a.c = m.Z[(m.d << 1) + 1];
                        ++m.d;
                        v0 = true;
                        break block22;
lbl52:
                        // 1 sources

                        r.a.b = 0;
                        r.a.c = 0;
                        m.c = 255;
                        ** GOTO lbl79
                    }
                    case 48: {
                        if (m.d < 0 || m.d >= 16) ** GOTO lbl79
                        m.c = m.a != false ? (m.d << 4) - 1 : (16 - ++m.d << 4) - 1;
                        if (m.c < 0) {
                            m.c = 0;
                        }
                        v0 = true;
                        break block22;
                    }
                    case 30: {
                        var0 = r.a.a[m.b[0]];
                        if (var0.a == m.a && var0.b == m.b) ** GOTO lbl69
                        var0.p = (byte)2;
                        v0 = true;
                        break block22;
lbl69:
                        // 1 sources

                        var0.a((byte)1);
                        ** GOTO lbl79
                    }
                    case 24: {
                        if (m.a == 1 && m.b[2] > 0) {
                            var0 = r.a.a[m.b[0]];
                            var0.a((byte)1);
                        }
                        ** GOTO lbl79
                    }
                    case 3: {
                        if (m.a == 1 && m.b[1] > 0) {
                            m.a.a((byte)1);
                        }
                    }
lbl79:
                    // 15 sources

                    default: {
                        if (m.a <= 0 || --m.a == 0) break;
                        v0 = true;
                        break block22;
                    }
                }
            }
            m.b = (byte)-1;
            v0 = false;
        }
        if (!v0 && !m.a.g()) {
            m.b = false;
            if (m.h >= 0) {
                rpg.c.f = null;
                var0_1 = m.h;
                m.h = (byte)-1;
                m.a((byte)-1, var0_1);
                bh.c = true;
                return true;
            }
            m.b();
            r.c((byte)3);
            m.a.t();
        }
        if (m.ab[0] != -1) {
            r.b(m.ab[0], m.ab[1], m.ab[2], m.ab[3]);
            m.a();
            cb.c();
            return false;
        }
        r.a.d();
        m.a.d();
        bh.c = true;
        return true;
    }

    public static void a(cr cr2) {
        int n2;
        int n3;
        if (b) {
            return;
        }
        if (a != null) {
            bh.a().f();
            a.c(cr2);
            return;
        }
        if (d != -2) {
            m.g();
        }
        r.a(false, false);
        if (c >= 0) {
            int n4 = 0;
            int n5 = 0;
            n3 = 0;
            n2 = 0;
            int n6 = rpg.a.b - 33;
            int n7 = n6 / 16;
            int n8 = rpg.a.a;
            int n9 = n8 / 16;
            switch (c) {
                case 0: {
                    n3 = rpg.a.a;
                    if (b[0] == 0) {
                        n2 = d * n7;
                        break;
                    }
                    n5 = d * n7;
                    n2 = rpg.a.b;
                    break;
                }
                case 1: {
                    n3 = rpg.a.a;
                    if (b[0] == 0) {
                        n2 = rpg.a.b;
                        n5 = n6 - d * n7;
                        break;
                    }
                    n2 = n6 - d * n7;
                    break;
                }
                case 2: {
                    n2 = rpg.a.b;
                    if (b[0] == 0) {
                        n3 = d * n9;
                        break;
                    }
                    n4 = d * n9;
                    n3 = rpg.a.a;
                    break;
                }
                case 3: {
                    n2 = rpg.a.b;
                    if (b[0] == 0) {
                        n3 = rpg.a.a;
                        n4 = n8 - d * n9;
                        break;
                    }
                    n3 = n8 - d * n9;
                }
            }
            m.b(cr2);
            cr2.a(n4, n5, n3, n2);
        }
        cr cr3 = cr2;
        if (c == 0) {
            cr3.a(b);
            cr3.b(0, 0, bh.g, rpg.a.b);
            cr3.a(0, 0, bh.g, rpg.a.b);
        } else {
            n3 = 255;
            cr cr4 = cr3;
            cr4.b(n3);
            m.b(cr3);
            if (i < 0) {
                r.a.c();
            }
        }
        if (c > 0) {
            cr2.a(0);
            cr2.b(0, 0, rpg.a.a, rpg.a.b);
            if (i < 0) {
                cr2.a(0, rpg.a.b - 37, rpg.a.a, 37);
                m.b(cr2);
            } else {
                cr2.a(0, 0, rpg.a.a, rpg.a.b);
                if (j >= rpg.c.a.a(i)) {
                    j = 0;
                    if (i == 1 || i == 3) {
                        i = (byte)(i + 1);
                    }
                }
                rpg.c.a.a(i, (byte)0, j, rpg.a.a >> 1, rpg.a.b + 50 >> 1);
                j = (byte)(j + 1);
            }
        }
        if (aa != null) {
            cr3 = cr2;
            int n10 = rpg.a.c - (rpg.a.a >> 1);
            n3 = i == 0 ? (short)(rpg.a.b - 37) : (short)(rpg.a.b - 33 - 37 >> 1);
            if (i > 0) {
                cr3.a(0);
                cr3.b(0, 0, rpg.a.a, rpg.a.b);
                cr3.a(0, rpg.a.b - 37, rpg.a.a, 37);
            }
            cr3.b(0, 0, rpg.a.a, rpg.a.b);
            cr3.a(a, n10, n3, 20);
            n2 = rpg.c.a(e);
            if (n2 >= 0) {
                if (f != 0) {
                    cr3.a(rpg.c.f[n2], n10 + a.a(), n3, 40);
                } else {
                    cr3.a(rpg.c.f[n2], n10, n3, 36);
                }
            }
            if (!r.d) {
                r.d = true;
                rpg.d.a();
                r.f = true;
                r.a = rpg.c.a.a(14);
            }
        }
        if (a != null) {
            if (b != null) {
                int n11 = cr2.a();
                int n12 = cr2.b();
                n3 = cr2.c();
                n2 = cr2.d();
                cr2.b(0, 0, rpg.a.a, rpg.a.b);
                b.a(cr2);
                cr2.b(n11, n12, n3, n2);
            } else if (a != null) {
                a.a(cr2);
            }
        }
        if (!b && b == null && a == null) {
            cr2.b(0, 0, rpg.a.a, rpg.a.b);
            cr2.a(rpg.c.o, rpg.a.a - 1, rpg.a.b - 1, 40);
        }
        if (ac != null) {
            bm.a(cr2, rpg.a.a - 160 >> 1, rpg.a.b - 174 - 40 >> 1, ac, 2);
        }
        cr cr5 = cr2;
        if (c > 0 && c < 255) {
            n3 = 255 - c;
            cr cr6 = cr5;
            cr6.b(n3);
            cr5.a(b);
            cr5.b(0, 0, bh.g, rpg.a.b);
            cr5.a(0, 0, bh.g, rpg.a.b);
        }
    }

    public static final boolean a(x x2) {
        if (((c)x2).a || ((c)x2).b) {
            return false;
        }
        byte by2 = r.a.a((int)((c)x2).c, (int)((c)x2).d);
        return m.a((byte)0, by2);
    }

    static final boolean b() {
        if (((c)m.a).a || ((c)m.a).b) {
            return false;
        }
        byte by2 = r.a.a(((c)m.a).c + rpg.b.S[m.a.q], ((c)m.a).d + rpg.b.T[m.a.q]);
        return m.a((byte)3, by2);
    }

    public static boolean c() {
        if (r.a(253) || r.a(254)) {
            m.a((byte)-1, (byte)3);
            return false;
        }
        if (a.a()) {
            r.c((byte)4);
            a = new bi(null, rpg.b.d, '\u0000');
            return false;
        }
        return true;
    }

    public static boolean a(int n2, int n3) {
        if (ac != null) {
            if (n2 == 8 || n3 == 53) {
                ac = null;
                m.b();
                m.a();
            }
            return true;
        }
        if (a != null) {
            return a.a(n2, n3);
        }
        if (b != null) {
            if (n2 == -6) {
                if (rpg.e.a.a(0)) {
                    j.c = (byte)(j.c + 1);
                    Object object = j.a();
                    if (object == null) {
                        j.a = false;
                        a = new bi(null, rpg.b.v, 1);
                        ((j)new bi(null, rpg.b.v, 1)).b = (byte)4;
                        b = null;
                        int[][] nArrayArray = new int[][]{{-1, -1, 1000}, {20, 2, 10}, {20, 3, 10}, {20, 1, 5}};
                        object = nArrayArray;
                        m.a(nArrayArray);
                    } else {
                        b = new eb(null, (byte[])object, 1, true);
                        ((j)new eb(null, (byte[])object, 1, true)).b = (byte)2;
                    }
                    rpg.d.a();
                } else {
                    a = new bi(null, rpg.b.u, 1);
                    ((j)new bi(null, rpg.b.u, 1)).b = (byte)3;
                    b = null;
                }
                return true;
            }
            if (n2 == -7) {
                cb.a(1);
                b = null;
                a = null;
                return true;
            }
        } else if (a != null) {
            if (n2 == 8 || n3 == 53 || n2 == -6) {
                if (a instanceof bk) {
                    if (j.a && m.a.b == 1 && a.a() == 0) {
                        byte[][] byArrayArray = new byte[2][];
                        byte[][] byArrayArray2 = byArrayArray;
                        byArrayArray[0] = rpg.b.m;
                        byArrayArray2[1] = rpg.b.n;
                        b = new eb(null, j.a(), 1, true);
                        ((j)new eb(null, j.a(), 1, true)).b = (byte)2;
                        return true;
                    }
                    if (m.a.b == 2) {
                        if (a.a() == 0) {
                            if (rpg.e.a.a(0)) {
                                j.c = (byte)(j.c + 1);
                                byte[] byArray = j.a();
                                if (byArray == null) {
                                    j.a = false;
                                    a = new bi(null, rpg.b.v, 1);
                                    ((j)new bi(null, rpg.b.v, 1)).b = (byte)4;
                                } else {
                                    byte[][] byArrayArray = new byte[2][];
                                    byte[][] byArrayArray3 = byArrayArray;
                                    byArrayArray[0] = rpg.b.m;
                                    byArrayArray3[1] = rpg.b.n;
                                    a = new bk(null, byArray, byArrayArray3, true);
                                    ((j)new bk(null, byArray, byArrayArray3, true)).b = (byte)2;
                                }
                                rpg.d.a();
                            } else {
                                a = new bi(null, rpg.b.u, 1);
                                ((j)new bi(null, rpg.b.u, 1)).b = (byte)3;
                            }
                            return true;
                        }
                        cb.a(a.a());
                    } else {
                        cb.a(a.a());
                    }
                } else if (m.a.b == 3) {
                    m.a.b = 0;
                    cb.a(1);
                } else if (m.a.b == 4) {
                    m.a.b = 0;
                    cb.a(0);
                } else {
                    if (a.a() == 0) {
                        a.l(50);
                    }
                    m.b();
                    r.c((byte)3);
                    a.t();
                }
                a = null;
                return true;
            }
            return a.a(n2, n3);
        }
        if (b) {
            return true;
        }
        if (n3 == -7) {
            c = 255;
            n3 = 255;
            Object object = cr.a();
            ((cr)object).b(n3);
            if (b != null || a != null) {
                return true;
            }
            if (r.d) {
                b = true;
            }
            object = a;
            switch (b) {
                case 7: {
                    m.a(a, a, b);
                    a.a((byte)1);
                    break;
                }
                case 30: {
                    object = r.a.a[b[0]];
                    m.a((do)object, a, b);
                    ((br)object).a((byte)1);
                }
            }
            b = (byte)-1;
            aa = null;
            return true;
        }
        switch (b) {
            case 42: 
            case 43: 
            case 44: {
                if (!ah.f(n2, n3)) break;
                if (e < d) {
                    while (m.h()) {
                    }
                    break;
                }
                if (c >= f) {
                    aa = null;
                    break;
                }
                if (g < h + 1) break;
                h = (short)(h + 1);
                m.f();
            }
        }
        return true;
    }

    public static final boolean d() {
        x x2 = r.a;
        if (((c)x2).a || ((c)x2).b) {
            return false;
        }
        byte by2 = r.a.a((int)((c)x2).c, (int)((c)x2).d);
        if (m.a((byte)1, by2)) {
            return true;
        }
        by2 = r.a.a(((c)x2).c + rpg.b.S[x2.q], ((c)x2).d + rpg.b.T[x2.q]);
        if (m.a((byte)2, by2)) {
            return true;
        }
        if (ab.c) {
            return false;
        }
        boolean bl2 = true;
        byte by3 = x2.q;
        c c2 = x2;
        if ((c2 = c2.a((byte)0, by3, (byte)1)) != null && c2 instanceof br) {
            by2 = ((br)c2).a();
        }
        if (by2 > 0 && by2 <= 127 && m.a((byte)2, by2)) {
            if (c2 != null) {
                by2 = rpg.b.Y[m.a.q];
                a = (br)c2;
                a.b(by2);
            }
            return true;
        }
        return false;
    }

    public static final boolean a(byte by2) {
        b = false;
        return m.a((byte)-1, by2);
    }

    public static final boolean e() {
        m.a();
        if (r.a.b == 60 || r.a.b == 61) {
            rpg.c.a(r.a.b - 60);
            i = 0;
            j = 0;
        }
        g = (byte)-1;
        boolean bl2 = m.a((byte)-1, (byte)0);
        if (g >= 0 || r.a.a >= 0) {
            bo.c();
            bo.a(g >= 0 ? g : r.a.a, true);
        }
        g = (byte)-1;
        bo.a = 0L;
        return bl2;
    }

    private static final boolean a(byte by2, byte by3) {
        if (by3 < 0) {
            return false;
        }
        a = by2;
        if (a.a(by3)) {
            a.t();
            m.a();
            return true;
        }
        return false;
    }

    private static void a(byte by2, byte by3, byte by4) {
        br br2 = r.a.a[by2];
        if (by3 > 0) {
            br2.i(by3);
        }
        if (by4 != 0) {
            br2.a(by4);
        }
    }

    private static void a(int n2, int n3) {
        r.a = -(n2 << 4) + rpg.a.c;
        r.b = -(n3 << 4) + rpg.a.d;
    }

    private static void g() {
        if (d == -1) {
            r.c();
            return;
        }
        br br2 = r.a.a[d];
        r.a = bh.i - ((c)br2).a;
        r.b = bh.j - ((c)br2).b;
    }

    private static void a(do do_, short s2, short s3) {
        do_.b_();
        do_.a((byte)1);
        do_.a(s2, s3);
        do_.a();
        do_.a_();
        r.a.c(do_);
    }

    private static void h() {
        b = false;
        c = 255;
        b = 0;
    }

    private static void b(cr cr2) {
        cr2.b(0, 0, rpg.a.a, rpg.a.b - 37);
    }

    private static void a(int[][] nArray) {
        if (nArray == null || nArray.length <= 0) {
            return;
        }
        try {
            byte[] byArray;
            int n2;
            int n3;
            Object object = rpg.d.b();
            if (object == null) {
                object = new byte[6];
                rpg.f.a(0, (byte[])object, 0);
                object[4] = 84;
                object[5] = 0;
                rpg.d.b((byte[])object);
            }
            int n4 = 0;
            int n5 = rpg.f.a((byte[])object, 0);
            n4 += 4;
            ++n4;
            int n6 = object[4];
            byte by2 = (byte)((n6 - 1) / 28 + 1);
            if (by2 <= 0) {
                by2 = 1;
            }
            bp[] bpArray = new bp[by2];
            int n7 = 0;
            while (n6 > 0) {
                n3 = Math.min(28, n6);
                n6 -= n3;
                bpArray[n7++] = new bp((byte)n3);
            }
            ++n4;
            n3 = object[5];
            n7 = 0;
            for (n2 = 0; n2 < n3; ++n2) {
                n6 = object[n4++];
                byArray = new byte[n6];
                System.arraycopy(object, n4, byArray, 0, n6);
                n4 += n6;
                dg dg2 = dg.a(byArray);
                if (dg2 == null) continue;
                bpArray[n7].a(dg2, (int)dg2.i);
                if (bpArray[n7].a() < bpArray[n7].a) continue;
                ++n7;
            }
            block4: for (n2 = 0; n2 < nArray.length; ++n2) {
                if (nArray[n2][0] < 0) {
                    n5 += nArray[n2][2];
                    continue;
                }
                object = dg.a((byte)nArray[n2][0], (byte)nArray[n2][1]);
                for (n4 = 0; n4 < 3; ++n4) {
                    if (!bpArray[n4].a((byte)nArray[n2][0], (byte)nArray[n2][1], nArray[n2][2])) continue;
                    bpArray[n4].a((dg)object, nArray[n2][2]);
                    continue block4;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            object = dataOutputStream;
            dataOutputStream.writeInt(n5);
            ((DataOutputStream)object).writeByte(84);
            n3 = 0;
            for (n4 = 0; n4 < 3; ++n4) {
                n3 = (byte)(n3 + bpArray[n4].a());
            }
            ((DataOutputStream)object).writeByte(n3);
            for (n4 = 0; n4 < 3; ++n4) {
                int n8 = bpArray[n4].a();
                for (n5 = 0; n5 < n8; ++n5) {
                    dg dg3 = bpArray[n4].a(n5);
                    if (dg3 == null) continue;
                    byArray = dg.a(dg3);
                    ((DataOutputStream)object).writeByte(byArray.length);
                    ((OutputStream)object).write(byArray);
                }
            }
            rpg.d.b(byteArrayOutputStream.toByteArray());
            ((FilterOutputStream)object).close();
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    static {
        a = (byte)-1;
        b = (byte)-1;
        a = new byte[5];
        b = new byte[9];
        a = 0;
        a = null;
        a = false;
        b = 0;
        c = 255;
        c = (byte)-1;
        d = -1;
        d = (byte)-1;
        Z = new byte[6];
        aa = null;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        a = null;
        g = (byte)-1;
        h = (byte)-1;
        ab = new byte[4];
        b = false;
        ac = null;
        a = null;
        b = null;
        a = null;
        a = null;
        i = (byte)-1;
        j = (byte)-1;
        j = new byte[][]{{16, 17, 18, 19}, {20, 21, 22, 23}, {20, 21, 22, 23}, {20, 21, 22, 23}, {14, 15, 16, 17}, {19, 20, 21, 22}};
        a = null;
    }
}

