package pl.pwr.smichalowski.lab4.zad1;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Lab4Frame extends JFrame {

    private JPanel panel;
    private JTextArea textArea;
    private final Font font = new Font("Arial", Font.PLAIN, 20);
    private int x, y;

    public Lab4Frame() {

        // JFrame
        this.setTitle("Zadanie 1 i 3");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'a':
                        textArea.setForeground(Color.RED);
                        break;
                    case 'b':
                        textArea.setForeground(Color.BLUE);
                        break;
                    case 'c':
                        textArea.setText("");
                        textArea.setForeground(Color.BLACK);
                        break;
                    default:
                        System.out.println("Przycisk '" + e.getKeyChar() + "' nie jest obslugiwany.");
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}

        });


        // JPanel
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);


        // textArea
        textArea = new JTextArea("Przykladowy tekst");
        textArea.setBounds(100, 50, 300, 200);
        textArea.setBorder(new LineBorder(Color.BLACK, 2, false));
        textArea.setFont(font);
        textArea.setCaretPosition(textArea.getText().length());
        textArea.setFocusable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        panel.add(textArea);
        textArea.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                x = e.getX();
                y = e.getY();
                System.out.println("Wspolrzedne klikniecia: x = " + x + ", y = " + y);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                textArea.setFocusable(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                textArea.setFocusable(false);
            }

        });


    } // koniec konstruktora obiektu klasy Lab4Class


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab4Frame().setVisible(true);
            }
        });
    }

} // koniec klasy Lab4Class
