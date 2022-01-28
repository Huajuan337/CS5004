package Problem1;

public class Gardening extends Exterior{

  private static final Double gardeningFee = 20.0;

  /**
   *
   * @param propertyAddress, property address expressed as String
   * @param propertySize, property size expressed as enum
   * @param monthlyService, monthly service expressed as Boolean
   * @param numOfService, number of service expressed as Integer
   */

  public Gardening(String propertyAddress, PropertySize propertySize, boolean monthlyService, Integer numOfService) {
    super(propertyAddress, propertySize, monthlyService, numOfService);
  }

  /**
   *
   * @return price of gardening service as Double
   */

  @Override
  public Double calculatePrice() {

    if((numOfService % 10) == 9) {
      return gardeningFee * 0.5;
    }
    else if(isMonthlyService()){
      return gardeningFee * 0.9;
    }
    else{
      return gardeningFee;
    }
  }







}
