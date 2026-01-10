package com.java.loader.applet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;

/* loaded from: Vene.jar:com/java/loader/applet/j.class */
final class j implements ActionListener {
    private final /* synthetic */ JFormattedTextField a;
    private final /* synthetic */ JFormattedTextField b;

    /* renamed from: a, reason: collision with other field name */
    private final /* synthetic */ a f11a;

    j(d dVar, JFormattedTextField jFormattedTextField, JFormattedTextField jFormattedTextField2, a aVar) {
        this.a = jFormattedTextField;
        this.b = jFormattedTextField2;
        this.f11a = aVar;
    }

    public final void actionPerformed(ActionEvent actionEvent) {
        int iIntValue = ((Number) this.a.getValue()).intValue();
        int iIntValue2 = ((Number) this.b.getValue()).intValue();
        if (iIntValue > iIntValue2 || iIntValue < this.f11a.getMinimum() || iIntValue2 > this.f11a.getMaximum()) {
            return;
        }
        this.f11a.setValue(iIntValue);
        this.f11a.a(iIntValue2);
    }
}
