/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class cg
extends cf {
    public static cg a = null;
    private byte[] a = rpg.c.a(ec.b, 19);

    public cg(short s, short s2, short s3, byte by) {
        super(s, s2, s3, by);
        this.g = (byte)3;
        this.Z = new byte[]{0};
        if (this.e == 112 || this.e == 114) {
            a = this;
        }
    }

    protected final void c() {
        if (this.p == 6) {
            this.c_();
            return;
        }
        switch (this.p) {
            case 3: {
                switch (this.u) {
                    case 0: {
                        this.i = (byte)4;
                        break;
                    }
                    case 2: {
                        this.i = (byte)3;
                        break;
                    }
                    case 3: {
                        this.i = (byte)4;
                    }
                }
                break;
            }
            case 4: {
                this.i = (byte)2;
                break;
            }
            case 100: {
                this.i = (byte)9;
                break;
            }
            case 2: {
                this.i = 1;
                break;
            }
            default: {
                this.i = 0;
            }
        }
        this.c = ((db)this).a.a(this.i);
    }

    protected final boolean a(int n) {
        boolean bl = false;
        switch (this.u) {
            case 0: {
                bl = n == 4;
                break;
            }
            case 2: {
                bl = n == 4;
                break;
            }
            case 3: {
                bl = n % 3 == 1;
            }
        }
        return bl;
    }

    protected final void e() {
        switch (this.u) {
            case 0: {
                new as(3, ((c)this).a, ((c)this).b, ((db)this).a, 7, false, this, this.a(), this.r, ((db)this).j);
                return;
            }
            case 2: {
                int by = Math.abs(this.a[0] - ((c)this).c);
                int n = Math.abs(this.a[1] - ((c)this).c);
                int n2 = Math.abs(this.a[2] - ((c)this).d);
                int n3 = Math.abs(this.a[3] - ((c)this).d);
                byte by2 = by > n ? this.a[0] : this.a[1];
                byte by3 = n2 > n3 ? this.a[2] : this.a[3];
                this.a(by2, by3, true);
                return;
            }
            case 3: {
                new as(13, ((c)((ec)this).a).a, ((c)((ec)this).a).b, ((db)this).a, 5, true, this, this.a(), this.r, 3);
            }
        }
    }

    protected final boolean a() {
        if (this.u == 2) {
            this.u = (byte)3;
            this.a((byte)3);
            return true;
        }
        return false;
    }

    protected final void e_() {
        if (this.i()) {
            if (ds.a == null || ds.a.d()) {
                if (ds.a != null) {
                    ds.a.l();
                    ds.a = null;
                }
                a = null;
                this.l();
                return;
            }
            this.a((byte)100);
        }
    }
}
