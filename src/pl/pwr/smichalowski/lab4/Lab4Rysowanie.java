package pl.pwr.smichalowski.lab4;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Lab4Rysowanie extends JFrame {

    private JPanel jpanel;
    private JPanel plotno;
    private JLabel komunikaty;
    private JTextField komunikatText;
    private JButton kwadrat, trojkat;
    public Font font = new Font("Arial", Font.PLAIN, 14);
    public Font smallFont = new Font("Arial", Font.BOLD, 11);
    public LineBorder thinBorder = new LineBorder(Color.BLACK, 5, true);
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


        // plotno - JPanel do rysowania
        plotno = new JPanel();
        plotno.setBounds(20, 20, 650, 450);
        plotno.setBorder(thinBorder);
        plotno.setBackground(new Color(211, 204, 191));
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
        jpanel.add(kwadrat);


        // JButton - trojkat
        trojkat = new JButton("Trojkat");
        trojkat.setFont(smallFont);
        trojkat.setBounds(685, 250, 80, 80);
        trojkat.setBackground(new Color(190, 255, 255));
        jpanel.add(trojkat);

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
