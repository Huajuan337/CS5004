package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testPlumbing {
  private String expectedPropertyAddress;
  private PropertySize expectedPropertySize;
  private Integer expectedNumOfService;
  private Integer expectedNumOfLicensedEmployee;
  private Double expectedPrice;
  private Plumbing testPlumbing;

  @BeforeEach
  void setUp() {
    expectedPropertyAddress = "123 Hill St, Seattle";
    expectedPropertySize = PropertySize.MEDIUM;
    expectedNumOfService = 9;
    expectedNumOfLicensedEmployee = 1;

    testPlumbing = new Plumbing(expectedPropertyAddress, expectedPropertySize, true, expectedNumOfService, expectedNumOfLicensedEmployee, true);
  }

  @Test
  void testCalculatePrice() {
    expectedPrice = 20.0;
    Assertions.assertEquals(expectedPrice, testPlumbing.calculatePrice());
  }
}
