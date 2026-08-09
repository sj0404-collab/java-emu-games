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

    public final boolean a(byte by2, int n2) {
        boolean bl2 = n2 == this.a[by2];
        block0 : switch (by2) {
            case 4: {
                y y2 = this;
                if (n2 == 0) {
                    y2.a((byte)4);
                    n2 = ((ct)y2).a.e((byte)0) / 10;
                    ((ct)y2).a.c(-n2);
                    n2 = y2.c((byte)4);
                    ((ct)y2).a.e(n2);
                }
                return true;
            }
            case 5: {
                y y3 = this;
                switch (n2) {
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
                        n2 = y3.c((byte)5);
                        ((ct)y3).a.j(n2);
                    }
                }
                return true;
            }
            case 9: {
                if (n2 == 1) {
                    r.a.c(3, 1);
                    break;
                }
                if (n2 != 3) break;
                r.a.c(1, 2);
                break;
            }
            case 10: {
                switch (n2) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: {
                        bl2 = true;
                    }
                }
                break;
            }
            case 11: {
                switch (n2) {
                    case 2: {
                        this.a(by2);
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
        if (bl2) {
            if (this.a(this.b[by2], by2, -1, false, false, false)) {
                this.c(by2);
            } else {
                return false;
            }
        }
        return true;
    }

    protected final byte a() {
        return 2;
    }

    public final boolean a(byte by2) {
        switch (by2) {
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

    protected final void a(byte by2) {
        byte by3 = 6;
        switch (by2) {
            case 11: {
                by3 = 2;
                break;
            }
            case 4: 
            case 5: {
                by3 = 0;
            }
        }
        bo.a(by3);
    }

    public final boolean b(byte by2) {
        switch (by2) {
            case 4: 
            case 5: {
                return false;
            }
        }
        return true;
    }
}

