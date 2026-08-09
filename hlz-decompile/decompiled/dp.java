/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;
import rpg.c;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class dp
extends ae {
    private byte a;
    private byte[] a;
    private byte[] b;
    private byte[] Z;
    private byte[] aa;
    private boolean a;

    public dp(ah ah2) {
        super(ah2, (byte)0);
        int n;
        this.e = 0;
        this.d = 0;
        byte by = 0;
        this.a = new byte[63];
        for (n = 0; n < 35; n = (int)((byte)(n + 1))) {
            if (r.a(n + 1) != 1) continue;
            this.a[by] = n;
            by = (byte)(by + 1);
        }
        this.a = by;
        for (n = 0; n < 28; n = (int)((byte)(n + 1))) {
            if (r.a(n + 51) != 1) continue;
            this.a[by] = n;
            by = (byte)(by + 1);
        }
        this.e = by;
        this.a = true;
    }

    final boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (ah.g(n, n2) || ah.f(n, n2)) {
            ((ah)this).a.d = (byte)7;
            ((ah)this).a.g();
        } else if (this.d(n, n2)) {
            this.a = true;
        }
        return true;
    }

    protected final void a(cr cr2) {
        int n;
        int n2;
        byte by = this.d;
        dp dp2 = this;
        if (dp2.a) {
            if (dp2.e <= 0) {
                dp2.Z = dj.a.a(62);
            } else {
                n2 = dp2.a[by];
                if (n2 >= 0) {
                    cx cx2 = by < dp2.a ? rpg.c.j : rpg.c.k;
                    n = n2 << 1;
                    dp2.b = cx2.a(n);
                    dp2.Z = cx2.a(n + 1);
                    dp2.aa = dj.a.a(by < dp2.a ? 63 : 64);
                    if (by >= dp2.a) {
                        switch (n2) {
                            case 1: {
                                dp2.a((byte)20, (byte)0, 10, rpg.b.e);
                                break;
                            }
                            case 5: {
                                dp2.a((byte)19, (byte)16, 10, rpg.b.f);
                                break;
                            }
                            case 15: {
                                dp2.a((byte)16, (byte)0, 10, rpg.b.g);
                                dp2.a((byte)16, (byte)5, 10, rpg.b.h);
                            }
                        }
                    }
                }
            }
        }
        this.a(cr2, false, true, true, false);
        int n3 = 32 + this.f;
        int n4 = n = this.g + 13 + 1;
        n2 = n3;
        cr cr3 = cr2;
        dp dp3 = this;
        cr3.a(0);
        cr3.a(n2, n4, 96, 11);
        cr3.a(0xFF0000);
        cr3.d(n2 + 1, n4 + 1, 93, 8);
        ah.a(cr3, n2 - 4, n4 + 5, 104, 0, false);
        dp3.a(cr3, n2 + 48, n4 + 2, dp3.e <= 0 ? 0 : dp3.d + 1, dp3.e, 1);
        int n5 = 5 + this.f;
        int n6 = n + 11 + 2;
        ah.d(cr2, n5, n6, 150, 14);
        n2 = n6 + 14 + 3;
        ah.d(cr2, n5, n2, 150, 120);
        cr2.a(15723216);
        cr2.e(this.f, n + 11, this.f + 160 - 1, n + 11);
        cr2.e(this.f, n2 - 2, this.f + 160 - 1, n2 - 2);
        if (this.b != null) {
            cr2.a(0xFFFFFF);
            dv.a(cr2, n5 + 6, n6 + 1, this.b, 1, 4);
            cr2.a(this.d < this.a ? 14597755 : 0xCCCCCC);
            dv.a(cr2, n5 + 150 - 6 + 2, n6 + 1, this.aa, 1, 8);
        } else {
            ae.a(cr2, rpg.a.c - 6, n6 + 6);
        }
        if (this.Z != null) {
            cr2.a(0xCCCCCC);
            dv.a(cr2, n5 + 6 - 2, n2 + 6, 146, 1, this.Z);
        }
    }

    private final void a(byte by, byte by2, int n, byte[] byArray) {
        bp bp2 = r.a(by);
        int n2 = bp2.a(by, by2);
        by = (byte)n2;
        if (n2 > 10) {
            by = (byte)10;
        }
        byte[] byArray2 = rpg.f.a(";&".getBytes(), byArray);
        byArray2 = rpg.f.a(byArray2, ("(" + by + "/" + 10 + ")").getBytes());
        this.Z = rpg.f.a(this.Z, byArray2);
    }
}
