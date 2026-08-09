/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class cr {
    public static final Image a = Image.createImage((int)cj.a.getWidth(), (int)cj.a.getHeight());
    private static final Graphics a = a.getGraphics();
    private static final cr a = new cr();
    private Graphics b;
    private int a = -1;
    private int b = 0;

    public cr() {
        this.b = a;
    }

    public cr(Graphics graphics) {
        this.b = graphics;
    }

    public static cr a() {
        return a;
    }

    public final void a(cw cw2, int n2, int n3, int n4) {
        try {
            if (this.a == -1) {
                if ((n4 & 0x20) != 0) {
                    n3 -= cw2.b();
                } else if ((n4 & 2) != 0) {
                    n3 -= cw2.b() >> 1;
                }
                if ((n4 & 8) != 0) {
                    n2 -= cw2.a();
                } else if ((n4 & 1) != 0) {
                    n2 -= cw2.a() >> 1;
                }
            } else {
                int n5 = cw2.a().getWidth();
                int n6 = cw2.a().getHeight();
                int[] nArray = new int[n5 * n6];
                cw2.a().getRGB(nArray, 0, n5, 0, 0, n5, n6);
                for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
                    if (nArray[i2] >>> 24 == 0) continue;
                    int n7 = i2;
                    nArray[n7] = nArray[n7] & this.a;
                }
                Image image = Image.createRGBImage((int[])nArray, (int)n5, (int)n6, (boolean)true);
                this.b.drawImage(image, n2, n3, n4);
                return;
            }
            this.b.drawImage(cw2.a(), n2, n3, 20);
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
    }

    public final void a(int n2) {
        this.b.setColor(n2);
        this.b = n2;
    }

    public final void a(int n2, int n3, int n4) {
        this.b.setColor(n2, n3, n4);
        this.b = (n2 & 0xFF) << 16 | (n3 & 0xFF) << 8 | n4 & 0xFF;
    }

    public final void a(int n2, int n3, int n4, int n5) {
        if (this.a == -1) {
            this.b.fillRect(n2, n3, n4, n5);
            return;
        }
        int[] nArray = new int[n4 * n5];
        int n6 = (this.b | 0xFF000000) & this.a;
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            nArray[i2] = n6;
        }
        this.b.drawRGB(nArray, 0, n4, n2, n3, n4, n5, true);
    }

    public final void b(int n2, int n3, int n4, int n5) {
        this.b.setClip(n2, n3, n4, n5);
    }

    public final void c(int n2, int n3, int n4, int n5) {
        this.b.clipRect(n2, n3, n4, n5);
    }

    public final void d(int n2, int n3, int n4, int n5) {
        if (this.a == -1) {
            this.b.drawRect(n2, n3, n4, n5);
        }
    }

    public final void e(int n2, int n3, int n4, int n5) {
        if (this.a == -1) {
            this.b.drawLine(n2, n3, n4, n5);
        }
    }

    public final void a(String string, int n2, int n3, int n4) {
        if (this.a == -1) {
            this.b.drawString(string, n2, n3, n4);
        }
    }

    public final void b(int n2) {
        this.a = (n2 & 0xFF) << 24 | 0xFFFFFF;
    }

    public final int a() {
        return this.b.getClipX();
    }

    public final int b() {
        return this.b.getClipY();
    }

    public final int c() {
        return this.b.getClipWidth();
    }

    public final int d() {
        return this.b.getClipHeight();
    }

    public final void a(int n2, int n3, int n4, int n5, int n6, int n7) {
        this.b.fillTriangle(n2, n3, n4, n5, n6, n7);
    }
}

