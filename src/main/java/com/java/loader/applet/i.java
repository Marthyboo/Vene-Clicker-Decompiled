package com.java.loader.applet;

import javax.swing.JFormattedTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* loaded from: Vene.jar:com/java/loader/applet/i.class */
final class i implements ChangeListener {
    private final /* synthetic */ JFormattedTextField a;

    /* renamed from: a, reason: collision with other field name */
    private final /* synthetic */ a f10a;
    private final /* synthetic */ JFormattedTextField b;

    i(d dVar, JFormattedTextField jFormattedTextField, a aVar, JFormattedTextField jFormattedTextField2) {
        this.a = jFormattedTextField;
        this.f10a = aVar;
        this.b = jFormattedTextField2;
    }

    public final void stateChanged(ChangeEvent changeEvent) {
        JFormattedTextField jFormattedTextField = this.a;
        int value = this.f10a.getValue();
        com.java.loader.c.a = value;
        jFormattedTextField.setValue(Integer.valueOf(value));
        JFormattedTextField jFormattedTextField2 = this.b;
        int iA = this.f10a.a();
        com.java.loader.c.b = iA;
        jFormattedTextField2.setValue(Integer.valueOf(iA));
    }
}
