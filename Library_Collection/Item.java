package Problem2;

import java.util.Objects;

public class Item {
  private Creator creators;
  private String title;
  private Integer year;

  /**
   *
   * @param creators item's creator, e.g., author, band, recording artist
   * @param title item's title, expressed as string
   * @param year was published or released, expressed as Integer
   */
  public Item(Creator creators, String title, Integer year) {
    this.creators = creators;
    this.title = title;
    this.year = year;
  }

  /**
   *
   * @return item's creator
   */
  public Creator getCreators() {
    return creators;
  }

  /**
   *
   * @return item's title
   */
  public String getTitle() {
    return title;
  }

  /**
   *
   * @return item's released or published year
   */
  public Integer getYear() {
    return year;
  }

  /**
   *
   * @param o objects
   * @return true if two objects are the same, else return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Item)) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(getCreators(), item.getCreators()) && Objects.equals(
        getTitle(), item.getTitle()) && Objects.equals(getYear(), item.getYear());
  }

  /**
   *
   * @return true if two objects are in the same position, else return false
   */
  @Override
  public int hashCode() {
    return Objects.hash(getCreators(), getTitle(), getYear());
  }

  /**
   *
   * @return item information expressed as string
   */
  @Override
  public String toString() {
    return "Item{" +
        "creators=" + creators +
        ", title='" + title + '\'' +
        ", year=" + year +
        '}';
  }
}
