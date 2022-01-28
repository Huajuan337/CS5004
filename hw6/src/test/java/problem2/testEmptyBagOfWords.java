package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testEmptyBagOfWords {

  private EmptyBagOfWords test;

  @Before
  public void setUp() throws Exception {
    test = new EmptyBagOfWords();
  }

  @Test
  public void testEmptyBagOfWords() {
    BagOfWords test2 = new EmptyBagOfWords();

    assertEquals(test2,test.emptyBagOfWords());
  }

  @Test
  public void testIsEmpty() {

    assertEquals(true, test.isEmpty());
  }

  @Test
  public void testContains() {

    assertEquals(false, test.contains("hello"));
  }

  @Test
  public void testAdd() {
    assertEquals(true, test.add("world").contains("world"));
  }

  @Test
  public void testSize() {
    Integer expectedSize = 0;
    assertEquals(expectedSize, test.size());
  }

  @Test
  public void testRemove() {
    //test = test.add("hello");
    assertEquals(test, test.remove(""));
  }

  @Test
  public void testEquals() {
    BagOfWords test2 = new EmptyBagOfWords();
    BagOfWords test3 = new EmptyBagOfWords();
    assertTrue(test3.equals(test2) && test2.equals(test3));
  }
}
