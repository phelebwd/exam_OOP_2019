package sk.stuba.fei.uim.oop.tvary;
import java.awt.*;
import java.awt.geom.Line2D;

public class Usecka extends Tvar {
    public Usecka(int x1, int y1) {
        super(x1, y1);
    }

    public void nakresli(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        super.nastavFarbu(g2d);
        g2d.setStroke(new BasicStroke(10));
        g2d.drawLine(super.x1, super.y1, super.x2, super.y2);
    }
    @Override
    public Shape getTvar() {
        Line2D line = new Line2D.Double(x1, y1, x2, y2);
        BasicStroke stroke = new BasicStroke(10);
        return stroke.createStrokedShape(line);
    }
}
