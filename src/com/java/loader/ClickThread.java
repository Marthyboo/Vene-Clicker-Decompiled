package com.java.loader;

import com.java.loader.utils.MouseUtils;
import com.java.loader.state.VeneState;
import java.awt.AWTException;

public final class ClickThread extends Thread {
    private MouseUtils mouseUtils;
    private boolean running = false;
    private boolean rightClick = false;

    public ClickThread(boolean rightClick) {
        this.rightClick = rightClick;
        try {
            this.mouseUtils = new MouseUtils();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public final void run() {
        while (true) {
            sleepMillis(1L);
            if (!this.running) continue;

            int currentMinCps = VeneState.cpsDropsEnabled ? (MouseUtils.getRandomDouble() > 0.7 ? (int)((double)VeneState.minCps * 0.75) : VeneState.minCps) : VeneState.minCps;
            
            // Randomize delay between 1000/maxCps and 1000/minCps
            int range = 1000 / currentMinCps - 1000 / VeneState.maxCps + 1;
            long totalDelay = (int)(MouseUtils.getRandomDouble() * (double)range) + 1000 / VeneState.maxCps;
            
            // Split delay into press and release
            long pressDelay = (int)(MouseUtils.getRandomDouble() * 11.0) + 30;
            long releaseDelay = totalDelay - pressDelay;

            sleepMillis(pressDelay);
            if (this.rightClick) {
                this.mouseUtils.rightClickRelease();
            } else {
                this.mouseUtils.leftClickRelease();
            }

            sleepMillis(releaseDelay);
            if (!this.running) continue;

            if (this.rightClick) {
                this.mouseUtils.rightClickPress();
            } else {
                this.mouseUtils.leftClickPress();
            }

            if (VeneState.jitterX != 0 || VeneState.jitterY != 0) {
                this.mouseUtils.applyJitter(VeneState.jitterX, VeneState.jitterY);
            }
        }
    }

    public final long getLastClickTime() {
        return this.mouseUtils.getLastClickTime();
    }

    private static void sleepMillis(long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public final void setRunning(boolean running) {
        this.running = running;
    }
}
