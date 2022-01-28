package problem1;

import java.util.Objects;

public class NonEmptyPriorityQueue implements PriorityQueue {

  private Integer priority;
  private String value;
  private PriorityQueue rest;

  /**
   *
   * @param priority one of element's property in priority queue, expressed as Integer
   * @param value one of element's property in priority queue, expressed as String
   * @param rest rest of element in priority queue, expressed as PriorityQueue
   */
  public NonEmptyPriorityQueue(Integer priority, String value, PriorityQueue rest) {
    this.priority = priority;
    this.value = value;
    this.rest = null;
  }

  /**
   * @return element's property in priority queue as Integer
   */
  public Integer getPriority()
  {
    return this.priority;
  }

  /**
   * @return element's property in priority queue as String
   */
  public String getValue()
  {
    return this.value;
  }

  /**
   * @return rest of element in priority queue as PriorityQueue
   */
  public PriorityQueue getRest() {
    return this.rest;
  }

  /**
   * @return an empty priority queue
   */
  @Override
  public PriorityQueue createEmpty() {

    return new EmptyPriorityQueue();
  }

  /**
   * @return true if priority queue is empty
   */
  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  /**
   * @param priority element's priority
   * @param value element's value
   * @return a new priority queue after adding a element
   */
  @Override
  public PriorityQueue add(Integer priority, String value) {
    if(priority >= this.priority){
      return new NonEmptyPriorityQueue(priority, value, this);
    }else{
      return new NonEmptyPriorityQueue(this.priority, this.value, this.rest.add(priority, value));
    }
  }

  /**
   * @return highest element's priority
   * @throws EmptyPqException true is priority queue is empty else false
   */
  @Override
  public String peek() throws EmptyPqException {
    if(isEmpty()){
      throw new EmptyPqException("There is an empty priority queue");
    }else {
      return this.value;
    }
  }

  /**
   * @return copy of priority except the highest priority element
   * @throws EmptyPqException true is priority queue is empty else false
   */
  @Override
  public PriorityQueue pop() throws EmptyPqException {
    if(isEmpty()) {
      throw new EmptyPqException("There is an empty priority queue");
    }else{
      return this.rest;
    }
  }

  /**
   * @param o two objects
   * @return true if two object is the same else return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NonEmptyPriorityQueue)) {
      return false;
    }
    NonEmptyPriorityQueue that = (NonEmptyPriorityQueue) o;
    return Objects.equals(getPriority(), that.getPriority()) && Objects.equals(
        getValue(), that.getValue()) && Objects.equals(getRest(), that.getRest());
  }

  /**
   * @return integer representation of the object based on the object current state
   */
  @Override
  public int hashCode() {
    return Objects.hash(getPriority(), getValue(), getRest());
  }

  @Override
  public String toString() {
    return "NonEmptyPriorityQueue{" +
        "priority=" + priority +
        ", value='" + value + '\'' +
        ", rest=" + rest +
        '}';
  }
}

