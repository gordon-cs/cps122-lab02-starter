package pong;

import java.util.TimerTask;

public class GameTick extends TimerTask {
    private Ball ball;
    private Canvas canvas;
    private Score p1;
    private Score p2;
    private Paddle paddle1;
    private Paddle paddle2;

    public GameTick(Ball ball, Canvas canvas, Paddle paddle1, Paddle paddle2, Score player1,
            Score player2) {
        this.ball = ball;
        this.canvas = canvas;
        this.p1 = player1;
        this.p2 = player2;
        this.paddle1 = paddle1;
        this.paddle2 = paddle2;
    }

    public void run() {
        if (ball.getX() <= 9 || (double) ball.getX() >= canvas.getBounds().getWidth() - 5.0 - 4.0) {
            ball.bounceX();
            if (ball.getX() <= 9) {
                if (!((double) ball.getY() <= (canvas.getBounds().getHeight() - 30.0) / 2.0 - 45.0)
                        && !((double) ball.getY() >= (canvas.getBounds().getHeight() - 30.0) / 2.0 + 45.0)) {
                    if ((double) ball.getY() >= (canvas.getBounds().getHeight() - 30.0) / 2.0 - 15.0
                            && (double) ball.getY() <= (canvas.getBounds().getHeight() - 30.0) / 2.0 + 15.0) {
                        p2.scorePoints(5);
                    } else {
                        p2.scorePoints(3);
                    }
                } else {
                    p2.scorePoints(1);
                }
            } else if (!((double) ball.getY() <= (canvas.getBounds().getHeight() - 30.0) / 2.0 - 45.0)
                    && !((double) ball.getY() >= (canvas.getBounds().getHeight() - 30.0) / 2.0 + 45.0)) {
                if ((double) ball.getY() >= (canvas.getBounds().getHeight() - 30.0) / 2.0 - 15.0
                        && (double) ball.getY() <= (canvas.getBounds().getHeight() - 30.0) / 2.0 + 15.0) {
                    p1.scorePoints(5);
                } else {
                    p1.scorePoints(3);
                }
            } else {
                p1.scorePoints(1);
            }

            ball.move();
        }

        if (ball.getY() <= 9 || (double) ball.getY() >= canvas.getBounds().getHeight() - 32.0 - 4.0) {
            ball.bounceY();
        }

        if (ball.getY() >= paddle1.getTopY() && ball.getY() <= paddle1.getBottomY()
                && ball.getX() >= paddle1.getLeftX() - 4
                && ball.getX() <= paddle1.getRightX() + 4) {
            ball.bounceX();
            ball.move();
        } else if (ball.getY() >= paddle1.getTopY() - 4 && ball.getY() <= paddle1.getBottomY() + 4
                && ball.getX() >= paddle1.getLeftX() && ball.getX() <= paddle1.getRightX()) {
            ball.bounceY();
            ball.move();
        } else if (ball.getY() >= paddle1.getTopY() - 4 && ball.getY() <= paddle1.getBottomY() + 4
                && ball.getX() >= paddle1.getLeftX() - 4
                && ball.getX() <= paddle1.getRightX() + 4) {
            ball.bounceY();
            ball.bounceX();
            ball.move();
        }

        if (ball.getY() >= paddle2.getTopY() && ball.getY() <= paddle2.getBottomY()
                && ball.getX() >= paddle2.getLeftX() - 4
                && ball.getX() <= paddle2.getRightX() + 4) {
            ball.bounceX();
            ball.move();
        } else if (ball.getY() >= paddle2.getTopY() - 4 && ball.getY() <= paddle2.getBottomY() + 4
                && ball.getX() >= paddle2.getLeftX() && ball.getX() <= paddle2.getRightX()) {
            ball.bounceY();
            ball.move();
        } else if (ball.getY() >= paddle2.getTopY() - 4 && ball.getY() <= paddle2.getBottomY() + 4
                && ball.getX() >= paddle2.getLeftX() - 4
                && ball.getX() <= paddle2.getRightX() + 4) {
            ball.bounceY();
            ball.bounceX();
            ball.move();
        }

        ball.move();
        canvas.repaint();
    }
}
