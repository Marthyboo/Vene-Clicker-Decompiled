package com.java.loader.applet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/* loaded from: Vene.jar:com/java/loader/applet/n.class */
final class n implements com.java.loader.f {
    private /* synthetic */ d a;

    /* renamed from: a, reason: collision with other field name */
    private final /* synthetic */ JLabel f12a;

    n(d dVar, JLabel jLabel) {
        this.a = dVar;
        this.f12a = jLabel;
    }

    @Override // com.java.loader.f
    public final void a(boolean z) {
        if (z) {
            this.f12a.setIcon(new ImageIcon(this.a.f5b));
        } else {
            this.f12a.setIcon(new ImageIcon(this.a.f4a));
        }
    }
}
