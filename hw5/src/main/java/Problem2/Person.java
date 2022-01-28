package Problem2;

import java.util.Objects;

public class Person extends Creator{
  private String firstName;
  private String lastName;

  /**
   *
   * @param firstName person's firstName expressed string
   * @param lastName person's lastName expressed string
   */
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   *
   * @return person's firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   *
   * @return person's lastName
   */
  public String getLastName() {
    return lastName;
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
    if (!(o instanceof Author)) {
      return false;
    }
    Author author = (Author) o;
    return Objects.equals(getFirstName(), author.getFirstName())
        && Objects.equals(getLastName(), author.getLastName());
  }

  /**
   *
   * @return true if two objects are in the same position, else return false
   */
  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName());
  }

  /**
   *
   * @return person information expressed as string
   */
  @Override
  public String toString() {
    return "Author{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
