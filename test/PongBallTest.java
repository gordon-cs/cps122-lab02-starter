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
public class PongBallTest extends TestCase {

  public PongBallTest(String testName) {
    super(testName);
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  /**
   * Test of move method, of class PongBall.
   */
  public void testMove() {
    PongBall ball = new PongBall(0, 1, 5, 10);
    ball.move();
    assertEquals(5, ball.getX());
    assertEquals(11, ball.getY());
    ball.move();
    assertEquals(10, ball.getX());
    assertEquals(21, ball.getY());
  }

  /**
   * Test of bounceX method, of class PongBall.
   */
  public void testBounceX() {
    PongBall ball = new PongBall(0, 1, 5, 10);
    ball.bounceX();
    ball.move();
    assertEquals(-5, ball.getX());
    ball.bounceX();
    ball.move();
    assertEquals(0, ball.getX());
  }

  /**
   * Test of bounceY method, of class PongBall.
   */
  public void testBounceY() {
    PongBall ball = new PongBall(0, 1, 5, 10);
    ball.bounceY();
    ball.move();
    assertEquals(-9, ball.getY());
    ball.bounceY();
    ball.move();
    assertEquals(1, ball.getY());
  }

  /**
   * Test of getX method, of class PongBall.
   */
  public void testGetX() {
    PongBall ball = new PongBall(0, 1, 5, 10);
    assertEquals(0, ball.getX());
    ball = new PongBall(-5, 1, 5, 10);
    assertEquals(-5, ball.getX());
  }

  /**
   * Test of getY method, of class PongBall.
   */
  public void testGetY() {
    PongBall ball = new PongBall(0, 1, 5, 10);
    assertEquals(1, ball.getY());
    ball = new PongBall(-5, 35, 5, 10);
    assertEquals(35, ball.getY());
  }

}
