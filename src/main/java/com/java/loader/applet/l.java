package com.java.loader.applet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* loaded from: Vene.jar:com/java/loader/applet/l.class */
final class l implements ActionListener {
    private /* synthetic */ d a;

    l(d dVar) {
        this.a = dVar;
    }

    public final void actionPerformed(ActionEvent actionEvent) {
        this.a.dispose();
        System.exit(0);
    }
}
