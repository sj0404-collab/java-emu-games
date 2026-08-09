/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;
import rpg.a;
import rpg.b;
import rpg.d;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class x
extends do {
    private byte i;
    private byte j;
    byte f;
    private byte[] b;
    private byte[] Z;
    public byte[] a;
    private boolean[] a;
    private boolean[] b;
    private byte[] aa;
    private ct a;
    private ai a;
    private boolean h;
    private boolean i;
    public byte g;
    private byte[] ab;
    private byte k;
    private byte l;
    private byte m;
    private byte n;
    private int[] a;
    private int[] b;
    private short[] a;
    private int[] c;
    private byte[] ac;
    private short e;
    private byte o;
    private int h;
    private int i;
    public int a;
    private byte u;
    private byte v;
    short c;
    public short d;
    private bs[] a;
    private byte w = 0;
    private byte x;
    private boolean j;
    private byte y;
    public int b = -1;
    private int j = -1;
    private boolean k;
    private boolean l;
    public int c;
    public boolean e;
    public int d = -1;
    public boolean f = false;
    private int k = 0;
    public int e = 0;
    public static byte h = (byte)-1;
    private int l = false;
    private byte z = 0;
    private boolean m = true;
    private static int m = 5;
    private int n = 0;
    public static long a = 0L;
    public static boolean g = false;
    private byte A = 0;
    private Vector c = -1;

    private x(short s2, short s3, byte by2, byte by3) {
        super((short)0, (short)0, (byte)8, (byte)9);
        this.y = (byte)-1;
    }

    public static x a(byte by2) {
        int n2;
        int n3;
        x x2;
        x x3 = x2 = new x(0, 0, 8, 9);
        x2.n = 1;
        x3.d = 0;
        x3.c = 0;
        x3.b = rpg.c.a("/hero/hsd2");
        x3.a = new bs[7];
        x3.a = new short[4];
        x3.c = new int[4];
        x3.ac = new byte[6];
        x3.a = new int[4];
        x3.b = new int[4];
        bh.a = new boolean[4];
        for (n3 = 0; n3 < 4; ++n3) {
            bh.a[n3] = false;
        }
        x3.v = (byte)100;
        x3.u = (byte)100;
        x3.aa = new byte[48];
        x3.Z = new byte[20];
        x3.G();
        n3 = x3.aa.length;
        for (n2 = 0; n2 < n3; ++n2) {
            x3.aa[n2] = -1;
        }
        n3 = x3.Z.length;
        for (n2 = 0; n2 < n3; ++n2) {
            x3.Z[n2] = -1;
        }
        ((c)x3).c = true;
        x3.v();
        x3.k = 1;
        x3.h = 1;
        x3.m = 0;
        x3.j = -1;
        x3.b = -1;
        x3.u();
        x3.H();
        v0.z = 0;
        x2.l(by2);
        x3 = x2;
        ai ai2 = new ai(x3);
        ai2.a();
        ai2.f();
        for (n2 = 0; n2 < 2; ++n2) {
            ai2.b(n2 + 2);
        }
        ai2.d();
        x3.a = ai2;
        return x2;
    }

    private void l(byte by2) {
        ct ct2 = null;
        switch (by2) {
            case 0: {
                ct2 = new dy(this);
                break;
            }
            case 1: {
                ct2 = new ci(this);
                break;
            }
            case 2: {
                ct2 = new ac(this);
                break;
            }
            case 3: {
                ct2 = new dw(this);
                break;
            }
            case 4: {
                ct2 = new dr(this);
                break;
            }
            case 5: {
                ct2 = new y(this);
            }
        }
        ct2.b(by2);
        bo.h();
        this.a = ct2;
    }

    public final void a_(byte by2) {
        for (byte by3 = 0; by3 < 2; by3 = (byte)(by3 + 1)) {
            r.a(by3, true);
        }
        r.b = by2;
        this.l(by2);
        this.b(false);
        rpg.c.c();
    }

    public final void b(boolean bl2) {
        int n2;
        int n3 = r.b;
        x x2 = this;
        int n4 = n3;
        x x3 = x2;
        int n5 = 0;
        for (n2 = 0; n2 < n4; ++n2) {
            n5 += 8;
        }
        if (x3.aa[n5] < 0) {
            x3.aa[n5] = 0;
        }
        if (!x.d((byte)n4)) {
            for (n2 = 2; n2 < 6; ++n2) {
                x3.aa[n5 + n2] = -2;
            }
        }
        n2 = n5 + 6;
        for (n4 = 0; n4 < 2; ++n4) {
            if (x3.aa[n2 += n4] >= 0) continue;
            x3.aa[n2] = 0;
        }
        n4 = n3;
        x3 = x2;
        n5 = 0;
        for (n2 = 0; n2 < n4; n2 = (byte)(n2 + 1)) {
            n5 += x.d((byte)n2) ? 4 : 2;
        }
        n2 = x.d((byte)n4) ? 4 : 2;
        for (n4 = 0; n4 < n2; ++n4) {
            if (x3.Z[n5 + n4] >= 0) continue;
            x3.Z[n5 + n4] = 0;
        }
        x2.c();
        r.j();
        this.H();
        this.a.c();
        this.k();
        if (bl2) {
            if (r.b == 4 || r.b == 5) {
                this.n = (byte)40;
                this.c = (short)(this.c + 156);
                this.d = (short)(this.d + 20);
            }
            int n6 = 0;
            x x4 = this;
            n3 = x4.b[n6];
            n6 = 0;
            x4 = this;
            x4.a[n6] = n3;
            n6 = 1;
            x4 = this;
            n3 = x4.b[n6];
            n6 = 1;
            x4 = this;
            x4.a[n6] = n3;
            n6 = 3;
            x4 = this;
            n3 = x4.b[n6];
            n6 = 3;
            x4 = this;
            x4.a[n6] = n3;
        }
    }

    private void u() {
        for (int i2 = 0; i2 < 6; ++i2) {
            int n2 = i2 * 8 + 6;
            this.aa[n2] = 3;
            this.aa[n2 + 1] = 3;
        }
    }

    public final byte a(byte by2) {
        by2 = (byte)((r.b << 3) + by2 - 4);
        return this.aa[by2];
    }

    public final void a(byte by2, byte by3) {
        int n2;
        byte by4 = by2 = (byte)((by2 << 3) + by3 - 4);
        this.aa[by4] = (byte)(this.aa[by4] + 1);
        by3 = by2;
        x x2 = this;
        int n3 = n2 = x.d(r.b) ? 6 : 2;
        if (by3 % 8 < n2 - 1 && x2.aa[by3 + 1] == -1) {
            x2.aa[by3 + 1] = 0;
        }
    }

    public final int a(byte by2) {
        return this.a.c(by2);
    }

    private int a(byte by2, int n2, boolean bl2) {
        return this.a.a(by2, n2, false);
    }

    public final void a(int n2) {
        int n3 = n2;
        this.Z[n3] = (byte)(this.Z[n3] + 1);
    }

    final void b() {
        super.b();
        this.w();
    }

    final void c(boolean bl2) {
        this.y();
        this.w();
        if (bl2) {
            x x2 = this;
            x2.v();
            x2.b();
            x x3 = x2;
            if (x3.b > 0) {
                x3.b = -1;
                x3.I();
            }
            if (x3.j > 0) {
                x3.j = -1;
                x3.J();
            }
            x2.N();
            x2.k();
        }
    }

    private void v() {
        this.j = false;
        this.y = (byte)-1;
        this.k = false;
        this.l = false;
        this.e = false;
        this.f = false;
        this.k = 0;
        this.d = -1;
        ((do)this).g = -1;
    }

    private void w() {
        this.ab = new byte[(r.b == 5 ? 6 : 4) + 2];
        this.x();
        this.h = false;
        this.i = false;
        this.w = 0;
        this.x = 0;
        h = (byte)-1;
        if (this.a != null) {
            this.a.a(false);
        }
        x x2 = this;
        this.z = 0;
    }

    private final void x() {
        for (int i2 = 0; i2 < this.ab.length; ++i2) {
            this.ab[i2] = -1;
        }
        this.l = (byte)-1;
    }

    public final void c() {
        this.k = this.a.b();
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(int n2, int n3) {
        block15: {
            if (a > 0L) {
                ++this.n;
                if (this.n > 5) {
                    this.n = 0;
                } else if (this.n < 2) {
                    return;
                }
            }
            if (!((c)this).c) {
                return;
            }
            n2 = n2 + ((c)this).a + ((c)this).a;
            n3 = n3 + ((c)this).b + ((c)this).b - 1;
            if (this.w == 1) {
                n2 += rpg.b.S[this.x] * 3;
                n3 += rpg.b.T[this.x] * 3;
                this.w = (byte)(this.w - 1);
            }
            this.b(n2, n3, false);
            cr cr2 = rpg.a.a;
            cr2.a(rpg.c.e[this.i ? 1 : 0], n2, n3 + 6, 33);
            switch (this.p) {
                case 3: {
                    if (this.l < 0) break;
                    this.b(this.ab[this.l] + 6, n2, n3);
                    break block15;
                }
                case 2: {
                    this.b((int)this.j, n2, n3);
                    break block15;
                }
                case 7: {
                    ((do)this).f = 8;
                }
                case 6: {
                    x.a(n2, n3, ((do)this).f);
                    break block15;
                }
                case 9: {
                    this.b(7, n2, n3);
                    break block15;
                }
                case 10: {
                    this.b(5, n2, n3);
                    break block15;
                }
                case 99: {
                    this.b((int)this.i, n2, n3);
                    break block15;
                }
            }
            this.b((int)this.f, n2, n3);
        }
        this.b(n2, n3, true);
        this.d(n2, n3);
    }

    private final void b(int n2, int n3, int n4) {
        ((do)this).f = rpg.c.a.a((byte)n2, this.q, ((do)this).f, n3, n4);
    }

    public static void a(int n2, int n3, int n4) {
        rpg.c.a.a((byte)4, (byte)1, n4, n2, n3);
    }

    final void d() {
        byte by2;
        int n2;
        super.d();
        if (a > 0L) {
            g = true;
        }
        ++((do)this).f;
        if (r.d == 3) {
            if (this.m > 0) {
                this.m = (byte)(this.m - 1);
            }
            if (this.d > 0) {
                --this.d;
            }
            x x2 = this;
            switch (x2.p) {
                case 1: {
                    x2.u = (byte)(x2.u - 2);
                    x2.v = (byte)(x2.v - 2);
                    break;
                }
                case 2: {
                    x2.u = (byte)(x2.u - 1);
                    x2.v = (byte)(x2.v - 1);
                }
            }
            if (x2.u <= 0) {
                x2.c(x2.l);
                x2.u = (byte)100;
            }
            if (x2.v <= 0) {
                n2 = x2.l;
                x x3 = x2;
                x3.c((byte)1, n2);
                x2.v = (byte)100;
            }
            for (by2 = 0; by2 < 5; by2 = (byte)(by2 + 1)) {
                if (r.a[by2] < 0) continue;
                byte by3 = by2;
                r.a[by3] = r.a[by3] - 1;
            }
            x2 = this;
            if (x2.b > 0) {
                --x2.b;
                if (x2.b == 0) {
                    x2.I();
                }
            }
            if (x2.j > 0 && x2.p != 10) {
                --x2.j;
                if (x2.j == 0) {
                    x2.J();
                }
            }
            this.a.b();
        }
        this.z();
        this.B();
        byte by4 = this.p;
        if (this.k()) {
            this.h = false;
        }
        by2 = by4;
        x x4 = this;
        n2 = 0;
        if (x4.p != 3 && !x4.h) {
            n2 = m.a(x4) ? 1 : 0;
            x4.h = true;
        }
        if (n2 == 0 && by2 == 2 && x4.p == 1) {
            n2 = m.b() ? 1 : 0;
        }
        if (n2 != 0) {
            x4.a((byte)1);
            x4.s = 0;
            ((do)x4).f = 0;
        }
    }

    public final void e() {
        this.A = 1;
    }

    public final void f() {
        a = 5000L;
        this.A = (byte)2;
        int n2 = 0;
        x x2 = this;
        int n3 = x2.b[n2];
        n2 = 0;
        x2 = this;
        x2.a[n2] = n3;
        n2 = 1;
        x2 = this;
        n3 = x2.b[n2];
        n2 = 1;
        x2 = this;
        x2.a[n2] = n3;
        n2 = 3;
        x2 = this;
        n3 = x2.b[n2];
        n2 = 3;
        x2 = this;
        x2.a[n2] = n3;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void B() {
        switch (this.p) {
            case 2: {
                x x2 = this;
                this.z = 0;
                this.A();
                this.o(4);
                return;
            }
            case 3: {
                x x3 = this;
                if (x3.l < 0) {
                    x3.l = 0;
                }
                if (x3.ab[x3.l] < 100 && ((do)x3).f == x.a(6 + x3.ab[x3.l])) {
                    if (x3.l + 1 >= x3.k && x3.ab[x3.l + 1] < 4 || x3.ab[x3.l + 1] == -1) {
                        x3.b((int)x3.l);
                        return;
                    }
                    x3.l = (byte)(x3.l + 1);
                    ((do)x3).f = 0;
                }
                int n2 = x3.ab[x3.l];
                if (((do)x3).f <= 0) {
                    boolean bl2;
                    if (x3.z > 0 && n2 < 4) {
                        x3.b((int)x3.l);
                        return;
                    }
                    if (n2 >= 100) {
                        n2 = (byte)(x3.ab[x3.l] - 100);
                        if (x3.a.d((byte)n2)) {
                            x3.x();
                            return;
                        }
                        x3.b((int)x3.l);
                        return;
                    }
                    if (!x3.a.a((byte)n2)) {
                        x3.b((int)x3.l);
                        x3.g((byte)6);
                        return;
                    }
                    int n3 = n2;
                    x x4 = x3;
                    n3 = x4.a.b((byte)n3);
                    int n4 = 0;
                    x x5 = x4;
                    n3 = x5.a[n4] ? x4.b((byte)0, n3) : n3;
                    n4 = 1;
                    x5 = x4;
                    if (n3 > x5.a[n4]) {
                        bl2 = false;
                    } else {
                        if (n3 > 0) {
                            n4 = -n3;
                            x5 = x4;
                            x5.c((byte)1, n4);
                        }
                        bl2 = true;
                    }
                    if (!bl2) {
                        x3.b((int)x3.l);
                        x3.g((byte)2);
                        return;
                    }
                    r.b((byte)n2, true);
                    if (x3.a.b((byte)n2)) {
                        x3.i();
                    }
                }
                if (x3.a.a((byte)n2, ((do)x3).f)) return;
                bo.a((byte)11);
                return;
            }
            case 6: {
                if (((do)this).f < 8) return;
                this.a((byte)7);
                if (!m.c()) return;
                if (j.a) {
                    bo.f();
                    r.a((byte)9);
                    return;
                }
                r.d = (byte)5;
                dj.a().b();
                dj.a().c((byte)3);
                bd bd2 = (bd)((ah)dj.a()).b;
                bd2.b();
                return;
            }
            case 7: {
                if (this.A == 1) {
                    bo.f();
                    r.a((byte)9);
                    this.A = 0;
                    return;
                }
                if (this.A != 2) return;
                this.a[0] = this.b[0];
                this.a((byte)1);
                this.x();
                this.A = 0;
                return;
            }
            case 0: {
                x x6 = this;
                this.z = 0;
                return;
            }
            case 1: {
                this.s = 0;
                this.o(x.a((int)this.f));
                return;
            }
            case 9: {
                if (((do)this).f < 4) return;
                byte by2 = this.z;
                this.z = 0;
                if (by2 > 0) {
                    r.b((byte)2, by2);
                    r.c((byte)0, (byte)0);
                    return;
                }
                this.C();
                return;
            }
            case 99: {
                this.o(x.a((int)this.i));
                return;
            }
            case 10: {
                if (((do)this).f >= x.a(5)) {
                    this.a.e();
                    this.C();
                    return;
                }
                if (((do)this).f != 0) return;
                bo.a((byte)0);
                return;
            }
        }
    }

    private void C() {
        byte by2 = r.c;
        switch (by2) {
            case 1: 
            case 3: 
            case 9: 
            case 10: {
                this.a(by2);
                r.c((byte)0, (byte)0);
                ((do)this).f = 0;
                this.B();
                return;
            }
        }
        this.a((byte)1);
    }

    static byte a(int n2) {
        return rpg.c.a.a((byte)n2);
    }

    public final int b(byte by2) {
        int n2 = this.a((byte)1, (int)(by2 = (byte)this.a.a(by2)));
        if (n2 > 0) {
            return n2;
        }
        return by2;
    }

    final void g() {
        if (this.l()) {
            ((do)this).f = 0;
            this.p(this.t);
        }
    }

    final boolean a_(byte by2) {
        if (this.m > 0 || this.l + 1 >= this.k) {
            return false;
        }
        if (this.ab[this.l + 1] < 4) {
            if (by2 > 0) {
                if (this.l >= 0 && this.ab[this.l] == by2) {
                    return false;
                }
                this.ab[this.l + 1] = by2;
                return true;
            }
            x x2 = this;
            boolean bl2 = x2.b > 0 ? (x2.l >= 0 && x2.ab[x2.l] >= 4 && x2.ab[x2.l] < 6 ? false : x2.l < 0 || x2.ab[x2.l] < 11) : x2.l < 0 || x2.ab[x2.l] < 4;
            if (bl2) {
                switch (r.b) {
                    case 3: {
                        this.ab[this.l + 1] = 0;
                        break;
                    }
                    case 5: {
                        if (this.b > 0) {
                            this.ab[this.l + 1] = (byte)(this.l + 1 + 6);
                            return true;
                        }
                    }
                    default: {
                        this.ab[this.l + 1] = (byte)(this.l + 1);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void b(byte by2) {
        this.ab[this.l + 1] = by2;
    }

    public final void b(int n2) {
        this.m = n2 < 2 && this.ab[n2] <= 0 ? (byte)2 : (byte)4;
        n2 = this.z;
        if (r.b == 3) {
            this.a((byte)9);
        } else if (n2 > 0) {
            x x2 = this;
            this.z = 0;
            r.b((byte)2, (byte)n2);
            r.c((byte)0, (byte)0);
        } else {
            this.a((byte)1);
        }
        ((do)this).f = 0;
        this.x();
    }

    public final void c(byte by2) {
        this.z = by2;
    }

    public final void h() {
        this.z = 0;
    }

    public final void i() {
        this.i(this.a());
    }

    public final int a(boolean bl2) {
        int n2 = (bl2 = bl2 ? this.i : this.h) ? 1 : 0;
        if (this.f) {
            return (bl2 << 2) / 5;
        }
        return bl2 ? 1 : 0;
    }

    public final int b(boolean bl2) {
        int n2;
        bs bs2 = bl2 ? this.a((byte)5) : this.a((byte)3);
        int n3 = this.a(bl2);
        if (bs2 != null) {
            n2 = n3 + (bs2.c - bs2.b);
        }
        return n2;
    }

    /*
     * WARNING - void declaration
     */
    public final int c(boolean bl2) {
        void var1_6;
        int n2;
        bs bs2 = bl2 ? this.a((byte)5) : this.a((byte)3);
        int x2 = this.a(bl2);
        if (bs2 != null) {
            int n3 = rpg.f.a(1, 100) + this.a.a((byte)4);
            if (n3 > 100) {
                n3 = 100;
            }
            n2 = x2 + (bs2.c - bs2.b) * n3 / 100;
        }
        if (this.b > 0) {
            int n4 = 3;
            x x3 = this;
            void var1_5 = n2 + x3.c[n4];
        }
        return (int)var1_6;
    }

    final boolean a(db db2, byte by2, int n2, byte by3, byte by4, boolean bl2, boolean bl3, boolean bl4) {
        if (db2 != null) {
            return db2.a(this, by2, n2, bl2, by3, by4, bl3, true, bl4);
        }
        return false;
    }

    public final boolean a(byte by2, int n2, byte by3, boolean bl2, boolean bl3, boolean bl4) {
        db db2 = this.a();
        return this.a(db2, by2, n2, this.q, by3, bl2, false, false);
    }

    public final boolean a(byte by2, int n2, byte by3, boolean bl2, boolean bl3) {
        by2 = 0;
        byte by4 = this.q;
        db by42 = this.b(by4);
        if (by42 != null) {
            by2 = this.a(by42, (byte)7, n2, by4, by3, false, bl2, false) ? 1 : 0;
        }
        for (byte by5 = 1; by5 <= 3; by5 = (byte)(by5 + 1)) {
            if (this.a(by4, by4, by5, (byte)7, n2, by3, bl2, false)) {
                by2 = 1;
            }
            if (this.a(rpg.b.V[by4], by4, by5, (byte)7, n2, by3, bl2, false)) {
                by2 = 1;
            }
            if (!this.a(rpg.b.U[by4], by4, by5, (byte)7, n2, by3, bl2, false)) continue;
            by2 = 1;
        }
        return by2 != 0;
    }

    private boolean a(byte by2, byte by3, byte by4, byte by5, int n2, byte by6, boolean bl2, boolean bl3) {
        db db2 = this.a(by2, by3, (int)by4);
        if (db2 != null) {
            return this.a(db2, by5, n2, by3, by6, bl3, bl2, false);
        }
        return false;
    }

    private db a(byte by2, byte by3, int n2) {
        c c2 = this.a(by2, by3, (byte)n2);
        if (c2 != null && c2 instanceof db) {
            return (db)c2;
        }
        return null;
    }

    public final db a(byte by2) {
        c c2 = c.a(((c)this).c, ((c)this).d, by2, (byte)0, (byte)0);
        if (c2 != null && c2 instanceof db && !(c2 instanceof an)) {
            return (db)c2;
        }
        return null;
    }

    public final boolean a(byte by2, int n2, byte by3) {
        by2 = 0;
        for (byte by4 = 1; by4 <= 12; by4 = (byte)(by4 + 1)) {
            db db2 = this.a(by4);
            if (db2 == null || !this.a(db2, (byte)9, n2, by4, by3, false, false, false)) continue;
            by2 = 1;
        }
        return by2 != 0;
    }

    protected final db a() {
        c c2 = this.a(this.q, (c)null);
        if (c2 != null && c2 instanceof db && !(c2 instanceof an) && !((db)c2).d()) {
            return (db)c2;
        }
        return null;
    }

    private void a(db db2) {
        if (db2 != null) {
            this.c.addElement(db2);
        }
    }

    public final Vector a(byte by2) {
        this.c = new Vector(0);
        switch (by2) {
            case 0: {
                this.a(this.a());
                break;
            }
            case 1: {
                this.a(this.a());
                this.a(this.b((byte)(this.q + 8)));
                break;
            }
            case 2: {
                this.a(this.b(rpg.b.X[this.q]));
                this.a(this.a());
                this.a(this.b(rpg.b.W[this.q]));
                break;
            }
            case 3: {
                this.a(this.b(rpg.b.X[this.q]));
                this.a(this.b(rpg.b.V[this.q]));
                this.a(this.a());
                this.a(this.b(rpg.b.U[this.q]));
                this.a(this.b(rpg.b.W[this.q]));
                break;
            }
            case 4: {
                for (by2 = 0; by2 < 3; by2 = (byte)(by2 + 1)) {
                    this.a(this.a(rpg.b.X[this.q], this.q, by2 + 1));
                    this.a(this.a((byte)0, this.q, by2 + 1));
                    this.a(this.a(rpg.b.W[this.q], this.q, by2 + 1));
                }
                break;
            }
        }
        return this.c;
    }

    final byte a() {
        db db2 = this.a();
        if (db2 == null) {
            if (this.b(rpg.b.X[this.q]) != null) {
                return rpg.b.X[this.q];
            }
            if (this.b(rpg.b.W[this.q]) != null) {
                return rpg.b.W[this.q];
            }
            if (this.b(rpg.b.Y[this.q]) != null) {
                return rpg.b.Y[this.q];
            }
        }
        return this.q;
    }

    public final db b() {
        db db2 = this.c(this.q);
        if (db2 != null) {
            return db2;
        }
        db2 = this.c(rpg.b.X[this.q]);
        if (db2 != null) {
            this.i(rpg.b.X[this.q]);
            return db2;
        }
        db2 = this.c(rpg.b.W[this.q]);
        if (db2 != null) {
            this.i(rpg.b.W[this.q]);
            return db2;
        }
        db2 = this.c(rpg.b.Y[this.q]);
        if (db2 != null) {
            this.i(rpg.b.Y[this.q]);
            return db2;
        }
        return db2;
    }

    private db c(byte by2) {
        db db2 = this.b(by2);
        if (db2 == null) {
            for (int n2 = 0; n2 < 3 && (db2 = this.a(by2, by2, n2)) == null && (db2 = this.a(rpg.b.V[by2], by2, n2)) == null && (db2 = this.a(rpg.b.U[by2], by2, n2)) == null; n2 = (int)((byte)(n2 + 1))) {
            }
        }
        if (db2 != null && db2.d()) {
            return null;
        }
        return db2;
    }

    public final void d(boolean bl2) {
        this.i = bl2;
    }

    public final boolean a(byte by2, byte by3, byte by4, int n2) {
        boolean bl2 = false;
        this.g = (byte)this.a(by3, true, this.q);
        if (this.g > 0) {
            if (n2 > 0 || n2 == -1 || n2 == -100) {
                if (this.a(by2, n2, by4, false, false, false)) {
                    bl2 = true;
                }
                if (this.g != 1) {
                    db db2;
                    byte by5 = by4;
                    by4 = this.q;
                    by3 = by2;
                    x x2 = this;
                    db db3 = x2.b((byte)(by4 + 8));
                    if (db3 != null && (db2 = x2.b(by4)) != db3 ? x2.a(db3, by3, n2, x2.q, by5, false, false, false) : false) {
                        bl2 = true;
                    }
                }
            }
            this.p(16 * this.g);
        } else if (this.a(by2, n2, by4, false, false, false)) {
            bl2 = true;
            this.g = 0;
        }
        return bl2;
    }

    public final boolean b(byte by2) {
        this.g = (byte)this.a((byte)3, false, this.q);
        if (this.g > 0) {
            this.p(16 * this.g);
        }
        return this.g != 3;
    }

    private int a(byte n2, boolean bl2, byte by2) {
        ab ab2 = r.a;
        int n3 = ((c)this).c;
        int n4 = ((c)this).d;
        int n5 = 0;
        for (int i2 = 1; i2 <= n2; ++i2) {
            if ((n3 += rpg.b.S[by2]) < 0 || (n4 += rpg.b.T[by2]) < 0 || n3 >= ab.c || n4 >= ab.d) continue;
            if (ab2.a((c)this, n3, n4)) {
                if (bl2) continue;
                return n5;
            }
            if (ab2.b(n3, n4) || ab2.c(n3, n4)) {
                return n5;
            }
            n5 = i2;
        }
        return n5;
    }

    final void c(int n2) {
        if (a > 0L && n2 < 0) {
            n2 = 0;
        }
        this.c((byte)0, bh.b ? 0 : n2);
        if (this.a[0] <= 0) {
            this.a((byte)6);
            ((do)this).f = 0;
        }
    }

    final void d(int n2) {
        this.c((byte)1, n2);
    }

    final void e(int n2) {
        this.c((byte)3, n2);
    }

    private final void D() {
        int n2;
        int n3 = n2 = r.b == 5 ? this.a((byte)10) : 2;
        x x2 = this;
        x2.c((byte)3, n3);
    }

    public final void j() {
        x x2 = this;
        if (x2.n > 99 - m) {
            this.n = (byte)99;
            this.c = (short)(this.c + (short)(4 * (99 - this.n)));
            this.d = (short)(this.d + 1 * (99 - this.n >> 1));
        } else {
            this.n = (byte)(this.n + m);
            this.c = (short)(this.c + (short)(4 * m));
            this.d = (short)(this.d + 1 * (m >> 1));
        }
        this.k();
        int n2 = 0;
        x2 = this;
        int n3 = x2.b[n2];
        n2 = 0;
        x2 = this;
        x2.a[n2] = n3;
        n2 = 1;
        x2 = this;
        n3 = x2.b[n2];
        n2 = 1;
        x2 = this;
        x2.a[n2] = n3;
        n2 = 3;
        x2 = this;
        n3 = x2.b[n2];
        n2 = 3;
        x2 = this;
        x2.a[n2] = n3;
    }

    final void f(int n2) {
        if (dj.i || j.a && this.n < 20) {
            n2 <<= 1;
        }
        this.a[2] = this.a[2] + (n2 < 0 ? -n2 : n2);
        while (this.a[2] >= this.b[2]) {
            this.a[2] = this.a[2] - this.b[2];
            if (this.n < 99) {
                this.n = (byte)(this.n + 1);
                this.k();
                this.c = (short)(this.c + 4);
                if (this.n % 2 == 0) {
                    this.d = (short)(this.d + 1);
                }
                this.c(new bj(8));
                if (!r.a) {
                    r.a = true;
                    rpg.d.a();
                    r.f = true;
                    r.a = rpg.c.a.a(11);
                }
            }
            this.g(100);
            this.r(100);
            this.a[3] = 100;
            bh.a[2] = true;
        }
        bh.a[2] = true;
    }

    final void g(int n2) {
        n2 = this.b[0] * n2 / 100;
        this.c(n2);
    }

    private void r(int n2) {
        int n3 = n2 = this.b[1] * n2 / 100;
        x x2 = this;
        x2.c((byte)1, n3);
    }

    private void c(byte by2, int n2) {
        byte by3 = by2;
        this.a[by3] = this.a[by3] + n2;
        if (this.a[by2] > this.b[by2]) {
            this.a[by2] = this.b[by2];
        } else if (this.a[by2] < 0) {
            this.a[by2] = 0;
        }
        bh.a[by2] = true;
    }

    public final void k() {
        int n2;
        int n3;
        int n4;
        bs bs2;
        int n5;
        int n6;
        this.m = false;
        Object object = this;
        this.b = new boolean[7];
        for (n6 = 0; n6 < 7; ++n6) {
            ((x)object).b[n6] = false;
        }
        ((x)object).N();
        n6 = 0;
        if (((x)object).a(2)) {
            ((x)object).s(2);
            n6 = 1;
            ((x)object).M();
        }
        int n7 = n6 = n6 != 0 ? 3 : 0;
        while (n6 < 6) {
            if (n6 != 2 && super.a(n6)) {
                super.s(n6);
                break;
            }
            ++n6;
        }
        object = new int[4];
        n6 = 10 + (this.b[0] ? 4 : 0);
        for (int i2 = 0; i2 < 4; ++i2) {
            object[i2] = n6 + this.a[i2];
        }
        bs[] bsArray = this.a;
        for (n6 = 0; n6 < 7; ++n6) {
            if (bsArray[n6] == null) continue;
            for (n5 = 0; n5 < 4; ++n5) {
                Object object2 = object;
                int n8 = n5 + 0;
                object2[n8] = object2[n8] + bsArray[n6].a(n5 + 0);
                Object object3 = object;
                int n9 = n5 + 0;
                object3[n9] = object3[n9] + bsArray[n6].a(n5 + 10);
                Object object4 = object;
                int n10 = n5 + 0;
                object4[n10] = object4[n10] + bsArray[n6].a(15);
            }
        }
        this.c[0] = (int)(object[0] + this.a((byte)3, (int)object[0]) + this.a.a((byte)7, (int)object[0]));
        this.c[1] = (int)(object[1] + this.a((byte)13, (int)object[1]) + this.a.a((byte)7, (int)object[1]));
        this.c[2] = (int)(object[2] + this.a((byte)8, (int)object[2]) + this.a.a((byte)7, (int)object[2]));
        this.c[3] = (int)(object[3] + this.a.a((byte)7, (int)object[3]));
        if (r.b == 5) {
            this.c[3] = this.c[3] + this.a((byte)11, (int)object[3], false);
        }
        n5 = (bs2 = this.a((byte)3)) != null ? 1 : 0;
        object = this.a((byte)5);
        int n11 = object != null ? 1 : 0;
        int n12 = this.c[0] + this.c[1] / 4 + this.g((byte)6);
        switch (r.b) {
            case 1: {
                n12 += this.c[1] / 6 - this.c[0] / 3;
                break;
            }
            case 2: {
                n12 -= this.c[0] / 2;
                break;
            }
            case 3: {
                n12 -= this.c[1] / 6 + this.c[0] / 2;
            }
        }
        int n13 = bh.b ? 9999 : this.a((byte)15, this.c[1]) + this.a.a((byte)1);
        this.h = n12 + n13;
        this.i = 0;
        switch (r.b) {
            case 0: {
                if (n5 == 0) break;
                this.h += this.a((byte)11, (int)bs2.c, false);
                break;
            }
            case 2: {
                if (n11 == 0) break;
                this.i = n12 + n13;
                this.m = true;
                break;
            }
            case 1: 
            case 3: {
                if (n11 == 0) break;
                this.i = this.a((byte)11, n12, false) + n13 + ((bs)object).b;
                this.m = true;
            }
        }
        if (n5 != 0) {
            this.h += bs2.b;
            this.m = true;
        }
        this.o();
        int n14 = this.h((byte)1) + this.h((byte)4) + this.h((byte)6) + this.h((byte)0) + this.g((byte)7);
        if (r.b == 2) {
            n14 += this.h((byte)5);
        } else if (r.b == 0) {
            n14 += this.c[0] / 12;
        }
        this.a = n14 + this.a((byte)9, n14) + this.a.a((byte)0);
        this.E();
        this.F();
        byte by2 = (byte)(90 + this.g((byte)14));
        n14 = by2;
        if (by2 > 95) {
            n14 = 95;
        }
        this.a((byte)1, n14 += this.i((byte)2), false);
        this.a((byte)1, n14, true);
        this.e = (short)(10 + this.c[2] / 10 + this.i((byte)10));
        this.o = 0;
        if (r.b == 2 && this.a((byte)5) != null) {
            this.o = (byte)(5 + this.c[0] / 5 + (this.h((byte)5) >> 1));
            if (this.o > 75) {
                this.o = (byte)75;
            }
            this.o = (byte)(this.o + (byte)this.a((byte)11));
        }
        n11 = n14 = this.n * this.n * this.n - this.n * this.n + 80 * this.n;
        int n15 = 2;
        x x2 = this;
        x2.b[n15] = n11;
        n11 = n4 = 5 * this.n + 10 * this.c[3] + this.g((byte)4);
        n15 = 1;
        x x3 = this;
        x3.b[n15] = n11;
        int n16 = 10 * this.n + 12 * this.c[2] + this.g((byte)9);
        n16 += this.a.a((byte)2);
        if (r.b == 2) {
            n16 += this.c[2] / 5;
        }
        n11 = n16;
        n15 = 0;
        x x4 = this;
        x4.b[n15] = n11;
        n11 = n3 = 100 + this.i((byte)19);
        n15 = 3;
        x x5 = this;
        x5.b[n15] = n11;
        for (n2 = 0; n2 < 2; ++n2) {
            if (this.a[n2] <= this.b[n2]) continue;
            this.a[n2] = this.b[n2];
        }
        for (n2 = 0; n2 < 3; ++n2) {
            if (this.ac[n2] <= 100) continue;
            this.ac[n2] = 100;
        }
        this.l = this.c[3] + this.a.a((byte)3);
        bh.c = true;
    }

    private void E() {
        bs bs2 = this.a((byte)3);
        int n2 = bs2 != null ? 1 : 0;
        bs bs3 = this.a((byte)5);
        boolean bl2 = bs3 != null;
        int n3 = (this.c[1] >> 3) + this.g((byte)5);
        if (r.b == 3) {
            n3 += this.c[1] >> 4;
        }
        if (n3 > 50) {
            n3 = 50;
        }
        int n4 = (n3 += this.i((byte)5)) + (n2 != 0 ? bs2.e : (byte)0);
        n2 = n3 + (bl2 ? bs3.e : (byte)0);
        if (n4 > 70) {
            n4 = 70;
        }
        if (n2 > 70) {
            n2 = 70;
        }
        if (this.k) {
            n3 = this.a.b((byte)1);
            n4 += n3;
            n2 += n3;
        }
        this.a((byte)2, n4, false);
        this.a((byte)2, n2, true);
    }

    private void F() {
        int n2 = this.c[1] / 5 + this.g((byte)8);
        if (r.b == 1) {
            n2 += this.c[1] / 10;
        } else if (r.b == 2) {
            n2 -= this.c[1] / 10;
        }
        if (n2 > 75) {
            n2 = 75;
        }
        if ((n2 += this.i((byte)4)) > 80) {
            n2 = 80;
        }
        if (this.l) {
            n2 += this.a.b((byte)2);
        }
        if (n2 > 85) {
            n2 = 85;
        }
        this.a((byte)0, n2, false);
        this.a((byte)0, n2, true);
    }

    final boolean a(do do_, int n2, byte by2) {
        boolean bl2;
        int n3;
        if (this.p == 7 || this.p == 6) {
            return false;
        }
        if (do_ instanceof db) {
            bh.a((db)do_, true);
        }
        if (r.b == 2) {
            if (this.y > 1) {
                this.c(new dn(19));
                if ((n2 *= this.y / 10) <= 0) {
                    n2 = 5;
                }
            }
            if (this.j) {
                n3 = this.a((byte)7, this.a(true), false);
                this.c(new dn(18));
                do_.a(this, n3, (byte)0, (byte)3);
            }
            if (this.o > 0 && rpg.f.a(1, 100) > 100 - this.o) {
                this.c(new ax(-3));
                return false;
            }
        }
        if ((n3 = n2 * (rpg.f.a(0, 2) + 10) / 10 - this.c()) <= 0) {
            n3 = 5;
        }
        do do_2 = this;
        n2 = do_.c((byte)1) / 8 + do_.b() - do_2.n;
        do_ = this;
        int n4 = n2;
        byte by3 = 14;
        do_2 = do_;
        if (do_2.a[by3]) {
            by3 = 14;
            do_2 = do_;
            n4 = n2 - super.b(by3, 1);
        }
        if (bl2 = rpg.f.a(1, 99) < n4) {
            n3 += n3 / 2;
        }
        if (this.c > 0) {
            this.c = 0;
            if ((n3 -= this.c) <= 0) {
                this.c = -n3;
                n3 = 0;
            }
        }
        if ((n3 /= 3) <= 0) {
            n3 = 1;
        }
        this.e = n3;
        this.c(-n3);
        this.D();
        this.c(new ax(-4, -1, n3));
        this.c(new bj(bl2 ? (byte)3 : 4));
        this.w = 1;
        this.x = by2;
        return true;
    }

    protected final void a(do do_, int n2, byte by2, byte by3) {
        this.c(-n2);
        this.c(new ax(-4, -1, n2));
        this.c(new bj(2));
    }

    public final void d(byte by2) {
        byte by3 = by2;
        this.a[by3] = (short)(this.a[by3] + 1);
    }

    public final int c(byte by2) {
        return this.c[by2];
    }

    public final void a(byte by2, int n2) {
        this.a[by2] = n2;
    }

    public final int d(byte by2) {
        return this.a[by2];
    }

    public final int a() {
        return this.a[3];
    }

    public final int e(byte by2) {
        return this.b[by2];
    }

    public final int f(byte by2) {
        return this.ac[by2];
    }

    private final void a(byte by2, int n2, boolean bl2) {
        this.ac[by2 + (bl2 ? 3 : 0)] = (byte)n2;
    }

    public final int b() {
        int n2 = 0;
        x x2 = this;
        return x2.ac[n2];
    }

    public final int a(byte by2, boolean bl2) {
        byte by3;
        if (bl2) {
            int x2 = 2;
            x n4 = this;
            by3 = n4.ac[5];
        } else {
            int n2 = 2;
            x x2 = this;
            by3 = x2.ac[n2];
        }
        byte by4 = by3;
        int n3 = by3 + (this.n - by2);
        if (n3 > 90) {
            return 90;
        }
        return n3;
    }

    public final int a(int n2) {
        int n3 = 6;
        x x2 = this;
        if (x2.a[n3]) {
            return n2 + this.b((byte)6, n2);
        }
        return n2;
    }

    public final int c() {
        if (this.f) {
            return (this.a << 2) / 5;
        }
        return this.a;
    }

    public final void e(byte by2) {
        db db2 = this.b(by2);
        if (db2 != null) {
            db2.j(by2);
        }
    }

    final void l() {
        bp bp2 = r.a();
        int n2 = 0;
        int n3 = bp2.a();
        for (int n4 = 0; n4 < n3; n4 = (int)((byte)(n4 + 1))) {
            dg dg2 = bp2.a(n4);
            if (!(dg2 instanceof bs) || ((bs)dg2).f < 0) continue;
            this.a[((bs)dg2).f] = (bs)dg2;
            byte by2 = (byte)(n2 + 1);
            n2 = by2;
            if (by2 == 7) break;
        }
    }

    private int g(byte by2) {
        int n2 = 0;
        bs[] bsArray = this.a;
        for (int i2 = 0; i2 < 7; ++i2) {
            if (bsArray[i2] == null) continue;
            n2 += bsArray[i2].a(by2);
        }
        return n2;
    }

    public final byte b() {
        return this.n;
    }

    private int h(byte by2) {
        if (this.a[by2] != null) {
            return this.a[by2].d;
        }
        return 0;
    }

    public final bs a(byte by2) {
        if (by2 < 0) {
            return null;
        }
        return this.a[by2];
    }

    public final void a(byte by2, bs bs2) {
        if (bs2 != null) {
            this.f(by2);
            this.a[by2] = bs2;
            bs2.f = by2;
        }
    }

    public final void f(byte by2) {
        bs bs2 = this.a(by2);
        if (bs2 != null) {
            this.a(bs2);
        }
    }

    public final void a(bs bs2) {
        if (bs2 != null && bs2.f >= 0) {
            this.a[bs2.f] = null;
            bs2.f = (byte)-1;
        }
    }

    public final boolean a(do do_) {
        x x2 = this;
        int n2 = 1;
        x x3 = x2;
        x3 = this;
        int n3 = x2.ac[n2] + x3.n - do_.b() - do_.c((byte)1) / 5;
        if (this.b[4]) {
            n3 += n3 * 5 / 100;
        }
        return (do.a.nextInt() & 0xFF) % 100 < n3;
    }

    private int i(byte by2) {
        byte by3 = by2;
        x x2 = this;
        if (x2.a[by3]) {
            by3 = by2;
            x2 = this;
            return x2.b(by3, 1);
        }
        return 0;
    }

    private int a(byte by2, int n2) {
        byte by3 = by2;
        x x2 = this;
        if (x2.a[by3]) {
            return this.b(by2, n2);
        }
        return 0;
    }

    private int b(byte by2, int n2) {
        int n3 = by2 * 3;
        by2 = (byte)(this.Z[by2] + this.a.a((byte)5));
        return n2 * (this.b[n3] + this.b[n3 + 1] * by2) / this.b[n3 + 2];
    }

    public final byte b(byte by2) {
        return this.Z[by2];
    }

    public final void a(int n2, byte by2) {
        for (int i2 = 0; i2 < 4; ++i2) {
            if (this.a[i2] != by2) continue;
            this.a[i2] = -1;
        }
        this.h(n2);
        this.a[n2] = by2;
        this.a[by2] = true;
        if (by2 == 1) {
            r.j();
        }
    }

    public final void h(int n2) {
        byte by2 = this.a[n2];
        if (by2 >= 0) {
            this.a[by2] = false;
        }
        this.a[n2] = -1;
    }

    private void G() {
        this.a = new byte[4];
        for (int i2 = 0; i2 < 4; ++i2) {
            this.a[i2] = -1;
        }
    }

    public final boolean c(byte by2) {
        return this.a[by2];
    }

    private void H() {
        int n2;
        this.a = new boolean[20];
        for (n2 = 0; n2 < 20; ++n2) {
            this.a[n2] = false;
        }
        for (n2 = 0; n2 < 4; ++n2) {
            if (this.a[n2] < 0) continue;
            this.a[this.a[n2]] = true;
        }
    }

    public final void m() {
        this.b((byte)20, 100);
        this.j = true;
    }

    public final void b(byte by2, byte by3) {
        this.b((byte)21, 80);
        this.y = by3;
    }

    private void d(byte by2, int n2) {
        if (this.e(by2)) {
            ((do)this).b.addElement(new u(by2, 10, -1));
        }
    }

    protected final void a(df df2) {
        switch (df2.b) {
            case 41: 
            case 42: {
                if (this.c > 0) break;
                df2.a = true;
                return;
            }
            case 37: 
            case 38: {
                if (this.d > 0) break;
                df2.a = true;
                return;
            }
            case 6: {
                if (df2.b % 10 != 0) break;
                if (this.p == 7 || this.p == 6) {
                    df2.a = true;
                    return;
                }
                if (r.d != 3) break;
                this.c(-this.k);
            }
        }
    }

    protected final void b(df df2) {
        switch (df2.b) {
            case 20: {
                this.j = false;
                return;
            }
            case 21: {
                this.y = (byte)-1;
                return;
            }
            case 31: {
                int n2 = this.a.c((byte)1);
                this.a((byte)32, (byte)1, n2);
                this.k = true;
                return;
            }
            case 32: {
                this.k = false;
                this.E();
                return;
            }
            case 33: {
                int n3 = this.a.c((byte)2);
                this.a((byte)34, (byte)2, n3);
                this.l = true;
                return;
            }
            case 34: {
                this.l = false;
                this.F();
                return;
            }
            case 44: {
                this.e = false;
                return;
            }
            case 7: {
                this.f = false;
                if (((do)this).g <= 1) break;
                ((do)this).g = 1;
                return;
            }
            case 6: {
                this.k = 0;
            }
        }
    }

    private boolean g(byte by2) {
        int n2;
        for (int i2 = n2 = ((do)this).b.size() - 1; i2 >= 0; --i2) {
            df df2 = (df)((do)this).b.elementAt(i2);
            if (df2.b != by2) continue;
            this.b(df2);
            ((do)this).b.removeElementAt(i2);
        }
        return false;
    }

    public final boolean a(boolean bl2) {
        block13: {
            if (this.p == 7 || this.p == 6) {
                return false;
            }
            if (r.a[4] > 0) {
                return true;
            }
            Object object = r.a(bl2);
            if (object == null) {
                return false;
            }
            dg dg2 = object;
            object = this;
            if (dg2 != null && dg2.g == 20) {
                int n2 = dg2.h;
                switch (n2) {
                    case 2: {
                        ((x)object).c(100);
                        break;
                    }
                    case 8: {
                        n2 = 300;
                        super.c((byte)1, n2);
                        break;
                    }
                    case 4: {
                        super.g((byte)7);
                        break;
                    }
                    case 5: {
                        super.g((byte)6);
                        break;
                    }
                    case 6: {
                        ((x)object).c(600);
                        break;
                    }
                    case 7: {
                        ((x)object).c(1000);
                    }
                    case 3: {
                        n2 = 80;
                        super.c((byte)1, n2);
                        break;
                    }
                    default: {
                        break block13;
                    }
                }
                object = r.a(dg2.g);
                int n3 = ((bp)object).a(dg2);
                ((bp)object).a(n3, 1);
                r.i();
            }
        }
        return true;
    }

    public final void n() {
        byte by2 = r.b;
        x x2 = this;
        bp bp2 = r.a((byte)20);
        bp2.a(dg.a((byte)20, (byte)2), 5);
        r.a(true, (byte)2);
        byte by3 = r.a() ? (byte)13 : 12;
        Object object = (bs)dg.a(by3, (byte)0);
        r.a().a((dg)object, 1);
        x2.a((byte)4, (bs)object);
        byte[] byArray = new byte[]{1, 4, 2, 5, 6, 4};
        object = byArray;
        object = (bs)dg.a(byArray[by2], (byte)0);
        r.a().a((dg)object, 1);
        x2.a((byte)3, (bs)object);
        byte[] byArray2 = new byte[]{-1, 4, 7, 5, -1, -1};
        object = byArray2;
        by2 = byArray2[by2];
        if (by2 >= 0) {
            object = (bs)dg.a(by2, (byte)0);
            r.a().a((dg)object, 1);
            x2.a((byte)5, (bs)object);
        }
        this.l();
    }

    public final void i(int n2) {
        byte by2 = this.q;
        if (by2 == 1 || by2 == 2) {
            r.a.c(n2, by2);
            return;
        }
        r.a.b(n2, (int)by2);
    }

    public final void o() {
        int n2;
        x x2;
        if (!ab.c || !this.m) {
            this.f = 1;
            x2 = this;
            n2 = 3;
        } else {
            this.f = (byte)(this.b > 0 ? 8 : 0);
            x2 = this;
            n2 = this.b > 0 ? 9 : 2;
        }
        x2.j = (byte)n2;
    }

    public final void j(int n2) {
        this.b = n2;
        if (this.b[6]) {
            this.b += n2 * 50 / 100;
        }
        this.M();
        this.f = (byte)8;
        this.j = (byte)9;
        this.c();
        rpg.c.a.a(true);
        this.L();
        this.c(new bj(9));
    }

    private void I() {
        this.b = -1;
        this.N();
        this.f = ab.c ? (byte)0 : 1;
        this.j = (byte)(ab.c ? 2 : 3);
        this.c();
        rpg.c.a.a(false);
        if (this.j > 0) {
            this.K();
            rpg.c.a.a(true);
            return;
        }
        this.c(new bj(10));
    }

    public final void p() {
        this.a.e();
        if (this.b > 0) {
            return;
        }
        this.K();
        rpg.c.a.a(true);
    }

    private void J() {
        this.L();
        if (this.b > 0) {
            return;
        }
        rpg.c.a.a(false);
    }

    public final void k(int n2) {
        if (this.j < n2) {
            this.j = n2;
        }
    }

    private void K() {
        this.a((byte)9);
        this.d((byte)45, -1);
        this.d((byte)46, -1);
    }

    private void L() {
        this.a((byte)10);
        this.g((byte)45);
        this.g((byte)46);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final byte[] a() {
        byte[] byArray;
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            int n2;
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)filterOutputStream).writeByte(this.n);
            ((DataOutputStream)filterOutputStream).writeShort(this.c);
            ((DataOutputStream)filterOutputStream).writeShort(this.d);
            for (n2 = 0; n2 < 4; ++n2) {
                ((DataOutputStream)filterOutputStream).writeInt(this.a[n2]);
            }
            for (n2 = 0; n2 < 4; ++n2) {
                ((DataOutputStream)filterOutputStream).writeShort(this.a[n2]);
            }
            ((OutputStream)filterOutputStream).write(this.aa);
            ((OutputStream)filterOutputStream).write(this.Z);
            ((OutputStream)filterOutputStream).write(this.a);
            byArray = byteArrayOutputStream.toByteArray();
        }
        catch (IOException iOException) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) return null;
                byteArrayOutputStream.close();
                return null;
            }
            catch (IOException iOException2) {
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
            catch (IOException iOException) {}
            throw throwable;
        }
        try {
            filterOutputStream.close();
            byteArrayOutputStream.close();
            return byArray;
        }
        catch (IOException iOException) {}
        return byArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = null;
        FilterInputStream filterInputStream = null;
        try {
            int n2;
            byteArrayInputStream = new ByteArrayInputStream(byArray);
            filterInputStream = new DataInputStream(byteArrayInputStream);
            this.n = ((DataInputStream)filterInputStream).readByte();
            this.c = ((DataInputStream)filterInputStream).readShort();
            this.d = ((DataInputStream)filterInputStream).readShort();
            for (n2 = 0; n2 < 4; ++n2) {
                this.a[n2] = ((DataInputStream)filterInputStream).readInt();
            }
            for (n2 = 0; n2 < 4; ++n2) {
                this.a[n2] = ((DataInputStream)filterInputStream).readShort();
            }
            ((DataInputStream)filterInputStream).read(this.aa);
            ((DataInputStream)filterInputStream).read(this.Z);
            ((DataInputStream)filterInputStream).read(this.a);
            if (r.a((byte)2)) {
                this.q();
            }
            if (r.a((byte)1)) {
                this.r();
            }
        }
        catch (IOException iOException) {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream == null) return;
                byteArrayInputStream.close();
                return;
            }
            catch (IOException iOException2) {
                return;
            }
        }
        catch (Throwable throwable) {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream == null) throw throwable;
                byteArrayInputStream.close();
                throw throwable;
            }
            catch (IOException iOException) {}
            throw throwable;
        }
        try {
            filterInputStream.close();
            byteArrayInputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public final void q() {
        int n2 = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            if (this.a[i2] <= 0) continue;
            n2 += this.a[i2];
            this.a[i2] = 0;
        }
        this.c = (short)(this.c + n2);
    }

    public final void r() {
        byte by2;
        int n2 = 0;
        for (by2 = 0; by2 < 48; ++by2) {
            if (this.aa[by2] <= 0) continue;
            n2 += this.aa[by2];
            this.aa[by2] = 0;
        }
        for (by2 = 0; by2 < 20; ++by2) {
            if (this.Z[by2] <= 0) continue;
            n2 += this.Z[by2];
            this.Z[by2] = 0;
        }
        this.d = (short)(this.d + n2);
        this.d = (short)(this.d - 36);
        this.u();
        for (by2 = 0; by2 < 2; by2 = (byte)(by2 + 1)) {
            r.a(by2, true);
        }
        this.G();
    }

    public final ai a() {
        return this.a;
    }

    public final void g(byte by2) {
        this.c(new ax(-6, by2, 2));
    }

    public final void l(int n2) {
        int n3 = 0;
        int n4 = 0;
        x x2 = this;
        x2.a[n4] = n3;
        n3 = 0;
        n4 = 1;
        x2 = this;
        x2.a[n4] = n3;
        this.g(50);
        this.r(50);
        this.c(true);
        this.b_();
        ((c)this).a = (short)(((c)this).c << 4);
        ((c)this).b = (short)(((c)this).d << 4);
        this.a();
        this.a_();
        this.a((byte)1);
    }

    public final boolean a() {
        return this.a.a();
    }

    public final boolean b() {
        return Math.max(10, 60 - this.e) < rpg.f.a(0, 99);
    }

    public final boolean c() {
        byte by2 = 11;
        x x2 = this;
        if (x2.a[by2]) {
            by2 = 11;
            x2 = this;
            int n2 = x2.b(by2, 1);
            if (rpg.f.a(1, 99) > 100 - n2) {
                return false;
            }
        }
        return true;
    }

    public final int b(int n2) {
        int n3 = n2;
        int n4 = 7;
        x x2 = this;
        if (x2.a[n4]) {
            n3 = this.b((byte)7, n2);
        }
        return n3;
    }

    public final void m(int n2) {
        int n3 = 0;
        int n4 = 0;
        if (this.e && n2 > 0) {
            n3 = this.a.a(n2);
        }
        if (this.b[1] && n2 > 0) {
            n3 += n2 * 10 / 100;
        }
        int n5 = 16;
        x x2 = this;
        if (x2.a[n5]) {
            n5 = 16;
            x2 = this;
            n4 = x2.b((byte)n5, 1);
        }
        n5 = 17;
        x2 = this;
        if (x2.a[n5]) {
            n5 = 17;
            x2 = this;
            n3 += x2.b((byte)n5, 1);
        }
        if (this.b[3] && n2 > 0) {
            n4 += n2 * 5 / 100;
        }
        if (n3 > 0) {
            this.c(n3);
        }
        if (n4 > 0) {
            n5 = n4;
            x2 = this;
            x2.c((byte)1, n5);
        }
        this.D();
    }

    public final byte c() {
        byte by2 = 0;
        byte by3 = 12;
        x x2 = this;
        if (x2.a[by3] && rpg.f.a(0, 99) < 25) {
            by3 = 12;
            x2 = this;
            by2 = (byte)(0 + x2.b(by3, 1));
        }
        return by2;
    }

    public final int c(int n2) {
        int n3 = 18;
        x x2 = this;
        if (x2.a[n3]) {
            return this.b((byte)18, n2);
        }
        return n2;
    }

    public final void b(int n2, int n3) {
        if (this.p == 7 || this.p == 6) {
            return;
        }
        if (this.d()) {
            return;
        }
        this.k = this.b[0] / n3;
        this.a((byte)6, n2);
    }

    public final void n(int n2) {
        if (this.p == 7 || this.p == 6) {
            return;
        }
        if (this.b[5]) {
            return;
        }
        if (this.d()) {
            return;
        }
        if (!this.f) {
            this.f = true;
            this.a((byte)7, n2);
            this.q(n2);
        }
    }

    private boolean d() {
        if (r.b == 2 && this.y > 1) {
            this.c(new dn(19));
            return true;
        }
        return false;
    }

    private void M() {
        if (this.t <= 8) {
            this.t = (byte)(this.t << 1);
        }
    }

    private void N() {
        if (((do)this).g > 1) {
            this.t = (byte)4;
            return;
        }
        if (this.b[2] || this.b > 1) {
            this.t = (byte)16;
            return;
        }
        this.t = (byte)8;
    }

    private boolean a(int n2) {
        int n3 = 0;
        for (byte by2 = 0; by2 < 7; by2 = (byte)(by2 + 1)) {
            bs bs2 = this.a(by2);
            if (bs2 == null || bs2.c != n2) continue;
            ++n3;
        }
        return n3 > 2;
    }

    private void s(int n2) {
        switch (n2) {
            case 0: {
                this.b[0] = true;
                return;
            }
            case 1: {
                this.b[1] = true;
                return;
            }
            case 2: {
                this.b[2] = true;
                return;
            }
            case 3: {
                this.b[1] = true;
                this.b[3] = true;
                this.b[4] = true;
                return;
            }
            case 4: {
                this.b[1] = true;
                this.b[4] = true;
                this.b[5] = true;
                return;
            }
            case 5: {
                this.b[4] = true;
                this.b[6] = true;
            }
        }
    }

    public final void h(byte by2) {
        this.i = by2;
        this.a((byte)99);
    }

    public static boolean d(byte by2) {
        return by2 < 4;
    }

    protected final void s() {
        if (((do)this).g == 0 && !((c)this).a && !((c)this).b) {
            ((do)this).g = -1;
            this.N();
        }
    }

    public final void t() {
        if (r.c() || this.p == 3) {
            this.b(0);
            this.m = 0;
            this.a.a(false);
        }
        r.e();
    }
}

