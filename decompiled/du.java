/*
 * Decompiled with CFR 0.152.
 */
final class du
extends ck {
    public du(short s2, short s3, short s4, byte by2) {
        super((short)1, (short)1, s4, by2);
    }

    protected final void c(int n2, int n3) {
    }

    protected final boolean a(int n2) {
        if (this.u == 3) {
            switch (n2) {
                case 9: {
                    ab.a(1);
                    break;
                }
                case 10: {
                    r.a.c(5, 2);
                    new as(0, 180, 170, ((db)this).a, 11, false, null, 0, 0, 0);
                }
            }
            return n2 == 10;
        }
        return false;
    }

    protected final void e() {
        do[] doArray = db.a();
        for (int i2 = 0; i2 < 2; ++i2) {
            if (doArray[i2] == null || doArray[i2].d > ((c)this).d + 10) continue;
            this.b(doArray[i2], (int)this.a(), (byte)2);
            if (!doArray[i2].c()) continue;
            doArray[i2].j((byte)3);
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

