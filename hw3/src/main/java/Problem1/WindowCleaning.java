package Problem1;

import java.util.Objects;

public class WindowCleaning extends Exterior{

  private Integer numOfFloor;
  private static final Integer MAX_OF_FLOORS = 3;

  /**
   * @param propertyAddress, property address expressed as String
   * @param propertySize, property size expressed as enum
   * @param monthlyService, monthly service expressed as Boolean
   * @param numOfService, number of service expressed as Integer
   * @param numOfFloor, number of floor expressed as Integer
   * @throws InvalidFloorException if number floor is out of floor maximum
   */

  public WindowCleaning(String propertyAddress, PropertySize propertySize, boolean monthlyService,
      Integer numOfService, Integer numOfFloor) throws InvalidFloorException{
    super(propertyAddress, propertySize, monthlyService, numOfService);
    if(numOfFloor <= MAX_OF_FLOORS && numOfFloor > 0 ){
      this.numOfFloor = numOfFloor;
    }else{
      throw new InvalidFloorException("Out of the range of number of floor.");
    }
  }

  /**
   *
   * @return price of window cleaning service as Double
   */

  @Override
  public Double calculatePrice() {

    Double price;

    // normal service price
    if (propertySize == PropertySize.SMALL)
      price = hoursToSmallProperty * rateOfHours;
    else if(propertySize == PropertySize.MEDIUM)
      price = hoursToMediumProperty * rateOfHours;
    else
      price = hoursToLargeProperty * rateOfHours;

    // check number of floor
    if (numOfFloor > 1)
      price *= 1.05;

    //check number of service
    if((numOfService%10) == 9)
      price *= 0.5;
    else if(isMonthlyService())
      price *= 0.9;

    // return total service price
    return price;
  }

  public Integer getNumOfFloor() {
    return numOfFloor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WindowCleaning)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    WindowCleaning that = (WindowCleaning) o;
    return Objects.equals(getNumOfFloor(), that.getNumOfFloor());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNumOfFloor());
  }

  @Override
  public String toString() {
    return "WindowCleaning{" +
        "numOfFloor=" + numOfFloor +
        '}';
  }
}
