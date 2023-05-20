package sk.stuba.fei.uim.oop.logika;

import lombok.Getter;
import sk.stuba.fei.uim.oop.okno.Doska;
import sk.stuba.fei.uim.oop.tvary.Medzikruzie;
import sk.stuba.fei.uim.oop.tvary.Plus;
import sk.stuba.fei.uim.oop.tvary.Tvar;
import sk.stuba.fei.uim.oop.tvary.Usecka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class LogikaHry extends UniverzalnyAdapter {
    JFrame okno;
    Doska doska;
    private final String USECKA = "Úsečka";
    private final String PLUS = "Plus";
    private final String MEDZIKRUZIE = "Medzikružie";
    private final String FARBA = "Farba";
    private final String ZMENAFARBY = "Zmena farby";
    private int zaciatokX;
    private int zaciatokY;
    private Tvar tvar;
    private boolean usecka;
    private boolean medzikruzie;
    private boolean plus;
    @Getter
    private JLabel farbaVypis;
    private Color farba;
    private boolean zmenaFarby;
    public LogikaHry(JFrame okno){
        usecka = true;
        plus = false;
        zmenaFarby = false;
        medzikruzie = false;
        farba = Color.BLACK;
        this.farbaVypis = new JLabel();
        this.farbaVypis.setBackground(Color.BLACK);
        this.farbaVypis.setOpaque(true);
        this.okno = okno;
        this.doska = new Doska();
        this.okno.add(doska);
        doska.addMouseMotionListener(this);
        doska.addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!zmenaFarby){
            zaciatokX = e.getPoint().x;
            zaciatokY = e.getPoint().y;
            if(usecka){
                tvar = new Usecka(zaciatokX,zaciatokY);
            }
            if(plus){
                tvar = new Plus(zaciatokX,zaciatokY);
            }
            if(medzikruzie){
                tvar = new Medzikruzie(zaciatokX,zaciatokY);
            }
            tvar.setFarba(farba);
            doska.pridajTvar(tvar);
        }

        if(zmenaFarby){
            for (int i=doska.getTvary().size()-1; i >= 0; i--) {
                if (doska.getTvary().get(i).getTvar().contains(e.getX(), e.getY())) {
                    doska.getTvary().get(i).setFarba(farba);
                    doska.repaint();
                    break;
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e){
        if(!zmenaFarby){
            tvar.setBod(e.getX(),e.getY());
            doska.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(!zmenaFarby) {
            this.tvar.setBod(e.getPoint().x, e.getPoint().y);
            this.tvar.addMouseListener(this);
            doska.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case PLUS:
                usecka = false;
                plus = true;
                medzikruzie = false;
                zmenaFarby = false;
                break;
            case USECKA:
                usecka = true;
                plus = false;
                medzikruzie = false;
                zmenaFarby = false;
                break;
            case MEDZIKRUZIE:
                usecka = false;
                plus = false;
                medzikruzie = true;
                zmenaFarby = false;
                break;
            case ZMENAFARBY:
                zmenaFarby = true;
                break;
            case FARBA:
                zmenFarbu();
                break;
        }
    }
    private void zmenFarbu(){
        if (farba.equals(Color.BLACK)) {
            farba = Color.RED;
            this.farbaVypis.setBackground(Color.RED);
        }
        else if (farba.equals(Color.RED)) {
            farba = Color.BLUE;
            this.farbaVypis.setBackground(Color.BLUE);
        }
        else if (farba.equals(Color.BLUE)) {
            farba = Color.PINK;
            this.farbaVypis.setBackground(Color.PINK);
        }
        else if (farba.equals(Color.PINK)) {
            farba = Color.BLACK;
            this.farbaVypis.setBackground(Color.BLACK);
        }
    }
}
