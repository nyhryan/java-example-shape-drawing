package example.drawables;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Rectangle extends AbstractShape {
    private final Point2D.Double originPoint;
    private Point2D.Double otherPoint = null;

    public Rectangle(Color color, Point2D.Double originPoint) {
        super(color);
        this.originPoint = originPoint;
    }

    public void setOtherPoint(Point2D.Double otherPoint) {
        this.otherPoint = otherPoint;
    }

    @Override
    public void draw(Graphics2D g) {
        if (otherPoint == null) {
            return;
        }

        int x1 = (int) originPoint.x;
        int y1 = (int) originPoint.y;
        int x2 = (int) otherPoint.x;
        int y2 = (int) otherPoint.y;

        int oX = Math.min(x1, x2);
        int oY = Math.min(y1, y2);
        int w = Math.abs(x1 - x2);
        int h = Math.abs(y1 - y2);

        g.setColor(color);
        g.setStroke(stroke);
        g.draw(new Rectangle2D.Double(oX, oY, w, h));
    }
}
