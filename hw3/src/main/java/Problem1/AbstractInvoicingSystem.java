package Problem1;

import java.util.Objects;

public abstract class AbstractInvoicingSystem implements InvoicingSystem {

  protected String propertyAddress;
  protected PropertySize propertySize;
  protected boolean monthlyService;
  protected Integer numOfService;

  /**
   *
   * @param propertyAddress, property address expressed as String
   * @param propertySize, property size expressed as enum
   * @param monthlyService, monthly service expressed as Boolean
   * @param numOfService, number of service expressed as Integer
   */
  public AbstractInvoicingSystem(String propertyAddress, PropertySize propertySize,
      boolean monthlyService, Integer numOfService) {
    this.propertyAddress = propertyAddress;
    this.propertySize = propertySize;
    this.monthlyService = monthlyService;
    this.numOfService = numOfService;
  }

  /**
   * @return property address as String
   */

  public String getPropertyAddress() {
    return propertyAddress;
  }

  /**
   * @return property size as Integer
   */
  public PropertySize getPropertySize() {
    return propertySize;
  }

  /**
   * @return monthly service as Boolean
   */
  public boolean isMonthlyService() {
    return monthlyService;
  }

  /**
   * @return service number as Integer
   */

  public Integer getNumOfService() {
    return numOfService;
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
    if (!(o instanceof AbstractInvoicingSystem)) {
      return false;
    }
    AbstractInvoicingSystem that = (AbstractInvoicingSystem) o;
    return isMonthlyService() == that.isMonthlyService() && Objects.equals(
        getPropertyAddress(), that.getPropertyAddress())
        && getPropertySize() == that.getPropertySize() && Objects.equals(getNumOfService(),
        that.getNumOfService());
  }

  /**
   * @return true if two objects are in the same position, else return false
   */

  @Override
  public int hashCode() {
    return Objects.hash(getPropertyAddress(), getPropertySize(), isMonthlyService(),
        getNumOfService());
  }

  /**
   * @return property information including address, size, monthly service, and number of service as String
   */
  @Override
  public String toString() {
    return "AbstractServiceCompany{" +
        "propertyAddress='" + propertyAddress + '\'' +
        ", propertySize=" + propertySize +
        ", monthlyService=" + monthlyService +
        ", numOfService=" + numOfService +
        '}';
  }
}
