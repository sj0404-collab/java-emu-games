/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import rpg.b;
import rpg.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ai
implements b {
    private static final byte[] b = new byte[]{6, 0, 0, 0, 21, 0, 21, 0, 23, 0};
    private byte[] Z;
    private byte[] aa;
    private boolean[] a;
    public byte[] a;
    private byte a;
    private byte b = 0;
    private byte c;
    private byte[] ab;
    private byte[] ac;
    private x a;
    private boolean a = false;
    private final byte[] ad = new byte[]{12, 12, 4, 2};
    private byte d;
    private byte e;

    public ai(x x2) {
        this.a = x2;
    }

    final void a() {
        this.Z = new byte[10];
        this.aa = new byte[10];
        for (int i2 = 4; i2 < 10; ++i2) {
            this.aa[i2] = -1;
            this.Z[i2] = -1;
        }
        this.g();
        this.a(false);
        this.a = false;
    }

    private void g() {
        this.a = new byte[2];
        for (int i2 = 0; i2 < 2; ++i2) {
            this.a[i2] = -1;
        }
    }

    public final void a(boolean bl2) {
        this.h();
        if (bl2) {
            ai ai2 = this;
            if (ai2.a) {
                int n2 = r.b[2];
                byte by2 = r.b[3];
                for (int i2 = 0; i2 < 10; ++i2) {
                    if (i2 == n2 || i2 == by2 || rpg.c.a[i2] == null) continue;
                    rpg.c.a[i2] = null;
                }
                ai2.a = false;
            }
        }
    }

    final void b() {
        if (this.b == 0) {
            return;
        }
        byte by2 = this.c = (byte)(this.c + 1);
        ai ai2 = this;
        if (by2 == 0) {
            ai.b(ai2.a);
        }
        switch (ai2.a) {
            case 0: {
                byte by3 = by2;
                ai ai3 = ai2;
                switch (by3) {
                    case 0: {
                        ab.a(1);
                        break;
                    }
                    case 1: {
                        int n2;
                        ai3.a.i();
                        db db2 = ai3.a.a();
                        if (db2 != null) {
                            n2 = ai3.e((byte)0);
                            db2.a(n2, ai3.a.q);
                            db2.c(new cl(30, 0, 1));
                        }
                    }
                    case 3: 
                    case 5: {
                        int n2 = 2 - by3 / 2 + 1;
                        r.a.c(n2, 1);
                    }
                }
                break;
            }
            case 1: {
                if (by2 != 0) break;
                ai.a((byte)31, (byte)1, 1);
                break;
            }
            case 2: {
                if (by2 != 0) break;
                ai.a((byte)33, (byte)2, 1);
                break;
            }
            case 3: {
                if (by2 != 0) break;
                int n3 = ai2.b((byte)3, ai2.a.e((byte)0)) + ai2.c((byte)3);
                ai2.a.c(n3);
                ai2.a.c(new cl(35, 3, 1));
                break;
            }
            case 4: {
                byte by4 = by2;
                ai ai4 = ai2;
                switch (by4) {
                    case 3: 
                    case 7: 
                    case 11: 
                    case 15: {
                        ab.a(1);
                        break;
                    }
                    default: {
                        ab.b(0);
                    }
                }
                int n4 = 0;
                switch (by4) {
                    case 1: {
                        n4 = -5;
                        break;
                    }
                    case 5: 
                    case 8: 
                    case 10: 
                    case 13: {
                        n4 = 4;
                        break;
                    }
                    case 12: {
                        bo.a((byte)2);
                    }
                    case 9: 
                    case 14: 
                    case 17: 
                    case 19: {
                        n4 = 6;
                        break;
                    }
                    case 20: {
                        n4 = 3;
                    }
                }
                if (n4 != 0) {
                    r.a.c(n4, n4 < 0 ? 2 : 1);
                }
                switch (by4) {
                    case 0: {
                        ai4.a((byte)36, (byte)4, 1, false);
                        break;
                    }
                    case 4: 
                    case 8: {
                        bo.a((byte)1);
                    }
                    case 1: 
                    case 6: 
                    case 10: 
                    case 12: 
                    case 14: 
                    case 16: {
                        int n5 = ai4.e((byte)4);
                        ai4.d(n5);
                    }
                }
                break;
            }
            case 5: {
                if (by2 != 0) break;
                ai2.a.d = ai2.c((byte)5);
                ai.a((byte)38, (byte)5, -1);
                ai.a((byte)37, (byte)5, -1);
                break;
            }
            case 6: {
                int n6;
                byte by5 = by2;
                ai ai5 = ai2;
                switch (by5) {
                    case 0: {
                        ai5.a((byte)40, (byte)6, 1, true);
                        break;
                    }
                    case 5: 
                    case 9: {
                        r.a.c(2, 2);
                        break;
                    }
                    case 12: {
                        r.a.a(new z(true, 0xFFFF57, ai5.ad, ai5.d << 4, ai5.e << 4));
                        break;
                    }
                    case 14: {
                        ab.a(1);
                        break;
                    }
                    case 15: 
                    case 16: {
                        ab.b(0);
                    }
                    case 17: 
                    case 18: {
                        r.a.c(3 * (19 - by5), 2);
                    }
                }
                if (by5 != 5 && by5 != 9 && by5 != 15) break;
                int n7 = n6 = ai5.e((byte)6);
                ai ai6 = ai5;
                for (byte by6 = 1; by6 <= 8; by6 = (byte)(by6 + 1)) {
                    db db3 = ai6.a(by6);
                    if (db3 == null) continue;
                    db3.a(n7, by6);
                    db3.d(60);
                }
                bo.a(by5 == 15 ? (byte)2 : 3);
                break;
            }
            case 7: {
                if (by2 != 0) break;
                byte by7 = 7;
                ai ai7 = ai2;
                ai2.a.c = ai7.b(by7, 1) + ai2.c((byte)7);
                ai.a((byte)41, (byte)7, -1);
                ai.a((byte)42, (byte)7, -1);
                break;
            }
            case 8: {
                byte by8 = by2;
                ai ai8 = ai2;
                switch (by8) {
                    case 0: {
                        ai8.a((byte)43, (byte)8, 1, true);
                        break;
                    }
                    case 3: {
                        ai8.a.g(30);
                        ab.a(1);
                        break;
                    }
                    case 23: {
                        r.a.c(1, 2);
                        break;
                    }
                    default: {
                        if (by8 <= 4 || by8 >= 22 || by8 % 2 != 1) break;
                        r.a.c(3, 2);
                    }
                }
                if (by8 >= 5 && by8 <= 21) {
                    int n8 = ai8.e((byte)8);
                    ai8.d(n8);
                }
                if (by8 % 7 != 6) break;
                ai.b((byte)8);
                break;
            }
            case 9: {
                if (by2 != 0) break;
                int n9 = ai2.c((byte)9);
                ai2.a.e = true;
                ai.a((byte)44, (byte)9, n9);
            }
        }
        if (by2 >= b[ai2.a]) {
            ai2.h();
        }
    }

    private void h() {
        this.b = 0;
        this.c = (byte)-1;
        this.a = (byte)-1;
    }

    public final byte a(byte by2) {
        return this.Z[by2];
    }

    public final byte b(byte by2) {
        return this.aa[by2];
    }

    public final boolean a(byte by2) {
        byte by3 = by2;
        this.Z[by3] = (byte)(this.Z[by3] + 1);
        return ai.a(this.Z);
    }

    public final boolean b(byte by2) {
        byte by3 = by2;
        this.aa[by3] = (byte)(this.aa[by3] + 1);
        return ai.a(this.aa);
    }

    public final boolean c(byte by2) {
        return this.a[by2];
    }

    public final void a(int n2, byte by2) {
        for (int i2 = 0; i2 < 2; ++i2) {
            if (this.a[i2] != by2) continue;
            this.a[i2] = -1;
        }
        this.a(n2);
        this.a[n2] = by2;
        this.a[by2] = true;
    }

    public final void a(int n2) {
        byte by2 = this.a[n2];
        if (by2 >= 0) {
            this.a[by2] = false;
        }
        this.a[n2] = -1;
    }

    public final void c() {
        int n2;
        this.a = new boolean[10];
        for (n2 = 0; n2 < 10; ++n2) {
            this.a[n2] = false;
        }
        for (n2 = 0; n2 < 2; ++n2) {
            if (this.a[n2] < 0) continue;
            this.a[this.a[n2]] = true;
        }
    }

    private static boolean a(byte[] byArray) {
        int n2;
        if (byArray[4] >= 0) {
            return false;
        }
        int n3 = 0;
        for (n2 = 0; n2 < 4; ++n2) {
            n3 += byArray[n2];
        }
        if (n3 >= 6) {
            for (n2 = 4; n2 < 10; ++n2) {
                if (byArray[n2] >= 0) continue;
                byArray[n2] = 0;
            }
            return true;
        }
        return false;
    }

    public final void b(int n2) {
        if ((n2 = r.b[n2]) < 0) {
            return;
        }
        if (rpg.c.a[n2] != null) {
            return;
        }
        ai.a((byte)n2);
        this.a = true;
    }

    public final void d() {
        ai.a((byte)10);
    }

    private int e(byte by2) {
        byte by3 = by2;
        ai ai2 = this;
        by2 = (byte)(ai2.b(by3, 1) + this.c(by2));
        return this.a.c((int)by2);
    }

    public final boolean a(db db2) {
        byte by2 = 5;
        ai ai2 = this;
        int n2 = ai2.b(by2, 1);
        if (f.a(1, 100) > n2) {
            if (db2 instanceof ec) {
                db2.c(new ax(-3));
                return false;
            }
            db2.c(new cl(39, 5, 1));
            return true;
        }
        return false;
    }

    public static void c(int n2) {
        switch (n2) {
            case 7: {
                ab.a(1);
                return;
            }
            case 8: {
                ab.b(0);
                return;
            }
            case 9: {
                r.a.c(2, 2);
            }
        }
    }

    public final int a(int n2) {
        return this.b((byte)9, n2);
    }

    public final boolean a() {
        byte by2 = 9;
        ai ai2 = this;
        return f.a(1, 100) < ai2.a(by2, 1);
    }

    private static void a(byte by2, byte by3, int n2) {
        r.a.a(by2, by3, n2);
    }

    public final int a(byte by2) {
        return this.a(by2, 1);
    }

    public final int a(byte by2, int n2) {
        byte by3 = by2;
        ai ai2 = this;
        if (!ai2.a[by3]) {
            return 0;
        }
        int n3 = by2 * 3;
        by3 = by2;
        ai2 = this;
        int n4 = this.ac[n3] + this.ac[n3 + 1] * ai2.aa[by3];
        by2 = (byte)n4;
        return n4 * n2 / this.ac[n3 + 2];
    }

    private int b(byte by2, int n2) {
        int n3 = by2 * 8;
        return n2 * (this.ab[n3] + this.ab[n3 + 1] * this.Z[by2]) / this.ab[n3 + 2];
    }

    public final int b(byte by2) {
        return this.b(by2, 1);
    }

    public final int c(byte by2) {
        by2 = (byte)(by2 << 3);
        byte by3 = this.ab[by2 + 3];
        by2 = this.ab[by2 + 7];
        return r.a.c((byte)3) / by3 + by2;
    }

    public final int d(byte by2) {
        short s2 = f.b(this.ab, (by2 << 3) + 5);
        by2 = (byte)s2;
        return s2;
    }

    public final boolean d(byte n2) {
        if (n2 < 0) {
            return false;
        }
        if (this.b != 0) {
            return false;
        }
        if (this.a != -1) {
            return false;
        }
        int n3 = n2;
        ai ai2 = this;
        n3 = ai2.ab[(n3 << 3) + 4];
        n3 -= ai2.a((byte)8, n3);
        int n4 = n3;
        if (n3 > r.a.a()) {
            this.a.g((byte)1);
            return false;
        }
        this.a = (byte)n2;
        r.a.e(-n4);
        r.b((byte)n2, false);
        n3 = n2;
        ai ai3 = this;
        switch (n3) {
            case 1: {
                n2 = 7;
                break;
            }
            case 2: {
                n2 = 6;
                break;
            }
            case 5: {
                n2 = 1;
                break;
            }
            case 9: {
                n2 = 8;
                break;
            }
            default: {
                ai3.a.a((byte)10);
                ((do)ai3.a).f = 0;
                return true;
            }
        }
        n3 = ai3.c((byte)n3) * n2;
        ai3.a.k(n3);
        ai3.a.p();
        return false;
    }

    public final void e() {
        this.c = (byte)-1;
        this.b = 1;
    }

    private void d(int n2) {
        this.b((byte)1, (byte)12, n2);
        this.b((byte)17, (byte)24, n2);
    }

    private void b(byte by2, byte by3, int n2) {
        for (byte by4 = by2; by4 <= by3; by4 = (byte)(by4 + 1)) {
            db db2 = this.a(by4);
            if (db2 == null) continue;
            db2.b(n2);
        }
    }

    private db a(byte by2) {
        c c2 = c.a(this.d, this.e, by2, (byte)0, (byte)0);
        if (c2 != null && c2 instanceof db && !(c2 instanceof an)) {
            return (db)c2;
        }
        return null;
    }

    private void a(byte by2, byte by3, int n2, boolean bl2) {
        ai ai2 = this;
        this.d = ((c)ai2.a).c;
        ai2.e = ((c)ai2.a).d;
        r.a.a(new v(by2, by3, 1, ((c)this.a).a, ((c)this.a).b, bl2));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final byte[] a() {
        byte[] byArray;
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((OutputStream)filterOutputStream).write(this.Z);
            ((OutputStream)filterOutputStream).write(this.aa);
            ((OutputStream)filterOutputStream).write(this.a);
            byArray = byteArrayOutputStream.toByteArray();
        }
        catch (IOException iOException) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) return null;
                byteArrayOutputStream.close();
                return null;
            }
            catch (IOException iOException2) {
                return null;
            }
        }
        catch (Throwable throwable) {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream == null) throw throwable;
                byteArrayOutputStream.close();
                throw throwable;
            }
            catch (IOException iOException) {}
            throw throwable;
        }
        try {
            filterOutputStream.close();
            byteArrayOutputStream.close();
            return byArray;
        }
        catch (IOException iOException) {}
        return byArray;
    }

    private void i() {
        byte by2;
        int n2 = 0;
        for (by2 = 0; by2 < this.Z.length; ++by2) {
            if (this.Z[by2] <= 0) continue;
            n2 += this.Z[by2];
            this.Z[by2] = 0;
        }
        for (by2 = 0; by2 < this.aa.length; ++by2) {
            if (this.aa[by2] <= 0) continue;
            n2 += this.aa[by2];
            this.aa[by2] = 0;
        }
        r.a.d = (short)(r.a.d + n2);
        this.g();
        for (by2 = 0; by2 < 2; by2 = (byte)(by2 + 1)) {
            r.a(by2, false);
        }
    }

    /*
     * Loose catch block
     */
    public final void a(byte[] object) {
        FilterInputStream filterInputStream;
        ByteArrayInputStream byteArrayInputStream;
        block14: {
            byteArrayInputStream = null;
            filterInputStream = null;
            byteArrayInputStream = new ByteArrayInputStream((byte[])object);
            filterInputStream = new DataInputStream(byteArrayInputStream);
            ((DataInputStream)filterInputStream).read(this.Z);
            ((DataInputStream)filterInputStream).read(this.aa);
            ((DataInputStream)filterInputStream).read(this.a);
            if (!r.a((byte)4)) break block14;
            this.i();
        }
        try {
            filterInputStream.close();
            byteArrayInputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
        catch (IOException iOException) {
            try {
                object = iOException;
                iOException.printStackTrace();
            }
            catch (Throwable throwable) {
                try {
                    if (filterInputStream != null) {
                        filterInputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                }
                catch (IOException iOException2) {}
                throw throwable;
            }
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return;
            }
            catch (IOException iOException3) {
                return;
            }
        }
    }

    public final void f() {
        this.ab = rpg.c.a("/s/d/a");
        this.ac = new byte[30];
        this.ac = rpg.c.a("/s/d/p");
    }

    private static void a(byte by2) {
        rpg.c.a[by2] = at.a("/s/cif/" + by2, "/s/" + by2);
    }

    private static void b(byte by2) {
        switch (by2) {
            case 0: 
            case 4: {
                by2 = 1;
                break;
            }
            case 8: {
                by2 = (byte)2;
                break;
            }
            default: {
                return;
            }
        }
        bo.a(by2);
    }

    public final boolean b() {
        int n2 = 5 + this.a.c((byte)3);
        byte by2 = 6;
        ai ai2 = this;
        int n3 = n2 + ai2.a(by2, 1);
        return f.a(0, 99) < n3;
    }
}

