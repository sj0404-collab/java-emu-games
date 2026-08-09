/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;
import rpg.f;

final class di
extends n {
    private boolean c = false;
    private static byte a = (byte)5;
    private byte[] Z = new byte[]{0, 2, 31, 29, 1, 30};

    public di(ah ah2) {
        super(ah2, a);
        this.d = 0;
        this.j();
        boolean bl = false;
        di di2 = this;
        if (di2.c) {
            di2.d = 0;
            di2.c = false;
            a = (byte)5;
            if (di2.c) {
                a = (byte)(a + 1);
            }
            ((ah)di2).e = a;
        }
        new Thread(this).start();
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
            n.f();
            ao.a().g();
            bo.e();
            return true;
        }
        if (ah.f(n2, n3)) {
            switch (this.d) {
                case 3: {
                    ((ah)this).b = new bk((ah)this, rpg.c.h.a(70), 11, false, true);
                    break;
                }
                case 4: {
                    byte[] byArray = af.a((byte)50, null);
                    this.a(byArray, true, false);
                    break;
                }
                case 0: {
                    ((ah)this).b = new dk(this);
                    break;
                }
                case 1: {
                    ((ah)this).b = new k((ah)this, null);
                    break;
                }
                case 2: {
                    ((ah)this).b = new s(this);
                    break;
                }
                case 5: {
                    ((ah)this).b = new bk((ah)this, rpg.c.h.a(86), 13, false, true);
                }
            }
            return true;
        }
        return this.c(n2, n3);
    }

    final void a(byte by, byte by2) {
        this.g();
        if (n.a && by == 3) {
            if (by2 == 0) {
                ao ao2 = ao.a();
                ao2.g();
                ao2.b = new di(ao2);
                return;
            }
            n.f();
            ao.a().g();
            return;
        }
        if (by == 13) {
            if (by2 == 0) {
                byte[] byArray = af.a((byte)61, null);
                this.a(byArray, true, false);
                return;
            }
        } else if (by == 11) {
            if (this.d == 3 && by2 == 0) {
                byte[] byArray = new byte[2 + (null).length + 2 + (null).length];
                short s2 = (short)(null).length;
                rpg.f.a(s2, byArray, 0);
                System.arraycopy(null, 0, byArray, 2, s2);
                by2 = (byte)(s2 + 2);
                s2 = (short)(null).length;
                rpg.f.a(s2, byArray, (int)by2);
                by2 = (byte)(by2 + 2);
                System.arraycopy(null, 0, byArray, by2, s2);
                byArray = af.a((byte)60, byArray);
                this.a(byArray, true, false);
                return;
            }
            if (this.d == 5 && by2 == 0) {
                byte[] byArray = af.a((byte)62, null);
                this.a(byArray, true, false);
                return;
            }
        } else if (by == 10) {
            byte[] byArray = n.a.getBytes();
            byte[] byArray2 = new byte[1 + byArray.length];
            byte[] byArray3 = byArray2;
            byArray2[0] = (byte)byArray.length;
            System.arraycopy(byArray, 0, byArray3, 1, byArray3[0]);
            byArray3 = af.a((byte)3, byArray3);
            this.a(byArray3, true, false);
        }
    }

    protected final void a(cr cr2) {
        rpg.a.a(cr2, true);
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, rpg.a.d - 58, rpg.c.b.a(9), 0, 1);
        for (byte by = 0; by < a; by = (byte)(by + 1)) {
            int n2 = this.g + 16 + by * 13;
            ah.a(cr2, this.f + 3, n2, 113, 12, this.d == by ? 0x660000 : 3550755, this.d == by ? 0xBD0000 : 7027456);
            cr2.a(this.d == by ? 0xFFFFFF : 12630160);
            dv.a(cr2, rpg.a.c, n2, rpg.c.h.a(this.Z[by]), 0, 1);
        }
    }
}
