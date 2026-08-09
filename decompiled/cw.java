/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Image;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class cw {
    private Image a = null;

    protected final Image a() {
        return this.a;
    }

    private cw(Image image) {
        this.a = image;
    }

    public final cr a() {
        if (this.a == null) {
            return null;
        }
        return new cr(this.a.getGraphics());
    }

    public static cw a(int n2, int n3) {
        Image image = Image.createImage((int)n2, (int)n3);
        return new cw(image);
    }

    public static cw a(byte[] object, int n2, int n3) {
        object = Image.createImage((byte[])object, (int)0, (int)n3);
        return new cw((Image)object);
    }

    public static cw a(String string) {
        try {
            string = Image.createImage((String)string);
            return new cw((Image)string);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public final int a() {
        return this.a.getWidth();
    }

    public final int b() {
        return this.a.getHeight();
    }

    public static cw a(int[] object, int n2, int n3, boolean bl2) {
        try {
            object = Image.createRGBImage((int[])object, (int)n2, (int)n3, (boolean)true);
            return new cw((Image)object);
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
            return null;
        }
    }

    public final void a(int[] object, int n2, int n3, int n4, int n5, int n6, int n7) {
        try {
            if (this.a != null) {
                this.a.getRGB(object, 0, n3, 0, 0, n6, n7);
            }
            return;
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
            return;
        }
    }
}

