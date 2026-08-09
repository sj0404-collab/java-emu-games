/*
 * Decompiled with CFR 0.152.
 */
package rpg;

import java.io.IOException;
import java.io.InputStream;
import rpg.a;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class c
implements rpg.b {
    private static c a = new c();
    public static cx a;
    public static cx b;
    public static cx c;
    public static cx d;
    public static bb a;
    public static at[] a;
    public static at a;
    public static cw[] a;
    public static cw[] b;
    public static cw[] c;
    public static cw[] d;
    public static cw[] e;
    public static cw[] f;
    public static cx e;
    public static cx f;
    public static cx g;
    public static cx h;
    public static cw a;
    public static cw b;
    public static cw c;
    public static cw d;
    public static cx i;
    public static cx j;
    public static cx k;
    private static String a;
    public static cw e;
    public static cw f;
    public static cw[] g;
    public static cw g;
    public static cw[] h;
    public static cw[] i;
    public static cw[] j;
    public static cw h;
    public static cw i;
    public static cw j;
    public static cw k;
    public static cw l;
    public static cw m;
    public static cw n;
    public static cw o;
    public static cw p;
    public static cw q;
    public static cw r;
    public static cw s;
    public static cw t;
    public static cw u;
    public static cw v;
    public static cw[] k;
    public static cw[] l;
    public static cw w;
    public static cw x;
    public static cw[] m;
    private static final byte[] a;

    public static c a() {
        return a;
    }

    public final void a() {
        dq dq2 = new dq("/img/sui");
        a = cw.a("/imgbox.png");
        b = dq2.a(0);
        k = dq2.a(1);
        c = dq2.a(2);
        d = dq2.a(3);
        if (q == null) {
            q = cw.a("/buttonBR.png");
        }
        if (r == null) {
            r = cw.a("/buttonLR.png");
        }
        rpg.a.c();
        i = new cx("/t/sm");
        rpg.a.c();
        a = at.a("/hero/hs", "/img/hs");
        rpg.a.c();
        e = cw.a("/title.png");
        rpg.a.c();
        if (h == null) {
            h = new cx("/t/nui");
        }
        dq2 = new dq("/img/gm");
        b = new cw[6];
        for (int i = 0; i < 6; ++i) {
            rpg.c.b[i] = dq2.a(i);
        }
        rpg.a.c();
    }

    public final bb a() {
        byte[] byArray = rpg.c.a("/hero/h" + r.b);
        bb bb2 = new bb();
        bb2.a(byArray, true);
        for (int i = 0; i <= 7; ++i) {
            rpg.c.a(bb2, i);
        }
        bb2.a();
        return bb2;
    }

    public final void b() {
        int n;
        dq dq2 = new dq("/img/em");
        a = dq2.a();
        dq2 = new dq("/img/gm");
        c = new cw[2];
        for (n = 0; n < 2; ++n) {
            rpg.c.c[n] = dq2.a(n + 6);
        }
        rpg.a.c();
        rpg.c.c();
        rpg.a.c();
        h = new cw[8];
        i = new cw[4];
        j = new cw[2];
        dq2 = new dq("/img/etc");
        g = dq2.a(0);
        for (n = 0; n < 4; ++n) {
            rpg.c.h[n] = dq2.a(n + 1);
            rpg.c.i[n] = cw.a("/miss" + n + ".png");
        }
        rpg.c.h[4] = cw.a("/yellowNum.png");
        rpg.c.h[5] = cw.a("/redNum.png");
        rpg.c.h[6] = cw.a("/yellowNumBig.png");
        rpg.c.h[7] = cw.a("/redNumBig.png");
        for (n = 0; n < 2; ++n) {
            rpg.c.j[n] = cw.a("/block" + n + ".png");
        }
        rpg.a.c();
        h = dq2.a(5);
        rpg.c.n = dq2.a(6);
        i = dq2.a(7);
        j = dq2.a(8);
        if (q == null) {
            q = cw.a("/buttonBR.png");
        }
        if (r == null) {
            r = cw.a("/buttonLR.png");
        }
        if (rpg.a.a >= 320) {
            l = cw.a("/_imgSkull.png");
        }
        m = dq2.a(9);
        o = cw.a("/ff.png");
        p = cw.a("/minimap1.png");
        rpg.a.c();
        dq2 = new dq("/img/si");
        g = dq2.a();
        rpg.a.c();
        a = new at();
        a.a("/hero/target", "/img/et");
        rpg.a.c();
        bo.g();
        j = new cx("/t/qm");
        k = new cx("/t/qs");
    }

    public static void c() {
        dq dq2 = new dq("/img/sk");
        f = dq2.a(r.b);
    }

    public final void d() {
        a = null;
        f = null;
        a = null;
        if (r.a != null) {
            ab.h();
        }
        b.a();
        c = null;
        c = null;
        f = null;
        n = null;
        o = null;
        g = null;
        h = null;
        i = null;
        h = null;
        i = null;
        j = null;
        m = null;
        if (k != null) {
            k = null;
        }
        if (l != null) {
            l = null;
        }
        if (q != null) {
            q = null;
        }
        if (r != null) {
            r = null;
        }
        g = null;
        r.g();
        j = null;
        k = null;
    }

    private static void h() {
        f = null;
        f = new cw[3];
    }

    public final void a(byte[] byArray) {
        if (f == null) {
            rpg.c.h();
        }
        for (int i = 0; i < 6; ++i) {
            int n;
            if (byArray[i] < 0 || (n = rpg.c.a(byArray[i])) < 0) continue;
            rpg.c.f[n] = cw.a("/img/face_" + n + ".png");
        }
    }

    public static int a(int n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 4) {
            return 0;
        }
        if (n <= 11) {
            return 1;
        }
        if (n <= 14) {
            return 2;
        }
        return -1;
    }

    public static void a(byte by, byte by2) {
        dq dq2 = new dq("/img/s");
        boolean bl = false;
        if (by >= 7 && by <= 17) {
            bl = true;
        }
        if (by2 >= 7 && by2 <= 17) {
            bl = true;
        }
        e = new cw[2];
        for (by = 0; by < 2; by = (byte)(by + 1)) {
            rpg.c.e[by] = dq2.a(by + (bl ? 2 : 0));
        }
    }

    public static void a(int n, int n2, byte[] byArray, byte[] byArray2, byte[] byArray3) {
        if (n2 < 0) {
            n2 += 256;
        }
        b.a((byte)n, (short)n2, byArray, byArray2, byArray3);
    }

    public static void e() {
        dv.a();
        b = new cx("/t/com");
        c = new cx("/t/m");
        d = new cx("/t/c");
        a = new cx("/t/lot");
    }

    public static void f() {
        int n;
        g = new cx("/t/it");
        rpg.a.c();
        e = new cx("/t/h");
        f = new cx("/t/a");
        rpg.a.c();
        dq dq2 = new dq("/img/glb");
        s = dq2.a(0);
        u = dq2.a(1);
        v = dq2.a(2);
        t = dq2.a(3);
        d = new cw[6];
        for (n = 0; n < 6; ++n) {
            rpg.c.d[n] = dq2.a(n + 4);
        }
        dq2 = new dq("/img/it");
        k = dq2.a();
        rpg.a.c();
        dq2 = new dq("/img/gt");
        cw[] cwArray = new cw[8];
        l = cwArray;
        cwArray[0] = rpg.c.a(rpg.b.x);
        rpg.c.l[1] = rpg.c.a(rpg.b.y);
        rpg.c.l[2] = rpg.c.a(rpg.b.z);
        rpg.c.l[3] = rpg.c.a(rpg.b.A);
        rpg.c.l[4] = rpg.c.a(rpg.b.B);
        rpg.c.l[5] = rpg.c.a(rpg.b.C);
        rpg.c.l[6] = rpg.c.a(rpg.b.D);
        rpg.c.l[7] = rpg.c.a(rpg.b.E);
        w = rpg.c.a(rpg.b.F);
        x = dq2.a(0);
        m = new cw[3];
        for (n = 0; n < 3; ++n) {
            rpg.c.m[n] = dq2.a(n + 1);
        }
    }

    private static cw a(byte[] byArray) {
        int n = dv.a(byArray) + 2;
        int n2 = dv.a + 2;
        int[] nArray = new int[n * n2];
        cw cw2 = cw.a(n, n2);
        cr cr2 = cw2.a();
        cr2.a(0xFFFFFF);
        cr2.a(0, 0, n, n2);
        cr2.a(0x3F1F3F);
        dv.a(cr2, 0, 0, n, byArray, 0, 0, byArray.length, 20);
        dv.a(cr2, 0, 1, n, byArray, 0, 0, byArray.length, 20);
        dv.a(cr2, 0, 2, n, byArray, 0, 0, byArray.length, 20);
        dv.a(cr2, 1, 0, n, byArray, 0, 0, byArray.length, 20);
        dv.a(cr2, 1, 2, n, byArray, 0, 0, byArray.length, 20);
        dv.a(cr2, 2, 0, n, byArray, 0, 0, byArray.length, 20);
        dv.a(cr2, 2, 1, n, byArray, 0, 0, byArray.length, 20);
        dv.a(cr2, 2, 2, n, byArray, 0, 0, byArray.length, 20);
        cr2.a(14597755);
        dv.a(cr2, 1, 1, n, byArray, 0, 0, byArray.length, 20);
        cw2.a(nArray, 0, n, 0, 0, n, n2);
        for (int i = n * n2 - 1; i >= 0; --i) {
            if (nArray[i] != -1) continue;
            nArray[i] = 0;
        }
        cw2 = cw.a(nArray, n, n2, true);
        return cw2;
    }

    public static void g() {
        byte[] byArray;
        bo.b();
        bo.f();
        rpg.c.h();
        int n = r.a;
        if (n < 0) {
            n += 256;
        }
        System.out.println("go to map : " + n);
        if (ab.a != null) {
            ab.a = null;
        }
        if (r.a != null) {
            r.a = null;
        }
        x x2 = r.a;
        x2.a(true);
        x2.a().a(true);
        ab.e();
        if (r.a != null) {
            r.a.d(x2);
            x2.b = null;
            x2.a = null;
            ab.h();
            r.a = null;
        }
        if (dt.a == null) {
            dt.a = null;
        }
        if (dt.a != null) {
            dt.a = null;
        }
        if (dt.b != null) {
            dt.b = null;
        }
        rpg.a.c();
        System.gc();
        Runtime.getRuntime().gc();
        if (n < 100) {
            byArray = rpg.c.a("/m/m/" + (n < 10 ? "0" : "") + n + ".m");
        } else {
            int n2 = n % 10;
            byte[] byArray2 = new byte[1];
            byte[] byArray3 = byArray2;
            byArray2[0] = 97;
            byArray3[0] = (byte)(byArray3[0] + ((n - n2) / 10 - 10));
            byArray = rpg.c.a("/m/m2/" + new String(byArray3) + n2 + ".m");
        }
        r.a = new ab(r.a);
        r.a.a(byArray);
        r.a.b();
        x2.o();
    }

    /*
     * Loose catch block
     */
    public static final byte[] a(String object) {
        InputStream inputStream;
        block21: {
            block22: {
                inputStream = null;
                inputStream = new Object().getClass().getResourceAsStream((String)object);
                if (inputStream != null) break block21;
                if (!ea.a((String)object)) break block22;
                bv bv2 = new bv((String)object, 1);
                Object object2 = bv2;
                Object object3 = object = (Object)new byte[bv2.a != null ? ((bv)object2).a.length - ((bv)object2).a : 0];
                object2 = bv2;
                try {
                    System.arraycopy(((bv)object2).a, ((bv)object2).a, object3, 0, ((Object)object3).length);
                    ((bv)object2).a += ((Object)object3).length;
                }
                catch (Exception exception) {
                    object2 = exception;
                    exception.printStackTrace();
                }
                v1.a = null;
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
                catch (Exception exception) {}
                return object;
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            catch (Exception exception) {}
            return null;
        }
        object = new byte[inputStream.available()];
        inputStream.read((byte[])object);
        Object object4 = object;
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        catch (Exception exception) {}
        return object4;
        catch (IOException iOException) {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            catch (Exception exception) {}
            return null;
        }
        catch (Throwable throwable) {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            catch (Exception exception) {}
            throw throwable;
        }
    }

    public static final byte[] a(String object, int n) {
        byte[] byArray = null;
        try {
            byte[] byArray2 = rpg.c.a((String)object);
            object = byArray2;
            byArray = rpg.c.a(byArray2, n);
        }
        catch (Exception exception) {}
        return byArray;
    }

    public static final byte[] a(byte[] byArray, int n) {
        short s;
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            s = rpg.f.b(byArray, n2);
            n2 += s + 2;
        }
        s = rpg.f.b(byArray, n2);
        byte[] byArray2 = new byte[s];
        System.arraycopy(byArray, n2 += 2, byArray2, 0, s);
        return byArray2;
    }

    public static final boolean a(byte[] byArray) {
        byte by = 0;
        int n = byArray.length - 1;
        for (int i = 0; i < n; ++i) {
            by = (byte)(by + byArray[i]);
        }
        return by == byArray[n];
    }

    public static final void a(int n) {
        a.a(a + n, a + "ed" + n);
    }

    public static void a(bb bb2, int n) {
        Object object = r.a;
        byte by = 0;
        byte by2 = 0;
        int n2 = -1;
        if ((object = ((x)object).a(a[n])) != null) {
            by = ((dg)object).g;
            by2 = ((bs)object).d;
            n2 = ((bs)object).a;
            if (by2 < 0) {
                by2 = 0;
            }
        }
        switch (n) {
            case 0: {
                object = "/hero/" + n + "/" + (by2 < 10 ? "0" : "") + by2;
                break;
            }
            case 1: 
            case 2: 
            case 3: {
                object = "/hero/" + n + "/" + (r.a() ? "" : "l") + (by2 < 10 ? "0" : "") + by2;
                break;
            }
            case 4: {
                object = "/hero/" + n + "/" + r.b;
                break;
            }
            case 5: {
                object = "/hero/eh";
                break;
            }
            case 6: 
            case 7: {
                if (object == null) {
                    bb2.a(n);
                    return;
                }
                object = "/hero/w/" + by + (by2 < 10 ? "0" : "") + by2;
                break;
            }
            default: {
                return;
            }
        }
        byte[] byArray = null;
        if (n2 >= 0) {
            byArray = rpg.c.a("/hero/h.p", n2);
        }
        bb2.a(n, (String)object, byArray);
    }

    public static void a(byte[] byArray, byte by, byte by2, byte[] byArray2) {
        byArray = rpg.c.a(byArray, (int)by);
        dt.a(byArray, by2, byArray2);
    }

    static {
        a = new at[11];
        h = null;
        a = "/img/ed/";
        q = null;
        r = null;
        a = new byte[]{1, 4, 0, 6, -1, -1, 3, 5};
    }
}
