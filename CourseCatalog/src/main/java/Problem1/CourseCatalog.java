package Problem1;

import java.util.Arrays;
import java.util.Objects;

public class CourseCatalog implements Catalog{

  private int size;
  private int MAX_SIZE= 100;
  private Course courseArray[];

  public CourseCatalog() {
    size = 0;
    courseArray = new Course[MAX_SIZE];
  }

  public int getSize() {
    return size;
  }

  @Override
  public void append(Course course) {
    courseArray[size] = course;
    size++;
  }

  @Override
  public void remove(Course course) throws CourseNotFoundException{
    int courseIndex = 0;

    // step 1: find the min index of the course
    if(contains(course)){
      courseIndex = indexOf(course);
    }
    else
      throw new CourseNotFoundException("Course doesn't exist");

    // step 2: copy courseArray[i+1] to courseArray[i]
    for(int i = courseIndex; i < this.size; i++){
      courseArray[i] = courseArray[i+1];
    }
    size --;
  }

  @Override
  public boolean contains(Course course) {
    for(int i = 0; i < this.size; i++) {
      if(course.equals(courseArray[i])) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int indexOf(Course course) {
    for(int i = 0; i < this.size; i++){
      if(course.equals(courseArray[i])){
        return i;
      }
    }
    return -1;
  }

  @Override
  public int count() {
    return this.size;
  }

  @Override
  public Course get(int index) throws InvalidIndexException{
    if(index < this.size)
      return courseArray[index];
    else
      throw new InvalidIndexException("Course doesn't exist");
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CourseCatalog)) {
      return false;
    }
    CourseCatalog that = (CourseCatalog) o;
    return getSize() == that.getSize() && MAX_SIZE == that.MAX_SIZE && Arrays.equals(
        courseArray, that.courseArray);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getSize(), MAX_SIZE);
    result = 31 * result + Arrays.hashCode(courseArray);
    return result;
  }

  @Override
  public String toString() {
    return "CourseCatalog{" +
        "size=" + size +
        ", MAX_SIZE=" + MAX_SIZE +
        ", courseArray=" + Arrays.toString(courseArray) +
        '}';
  }
}
