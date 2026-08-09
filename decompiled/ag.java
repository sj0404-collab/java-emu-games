/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.midlet.MIDlet
 */
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;
import javax.microedition.midlet.MIDlet;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ag {
    private static Hashtable a = new Hashtable();
    private static String[][] a = new String[2][];
    private static String[][] b = new String[2][];
    private static String[][] c = new String[1][];
    private static String[][] d = new String[1][];
    private static String a = "Fr";
    private static String b = "Sec";
    private static String c = "N7610";
    private static String d = "Idx";
    private static String e = "0";
    private static int[] a = new int[3];
    private static int a = 0;
    private static int[][] a = new int[2][];

    public ag(MIDlet mIDlet) {
        this.a(mIDlet);
    }

    private static final String[] a(String string, String string2) {
        int n2;
        if (string == null) {
            System.out.println(" split. aStr == null");
            return null;
        }
        if (string.length() <= 0 || string2 == null) {
            return new String[]{string};
        }
        if (string2.length() <= 0) {
            return new String[]{string};
        }
        String[] stringArray = null;
        String string3 = string;
        int[] nArray = new int[string3.length()];
        int[] nArray2 = new int[string3.length()];
        int n3 = 0;
        boolean bl2 = false;
        int n4 = 0;
        do {
            n2 = 0;
            int n5 = n4 + string2.length();
            if (n5 <= string3.length() && string3.substring(n4, n5).equals(string2)) {
                n2 = 1;
            }
            if (n2 != 0) {
                if (bl2) {
                    bl2 = false;
                    nArray2[n3++] = n4;
                }
                n4 = n5;
                continue;
            }
            if (!bl2) {
                bl2 = true;
                nArray[n3] = n4;
            }
            ++n4;
        } while (n4 < string3.length());
        if (bl2) {
            nArray2[n3++] = string3.length();
        }
        if (n3 > 0) {
            stringArray = new String[n3];
            n2 = 0;
            while (n2 < n3) {
                stringArray[n2] = string.substring(nArray[n2], nArray2[n2]);
                ++n2;
            }
        }
        return stringArray;
    }

    private static final String a(String string) {
        if (string == null || string.length() < 32) {
            System.out.println("des. aStr ==null or aStr length < 32");
            return null;
        }
        try {
            Object object = new bt();
            ((bt)object).a("a4s3d5f1");
            object = ((bt)object).a(string.substring(0, string.length() - 32));
            int n2 = 0;
            int n3 = 0;
            while (n3 < ((String)object).length()) {
                if (!(((String)object).charAt(n3) >= 'a' && ((String)object).charAt(n3) <= 'z' || ((String)object).charAt(n3) >= 'A' && ((String)object).charAt(n3) <= 'Z' || ((String)object).charAt(n3) >= '0' && ((String)object).charAt(n3) <= '9' || ((String)object).charAt(n3) == ';' || ((String)object).charAt(n3) == ',')) {
                    n2 = n3;
                    break;
                }
                ++n3;
            }
            object = ((String)object).substring(0, n2);
            if (new bu().a((String)object).equals(string.substring(string.length() - 32))) {
                return object;
            }
            return null;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return null;
        }
    }

    private static int a(String object) {
        int n2 = 0;
        try {
            n2 = Integer.parseInt((String)object);
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
        }
        return n2;
    }

    private static String a(byte[] byArray) {
        String string;
        try {
            string = new String(byArray, "utf-8");
        }
        catch (Exception exception) {
            try {
                string = new String(byArray, "UTF-8");
            }
            catch (Exception exception2) {
                string = new String(byArray);
            }
        }
        return string;
    }

    private static String[] a(int n2, String object) {
        try {
            if (a.isEmpty()) {
                System.out.println("is empty");
            }
            if (a.containsKey(object)) {
                object = (Vector)a.get(object);
                if (n2 >= 0 && n2 < ((Vector)object).size()) {
                    return (String[])((Vector)object).elementAt(n2);
                }
                return null;
            }
            return null;
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
            return null;
        }
    }

    private void a() {
        InputStream inputStream = new Object().getClass().getResourceAsStream("/cpid.txt");
        if (inputStream != null) {
            try {
                try {
                    Object object = new byte[inputStream.available()];
                    inputStream.read((byte[])object);
                    object = ag.a(object);
                    System.out.println("cpidListStr=" + (String)object);
                    object = ag.a((String)object, "\n");
                    System.out.println("splitArray.length=" + (object != null ? ((byte[])object).length : 0));
                    int n2 = 0;
                    while (n2 < (object != null ? ((byte[])object).length : 0)) {
                        String[] stringArray = ag.a((String)object[n2], ",");
                        System.out.println("lineArray=" + stringArray.length);
                        System.out.println("lineArray[0]=" + stringArray[0]);
                        System.out.println("lineArray[1]=" + stringArray[1]);
                        System.out.println("lineArray[2]=" + stringArray[2].length() + "," + stringArray[2].trim().length());
                        String string = stringArray[0].trim();
                        Object object2 = ag.a(stringArray[1].trim());
                        String string2 = ag.a(stringArray[2].trim());
                        stringArray = new String[]{object2, string2};
                        System.out.println("cpid=" + string + ",code=" + (String)object2 + ",dest=" + string2);
                        if (!a.containsKey(string)) {
                            object2 = new Vector<String[]>();
                            ((Vector)object2).addElement(stringArray);
                            a.put(string, object2);
                            System.out.println("put.cpid=" + string + ",CodeDestV.size()=" + ((Vector)object2).size());
                        } else {
                            object2 = (Vector)a.get(string);
                            System.out.println("old.size()=" + ((Vector)object2).size());
                            ((Vector)object2).addElement(stringArray);
                            System.out.println("old.size.2()=" + ((Vector)object2).size());
                            a.remove(string);
                            a.put(string, object2);
                            System.out.println("put.cpid=" + string + ",old.size()=" + ((Vector)object2).size());
                            System.out.println("cpid=" + string + ",cpidHashtable=" + ((Vector)a.get(string)).size());
                        }
                        ++n2;
                    }
                }
                catch (Exception exception) {
                    Exception exception2 = exception;
                    exception.printStackTrace();
                    try {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return;
                    }
                    catch (Exception exception3) {
                        return;
                    }
                }
            }
            catch (Throwable throwable) {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
                catch (Exception exception) {}
                throw throwable;
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                return;
            }
            catch (Exception exception) {}
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void a(MIDlet var1_1) {
        block55: {
            try {
                try {
                    var2_3 /* !! */  = var1_1 /* !! */ .getAppProperty("ChannelFirst");
                    if (var2_3 /* !! */  != null) {
                        ag.a = var2_3 /* !! */ ;
                    }
                    if ((var2_3 /* !! */  = var1_1 /* !! */ .getAppProperty("ChannelSecond")) != null) {
                        ag.b = var2_3 /* !! */ ;
                    }
                    if ((var2_3 /* !! */  = var1_1 /* !! */ .getAppProperty("InterChannel")) != null) {
                        ag.d = var2_3 /* !! */ ;
                    }
                    if ((var2_3 /* !! */  = var1_1 /* !! */ .getAppProperty("Term")) != null) {
                        ag.c = var2_3 /* !! */ ;
                    }
                    if ((var2_3 /* !! */  = var1_1 /* !! */ .getAppProperty("QQ")) != null) {
                        ag.e = var2_3 /* !! */ ;
                    }
                    var1_1 /* !! */ .getAppProperty("GameCenterName");
                    var1_1 /* !! */ .getAppProperty("GameCenterUrl");
                    ag.a(var1_1 /* !! */ .getAppProperty("FreeCode"));
                    ag.a(var1_1 /* !! */ .getAppProperty("FreeDest"));
                    var2_3 /* !! */  = ag.a(var1_1 /* !! */ .getAppProperty("SmsCode1"));
                    var3_8 = ag.a(var1_1 /* !! */ .getAppProperty("SmsCode2"));
                    var4_14 = ag.a(var1_1 /* !! */ .getAppProperty("SmsDest1"));
                    var5_15 = ag.a(var1_1 /* !! */ .getAppProperty("SmsDest2"));
                    ag.a[0] = ag.a((String)var2_3 /* !! */ , ";");
                    ag.a[1] = ag.a(var3_8, ";");
                    ag.b[0] = ag.a(var4_14, ";");
                    ag.b[1] = ag.a(var5_15, ";");
                    var2_3 /* !! */  = var1_1 /* !! */ .getAppProperty("LogoLinkReco");
                    var2_3 /* !! */  = ag.a((String)var2_3 /* !! */ , ";");
                    var3_9 = 0;
                    if (true) ** GOTO lbl37
                    do {
                        ag.a[var3_9] = ag.a(var2_3 /* !! */ [var3_9]);
                        ++var3_9;
lbl37:
                        // 2 sources

                        if (var2_3 /* !! */  != null) {
                            if (var2_3 /* !! */ .length > 3) {
                                v0 = 3;
                                continue;
                            }
                            v0 = var2_3 /* !! */ .length;
                            continue;
                        }
                        v0 = 0;
                    } while (var3_9 < v0);
                    var3_10 = var1_1 /* !! */ .getAppProperty("FeeMode");
                    if (var3_10 != null) {
                        ag.a = ag.a(var3_10);
                    }
                    var2_3 /* !! */  = ag.a(var1_1 /* !! */ .getAppProperty("DoCode"));
                    var1_1 /* !! */  = ag.a(var1_1 /* !! */ .getAppProperty("DoDest"));
                    ag.c[0] = ag.a((String)var2_3 /* !! */ , ";");
                    ag.d[0] = ag.a((String)var1_1 /* !! */ , ";");
                    break block55;
                }
                catch (NullPointerException v1) {
                    var2_4 = v1;
                    v1.printStackTrace();
                    var2_5 = 1;
                    if (ag.a[0] == null || ag.b[0] == null) {
                        var2_5 = 0;
                    } else if (ag.a[0].length != ag.b[0].length) {
                        var2_5 = 0;
                    }
                    if (var2_5 == 0) {
                        ag.a[0] = null;
                        ag.b[0] = null;
                        ag.a[0] = new String[2];
                        ag.b[0] = new String[2];
                        ag.a[0][0] = "62";
                        ag.a[0][1] = "63";
                        ag.b[0][0] = "106662267";
                        ag.b[0][1] = "106662269";
                    }
                    var2_5 = 1;
                    if (ag.a[1] == null || ag.b[1] == null) {
                        var2_5 = 0;
                    } else if (ag.a[1].length != ag.b[1].length) {
                        var2_5 = 0;
                    }
                    if (var2_5 == 0) {
                        ag.a[1] = null;
                        ag.b[1] = null;
                        ag.a[1] = new String[1];
                        ag.b[1] = new String[1];
                        ag.a[1][0] = "JG";
                        ag.b[1][0] = "1066170073";
                    }
                    var2_5 = 1;
                    if (ag.c[0] == null || ag.d[0] == null) {
                        var2_5 = 0;
                    } else if (ag.c[0].length != ag.d[0].length) {
                        var2_5 = 0;
                    }
                    if (var2_5 == 0) {
                        ag.c[0] = null;
                        ag.d[0] = null;
                        this.a();
                    }
                    var2_5 = 0;
                    ** while (var2_5 < 2)
                }
            }
            catch (Throwable var1_2) {
                var2_6 = 1;
                if (ag.a[0] == null || ag.b[0] == null) {
                    var2_6 = 0;
                } else if (ag.a[0].length != ag.b[0].length) {
                    var2_6 = 0;
                }
                if (var2_6 == 0) {
                    ag.a[0] = null;
                    ag.b[0] = null;
                    ag.a[0] = new String[2];
                    ag.b[0] = new String[2];
                    ag.a[0][0] = "62";
                    ag.a[0][1] = "63";
                    ag.b[0][0] = "106662267";
                    ag.b[0][1] = "106662269";
                }
                var2_6 = 1;
                if (ag.a[1] == null || ag.b[1] == null) {
                    var2_6 = 0;
                } else if (ag.a[1].length != ag.b[1].length) {
                    var2_6 = 0;
                }
                if (var2_6 == 0) {
                    ag.a[1] = null;
                    ag.b[1] = null;
                    ag.a[1] = new String[1];
                    ag.b[1] = new String[1];
                    ag.a[1][0] = "JG";
                    ag.b[1][0] = "1066170073";
                }
                var2_6 = 1;
                if (ag.c[0] == null || ag.d[0] == null) {
                    var2_6 = 0;
                } else if (ag.c[0].length != ag.d[0].length) {
                    var2_6 = 0;
                }
                if (var2_6 == 0) {
                    ag.c[0] = null;
                    ag.d[0] = null;
                    this.a();
                }
                var2_6 = 0;
                ** while (var2_6 < 2)
            }
lbl-1000:
            // 1 sources

            {
                ag.a[var2_5] = new int[ag.a[var2_5].length];
                var3_11 = 0;
                while (var3_11 < ag.a[var2_5].length) {
                    ag.a[var2_5][var3_11] = 0;
                    ++var3_11;
                }
                ++var2_5;
                continue;
            }
lbl104:
            // 1 sources

            return;
lbl-1000:
            // 1 sources

            {
                ag.a[var2_6] = new int[ag.a[var2_6].length];
                var3_12 = 0;
                while (var3_12 < ag.a[var2_6].length) {
                    ag.a[var2_6][var3_12] = 0;
                    ++var3_12;
                }
                ++var2_6;
                continue;
            }
lbl154:
            // 1 sources

            throw var1_2;
        }
        var2_7 = 1;
        if (ag.a[0] == null || ag.b[0] == null) {
            var2_7 = 0;
        } else if (ag.a[0].length != ag.b[0].length) {
            var2_7 = 0;
        }
        if (var2_7 == 0) {
            ag.a[0] = null;
            ag.b[0] = null;
            ag.a[0] = new String[2];
            ag.b[0] = new String[2];
            ag.a[0][0] = "62";
            ag.a[0][1] = "63";
            ag.b[0][0] = "106662267";
            ag.b[0][1] = "106662269";
        }
        var2_7 = 1;
        if (ag.a[1] == null || ag.b[1] == null) {
            var2_7 = 0;
        } else if (ag.a[1].length != ag.b[1].length) {
            var2_7 = 0;
        }
        if (var2_7 == 0) {
            ag.a[1] = null;
            ag.b[1] = null;
            ag.a[1] = new String[1];
            ag.b[1] = new String[1];
            ag.a[1][0] = "JG";
            ag.b[1][0] = "1066170073";
        }
        var2_7 = 1;
        if (ag.c[0] == null || ag.d[0] == null) {
            var2_7 = 0;
        } else if (ag.c[0].length != ag.d[0].length) {
            var2_7 = 0;
        }
        if (var2_7 == 0) {
            ag.c[0] = null;
            ag.d[0] = null;
            this.a();
        }
        var2_7 = 0;
        while (var2_7 < 2) {
            ag.a[var2_7] = new int[ag.a[var2_7].length];
            var3_13 = 0;
            while (var3_13 < ag.a[var2_7].length) {
                ag.a[var2_7][var3_13] = 0;
                ++var3_13;
            }
            ++var2_7;
        }
    }

    public static String[] a(int n2) {
        if (n2 != 1 && n2 != 2) {
            n2 = 2;
        }
        int n3 = 0;
        int n4 = 100000;
        boolean bl2 = true;
        int n5 = 0;
        while (n5 < a[n2 - 1].length) {
            if (a[n2 - 1][n5] <= n4) {
                n3 = n5;
                n4 = a[n2 - 1][n5];
            }
            if (a[n2 - 1][n5] != 0) {
                bl2 = false;
            }
            ++n5;
        }
        if (bl2) {
            Random random = new Random();
            n3 = Math.abs(random.nextInt()) % 100 % a[n2 - 1].length;
            System.out.println("Random minId :" + n3);
        }
        if (n3 < 0 || n3 >= a[n2 - 1].length) {
            n3 = 0;
        }
        String[] stringArray = new String[2];
        String[] stringArray2 = stringArray;
        stringArray[0] = a[n2 - 1][n3];
        stringArray2[1] = b[n2 - 1][n3];
        int[] nArray = a[n2 - 1];
        int n6 = n3;
        nArray[n6] = nArray[n6] + 1;
        return stringArray2;
    }

    public static String a() {
        return a;
    }

    public static String b() {
        return b;
    }

    public static String c() {
        return c;
    }

    public static String d() {
        return d;
    }

    public static String e() {
        return e;
    }

    public static int a() {
        return a;
    }

    public final String[] a(int n2, int n3) {
        if (n2 == 0) {
            return null;
        }
        try {
            if (c[0] != null && --n2 >= 0 && n2 < c[0].length) {
                if (c[0][n2] != null && d[0][n2] != null && c[0][n2].length() > 0 && d[0][n2].length() > 0) {
                    String[] stringArray = new String[2];
                    String[] stringArray2 = stringArray;
                    stringArray[0] = c[0][n2];
                    stringArray2[1] = d[0][n2];
                    return stringArray2;
                }
                return this.b(n2, n3);
            }
            return this.b(n2, n3);
        }
        catch (Exception exception) {
            return null;
        }
    }

    private String[] b(int n2, int n3) {
        String string = Integer.toString(n3);
        return ag.a(n2, string);
    }
}

