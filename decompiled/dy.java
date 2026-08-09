/*
 * Decompiled with CFR 0.152.
 */
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class dy
extends ct {
    private final byte[] a = new byte[]{2, 3, 1, 4};
    private final byte[] b = new byte[]{0, 3, 1, 1};

    dy(x x2) {
        super(x2);
    }

    public final boolean a(byte by2, int n2) {
        switch (by2) {
            case 4: {
                if (n2 >= 2 && n2 <= 5) {
                    ((ct)this).a.d(true);
                } else if (n2 == 7 || n2 == 9) {
                    r.a.c(2, n2);
                    ((ct)this).a.d(false);
                }
                if (n2 == 7) {
                    n2 = this.a((byte)4, false);
                    ((ct)this).a.a(by2, n2, this.a(), false, false, false);
                    this.c(by2);
                }
                return true;
            }
            case 5: {
                dy dy2 = this;
                if (n2 != 3) break;
                db db2 = ((ct)dy2).a.a();
                if (db2 != null && db2.a(((ct)dy2).a, (byte)5, -1, false, ((ct)dy2).a.q, dy2.a(), false, true, false)) {
                    int n3 = dy2.c((byte)5);
                    db2.d(n3);
                }
                dy2.c((byte)5);
                break;
            }
            case 6: {
                dy dy3 = this;
                if (n2 != 4) break;
                n2 = dy3.a((byte)6, false);
                ((ct)dy3).a.a((byte)6, (byte)3, dy3.a(), n2);
                dy3.c((byte)6);
                break;
            }
            case 7: {
                dy dy4 = this;
                if (n2 == 4) {
                    n2 = dy4.c((byte)7);
                    for (byte by3 = 1; by3 <= 12; by3 = (byte)(by3 + 1)) {
                        db db3 = ((ct)dy4).a.a(by3);
                        if (db3 == null) continue;
                        if (f.a(0, 99) < n2) {
                            db3.n(75);
                            db3.a(((ct)dy4).a, (byte)7, -1, false, ((ct)dy4).a.q, (byte)1, false, true, false);
                            continue;
                        }
                        db3.x();
                    }
                    dy4.a((byte)7);
                }
                return true;
            }
            case 8: {
                dy dy5 = this;
                if (n2 == 6) {
                    n2 = ((ct)dy5).a.e((byte)0) / 10;
                    int n4 = dy5.a((byte)8, n2, false);
                    ((ct)dy5).a.c(-n2);
                    ((ct)dy5).a.d(n4);
                    bh.c = true;
                    dy5.a((byte)8);
                } else if (n2 == 4) {
                    ab.a(1);
                }
                return true;
            }
            case 9: {
                if (n2 == 0 || n2 == 2 || n2 == 4) {
                    n2 = this.a((byte)9, false);
                    if (((ct)this).a.a((byte)9, n2, this.a())) {
                        this.c((byte)9);
                    } else {
                        return false;
                    }
                }
                return true;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                if ((n2 = n2 == this.a[by2] ? 1 : 0) == 0) break;
                if (this.a(this.b[by2], by2, -1, false, false, false)) {
                    this.c(by2);
                    break;
                }
                return false;
            }
        }
        return true;
    }

    protected final byte a() {
        int n2 = 1;
        bs bs2 = ((ct)this).a.a((byte)3);
        if (bs2 != null && bs2.g == 0) {
            n2 = 3;
        }
        return (byte)n2;
    }

    public final boolean a(byte by2) {
        switch (by2) {
            case 7: 
            case 8: {
                return true;
            }
        }
        return this.a();
    }

    protected final void a(byte by2) {
        byte by3 = 8;
        switch (by2) {
            case 4: {
                by3 = 1;
                break;
            }
            case 5: {
                by3 = 3;
                break;
            }
            case 6: 
            case 7: 
            case 8: {
                by3 = 0;
            }
        }
        bo.a(by3);
    }

    public final boolean b(byte by2) {
        switch (by2) {
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return false;
            }
        }
        return true;
    }
}

