package problem2;

import Problem2.Author;
import Problem2.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testBook {

  private Author author;
  private Book testBook;

  @BeforeEach
  void setUp() {
    author = new Author("J.K.", "Rowling");
    testBook = new Book(author,"Harry Potter", 1997, author);
  }

  @Test
  void testAuthor() {
    Assertions.assertEquals(author, testBook.getAuthor());
  }
}
