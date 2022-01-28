package Problem2;

import java.util.Objects;

public class Book extends Item{

  private Author author;

  /**
   *
   * @param creators book's creator
   * @param title book's title, expressed as string
   * @param year book published, expressed as integer
   * @param author book's author
   */
  public Book(Creator creators, String title, Integer year, Author author) {
    super(creators, title, year);
    this.author = author;
  }

  /**
   *
   * @return author
   */
  public Author getAuthor() {
    return author;
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
    if (!(o instanceof Book)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(getAuthor(), book.getAuthor());
  }

  /**
   *
   * @return true if two objects are in the same position, else return false
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getAuthor());
  }

  /**
   *
   * @return book information expressed as string
   */
  @Override
  public String toString() {
    return "Book{" +
        "author=" + author +
        '}';
  }
}
