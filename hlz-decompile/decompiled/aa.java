/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import rpg.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class aa
extends Canvas {
    public static dc a = null;
    private static int a = 0;
    private static int b = 0;
    private static int c = 0;
    public static boolean a = false;
    private static byte a = 0;
    private static i a = null;
    private static boolean b = false;

    public aa() {
        this.setFullScreenMode(true);
    }

    protected final void paint(Graphics object) {
        block7: {
            try {
                if (!a.a) {
                    int n = this.getWidth();
                    int n2 = this.getHeight();
                    object.setClip(0, 0, n, n2);
                    object.setColor(0);
                    object.fillRect(0, 0, n, n2);
                    object.setColor(0xFFFFFF);
                    object = new cr((Graphics)object);
                    dv.a((cr)object, n >> 1, n2 >> 1, rpg.b.R, 0, 1);
                    break block7;
                }
                if (a) {
                    int n = this.getWidth();
                    int n3 = this.getHeight();
                    object.setClip(0, 0, n, n3);
                    object.setColor(0);
                    object.fillRect(0, 0, n, n3);
                    object.setColor(0xFFFFFF);
                    if (a < 20) {
                        object = new cr((Graphics)object);
                        dv.a((cr)object, n >> 1, n3 >> 1, rpg.b.s, 0, 1);
                    }
                    byte by = a;
                    a = (byte)(by + 1);
                    if (by > 30) {
                        a = 0;
                    }
                    break block7;
                }
                if (cr.a != null) {
                    object.drawImage(cr.a, 0, 0, 20);
                }
                return;
            }
            catch (Exception exception) {
                Exception exception2 = exception;
                exception.printStackTrace();
            }
        }
    }

    protected final void keyPressed(int n) {
        if (n < -7) {
            return;
        }
        if (!a.a) {
            return;
        }
        if (a) {
            if (this.isShown() && (a = false) != null) {
                a.b();
            }
            return;
        }
        a = n;
    }

    protected final void keyReleased(int n) {
        b = n;
    }

    public static void a() {
        if (a != 0) {
            if (c != 0) {
                if (a != null) {
                    a.a(1, c);
                }
                c = 0;
            }
            c = a;
            if (a != null) {
                a.a(0, a);
            }
            a = 0;
        }
        if (b != 0) {
            if (c != 0) {
                if (a != null) {
                    a.a(1, c);
                }
                c = 0;
            }
            b = 0;
        }
    }

    protected final void showNotify() {
    }

    protected final void hideNotify() {
        if (!a.a) {
            return;
        }
        a = true;
        if (a != null) {
            a.a(1, c);
            c = 0;
            a.a();
        }
    }

    public static boolean a(dc dc2) {
        boolean bl = a == null;
        a = dc2;
        return bl;
    }
}
