/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class eb
extends j {
    private byte[] a = null;
    private int j = 1;
    private boolean b;
    private cw b = false;
    private cw c = null;

    private eb(ah ah2, byte[] byArray, byte[][] byArray2, boolean n) {
        super(ah2, byArray2.length, byArray2.length, 1, (byte)6);
        this.a = byArray;
        this.e = byArray2.length;
        for (n = 0; n < this.e; ++n) {
            int n2 = dv.a(byArray2[n]);
            if (n2 <= ((j)this).c) continue;
            ((j)this).c = n2;
        }
        ((j)this).c = !this.b && ((j)this).c < 155 ? 160 : (((j)this).c += 5);
        this.j = 1;
        int n3 = dv.a(byArray);
        if (n3 > ((j)this).c) {
            ((j)this).c = n3;
        }
        ((j)this).c += 11;
        if (((j)this).c > 160) {
            ((j)this).c = 160;
            this.j = dv.a(byArray, ((j)this).c - 10);
        }
        this.d = this.e + this.j << 4;
        if (!this.b) {
            this.d -= 16;
        }
        ((j)this).b = rpg.a.d - (this.d >> 1);
        ((j)this).a = rpg.a.c - (((j)this).c >> 1);
        try {
            this.b = cw.a("/sks/yes.png");
            this.c = cw.a("/sks/no.png");
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    private eb(ah ah2, byte[] byArray, byte by) {
        this(ah2, byArray, rpg.c.b.a(2, 3), false);
        ((j)this).a = by;
        if (((j)this).a == 4) {
            ((ah)this).d = 1;
        }
    }

    eb(ah ah2, byte[] byArray, byte by, boolean bl) {
        this(ah2, byArray, by);
    }

    final boolean a(int n, int n2) {
        if (((j)this).a == 1) {
            return false;
        }
        if (n == -6) {
            ((ah)this).a.a(((j)this).a, (byte)0);
        } else if (n == -7) {
            ((ah)this).a.g();
        }
        return true;
    }

    protected final void a(cr cr2) {
        int n = cr2.a();
        int n2 = cr2.b();
        int n3 = cr2.c();
        int n4 = cr2.d();
        cr2.b(0, 0, rpg.a.a, rpg.a.b);
        cr2.a(0);
        cr2.a(0, 0, rpg.a.a, rpg.a.b);
        if (rpg.c.k != null) {
            int n5 = rpg.c.k.a();
            for (int i = 0; i < rpg.a.a; i += n5) {
                cr2.a(rpg.c.k, i, 0, 20);
                cr2.a(rpg.c.k, i, rpg.a.b, 36);
            }
            if (this.b != null) {
                cr2.a(this.b, 0, rpg.a.b, 36);
            }
            if (this.c != null) {
                cr2.a(this.c, rpg.a.a, rpg.a.b, 40);
            }
        }
        cr2.a(0xFFFFFF);
        if (this.j == 1) {
            dv.a(cr2, rpg.a.c + 1, ((j)this).b + 5 + 1, this.a, 0, 1);
        } else {
            dv.a(cr2, 20, ((j)this).b + 5 + 1, rpg.a.a - 40, 0, this.a);
        }
        cr2.b(n, n2, n3, n4);
    }
}
