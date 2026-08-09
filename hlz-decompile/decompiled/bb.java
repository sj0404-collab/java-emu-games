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
        int n = dq2.a();
        cw[] cwArray = new cw[n];
        byte[] byArray = this.a[0];
        n = byArray.length;
        for (int i = 0; i < n; ++i) {
            cwArray[byArray[i]] = dq2.b(byArray[i]);
        }
        this.b[1] = cwArray;
    }

    public final void a(boolean bl) {
        int n = 2;
        if (bl) {
            if (this.a[0] != this.b[0]) {
                this.b[2] = this.a[0];
                this.b[3] = this.a[0 + this.a];
            }
            n = 0;
        }
        this.a[0] = this.b[n];
        this.a[0 + this.a] = this.b[n + 1];
    }

    public final void a(int n) {
        if (n >= this.a) {
            return;
        }
        if (this.a[n] != null) {
            this.a[n] = null;
        }
        if (this.a[n + this.a] != null) {
            this.a[n + this.a] = null;
        }
    }
}
