package problem2;

import Problem2.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testPerson {

  private String expectedFirstName;
  private String expectedLastName;
  private Person testPerson;

  @BeforeEach
  void setUp() {
    expectedFirstName = "J.K.";
    expectedLastName = "Rowling";
    testPerson = new Person(expectedFirstName, expectedLastName);
  }

  @Test
  void testGetFirstName() {
    Assertions.assertEquals(expectedFirstName, testPerson.getFirstName());
  }

  @Test
  void testGetLastName() {
    Assertions.assertEquals(expectedLastName, testPerson.getLastName());
  }
}
