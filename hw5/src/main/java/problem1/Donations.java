package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Donations implements DonationCalculation{
  protected Double amount;
  protected LocalDateTime donationDate;

  /**
   *
   * @param amount donation's amount expressed as Double
   * @param donationDate  date of donation made expressed as LocalDateTime
   */
  public Donations(Double amount, LocalDateTime donationDate) {
    this.amount = amount;
    this.donationDate = donationDate;
  }

  /**
   *
   * @return donation's amount
   */
  public Double getAmount() {
    return amount;
  }

  /**
   *
   * @return date of donation made
   */
  public LocalDateTime getDonationDate() {
    return donationDate;
  }

  /**
   *
   * @param year total donation made in the year
   * @return total amount donation make in the year
   */
  public Double getTotalDonationsForYear(Integer year) { return 0.0;}

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
    if (!(o instanceof Donations)) {
      return false;
    }
    Donations donations = (Donations) o;
    return Objects.equals(getAmount(), donations.getAmount()) && Objects.equals(
        getDonationDate(), donations.getDonationDate());
  }

  /**
   *
   * @return true if two objects are in the same position, else return false
   */
  @Override
  public int hashCode() {
    return Objects.hash(getAmount(), getDonationDate());
  }

  /**
   *
   * @return donation information expressed as string
   */
  @Override
  public String toString() {
    return "Donations{" +
        "amount=" + amount +
        ", donationDate=" + donationDate +
        '}';
  }
}
