package com.java.loader.applet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;

/* loaded from: Vene.jar:com/java/loader/applet/RangeSliderUI.class */
class RangeSliderUI extends BasicSliderUI {
    private Color a;

    /* renamed from: a, reason: collision with other field name */
    Rectangle f2a;

    /* renamed from: a, reason: collision with other field name */
    boolean f3a;
    transient boolean b;
    transient boolean c;

    public RangeSliderUI(a aVar) {
        super(aVar);
        this.a = new Color(42, 172, 255);
    }

    public void installUI(JComponent jComponent) {
        this.f2a = new Rectangle();
        super.installUI(jComponent);
    }

    protected BasicSliderUI.TrackListener createTrackListener(JSlider jSlider) {
        return new RangeTrackListener();
    }

    protected ChangeListener createChangeListener(JSlider jSlider) {
        return new RangeChangeListener();
    }

    protected void calculateThumbSize() {
        super.calculateThumbSize();
        this.f2a.setSize(this.thumbRect.width, this.thumbRect.height);
    }

    protected void calculateThumbLocation() {
        super.calculateThumbLocation();
        if (this.slider.getSnapToTicks()) {
            int value = this.slider.getValue() + this.slider.getExtent();
            int minimum = value;
            int majorTickSpacing = this.slider.getMajorTickSpacing();
            int minorTickSpacing = this.slider.getMinorTickSpacing();
            int i = 0;
            if (minorTickSpacing > 0) {
                i = minorTickSpacing;
            } else if (majorTickSpacing > 0) {
                i = majorTickSpacing;
            }
            if (i != 0) {
                if ((value - this.slider.getMinimum()) % i != 0) {
                    minimum = this.slider.getMinimum() + (Math.round((value - this.slider.getMinimum()) / i) * i);
                }
                if (minimum != value) {
                    this.slider.setExtent(minimum - this.slider.getValue());
                }
            }
        }
        if (this.slider.getOrientation() == 0) {
            this.f2a.x = xPositionForValue(this.slider.getValue() + this.slider.getExtent()) - (this.f2a.width / 2);
            this.f2a.y = this.trackRect.y;
            return;
        }
        int iYPositionForValue = yPositionForValue(this.slider.getValue() + this.slider.getExtent());
        this.f2a.x = this.trackRect.x;
        this.f2a.y = iYPositionForValue - (this.f2a.height / 2);
    }

    protected Dimension getThumbSize() {
        return new Dimension(12, 12);
    }

    public void paint(Graphics graphics, JComponent jComponent) {
        super.paint(graphics, jComponent);
        Rectangle clipBounds = graphics.getClipBounds();
        if (this.f3a) {
            if (clipBounds.intersects(this.thumbRect)) {
                a(graphics);
            }
            if (clipBounds.intersects(this.f2a)) {
                b(graphics);
                return;
            }
            return;
        }
        if (clipBounds.intersects(this.f2a)) {
            b(graphics);
        }
        if (clipBounds.intersects(this.thumbRect)) {
            a(graphics);
        }
    }

    public void paintTrack(Graphics graphics) {
        super.paintTrack(graphics);
        Rectangle rectangle = this.trackRect;
        if (this.slider.getOrientation() == 0) {
            int i = this.thumbRect.x + (this.thumbRect.width / 2);
            int i2 = this.f2a.x + (this.f2a.width / 2);
            int i3 = (rectangle.height / 2) - 2;
            Color color = graphics.getColor();
            graphics.translate(rectangle.x, rectangle.y + i3);
            graphics.setColor(this.a);
            for (int i4 = 0; i4 <= 3; i4++) {
                graphics.drawLine(i - rectangle.x, i4, i2 - rectangle.x, i4);
            }
            graphics.translate(-rectangle.x, -(rectangle.y + i3));
            graphics.setColor(color);
            return;
        }
        int i5 = this.thumbRect.x + (this.thumbRect.width / 2);
        int i6 = this.f2a.x + (this.f2a.width / 2);
        int i7 = (rectangle.width / 2) - 2;
        Color color2 = graphics.getColor();
        graphics.translate(rectangle.x + i7, rectangle.y);
        graphics.setColor(this.a);
        for (int i8 = 0; i8 <= 3; i8++) {
            graphics.drawLine(i8, i5 - rectangle.y, i8, i6 - rectangle.y);
        }
        graphics.translate(-(rectangle.x + i7), -rectangle.y);
        graphics.setColor(color2);
    }

    public void paintThumb(Graphics graphics) {
    }

    private void a(Graphics graphics) {
        Rectangle rectangle = this.thumbRect;
        int i = rectangle.width;
        int i2 = rectangle.height;
        Graphics2D graphics2DCreate = (Graphics2D) graphics.create();
        Shape shapeA = a(i - 1, i2 - 1);
        graphics2DCreate.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2DCreate.translate(rectangle.x, rectangle.y);
        graphics2DCreate.setColor(new Color(255, 199, 60));
        graphics2DCreate.fill(shapeA);
        graphics2DCreate.dispose();
    }

    private void b(Graphics graphics) {
        Rectangle rectangle = this.f2a;
        int i = rectangle.width;
        int i2 = rectangle.height;
        Graphics2D graphics2DCreate = (Graphics2D) graphics.create();
        Shape shapeA = a(i - 1, i2 - 1);
        graphics2DCreate.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2DCreate.translate(rectangle.x, rectangle.y);
        graphics2DCreate.setColor(new Color(216, 73, 63));
        graphics2DCreate.fill(shapeA);
        graphics2DCreate.dispose();
    }

    private static Shape a(int i, int i2) {
        return new Ellipse2D.Double(0.0d, 0.0d, i, i2);
    }

    public void scrollByBlock(int i) {
        synchronized (this.slider) {
            int maximum = (this.slider.getMaximum() - this.slider.getMinimum()) / 10;
            int i2 = maximum;
            if (maximum <= 0 && this.slider.getMaximum() > this.slider.getMinimum()) {
                i2 = 1;
            }
            int i3 = i2 * (i > 0 ? 1 : -1);
            if (this.f3a) {
                ((a) this.slider).a(((a) this.slider).a() + i3);
            } else {
                this.slider.setValue(this.slider.getValue() + i3);
            }
        }
    }

    public void scrollByUnit(int i) {
        synchronized (this.slider) {
            int i2 = 1 * (i > 0 ? 1 : -1);
            if (this.f3a) {
                ((a) this.slider).a(((a) this.slider).a() + i2);
            } else {
                this.slider.setValue(this.slider.getValue() + i2);
            }
        }
    }

    static void a(RangeSliderUI rangeSliderUI, int i, int i2) {
        Rectangle rectangle = new Rectangle();
        rectangle.setBounds(rangeSliderUI.f2a);
        rangeSliderUI.f2a.setLocation(i, i2);
        SwingUtilities.computeUnion(rangeSliderUI.f2a.x, rangeSliderUI.f2a.y, rangeSliderUI.f2a.width, rangeSliderUI.f2a.height, rectangle);
        rangeSliderUI.slider.repaint(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public class RangeChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            if (b || c) {
                return;
            }
            calculateThumbLocation();
            slider.repaint();
        }
    }

    public class RangeTrackListener extends BasicSliderUI.TrackListener {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            if (slider.isEnabled()) {
                currentMouseX = mouseEvent.getX();
                currentMouseY = mouseEvent.getY();
                if (slider.isRequestFocusEnabled()) {
                    slider.requestFocus();
                }
                boolean z = false;
                boolean z2 = false;
                if (f3a || slider.getMinimum() == slider.getValue()) {
                    if (f2a.contains(currentMouseX, currentMouseY)) {
                        z2 = true;
                    } else if (thumbRect.contains(currentMouseX, currentMouseY)) {
                        z = true;
                    }
                } else if (thumbRect.contains(currentMouseX, currentMouseY)) {
                    z = true;
                } else if (f2a.contains(currentMouseX, currentMouseY)) {
                    z2 = true;
                }
                if (z) {
                    switch (slider.getOrientation()) {
                        case 0:
                            offset = currentMouseX - thumbRect.x;
                            break;
                        case 1:
                            offset = currentMouseY - thumbRect.y;
                            break;
                    }
                    f3a = false;
                    b = true;
                    return;
                }
                b = false;
                if (!z2) {
                    c = false;
                    return;
                }
                switch (slider.getOrientation()) {
                    case 0:
                        offset = currentMouseX - f2a.x;
                        break;
                    case 1:
                        offset = currentMouseY - f2a.y;
                        break;
                }
                f3a = true;
                c = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            b = false;
            c = false;
            slider.setValueIsAdjusting(false);
            super.mouseReleased(mouseEvent);
        }

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            if (slider.isEnabled()) {
                currentMouseX = mouseEvent.getX();
                currentMouseY = mouseEvent.getY();
                if (b) {
                    slider.setValueIsAdjusting(true);
                    switch (slider.getOrientation()) {
                        case 0:
                            int i = thumbRect.width / 2;
                            int i2 = currentMouseX - offset;
                            int i3 = trackRect.x;
                            int i4 = trackRect.x + (trackRect.width - 1);
                            int iXPositionForValue = xPositionForValue(slider.getValue() + slider.getExtent());
                            if (drawInverted()) {
                                i3 = iXPositionForValue;
                            } else {
                                i4 = iXPositionForValue;
                            }
                            int iMin = Math.min(Math.max(i2, i3 - i), i4 - i);
                            setThumbLocation(iMin, thumbRect.y);
                            slider.setValue(valueForXPosition(iMin + i));
                            break;
                        case 1:
                            int i5 = thumbRect.height / 2;
                            int i6 = currentMouseY - offset;
                            int i7 = trackRect.y;
                            int i8 = trackRect.y + (trackRect.height - 1);
                            int iYPositionForValue = yPositionForValue(slider.getValue() + slider.getExtent());
                            if (drawInverted()) {
                                i8 = iYPositionForValue;
                            } else {
                                i7 = iYPositionForValue;
                            }
                            int iMin2 = Math.min(Math.max(i6, i7 - i5), i8 - i5);
                            setThumbLocation(thumbRect.x, iMin2);
                            slider.setValue(valueForYPosition(iMin2 + i5));
                            break;
                    }
                }
                if (c) {
                    slider.setValueIsAdjusting(true);
                    switch (slider.getOrientation()) {
                        case 0:
                            int i9 = thumbRect.width / 2;
                            int i10 = currentMouseX - offset;
                            int i11 = trackRect.x;
                            int i12 = trackRect.x + (trackRect.width - 1);
                            int iXPositionForValue2 = xPositionForValue(slider.getValue());
                            if (drawInverted()) {
                                i12 = iXPositionForValue2;
                            } else {
                                i11 = iXPositionForValue2;
                            }
                            int iMin3 = Math.min(Math.max(i10, i11 - i9), i12 - i9);
                            a(RangeSliderUI.this, iMin3, thumbRect.y);
                            slider.setExtent(valueForXPosition(iMin3 + i9) - slider.getValue());
                            break;
                        case 1:
                            int i13 = thumbRect.height / 2;
                            int i14 = currentMouseY - offset;
                            int i15 = trackRect.y;
                            int i16 = trackRect.y + (trackRect.height - 1);
                            int iYPositionForValue2 = yPositionForValue(slider.getValue());
                            if (drawInverted()) {
                                i15 = iYPositionForValue2;
                            } else {
                                i16 = iYPositionForValue2;
                            }
                            int iMin4 = Math.min(Math.max(i14, i15 - i13), i16 - i13);
                            a(RangeSliderUI.this, thumbRect.x, iMin4);
                            slider.setExtent(valueForYPosition(iMin4 + i13) - slider.getValue());
                            break;
                    }
                }
            }
        }

        @Override
        public boolean shouldScroll(int i) {
            return false;
        }
    }
}
