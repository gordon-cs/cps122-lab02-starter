package pong;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author russtuck
 */
class BallTest {

  /**
   * Test of move method, of class Ball.
   */
  @Test
  void testMove() {
    Ball ball = new Ball(0, 1, 5, 10);
    ball.move();
    assertEquals(5, ball.getX());
    assertEquals(11, ball.getY());
    ball.move();
    assertEquals(10, ball.getX());
    assertEquals(21, ball.getY());
  }

  /**
   * Test of bounceX method, of class Ball.
   */
  @Test
  void testBounceX() {
    Ball ball = new Ball(0, 1, 5, 10);
    ball.bounceX();
    ball.move();
    assertEquals(-5, ball.getX());
    ball.bounceX();
    ball.move();
    assertEquals(0, ball.getX());
  }

  /**
   * Test of bounceY method, of class Ball.
   */
  @Test
  void testBounceY() {
    Ball ball = new Ball(0, 1, 5, 10);
    ball.bounceY();
    ball.move();
    assertEquals(-9, ball.getY());
    ball.bounceY();
    ball.move();
    assertEquals(1, ball.getY());
  }

  /**
   * Test of getX method, of class Ball.
   */
  @Test
  void testGetX() {
    Ball ball = new Ball(0, 1, 5, 10);
    assertEquals(0, ball.getX());
    ball = new Ball(-5, 1, 5, 10);
    assertEquals(-5, ball.getX());
  }

  /**
   * Test of getY method, of class Ball.
   */
  @Test
  void testGetY() {
    Ball ball = new Ball(0, 1, 5, 10);
    assertEquals(1, ball.getY());
    ball = new Ball(-5, 35, 5, 10);
    assertEquals(35, ball.getY());
  }

}