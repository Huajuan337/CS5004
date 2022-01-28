package Problem1;

import java.util.Objects;

public abstract class Specialist extends AbstractInvoicingSystem{

  protected Integer numOfLicensedEmployee;
  protected boolean complexWork;

  /**
   *
   * @param propertyAddress, property address expressed as String
   * @param propertySize, property size expressed as enum
   * @param monthlyService, monthly service expressed as Boolean
   * @param numOfService, number of service expressed as Integer
   * @param numOfLicensedEmployee, number of licenseEmployee expressed as Integer
   * @param complexWork,, whether is complex work expressed as Boolean
   */

  public Specialist(String propertyAddress, PropertySize propertySize, boolean monthlyService,
      Integer numOfService, Integer numOfLicensedEmployee, boolean complexWork) {
    super(propertyAddress, propertySize, monthlyService, numOfService);
    this.numOfLicensedEmployee = numOfLicensedEmployee;
    this.complexWork = complexWork;

    if (numOfLicensedEmployee == 0){
      setNumOfLicensedEmployee(1);
    }

    // if this service is a complex work,
    //  if propertySize is small or medium
    //      if numberOfLicencedEmployee < 2:
    //         setNumOfLicensedEmployee(2)
    // elif propertySize is large
    //  then the numOfLicensedEmployee has to be >3
    if(complexWork){
      if((propertySize == PropertySize.SMALL || propertySize == PropertySize.MEDIUM) && numOfLicensedEmployee < 2){
        setNumOfLicensedEmployee(2);
      }
      else if(propertySize == PropertySize.LARGE && numOfLicensedEmployee < 3)
        setNumOfLicensedEmployee(3);
    }
  }

  /**
   *
   * @return number of licensed employee as Integer
   */

  public Integer getNumOfLicensedEmployee() {
    return numOfLicensedEmployee;
  }

  /**
   *
   * @param numOfLicensedEmployee, set the number of licensed employee as Integer
   */
  public void setNumOfLicensedEmployee(Integer numOfLicensedEmployee) {
    this.numOfLicensedEmployee = numOfLicensedEmployee;
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
    if (!(o instanceof Specialist)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Specialist that = (Specialist) o;
    return complexWork == that.complexWork && Objects.equals(getNumOfLicensedEmployee(),
        that.getNumOfLicensedEmployee());
  }

  /**
   * @return true if two objects are in the same position, else return false
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNumOfLicensedEmployee(), complexWork);
  }

  /**
   *
   * @return specialist information including number of licensed employee and complex work as String
   */
  @Override
  public String toString() {
    return "Specialist{" +
        "numOfLicensedEmployee=" + numOfLicensedEmployee +
        ", complexWork=" + complexWork +
        '}';
  }
}
