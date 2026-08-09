/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class cd {
    private int b = 10;
    int a;
    ak[] a = 0;

    public cd(cb cb2) {
    }

    public final void a(ak ak2) {
        if (this.a >= this.b) {
            ak[] akArray = new ak[this.b + 5];
            for (int i2 = 0; i2 < this.b + 5; ++i2) {
                akArray[i2] = i2 < this.a ? this.a[i2] : null;
            }
            this.a = null;
            this.a = akArray;
            this.b += 5;
        }
        this.a[this.a++] = ak2;
    }
}

