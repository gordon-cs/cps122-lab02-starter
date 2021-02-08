/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.TestCase;

/**
 *
 * @author russtuck
 */
public class PongScoreTest extends TestCase {

  public PongScoreTest(String testName) {
    super(testName);
  }

  /**
   * Test of getScore method, of class PongScore.
   * Really only tests constructor.  Rest of test is in testScorePoints.
   */
  public void testGetScore() {
    PongScore score = new PongScore();
    assertEquals(0, score.getScore());
  }

  /**
   * Test of scorePoints method, of class PongScore.
   */
  public void testScorePoints() {
    PongScore score = new PongScore();
    score.scorePoints(5);
    assertEquals(5, score.getScore());
  }

}
