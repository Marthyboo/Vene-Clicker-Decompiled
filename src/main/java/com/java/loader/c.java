package com.java.loader;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;

/* loaded from: Vene.jar:com/java/loader/c.class */
public class c {
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static int f;

    /* renamed from: a, reason: collision with other field name */
    public static boolean f17a;

    /* renamed from: b, reason: collision with other field name */
    public static boolean f18b;

    /* renamed from: c, reason: collision with other field name */
    public static boolean f19c;

    /* renamed from: d, reason: collision with other field name */
    public static boolean f20d;

    /* renamed from: f, reason: collision with other field name */
    private static boolean f21f;

    /* renamed from: a, reason: collision with other field name */
    public static ArrayList f22a;

    /* renamed from: a, reason: collision with other field name */
    private static f f23a;

    /* renamed from: e, reason: collision with other field name */
    public static boolean f24e;

    public c() throws SecurityException {
        f24e = !com.java.loader.c.class.getResource("c.class").toString().startsWith("file:");
        Runtime.getRuntime().addShutdownHook(new Thread(new com.java.loader.d(this)));
        f22a = new ArrayList();
        com.java.loader.e.b();
        f19c = false;
        new com.java.loader.applet.d().setVisible(true);
        LogManager.getLogManager().reset();
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e2) {
            e2.printStackTrace();
        }
        GlobalScreen.addNativeMouseListener(new com.java.loader.hooks.b());
        GlobalScreen.addNativeKeyListener(new com.java.loader.hooks.a());
    }

    public static String a() {
        if (f22a == null || f22a.size() == 0) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < f22a.size() - 1; i++) {
            sb.append(String.valueOf(NativeKeyEvent.getKeyText(((Integer) f22a.get(i)).intValue())) + " + ");
        }
        sb.append(NativeKeyEvent.getKeyText(((Integer) f22a.get(f22a.size() - 1)).intValue()));
        return sb.toString();
    }

    public static void a(boolean z) {
        f21f = z;
        if (f23a != null) {
            f23a.a(z);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m9a() {
        return f21f;
    }

    public static void a(f fVar) {
        f23a = fVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m10a() {
        ArrayList arrayList = new ArrayList();
        f22a = arrayList;
        arrayList.add(33);
        a = 9;
        b = 12;
        f18b = true;
        f20d = true;
        e = 0;
        f = 0;
        f17a = false;
        c = 6;
        d = 9;
        com.java.loader.e.a();
    }
}
