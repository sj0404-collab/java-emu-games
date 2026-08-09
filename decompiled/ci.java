/*
 * Decompiled with CFR 0.152.
 */
import rpg.b;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class ci
extends ct {
    private final byte[] a;
    private final byte[] b;
    private final byte[] Z;
    private final byte[] aa;
    private boolean a;
    private db a = null;

    ci(x x2) {
        super(x2);
        this.b = new byte[]{3, 0, 6};
        this.Z = new byte[]{0, 0, 0, 0, 0, 0, 2};
        this.aa = new byte[]{40, 45, 45, 40, 27, 27, 27, 27, 27, 27, 27, 27, 10, -2, 4};
    }

    /*
     * Enabled aggressive block sorting
     */
    public final boolean a(byte by2, int n2) {
        int n3 = 0;
        int n4 = n2 == this.a[by2] ? 1 : 0;
        switch (by2) {
            case 0: 
            case 1: 
            case 2: {
                if (n2 == this.b[by2]) {
                    n3 = 1;
                    n4 = 1;
                }
            }
            case 3: {
                if (n4 == 0) return true;
                if (!this.a(this.Z[(by2 << 1) + (n3 != 0 ? 1 : 0)], by2, -1, false, n3 != 0, false)) return false;
                this.c(by2);
                return true;
            }
            case 4: {
                ci ci2 = this;
                n3 = 1;
                switch (n2) {
                    case 0: {
                        ci2.a = false;
                        return n3 != 0;
                    }
                    case 2: 
                    case 5: {
                        n2 = ci2.a((byte)4, ((ct)ci2).a.f((byte)1), true);
                        int n5 = n2 = f.a(0, 99) < n2 ? -100 : -2;
                        if (((ct)ci2).a.a((byte)4, (byte)2, (byte)11, n2)) {
                            ci2.a((byte)4);
                        } else {
                            n3 = 0;
                        }
                        ci2.a = ((ct)ci2).a.g > 0;
                        return n3 != 0;
                    }
                    case 4: 
                    case 6: {
                        if (!ci2.a) return n3 != 0;
                        ((ct)ci2).a.i(rpg.b.Y[((ct)ci2).a.q]);
                        ci2.a = false;
                        return n3 != 0;
                    }
                }
                return n3 != 0;
            }
            case 5: {
                ci ci3 = this;
                switch (n2) {
                    case 4: {
                        db db2 = ((ct)ci3).a.a();
                        if (db2 != null && !db2.d()) {
                            if (f.a(0, 99) < ci3.c((byte)5)) {
                                n4 = ((ct)ci3).a.c(false);
                                db2.b(75, n4);
                            } else {
                                db2.x();
                            }
                        }
                        ci3.a((byte)5);
                    }
                    case 6: {
                        r.a.c(2, n2);
                        return true;
                    }
                }
                return true;
            }
            case 6: {
                ci ci4 = this;
                n3 = 0;
                n4 = 0;
                if (n2 > 0 && n2 < 13) {
                    r.a.c(ci4.aa[n2 - 1] >> 1, 2);
                }
                switch (n2) {
                    case 1: {
                        ci4.a = ((ct)ci4).a.a();
                        if (ci4.a == null) {
                            ci4.a = false;
                            return true;
                        }
                        n2 = ci4.a((byte)6, false);
                        ci ci5 = ci4;
                        ci4.a = ci4.a.a(((ct)ci4).a, (byte)6, n2, false, ((ct)ci4).a.q, (byte)2, false, true, true);
                        if (ci4.a) {
                            ci4.a.a(ci4.aa);
                            return true;
                        }
                    }
                    case 2: {
                        if (ci4.a) return true;
                        ((do)((ct)ci4).a).f = 15;
                        return true;
                    }
                    case 3: {
                        ((ct)ci4).a.d(true);
                        break;
                    }
                    case 8: 
                    case 12: {
                        n4 = 1;
                    }
                    case 5: {
                        n3 = 1;
                        break;
                    }
                    case 13: {
                        ((ct)ci4).a.d(false);
                        if (ci4.a == null) break;
                        ci4.a = null;
                        break;
                    }
                    case 14: {
                        r.a.c(2, 2);
                    }
                }
                if (n3 == 0) return true;
                if (ci4.a != null) {
                    n2 = ci4.a((byte)6, n4 != 0);
                    ci ci6 = ci4;
                    ci4.a.a(((ct)ci4).a, (byte)6, n2, false, ((ct)ci4).a.q, (byte)2, false, true, true);
                }
                ci4.a((byte)6);
                return true;
            }
            case 7: {
                if (n4 == 0) return true;
                by2 = (byte)this.c((byte)7);
                ci ci7 = this;
                ((ct)this).a.a((byte)7, by2, (byte)2, -2);
                this.a((byte)7);
                return true;
            }
            case 8: {
                ci ci8 = this;
                n3 = n2 == 4 ? 1 : 0;
                switch (n2) {
                    case 1: 
                    case 4: {
                        n4 = ci8.a((byte)8, n3 != 0);
                        r.a.a(new bc(((ct)ci8).a, n2 == 4 ? (byte)1 : 0, 8, n4));
                        ci8.a((byte)7);
                        return true;
                    }
                }
                return true;
            }
            case 9: {
                ci ci9 = this;
                if (n2 != 5) return true;
                ((ct)ci9).a.b((byte)10);
                ab.a(1);
                for (n3 = 1; n3 <= 4; n3 = (int)((byte)(n3 + 1))) {
                    ((ct)ci9).a.e((byte)n3);
                }
                n3 = ci9.c((byte)9);
                an.a(r.a, (short)n3);
                ci9.a((byte)9);
                return true;
            }
        }
        return true;
    }

    protected final byte a() {
        return 2;
    }

    public final boolean a(byte by2) {
        if (by2 == 7) {
            return true;
        }
        return this.a();
    }

    protected final void a(byte by2) {
        byte by3 = 5;
        switch (by2) {
            case 5: 
            case 7: 
            case 9: {
                by3 = 0;
                break;
            }
            case 8: {
                by3 = 4;
            }
        }
        bo.a(by3);
    }

    public final boolean b(byte by2) {
        switch (by2) {
            case 7: 
            case 9: 
            case 10: {
                return false;
            }
        }
        return true;
    }
}

