package sk.stuba.fei.uim.oop.okno;

import sk.stuba.fei.uim.oop.logika.LogikaHry;

import javax.swing.*;
import java.awt.*;

public class Aplikacia {
    public Aplikacia(){
        JFrame okno = new JFrame();  //vytvorenie okna
        okno.setSize(800,800);  //nastavenei velkosti okna
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //nastavenie zatvaracieho buttonu
        okno.setResizable(false);  //nemôže sa meniť velkosť
        okno.setBackground(Color.YELLOW);
        LogikaHry logika = new LogikaHry(okno);  //vloženie window do logiky

        JButton plus = new JButton("Plus"); //vytvorenie buttonu
        plus.addActionListener(logika); //priradenie liseneru k buttonu
        plus.setFocusable(false);
        JButton usecka = new JButton("Úsečka"); //vytvorenie buttonu
        usecka.addActionListener(logika); //priradenie liseneru k buttonu
        usecka.setFocusable(false);
        JButton medzikruzie = new JButton("Medzikružie"); //vytvorenie buttonu
        medzikruzie.addActionListener(logika); //priradenie liseneru k buttonu
        medzikruzie.setFocusable(false);

        JPanel bocneMenu1 = new JPanel(); //vytvorenie bočného menu pomocou JPanel
        bocneMenu1.setLayout(new GridLayout(1,3));  //nastavenie rozloženia buttonov
        bocneMenu1.add(plus); //prídamé do bočného menu oboje buttony
        bocneMenu1.add(usecka);
        bocneMenu1.add(medzikruzie);


        JButton choice = new JButton("Farba");
        choice.addActionListener(logika);
        JButton label = new JButton("Zmena farby");
        label.addActionListener(logika);

        JPanel bocneMenu2 = new JPanel(new GridLayout(2,2));
        bocneMenu2.add(choice);
        bocneMenu2.add(label);
        bocneMenu2.add(logika.getFarbaVypis());

        okno.add(bocneMenu1, BorderLayout.PAGE_START); //do okna pidáme bočne menu1 a nastavíme že má byť na vrchu
        okno.add(bocneMenu2, BorderLayout.PAGE_END); //do okna pidáme bočne menu1 a nastavíme že má byť na vrchu
        okno.setVisible(true);  //zobrazenie okna
    }
}
