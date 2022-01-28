package problem1;

public class EmptyPriorityQueue implements PriorityQueue{

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
    return Boolean.TRUE;
  }

  /**
   * @param priority element's priority
   * @param value element's value
   * @return a new priority queue after adding a element
   */
  @Override
  public PriorityQueue add(Integer priority, String value) {
    return new NonEmptyPriorityQueue(priority, value, this);
  }

  /**
   *
   * @return a massage of EmptyPqException
   * @throws EmptyPqException true is priority queue is empty else false
   */
  @Override
  public String peek() throws EmptyPqException {
    throw new EmptyPqException("It's empty");
  }

  /**
   * @return a massage of EmptyPqException
   * @throws EmptyPqException true is priority queue is empty else false
   */
  @Override
  public PriorityQueue pop() throws EmptyPqException {
    throw new EmptyPqException("It's empty");
  }

  /**
   * @param o two objects
   * @return true if two object is the same else return false
   */
  public boolean equals(Object o){
    if(o instanceof EmptyPriorityQueue)
      return true;
    else
      return false;
  }



}
