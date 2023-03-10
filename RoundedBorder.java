/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.Border;

/**
 *
 * @author Acer
 */
public class RoundedBorder implements Border {
        int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }
    @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius/2, this.radius, this.radius/2, this.radius);
        }
    @Override
        public boolean isBorderOpaque() {
            return true;
        }
    @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

            g.drawRoundRect(x,y,width-1,height-1,radius,radius);           
        }
    }
