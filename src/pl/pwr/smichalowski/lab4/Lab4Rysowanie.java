package pl.pwr.smichalowski.lab4;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Lab4Rysowanie extends JFrame {

    private JPanel jpanel;
    private MyPanel plotno;
    private JLabel komunikaty;
    private JTextField komunikatText;
    private JButton kwadrat, kolo;
    public Font font = new Font("Arial", Font.PLAIN, 14);
    public Font smallFont = new Font("Arial", Font.BOLD, 11);
    public LineBorder thickBorder = new LineBorder(Color.BLACK, 3, false);

    public Lab4Rysowanie() {

        // JFrame
        this.setTitle("Rysowanie figur na plotnie");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // JPanel
        jpanel = new JPanel();
        jpanel.setLayout(null);
        this.add(jpanel);


        // plotno - Panel do rysowania
        plotno = new MyPanel();
        plotno.setBounds(20, 20, 650, 450);
        plotno.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(plotno.hasFigura()) {
                    plotno.getFigura().setX(e.getX());
                    plotno.getFigura().setY(e.getY());
                    plotno.repaint();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {
                komunikatText.setText("Mysz zostala puszczona.");
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
        jpanel.add(plotno);


        // JLabel - komunikaty
        komunikaty = new JLabel("Komunikaty:");
        komunikaty.setFont(font);
        komunikaty.setBounds(40, 480, 100, 25);
        jpanel.add(komunikaty);


        // JTextField - komunikatText
        komunikatText = new JTextField("");
        komunikatText.setFont(font);
        komunikatText.setBorder(thickBorder);
        komunikatText.setBounds(20, 505, 650, 35);
        komunikatText.setFocusable(false);
        jpanel.add(komunikatText);


        // JButton - kwadrat
        kwadrat = new JButton("Kwadrat");
        kwadrat.setFont(smallFont);
        kwadrat.setBounds(685, 150, 80, 80);
        kwadrat.setBackground(new Color(188, 246, 162));
        kwadrat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(plotno.getFigura() instanceof Kwadrat))
                    plotno.setKwadrat();
            }
        });
        jpanel.add(kwadrat);


        // JButton - kolo
        kolo = new JButton("Kolo");
        kolo.setFont(smallFont);
        kolo.setBounds(685, 250, 80, 80);
        kolo.setBackground(new Color(190, 255, 255));
        kolo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(plotno.getFigura() instanceof Kolo))
                    plotno.setKolo();
            }
        });
        jpanel.add(kolo);

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab4Rysowanie().setVisible(true);
            }
        });
    }
}
