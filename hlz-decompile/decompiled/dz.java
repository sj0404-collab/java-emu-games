/*
 * Decompiled with CFR 0.152.
 */
final class dz
extends db {
    private boolean f = false;

    protected dz(short s, short s2, short s3, byte by2) {
        super(s, s2, s3, by2, b.a[by2].a, false);
        if (this.e == by.d) {
            ++by.b;
        }
    }

    protected final void e() {
        boolean bl = false;
        boolean bl2 = false;
        for (byte by2 = 1; by2 <= 8; by2 = (byte)(by2 + 1)) {
            c c2 = this.a(by2, null);
            if (c2 == null) continue;
            if (c2 instanceof x && !bl) {
                bl = true;
                this.b((do)c2, (int)this.h, by2);
            }
            if (!(c2 instanceof an) || bl2) continue;
            bl2 = true;
            this.b((do)c2, (int)this.h, by2);
        }
    }

    protected final void j() {
        this.f = true;
        this.a(null, this.e);
        this.e();
    }

    protected final void a(byte by2) {
        if (by2 == 6) {
            if (this.e == by.d) {
                --by.b;
            }
            by2 = (byte)7;
        }
        super.a(by2);
    }

    protected final void w() {
        if (!this.f) {
            super.w();
        }
    }

    protected final void f() {
        this.f = false;
        super.f();
    }

    protected final void p() {
        if (!this.f) {
            super.p();
        }
    }
}
