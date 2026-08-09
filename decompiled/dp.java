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
        int n2;
        this.e = 0;
        this.d = 0;
        byte by2 = 0;
        this.a = new byte[63];
        for (n2 = 0; n2 < 35; n2 = (int)((byte)(n2 + 1))) {
            if (r.a(n2 + 1) != 1) continue;
            this.a[by2] = n2;
            by2 = (byte)(by2 + 1);
        }
        this.a = by2;
        for (n2 = 0; n2 < 28; n2 = (int)((byte)(n2 + 1))) {
            if (r.a(n2 + 51) != 1) continue;
            this.a[by2] = n2;
            by2 = (byte)(by2 + 1);
        }
        this.e = by2;
        this.a = true;
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3) || ah.f(n2, n3)) {
            ((ah)this).a.d = (byte)7;
            ((ah)this).a.g();
        } else if (this.d(n2, n3)) {
            this.a = true;
        }
        return true;
    }

    protected final void a(cr cr2) {
        int n2;
        int n3;
        byte by2 = this.d;
        dp dp2 = this;
        if (dp2.a) {
            if (dp2.e <= 0) {
                dp2.Z = dj.a.a(62);
            } else {
                n3 = dp2.a[by2];
                if (n3 >= 0) {
                    cx cx2 = by2 < dp2.a ? rpg.c.j : rpg.c.k;
                    n2 = n3 << 1;
                    dp2.b = cx2.a(n2);
                    dp2.Z = cx2.a(n2 + 1);
                    dp2.aa = dj.a.a(by2 < dp2.a ? 63 : 64);
                    if (by2 >= dp2.a) {
                        switch (n3) {
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
        int n4 = 32 + this.f;
        int n5 = n2 = this.g + 13 + 1;
        n3 = n4;
        cr cr3 = cr2;
        dp dp3 = this;
        cr3.a(0);
        cr3.a(n3, n5, 96, 11);
        cr3.a(0xFF0000);
        cr3.d(n3 + 1, n5 + 1, 93, 8);
        ah.a(cr3, n3 - 4, n5 + 5, 104, 0, false);
        dp3.a(cr3, n3 + 48, n5 + 2, dp3.e <= 0 ? 0 : dp3.d + 1, dp3.e, 1);
        int n6 = 5 + this.f;
        int n7 = n2 + 11 + 2;
        ah.d(cr2, n6, n7, 150, 14);
        n3 = n7 + 14 + 3;
        ah.d(cr2, n6, n3, 150, 120);
        cr2.a(15723216);
        cr2.e(this.f, n2 + 11, this.f + 160 - 1, n2 + 11);
        cr2.e(this.f, n3 - 2, this.f + 160 - 1, n3 - 2);
        if (this.b != null) {
            cr2.a(0xFFFFFF);
            dv.a(cr2, n6 + 6, n7 + 1, this.b, 1, 4);
            cr2.a(this.d < this.a ? 14597755 : 0xCCCCCC);
            dv.a(cr2, n6 + 150 - 6 + 2, n7 + 1, this.aa, 1, 8);
        } else {
            ae.a(cr2, rpg.a.c - 6, n7 + 6);
        }
        if (this.Z != null) {
            cr2.a(0xCCCCCC);
            dv.a(cr2, n6 + 6 - 2, n3 + 6, 146, 1, this.Z);
        }
    }

    private final void a(byte by2, byte by3, int n2, byte[] byArray) {
        bp bp2 = r.a(by2);
        int n3 = bp2.a(by2, by3);
        by2 = (byte)n3;
        if (n3 > 10) {
            by2 = (byte)10;
        }
        byte[] byArray2 = rpg.f.a(";&".getBytes(), byArray);
        byArray2 = rpg.f.a(byArray2, ("(" + by2 + "/" + 10 + ")").getBytes());
        this.Z = rpg.f.a(this.Z, byArray2);
    }
}

