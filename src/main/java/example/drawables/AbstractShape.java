package example.drawables;

import java.awt.*;

public abstract class AbstractShape implements Drawable {
    protected Color color = Color.BLACK;
    protected Stroke stroke = new BasicStroke(4);
    protected AbstractShape(Color color) {
        this.color = color;
    }
}
