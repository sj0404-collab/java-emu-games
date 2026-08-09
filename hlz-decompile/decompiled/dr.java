/*
 * Decompiled with CFR 0.152.
 */
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class dr
extends ct {
    private final byte[] a;
    private final byte[] b;
    private boolean a = false;

    dr(x x2) {
        super(x2);
        this.b = new byte[]{2, 1, 1, 4};
    }

    public final boolean a(byte by, int n) {
        int n2 = -1;
        byte by2 = n == this.a[by] ? (byte)1 : 0;
        int n3 = 0;
        dr dr2 = this;
        byte by3 = 1;
        switch (by) {
            case 0: 
            case 1: 
            case 2: {
                if (by2 != 0) {
                    this.a = this.a(this.b[by], by, -1, false, false, false);
                    if (this.a) {
                        this.c(by);
                    } else {
                        return false;
                    }
                }
                return true;
            }
            case 3: {
                if (!this.a) {
                    ((ct)this).a.b(0);
                    return true;
                }
                this.a(n);
                if (by2 != 0) {
                    n3 = this.c();
                    this.a(by);
                    this.a(this.b[by], by, -1, n3 != 0, false, false);
                }
                return true;
            }
            case 4: {
                this.a(n);
                if (by2 != 0) {
                    db db2 = ((ct)this).a.b();
                    if (db2 != null) {
                        n2 = this.a((byte)4, false);
                        ((ct)this).a.a(db2, by, n2, ((ct)this).a.q, (byte)22, this.c(), false, false);
                        for (by2 = 1; by2 <= 8; by2 = (byte)(by2 + 1)) {
                            boolean bl = this.c();
                            n3 = 22;
                            int n4 = n2;
                            byte by4 = by2;
                            byte by5 = by;
                            db db3 = db2;
                            dr dr3 = this;
                            boolean bl2 = (db3 = db3.b(by4)) != null ? ((ct)dr3).a.a(db3, by5, n4, ((ct)dr3).a.q, (byte)22, bl, false, false) : false;
                        }
                    }
                    this.a(by);
                }
                return true;
            }
            case 5: {
                if (by2 != 0) {
                    this.a(by);
                    ((ct)this).a.b((byte)3);
                } else if (n == 2 && ((ct)this).a.a() != null) {
                    ((ct)this).a.b((byte)6);
                }
                return true;
            }
            case 6: {
                this.a(n);
                if (by2 == 0) break;
                this.a(by);
                n2 = this.a((byte)5, false);
                n3 = this.c();
            }
        }
        if (by2 != 0) {
            if (((ct)this).a.a(by, n2, by3, n3 != 0, false, false)) {
                this.a(by);
            } else {
                return false;
            }
        }
        return true;
    }

    private void a(int n) {
        if (n == 2) {
            ((ct)this).a.i(5);
            return;
        }
        if (n == 4) {
            ((ct)this).a.i(-3);
        }
    }

    protected final byte a() {
        return 1;
    }

    public final boolean a(byte by) {
        return this.a();
    }

    private boolean c() {
        return f.a(1, 100) < this.c((byte)11);
    }

    protected final void a(byte by) {
        byte by2 = 8;
        switch (by) {
            case 3: 
            case 4: 
            case 6: {
                by2 = 2;
            }
        }
        bo.a(by2);
    }

    public final boolean b(byte by) {
        return by != 4;
    }
}
