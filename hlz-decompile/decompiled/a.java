/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.lcdui.Display
 *  javax.microedition.midlet.MIDlet
 */
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class a
implements Runnable {
    private static final String[] a = new String[]{"01", "06", "03", "03", "03", "15", "10", "10"};
    private static final byte[][] a;
    private static final byte[] a;
    private static final byte[][] b;
    private static int a;
    private boolean b;
    private String[] b;
    private String a;
    private String b;
    private static ag a;
    private int b = null;
    private String c;
    private String d = null;
    private static MIDlet a;
    public static boolean a;
    private boolean c = false;

    public a(MIDlet mIDlet) {
        a = mIDlet;
        a = new ag(a);
        this.b = ag.a();
        this.c = a.getAppProperty("EA-Porting-Test-SMS-Mode");
        if (this.c != null) {
            this.c = this.c.trim().length() <= 0 ? null : this.c.toLowerCase().trim();
        }
        this.d = a.getAppProperty("EA-Porting-Test-SMS-Phone");
        if (this.d != null) {
            if (this.d.trim().length() <= 0) {
                this.d = null;
                return;
            }
            this.d = this.d.toLowerCase().trim();
        }
    }

    public final byte[] a(int n) {
        byte[] byArray = new byte[2];
        byte[] byArray2 = byArray;
        byArray[0] = a[n];
        byArray2[1] = b[this.b][n];
        return byArray2;
    }

    public final boolean a(int n) {
        System.out.println("send pay : " + n);
        this.c = false;
        if (this.c != null) {
            return !this.c.equals("false");
        }
        this.b = null;
        a = a[this.b][n];
        this.a = a[n];
        if (this.b == 0) {
            a = a[1][n];
            a a2 = this;
            String string = ag.a();
            String string2 = ag.b();
            String string3 = ag.d();
            String string4 = ag.c();
            String string5 = ag.e();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" 146 ");
            stringBuffer.append("011 ");
            stringBuffer.append("Z600 ");
            stringBuffer.append(string + " ");
            stringBuffer.append(string2 + " ");
            stringBuffer.append(string3 + " ");
            stringBuffer.append(string4 + " ");
            stringBuffer.append(string5 + " ");
            stringBuffer.append(a2.a + " ");
            stringBuffer.append(0);
            stringBuffer.append(a + " ");
            stringBuffer.append("Z600");
            a2.b = stringBuffer.toString();
            this.b = ag.a(a[this.b][n]);
            this.b[0] = this.b[0] + this.b;
        } else if (this.b == 1) {
            this.b = a.a(a, Integer.parseInt("146"));
        }
        if (this.d != null) {
            this.b[1] = this.d;
        }
        this.b = false;
        a = false;
        new Thread(this).start();
        while (!a) {
            try {
                Canvas canvas = (Canvas)Display.getDisplay((MIDlet)a).getCurrent();
                canvas.repaint();
                canvas.serviceRepaints();
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedException) {
                InterruptedException interruptedException2 = interruptedException;
                interruptedException.printStackTrace();
            }
        }
        return this.b;
    }

    private boolean a(String[] stringArray) {
        return true;
    }

    public final void run() {
        this.b = this.a(this.b);
        a = true;
    }

    static {
        byte[][] byArrayArray = new byte[][]{{4, 2, 2, 2, 2, 1, 1, 1}, {1, 2, 3, 3, 3, 4, 5, 5}};
        a = byArrayArray;
        a = byArrayArray[0];
        b = new byte[][]{{2, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};
        a = 1;
        a = null;
        a = true;
    }
}
