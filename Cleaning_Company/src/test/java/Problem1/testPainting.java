package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testPainting {
  private String expectedPropertyAddress;
  private PropertySize expectedPropertySize;
  private boolean expectedMonthlyService;
  private Integer expectedNumOfService;
  private Integer expectedNumOfPets;
  private Painting testPainting;
  private Double expectedPrice;


  @BeforeEach
  void setUp() {
    expectedPropertyAddress = "123 Hill St, Seattle";
    expectedPropertySize = PropertySize.SMALL;
    expectedNumOfService = 9;
    expectedNumOfPets = 1;
    testPainting = new Painting(expectedPropertyAddress, expectedPropertySize, expectedMonthlyService, expectedNumOfService, expectedNumOfPets);
  }


  @Test
  void testCalculatePrice() {
    expectedPrice = 672.0;
    Assertions.assertEquals(expectedPrice, testPainting.calculatePrice());
  }
}
