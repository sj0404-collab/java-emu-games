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

    ar(byte by, byte by2, byte by3, byte by4, boolean bl) {
        super((short)(by3 << 4), (short)(by4 << 4), (byte)8, (byte)(8 + f));
        this.f = true;
        this.h = by;
        this.i = by2;
        this.a = -1;
        this.e = false;
    }

    ar(byte by, byte by2, short s, short s2, boolean bl) {
        super(s, s2, (byte)8, (byte)(8 + (bl ? f : g)));
        this.f = bl;
        this.h = by;
        this.i = 1;
        this.a = -1;
        this.e = false;
    }

    public final void a(int n, int n2) {
        ar ar2 = this;
        ++ar2.a;
        ar2.b();
        if (this.e) {
            r.a.d(this);
            return;
        }
        this.b(n, n2);
    }
}
