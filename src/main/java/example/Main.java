package example;

import example.components.CanvasPanel;
import example.components.ShapePanel;
import example.components.ShapeType;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private ShapeType currentShape = ShapeType.CURVE;
    private Color currentColor = Color.BLACK;

    public Main() {
        super("Shape example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 400));
        setLocationRelativeTo(null);

        ShapePanel shapePanel = new ShapePanel(this);
        add(shapePanel, BorderLayout.NORTH);

        CanvasPanel canvasPanel = new CanvasPanel(this);
        add(canvasPanel, BorderLayout.CENTER);

        pack();
        setVisible(false);
    }

    public ShapeType getCurrentShape() {
        return currentShape;
    }

    public void setCurrentShape(ShapeType currentShape) {
        this.currentShape = currentShape;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}