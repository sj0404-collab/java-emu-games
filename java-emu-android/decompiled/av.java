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

    av(ah ah2, byte by2, byte by3, byte by4) {
        super(ah2, (byte)6, (byte)1, (byte)1);
        if (this.a == null) {
            this.a = new cx("/t/jd");
        }
        this.a = new boolean[6];
        for (byte by5 = 0; by5 < 6; by5 = (byte)(by5 + 1)) {
            this.a[by5] = r.b(by5);
        }
    }

    protected final int a(cr cr2, byte n2) {
        int n3;
        if (n2 >= 6) {
            n3 = this.a(cr2, false, false, true, false, true);
            n2 = (byte)(n2 - 6);
        } else {
            n3 = this.a(cr2, false, false, true, false, false);
        }
        int n4 = this.g + 174 - 60;
        cr2.a(3550755);
        cr2.a(this.f, n4, 160, 60);
        int n5 = n2;
        av av2 = this;
        boolean bl2 = av2.a[n5];
        cr2.a(0xFFFFFF);
        for (n5 = 0; n5 < 4; ++n5) {
            dv.a(cr2, rpg.a.c, n4 + 4 + n5 * 14, this.a.a(n5 + (bl2 ? n2 << 2 : 24)), 1, 1);
        }
        ah.a(cr2, this.f + 23, n4 -= 14, 114, 14, 0x660000, 0x810000);
        ah.a(cr2, this.f + 46, n4 + 5, 68, 0xFFFFFF, false);
        if (bl2) {
            cr2.a(0xFFFFFF);
        } else {
            cr2.a(0x7F7F7F);
        }
        dv.a(cr2, rpg.a.c, n4, rpg.c.d.a(n2 + 1), 1, 1);
        return n3;
    }

    protected final boolean a(byte by2) {
        return this.a[by2];
    }
}

