/*
 * Decompiled with CFR 0.152.
 */
public abstract class ec
extends db {
    protected static byte[] b = null;
    protected x a = null;
    protected boolean j = true;
    protected boolean k = false;
    protected boolean l = false;
    protected boolean m = false;
    protected byte u;
    protected byte[] Z = null;
    protected int h = -1;
    protected byte[] aa = null;
    protected byte[] ab = null;

    protected ec(short s2, short s3, short s4, byte by2, at at2) {
        super(s2, s3, s4, by2, at2, true);
        this.i = 0;
        this.a = r.a;
        this.a((short)-1);
        if (b == null) {
            b = rpg.c.a("/t/bd");
        }
        ab.f = true;
    }

    public static final void B() {
        b = null;
    }

    public final void d(int n2) {
    }

    protected final void b(byte[] byArray) {
        ab ab2 = r.a;
        for (int i2 = 0; i2 < byArray.length; i2 += 2) {
            try {
                ab2.a[((c)this).d + byArray[i2 + 1]][((c)this).c + byArray[i2]] = this;
                continue;
            }
            catch (Exception exception) {}
        }
    }

    protected final void w() {
    }

    protected final void r() {
        this.o = ((db)this).a.d;
        short s2 = ((db)this).a.d;
        this.d = s2;
        this.e = s2;
        this.f = ((db)this).a.b;
        this.g = ((db)this).a.c;
        ((db)this).h = ((db)this).a.e;
        this.i = ((db)this).a.f;
    }

    protected final void t() {
    }

    protected final void c(byte[] byArray) {
        ab ab2 = r.a;
        for (int i2 = 0; i2 < byArray.length; i2 += 2) {
            try {
                ab2.a[((c)this).d + byArray[i2 + 1]][((c)this).c + byArray[i2]] = null;
                continue;
            }
            catch (Exception exception) {}
        }
    }

    protected final void a(int n2, int n3, boolean bl2) {
        if (!this.j) {
            super.a(n2, n3, bl2);
        }
    }

    protected final void j(byte by2) {
        if (this.j) {
            return;
        }
        super.j(by2);
    }

    protected final boolean h() {
        return true;
    }

    public final void b(int n2, int n3) {
    }

    protected final boolean a(byte by2, byte by3) {
        switch (this.e) {
            case 101: 
            case 102: 
            case 103: 
            case 104: 
            case 105: 
            case 106: 
            case 107: 
            case 108: 
            case 124: 
            case 125: 
            case 126: 
            case 127: 
            case 128: 
            case 129: 
            case 130: 
            case 131: {
                r.a.b(this);
                break;
            }
            default: {
                r.a.a(this);
            }
        }
        return true;
    }

    protected void a(do do_, int n2) {
        super.a(do_, n2);
        if (this.l) {
            do_.a(this, n2 / 5, (byte)0, (byte)2);
        }
    }

    protected final int a(int n2) {
        super.a(n2);
        return n2;
    }

    protected final void a(ec ec2) {
        this.k = this.k || ec2.k;
        this.l = this.l || ec2.l;
        this.m = this.m || ec2.m;
        ec2.m = false;
        ec2.l = false;
        ec2.k = false;
    }

    public boolean a(x x2, byte by2, int n2, boolean bl2, byte by3, byte by4, boolean bl3, boolean bl4, boolean bl5) {
        if (this.j) {
            return super.a(x2, by2, n2, bl2, by3, by4, bl3, bl4, bl5);
        }
        return super.a(x2, by2, bl5 ? -90 : n2, bl2, by3, by4, bl3, bl4, bl5);
    }

    protected void c(int n2, int n3) {
        if (((db)this).a != null) {
            ((db)this).a.a(this.i, this.q, ((do)this).f, n2, n3);
        }
    }

    protected void j() {
        this.a(this.aa == null ? 0 : this.aa[this.u]);
    }
}

