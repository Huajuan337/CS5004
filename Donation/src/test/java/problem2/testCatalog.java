package problem2;

import Problem2.Author;
import Problem2.Band;
import Problem2.Catalog;
import Problem2.Item;
import Problem2.RecordingArtist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testCatalog {
  private Item item1;
  private Item item2;
  private Item item3;
  private Catalog testCatalog;
  private Author author;
  private Band band;
  private RecordingArtist recordingArtist;
  private RecordingArtist artists[];

  @BeforeEach
  void setUp() {
    author = new Author("J.K.", "Rowling");

    recordingArtist = new RecordingArtist("Chris", "Martin"); // this is for item3
    artists = new RecordingArtist[3];
    artists[0] = new RecordingArtist("John", "Smith");
    artists[1]  = new RecordingArtist("Chris", "Martin");
    artists[2] = new RecordingArtist("Brandon", "Green");
    band = new Band("ColdPlay", artists);

    item1 = new Item(author,"Harry Potter", 1997);
    item2 = new Item(band, "yellow", 1997); // music
    item3 = new Item(recordingArtist, "30", 2021);
    testCatalog = new Catalog();
    testCatalog.Add(item1);
  }

  @Test
  void testAdd() {
    testCatalog.Add(item2);
    Integer expectedSize = 2;
    Assertions.assertEquals(expectedSize, testCatalog.getSize());
  }

  @Test
  void testRemove() {
    Integer expectedSize = 0;
    Assertions.assertEquals(expectedSize, testCatalog.getSize());
  }

  @Test
  void testSearch1() {
    Catalog expectedCollection = new Catalog();
    expectedCollection.Add(item1);
    Assertions.assertEquals(expectedCollection, testCatalog.Search("a"));
  }

  @Test
  void testSearch2() {
    Catalog expectedCollection = new Catalog();
    expectedCollection.Add(item1);
    Assertions.assertEquals(expectedCollection, testCatalog.Search(author));
  }

  @Test
  void testSearch3() {
    testCatalog.Add(item1);
    testCatalog.Add(item2);
    testCatalog.Add(item3);
    Catalog expectedCollection = new Catalog();
    expectedCollection.Add(item2);
    expectedCollection.Add(item3);
    Assertions.assertEquals(expectedCollection, testCatalog.Search(recordingArtist));
  }
}
