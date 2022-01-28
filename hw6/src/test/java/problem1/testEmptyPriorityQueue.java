package problem1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testEmptyPriorityQueue {

  private PriorityQueue test;

  @Before
  public void setUp() {
    test = new EmptyPriorityQueue();
  }

  @Test
  public void testCreateEmpty() {
    EmptyPriorityQueue test2 = new EmptyPriorityQueue();
    assertEquals(test2, test.createEmpty());
  }

  @Test
  public void testAdd(){
    PriorityQueue test2 = new NonEmptyPriorityQueue(2, "num2", new EmptyPriorityQueue());
    assertEquals(test2, test.add(2, "num2"));
  }

  @Test
  public void testIsEmpty() {
    assertEquals(true, test.isEmpty());
  }

  @Test(expected = EmptyPqException.class)
  public void testPeak() throws EmptyPqException {
      test.peek();
  }


  @Test(expected = EmptyPqException.class)
  public void testEmptyPqException() throws EmptyPqException {
      test.peek();
  }
}

