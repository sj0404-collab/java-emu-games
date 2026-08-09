/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;

class bi
extends j {
    private boolean c;
    private int j;
    private byte[] a;
    public boolean b = false;

    public bi(ah ah2, byte[] byArray, char c) {
        super(ah2, 0, 0, 0, (byte)1);
        this.a = byArray;
        this.a(dv.a(this.a, 144));
        this.c = false;
    }

    public bi(ah ah2, byte[] byArray, byte by) {
        this(ah2, byArray, '\u0000');
        ((j)this).a = by;
    }

    protected final void a(int n) {
        this.e = n;
        ((j)this).c = 160;
        this.d = 18 + this.e * 12 + (this.e - 1 << 1);
        ((j)this).a = rpg.a.c - (((j)this).c >> 1);
        ((j)this).b = rpg.a.d - (this.d >> 1);
    }

    public bi(ah ah2, byte[] byArray) {
        this(ah2, byArray, '\u0000');
        ((j)this).c = dv.a(byArray) + 16;
        ((j)this).a = rpg.a.c - (((j)this).c >> 1);
        this.c = true;
    }

    boolean a(int n, int n2) {
        if (this.b(n, n2)) {
            return true;
        }
        if (this.b) {
            if (n == -6) {
                ((ah)this).a.a((byte)3, (byte)0);
            } else if (n == -7) {
                ((ah)this).a.a((byte)3, (byte)1);
            }
            return true;
        }
        if (this.c) {
            return true;
        }
        if (((ah)this).a != null && (ah.f(n, n2) || ah.g(n, n2))) {
            ((ah)this).a.a(((j)this).a, (byte)-1);
        }
        return true;
    }

    protected void a(cr cr2) {
        cr2.a(7228201);
        cr2.d(((j)this).a - 3, ((j)this).b - 3, ((j)this).c + 5, this.d + 5);
        cr2.a(10646341);
        cr2.d(((j)this).a - 2, ((j)this).b - 2, ((j)this).c + 3, this.d + 3);
        j.a(cr2, ((j)this).a, ((j)this).b, ((j)this).c, this.d);
        cr2.a(7228201);
        cr2.d(((j)this).a - 1, ((j)this).b - 1, ((j)this).c + 1, this.d + 1);
        int n = ((j)this).b + 9;
        cr2.a(3550755);
        if (this.c) {
            this.j = this.j > 100 ? 0 : ++this.j;
            int n2 = this.a.length - this.j % 4;
            byte[] byArray = new byte[n2];
            System.arraycopy(this.a, 0, byArray, 0, n2);
            dv.a(cr2, ((j)this).a + 8, n, byArray, 0);
            ((ah)this).d = true;
            return;
        }
        if (this.e == 1) {
            dv.a(cr2, rpg.a.c, n, this.a, 1, 1);
            return;
        }
        dv.a(cr2, ((j)this).a + 8, n, 144, 1, this.a);
    }
}
