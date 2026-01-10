package com.java.loader.applet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/* loaded from: Vene.jar:com/java/loader/applet/k.class */
final class k implements MouseListener {
    private /* synthetic */ d a;

    k(d dVar) {
        this.a = dVar;
    }

    public final void mouseClicked(MouseEvent mouseEvent) {
    }

    public final void mousePressed(MouseEvent mouseEvent) {
        this.a.a = mouseEvent.getX();
        this.a.b = mouseEvent.getY();
    }

    public final void mouseReleased(MouseEvent mouseEvent) {
    }

    public final void mouseEntered(MouseEvent mouseEvent) {
    }

    public final void mouseExited(MouseEvent mouseEvent) {
    }
}
