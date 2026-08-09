/*
 * Decompiled with CFR 0.152.
 */
package rpg;

import rpg.RPGHeroEx;
import rpg.c;
import rpg.d;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class e
implements Runnable {
    private static final byte[] a = new byte[]{6, 10, 14, 18};
    private static e a = new e();
    private cj a;
    private rpg.a a = cj.a();
    public static byte a = (byte)3;
    public static byte b = (byte)2;
    public static byte c = (byte)2;
    public static boolean a = true;
    private static byte e = 0;
    public static boolean b = false;
    public static boolean c = false;
    private static boolean g = true;
    public static byte d = 0;
    private static long a = 0L;
    public static boolean d = true;
    private static int a;
    private static int b;
    private static long b;
    public static boolean e;
    private static dh a;
    public static a a;
    public static boolean f;

    e() {
        a = new dh();
        a = a[b];
        e e2 = this;
        rpg.e.a(a);
    }

    public static e a() {
        return a;
    }

    public final synchronized void a() {
        e = true;
        bo.b();
        af.a(true);
        if (this.a != null) {
            this.a.a();
        }
    }

    public final synchronized void b() {
        if (e) {
            e = false;
        }
        if (this.a != null) {
            this.a.b();
        }
    }

    public final void c() {
        rpg.c.e();
        this.a = be.a();
        be.a().a((byte)1);
        cj.a(this.a);
        new Thread(this).start();
        if (a == null) {
            a = new a(RPGHeroEx.a);
        }
    }

    public final void d() {
        this.a = bh.a();
        r.b();
        cj.a(this.a);
        be.d();
    }

    public final void run() {
        if (!f) {
            f = true;
            while (f) {
                Exception exception;
                try {
                    if (aa.a) {
                        cj.a.repaint();
                        try {
                            Thread.sleep(50L);
                        }
                        catch (InterruptedException interruptedException) {
                            exception = interruptedException;
                            interruptedException.printStackTrace();
                        }
                        continue;
                    }
                    aa.a();
                    long l2 = System.currentTimeMillis() - b;
                    if (l2 < (long)b) {
                        try {
                            Thread.sleep((long)b - l2);
                        }
                        catch (InterruptedException interruptedException) {}
                    } else {
                        Thread.sleep(10L);
                    }
                    if (x.g) {
                        x.a -= System.currentTimeMillis() - b;
                        x.g = false;
                    }
                    b = System.currentTimeMillis();
                    if (e) continue;
                    if (!r.f) {
                        bo.a();
                    }
                    this.a.a(rpg.a.a, rpg.a.b);
                }
                catch (Exception exception2) {
                    exception = exception2;
                    exception2.printStackTrace();
                }
            }
        }
    }

    public static void e() {
        long l2 = System.currentTimeMillis() - b;
        if (l2 < (long)b) {
            try {
                Thread.sleep((long)b - l2);
                return;
            }
            catch (InterruptedException interruptedException) {
                return;
            }
        }
        Thread.yield();
    }

    public static void a(int n2) {
        b = 1000 / n2;
    }

    public final void f() {
        rpg.e.a(a);
    }

    public final void g() {
        rpg.e.a(10);
    }

    public final void h() {
        rpg.e.a(20);
    }

    public static void a(byte by2) {
        b = by2;
        a = a[by2];
    }

    public final void i() {
        Object object = this;
        rpg.e.a(20);
        try {
            object = this;
            byte[] byArray = rpg.d.a();
            object = byArray;
            object = byArray;
            a = (byte)8;
            c = (object[0] & 8) != 0;
            g = (object[0] & 4) != 0;
            b = false;
            boolean bl2 = a = (object[0] & 1) != 0;
            if (c) {
                a = false;
            }
            b = (byte)((object[1] & 0xF0) >> 4);
            e = (byte)(object[1] & 0xF);
            c = (byte)object[2];
            a = rpg.f.a((byte[])object, 3);
            r.f = rpg.f.a((byte[])object, 11);
            d = (byte)object[15];
            d = object[16] == true;
        }
        catch (Exception exception) {
            try {
                if (a == 0L) {
                    a = rpg.f.a();
                }
                this.j();
            }
            catch (Exception exception2) {}
        }
        rpg.e.a(b);
    }

    public final void j() {
        byte[] byArray = new byte[24];
        int n2 = 0 | (a & 0xF) << 4;
        if (c) {
            n2 |= 8;
        }
        if (g) {
            n2 |= 4;
        }
        if (a) {
            n2 |= 1;
        }
        byArray[0] = (byte)n2;
        byArray[1] = (byte)((b & 0xF) << 4 | e);
        byArray[2] = c;
        rpg.f.a(a, byArray, 3);
        rpg.f.a(r.f, byArray, 11);
        bo.a((int)a);
        byArray[15] = d;
        byArray[16] = (byte)(d ? 1 : 0);
        rpg.d.a(byArray);
    }

    public static final void k() {
        if (a) {
            a.a();
        }
    }

    static {
        a = null;
        f = false;
    }
}

