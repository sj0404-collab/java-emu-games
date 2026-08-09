/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.util.Vector;
import rpg.a;
import rpg.e;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ab
implements rpg.b {
    private byte[] b;
    byte[] a;
    private byte[] Z = new byte[2];
    private cw[] a;
    private int f;
    public byte a;
    private c a;
    private c b;
    private c c;
    private c d;
    private final byte[] aa;
    c[][] a;
    public f[] a;
    public f[] b;
    public f[] c;
    br[] a;
    private Vector a;
    public byte b;
    private byte[][] a;
    private byte[] ab;
    static int a;
    public static byte c;
    public static byte d;
    public short a = (byte)-1;
    public short b;
    int b;
    int c;
    private static int g;
    public static boolean a;
    public static boolean b;
    private static byte e;
    private cw[] b;
    private static int[] a;
    public static boolean c;
    public boolean d;
    public boolean e;
    public static boolean f;
    private static boolean g;
    private cw[] c;
    private byte[] ac;
    private static cw b;
    public static cw a;
    private int h = -1;
    private int i = -1;
    private static byte[][] j;
    public int d = false;
    public int e = true;
    private Vector b;
    private static byte f;
    private static final int[] b;

    public static void a(int n, int n2) {
        if (b == null) {
            b = cw.a("/chest_opened.png");
        }
        int n3 = b.a() / 2;
        int n4 = b.b();
        rpg.a.a.a(b, n - n3, n2 - n4, 0);
    }

    public ab(byte by) {
        this.aa = new byte[]{33, 55, 49, 13, 20};
        this.b = new cw[3];
        this.b = new Vector();
        this.c(-1);
        this.b = by;
        c = false;
        this.d = false;
        this.e = true;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        e = (byte)-1;
        ab ab2 = this;
        this.a = null;
        ab2.a = new Vector(3);
        this.a();
    }

    public final int a(int n, int n2) {
        for (int i = 0; i < j.length; ++i) {
            if (this.b == j[i][0]) {
                for (int j = 1; j < ab.j[i].length; j += 3) {
                    if (n != ab.j[i][j] || n2 != ab.j[i][j + 1]) continue;
                    return ab.j[i][j + 2];
                }
                continue;
            }
            if (this.b < j[i][0]) break;
        }
        if (this.b == 89) {
            if (n == 16 && n2 == 10) {
                return 19;
            }
        } else if (this.b == 90) {
            if (n == 9 && n2 == 16) {
                return 20;
            }
        } else if (this.b == 92 && n == 10 && n2 == 13) {
            return 21;
        }
        return -1;
    }

    public final void a() {
        try {
            byte by;
            int n;
            boolean bl = false;
            int n2 = this.b;
            if (n2 < 0) {
                n2 += 256;
            }
            Object object = "/mmi/" + n2;
            object = new DataInputStream(object.getClass().getResourceAsStream((String)object));
            byte[] byArray = new byte[((FilterInputStream)object).available()];
            ((DataInputStream)object).read(byArray);
            ((FilterInputStream)object).close();
            for (n = 35; n > 0 && (by = r.a(n)) != 1; --n) {
                if (by != 2) continue;
                if (j.a) {
                    n = 10;
                    bl = true;
                    break;
                }
                n = 0;
                break;
            }
            if (n < 36 && n > 0) {
                if (bl && this.b == 8) {
                    this.h = 0;
                    this.i = 0;
                } else if (bl && this.b == 10) {
                    this.h = 5;
                    this.i = 10;
                } else {
                    this.h = byArray[--n << 1];
                    this.i = byArray[(n << 1) + 1];
                    if (this.h != -1 || this.i != -1) {
                        if (this.h < 0) {
                            this.h += 256;
                        }
                        if (this.i < 0) {
                            this.i += 256;
                        }
                    }
                }
            }
            System.out.println("taskX = " + this.h + " , taskY = " + this.i);
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public final void a(c c2) {
        this.f(c2);
        this.c(c2);
    }

    public final void b(c c2) {
        this.g(c2);
        this.h(c2);
    }

    private final void f(c c2) {
        c2.a = this.b;
        c2.b = null;
        if (this.b != null) {
            this.b.b = c2;
        }
        this.b = c2;
        if (this.a == null) {
            this.a = this.b;
        }
    }

    private final void g(c c2) {
        c2.a = this.d;
        c2.b = null;
        if (this.d != null) {
            this.d.b = c2;
        }
        this.d = c2;
        if (this.c == null) {
            this.c = this.d;
        }
    }

    public final void c(c b2) {
        if (b2.a != null && b2.b + b2.b < b2.a.b + b2.a.b) {
            b2.a.b = b2.b;
            if (b2.b == null) {
                this.b = b2.a;
            } else {
                b2.b.a = b2.a;
            }
            c c2 = b2.a;
            while (c2 != null && b2.b + b2.b < c2.b + c2.b) {
                c2 = c2.a;
            }
            if (c2 == null) {
                c2 = b2;
                b2 = this;
                c2.b = ((ab)b2).a;
                c2.a = null;
                if (((ab)b2).a != null) {
                    ((ab)b2).a.a = c2;
                }
                ((ab)b2).a = c2;
                if (((ab)b2).b == null) {
                    ((ab)b2).b = ((ab)b2).a;
                }
                return;
            }
            c2.b.a = b2;
            b2.b = c2.b;
            c2.b = b2;
            b2.a = c2;
            return;
        }
        if (b2.b != null && b2.b + b2.b > b2.b.b + b2.b.b) {
            b2.d = true;
            b2.b.a = b2.a;
            if (b2.a == null) {
                this.a = b2.b;
            } else {
                b2.a.b = b2.b;
            }
            c c3 = b2.b;
            while (c3 != null && b2.b + b2.b > c3.b + c3.b) {
                c3 = c3.b;
            }
            if (c3 == null) {
                this.f((c)b2);
                return;
            }
            c3.a.b = b2;
            b2.a = c3.a;
            c3.a = b2;
            b2.b = c3;
        }
    }

    private void h(c b2) {
        if (b2.a != null && b2.b + b2.b < b2.a.b + b2.a.b) {
            b2.a.b = b2.b;
            if (b2.b == null) {
                this.d = b2.a;
            } else {
                b2.b.a = b2.a;
            }
            c c2 = b2.a;
            while (c2 != null && b2.b + b2.b < c2.b + c2.b) {
                c2 = c2.a;
            }
            if (c2 == null) {
                c2 = b2;
                b2 = this;
                c2.b = ((ab)b2).c;
                c2.a = null;
                if (((ab)b2).c != null) {
                    ((ab)b2).c.a = c2;
                }
                ((ab)b2).c = c2;
                if (((ab)b2).d == null) {
                    ((ab)b2).d = ((ab)b2).c;
                }
                return;
            }
            c2.b.a = b2;
            b2.b = c2.b;
            c2.b = b2;
            b2.a = c2;
            return;
        }
        if (b2.b != null && b2.b + b2.b > b2.b.b + b2.b.b) {
            b2.d = true;
            b2.b.a = b2.a;
            if (b2.a == null) {
                this.c = b2.b;
            } else {
                b2.a.b = b2.b;
            }
            c c3 = b2.b;
            while (c3 != null && b2.b + b2.b > c3.b + c3.b) {
                c3 = c3.b;
            }
            if (c3 == null) {
                this.g((c)b2);
                return;
            }
            c3.a.b = b2;
            b2.a = c3.a;
            c3.a = b2;
            b2.b = c3;
        }
    }

    public final byte a(int n, int n2) {
        if (n < 0 || n2 < 0 || n >= c || n2 >= d) {
            return 0;
        }
        byte by = (byte)(this.a[n2 * c + n] & 0x3F);
        n = by;
        if (by <= 0) {
            return -1;
        }
        return (byte)n;
    }

    public static boolean a(int n, int n2) {
        return n < 0 || n2 < 0 || n >= c || n2 >= d;
    }

    public final void a(byte[] byArray) {
        byte by;
        byte by2;
        int n;
        int n2;
        int n3;
        byte by3;
        byte by4;
        int n4;
        int n5;
        f = false;
        g = false;
        m.a();
        int n6 = 0;
        byte[] byArray2 = new byte[]{-1, -1};
        if (this.ab != null) {
            System.arraycopy(this.ab, 0, byArray2, 0, 2);
        }
        ++n6;
        this.a = byArray[0];
        if (this.ab == null) {
            this.ab = new byte[2];
        }
        ++n6;
        this.ab[0] = byArray[1];
        ++n6;
        this.ab[1] = byArray[2];
        rpg.a.c();
        this.a = new byte[2][];
        for (int i = 0; i < 2; ++i) {
            byte by7;
            if ((by7 = byArray[n6++]) <= 0) continue;
            this.a[i] = new byte[by7];
            System.arraycopy(byArray, n6, this.a[i], 0, by7);
            n6 += by7;
        }
        Object object = null;
        int by8 = byArray[n6++];
        this.c = new cw[by8];
        this.ac = new byte[by8];
        int n7 = -1;
        for (n5 = 0; n5 < by8; ++n5) {
            n4 = -1;
            this.ac[n5] = byArray[n6++];
            by4 = this.ac[n5];
            if (by4 < 0) {
                by4 += 256;
            }
            by3 = by4;
            int by13 = 0;
            for (n3 = 0; n3 < this.aa.length; ++n3) {
                if (by4 >= (by13 += this.aa[n3])) continue;
                n4 = n3;
                by3 -= by13 - this.aa[n3];
                break;
            }
            if (n7 != n4) {
                n7 = n4;
                object = new dq("/m/ob" + n7);
            }
            this.c[n5] = ((dq)object).a(by3);
        }
        rpg.a.c();
        c = byArray[n6++];
        d = byArray[n6++];
        this.a = (short)(c << 4);
        this.b = (short)(d << 4);
        this.a = new c[d][c];
        n5 = d * c;
        this.b = new byte[n5];
        System.arraycopy(byArray, n6, this.b, 0, n5);
        rpg.a.c();
        this.a = new byte[n5];
        System.arraycopy(byArray, n6 += n5, this.a, 0, n5);
        n6 += n5;
        int n8 = byArray[n6++] & 0xFF;
        if (n8 > 0) {
            this.a = new f[n8];
            for (n3 = 0; n3 < n8; ++n3) {
                n4 = byArray[n6];
                by4 = (byte)rpg.f.a(byArray, n6 + 1);
                by3 = (byte)rpg.f.a(byArray, n6 + 3);
                n6 += 5;
                f f2 = new f(this.a((byte)n4), by4, by3);
                this.f(f2);
                this.c(f2);
                this.a[n3] = f2;
            }
            rpg.a.c();
        }
        if ((n2 = byArray[n6++] & 0xFF) > 0) {
            this.b = new f[n2];
            for (int i = 0; i < n2; ++i) {
                n4 = byArray[n6];
                by4 = (byte)rpg.f.a(byArray, n6 + 1);
                by3 = rpg.f.a(byArray, n6 + 3);
                n6 += 5;
                this.b[i] = new f(this.a((byte)n4), by4, by3);
            }
            rpg.a.c();
        }
        if ((n = byArray[n6++] & 0xFF) > 0) {
            this.c = new f[n];
            for (int i = 0; i < n; ++i) {
                n4 = byArray[n6];
                by4 = rpg.f.a(byArray, n6 + 1);
                by3 = rpg.f.a(byArray, n6 + 3);
                n6 += 5;
                this.c[i] = new f(this.a((byte)n4), by4, by3);
            }
            rpg.a.c();
        }
        byte by5 = byArray[n6++];
        byte[] byArray3 = new byte[by5];
        if (by5 > 0) {
            c = true;
            b.a(by5);
            object = rpg.c.a("/en/edf");
            byte[] byArray4 = rpg.c.a("/en/np");
            byte[] byArray5 = rpg.c.a("/en/ep");
            for (n4 = 0; n4 < by5; ++n4) {
                byArray3[n4] = n3 = byArray[n6++];
                rpg.c.a(n4, n3, (byte[])object, byArray4, byArray5);
                rpg.a.c();
            }
        }
        byte by6 = byArray[n6++];
        for (by2 = 0; by2 < by6; ++by2) {
            n3 = byArray[n6 + 1];
            n7 = (n3 & 0x80) == 128 ? byArray[n6 + 3] : -1;
            for (byte by7 = 0; by7 < byArray3.length; by7 = (byte)((byte)(by7 + 1))) {
                if (byArray3[by7] != byArray[n6]) continue;
                db.a((short)((byArray[n6 + 1] & 0x7F) << 4), (short)(byArray[n6 + 2] << 4), byArray[n6], by7);
                b.a[by7].f = (byte)n7;
            }
            n6 += 3;
            if ((n3 & 0x80) == 128) {
                ++n6;
            }
            rpg.a.c();
        }
        ec.B();
        by2 = byArray[n6++];
        byte[] byArray6 = new byte[by2];
        if (by2 > 0) {
            boolean bl = r.a(252);
            System.arraycopy(byArray, n6, byArray6, 0, by2);
            n6 += by2;
            dt.a = new at[by2];
            dt.a = new byte[by2];
            dt.b = new byte[by2];
            byte[] byArray7 = rpg.c.a("/en/ndf");
            byte[] byArray8 = rpg.c.a("/en/np");
            for (by3 = 0; by3 < by2; by3 = (byte)(by3 + 1)) {
                rpg.c.a(byArray7, bl && byArray6[by3] == 1 ? (byte)47 : byArray6[by3], by3, byArray8);
                rpg.a.c();
            }
        }
        if ((by = byArray[n6++]) > 0) {
            this.a = new br[by];
            by3 = 0;
            for (byte by9 = 0; by9 < by; by9 = (byte)(by9 + 1)) {
                byte by10 = byArray[n6++];
                n3 = byArray[n6];
                int n9 = byArray[n6++] & 0x7F;
                byte by11 = byArray[n6++];
                for (byte by12 = 0; by12 < by2; by12 = (byte)((byte)(by12 + 1))) {
                    if (by10 != byArray6[by12]) continue;
                    by3 = by12;
                    break;
                }
                br br2 = new br((short)(n9 << 4), (short)(by11 << 4), by10, by3);
                this.f(br2);
                this.c(br2);
                br2.a_();
                if ((n3 & 0x80) == 128) {
                    br2.c(byArray[n6++]);
                }
                this.a[by9] = br2;
            }
            rpg.a.c();
        }
        m.a(byArray, n6);
        g = true;
        rpg.a.c();
        rpg.c.a(this.ab[0], this.ab[1]);
        rpg.a.c();
        this.i();
        a = 10;
    }

    public final void b() {
        this.c(0);
        rpg.a.c();
        this.c(1);
        rpg.a.c();
    }

    public final void a(byte by, byte by2, byte by3) {
        this.b[by2 * ab.c + by] = (byte)(by3 + 1);
    }

    private final void c(int n) {
        if (n < 0) {
            this.f = 0;
            this.a = null;
            this.Z[0] = -1;
            this.Z[1] = -1;
            return;
        }
        if (this.Z[n] != this.ab[n]) {
            int n2;
            int n3 = n == 0 ? 1 : 0;
            cw[][] cwArrayArray = new cw[2][];
            cw[][] cwArrayArray2 = cwArrayArray;
            cwArrayArray[0] = null;
            cwArrayArray2[1] = null;
            if (this.Z[n3] >= 0) {
                cwArrayArray2[n3] = new cw[n3 == 0 ? this.f : this.a.length - this.f];
                for (n2 = 0; n2 < cwArrayArray2[n3].length; ++n2) {
                    cwArrayArray2[n3][n2] = this.a[n2 + (n3 == 0 ? 0 : this.f)];
                }
            }
            this.a = null;
            if (this.ab[n] >= 0) {
                dq dq2 = new dq("/m/t" + (this.ab[n] < 10 ? "0" : "") + this.ab[n]);
                cwArrayArray2[n] = new cw[dq2.a()];
                dq2.a(cwArrayArray2[n], 0);
            }
            this.f = cwArrayArray2[0] != null ? cwArrayArray2[0].length : 0;
            n2 = this.f + (cwArrayArray2[1] != null ? cwArrayArray2[1].length : 0);
            this.a = new cw[n2];
            for (n3 = 0; n3 < n2; ++n3) {
                this.a[n3] = n3 < this.f ? cwArrayArray2[0][n3] : cwArrayArray2[1][n3 - this.f];
            }
            this.Z[n] = this.ab[n];
        }
    }

    public final void c() {
        int n;
        Object object;
        this.d = rpg.e.c > 0 ? r.c : r.a;
        this.e = rpg.e.c > 0 ? r.d : r.b;
        int n2 = bh.g;
        int n3 = bh.h;
        if (this.d > 0) {
            this.d = 0;
        }
        if (this.e > 0) {
            this.e = 0;
        }
        if (this.d < n2 - this.a) {
            this.d = n2 - this.a;
        }
        if (this.e < n3 - this.b) {
            this.e = n3 - this.b;
        }
        if (this.d > 0) {
            this.d = n2 - this.a >> 1;
        }
        if (this.e > 0) {
            this.e = n3 - this.b >> 1;
        }
        if (this.b != 0 || this.c != 0) {
            rpg.e.k();
        } else {
            object = this;
            if (e == 2) {
                ((ab)object).b(2, r.a.q == 4 ? 4 : 3);
            } else if (e == 1) {
                ((ab)object).c(2, 2);
            }
        }
        if (this.b != 0) {
            this.d += this.b;
            this.b = 0;
        }
        if (this.c != 0) {
            this.e += this.c;
            this.c = 0;
        }
        int n4 = -this.d / 16;
        int n5 = -this.e / 16;
        int n6 = (n2 - this.d - 1) / 16;
        int n7 = (n3 - this.e - 1) / 16;
        if (n4 < 0) {
            n4 = 0;
        }
        if (n5 < 0) {
            n5 = 0;
        }
        if (n6 >= c) {
            n6 = c - 1;
        }
        if (n7 >= d) {
            n7 = d - 1;
        }
        cr cr2 = rpg.a.a;
        if (a || b) {
            object = cr2;
            ((cr)object).a(g == 1 ? 0xFFFFFF : 0);
            ((cr)object).b(0, 0, bh.g, bh.h);
            ((cr)object).a(0, 0, bh.g, bh.h);
            if (a) {
                this.a(this.d, this.e, false);
                this.a(this.d, this.e, true);
                a = false;
                return;
            }
        } else {
            cr2.b(0, 0, n2, n3);
            cr2.a(0x202020);
            cr2.a(0, 0, n2, n3);
        }
        bh.e(cr2);
        if (!b) {
            int n8;
            int n9;
            int n10;
            n = this.a.length;
            n3 = this.e + (n5 << 4);
            for (n10 = n5; n10 <= n7; ++n10) {
                n2 = this.d + (n4 << 4);
                for (n9 = n4; n9 <= n6; ++n9) {
                    n8 = n10 * c + n9;
                    int n11 = (this.b[n8] & 0x80) != 0 ? this.f : 0;
                    n11 = n11 + (char)(this.b[n8] & 0x7F);
                    if (n11 > 0 && --n11 < n) {
                        cr2.a(this.a[n11], n2, n3, 20);
                    }
                    n2 += 16;
                }
                n3 += 16;
            }
            bh.e(cr2);
            if (this.c != null) {
                n10 = this.c.length;
                for (n9 = 0; n9 < n10; ++n9) {
                    this.c[n9].a(this.d, this.e);
                }
            }
            int n12 = n4;
            int n13 = n5;
            int n14 = n6;
            int n15 = n7;
            n = this.e;
            n7 = this.d;
            n6 = n15;
            n5 = n14;
            n4 = n13;
            n3 = n12;
            cr cr3 = cr2;
            object = this;
            n8 = ((ab)object).b.size();
            if (n8 > 0) {
                bh.e(cr3);
                for (int i = n8 - 1; i >= 0; --i) {
                    byte by;
                    byte[] byArray = (byte[])((ab)object).b.elementAt(i);
                    if (byArray[5] <= 16 && byArray[5] % 3 != 0 || byArray[0] < n3 || byArray[0] > n5 || byArray[1] < n4 || byArray[1] > n6) continue;
                    n10 = n7 + (byArray[0] << 4);
                    n9 = n + (byArray[1] << 4) + 2;
                    cr3.a(rpg.c.e[0], n10, n9 + 4, 20);
                    if (byArray[2] == 1) {
                        cr3.a(rpg.c.g, n10 + 1, n9 + 2, 20);
                        continue;
                    }
                    int n16 = by + ((by = byArray[3]) == 20 ? byArray[4] : (byte)0);
                    cr3.a(rpg.c.k[n16], n10 + 8, n9 + 16 - 6, 33);
                }
            }
        }
        bh.e(cr2);
        this.a(this.d, this.e, false);
        object = this.a;
        while (object != null) {
            ((c)object).a(this.d, this.e);
            object = ((c)object).b;
        }
        object = this.c;
        while (object != null) {
            ((c)object).a(this.d, this.e);
            object = ((c)object).b;
        }
        this.a(this.d, this.e, true);
        if (b) {
            b = false;
            return;
        }
        if (this.b != null) {
            n = this.b.length;
            for (int i = 0; i < n; ++i) {
                this.b[i].a(this.d, this.e);
            }
        }
        if (r.d == 3 || r.d == 4) {
            if (a > 0) {
                --a;
            }
            if (e >= 0) {
                e = (byte)(e - 1);
            }
        }
        if (!g) {
            cr2.a(0);
            cr2.a(0, 0, 10, 10);
        }
        cr cr4 = cr2;
        object = this;
        if (a > 0 && ((ab)object).a != null) {
            cr4.b(255);
            n3 = a << 2;
            n4 = rpg.a.a - bh.g >> 1;
            cr4.a(0);
            cr4.a(n4, 0, bh.g, n3);
            cr4.a(n4, bh.h - n3, bh.g, n3);
            cr4.b(60);
            n5 = n3 * 6;
            n6 = 180 - (n5 >> 1);
            cr4.a(n6, n6, n6);
            cr4.a(0, bh.j - 15, rpg.a.a, 30);
            cr4.b(255);
            if (a > 6 && a < 15) {
                n5 = 0xFFFFFF;
            }
            if (((ab)object).a[0] != null) {
                ab.a(cr4, n5, ((ab)object).a[0], rpg.a.c - a, bh.j - 3 - 7);
            }
            if (((ab)object).a[1] != null) {
                ab.a(cr4, n5, ((ab)object).a[1], rpg.a.c + a, bh.j - 3 + 7);
            }
        }
        for (n3 = 0; n3 < 3; ++n3) {
            if (a[n3] <= 0) continue;
            int n17 = n3;
            a[n17] = a[n17] - 1;
            try {
                if (a[n3] > 0) {
                    cr4.a(((ab)object).b[n3], rpg.a.c, bh.h - n3 * (((ab)object).b[n3].b() + 1), 33);
                    continue;
                }
                ((ab)object).b[n3] = null;
                continue;
            }
            catch (Exception exception) {
                Exception exception2 = exception;
                exception.printStackTrace();
            }
        }
    }

    private static void a(cr cr2, int n, byte[] byArray, int n2, int n3) {
        if (byArray == null) {
            return;
        }
        cr2.a(0);
        dv.a(cr2, n2 + 1, n3 - 1, byArray, 0, 1);
        if (n > 255) {
            n = 255;
        }
        cr2.a(n, n, n);
        dv.a(cr2, n2, n3, byArray, 0, 1);
    }

    private byte a(byte by) {
        if (this.ac == null) {
            return -1;
        }
        for (byte by2 = 0; by2 < this.ac.length; by2 = (byte)(by2 + 1)) {
            if (this.ac[by2] != by) continue;
            return by2;
        }
        return -1;
    }

    public final void a(byte by, int n, int n2) {
        rpg.a.a.a(this.c[by], n, n2, 33);
    }

    final boolean b(int n, int n2) {
        return (this.a[n2 * c + n] & 0xC0) != 0;
    }

    final boolean c(int n, int n2) {
        return (this.a[n2 * c + n] & 0x80) != 0;
    }

    final boolean a(c c2, int n, int n2) {
        return this.a[n2][n] != null && this.a[n2][n] != c2;
    }

    final boolean d(int n, int n2) {
        return this.b(n, n2) && (this.a[n2 * c + n] & 0x3F) == 0;
    }

    public final boolean a(do do_, int n, int n2) {
        for (int i = 0; i < do_.e; ++i) {
            if (n + i < 0 || n2 < 0 || n + i >= c - 1 || n2 + i >= d - 1) {
                return false;
            }
            if (!this.b(n + i, n2) && !this.a((c)do_, n + i, n2)) continue;
            return false;
        }
        return true;
    }

    final boolean a(do do_, byte by) {
        return this.a(do_, do_.c + rpg.b.S[by], do_.d + rpg.b.T[by]);
    }

    final void d() {
        rpg.b b2 = this;
        int n = b2.a.size();
        for (int i = n - 1; i >= 0; --i) {
            df df2 = (df)b2.a.elementAt(i);
            if (df2 == null || !df2.a) continue;
            b2.a.removeElementAt(i);
        }
        b2 = this.a;
        while (b2 != null) {
            if (b2 instanceof f) {
                b2 = ((c)b2).b;
                continue;
            }
            if (b2 instanceof db && !((c)b2).d) {
                db db2 = (db)b2;
                db2.d();
                b2 = ((c)b2).b;
                this.c(db2);
                if (db2.p != 7) continue;
                this.d(db2);
                continue;
            }
            if (b2 instanceof br && !((c)b2).d) {
                br br2 = (br)b2;
                br2.d();
                b2 = ((c)b2).b;
                this.c(br2);
                continue;
            }
            if (((c)b2).d) {
                ((c)b2).d = false;
                b2 = ((c)b2).b;
                continue;
            }
            b2 = ((c)b2).b;
        }
        b2 = this.c;
        while (b2 != null) {
            if (b2 instanceof ec && !((c)b2).d) {
                db db3 = (db)b2;
                db3.d();
                b2 = ((c)b2).b;
                this.h(db3);
                if (db3.p != 7) continue;
                this.e(db3);
                continue;
            }
            if (((c)b2).d) {
                ((c)b2).d = false;
                b2 = ((c)b2).b;
                continue;
            }
            b2 = ((c)b2).b;
        }
    }

    public final void d(c b2) {
        boolean bl;
        if (b2 instanceof do) {
            ((do)b2).b_();
        }
        c c2 = b2;
        b2 = this;
        c c3 = ((ab)b2).a;
        while (c3 != null && !c3.equals(c2)) {
            c3 = c3.b;
        }
        if (c3 != null) {
            if (c3.a != null) {
                c3.a.b = c3.b;
            } else {
                ((ab)b2).a = c3.b;
            }
            if (c3.b != null) {
                c3.b.a = c3.a;
            } else {
                ((ab)b2).b = c3.a;
            }
            bl = true;
        } else {
            bl = false;
        }
    }

    public final void e(c b2) {
        boolean bl;
        if (b2 instanceof do) {
            ((do)b2).b_();
        }
        c c2 = b2;
        b2 = this;
        c c3 = ((ab)b2).c;
        while (c3 != null && !c3.equals(c2)) {
            c3 = c3.b;
        }
        if (c3 != null) {
            if (c3.a != null) {
                c3.a.b = c3.b;
            } else {
                ((ab)b2).c = c3.b;
            }
            if (c3.b != null) {
                c3.b.a = c3.a;
            } else {
                ((ab)b2).d = c3.a;
            }
            bl = true;
        } else {
            bl = false;
        }
    }

    public static void a(byte by) {
        x x2 = r.a;
        x2.y();
        if (by > 0) {
            x2.c(new ax(-6, by));
        }
    }

    public final void a(byte by, byte by2) {
        br br2 = this.a[by2];
        br2.y();
        if (by > 0) {
            br2.c(new ax(-6, by));
        }
    }

    public final void b(byte by, byte by2) {
        br br2 = this.a[by & 0xFF];
        this.a[by & 0xFF].f = by2;
    }

    public final void b(int n, int n2) {
        if (n2 % 2 == 1) {
            this.b = -n;
            return;
        }
        this.b = n;
    }

    public final void c(int n, int n2) {
        if (n2 % 2 == 0) {
            this.c = n;
            return;
        }
        this.c = -n;
    }

    public static void a(int n) {
        g = 1;
        a = true;
    }

    public static void b(int n) {
        g = 0;
        b = true;
    }

    public static void e() {
        b = false;
        a = false;
    }

    public final void a(byte by, byte by2, byte by3, byte by4) {
        if (by3 < 0 || by4 < 0 || by3 > 20 || by4 > 28) {
            return;
        }
        byte[] byArray = new byte[]{by, by2, 0, by3, by4, 126};
        this.b.insertElementAt(byArray, 0);
    }

    public final void a(byte by, byte by2, int n) {
        byte[] byArray = new byte[]{by, by2, 1, (byte)(n / 100), (byte)(n % 100), 126};
        this.b.addElement(byArray);
    }

    public final void f() {
        int n;
        for (int i = n = this.b.size() - 1; i >= 0; --i) {
            byte[] byArray = (byte[])this.b.elementAt(i);
            if (byArray[5] > 0) {
                byArray[5] = (byte)(byArray[5] - 1);
                continue;
            }
            this.b.removeElementAt(i);
        }
    }

    public final boolean a(byte by, byte by2) {
        int n = this.b.size();
        if (n <= 0) {
            return false;
        }
        byte[] byArray = null;
        boolean bl = false;
        for (int i = 0; i < n; ++i) {
            byArray = (byte[])this.b.elementAt(i);
            if (by != byArray[0] || by2 != byArray[1]) continue;
            if (byArray[2] == 1) {
                int n2 = byArray[3] * 100 + byArray[4];
                if (dj.j) {
                    n2 <<= 1;
                }
                r.e(n2);
                this.b.removeElementAt(i);
                this.a((byte)1, byArray[3], byArray[4], true);
                return true;
            }
            bl = true;
            bp bp2 = r.a(byArray[3]);
            if (!bp2.a(byArray[3], byArray[4], 1)) continue;
            bp2.a(dg.a(byArray[3], byArray[4]), 1);
            this.b.removeElementAt(i);
            this.a((byte)0, byArray[3], byArray[4], true);
            if (byArray[3] == 20) {
                bh.d = true;
            }
            return true;
        }
        if (bl) {
            this.a(byArray[2], byArray[3], byArray[4], false);
        }
        return false;
    }

    private final void a(byte by, byte by2, byte by3, boolean bl) {
        byte[] byArray;
        cw cw2 = cw.a(120, 16);
        cr cr2 = cw2.a();
        cr2.a(0);
        cr2.a(0, 0, 120, 16);
        cr2.a(13682856);
        cr2.d(1, 1, 117, 13);
        cr2.a(0xFFFFFF);
        if (!bl) {
            by2 = (byte)23;
            switch (by) {
                case 16: {
                    by2 = (byte)21;
                    break;
                }
                case 18: {
                    by2 = (byte)22;
                }
            }
            byArray = rpg.c.g.a(by2);
        } else {
            byte[] byArray2;
            if (by == 1) {
                byArray2 = rpg.f.a(("" + (by2 * 100 + by3)).getBytes(), rpg.b.G);
                if (dj.j) {
                    byArray2 = rpg.f.a(byArray2, "x2".getBytes());
                }
            } else {
                dg dg2 = dg.a(by2, by3);
                byArray2 = by2 == 18 ? rpg.f.a(rpg.c.g.a(by2), dg2.c) : dg2.c;
                if (dg2 instanceof bs) {
                    cr2.a(aw.e[((bs)dg2).b]);
                }
            }
            byArray = byArray2;
        }
        dv.a(cr2, 60, 1, byArray, 0, 1);
        boolean bl2 = false;
        for (int i = 0; i < 3; ++i) {
            if (this.b[i] != null) continue;
            this.b[i] = cw2;
            ab.a[i] = 15;
            bl2 = true;
            break;
        }
        if (!bl2) {
            this.b[0] = cw2;
            ab.a[0] = 15;
        }
    }

    public final byte[] a() {
        x x2 = r.a;
        byte[] byArray = new byte[4];
        byte[] byArray2 = byArray;
        byArray[0] = this.b;
        byArray2[1] = ((c)x2).c;
        byArray2[2] = ((c)x2).d;
        byArray2[3] = x2.q;
        return byArray2;
    }

    public final c a(int n, int n2) {
        if (n >= 0 && n2 >= 0 && n < c && n2 < d) {
            return this.a[n2][n];
        }
        return null;
    }

    public final void a(df df2) {
        this.a.addElement(df2);
    }

    private void a(int n, int n2, boolean bl) {
        int n3;
        for (int i = n3 = this.a.size() - 1; i >= 0; --i) {
            df df2 = (df)this.a.elementAt(i);
            if (df2 == null) continue;
            df2.a(n, n2, bl);
        }
    }

    public static final void g() {
        e = (byte)2;
    }

    public static boolean a() {
        return e > 0;
    }

    public static void h() {
        db.u();
        b.a();
    }

    private int a(int n, int n2, int n3) {
        if (n2 < 0 || n3 < 0 || n2 >= c || n3 >= d) {
            return -1;
        }
        int n4 = n3;
        n3 = n2;
        ab ab2 = this;
        int n5 = n3 < 0 || n4 < 0 || n3 >= c || n4 >= d ? 0 : ab2.a[n4 * c + n3];
        n = (n5 & 0x40) != 0 || (n5 & 0x80) != 0 ? b[(n << 1) + 1] : b[n << 1];
        if ((n5 & 0x3F) != 0) {
            n = 3767807;
        }
        return n;
    }

    public final void a(cr cr2) {
        Object object;
        int n = c * f;
        int n2 = d * f;
        n = rpg.a.c - (n >> 1);
        n2 = 8 + rpg.a.b >= 300 ? bh.h - n2 >> 1 : rpg.a.b - n2 >> 1;
        int n3 = n2;
        if (bh.e || rpg.a.a) {
            object = this.b();
            int n4 = rpg.a.a - dv.a(object) >> 1;
            int n5 = n < n4 - 5 ? n : n4 - 5;
            int n6 = n3 - 15 > 0 ? n3 - 15 : 0;
            int n7 = rpg.a.c - n5 << 1;
            int n8 = 15 + a.b();
            cr2.a(0);
            cr2.a(0, 0, rpg.a.a, rpg.a.b - 33);
            cr2.a(10159117);
            cr2.a(0, 0, rpg.a.a, 15);
            cr2.a(0x777777);
            dv.a(cr2, n4 + 1, 2, object, 1);
            cr2.a(0xFFFFFF);
            dv.a(cr2, n4, 1, object, 1);
            cr2.a(a, n, n3, 20);
            if (rpg.e.d && this.h >= 0 && this.i >= 0) {
                cr2.a(0xFF0000);
                cr2.b(n5, n6, n7, n8);
                n3 = rpg.c.p.a();
                int n9 = rpg.c.p.b();
                n4 = n + this.h * f;
                n5 = n2 + this.i * f;
                cr2.b(n4 + 1, n5, n3, n9);
                cr2.a(rpg.c.p, n4 + 1, n5, 20);
                cr2.b(0, 0, rpg.a.a, rpg.a.b);
            }
        }
        object = r.a;
        cr2.a(rpg.a.e % 2 == 1 ? 0xFF0000 : 0x7F7F7F);
        cr2.a(n + object.c * f, n2 + object.d * f, (int)f, (int)f);
        if (++rpg.a.e > 99) {
            rpg.a.e = 0;
        }
        if (ah.a != null) {
            cr2.a(ah.a, rpg.a.a - ah.a.a(), rpg.a.b - ah.a.b(), 20);
        }
        if (!rpg.e.d || this.h == -1 && this.i == -1) {
            bh.e = false;
        }
    }

    private void i() {
        int n = c * f;
        int n2 = d * f;
        a = cw.a(n, n2);
        cr cr2 = a.a();
        cr2.a(0);
        cr2.a(0, 0, n, n2);
        int n3 = 2;
        switch (this.ab[0]) {
            case 0: 
            case 2: {
                n3 = 0;
                break;
            }
            case 1: 
            case 6: {
                n3 = 1;
            }
        }
        for (int i = 0; i < n2; ++i) {
            for (int k = 0; k < n; ++k) {
                int n4;
                int n5 = i;
                int n6 = k;
                int n7 = n3;
                ab ab2 = this;
                boolean bl = false;
                int n8 = n6 >> 1;
                int n9 = n5 >> 1;
                int n10 = ab2.a(n7, n8, n9);
                if (n6 % 2 == 0 && n5 % 2 == 0) {
                    n6 = ab2.a(n7, n8 - 1, n9);
                    n4 = ab2.a(n7, n8, n9 - 1);
                } else if (n6 % 2 == 1 && n5 % 2 == 0) {
                    n6 = ab2.a(n7, n8 + 1, n9);
                    n4 = ab2.a(n7, n8, n9 - 1);
                } else if (n6 % 2 == 0 && n5 % 2 == 1) {
                    n6 = ab2.a(n7, n8 - 1, n9);
                    n4 = ab2.a(n7, n8, n9 + 1);
                } else {
                    n6 = ab2.a(n7, n8 + 1, n9);
                    n4 = ab2.a(n7, n8, n9 + 1);
                }
                if (n6 == -1) {
                    n6 = n10;
                }
                if (n4 == -1) {
                    n4 = n10;
                }
                if (n10 != n6 && n10 != n4) {
                    bl = true;
                }
                if (n10 == 3767807) {
                    bl = false;
                }
                if (bl) {
                    n7 = ((n10 & 0xFF) + (n6 & 0xFF) + (n4 & 0xFF)) / 3;
                    n5 = ((n10 >> 8 & 0xFF) + (n6 >> 8 & 0xFF) + (n4 >> 8 & 0xFF)) / 3;
                    n4 = ((n10 >> 16 & 0xFF) + (n6 >> 16 & 0xFF) + (n4 >> 16 & 0xFF)) / 3;
                    n7 = n7 > 255 ? 255 : n7;
                    n5 = n5 > 255 ? 255 : n5;
                    n4 = n4 > 255 ? 255 : n4;
                    n10 = n7 + (n5 << 8) + (n4 << 16);
                }
                n4 = n10;
                cr2.a(n4);
                cr2.a(k << 1, i << 1, 2, 2);
            }
            if (i % 10 != 1) continue;
            rpg.a.c();
        }
    }

    public final byte[] b() {
        byte[] byArray = this.a[0];
        if (this.a[1] != null) {
            byArray = rpg.f.a(this.a[0], "-".getBytes());
            byArray = rpg.f.a(byArray, this.a[1]);
        }
        return byArray;
    }

    public final br a() {
        for (int i = 0; i < this.a.length; ++i) {
            br br2 = this.a[i];
            if (br2.g != 1) continue;
            return br2;
        }
        return null;
    }

    static {
        g = 0;
        a = false;
        b = false;
        e = (byte)-1;
        a = new int[3];
        c = false;
        f = false;
        g = true;
        a = null;
        j = new byte[][]{{1, 3, 3, -46}, {2, 1, 4, -45}, {3, 8, 3, -44}, {14, 8, 8, -42}, {20, 5, 5, -41}, {22, 4, 22, -40}, {27, 4, 5, -39, 15, 17, -38}, {28, 16, 4, 9}, {32, 3, 5, -36}, {35, 1, 10, -18}, {40, 17, 6, -43}, {46, 33, 4, -35}, {47, 2, 1, -34}, {52, 4, 13, -33}, {54, 2, 10, -32}, {56, 4, 4, -31}, {58, 1, 27, -30}, {64, 8, 2, -29}, {69, 30, 29, -28}, {75, 3, 6, -27}, {77, 20, 10, -26}, {86, 13, 12, 77}, {96, 11, 6, -21}, {110, 3, 5, -50, 3, 20, -48, 21, 5, -49, 21, 20, -47}, {112, 3, 15, -20}, {118, 4, 17, -19}};
        f = (byte)4;
        b = new int[]{0xBFBFBF, 0x3F3F3F, 12451641, 1588281, 0xBFBFDF, 0x5F5F3F};
    }
}
