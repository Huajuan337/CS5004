package problem2;

import Problem2.Band;
import Problem2.RecordingArtist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testBand {

  private String expectedName;
  private  RecordingArtist members[];
  private Band testBand;

  @BeforeEach
  void setUp() {

    members = new RecordingArtist[3];
    members[0] = new RecordingArtist("John", "Smith");
    members[1]  = new RecordingArtist("Chris", "Martin");
    members[2] = new RecordingArtist("Brandon", "Green");
    testBand = new Band("Coldplay", members);
  }

  @Test
  void testGetName() {
    Assertions.assertEquals("Coldplay", testBand.getName());
  }

  @Test
  void testGetMember() {
    Assertions.assertEquals(members, testBand.getMembers());
  }
}
