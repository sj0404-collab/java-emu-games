/*
 * Decompiled with CFR 0.152.
 */
public final class d
extends dg {
    public byte[] a = new byte[]{-1, -1};
    public byte[] b = new byte[]{-1, -1, -1, -1, -1, -1};

    public d(byte by, byte by2) {
        super(by, by2);
    }

    protected final int a(byte[] byArray, int n) {
        n = super.a(byArray, n);
        System.arraycopy(byArray, n, this.b, 0, 6);
        System.arraycopy(byArray, n += 6, this.a, 0, 2);
        return n += 2;
    }
}
