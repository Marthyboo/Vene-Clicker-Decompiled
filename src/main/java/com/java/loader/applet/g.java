package com.java.loader.applet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;

/* loaded from: Vene.jar:com/java/loader/applet/g.class */
final class g implements ActionListener {
    private final /* synthetic */ JFormattedTextField a;

    g(d dVar, JFormattedTextField jFormattedTextField) {
        this.a = jFormattedTextField;
    }

    public final void actionPerformed(ActionEvent actionEvent) {
        com.java.loader.c.e = Integer.valueOf(((String) this.a.getValue()).substring(1, 2)).intValue();
        System.out.println(com.java.loader.c.e);
    }
}
