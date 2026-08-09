/*
 * Decompiled with CFR 0.152.
 */
public final class bu {
    private String a = "0123456789abcdef";

    private String a(int n) {
        String string = "";
        int n2 = 0;
        while (n2 <= 3) {
            string = String.valueOf(string) + this.a.charAt(n >> (n2 << 3) + 4 & 0xF) + this.a.charAt(n >> (n2 << 3) & 0xF);
            ++n2;
        }
        return string;
    }

    private static int a(int n, int n2) {
        return (n & Integer.MAX_VALUE) + (n2 & Integer.MAX_VALUE) ^ n & Integer.MIN_VALUE ^ n2 & Integer.MIN_VALUE;
    }

    private int a(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = bu.a(bu.a(n2, n), bu.a(n4, n6));
        n2 = n5;
        n = n7;
        return bu.a(n7 << n2 | n >>> 32 - n2, n3);
    }

    private int a(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        return this.a(n2 & n3 | ~n2 & n4, n, n2, n5, n6, n7);
    }

    private int b(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        return this.a(n2 & n4 | n3 & ~n4, n, n2, n5, n6, n7);
    }

    private int c(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        return this.a(n2 ^ n3 ^ n4, n, n2, n5, n6, n7);
    }

    private int d(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        return this.a(n3 ^ (n2 | ~n4), n, n2, n5, n6, n7);
    }

    public final String a(String object) {
        int n = (((String)object).length() + 8 >> 6) + 1;
        int[] nArray = new int[n << 4];
        int n2 = 0;
        while (n2 < n << 4) {
            nArray[n2] = 0;
            ++n2;
        }
        n2 = 0;
        while (n2 < ((String)object).length()) {
            int n3 = n2 >> 2;
            nArray[n3] = nArray[n3] | ((String)object).charAt(n2) << (n2 % 4 << 3);
            ++n2;
        }
        int n4 = n2 >> 2;
        nArray[n4] = nArray[n4] | 128 << (n2 % 4 << 3);
        nArray[(n << 4) - 2] = ((String)object).length() << 3;
        object = nArray;
        n = 1732584193;
        int n5 = -271733879;
        n2 = -1732584194;
        int n6 = 271733878;
        int n7 = 0;
        while (n7 < ((Object)object).length) {
            int n8 = n;
            int n9 = n5;
            int n10 = n2;
            int n11 = n6;
            n = this.a(n, n5, n2, n6, (int)object[n7], 7, -680876936);
            n6 = this.a(n6, n, n5, n2, (int)object[n7 + 1], 12, -389564586);
            n2 = this.a(n2, n6, n, n5, (int)object[n7 + 2], 17, 606105819);
            n5 = this.a(n5, n2, n6, n, (int)object[n7 + 3], 22, -1044525330);
            n = this.a(n, n5, n2, n6, (int)object[n7 + 4], 7, -176418897);
            n6 = this.a(n6, n, n5, n2, (int)object[n7 + 5], 12, 1200080426);
            n2 = this.a(n2, n6, n, n5, (int)object[n7 + 6], 17, -1473231341);
            n5 = this.a(n5, n2, n6, n, (int)object[n7 + 7], 22, -45705983);
            n = this.a(n, n5, n2, n6, (int)object[n7 + 8], 7, 1770035416);
            n6 = this.a(n6, n, n5, n2, (int)object[n7 + 9], 12, -1958414417);
            n2 = this.a(n2, n6, n, n5, (int)object[n7 + 10], 17, -42063);
            n5 = this.a(n5, n2, n6, n, (int)object[n7 + 11], 22, -1990404162);
            n = this.a(n, n5, n2, n6, (int)object[n7 + 12], 7, 1804603682);
            n6 = this.a(n6, n, n5, n2, (int)object[n7 + 13], 12, -40341101);
            n2 = this.a(n2, n6, n, n5, (int)object[n7 + 14], 17, -1502002290);
            n5 = this.a(n5, n2, n6, n, (int)object[n7 + 15], 22, 1236535329);
            n = this.b(n, n5, n2, n6, (int)object[n7 + 1], 5, -165796510);
            n6 = this.b(n6, n, n5, n2, (int)object[n7 + 6], 9, -1069501632);
            n2 = this.b(n2, n6, n, n5, (int)object[n7 + 11], 14, 643717713);
            n5 = this.b(n5, n2, n6, n, (int)object[n7], 20, -373897302);
            n = this.b(n, n5, n2, n6, (int)object[n7 + 5], 5, -701558691);
            n6 = this.b(n6, n, n5, n2, (int)object[n7 + 10], 9, 38016083);
            n2 = this.b(n2, n6, n, n5, (int)object[n7 + 15], 14, -660478335);
            n5 = this.b(n5, n2, n6, n, (int)object[n7 + 4], 20, -405537848);
            n = this.b(n, n5, n2, n6, (int)object[n7 + 9], 5, 568446438);
            n6 = this.b(n6, n, n5, n2, (int)object[n7 + 14], 9, -1019803690);
            n2 = this.b(n2, n6, n, n5, (int)object[n7 + 3], 14, -187363961);
            n5 = this.b(n5, n2, n6, n, (int)object[n7 + 8], 20, 1163531501);
            n = this.b(n, n5, n2, n6, (int)object[n7 + 13], 5, -1444681467);
            n6 = this.b(n6, n, n5, n2, (int)object[n7 + 2], 9, -51403784);
            n2 = this.b(n2, n6, n, n5, (int)object[n7 + 7], 14, 1735328473);
            n5 = this.b(n5, n2, n6, n, (int)object[n7 + 12], 20, -1926607734);
            n = this.c(n, n5, n2, n6, (int)object[n7 + 5], 4, -378558);
            n6 = this.c(n6, n, n5, n2, (int)object[n7 + 8], 11, -2022574463);
            n2 = this.c(n2, n6, n, n5, (int)object[n7 + 11], 16, 1839030562);
            n5 = this.c(n5, n2, n6, n, (int)object[n7 + 14], 23, -35309556);
            n = this.c(n, n5, n2, n6, (int)object[n7 + 1], 4, -1530992060);
            n6 = this.c(n6, n, n5, n2, (int)object[n7 + 4], 11, 1272893353);
            n2 = this.c(n2, n6, n, n5, (int)object[n7 + 7], 16, -155497632);
            n5 = this.c(n5, n2, n6, n, (int)object[n7 + 10], 23, -1094730640);
            n = this.c(n, n5, n2, n6, (int)object[n7 + 13], 4, 681279174);
            n6 = this.c(n6, n, n5, n2, (int)object[n7], 11, -358537222);
            n2 = this.c(n2, n6, n, n5, (int)object[n7 + 3], 16, -722521979);
            n5 = this.c(n5, n2, n6, n, (int)object[n7 + 6], 23, 76029189);
            n = this.c(n, n5, n2, n6, (int)object[n7 + 9], 4, -640364487);
            n6 = this.c(n6, n, n5, n2, (int)object[n7 + 12], 11, -421815835);
            n2 = this.c(n2, n6, n, n5, (int)object[n7 + 15], 16, 530742520);
            n5 = this.c(n5, n2, n6, n, (int)object[n7 + 2], 23, -995338651);
            n = this.d(n, n5, n2, n6, (int)object[n7], 6, -198630844);
            n6 = this.d(n6, n, n5, n2, (int)object[n7 + 7], 10, 1126891415);
            n2 = this.d(n2, n6, n, n5, (int)object[n7 + 14], 15, -1416354905);
            n5 = this.d(n5, n2, n6, n, (int)object[n7 + 5], 21, -57434055);
            n = this.d(n, n5, n2, n6, (int)object[n7 + 12], 6, 1700485571);
            n6 = this.d(n6, n, n5, n2, (int)object[n7 + 3], 10, -1894986606);
            n2 = this.d(n2, n6, n, n5, (int)object[n7 + 10], 15, -1051523);
            n5 = this.d(n5, n2, n6, n, (int)object[n7 + 1], 21, -2054922799);
            n = this.d(n, n5, n2, n6, (int)object[n7 + 8], 6, 1873313359);
            n6 = this.d(n6, n, n5, n2, (int)object[n7 + 15], 10, -30611744);
            n2 = this.d(n2, n6, n, n5, (int)object[n7 + 6], 15, -1560198380);
            n5 = this.d(n5, n2, n6, n, (int)object[n7 + 13], 21, 1309151649);
            n = this.d(n, n5, n2, n6, (int)object[n7 + 4], 6, -145523070);
            n6 = this.d(n6, n, n5, n2, (int)object[n7 + 11], 10, -1120210379);
            n2 = this.d(n2, n6, n, n5, (int)object[n7 + 2], 15, 718787259);
            n5 = this.d(n5, n2, n6, n, (int)object[n7 + 9], 21, -343485551);
            n = bu.a(n, n8);
            n5 = bu.a(n5, n9);
            n2 = bu.a(n2, n10);
            n6 = bu.a(n6, n11);
            n7 += 16;
        }
        return String.valueOf(this.a(n)) + this.a(n5) + this.a(n2) + this.a(n6);
    }
}
