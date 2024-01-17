package pong.internal;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Pong {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Pong pong = new Pong(600, 600);
        pong.show();
    }

    private Canvas canvas;
    private JFrame frame = new JFrame("Gordon CS Pong");

    public Pong(int width, int height) {
        canvas = new Canvas(width, height);
        Container container = frame.getContentPane();
        container.add(canvas, "Center");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocation(100, 100);
    }

    /**
     * Display this Table on the screen.
     */
    public void show() {
        frame.setVisible(true);
        canvas.requestFocus();
    }
}
