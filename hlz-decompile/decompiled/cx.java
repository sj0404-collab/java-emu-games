/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class cx {
    private Object[] a;
    private short a;

    public cx(String object) {
        object = c.a(((String)object).concat(".tdf"));
        int n = 0;
        ++n;
        this.a = (short)(object[0] & 0xFF);
        this.a = new Object[this.a];
        for (int i = 0; i < this.a; ++i) {
            int n2 = (object[n++] & 0xFF) << 8;
            this.a[i] = new byte[n2 += object[n++] & 0xFF];
            System.arraycopy(object, n, this.a[i], 0, n2);
            n += n2;
        }
    }

    public final byte[] a(int n) {
        return (byte[])this.a[n];
    }

    public final byte[][] a(int n, int n2) {
        return this.a(new int[]{n, n2});
    }

    public final byte[][] a(int n, int n2, int n3) {
        return this.a(new int[]{n, n2, n3});
    }

    public final byte[][] a(int n, int n2, int n3, int n4) {
        return this.a(new int[]{n, n2, n3, 25});
    }

    public final byte[][] a(int[] nArray) {
        byte[][] byArrayArray = new byte[nArray.length][];
        for (int i = 0; i < nArray.length; ++i) {
            byArrayArray[i] = (byte[])(nArray[i] < 0 ? null : this.a(nArray[i]));
        }
        return byArrayArray;
    }
}
