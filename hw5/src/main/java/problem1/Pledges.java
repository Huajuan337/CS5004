package problem1;

import java.time.LocalDateTime;

public class Pledges extends Donations{
  private LocalDateTime processingDate;

  /**
   *
   * @param amount amount of donation, expressed as Double
   * @param donationDate Date of donation, expressed as Date
   */
  public Pledges(Double amount, LocalDateTime donationDate) {
    super(amount, donationDate);
  }

  /**
   *
   * @return return the processingDate
   */
  public LocalDateTime getProcessingDate() {
    return processingDate;
  }


  /**
   *
   * @param processingDate date of processing, expressed as Date
   * @throws Exception exceptions
   */
  public void setProcessingDate(LocalDateTime processingDate) throws Exception {

    if(processingDate.isAfter(donationDate)){
      this.processingDate = processingDate;
    } else
      throw new Exception("cancellation date is not valid");
  }


  /**
   *
   * @param year year of interest, expressed as Integer
   * @return the total donation mode in the year
   */
  @Override
  public Double getTotalDonationsForYear(Integer year) {
    if(year == processingDate.getYear()){
      return amount;
    }
    else
      return 0.0;
  }
}
