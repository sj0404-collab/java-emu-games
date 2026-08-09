/*
 * Decompiled with CFR 0.152.
 */
import rpg.c;

final class cv
extends aw {
    private dg a = null;

    public cv(ah ah2, dg dg2) {
        super(ah2, (byte)0, (byte)0, (byte)0);
        this.a = dg2;
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3) || ah.f(n2, n3)) {
            ((ah)this).a.g();
        }
        return true;
    }

    protected final void a(cr cr2) {
        this.a(cr2, false, true, rpg.c.b.a(29), false);
        this.b(cr2, this.f, this.g + 13 + 1, this.a);
    }
}

