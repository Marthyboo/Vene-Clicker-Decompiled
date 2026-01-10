package com.java.loader.applet;

import javax.swing.JSlider;

/* loaded from: Vene.jar:com/java/loader/applet/a.class */
public final class a extends JSlider {
    public a() {
        setOrientation(0);
    }

    public a(int i, int i2) {
        super(5, 25);
        setOrientation(0);
    }

    public final void updateUI() {
        setUI(new RangeSliderUI(this));
        updateLabelUIs();
    }

    public final int getValue() {
        return super.getValue();
    }

    public final void setValue(int i) {
        int value = getValue();
        if (value == i) {
            return;
        }
        int extent = getExtent();
        int iMin = Math.min(Math.max(getMinimum(), i), value + extent);
        getModel().setRangeProperties(iMin, (extent + value) - iMin, getMinimum(), getMaximum(), getValueIsAdjusting());
    }

    public final int a() {
        return getValue() + getExtent();
    }

    public final void a(int i) {
        int value = getValue();
        setExtent(Math.min(Math.max(0, i - value), getMaximum() - value));
    }
}
