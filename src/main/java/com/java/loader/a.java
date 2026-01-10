package com.java.loader;

import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.AWTException;
import java.security.SecureRandom;
import org.jnativehook.NativeInputEvent;

/* loaded from: Vene.jar:com/java/loader/a.class */
public class a {
    private Robot a;

    public a() throws AWTException {
        this.a = new Robot();
    }

    /* renamed from: a, reason: collision with other field name */
    private long f0a = 0;

    static double a() {
        double d = Double.MAX_VALUE;
        double d2 = Double.MIN_VALUE;
        for (int i = 0; i < 20; i++) {
            double dNanoTime = System.nanoTime();
            new SecureRandom().nextInt();
            double dNanoTime2 = System.nanoTime() - dNanoTime;
            if (dNanoTime2 < d && dNanoTime2 > 0.0d) {
                d = dNanoTime2;
            } else if (dNanoTime2 > d2 && dNanoTime2 > 0.0d) {
                d2 = dNanoTime2;
            }
        }
        String strValueOf = String.valueOf(d2 / d);
        int dotIndex = strValueOf.indexOf(46);
        double dDoubleValue = 0.1d;
        if (dotIndex != -1 && strValueOf.length() > dotIndex + 2) {
             dDoubleValue = Double.valueOf("0." + strValueOf.substring(dotIndex + 2)).doubleValue();
        }
        return dDoubleValue < 0.1d ? a() : dDoubleValue;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m0a() {
        return this.f0a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m1a() {
        this.f0a = System.currentTimeMillis();
        this.a.mousePress(NativeInputEvent.BUTTON3_MASK);
    }

    public void b() {
        this.a.mouseRelease(NativeInputEvent.BUTTON3_MASK);
    }

    public void c() {
        this.f0a = System.currentTimeMillis();
        this.a.mousePress(NativeInputEvent.BUTTON5_MASK);
    }

    public void d() {
        this.a.mouseRelease(NativeInputEvent.BUTTON5_MASK);
    }

    public void a(int i, int i2) {
        int i3 = 0;
        if (i != 0) {
            int iA = (int) (a() * (i + 1));
            i3 = a() > 0.5d ? iA : -iA;
        }
        int i4 = 0;
        if (i2 != 0) {
            int iA2 = (int) (a() * (i2 + 1));
            i4 = a() > 0.5d ? iA2 : -iA2;
        }
        this.a.mouseMove(MouseInfo.getPointerInfo().getLocation().x + i3, MouseInfo.getPointerInfo().getLocation().y + i4);
    }
}