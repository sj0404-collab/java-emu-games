/*
 * Decompiled with CFR 0.152.
 */
import rpg.RPGHeroEx;
import rpg.a;
import rpg.b;
import rpg.c;
import rpg.g;

public final class ao
extends ah
implements g {
    private static ao a = null;

    public static ao a() {
        if (a == null) {
            a = new ao();
        }
        return a;
    }

    public static void b() {
        if (a != null) {
            a = null;
        }
        r.a = null;
        System.gc();
        Runtime.getRuntime().gc();
    }

    public ao() {
        super(null, (byte)10);
        this.d = r.i > 0 ? (byte)1 : 0;
        this.j();
    }

    final boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (this.d(n, n2)) {
            while (this.d == 1 && r.i <= 0 || this.d == 2 && j.a) {
                if (n == 5 || n2 == 54) {
                    this.d = (byte)(this.d + 1);
                    continue;
                }
                this.d = (byte)(this.d - 1);
            }
            this.j();
            return true;
        }
        if (ah.f(n, n2)) {
            n2 = this.d;
            ao ao2 = this;
            switch (n2) {
                case 0: 
                case 1: {
                    ao2.b = new dm(ao2, (byte)n2);
                    break;
                }
                case 4: {
                    ao2.b = new bz((ah)ao2, false);
                    break;
                }
                case 5: {
                    ao2.b = new au((ah)ao2, false);
                    break;
                }
                case 6: {
                    ao2.b = new al(ao2);
                    break;
                }
                case 7: {
                    RPGHeroEx.a.a("GameCenterUrl");
                    break;
                }
                case 8: {
                    ao2.b = new cz(ao2);
                    break;
                }
                case 3: {
                    ao2.b = new dm(ao2, (byte)n2);
                    break;
                }
                case 9: {
                    byte[] byArray = rpg.b.I;
                    v0.b = new bk((ah)ao2, byArray, 3, false, true);
                    break;
                }
                case 2: {
                    ao2.b = new bd(ao2);
                    bd.a = true;
                }
            }
            return true;
        }
        return false;
    }

    final void a(byte by, byte by2) {
        this.g();
        if (by == 3 && by2 == 0) {
            switch (this.d) {
                case 9: {
                    RPGHeroEx.a.destroyApp(true);
                }
            }
        }
    }

    protected final void a(cr cr2) {
        bh.a();
        rpg.a.c(cr2);
        if (!this.e) {
            this.b(cr2);
        }
    }

    protected final void b(cr cr2) {
        int n;
        if (this.h < 8) {
            n = 30 * this.h;
            cr2.a(n, n, n);
        } else {
            cr2.a(0xFFFFFF);
        }
        n = rpg.a.d + (rpg.a.d >> 1) - 3;
        cr2.a(rpg.c.a, rpg.a.c, n, 17);
        dv.a(cr2, rpg.a.c, n + 3, rpg.c.c.a(this.d), 0, 1);
    }

    protected final void i() {
        if (this.h > 8) {
            this.e = false;
        }
    }
}
