package com.java.loader.hooks;

import com.java.loader.c;
import java.util.ArrayList;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/* loaded from: Vene.jar:com/java/loader/a/a.class */
public final class a implements NativeKeyListener {
    private ArrayList a = new ArrayList();

    @Override // org.jnativehook.keyboard.NativeKeyListener
    public final void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        boolean z = this.a.contains(Integer.valueOf(nativeKeyEvent.getKeyCode())) && c.f22a.contains(Integer.valueOf(nativeKeyEvent.getKeyCode()));
        this.a.add(Integer.valueOf(nativeKeyEvent.getKeyCode()));
        if (!this.a.containsAll(c.f22a) || !c.f22a.contains(Integer.valueOf(nativeKeyEvent.getKeyCode())) || c.f19c || z) {
            return;
        }
        c.a(!c.m9a());
    }

    @Override // org.jnativehook.keyboard.NativeKeyListener
    public final void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        while (this.a.contains(new Integer(nativeKeyEvent.getKeyCode()))) {
            this.a.remove(new Integer(nativeKeyEvent.getKeyCode()));
        }
    }

    @Override // org.jnativehook.keyboard.NativeKeyListener
    public final void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
    }
}
