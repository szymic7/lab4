package pl.pwr.smichalowski.lab4;

import java.awt.*;

public class Kwadrat extends Figura {
    private final int bok = 40;

    public Kwadrat(int x, int y){
        super(x, y);
    }

    public int getBok() {
        return this.bok;
    }

    public void rysuj(Graphics2D graphics2D) {
        graphics2D.fillRect(this.getX()-(this.getBok()/2), this.getY()-(this.getBok()/2), bok, bok);
    }

    public void rysujDuze(Graphics2D graphics2D) {
        graphics2D.fillRect(this.getX()-(this.getBok()), this.getY()-(this.getBok()), 2*bok, 2*bok);
    }

}
