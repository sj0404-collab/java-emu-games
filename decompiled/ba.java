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

    public final int a(byte[] byArray, int n2, int n3) {
        this.a = byArray[n2++];
        if (this.a < 0) {
            this.a = (short)(256 + this.a);
        }
        this.a = new short[this.a + 1];
        int n4 = 0;
        this.a[0] = 0;
        for (short s2 = 0; s2 < this.a; s2 = (short)(s2 + 1)) {
            short s3 = (short)(byArray[n2] < 0 ? 256 + byArray[n2] : byArray[n2]);
            if (n3 > 1) {
                s3 = (short)(s3 + ((short)(byArray[++n2] < 0 ? 256 + byArray[n2] : byArray[n2]) << 8));
            }
            this.a[s2 + 1] = n4 = (int)((short)(n4 + s3));
            ++n2;
        }
        this.a = null;
        if (n4 > 0) {
            this.a = new byte[n4];
            System.arraycopy(byArray, n2, this.a, 0, n4);
            n2 += n4;
        }
        this.a = ak.a(this.a);
        return n2;
    }
}

