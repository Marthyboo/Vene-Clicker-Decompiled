package com.java.loader.applet;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JToggleButton;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/* loaded from: Vene.jar:com/java/loader/applet/q.class */
final class q implements NativeKeyListener {
    private ArrayList a = new ArrayList();

    /* renamed from: a, reason: collision with other field name */
    private final /* synthetic */ JToggleButton f13a;

    q(p pVar, JToggleButton jToggleButton) {
        this.f13a = jToggleButton;
    }

    @Override // org.jnativehook.keyboard.NativeKeyListener
    public final void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
    }

    @Override // org.jnativehook.keyboard.NativeKeyListener
    public final void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        com.java.loader.c.f22a.clear();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (!arrayList.contains(num)) {
                arrayList.add(num);
            }
        }
        com.java.loader.c.f22a.addAll(arrayList);
        this.f13a.setText(com.java.loader.c.a());
        this.f13a.setSelected(false);
        GlobalScreen.removeNativeKeyListener(this);
        com.java.loader.c.f19c = false;
    }

    @Override // org.jnativehook.keyboard.NativeKeyListener
    public final void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        this.a.add(Integer.valueOf(nativeKeyEvent.getKeyCode()));
    }
}
