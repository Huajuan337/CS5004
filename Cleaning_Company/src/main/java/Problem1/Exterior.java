package Problem1;

public abstract class Exterior extends AbstractInvoicingSystem {

  protected static final Double rateOfHours = 80.0;
  protected static final Integer hoursToSmallProperty = 1;
  protected static final Integer hoursToMediumProperty = 2;
  protected static final Integer hoursToLargeProperty = 4;

  /**
   *
   * @param propertyAddress, property address expressed as String
   * @param propertySize, property size expressed as enum
   * @param monthlyService, monthly service expressed as Boolean
   * @param numOfService, number of service expressed as Integer
   */

  public Exterior(String propertyAddress, PropertySize propertySize, boolean monthlyService,
      Integer numOfService) {
    super(propertyAddress, propertySize, monthlyService, numOfService);
  }

}
