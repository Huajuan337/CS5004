package P1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoomsTest {

  private Integer expectedMaxOccupancy;
  private Double expectedPrice;
  private Integer expectedGuestNum;
  private Rooms testRooms;

  @BeforeEach
  void setUp() {
    expectedGuestNum = 3;
    expectedPrice = 100.00;
    expectedMaxOccupancy = 2;
    testRooms = new Rooms(100.00, expectedMaxOccupancy);
  }

  @Test
  void testIsAvailable() {
    Assertions.assertEquals(true, testRooms.isAvailable());

  }

  @Test
  void testBookRoom() {
    testRooms.bookRoom(3);
    Assertions.assertEquals(expectedGuestNum, testRooms.getGuestNum());
  }
}