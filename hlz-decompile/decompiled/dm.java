/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;
import rpg.c;
import rpg.d;
import rpg.f;
import rpg.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class dm
extends ae {
    private byte a;
    private byte[] a = 0;

    public dm(ah ah2, byte by) {
        super(ah2, (byte)3);
        this.a = by;
        block0 : switch (this.a) {
            case 0: {
                this.a = rpg.c.i.a(0);
                return;
            }
            case 1: {
                this.a = rpg.c.b.a(6);
                if (r.j > 0) {
                    this.d = r.j;
                }
                if (r.a[this.d] != null) break;
                this.d = 0;
                for (int n = 0; n < 3; n = (int)((byte)(n + 1))) {
                    if (r.a[n] == null) continue;
                    this.d = (byte)n;
                    break block0;
                }
                return;
            }
            case 3: {
                if (r.i) {
                    this.b = new bi((ah)this, rpg.b.H, '\u0000');
                    r.i = false;
                    rpg.d.a();
                }
                this.a = rpg.c.h.a(12);
            }
        }
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
            ((ah)this).a.d = this.a;
            ((ah)this).a.g();
            return true;
        }
        if (ah.f(n2, n3)) {
            if (this.a == 1) {
                if (r.a[this.d] == null) {
                    this.b = new bi((ah)this, rpg.c.i.a(5), '\u0000');
                } else {
                    r.j = this.d;
                    byte[] byArray = r.a[r.j];
                    r.b = byArray[13];
                    r.h = byArray[16];
                    r.k = byArray[17];
                    r.a(1);
                }
            } else if (this.a == 0) {
                if (r.a[this.d] != null) {
                    this.b = new bk((ah)this, rpg.c.i.a(8), 3, false, true);
                    this.b.d = 1;
                } else {
                    this.b();
                }
            } else if (this.a == 3 && r.a[this.d] != null) {
                r.j = this.d;
                r.f();
                r.h();
                r.a(false);
                this.b = new dk(this);
            }
            return true;
        }
        return this.c(n2, n3);
    }

    final void a(byte by, byte by2) {
        this.g();
        if (by == 3 && by2 == 0) {
            if (this.a == 0) {
                r.e = 0;
                this.b();
                return;
            }
            if (this.a == 3) {
                this.g();
                this.b = new bi((ah)this, rpg.c.h.a(14));
                r.f();
                r.a(true);
                bo.d();
                ((ah)this).a.g();
                ((ah)this).a.b = new di(((ah)this).a);
            }
        }
    }

    private void b() {
        r.j = this.d;
        this.b = new ca(this);
    }

    protected final void a(cr cr2) {
        int n2;
        byte by;
        rpg.a.a(cr2, true);
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, rpg.g.b, this.a, 0, 1);
        for (by = 0; by < 3; by = (byte)(by + 1)) {
            int n3;
            cr cr3;
            n2 = this.g + 16 + by * 15;
            ah.a(cr2, rpg.a.a - 160 >> 1, n2, 160, 14, this.d == by ? 0x660000 : 3550755, this.d == by ? 0xBD0000 : 7027456);
            if (by == this.d) {
                cr3 = cr2;
                n3 = 0xFFFFFF;
            } else {
                cr3 = cr2;
                n3 = r.a[by] == null ? 0x7F7F7F : 12630160;
            }
            cr3.a(n3);
            dv.a(cr2, rpg.a.c, n2 - 1, rpg.f.a(rpg.c.b.a(27), (" " + (by + 1)).getBytes()), 0, 1);
        }
        n2 = rpg.a.a - 160 >> 1;
        by = this.g + 68;
        ah.a(cr2, n2, by, 160, 70, 3550755, 7027456);
        this.b(cr2, n2, by);
        if (this.b == null) {
            ah.a(cr2, 3);
        }
    }

    private void b(cr cr2, int n2, int n3) {
        byte[] byArray = r.a[this.d];
        if (byArray == null) {
            cr2.a(12630160);
            dv.a(cr2, n2 + 4, n3 + 4, rpg.c.b.a(28), 0);
            return;
        }
        int n4 = r.b = byArray[13];
        int n5 = n3 + 3;
        cr2.a(ah.c[n4]);
        ah.d(cr2, n2 += 3, n5, 22, 14);
        cr2.a(rpg.c.d[r.b], n2 + 6, n5 + 1, 20);
        cr2.a(0xFFFFFF);
        dv.a(cr2, n2 + 26, n5 + 1, rpg.c.d.a(n4 + 1), 0);
        n4 = byArray[14];
        cr2.a(14597755);
        dv.a(cr2, n2 + 60 + 25, n5 + 1, rpg.c.d.a(10), 0);
        ah.b(cr2, n4, n2 + 87 + 25, n5 + 5, 4, 0);
        n4 = byArray[15];
        ah.f(cr2, n4, n2 + 100 + 25, n5 + 5);
        long l = r.c = rpg.f.a(byArray, 18);
        n4 = (int)(r.c % 60L);
        int n6 = (int)((l /= 60L) % 60L);
        int n7 = (int)(l / 60L);
        n5 = n3 + 30 + 5;
        cr2.a(0xFFFFFF);
        dv.a(cr2, n2 + 4, n5, rpg.c.i.a(6), 0);
        dv.a(cr2, n2 + 64 + 25, n5, ("" + n7 + ":" + n6 + ":" + n4).getBytes(), 0);
        n2 = byArray[26];
        byte[] byArray2 = new byte[n2];
        System.arraycopy(byArray, 27, byArray2, 0, byArray2.length);
        n5 = n3 + 15 + 5;
        dv.a(cr2, rpg.a.c, n5, byArray2, 0, 1);
        int n8 = r.h = byArray[16];
        n4 = rpg.c.d.a();
        n6 = rpg.a.a - (n4 * ++n8 + (n8 - 1 << 1)) >> 1;
        n5 = n3 + 45 + 3;
        for (n3 = 0; n3 < n8; ++n3) {
            cr2.a(rpg.c.d, n6 + (n4 + 2) * n3, n5, 20);
        }
        r.k = byArray[17];
    }
}
