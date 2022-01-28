package Problem1;

import java.util.Objects;

public abstract class Interior extends AbstractInvoicingSystem {

  protected Integer numOfPets;
  protected static final Integer hoursToSmallProperty = 1;
  protected static final Integer hoursToMediumProperty = 2;
  protected static final Integer hoursToLargeProperty = 4;
  protected static final Double rateOfHours = 80.0;

  /**
   *
   * @param propertyAddress, property address expressed as String
   * @param propertySize, property size expressed as enum
   * @param monthlyService, monthly service expressed as Boolean
   * @param numOfService, number of service expressed as Integer
   * @param numOfPets, number of pets expressed as Integer
   */

  public Interior(String propertyAddress, PropertySize propertySize, boolean monthlyService,
      Integer numOfService, Integer numOfPets) {
    super(propertyAddress, propertySize, monthlyService, numOfService);
    this.numOfPets = numOfPets;
  }

  /**
   * @return number of pets as Integer
   */
  public Integer getNumOfPets() {
    return numOfPets;
  }

  /**
   *
   * @param o Objects
   * @return true if two objects are the same, else return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Interior)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Interior interior = (Interior) o;
    return Objects.equals(getNumOfPets(), interior.getNumOfPets());
  }

  /**
   * @return true if two objects are in the same position, else return false
   */

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNumOfPets());
  }

  /**
   *
   * @return interior information, number of pets as String
   */
  @Override
  public String toString() {
    return "Interior{" +
        "numOfPets=" + numOfPets +
        '}';
  }


}
