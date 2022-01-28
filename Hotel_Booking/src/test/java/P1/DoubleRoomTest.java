package P1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoubleRoomTest {
  private Integer expectedGuestNnum;
  private Double expectedPrice;
  private DoubleRoom testDoubleRoom;

  @BeforeEach
  void setUp() {

    expectedPrice = 130.00;
    testDoubleRoom = new DoubleRoom(130.00);
  }

  @Test
  void testIsAvailable() {
//    testDoubleRoom.setGuestNum(2);
//    Assertions.assertEquals(false, testDoubleRoom.isAvailable());
//    testDoubleRoom.setGuestNum(0);
    Assertions.assertEquals(true, testDoubleRoom.isAvailable());
  }

  @Test
  void testBookRooom() {
    expectedGuestNnum = 2;
    testDoubleRoom.bookRoom(2);
    Assertions.assertEquals(expectedGuestNnum, testDoubleRoom.getGuestNum());
  }
}