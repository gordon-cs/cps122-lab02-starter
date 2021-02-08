/**
 * This class describes objects that represent the paddles
 * in a Pong game.  Each PongPaddle has an (x,y) position that
 * indicates the position of the top-left corner of the paddle.
 * Each PongPaddle also has a width and a height.
 */
public class PongPaddle {
  // Instance variables
  private int x;
  private int y;
  private int width;
  private int height;

  /**
   * Construct a new PongPaddle at the specified position with the
   * specified width and height.
   *
   * @param top the Y coordinate of the top left corner of the
   *            new PongPaddle.
   * @param left the X coordinate of the top left corner of the
   *             new PongPaddle.
   * @param w the width of the new PongPaddle, measured in pixels.
   * @param h the height of the new PongPaddle, measured in pixels.
   */
  public PongPaddle(int top, int left, int w, int h) {
    y = top;
    x = left;
    width = w;
    height = h;
  }

  /**
   * Move the position of this PongPaddle up by the specified
   * number of pixels.
   *
   * @param d a number of pixels.
   */
  public void moveUp(int d) {
  }

  /**
   * Move the position of this PongPaddle down by the specified
   * number of pixels.
   *
   * @param d a number of pixels.
   */
  public void moveDown(int d) {
  }

  /**
   * Return the X coordinate of the left edge of this PongPaddle.
   *
   * @return the X coordinate of the left edge of this PongPaddle.
   */
  public int getLeftX() {
    return x;
  }

  /**
   * Return the Y coordinate of the top edge of this PongPaddle.
   *
   * @return the Y coordinate of the top edge of this PongPaddle.
   */
  public int getTopY() {
    return y;
  }

  /**
   * Return the X coordinate of the right edge of this PongPaddle.
   *
   * @return the X coordinate of the right edge of this PongPaddle.
   */
  public int getRightX() {
    return x + width - 1;
  }

  /**
   * Return the Y coordinate of the bottom edge of this PongPaddle.
   *
   * @return the Y coordinate of the bottom edge of this PongPaddle.
   */
  public int getBottomY() {
    return y + height - 1;
  }

}
