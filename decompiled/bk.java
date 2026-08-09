/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class bk
extends j {
    private int j = 0;
    private byte[] a;
    private byte[][] a = null;
    private int k;
    private int l = 1;
    private boolean b = true;
    private boolean c = false;
    private boolean h = true;

    bk(ah ah2, byte[] byArray, byte[][] byArray2, boolean n2) {
        super(ah2, byArray2.length, byArray2.length, 1, (byte)6);
        this.h = n2;
        this.a = byArray;
        this.a = byArray2;
        this.e = byArray2.length;
        for (n2 = 0; n2 < this.e; ++n2) {
            int n3 = dv.a(byArray2[n2]);
            if (n3 <= ((j)this).c) continue;
            ((j)this).c = n3;
        }
        ((j)this).c = !this.h && ((j)this).c < 155 ? 160 : (((j)this).c += 5);
        this.l = 1;
        int n4 = ((j)this).c;
        int n5 = dv.a(byArray);
        if (n5 > ((j)this).c) {
            ((j)this).c = n5;
        }
        ((j)this).c += 11;
        if (((j)this).c > 160) {
            ((j)this).c = 160;
            this.l = dv.a(byArray, ((j)this).c - 10);
        }
        this.d = (this.e + this.l << 4) + 10 + 3;
        if (!this.h) {
            this.d -= 16;
        }
        ((j)this).b = rpg.a.d - (this.d >> 1);
        ((j)this).a = rpg.a.c - (((j)this).c >> 1);
        this.k = 4;
        this.j = rpg.a.c - (n4 >> 1);
        this.c = false;
    }

    bk(ah ah2, byte[] byArray, byte[][] byArray2) {
        this(ah2, byArray, byArray2, true);
    }

    bk(ah ah2, byte[] byArray, byte by2, boolean bl2) {
        this(ah2, byArray, rpg.c.b.a(2, 3), false);
        ((j)this).a = by2;
        this.k = 1;
        this.j = rpg.a.c + 1;
        this.b = bl2;
        if (((j)this).a == 4) {
            ((ah)this).d = 1;
        }
        if (by2 == 3) {
            this.c = true;
        }
    }

    bk(ah ah2, byte[] byArray, byte by2, boolean bl2, boolean bl3) {
        this(ah2, byArray, by2, bl2);
        this.c = true;
    }

    final boolean a(int n2, int n3) {
        if (this.h) {
            if (this.c(n2, n3)) {
                ((ah)this).d = true;
                return true;
            }
        } else if (this.d(n2, n3)) {
            ((ah)this).d = true;
            return true;
        }
        if (ah.f(n2, n3)) {
            ((ah)this).a.a(((j)this).a, ((ah)this).d);
        } else if (this.c && ah.g(n2, n3)) {
            ((ah)this).a.a(((j)this).a, (byte)1);
        }
        return true;
    }

    protected final void a(cr cr2) {
        int n2;
        int n3;
        if (this.b) {
            j.a(cr2, ((j)this).a, ((j)this).b, ((j)this).c, this.d);
            cr2.a(15723216);
            cr2.d(((j)this).a, ((j)this).b, ((j)this).c - 1, this.d - 1);
            cr2.a(3550755);
        } else {
            int n4 = this.d;
            int n5 = ((j)this).c;
            n3 = ((j)this).b;
            n2 = ((j)this).a;
            cr cr3 = cr2;
            cr3.b(n2 - 1, n3 - 1, n5 + 2, n4 + 2);
            cr3.a(3550755);
            cr3.a(n2 - 1, n3 - 1, n5 + 2, n4 + 2);
            cr3.a(7027456);
            cr3.d(n2, n3, n5 - 1, n4 - 1);
            cr2.a(0x660000);
        }
        if (this.h) {
            cr2.a(((j)this).a + 2, ((j)this).b + 5 + (((ah)this).d + this.l << 4) + 3, ((j)this).c - 4, 16);
        }
        if (!this.b) {
            cr2.a(0xFFFFFF);
        }
        if (this.l == 1) {
            dv.a(cr2, rpg.a.c + 1, ((j)this).b + 5 + 1, this.a, 0, 1);
        } else {
            dv.a(cr2, ((j)this).a + 5, ((j)this).b + 5 + 1, ((j)this).c - 10, 0, this.a);
        }
        if (this.h) {
            for (int i2 = 0; i2 < this.e; ++i2) {
                cr2.a(i2 == ((ah)this).d ? 0xFFFFFF : (this.b ? 0 : 12630160));
                dv.a(cr2, this.j, ((j)this).b + 5 + 1 + (i2 + this.l << 4) + 3, this.a[i2], 0, this.k);
            }
            return;
        }
        n2 = ((j)this).b + 5 + 1 + (this.l << 4) + 3;
        for (n3 = 0; n3 < this.e; ++n3) {
            int n6 = rpg.a.c - 30 + n3 * 60;
            if (n3 == ((ah)this).d) {
                cr2.a(0x660000);
                cr2.a(n6 - 26, n2 - 1, 52, 15);
            }
            cr2.a(n3 == ((ah)this).d ? 0xFFFFFF : (this.b ? 0 : 12630160));
            dv.a(cr2, n6, n2, this.a[n3], 0, 1);
        }
    }
}

