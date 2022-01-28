package problem1;

public interface PriorityQueue {

  PriorityQueue createEmpty();
  Boolean isEmpty();
  PriorityQueue add(Integer priority, String value);
  String peek() throws EmptyPqException;
  PriorityQueue pop() throws EmptyPqException;
}
