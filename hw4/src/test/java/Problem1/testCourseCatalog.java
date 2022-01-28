package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testCourseCatalog {
  private Course course1;
  private Course course2;
  private Course course3;
  private CourseCatalog testCourseCatalog;

  @BeforeEach
  void setUp() {
    course1 = new Course("Math", "", 100);
    course2 = new Course("English", "", 200);
    course3 = new Course("CS", "", 300);
    testCourseCatalog = new CourseCatalog();
    testCourseCatalog.append(course1);
    testCourseCatalog.append(course2);
  }

  @Test
  void testAppend() throws InvalidIndexException {
    testCourseCatalog.append(course1);
    Assertions.assertEquals(course1, testCourseCatalog.get(testCourseCatalog.indexOf(course1)));
  }


  @Test
  void testIndexOf() {
    int expectedIndex = 0;
    Assertions.assertEquals(expectedIndex, testCourseCatalog.indexOf(course1));
  }

  @Test
  void testIsEmpty() {
    Assertions.assertEquals(false, testCourseCatalog.isEmpty());
  }

  @Test
  void testCount() {
    int expectedSize = 2;
    Assertions.assertEquals(expectedSize, testCourseCatalog.count());
  }

  @Test
  void testGet() throws InvalidIndexException {
    Assertions.assertEquals(course1, testCourseCatalog.get(0));
  }

  @Test
  void testContains() {
    Assertions.assertEquals(true, testCourseCatalog.contains(course2));
  }

  @Test
  void testRemove() throws CourseNotFoundException {
    testCourseCatalog.remove(course1);
    Assertions.assertEquals(false, testCourseCatalog.contains(course1));
    Assertions.assertEquals(1, testCourseCatalog.count());
  }

  @Test
  void testInvalidIndexException() {
    Assertions.assertThrows(InvalidIndexException.class, ()->
        testCourseCatalog.get(10000));
  }

  @Test
  void testCourseNotFound() {
    Assertions.assertThrows(CourseNotFoundException.class, ()->
        testCourseCatalog.remove(course3));
  }

  @Test
  void testEqual() {
    CourseCatalog testCourseCatalog2 = new CourseCatalog();
    testCourseCatalog2.append(course1);
    testCourseCatalog2.append(course2);

    Assertions.assertTrue(testCourseCatalog2.equals(testCourseCatalog) && testCourseCatalog.equals(testCourseCatalog2));
  }

  @Test
  void testHashCode() {
    CourseCatalog testCourseCatalog2 = new CourseCatalog();
    testCourseCatalog2.append(course1);
    testCourseCatalog2.append(course2);

    Assertions.assertTrue(testCourseCatalog2.hashCode() == testCourseCatalog.hashCode());
  }
}
