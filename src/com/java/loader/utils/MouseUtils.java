package com.java.loader.utils;

import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.AWTException;
import java.security.SecureRandom;

public class MouseUtils {
    private Robot robot;
    private long lastClickTime = 0L;

    public MouseUtils() throws AWTException {
        this.robot = new Robot();
    }

    public static double getRandomDouble() {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        int n = 0;
        while (n < 20) {
            double start = System.nanoTime();
            new SecureRandom().nextInt();
            double end = System.nanoTime();
            double diff = end - start;
            if (diff < min && diff > 0.0) {
                min = diff;
            } else if (diff > max && diff > 0.0) {
                max = diff;
            }
            ++n;
        }
        String string = String.valueOf(max / min);
        double result = Double.parseDouble("0." + string.substring(string.indexOf('.') + 2));
        if (result < 0.1) {
            return getRandomDouble();
        }
        return result;
    }

    public long getLastClickTime() {
        return this.lastClickTime;
    }

    public void leftClickPress() {
        this.lastClickTime = System.currentTimeMillis();
        this.robot.mousePress(1024); // InputEvent.BUTTON1_MASK
    }

    public void leftClickRelease() {
        this.robot.mouseRelease(1024);
    }

    public void rightClickPress() {
        this.lastClickTime = System.currentTimeMillis();
        this.robot.mousePress(4096); // InputEvent.BUTTON3_MASK
    }

    public void rightClickRelease() {
        this.robot.mouseRelease(4096);
    }

    public void applyJitter(int jitterX, int jitterY) {
        int offsetX = 0;
        if (jitterX != 0) {
            offsetX = (int)(getRandomDouble() * (double)(++jitterX));
            offsetX = getRandomDouble() > 0.5 ? offsetX : -offsetX;
        }
        int offsetY = 0;
        if (jitterY != 0) {
            offsetY = jitterY + 1;
            offsetY = (int)(getRandomDouble() * (double)offsetY);
            offsetY = getRandomDouble() > 0.5 ? offsetY : -offsetY;
        }
        this.robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x + offsetX, MouseInfo.getPointerInfo().getLocation().y + offsetY);
    }
}
