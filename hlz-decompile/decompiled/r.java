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

    static final synchronized void a(byte by, byte by2, byte by3, byte by4) {
        e = by2;
        f = by3;
        g = by4;
        n = by;
    }

    public static final synchronized void a(byte by, byte by2, byte by3) {
        r.a((byte)3, by2, by3, (byte)0);
    }

    public static final synchronized void a(byte by, byte by2) {
        r.a(by, by2, (byte)0, (byte)0);
    }

    public static final synchronized void a(byte by) {
        r.a(by, (byte)0, (byte)0, (byte)0);
    }

    public static final void a() {
        if (n == 0) {
            return;
        }
        byte by = n;
        n = 0;
        block0 : switch (by) {
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
                int n;
                by = e;
                if (by == 2) {
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
                int n2 = by == 2 ? 1 : 0;
                int n3 = n2;
                int n4 = n2 != 0 ? 31 : 32;
                for (n = 0; n < n4; ++n) {
                    r.ab[n] = 0;
                }
                if (n3 != 0) {
                    for (n = n4 << 3; n < 250; ++n) {
                        r.d(n);
                    }
                }
                for (n3 = 0; n3 < 32; ++n3) {
                    r.ac[n3] = 0;
                }
                for (n3 = 0; n3 < 140; ++n3) {
                    r.ad[n3] = -1;
                }
                if (n2 == 0) {
                    for (n3 = 0; n3 < 10; ++n3) {
                        r.ah[n3] = 0;
                    }
                }
                n3 = 1;
                if (by == 0) {
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
                } else if (by == 1) {
                    int n5;
                    if (!r.a(false)) {
                        n5 = 0;
                    } else {
                        a.l();
                        a.k();
                        n5 = n3 = 1;
                    }
                }
                if (n3 != 0) {
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

    public static final void a(int n) {
        r.a((byte)8, (byte)n);
    }

    public static final void b() {
        r.a((byte)3, (byte)2, (byte)3);
    }

    public static final void b(byte by, byte by2, byte by3, byte by4) {
        a = by;
        r.a((byte)1, by2, by3, by4);
    }

    public static final void c() {
        a = bh.i - ((c)r.a).a;
        b = bh.j - ((c)r.a).b;
    }

    public static final void a(boolean bl, boolean bl2) {
        if (bl2) {
            byte by = r.a.q;
            if (bl) {
                b -= Z[rpg.e.c] * rpg.b.T[by];
                a -= Z[rpg.e.c] * rpg.b.S[by];
            }
            if (!a[by] && d != b) {
                d += (b - d + 1) / aa[rpg.e.c] - 1;
            }
            if (a[by] && c != a) {
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

    public static final void b(byte by) {
        switch (r.a.p) {
            case 1: {
                r.b((byte)2, by);
                r.c((byte)0, (byte)0);
                return;
            }
            case 2: {
                if (r.c()) break;
                r.c((byte)2, by);
                return;
            }
            case 3: 
            case 9: {
                a.c(by);
            }
        }
    }

    public static final void e() {
        a.h();
        r.c((byte)1, r.a.q);
    }

    public static final void b(int n) {
        if (!a.a_((byte)n)) {
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

    public static final void a(int n, int n2, int n3) {
        r.ag[0] = (byte)n3;
        r.ag[1] = (byte)n;
        r.ag[2] = (byte)n2;
    }

    private static void n() {
        r.c(rpg.h.b[0], rpg.h.b[1], rpg.h.b[2], rpg.h.b[3]);
    }

    private static void c(byte by, byte by2, byte by3, byte by4) {
        a = by;
        e = by2;
        f = by3;
        g = by4;
    }

    private static void o() {
        a = x.a(b);
    }

    public static final void b(byte by, byte by2) {
        a.a(by);
        a.i(by2);
    }

    public static final void c(byte by, byte by2) {
        c = by;
        m = by2;
    }

    public static final boolean a(int n) {
        byte by = ab[n / 8];
        return (by >> n % 8 & 1) == 1;
    }

    public static final void c(int n) {
        byte by = ab[n / 8];
        r.ab[n / 8] = (byte)(by | 1 << n % 8);
        if (n == 250 || n == 251) {
            switch (n) {
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

    private static boolean c(int n) {
        byte by = ah[n / 8];
        return (by >> n % 8 & 1) == 1;
    }

    public static final void d(int n) {
        byte by = ab[n / 8];
        r.ab[n / 8] = (byte)(by & ~(1 << n % 8));
    }

    public static final byte a(int n) {
        byte by = ac[n / 4];
        return (byte)(by >> (3 - n % 4 << 1) & 3);
    }

    public static final void a(int n, byte by) {
        byte by2 = (byte)(192 >> (n % 4 << 1));
        r.ac[n / 4] = (byte)(ac[n / 4] & ~by2);
        int n2 = n / 4;
        ac[n2] = (byte)(ac[n2] | (byte)(by << (3 - n % 4 << 1)));
        a.a();
        if (by == 2) {
            by = r.a.b;
            if (by < 0) {
                by = (byte)(by + 256);
            }
            System.out.println("*************************************");
            System.out.println("finished task " + n + " on map " + by);
            System.out.println("*************************************");
            return;
        }
        if (by == 1) {
            by = r.a.b;
            if (by < 0) {
                by = (byte)(by + 256);
            }
            System.out.println("#####################################");
            System.out.println("received task " + n + " on map " + by);
            System.out.println("#####################################");
        }
    }

    public static final void b(int n, byte by) {
        if (n < 0) {
            n += 256;
        }
        r.ad[n] = by;
    }

    public static final void c(int n, byte by) {
        if (ad[n] < 0) {
            return;
        }
        int n2 = n;
        ad[n2] = (byte)(ad[n2] - 1);
        if (ad[n] == 0) {
            r.ad[n] = -1;
            m.a(by);
        }
    }

    public static final void c(byte by) {
        d = by;
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

    public static bp a(byte by) {
        switch (by) {
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

    public static final void e(int n) {
        if ((e += n) < 0) {
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
        for (int i = 0; i < 6; ++i) {
            r.b[i] = -1;
            r.a[i] = -1;
            r.b[i] = -1;
        }
    }

    public static void a(boolean bl, byte by) {
        if (b[bl ? 5 : 4] == by) {
            r.b[bl ? 5 : 4] = -1;
        }
        r.b[bl ? 4 : 5] = by;
        bh.d = true;
    }

    public static dg a(boolean n) {
        n = b[n != 0 ? 4 : 5];
        dg dg2 = null;
        if (n > 0) {
            dg2 = c.a((byte)20, (byte)n);
        }
        return dg2;
    }

    public static void d(int n, byte by) {
        int n2 = r.d(n) ? 0 : 2;
        for (int i = 0; i < 2; ++i) {
            if (b[i + n2] != by) continue;
            r.b[i + n2] = -1;
        }
        r.b[n] = by;
        r.f(n);
        if (!r.d(n)) {
            a.a().b(n);
        }
    }

    private static boolean d(int n) {
        return n < 2;
    }

    public static void a(byte by, boolean bl) {
        int n = bl ? 0 : 2;
        r.b[by + n] = -1;
    }

    public static boolean a(byte by, boolean bl) {
        int n = bl ? 0 : 2;
        for (int i = 0; i < 2; ++i) {
            if (b[i + n] != by) continue;
            return true;
        }
        return false;
    }

    public static boolean b(int n) {
        return n == 0 || n == 1;
    }

    private static void f(int n) {
        r.g(n);
        r.a[n] = b[n];
    }

    public static void b(byte by, boolean bl) {
        int n = bl ? 0 : 2;
        for (int i = 0; i < 2; ++i) {
            if (b[n + i] != by) continue;
            r.f(n + i);
            return;
        }
    }

    private static void g(int n) {
        byte by = b[n];
        if (by < 0) {
            return;
        }
        int n2 = r.b[n] = r.b(n) ? a.b(by) : a.a().d(by);
        if (a[n] > b[n]) {
            r.a[n] = b[n];
        }
    }

    public static final void i() {
        r.a[4] = 10;
    }

    public static void j() {
        for (int i = 0; i < 6; ++i) {
            r.g(i);
        }
    }

    public static final boolean a() {
        return b % 2 == 0;
    }

    public static final boolean b() {
        return b == 1 || b == 3 || b == 2;
    }

    public static final void k() {
        long l = System.currentTimeMillis();
        r.a[r.j] = l;
        a = l;
        b = l;
        byte by = j;
        rpg.d.c(r.a(by), by);
        byte[] byArray = r.a();
        byte[] byArray2 = a.a();
        byte[] byArray3 = a.a();
        byte[] byArray4 = a.a().a();
        byte[] byArray5 = new byte[13 + byArray.length + byArray2.length + byArray3.length + byArray4.length + 8];
        rpg.f.a(f, byArray5, 0);
        byArray5[4] = j;
        rpg.f.a(b, byArray5, 5);
        int n = r.a(byArray, byArray5, 13);
        n = r.a(byArray2, byArray5, n);
        n = r.a(byArray3, byArray5, n);
        r.a(byArray4, byArray5, n);
        rpg.d.a(byArray5, j);
        r.l();
    }

    public static final boolean a(boolean bl) {
        if (!r.b(j, bl)) {
            return false;
        }
        if (!r.c(j)) {
            return false;
        }
        if (!bl) {
            a.b(false);
        }
        return true;
    }

    /*
     * Loose catch block
     */
    private static final boolean b(byte by, boolean bl) {
        block34: {
            FilterInputStream filterInputStream;
            ByteArrayInputStream byteArrayInputStream;
            block35: {
                block33: {
                    block32: {
                        byte[] byArray = rpg.d.a(by);
                        byteArrayInputStream = null;
                        filterInputStream = null;
                        byteArrayInputStream = new ByteArrayInputStream(byArray);
                        filterInputStream = new DataInputStream(byteArrayInputStream);
                        ((DataInputStream)filterInputStream).readInt();
                        byte by2 = ((DataInputStream)filterInputStream).readByte();
                        if (by == by2) break block32;
                        try {
                            filterInputStream.close();
                            byteArrayInputStream.close();
                        }
                        catch (Exception exception) {}
                        return false;
                    }
                    b = ((DataInputStream)filterInputStream).readLong();
                    if (!bl) break block33;
                    try {
                        filterInputStream.close();
                        byteArrayInputStream.close();
                    }
                    catch (Exception exception) {}
                    return true;
                }
                short s = ((DataInputStream)filterInputStream).readShort();
                by = (byte)s;
                byte[] byArray = new byte[s];
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
            short s = ((DataInputStream)filterInputStream).readShort();
            byte[] byArray = new byte[s];
            ((DataInputStream)filterInputStream).read(byArray);
            r.c(byArray[0], byArray[1], byArray[2], byArray[3]);
            r.o();
            short s2 = ((DataInputStream)filterInputStream).readShort();
            byte[] byArray2 = new byte[s2];
            ((DataInputStream)filterInputStream).read(byArray2);
            a.a(byArray2);
            short s3 = ((DataInputStream)filterInputStream).readShort();
            byte[] byArray3 = new byte[s3];
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
        int n = r.a(byArray, byArray5, 13);
        n = r.a(byArray2, byArray5, n);
        n = r.a(byArray3, byArray5, n);
        System.arraycopy(byArray4, 0, byArray5, n, 8);
        rpg.d.b(byArray5, j);
    }

    private static int a(byte[] byArray, byte[] byArray2, int n) {
        int n2 = byArray.length;
        rpg.f.a((short)n2, byArray2, n);
        System.arraycopy(byArray, 0, byArray2, n += 2, n2);
        return n += n2;
    }

    /*
     * Loose catch block
     */
    private static boolean c(byte by) {
        block19: {
            FilterInputStream filterInputStream;
            ByteArrayInputStream byteArrayInputStream;
            block18: {
                byte by2;
                block17: {
                    byte[] byArray = rpg.d.b(by);
                    byteArrayInputStream = null;
                    filterInputStream = null;
                    byteArrayInputStream = new ByteArrayInputStream(byArray);
                    filterInputStream = new DataInputStream(byteArrayInputStream);
                    ((DataInputStream)filterInputStream).readInt();
                    by2 = ((DataInputStream)filterInputStream).readByte();
                    if (by == by2) break block17;
                    try {
                        filterInputStream.close();
                        byteArrayInputStream.close();
                    }
                    catch (Exception exception) {}
                    return false;
                }
                a = ((DataInputStream)filterInputStream).readLong();
                short s = ((DataInputStream)filterInputStream).readShort();
                by = (byte)s;
                byte[] byArray = new byte[s];
                ((DataInputStream)filterInputStream).read(byArray);
                a.a(byArray);
                short s2 = ((DataInputStream)filterInputStream).readShort();
                byte[] byArray2 = new byte[s2];
                ((DataInputStream)filterInputStream).read(byArray2);
                b.a(byArray2);
                short s3 = ((DataInputStream)filterInputStream).readShort();
                byte[] byArray3 = new byte[s3];
                ((DataInputStream)filterInputStream).read(byArray3);
                c.a(byArray3);
                byArray3 = new byte[8];
                ((DataInputStream)filterInputStream).read(byArray3);
                by2 = byArray3[2] != (byte)(byArray3[5] | byArray3[6]) ? (byte)1 : 0;
                by2 = by2 != 0 || byArray3[3] != (byte)(byArray3[0] & byArray3[1]) ? (byte)1 : 0;
                by2 = by2 != 0 || byArray3[4] != (byte)(byArray3[0] | byArray3[5]) ? (byte)1 : 0;
                if ((by2 = by2 != 0 || byArray3[7] != (byte)(byArray3[1] & byArray3[6]) ? (byte)1 : 0) == 0) {
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

    public static boolean a(byte by) {
        return (k & by) != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final byte[] a(byte by) {
        byte[] byArray;
        int n;
        int n2;
        int n3;
        for (n3 = 0; n3 <= 78; ++n3) {
            if (r.a(n3) != 2) continue;
            n2 = n3;
            byte by2 = ah[n2 / 8];
            r.ah[n2 / 8] = (byte)(by2 | 1 << n2 % 8);
        }
        n3 = 0;
        for (n = 11; n <= 40; ++n) {
            if (!r.c(n)) continue;
            n3 = (byte)(n3 + 1);
        }
        n3 = (byte)(n3 << 1);
        for (n = 0; n <= 10; ++n) {
            if (!r.c(n)) continue;
            n3 = (byte)(n3 + 1);
        }
        for (n = 50; n <= 78; ++n) {
            if (!r.c(n)) continue;
            n3 = (byte)(n3 + 1);
        }
        if (r.b((byte)4)) {
            n3 = (byte)(n3 + 1);
        }
        if (r.b((byte)5)) {
            n3 = (byte)(n3 + 1);
        }
        byte by2 = (byte)(n3 + h);
        n3 = by2;
        n2 = (byte)(by2 > 100 ? 100 : n3);
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)filterOutputStream).writeInt(f);
            ((DataOutputStream)filterOutputStream).writeByte(by);
            ((DataOutputStream)filterOutputStream).writeLong(a[by]);
            ((DataOutputStream)filterOutputStream).writeByte(b);
            ((DataOutputStream)filterOutputStream).writeByte(a.b());
            ((DataOutputStream)filterOutputStream).writeByte(n2);
            ((DataOutputStream)filterOutputStream).writeByte(h);
            ((DataOutputStream)filterOutputStream).writeByte(k);
            long l = rpg.f.a();
            c += l - d;
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
        for (byte by = 0; by < 3; by = (byte)(by + 1)) {
            r.ae[by] = by;
            r.a[by] = rpg.d.c(by);
            if (a[by] == null) continue;
            r.c[by] = rpg.f.a(a[by], 0);
            r.ae[by] = a[by][4];
            r.a[by] = rpg.f.a(a[by], 5);
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

    public static boolean b(byte by) {
        switch (by) {
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
