package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

public class MonthlyDonation extends Donations{

  LocalDateTime cancellationDate;

  /**
   *
   * @param amount donation's amount expressed as Double
   * @param donationDate  date of donation made expressed as LocalDateTime
   */
  public MonthlyDonation(Double amount, LocalDateTime donationDate) {
    super(amount, donationDate);
    this.cancellationDate = null;
  }

  /**
   *
   * @return cancellation date
   */
  public LocalDateTime getCancellationDate() {
    return cancellationDate;
  }

  /**
   *
   * @param cancellationDate cancellation date
   * @throws Exception if set cancellation date is prior to the creation date and time
   */
  public void setCancellationDate(LocalDateTime cancellationDate) throws Exception {
    if(cancellationDate.isAfter(donationDate)){
      this.cancellationDate = cancellationDate;
    } else
      throw new Exception("cancellation date is not valid");
  }

  /**
   *
   * @param year total donation made in the year
   * @return total amount donation make in the year
   */
  @Override
  public Double getTotalDonationsForYear(Integer year) {

    Integer duration = 0;
    if(donationDate.getYear() < year){
      if(cancellationDate == null)
        duration = 12;
      else
        duration = cancellationDate.getMonthValue();
    }else if(donationDate.getYear() == year && cancellationDate != null){
      duration = cancellationDate.getMonthValue() - donationDate.getMonthValue() + 1;
    }else if(donationDate.getYear() == year && cancellationDate == null){
      duration = 12 - donationDate.getMonthValue() +1;
    }
    return duration * amount;
  }

  /**
   *
   * @param o objects
   * @return true if two objects are the same, else return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MonthlyDonation)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    MonthlyDonation that = (MonthlyDonation) o;
    return Objects.equals(getCancellationDate(), that.getCancellationDate());
  }

  /**
   *
   * @return true if two objects are in the same position, else return false
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getCancellationDate());
  }

  /**
   *
   * @return donation information expressed as string
   */
  @Override
  public String toString() {
    return "MonthlyDonation{" +
        "cancellationDate=" + cancellationDate +
        '}';
  }
}
