/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import rpg.a;
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class k
extends n {
    private String b = null;
    protected int a;
    public dg a = null;
    private String c = null;

    public k(ah ah2, dg dg2) {
        super(ah2, (byte)5);
        if (n.a == null || ((n)this).b) {
            this.c();
        }
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
            this.g();
            ((ah)this).a.g();
            return true;
        }
        if (ah.f(n2, n3)) {
            switch (this.d) {
                case 0: {
                    ((ah)this).b = new ch((ah)this, 0, rpg.c.h.a(61));
                    break;
                }
                case 1: {
                    ((ah)this).b = new bx(this, rpg.c.h.a(65));
                    break;
                }
                case 2: {
                    ((ah)this).b = new q((ah)this, rpg.c.h.a(66, 67));
                    break;
                }
                case 3: {
                    ((ah)this).b = new ch((ah)this, 1, rpg.c.h.a(63));
                    break;
                }
                case 4: {
                    ((ah)this).b = this.b == null || this.b.length() == 0 ? new bi((ah)this, rpg.c.h.a(38), '\u0000') : (this.a == 0 && this.a == null && (this.c == null || this.c.trim().length() == 0) ? new bi((ah)this, rpg.c.h.a(26), '\u0000') : new bk((ah)this, rpg.c.h.a(64), 3, false, true));
                }
            }
            return true;
        }
        return this.c(n2, n3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void a(byte by2, byte by3) {
        byte[] byArray;
        block31: {
            this.g();
            if (by2 == 10) {
                switch (this.d) {
                    case 0: {
                        this.b = n.a;
                        break;
                    }
                    case 3: {
                        this.c = n.a;
                        break;
                    }
                }
                n.a = "";
            } else if (by2 == 6) {
                if (by3 == 0) {
                    ((ah)this).b = new t(this, 1);
                } else {
                    this.a = null;
                }
            }
            if (by2 != 3) return;
            if (by3 != 0) return;
            ((ah)this).b = new bi((ah)this, rpg.c.h.a(4));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            byArray = null;
            try {
                if (this.b == null) {
                    dataOutputStream.writeByte(0);
                } else {
                    byArray = this.b.getBytes();
                    dataOutputStream.writeByte(byArray.length);
                    ((OutputStream)dataOutputStream).write(byArray);
                }
                dataOutputStream.writeInt(this.a);
                if (this.a == null) {
                    dataOutputStream.writeLong(0L);
                } else {
                    dataOutputStream.writeLong(this.a.a);
                }
                if (this.c == null) {
                    dataOutputStream.writeByte(0);
                } else {
                    byArray = this.c.getBytes();
                    dataOutputStream.writeByte(byArray.length);
                    ((OutputStream)dataOutputStream).write(byArray);
                }
                byArray = byteArrayOutputStream.toByteArray();
            }
            catch (Exception exception) {
                byArray = null;
                try {
                    dataOutputStream.close();
                }
                catch (Exception exception2) {}
                try {
                    byteArrayOutputStream.close();
                }
                catch (Exception exception3) {}
                break block31;
            }
            catch (Throwable throwable) {
                try {
                    dataOutputStream.close();
                }
                catch (Exception exception) {}
                try {
                    byteArrayOutputStream.close();
                    throw throwable;
                }
                catch (Exception exception) {}
                throw throwable;
            }
            try {
                dataOutputStream.close();
            }
            catch (Exception exception) {}
            try {
                byteArrayOutputStream.close();
            }
            catch (Exception exception) {}
        }
        if (byArray == null) {
            this.g();
            return;
        }
        byArray = af.a((byte)24, byArray);
        this.a(byArray, false, false);
    }

    protected final void a(cr cr2) {
        this.a(cr2, rpg.c.h.a(2), true, false);
        int n2 = this.f + 4;
        int n3 = this.f + 22;
        int n4 = this.f + 68;
        int n5 = this.g + 18;
        ah.a(cr2, n2, n5, 14, 12, this.d == 0 ? 0x660000 : 3550755, this.d == 0 ? 0xBD0000 : 7027456);
        ah.a(cr2, n3, n5, 93, 12, this.d == 0 ? 0x660000 : 3550755, this.d == 0 ? 0xBD0000 : 7027456);
        if (this.b != null && this.b.length() != 0) {
            cr2.a(0xFFFFFF);
            dv.a(cr2, n4, n5, this.b.getBytes(), 0, 1);
        } else {
            cr2.a(this.d == 0 ? 16775602 : 12630160);
            dv.a(cr2, n4, n5, rpg.c.h.a(57), 0, 1);
        }
        dv.a(cr2, this.f + 5, n5, rpg.c.h.a(46), 0);
        ah.a(cr2, n2, n5 += 14, 14, 12, this.d == 1 ? 0x660000 : 3550755, this.d == 1 ? 0xBD0000 : 7027456);
        cr2.a(rpg.c.u, n2 + 7, n5 + 5, 3);
        ah.a(cr2, n3, n5, 93, 12, this.d == 1 ? 0x660000 : 3550755, this.d == 1 ? 0xBD0000 : 7027456);
        if (this.a > 0) {
            ah.b(cr2, this.a, n4, n5 + 2, 1, 0);
        } else {
            cr2.a(this.d == 1 ? 16775602 : 12630160);
            dv.a(cr2, n4, n5, rpg.c.h.a(58), 0, 1);
        }
        ah.a(cr2, n2, n5 += 14, 14, 14, this.d == 2 ? 0x660000 : 3550755, this.d == 2 ? 0xBD0000 : 7027456);
        ah.a(cr2, n3, n5, 93, 12, this.d == 2 ? 0x660000 : 3550755, this.d == 2 ? 0xBD0000 : 7027456);
        if (this.a != null) {
            this.a.a(cr2, n2, n5 - 1, true, true);
            cr2.a(0xFFFFFF);
            dv.a(cr2, n4, n5, this.a.c, 0, 1);
        } else {
            cr2.a(this.d == 2 ? 16775602 : 12630160);
            dv.a(cr2, n4, n5, rpg.c.h.a(59), 0, 1);
        }
        ah.a(cr2, n3, n5 += 14, 93, 41, this.d == 3 ? 0x660000 : 3550755, this.d == 3 ? 0xBD0000 : 7027456);
        if (this.c != null && this.c.length() > 0) {
            cr2.a(0xFFFFFF);
            dv.a(cr2, n3 + 2, n5 + 2, 89, 0, this.c.getBytes());
        } else {
            cr2.a(this.d == 3 ? 16775602 : 12630160);
            dv.a(cr2, n4, n5, rpg.c.h.a(60), 0, 1);
        }
        ah.a(cr2, n2, n5 += 43, 111, 12, this.d == 4 ? 0x660000 : 3550755, this.d == 4 ? 0xBD0000 : 7027456);
        cr2.a(this.d == 4 ? 16775602 : 12630160);
        dv.a(cr2, rpg.a.c, n5, rpg.c.h.a(2), 0, 1);
    }
}

