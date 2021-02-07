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
public class PongPaddleTest extends TestCase {

  public PongPaddleTest(String testName) {
    super(testName);
  }

  /**
   * Test of moveUp method, of class PongPaddle.
   */
  public void testMoveUp() {
    PongPaddle paddle = new PongPaddle(5, 10, 15, 30);
    paddle.moveUp(3);
    assertEquals(2, paddle.getTopY());
    paddle.moveUp(10);
    assertEquals(-8, paddle.getTopY());
  }

  /**
   * Test of moveDown method, of class PongPaddle.
   */
  public void testMoveDown() {
    PongPaddle paddle = new PongPaddle(5, 10, 15, 30);
    paddle.moveDown(3);
    assertEquals(8, paddle.getTopY());
    paddle.moveDown(12);
    assertEquals(20, paddle.getTopY());
  }

  /**
   * Test of getLeftX method, of class PongPaddle.
   */
  public void testGetLeftX() {
    PongPaddle paddle = new PongPaddle(5, 10, 15, 30);
    assertEquals(10, paddle.getLeftX());
  }

  /**
   * Test of getTopY method, of class PongPaddle.
   */
  public void testGetTopY() {
    PongPaddle paddle = new PongPaddle(5, 10, 15, 30);
    assertEquals(5, paddle.getTopY());
  }

  /**
   * Test of getRightX method, of class PongPaddle.
   */
  public void testGetRightX() {
    PongPaddle paddle = new PongPaddle(5, 10, 15, 30);
    assertEquals(24, paddle.getRightX());
  }

  /**
   * Test of getBottomY method, of class PongPaddle.
   */
  public void testGetBottomY() {
    PongPaddle paddle = new PongPaddle(5, 10, 15, 30);
    assertEquals(34, paddle.getBottomY());
  }

}
