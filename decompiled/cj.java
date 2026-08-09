/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 *  javax.microedition.midlet.MIDlet
 */
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import rpg.RPGHeroEx;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class cj {
    public static Display a = null;
    private static cj a = null;
    public static Canvas a = null;

    private cj(Display display) {
        a = display;
    }

    public static int a(int n2) {
        if (a != null) {
            return a.getGameAction(n2);
        }
        return n2;
    }

    public static void a(dc dc2) {
        if (aa.a(dc2)) {
            a.setCurrent((Displayable)a);
        }
    }

    public static cj a() {
        if (a == null) {
            a = new cj(Display.getDisplay((MIDlet)RPGHeroEx.a));
            a = new aa();
        }
        return a;
    }
}

