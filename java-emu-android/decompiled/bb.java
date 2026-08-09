/*
 * Decompiled with CFR 0.152.
 */
public final class bb
extends at {
    private cw[][] b;

    public final void a() {
        this.b = new cw[4][];
        dq dq2 = new dq("/hero/0/t");
        this.b[0] = dq2.a();
        int n2 = dq2.a();
        cw[] cwArray = new cw[n2];
        byte[] byArray = this.a[0];
        n2 = byArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            cwArray[byArray[i2]] = dq2.b(byArray[i2]);
        }
        this.b[1] = cwArray;
    }

    public final void a(boolean bl2) {
        int n2 = 2;
        if (bl2) {
            if (this.a[0] != this.b[0]) {
                this.b[2] = this.a[0];
                this.b[3] = this.a[0 + this.a];
            }
            n2 = 0;
        }
        this.a[0] = this.b[n2];
        this.a[0 + this.a] = this.b[n2 + 1];
    }

    public final void a(int n2) {
        if (n2 >= this.a) {
            return;
        }
        if (this.a[n2] != null) {
            this.a[n2] = null;
        }
        if (this.a[n2 + this.a] != null) {
            this.a[n2 + this.a] = null;
        }
    }
}

