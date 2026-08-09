/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.e;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dj
extends aj {
    private static dj a;
    public static cx a;
    public static byte a;
    public static cx b;
    public static cx c;
    public static boolean a;
    public static boolean b;
    public static boolean c;
    public static boolean h;
    public static boolean i;
    public static boolean j;
    public static byte b;
    public static byte c;
    public static byte i;
    public static boolean k;

    public static dj a() {
        if (a == null) {
            a = new dj();
        }
        return a;
    }

    public dj() {
        super(null, (byte)10);
        if (j.a && this.d == 0) {
            this.d = 1;
        }
    }

    public final void b() {
        if (a == null) {
            a = new cx("/t/gm");
        }
        a = r.h > 0 || r.a(4) == 2;
        rpg.e.a().h();
        b = false;
        c = false;
    }

    public final void c(byte by) {
        switch (by) {
            case 1: {
                this.d = (byte)4;
                this.d((byte)4);
                b = false;
                c = false;
                return;
            }
            case 2: {
                this.d = (byte)9;
                this.d((byte)9);
                ((o)((ah)this).b).a();
                b = true;
                c = false;
                return;
            }
            case 3: {
                this.d = 0;
                this.d((byte)0);
                c = true;
            }
        }
    }

    public final void c() {
        this.d = 0;
        a = null;
        a = null;
        if (b != null) {
            b = null;
        }
        if (c != null) {
            c = null;
        }
        w.c();
        if (((ah)this).b != null) {
            ((ah)this).b = null;
        }
        System.gc();
        Runtime.getRuntime().gc();
        rpg.e.a().f();
        bh.c = true;
    }

    final boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (n2 >= 48 && n2 <= 57) {
            if (n2 == 55 && !a) {
                this.a(a.a(69));
                return true;
            }
            if (j.a && n2 == 49) {
                this.a(a.a(69));
                return true;
            }
            if (!h && n2 == 52) {
                this.a(a.a(69));
                return true;
            }
            this.d = n2 == 48 ? (byte)9 : (byte)(n2 - 49);
            this.d(this.d);
        } else if (ah.g(n, n2)) {
            r.a((byte)7, (byte)0);
        } else if (ah.f(n, 49)) {
            this.d(this.d);
        } else if (this.c(n, 49)) {
            if (!a && this.d == 6) {
                this.d = n == 6 ? (byte)(this.d + 1) : (byte)(this.d - 1);
            } else if (j.a && this.d == 0) {
                this.c(n, 49);
            } else if (!h && this.d == 3) {
                this.c(n, 49);
            }
        }
        return true;
    }

    private final void d(byte by) {
        a = by;
        switch (by) {
            case 1: {
                ((ah)this).b = new l(this);
                return;
            }
            case 2: {
                ((ah)this).b = new ce(this, 0);
                return;
            }
            case 4: {
                ((ah)this).b = new w(this);
                return;
            }
            case 5: {
                ((ah)this).b = new ay(this);
                return;
            }
            case 6: {
                ((ah)this).b = new cy(this);
                return;
            }
            case 7: {
                ((ah)this).b = new dp(this);
                return;
            }
            case 9: {
                ((ah)this).b = new o(this);
                return;
            }
            case 8: {
                r.a((byte)3, (byte)8, (byte)3);
                bh.e = true;
                return;
            }
            case 3: {
                ((ah)this).b = new co(this);
                return;
            }
            case 0: {
                ((ah)this).b = new bd(this);
            }
        }
    }

    public final void e(cr cr2) {
        if (k) {
            k = false;
            r.a.c();
        }
        this.d(cr2);
    }

    protected final void a(cr cr2) {
        if (b || c) {
            return;
        }
        if (rpg.a.a > 120) {
            cr2.a(0);
            cr2.b((rpg.a.a - 160 >> 1) - 2, this.g - 2, 164, 178);
            cr2.a((rpg.a.a - 160 >> 1) - 2, this.g - 2, 164, 178);
        }
        cr2.b(rpg.a.a - 160 >> 1, this.g, 160, 174);
        ah.c(cr2, rpg.a.a - 160 >> 1, this.g, 172, 174);
        int n = rpg.a.a - 151 >> 1;
        int n2 = this.g + 5 + 9;
        cr2.a(15723216);
        cr2.d(n + 1, n2 + 1, 151, 152);
        cr2.a(0);
        cr2.d(n, n2, 151, 152);
        dv.a(cr2, rpg.a.c, this.g, a.a(40), 0, 1);
        this.a(cr2, 0, 150, true);
        ah.a(cr2, 3);
    }

    static {
        a = false;
        b = false;
        c = false;
        h = true;
        i = false;
        j = false;
        b = 0;
        c = 0;
        i = 0;
        k = false;
    }
}
