package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import javax.swing.JPanel;

public class Canvas extends JPanel implements KeyListener {
    private int width;
    private int height;
    private PongBall ball;
    private PongPaddle paddle1;
    private PongPaddle paddle2;
    private PongScore player1;
    private PongScore player2;
    private Timer gameTickTimer;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.ball = new PongBall(width / 2, (height - 40) / 2 + 5, 3, 4);
        this.paddle1 = new PongPaddle((height - 40) / 2 - 20, 25, 10, 50);
        this.paddle2 = new PongPaddle((height - 40) / 2 - 20, width - 35, 10, 50);
        this.player1 = new PongScore();
        this.player2 = new PongScore();
        this.gameTickTimer = new Timer();
        this.addKeyListener(this);
    }

    public boolean isFocusable() {
        return true;
    }

    public boolean isFocusTraversable() {
        return true;
    }

    public Dimension getPreferredSize() {
        return new Dimension(this.width, this.height);
    }

    public Dimension getMinimumSize() {
        return new Dimension(this.width, this.height);
    }

    public Dimension getMaximumSize() {
        return new Dimension(this.width, this.height);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.red);
        graphics.fillOval(this.ball.getX() - 4, this.ball.getY() - 4, 8, 8);
        graphics.setColor(Color.blue);
        graphics.fillRect(this.paddle1.getLeftX(), this.paddle1.getTopY(),
                this.paddle1.getRightX() - this.paddle1.getLeftX(), this.paddle1.getBottomY() - this.paddle1.getTopY());
        graphics.setColor(Color.green.darker());
        graphics.fillRect(this.paddle2.getLeftX(), this.paddle2.getTopY(),
                this.paddle2.getRightX() - this.paddle2.getLeftX(), this.paddle2.getBottomY() - this.paddle2.getTopY());
    }

    public void paintBorder(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.drawRect(5, 5, this.width - 11, this.height - 35);
        graphics.drawLine(5, (this.height - 30) / 2 - 15, 15, (this.height - 30) / 2 - 15);
        graphics.drawLine(5, (this.height - 30) / 2 + 15, 15, (this.height - 30) / 2 + 15);
        graphics.drawString("5", 9, (this.height - 30) / 2 + 5);
        graphics.drawLine(5, (this.height - 30) / 2 - 45, 15, (this.height - 30) / 2 - 45);
        graphics.drawLine(5, (this.height - 30) / 2 + 45, 15, (this.height - 30) / 2 + 45);
        graphics.drawString("3", 9, (this.height - 30) / 2 + 5 - 30);
        graphics.drawString("3", 9, (this.height - 30) / 2 + 5 + 30);
        graphics.drawString("1", 9, (this.height - 30) / 2 + 5 - 65);
        graphics.drawString("1", 9, (this.height - 30) / 2 + 5 + 65);
        graphics.drawLine(this.width - 19, (this.height - 30) / 2 - 15, this.width - 6, (this.height - 30) / 2 - 15);
        graphics.drawLine(this.width - 19, (this.height - 30) / 2 + 15, this.width - 6, (this.height - 30) / 2 + 15);
        graphics.drawString("5", this.width - 15, (this.height - 30) / 2 + 5);
        graphics.drawLine(this.width - 19, (this.height - 30) / 2 - 45, this.width - 6, (this.height - 30) / 2 - 45);
        graphics.drawLine(this.width - 19, (this.height - 30) / 2 + 45, this.width - 6, (this.height - 30) / 2 + 45);
        graphics.drawString("3", this.width - 15, (this.height - 30) / 2 + 5 - 30);
        graphics.drawString("3", this.width - 15, (this.height - 30) / 2 + 5 + 30);
        graphics.drawString("1", this.width - 15, (this.height - 30) / 2 + 5 - 65);
        graphics.drawString("1", this.width - 15, (this.height - 30) / 2 + 5 + 65);
        graphics.setColor(Color.blue);
        graphics.drawString("Blue: " + this.player1.getScore(), 15, this.height - 10);
        graphics.setColor(Color.green.darker());
        graphics.drawString("Green: " + this.player2.getScore(), this.width - 75, this.height - 10);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        switch (keyEvent.getKeyChar()) {
            case 'A':
            case 'a':
                if (this.paddle1.getTopY() > 7) {
                    paddle1.moveUp(2);
                    repaint();
                }
                break;

            case 'Z':
            case 'z':
                if (this.paddle1.getBottomY() < height - 30) {
                    paddle1.moveDown(2);
                    repaint();
                }
                break;

            case 'K':
            case 'k':
                if (this.paddle2.getTopY() > 7) {
                    paddle2.moveUp(2);
                    repaint();
                }
                break;

            case 'M':
            case 'm':
                if (this.paddle2.getBottomY() < height - 30) {
                    paddle2.moveDown(2);
                    repaint();
                }
                break;

            case 'B':
            case 'b':
                this.gameTickTimer.scheduleAtFixedRate(
                        new GameTick(ball, this, this.paddle1, this.paddle2, this.player1, this.player2), 0L, 40L);

                break;
            default:
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
    }

    @Override
    public void keyReleased(KeyEvent event) {
    }

}
