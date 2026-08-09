/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.c;

public final class ch
extends bi {
    private byte i;
    private static az a = null;

    public ch(ah ah2, byte by, byte[] byArray) {
        super(ah2, byArray, '\u0000');
        n.a = "";
        this.i = by;
        switch (this.i) {
            case 0: 
            case 2: {
                this.a(this.e + 2);
                return;
            }
            case 1: {
                this.a(this.e + 5);
            }
        }
    }

    protected final void a(cr cr2) {
        ch ch2 = this;
        if (a == null) {
            switch (ch2.i) {
                case 0: 
                case 2: {
                    a = new az(8);
                    break;
                }
                case 1: {
                    a = new az(25);
                }
            }
        }
        if (a == null) {
            return;
        }
        super.a(cr2);
        int n2 = ((j)this).a + 4;
        int n3 = ((j)this).c - 8;
        int n4 = ((j)this).b + 38;
        ah.a(cr2, n2 + 89, n4 - 11, 20, 12, 0x660000, 0xBD0000);
        cr2.a(0xFFFFFF);
        dv.a(cr2, n2 + 100, n4 - 11, a.a(), 0, 1);
        switch (this.i) {
            case 0: 
            case 2: {
                ah.a(cr2, n2, n4, n3, 17, 0x660000, 0xBD0000);
                cr2.a(0xFFFFFF);
                cr2.a(a.a(), rpg.a.c, n4 + 1, 17);
                return;
            }
            case 1: {
                int n5 = n4;
                ah.a(cr2, n2, n4, n3, 59, 0x660000, 0xBD0000);
                cr2.a(0xFFFFFF);
                String string = a.a();
                n3 = string.length();
                while (n3 > 0) {
                    while (bl.a().a(string, 0, n3) >= 144) {
                        --n3;
                    }
                    String string2 = string.substring(0, n3);
                    cr2.a(string2, ((j)this).a + 5, n5, 20);
                    n5 += 15;
                    string = string.substring(n3);
                    n3 = string.length();
                }
                break;
            }
        }
    }

    final boolean a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (ah.g(n2, n3) && a.a().length() == 0) {
            if (this.i == 2) {
                n.f();
                ao.a().g();
                af.a(false);
            } else {
                a = null;
                ((ah)this).a.g();
            }
            return true;
        }
        if (n2 == 8 && n3 != 53) {
            boolean bl2;
            String string;
            String string2 = string = a.a();
            if (string == null) {
                bl2 = false;
            } else if (string2.length() != 0) {
                for (int k = 0; k < string2.length(); ++k) {
                    String string3 = string2.substring(k, k + 1);
                    char c2 = string3.charAt(0);
                    if (c2 > '/' && c2 < ':' || c2 > '@' && c2 < '[') continue;
                    if (c2 > '`' && c2 < '{') {
                        bl2 = false;
                    } else {
                        if (c2 == ' ') continue;
                        if (c2 > '\u3130' && c2 < '\u3164') {
                            bl2 = false;
                        } else {
                            if (c2 > '\uabff' && c2 < '\ud789') continue;
                            bl2 = false;
                        }
                    }
                    break;
                }
            } else {
                bl2 = true;
            }
            if (bl2) {
                if (this.i == 0 || this.i == 2) {
                    if ((string = string.trim()).length() > 5) {
                        ((ah)this).b = new bi((ah)this, c.h.a(73), '\u0000');
                    } else if (string.length() > 0) {
                        n.a = string;
                        a = null;
                        ((ah)this).a.a((byte)10, ((ah)this).d);
                    }
                } else {
                    n.a = string;
                    a = null;
                    ((ah)this).a.a((byte)10, ((ah)this).d);
                }
            } else {
                ((ah)this).b = new bi((ah)this, c.h.a(62), '\u0000');
            }
            return true;
        }
        this.a();
        return a.a(n2, n3);
    }
}
