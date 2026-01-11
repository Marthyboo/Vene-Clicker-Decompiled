package com.java.loader.gui;

import com.java.loader.ConfigManager;
import com.java.loader.state.VeneState;
import com.java.loader.listener.StateListener;
import com.java.loader.listener.GlobalKeyListener;
import com.java.loader.listener.GlobalMouseListener;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public final class MainFrame extends JFrame {
    private int mouseX;
    private int mouseY;
    private BufferedImage logoActive;
    private BufferedImage logoInactive;
    private Font fontLato13;
    private Font fontLato16;
    private Font fontLato11;

    public MainFrame() {
        setTitle("VeneClicker");
        setBounds(100, 100, 297, 322);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setUndecorated(true);
        setResizable(false);
        setBackground(new Color(46, 49, 54));
        getContentPane().setBackground(new Color(46, 49, 54));

        // Drag listeners
        MouseAdapter dragAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(e.getXOnScreen() - mouseX, e.getYOnScreen() - mouseY);
            }
        };
        addMouseListener(dragAdapter);
        addMouseMotionListener(dragAdapter);

        loadAssets();

        // Control Panel (Top Right - Close/Minimize)
        JPanel controlPanel = new JPanel();
        controlPanel.setBounds(5, 5, 50, 15);
        controlPanel.setLayout(null);
        controlPanel.setOpaque(false);
        getContentPane().add(controlPanel);

        JButton closeBtn = new JButton(new ImageIcon(loadImage("/res/x.png")));
        closeBtn.setBounds(0, 0, 15, 15);
        closeBtn.setBorder(BorderFactory.createEmptyBorder());
        closeBtn.setOpaque(false);
        closeBtn.setContentAreaFilled(false);
        closeBtn.setBorderPainted(false);
        closeBtn.addActionListener(e -> System.exit(0));
        controlPanel.add(closeBtn);

        JButton minBtn = new JButton(new ImageIcon(loadImage("/res/min.png")));
        minBtn.setBounds(20, 0, 15, 15);
        minBtn.setBorder(BorderFactory.createEmptyBorder());
        minBtn.setOpaque(false);
        minBtn.setContentAreaFilled(false);
        minBtn.setBorderPainted(false);
        minBtn.addActionListener(e -> setState(JFrame.ICONIFIED));
        controlPanel.add(minBtn);

        // Logo
        JLabel logoLabel = new JLabel(new ImageIcon(logoInactive));
        logoLabel.setBounds(272, 5, 21, 21);
        getContentPane().add(logoLabel);

        VeneState.setStateListener(active -> {
            if (active) {
                logoLabel.setIcon(new ImageIcon(logoActive));
            } else {
                logoLabel.setIcon(new ImageIcon(logoInactive));
            }
        });

        // Top Buttons (Destruct/Settings)
        JPanel topBtnPanel = new JPanel();
        topBtnPanel.setBounds(5, 28, 288, 64);
        topBtnPanel.setLayout(null);
        topBtnPanel.setOpaque(false);
        getContentPane().add(topBtnPanel);

        JButton destructBtn = new JButton(new ImageIcon(loadImage("/res/destruct.png")));
        destructBtn.setBounds(topBtnPanel.getWidth() / 2 - 74, 0, 64, 64);
        destructBtn.setOpaque(false);
        destructBtn.setContentAreaFilled(false);
        destructBtn.setBorderPainted(false);
        destructBtn.setToolTipText("Self-destruct");
        destructBtn.addActionListener(e -> {
            // Destruct logic: delete files and exit
            new File("config.txt").delete();
            System.exit(0);
        });
        topBtnPanel.add(destructBtn);

        JButton settingsBtn = new JButton(new ImageIcon(loadImage("/res/settings.png")));
        settingsBtn.setBounds(topBtnPanel.getWidth() / 2 + 10, 0, 64, 64);
        settingsBtn.setOpaque(false);
        settingsBtn.setContentAreaFilled(false);
        settingsBtn.setBorderPainted(false);
        settingsBtn.setToolTipText("Settings");
        topBtnPanel.add(settingsBtn);

        // Main Content Area
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(5, 96, 288, 218);
        contentPanel.setLayout(null);
        contentPanel.setOpaque(false);
        getContentPane().add(contentPanel);

        // Keybind Toggle
        JLabel toggleBtnLabel = new JLabel("Toggle Button");
        toggleBtnLabel.setFont(fontLato13);
        toggleBtnLabel.setForeground(Color.WHITE);
        toggleBtnLabel.setBounds(6, 11, 103, 16);
        contentPanel.add(toggleBtnLabel);

        JToggleButton keybindBtn = new JToggleButton(new ImageIcon(loadImage("/res/button.png")));
        keybindBtn.setSelectedIcon(new ImageIcon(loadImage("/res/button_active.png")));
        keybindBtn.setBounds(179, 8, 103, 19);
        keybindBtn.setOpaque(false);
        keybindBtn.setContentAreaFilled(false);
        keybindBtn.setBorderPainted(false);
        keybindBtn.setBorder(BorderFactory.createEmptyBorder());
        keybindBtn.setFont(fontLato13);
        keybindBtn.setText(VeneState.getKeybindString());
        keybindBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        keybindBtn.setVerticalTextPosition(SwingConstants.CENTER);
        keybindBtn.addActionListener(e -> {
            if (keybindBtn.isSelected()) {
                keybindBtn.setText("...");
                GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
                    private ArrayList<Integer> keys = new ArrayList<>();
                    @Override
                    public void nativeKeyTyped(NativeKeyEvent e1) {}
                    @Override
                    public void nativeKeyReleased(NativeKeyEvent e1) {
                        VeneState.keybinds.clear();
                        ArrayList<Integer> uniqueKeys = new ArrayList<>();
                        for (Integer k : keys) {
                            if (!uniqueKeys.contains(k)) uniqueKeys.add(k);
                        }
                        VeneState.keybinds.addAll(uniqueKeys);
                        keybindBtn.setText(VeneState.getKeybindString());
                        keybindBtn.setSelected(false);
                        GlobalScreen.removeNativeKeyListener(this);
                    }
                    @Override
                    public void nativeKeyPressed(NativeKeyEvent e1) {
                        keys.add(e1.getKeyCode());
                    }
                });
            }
        });
        contentPanel.add(keybindBtn);

        // Only in Minecraft
        JLabel mcOnlyLabel = new JLabel("Only in Minecraft");
        mcOnlyLabel.setFont(fontLato13);
        mcOnlyLabel.setForeground(Color.WHITE);
        mcOnlyLabel.setBounds(6, 39, 157, 16);
        contentPanel.add(mcOnlyLabel);

        JCheckBox mcOnlyCb = new JCheckBox("");
        mcOnlyCb.setIcon(new ImageIcon(loadImage("/res/checkbox.png")));
        mcOnlyCb.setSelectedIcon(new ImageIcon(loadImage("/res/checkbox_checked.png")));
        mcOnlyCb.setBounds(254, 39, 28, 16);
        mcOnlyCb.setOpaque(false);
        mcOnlyCb.setContentAreaFilled(false);
        mcOnlyCb.setBorderPainted(false);
        mcOnlyCb.setSelected(VeneState.onlyInMinecraft);
        mcOnlyCb.addActionListener(e -> VeneState.onlyInMinecraft = mcOnlyCb.isSelected());
        contentPanel.add(mcOnlyCb);

        // CPS Drops
        JLabel cpsDropsLabel = new JLabel("CPS Drops");
        cpsDropsLabel.setFont(fontLato13);
        cpsDropsLabel.setForeground(Color.WHITE);
        cpsDropsLabel.setBounds(6, 67, 80, 16);
        contentPanel.add(cpsDropsLabel);

        JLabel cpsDropsInfo = new JLabel("[?]");
        cpsDropsInfo.setFont(fontLato13);
        cpsDropsInfo.setForeground(new Color(200, 200, 200));
        cpsDropsInfo.setBounds(73, 67, 14, 16);
        cpsDropsInfo.setToolTipText("Randomly drops CPS to simulate human clicking.");
        contentPanel.add(cpsDropsInfo);

        JCheckBox cpsDropsCb = new JCheckBox("");
        cpsDropsCb.setIcon(new ImageIcon(loadImage("/res/checkbox.png")));
        cpsDropsCb.setSelectedIcon(new ImageIcon(loadImage("/res/checkbox_checked.png")));
        cpsDropsCb.setBounds(254, 67, 28, 16);
        cpsDropsCb.setOpaque(false);
        cpsDropsCb.setContentAreaFilled(false);
        cpsDropsCb.setBorderPainted(false);
        cpsDropsCb.setSelected(VeneState.cpsDropsEnabled);
        cpsDropsCb.addActionListener(e -> VeneState.cpsDropsEnabled = cpsDropsCb.isSelected());
        contentPanel.add(cpsDropsCb);

        // Jitter
        JLabel jitterLabel = new JLabel("Jitter");
        jitterLabel.setFont(fontLato13);
        jitterLabel.setForeground(Color.WHITE);
        jitterLabel.setBounds(6, 95, 184, 16);
        contentPanel.add(jitterLabel);

        JLabel jitterInfo = new JLabel("[?]");
        jitterInfo.setFont(fontLato13);
        jitterInfo.setForeground(new Color(200, 200, 200));
        jitterInfo.setBounds(41, 95, 14, 16);
        jitterInfo.setToolTipText("Adds random mouse movement while clicking.");
        contentPanel.add(jitterInfo);

        JLabel xAxisLabel = new JLabel("X Axis:");
        xAxisLabel.setFont(fontLato13);
        xAxisLabel.setForeground(Color.WHITE);
        xAxisLabel.setBounds(204, 95, 49, 16);
        contentPanel.add(xAxisLabel);

        JLabel yAxisLabel = new JLabel("Y Axis:");
        yAxisLabel.setFont(fontLato13);
        yAxisLabel.setForeground(Color.WHITE);
        yAxisLabel.setBounds(204, 115, 49, 16);
        contentPanel.add(yAxisLabel);

        MaskFormatter axisFormatter = null;
        try {
            axisFormatter = new MaskFormatter("|#|");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JFormattedTextField xField = new JFormattedTextField(axisFormatter);
        xField.setBounds(254, 90, 28, 26);
        xField.setBorder(null);
        xField.setOpaque(true);
        xField.setFont(fontLato13);
        xField.setHorizontalAlignment(SwingConstants.CENTER);
        xField.setText("|" + VeneState.jitterX + "|");
        xField.addActionListener(e -> {
            try {
                String val = xField.getText().replace("|", "");
                VeneState.jitterX = Integer.parseInt(val);
            } catch (Exception ex) {}
        });
        contentPanel.add(xField);

        JFormattedTextField yField = new JFormattedTextField(axisFormatter);
        yField.setBounds(254, 110, 28, 26);
        yField.setBorder(null);
        yField.setOpaque(true);
        yField.setFont(fontLato13);
        yField.setHorizontalAlignment(SwingConstants.CENTER);
        yField.setText("|" + VeneState.jitterY + "|");
        yField.addActionListener(e -> {
            try {
                String val = yField.getText().replace("|", "");
                VeneState.jitterY = Integer.parseInt(val);
            } catch (Exception ex) {}
        });
        contentPanel.add(yField);

        // Left Click Section
        JLabel leftClickLabel = new JLabel("Left Click");
        leftClickLabel.setFont(fontLato16);
        leftClickLabel.setForeground(Color.WHITE);
        leftClickLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leftClickLabel.setBounds(6, 143, 276, 16);
        contentPanel.add(leftClickLabel);

        RangeSlider cpsSlider = new RangeSlider(5, 25);
        cpsSlider.setBounds(6, 160, 276, 29);
        cpsSlider.setValue(VeneState.minCps);
        cpsSlider.setUpperValue(VeneState.maxCps);
        cpsSlider.setFocusable(false);
        cpsSlider.setOpaque(false);
        contentPanel.add(cpsSlider);

        NumberFormat cpsFormat = NumberFormat.getInstance();
        cpsFormat.setMaximumIntegerDigits(2);

        JFormattedTextField minCpsField = new JFormattedTextField(cpsFormat);
        minCpsField.setBounds(6, 182, 28, 26);
        minCpsField.setBorder(null);
        minCpsField.setOpaque(true);
        minCpsField.setHorizontalAlignment(SwingConstants.CENTER);
        minCpsField.setValue(cpsSlider.getValue());
        contentPanel.add(minCpsField);

        JFormattedTextField maxCpsField = new JFormattedTextField(cpsFormat);
        maxCpsField.setBounds(254, 182, 28, 26);
        maxCpsField.setBorder(null);
        maxCpsField.setOpaque(true);
        maxCpsField.setHorizontalAlignment(SwingConstants.CENTER);
        maxCpsField.setValue(cpsSlider.getUpperValue());
        contentPanel.add(maxCpsField);

        cpsSlider.addChangeListener(e -> {
            minCpsField.setValue(cpsSlider.getValue());
            maxCpsField.setValue(cpsSlider.getUpperValue());
            VeneState.minCps = cpsSlider.getValue();
            VeneState.maxCps = cpsSlider.getUpperValue();
        });

        ActionListener cpsFieldListener = e -> {
            cpsSlider.setValue(((Number)minCpsField.getValue()).intValue());
            cpsSlider.setUpperValue(((Number)maxCpsField.getValue()).intValue());
            VeneState.minCps = cpsSlider.getValue();
            VeneState.maxCps = cpsSlider.getUpperValue();
        };
        minCpsField.addActionListener(cpsFieldListener);
        maxCpsField.addActionListener(cpsFieldListener);

        // Title Footer
        JLabel titleLabel = new JLabel("VeneClicker");
        titleLabel.setBounds(5, 5, 288, 16);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(fontLato16);
        titleLabel.setForeground(Color.WHITE);
        getContentPane().add(titleLabel);
    }

    private void loadAssets() {
        logoActive = loadImage("/res/logo_active.png");
        logoInactive = loadImage("/res/logo.png");
        try {
            InputStream is = getClass().getResourceAsStream("/Lato-Regular.ttf");
            if (is == null) {
                // Try file if resource fails
                fontLato13 = new Font("SansSerif", Font.PLAIN, 13);
                fontLato16 = new Font("SansSerif", Font.PLAIN, 16);
                fontLato11 = new Font("SansSerif", Font.PLAIN, 11);
            } else {
                Font baseFont = Font.createFont(Font.TRUETYPE_FONT, is);
                fontLato13 = baseFont.deriveFont(13.0f);
                fontLato16 = baseFont.deriveFont(16.0f);
                fontLato11 = baseFont.deriveFont(11.0f);
            }
        } catch (Exception e) {
            e.printStackTrace();
            fontLato13 = new Font("SansSerif", Font.PLAIN, 13);
            fontLato16 = new Font("SansSerif", Font.PLAIN, 16);
            fontLato11 = new Font("SansSerif", Font.PLAIN, 11);
        }
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(path));
        } catch (Exception e) {
            // Try without leading slash
            try {
                return ImageIO.read(getClass().getResourceAsStream(path.substring(1)));
            } catch (Exception e2) {
                // Try file
                try {
                    return ImageIO.read(new File(path.startsWith("/") ? path.substring(1) : path));
                } catch (Exception e3) {
                    return new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
                }
            }
        }
    }
}
