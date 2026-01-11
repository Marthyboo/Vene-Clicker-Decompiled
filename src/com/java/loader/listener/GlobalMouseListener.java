package com.java.loader.listener;

import com.java.loader.ClickThread;
import com.java.loader.state.VeneState;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public final class GlobalMouseListener implements NativeMouseListener {
    private ClickThread clickThread;
    private boolean isPressed = false;

    public GlobalMouseListener() {
        this.clickThread = new ClickThread(false);
        this.clickThread.start();
    }

    @Override
    public final void nativeMousePressed(NativeMouseEvent e) {
        // Button 1 is Left Click
        if (e.getButton() == 1 && System.currentTimeMillis() - this.clickThread.getLastClickTime() <= 20L) {        
            this.isPressed = true;
            return;
        }
        if (e.getButton() == 1 && VeneState.isActive()) {
            this.clickThread.setRunning(true);
            this.isPressed = true;
        }
    }

    @Override
    public final void nativeMouseReleased(NativeMouseEvent e) {
        if (e.getButton() == 1 && this.isPressed) {
            this.isPressed = false;
            return;
        }
        if (e.getButton() == 1) {
            this.clickThread.setRunning(false);
        }
    }

    @Override
    public final void nativeMouseClicked(NativeMouseEvent e) {
    }
}
