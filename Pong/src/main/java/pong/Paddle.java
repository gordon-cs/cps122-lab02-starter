package pong;

/**
 * This class describes objects that represent the paddles
 * in a Pong game. Each Paddle has an (x,y) position that
 * indicates the position of the top-left corner of the paddle.
 * Each Paddle also has a width and a height.
 */
public class Paddle {
  public int speed;
  // Instance variables
  private int x;
  private int y;
  private int width;
  private int height;

  /**
   * Construct a new Paddle at the specified position with the
   * specified width and height.
   *
   * @param top  the Y coordinate of the top left corner of the
   *             new Paddle.
   * @param left the X coordinate of the top left corner of the
   *             new Paddle.
   * @param w    the width of the new Paddle, measured in pixels.
   * @param h    the height of the new Paddle, measured in pixels.
   */
  public Paddle(int speed, int top, int left, int w, int h) {
    this.speed = speed;
    y = top;
    x = left;
    width = w;
    height = h;
  }

  /**
   * Move the position of this Paddle up by the specified
   * number of pixels.
   *
   * @param d a number of pixels.
   */
  public void moveUp(int d) {
    y -= d;
  }

  /**
   * Move the position of this Paddle down by the specified
   * number of pixels.
   *
   * @param d a number of pixels.
   */
  public void moveDown(int d) {
    y += d;
  }

  /**
   * Return the X coordinate of the left edge of this Paddle.
   *
   * @return the X coordinate of the left edge of this Paddle.
   */
  public int getLeftX() {
    return x;
  }

  /**
   * Return the Y coordinate of the top edge of this Paddle.
   *
   * @return the Y coordinate of the top edge of this Paddle.
   */
  public int getTopY() {
    return y;
  }

  /**
   * Return the X coordinate of the right edge of this Paddle.
   *
   * @return the X coordinate of the right edge of this Paddle.
   */
  public int getRightX() {
    return x + width - 1;
  }

  /**
   * Return the Y coordinate of the bottom edge of this Paddle.
   *
   * @return the Y coordinate of the bottom edge of this Paddle.
   */
  public int getBottomY() {
    return y + height - 1;
  }

}
