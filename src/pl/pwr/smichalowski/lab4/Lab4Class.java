package pl.pwr.smichalowski.lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Lab4Class extends JFrame {

    private JPanel panel;
    private JTextArea textArea;
    public final Font font = new Font("Arial", Font.PLAIN, 22);

    public Lab4Class() {

        // JFrame
        this.setTitle("Zadanie 1 i 3");
        this.setSize(700, 700);
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
                        textArea.setForeground(Color.CYAN);
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
        textArea.setBounds(200, 100, 300, 200);
        textArea.setFont(font);
        textArea.setCaretPosition(textArea.getText().length());
        textArea.setFocusable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        panel.add(textArea);
        textArea.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                int x = e.getX();
                int y = e.getY();
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


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab4Class().setVisible(true);
            }
        });
    }
}
