package pong;

/**
 * This class describes an object that is used to represent the ball
 * in a game of pong. Each Ball will have an x and y position.
 * Each Ball will also have a velocity in the x direction and a
 * velocity in the y direction.
 */
public class Ball {
  // Instance variables
  private int x; // Current horizontal position of the ball
  private int y; // Current vertical position of the ball
  private int xVelocity; // Current horizontal velocity of the ball
  private int yVelocity; // Current vertical velocity of the ball

  /**
   * Construct a new Ball with the specified initial
   * position and velocity.
   * 
   * @param initX  the initial X position of the new Ball.
   * @param initY  the initial Y position of the new Ball.
   * @param initXV the initial velocity of the new Ball in
   *               the X direction.
   * @param initYV the initial velocity of the new Ball in
   *               the Y Direction.
   */
  public Ball(int initX, int initY, int initXV, int initYV) {
    // TODO: Complete constructor by assigning all initial properties
  }

  /**
   * Move this Ball according to its current velocity. This
   * method is invoked at a regular rate by the Pong application in
   * order to update the position of the ball. The x position
   * changes by the xVelocity and the y position changes by the
   * yVelocity.
   */
  public void move() {
    // TODO: Move the ball
  }

  /**
   * Reverse the X direction of this Ball. This method
   * is invoked by the Pong application each time this Ball
   * collides with a vertical obstruction such as a wall or paddle.
   */
  public void bounceX() {
    // TODO: Bounce in the X direction. The X direction can be reversed by changing
    // the sign of the xVelocity.
  }

  /**
   * Reverse the Y direction of this Ball. This method is invoked
   * by the Pong application each time this Ball collides with a
   * horizontal obstruction such as a wall or the top/bottom edge of
   * a paddle.
   */
  public void bounceY() {
    // TODO: Bounce in the Y direction. The Y direction can be reversed by changing
    // the sign of the yVelocity.
  }

  /**
   * Return the current X position of this Ball.
   *
   * @return the X position of this Ball.
   */
  public int getX() {
    // TODO: return actual current x value
    return 150; // STUB - REPLACE THIS LINE
  }

  /**
   * Return the current y position of this Ball.
   *
   * @return the Y position of this Ball.
   */
  public int getY() {
    // TODO: return actual current y value
    return 150; // STUB - REPLACE THIS LINE
  }
}
