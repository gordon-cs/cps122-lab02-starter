package pong.internal;

import java.util.TimerTask;
import java.util.function.Consumer;

import pong.Ball;
import pong.Paddle;
import pong.Score;

public class GameTick extends TimerTask {
    private final Ball ball;
    private final Canvas canvas;
    private final Score p1;
    private final Score p2;
    private final Paddle paddle1;
    private final Paddle paddle2;

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

        // There is some bad hard coding here that should be
        // replaced with calls the the Canvas to determine
        // when the ball hits the borders!

        // Also there are thread synchronization issues with the
        // paddle motion and the ball motion that lead to the ball
        // occasionally getting stuck to the paddle. Right now
        // it seems that the ball will always disloge itself,
        // particuarly if the paddle is moved.

        boolean bouncedLeft = ball.getX() <= canvas.field.leftEdge + canvas.ballRadius;
        boolean bouncedRight = (double) ball.getX() >= canvas.field.rightEdge - canvas.ballRadius;
        if (bouncedLeft || bouncedRight) {
            if (bouncedLeft) {
                GoalZone scoredInZone = canvas.field.leftGoal.zoneAt(ball.getY());
                p2.scorePoints(scoredInZone.points());
            } else {
                GoalZone scoredInZone = canvas.field.rightGoal.zoneAt(ball.getY());
                p1.scorePoints(scoredInZone.points());
            }
            ball.bounceX();
            ball.move();
            canvas.repaint();
            return;
        }

        boolean bouncedTop = ball.getY() <= canvas.field.topEdge + canvas.ballRadius;
        boolean bouncedBottom = ball.getY() >= canvas.field.bottomEdge + canvas.ballRadius;
        if (bouncedTop || bouncedBottom) {
            ball.bounceY();
            ball.move();
            canvas.repaint();
            return;
        }

        Consumer<Paddle> checkPaddleBounce = (paddle) -> {
            if (ball.getY() >= paddle.getTopY() && ball.getY() <= paddle.getBottomY()
                    && ball.getX() >= paddle.getLeftX() - canvas.ballRadius
                    && ball.getX() <= paddle.getRightX() + canvas.ballRadius) {
                ball.bounceX();
            } else if (ball.getY() >= paddle.getTopY() - canvas.ballRadius
                    && ball.getY() <= paddle.getBottomY() + canvas.ballRadius
                    && ball.getX() >= paddle.getLeftX() && ball.getX() <= paddle.getRightX()) {
                ball.bounceY();
            } else if (ball.getY() >= paddle.getTopY() - canvas.ballRadius
                    && ball.getY() <= paddle.getBottomY() + canvas.ballRadius
                    && ball.getX() >= paddle.getLeftX() - canvas.ballRadius
                    && ball.getX() <= paddle.getRightX() + canvas.ballRadius) {
                ball.bounceY();
                ball.bounceX();
            }
        };

        checkPaddleBounce.accept(paddle1);
        checkPaddleBounce.accept(paddle2);

        ball.move();
        canvas.repaint();
    }
}
