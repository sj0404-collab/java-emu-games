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

    public am(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, (byte)8, by3);
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

    protected final void b(boolean bl2) {
        byte by2;
        if (this.a != 0) {
            return;
        }
        if ((do.a.nextInt() & 0xFF) % 6 == 0) {
            this.a((byte)((do.a.nextInt() & 0xFF) % 4 + 1), 0);
            return;
        }
        int n2 = 0;
        while (!r.a.a(this, by2 = (byte)((do.a.nextInt() & 0xFF) % 4 + 1)) && ++n2 < 5) {
        }
        this.a(by2, (do.a.nextInt() & 0xF) % 2 + (bl2 ? 1 + ((c)this).e : 1));
    }

    protected final void a(byte by2, int n2) {
        if (this.t > 0) {
            this.c = (short)(16 / this.t * n2);
        }
        this.i(by2);
        if (n2 > 0) {
            this.a((byte)2);
        }
    }

    protected void a(int n2) {
        this.c = (short)n2;
        this.a((byte)1);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected final boolean a(c c2, byte by2) {
        byte by3;
        byte by4 = this.a(c2);
        byte by5 = this.b(c2);
        byte by6 = by4;
        if (c2.c > ((c)this).c) {
            by6 = 0 - by4;
        }
        byte by7 = by5;
        if (c2.d > this.d) {
            by7 = 0 - by5;
        }
        byte by8 = 0;
        byte by9 = 0;
        if (by7 != 0) {
            byte by10 = by8 = by7 > 0 ? (byte)1 : 2;
        }
        if (by6 != 0) {
            by9 = by6 > 0 ? (byte)3 : 4;
        }
        by6 = 0;
        if (by4 < by5) {
            by7 = by8;
            by3 = by9;
        } else {
            by7 = by9;
            by3 = by8;
        }
        ab ab2 = r.a;
        if (by4 + by5 <= by2) {
            if (by2 > 1 && by4 != by5 && by4 * by5 != 0) {
                if (ab2.a(this, by3)) {
                    this.a(by3, 1);
                    return true;
                }
                if (!ab2.a(this, by7)) return false;
                this.a(by7, 1);
                return true;
            }
            this.i(by7);
            if (by4 != by5) return false;
            this.r = (byte)((by8 << 1) + by9);
            return false;
        }
        if (this.a != 0) return false;
        by8 = 0;
        by9 = ab2.a(this, this.q) ? 1 : 0;
        if ((this.q == by7 || this.q == by3) && this.q != 0 && by9 != 0) {
            by8 = 1;
            by6 = this.q;
        } else if (by3 != 0 && rpg.b.Y[this.q] != by3 && ab2.a(this, by3)) {
            by8 = 1;
            by6 = by3;
        } else if (by7 != 0 && rpg.b.Y[this.q] != by7 && ab2.a(this, by7)) {
            by8 = 1;
            by6 = by7;
        } else {
            if (this.f(by7)) {
                this.c = (short)(16 / this.t << 1);
                return true;
            }
            if (this.f(by3)) {
                this.c = (short)(16 / this.t << 1);
                return true;
            }
        }
        if (by8 != 0) {
            if (this instanceof br && ((br)this).e()) {
                this.a(by6, by6 == 3 || by6 == 4 ? by4 - (by2 - 1) : by5 - (by2 - 1));
                return by8 != 0;
            } else {
                this.a(by6, 1);
            }
            return by8 != 0;
        } else {
            this.b(true);
        }
        return by8 != 0;
    }

    protected final void h() {
        if (this.c > 0) {
            this.A();
        }
        this.k();
    }

    public final void b(int n2) {
        this.a = n2;
    }

    protected boolean d() {
        return this.p == 7 || this.p == 6;
    }

    protected void a(int n2, int n3, boolean bl2) {
        if (this.d()) {
            return;
        }
        cr cr2 = rpg.a.a;
        if (((c)this).e == 1) {
            cr2.a(rpg.c.e[bl2 ? 1 : 0], n2, n3 + 6, 33);
            return;
        }
        cr2.a(rpg.c.e[bl2 ? 1 : 0], n2 - 2, n3 + 6, 33);
        cr2.a(rpg.c.e[bl2 ? 1 : 0], n2 + 2, n3 + 6, 33);
    }
}

