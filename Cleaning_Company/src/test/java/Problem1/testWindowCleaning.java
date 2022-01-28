package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testWindowCleaning {

  private String expectedPropertyAddress;
  private PropertySize expectedPropertySize;
  private Integer expectedNumOfService;
  private Integer expectedNumOfFloor;
  private WindowCleaning testWindowCleaning;
  private Double expectedPrice;

  @BeforeEach
  void setUp() throws InvalidFloorException {
    expectedPropertyAddress = "123 Hill St, Seattle";
    expectedPropertySize = PropertySize.MEDIUM;
    expectedNumOfService = 9;
    expectedNumOfFloor = 2;
    testWindowCleaning = new WindowCleaning(expectedPropertyAddress, expectedPropertySize, true, expectedNumOfService, expectedNumOfFloor);
  }

  @Test
  void testInValidNumOfFloorException() {
    Assertions.assertThrows(InvalidFloorException.class, () ->
        new WindowCleaning(expectedPropertyAddress, expectedPropertySize, true, expectedNumOfService, 4));
  }

  @Test
  void testCalculatePrice() {
    expectedPrice =84.0;
    Assertions.assertEquals(expectedPrice, testWindowCleaning.calculatePrice());
  }

  @Test
  void testEqual() throws InvalidFloorException {
    WindowCleaning test = new WindowCleaning(expectedPropertyAddress, expectedPropertySize, true, expectedNumOfService, expectedNumOfFloor);
    Assertions.assertTrue(test.equals(testWindowCleaning) && testWindowCleaning.equals(test));
  }

  @Test
  void testHashCode() throws InvalidFloorException {
    WindowCleaning test = new WindowCleaning(expectedPropertyAddress, expectedPropertySize, true, expectedNumOfService, expectedNumOfFloor);
    Assertions.assertTrue(test.hashCode() == testWindowCleaning.hashCode());
  }
  
//  @Test
//  void testGetPropertyAddress() {
//    Assertions.assertEquals(expectedPropertyAddress, testWindowCleaning.getPropertyAddress());
//  }
//
//  @Test
//  void testGetPropertySize() {
//    Assertions.assertEquals(expectedPropertySize, testWindowCleaning.getPropertySize());
//  }
//
//  @Test
//  void testIsMonthlyService() {
//    Assertions.assertEquals(false, testWindowCleaning.isMonthlyService());
//  }
//
//  @Test
//  void testGetNumOfService() {
//    Assertions.assertEquals(expectedNumOfService, testWindowCleaning.numOfService);
  //}

}
