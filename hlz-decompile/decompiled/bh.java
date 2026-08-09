/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import rpg.RPGHeroEx;
import rpg.a;
import rpg.b;
import rpg.e;
import rpg.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bh
extends a {
    private static byte b = (byte)-1;
    public static boolean b = false;
    public static int g;
    public static int h;
    public static int i;
    public static int j;
    public static boolean c;
    public static boolean d;
    public static boolean[] a;
    public static boolean e;
    private static bh a;
    int k = 0;
    private static int l;
    private static db a;
    private static cw a;
    private cx a;
    private int m;
    private byte c;
    private boolean f = false;
    private int n = 0;
    private byte d;
    private static boolean g;
    private final int[] a;
    private final int[] b;
    private final int[] c;
    private final int[] d = (byte)2;

    public bh() {
        this.a = new int[]{9700099, 0xFF0303, 16740355, 11862787};
        this.b = new int[]{0xFFFF00};
        this.c = new int[]{51968, 0x99F900, 51968};
        this.d = new int[]{5747455, 3208959, 5747455};
        g = rpg.a.a;
        h = rpg.a.b - 33;
        i = g - 16 >> 1;
        j = h >> 1;
        if (b < 0) {
            b = 1;
            try {
                String string = RPGHeroEx.a.getAppProperty("EA-Porting-Test-Cheat-Enable");
                if (string != null && string.trim().equals("We.are.QA.need.CHEAT.PLEASE")) {
                    b = 0;
                }
                return;
            }
            catch (Exception exception) {
                Exception exception2 = exception;
                exception.printStackTrace();
            }
        }
    }

    public static bh a() {
        if (a == null) {
            a = new bh();
        }
        return a;
    }

    public final void a() {
        this.d = (byte)2;
    }

    public final void b() {
        bo.a = 0L;
        if (r.d == 2) {
            bo.a();
        }
        this.a(1, 53);
        bh.a();
        rpg.a.a = true;
        c = true;
        e = true;
        rpg.a.e = 3;
        this.d = (byte)2;
    }

    public static void e(cr cr2) {
        if (rpg.a.a > 240) {
            cr2.b(r.a.d, r.a.e, Math.min(r.a.a, g - r.a.d), Math.min(r.a.b, h - r.a.e));
            return;
        }
        cr2.b(0, 0, g, h);
    }

    protected final void d(cr object) {
        rpg.a.a = object;
        bh bh2 = this;
        this.f = false;
        if (bh2.n != 0) {
            bh2.a(1, bh2.n);
            bh2.n = 0;
        }
        if (r.f) {
            j.a((cr)object, rpg.g.a, (rpg.g.b << 1) - 20, 160, 150);
            ((cr)object).a(15723216);
            ((cr)object).d(rpg.g.a, (rpg.g.b << 1) - 20, 159, 149);
            ((cr)object).a(3550755);
            if (r.a != null) {
                dv.a((cr)object, rpg.g.a + 10, (rpg.g.b << 1) - 10, 150, 1, r.a);
                dv.a((cr)object, rpg.a.c, rpg.a.b - 62, rpg.c.a.a(27), 0, 1);
            }
            return;
        }
        r.a();
        switch (r.d) {
            case 1: {
                rpg.a.b(rpg.a.a);
                break;
            }
            case 2: {
                if (this.d > 0) {
                    rpg.a.a = true;
                    this.d = (byte)(this.d - 1);
                }
                ao.a().c(rpg.a.a);
                break;
            }
            case 3: {
                this.d();
                break;
            }
            case 7: {
                bh2 = this;
                object = rpg.a.a;
                if (bh2.k < 5) {
                    int n = rpg.a.b / 5;
                    int n2 = n / 5;
                    for (int i = 0; i < 5; ++i) {
                        ((cr)object).a(0, n * i, rpg.a.a, n2 * bh2.k);
                    }
                } else {
                    rpg.a.a((cr)object, 0);
                    byte[] byArray = rpg.c.b.a(14);
                    int n = dv.a(byArray);
                    ((cr)object).a(0x5F3F3F);
                    dv.a((cr)object, rpg.a.c - n / 2 + 1, rpg.a.d - 20 + 1, 200, 1, byArray, 0, 0, bh2.k - 5 << 1);
                    ((cr)object).a(0xFF3F3F);
                    dv.a((cr)object, rpg.a.c - n / 2, rpg.a.d - 20, 200, 1, byArray, 0, 0, bh2.k - 5 << 1);
                    int n3 = bh2.k - 5;
                    if (n3 > 8) {
                        n3 = 8;
                    }
                    x.a(rpg.a.c, rpg.a.d + 20, n3);
                    if (bh2.k > 43) {
                        rpg.c.a().d();
                        bh.a().a((byte)2, false);
                    }
                }
                ++bh2.k;
                break;
            }
            case 4: {
                if (!m.a()) break;
                m.a(rpg.a.a);
                break;
            }
            case 5: {
                this.a(dj.a());
                dj.a().e(rpg.a.a);
                break;
            }
            case 8: {
                this.a(null);
                r.a.a(rpg.a.a);
                break;
            }
            case 10: {
                bh2 = this;
                object = rpg.a.a;
                rpg.a.a((cr)object, 0);
                if (bh2.m > 0) {
                    object = bh2;
                    bh2.a = null;
                    r.a((byte)3, (byte)11, (byte)1);
                    break;
                }
                int n = bh2.m * 7;
                if (bh2.k < 3) {
                    ((cr)object).a(50 + 50 * bh2.k, 50 + 50 * bh2.k, 50 + 50 * bh2.k);
                } else if (bh2.k < 15) {
                    ((cr)object).a(0xFFFFFF);
                } else if (bh2.k < 18) {
                    ((cr)object).a(255 - 50 * (bh2.k - 15), 255 - 50 * (bh2.k - 15), 255 - 50 * (bh2.k - 15));
                } else {
                    ((cr)object).a(0);
                }
                int n4 = rpg.a.b - 84 >> 1;
                for (int i = 0; i < 7; ++i) {
                    byte[] byArray = bh2.a.a(n + i);
                    if (byArray == null) continue;
                    dv.a((cr)object, rpg.a.c, n4 + i * 15, byArray, 0, 1);
                }
                if (bh2.k < 20) {
                    ++bh2.k;
                    break;
                }
                if (bh2.m > 0) break;
                ++bh2.m;
                bh2.k = 0;
                break;
            }
            case 11: {
                object = rpg.a.a;
                ((cr)object).b(255);
                rpg.a.a((cr)object, 0);
                ((cr)object).a(0xFFFFFF);
                dv.a((cr)object, rpg.a.c, rpg.a.d - 20, rpg.c.b.a(r.h > 0 ? 34 : 33), 0, 1);
                dv.a((cr)object, rpg.a.c, rpg.a.d + 10, rpg.c.b.a(32), 0, 1);
            }
        }
        rpg.e.e();
    }

    public final void d() {
        if (rpg.e.c > 0) {
            r.c();
            r.d();
            r.a(true, true);
        } else {
            r.d();
            r.c();
        }
        r.a.c();
        this.f();
    }

    public final void run() {
        if (r.d == 1) {
            rpg.c c2 = rpg.c.a();
            switch (((a)this).a) {
                case 2: {
                    r.m();
                    ao.a();
                    c2.a();
                    bo.a((byte)0, true);
                    r.b();
                    break;
                }
                case 3: {
                    ao.b();
                    rpg.c.a = c2.a();
                    c2.b();
                    ((a)this).a = (byte)4;
                }
                case 4: {
                    m.a();
                    rpg.c.g();
                    bo.f();
                    r.a((byte)2, r.e, r.f, r.g);
                }
            }
            ((a)this).a = (byte)-1;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    protected final boolean a(int n, int n2) {
        int n3;
        if (rpg.e.a() == null) return true;
        if (rpg.e.e) {
            return true;
        }
        if (n3 == 35 && r.f) {
            r.f = false;
            return true;
        }
        if (r.f) {
            return true;
        }
        if (n == 0) {
            int n4;
            this.f = true;
            void var1_2 = n3;
            switch (var1_2) {
                case -7: 
                case -6: {
                    n4 = var1_2;
                    break;
                }
                default: {
                    n4 = cj.a((int)var1_2);
                }
            }
            int n5 = n4;
            switch (r.d) {
                case 3: {
                    int n6 = n3;
                    n3 = n5;
                    bh bh2 = this;
                    switch (n3) {
                        case 1: {
                            n6 = 50;
                            break;
                        }
                        case 6: {
                            n6 = 56;
                            break;
                        }
                        case 2: {
                            n6 = 52;
                            break;
                        }
                        case 5: {
                            n6 = 54;
                            break;
                        }
                        case 8: {
                            n6 = 53;
                            break;
                        }
                        case -7: {
                            if (j.a) return true;
                            if (!bh.a()) return true;
                            r.a((byte)6, (byte)3);
                            return true;
                        }
                        case -6: {
                            if (!bh.a()) return true;
                            r.a((byte)6);
                            return true;
                        }
                    }
                    switch (n6) {
                        case 53: {
                            x x2 = r.a;
                            switch (x2.p) {
                                case 6: 
                                case 7: {
                                    return true;
                                }
                                case 2: {
                                    if (r.c()) break;
                                    r.e();
                                    break;
                                }
                            }
                            if (r.a.a(((c)x2).c, ((c)x2).d)) return true;
                            if (m.d()) return true;
                            if (!ab.c) return true;
                            r.b(0);
                            return true;
                        }
                        case 50: {
                            r.b((byte)1);
                            return true;
                        }
                        case 56: {
                            r.b((byte)2);
                            return true;
                        }
                        case 52: {
                            r.b((byte)3);
                            return true;
                        }
                        case 54: {
                            r.b((byte)4);
                            return true;
                        }
                        case 49: {
                            bh.a(0);
                            return true;
                        }
                        case 51: {
                            bh.a(1);
                            return true;
                        }
                        case 55: {
                            bh.a(2);
                            return true;
                        }
                        case 57: {
                            bh.a(3);
                            return true;
                        }
                        case 48: {
                            d = r.a.a(true);
                            return true;
                        }
                        case 35: {
                            if (b == 0) {
                                b = !b;
                            }
                            d = r.a.a(false);
                            return true;
                        }
                        case 42: {
                            if (!bh.a()) return true;
                            if (rpg.e.d == 1) {
                                r.a((byte)6, (byte)2);
                                return true;
                            }
                            if (rpg.e.d != 0) return true;
                            g = true;
                            r.a((byte)3, (byte)8, (byte)3);
                            e = true;
                        }
                    }
                    return true;
                }
                case 5: {
                    dj.a().a(n5, n3);
                    return true;
                }
                case 4: {
                    m.a(n5, n3);
                    return true;
                }
                case 2: {
                    ao.a().a(n5, n3);
                    return true;
                }
                case 8: {
                    if (n3 != -7) {
                        if (n5 != 8) {
                            if (n3 != -6) return true;
                        }
                        if (g) return true;
                    }
                    if (g) {
                        g = false;
                        r.a((byte)3, (byte)3, (byte)1);
                    } else {
                        r.a((byte)6);
                        dj.k = true;
                    }
                    c = true;
                    return true;
                }
                case 11: {
                    if (n5 != 8) {
                        if (n3 != 53) return true;
                    }
                    r.a((byte)8, (byte)2);
                }
            }
            return true;
        }
        if (n != 1) return true;
        if (r.d != 3) {
            return true;
        }
        if (this.f) {
            this.n = n3;
            return true;
        }
        if (r.a.p == 2 && !r.c()) {
            r.e();
        }
        r.a.h();
        return true;
    }

    private static boolean a() {
        if (r.a == null || r.a.p == 1) {
            return true;
        }
        if (r.a.p == 2 && !r.c()) {
            r.e();
            return true;
        }
        return false;
    }

    private static void a(int n) {
        if (!ab.c) {
            return;
        }
        switch (r.a.p) {
            case 6: 
            case 7: 
            case 9: 
            case 10: {
                return;
            }
        }
        int n2 = r.b[n];
        if (n2 < 0) {
            return;
        }
        if (r.a[n] > 0) {
            return;
        }
        r.b(r.b(n) ? n2 : n2 + 100);
    }

    public final void a(byte by, boolean bl) {
        ((a)this).a = by;
        r.d = 1;
        rpg.a.f = new Random().nextInt();
        rpg.a.f = Math.abs(rpg.a.f) % 11;
        rpg.a.a(false);
        new Thread(a).start();
    }

    public static void e() {
        rpg.a.a = true;
        c = true;
    }

    public final void f() {
        int n;
        int n2;
        int n3;
        if (l > 0 && a != null && bh.a.p != 7) {
            n3 = rpg.a.a - 80;
            rpg.a.a.a(a, n3, 0, 20);
            rpg.a.a.a(0xFF3F2F);
            rpg.a.a.a(n3 + 42 + 2, 24, 32 * (a.c() - 1) / a.d() - 1, 2);
            if (r.d == 3) {
                --l;
            }
        } else {
            bh.h();
        }
        n3 = rpg.a.a - 120 >> 1;
        int n4 = rpg.a.b - 33;
        x x2 = r.a;
        if ((x2.c > 0 || x2.d > 0) && r.d == 3 && ab.a <= 0) {
            this.c = (byte)(this.c + 1);
            if (this.c < 5) {
                bh.e(rpg.a.a);
                n2 = 0;
                n = n3 - 40;
                if (rpg.a.a < 240) {
                    n += 20;
                }
                if (x2.c > 0) {
                    rpg.a.a.a(rpg.c.c[0], n, n4 - 2, 36);
                    n2 = 12;
                }
                if (x2.d > 0) {
                    rpg.a.a.a(rpg.c.c[1], n + n2, n4 - 2, 36);
                }
            }
            if (this.c >= 8) {
                this.c = 0;
            }
        }
        if (c) {
            rpg.a.a.b(0, n4, rpg.a.a, 33);
            rpg.a.a.a(0);
            rpg.a.a.a(0, n4, rpg.a.a, 33);
            if (rpg.c.r != null) {
                rpg.a.a.a(rpg.c.r, 0, n4, 20);
                if (rpg.a.a > 176) {
                    ah.b(rpg.a.a, r.a.b(), 40, n4 + 20, 4, 0);
                    ah.b(rpg.a.a, r.e, 17, n4 + 10, 4, 0);
                }
                if (j.a) {
                    if (rpg.c.k != null) {
                        if (rpg.c.l != null) {
                            rpg.a.a.a(rpg.c.l, rpg.a.a - rpg.c.l.a(), n4, 20);
                        }
                        rpg.a.a.a(rpg.c.k, rpg.a.a - rpg.c.k.a(), n4, 20);
                    }
                } else {
                    if (rpg.c.l != null) {
                        rpg.a.a.a(rpg.c.l, rpg.a.a - rpg.c.l.a(), n4, 20);
                    }
                    rpg.a.a.a(rpg.c.q, rpg.a.a - rpg.c.q.a(), n4, 20);
                }
            }
            rpg.a.a.a(rpg.c.j, n3, n4, 20);
            if (rpg.a.a >= 360 && rpg.c.k != null) {
                rpg.a.a.a(rpg.c.k, n3 - 60, n4, 20);
                rpg.a.a.a(rpg.c.k, n3 + 120, n4, 20);
            }
        }
        if (c || d) {
            if (bh.a(true, n3 + 86, n4 + 16)) {
                ah.b(rpg.a.a, 0, n3 + 83, n4 + 19, 4, 0);
                d = false;
            }
            if (bh.a(false, n3 + 104, n4 + 16)) {
                rpg.a.a(rpg.a.a);
                rpg.a.a.a(0xFFFFFF);
                dv.a(rpg.a.a, n3 + 102, n4 + 18, rpg.b.r, 0);
                d = false;
            }
        }
        if (c || a[0]) {
            n2 = n3 + 1;
            n = n4 + 10;
            bh.a(n3, n4, n2, n, 118, 4, this.a, (byte)0, 4);
        }
        if (c || a[2]) {
            int n5 = n3 + 1;
            n2 = n4 + 33 - 1;
            bh.a(n3, n4, n5, n2, 118, 1, this.b, (byte)2, 4);
        }
        if (c || a[3]) {
            n2 = n3 + 79;
            n = n4 + 4;
            bh.a(n3, n4, n2, n, 40, 3, this.c, (byte)3, 4);
        }
        if (c || a[1]) {
            n2 = n3 + 1;
            n = n4 + 4;
            bh.a(n3, n4, n2, n, 40, 3, this.d, (byte)1, 8);
        }
        for (n = 0; n < 4; n = (int)((byte)(n + 1))) {
            int n6 = n4 + 17;
            n2 = n3 + 8 + n * 20;
            int n7 = n;
            byte by = r.b[n7];
            rpg.a.a.b(n2 - 5, n6, 17, 12);
            if (by < 0) {
                rpg.a.a.a(0);
                rpg.a.a.a(n2 - 5, n6, 17, 12);
                continue;
            }
            int n8 = r.a[n7];
            int n9 = r.b[n7];
            if (r.b(n7)) {
                bh.a(by, n2, n6);
            } else {
                rpg.a.a.a(rpg.c.g[by], n2, n6, 20);
            }
            if (n8 > 0) {
                rpg.a.a.b(n2 - 5, n6, 5, 12);
                rpg.a.a.a(0);
                rpg.a.a.a(n2 - 5, n6, 5, 12);
                rpg.a.a.b(n2, n6, 12, n8 * 12 / n9);
                rpg.a.a.a(rpg.c.i, n2, n6, 20);
                continue;
            }
            if (n8 != 0) continue;
            rpg.a.a.b(n2 - 5, n6, 5, 12);
            rpg.a.a.a(rpg.c.j, rpg.a.a - 120 >> 1, rpg.a.b - 33, 20);
        }
        bh.e(rpg.a.a);
        c = false;
    }

    private static void a(int n, int n2, int n3, int n4, int n5, int n6, int[] nArray, byte by, int n7) {
        x x2 = r.a;
        int n8 = x2.d(by) * n5 / x2.e(by);
        rpg.a.a.b(n3, n4, n5, n6);
        rpg.a.a.a(rpg.c.j, n, n2, 20);
        if (n8 > 0) {
            n = n7 == 4 ? n3 : n3 + n5 - n8;
            for (n2 = 0; n2 < n6; ++n2) {
                if (b && by == 0) {
                    rpg.a.a.a(0x7F7F7F);
                } else {
                    rpg.a.a.a(nArray[n2]);
                }
                rpg.a.a.e(n, n4 + n2, n + n8, n4 + n2);
            }
        }
        bh.a[by] = false;
    }

    private static boolean a(boolean bl, int n, int n2) {
        dg dg2 = r.a(bl);
        rpg.a.a.b(n - 3, n2, 17, 14);
        rpg.a.a.a(0);
        rpg.a.a.a(n - 3, n2, 17, 14);
        if (dg2 == null) {
            return false;
        }
        int n3 = r.a[4];
        dg2.a(rpg.a.a, n, n2, true, true);
        int n4 = r.a(dg2.g).a(dg2.g, dg2.h);
        if (n4 > 1) {
            if (n4 > 99) {
                n4 = 99;
            }
            ah.b(rpg.a.a, n4, n + 13, n2 + 7, 8, 0);
        }
        if (n3 > 0) {
            rpg.a.a.b(n, n2, 12, n3 * 12 / 10);
            rpg.a.a.a(rpg.c.i, n, n2, 20);
            return false;
        }
        return true;
    }

    public static final void a(int n, int n2, int n3) {
        rpg.a.a.b(n2, n3, 12, 12);
        rpg.a.a.a(rpg.c.f, n2 - 12 * (n - 4), n3, 20);
    }

    private final void a(ah ah2) {
        if (rpg.a.a) {
            r.a.c();
            this.f();
            if (ah2 != null) {
                ah2.h();
            }
            rpg.a.a = false;
        }
    }

    public final void g() {
        this.a = new cx("/t/stf");
        this.k = 0;
        this.m = 0;
        r.a((byte)3, (byte)10, (byte)1);
    }

    public static final void a(db object, boolean bl) {
        l = 24;
        if (bl && a != null) {
            return;
        }
        if (a == object) {
            return;
        }
        a = object;
        a = cw.a(80, 34);
        object = a.a();
        ((cr)object).b(0, 0, 80, 34);
        ((cr)object).a(0);
        ((cr)object).a(0, 0, 80, 34);
        ((cr)object).a(0xFFFFFF);
        dv.a((cr)object, 40, 5, a.a(), 0, 1);
        ((cr)object).a(10159117);
        ((cr)object).d(1, 1, 77, 31);
        ((cr)object).d(42, 22, 33, 5);
        ((cr)object).a(rpg.c.l[0], 2, 17, 20);
        ah.b((cr)object, a.b(), 39, 21, 8, 1);
    }

    public static void h() {
        a = null;
        a = null;
        l = 0;
    }

    static {
        g = false;
    }
}
