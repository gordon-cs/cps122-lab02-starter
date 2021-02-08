/**
 * This class describes an object that is used to represent the ball
 * in a game of pong.  Each PongBall will have an x and y position.
 * Each PongBall will also have a velocity in the x direction and a
 * velocity in the y direction.
 */
public class PongBall {
  // Instance variables
  private int x;          // Current horizontal position of the ball
  private int y;          // Current vertical position of the ball
  private int xVelocity;  // Current horizontal velocity of the ball
  private int yVelocity;  // Current vertical velocity of the ball

  /**
   * Construct a new PongBall with the specified initial
   * position and velocity.
   *
   * @param initX the initial X position of the new PongBall.
   * @param initY the initial Y position of the new PongBall.
   * @param initXV the initial velocity of the new PongBall in
   *               the X direction.
   * @param initYV the initial velocity of the new PongBall in
   *               the Y Direction.
   */
  public PongBall(int initX, int initY, int initXV, int initYV) {
  }

  /**
   * Move this PongBall according to its current velocity.  This
   * method is invoked at a regular rate by the Pong application in
   * order to update the position of the ball.  The x position
   * changes by the xVelocity and the y position changes by the
   * yVelocity.
   */
  public void move() {
  }

  /**
   * Reverse the X direction of this PongBall.  This method
   * is invoked by the Pong application each time this PongBall
   * collides with a vertical obstruction such as a wall or paddle.
   */
  public void bounceX() {
    // The X direction can be reversed by changing the sign of the xVelocity.

  }

  /**
   * Reverse the Y direction of this PongBall.  This method is invoked
   * by the Pong application each time this PongBall collides with a
   * horizontal obstruction such as a wall or the top/bottom edge of
   * a paddle.
   */
  public void bounceY() {
    // The Y direction can be reversed by changing the sign of the yVelocity.
  }

  /**
   * Return the current X position of this PongBall.
   *
   * @return the X position of this PongBall.
   */
  public int getX() {
    return 150;	// STUB - REPLACE THIS LINE
  }

  /**
   * Return the current y position of this PongBall.
   *
   * @return the Y position of this PongBall.
   */
  public int getY() {
    return 80;	// STUB - REPLACE THIS LINE
  }
}
