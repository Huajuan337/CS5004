package problem1;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem1.Donations;
import problem1.MonthlyDonation;
import problem1.NonProfit;
import problem1.OneTimeDonation;

public class testNonprofit {

  private Donations donation1;
  private Donations donation2;
  private NonProfit testNonprofit;

  @BeforeEach
  void setUp() {

    donation1 = new OneTimeDonation(100.0, LocalDateTime.of(2018,05, 05, 9, 00, 00));
    //donation2= new OneTimeDonation(100.0, LocalDateTime.of(2018,10, 05, 9, 00, 00));
    donation2 = new MonthlyDonation(50.0,LocalDateTime.of(2017,10, 05, 9, 00, 00) );
    testNonprofit = new NonProfit("YAYA nonprofit");
    testNonprofit.addDonation( donation1);
    testNonprofit.addDonation( donation2);
  }

  @Test
  void testAddDonation() {
    Assertions.assertEquals(donation1, testNonprofit.getDonationCollection(0));
//    Assertions.assertEquals(1, problem1.testNonprofit.);
  }

    @Test
  void testGetTotalDonationForYear() throws Exception {
    Double expectedAmount = 350.0;
    ((MonthlyDonation) donation2).setCancellationDate(LocalDateTime.of(2018,5, 05, 9, 00, 00));
    Assertions.assertEquals(expectedAmount, testNonprofit.getTotalDonationForYear(2018));
  }
}
