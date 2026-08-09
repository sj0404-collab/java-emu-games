/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class az
extends i {
    private int a;
    private int b;
    private final int[] a;
    private byte[][] a = new byte[][]{"[A]".getBytes(), "[a]".getBytes(), "[1]".getBytes()};

    public az(int n2) {
        super("");
        this.a = n2;
        this.b = 0;
    }

    public final String a() {
        return super.a();
    }

    public final boolean a(int n2, int n3) {
        if (n2 == -6) {
            az az2 = this;
            this.b = (az2.b + 1) % az2.a.length;
        }
        return true;
    }

    public final byte[] a() {
        return this.a[this.b];
    }
}

