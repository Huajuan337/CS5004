package Problem1;

public class Painting extends Interior {

  private static final Integer hoursToSmallOrMediumProperty = 16;
  private static final Integer hoursToLargeProperty = 24;

  /**
   *
   * @param propertyAddress, property address expressed as String
   * @param propertySize, property size expressed as enum
   * @param monthlyService, monthly service expressed as Boolean
   * @param numOfService, number of service expressed as Integer
   * @param numOfPets, number of pets expressed as Integer
   */

  public Painting(String propertyAddress, PropertySize propertySize, boolean monthlyService,
      Integer numOfService, Integer numOfPets) {
    super(propertyAddress, propertySize, monthlyService, numOfService, numOfPets);
  }

  /**
   *
   * @return price of painting as Double
   */

  @Override
  public Double calculatePrice() {

    Double price;

    if (propertySize == PropertySize.SMALL || propertySize == PropertySize.MEDIUM)
      price = (rateOfHours * hoursToSmallOrMediumProperty);
    else
      price = (rateOfHours * hoursToLargeProperty);

    // check number of pets
    if (numOfPets <= 2 && numOfPets > 0)
      price *= 1.05;
    else if (numOfPets >= 3)
      price *= 1.07;

    // check number of service is 10th or not
    if((numOfService%10) == 9){
      price *= 0.5;
    }
    // check monthly service
    else if(isMonthlyService() ){
      price *= 0.9;
    }

    return price;
  }

}
