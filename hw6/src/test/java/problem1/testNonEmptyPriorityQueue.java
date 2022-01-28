package problem1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testNonEmptyPriorityQueue {

  private String expectedValue;
  private Integer expectedPriority;
  private PriorityQueue testPQ;

  @Before
  public void setUp() {
      expectedPriority = 1;
      expectedValue = "num1";
      testPQ = new EmptyPriorityQueue();
      testPQ = testPQ.add(expectedPriority, expectedValue);
  }

  @Test
  public void testCreateEmpty() {
    assertEquals(new EmptyPriorityQueue(), testPQ.createEmpty());
  }

  @Test
  public void testAdd(){
    PriorityQueue testPQ2 = new NonEmptyPriorityQueue(2, "num2", testPQ);
    assertEquals(testPQ2, testPQ.add(2, "num2"));
  }

  @Test
  public void testPeak() throws EmptyPqException {
    testPQ = testPQ.add(2, "num2");
    assertEquals("num2", testPQ.peek());
  }

  @Test
  public void testIsEmpty() {
    assertEquals(false, testPQ.isEmpty());
  }


}