/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class b
implements g {
    public static b[] a = null;
    at a;
    byte[] a;
    private byte k;
    byte a;
    private byte l;
    private byte[] e;
    private byte[] f;
    byte b;
    byte c;
    short a;
    short b;
    short c;
    byte d;
    short d;
    short e;
    short f;
    boolean a = null;
    boolean b;
    boolean c;
    byte e = new byte[4];
    public byte f = new byte[6];
    byte[] b;
    byte g;
    byte h;
    byte i;
    byte j;
    boolean d;

    public static final void a(int n2) {
        a = new b[n2];
    }

    public static final void a(byte by2, short s2, byte[] byArray, byte[] byArray2, byte[] byArray3) {
        byte[] byArray4 = rpg.c.a(byArray, (int)s2);
        if (!rpg.c.a(byArray4)) {
            b.a[by2] = null;
            return;
        }
        b b2 = new b();
        int n2 = byArray4[0];
        b2.a = new byte[n2];
        System.arraycopy(byArray4, 1, b2.a, 0, n2);
        int n3 = ++n2;
        b2.k = byArray4[n3];
        int n4 = ++n2;
        b2.a = byArray4[n4];
        int n5 = ++n2;
        b2.l = byArray4[n5];
        System.arraycopy(byArray4, ++n2, b2.e, 0, 4);
        System.arraycopy(byArray4, n2 += 4, b2.f, 0, 6);
        n2 += 6;
        if (b2.f[0] == 0 && b2.f[1] == 0 && b2.f[2] == 0 && b2.f[3] == 0 && b2.f[4] == 0 && b2.f[5] == 0) {
            b2.f = null;
        }
        b2.b = byArray4[n2++];
        b2.c = byArray4[n2++];
        b2.a = rpg.f.b(byArray4, n2);
        b2.b = rpg.f.b(byArray4, n2 += 2);
        b2.c = rpg.f.b(byArray4, n2 += 2);
        n2 += 2;
        b2.d = byArray4[n2++];
        b2.d = rpg.f.b(byArray4, n2);
        b2.e = rpg.f.b(byArray4, n2 += 2);
        b2.f = rpg.f.b(byArray4, n2 += 2);
        n2 += 2;
        b2.a = byArray4[n2++] == 1;
        b2.b = byArray4[n2++] == 1;
        b2.c = byArray4[n2++] == 1;
        b2.e = byArray4[n2++];
        b2.b = new byte[24];
        System.arraycopy(byArray4, n2, b2.b, 0, 24);
        n2 += 24;
        b2.g = byArray4[n2++];
        b2.h = byArray4[n2++];
        b2.i = byArray4[n2++];
        b2.j = byArray4[n2++];
        if (b2.a == 5) {
            b2.j = 0;
        }
        b2.d = byArray4[n2] == 0;
        b.a[by2] = b2;
        b b3 = b2;
        if (b3.l >= 0) {
            b3.a = new at();
            byArray4 = rpg.c.a((b3.k == 0 ? "/en/cif/h" : "/en/cif/a") + (b3.l < 10 ? "0" : "") + b3.l);
            b3.a.a(byArray4, true);
        }
        if (b2.a != null) {
            b2.a(byArray2, byArray3);
            b2.a.a = null;
        }
        b2.f = null;
        b2.e = null;
    }

    private void a(byte[] byArray, byte[] object) {
        if (this.f == null) {
            return;
        }
        byArray = this.k == 0 ? byArray : object;
        for (int i2 = 0; i2 < 6; ++i2) {
            if (this.f[i2] == 0) continue;
            object = "/en/";
            if (this.k == 0) {
                object = (String)object + i2 + "/";
            }
            object = (String)object + (this.f[i2] < 10 ? "0" : "") + this.f[i2];
            byte[] byArray2 = null;
            if (i2 < this.e.length && this.e[i2] > 0) {
                byArray2 = rpg.c.a(byArray, this.e[i2] - 1);
            }
            this.a.a(i2, (String)object, byArray2);
        }
    }

    public static final void a() {
        a = null;
        dl.a = null;
        dl.a = null;
        ds.a = null;
        cg.a = null;
    }
}

