/*
 * Decompiled with CFR 0.152.
 */
final class f
extends c {
    private byte f;
    private int a = -1;

    f(byte by, short s, short s2) {
        super(s, s2, (byte)0, (byte)0);
        this.f = by;
        this.a = r.a.a(s - 8 >> 4, s2 - 16 >> 4);
        if (this.a != -1 && this.a < 0) {
            this.a += 256;
        }
    }

    public final void a(int n, int n2) {
        if (ab.b || !this.c) {
            return;
        }
        if ((n2 = n2 + this.b + this.b) + 16 < 0) {
            return;
        }
        n = n + ((c)this).a + ((c)this).a;
        f f2 = this;
        boolean bl = f2.a >= 19 && f2.a <= 21 || f2.a == 9 ? r.a((byte)19).a((byte)19, (byte)f2.a) > 0 : f2.a > 0 && r.a(f2.a);
        if (bl) {
            ab.a(n, n2);
            return;
        }
        r.a.a(this.f, n, n2);
    }
}
