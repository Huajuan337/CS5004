package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testCleaning{

  private String expectedPropertyAddress;
  private PropertySize expectedPropertySize;
  private Integer expectedNumOfService;
  private Integer expectedNumOfPets;
  private Cleaning testCleaning;
  private Double expectedPrice;

  @BeforeEach
  void setUp() {
    expectedPropertyAddress = "123 Hill St, Seattle";
    expectedPropertySize = PropertySize.SMALL;
    expectedNumOfService = 3;
    expectedNumOfPets = 1;
    testCleaning = new Cleaning(expectedPropertyAddress, expectedPropertySize, false, expectedNumOfService, expectedNumOfPets);
  }

  @Test
  void testCalculatePrice() {
    expectedPrice = 84.0;
    Assertions.assertEquals(expectedPrice, testCleaning.calculatePrice());
  }

  @Test
  void testEqual() {
    Cleaning test = new Cleaning(expectedPropertyAddress, expectedPropertySize, false, expectedNumOfService, expectedNumOfPets);
    Assertions.assertTrue(testCleaning.equals(test) && test.equals(testCleaning));
  }

  @Test
  void testHashCode() {
    Cleaning test = new Cleaning(expectedPropertyAddress, expectedPropertySize, false, expectedNumOfService, expectedNumOfPets);
    Assertions.assertTrue(testCleaning.hashCode() == test.hashCode());
  }
}
