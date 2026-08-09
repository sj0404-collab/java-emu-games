/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class as
extends ar
implements g {
    private at a;
    private int b;
    private byte j;
    private db a = null;
    private int c;
    private byte k;
    private byte l;
    private int d;
    private int e;

    as(byte by, short s, short s2, at at2, byte by2, boolean bl, db db2, int n, byte by3, byte by4) {
        super(by, (byte)1, s, s2, bl);
        this.a = db2;
        this.c = n;
        this.k = by3;
        this.l = by4;
        this.a = at2;
        this.j = by2;
        this.b = 0;
        ((ar)this).c = this.a.a(this.j);
        r.a.a(this);
        switch (this.h) {
            case 4: {
                this.l = (byte)6;
                this.d = (100 - ((c)this).a) / this.l;
                this.e = (150 - ((c)this).b) / this.l;
                return;
            }
            case 5: {
                this.l = (byte)6;
                this.d = (160 - ((c)this).a) / this.l;
                this.e = (150 - ((c)this).b) / this.l;
                return;
            }
            case 6: {
                this.l = (byte)3;
                this.d = (230 - ((c)this).a) / this.l;
                this.e = (150 - ((c)this).b) / this.l;
            }
        }
    }

    final void b() {
        if (((ar)this).a > ((ar)this).c) {
            ((ar)this).a = -1;
        }
        if (this.b++ >= ((ar)this).c) {
            ((ar)this).e = true;
        }
        block0 : switch (this.h) {
            case 1: {
                do[] doArray = db.a();
                for (int i = 0; i < 2; ++i) {
                    if (doArray[i] == null || doArray[i].b() || doArray[i].c != ((c)this).c || doArray[i].d != ((c)this).d || doArray[i].b()) continue;
                    doArray[i].q(50);
                    doArray[i].b(60, 30);
                }
                if (!((ar)this).e) break;
                this.b = 0;
                ((ar)this).a = -1;
                switch (this.j) {
                    case 16: {
                        ((ar)this).e = false;
                        this.j = (byte)((do.a.nextInt() & 1) == 0 ? 17 : 18);
                        ((ar)this).c = (byte)(Math.abs(do.a.nextInt() & 0xFF) % 8 + 35);
                        return;
                    }
                    case 19: {
                        ((ar)this).e = true;
                        return;
                    }
                }
                ((ar)this).e = false;
                this.j = (byte)19;
                ((ar)this).c = this.a.a(this.j);
                return;
            }
            case 3: {
                if (this.l > 0) {
                    this.l = (byte)(this.l - 1);
                    ((ar)this).e = false;
                    byte by = (byte)(((c)this).c + rpg.b.S[this.k]);
                    byte by2 = (byte)(((c)this).d + rpg.b.T[this.k]);
                    if (!ab.a(by, by2) && !r.a.b((int)by, (int)by2)) {
                        this.a((short)(by << 4), (short)(by2 << 4));
                        this.a();
                        boolean[] blArray = new boolean[]{false, false};
                        do[] doArray = db.a();
                        for (int i = 0; i < 2; ++i) {
                            for (int j = 0; j < ((c)this).e; ++j) {
                                if (doArray[i] == null || blArray[i] || doArray[i].d != ((c)this).d || doArray[i].c != ((c)this).c + j) continue;
                                blArray[i] = true;
                                this.a.b(doArray[i], this.c, this.k);
                                ((ar)this).e = true;
                            }
                        }
                        break;
                    }
                    ((ar)this).e = true;
                    return;
                }
                ((ar)this).e = true;
                return;
            }
            case 14: {
                if (this.b == 1) {
                    boolean[] blArray = new boolean[]{false, false};
                    do[] doArray = db.a();
                    for (int i = 0; i < 2; ++i) {
                        for (int j = 0; j < ((c)this).e; ++j) {
                            if (doArray[i] == null || blArray[i] || doArray[i].d != ((c)this).d || doArray[i].c != ((c)this).c + j) continue;
                            blArray[i] = true;
                            this.a.b(doArray[i], this.c, this.k);
                        }
                    }
                    return;
                }
                if (this.b != 2 || this.l <= 1) break;
                this.l = (byte)(this.l - 1);
                byte by = (byte)(((c)this).c + rpg.b.S[this.k]);
                byte by3 = (byte)(((c)this).d + rpg.b.T[this.k]);
                if (!ab.a(by, by3) && !r.a.b((int)by, (int)by3)) {
                    new as(this.h, (short)(by << 4), (short)(by3 << 4), this.a, this.j, this.f, this.a, this.c, this.k, this.l);
                }
                return;
            }
            case 13: {
                if (this.b != this.l) break;
                boolean[] blArray = new boolean[]{false, false};
                do[] doArray = db.a();
                for (int i = 0; i < 2; ++i) {
                    for (int j = 0; j < ((c)this).e; ++j) {
                        if (doArray[i] == null || blArray[i] || doArray[i].c != ((c)this).c + j || doArray[i].d != ((c)this).d) continue;
                        blArray[i] = true;
                        this.a.b(doArray[i], this.c, this.k);
                    }
                }
                return;
            }
            case 9: {
                if (this.b != this.l) break;
                byte by = (byte)(((c)this).c - 1);
                byte by4 = (byte)(((c)this).c + 3);
                byte by5 = (byte)(((c)this).d - 3);
                byte by6 = (byte)(((c)this).d + 2);
                do[] doArray = db.a();
                for (int i = 0; i < 2; ++i) {
                    if (doArray[i] == null || doArray[i].c < by || doArray[i].c > by4 || doArray[i].d < by5 || doArray[i].d > by6) continue;
                    this.a.b(doArray[i], this.c, this.k);
                    break block0;
                }
                return;
            }
            case 4: 
            case 5: 
            case 6: {
                if (this.l > 0) {
                    ((ar)this).e = false;
                    this.l = (byte)(this.l - 1);
                    ((c)this).a = (short)(((c)this).a + this.d);
                    ((c)this).b = (short)(((c)this).b + this.e);
                    this.a(((c)this).a, ((c)this).b);
                    this.a();
                    return;
                }
                ((ar)this).e = true;
                new as(7, ((c)this).a, (short)(((c)this).b + 16), this.a, 8, true, this.a, this.c, 1, 10);
                new as(7, ((c)this).a, ((c)this).b, this.a, 9, true, this.a, this.c, 2, 10);
                return;
            }
            case 7: {
                if (this.l > 0) {
                    this.l = (byte)(this.l - 1);
                    ((ar)this).e = false;
                    byte by = (byte)(((c)this).d + rpg.b.T[this.k]);
                    if (by >= 0 && by < ab.d) {
                        this.a(((c)this).a, (short)(by << 4));
                        this.a();
                        do[] doArray = db.a();
                        for (int i = 0; i < 2; ++i) {
                            if (doArray[i] == null || doArray[i].c < ((c)this).c - 2 || doArray[i].c >= ((c)this).c + 2 || doArray[i].d != ((c)this).d) continue;
                            this.a.b(doArray[i], this.c, this.k);
                            ((ar)this).e = true;
                            new as(0, ((c)doArray[i]).a, ((c)doArray[i]).b, this.a, 10, true, null, 0, 0, 0);
                        }
                        break;
                    }
                    ((ar)this).e = true;
                    return;
                }
                ((ar)this).e = true;
            }
        }
    }

    final void b(int n, int n2) {
        switch (this.h) {
            case 2: {
                n2 = n2 + ((c)this).b + ((c)this).b;
                while (n2 <= rpg.a.b) {
                    this.a.a(this.j, (byte)1, ((ar)this).a, n + ((c)this).a + ((c)this).a, n2 += 16);
                }
                break;
            }
            case 8: {
                n2 = n2 + ((c)this).b + ((c)this).b - 8;
                while (n2 > 0) {
                    this.a.a(this.j, (byte)1, ((ar)this).a, n + ((c)this).a + ((c)this).a, n2 -= 16);
                }
                break;
            }
            default: {
                this.a.a(this.j, this.i, ((ar)this).a % ((ar)this).c, n + ((c)this).a + ((c)this).a + (((c)this).e - 1 << 3), n2 + ((c)this).b + ((c)this).b);
            }
        }
    }
}
