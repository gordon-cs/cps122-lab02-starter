package pong.internal;

import java.awt.Graphics;

public record Goal(int leftEdge, int rightEdge, GoalZone inner, GoalZone middle, GoalZone outer) {
    public void draw(Graphics graphics, int innerGoalZoneHeight) {
        inner.draw(graphics, leftEdge, rightEdge, innerGoalZoneHeight);
        middle.draw(graphics, leftEdge, rightEdge, innerGoalZoneHeight);
        outer.draw(graphics, leftEdge, rightEdge, innerGoalZoneHeight);
    }

    public GoalZone zoneAt(int y) {
        if (y >= middle.top() && y <= middle.bottom()) {
            if (y >= inner.top() && y <= inner.bottom()) {
                return inner;
            } else {
                return middle;
            }
        } else {
            return outer;
        }
    }
}