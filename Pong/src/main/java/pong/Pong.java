package pong;

import java.awt.Container;
import javax.swing.JFrame;

public class Pong {
    public static void main(String[] args) {
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

    public void show() {
        frame.setVisible(true);
        canvas.requestFocus();
    }
}
