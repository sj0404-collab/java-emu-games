/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.midlet.MIDlet
 */
package rpg;

import javax.microedition.midlet.MIDlet;
import rpg.e;

public class RPGHeroEx
extends MIDlet {
    public static RPGHeroEx a = null;

    protected void startApp() {
        if (a == null) {
            a = this;
            e.a().c();
            return;
        }
        bo.b();
        if (e.a() != null) {
            e.a().b();
        }
    }

    protected void pauseApp() {
        if (e.a() != null) {
            e.a().a();
        }
    }

    public void destroyApp(boolean bl) {
        e.f = false;
        this.notifyDestroyed();
    }

    public final void a(String object) {
        try {
            object = this.getAppProperty((String)object);
            if (object != null && ((String)object).trim().length() > 7) {
                this.platformRequest((String)object);
            }
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
        }
        this.destroyApp(true);
    }
}
