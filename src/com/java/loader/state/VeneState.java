package com.java.loader.state;

import com.java.loader.listener.StateListener;
import java.util.ArrayList;
import org.jnativehook.keyboard.NativeKeyEvent;

public class VeneState {
    public static int minCps;
    public static int maxCps;
    public static int someConfigValue;
    public static int anotherConfigValue;
    public static int jitterX;
    public static int jitterY;
    public static boolean enabled;
    public static boolean cpsDropsEnabled;
    public static boolean jitterEnabled;
    public static boolean onlyInMinecraft; // derived from c.d if c.d is used that way
    private static boolean active; // derived from c.f (private boolean f)
    public static ArrayList<Integer> keybinds;
    private static StateListener stateListener;
    public static boolean isJar;

    public static String getKeybindString() {
        if (keybinds == null || keybinds.size() == 0) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        while (n < keybinds.size() - 1) {
            stringBuilder.append(NativeKeyEvent.getKeyText(keybinds.get(n))).append(" + ");
            ++n;
        }
        stringBuilder.append(NativeKeyEvent.getKeyText(keybinds.get(keybinds.size() - 1)));
        return stringBuilder.toString();
    }

    public static void setActive(boolean bl) {
        active = bl;
        if (stateListener != null) {
            stateListener.onStateChanged(bl);
        }
    }

    public static boolean isActive() {
        return active;
    }

    public static void setStateListener(StateListener listener) {
        stateListener = listener;
    }

    public static void resetToDefaults() {
        keybinds = new ArrayList<>();
        keybinds.add(33); // F
        minCps = 9;
        maxCps = 12;
        cpsDropsEnabled = true;
        jitterEnabled = true;
        jitterX = 0;
        jitterY = 0;
        enabled = false;
        someConfigValue = 6;
    }
}
