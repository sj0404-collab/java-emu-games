/*
 * Decompiled with CFR 0.152.
 */
import java.util.Vector;
import rpg.e;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class db
extends am
implements g {
    public short e;
    protected b a;
    protected at a;
    protected byte i;
    protected int c;
    private static Vector c = new Vector();
    private short d;
    protected do a;
    protected byte j;
    private byte f;
    protected byte k;
    protected byte l;
    protected byte m = 0;
    protected byte n = 0;
    private short j;
    private short k;
    protected byte o;
    protected int d = 0;
    protected int e;
    protected short f;
    protected short g;
    protected short h;
    protected short i;
    protected boolean g;
    private boolean f = false;
    protected boolean h;
    protected boolean i = false;
    private int b = 0;
    private byte g = 0;
    private int h = 0;
    private byte[] a = null;

    public static final void a(short s2, short s3, byte by2, byte by3) {
        short s4 = by2;
        by2 = (byte)s4;
        if (s4 < 0) {
            by2 = (byte)(by2 + 256);
        }
        switch (by2) {
            case 100: 
            case 123: {
                cs.f = by3;
                cs.d = by2;
                return;
            }
            case 99: 
            case 122: {
                new aq(s2, s3, (short)by2, by3);
                return;
            }
            case 101: 
            case 124: {
                new ck(149, 52, (short)by2, by3);
                return;
            }
            case 102: 
            case 125: {
                new cn(100, 85, (short)by2, by3);
                return;
            }
            case 103: 
            case 126: {
                new cn(148, 70, (short)by2, by3);
                return;
            }
            case 104: 
            case 127: {
                new cn(198, 81, (short)by2, by3);
                return;
            }
            case 105: 
            case 128: {
                new du(1, 1, (short)by2, by3);
                return;
            }
            case 106: 
            case 129: {
                new bf(168, 56, (short)by2, by3);
                return;
            }
            case 107: 
            case 130: {
                new bf(216, 72, (short)by2, by3);
                return;
            }
            case 108: 
            case 131: {
                new bf(248, 120, (short)by2, by3);
                return;
            }
            case 119: {
                new dl(135, 100, (short)by2, by3);
                return;
            }
            case 120: {
                new bw(s2, s3, (short)by2, by3);
                return;
            }
            case 121: {
                cp.f = by3;
                cp.d = by2;
                return;
            }
            case 109: 
            case 111: 
            case 113: {
                new ds(s2, s3, (short)by2, by3);
                return;
            }
            case 110: 
            case 112: 
            case 114: {
                new cg(s2, s3, (short)by2, by3);
                return;
            }
            case 115: {
                new by(s2, s3, (short)by2, by3);
                return;
            }
            case 116: {
                by.d = by2;
                by.f = by3;
                return;
            }
            case 117: 
            case 118: {
                new ad(s2, s3, (short)by2, by3);
                return;
            }
        }
        if (b.a[by3].a == 4) {
            new dz(s2, s3, (short)by2, by3);
            return;
        }
        if (b.a[by3].a == 5) {
            new cu(s2, s3, (short)by2, by3);
            return;
        }
        new db(s2, s3, by2, by3, b.a[by3].a, false);
    }

    protected db(short s2, short s3) {
        super(s2, s3, (byte)8, (byte)7);
        this.j = ((c)this).c;
        this.k = ((c)this).d;
        this.i((byte)2);
    }

    protected db(short s2, short s3, short s4, byte by2, at at2, boolean bl2) {
        this(s2, s3);
        this.e = s4;
        this.a = b.a[by2];
        this.a = at2;
        this.j = this.a.j;
        this.f = this.a.g;
        this.k = this.a.c;
        this.l = this.a.b;
        ((c)this).e = (byte)(this.a.e + 1);
        this.k(this.a.i);
        if (this.t <= 0) {
            this.b(-1);
        }
        if (bl2) {
            this.a((byte)0, this.a == null || this.a.d ? (byte)8 : 0);
            this.f();
            return;
        }
        this.d = 0;
        db.a(this);
    }

    protected void a(byte by2) {
        super.a(by2);
        if (this.p == 7 && this.e != -1) {
            r.c(this.e, this.a != null ? this.a.f : (byte)-1);
        } else if (this.p == 6) {
            this.m();
        }
        this.c();
    }

    protected void f() {
        db db2;
        int n2;
        super.f();
        if (this.a != null && this.a.a) {
            n2 = 0;
            db2 = this;
            ((c)this).c = n2;
        }
        this.r();
        db2 = this;
        n2 = r.h > 2 ? 2 : (int)r.h;
        if (n2 != 0) {
            byte by2 = db2.o;
            db2.o = (byte)((n2 + 1) * by2 / 5 + (n2 == 1 ? 40 : 60));
            db2.f = (short)(db2.f * db2.o / by2);
            db2.g = (short)(db2.g * db2.o / by2);
            db2.e = db2.d = (db2.d - 70) * (db2.o + (n2 == 1 ? 20 : 40)) / by2;
            db2.h = (short)((db2.h - 13) * db2.o / by2 + (n2 == 1 ? 20 : 40));
            db2.i = (short)((db2.i - 10) * db2.o / by2);
        }
        this.t();
        this.a = null;
        this.a = null;
        this.h = 0;
        this.f = false;
        this.h = false;
        this.g = false;
        this.g = 0;
        this.b = 0;
        this.i = false;
    }

    protected void r() {
        this.o = this.a.d;
        short s2 = this.a.d;
        this.d = s2;
        this.e = s2;
        this.f = this.a.b;
        this.g = this.a.c;
        this.h = this.a.e;
        this.i = this.a.f;
    }

    protected void t() {
        int n2 = (do.a.nextInt() & 0xFF) % 3;
        this.o = (byte)(this.o + n2);
        this.d += n2 * 20;
        this.e = this.d;
        this.h = (short)(this.h + n2 * 3);
    }

    protected int c() {
        return this.e;
    }

    protected int d() {
        return this.d;
    }

    public void a(int n2, int n3) {
        n2 = n2 + ((c)this).a + ((c)this).a + (((c)this).e - 1 << 3);
        n3 = n3 + ((c)this).b + ((c)this).b + 1;
        if (this.m > 0) {
            this.m = (byte)(this.m - 1);
            n2 += rpg.b.S[this.n] * g.a_[this.m];
            n3 += rpg.b.T[this.n] * g.a_[this.m];
        }
        if (n2 < -16 || n3 < 0 || n2 > bh.g + 16 || n3 > bh.h + 32) {
            this.b(n2, n3 - (this.a != null ? (int)this.a.h : 0), true);
            this.d(n2, n3);
            ((am)this).e = false;
            if (!this.h()) {
                return;
            }
        }
        ((am)this).e = true;
        if (!((c)this).c && !this.h()) {
            return;
        }
        this.a(n2, n3, this.g);
        n3 = this.a(n3);
        this.c(n2, n3);
        this.b(n2, n3, true);
        this.d(n2, n3);
    }

    protected int a(int n2) {
        if (this.g) {
            if (this.h >= this.a.length) {
                db db2 = this;
                this.g = false;
                db2.h = 0;
                db2.a = null;
                db2.e();
            } else {
                n2 -= this.a[this.h];
                ++this.h;
            }
        }
        return n2;
    }

    protected boolean h() {
        return false;
    }

    protected void c(int n2, int n3) {
        switch (this.p) {
            case 6: {
                rpg.c.a.a((byte)0, (byte)1, ((do)this).f, n2, n3);
                return;
            }
        }
        this.a.a(this.i, this.q, ((do)this).f, n2, n3);
    }

    protected void c() {
        int n2;
        db db2;
        if (this.a == null) {
            db2 = this;
            n2 = 0;
        } else {
            switch (this.p) {
                case 0: 
                case 1: 
                case 5: {
                    this.i = 0;
                    break;
                }
                case 2: {
                    this.i = 1;
                    break;
                }
                case 3: {
                    this.i = (byte)2;
                    break;
                }
                case 4: {
                    this.i = (byte)3;
                    break;
                }
                case 6: {
                    this.i = 0;
                    break;
                }
                default: {
                    this.c = 0;
                }
            }
            db2 = this;
            n2 = this.p == 6 ? (int)rpg.c.a.a(this.i) : (int)this.a.a(this.i);
        }
        db2.c = n2;
    }

    void d() {
        super.d();
        ++((do)this).f;
        this.z();
        this.m();
        if (((do)this).f < 0) {
            ((do)this).f = 0;
        }
        this.o(this.c);
        if (((am)this).c > 0) {
            ((am)this).c = (short)(((am)this).c - 1);
        }
        if (((am)this).a > 0) {
            --((am)this).a;
        }
    }

    protected void g() {
        if (((am)this).c > 0 && this.l()) {
            this.k();
            return;
        }
        this.a(this.l + this.g);
    }

    private static void a(db db2) {
        db2.b();
        c.addElement(db2);
    }

    public static final void u() {
        c.removeAllElements();
    }

    public static final void v() {
        for (int i2 = c.size() - 1; i2 >= 0; --i2) {
            db db2 = (db)c.elementAt(i2);
            if (db2.d == 0) {
                if (db2.a((byte)0, db2.a == null || db2.a.d ? (byte)8 : 0)) {
                    db2.f();
                    c.removeElementAt(i2);
                    continue;
                }
                db2.d = (short)10;
                continue;
            }
            if (db2.d <= 0) continue;
            db2.d = (short)(db2.d - 1);
        }
    }

    protected boolean a(byte by2, byte by3) {
        if (this.a(this.j, this.k, by2, by3)) {
            r.a.a(this);
            return true;
        }
        return false;
    }

    protected void w() {
        byte by2;
        if (this.e == 0) {
            return;
        }
        byte[] byArray = this.a.b;
        byte by3 = this.b();
        int n2 = Math.abs(do.a.nextInt()) % 65535;
        if (n2 < 52428) {
            r.a.a(this.a(), ((c)this).d, by3 * 6 + 20 >> 2);
        }
        for (int i2 = 0; i2 < 4; ++i2) {
            by2 = -1;
            byte by4 = -1;
            int n3 = rpg.f.a(byArray, i2 * 6 + 2);
            if (n2 >= n3) continue;
            switch (i2) {
                case 0: 
                case 1: {
                    by4 = (byte)rpg.f.a(do.a, byArray[i2 * 6], (int)byArray[i2 * 6 + 1]);
                    by2 = (byte)Math.min(by3 / 4, 14);
                    break;
                }
                case 2: {
                    if (by3 <= 13) {
                        by2 = -1;
                        by4 = -1;
                        break;
                    }
                    by4 = (byte)rpg.f.a(do.a, byArray[i2 * 6], (int)byArray[i2 * 6 + 1]);
                    by2 = (byte)Math.min(by3 / 5 + 13, 28);
                    break;
                }
                case 3: {
                    by4 = byArray[i2 * 6];
                    by2 = byArray[i2 * 6 + 1];
                }
            }
            if (by4 == -1 || by2 == -1) continue;
            r.a.a(this.a(), ((c)this).d, by4, by2);
            return;
        }
        if (n2 < 14500) {
            return;
        }
        if (n2 < 20000) {
            by2 = by3 < 20 ? (byte)2 : 6;
            r.a.a(this.a(), ((c)this).d, (byte)20, by2);
            return;
        }
        if (n2 < 25000 && this.e < 81) {
            by2 = (byte)Math.min(6 * this.e / 40, 11);
            r.a.a(this.a(), ((c)this).d, (byte)16, by2);
            return;
        }
        if (n2 < 35000) {
            int cfr_ignored_0 = n2 - (n2 / 2 << 1);
            by2 = false ? (byte)1 : 0;
            r.a.a(this.a(), ((c)this).d, (byte)20, by2);
            return;
        }
        if (n2 < 36500) {
            by2 = (byte)Math.min(3 * this.e / 10, 27);
            r.a.a(this.a(), ((c)this).d, (byte)18, by2);
            return;
        }
        if (n2 < 38000) {
            byte by5 = (byte)Math.min(this.e / 6, 15);
            by2 = by5;
            if (by5 > by3 / 5) {
                by2 = (byte)Math.min(by3 / 5, 15);
            }
            r.a.a(this.a(), ((c)this).d, (byte)17, by2);
            return;
        }
    }

    private final byte a() {
        if (((c)this).e == 1) {
            return ((c)this).c;
        }
        return (byte)(((c)this).c + (do.a.nextInt() & 1));
    }

    protected void m() {
        boolean bl2;
        boolean bl3 = bl2 = !((c)this).a && !((c)this).b;
        if (this.p == 6) {
            this.e_();
            return;
        }
        if (!((am)this).e && !this.h()) {
            this.a = null;
            return;
        }
        switch (this.p) {
            case 0: 
            case 1: {
                if (this.h || !bl2 && ((am)this).a != -1) break;
                this.n();
                return;
            }
            case 2: {
                if (((am)this).a != 0 && bl2) {
                    this.a(this.l + this.g);
                    return;
                }
                if (bl2 && this.h) {
                    this.a(this.l + this.g);
                    return;
                }
                if (((am)this).c == 0 && bl2) {
                    this.g();
                    return;
                }
                this.h();
                return;
            }
            case 3: {
                if (this.a(((do)this).f)) {
                    this.e();
                }
                if (!this.i()) break;
                this.j();
                return;
            }
            case 4: {
                if (!this.i()) break;
                this.a((byte)1);
                return;
            }
            case 8: {
                this.i();
            }
        }
    }

    protected final boolean i() {
        return this.c - ((do)this).f <= 0;
    }

    protected void n() {
        if (((am)this).c <= 0 && !this.g && r.d == 3) {
            if (this.a == null || this.a.p == 6 || this.a.p == 7) {
                this.k();
            }
            if (this.a == null) {
                if (((am)this).a == 0) {
                    this.b(false);
                    return;
                }
            } else if (!this.a((c)this.a, this.j)) {
                if (this.a((c)this.a)) {
                    this.a((byte)3);
                    return;
                }
                this.a = null;
            }
        }
    }

    protected void e() {
        switch (this.a.a) {
            case 0: {
                if (this.j == 1) {
                    if (this.a == r.a || this.a == r.a) {
                        if (r.a == this.a(this.q, r.a)) {
                            this.b(r.a, (int)this.a(), this.q);
                        }
                        if (r.a == null || r.a != this.a(this.q, r.a)) break;
                        this.b(r.a, (int)this.a(), this.q);
                        return;
                    }
                    if (this.a != this.a(this.q, this.a)) break;
                    this.b(this.a, (int)this.a(), this.q);
                    return;
                }
                if (this.j <= 1 || !this.a((c)this.a)) break;
                this.b(this.a, (int)this.a(), this.q);
                return;
            }
            case 1: {
                new as(3, ((c)this).a, ((c)this).b, this.a, 4, false, this, this.a(), this.r, this.j);
                return;
            }
            case 2: {
                int n2 = ((c)this).c + rpg.b.S[this.r];
                int n3 = ((c)this).d + rpg.b.T[this.r];
                if (ab.a(n2, n3)) break;
                new as(14, (short)(n2 << 4), (short)(n3 << 4), this.a, 4, false, this, this.a(), this.r, this.j);
                return;
            }
            case 3: {
                if (!this.a((c)this.a)) break;
                new as(13, ((c)this.a).a, ((c)this.a).b, this.a, 4, true, this, this.a(), this.r, 1);
            }
        }
    }

    protected void j() {
        this.a = null;
        this.a((int)this.k);
    }

    protected void i() {
    }

    public void l() {
        this.a((byte)7);
        short s2 = this.a.a;
        db db2 = this;
        this.d = s2;
        this.w();
        this.p();
        this.o();
        if (this.d > 0) {
            db.a(this);
        }
    }

    protected void o() {
        this.a = null;
        r.a.d(this);
    }

    protected final void a(short s2) {
        this.d = s2;
    }

    protected void e_() {
        if (this.i()) {
            this.l();
        }
    }

    protected void p() {
        if (this.e >= 81 && this.e <= 97) {
            r.a.f(100);
            return;
        }
        int n2 = 20 + this.b() - r.a.b();
        if (n2 < 0) {
            n2 = 0;
        } else if (n2 > 30) {
            n2 = 30;
        }
        r.a.f(18 * this.b() * n2 / 20);
    }

    protected void k() {
        do do_ = r.a;
        if (do_ != null && this.b(do_)) {
            this.a = do_;
            return;
        }
        do_ = r.a;
        if (do_ != null && this.b(do_)) {
            this.a = do_;
        }
    }

    protected boolean a(c c2) {
        if (c2 == null) {
            return false;
        }
        if (c2 instanceof do && ((do)c2).p == 7) {
            this.a = null;
            return false;
        }
        int n2 = this.a(c2);
        return n2 <= this.j;
    }

    protected final boolean b(c c2) {
        return this.a(c2) <= 5 && this.b(c2) <= 5;
    }

    protected boolean a(int n2) {
        return n2 == this.f;
    }

    public boolean a(do do_) {
        int n2;
        if (r.d != 3) {
            return false;
        }
        int n3 = 90 + this.b() - do_.b() - do_.b();
        if (n3 < 15) {
            n3 = 15;
        }
        return (n2 = (do.a.nextInt() & 0xFF) % 100) < n3;
    }

    protected void a(do do_, int n2, byte by2, byte by3) {
        if (do_ != null && (this.a == null || do_ instanceof an)) {
            this.a = do_;
        }
        if (by3 >= 11) {
            this.c(new dn(by3, by2));
        } else {
            this.c(new bj(by3));
        }
        if (n2 <= 0) {
            n2 = 5;
        }
        this.c(new ax(-5, 0, n2));
        this.a(do_, n2);
        if (!this.e()) {
            this.m = (byte)2;
            this.n = by2;
            if (this.p == 1 || this.p == 0) {
                this.a((byte)4);
            }
        }
    }

    public boolean a(x do_, byte by2, int n2, boolean bl2, byte by3, byte by4, boolean bl3, boolean bl4, boolean bl5) {
        boolean bl6;
        if (this.d()) {
            return false;
        }
        bh.a(this, false);
        ((c)this).c = true;
        boolean bl7 = bl6 = n2 == -100;
        if (n2 == -2 || !bl6 && bl4 && !do_.a(this)) {
            this.x();
            return false;
        }
        if (n2 == -90) {
            this.c(new ax(-3));
            return false;
        }
        if (n2 <= 0) {
            n2 = do_.c(bl3);
        }
        n2 = db.a(n2, do_.b(this.a()));
        if (do_.d > 0 && do_.a().a(this)) {
            if (by2 < 4) {
                x.h = (byte)3;
            }
            this.a(do_, this.e, by3, by4);
            do_.m(n2);
            return true;
        }
        if (bl6 || rpg.f.a(0, 99) < do_.a(this.b(), bl3)) {
            n2 += do_.a(n2);
            if (by4 == 2 || by4 == 4) {
                by4 = (byte)(by4 - 1);
            }
            if (!bl5) {
                byte[] byArray = new byte[]{7, 1};
                r.a.a(new z(false, 0xFFFFFF, byArray, ((c)this).c << 4, ((c)this).d << 4));
            }
            rpg.e.k();
            ab.g();
            if (by2 < 4 && r.b != 3) {
                x.h = (byte)10;
            }
        } else if (r.b == 0) {
            ab.g();
        }
        this.a(do_, n2, by3, by4);
        do_.m(n2);
        by2 = do_.c();
        do_ = this;
        if (by2 > 0) {
            ((db)do_).g = by2;
        }
        if (bl2) {
            this.j(by3);
        }
        return true;
    }

    public final void x() {
        this.c(new ax(-2));
    }

    public boolean a(int n2, byte by2) {
        if (this.d()) {
            return false;
        }
        ((c)this).c = true;
        if (n2 == -90) {
            this.c(new ax(-3));
            return false;
        }
        ai ai2 = r.a.a();
        if (ai2.b()) {
            n2 = n2 * 3 >> 1;
        }
        db db2 = this;
        this.a(r.a, db.a(n2, db2.i ? (db2.g << 2) / 5 : db2.g), by2, (byte)3);
        return true;
    }

    public final boolean b(int n2) {
        this.a(n2, rpg.b.Y[this.q]);
        return true;
    }

    protected final boolean b(do do_, int n2, byte by2) {
        boolean bl2 = !this.a(do_);
        if (bl2) {
            do_.c(new ax(do_ instanceof x ? (byte)-1 : -2));
            return false;
        }
        boolean bl3 = do_.a(this, n2, by2);
        n2 = bl3 ? 1 : 0;
        if (bl3 && this.a != null) {
            if (this.a.b && !do_.b()) {
                do_.b(60, 30);
            }
            if (this.a.c && !do_.b()) {
                do_.n(50);
            }
        }
        return n2 != 0;
    }

    protected boolean a(do do_, int n2, byte by2) {
        if (this.d()) {
            return false;
        }
        if (n2 == -90) {
            this.c(new ax(-3));
            return false;
        }
        this.c(new bj(1));
        this.a(do_, db.a(n2, this.a()), by2, (byte)3);
        return true;
    }

    private static int a(int n2, int n3) {
        if ((n2 -= n3) < 5) {
            return 5;
        }
        return n2;
    }

    protected void a(do do_, int n2) {
        boolean bl2 = true;
        do_ = this;
        ((c)this).c = bl2;
        this.e -= n2;
        if (this.e <= 0) {
            this.e = 0;
        }
    }

    protected void c(int n2) {
        this.e += n2;
        if (this.e > this.d()) {
            this.e = this.d();
        }
    }

    public final void a(byte[] byArray) {
        this.g = true;
        this.a = null;
        ((am)this).c = 1;
        this.h = 0;
        this.a = byArray;
        this.e();
    }

    protected boolean e() {
        if (this.e <= 0 && !this.g) {
            this.e = 0;
            this.a((byte)6);
            return true;
        }
        return false;
    }

    protected final boolean a(short s2, short s3, byte by2, byte by3) {
        ab ab2 = r.a;
        int n2 = 0;
        while (++n2 < 10) {
            int n3 = rpg.f.a(do.a, by2, (int)by3);
            int n4 = s2 + rpg.b.S[n3];
            if (!ab2.a(this, n4, n3 = s3 + rpg.b.T[n3])) continue;
            by2 = (byte)n3;
            s3 = (short)n4;
            db db2 = this;
            db2.a((short)(s3 << 4), (short)(by2 << 4));
            db2.a();
            db2.a_();
            return true;
        }
        return false;
    }

    protected final void a(df df2) {
        switch (df2.b) {
            case 39: {
                if (!ab.a()) {
                    ai.c(df2.b);
                }
                if (!ab.a) break;
                ++df2.b;
                return;
            }
            case 6: {
                if (df2.b % 10 != 0 || this.b <= 0) break;
                this.c(new ax(-5, 0, this.b));
                this.a(null, this.b);
                this.e();
            }
        }
    }

    protected final void b(df df2) {
        switch (df2.b) {
            case 16: {
                int n2 = r.a.a((byte)8);
                this.f = true;
                this.b((byte)17, n2);
                return;
            }
            case 17: {
                this.f = false;
                return;
            }
            case 5: {
                this.h = false;
                this.a((byte)1);
                return;
            }
            case 7: {
                this.i = false;
                return;
            }
            case 6: {
                this.b = 0;
            }
        }
    }

    public final boolean j() {
        return this.f;
    }

    public byte b() {
        return this.o;
    }

    public int c(byte by2) {
        int n2 = 0;
        switch (by2) {
            case 1: {
                n2 = this.i;
            }
        }
        return n2;
    }

    public int a() {
        if (this.i) {
            return (this.f << 2) / 5;
        }
        return this.f;
    }

    public short a() {
        if (this.i) {
            return (short)((this.h << 2) / 5);
        }
        return this.h;
    }

    public void d(int n2) {
        if (this.d()) {
            return;
        }
        if (!this.h) {
            this.h = true;
            if (this.p != 2) {
                this.a((byte)1);
            }
            this.a((byte)5, n2);
        }
    }

    public void b(int n2, int n3) {
        if (this.d()) {
            return;
        }
        if (this.b == 0) {
            this.b = n3;
            this.a((byte)6, n2);
        }
    }

    public final void n(int n2) {
        if (this.d()) {
            return;
        }
        if (!this.i) {
            this.i = true;
            this.a((byte)7, n2);
            this.q(n2);
        }
    }

    protected final boolean a(byte[] byArray, short s2, boolean bl2) {
        int n2;
        int n3;
        int n4;
        int n5;
        boolean bl3 = false;
        do do_ = r.a;
        block0: for (n5 = 0; !bl3 && n5 < byArray.length; n5 += 2) {
            n4 = ((c)this).c + byArray[n5];
            n3 = ((c)this).d + byArray[n5 + 1];
            for (n2 = 0; !bl3 && n2 < ((c)this).e; ++n2) {
                if (do_.c != n4 + n2 || do_.d != n3) continue;
                bl3 = this.b(do_, (int)s2, this.q);
                if (!bl2 || !bl3 || !r.a.c()) continue block0;
                do_.j(this.q);
                continue block0;
            }
        }
        n5 = 0;
        if (r.a != null) {
            do_ = r.a;
            block2: for (n2 = 0; n5 == 0 && n2 < byArray.length; n2 += 2) {
                n4 = ((c)this).c + byArray[n2];
                n3 = ((c)this).d + byArray[n2 + 1];
                for (int i2 = 0; n5 == 0 && i2 < ((c)this).e; ++i2) {
                    if (do_.c != n4 + i2 || do_.d != n3) continue;
                    n5 = this.b(do_, (int)s2, this.q) ? 1 : 0;
                    if (!bl2 || n5 == 0) continue block2;
                    do_.j((byte)(n2 / 2 + 1));
                    continue block2;
                }
            }
        }
        return bl3 || n5 != 0;
    }

    public final byte[] a() {
        return this.a.a;
    }

    protected static do[] a() {
        return new do[]{r.a, r.a};
    }
}

