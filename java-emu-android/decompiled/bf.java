/*
 * Decompiled with CFR 0.152.
 */
final class bf
extends cn {
    public bf(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2);
        switch (s4) {
            case 106: 
            case 129: {
                this.k = true;
                this.f = 0;
                break;
            }
            case 107: 
            case 130: {
                this.l = true;
                this.f = 1;
                break;
            }
            case 108: 
            case 131: {
                this.m = true;
                this.f = (byte)2;
            }
        }
        this.a = rpg.c.a(ec.b, 11);
        this.b(this.a);
        ck.a(this, this.f);
    }

    protected final void c() {
        switch (this.p) {
            case 0: 
            case 1: 
            case 2: 
            case 4: 
            case 5: {
                this.i = (byte)(this.d() ? 2 : 0);
                break;
            }
            case 6: {
                this.i = 1;
                break;
            }
            case 7: {
                this.i = (byte)2;
            }
        }
        this.c = ((db)this).a.a(this.i);
    }

    public final void d_() {
        this.i = (byte)3;
        this.a((byte)3);
    }

    public final void q() {
        this.i = (byte)(this.f + (this.d() ? 13 : 4));
        this.a((byte)3);
    }

    protected final boolean a(int n2) {
        if (this.i == 3 && n2 == 8) {
            ab.a(1);
            new as((byte)(4 + this.f), (short)(((c)this).a + 5), (short)(((c)this).b + 5), ((db)this).a, 12, true, this, this.a(), 0, 0);
        }
        return false;
    }

    protected final void e() {
    }

    protected final void a(byte by2) {
        super.a(by2);
        if (this.p == 6) {
            this.f = true;
            for (by2 = 1; by2 < 3; by2 = (byte)(by2 + 1)) {
                ck.a[(this.f + by2) % 3].a(this);
            }
        }
    }
}

