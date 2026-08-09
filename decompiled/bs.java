/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bs
extends dg {
    public byte a;
    public byte b;
    public byte c;
    public byte d;
    public short a;
    public short b;
    public short c;
    public short d;
    public byte e;
    private static byte[] b = new byte[]{5, 5, 5, 5, 50, 1, 8, 5, 1, 100, 8, 8, 8, 8, 1, 3};
    public byte[] a = new byte[]{-3, -3, -3, -3, -3, -3};
    public byte f;

    public bs(byte by2, byte by3) {
        super(by2, by3);
        this.b = by3 < 16 ? (byte)0 : 1;
        this.f = (byte)-1;
    }

    protected final byte a() {
        int n2 = super.a();
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            n2 += this.a[i2] << ((i2 & 1) == 0 ? 2 : 3);
        }
        return (byte)(n2 % 100);
    }

    protected final DataOutputStream a(DataOutputStream dataOutputStream) {
        dataOutputStream = super.a(dataOutputStream);
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeShort(this.c);
        dataOutputStream.writeShort(this.d);
        dataOutputStream.writeByte(this.e);
        ((OutputStream)dataOutputStream).write(this.a);
        dataOutputStream.write(this.f);
        return dataOutputStream;
    }

    protected final void a(DataInputStream dataInputStream) {
        super.a(dataInputStream);
        this.b = dataInputStream.readShort();
        this.c = dataInputStream.readShort();
        this.d = dataInputStream.readShort();
        this.e = dataInputStream.readByte();
        dataInputStream.read(this.a);
        this.f = dataInputStream.readByte();
    }

    protected final int a(byte[] byArray, int n2) {
        n2 = super.a(byArray, n2);
        this.a = byArray[n2++];
        this.b = byArray[n2++];
        this.c = byArray[n2++];
        this.d = byArray[n2++];
        this.a = rpg.f.b(byArray, n2);
        this.b = rpg.f.b(byArray, n2 += 2);
        this.c = rpg.f.b(byArray, n2 += 2);
        this.d = rpg.f.b(byArray, n2 += 2);
        n2 += 2;
        this.e = byArray[n2++];
        System.arraycopy(byArray, n2, this.a, 0, this.a.length);
        n2 += this.a.length;
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (this.a[i2] != 100) continue;
            this.a[i2] = (byte)rpg.f.a(0, 15);
        }
        return n2;
    }

    public final int a(int n2) {
        int n3 = 0;
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (this.a[i2] != n2) continue;
            n3 += b[n2];
        }
        return n3;
    }

    public final int a() {
        int n2;
        for (n2 = 0; n2 < this.a.length && this.a[n2] != -3; ++n2) {
        }
        return n2;
    }
}

