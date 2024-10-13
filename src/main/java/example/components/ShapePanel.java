package example.components;

import example.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ShapePanel extends JPanel implements ActionListener {
    private final JRadioButton noneBtn = new JRadioButton(ShapeType.NONE.getName());
    private final JRadioButton curveBtn = new JRadioButton(ShapeType.CURVE.getName());
    private final JRadioButton rectBtn = new JRadioButton(ShapeType.RECTANGLE.getName());
    {
        noneBtn.setSelected(false);
        noneBtn.setActionCommand(ShapeType.NONE.getName());
        noneBtn.addActionListener(this);

        curveBtn.setSelected(true);
        curveBtn.setActionCommand(ShapeType.CURVE.getName());
        curveBtn.addActionListener(this);

        rectBtn.setSelected(false);
        rectBtn.setActionCommand(ShapeType.RECTANGLE.getName());
        rectBtn.addActionListener(this);
    }

    private final Main frame;

    public ShapePanel(Main frame) {
        this.frame = frame;

        setLayout(new FlowLayout(FlowLayout.LEFT));

        ButtonGroup group = new ButtonGroup();
        group.add(noneBtn);
        group.add(curveBtn);
        group.add(rectBtn);

        JButton colorBtn = new JButton("색상...");
        ImageIcon colorIcon = new ImageIcon(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB) {
            {
                Graphics2D g = createGraphics();
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 16, 16);
                g.dispose();
            }
        });
        colorBtn.setIcon(colorIcon);
        colorBtn.addActionListener(e -> {
            Color color = JColorChooser.showDialog(this, "색상 선택", frame.getCurrentColor());
            if (color != null) {
                frame.setCurrentColor(color);
                colorIcon.setImage(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB) {
                    {
                        Graphics2D g = createGraphics();
                        g.setColor(color);
                        g.fillRect(0, 0, 16, 16);
                        g.dispose();
                    }
                });
            } else {
                frame.setCurrentColor(Color.BLACK);
                colorIcon.setImage(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB) {
                    {
                        Graphics2D g = createGraphics();
                        g.setColor(Color.BLACK);
                        g.fillRect(0, 0, 16, 16);
                        g.dispose();
                    }
                });
            }
        });

        add(noneBtn);
        add(curveBtn);
        add(rectBtn);
        add(colorBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        ShapeType shape = ShapeType.getShapeTypeByName(command);
        if (shape != null) {
            frame.setCurrentShape(shape);
        }
    }
}
