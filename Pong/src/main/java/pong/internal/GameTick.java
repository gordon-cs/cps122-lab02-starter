package pong.internal;

import pong.*;
import java.util.TimerTask;
import java.util.function.Consumer;

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
        boolean bouncedLeft = ball.getX() <= canvas.field.leftEdge + canvas.ballRadius;
        boolean bouncedRight = (double) ball.getX() >= canvas.field.rightEdge - canvas.ballRadius;
        if (bouncedLeft || bouncedRight) {
            ball.bounceX();
            if (bouncedLeft) {
                GoalZone scoredInZone = canvas.field.leftGoal.zoneAt(ball.getY());
                p2.scorePoints(scoredInZone.points());
            } else {
                GoalZone scoredInZone = canvas.field.rightGoal.zoneAt(ball.getY());
                p1.scorePoints(scoredInZone.points());
            }
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
