/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import rpg.c;
import rpg.d;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class n
extends aw
implements Runnable {
    public static String a = null;
    protected static boolean a = false;
    protected static int b = 0;
    protected static bp[] a = null;
    protected boolean b = true;
    protected static byte[] a = null;
    protected static byte[] b = null;

    public n(ah ah2, byte by) {
        super(ah2, by);
    }

    protected final void b() {
        long l = System.currentTimeMillis();
        r.a[r.j] = l;
        r.a = l;
        r.b = l;
        r.l();
    }

    public n(ah ah2, byte by, byte by2, byte by3) {
        super(ah2, by, by2, by3);
    }

    public final void run() {
        n.d();
        r.m();
    }

    protected final void a(byte[] byArray, boolean bl, boolean bl2) {
        if (bl) {
            this.g();
            ((ah)this).b = new bi((ah)this, rpg.c.h.a(4));
        }
    }

    public final void c() {
        byte[] byArray = af.a((byte)30, null);
        this.a(byArray, true, false);
    }

    protected static void d() {
        int n2;
        byte[] byArray = rpg.d.b();
        if (byArray == null) {
            byArray = new byte[6];
            b = 0;
            rpg.f.a(0, byArray, 0);
            byArray[4] = 84;
            byArray[5] = 0;
            rpg.d.b(byArray);
        }
        int n3 = 0;
        b = rpg.f.a(byArray, 0);
        n3 += 4;
        ++n3;
        int n4 = byArray[4];
        int n5 = (n4 - 1) / 28 + 1;
        if (n5 <= 0) {
            n5 = 1;
        }
        a = new bp[n5];
        n5 = 0;
        while (n4 > 0) {
            n2 = Math.min(28, n4);
            n4 -= n2;
            n.a[n5++] = new bp((byte)n2);
        }
        ++n3;
        n2 = byArray[5];
        n5 = 0;
        for (int i = 0; i < n2; ++i) {
            n4 = byArray[n3++];
            byte[] byArray2 = new byte[n4];
            System.arraycopy(byArray, n3, byArray2, 0, n4);
            n3 += n4;
            dg dg2 = dg.a(byArray2);
            if (dg2 == null) continue;
            a[n5].a(dg2, (int)dg2.i);
            if (a[n5].a() < n.a[n5].a) continue;
            ++n5;
        }
    }

    protected static void e() {
        try {
            int n2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(b);
            dataOutputStream.writeByte(84);
            int n3 = 0;
            for (n2 = 0; n2 < 3; ++n2) {
                n3 += a[n2].a();
            }
            dataOutputStream.writeByte(n3);
            for (n2 = 0; n2 < 3; ++n2) {
                n3 = a[n2].a();
                for (int i = 0; i < n3; ++i) {
                    Object object = a[n2].a(i);
                    if (object == null) continue;
                    object = dg.a((dg)object);
                    dataOutputStream.writeByte(((Object)object).length);
                    ((OutputStream)dataOutputStream).write((byte[])object);
                }
            }
            rpg.d.b(byteArrayOutputStream.toByteArray());
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public static final void f() {
        if (af.a()) {
            af.a(false);
        }
        r.g();
        a = null;
        bo.e();
    }

    protected void b(cr cr2) {
    }
}
