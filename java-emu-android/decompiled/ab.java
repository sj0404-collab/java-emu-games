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

    public static void a(int n2, int n3) {
        if (b == null) {
            b = cw.a("/chest_opened.png");
        }
        int n4 = b.a() / 2;
        int n5 = b.b();
        rpg.a.a.a(b, n2 - n4, n3 - n5, 0);
    }

    public ab(byte by2) {
        this.aa = new byte[]{33, 55, 49, 13, 20};
        this.b = new cw[3];
        this.b = new Vector();
        this.c(-1);
        this.b = by2;
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

    public final int a(int n2, int n3) {
        for (int i2 = 0; i2 < j.length; ++i2) {
            if (this.b == j[i2][0]) {
                for (int i3 = 1; i3 < j[i2].length; i3 += 3) {
                    if (n2 != j[i2][i3] || n3 != j[i2][i3 + 1]) continue;
                    return j[i2][i3 + 2];
                }
                continue;
            }
            if (this.b < j[i2][0]) break;
        }
        if (this.b == 89) {
            if (n2 == 16 && n3 == 10) {
                return 19;
            }
        } else if (this.b == 90) {
            if (n2 == 9 && n3 == 16) {
                return 20;
            }
        } else if (this.b == 92 && n2 == 10 && n3 == 13) {
            return 21;
        }
        return -1;
    }

    public final void a() {
        try {
            byte by2;
            int n2;
            boolean bl2 = false;
            int n3 = this.b;
            if (n3 < 0) {
                n3 += 256;
            }
            Object object = "/mmi/" + n3;
            object = new DataInputStream(object.getClass().getResourceAsStream((String)object));
            byte[] byArray = new byte[((FilterInputStream)object).available()];
            ((DataInputStream)object).read(byArray);
            ((FilterInputStream)object).close();
            for (n2 = 35; n2 > 0 && (by2 = r.a(n2)) != 1; --n2) {
                if (by2 != 2) continue;
                if (j.a) {
                    n2 = 10;
                    bl2 = true;
                    break;
                }
                n2 = 0;
                break;
            }
            if (n2 < 36 && n2 > 0) {
                if (bl2 && this.b == 8) {
                    this.h = 0;
                    this.i = 0;
                } else if (bl2 && this.b == 10) {
                    this.h = 5;
                    this.i = 10;
                } else {
                    this.h = byArray[--n2 << 1];
                    this.i = byArray[(n2 << 1) + 1];
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

    public final byte a(int n2, int n3) {
        if (n2 < 0 || n3 < 0 || n2 >= c || n3 >= d) {
            return 0;
        }
        byte by2 = (byte)(this.a[n3 * c + n2] & 0x3F);
        n2 = by2;
        if (by2 <= 0) {
            return -1;
        }
        return (byte)n2;
    }

    public static boolean a(int n2, int n3) {
        return n2 < 0 || n3 < 0 || n2 >= c || n3 >= d;
    }

    public final void a(byte[] byArray) {
        byte by2;
        byte by3;
        int n2;
        int n3;
        int n4;
        byte by4;
        byte by5;
        int n5;
        int n6;
        f = false;
        g = false;
        m.a();
        int n22 = 0;
        byte[] byArray2 = new byte[]{-1, -1};
        if (this.ab != null) {
            System.arraycopy(this.ab, 0, byArray2, 0, 2);
        }
        ++n22;
        this.a = byArray[0];
        if (this.ab == null) {
            this.ab = new byte[2];
        }
        ++n22;
        this.ab[0] = byArray[1];
        ++n22;
        this.ab[1] = byArray[2];
        rpg.a.c();
        this.a = new byte[2][];
        for (int i2 = 0; i2 < 2; ++i2) {
            byte by8;
            if ((by8 = byArray[n22++]) <= 0) continue;
            this.a[i2] = new byte[by8];
            System.arraycopy(byArray, n22, this.a[i2], 0, by8);
            n22 += by8;
        }
        Object object = null;
        int by9 = byArray[n22++];
        this.c = new cw[by9];
        this.ac = new byte[by9];
        int n7 = -1;
        for (n6 = 0; n6 < by9; ++n6) {
            n5 = -1;
            this.ac[n6] = byArray[n22++];
            by5 = this.ac[n6];
            if (by5 < 0) {
                by5 += 256;
            }
            by4 = by5;
            int by14 = 0;
            for (n4 = 0; n4 < this.aa.length; ++n4) {
                if (by5 >= (by14 += this.aa[n4])) continue;
                n5 = n4;
                by4 -= by14 - this.aa[n4];
                break;
            }
            if (n7 != n5) {
                n7 = n5;
                object = new dq("/m/ob" + n7);
            }
            this.c[n6] = ((dq)object).a(by4);
        }
        rpg.a.c();
        c = byArray[n22++];
        d = byArray[n22++];
        this.a = (short)(c << 4);
        this.b = (short)(d << 4);
        this.a = new c[d][c];
        n6 = d * c;
        this.b = new byte[n6];
        System.arraycopy(byArray, n22, this.b, 0, n6);
        rpg.a.c();
        this.a = new byte[n6];
        System.arraycopy(byArray, n22 += n6, this.a, 0, n6);
        n22 += n6;
        int n8 = byArray[n22++] & 0xFF;
        if (n8 > 0) {
            this.a = new f[n8];
            for (n4 = 0; n4 < n8; ++n4) {
                n5 = byArray[n22];
                by5 = (byte)rpg.f.a(byArray, n22 + 1);
                by4 = (byte)rpg.f.a(byArray, n22 + 3);
                n22 += 5;
                f f2 = new f(this.a((byte)n5), by5, by4);
                this.f(f2);
                this.c(f2);
                this.a[n4] = f2;
            }
            rpg.a.c();
        }
        if ((n3 = byArray[n22++] & 0xFF) > 0) {
            this.b = new f[n3];
            for (int i3 = 0; i3 < n3; ++i3) {
                n5 = byArray[n22];
                by5 = (byte)rpg.f.a(byArray, n22 + 1);
                by4 = rpg.f.a(byArray, n22 + 3);
                n22 += 5;
                this.b[i3] = new f(this.a((byte)n5), by5, by4);
            }
            rpg.a.c();
        }
        if ((n2 = byArray[n22++] & 0xFF) > 0) {
            this.c = new f[n2];
            for (int i4 = 0; i4 < n2; ++i4) {
                n5 = byArray[n22];
                by5 = rpg.f.a(byArray, n22 + 1);
                by4 = rpg.f.a(byArray, n22 + 3);
                n22 += 5;
                this.c[i4] = new f(this.a((byte)n5), by5, by4);
            }
            rpg.a.c();
        }
        byte by6 = byArray[n22++];
        byte[] byArray3 = new byte[by6];
        if (by6 > 0) {
            c = true;
            b.a(by6);
            object = rpg.c.a("/en/edf");
            byte[] byArray4 = rpg.c.a("/en/np");
            byte[] byArray5 = rpg.c.a("/en/ep");
            for (n5 = 0; n5 < by6; ++n5) {
                byArray3[n5] = n4 = byArray[n22++];
                rpg.c.a(n5, n4, (byte[])object, byArray4, byArray5);
                rpg.a.c();
            }
        }
        byte by7 = byArray[n22++];
        for (by3 = 0; by3 < by7; ++by3) {
            n4 = byArray[n22 + 1];
            n7 = (n4 & 0x80) == 128 ? byArray[n22 + 3] : -1;
            for (byte by8 = 0; by8 < byArray3.length; by8 = (byte)((byte)(by8 + 1))) {
                if (byArray3[by8] != byArray[n22]) continue;
                db.a((short)((byArray[n22 + 1] & 0x7F) << 4), (short)(byArray[n22 + 2] << 4), byArray[n22], by8);
                b.a[by8].f = (byte)n7;
            }
            n22 += 3;
            if ((n4 & 0x80) == 128) {
                ++n22;
            }
            rpg.a.c();
        }
        ec.B();
        by3 = byArray[n22++];
        byte[] byArray6 = new byte[by3];
        if (by3 > 0) {
            boolean bl2 = r.a(252);
            System.arraycopy(byArray, n22, byArray6, 0, by3);
            n22 += by3;
            dt.a = new at[by3];
            dt.a = new byte[by3];
            dt.b = new byte[by3];
            byte[] byArray7 = rpg.c.a("/en/ndf");
            byte[] byArray8 = rpg.c.a("/en/np");
            for (by4 = 0; by4 < by3; by4 = (byte)(by4 + 1)) {
                rpg.c.a(byArray7, bl2 && byArray6[by4] == 1 ? (byte)47 : byArray6[by4], by4, byArray8);
                rpg.a.c();
            }
        }
        if ((by2 = byArray[n22++]) > 0) {
            this.a = new br[by2];
            by4 = 0;
            for (byte by10 = 0; by10 < by2; by10 = (byte)(by10 + 1)) {
                byte by11 = byArray[n22++];
                n4 = byArray[n22];
                int n9 = byArray[n22++] & 0x7F;
                byte by12 = byArray[n22++];
                for (byte by13 = 0; by13 < by3; by13 = (byte)((byte)(by13 + 1))) {
                    if (by11 != byArray6[by13]) continue;
                    by4 = by13;
                    break;
                }
                br br2 = new br((short)(n9 << 4), (short)(by12 << 4), by11, by4);
                this.f(br2);
                this.c(br2);
                br2.a_();
                if ((n4 & 0x80) == 128) {
                    br2.c(byArray[n22++]);
                }
                this.a[by10] = br2;
            }
            rpg.a.c();
        }
        m.a(byArray, n22);
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

    public final void a(byte by2, byte by3, byte by4) {
        this.b[by3 * ab.c + by2] = (byte)(by4 + 1);
    }

    private final void c(int n2) {
        if (n2 < 0) {
            this.f = 0;
            this.a = null;
            this.Z[0] = -1;
            this.Z[1] = -1;
            return;
        }
        if (this.Z[n2] != this.ab[n2]) {
            int n3;
            int n4 = n2 == 0 ? 1 : 0;
            cw[][] cwArrayArray = new cw[2][];
            cw[][] cwArrayArray2 = cwArrayArray;
            cwArrayArray[0] = null;
            cwArrayArray2[1] = null;
            if (this.Z[n4] >= 0) {
                cwArrayArray2[n4] = new cw[n4 == 0 ? this.f : this.a.length - this.f];
                for (n3 = 0; n3 < cwArrayArray2[n4].length; ++n3) {
                    cwArrayArray2[n4][n3] = this.a[n3 + (n4 == 0 ? 0 : this.f)];
                }
            }
            this.a = null;
            if (this.ab[n2] >= 0) {
                dq dq2 = new dq("/m/t" + (this.ab[n2] < 10 ? "0" : "") + this.ab[n2]);
                cwArrayArray2[n2] = new cw[dq2.a()];
                dq2.a(cwArrayArray2[n2], 0);
            }
            this.f = cwArrayArray2[0] != null ? cwArrayArray2[0].length : 0;
            n3 = this.f + (cwArrayArray2[1] != null ? cwArrayArray2[1].length : 0);
            this.a = new cw[n3];
            for (n4 = 0; n4 < n3; ++n4) {
                this.a[n4] = n4 < this.f ? cwArrayArray2[0][n4] : cwArrayArray2[1][n4 - this.f];
            }
            this.Z[n2] = this.ab[n2];
        }
    }

    public final void c() {
        int n2;
        Object object;
        this.d = rpg.e.c > 0 ? r.c : r.a;
        this.e = rpg.e.c > 0 ? r.d : r.b;
        int n3 = bh.g;
        int n4 = bh.h;
        if (this.d > 0) {
            this.d = 0;
        }
        if (this.e > 0) {
            this.e = 0;
        }
        if (this.d < n3 - this.a) {
            this.d = n3 - this.a;
        }
        if (this.e < n4 - this.b) {
            this.e = n4 - this.b;
        }
        if (this.d > 0) {
            this.d = n3 - this.a >> 1;
        }
        if (this.e > 0) {
            this.e = n4 - this.b >> 1;
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
        int n5 = -this.d / 16;
        int n6 = -this.e / 16;
        int n7 = (n3 - this.d - 1) / 16;
        int n8 = (n4 - this.e - 1) / 16;
        if (n5 < 0) {
            n5 = 0;
        }
        if (n6 < 0) {
            n6 = 0;
        }
        if (n7 >= c) {
            n7 = c - 1;
        }
        if (n8 >= d) {
            n8 = d - 1;
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
            cr2.b(0, 0, n3, n4);
            cr2.a(0x202020);
            cr2.a(0, 0, n3, n4);
        }
        bh.e(cr2);
        if (!b) {
            int n9;
            int n10;
            int n11;
            n2 = this.a.length;
            n4 = this.e + (n6 << 4);
            for (n11 = n6; n11 <= n8; ++n11) {
                n3 = this.d + (n5 << 4);
                for (n10 = n5; n10 <= n7; ++n10) {
                    n9 = n11 * c + n10;
                    int n12 = (this.b[n9] & 0x80) != 0 ? this.f : 0;
                    n12 = n12 + (char)(this.b[n9] & 0x7F);
                    if (n12 > 0 && --n12 < n2) {
                        cr2.a(this.a[n12], n3, n4, 20);
                    }
                    n3 += 16;
                }
                n4 += 16;
            }
            bh.e(cr2);
            if (this.c != null) {
                n11 = this.c.length;
                for (n10 = 0; n10 < n11; ++n10) {
                    this.c[n10].a(this.d, this.e);
                }
            }
            int n13 = n5;
            int n14 = n6;
            int n15 = n7;
            int n16 = n8;
            n2 = this.e;
            n8 = this.d;
            n7 = n16;
            n6 = n15;
            n5 = n14;
            n4 = n13;
            cr cr3 = cr2;
            object = this;
            n9 = ((ab)object).b.size();
            if (n9 > 0) {
                bh.e(cr3);
                for (int i2 = n9 - 1; i2 >= 0; --i2) {
                    byte by2;
                    byte[] byArray = (byte[])((ab)object).b.elementAt(i2);
                    if (byArray[5] <= 16 && byArray[5] % 3 != 0 || byArray[0] < n4 || byArray[0] > n6 || byArray[1] < n5 || byArray[1] > n7) continue;
                    n11 = n8 + (byArray[0] << 4);
                    n10 = n2 + (byArray[1] << 4) + 2;
                    cr3.a(rpg.c.e[0], n11, n10 + 4, 20);
                    if (byArray[2] == 1) {
                        cr3.a(rpg.c.g, n11 + 1, n10 + 2, 20);
                        continue;
                    }
                    int n17 = by2 + ((by2 = byArray[3]) == 20 ? byArray[4] : (byte)0);
                    cr3.a(rpg.c.k[n17], n11 + 8, n10 + 16 - 6, 33);
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
            n2 = this.b.length;
            for (int i3 = 0; i3 < n2; ++i3) {
                this.b[i3].a(this.d, this.e);
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
            n4 = a << 2;
            n5 = rpg.a.a - bh.g >> 1;
            cr4.a(0);
            cr4.a(n5, 0, bh.g, n4);
            cr4.a(n5, bh.h - n4, bh.g, n4);
            cr4.b(60);
            n6 = n4 * 6;
            n7 = 180 - (n6 >> 1);
            cr4.a(n7, n7, n7);
            cr4.a(0, bh.j - 15, rpg.a.a, 30);
            cr4.b(255);
            if (a > 6 && a < 15) {
                n6 = 0xFFFFFF;
            }
            if (((ab)object).a[0] != null) {
                ab.a(cr4, n6, ((ab)object).a[0], rpg.a.c - a, bh.j - 3 - 7);
            }
            if (((ab)object).a[1] != null) {
                ab.a(cr4, n6, ((ab)object).a[1], rpg.a.c + a, bh.j - 3 + 7);
            }
        }
        for (n4 = 0; n4 < 3; ++n4) {
            if (a[n4] <= 0) continue;
            int n18 = n4;
            a[n18] = a[n18] - 1;
            try {
                if (a[n4] > 0) {
                    cr4.a(((ab)object).b[n4], rpg.a.c, bh.h - n4 * (((ab)object).b[n4].b() + 1), 33);
                    continue;
                }
                ((ab)object).b[n4] = null;
                continue;
            }
            catch (Exception exception) {
                Exception exception2 = exception;
                exception.printStackTrace();
            }
        }
    }

    private static void a(cr cr2, int n2, byte[] byArray, int n3, int n4) {
        if (byArray == null) {
            return;
        }
        cr2.a(0);
        dv.a(cr2, n3 + 1, n4 - 1, byArray, 0, 1);
        if (n2 > 255) {
            n2 = 255;
        }
        cr2.a(n2, n2, n2);
        dv.a(cr2, n3, n4, byArray, 0, 1);
    }

    private byte a(byte by2) {
        if (this.ac == null) {
            return -1;
        }
        for (byte by3 = 0; by3 < this.ac.length; by3 = (byte)(by3 + 1)) {
            if (this.ac[by3] != by2) continue;
            return by3;
        }
        return -1;
    }

    public final void a(byte by2, int n2, int n3) {
        rpg.a.a.a(this.c[by2], n2, n3, 33);
    }

    final boolean b(int n2, int n3) {
        return (this.a[n3 * c + n2] & 0xC0) != 0;
    }

    final boolean c(int n2, int n3) {
        return (this.a[n3 * c + n2] & 0x80) != 0;
    }

    final boolean a(c c2, int n2, int n3) {
        return this.a[n3][n2] != null && this.a[n3][n2] != c2;
    }

    final boolean d(int n2, int n3) {
        return this.b(n2, n3) && (this.a[n3 * c + n2] & 0x3F) == 0;
    }

    public final boolean a(do do_, int n2, int n3) {
        for (int i2 = 0; i2 < do_.e; ++i2) {
            if (n2 + i2 < 0 || n3 < 0 || n2 + i2 >= c - 1 || n3 + i2 >= d - 1) {
                return false;
            }
            if (!this.b(n2 + i2, n3) && !this.a((c)do_, n2 + i2, n3)) continue;
            return false;
        }
        return true;
    }

    final boolean a(do do_, byte by2) {
        return this.a(do_, do_.c + rpg.b.S[by2], do_.d + rpg.b.T[by2]);
    }

    final void d() {
        rpg.b b2 = this;
        int n2 = b2.a.size();
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            df df2 = (df)b2.a.elementAt(i2);
            if (df2 == null || !df2.a) continue;
            b2.a.removeElementAt(i2);
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
        boolean bl2;
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
            bl2 = true;
        } else {
            bl2 = false;
        }
    }

    public final void e(c b2) {
        boolean bl2;
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
            bl2 = true;
        } else {
            bl2 = false;
        }
    }

    public static void a(byte by2) {
        x x2 = r.a;
        x2.y();
        if (by2 > 0) {
            x2.c(new ax(-6, by2));
        }
    }

    public final void a(byte by2, byte by3) {
        br br2 = this.a[by3];
        br2.y();
        if (by2 > 0) {
            br2.c(new ax(-6, by2));
        }
    }

    public final void b(byte by2, byte by3) {
        br br2 = this.a[by2 & 0xFF];
        this.a[by2 & 0xFF].f = by3;
    }

    public final void b(int n2, int n3) {
        if (n3 % 2 == 1) {
            this.b = -n2;
            return;
        }
        this.b = n2;
    }

    public final void c(int n2, int n3) {
        if (n3 % 2 == 0) {
            this.c = n2;
            return;
        }
        this.c = -n2;
    }

    public static void a(int n2) {
        g = 1;
        a = true;
    }

    public static void b(int n2) {
        g = 0;
        b = true;
    }

    public static void e() {
        b = false;
        a = false;
    }

    public final void a(byte by2, byte by3, byte by4, byte by5) {
        if (by4 < 0 || by5 < 0 || by4 > 20 || by5 > 28) {
            return;
        }
        byte[] byArray = new byte[]{by2, by3, 0, by4, by5, 126};
        this.b.insertElementAt(byArray, 0);
    }

    public final void a(byte by2, byte by3, int n2) {
        byte[] byArray = new byte[]{by2, by3, 1, (byte)(n2 / 100), (byte)(n2 % 100), 126};
        this.b.addElement(byArray);
    }

    public final void f() {
        int n2;
        for (int i2 = n2 = this.b.size() - 1; i2 >= 0; --i2) {
            byte[] byArray = (byte[])this.b.elementAt(i2);
            if (byArray[5] > 0) {
                byArray[5] = (byte)(byArray[5] - 1);
                continue;
            }
            this.b.removeElementAt(i2);
        }
    }

    public final boolean a(byte by2, byte by3) {
        int n2 = this.b.size();
        if (n2 <= 0) {
            return false;
        }
        byte[] byArray = null;
        boolean bl2 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            byArray = (byte[])this.b.elementAt(i2);
            if (by2 != byArray[0] || by3 != byArray[1]) continue;
            if (byArray[2] == 1) {
                int n3 = byArray[3] * 100 + byArray[4];
                if (dj.j) {
                    n3 <<= 1;
                }
                r.e(n3);
                this.b.removeElementAt(i2);
                this.a((byte)1, byArray[3], byArray[4], true);
                return true;
            }
            bl2 = true;
            bp bp2 = r.a(byArray[3]);
            if (!bp2.a(byArray[3], byArray[4], 1)) continue;
            bp2.a(dg.a(byArray[3], byArray[4]), 1);
            this.b.removeElementAt(i2);
            this.a((byte)0, byArray[3], byArray[4], true);
            if (byArray[3] == 20) {
                bh.d = true;
            }
            return true;
        }
        if (bl2) {
            this.a(byArray[2], byArray[3], byArray[4], false);
        }
        return false;
    }

    private final void a(byte by2, byte by3, byte by4, boolean bl2) {
        byte[] byArray;
        cw cw2 = cw.a(120, 16);
        cr cr2 = cw2.a();
        cr2.a(0);
        cr2.a(0, 0, 120, 16);
        cr2.a(13682856);
        cr2.d(1, 1, 117, 13);
        cr2.a(0xFFFFFF);
        if (!bl2) {
            by3 = (byte)23;
            switch (by2) {
                case 16: {
                    by3 = (byte)21;
                    break;
                }
                case 18: {
                    by3 = (byte)22;
                }
            }
            byArray = rpg.c.g.a(by3);
        } else {
            byte[] byArray2;
            if (by2 == 1) {
                byArray2 = rpg.f.a(("" + (by3 * 100 + by4)).getBytes(), rpg.b.G);
                if (dj.j) {
                    byArray2 = rpg.f.a(byArray2, "x2".getBytes());
                }
            } else {
                dg dg2 = dg.a(by3, by4);
                byArray2 = by3 == 18 ? rpg.f.a(rpg.c.g.a(by3), dg2.c) : dg2.c;
                if (dg2 instanceof bs) {
                    cr2.a(aw.e[((bs)dg2).b]);
                }
            }
            byArray = byArray2;
        }
        dv.a(cr2, 60, 1, byArray, 0, 1);
        boolean bl3 = false;
        for (int i2 = 0; i2 < 3; ++i2) {
            if (this.b[i2] != null) continue;
            this.b[i2] = cw2;
            ab.a[i2] = 15;
            bl3 = true;
            break;
        }
        if (!bl3) {
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

    public final c a(int n2, int n3) {
        if (n2 >= 0 && n3 >= 0 && n2 < c && n3 < d) {
            return this.a[n3][n2];
        }
        return null;
    }

    public final void a(df df2) {
        this.a.addElement(df2);
    }

    private void a(int n2, int n3, boolean bl2) {
        int n4;
        for (int i2 = n4 = this.a.size() - 1; i2 >= 0; --i2) {
            df df2 = (df)this.a.elementAt(i2);
            if (df2 == null) continue;
            df2.a(n2, n3, bl2);
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

    private int a(int n2, int n3, int n4) {
        if (n3 < 0 || n4 < 0 || n3 >= c || n4 >= d) {
            return -1;
        }
        int n5 = n4;
        n4 = n3;
        ab ab2 = this;
        int n6 = n4 < 0 || n5 < 0 || n4 >= c || n5 >= d ? 0 : ab2.a[n5 * c + n4];
        n2 = (n6 & 0x40) != 0 || (n6 & 0x80) != 0 ? b[(n2 << 1) + 1] : b[n2 << 1];
        if ((n6 & 0x3F) != 0) {
            n2 = 3767807;
        }
        return n2;
    }

    public final void a(cr cr2) {
        Object object;
        int n2 = c * f;
        int n3 = d * f;
        n2 = rpg.a.c - (n2 >> 1);
        n3 = 8 + rpg.a.b >= 300 ? bh.h - n3 >> 1 : rpg.a.b - n3 >> 1;
        int n4 = n3;
        if (bh.e || rpg.a.a) {
            object = this.b();
            int n5 = rpg.a.a - dv.a(object) >> 1;
            int n6 = n2 < n5 - 5 ? n2 : n5 - 5;
            int n7 = n4 - 15 > 0 ? n4 - 15 : 0;
            int n8 = rpg.a.c - n6 << 1;
            int n9 = 15 + a.b();
            cr2.a(0);
            cr2.a(0, 0, rpg.a.a, rpg.a.b - 33);
            cr2.a(10159117);
            cr2.a(0, 0, rpg.a.a, 15);
            cr2.a(0x777777);
            dv.a(cr2, n5 + 1, 2, object, 1);
            cr2.a(0xFFFFFF);
            dv.a(cr2, n5, 1, object, 1);
            cr2.a(a, n2, n4, 20);
            if (rpg.e.d && this.h >= 0 && this.i >= 0) {
                cr2.a(0xFF0000);
                cr2.b(n6, n7, n8, n9);
                n4 = rpg.c.p.a();
                int n10 = rpg.c.p.b();
                n5 = n2 + this.h * f;
                n6 = n3 + this.i * f;
                cr2.b(n5 + 1, n6, n4, n10);
                cr2.a(rpg.c.p, n5 + 1, n6, 20);
                cr2.b(0, 0, rpg.a.a, rpg.a.b);
            }
        }
        object = r.a;
        cr2.a(rpg.a.e % 2 == 1 ? 0xFF0000 : 0x7F7F7F);
        cr2.a(n2 + object.c * f, n3 + object.d * f, (int)f, (int)f);
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
        int n2 = c * f;
        int n3 = d * f;
        a = cw.a(n2, n3);
        cr cr2 = a.a();
        cr2.a(0);
        cr2.a(0, 0, n2, n3);
        int n4 = 2;
        switch (this.ab[0]) {
            case 0: 
            case 2: {
                n4 = 0;
                break;
            }
            case 1: 
            case 6: {
                n4 = 1;
            }
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                int n5;
                int n6 = i2;
                int n7 = i3;
                int n8 = n4;
                ab ab2 = this;
                boolean bl2 = false;
                int n9 = n7 >> 1;
                int n10 = n6 >> 1;
                int n11 = ab2.a(n8, n9, n10);
                if (n7 % 2 == 0 && n6 % 2 == 0) {
                    n7 = ab2.a(n8, n9 - 1, n10);
                    n5 = ab2.a(n8, n9, n10 - 1);
                } else if (n7 % 2 == 1 && n6 % 2 == 0) {
                    n7 = ab2.a(n8, n9 + 1, n10);
                    n5 = ab2.a(n8, n9, n10 - 1);
                } else if (n7 % 2 == 0 && n6 % 2 == 1) {
                    n7 = ab2.a(n8, n9 - 1, n10);
                    n5 = ab2.a(n8, n9, n10 + 1);
                } else {
                    n7 = ab2.a(n8, n9 + 1, n10);
                    n5 = ab2.a(n8, n9, n10 + 1);
                }
                if (n7 == -1) {
                    n7 = n11;
                }
                if (n5 == -1) {
                    n5 = n11;
                }
                if (n11 != n7 && n11 != n5) {
                    bl2 = true;
                }
                if (n11 == 3767807) {
                    bl2 = false;
                }
                if (bl2) {
                    n8 = ((n11 & 0xFF) + (n7 & 0xFF) + (n5 & 0xFF)) / 3;
                    n6 = ((n11 >> 8 & 0xFF) + (n7 >> 8 & 0xFF) + (n5 >> 8 & 0xFF)) / 3;
                    n5 = ((n11 >> 16 & 0xFF) + (n7 >> 16 & 0xFF) + (n5 >> 16 & 0xFF)) / 3;
                    n8 = n8 > 255 ? 255 : n8;
                    n6 = n6 > 255 ? 255 : n6;
                    n5 = n5 > 255 ? 255 : n5;
                    n11 = n8 + (n6 << 8) + (n5 << 16);
                }
                n5 = n11;
                cr2.a(n5);
                cr2.a(i3 << 1, i2 << 1, 2, 2);
            }
            if (i2 % 10 != 1) continue;
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
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            br br2 = this.a[i2];
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

