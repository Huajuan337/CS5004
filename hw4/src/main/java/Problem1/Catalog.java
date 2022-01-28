package Problem1;

public interface Catalog {

  void append(Course course);
  void remove(Course course) throws CourseNotFoundException;
  boolean contains(Course course);
  int indexOf(Course course);
  int count();
  Course get(int index) throws InvalidIndexException;
  boolean isEmpty();


}
