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

    public final void a(int n, String object, byte[] byArray) {
        int n2;
        object = new dq((String)object);
        if (byArray != null) {
            int n3 = 0;
            ++n3;
            n2 = byArray[0];
            for (int n4 = 0; n4 < n2; n4 = (byte)(n4 + 1)) {
                int n5 = f.b(byArray, n3);
                int n6 = f.b(byArray, n3 += 4);
                n3 += 4;
                ((dq)object).a(n5, n6);
            }
        }
        this.a[n] = ((dq)object).a();
        byte[] byArray2 = this.a[n];
        if (byArray2 != null) {
            this.a[n + this.a] = new cw[((dq)object).a()];
            for (n2 = 0; n2 < byArray2.length; ++n2) {
                this.a[n + this.a][byArray2[n2]] = ((dq)object).b(byArray2[n2]);
            }
        }
    }

    public final void a(byte[] byArray, boolean bl) {
        int n;
        int n2;
        int n3 = byArray[0];
        int n4 = n3 + 1;
        this.a = n3;
        this.a = new cw[n3 * (bl ? 2 : 1)][];
        this.a = new byte[n3][];
        for (n2 = 0; n2 < n3; ++n2) {
            n = byArray[n4++];
            byte by = byArray[n4++];
            this.a[n2] = new byte[n];
            System.arraycopy(byArray, n4, this.a[n2], 0, n);
            n4 += by + n;
        }
        n2 = byArray[n4++];
        this.a = new int[n2];
        this.b = new byte[n2];
        n3 = n4;
        for (n = 0; n < n2; ++n) {
            this.a[n] = n4 - n3;
            this.b[n] = byArray[n4++];
            for (int i = 0; i < this.b[n]; ++i) {
                for (int j = 0; j < 4; ++j) {
                    byte by = byArray[n4++];
                    n4 += by * 4;
                }
            }
        }
        n = n4 - n3;
        this.a = new byte[n];
        System.arraycopy(byArray, n3, this.a, 0, n);
    }

    public final int a(byte n, byte by, int n2, int n3, int n4) {
        int n5;
        int n6 = this.a[n];
        ++n6;
        if (n2 >= this.b[n] || n2 < 0) {
            n2 = 0;
        }
        for (n5 = 0; n5 < n2; ++n5) {
            for (int i = 0; i < 4; ++i) {
                n = this.a[n6++];
                n6 += n << 2;
            }
        }
        for (n5 = 0; n5 < by - 1; ++n5) {
            n = this.a[n6++];
            n6 += n << 2;
        }
        n = this.a[n6++];
        cr cr2 = rpg.a.a;
        for (int i = 0; i < n; ++i) {
            n5 = this.a[n6] & 0x7F;
            cw[] cwArray = this.a[n5 += this.a[n6] >> 7 == 0 ? (byte)0 : this.a];
            n5 = this.a[n6 + 1];
            if (cwArray != null && cwArray[n5] != null) {
                cr2.a(cwArray[n5], n3 + this.a[n6 + 2], n4 + this.a[n6 + 3], 20);
            }
            n6 += 4;
        }
        return n2;
    }

    public final byte a(byte by) {
        return this.b[by];
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
