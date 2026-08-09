/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;

public abstract class am
extends do {
    protected boolean e = false;
    protected short c = 0;
    protected int a = 0;

    public am(short s, short s2, byte by, byte by2) {
        super(s, s2, (byte)8, by2);
    }

    protected void g() {
    }

    protected void f() {
        this.a(0);
        this.b.removeAllElements();
        ((do)this).a.removeAllElements();
        if (this.a > 0) {
            this.a = 0;
        }
    }

    protected final void b(boolean bl) {
        byte by;
        if (this.a != 0) {
            return;
        }
        if ((do.a.nextInt() & 0xFF) % 6 == 0) {
            this.a((byte)((do.a.nextInt() & 0xFF) % 4 + 1), 0);
            return;
        }
        int n = 0;
        while (!r.a.a(this, by = (byte)((do.a.nextInt() & 0xFF) % 4 + 1)) && ++n < 5) {
        }
        this.a(by, (do.a.nextInt() & 0xF) % 2 + (bl ? 1 + ((c)this).e : 1));
    }

    protected final void a(byte by, int n) {
        if (this.t > 0) {
            this.c = (short)(16 / this.t * n);
        }
        this.i(by);
        if (n > 0) {
            this.a((byte)2);
        }
    }

    protected void a(int n) {
        this.c = (short)n;
        this.a((byte)1);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected final boolean a(c c2, byte by) {
        byte by2;
        byte by3 = this.a(c2);
        byte by4 = this.b(c2);
        byte by5 = by3;
        if (c2.c > ((c)this).c) {
            by5 = 0 - by3;
        }
        byte by6 = by4;
        if (c2.d > this.d) {
            by6 = 0 - by4;
        }
        byte by7 = 0;
        byte by8 = 0;
        if (by6 != 0) {
            byte by9 = by7 = by6 > 0 ? (byte)1 : 2;
        }
        if (by5 != 0) {
            by8 = by5 > 0 ? (byte)3 : 4;
        }
        by5 = 0;
        if (by3 < by4) {
            by6 = by7;
            by2 = by8;
        } else {
            by6 = by8;
            by2 = by7;
        }
        ab ab2 = r.a;
        if (by3 + by4 <= by) {
            if (by > 1 && by3 != by4 && by3 * by4 != 0) {
                if (ab2.a(this, by2)) {
                    this.a(by2, 1);
                    return true;
                }
                if (!ab2.a(this, by6)) return false;
                this.a(by6, 1);
                return true;
            }
            this.i(by6);
            if (by3 != by4) return false;
            this.r = (byte)((by7 << 1) + by8);
            return false;
        }
        if (this.a != 0) return false;
        by7 = 0;
        by8 = ab2.a(this, this.q) ? 1 : 0;
        if ((this.q == by6 || this.q == by2) && this.q != 0 && by8 != 0) {
            by7 = 1;
            by5 = this.q;
        } else if (by2 != 0 && rpg.b.Y[this.q] != by2 && ab2.a(this, by2)) {
            by7 = 1;
            by5 = by2;
        } else if (by6 != 0 && rpg.b.Y[this.q] != by6 && ab2.a(this, by6)) {
            by7 = 1;
            by5 = by6;
        } else {
            if (this.f(by6)) {
                this.c = (short)(16 / this.t << 1);
                return true;
            }
            if (this.f(by2)) {
                this.c = (short)(16 / this.t << 1);
                return true;
            }
        }
        if (by7 != 0) {
            if (this instanceof br && ((br)this).e()) {
                this.a(by5, by5 == 3 || by5 == 4 ? by3 - (by - 1) : by4 - (by - 1));
                return by7 != 0;
            } else {
                this.a(by5, 1);
            }
            return by7 != 0;
        } else {
            this.b(true);
        }
        return by7 != 0;
    }

    protected final void h() {
        if (this.c > 0) {
            this.A();
        }
        this.k();
    }

    public final void b(int n) {
        this.a = n;
    }

    protected boolean d() {
        return this.p == 7 || this.p == 6;
    }

    protected void a(int n, int n2, boolean bl) {
        if (this.d()) {
            return;
        }
        cr cr2 = rpg.a.a;
        if (((c)this).e == 1) {
            cr2.a(rpg.c.e[bl ? 1 : 0], n, n2 + 6, 33);
            return;
        }
        cr2.a(rpg.c.e[bl ? 1 : 0], n - 2, n2 + 6, 33);
        cr2.a(rpg.c.e[bl ? 1 : 0], n + 2, n2 + 6, 33);
    }
}
