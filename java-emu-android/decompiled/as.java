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

    as(byte by2, short s2, short s3, at at2, byte by3, boolean bl2, db db2, int n2, byte by4, byte by5) {
        super(by2, (byte)1, s2, s3, bl2);
        this.a = db2;
        this.c = n2;
        this.k = by4;
        this.l = by5;
        this.a = at2;
        this.j = by3;
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
                for (int i2 = 0; i2 < 2; ++i2) {
                    if (doArray[i2] == null || doArray[i2].b() || doArray[i2].c != ((c)this).c || doArray[i2].d != ((c)this).d || doArray[i2].b()) continue;
                    doArray[i2].q(50);
                    doArray[i2].b(60, 30);
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
                    byte by2 = (byte)(((c)this).c + rpg.b.S[this.k]);
                    byte by3 = (byte)(((c)this).d + rpg.b.T[this.k]);
                    if (!ab.a(by2, by3) && !r.a.b((int)by2, (int)by3)) {
                        this.a((short)(by2 << 4), (short)(by3 << 4));
                        this.a();
                        boolean[] blArray = new boolean[]{false, false};
                        do[] doArray = db.a();
                        for (int i3 = 0; i3 < 2; ++i3) {
                            for (int i4 = 0; i4 < ((c)this).e; ++i4) {
                                if (doArray[i3] == null || blArray[i3] || doArray[i3].d != ((c)this).d || doArray[i3].c != ((c)this).c + i4) continue;
                                blArray[i3] = true;
                                this.a.b(doArray[i3], this.c, this.k);
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
                    for (int i5 = 0; i5 < 2; ++i5) {
                        for (int i6 = 0; i6 < ((c)this).e; ++i6) {
                            if (doArray[i5] == null || blArray[i5] || doArray[i5].d != ((c)this).d || doArray[i5].c != ((c)this).c + i6) continue;
                            blArray[i5] = true;
                            this.a.b(doArray[i5], this.c, this.k);
                        }
                    }
                    return;
                }
                if (this.b != 2 || this.l <= 1) break;
                this.l = (byte)(this.l - 1);
                byte by4 = (byte)(((c)this).c + rpg.b.S[this.k]);
                byte by5 = (byte)(((c)this).d + rpg.b.T[this.k]);
                if (!ab.a(by4, by5) && !r.a.b((int)by4, (int)by5)) {
                    new as(this.h, (short)(by4 << 4), (short)(by5 << 4), this.a, this.j, this.f, this.a, this.c, this.k, this.l);
                }
                return;
            }
            case 13: {
                if (this.b != this.l) break;
                boolean[] blArray = new boolean[]{false, false};
                do[] doArray = db.a();
                for (int i7 = 0; i7 < 2; ++i7) {
                    for (int i8 = 0; i8 < ((c)this).e; ++i8) {
                        if (doArray[i7] == null || blArray[i7] || doArray[i7].c != ((c)this).c + i8 || doArray[i7].d != ((c)this).d) continue;
                        blArray[i7] = true;
                        this.a.b(doArray[i7], this.c, this.k);
                    }
                }
                return;
            }
            case 9: {
                if (this.b != this.l) break;
                byte by6 = (byte)(((c)this).c - 1);
                byte by7 = (byte)(((c)this).c + 3);
                byte by8 = (byte)(((c)this).d - 3);
                byte by9 = (byte)(((c)this).d + 2);
                do[] doArray = db.a();
                for (int i9 = 0; i9 < 2; ++i9) {
                    if (doArray[i9] == null || doArray[i9].c < by6 || doArray[i9].c > by7 || doArray[i9].d < by8 || doArray[i9].d > by9) continue;
                    this.a.b(doArray[i9], this.c, this.k);
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
                    byte by10 = (byte)(((c)this).d + rpg.b.T[this.k]);
                    if (by10 >= 0 && by10 < ab.d) {
                        this.a(((c)this).a, (short)(by10 << 4));
                        this.a();
                        do[] doArray = db.a();
                        for (int i10 = 0; i10 < 2; ++i10) {
                            if (doArray[i10] == null || doArray[i10].c < ((c)this).c - 2 || doArray[i10].c >= ((c)this).c + 2 || doArray[i10].d != ((c)this).d) continue;
                            this.a.b(doArray[i10], this.c, this.k);
                            ((ar)this).e = true;
                            new as(0, ((c)doArray[i10]).a, ((c)doArray[i10]).b, this.a, 10, true, null, 0, 0, 0);
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

    final void b(int n2, int n3) {
        switch (this.h) {
            case 2: {
                n3 = n3 + ((c)this).b + ((c)this).b;
                while (n3 <= rpg.a.b) {
                    this.a.a(this.j, (byte)1, ((ar)this).a, n2 + ((c)this).a + ((c)this).a, n3 += 16);
                }
                break;
            }
            case 8: {
                n3 = n3 + ((c)this).b + ((c)this).b - 8;
                while (n3 > 0) {
                    this.a.a(this.j, (byte)1, ((ar)this).a, n2 + ((c)this).a + ((c)this).a, n3 -= 16);
                }
                break;
            }
            default: {
                this.a.a(this.j, this.i, ((ar)this).a % ((ar)this).c, n2 + ((c)this).a + ((c)this).a + (((c)this).e - 1 << 3), n3 + ((c)this).b + ((c)this).b);
            }
        }
    }
}

