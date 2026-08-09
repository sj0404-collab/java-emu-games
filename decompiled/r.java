/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import rpg.b;
import rpg.d;
import rpg.e;
import rpg.f;
import rpg.h;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class r
implements b {
    public static boolean a;
    public static boolean b;
    public static boolean c;
    public static boolean d;
    public static boolean e;
    public static byte[] a;
    public static boolean f;
    private static final byte[] Z;
    private static final byte[] aa;
    private static final boolean[] a;
    public static byte a;
    public static ab a;
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static boolean g;
    public static boolean h;
    public static boolean i;
    private static byte[] ab;
    private static byte[] ac;
    private static byte[] ad;
    private static bp a;
    private static bp b;
    private static bp c;
    public static int e;
    private static int[] c;
    public static int f;
    public static long a;
    public static long b;
    public static long[] a;
    private static byte[] ae;
    public static byte b;
    public static x a;
    public static an a;
    public static byte[] b;
    public static int[] a;
    public static int[] b;
    private static byte[] af;
    private static byte[] ag;
    static byte c;
    private static byte m;
    public static byte d;
    private static byte n;
    public static byte e;
    public static byte f;
    public static byte g;
    public static byte h;
    private static final byte[] ah;
    public static byte[][] a;
    public static byte i;
    public static byte j;
    public static byte k;
    public static long c;
    private static long d;
    public static byte l;

    static final synchronized void a(byte by2, byte by3, byte by4, byte by5) {
        e = by3;
        f = by4;
        g = by5;
        n = by2;
    }

    public static final synchronized void a(byte by2, byte by3, byte by4) {
        r.a((byte)3, by3, by4, (byte)0);
    }

    public static final synchronized void a(byte by2, byte by3) {
        r.a(by2, by3, (byte)0, (byte)0);
    }

    public static final synchronized void a(byte by2) {
        r.a(by2, (byte)0, (byte)0, (byte)0);
    }

    public static final void a() {
        if (n == 0) {
            return;
        }
        byte by2 = n;
        n = 0;
        block0 : switch (by2) {
            case 11: {
                bh.a().a((byte)2, false);
                return;
            }
            case 1: {
                bh.a().a((byte)4, false);
                return;
            }
            case 2: {
                a.a(a);
                a.c(!ab.c || ab.f);
                bh.h();
                a.a((short)(e << 4), (short)(f << 4));
                a.i(g);
                r.a((byte)0, (byte)0, (byte)0, (byte)0);
                a.a((byte)1);
                a.a();
                a.a_();
                a.c(a);
                r.c();
                c = a;
                d = b;
                rpg.e.a().f();
                bh.c = true;
                if (m.e()) {
                    r.a((byte)3, (byte)4, (byte)1);
                } else {
                    r.a((byte)3, (byte)3, (byte)1);
                }
                if (k == 0) break;
                k = 0;
                r.k();
                return;
            }
            case 3: {
                d = e;
                switch (f) {
                    case 0: {
                        rpg.e.a((int)g);
                        break block0;
                    }
                    case 1: {
                        rpg.e.a().f();
                        break block0;
                    }
                    case 2: {
                        rpg.e.a().g();
                        break block0;
                    }
                    case 3: {
                        rpg.e.a().h();
                    }
                }
                return;
            }
            case 6: {
                d = (byte)5;
                dj.a().b();
                dj.a().c(e);
                return;
            }
            case 7: {
                d = (byte)3;
                dj.a().c();
                switch (e) {
                    case 1: {
                        rpg.c.a().d();
                        bh.a().a((byte)2, false);
                        break block0;
                    }
                    case 2: {
                        r.b(ag[0], ag[1], ag[2], (byte)2);
                    }
                }
                return;
            }
            case 8: {
                int n2;
                by2 = e;
                if (by2 == 2) {
                    if (h < 2) {
                        h = (byte)(h + 1);
                    }
                    r.a((byte)19).a();
                    a.a((byte)0, a.e((byte)0));
                    a.a((byte)1, a.e((byte)1));
                    a.a((byte)3, a.e((byte)3));
                    r.a((int)af[0], (int)af[1], (int)af[2]);
                    r.n();
                } else {
                    r.f();
                    r.h();
                    d = rpg.f.a();
                }
                int n3 = by2 == 2 ? 1 : 0;
                int n4 = n3;
                int n5 = n3 != 0 ? 31 : 32;
                for (n2 = 0; n2 < n5; ++n2) {
                    r.ab[n2] = 0;
                }
                if (n4 != 0) {
                    for (n2 = n5 << 3; n2 < 250; ++n2) {
                        r.d(n2);
                    }
                }
                for (n4 = 0; n4 < 32; ++n4) {
                    r.ac[n4] = 0;
                }
                for (n4 = 0; n4 < 140; ++n4) {
                    r.ad[n4] = -1;
                }
                if (n3 == 0) {
                    for (n4 = 0; n4 < 10; ++n4) {
                        r.ah[n4] = 0;
                    }
                }
                n4 = 1;
                if (by2 == 0) {
                    c = 0L;
                    h = 0;
                    k = 0;
                    l = 1;
                    e = 0;
                    r.o();
                    a.n();
                    a.b(true);
                    r.n();
                    dg dg2 = dg.a((byte)20, (byte)1);
                    c.a(dg2, 1);
                } else if (by2 == 1) {
                    int n6;
                    if (!r.a(false)) {
                        n6 = 0;
                    } else {
                        a.l();
                        a.k();
                        n6 = n4 = 1;
                    }
                }
                if (n4 != 0) {
                    bh.a().a((byte)3, false);
                } else {
                    rpg.d.a();
                    ao.a().d = 0;
                    rpg.c.a().d();
                    bh.a().a((byte)2, false);
                    ao.a().b = new bi((ah)ao.a(), rpg.c.i.a(13), '\u0000');
                }
                rpg.d.b();
                return;
            }
            case 9: {
                bh.a().k = 0;
                r.c((byte)7);
            }
        }
    }

    public static final void a(int n2) {
        r.a((byte)8, (byte)n2);
    }

    public static final void b() {
        r.a((byte)3, (byte)2, (byte)3);
    }

    public static final void b(byte by2, byte by3, byte by4, byte by5) {
        a = by2;
        r.a((byte)1, by3, by4, by5);
    }

    public static final void c() {
        a = bh.i - ((c)r.a).a;
        b = bh.j - ((c)r.a).b;
    }

    public static final void a(boolean bl2, boolean bl3) {
        if (bl3) {
            byte by2 = r.a.q;
            if (bl2) {
                b -= Z[rpg.e.c] * rpg.b.T[by2];
                a -= Z[rpg.e.c] * rpg.b.S[by2];
            }
            if (!a[by2] && d != b) {
                d += (b - d + 1) / aa[rpg.e.c] - 1;
            }
            if (a[by2] && c != a) {
                c += (a - c + 1) / aa[rpg.e.c] - 1;
            }
            return;
        }
        c += (a - c + 1) / aa[rpg.e.c] - 1;
        d += (b - d + 1) / aa[rpg.e.c] - 1;
    }

    public static final void d() {
        if (c != 0 && !((c)r.a).a && !((c)r.a).b) {
            r.b(c, m);
            r.c((byte)0, (byte)0);
        }
        if (!ab.a()) {
            a.d();
            a.c(a);
            db.v();
            a.a(((c)r.a).c, ((c)r.a).d);
            a.f();
            a.d();
            if (!b && r.a.b == 11) {
                b = true;
                rpg.d.a();
                f = true;
                a = rpg.c.a.a(12);
            }
        }
    }

    public static final void b(byte by2) {
        switch (r.a.p) {
            case 1: {
                r.b((byte)2, by2);
                r.c((byte)0, (byte)0);
                return;
            }
            case 2: {
                if (r.c()) break;
                r.c((byte)2, by2);
                return;
            }
            case 3: 
            case 9: {
                a.c(by2);
            }
        }
    }

    public static final void e() {
        a.h();
        r.c((byte)1, r.a.q);
    }

    public static final void b(int n2) {
        if (!a.a_((byte)n2)) {
            return;
        }
        switch (r.a.p) {
            case 2: {
                r.c((byte)3, r.a.q);
                return;
            }
            case 1: {
                r.b((byte)3, a.a());
            }
        }
    }

    public static final void a(int n2, int n3, int n4) {
        r.ag[0] = (byte)n4;
        r.ag[1] = (byte)n2;
        r.ag[2] = (byte)n3;
    }

    private static void n() {
        r.c(rpg.h.b[0], rpg.h.b[1], rpg.h.b[2], rpg.h.b[3]);
    }

    private static void c(byte by2, byte by3, byte by4, byte by5) {
        a = by2;
        e = by3;
        f = by4;
        g = by5;
    }

    private static void o() {
        a = x.a(b);
    }

    public static final void b(byte by2, byte by3) {
        a.a(by2);
        a.i(by3);
    }

    public static final void c(byte by2, byte by3) {
        c = by2;
        m = by3;
    }

    public static final boolean a(int n2) {
        byte by2 = ab[n2 / 8];
        return (by2 >> n2 % 8 & 1) == 1;
    }

    public static final void c(int n2) {
        byte by2 = ab[n2 / 8];
        r.ab[n2 / 8] = (byte)(by2 | 1 << n2 % 8);
        if (n2 == 250 || n2 == 251) {
            switch (n2) {
                case 250: {
                    if (g) break;
                    g = true;
                    rpg.d.a();
                    return;
                }
                case 251: {
                    if (h) break;
                    h = true;
                    rpg.d.a();
                }
            }
        }
    }

    private static boolean c(int n2) {
        byte by2 = ah[n2 / 8];
        return (by2 >> n2 % 8 & 1) == 1;
    }

    public static final void d(int n2) {
        byte by2 = ab[n2 / 8];
        r.ab[n2 / 8] = (byte)(by2 & ~(1 << n2 % 8));
    }

    public static final byte a(int n2) {
        byte by2 = ac[n2 / 4];
        return (byte)(by2 >> (3 - n2 % 4 << 1) & 3);
    }

    public static final void a(int n2, byte by2) {
        byte by3 = (byte)(192 >> (n2 % 4 << 1));
        r.ac[n2 / 4] = (byte)(ac[n2 / 4] & ~by3);
        int n3 = n2 / 4;
        ac[n3] = (byte)(ac[n3] | (byte)(by2 << (3 - n2 % 4 << 1)));
        a.a();
        if (by2 == 2) {
            by2 = r.a.b;
            if (by2 < 0) {
                by2 = (byte)(by2 + 256);
            }
            System.out.println("*************************************");
            System.out.println("finished task " + n2 + " on map " + by2);
            System.out.println("*************************************");
            return;
        }
        if (by2 == 1) {
            by2 = r.a.b;
            if (by2 < 0) {
                by2 = (byte)(by2 + 256);
            }
            System.out.println("#####################################");
            System.out.println("received task " + n2 + " on map " + by2);
            System.out.println("#####################################");
        }
    }

    public static final void b(int n2, byte by2) {
        if (n2 < 0) {
            n2 += 256;
        }
        r.ad[n2] = by2;
    }

    public static final void c(int n2, byte by2) {
        if (ad[n2] < 0) {
            return;
        }
        int n3 = n2;
        ad[n3] = (byte)(ad[n3] - 1);
        if (ad[n2] == 0) {
            r.ad[n2] = -1;
            m.a(by2);
        }
    }

    public static final void c(byte by2) {
        d = by2;
        if (d == 3) {
            bh.c = true;
        }
    }

    public static void f() {
        a = new bp(28);
        b = new bp(28);
        c = new bp(28);
    }

    public static void g() {
        a = null;
        b = null;
        c = null;
    }

    public static bp a(byte by2) {
        switch (by2) {
            case 16: 
            case 18: {
                return b;
            }
            case 17: 
            case 19: 
            case 20: {
                return c;
            }
        }
        return a;
    }

    public static bp a() {
        return a;
    }

    public static bp b() {
        return c;
    }

    public static bp c() {
        return b;
    }

    public static final void e(int n2) {
        if ((e += n2) < 0) {
            e = 0;
        } else if (e > 999999999) {
            e = 999999999;
        }
        bh.c = true;
    }

    public static void h() {
        b = new byte[6];
        a = new int[6];
        b = new int[6];
        for (int i2 = 0; i2 < 6; ++i2) {
            r.b[i2] = -1;
            r.a[i2] = -1;
            r.b[i2] = -1;
        }
    }

    public static void a(boolean bl2, byte by2) {
        if (b[bl2 ? 5 : 4] == by2) {
            r.b[bl2 ? 5 : 4] = -1;
        }
        r.b[bl2 ? 4 : 5] = by2;
        bh.d = true;
    }

    public static dg a(boolean n2) {
        n2 = b[n2 != 0 ? 4 : 5];
        dg dg2 = null;
        if (n2 > 0) {
            dg2 = c.a((byte)20, (byte)n2);
        }
        return dg2;
    }

    public static void d(int n2, byte by2) {
        int n3 = r.d(n2) ? 0 : 2;
        for (int i2 = 0; i2 < 2; ++i2) {
            if (b[i2 + n3] != by2) continue;
            r.b[i2 + n3] = -1;
        }
        r.b[n2] = by2;
        r.f(n2);
        if (!r.d(n2)) {
            a.a().b(n2);
        }
    }

    private static boolean d(int n2) {
        return n2 < 2;
    }

    public static void a(byte by2, boolean bl2) {
        int n2 = bl2 ? 0 : 2;
        r.b[by2 + n2] = -1;
    }

    public static boolean a(byte by2, boolean bl2) {
        int n2 = bl2 ? 0 : 2;
        for (int i2 = 0; i2 < 2; ++i2) {
            if (b[i2 + n2] != by2) continue;
            return true;
        }
        return false;
    }

    public static boolean b(int n2) {
        return n2 == 0 || n2 == 1;
    }

    private static void f(int n2) {
        r.g(n2);
        r.a[n2] = b[n2];
    }

    public static void b(byte by2, boolean bl2) {
        int n2 = bl2 ? 0 : 2;
        for (int i2 = 0; i2 < 2; ++i2) {
            if (b[n2 + i2] != by2) continue;
            r.f(n2 + i2);
            return;
        }
    }

    private static void g(int n2) {
        byte by2 = b[n2];
        if (by2 < 0) {
            return;
        }
        int n3 = r.b[n2] = r.b(n2) ? a.b(by2) : a.a().d(by2);
        if (a[n2] > b[n2]) {
            r.a[n2] = b[n2];
        }
    }

    public static final void i() {
        r.a[4] = 10;
    }

    public static void j() {
        for (int i2 = 0; i2 < 6; ++i2) {
            r.g(i2);
        }
    }

    public static final boolean a() {
        return b % 2 == 0;
    }

    public static final boolean b() {
        return b == 1 || b == 3 || b == 2;
    }

    public static final void k() {
        long l2 = System.currentTimeMillis();
        r.a[r.j] = l2;
        a = l2;
        b = l2;
        byte by2 = j;
        rpg.d.c(r.a(by2), by2);
        byte[] byArray = r.a();
        byte[] byArray2 = a.a();
        byte[] byArray3 = a.a();
        byte[] byArray4 = a.a().a();
        byte[] byArray5 = new byte[13 + byArray.length + byArray2.length + byArray3.length + byArray4.length + 8];
        rpg.f.a(f, byArray5, 0);
        byArray5[4] = j;
        rpg.f.a(b, byArray5, 5);
        int n2 = r.a(byArray, byArray5, 13);
        n2 = r.a(byArray2, byArray5, n2);
        n2 = r.a(byArray3, byArray5, n2);
        r.a(byArray4, byArray5, n2);
        rpg.d.a(byArray5, j);
        r.l();
    }

    public static final boolean a(boolean bl2) {
        if (!r.b(j, bl2)) {
            return false;
        }
        if (!r.c(j)) {
            return false;
        }
        if (!bl2) {
            a.b(false);
        }
        return true;
    }

    /*
     * Loose catch block
     */
    private static final boolean b(byte by2, boolean bl2) {
        block34: {
            FilterInputStream filterInputStream;
            ByteArrayInputStream byteArrayInputStream;
            block35: {
                block33: {
                    block32: {
                        byte[] byArray = rpg.d.a(by2);
                        byteArrayInputStream = null;
                        filterInputStream = null;
                        byteArrayInputStream = new ByteArrayInputStream(byArray);
                        filterInputStream = new DataInputStream(byteArrayInputStream);
                        ((DataInputStream)filterInputStream).readInt();
                        byte by3 = ((DataInputStream)filterInputStream).readByte();
                        if (by2 == by3) break block32;
                        try {
                            filterInputStream.close();
                            byteArrayInputStream.close();
                        }
                        catch (Exception exception) {}
                        return false;
                    }
                    b = ((DataInputStream)filterInputStream).readLong();
                    if (!bl2) break block33;
                    try {
                        filterInputStream.close();
                        byteArrayInputStream.close();
                    }
                    catch (Exception exception) {}
                    return true;
                }
                short s2 = ((DataInputStream)filterInputStream).readShort();
                by2 = (byte)s2;
                byte[] byArray = new byte[s2];
                ((DataInputStream)filterInputStream).read(byArray);
                ByteArrayInputStream byteArrayInputStream2 = null;
                FilterInputStream filterInputStream2 = null;
                byteArrayInputStream2 = new ByteArrayInputStream(byArray);
                filterInputStream2 = new DataInputStream(byteArrayInputStream2);
                ((DataInputStream)filterInputStream2).read(ab);
                ((DataInputStream)filterInputStream2).read(ac);
                ((DataInputStream)filterInputStream2).read(ad);
                ((DataInputStream)filterInputStream2).read(ag);
                ((DataInputStream)filterInputStream2).read(b);
                ((DataInputStream)filterInputStream2).read(ah);
                l = ((DataInputStream)filterInputStream2).readByte();
                try {
                    filterInputStream2.close();
                    byteArrayInputStream2.close();
                }
                catch (Exception exception) {}
                break block35;
                catch (Exception exception) {
                    try {
                        if (filterInputStream2 != null) {
                            filterInputStream2.close();
                        }
                        if (byteArrayInputStream2 != null) {
                            byteArrayInputStream2.close();
                        }
                    }
                    catch (Exception exception2) {}
                }
                catch (Throwable throwable) {
                    try {
                        if (filterInputStream2 != null) {
                            filterInputStream2.close();
                        }
                        if (byteArrayInputStream2 != null) {
                            byteArrayInputStream2.close();
                        }
                    }
                    catch (Exception exception) {}
                    throw throwable;
                }
            }
            short s3 = ((DataInputStream)filterInputStream).readShort();
            byte[] byArray = new byte[s3];
            ((DataInputStream)filterInputStream).read(byArray);
            r.c(byArray[0], byArray[1], byArray[2], byArray[3]);
            r.o();
            short s4 = ((DataInputStream)filterInputStream).readShort();
            byte[] byArray2 = new byte[s4];
            ((DataInputStream)filterInputStream).read(byArray2);
            a.a(byArray2);
            short s5 = ((DataInputStream)filterInputStream).readShort();
            byte[] byArray3 = new byte[s5];
            ((DataInputStream)filterInputStream).read(byArray3);
            a.a().a(byArray3);
            try {
                filterInputStream.close();
                byteArrayInputStream.close();
            }
            catch (Exception exception) {}
            break block34;
            catch (Exception exception) {
                try {
                    if (filterInputStream != null) {
                        filterInputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    break block34;
                }
                catch (Exception exception3) {}
                break block34;
            }
            catch (Throwable throwable) {
                try {
                    if (filterInputStream != null) {
                        filterInputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                }
                catch (Exception exception) {}
                throw throwable;
            }
        }
        return true;
    }

    public static final void l() {
        byte[] byArray = a.a();
        byte[] byArray2 = b.a();
        byte[] byArray3 = c.a();
        byte[] byArray4 = new byte[8];
        rpg.f.a(e, byArray4, 0);
        byArray4[5] = byArray4[2];
        byArray4[6] = byArray4[3];
        byArray4[2] = (byte)(byArray4[5] | byArray4[6]);
        byArray4[3] = (byte)(byArray4[0] & byArray4[1]);
        byArray4[4] = (byte)(byArray4[0] | byArray4[5]);
        byArray4[7] = (byte)(byArray4[1] & byArray4[6]);
        byte[] byArray5 = new byte[13 + byArray.length + byArray2.length + byArray3.length + 6 + 8];
        rpg.f.a(f, byArray5, 0);
        byArray5[4] = j;
        rpg.f.a(a, byArray5, 5);
        int n2 = r.a(byArray, byArray5, 13);
        n2 = r.a(byArray2, byArray5, n2);
        n2 = r.a(byArray3, byArray5, n2);
        System.arraycopy(byArray4, 0, byArray5, n2, 8);
        rpg.d.b(byArray5, j);
    }

    private static int a(byte[] byArray, byte[] byArray2, int n2) {
        int n3 = byArray.length;
        rpg.f.a((short)n3, byArray2, n2);
        System.arraycopy(byArray, 0, byArray2, n2 += 2, n3);
        return n2 += n3;
    }

    /*
     * Loose catch block
     */
    private static boolean c(byte by2) {
        block19: {
            FilterInputStream filterInputStream;
            ByteArrayInputStream byteArrayInputStream;
            block18: {
                byte by3;
                block17: {
                    byte[] byArray = rpg.d.b(by2);
                    byteArrayInputStream = null;
                    filterInputStream = null;
                    byteArrayInputStream = new ByteArrayInputStream(byArray);
                    filterInputStream = new DataInputStream(byteArrayInputStream);
                    ((DataInputStream)filterInputStream).readInt();
                    by3 = ((DataInputStream)filterInputStream).readByte();
                    if (by2 == by3) break block17;
                    try {
                        filterInputStream.close();
                        byteArrayInputStream.close();
                    }
                    catch (Exception exception) {}
                    return false;
                }
                a = ((DataInputStream)filterInputStream).readLong();
                short s2 = ((DataInputStream)filterInputStream).readShort();
                by2 = (byte)s2;
                byte[] byArray = new byte[s2];
                ((DataInputStream)filterInputStream).read(byArray);
                a.a(byArray);
                short s3 = ((DataInputStream)filterInputStream).readShort();
                byte[] byArray2 = new byte[s3];
                ((DataInputStream)filterInputStream).read(byArray2);
                b.a(byArray2);
                short s4 = ((DataInputStream)filterInputStream).readShort();
                byte[] byArray3 = new byte[s4];
                ((DataInputStream)filterInputStream).read(byArray3);
                c.a(byArray3);
                byArray3 = new byte[8];
                ((DataInputStream)filterInputStream).read(byArray3);
                by3 = byArray3[2] != (byte)(byArray3[5] | byArray3[6]) ? (byte)1 : 0;
                by3 = by3 != 0 || byArray3[3] != (byte)(byArray3[0] & byArray3[1]) ? (byte)1 : 0;
                by3 = by3 != 0 || byArray3[4] != (byte)(byArray3[0] | byArray3[5]) ? (byte)1 : 0;
                if ((by3 = by3 != 0 || byArray3[7] != (byte)(byArray3[1] & byArray3[6]) ? (byte)1 : 0) == 0) {
                    byArray3[2] = byArray3[5];
                    byArray3[3] = byArray3[6];
                    e = rpg.f.a(byArray3, 0);
                    break block18;
                }
                e = 0;
            }
            try {
                filterInputStream.close();
                byteArrayInputStream.close();
            }
            catch (Exception exception) {}
            break block19;
            catch (Exception exception) {
                try {
                    if (filterInputStream != null) {
                        filterInputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    break block19;
                }
                catch (Exception exception2) {}
                break block19;
            }
            catch (Throwable throwable) {
                try {
                    if (filterInputStream != null) {
                        filterInputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                }
                catch (Exception exception) {}
                throw throwable;
            }
        }
        return true;
    }

    public static boolean a(byte by2) {
        return (k & by2) != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final byte[] a(byte by2) {
        byte[] byArray;
        int n2;
        int n3;
        int n4;
        for (n4 = 0; n4 <= 78; ++n4) {
            if (r.a(n4) != 2) continue;
            n3 = n4;
            byte by3 = ah[n3 / 8];
            r.ah[n3 / 8] = (byte)(by3 | 1 << n3 % 8);
        }
        n4 = 0;
        for (n2 = 11; n2 <= 40; ++n2) {
            if (!r.c(n2)) continue;
            n4 = (byte)(n4 + 1);
        }
        n4 = (byte)(n4 << 1);
        for (n2 = 0; n2 <= 10; ++n2) {
            if (!r.c(n2)) continue;
            n4 = (byte)(n4 + 1);
        }
        for (n2 = 50; n2 <= 78; ++n2) {
            if (!r.c(n2)) continue;
            n4 = (byte)(n4 + 1);
        }
        if (r.b((byte)4)) {
            n4 = (byte)(n4 + 1);
        }
        if (r.b((byte)5)) {
            n4 = (byte)(n4 + 1);
        }
        byte by3 = (byte)(n4 + h);
        n4 = by3;
        n3 = (byte)(by3 > 100 ? 100 : n4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)filterOutputStream).writeInt(f);
            ((DataOutputStream)filterOutputStream).writeByte(by2);
            ((DataOutputStream)filterOutputStream).writeLong(a[by2]);
            ((DataOutputStream)filterOutputStream).writeByte(b);
            ((DataOutputStream)filterOutputStream).writeByte(a.b());
            ((DataOutputStream)filterOutputStream).writeByte(n3);
            ((DataOutputStream)filterOutputStream).writeByte(h);
            ((DataOutputStream)filterOutputStream).writeByte(k);
            long l2 = rpg.f.a();
            c += l2 - d;
            d = rpg.f.a();
            ((DataOutputStream)filterOutputStream).writeLong(c);
            byArray = a.b();
            ((DataOutputStream)filterOutputStream).writeByte(byArray.length);
            ((OutputStream)filterOutputStream).write(byArray);
            byArray = byteArrayOutputStream.toByteArray();
        }
        catch (Exception exception) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) return null;
                byteArrayOutputStream.close();
                return null;
            }
            catch (Exception exception2) {
                return null;
            }
        }
        catch (Throwable throwable) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) throw throwable;
                byteArrayOutputStream.close();
                throw throwable;
            }
            catch (Exception exception) {}
            throw throwable;
        }
        try {
            filterOutputStream.close();
            byteArrayOutputStream.close();
            return byArray;
        }
        catch (Exception exception) {}
        return byArray;
    }

    public static final void m() {
        k = 0;
        i = 0;
        a = new byte[3][];
        c = new int[3];
        a = new long[3];
        ae = new byte[3];
        for (byte by2 = 0; by2 < 3; by2 = (byte)(by2 + 1)) {
            r.ae[by2] = by2;
            r.a[by2] = rpg.d.c(by2);
            if (a[by2] == null) continue;
            r.c[by2] = rpg.f.a(a[by2], 0);
            r.ae[by2] = a[by2][4];
            r.a[by2] = rpg.f.a(a[by2], 5);
            i = (byte)(i + 1);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final byte[] a() {
        byte[] byArray;
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((OutputStream)filterOutputStream).write(ab);
            ((OutputStream)filterOutputStream).write(ac);
            ((OutputStream)filterOutputStream).write(ad);
            ((OutputStream)filterOutputStream).write(ag);
            ((OutputStream)filterOutputStream).write(b);
            ((OutputStream)filterOutputStream).write(ah);
            ((DataOutputStream)filterOutputStream).writeByte(l);
            byArray = byteArrayOutputStream.toByteArray();
        }
        catch (Exception exception) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) return null;
                byteArrayOutputStream.close();
                return null;
            }
            catch (Exception exception2) {
                return null;
            }
        }
        catch (Throwable throwable) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) throw throwable;
                byteArrayOutputStream.close();
                throw throwable;
            }
            catch (Exception exception) {}
            throw throwable;
        }
        try {
            filterOutputStream.close();
            byteArrayOutputStream.close();
            return byArray;
        }
        catch (Exception exception) {}
        return byArray;
    }

    public static boolean c() {
        return c == 3 || c == 10;
    }

    public static boolean b(byte by2) {
        switch (by2) {
            case 4: {
                return g;
            }
            case 5: {
                return h;
            }
        }
        return true;
    }

    static {
        a = null;
        f = false;
        Z = new byte[]{0, 15, 30, 35};
        aa = new byte[]{1, 2, 3, 3};
        a = new boolean[]{false, false, false, true, true};
        g = true;
        h = true;
        i = true;
        ab = new byte[32];
        ac = new byte[32];
        ad = new byte[140];
        c = null;
        f = 0;
        a = 0L;
        b = 0L;
        a = null;
        ae = null;
        b = 1;
        a = null;
        af = new byte[]{0, 22, 26};
        ag = new byte[]{1, 20, 2};
        c = 0;
        m = 0;
        n = 0;
        ah = new byte[10];
        a = null;
        i = 0;
        j = 0;
        k = 0;
        c = 0L;
        d = 0L;
        l = 1;
    }
}

