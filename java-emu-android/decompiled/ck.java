/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class ck
extends ec {
    public static byte f;
    protected static ec[] a;

    protected ck(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2, b.a[by2].a);
        this.Z = rpg.c.a(ec.b, 8);
        this.aa = rpg.c.a(ec.b, 9);
        f = by2;
        this.h = -1;
        if (a == null) {
            a = new ec[3];
        }
        this.i((byte)1);
    }

    public static final void a(ec ec2, byte by2) {
        if (a == null) {
            a = new cn[3];
        }
        ck.a[by2] = ec2;
    }

    protected void c() {
        switch (this.p) {
            case 3: {
                this.i = (byte)14;
                break;
            }
            case 6: {
                this.i = (byte)7;
                break;
            }
            default: {
                this.i = 0;
            }
        }
        this.c = ((db)this).a.a(this.i);
    }

    protected final boolean e() {
        if (!(a[0] != null && !a[0].d() || a[1] != null && !a[1].d() || a[2] != null && !a[2].d() || this.g)) {
            this.e = 0;
            this.a((byte)6);
            return true;
        }
        return false;
    }

    protected final void n() {
        if (!this.e() && ((am)this).c <= 0 && !this.g) {
            this.C();
            switch (this.u) {
                case 0: 
                case 1: 
                case 2: {
                    if (a[this.u] == null) break;
                    ((cn)a[this.u]).d_();
                    return;
                }
                case 3: {
                    for (int i2 = 0; i2 < 3; ++i2) {
                        if (a[i2] == null) continue;
                        ((cn)a[i2]).q();
                    }
                    this.a((byte)3);
                }
            }
        }
    }

    private void C() {
        block3: while (true) {
            this.h = (this.h + 1) % this.Z.length;
            this.u = this.Z[this.h];
            ((am)this).c = this.aa[this.u];
            switch (this.u) {
                case 0: 
                case 1: 
                case 2: {
                    if (a[this.u] != null && a[this.u].c() > 0 && !((db)ck.a[this.u]).h) break block3;
                    continue block3;
                }
            }
            break;
        }
    }

    protected boolean a(int n2) {
        if (this.u == 3) {
            switch (n2) {
                case 10: {
                    ab.a(1);
                    break;
                }
                case 11: {
                    r.a.c(2, 2);
                    new as(0, ((c)this).a, (short)(((c)this).b + 112), ((db)this).a, 22, false, null, 0, 0, 0);
                    break;
                }
                case 12: {
                    r.a.c(2, 1);
                    break;
                }
                case 13: {
                    r.a.b(2, 3);
                    break;
                }
                case 14: {
                    r.a.c(2, 4);
                }
            }
            return n2 == 11;
        }
        return false;
    }

    protected void e() {
        do[] doArray = db.a();
        for (int i2 = 0; i2 < 2; ++i2) {
            if (doArray[i2] == null || doArray[i2].d > ((c)this).d + 7) continue;
            this.b(doArray[i2], (int)this.a(), (byte)2);
            if (!doArray[i2].c()) continue;
            doArray[i2].j((byte)2);
        }
    }

    protected final void o() {
        a[0].o();
        a[1].o();
        a[2].o();
        r.a.e(this);
        r.a.e(a[0]);
        r.a.e(a[1]);
        r.a.e(a[2]);
        a = null;
    }

    static {
        a = null;
    }
}

