package problem1;

import java.time.LocalDateTime;

public class OneTimeDonation extends Donations{

  /**
   *
   * @param amount donation's amount expressed as Double
   * @param donationDate  date of donation made expressed as LocalDateTime
   */
  public OneTimeDonation(Double amount, LocalDateTime donationDate) {
    super(amount, donationDate);
  }

  /**
   *
   * @param year total donation made in the year
   * @return total amount donation make in the year
   */
  @Override
  public Double getTotalDonationsForYear(Integer year) {
    if(donationDate.getYear() == year)
      return amount;
    else
      return 0.0;
  }
}