package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class testNonEmptyBagOfWords {
  private String expectedWords;
  private BagOfWords test;

  @Before
  public void setUp() throws Exception {
    expectedWords = "hello";
    test = new EmptyBagOfWords();
    test= test.add(expectedWords);
  }

  @Test
  public void testEmptyBagOfWords() {
    BagOfWords test1 = new EmptyBagOfWords();
    assertEquals(test1, test.emptyBagOfWords());
  }

  @Test
  public void testIsEmpty() {
    assertEquals(false, test.isEmpty());
  }

  @Test
  public void testContains() {
    assertEquals(true, test.contains("hello"));
  }

  @Test
  public void testAdd() {
    assertEquals(true, test.add("world").contains("world"));
  }

  @Test
  public void testSize() {
    Integer expectedSize = 1;
    assertEquals(expectedSize, test.size());
  }

  @Test
  public void testEqual() {
    BagOfWords test2 = new NonEmptyBagOfWords("hello", new EmptyBagOfWords());
    BagOfWords test3 = new NonEmptyBagOfWords("world", new EmptyBagOfWords());
    test2 = test2.add("world");
    test3 = test3.add("hello");
    assertTrue(test3.equals(test2) && test2.equals(test3));
  }

  @Test
  public void testToString() {
    test = test.add("world");
    String test2 = "NonEmptyBagOfWords{words='world', rest=NonEmptyBagOfWords{words='hello', rest=problem2.EmptyBagOfWords@a0b6303}}";
    assertEquals(test2, test.toString());
  }
}
