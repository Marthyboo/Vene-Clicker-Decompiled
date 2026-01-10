package com.java.loader.applet;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* loaded from: Vene.jar:com/java/loader/applet/r.class */
final class r implements MouseListener {
    private JFrame a;

    /* renamed from: a, reason: collision with other field name */
    private /* synthetic */ d f14a;

    /* renamed from: a, reason: collision with other field name */
    private final /* synthetic */ JLabel f15a;

    r(d dVar, JLabel jLabel) {
        this.f14a = dVar;
        this.f15a = jLabel;
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
        this.a.setLocation(this.f15a.getLocationOnScreen().x + 15, this.f15a.getLocationOnScreen().y + 10);
        this.a.setSize(395, 75);
        this.a.getContentPane().setLayout((LayoutManager) null);
        JLabel jLabel = new JLabel("<html>CPS Drops destroys manual heuristics by occasionally attempting to drop your CPS below the minimum threshold.<br></html>");
        jLabel.setFont(this.f14a.c);
        jLabel.setBounds(5, 5, 385, 65);
        jLabel.setForeground(new Color(42, 172, 255));
        jLabel.setBorder(BorderFactory.createEmptyBorder());
        this.a.getContentPane().add(jLabel);
        this.a.setVisible(true);
    }

    public final void mouseClicked(MouseEvent mouseEvent) {
    }
}
