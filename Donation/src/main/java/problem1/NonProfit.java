package problem1;

public class NonProfit {

  private String organizationName;
  private Donations donationCollection[];
  private Integer size;
  private Integer MAX_SIZE = 1000;

  /**
   *
   * @param organizationName name of the organization, expressed as String
   */
  public NonProfit(String organizationName) {
    this.organizationName = organizationName;
    this.donationCollection = new Donations[MAX_SIZE];
    size = 0;
  }

  /**
   * @param donate donations, can be oneTimeDonation, MonthlyDonation, or Plege
   */
  public void addDonation(Donations donate){
    donationCollection[size] = donate;
    size ++;
  }

  /**
   *
   * @param index index, Integer
   * @return the index-th donation in the collection
   */
  public Donations getDonationCollection(int index) {
    return donationCollection[index];
  }

  /**
   *
   * @param year year of interest, expressed as Integer
   * @return the total amount of donation during the provided year, summing over all donations in the collection
   */
  public Double getTotalDonationForYear(Integer year){
    Double totalAmount = 0.0;
    for(int i = 0; i < size; i++){
        totalAmount += donationCollection[i].getTotalDonationsForYear(year);
    }
    return totalAmount;
  }
}
