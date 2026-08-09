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

    df(byte by) {
        this.b = by;
        this.a = 1;
        this.c = 1;
        this.c = 0;
        this.b = 0;
        this.b = true;
    }

    abstract void a(int var1, int var2);

    final void a(int n, int n2, boolean bl) {
        if (this.b != bl || this.a) {
            return;
        }
        this.a(n, n2);
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

    public static final boolean a(byte by) {
        switch (by) {
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
