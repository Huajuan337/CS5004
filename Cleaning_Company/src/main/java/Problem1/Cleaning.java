package Problem1;

public class Cleaning extends Interior{

  /**
   *
   * @param propertyAddress, property address expressed as String
   * @param propertySize, property size expressed as enum
   * @param monthlyService, monthly service expressed as Boolean
   * @param numOfService, number of service expressed as Integer
   * @param numOfPets, number of pets expressed as Integer
   */

  public Cleaning(String propertyAddress, PropertySize propertySize, boolean monthlyService,
      Integer numOfService, Integer numOfPets) {
    super(propertyAddress, propertySize, monthlyService, numOfService, numOfPets);
  }

  /**
   *
   * @return price of cleaning service as Double
   */

  @Override
  public Double calculatePrice() {
    Double price;

    //check property size
    if (propertySize == PropertySize.SMALL)
      price = (rateOfHours * hoursToSmallProperty);
    else if( propertySize == PropertySize.MEDIUM)
      price = (rateOfHours * hoursToMediumProperty);
    else
      price = (rateOfHours * hoursToLargeProperty);

    // check number of pets
    if (numOfPets >= 1 && numOfPets <= 2)
      price *= 1.05;
    else if (numOfPets >= 3)
      price *= 1.07;

    // check number of service
    if((numOfService%10) == 9)
      price *= 0.5;
    //check monthly service
    else if(isMonthlyService())
      price *= 0.9;

    return price;
  }

}
