package pl.pwr.smichalowski.lab4;

import java.awt.*;

public class Kolo extends Figura {
    private final int promien = 20;
    public Kolo(int x, int y) {
        super(x, y);
    }
    public int getPromien() {
        return this.promien;
    }
    public void rysuj(Graphics2D graphics2D){
        graphics2D.fillOval(getX()-getPromien(), getY()-getPromien(), 2*getPromien(), 2*getPromien());
    }
}