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

    public final boolean a(byte by2, int n2) {
        int n3 = -1;
        byte by3 = n2 == this.a[by2] ? (byte)1 : 0;
        int n4 = 0;
        dr dr2 = this;
        byte by4 = 1;
        switch (by2) {
            case 0: 
            case 1: 
            case 2: {
                if (by3 != 0) {
                    this.a = this.a(this.b[by2], by2, -1, false, false, false);
                    if (this.a) {
                        this.c(by2);
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
                this.a(n2);
                if (by3 != 0) {
                    n4 = this.c();
                    this.a(by2);
                    this.a(this.b[by2], by2, -1, n4 != 0, false, false);
                }
                return true;
            }
            case 4: {
                this.a(n2);
                if (by3 != 0) {
                    db db2 = ((ct)this).a.b();
                    if (db2 != null) {
                        n3 = this.a((byte)4, false);
                        ((ct)this).a.a(db2, by2, n3, ((ct)this).a.q, (byte)22, this.c(), false, false);
                        for (by3 = 1; by3 <= 8; by3 = (byte)(by3 + 1)) {
                            boolean bl2 = this.c();
                            n4 = 22;
                            int n5 = n3;
                            byte by5 = by3;
                            byte by6 = by2;
                            db db3 = db2;
                            dr dr3 = this;
                            boolean bl3 = (db3 = db3.b(by5)) != null ? ((ct)dr3).a.a(db3, by6, n5, ((ct)dr3).a.q, (byte)22, bl2, false, false) : false;
                        }
                    }
                    this.a(by2);
                }
                return true;
            }
            case 5: {
                if (by3 != 0) {
                    this.a(by2);
                    ((ct)this).a.b((byte)3);
                } else if (n2 == 2 && ((ct)this).a.a() != null) {
                    ((ct)this).a.b((byte)6);
                }
                return true;
            }
            case 6: {
                this.a(n2);
                if (by3 == 0) break;
                this.a(by2);
                n3 = this.a((byte)5, false);
                n4 = this.c();
            }
        }
        if (by3 != 0) {
            if (((ct)this).a.a(by2, n3, by4, n4 != 0, false, false)) {
                this.a(by2);
            } else {
                return false;
            }
        }
        return true;
    }

    private void a(int n2) {
        if (n2 == 2) {
            ((ct)this).a.i(5);
            return;
        }
        if (n2 == 4) {
            ((ct)this).a.i(-3);
        }
    }

    protected final byte a() {
        return 1;
    }

    public final boolean a(byte by2) {
        return this.a();
    }

    private boolean c() {
        return f.a(1, 100) < this.c((byte)11);
    }

    protected final void a(byte by2) {
        byte by3 = 8;
        switch (by2) {
            case 3: 
            case 4: 
            case 6: {
                by3 = 2;
            }
        }
        bo.a(by3);
    }

    public final boolean b(byte by2) {
        return by2 != 4;
    }
}

