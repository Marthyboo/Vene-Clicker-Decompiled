package com.java.loader.applet;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import org.jnativehook.keyboard.NativeKeyEvent;

/* loaded from: Vene.jar:com/java/loader/applet/d.class */
public final class d extends JFrame {
    int a = 0;
    int b = 0;

    /* renamed from: a, reason: collision with other field name */
    BufferedImage f4a;

    /* renamed from: b, reason: collision with other field name */
    BufferedImage f5b;

    /* renamed from: a, reason: collision with other field name */
    Font f6a;

    /* renamed from: b, reason: collision with other field name */
    Font f7b;
    Font c;

    public d() {
        this.f6a = null;
        this.f7b = null;
        this.c = null;
        setTitle("VeneClicker");
        setBounds(100, 100, 297, 322);
        setDefaultCloseOperation(3);
        getContentPane().setLayout((LayoutManager) null);
        setUndecorated(true);
        setResizable(false);
        setBackground(new Color(46, 49, 54));
        getContentPane().setBackground(new Color(46, 49, 54));
        addMouseMotionListener(new e(this));
        addMouseListener(new k(this));
        BufferedImage bufferedImageA = a("/res/button.png");
        BufferedImage bufferedImageA2 = a("/res/x.png");
        BufferedImage bufferedImageA3 = a("/res/min.png");
        BufferedImage bufferedImageA4 = a("/res/checkbox.png");
        BufferedImage bufferedImageA5 = a("/res/checkbox_checked.png");
        BufferedImage bufferedImageA6 = a("/res/button_active.png");
        this.f4a = a("/res/logo.png");
        this.f5b = a("/res/logo_active.png");
        BufferedImage bufferedImageA7 = a("/res/settings.png");
        BufferedImage bufferedImageA8 = a("/res/destruct.png");
        try {
            if (com.java.loader.c.f24e) {
                this.f6a = Font.createFont(0, getClass().getResourceAsStream("/Lato-Regular.ttf")).deriveFont(13.0f);
                this.f7b = Font.createFont(0, getClass().getResourceAsStream("/Lato-Regular.ttf")).deriveFont(16.0f);
                this.c = Font.createFont(0, getClass().getResourceAsStream("/Lato-Regular.ttf")).deriveFont(11.0f);
            } else {
                this.f6a = Font.createFont(0, new File("Lato-Regular.ttf")).deriveFont(13.0f);
                this.f7b = Font.createFont(0, new File("Lato-Regular.ttf")).deriveFont(16.0f);
                this.c = Font.createFont(0, new File("Lato-Regular.ttf")).deriveFont(11.0f);
            }
            GraphicsEnvironment localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            if (com.java.loader.c.f24e) {
                localGraphicsEnvironment.registerFont(Font.createFont(0, getClass().getResourceAsStream("/Lato-Regular.ttf")));
            } else {
                localGraphicsEnvironment.registerFont(Font.createFont(0, new File("Lato-Regular.ttf")));
            }
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        JPanel jPanel = new JPanel();
        jPanel.setBounds(5, 5, 50, 15);
        getContentPane().add(jPanel);
        jPanel.setLayout((LayoutManager) null);
        jPanel.setOpaque(false);
        JButton jButton = new JButton(new ImageIcon(bufferedImageA2));
        jButton.addActionListener(new l(this));
        jButton.setBorder(BorderFactory.createEmptyBorder());
        jButton.setBounds(0, 0, 15, 15);
        jButton.setOpaque(false);
        jButton.setContentAreaFilled(false);
        jButton.setBorderPainted(false);
        jPanel.add(jButton);
        JButton jButton2 = new JButton(new ImageIcon(bufferedImageA3));
        jButton2.addActionListener(new m(this));
        jButton2.setBorder(BorderFactory.createEmptyBorder());
        jButton2.setBounds(20, 0, 15, 15);
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jPanel.add(jButton2);
        JLabel jLabel = new JLabel(new ImageIcon(this.f4a));
        jLabel.setBounds(272, 5, 21, 21);
        getContentPane().add(jLabel);
        com.java.loader.c.a(new n(this, jLabel));
        JPanel jPanel2 = new JPanel();
        jPanel2.setBounds(5, 28, 288, 64);
        getContentPane().add(jPanel2);
        jPanel2.setLayout((LayoutManager) null);
        jPanel2.setOpaque(false);
        JButton jButton3 = new JButton(new ImageIcon(bufferedImageA8));
        jButton3.setBounds((jPanel2.getWidth() / 2) - 74, 0, 64, 64);
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setBorderPainted(false);
        jButton3.setToolTipText("Self-destruct");
        jPanel2.add(jButton3);
        jButton3.addActionListener(new o(this));
        JButton jButton4 = new JButton(new ImageIcon(bufferedImageA7));
        jButton4.setBounds((jPanel2.getWidth() / 2) + 10, 0, 64, 64);
        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setBorderPainted(false);
        jButton4.setToolTipText("Settings");
        jPanel2.add(jButton4);
        JPanel jPanel3 = new JPanel();
        jPanel3.setBounds(5, 96, 288, 218);
        jPanel3.setOpaque(false);
        getContentPane().add(jPanel3);
        jPanel3.setLayout((LayoutManager) null);
        JLabel jLabel2 = new JLabel("Toggle Button");
        this.f6a.deriveFont(13.0f);
        jLabel2.setFont(this.f6a);
        jLabel2.setFont(new Font("Lato", 0, 13));
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setBounds(6, 11, NativeKeyEvent.VC_F20, 16);
        jPanel3.add(jLabel2);
        JToggleButton jToggleButton = new JToggleButton(new ImageIcon(bufferedImageA));
        jToggleButton.setSelectedIcon(new ImageIcon(bufferedImageA6));
        jToggleButton.setBounds(179, 8, NativeKeyEvent.VC_F20, 19);
        jToggleButton.setOpaque(false);
        jToggleButton.setContentAreaFilled(false);
        jToggleButton.setBorderPainted(false);
        jToggleButton.setBorder(BorderFactory.createEmptyBorder());
        jToggleButton.setFont(this.f6a);
        jToggleButton.setText(com.java.loader.c.a());
        jToggleButton.setHorizontalTextPosition(0);
        jToggleButton.setVerticalTextPosition(0);
        jToggleButton.addActionListener(new p(this, jToggleButton));
        jPanel3.add(jToggleButton);
        JLabel jLabel3 = new JLabel("Only in Minecraft");
        jLabel3.setFont(this.f6a);
        jLabel3.setForeground(Color.WHITE);
        jLabel3.setFont(this.f6a);
        jLabel3.setBounds(6, 39, 157, 16);
        jPanel3.add(jLabel3);
        JCheckBox jCheckBox = new JCheckBox("");
        jCheckBox.setIcon(new ImageIcon(bufferedImageA4));
        jCheckBox.setSelectedIcon(new ImageIcon(bufferedImageA5));
        jCheckBox.setBounds(254, 39, 28, 16);
        jCheckBox.setOpaque(false);
        jCheckBox.setContentAreaFilled(false);
        jCheckBox.setBorderPainted(false);
        jPanel3.add(jCheckBox);
        JLabel jLabel4 = new JLabel("CPS Drops");
        jLabel4.setFont(this.f6a);
        jLabel4.setForeground(Color.WHITE);
        jLabel4.setBounds(6, 67, 80, 16);
        jPanel3.add(jLabel4);
        JLabel jLabel5 = new JLabel("[?]");
        jLabel5.setFont(this.f6a);
        jLabel5.setBounds(73, 67, 14, 16);
        jPanel3.add(jLabel5);
        jLabel5.setForeground(new Color(200, 200, 200));
        jLabel5.addMouseListener(new r(this, jLabel5));
        JCheckBox jCheckBox2 = new JCheckBox("");
        jCheckBox2.setSelected(com.java.loader.c.f18b);
        jCheckBox2.setIcon(new ImageIcon(bufferedImageA4));
        jCheckBox2.setSelectedIcon(new ImageIcon(bufferedImageA5));
        jCheckBox2.setOpaque(false);
        jCheckBox2.setContentAreaFilled(false);
        jCheckBox2.setBorderPainted(false);
        jCheckBox2.setBounds(254, 67, 28, 16);
        jCheckBox2.addActionListener(new s(this, jCheckBox2));
        jPanel3.add(jCheckBox2);
        JLabel jLabel6 = new JLabel("Jitter");
        this.f6a.deriveFont(13.0f);
        jLabel6.setFont(this.f6a);
        jLabel6.setForeground(Color.WHITE);
        jLabel6.setBounds(6, 95, 184, 16);
        jPanel3.add(jLabel6);
        JLabel jLabel7 = new JLabel("[?]");
        jLabel7.setBounds(41, 95, 14, 16);
        jPanel3.add(jLabel7);
        jLabel7.setFont(this.f6a);
        jLabel7.setForeground(new Color(200, 200, 200));
        jLabel7.addMouseListener(new f(this, jLabel7));
        JLabel jLabel8 = new JLabel("X Axis:");
        jLabel8.setForeground(Color.WHITE);
        this.f6a.deriveFont(13.0f);
        jLabel8.setFont(this.f6a);
        jLabel8.setBounds(204, 95, 49, 16);
        jPanel3.add(jLabel8);
        JLabel jLabel9 = new JLabel("Y Axis:");
        jLabel9.setForeground(Color.WHITE);
        jLabel9.setFont(this.f6a);
        jLabel9.setBounds(204, NativeKeyEvent.VC_UNDERSCORE, 49, 16);
        jPanel3.add(jLabel9);
        MaskFormatter maskFormatter = null;
        try {
            maskFormatter = new MaskFormatter("|#|");
        } catch (ParseException e3) {
            e3.printStackTrace();
        }
        JFormattedTextField jFormattedTextField = new JFormattedTextField(maskFormatter);
        jFormattedTextField.setBorder((Border) null);
        jFormattedTextField.setOpaque(true);
        jFormattedTextField.setFont(this.f6a);
        jFormattedTextField.setHorizontalAlignment(0);
        jFormattedTextField.setText("|" + com.java.loader.c.e + "|");
        jFormattedTextField.setBounds(254, 90, 28, 26);
        jPanel3.add(jFormattedTextField);
        JFormattedTextField jFormattedTextField2 = new JFormattedTextField(maskFormatter);
        jFormattedTextField2.setBorder((Border) null);
        jFormattedTextField2.setOpaque(true);
        jFormattedTextField2.setFont(this.f6a);
        jFormattedTextField2.setHorizontalAlignment(0);
        jFormattedTextField2.setText("|" + com.java.loader.c.f + "|");
        jFormattedTextField2.setBounds(254, 110, 28, 26);
        jPanel3.add(jFormattedTextField2);
        jFormattedTextField.addActionListener(new g(this, jFormattedTextField));
        jFormattedTextField2.addActionListener(new h(this, jFormattedTextField2));
        JLabel jLabel10 = new JLabel("Left Click");
        this.f6a.deriveFont(15.0f);
        jLabel10.setFont(this.f6a);
        jLabel10.setForeground(Color.WHITE);
        jLabel10.setHorizontalAlignment(0);
        jLabel10.setBounds(6, 143, 276, 16);
        jPanel3.add(jLabel10);
        a aVar = new a(5, 25);
        aVar.setValue(com.java.loader.c.a);
        aVar.a(com.java.loader.c.b);
        aVar.setBorder(BorderFactory.createEmptyBorder());
        aVar.setFocusable(false);
        aVar.setOpaque(false);
        aVar.setBounds(6, 160, 276, 29);
        jPanel3.add(aVar);
        
        NumberFormat nf = null;
        Format format = null;
        try {
            nf = NumberFormat.getInstance();
            format = nf;
            nf.setMaximumIntegerDigits(2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        JFormattedTextField jFormattedTextField3 = new JFormattedTextField(format);
        jFormattedTextField3.setBorder((Border) null);
        jFormattedTextField3.setOpaque(true);
        jFormattedTextField3.setHorizontalAlignment(0);
        jFormattedTextField3.setBounds(6, 182, 28, 26);
        jFormattedTextField3.setValue(Integer.valueOf(aVar.getValue()));
        jPanel3.add(jFormattedTextField3);
        JFormattedTextField jFormattedTextField4 = new JFormattedTextField(format);
        jFormattedTextField4.setBorder((Border) null);
        jFormattedTextField4.setOpaque(true);
        jFormattedTextField4.setHorizontalAlignment(0);
        jFormattedTextField4.setBounds(254, 182, 28, 26);
        jFormattedTextField4.setValue(Integer.valueOf(aVar.a()));
        jPanel3.add(jFormattedTextField4);
        aVar.addChangeListener(new i(this, jFormattedTextField3, aVar, jFormattedTextField4));
        j jVar = new j(this, jFormattedTextField3, jFormattedTextField4, aVar);
        jFormattedTextField3.addActionListener(jVar);
        jFormattedTextField4.addActionListener(jVar);
        jFormattedTextField.setEnabled(false);
        jFormattedTextField2.setEnabled(false);
        JLabel jLabel11 = new JLabel("VeneClicker");
        jLabel11.setBounds(5, 5, 288, 16);
        getContentPane().add(jLabel11);
        jLabel11.setHorizontalAlignment(0);
        jLabel11.setFont(this.f7b);
        jLabel11.setForeground(Color.WHITE);
    }

    private BufferedImage a(String str) {
        try {
            if (com.java.loader.c.f24e) {
                return ImageIO.read(getClass().getResourceAsStream(str));
            }
            return ImageIO.read(new File(str.startsWith("/") ? str.substring(1) : str));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}