/*
 * Decompiled with CFR 0.152.
 */
import rpg.b;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class dw
extends ct {
    private db a;
    private db b;

    dw(x x2) {
        super(x2);
    }

    public final boolean a(byte by2, int n2) {
        block53: {
            block0 : switch (by2) {
                case 0: {
                    dw dw2 = this;
                    boolean bl2 = false;
                    boolean bl3 = false;
                    if (n2 == 0) {
                        bl2 = true;
                        dw2.c((byte)0);
                    } else if (n2 == 2) {
                        bl3 = true;
                        bl2 = true;
                    }
                    if (!bl2) break;
                    dw dw3 = dw2;
                    dw2.a((byte)0, -1, (byte)4, bl3);
                    break;
                }
                case 4: {
                    dw dw4 = this;
                    boolean bl4 = false;
                    boolean bl5 = false;
                    dw dw5 = dw4;
                    byte by3 = 4;
                    switch (n2) {
                        case 2: {
                            if (((ct)dw4).a.a((byte)3) != null) {
                                by3 = 12;
                            }
                        }
                        case 0: {
                            bl4 = true;
                            break;
                        }
                        case 6: {
                            if (((ct)dw4).a.a((byte)5) != null) {
                                by3 = 13;
                            }
                        }
                        case 4: {
                            bl5 = true;
                            bl4 = true;
                        }
                    }
                    if (!bl4) break;
                    n2 = dw4.a((byte)4, ((ct)dw4).a.c((byte)1), false);
                    dw4.a((byte)4, n2 += ((ct)dw4).a.c(bl5), by3, bl5);
                    dw4.a((byte)4);
                    break;
                }
                case 5: {
                    dw dw6 = this;
                    switch (n2) {
                        case 0: {
                            dw6.a((byte)5);
                            dw6.b = dw6.a();
                            if (dw6.b == null) break;
                            dw6.b.b(14);
                            dw6.b.c(new dn(14, 14));
                            break;
                        }
                        case 9: {
                            ab.a(1);
                            break;
                        }
                        case 10: {
                            ((ct)dw6).a.i(-3);
                            if (dw6.b != null) {
                                int n3 = dw6.b((byte)5, ((ct)dw6).a.a(false), false);
                                dw dw7 = dw6;
                                dw6.b.a(((ct)dw6).a, (byte)5, n3, false, ((ct)dw6).a.q, (byte)4, false, false, false);
                            }
                            bo.a((byte)1);
                            break;
                        }
                        case 12: {
                            ((ct)dw6).a.i(1);
                        }
                    }
                    break;
                }
                case 6: {
                    int n4;
                    dw dw8 = this;
                    boolean bl6 = false;
                    switch (n2) {
                        case 1: {
                            dw8.b = dw8.a();
                            ((ct)dw8).a.j(rpg.b.Y[((ct)dw8).a.q]);
                        }
                        case 3: {
                            bl6 = true;
                        }
                        case 5: {
                            n4 = dw8.b((byte)6, ((ct)dw8).a.a(bl6), bl6);
                            dw8.a((byte)6);
                            break;
                        }
                        default: {
                            break block0;
                        }
                    }
                    if (dw8.b == null) {
                        dw8.b = dw8.a();
                    }
                    if (dw8.b == null) break;
                    dw dw9 = dw8;
                    ((ct)dw8).a.a(dw8.b, (byte)6, n4, ((ct)dw8).a.q, (byte)4, false, false, false);
                    break;
                }
                case 7: {
                    dw dw10 = this;
                    boolean bl7 = false;
                    switch (n2) {
                        case 0: {
                            dw10.a();
                        }
                        case 4: 
                        case 8: 
                        case 12: {
                            dw10.a((byte)7);
                            break;
                        }
                        case 2: 
                        case 6: 
                        case 10: {
                            bl7 = true;
                            break;
                        }
                        default: {
                            break block0;
                        }
                    }
                    int n5 = dw10.a((byte)7, ((ct)dw10).a.a(bl7), false);
                    if (n5 <= 0) break;
                    dw dw11 = dw10;
                    ((ct)dw10).a.a((byte)7, n5, (byte)4, bl7, false);
                    break;
                }
                case 8: {
                    dw dw12 = this;
                    switch (n2) {
                        case 0: {
                            dw12.a((byte)8);
                            break;
                        }
                        case 2: {
                            ab.a(1);
                            break;
                        }
                        case 5: {
                            dw12.a = dw12.a();
                            if (dw12.a == null) break;
                            dw12.a.b((byte)16, 1);
                        }
                    }
                    break;
                }
                case 9: {
                    dw dw13 = this;
                    switch (n2) {
                        case 0: {
                            dw13.a((byte)9);
                            dw13.b = dw13.a();
                            if (dw13.b != null) {
                                dw13.b.b(14);
                                dw13.b.c(new dn(14, 14));
                                break block0;
                            }
                            break block53;
                        }
                        case 11: {
                            ((ct)dw13).a.i(-3);
                            break block0;
                        }
                        case 12: {
                            if (dw13.b != null) {
                                int n6;
                                if (dw13.b instanceof ec) {
                                    n6 = -90;
                                } else {
                                    int n7 = dw13.c((byte)9);
                                    n6 = f.a(0, 99) < n7 ? dw13.b.e + dw13.b.a() : ((ct)dw13).a.c(false) << 1;
                                }
                                dw13.b.a(((ct)dw13).a, (byte)9, n6, false, ((ct)dw13).a.q, (byte)15, false, false, false);
                            }
                            bo.a((byte)1);
                            break block0;
                        }
                        case 13: {
                            ((ct)dw13).a.i(1);
                        }
                    }
                }
            }
        }
        return true;
    }

    private int b(byte by2, int n2, boolean bl2) {
        int n3 = this.a(by2, n2, false);
        by2 = (byte)n3;
        int n4 = n3 + ((ct)this).a.c(bl2);
        by2 = (byte)n4;
        return n4;
    }

    private db a() {
        if (this.a != null && this.a.j()) {
            if (this.a.d()) {
                this.a = null;
            } else {
                int n2;
                int n3 = ((c)((ct)this).a).a - ((c)this.a).a;
                int n4 = Math.abs(n3);
                if (n4 <= 96 && (n2 = Math.abs(n4 = ((c)((ct)this).a).b - ((c)this.a).b)) <= 96) {
                    if (n4 > n3 || n3 == 0) {
                        ((ct)this).a.q = (byte)(n4 > 0 ? 1 : 2);
                    } else if (n4 > n3 || n4 == 0) {
                        ((ct)this).a.q = (byte)(n3 > 0 ? 3 : 4);
                    }
                    return this.a;
                }
            }
        }
        this.b = ((ct)this).a.b();
        return this.b;
    }

    private boolean a(byte by2, int n2, byte by3, boolean bl2) {
        if (bl2 && !this.b()) {
            return false;
        }
        this.b = this.a();
        if (this.b != null) {
            return ((ct)this).a.a(this.b, by2, n2, ((ct)this).a.q, by3, false, bl2, false);
        }
        return false;
    }

    protected final byte a() {
        return 4;
    }

    public final boolean a(byte by2) {
        return this.a();
    }

    protected final void a(byte by2) {
        byte by3 = 9;
        switch (by2) {
            case 5: 
            case 8: 
            case 9: {
                by3 = 0;
            }
        }
        bo.a(by3);
    }

    public final boolean b(byte by2) {
        return false;
    }
}

