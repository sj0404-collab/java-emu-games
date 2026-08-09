/*
 * Decompiled with CFR 0.152.
 */
final class du
extends ck {
    public du(short s, short s2, short s3, byte by) {
        super((short)1, (short)1, s3, by);
    }

    protected final void c(int n, int n2) {
    }

    protected final boolean a(int n) {
        if (this.u == 3) {
            switch (n) {
                case 9: {
                    ab.a(1);
                    break;
                }
                case 10: {
                    r.a.c(5, 2);
                    new as(0, 180, 170, ((db)this).a, 11, false, null, 0, 0, 0);
                }
            }
            return n == 10;
        }
        return false;
    }

    protected final void e() {
        do[] doArray = db.a();
        for (int i = 0; i < 2; ++i) {
            if (doArray[i] == null || doArray[i].d > ((c)this).d + 10) continue;
            this.b(doArray[i], (int)this.a(), (byte)2);
            if (!doArray[i].c()) continue;
            doArray[i].j((byte)3);
        }
    }

    protected final void c() {
        switch (this.p) {
            case 3: {
                this.i = (byte)4;
                break;
            }
            case 6: {
                this.i = 1;
                break;
            }
            default: {
                this.i = 0;
            }
        }
        this.c = ((db)this).a.a(this.i);
    }
}
