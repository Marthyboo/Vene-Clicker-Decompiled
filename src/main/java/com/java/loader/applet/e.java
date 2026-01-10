package com.java.loader.applet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/* loaded from: Vene.jar:com/java/loader/applet/e.class */
final class e implements MouseMotionListener {
    private /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void mouseMoved(MouseEvent mouseEvent) {
    }

    public final void mouseDragged(MouseEvent mouseEvent) {
        this.a.setLocation(mouseEvent.getXOnScreen() - this.a.a, mouseEvent.getYOnScreen() - this.a.b);
    }
}
