package pong.internal;

import java.awt.Graphics;

public record GoalZone(int top, int bottom, int points) {
    public void draw(Graphics graphics, int leftEdge, int rightEdge, int innerGoalZoneHeight) {
        graphics.drawLine(leftEdge, top, rightEdge, top);
        graphics.drawLine(leftEdge, bottom, rightEdge, bottom);
        int goalZoneHalfStep = innerGoalZoneHeight / 2;

        String pointsString = String.valueOf(points);
        int textWidth = graphics.getFontMetrics().stringWidth(pointsString);
        int textLeft = leftEdge + ((rightEdge - leftEdge - textWidth) / 2);
        // Should be FontMetrics.getHeight(), but that is inaccurate
        int textHeightOffset = 5;
        graphics.drawString(String.valueOf(points), textLeft, bottom - goalZoneHalfStep + textHeightOffset);
        graphics.drawString(String.valueOf(points), textLeft, top + goalZoneHalfStep + textHeightOffset);
    }
}
