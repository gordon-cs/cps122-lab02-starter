package pong.internal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.JPanel;

import pong.Ball;
import pong.Paddle;
import pong.Score;

public class Canvas extends JPanel implements KeyListener {
    public final Field field;
    public final int ballRadius;

    private final int width;
    private final int height;
    private final Ball ball;
    private final Paddle paddle1;
    private final Paddle paddle2;
    private final int paddleSpeed;
    private final Score player1;
    private final Score player2;
    private final Timer gameTickTimer;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;

        // Create Field

        int inlineMargin = width / 60;
        int topMargin = height / 60;
        int bottomMargin = height / 10;
        int innerGoalZoneHeight = height / 10;
        field = new Field(inlineMargin, topMargin, width - inlineMargin, height - bottomMargin, innerGoalZoneHeight);

        ballRadius = width / 75;
        ball = new Ball(width / 2, field.midpoint, width / 100, height / 75);

        int paddleHeight = height / 6;
        int paddleWidth = width / 30;
        paddleSpeed = width / 75;
        paddle1 = new Paddle(
                field.midpoint - (paddleHeight / 2),
                field.leftEdge + Field.goalWidth + paddleWidth,
                paddleWidth,
                paddleHeight);
        paddle2 = new Paddle(
                field.midpoint - (paddleHeight / 2),
                field.rightEdge - Field.goalWidth - paddleWidth,
                paddleWidth,
                paddleHeight);

        player1 = new Score();
        player2 = new Score();
        gameTickTimer = new Timer();
        this.addKeyListener(this);
    }

    // NOTE: This method is for JDK1.4 or newer and replaces
    // the deprecated isFocusTraversable defined below. When
    // compiling with JDK1.4 or newer it is recommended that
    // isFocusTraversable be removed.
    public boolean isFocusable() {
        return true;
    }

    public boolean isFocusTraversable() {
        return true;
    }

    /**
     * Return the width and height of this Canvas
     * as its preferred, minimum and maximum sizes.
     *
     * @return a new Dimension object specifying the width
     *         and height of this Canvas.
     */
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    /**
     * Return the width and height of this Canvas
     * as its preferred, minimum and maximum sizes.
     *
     * @return a new Dimension object specifying the width
     *         and height of this Canvas.
     */
    public Dimension getMinimumSize() {
        return new Dimension(width, height);
    }

    /**
     * Return the width and height of this Canvas
     * as its preferred, minimum and maximum sizes.
     *
     * @return a new Dimension object specifying the width
     *         and height of this Canvas.
     */
    public Dimension getMaximumSize() {
        return new Dimension(width, height);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.red);
        graphics.fillOval(ball.getX() - ballRadius, ball.getY() - ballRadius, ballRadius * 2,
                ballRadius * 2);
        graphics.setColor(Color.blue);
        graphics.fillRect(paddle1.getLeftX(), paddle1.getTopY(),
                paddle1.getRightX() - paddle1.getLeftX(), paddle1.getBottomY() - paddle1.getTopY());
        graphics.setColor(Color.green.darker());
        graphics.fillRect(paddle2.getLeftX(), paddle2.getTopY(),
                paddle2.getRightX() - paddle2.getLeftX(), paddle2.getBottomY() - paddle2.getTopY());
    }

    public void paintBorder(Graphics graphics) {

        graphics.setColor(Color.black);
        // draw field border
        graphics.drawRect(field.leftEdge, field.topEdge, field.width, field.height);

        field.drawGoals(graphics);

        // Draw scores
        FontMetrics fontMetrics = graphics.getFontMetrics();
        // Should be fontMetrics.getHeight(), but that doesn't work
        int fontHeight = 10;
        int bottomMargin = height - field.bottomEdge;
        int scoreBottom = height - ((bottomMargin - fontHeight) / 2);

        graphics.setColor(Color.blue);
        String player1ScoreText = "Blue: " + player1.getScore();
        graphics.drawString(player1ScoreText, field.leftEdge, scoreBottom);

        graphics.setColor(Color.green.darker());
        String player2ScoreText = "Green: " + player2.getScore();
        int player2ScoreWidth = fontMetrics.stringWidth(player2ScoreText);
        graphics.drawString(player2ScoreText, field.rightEdge - player2ScoreWidth, scoreBottom);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        switch (keyEvent.getKeyChar()) {
            case 'A', 'a' -> {
                if (paddle1.getTopY() > field.topEdge) {
                    paddle1.moveUp(paddleSpeed);
                    repaint();
                }
            }

            case 'Z', 'z' -> {
                if (paddle1.getBottomY() < field.bottomEdge) {
                    paddle1.moveDown(paddleSpeed);
                    repaint();
                }
            }

            case 'K', 'k' -> {
                if (paddle2.getTopY() > field.topEdge) {
                    paddle2.moveUp(paddleSpeed);
                    repaint();
                }
            }

            case 'M', 'm' -> {
                if (paddle2.getBottomY() < field.bottomEdge) {
                    paddle2.moveDown(paddleSpeed);
                    repaint();
                }
            }

            case 'B', 'b' -> gameTickTimer.scheduleAtFixedRate(
                    new GameTick(ball, this, paddle1, paddle2, player1, player2), 0L, 40L);
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
    }

    @Override
    public void keyReleased(KeyEvent event) {
    }
}
