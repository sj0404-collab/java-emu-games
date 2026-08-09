/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class ba {
    private byte[] a;
    public short[] a;
    public short a;
    public ak a = null;

    ba(cb cb2) {
    }

    public final int a(byte[] byArray, int n, int n2) {
        this.a = byArray[n++];
        if (this.a < 0) {
            this.a = (short)(256 + this.a);
        }
        this.a = new short[this.a + 1];
        int n3 = 0;
        this.a[0] = 0;
        for (short s = 0; s < this.a; s = (short)(s + 1)) {
            short s2 = (short)(byArray[n] < 0 ? 256 + byArray[n] : byArray[n]);
            if (n2 > 1) {
                s2 = (short)(s2 + ((short)(byArray[++n] < 0 ? 256 + byArray[n] : byArray[n]) << 8));
            }
            this.a[s + 1] = n3 = (int)((short)(n3 + s2));
            ++n;
        }
        this.a = null;
        if (n3 > 0) {
            this.a = new byte[n3];
            System.arraycopy(byArray, n, this.a, 0, n3);
            n += n3;
        }
        this.a = ak.a(this.a);
        return n;
    }
}
