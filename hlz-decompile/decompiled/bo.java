/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.media.Manager
 *  javax.microedition.media.Player
 *  javax.microedition.media.control.VolumeControl
 */
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;
import rpg.b;
import rpg.c;
import rpg.e;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bo
implements b {
    private static int a = 10;
    public static long a;
    private static long b;
    private static byte a;
    private static byte b;
    private static Player[] a;
    private static Player a;
    private static final byte[] a;

    public static final void a() {
    }

    public static final void b() {
        b = 0L;
        if (a == null || a.getState() != 400) {
            a = (byte)-1;
            return;
        }
        try {
            a.stop();
            if (a == 14) {
                bo.i();
            }
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
        a = (byte)-1;
    }

    public static final void c() {
        if (a == 14) {
            bo.b();
        }
    }

    public static final void d() {
        bo.c();
        a = System.currentTimeMillis() << 1;
    }

    public static final void e() {
        a = 0L;
    }

    public static final void f() {
        bo.c();
        bo.i();
    }

    private static void b(byte by, boolean bl) {
        if (e.a > 0) {
            try {
                if (a != 14 || a.getState() == 400) {
                    bo.b();
                }
                if (a != by) {
                    a = a[by];
                } else if (a == null) {
                    byte by2 = by;
                    if (by2 != 14) {
                        bo.b(by2);
                    }
                    a = a[by2];
                }
                a = by;
                if (a != null && a.getState() != 400) {
                    bo.a((int)e.a);
                    a.setLoopCount(bl ? -1 : 1);
                    a.start();
                    bo.a((int)e.a);
                }
            }
            catch (Exception exception) {
                Exception exception2 = exception;
                exception.printStackTrace();
            }
        }
        a = System.currentTimeMillis() + 3000L;
    }

    public static final void a(byte by, boolean bl) {
        bo.c();
        bo.c();
        bo.i();
        if (bl) {
            a = 0L;
            return;
        }
        by = 0;
        by = (byte)14;
        bo.b((byte)14, false);
    }

    public static final void a(byte by) {
        if (e.c) {
            if (System.currentTimeMillis() - b < 127L) {
                return;
            }
            if (a[by] == null) {
                bo.b(by);
            }
            bo.b(by, false);
            b = System.currentTimeMillis();
        }
    }

    public static final void a(int n) {
        if (n < 0) {
            n = 0;
        } else if (n > a) {
            n = a;
        }
        if (a != null) {
            try {
                VolumeControl volumeControl;
                if (a.getState() != 400 && (volumeControl = (VolumeControl)a.getControl("VolumeControl")) != null) {
                    volumeControl.setLevel(n * 100 / a);
                }
                return;
            }
            catch (Exception exception) {}
        }
    }

    private static void i() {
        if (a[14] != null) {
            a[14].close();
            bo.a[14] = null;
        }
    }

    public static final void g() {
        bo.b(10);
        bo.b(11);
        bo.b(13);
        for (int i = 1; i <= 4; ++i) {
            bo.b(i);
        }
    }

    public static final void h() {
        for (int i = 0; i < 6; ++i) {
            if (a[a[i]] == null) continue;
            bo.a[bo.a[i]] = null;
        }
        bo.b(a[r.b]);
        bo.b(11);
    }

    public static final void b(int n) {
        if (a[n] != null) {
            return;
        }
        try {
            int n2 = 0;
            switch (n) {
                case 0: {
                    n2 = 0;
                    break;
                }
                case 3: 
                case 6: 
                case 7: 
                case 8: {
                    n2 = 1;
                    break;
                }
                case 4: 
                case 5: 
                case 10: {
                    n2 = 2;
                    break;
                }
                case 1: 
                case 2: 
                case 9: {
                    n2 = 3;
                    break;
                }
                case 11: 
                case 12: {
                    n2 = 4;
                    break;
                }
                case 13: {
                    n2 = 5;
                }
            }
            Object object = c.a("/snd/e/" + n2);
            object = new ByteArrayInputStream((byte[])object);
            bo.a[n] = Manager.createPlayer((InputStream)object, (String)"audio/x-wav");
            a[n].realize();
            a[n].prefetch();
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
        a = new Player[15];
        a = new byte[]{8, 5, 7, 9, 8, 6};
    }
}
