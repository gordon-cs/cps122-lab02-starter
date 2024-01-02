package pong;

/**
 * This class desrcibes objects that are used to track
 * the player's scores in a game of Pong. Each Score
 * object will keep the score for a single player.
 */
public class Score {
  // Instance variable
  private int score; // Current score

  /**
   * Construct a new Score object with an initial
   * score of zero points.
   */
  public Score() {
  }

  /**
   * Return the current score of this Score object.
   *
   * @return the score.
   */
  public int getScore() {
    // TODO: return current score
    return 0; // STUB - REPLACE THIS LINE
  }

  /**
   * Increase the current score of this Score object by points.
   *
   * @param points the number of points to add to the score.
   */
  public void scorePoints(int points) {
    // TODO: increase score by `points` amount
  }
}
