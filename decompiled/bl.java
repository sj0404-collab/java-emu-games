/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Font
 */
import javax.microedition.lcdui.Font;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bl {
    private Font a = null;
    private static final bl a = new bl(Font.getDefaultFont());

    private bl(Font font) {
        this.a = font;
    }

    public static bl a() {
        return a;
    }

    public final int a(String string, int n2, int n3) {
        return this.a.substringWidth(string, 0, n3);
    }
}

