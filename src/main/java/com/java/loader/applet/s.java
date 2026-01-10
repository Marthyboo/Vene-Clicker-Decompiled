package com.java.loader.applet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

/* loaded from: Vene.jar:com/java/loader/applet/s.class */
final class s implements ActionListener {
    private final /* synthetic */ JCheckBox a;

    s(d dVar, JCheckBox jCheckBox) {
        this.a = jCheckBox;
    }

    public final void actionPerformed(ActionEvent actionEvent) {
        com.java.loader.c.f18b = this.a.isSelected();
    }
}
