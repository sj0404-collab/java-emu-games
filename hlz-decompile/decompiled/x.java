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

    private x(short s, short s2, byte by, byte by2) {
        super((short)0, (short)0, (byte)8, (byte)9);
        this.y = (byte)-1;
    }

    public static x a(byte by) {
        int n;
        int n2;
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
        for (n2 = 0; n2 < 4; ++n2) {
            bh.a[n2] = false;
        }
        x3.v = (byte)100;
        x3.u = (byte)100;
        x3.aa = new byte[48];
        x3.Z = new byte[20];
        x3.G();
        n2 = x3.aa.length;
        for (n = 0; n < n2; ++n) {
            x3.aa[n] = -1;
        }
        n2 = x3.Z.length;
        for (n = 0; n < n2; ++n) {
            x3.Z[n] = -1;
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
        x2.l(by);
        x3 = x2;
        ai ai2 = new ai(x3);
        ai2.a();
        ai2.f();
        for (n = 0; n < 2; ++n) {
            ai2.b(n + 2);
        }
        ai2.d();
        x3.a = ai2;
        return x2;
    }

    private void l(byte by) {
        ct ct2 = null;
        switch (by) {
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
        ct2.b(by);
        bo.h();
        this.a = ct2;
    }

    public final void a_(byte by) {
        for (byte by2 = 0; by2 < 2; by2 = (byte)(by2 + 1)) {
            r.a(by2, true);
        }
        r.b = by;
        this.l(by);
        this.b(false);
        rpg.c.c();
    }

    public final void b(boolean bl) {
        int n;
        int n2 = r.b;
        x x2 = this;
        int n3 = n2;
        x x3 = x2;
        int n4 = 0;
        for (n = 0; n < n3; ++n) {
            n4 += 8;
        }
        if (x3.aa[n4] < 0) {
            x3.aa[n4] = 0;
        }
        if (!x.d((byte)n3)) {
            for (n = 2; n < 6; ++n) {
                x3.aa[n4 + n] = -2;
            }
        }
        n = n4 + 6;
        for (n3 = 0; n3 < 2; ++n3) {
            if (x3.aa[n += n3] >= 0) continue;
            x3.aa[n] = 0;
        }
        n3 = n2;
        x3 = x2;
        n4 = 0;
        for (n = 0; n < n3; n = (byte)(n + 1)) {
            n4 += x.d((byte)n) ? 4 : 2;
        }
        n = x.d((byte)n3) ? 4 : 2;
        for (n3 = 0; n3 < n; ++n3) {
            if (x3.Z[n4 + n3] >= 0) continue;
            x3.Z[n4 + n3] = 0;
        }
        x2.c();
        r.j();
        this.H();
        this.a.c();
        this.k();
        if (bl) {
            if (r.b == 4 || r.b == 5) {
                this.n = (byte)40;
                this.c = (short)(this.c + 156);
                this.d = (short)(this.d + 20);
            }
            int n5 = 0;
            x x4 = this;
            n2 = x4.b[n5];
            n5 = 0;
            x4 = this;
            x4.a[n5] = n2;
            n5 = 1;
            x4 = this;
            n2 = x4.b[n5];
            n5 = 1;
            x4 = this;
            x4.a[n5] = n2;
            n5 = 3;
            x4 = this;
            n2 = x4.b[n5];
            n5 = 3;
            x4 = this;
            x4.a[n5] = n2;
        }
    }

    private void u() {
        for (int i = 0; i < 6; ++i) {
            int n = i * 8 + 6;
            this.aa[n] = 3;
            this.aa[n + 1] = 3;
        }
    }

    public final byte a(byte by) {
        by = (byte)((r.b << 3) + by - 4);
        return this.aa[by];
    }

    public final void a(byte by, byte by2) {
        int n;
        byte by3 = by = (byte)((by << 3) + by2 - 4);
        this.aa[by3] = (byte)(this.aa[by3] + 1);
        by2 = by;
        x x2 = this;
        int n2 = n = x.d(r.b) ? 6 : 2;
        if (by2 % 8 < n - 1 && x2.aa[by2 + 1] == -1) {
            x2.aa[by2 + 1] = 0;
        }
    }

    public final int a(byte by) {
        return this.a.c(by);
    }

    private int a(byte by, int n, boolean bl) {
        return this.a.a(by, n, false);
    }

    public final void a(int n) {
        int n2 = n;
        this.Z[n2] = (byte)(this.Z[n2] + 1);
    }

    final void b() {
        super.b();
        this.w();
    }

    final void c(boolean bl) {
        this.y();
        this.w();
        if (bl) {
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
        for (int i = 0; i < this.ab.length; ++i) {
            this.ab[i] = -1;
        }
        this.l = (byte)-1;
    }

    public final void c() {
        this.k = this.a.b();
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(int n, int n2) {
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
            n = n + ((c)this).a + ((c)this).a;
            n2 = n2 + ((c)this).b + ((c)this).b - 1;
            if (this.w == 1) {
                n += rpg.b.S[this.x] * 3;
                n2 += rpg.b.T[this.x] * 3;
                this.w = (byte)(this.w - 1);
            }
            this.b(n, n2, false);
            cr cr2 = rpg.a.a;
            cr2.a(rpg.c.e[this.i ? 1 : 0], n, n2 + 6, 33);
            switch (this.p) {
                case 3: {
                    if (this.l < 0) break;
                    this.b(this.ab[this.l] + 6, n, n2);
                    break block15;
                }
                case 2: {
                    this.b((int)this.j, n, n2);
                    break block15;
                }
                case 7: {
                    ((do)this).f = 8;
                }
                case 6: {
                    x.a(n, n2, ((do)this).f);
                    break block15;
                }
                case 9: {
                    this.b(7, n, n2);
                    break block15;
                }
                case 10: {
                    this.b(5, n, n2);
                    break block15;
                }
                case 99: {
                    this.b((int)this.i, n, n2);
                    break block15;
                }
            }
            this.b((int)this.f, n, n2);
        }
        this.b(n, n2, true);
        this.d(n, n2);
    }

    private final void b(int n, int n2, int n3) {
        ((do)this).f = rpg.c.a.a((byte)n, this.q, ((do)this).f, n2, n3);
    }

    public static void a(int n, int n2, int n3) {
        rpg.c.a.a((byte)4, (byte)1, n3, n, n2);
    }

    final void d() {
        byte by;
        int n;
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
                n = x2.l;
                x x3 = x2;
                x3.c((byte)1, n);
                x2.v = (byte)100;
            }
            for (by = 0; by < 5; by = (byte)(by + 1)) {
                if (r.a[by] < 0) continue;
                byte by2 = by;
                r.a[by2] = r.a[by2] - 1;
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
        byte by3 = this.p;
        if (this.k()) {
            this.h = false;
        }
        by = by3;
        x x4 = this;
        n = 0;
        if (x4.p != 3 && !x4.h) {
            n = m.a(x4) ? 1 : 0;
            x4.h = true;
        }
        if (n == 0 && by == 2 && x4.p == 1) {
            n = m.b() ? 1 : 0;
        }
        if (n != 0) {
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
        int n = 0;
        x x2 = this;
        int n2 = x2.b[n];
        n = 0;
        x2 = this;
        x2.a[n] = n2;
        n = 1;
        x2 = this;
        n2 = x2.b[n];
        n = 1;
        x2 = this;
        x2.a[n] = n2;
        n = 3;
        x2 = this;
        n2 = x2.b[n];
        n = 3;
        x2 = this;
        x2.a[n] = n2;
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
                int n = x3.ab[x3.l];
                if (((do)x3).f <= 0) {
                    boolean bl;
                    if (x3.z > 0 && n < 4) {
                        x3.b((int)x3.l);
                        return;
                    }
                    if (n >= 100) {
                        n = (byte)(x3.ab[x3.l] - 100);
                        if (x3.a.d((byte)n)) {
                            x3.x();
                            return;
                        }
                        x3.b((int)x3.l);
                        return;
                    }
                    if (!x3.a.a((byte)n)) {
                        x3.b((int)x3.l);
                        x3.g((byte)6);
                        return;
                    }
                    int n2 = n;
                    x x4 = x3;
                    n2 = x4.a.b((byte)n2);
                    int n3 = 0;
                    x x5 = x4;
                    n2 = x5.a[n3] ? x4.b((byte)0, n2) : n2;
                    n3 = 1;
                    x5 = x4;
                    if (n2 > x5.a[n3]) {
                        bl = false;
                    } else {
                        if (n2 > 0) {
                            n3 = -n2;
                            x5 = x4;
                            x5.c((byte)1, n3);
                        }
                        bl = true;
                    }
                    if (!bl) {
                        x3.b((int)x3.l);
                        x3.g((byte)2);
                        return;
                    }
                    r.b((byte)n, true);
                    if (x3.a.b((byte)n)) {
                        x3.i();
                    }
                }
                if (x3.a.a((byte)n, ((do)x3).f)) return;
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
                byte by = this.z;
                this.z = 0;
                if (by > 0) {
                    r.b((byte)2, by);
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
        byte by = r.c;
        switch (by) {
            case 1: 
            case 3: 
            case 9: 
            case 10: {
                this.a(by);
                r.c((byte)0, (byte)0);
                ((do)this).f = 0;
                this.B();
                return;
            }
        }
        this.a((byte)1);
    }

    static byte a(int n) {
        return rpg.c.a.a((byte)n);
    }

    public final int b(byte by) {
        int n = this.a((byte)1, (int)(by = (byte)this.a.a(by)));
        if (n > 0) {
            return n;
        }
        return by;
    }

    final void g() {
        if (this.l()) {
            ((do)this).f = 0;
            this.p(this.t);
        }
    }

    final boolean a_(byte by) {
        if (this.m > 0 || this.l + 1 >= this.k) {
            return false;
        }
        if (this.ab[this.l + 1] < 4) {
            if (by > 0) {
                if (this.l >= 0 && this.ab[this.l] == by) {
                    return false;
                }
                this.ab[this.l + 1] = by;
                return true;
            }
            x x2 = this;
            boolean bl = x2.b > 0 ? (x2.l >= 0 && x2.ab[x2.l] >= 4 && x2.ab[x2.l] < 6 ? false : x2.l < 0 || x2.ab[x2.l] < 11) : x2.l < 0 || x2.ab[x2.l] < 4;
            if (bl) {
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

    public final void b(byte by) {
        this.ab[this.l + 1] = by;
    }

    public final void b(int n) {
        this.m = n < 2 && this.ab[n] <= 0 ? (byte)2 : (byte)4;
        n = this.z;
        if (r.b == 3) {
            this.a((byte)9);
        } else if (n > 0) {
            x x2 = this;
            this.z = 0;
            r.b((byte)2, (byte)n);
            r.c((byte)0, (byte)0);
        } else {
            this.a((byte)1);
        }
        ((do)this).f = 0;
        this.x();
    }

    public final void c(byte by) {
        this.z = by;
    }

    public final void h() {
        this.z = 0;
    }

    public final void i() {
        this.i(this.a());
    }

    public final int a(boolean bl) {
        int n = (bl = bl ? this.i : this.h) ? 1 : 0;
        if (this.f) {
            return (bl << 2) / 5;
        }
        return bl ? 1 : 0;
    }

    public final int b(boolean bl) {
        int n;
        bs bs2 = bl ? this.a((byte)5) : this.a((byte)3);
        int n2 = this.a(bl);
        if (bs2 != null) {
            n = n2 + (bs2.c - bs2.b);
        }
        return n;
    }

    /*
     * WARNING - void declaration
     */
    public final int c(boolean bl) {
        void var1_6;
        int n;
        bs bs2 = bl ? this.a((byte)5) : this.a((byte)3);
        int x2 = this.a(bl);
        if (bs2 != null) {
            int n2 = rpg.f.a(1, 100) + this.a.a((byte)4);
            if (n2 > 100) {
                n2 = 100;
            }
            n = x2 + (bs2.c - bs2.b) * n2 / 100;
        }
        if (this.b > 0) {
            int n3 = 3;
            x x3 = this;
            void var1_5 = n + x3.c[n3];
        }
        return (int)var1_6;
    }

    final boolean a(db db2, byte by, int n, byte by2, byte by3, boolean bl, boolean bl2, boolean bl3) {
        if (db2 != null) {
            return db2.a(this, by, n, bl, by2, by3, bl2, true, bl3);
        }
        return false;
    }

    public final boolean a(byte by, int n, byte by2, boolean bl, boolean bl2, boolean bl3) {
        db db2 = this.a();
        return this.a(db2, by, n, this.q, by2, bl, false, false);
    }

    public final boolean a(byte by, int n, byte by2, boolean bl, boolean bl2) {
        by = 0;
        byte by3 = this.q;
        db by32 = this.b(by3);
        if (by32 != null) {
            by = this.a(by32, (byte)7, n, by3, by2, false, bl, false) ? 1 : 0;
        }
        for (byte by4 = 1; by4 <= 3; by4 = (byte)(by4 + 1)) {
            if (this.a(by3, by3, by4, (byte)7, n, by2, bl, false)) {
                by = 1;
            }
            if (this.a(rpg.b.V[by3], by3, by4, (byte)7, n, by2, bl, false)) {
                by = 1;
            }
            if (!this.a(rpg.b.U[by3], by3, by4, (byte)7, n, by2, bl, false)) continue;
            by = 1;
        }
        return by != 0;
    }

    private boolean a(byte by, byte by2, byte by3, byte by4, int n, byte by5, boolean bl, boolean bl2) {
        db db2 = this.a(by, by2, (int)by3);
        if (db2 != null) {
            return this.a(db2, by4, n, by2, by5, bl2, bl, false);
        }
        return false;
    }

    private db a(byte by, byte by2, int n) {
        c c2 = this.a(by, by2, (byte)n);
        if (c2 != null && c2 instanceof db) {
            return (db)c2;
        }
        return null;
    }

    public final db a(byte by) {
        c c2 = c.a(((c)this).c, ((c)this).d, by, (byte)0, (byte)0);
        if (c2 != null && c2 instanceof db && !(c2 instanceof an)) {
            return (db)c2;
        }
        return null;
    }

    public final boolean a(byte by, int n, byte by2) {
        by = 0;
        for (byte by3 = 1; by3 <= 12; by3 = (byte)(by3 + 1)) {
            db db2 = this.a(by3);
            if (db2 == null || !this.a(db2, (byte)9, n, by3, by2, false, false, false)) continue;
            by = 1;
        }
        return by != 0;
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

    public final Vector a(byte by) {
        this.c = new Vector(0);
        switch (by) {
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
                for (by = 0; by < 3; by = (byte)(by + 1)) {
                    this.a(this.a(rpg.b.X[this.q], this.q, by + 1));
                    this.a(this.a((byte)0, this.q, by + 1));
                    this.a(this.a(rpg.b.W[this.q], this.q, by + 1));
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

    private db c(byte by) {
        db db2 = this.b(by);
        if (db2 == null) {
            for (int n = 0; n < 3 && (db2 = this.a(by, by, n)) == null && (db2 = this.a(rpg.b.V[by], by, n)) == null && (db2 = this.a(rpg.b.U[by], by, n)) == null; n = (int)((byte)(n + 1))) {
            }
        }
        if (db2 != null && db2.d()) {
            return null;
        }
        return db2;
    }

    public final void d(boolean bl) {
        this.i = bl;
    }

    public final boolean a(byte by, byte by2, byte by3, int n) {
        boolean bl = false;
        this.g = (byte)this.a(by2, true, this.q);
        if (this.g > 0) {
            if (n > 0 || n == -1 || n == -100) {
                if (this.a(by, n, by3, false, false, false)) {
                    bl = true;
                }
                if (this.g != 1) {
                    db db2;
                    byte by4 = by3;
                    by3 = this.q;
                    by2 = by;
                    x x2 = this;
                    db db3 = x2.b((byte)(by3 + 8));
                    if (db3 != null && (db2 = x2.b(by3)) != db3 ? x2.a(db3, by2, n, x2.q, by4, false, false, false) : false) {
                        bl = true;
                    }
                }
            }
            this.p(16 * this.g);
        } else if (this.a(by, n, by3, false, false, false)) {
            bl = true;
            this.g = 0;
        }
        return bl;
    }

    public final boolean b(byte by) {
        this.g = (byte)this.a((byte)3, false, this.q);
        if (this.g > 0) {
            this.p(16 * this.g);
        }
        return this.g != 3;
    }

    private int a(byte n, boolean bl, byte by) {
        ab ab2 = r.a;
        int n2 = ((c)this).c;
        int n3 = ((c)this).d;
        int n4 = 0;
        for (int i = 1; i <= n; ++i) {
            if ((n2 += rpg.b.S[by]) < 0 || (n3 += rpg.b.T[by]) < 0 || n2 >= ab.c || n3 >= ab.d) continue;
            if (ab2.a((c)this, n2, n3)) {
                if (bl) continue;
                return n4;
            }
            if (ab2.b(n2, n3) || ab2.c(n2, n3)) {
                return n4;
            }
            n4 = i;
        }
        return n4;
    }

    final void c(int n) {
        if (a > 0L && n < 0) {
            n = 0;
        }
        this.c((byte)0, bh.b ? 0 : n);
        if (this.a[0] <= 0) {
            this.a((byte)6);
            ((do)this).f = 0;
        }
    }

    final void d(int n) {
        this.c((byte)1, n);
    }

    final void e(int n) {
        this.c((byte)3, n);
    }

    private final void D() {
        int n;
        int n2 = n = r.b == 5 ? this.a((byte)10) : 2;
        x x2 = this;
        x2.c((byte)3, n2);
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
        int n = 0;
        x2 = this;
        int n2 = x2.b[n];
        n = 0;
        x2 = this;
        x2.a[n] = n2;
        n = 1;
        x2 = this;
        n2 = x2.b[n];
        n = 1;
        x2 = this;
        x2.a[n] = n2;
        n = 3;
        x2 = this;
        n2 = x2.b[n];
        n = 3;
        x2 = this;
        x2.a[n] = n2;
    }

    final void f(int n) {
        if (dj.i || j.a && this.n < 20) {
            n <<= 1;
        }
        this.a[2] = this.a[2] + (n < 0 ? -n : n);
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

    final void g(int n) {
        n = this.b[0] * n / 100;
        this.c(n);
    }

    private void r(int n) {
        int n2 = n = this.b[1] * n / 100;
        x x2 = this;
        x2.c((byte)1, n2);
    }

    private void c(byte by, int n) {
        byte by2 = by;
        this.a[by2] = this.a[by2] + n;
        if (this.a[by] > this.b[by]) {
            this.a[by] = this.b[by];
        } else if (this.a[by] < 0) {
            this.a[by] = 0;
        }
        bh.a[by] = true;
    }

    public final void k() {
        int n;
        int n2;
        int n3;
        bs bs2;
        int n4;
        int n5;
        this.m = false;
        Object object = this;
        this.b = new boolean[7];
        for (n5 = 0; n5 < 7; ++n5) {
            ((x)object).b[n5] = false;
        }
        ((x)object).N();
        n5 = 0;
        if (((x)object).a(2)) {
            ((x)object).s(2);
            n5 = 1;
            ((x)object).M();
        }
        int n6 = n5 = n5 != 0 ? 3 : 0;
        while (n5 < 6) {
            if (n5 != 2 && super.a(n5)) {
                super.s(n5);
                break;
            }
            ++n5;
        }
        object = new int[4];
        n5 = 10 + (this.b[0] ? 4 : 0);
        for (int i = 0; i < 4; ++i) {
            object[i] = n5 + this.a[i];
        }
        bs[] bsArray = this.a;
        for (n5 = 0; n5 < 7; ++n5) {
            if (bsArray[n5] == null) continue;
            for (n4 = 0; n4 < 4; ++n4) {
                Object object2 = object;
                int n7 = n4 + 0;
                object2[n7] = object2[n7] + bsArray[n5].a(n4 + 0);
                Object object3 = object;
                int n8 = n4 + 0;
                object3[n8] = object3[n8] + bsArray[n5].a(n4 + 10);
                Object object4 = object;
                int n9 = n4 + 0;
                object4[n9] = object4[n9] + bsArray[n5].a(15);
            }
        }
        this.c[0] = (int)(object[0] + this.a((byte)3, (int)object[0]) + this.a.a((byte)7, (int)object[0]));
        this.c[1] = (int)(object[1] + this.a((byte)13, (int)object[1]) + this.a.a((byte)7, (int)object[1]));
        this.c[2] = (int)(object[2] + this.a((byte)8, (int)object[2]) + this.a.a((byte)7, (int)object[2]));
        this.c[3] = (int)(object[3] + this.a.a((byte)7, (int)object[3]));
        if (r.b == 5) {
            this.c[3] = this.c[3] + this.a((byte)11, (int)object[3], false);
        }
        n4 = (bs2 = this.a((byte)3)) != null ? 1 : 0;
        object = this.a((byte)5);
        int n10 = object != null ? 1 : 0;
        int n11 = this.c[0] + this.c[1] / 4 + this.g((byte)6);
        switch (r.b) {
            case 1: {
                n11 += this.c[1] / 6 - this.c[0] / 3;
                break;
            }
            case 2: {
                n11 -= this.c[0] / 2;
                break;
            }
            case 3: {
                n11 -= this.c[1] / 6 + this.c[0] / 2;
            }
        }
        int n12 = bh.b ? 9999 : this.a((byte)15, this.c[1]) + this.a.a((byte)1);
        this.h = n11 + n12;
        this.i = 0;
        switch (r.b) {
            case 0: {
                if (n4 == 0) break;
                this.h += this.a((byte)11, (int)bs2.c, false);
                break;
            }
            case 2: {
                if (n10 == 0) break;
                this.i = n11 + n12;
                this.m = true;
                break;
            }
            case 1: 
            case 3: {
                if (n10 == 0) break;
                this.i = this.a((byte)11, n11, false) + n12 + ((bs)object).b;
                this.m = true;
            }
        }
        if (n4 != 0) {
            this.h += bs2.b;
            this.m = true;
        }
        this.o();
        int n13 = this.h((byte)1) + this.h((byte)4) + this.h((byte)6) + this.h((byte)0) + this.g((byte)7);
        if (r.b == 2) {
            n13 += this.h((byte)5);
        } else if (r.b == 0) {
            n13 += this.c[0] / 12;
        }
        this.a = n13 + this.a((byte)9, n13) + this.a.a((byte)0);
        this.E();
        this.F();
        byte by = (byte)(90 + this.g((byte)14));
        n13 = by;
        if (by > 95) {
            n13 = 95;
        }
        this.a((byte)1, n13 += this.i((byte)2), false);
        this.a((byte)1, n13, true);
        this.e = (short)(10 + this.c[2] / 10 + this.i((byte)10));
        this.o = 0;
        if (r.b == 2 && this.a((byte)5) != null) {
            this.o = (byte)(5 + this.c[0] / 5 + (this.h((byte)5) >> 1));
            if (this.o > 75) {
                this.o = (byte)75;
            }
            this.o = (byte)(this.o + (byte)this.a((byte)11));
        }
        n10 = n13 = this.n * this.n * this.n - this.n * this.n + 80 * this.n;
        int n14 = 2;
        x x2 = this;
        x2.b[n14] = n10;
        n10 = n3 = 5 * this.n + 10 * this.c[3] + this.g((byte)4);
        n14 = 1;
        x x3 = this;
        x3.b[n14] = n10;
        int n15 = 10 * this.n + 12 * this.c[2] + this.g((byte)9);
        n15 += this.a.a((byte)2);
        if (r.b == 2) {
            n15 += this.c[2] / 5;
        }
        n10 = n15;
        n14 = 0;
        x x4 = this;
        x4.b[n14] = n10;
        n10 = n2 = 100 + this.i((byte)19);
        n14 = 3;
        x x5 = this;
        x5.b[n14] = n10;
        for (n = 0; n < 2; ++n) {
            if (this.a[n] <= this.b[n]) continue;
            this.a[n] = this.b[n];
        }
        for (n = 0; n < 3; ++n) {
            if (this.ac[n] <= 100) continue;
            this.ac[n] = 100;
        }
        this.l = this.c[3] + this.a.a((byte)3);
        bh.c = true;
    }

    private void E() {
        bs bs2 = this.a((byte)3);
        int n = bs2 != null ? 1 : 0;
        bs bs3 = this.a((byte)5);
        boolean bl = bs3 != null;
        int n2 = (this.c[1] >> 3) + this.g((byte)5);
        if (r.b == 3) {
            n2 += this.c[1] >> 4;
        }
        if (n2 > 50) {
            n2 = 50;
        }
        int n3 = (n2 += this.i((byte)5)) + (n != 0 ? bs2.e : (byte)0);
        n = n2 + (bl ? bs3.e : (byte)0);
        if (n3 > 70) {
            n3 = 70;
        }
        if (n > 70) {
            n = 70;
        }
        if (this.k) {
            n2 = this.a.b((byte)1);
            n3 += n2;
            n += n2;
        }
        this.a((byte)2, n3, false);
        this.a((byte)2, n, true);
    }

    private void F() {
        int n = this.c[1] / 5 + this.g((byte)8);
        if (r.b == 1) {
            n += this.c[1] / 10;
        } else if (r.b == 2) {
            n -= this.c[1] / 10;
        }
        if (n > 75) {
            n = 75;
        }
        if ((n += this.i((byte)4)) > 80) {
            n = 80;
        }
        if (this.l) {
            n += this.a.b((byte)2);
        }
        if (n > 85) {
            n = 85;
        }
        this.a((byte)0, n, false);
        this.a((byte)0, n, true);
    }

    final boolean a(do do_, int n, byte by) {
        boolean bl;
        int n2;
        if (this.p == 7 || this.p == 6) {
            return false;
        }
        if (do_ instanceof db) {
            bh.a((db)do_, true);
        }
        if (r.b == 2) {
            if (this.y > 1) {
                this.c(new dn(19));
                if ((n *= this.y / 10) <= 0) {
                    n = 5;
                }
            }
            if (this.j) {
                n2 = this.a((byte)7, this.a(true), false);
                this.c(new dn(18));
                do_.a(this, n2, (byte)0, (byte)3);
            }
            if (this.o > 0 && rpg.f.a(1, 100) > 100 - this.o) {
                this.c(new ax(-3));
                return false;
            }
        }
        if ((n2 = n * (rpg.f.a(0, 2) + 10) / 10 - this.c()) <= 0) {
            n2 = 5;
        }
        do do_2 = this;
        n = do_.c((byte)1) / 8 + do_.b() - do_2.n;
        do_ = this;
        int n3 = n;
        byte by2 = 14;
        do_2 = do_;
        if (do_2.a[by2]) {
            by2 = 14;
            do_2 = do_;
            n3 = n - super.b(by2, 1);
        }
        if (bl = rpg.f.a(1, 99) < n3) {
            n2 += n2 / 2;
        }
        if (this.c > 0) {
            this.c = 0;
            if ((n2 -= this.c) <= 0) {
                this.c = -n2;
                n2 = 0;
            }
        }
        if ((n2 /= 3) <= 0) {
            n2 = 1;
        }
        this.e = n2;
        this.c(-n2);
        this.D();
        this.c(new ax(-4, -1, n2));
        this.c(new bj(bl ? (byte)3 : 4));
        this.w = 1;
        this.x = by;
        return true;
    }

    protected final void a(do do_, int n, byte by, byte by2) {
        this.c(-n);
        this.c(new ax(-4, -1, n));
        this.c(new bj(2));
    }

    public final void d(byte by) {
        byte by2 = by;
        this.a[by2] = (short)(this.a[by2] + 1);
    }

    public final int c(byte by) {
        return this.c[by];
    }

    public final void a(byte by, int n) {
        this.a[by] = n;
    }

    public final int d(byte by) {
        return this.a[by];
    }

    public final int a() {
        return this.a[3];
    }

    public final int e(byte by) {
        return this.b[by];
    }

    public final int f(byte by) {
        return this.ac[by];
    }

    private final void a(byte by, int n, boolean bl) {
        this.ac[by + (bl ? 3 : 0)] = (byte)n;
    }

    public final int b() {
        int n = 0;
        x x2 = this;
        return x2.ac[n];
    }

    public final int a(byte by, boolean bl) {
        byte by2;
        if (bl) {
            int x2 = 2;
            x n3 = this;
            by2 = n3.ac[5];
        } else {
            int n = 2;
            x x2 = this;
            by2 = x2.ac[n];
        }
        byte by3 = by2;
        int n = by2 + (this.n - by);
        if (n > 90) {
            return 90;
        }
        return n;
    }

    public final int a(int n) {
        int n2 = 6;
        x x2 = this;
        if (x2.a[n2]) {
            return n + this.b((byte)6, n);
        }
        return n;
    }

    public final int c() {
        if (this.f) {
            return (this.a << 2) / 5;
        }
        return this.a;
    }

    public final void e(byte by) {
        db db2 = this.b(by);
        if (db2 != null) {
            db2.j(by);
        }
    }

    final void l() {
        bp bp2 = r.a();
        int n = 0;
        int n2 = bp2.a();
        for (int n3 = 0; n3 < n2; n3 = (int)((byte)(n3 + 1))) {
            dg dg2 = bp2.a(n3);
            if (!(dg2 instanceof bs) || ((bs)dg2).f < 0) continue;
            this.a[((bs)dg2).f] = (bs)dg2;
            byte by = (byte)(n + 1);
            n = by;
            if (by == 7) break;
        }
    }

    private int g(byte by) {
        int n = 0;
        bs[] bsArray = this.a;
        for (int i = 0; i < 7; ++i) {
            if (bsArray[i] == null) continue;
            n += bsArray[i].a(by);
        }
        return n;
    }

    public final byte b() {
        return this.n;
    }

    private int h(byte by) {
        if (this.a[by] != null) {
            return this.a[by].d;
        }
        return 0;
    }

    public final bs a(byte by) {
        if (by < 0) {
            return null;
        }
        return this.a[by];
    }

    public final void a(byte by, bs bs2) {
        if (bs2 != null) {
            this.f(by);
            this.a[by] = bs2;
            bs2.f = by;
        }
    }

    public final void f(byte by) {
        bs bs2 = this.a(by);
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
        int n = 1;
        x x3 = x2;
        x3 = this;
        int n2 = x2.ac[n] + x3.n - do_.b() - do_.c((byte)1) / 5;
        if (this.b[4]) {
            n2 += n2 * 5 / 100;
        }
        return (do.a.nextInt() & 0xFF) % 100 < n2;
    }

    private int i(byte by) {
        byte by2 = by;
        x x2 = this;
        if (x2.a[by2]) {
            by2 = by;
            x2 = this;
            return x2.b(by2, 1);
        }
        return 0;
    }

    private int a(byte by, int n) {
        byte by2 = by;
        x x2 = this;
        if (x2.a[by2]) {
            return this.b(by, n);
        }
        return 0;
    }

    private int b(byte by, int n) {
        int n2 = by * 3;
        by = (byte)(this.Z[by] + this.a.a((byte)5));
        return n * (this.b[n2] + this.b[n2 + 1] * by) / this.b[n2 + 2];
    }

    public final byte b(byte by) {
        return this.Z[by];
    }

    public final void a(int n, byte by) {
        for (int i = 0; i < 4; ++i) {
            if (this.a[i] != by) continue;
            this.a[i] = -1;
        }
        this.h(n);
        this.a[n] = by;
        this.a[by] = true;
        if (by == 1) {
            r.j();
        }
    }

    public final void h(int n) {
        byte by = this.a[n];
        if (by >= 0) {
            this.a[by] = false;
        }
        this.a[n] = -1;
    }

    private void G() {
        this.a = new byte[4];
        for (int i = 0; i < 4; ++i) {
            this.a[i] = -1;
        }
    }

    public final boolean c(byte by) {
        return this.a[by];
    }

    private void H() {
        int n;
        this.a = new boolean[20];
        for (n = 0; n < 20; ++n) {
            this.a[n] = false;
        }
        for (n = 0; n < 4; ++n) {
            if (this.a[n] < 0) continue;
            this.a[this.a[n]] = true;
        }
    }

    public final void m() {
        this.b((byte)20, 100);
        this.j = true;
    }

    public final void b(byte by, byte by2) {
        this.b((byte)21, 80);
        this.y = by2;
    }

    private void d(byte by, int n) {
        if (this.e(by)) {
            ((do)this).b.addElement(new u(by, 10, -1));
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
                int n = this.a.c((byte)1);
                this.a((byte)32, (byte)1, n);
                this.k = true;
                return;
            }
            case 32: {
                this.k = false;
                this.E();
                return;
            }
            case 33: {
                int n = this.a.c((byte)2);
                this.a((byte)34, (byte)2, n);
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

    private boolean g(byte by) {
        int n;
        for (int i = n = ((do)this).b.size() - 1; i >= 0; --i) {
            df df2 = (df)((do)this).b.elementAt(i);
            if (df2.b != by) continue;
            this.b(df2);
            ((do)this).b.removeElementAt(i);
        }
        return false;
    }

    public final boolean a(boolean bl) {
        block13: {
            if (this.p == 7 || this.p == 6) {
                return false;
            }
            if (r.a[4] > 0) {
                return true;
            }
            Object object = r.a(bl);
            if (object == null) {
                return false;
            }
            dg dg2 = object;
            object = this;
            if (dg2 != null && dg2.g == 20) {
                int n = dg2.h;
                switch (n) {
                    case 2: {
                        ((x)object).c(100);
                        break;
                    }
                    case 8: {
                        n = 300;
                        super.c((byte)1, n);
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
                        n = 80;
                        super.c((byte)1, n);
                        break;
                    }
                    default: {
                        break block13;
                    }
                }
                object = r.a(dg2.g);
                int n2 = ((bp)object).a(dg2);
                ((bp)object).a(n2, 1);
                r.i();
            }
        }
        return true;
    }

    public final void n() {
        byte by = r.b;
        x x2 = this;
        bp bp2 = r.a((byte)20);
        bp2.a(dg.a((byte)20, (byte)2), 5);
        r.a(true, (byte)2);
        byte by2 = r.a() ? (byte)13 : 12;
        Object object = (bs)dg.a(by2, (byte)0);
        r.a().a((dg)object, 1);
        x2.a((byte)4, (bs)object);
        byte[] byArray = new byte[]{1, 4, 2, 5, 6, 4};
        object = byArray;
        object = (bs)dg.a(byArray[by], (byte)0);
        r.a().a((dg)object, 1);
        x2.a((byte)3, (bs)object);
        byte[] byArray2 = new byte[]{-1, 4, 7, 5, -1, -1};
        object = byArray2;
        by = byArray2[by];
        if (by >= 0) {
            object = (bs)dg.a(by, (byte)0);
            r.a().a((dg)object, 1);
            x2.a((byte)5, (bs)object);
        }
        this.l();
    }

    public final void i(int n) {
        byte by = this.q;
        if (by == 1 || by == 2) {
            r.a.c(n, by);
            return;
        }
        r.a.b(n, (int)by);
    }

    public final void o() {
        int n;
        x x2;
        if (!ab.c || !this.m) {
            this.f = 1;
            x2 = this;
            n = 3;
        } else {
            this.f = (byte)(this.b > 0 ? 8 : 0);
            x2 = this;
            n = this.b > 0 ? 9 : 2;
        }
        x2.j = (byte)n;
    }

    public final void j(int n) {
        this.b = n;
        if (this.b[6]) {
            this.b += n * 50 / 100;
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

    public final void k(int n) {
        if (this.j < n) {
            this.j = n;
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
            int n;
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)filterOutputStream).writeByte(this.n);
            ((DataOutputStream)filterOutputStream).writeShort(this.c);
            ((DataOutputStream)filterOutputStream).writeShort(this.d);
            for (n = 0; n < 4; ++n) {
                ((DataOutputStream)filterOutputStream).writeInt(this.a[n]);
            }
            for (n = 0; n < 4; ++n) {
                ((DataOutputStream)filterOutputStream).writeShort(this.a[n]);
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
            int n;
            byteArrayInputStream = new ByteArrayInputStream(byArray);
            filterInputStream = new DataInputStream(byteArrayInputStream);
            this.n = ((DataInputStream)filterInputStream).readByte();
            this.c = ((DataInputStream)filterInputStream).readShort();
            this.d = ((DataInputStream)filterInputStream).readShort();
            for (n = 0; n < 4; ++n) {
                this.a[n] = ((DataInputStream)filterInputStream).readInt();
            }
            for (n = 0; n < 4; ++n) {
                this.a[n] = ((DataInputStream)filterInputStream).readShort();
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
        int n = 0;
        for (int i = 0; i < 4; ++i) {
            if (this.a[i] <= 0) continue;
            n += this.a[i];
            this.a[i] = 0;
        }
        this.c = (short)(this.c + n);
    }

    public final void r() {
        byte by;
        int n = 0;
        for (by = 0; by < 48; ++by) {
            if (this.aa[by] <= 0) continue;
            n += this.aa[by];
            this.aa[by] = 0;
        }
        for (by = 0; by < 20; ++by) {
            if (this.Z[by] <= 0) continue;
            n += this.Z[by];
            this.Z[by] = 0;
        }
        this.d = (short)(this.d + n);
        this.d = (short)(this.d - 36);
        this.u();
        for (by = 0; by < 2; by = (byte)(by + 1)) {
            r.a(by, true);
        }
        this.G();
    }

    public final ai a() {
        return this.a;
    }

    public final void g(byte by) {
        this.c(new ax(-6, by, 2));
    }

    public final void l(int n) {
        int n2 = 0;
        int n3 = 0;
        x x2 = this;
        x2.a[n3] = n2;
        n2 = 0;
        n3 = 1;
        x2 = this;
        x2.a[n3] = n2;
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
        byte by = 11;
        x x2 = this;
        if (x2.a[by]) {
            by = 11;
            x2 = this;
            int n = x2.b(by, 1);
            if (rpg.f.a(1, 99) > 100 - n) {
                return false;
            }
        }
        return true;
    }

    public final int b(int n) {
        int n2 = n;
        int n3 = 7;
        x x2 = this;
        if (x2.a[n3]) {
            n2 = this.b((byte)7, n);
        }
        return n2;
    }

    public final void m(int n) {
        int n2 = 0;
        int n3 = 0;
        if (this.e && n > 0) {
            n2 = this.a.a(n);
        }
        if (this.b[1] && n > 0) {
            n2 += n * 10 / 100;
        }
        int n4 = 16;
        x x2 = this;
        if (x2.a[n4]) {
            n4 = 16;
            x2 = this;
            n3 = x2.b((byte)n4, 1);
        }
        n4 = 17;
        x2 = this;
        if (x2.a[n4]) {
            n4 = 17;
            x2 = this;
            n2 += x2.b((byte)n4, 1);
        }
        if (this.b[3] && n > 0) {
            n3 += n * 5 / 100;
        }
        if (n2 > 0) {
            this.c(n2);
        }
        if (n3 > 0) {
            n4 = n3;
            x2 = this;
            x2.c((byte)1, n4);
        }
        this.D();
    }

    public final byte c() {
        byte by = 0;
        byte by2 = 12;
        x x2 = this;
        if (x2.a[by2] && rpg.f.a(0, 99) < 25) {
            by2 = 12;
            x2 = this;
            by = (byte)(0 + x2.b(by2, 1));
        }
        return by;
    }

    public final int c(int n) {
        int n2 = 18;
        x x2 = this;
        if (x2.a[n2]) {
            return this.b((byte)18, n);
        }
        return n;
    }

    public final void b(int n, int n2) {
        if (this.p == 7 || this.p == 6) {
            return;
        }
        if (this.d()) {
            return;
        }
        this.k = this.b[0] / n2;
        this.a((byte)6, n);
    }

    public final void n(int n) {
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
            this.a((byte)7, n);
            this.q(n);
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

    private boolean a(int n) {
        int n2 = 0;
        for (byte by = 0; by < 7; by = (byte)(by + 1)) {
            bs bs2 = this.a(by);
            if (bs2 == null || bs2.c != n) continue;
            ++n2;
        }
        return n2 > 2;
    }

    private void s(int n) {
        switch (n) {
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

    public final void h(byte by) {
        this.i = by;
        this.a((byte)99);
    }

    public static boolean d(byte by) {
        return by < 4;
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
