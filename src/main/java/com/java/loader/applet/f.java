package com.java.loader.applet;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* loaded from: Vene.jar:com/java/loader/applet/f.class */
final class f implements MouseListener {
    private JFrame a;

    /* renamed from: a, reason: collision with other field name */
    private /* synthetic */ d f8a;

    /* renamed from: a, reason: collision with other field name */
    private final /* synthetic */ JLabel f9a;

    f(d dVar, JLabel jLabel) {
        this.f8a = dVar;
        this.f9a = jLabel;
    }

    public final void mouseReleased(MouseEvent mouseEvent) {
    }

    public final void mousePressed(MouseEvent mouseEvent) {
    }

    public final void mouseExited(MouseEvent mouseEvent) {
        this.a.setVisible(false);
        this.a.dispose();
    }

    public final void mouseEntered(MouseEvent mouseEvent) {
        this.a = new JFrame();
        this.a.setType(Window.Type.UTILITY);
        this.a.setBackground(new Color(66, 69, 74));
        this.a.getContentPane().setBackground(new Color(66, 69, 74));
        this.a.setUndecorated(true);
        this.a.setLocation(this.f9a.getLocationOnScreen().x + 15, this.f9a.getLocationOnScreen().y + 10);
        this.a.setSize(395, 85);
        this.a.getContentPane().setLayout((LayoutManager) null);
        JLabel jLabel = new JLabel("<html><b color=\"red\"><i>Currently disabled</b></i><br>While autoclicking, VeneClicker will simulate mouse movements for the user.<br><br><code><span bgcolor=\"#6A6D72\">|X-Axis|</span></code> The absolute value of the x-axis jitter range. -x &lt;= val &lt;= x<br><code><span bgcolor=\"#6A6D72\">|Y-Axis|</span></code> The absolute value of the y-axis jitter range. -y &lt;= val &lt;= y</html>");
        jLabel.setFont(this.f8a.c);
        jLabel.setBounds(5, 5, 385, 75);
        jLabel.setForeground(new Color(42, 172, 255));
        jLabel.setBorder(BorderFactory.createEmptyBorder());
        this.a.getContentPane().add(jLabel);
        this.a.setVisible(true);
    }

    public final void mouseClicked(MouseEvent mouseEvent) {
    }
}
