package pl.pwr.smichalowski.lab4;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private Graphics2D g2d;
    private int wybranaFigura = 0, colorChanged = 0, sizeChanged = 0;
    private Figura[] narysowaneFigury = new Figura[20];

    public MyPanel() {
        this.setBackground(new Color(169, 162, 162));
        this.setLayout(null);
        this.setFocusable(false);
    }

    public int getWybranaFigura() {
        return this.wybranaFigura;
    }

    public void setWybranaFigura(int i) {
        this.wybranaFigura = i;
    }

    public void setColorChanged(int x) {
        this.colorChanged = x;
    }

    public int getSizeChanged() {
        return this.sizeChanged;
    }

    public void setSizeChanged(int y) {
        this.sizeChanged = y;
    }

    public Figura getFigura(int index) {
        return narysowaneFigury[index];
    }

    public void dodajFigure(Figura f) {
        for(int i = 0; i < 20; i++) {
            if(narysowaneFigury[i]==null) {
                narysowaneFigury[i] = f;
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        try {
            for(int i = 0; i < 20; i++) {

                if (narysowaneFigury[i] == null) return;

                if(colorChanged == 0) {
                    if (narysowaneFigury[i] instanceof Kwadrat)
                        g2d.setColor(new Color(188, 246, 162));
                    else if (narysowaneFigury[i] instanceof Kolo)
                        g2d.setColor(new Color(190, 255, 255));
                } else if(colorChanged == 1) {
                    if (narysowaneFigury[i] instanceof Kwadrat)
                        g2d.setColor(new Color(198, 143, 213));
                    else if (narysowaneFigury[i] instanceof Kolo)
                        g2d.setColor(new Color(255, 250, 132));
                }

                if(this.sizeChanged == 0) narysowaneFigury[i].rysuj(g2d);
                else if(this.sizeChanged == 1) narysowaneFigury[i].rysujDuze(g2d);
            }
        } finally {
            g2d.dispose();
        }
    }

}
