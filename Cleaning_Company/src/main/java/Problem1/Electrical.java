package Problem1;

public class Electrical extends Specialist{

  private static final Double electricalPermitFee = 50.0;
  private static final Integer MAX_NUMBER_OF_EMPLOYEE = 4;

  /**
   *
   * @param propertyAddress, property address expressed as String
   * @param propertySize, property size expressed as enum
   * @param monthlyService, monthly service expressed as Boolean
   * @param numOfService, number of service expressed as Integer
   * @param numOfLicensedEmployee, number of licenseEmployee expressed as Integer
   * @param complexWork,, whether is complex work expressed as Boolean
   */

  public Electrical(String propertyAddress, PropertySize propertySize, boolean monthlyService,
      Integer numOfService, Integer numOfLicensedEmployee, boolean complexWork) throws InvalidEmployeeException{
    super(propertyAddress, propertySize, monthlyService, numOfService, numOfLicensedEmployee,
        complexWork);

    if(numOfLicensedEmployee > MAX_NUMBER_OF_EMPLOYEE){
      throw new InvalidEmployeeException("The number of employee is out of range");
    }

  }

  /**
   *
   * @return price of electrical service as Double
   */

  @Override
  public Double calculatePrice() {
    return electricalPermitFee;
  }
}
