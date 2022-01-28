package P1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingleRoomTest {

  private Integer expectedGuestNum;
  private Double expectedPrice;

  private SingleRoom testSingleRoom;


  @BeforeEach
  void setUp() {
    expectedPrice = 99.00;
    expectedGuestNum = 0;
    testSingleRoom = new SingleRoom(99.00);
  }

  @Test
  void testIsAvailable() {

    Assertions.assertEquals(true, testSingleRoom.isAvailable());
  }

  @Test
  void testBookRoom() {
    expectedGuestNum = 1;
    testSingleRoom.bookRoom(1);
    Assertions.assertEquals(expectedGuestNum, testSingleRoom.getGuestNum());
  }
}