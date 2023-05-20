package sk.stuba.fei.uim.oop.tvary;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Medzikruzie extends Tvar{
    int x;
    int y;
    int sirka;
    int vyska;
    double hrubka;
    public Medzikruzie(int x1, int y1) {
        super(x1, y1);
    }

    public void nakresli(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        int stredX = (x1 + x2) / 2;
        int stredY = (y1 + y2) / 2;

        int uhol = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) / 2;
        double dlzka = sqrt(pow((super.x1-super.x2),2) + pow((super.y1-super.y2),2));
        this.hrubka = dlzka / 3;
        this.x = stredX - uhol;
        this.y = stredY - uhol;
        this.sirka = uhol * 2;
        this.vyska = uhol * 2;
        super.nastavFarbu(g2d);
        g2d.setStroke(new BasicStroke((int)hrubka));
        g2d.drawOval(x, y, sirka, vyska);
    }

    @Override
    public Shape getTvar() {
        Shape shape = new Ellipse2D.Double(x, y, sirka, vyska);
        BasicStroke stroke = new BasicStroke((int) this.hrubka);
        return stroke.createStrokedShape(shape);
    }
}
