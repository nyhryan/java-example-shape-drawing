package example.drawables;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Vector;

public class Curve extends AbstractShape {
    private final List<Point2D> points = new Vector<>();

    public Curve(Color color) {
        super(color);
    }

    public void addPoint(Point2D point) {
        points.add(point);
    }

    @Override
    public void draw(Graphics2D g) {
        if (points.size() < 2) {
            return;
        }

        g.setColor(color);
        g.setStroke(stroke);
        for (int i = 1; i < points.size(); i++) {
            var p1 = points.get(i - 1);
            var p2 = points.get(i);
            g.draw(new Line2D.Double(p1, p2));
        }
    }
}
