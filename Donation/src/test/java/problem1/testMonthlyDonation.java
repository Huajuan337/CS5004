package problem1;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testMonthlyDonation {
  private Double expectedAmount;
  private LocalDateTime expectedDonationDate;
  private LocalDateTime expectedCancellationDate;
  private MonthlyDonation testMonthlyDonation;

  @BeforeEach
  void setUp() {
    expectedAmount = 100.0;
    expectedDonationDate = LocalDateTime.of(2018,05, 05, 9, 00, 00);
    expectedCancellationDate = LocalDateTime.of(2018,10, 01, 10, 00, 00 );
    testMonthlyDonation = new MonthlyDonation(expectedAmount, expectedDonationDate);
  }

  @Test
  void testSetCancellationDate() throws Exception {
    testMonthlyDonation.setCancellationDate(expectedCancellationDate);
    Assertions.assertEquals(expectedCancellationDate, testMonthlyDonation.getCancellationDate());
  }

  @Test
  void testGetTotalDonationsForYear() throws Exception {
    Double expectedTotalAmount = 600.0;
    testMonthlyDonation.setCancellationDate(expectedCancellationDate);
    Assertions.assertEquals(expectedTotalAmount, testMonthlyDonation.getTotalDonationsForYear(2018));
  }

  public static class testPledges {

    private LocalDateTime expectedProcessingDate;
    private Double expectedAmount;
    private Pledges testPledges;

    @BeforeEach
    void setUp() {
      expectedAmount = 10000.0;
      expectedProcessingDate = LocalDateTime.of(2018,05, 05, 9, 00, 00);
      testPledges = new Pledges(expectedAmount, LocalDateTime.of(2017,05, 05, 9, 00, 00));
    }

    @Test
    void testGetTotalDonationsForYear() throws Exception {
      testPledges.setProcessingDate(expectedProcessingDate);
      Assertions.assertEquals(expectedAmount, testPledges.getTotalDonationsForYear(2018));
    }

  }
}
