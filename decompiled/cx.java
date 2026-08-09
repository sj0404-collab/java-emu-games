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
        int n2 = 0;
        ++n2;
        this.a = (short)(object[0] & 0xFF);
        this.a = new Object[this.a];
        for (int i2 = 0; i2 < this.a; ++i2) {
            int n3 = (object[n2++] & 0xFF) << 8;
            this.a[i2] = new byte[n3 += object[n2++] & 0xFF];
            System.arraycopy(object, n2, this.a[i2], 0, n3);
            n2 += n3;
        }
    }

    public final byte[] a(int n2) {
        return (byte[])this.a[n2];
    }

    public final byte[][] a(int n2, int n3) {
        return this.a(new int[]{n2, n3});
    }

    public final byte[][] a(int n2, int n3, int n4) {
        return this.a(new int[]{n2, n3, n4});
    }

    public final byte[][] a(int n2, int n3, int n4, int n5) {
        return this.a(new int[]{n2, n3, n4, 25});
    }

    public final byte[][] a(int[] nArray) {
        byte[][] byArrayArray = new byte[nArray.length][];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            byArrayArray[i2] = (byte[])(nArray[i2] < 0 ? null : this.a(nArray[i2]));
        }
        return byArrayArray;
    }
}

