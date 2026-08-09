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

    public final boolean a(byte by, int n) {
        switch (by) {
            case 4: {
                if (n >= 2 && n <= 5) {
                    ((ct)this).a.d(true);
                } else if (n == 7 || n == 9) {
                    r.a.c(2, n);
                    ((ct)this).a.d(false);
                }
                if (n == 7) {
                    n = this.a((byte)4, false);
                    ((ct)this).a.a(by, n, this.a(), false, false, false);
                    this.c(by);
                }
                return true;
            }
            case 5: {
                dy dy2 = this;
                if (n != 3) break;
                db db2 = ((ct)dy2).a.a();
                if (db2 != null && db2.a(((ct)dy2).a, (byte)5, -1, false, ((ct)dy2).a.q, dy2.a(), false, true, false)) {
                    int n2 = dy2.c((byte)5);
                    db2.d(n2);
                }
                dy2.c((byte)5);
                break;
            }
            case 6: {
                dy dy3 = this;
                if (n != 4) break;
                n = dy3.a((byte)6, false);
                ((ct)dy3).a.a((byte)6, (byte)3, dy3.a(), n);
                dy3.c((byte)6);
                break;
            }
            case 7: {
                dy dy4 = this;
                if (n == 4) {
                    n = dy4.c((byte)7);
                    for (byte by2 = 1; by2 <= 12; by2 = (byte)(by2 + 1)) {
                        db db3 = ((ct)dy4).a.a(by2);
                        if (db3 == null) continue;
                        if (f.a(0, 99) < n) {
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
                if (n == 6) {
                    n = ((ct)dy5).a.e((byte)0) / 10;
                    int n3 = dy5.a((byte)8, n, false);
                    ((ct)dy5).a.c(-n);
                    ((ct)dy5).a.d(n3);
                    bh.c = true;
                    dy5.a((byte)8);
                } else if (n == 4) {
                    ab.a(1);
                }
                return true;
            }
            case 9: {
                if (n == 0 || n == 2 || n == 4) {
                    n = this.a((byte)9, false);
                    if (((ct)this).a.a((byte)9, n, this.a())) {
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
                if ((n = n == this.a[by] ? 1 : 0) == 0) break;
                if (this.a(this.b[by], by, -1, false, false, false)) {
                    this.c(by);
                    break;
                }
                return false;
            }
        }
        return true;
    }

    protected final byte a() {
        int n = 1;
        bs bs2 = ((ct)this).a.a((byte)3);
        if (bs2 != null && bs2.g == 0) {
            n = 3;
        }
        return (byte)n;
    }

    public final boolean a(byte by) {
        switch (by) {
            case 7: 
            case 8: {
                return true;
            }
        }
        return this.a();
    }

    protected final void a(byte by) {
        byte by2 = 8;
        switch (by) {
            case 4: {
                by2 = 1;
                break;
            }
            case 5: {
                by2 = 3;
                break;
            }
            case 6: 
            case 7: 
            case 8: {
                by2 = 0;
            }
        }
        bo.a(by2);
    }

    public final boolean b(byte by) {
        switch (by) {
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
