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

    public final boolean a(byte by2, int n2) {
        byte by3 = n2 == this.a[by2] ? (byte)1 : 0;
        switch (by2) {
            case 3: {
                if (n2 == 3) {
                    by3 = 1;
                }
            }
            case 0: 
            case 1: 
            case 2: {
                if (by3 == 0) break;
                if (this.a(this.b[by2], by2, -1, false, false, false)) {
                    this.c(by2);
                    break;
                }
                return false;
            }
            case 4: {
                this.a(n2);
                n2 = by3;
                ac ac2 = this;
                if (n2 != 0) {
                    db db2 = ((ct)ac2).a.a();
                    return ac2.a(db2, (byte)4, ac2.a());
                }
                return true;
            }
            case 5: {
                if (by3 == 0) break;
                this.a(by2);
                by2 = (byte)this.a((byte)5, ((ct)this).a.e((byte)0), false);
                ((ct)this).a.c((int)by2);
                break;
            }
            case 6: {
                this.a(n2);
                n2 = by3;
                ac ac3 = this;
                if (n2 != 0) {
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
                if (by3 == 0) break;
                this.a(by2);
                ((ct)this).a.m();
                break;
            }
            case 8: {
                this.a(n2);
                n2 = by3;
                ac ac4 = this;
                if (n2 != 0) {
                    db db4 = ((ct)ac4).a.a();
                    if (ac4.a(db4, (byte)8, (byte)3)) {
                        by3 = ((ct)ac4).a.q;
                        db4.j(by3);
                        ((ct)ac4).a.j(by3);
                    } else {
                        return false;
                    }
                }
                return true;
            }
            case 9: {
                if (by3 == 0) break;
                this.a(by2);
                by2 = (byte)this.c(by2);
                ((ct)this).a.b((byte)80, by2);
            }
        }
        return true;
    }

    private boolean a(db db2, byte by2, byte by3) {
        if (db2 != null) {
            int n2;
            byte by4 = by2;
            ac ac2 = this;
            bs bs2 = ((ct)ac2).a.a((byte)5);
            int n3 = -2;
            if (bs2 != null) {
                int n4 = ((ct)ac2).a.a(true);
                n3 = n4 + bs2.b + (bs2.c - bs2.b) * f.a(1, 100) / 100;
                int n5 = ac2.a(by4, n4, false);
                n3 += n5;
            }
            if (db2.a(((ct)this).a, by2, n2 = n3, true, ((ct)this).a.q, by3, true, true, false)) {
                this.a(by2);
                return true;
            }
        }
        return false;
    }

    private void a(int n2) {
        if (n2 == 0) {
            this.a(3, true);
            return;
        }
        if (n2 == 2) {
            this.a(1, false);
        }
    }

    private void a(int n2, boolean bl2) {
        if (((ct)this).a.q <= 2) {
            r.a.c(n2, bl2 ? 0 : 1);
            return;
        }
        r.a.b(n2, bl2 ? 0 : 1);
    }

    protected final byte a() {
        int n2 = 2;
        bs bs2 = ((ct)this).a.a((byte)3);
        if (bs2 != null && bs2.g == 3) {
            n2 = 4;
        }
        return (byte)n2;
    }

    public final boolean a(byte by2) {
        switch (by2) {
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

    protected final void a(byte by2) {
        int n2 = 7;
        switch (by2) {
            case 4: 
            case 6: 
            case 8: {
                break;
            }
            case 5: 
            case 7: 
            case 9: {
                n2 = 0;
                break;
            }
            default: {
                bs bs2 = ((ct)this).a.a((byte)3);
                if (bs2 == null || bs2.g != 2) break;
                n2 = 4;
            }
        }
        bo.a((byte)n2);
    }

    public final boolean b(byte by2) {
        switch (by2) {
            case 5: 
            case 7: 
            case 9: {
                return false;
            }
        }
        return true;
    }
}

