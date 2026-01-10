package com.java.loader.applet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import org.jnativehook.GlobalScreen;

/* loaded from: Vene.jar:com/java/loader/applet/p.class */
final class p implements ActionListener {
    private final /* synthetic */ JToggleButton a;

    p(d dVar, JToggleButton jToggleButton) {
        this.a = jToggleButton;
    }

    public final void actionPerformed(ActionEvent actionEvent) {
        if (!this.a.isSelected()) {
            this.a.setText(com.java.loader.c.a());
            return;
        }
        com.java.loader.c.f19c = true;
        this.a.setText("...");
        GlobalScreen.addNativeKeyListener(new q(this, this.a));
    }
}
