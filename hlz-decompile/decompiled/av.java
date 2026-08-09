/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
abstract class av
extends aj {
    private cx a;
    private boolean[] a = null;

    av(ah ah2, byte by, byte by2, byte by3) {
        super(ah2, (byte)6, (byte)1, (byte)1);
        if (this.a == null) {
            this.a = new cx("/t/jd");
        }
        this.a = new boolean[6];
        for (byte by4 = 0; by4 < 6; by4 = (byte)(by4 + 1)) {
            this.a[by4] = r.b(by4);
        }
    }

    protected final int a(cr cr2, byte n) {
        int n2;
        if (n >= 6) {
            n2 = this.a(cr2, false, false, true, false, true);
            n = (byte)(n - 6);
        } else {
            n2 = this.a(cr2, false, false, true, false, false);
        }
        int n3 = this.g + 174 - 60;
        cr2.a(3550755);
        cr2.a(this.f, n3, 160, 60);
        int n4 = n;
        av av2 = this;
        boolean bl = av2.a[n4];
        cr2.a(0xFFFFFF);
        for (n4 = 0; n4 < 4; ++n4) {
            dv.a(cr2, rpg.a.c, n3 + 4 + n4 * 14, this.a.a(n4 + (bl ? n << 2 : 24)), 1, 1);
        }
        ah.a(cr2, this.f + 23, n3 -= 14, 114, 14, 0x660000, 0x810000);
        ah.a(cr2, this.f + 46, n3 + 5, 68, 0xFFFFFF, false);
        if (bl) {
            cr2.a(0xFFFFFF);
        } else {
            cr2.a(0x7F7F7F);
        }
        dv.a(cr2, rpg.a.c, n3, rpg.c.d.a(n + 1), 1, 1);
        return n2;
    }

    protected final boolean a(byte by) {
        return this.a[by];
    }
}
