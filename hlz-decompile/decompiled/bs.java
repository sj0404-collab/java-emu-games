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

    public bs(byte by, byte by2) {
        super(by, by2);
        this.b = by2 < 16 ? (byte)0 : 1;
        this.f = (byte)-1;
    }

    protected final byte a() {
        int n = super.a();
        for (int i = 0; i < this.a.length; ++i) {
            n += this.a[i] << ((i & 1) == 0 ? 2 : 3);
        }
        return (byte)(n % 100);
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

    protected final int a(byte[] byArray, int n) {
        n = super.a(byArray, n);
        this.a = byArray[n++];
        this.b = byArray[n++];
        this.c = byArray[n++];
        this.d = byArray[n++];
        this.a = rpg.f.b(byArray, n);
        this.b = rpg.f.b(byArray, n += 2);
        this.c = rpg.f.b(byArray, n += 2);
        this.d = rpg.f.b(byArray, n += 2);
        n += 2;
        this.e = byArray[n++];
        System.arraycopy(byArray, n, this.a, 0, this.a.length);
        n += this.a.length;
        for (int i = 0; i < this.a.length; ++i) {
            if (this.a[i] != 100) continue;
            this.a[i] = (byte)rpg.f.a(0, 15);
        }
        return n;
    }

    public final int a(int n) {
        int n2 = 0;
        for (int i = 0; i < this.a.length; ++i) {
            if (this.a[i] != n) continue;
            n2 += b[n];
        }
        return n2;
    }

    public final int a() {
        int n;
        for (n = 0; n < this.a.length && this.a[n] != -3; ++n) {
        }
        return n;
    }
}
