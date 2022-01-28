package problem1;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem1.Donations;
import problem1.OneTimeDonation;

public class testOneTimeDonation {

  private Double expectedAmount;
  private LocalDateTime expectedDonationDate;
  private OneTimeDonation testOneTimeDonation;

  @BeforeEach
  void setUp() {
    expectedAmount = 100.0;
    expectedDonationDate = LocalDateTime.of(2018,05, 05, 9, 00, 00);
    testOneTimeDonation = new OneTimeDonation(expectedAmount, expectedDonationDate);
  }

  @Test
  void testGetTotalDonationsForYear() {
    Assertions.assertEquals(expectedAmount, testOneTimeDonation.getTotalDonationsForYear(2018));
  }
}
