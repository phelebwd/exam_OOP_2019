package sk.stuba.fei.uim.oop.tvary;

import lombok.Getter;
import lombok.Setter;
import javax.swing.*;
import java.awt.*;

public abstract class Tvar extends JPanel {
    @Getter
    int x1;
    @Getter
    int y1;
    int x2;
    int y2;
    @Setter
    private Color farba;
    public Tvar(int x1, int y1){
        this.x1 = x1;
        this.y1 = y1;
        farba = Color.black;
    }

    public void setBod(int x2, int y2){
        this.x2 = x2;
        this.y2 = y2;
    }
    protected void nastavFarbu(Graphics2D g2d){
        g2d.setColor(this.farba);
    }
    public abstract Shape getTvar();
}
