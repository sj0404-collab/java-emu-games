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

    public final void a(cw cw2, int n, int n2, int n3) {
        try {
            if (this.a == -1) {
                if ((n3 & 0x20) != 0) {
                    n2 -= cw2.b();
                } else if ((n3 & 2) != 0) {
                    n2 -= cw2.b() >> 1;
                }
                if ((n3 & 8) != 0) {
                    n -= cw2.a();
                } else if ((n3 & 1) != 0) {
                    n -= cw2.a() >> 1;
                }
            } else {
                int n4 = cw2.a().getWidth();
                int n5 = cw2.a().getHeight();
                int[] nArray = new int[n4 * n5];
                cw2.a().getRGB(nArray, 0, n4, 0, 0, n4, n5);
                for (int i = nArray.length - 1; i >= 0; --i) {
                    if (nArray[i] >>> 24 == 0) continue;
                    int n6 = i;
                    nArray[n6] = nArray[n6] & this.a;
                }
                Image image = Image.createRGBImage((int[])nArray, (int)n4, (int)n5, (boolean)true);
                this.b.drawImage(image, n, n2, n3);
                return;
            }
            this.b.drawImage(cw2.a(), n, n2, 20);
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
    }

    public final void a(int n) {
        this.b.setColor(n);
        this.b = n;
    }

    public final void a(int n, int n2, int n3) {
        this.b.setColor(n, n2, n3);
        this.b = (n & 0xFF) << 16 | (n2 & 0xFF) << 8 | n3 & 0xFF;
    }

    public final void a(int n, int n2, int n3, int n4) {
        if (this.a == -1) {
            this.b.fillRect(n, n2, n3, n4);
            return;
        }
        int[] nArray = new int[n3 * n4];
        int n5 = (this.b | 0xFF000000) & this.a;
        for (int i = nArray.length - 1; i >= 0; --i) {
            nArray[i] = n5;
        }
        this.b.drawRGB(nArray, 0, n3, n, n2, n3, n4, true);
    }

    public final void b(int n, int n2, int n3, int n4) {
        this.b.setClip(n, n2, n3, n4);
    }

    public final void c(int n, int n2, int n3, int n4) {
        this.b.clipRect(n, n2, n3, n4);
    }

    public final void d(int n, int n2, int n3, int n4) {
        if (this.a == -1) {
            this.b.drawRect(n, n2, n3, n4);
        }
    }

    public final void e(int n, int n2, int n3, int n4) {
        if (this.a == -1) {
            this.b.drawLine(n, n2, n3, n4);
        }
    }

    public final void a(String string, int n, int n2, int n3) {
        if (this.a == -1) {
            this.b.drawString(string, n, n2, n3);
        }
    }

    public final void b(int n) {
        this.a = (n & 0xFF) << 24 | 0xFFFFFF;
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

    public final void a(int n, int n2, int n3, int n4, int n5, int n6) {
        this.b.fillTriangle(n, n2, n3, n4, n5, n6);
    }
}
