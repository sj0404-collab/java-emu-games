/*
 * Decompiled with CFR 0.152.
 */
import java.util.Vector;
import rpg.a;
import rpg.c;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class s
extends n {
    private Vector a;
    private bg a = null;

    public s(ah ah2) {
        super(ah2, (byte)6);
        boolean bl = true;
        s s2 = this;
        byte[] byArray = af.a((byte)20, null);
        s2.a(byArray, true, false);
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3)) {
            ((ah)this).a.g();
            return true;
        }
        if (ah.f(n2, n3)) {
            if (this.d < this.a.size()) {
                bg bg2 = this.a = (bg)this.a.elementAt(this.d);
                ((ah)this).b = new q((ah)this, rpg.c.h.a(33, 35));
            }
            return true;
        }
        return this.c(n2, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    final void a(byte by, byte by2) {
        this.g();
        if (by != 6) {
            if (by != 3) return;
            if (by2 != 0) return;
            s s2 = this;
            byte[] byArray = new byte[8];
            rpg.f.a(0L, byArray, 0);
            byArray = af.a((byte)22, byArray);
            s2.a(byArray, true, false);
            return;
        }
        s s3 = this;
        bg bg2 = s3.a;
        if (by2 == 0) {
            s3.k();
            return;
        }
        if (by2 != 1) return;
        ((ah)s3).b = new bk((ah)s3, rpg.c.h.a(45), 3, true, true);
    }

    private final void k() {
        byte[] byArray = new byte[8];
        rpg.f.a(0L, byArray, 0);
        byArray = af.a((byte)21, byArray);
        this.a(byArray, true, false);
    }

    protected final void a(cr cr2) {
        rpg.a.a(cr2, true);
        cr2.a(14597755);
        dv.a(cr2, rpg.a.c, rpg.a.d - 58, rpg.c.h.a(31), 0, 1);
        int n2 = this.a.size();
        int n3 = this.d / 6 * 6;
        int n4 = this.d % 6;
        for (int n5 = 0; n5 < 6; n5 = (int)((byte)(n5 + 1))) {
            int n6 = this.g + 16 + n5 * 13;
            ah.a(cr2, this.f + 3, n6, 108, 12, n4 == n5 ? 0x660000 : 3550755, this.d == n5 ? 0xBD0000 : 7027456);
            if (n3 < n2) {
                boolean bl = n4 == n5;
                int n7 = n6;
                int n8 = this.f;
                cr cr3 = cr2;
                bg bg2 = (bg)this.a.elementAt(n3);
                bg2 = bg2;
                cr3.a(bl ? 0xFFFFFF : 12630160);
                dv.a(cr3, n8 + 24, n7, null, 0);
                dv.a(cr3, n8 + 109, n7, null, 0, 8);
            }
            ++n3;
        }
        this.a(cr2, rpg.a.c + 52, rpg.a.d - 55, this.d / 6 + 1, ((ah)this).e / 6, 8);
        this.f(cr2, rpg.a.c + 54, rpg.a.d - 37, this.d / 6, ((ah)this).e / 6);
    }
}
