package Problem2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testSet {

  private Set testSet;

  @BeforeEach
  void setUp() {
   testSet = new Set();
   testSet = testSet.add(1);
   testSet = testSet.add(2);
  }

  @Test
  void testEmptySet() {
    Assertions.assertEquals(new Set(), testSet.emptySet());
  }

  @Test
  void testAdd() {
    Integer size = 3;
    testSet = testSet.add(3);
    Assertions.assertEquals(size, testSet.size());
  }

  @Test
  void testIsEmpty() {
    Assertions.assertEquals(false, testSet.isEmpty());
  }

  @Test
  void testContains() {
    Assertions.assertEquals(true, testSet.contains(2));
  }

  @Test
  void testRemove() {
    Set testSet2 = testSet.remove(2);
    Assertions.assertEquals(1, testSet2.size());
    Assertions.assertEquals(false, testSet2.contains(2));
    Assertions.assertEquals(2, testSet.size());
  }

  @Test
  void testSize() {
    Integer expectedSize = 2;
    Assertions.assertEquals(expectedSize, testSet.size());
  }

  @Test
  void testEqual() {
    Set testSet3 = testSet;
    testSet3.add(1);
    testSet3.add(2);
    Assertions.assertTrue(testSet3.equals(testSet) && testSet.equals(testSet3));
  }

  @Test
  void testHashCode() {
    Set testSet3 = testSet;
    testSet3.add(1);
    testSet3.add(2);
    Assertions.assertTrue(testSet3.hashCode() == testSet.hashCode());
  }
}
