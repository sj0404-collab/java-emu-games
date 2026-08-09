/*
 * Decompiled with CFR 0.152.
 */
import rpg.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
abstract class df
implements b {
    public byte b;
    protected int a;
    protected int b;
    protected int c;
    protected byte c;
    protected boolean a;
    protected boolean b;

    df(byte by2) {
        this.b = by2;
        this.a = 1;
        this.c = 1;
        this.c = 0;
        this.b = 0;
        this.b = true;
    }

    abstract void a(int var1, int var2);

    final void a(int n2, int n3, boolean bl2) {
        if (this.b != bl2 || this.a) {
            return;
        }
        this.a(n2, n3);
        if (r.d != 5) {
            this.a();
        }
    }

    void a() {
        ++this.b;
        if (this.c != -1 && this.b >= this.a * this.c) {
            this.a = true;
        }
    }

    public static final boolean a(byte by2) {
        switch (by2) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return true;
            }
        }
        return false;
    }
}

