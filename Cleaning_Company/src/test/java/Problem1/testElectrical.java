package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testElectrical {

  private String expectedPropertyAddress;
  private PropertySize expectedPropertySize;
  private Integer expectedNumOfService;
  private Integer expectedNumOfLicensedEmployee;
  private Double expectedPrice;
  private Electrical testElectrical;

  @BeforeEach
  void setUp() throws InvalidEmployeeException {
    expectedPropertyAddress = "123 Hill St, Seattle";
    expectedPropertySize = PropertySize.MEDIUM;
    expectedNumOfService = 9;
    expectedNumOfLicensedEmployee = 1;

    testElectrical = new Electrical(expectedPropertyAddress, expectedPropertySize, true, expectedNumOfService, expectedNumOfLicensedEmployee, true);
  }

  @Test
  void testCalculatePrice() {
    expectedPrice = 50.0;
    Assertions.assertEquals(expectedPrice, testElectrical.calculatePrice());
  }

  @Test
  void testInvalidEmployeeException() {
    Assertions.assertThrows(InvalidEmployeeException.class, () ->
        new Electrical(expectedPropertyAddress, expectedPropertySize, true, expectedNumOfService, 5, true));
  }

}
