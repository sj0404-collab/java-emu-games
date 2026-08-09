/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class y
extends ct {
    private final byte[] a = new byte[]{2, 2, -1, -1, 0, 10, 1, 0, 0, 1, 0, 3};
    private final byte[] b = new byte[]{0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 2, 0};

    y(x x2) {
        super(x2);
    }

    public final boolean a(byte by, int n) {
        boolean bl = n == this.a[by];
        block0 : switch (by) {
            case 4: {
                y y2 = this;
                if (n == 0) {
                    y2.a((byte)4);
                    n = ((ct)y2).a.e((byte)0) / 10;
                    ((ct)y2).a.c(-n);
                    n = y2.c((byte)4);
                    ((ct)y2).a.e(n);
                }
                return true;
            }
            case 5: {
                y y3 = this;
                switch (n) {
                    case 3: {
                        y3.a((byte)5);
                    }
                    case 5: 
                    case 7: 
                    case 9: {
                        r.a.c(2, 2);
                        break;
                    }
                    case 10: {
                        n = y3.c((byte)5);
                        ((ct)y3).a.j(n);
                    }
                }
                return true;
            }
            case 9: {
                if (n == 1) {
                    r.a.c(3, 1);
                    break;
                }
                if (n != 3) break;
                r.a.c(1, 2);
                break;
            }
            case 10: {
                switch (n) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: {
                        bl = true;
                    }
                }
                break;
            }
            case 11: {
                switch (n) {
                    case 2: {
                        this.a(by);
                        ab.a(1);
                        break block0;
                    }
                    case 3: 
                    case 4: 
                    case 5: {
                        r.a.a(new bc(((ct)this).a, 2, 11, -1));
                    }
                }
            }
        }
        if (bl) {
            if (this.a(this.b[by], by, -1, false, false, false)) {
                this.c(by);
            } else {
                return false;
            }
        }
        return true;
    }

    protected final byte a() {
        return 2;
    }

    public final boolean a(byte by) {
        switch (by) {
            case 4: 
            case 5: {
                return true;
            }
        }
        return this.a();
    }

    public final byte b() {
        return (byte)(((ct)this).a.b > 0 ? 6 : 2);
    }

    protected final void a(byte by) {
        byte by2 = 6;
        switch (by) {
            case 11: {
                by2 = 2;
                break;
            }
            case 4: 
            case 5: {
                by2 = 0;
            }
        }
        bo.a(by2);
    }

    public final boolean b(byte by) {
        switch (by) {
            case 4: 
            case 5: {
                return false;
            }
        }
        return true;
    }
}
