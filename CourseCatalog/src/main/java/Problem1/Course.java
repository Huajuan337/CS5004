package Problem1;

import java.util.Objects;

public class Course {

  private final String name;
  private final String prefix;
  private final int number;

  public Course(String name, String prefix, int number) {
    this.name = name;
    this.prefix = prefix;
    this.number = number;
  }

  @Override
  public String toString() {
    return "Course{" +
        "name='" + name + '\'' +
        ", prefix='" + prefix + '\'' +
        ", number=" + number +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Course)) {
      return false;
    }
    Course course = (Course) o;
    return number == course.number && Objects.equals(name, course.name)
        && Objects.equals(prefix, course.prefix);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, prefix, number);
  }
}
