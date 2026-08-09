/*
 * Decompiled with CFR 0.152.
 */
final class f
extends c {
    private byte f;
    private int a = -1;

    f(byte by2, short s2, short s3) {
        super(s2, s3, (byte)0, (byte)0);
        this.f = by2;
        this.a = r.a.a(s2 - 8 >> 4, s3 - 16 >> 4);
        if (this.a != -1 && this.a < 0) {
            this.a += 256;
        }
    }

    public final void a(int n2, int n3) {
        if (ab.b || !this.c) {
            return;
        }
        if ((n3 = n3 + this.b + this.b) + 16 < 0) {
            return;
        }
        n2 = n2 + ((c)this).a + ((c)this).a;
        f f2 = this;
        boolean bl2 = f2.a >= 19 && f2.a <= 21 || f2.a == 9 ? r.a((byte)19).a((byte)19, (byte)f2.a) > 0 : f2.a > 0 && r.a(f2.a);
        if (bl2) {
            ab.a(n2, n3);
            return;
        }
        r.a.a(this.f, n2, n3);
    }
}

