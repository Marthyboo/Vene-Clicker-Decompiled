package com.java.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/* loaded from: Vene.jar:com/java/loader/e.class */
public final class e {
    private static File a;

    /* renamed from: a, reason: collision with other field name */
    private static PrintWriter f25a;

    static {
        a = new File("config.txt");
        if (!a.exists()) {
            try {
                a.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            f25a = new PrintWriter(new FileOutputStream(a, true));
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public static void a() {
        try {
            f25a = new PrintWriter(a, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String str = "";
        if (c.f22a != null && !c.f22a.isEmpty()) {
            for (int i = 0; i < c.f22a.size() - 1; i++) {
                str = String.valueOf(str) + c.f22a.get(i) + ":";
            }
            f25a.print(String.valueOf(String.valueOf(str) + c.f22a.get(c.f22a.size() - 1)) + ",");
        } else {
            f25a.print("33,");
        }
        f25a.print(String.valueOf(c.a) + ",");
        f25a.print(String.valueOf(c.b) + ",");
        f25a.print(String.valueOf(c.f18b) + ",");
        f25a.print(String.valueOf(c.f20d) + ",");
        f25a.print(String.valueOf(c.e) + ",");
        f25a.print(String.valueOf(c.f) + ",");
        f25a.print(String.valueOf(c.f17a) + ",");
        f25a.print(String.valueOf(c.c) + ",");
        f25a.print(c.d);
        f25a.println();
        f25a.flush();
    }

    public static void b() {
        Scanner scanner = null;
        try {
            if (a.exists()) {
                scanner = new Scanner(a, "UTF-8");
            }
        } catch (FileNotFoundException unused) {
        }
        
        if (scanner != null && scanner.hasNextLine()) {
            String strNextLine = scanner.nextLine();
            if (strNextLine != null && !strNextLine.isEmpty()) {
                String[] strArrSplit = strNextLine.split(",");
                try {
                    if (strArrSplit.length > 0) {
                        if (strArrSplit[0].contains(":")) {
                            for (String str : strArrSplit[0].split(":")) {
                                c.f22a.add(Integer.valueOf(Integer.parseInt(str)));
                            }
                        } else if (!strArrSplit[0].isEmpty()) {
                            c.f22a.add(Integer.valueOf(Integer.parseInt(strArrSplit[0])));
                        }
                    }
                    if (strArrSplit.length >= 10) {
                        c.a = Integer.parseInt(strArrSplit[1]);
                        c.b = Integer.parseInt(strArrSplit[2]);
                        c.f18b = Boolean.parseBoolean(strArrSplit[3]);
                        c.f20d = Boolean.parseBoolean(strArrSplit[4]);
                        c.e = Integer.parseInt(strArrSplit[5]);
                        c.f = Integer.parseInt(strArrSplit[6]);
                        c.f17a = Boolean.parseBoolean(strArrSplit[7]);
                        c.c = Integer.parseInt(strArrSplit[8]);
                        c.d = Integer.parseInt(strArrSplit[9]);
                    } else {
                        c.m10a();
                    }
                } catch (Exception unused2) {
                    c.m10a();
                }
            } else {
                c.m10a();
            }
            scanner.close();
        } else {
            c.m10a();
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
