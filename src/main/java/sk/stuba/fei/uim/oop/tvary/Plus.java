package sk.stuba.fei.uim.oop.tvary;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import static java.lang.Math.*;

public class Plus extends Tvar {
    double hrubka;
    int usecka2X1;
    int usecka2Y1;
    int usecka2X2;
    int usecka2Y2;
    public Plus(int x1, int y1) {
        super(x1, y1);
    }

    public void nakresli(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        super.nastavFarbu(g2d);
        double dlzka = sqrt(pow((super.x1-super.x2),2) + pow((super.y1-super.y2),2));
        this.hrubka = (dlzka / 3)+(dlzka / 3);
        g2d.setStroke(new BasicStroke((int)hrubka));
        g2d.drawLine(super.x1, super.y1, super.x2, super.y2);

        int stredX = (super.x1 + super.x2) / 2;
        int stredY = (super.y1 + super.y2) / 2;

        usecka2X1 = stredX - (y1 - stredY);
        usecka2Y1 = stredY + (x1 - stredX);
        usecka2X2 = stredX - (y2 - stredY);
        usecka2Y2 = stredY + (x2 - stredX);

        g2d.setStroke(new BasicStroke((int)hrubka));
        g2d.drawLine(usecka2X1, usecka2Y1, usecka2X2 , usecka2Y2);
    }


    @Override
    public Shape getTvar() {
        Line2D line = new Line2D.Double(x1, y1, x2, y2);
        Line2D line2 = new Line2D.Double(usecka2X1, usecka2Y1, usecka2X2 , usecka2Y2);
        Path2D shape = new Path2D.Double();
        shape.append(line,false);
        shape.append(line2, false);
        BasicStroke stroke = new BasicStroke((int) hrubka);
        return stroke.createStrokedShape(shape);
    }
}
