/*
 * Decompiled with CFR 0.152.
 */
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class ac
extends ct {
    private final byte[] a = new byte[]{1, 2, 2, 1, 0, 0, 0, 2, 0, 6};
    private final byte[] b = new byte[]{0, 0, 1, 0};

    ac(x x2) {
        super(x2);
    }

    public final boolean a(byte by, int n) {
        byte by2 = n == this.a[by] ? (byte)1 : 0;
        switch (by) {
            case 3: {
                if (n == 3) {
                    by2 = 1;
                }
            }
            case 0: 
            case 1: 
            case 2: {
                if (by2 == 0) break;
                if (this.a(this.b[by], by, -1, false, false, false)) {
                    this.c(by);
                    break;
                }
                return false;
            }
            case 4: {
                this.a(n);
                n = by2;
                ac ac2 = this;
                if (n != 0) {
                    db db2 = ((ct)ac2).a.a();
                    return ac2.a(db2, (byte)4, ac2.a());
                }
                return true;
            }
            case 5: {
                if (by2 == 0) break;
                this.a(by);
                by = (byte)this.a((byte)5, ((ct)this).a.e((byte)0), false);
                ((ct)this).a.c((int)by);
                break;
            }
            case 6: {
                this.a(n);
                n = by2;
                ac ac3 = this;
                if (n != 0) {
                    db db3 = ((ct)ac3).a.a();
                    if (ac3.a(db3, (byte)6, (byte)3)) {
                        db3.d(30);
                    } else {
                        return false;
                    }
                }
                return true;
            }
            case 7: {
                if (by2 == 0) break;
                this.a(by);
                ((ct)this).a.m();
                break;
            }
            case 8: {
                this.a(n);
                n = by2;
                ac ac4 = this;
                if (n != 0) {
                    db db4 = ((ct)ac4).a.a();
                    if (ac4.a(db4, (byte)8, (byte)3)) {
                        by2 = ((ct)ac4).a.q;
                        db4.j(by2);
                        ((ct)ac4).a.j(by2);
                    } else {
                        return false;
                    }
                }
                return true;
            }
            case 9: {
                if (by2 == 0) break;
                this.a(by);
                by = (byte)this.c(by);
                ((ct)this).a.b((byte)80, by);
            }
        }
        return true;
    }

    private boolean a(db db2, byte by, byte by2) {
        if (db2 != null) {
            int n;
            byte by3 = by;
            ac ac2 = this;
            bs bs2 = ((ct)ac2).a.a((byte)5);
            int n2 = -2;
            if (bs2 != null) {
                int n3 = ((ct)ac2).a.a(true);
                n2 = n3 + bs2.b + (bs2.c - bs2.b) * f.a(1, 100) / 100;
                int n4 = ac2.a(by3, n3, false);
                n2 += n4;
            }
            if (db2.a(((ct)this).a, by, n = n2, true, ((ct)this).a.q, by2, true, true, false)) {
                this.a(by);
                return true;
            }
        }
        return false;
    }

    private void a(int n) {
        if (n == 0) {
            this.a(3, true);
            return;
        }
        if (n == 2) {
            this.a(1, false);
        }
    }

    private void a(int n, boolean bl) {
        if (((ct)this).a.q <= 2) {
            r.a.c(n, bl ? 0 : 1);
            return;
        }
        r.a.b(n, bl ? 0 : 1);
    }

    protected final byte a() {
        int n = 2;
        bs bs2 = ((ct)this).a.a((byte)3);
        if (bs2 != null && bs2.g == 3) {
            n = 4;
        }
        return (byte)n;
    }

    public final boolean a(byte by) {
        switch (by) {
            case 4: 
            case 6: 
            case 8: {
                return this.b();
            }
            case 5: 
            case 9: {
                return true;
            }
        }
        return this.a();
    }

    protected final void a(byte by) {
        int n = 7;
        switch (by) {
            case 4: 
            case 6: 
            case 8: {
                break;
            }
            case 5: 
            case 7: 
            case 9: {
                n = 0;
                break;
            }
            default: {
                bs bs2 = ((ct)this).a.a((byte)3);
                if (bs2 == null || bs2.g != 2) break;
                n = 4;
            }
        }
        bo.a((byte)n);
    }

    public final boolean b(byte by) {
        switch (by) {
            case 5: 
            case 7: 
            case 9: {
                return false;
            }
        }
        return true;
    }
}
