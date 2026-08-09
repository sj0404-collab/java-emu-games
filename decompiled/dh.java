/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dh
implements Runnable {
    private boolean a;
    private Thread a;
    private Object a = new Thread(this);
    private boolean b = false;

    public dh() {
        this.a.start();
        this.a = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void run() {
        if (this.b) {
            return;
        }
        while (this.a) {
            try {
                Object object = this.a;
                synchronized (object) {
                    while (!this.b) {
                        this.a.wait(100000L);
                    }
                    try {
                        dg.a((byte)80);
                        Thread.sleep(80L);
                    }
                    catch (Exception exception) {}
                    try {
                        dg.a((byte)80);
                        Thread.sleep(500L);
                    }
                    catch (Exception exception) {}
                }
            }
            catch (Exception exception) {
            }
            finally {
                this.b = false;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void a() {
        if (this.b) {
            return;
        }
        Object object = this.a;
        synchronized (object) {
            this.b = true;
            this.a.notify();
            return;
        }
    }
}

