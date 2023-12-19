/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pong;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author russtuck
 */
public class ScoreTest {

  /**
   * Test of getScore method, of class Score.
   * Really only tests constructor. Rest of test is in testScorePoints.
   */
  @Test
  void testGetScore() {
    Score score = new Score();
    assertEquals(0, score.getScore());
  }

  /**
   * Test of scorePoints method, of class Score.
   */
  @Test
  void testScorePoints() {
    Score score = new Score();
    score.scorePoints(5);
    assertEquals(5, score.getScore());
  }

}