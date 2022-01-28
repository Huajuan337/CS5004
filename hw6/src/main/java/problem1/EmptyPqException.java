package problem1;

public class EmptyPqException extends Exception {

  public EmptyPqException() {
  }

  public EmptyPqException(String message) {
    super(message);
  }
}
