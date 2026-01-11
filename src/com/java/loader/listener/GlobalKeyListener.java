package com.java.loader.listener;

import com.java.loader.state.VeneState;
import java.util.ArrayList;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public final class GlobalKeyListener implements NativeKeyListener {
    private ArrayList<Integer> pressedKeys = new ArrayList<>();

    @Override
    public final void nativeKeyPressed(NativeKeyEvent e) {
        boolean alreadyPressed = this.pressedKeys.contains(e.getKeyCode()) && VeneState.keybinds.contains(e.getKeyCode());
        this.pressedKeys.add(e.getKeyCode());
        
        if (this.pressedKeys.containsAll(VeneState.keybinds) && VeneState.keybinds.contains(e.getKeyCode()) && !VeneState.enabled && !alreadyPressed) {
            VeneState.setActive(!VeneState.isActive());
        }
    }

    @Override
    public final void nativeKeyReleased(NativeKeyEvent e) {
        while (this.pressedKeys.contains(e.getKeyCode())) {
            this.pressedKeys.remove((Integer)e.getKeyCode());
        }
    }

    @Override
    public final void nativeKeyTyped(NativeKeyEvent e) {
    }
}
