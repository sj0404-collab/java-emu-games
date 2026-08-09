/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;
import rpg.c;
import rpg.d;
import rpg.e;
import rpg.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class be
extends a {
    private byte b = 0;
    private static be a;
    private cw a;
    private int g;
    private static boolean b;
    private static cw b;
    private static long a;

    public static be a() {
        if (a == null) {
            a = new be();
        }
        return a;
    }

    public final void a() {
    }

    public final void b() {
        rpg.a.e = 3;
        if (this.b == 2) {
            bo.a = 0L;
            bo.a();
        }
    }

    public static void d() {
        if (a != null) {
            a = null;
        }
    }

    protected final boolean a(int n2, int n3) {
        if (n2 != 0) {
            return true;
        }
        n2 = cj.a(n3);
        switch (this.b) {
            case 1: {
                break;
            }
            case 4: {
                switch (n2) {
                    case 2: {
                        n3 = 52;
                        break;
                    }
                    case 5: {
                        n3 = 54;
                        break;
                    }
                    case 8: {
                        n3 = 53;
                    }
                }
                switch (n3) {
                    case -6: 
                    case 53: {
                        if (b) {
                            rpg.e.a = (byte)8;
                            rpg.e.c = true;
                            rpg.e.b = false;
                            bo.a((byte)0, true);
                            rpg.e.a = false;
                        } else {
                            rpg.e.a = (byte)8;
                            rpg.e.c = false;
                            rpg.e.b = false;
                        }
                        this.b((byte)2);
                        break;
                    }
                    case 52: {
                        b = !b;
                        break;
                    }
                    case 54: {
                        b = !b;
                        break;
                    }
                    case -7: {
                        rpg.e.a = (byte)8;
                        rpg.e.c = false;
                        rpg.e.b = false;
                        this.b((byte)2);
                    }
                }
                break;
            }
            case 2: {
                rpg.e.a().d();
            }
        }
        return true;
    }

    protected final void d(cr object) {
        rpg.a.a = object;
        switch (this.b) {
            case 3: {
                if (b != null) {
                    if (a == 0L) {
                        a = System.currentTimeMillis();
                    }
                    rpg.a.a.a(16683008);
                    rpg.a.a.b(0, 0, rpg.a.a, rpg.a.b);
                    rpg.a.a.a(0, 0, rpg.a.a, rpg.a.b);
                    rpg.a.a.a(b, rpg.a.c, rpg.a.d, 3);
                    break;
                }
                rpg.a.b(rpg.a.a);
                break;
            }
            case 1: {
                if (b != null) {
                    b = null;
                }
                cr cr2 = rpg.a.a;
                object = this;
                rpg.a.a(cr2, 0);
                rpg.a.a.b(((be)object).g < 25 ? ((be)object).g * 10 : 255);
                cr2.a(((be)object).a, rpg.a.c, rpg.a.d, 3);
                ++((be)object).g;
                if (((be)object).g <= 50) break;
                super.b((byte)4);
                break;
            }
            case 4: {
                cr cr3 = rpg.a.a;
                object = this;
                rpg.a.c(cr3);
                j.a(cr3, rpg.g.a, rpg.a.d + 15, 160, 70);
                cr3.a(15723216);
                cr3.d(rpg.g.a, rpg.a.d + 15, 159, 69);
                cr3.a(0);
                dv.a(cr3, rpg.a.c, rpg.a.d + 25, rpg.c.a.a(26), 0, 1);
                object = cr3;
                int n2 = rpg.a.d + 58;
                ((cr)object).a(0x660000);
                if (b) {
                    ((cr)object).a(rpg.a.c - 50 - 25, n2, 50, 20);
                    ((cr)object).a(0xFFFFFF);
                    dv.a((cr)object, rpg.a.c - 50, n2 + 4, rpg.c.a.a(0), 0, 1);
                    ((cr)object).a(0);
                    dv.a((cr)object, rpg.a.c + 50, n2 + 4, rpg.c.a.a(1), 0, 1);
                    break;
                }
                ((cr)object).a(rpg.a.c + 25, n2, 50, 20);
                ((cr)object).a(0);
                dv.a((cr)object, rpg.a.c - 50, n2 + 4, rpg.c.a.a(0), 0, 1);
                ((cr)object).a(0xFFFFFF);
                dv.a((cr)object, rpg.a.c + 50, n2 + 4, rpg.c.a.a(1), 0, 1);
                break;
            }
            case 2: {
                cr cr4 = rpg.a.a;
                object = this;
                rpg.a.c(cr4);
                if (((be)object).g % 10 < 8) {
                    cr4.a(0xFFFFFF);
                    dv.a(cr4, rpg.a.c, rpg.a.d + (rpg.a.d >> 1), rpg.b.s, 0, 1);
                }
                ++((be)object).g;
                if (((be)object).g <= 124) break;
                ((be)object).g = 1;
            }
        }
        rpg.e.e();
    }

    public final void run() {
        if (this.b == 3) {
            switch (((a)this).a) {
                case 1: {
                    rpg.e.a().i();
                    rpg.d.b();
                    rpg.a.c();
                    String string = "/ealogo.png";
                    Object object = this;
                    this.a = cw.a(string);
                    rpg.a.c();
                    rpg.c.a().a();
                    rpg.a.c();
                    bo.b(0);
                    rpg.a.c();
                    rpg.c.f();
                    rpg.a.c();
                    r.m();
                    rpg.a.c();
                    a = System.currentTimeMillis() - a;
                    if (a < 2000L) {
                        try {
                            Thread.sleep(2000L - a);
                        }
                        catch (Exception exception) {
                            object = exception;
                            exception.printStackTrace();
                        }
                    }
                    this.b((byte)1);
                }
            }
            ((a)this).a = (byte)-1;
        }
    }

    public final void a(byte by2) {
        ((a)this).a = 1;
        this.b((byte)3);
        new Thread(a).start();
    }

    private void b(byte by2) {
        this.b = by2;
        this.g = 0;
        switch (this.b) {
            case 3: {
                rpg.a.a(false);
                return;
            }
        }
        rpg.e.a().h();
    }

    static {
        b = true;
        b = cw.a("/qq.png");
        a = 0L;
    }
}

