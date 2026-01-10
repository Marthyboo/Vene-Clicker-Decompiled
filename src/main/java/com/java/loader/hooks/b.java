package com.java.loader.hooks;

import com.java.loader.c;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

/* loaded from: Vene.jar:com/java/loader/a/b.class */
public final class b implements NativeMouseListener {
    private com.java.loader.b a = new com.java.loader.b(false);

    /* renamed from: a, reason: collision with other field name */
    private boolean f1a;

    public b() {
        this.a.start();
        this.f1a = false;
    }

    @Override // org.jnativehook.mouse.NativeMouseListener
    public final void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
        if (nativeMouseEvent.getButton() == 1 && System.currentTimeMillis() - this.a.a() <= 20) {
            this.f1a = true;
        } else if (nativeMouseEvent.getButton() == 1 && c.m9a()) {
            this.a.a(true);
            this.f1a = true;
        }
    }

    @Override // org.jnativehook.mouse.NativeMouseListener
    public final void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        if (nativeMouseEvent.getButton() == 1 && this.f1a) {
            this.f1a = false;
        } else if (nativeMouseEvent.getButton() == 1) {
            this.a.a(false);
        }
    }

    @Override // org.jnativehook.mouse.NativeMouseListener
    public final void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
    }
}
