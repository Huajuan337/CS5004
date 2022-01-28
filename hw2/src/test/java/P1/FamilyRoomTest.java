package P1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FamilyRoomTest {

  private Integer expectedGuestNum;
  private Double expectedPrice;
  private FamilyRoom testFamilyRoom;

  @BeforeEach
  void setUp() {
    expectedGuestNum = 3;
    expectedPrice = 199.00;

    testFamilyRoom = new FamilyRoom(199.00);
  }

  @Test
  void testIsAvaible() {
    Assertions.assertEquals(true, testFamilyRoom.isAvailable());
  }

  @Test
  void testBookRoom() {
    testFamilyRoom.bookRoom(3);
    Assertions.assertEquals(expectedGuestNum, testFamilyRoom.getGuestNum());
  }
}