package sk.stuba.fei.uim.oop.okno;

import lombok.Getter;
import sk.stuba.fei.uim.oop.tvary.Medzikruzie;
import sk.stuba.fei.uim.oop.tvary.Plus;
import sk.stuba.fei.uim.oop.tvary.Tvar;
import sk.stuba.fei.uim.oop.tvary.Usecka;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Doska extends JPanel {
    @Getter
    private ArrayList<Tvar> tvary;
    public Doska(){
        setBackground(Color.GREEN);
        tvary = new ArrayList<>();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Tvar tvar : tvary){
            if(tvar instanceof Usecka){
                ((Usecka) tvar).nakresli(g);
            }
            if(tvar instanceof Plus){
                ((Plus) tvar).nakresli(g);
            }
            if(tvar instanceof Medzikruzie){
                ((Medzikruzie) tvar).nakresli(g);
            }
        }
    }
    public void pridajTvar(Tvar tvar){
        this.tvary.add(tvar);
        this.add(tvar);
    }
}
