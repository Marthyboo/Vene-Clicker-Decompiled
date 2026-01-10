package com.java.loader.applet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;

/* loaded from: Vene.jar:com/java/loader/applet/h.class */
final class h implements ActionListener {
    private final /* synthetic */ JFormattedTextField a;

    h(d dVar, JFormattedTextField jFormattedTextField) {
        this.a = jFormattedTextField;
    }

    public final void actionPerformed(ActionEvent actionEvent) {
        com.java.loader.c.f = Integer.valueOf(((String) this.a.getValue()).substring(1, 2)).intValue();
        System.out.println(com.java.loader.c.f);
    }
}
