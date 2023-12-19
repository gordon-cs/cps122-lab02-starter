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
class PaddleTest {

  /**
   * Test of moveUp method, of class Paddle.
   */
  @Test
  void testMoveUp() {
    Paddle paddle = new Paddle(5, 10, 15, 30);
    paddle.moveUp(3);
    assertEquals(2, paddle.getTopY());
    paddle.moveUp(10);
    assertEquals(-8, paddle.getTopY());
  }

  /**
   * Test of moveDown method, of class Paddle.
   */
  @Test
  void testMoveDown() {
    Paddle paddle = new Paddle(5, 10, 15, 30);
    paddle.moveDown(3);
    assertEquals(8, paddle.getTopY());
    paddle.moveDown(12);
    assertEquals(20, paddle.getTopY());
  }

  /**
   * Test of getLeftX method, of class Paddle.
   */
  @Test
  void testGetLeftX() {
    Paddle paddle = new Paddle(5, 10, 15, 30);
    assertEquals(10, paddle.getLeftX());
  }

  /**
   * Test of getTopY method, of class Paddle.
   */
  @Test
  void testGetTopY() {
    Paddle paddle = new Paddle(5, 10, 15, 30);
    assertEquals(5, paddle.getTopY());
  }

  /**
   * Test of getRightX method, of class Paddle.
   */
  @Test
  void testGetRightX() {
    Paddle paddle = new Paddle(5, 10, 15, 30);
    assertEquals(24, paddle.getRightX());
  }

  /**
   * Test of getBottomY method, of class Paddle.
   */
  @Test
  void testGetBottomY() {
    Paddle paddle = new Paddle(5, 10, 15, 30);
    assertEquals(34, paddle.getBottomY());
  }

}