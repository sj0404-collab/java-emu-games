/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;
import rpg.c;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class at
implements b {
    private byte[] a;
    private int[] a;
    private byte[] b;
    protected byte a;
    public byte[][] a;
    protected cw[][] a;

    public final void a(int n2, String object, byte[] byArray) {
        int n3;
        object = new dq((String)object);
        if (byArray != null) {
            int n4 = 0;
            ++n4;
            n3 = byArray[0];
            for (int n5 = 0; n5 < n3; n5 = (byte)(n5 + 1)) {
                int n6 = f.b(byArray, n4);
                int n7 = f.b(byArray, n4 += 4);
                n4 += 4;
                ((dq)object).a(n6, n7);
            }
        }
        this.a[n2] = ((dq)object).a();
        byte[] byArray2 = this.a[n2];
        if (byArray2 != null) {
            this.a[n2 + this.a] = new cw[((dq)object).a()];
            for (n3 = 0; n3 < byArray2.length; ++n3) {
                this.a[n2 + this.a][byArray2[n3]] = ((dq)object).b(byArray2[n3]);
            }
        }
    }

    public final void a(byte[] byArray, boolean bl2) {
        int n2;
        int n3;
        int n4 = byArray[0];
        int n5 = n4 + 1;
        this.a = n4;
        this.a = new cw[n4 * (bl2 ? 2 : 1)][];
        this.a = new byte[n4][];
        for (n3 = 0; n3 < n4; ++n3) {
            n2 = byArray[n5++];
            byte by2 = byArray[n5++];
            this.a[n3] = new byte[n2];
            System.arraycopy(byArray, n5, this.a[n3], 0, n2);
            n5 += by2 + n2;
        }
        n3 = byArray[n5++];
        this.a = new int[n3];
        this.b = new byte[n3];
        n4 = n5;
        for (n2 = 0; n2 < n3; ++n2) {
            this.a[n2] = n5 - n4;
            this.b[n2] = byArray[n5++];
            for (int i2 = 0; i2 < this.b[n2]; ++i2) {
                for (int i3 = 0; i3 < 4; ++i3) {
                    byte by3 = byArray[n5++];
                    n5 += by3 * 4;
                }
            }
        }
        n2 = n5 - n4;
        this.a = new byte[n2];
        System.arraycopy(byArray, n4, this.a, 0, n2);
    }

    public final int a(byte n2, byte by2, int n3, int n4, int n5) {
        int n6;
        int n7 = this.a[n2];
        ++n7;
        if (n3 >= this.b[n2] || n3 < 0) {
            n3 = 0;
        }
        for (n6 = 0; n6 < n3; ++n6) {
            for (int i2 = 0; i2 < 4; ++i2) {
                n2 = this.a[n7++];
                n7 += n2 << 2;
            }
        }
        for (n6 = 0; n6 < by2 - 1; ++n6) {
            n2 = this.a[n7++];
            n7 += n2 << 2;
        }
        n2 = this.a[n7++];
        cr cr2 = rpg.a.a;
        for (int i3 = 0; i3 < n2; ++i3) {
            n6 = this.a[n7] & 0x7F;
            cw[] cwArray = this.a[n6 += this.a[n7] >> 7 == 0 ? (byte)0 : this.a];
            n6 = this.a[n7 + 1];
            if (cwArray != null && cwArray[n6] != null) {
                cr2.a(cwArray[n6], n4 + this.a[n7 + 2], n5 + this.a[n7 + 3], 20);
            }
            n7 += 4;
        }
        return n3;
    }

    public final byte a(byte by2) {
        return this.b[by2];
    }

    public final void a(String object, String string) {
        object = c.a((String)object);
        this.a((byte[])object, false);
        object = new dq(string);
        this.a[0] = ((dq)object).a();
    }

    public static at a(String object, String string) {
        object = c.a((String)object);
        at at2 = new at();
        at2.a((byte[])object, true);
        at2.a(0, string, null);
        return at2;
    }
}

