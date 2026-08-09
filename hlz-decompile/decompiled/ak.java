/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class ak {
    private byte[] a;
    private int a = 0;
    private int b = 0;

    public static ak a(ak ak2) {
        ak ak3 = ak2;
        ak2 = new ak();
        new ak().a = ak3.a;
        ak2.a = ak3.a;
        ak2.b = ak3.b;
        return ak2;
    }

    public static ak a(byte[] object) {
        byte[] byArray = object;
        object = new ak();
        new ak().a = byArray;
        byArray = object;
        byArray.a(0, byArray.a != null ? byArray.a.length : 0);
        return object;
    }

    private ak() {
    }

    public final void a(int n) {
        this.a = n;
    }

    public final void a(int n, int n2) {
        this.a = n;
        this.b = n2;
    }

    public final int a() {
        return this.a;
    }

    public final void a(byte[] byArray, int n) {
        if (this.a != null) {
            System.arraycopy(this.a, this.a, byArray, 0, n);
            this.a += n;
        }
    }

    public final byte a() {
        if (this.a != null) {
            return this.a[this.a++];
        }
        return 0;
    }

    public final short a() {
        short s;
        if (this.a == null) {
            return 0;
        }
        if ((s = (short)this.a[this.a++]) < 0) {
            s = (short)(s + 256);
        }
        return (short)(s + (this.a[this.a++] << 8));
    }

    public final int b() {
        if (this.a == null) {
            return 0;
        }
        int n = this.a[this.a++];
        int n2 = this.a[this.a++];
        if (n < 0) {
            n += 256;
        }
        if (n2 < 0) {
            n2 += 256;
        }
        return n += n2 << 8;
    }

    public final boolean a() {
        return this.a >= this.b;
    }
}
