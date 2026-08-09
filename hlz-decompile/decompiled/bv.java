/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.rms.RecordStore
 */
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.rms.RecordStore;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bv {
    public byte[] a;
    public int a;
    public String a = 0;

    public bv(String string, byte by) {
        this.a = string;
        if (by == 1) {
            if (string.equals(ea.a)) {
                this.a = new byte[ea.a.length];
                System.arraycopy(ea.a, 0, this.a, 0, ea.a.length);
                ea.a = null;
                ea.a = null;
                return;
            }
            if (!this.a()) {
                throw new IOException("No such file : " + string);
            }
        }
    }

    public final void a(byte[] byArray, int n, int n2) {
        try {
            this.a = this.a;
            System.arraycopy(this.a, this.a, byArray, 0, n2);
            this.a += n2;
            return;
        }
        catch (Exception exception) {
            System.out.println(this.a);
            exception.printStackTrace();
            return;
        }
    }

    private boolean a() {
        int n;
        Object object;
        if (this.a == null) {
            return false;
        }
        try {
            object = this.a.getClass().getResourceAsStream(this.a);
            if (object != null) {
                this.a = new byte[((InputStream)object).available()];
                ((InputStream)object).read(this.a);
                ((InputStream)object).close();
                return true;
            }
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
        }
        while (this.a.startsWith("/")) {
            this.a = this.a.substring(1);
        }
        while ((n = this.a.indexOf("/")) > 0) {
            this.a = this.a.substring(0, n) + "." + this.a.substring(n + 1);
        }
        try {
            RecordStore recordStore = RecordStore.openRecordStore((String)this.a, (boolean)true);
            if (recordStore.getNumRecords() == 0) {
                try {
                    recordStore.closeRecordStore();
                }
                catch (Exception exception) {}
                return false;
            }
            this.a = recordStore.getRecord(1);
            try {
                recordStore.closeRecordStore();
            }
            catch (Exception exception) {}
            return true;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return false;
        }
    }
}
