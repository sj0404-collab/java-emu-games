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
        for (int i = 4; i < 10; ++i) {
            this.aa[i] = -1;
            this.Z[i] = -1;
        }
        this.g();
        this.a(false);
        this.a = false;
    }

    private void g() {
        this.a = new byte[2];
        for (int i = 0; i < 2; ++i) {
            this.a[i] = -1;
        }
    }

    public final void a(boolean bl) {
        this.h();
        if (bl) {
            ai ai2 = this;
            if (ai2.a) {
                int n = r.b[2];
                byte by = r.b[3];
                for (int i = 0; i < 10; ++i) {
                    if (i == n || i == by || rpg.c.a[i] == null) continue;
                    rpg.c.a[i] = null;
                }
                ai2.a = false;
            }
        }
    }

    final void b() {
        if (this.b == 0) {
            return;
        }
        byte by = this.c = (byte)(this.c + 1);
        ai ai2 = this;
        if (by == 0) {
            ai.b(ai2.a);
        }
        switch (ai2.a) {
            case 0: {
                byte by2 = by;
                ai ai3 = ai2;
                switch (by2) {
                    case 0: {
                        ab.a(1);
                        break;
                    }
                    case 1: {
                        int n;
                        ai3.a.i();
                        db db2 = ai3.a.a();
                        if (db2 != null) {
                            n = ai3.e((byte)0);
                            db2.a(n, ai3.a.q);
                            db2.c(new cl(30, 0, 1));
                        }
                    }
                    case 3: 
                    case 5: {
                        int n = 2 - by2 / 2 + 1;
                        r.a.c(n, 1);
                    }
                }
                break;
            }
            case 1: {
                if (by != 0) break;
                ai.a((byte)31, (byte)1, 1);
                break;
            }
            case 2: {
                if (by != 0) break;
                ai.a((byte)33, (byte)2, 1);
                break;
            }
            case 3: {
                if (by != 0) break;
                int n = ai2.b((byte)3, ai2.a.e((byte)0)) + ai2.c((byte)3);
                ai2.a.c(n);
                ai2.a.c(new cl(35, 3, 1));
                break;
            }
            case 4: {
                byte by3 = by;
                ai ai4 = ai2;
                switch (by3) {
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
                int n = 0;
                switch (by3) {
                    case 1: {
                        n = -5;
                        break;
                    }
                    case 5: 
                    case 8: 
                    case 10: 
                    case 13: {
                        n = 4;
                        break;
                    }
                    case 12: {
                        bo.a((byte)2);
                    }
                    case 9: 
                    case 14: 
                    case 17: 
                    case 19: {
                        n = 6;
                        break;
                    }
                    case 20: {
                        n = 3;
                    }
                }
                if (n != 0) {
                    r.a.c(n, n < 0 ? 2 : 1);
                }
                switch (by3) {
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
                        int n2 = ai4.e((byte)4);
                        ai4.d(n2);
                    }
                }
                break;
            }
            case 5: {
                if (by != 0) break;
                ai2.a.d = ai2.c((byte)5);
                ai.a((byte)38, (byte)5, -1);
                ai.a((byte)37, (byte)5, -1);
                break;
            }
            case 6: {
                int n;
                byte by4 = by;
                ai ai5 = ai2;
                switch (by4) {
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
                        r.a.c(3 * (19 - by4), 2);
                    }
                }
                if (by4 != 5 && by4 != 9 && by4 != 15) break;
                int n3 = n = ai5.e((byte)6);
                ai ai6 = ai5;
                for (byte by5 = 1; by5 <= 8; by5 = (byte)(by5 + 1)) {
                    db db3 = ai6.a(by5);
                    if (db3 == null) continue;
                    db3.a(n3, by5);
                    db3.d(60);
                }
                bo.a(by4 == 15 ? (byte)2 : 3);
                break;
            }
            case 7: {
                if (by != 0) break;
                byte by6 = 7;
                ai ai7 = ai2;
                ai2.a.c = ai7.b(by6, 1) + ai2.c((byte)7);
                ai.a((byte)41, (byte)7, -1);
                ai.a((byte)42, (byte)7, -1);
                break;
            }
            case 8: {
                byte by7 = by;
                ai ai8 = ai2;
                switch (by7) {
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
                        if (by7 <= 4 || by7 >= 22 || by7 % 2 != 1) break;
                        r.a.c(3, 2);
                    }
                }
                if (by7 >= 5 && by7 <= 21) {
                    int n = ai8.e((byte)8);
                    ai8.d(n);
                }
                if (by7 % 7 != 6) break;
                ai.b((byte)8);
                break;
            }
            case 9: {
                if (by != 0) break;
                int n = ai2.c((byte)9);
                ai2.a.e = true;
                ai.a((byte)44, (byte)9, n);
            }
        }
        if (by >= b[ai2.a]) {
            ai2.h();
        }
    }

    private void h() {
        this.b = 0;
        this.c = (byte)-1;
        this.a = (byte)-1;
    }

    public final byte a(byte by) {
        return this.Z[by];
    }

    public final byte b(byte by) {
        return this.aa[by];
    }

    public final boolean a(byte by) {
        byte by2 = by;
        this.Z[by2] = (byte)(this.Z[by2] + 1);
        return ai.a(this.Z);
    }

    public final boolean b(byte by) {
        byte by2 = by;
        this.aa[by2] = (byte)(this.aa[by2] + 1);
        return ai.a(this.aa);
    }

    public final boolean c(byte by) {
        return this.a[by];
    }

    public final void a(int n, byte by) {
        for (int i = 0; i < 2; ++i) {
            if (this.a[i] != by) continue;
            this.a[i] = -1;
        }
        this.a(n);
        this.a[n] = by;
        this.a[by] = true;
    }

    public final void a(int n) {
        byte by = this.a[n];
        if (by >= 0) {
            this.a[by] = false;
        }
        this.a[n] = -1;
    }

    public final void c() {
        int n;
        this.a = new boolean[10];
        for (n = 0; n < 10; ++n) {
            this.a[n] = false;
        }
        for (n = 0; n < 2; ++n) {
            if (this.a[n] < 0) continue;
            this.a[this.a[n]] = true;
        }
    }

    private static boolean a(byte[] byArray) {
        int n;
        if (byArray[4] >= 0) {
            return false;
        }
        int n2 = 0;
        for (n = 0; n < 4; ++n) {
            n2 += byArray[n];
        }
        if (n2 >= 6) {
            for (n = 4; n < 10; ++n) {
                if (byArray[n] >= 0) continue;
                byArray[n] = 0;
            }
            return true;
        }
        return false;
    }

    public final void b(int n) {
        if ((n = r.b[n]) < 0) {
            return;
        }
        if (rpg.c.a[n] != null) {
            return;
        }
        ai.a((byte)n);
        this.a = true;
    }

    public final void d() {
        ai.a((byte)10);
    }

    private int e(byte by) {
        byte by2 = by;
        ai ai2 = this;
        by = (byte)(ai2.b(by2, 1) + this.c(by));
        return this.a.c((int)by);
    }

    public final boolean a(db db2) {
        byte by = 5;
        ai ai2 = this;
        int n = ai2.b(by, 1);
        if (f.a(1, 100) > n) {
            if (db2 instanceof ec) {
                db2.c(new ax(-3));
                return false;
            }
            db2.c(new cl(39, 5, 1));
            return true;
        }
        return false;
    }

    public static void c(int n) {
        switch (n) {
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

    public final int a(int n) {
        return this.b((byte)9, n);
    }

    public final boolean a() {
        byte by = 9;
        ai ai2 = this;
        return f.a(1, 100) < ai2.a(by, 1);
    }

    private static void a(byte by, byte by2, int n) {
        r.a.a(by, by2, n);
    }

    public final int a(byte by) {
        return this.a(by, 1);
    }

    public final int a(byte by, int n) {
        byte by2 = by;
        ai ai2 = this;
        if (!ai2.a[by2]) {
            return 0;
        }
        int n2 = by * 3;
        by2 = by;
        ai2 = this;
        int n3 = this.ac[n2] + this.ac[n2 + 1] * ai2.aa[by2];
        by = (byte)n3;
        return n3 * n / this.ac[n2 + 2];
    }

    private int b(byte by, int n) {
        int n2 = by * 8;
        return n * (this.ab[n2] + this.ab[n2 + 1] * this.Z[by]) / this.ab[n2 + 2];
    }

    public final int b(byte by) {
        return this.b(by, 1);
    }

    public final int c(byte by) {
        by = (byte)(by << 3);
        byte by2 = this.ab[by + 3];
        by = this.ab[by + 7];
        return r.a.c((byte)3) / by2 + by;
    }

    public final int d(byte by) {
        short s = f.b(this.ab, (by << 3) + 5);
        by = (byte)s;
        return s;
    }

    public final boolean d(byte n) {
        if (n < 0) {
            return false;
        }
        if (this.b != 0) {
            return false;
        }
        if (this.a != -1) {
            return false;
        }
        int n2 = n;
        ai ai2 = this;
        n2 = ai2.ab[(n2 << 3) + 4];
        n2 -= ai2.a((byte)8, n2);
        int n3 = n2;
        if (n2 > r.a.a()) {
            this.a.g((byte)1);
            return false;
        }
        this.a = (byte)n;
        r.a.e(-n3);
        r.b((byte)n, false);
        n2 = n;
        ai ai3 = this;
        switch (n2) {
            case 1: {
                n = 7;
                break;
            }
            case 2: {
                n = 6;
                break;
            }
            case 5: {
                n = 1;
                break;
            }
            case 9: {
                n = 8;
                break;
            }
            default: {
                ai3.a.a((byte)10);
                ((do)ai3.a).f = 0;
                return true;
            }
        }
        n2 = ai3.c((byte)n2) * n;
        ai3.a.k(n2);
        ai3.a.p();
        return false;
    }

    public final void e() {
        this.c = (byte)-1;
        this.b = 1;
    }

    private void d(int n) {
        this.b((byte)1, (byte)12, n);
        this.b((byte)17, (byte)24, n);
    }

    private void b(byte by, byte by2, int n) {
        for (byte by3 = by; by3 <= by2; by3 = (byte)(by3 + 1)) {
            db db2 = this.a(by3);
            if (db2 == null) continue;
            db2.b(n);
        }
    }

    private db a(byte by) {
        c c2 = c.a(this.d, this.e, by, (byte)0, (byte)0);
        if (c2 != null && c2 instanceof db && !(c2 instanceof an)) {
            return (db)c2;
        }
        return null;
    }

    private void a(byte by, byte by2, int n, boolean bl) {
        ai ai2 = this;
        this.d = ((c)ai2.a).c;
        ai2.e = ((c)ai2.a).d;
        r.a.a(new v(by, by2, 1, ((c)this.a).a, ((c)this.a).b, bl));
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
        byte by;
        int n = 0;
        for (by = 0; by < this.Z.length; ++by) {
            if (this.Z[by] <= 0) continue;
            n += this.Z[by];
            this.Z[by] = 0;
        }
        for (by = 0; by < this.aa.length; ++by) {
            if (this.aa[by] <= 0) continue;
            n += this.aa[by];
            this.aa[by] = 0;
        }
        r.a.d = (short)(r.a.d + n);
        this.g();
        for (by = 0; by < 2; by = (byte)(by + 1)) {
            r.a(by, false);
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

    private static void a(byte by) {
        rpg.c.a[by] = at.a("/s/cif/" + by, "/s/" + by);
    }

    private static void b(byte by) {
        switch (by) {
            case 0: 
            case 4: {
                by = 1;
                break;
            }
            case 8: {
                by = (byte)2;
                break;
            }
            default: {
                return;
            }
        }
        bo.a(by);
    }

    public final boolean b() {
        int n = 5 + this.a.c((byte)3);
        byte by = 6;
        ai ai2 = this;
        int n2 = n + ai2.a(by, 1);
        return f.a(0, 99) < n2;
    }
}
