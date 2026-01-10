package com.java.loader.applet;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/* loaded from: Vene.jar:com/java/loader/applet/o.class */
final class o implements ActionListener {
    o(d dVar) {
    }

    public final void actionPerformed(ActionEvent actionEvent) {
        if (JOptionPane.showConfirmDialog((Component) null, "Are you sure you would like to destruct?", "Destruct", 0) == 0) {
            System.exit(69);
        }
    }
}
