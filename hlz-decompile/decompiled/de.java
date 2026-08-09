/*
 * Decompiled with CFR 0.152.
 */
public final class de
extends dg {
    public byte a = (byte)-1;

    public de(byte by, byte by2) {
        super(by, by2);
    }

    protected final int a(byte[] byArray, int n) {
        n = super.a(byArray, n);
        this.a = byArray[n++];
        return n;
    }
}
