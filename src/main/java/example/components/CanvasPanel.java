package example.components;

import example.drawables.Curve;
import example.drawables.Rectangle;
import example.drawables.Drawable;
import example.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Vector;

public class CanvasPanel extends JPanel {
    class CanvasMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            var currentColor = frame.getCurrentColor();
            switch (frame.getCurrentShape()) {
                case CURVE -> {
                    var currentDrawable = new Curve(currentColor);
                    shapes.add(currentDrawable);
                    currentDrawable.addPoint(e.getPoint());
                    repaint();
                }
                case RECTANGLE -> {
                    var currentPoint = new Point2D.Double(e.getX(), e.getY());
                    shapes.add(new Rectangle(currentColor, currentPoint));
                    repaint();
                }
                default -> {
                }
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            switch (frame.getCurrentShape()) {
                case CURVE -> {
                    ((Curve) shapes.getLast()).addPoint(e.getPoint());
                    repaint();
                }
                case RECTANGLE -> {
                    Rectangle rect = (Rectangle) shapes.getLast();
                    rect.setOtherPoint(new Point2D.Double(e.getX(), e.getY()));
                    repaint();
                }
                default -> {
                }
            }
        }
    }

    private final Main frame;
    private final List<Drawable> shapes = new Vector<>();

    public CanvasPanel(Main frame) {
        this.frame = frame;

        setBackground(Color.WHITE);
        CanvasPanel.CanvasMouseListener listener = new CanvasPanel.CanvasMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        var g2d = (Graphics2D) g;
        shapes.forEach(shape -> shape.draw(g2d));
    }
}
