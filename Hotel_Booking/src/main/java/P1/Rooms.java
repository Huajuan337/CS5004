package P1;

public class Rooms {

  private Integer maxOccupancy;
  private Double price;
  private Integer guestNum;

  public Rooms(Double price, Integer maxOccupancy) {
    this.price = price;
    this.guestNum = 0;
    this.maxOccupancy = maxOccupancy;
  }

  public Integer getGuestNum() {
    return guestNum;
  }

  public void setGuestNum(Integer guestNum) {
    this.guestNum = guestNum;
  }

  public boolean isAvailable() {
    if(this.guestNum > 0){
      return false;
    }else{
      return true;
    }
  }

  public void bookRoom(Integer guests) {

    if(isAvailable() && guests <= maxOccupancy && guests > 0){
      guestNum = guests;
    }else{
      guestNum = 0;
    }

  }
}