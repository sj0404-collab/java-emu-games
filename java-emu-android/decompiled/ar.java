/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
abstract class ar
extends c {
    protected static byte f = (byte)2;
    protected static byte g = (byte)-5;
    public byte h;
    protected short c;
    protected int a;
    protected byte i;
    public boolean e;
    public boolean f;

    abstract void b(int var1, int var2);

    abstract void b();

    ar(byte by2, byte by3, byte by4, byte by5, boolean bl2) {
        super((short)(by4 << 4), (short)(by5 << 4), (byte)8, (byte)(8 + f));
        this.f = true;
        this.h = by2;
        this.i = by3;
        this.a = -1;
        this.e = false;
    }

    ar(byte by2, byte by3, short s2, short s3, boolean bl2) {
        super(s2, s3, (byte)8, (byte)(8 + (bl2 ? f : g)));
        this.f = bl2;
        this.h = by2;
        this.i = 1;
        this.a = -1;
        this.e = false;
    }

    public final void a(int n2, int n3) {
        ar ar2 = this;
        ++ar2.a;
        ar2.b();
        if (this.e) {
            r.a.d(this);
            return;
        }
        this.b(n2, n3);
    }
}

