package Problem1;

public class Plumbing extends Specialist{

  private static final Double plumbingPermitFee = 20.0;

  /**
   *
   * @param propertyAddress, property address expressed as String
   * @param propertySize, property size expressed as enum
   * @param monthlyService, monthly service expressed as Boolean
   * @param numOfService, number of service expressed as Integer
   * @param numOfLicensedEmployee, number of licenseEmployee expressed as Integer
   * @param complexWork,, whether is complex work expressed as Boolean
   */

  public Plumbing(String propertyAddress, PropertySize propertySize, boolean monthlyService,
      Integer numOfService, Integer numOfLicensedEmployee, boolean complexWork) {
    super(propertyAddress, propertySize, monthlyService, numOfService, numOfLicensedEmployee,
        complexWork);
  }

  /**
   *
   * @return price of plumbing as Double
   */

  @Override
  public Double calculatePrice() {
    return plumbingPermitFee;
  }
}
