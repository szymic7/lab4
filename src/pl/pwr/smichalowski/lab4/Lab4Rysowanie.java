package pl.pwr.smichalowski.lab4;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Lab4Rysowanie extends JFrame {

    private JPanel jpanel;
    private MyPanel plotno;
    private JLabel komunikaty;
    private JTextField komunikatText;
    private JButton kwadrat, kolo;
    private Figura f1;
    private int indexPrzesuwanej = -1, xPrzesuwanej, yPrzesuwanej;
    public Font font = new Font("Arial", Font.PLAIN, 14);
    public Font smallFont = new Font("Arial", Font.BOLD, 11);
    public LineBorder border = new LineBorder(Color.BLACK, 3, false);


    public Lab4Rysowanie() {

        // JFrame
        this.setTitle("Rysowanie figur na plotnie");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()){
                    case 67: // klawisz 'C' - zmiana kolorow figur
                        plotno.setColorChanged(1);
                        plotno.repaint();
                        break;
                    case 17: // klawisz 'Ctrl' - zmiana rozmiaru figur
                        if(plotno.getSizeChanged() == 0) plotno.setSizeChanged(1);
                        else if(plotno.getSizeChanged() == 1) plotno.setSizeChanged(0);
                        plotno.repaint();
                        break;
                    default:
                        System.out.println("Klawisz nieobslugiwany.");
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar() == 'c'){
                    plotno.setColorChanged(0);
                    plotno.repaint();
                }
            }

        });


        // JPanel
        jpanel = new JPanel();
        jpanel.setLayout(null);
        this.add(jpanel);


        // plotno - Panel do rysowania
        plotno = new MyPanel();
        plotno.setBounds(20, 20, 650, 450);
        jpanel.add(plotno);

        plotno.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch(plotno.getWybranaFigura()){
                    case 0:
                        break;
                    case 1:
                        f1 = new Kwadrat(e.getX(), e.getY());
                        plotno.dodajFigure(f1);
                        plotno.repaint();
                        break;
                    case 2:
                        f1 = new Kolo(e.getX(), e.getY());
                        plotno.dodajFigure(f1);
                        plotno.repaint();
                        break;
                    default:
                        System.out.println("Cos poszlo nie tak. Sprobuj narysowac figure ponownie.");
                        break;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                for(int i = 0; i < 20; i++) {
                    if(plotno.getFigura(i)!=null) {
                        Figura f = plotno.getFigura(i);
                        if (f.getX() - 20 <= e.getX() && e.getX() <= f.getX() + 20
                                && f.getY() - 20 <= e.getY() && e.getY() <= f.getY() + 20) {
                            xPrzesuwanej = e.getX() - f.getX();
                            yPrzesuwanej = e.getY() - f.getY();
                            indexPrzesuwanej = i;
                            break;
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                komunikatText.setText("Mysz zostala puszczona.");

                if(indexPrzesuwanej != -1) {
                    indexPrzesuwanej = -1;
                    xPrzesuwanej = 0;
                    yPrzesuwanej = 0;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                komunikatText.setText("Kursor znajduje sie w obszarze rysowania.");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                komunikatText.setText("Kursor opuscil obszar rysowania.");
            }

        });

        plotno.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(indexPrzesuwanej != -1) {
                    plotno.getFigura(indexPrzesuwanej).setX(e.getX() - xPrzesuwanej);
                    plotno.getFigura(indexPrzesuwanej).setY(e.getY() - yPrzesuwanej);
                    plotno.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {}

        });


        // JLabel - komunikaty
        komunikaty = new JLabel("Komunikaty:");
        komunikaty.setFont(font);
        komunikaty.setBounds(40, 480, 100, 25);
        jpanel.add(komunikaty);


        // JTextField - komunikatText
        komunikatText = new JTextField("");
        komunikatText.setFont(font);
        komunikatText.setBorder(border);
        komunikatText.setBounds(20, 505, 650, 35);
        komunikatText.setFocusable(false);
        jpanel.add(komunikatText);


        // JButton - kwadrat
        kwadrat = new JButton("Kwadrat");
        kwadrat.setFont(smallFont);
        kwadrat.setBounds(685, 150, 80, 80);
        kwadrat.setBackground(new Color(188, 246, 162));
        kwadrat.setFocusable(false);
        jpanel.add(kwadrat);
        kwadrat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plotno.setWybranaFigura(1);
                kwadrat.setBorder(border);
                kolo.setBorder(null);
            }
        });


        // JButton - kolo
        kolo = new JButton("Kolo");
        kolo.setFont(smallFont);
        kolo.setBounds(685, 250, 80, 80);
        kolo.setBackground(new Color(190, 255, 255));
        kolo.setFocusable(false);
        jpanel.add(kolo);
        kolo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plotno.setWybranaFigura(2);
                kwadrat.setBorder(null);
                kolo.setBorder(border);
            }
        });

    } // koniec konstruktora obiektu klasy Lab4Rysowanie


    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab4Rysowanie().setVisible(true);
            }
        });
    }

} // koniec klasy Lab4Rysowanie
