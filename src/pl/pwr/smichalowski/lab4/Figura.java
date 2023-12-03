package pl.pwr.smichalowski.lab4;

import java.awt.*;

public abstract class Figura {
    private int x;
    private int y;
    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public abstract void rysuj(Graphics2D graphics2D);
    public abstract void rysujDuze(Graphics2D graphics2D);
}
