/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keeptoo;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author oXCToo
 */
public class KGradientPanel extends JComponent {

    public Color StartColor = Color.GREEN;
    public Color EndColor = Color.BLUE;
    public boolean TransparentControls = true;
    public int gradientFocus = 0;

    public KGradientPanel() {

        if (TransparentControls) {
            setBg(true);
        } else {
            setBg(false);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();

        GradientPaint gp = new GradientPaint(0, 0, StartColor, gradientFocus, h, EndColor);;

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }

    public Color getStartColor() {
        return StartColor;
    }

    public void setStartColor(Color StartColor) {
        this.StartColor = StartColor;
        invalidate();
    }

    public Color getEndColor() {
        return EndColor;
    }

    public void setEndColor(Color EndColor) {
        this.EndColor = EndColor;
        invalidate();
    }

    public int getGradientFocus() {
        return gradientFocus;
    }

    public void setGradientFocus(int gradientFocus) {
        this.gradientFocus = gradientFocus;
        invalidate();
    }

    public boolean isTransparentControls() {
        return TransparentControls;
    }

    public void setTransparentControls(boolean TransparentControls) {
        this.TransparentControls = TransparentControls;
        invalidate();
    }

    private void setBg(boolean isOpaque) {
        Component[] components = this.getComponents();
        for (Component component : components) {

            ((JLabel) component).setOpaque(isOpaque);
            ((JCheckBox) component).setOpaque(isOpaque);
            ((JTextField) component).setOpaque(isOpaque);
            ((JPasswordField) component).setOpaque(isOpaque);
            ((JFormattedTextField) component).setOpaque(isOpaque);
            ((JToolBar) component).setOpaque(isOpaque);
            ((JRadioButton) component).setOpaque(isOpaque);

        }
    }

}
