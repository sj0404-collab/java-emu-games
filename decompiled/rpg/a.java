/*
 * Decompiled with CFR 0.152.
 */
package rpg;

import rpg.b;
import rpg.c;
import rpg.e;
import rpg.h;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class a
extends dc
implements Runnable,
b {
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    private static byte b;
    public static boolean a;
    protected byte a = (byte)-1;
    public static cr a;
    public static int f;

    public abstract void a();

    public abstract void b();

    public a() {
        a = cj.a.getWidth();
        b = cj.a.getHeight();
        c = a >> 1;
        d = b >> 1;
    }

    public static void a(cr cr2) {
        cr2.b(0, 0, a, b);
    }

    public static void a(cr cr2, int n2) {
        cr2.b(0, 0, a, b);
        cr2.a(n2);
        cr2.a(0, 0, a, b);
    }

    public static void c() {
        if ((b = (byte)(b + 5)) < 0 || b > 100) {
            b = (byte)100;
        }
    }

    protected static void b(cr cr2) {
        int n2 = d;
        cr2.b(255);
        if (e == 3) {
            rpg.a.a(cr2, 0);
            cr2.a(14663551);
            dv.a(cr2, c - 48, n2 - 18, rpg.c.b.a(1), 0);
            cr2.e(c - 50, n2, c + 48, n2);
            cr2.a(c - 51, n2 + 1, 2, 2);
            cr2.a(c + 48, n2 + 1, 2, 2);
            cr2.a(10452799);
            cr2.e(c - 50, n2 + 5, c + 48, n2 + 5);
            cr2.a(c - 51, n2 + 3, 2, 2);
            cr2.a(c + 48, n2 + 3, 2, 2);
        }
        if (e > 3) {
            cr2.b(0, 0, a, b);
            cr2.a(0);
            cr2.a(c + 5, n2 - 16, 18, 10);
            cr2.a(14663551);
            dv.a(cr2, c + 5, n2 - 16, "...".substring(0, 3).getBytes(), 1);
            cr2.a(14655295);
            cr2.a(c - 48, n2 + 2, 95 * b / 100, 1);
            cr2.a(0xFFFF7F);
            cr2.a(c - 48, n2 + 3, 95 * b / 100, 1);
        } else if (e < 3) {
            cr2.a(0);
            int n3 = (b + 11) / 12;
            for (int i2 = 0; i2 < n3; ++i2) {
                cr2.a(0, i2 * 12 + (e << 2), a, 4);
            }
        }
        e = e < 100 ? ++e : 4;
        cr2.a(0xFFFFFF);
        byte[] byArray = rpg.c.a.a(15 + f);
        dv.a(cr2, 10, n2 + 10, a - 20, 0, byArray);
    }

    public static final void a(cr cr2, boolean bl2) {
        int n2;
        rpg.a.a(cr2, 10159117);
        cr2.a(0);
        cr2.a(0, 0, a, d);
        int n3 = rpg.c.b.a();
        int n4 = rpg.c.b.b();
        int n5 = a / n3 + 1;
        n4 = b - n4 >> 1;
        for (n2 = 0; n2 < n5; ++n2) {
            cr2.a(rpg.c.b, n2 * n3, n4, 20);
        }
        if (bl2 && b >= 200) {
            n3 = rpg.c.k.a();
            n4 = rpg.c.k.b();
            n5 = a / n3 + 1;
            for (n2 = 0; n2 < n5; ++n2) {
                if (b > 240) {
                    cr2.a(rpg.c.k, n2 * n3, 0, 20);
                    cr2.a(rpg.c.c, n2 * n3, n4, 20);
                }
                cr2.a(rpg.c.k, n2 * n3, b - n4, 20);
            }
        }
    }

    public static void c(cr cr2) {
        rpg.a.a(cr2, false);
        cr2.a(rpg.c.e, c, d - d / 3, 3);
        cr2.a(0xFF0000);
        dv.a(cr2, c, b - 15, h.a, 0, 1);
    }

    protected static void a(boolean bl2) {
        if (bl2) {
            e = 3;
        } else {
            b = 0;
            e = 3;
        }
        rpg.e.a().g();
    }
}

