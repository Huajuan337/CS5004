package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testGardening {

  private String expectedPropertyAddress;
  private PropertySize expectedPropertySize;
  private Integer expectedNumOfService;
  private Integer expectedNumOfFloor;
  private Gardening testGardening;
  private Double expectedPrice;

  @BeforeEach
  void setUp() throws InvalidFloorException {
    expectedPropertyAddress = "123 Hill St, Seattle";
    expectedPropertySize = PropertySize.MEDIUM;
    expectedNumOfService = 2;
    expectedNumOfFloor = 2;
    testGardening = new Gardening(expectedPropertyAddress, expectedPropertySize, true, expectedNumOfService);
  }

  @Test
  void TestCalculatePrice() {
    expectedPrice = 18.0;
    Assertions.assertEquals(expectedPrice, testGardening.calculatePrice());
  }

}
