package pong.internal;

import java.awt.Graphics;

public class Field {
    public final int leftEdge;
    public final int rightEdge;
    public final int topEdge;
    public final int bottomEdge;
    public final int width;
    public final int height;
    public final int midpoint;
    public final Goal leftGoal;
    public final Goal rightGoal;
    public static int goalWidth = 15;

    private final int innerGoalZoneHeight;

    public Field(int leftEdge, int topEdge, int rightEdge, int bottomEdge, int innerGoalZoneHeight) {
        this.leftEdge = leftEdge;
        this.topEdge = topEdge;
        this.rightEdge = rightEdge;
        this.bottomEdge = bottomEdge;
        this.width = rightEdge - leftEdge;
        this.height = bottomEdge - topEdge;
        this.midpoint = height / 2 + topEdge;
        this.innerGoalZoneHeight = innerGoalZoneHeight;
        int goalZoneHalfStep = innerGoalZoneHeight / 2;

        GoalZone innerZone = new GoalZone(midpoint - goalZoneHalfStep, midpoint + goalZoneHalfStep, 5);
        GoalZone middleZone = new GoalZone(midpoint - (3 * goalZoneHalfStep), midpoint + (3 * goalZoneHalfStep), 3);
        GoalZone outerZone = new GoalZone(topEdge, bottomEdge, 1);

        leftGoal = new Goal(leftEdge, leftEdge + goalWidth, innerZone, middleZone, outerZone);
        rightGoal = new Goal(rightEdge - goalWidth, rightEdge, innerZone, middleZone, outerZone);
    }

    /**
     * Draw the goal for one side of the field.
     * 
     * The goal has 5 zones divided by lines that are the same width as the goal.
     * The innermost zone is worth 5 points, the two zones above and below it are
     * worth 3 points, and the outermost zones are worth 1 point.
     * <br >
     * <br >
     * Drawn horizontally, it would resemble this: |---1-|-3-|-5-|-3-|-1---|
     * 
     * @param graphics the graphics to draw the goal onto
     * @param goalLeft the X coordinate for the left side of the goal
     */
    public void drawGoals(Graphics graphics) {
        leftGoal.draw(graphics, innerGoalZoneHeight);
        rightGoal.draw(graphics, innerGoalZoneHeight);
    }

}
