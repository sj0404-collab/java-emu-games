/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class cn
extends ec {
    protected byte[] a = null;
    private byte[] ac = null;
    private byte g;
    private byte h;
    protected byte f;
    protected boolean f = false;
    private static byte v = (byte)8;
    private static byte w = (byte)13;

    public cn(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2, b.a[ck.f].a);
        s2 = 1;
        switch (s4) {
            case 102: 
            case 125: {
                this.k = true;
                this.f = 0;
                this.g = (byte)19;
                this.h = (byte)41;
                break;
            }
            case 103: 
            case 126: {
                ((c)this).d = (byte)5;
                this.l = true;
                this.f = 1;
                this.g = (byte)7;
                this.h = (byte)26;
                break;
            }
            case 104: 
            case 127: {
                this.m = true;
                this.f = (byte)2;
                this.g = (byte)5;
                this.h = (byte)38;
                break;
            }
            default: {
                s2 = 0;
            }
        }
        if (s2 != 0) {
            this.ac = rpg.c.a(ec.b, 10);
            this.a = rpg.c.a(ec.b, 5 + this.f);
            this.b(this.a);
            ck.a(this, this.f);
        }
        this.i((byte)1);
        this.a((byte)1);
    }

    protected void c() {
        switch (this.p) {
            case 0: 
            case 1: 
            case 2: 
            case 4: 
            case 5: {
                this.i = (byte)(this.f + (this.d() ? 4 : 1));
                break;
            }
            case 6: {
                this.i = (byte)(8 + this.f);
                break;
            }
            case 7: {
                this.i = (byte)(4 + this.f);
            }
        }
        this.c = ((db)this).a.a(this.i);
    }

    public void d_() {
        this.i = (byte)(11 + this.f);
        this.a((byte)3);
    }

    public void q() {
        this.i = (byte)(this.f + (this.d() ? 18 : 15));
        this.a((byte)3);
    }

    public final void l() {
        this.f = true;
        this.a((byte)1);
    }

    protected final void n() {
    }

    protected final boolean d() {
        return this.f || this.c() <= 0;
    }

    protected boolean a(int n2) {
        if (this.i == (byte)(11 + this.f)) {
            if (n2 == 6) {
                ab.a(1);
            } else if (n2 == 7) {
                new as(2, (short)(((c)this).a + this.g), (short)(((c)this).b + this.h), ((db)this).a, 21, true, null, 0, 0, 0);
            }
            return n2 >= v && n2 <= w && n2 % 2 == 0;
        }
        return false;
    }

    protected void e() {
        int n2 = ((c)this).c + this.ac[this.f << 1];
        int n3 = ((c)this).c + this.ac[(this.f << 1) + 1];
        do[] doArray = db.a();
        for (int i2 = 0; i2 < 2; ++i2) {
            if (doArray[i2] == null || doArray[i2].c < n2 || doArray[i2].c > n3) continue;
            this.b(doArray[i2], (int)this.a(), (byte)2);
            if (!doArray[i2].c()) continue;
            doArray[i2].j((byte)2);
        }
    }

    protected final void o() {
        this.c(this.a);
    }
}

