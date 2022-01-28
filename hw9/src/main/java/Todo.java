import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Todo implements Comparable<Todo>  {
  private final Integer id;
  private final String text;
  private Boolean completed;
  private final LocalDate due;
  private final Integer priority;
  private final String category;
  private boolean sortByPriority; // true if sort by priority; false if sort by due date

  public Todo(Integer id,String text, boolean completed, Integer priority, LocalDate due, String category) {
    this.id = id;
    this.text = text;
    this.completed = completed;
    this.due = due;
    this.priority = priority;
    this.category = category;
    this.sortByPriority = true;
  }


  public Integer getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public Boolean getCompleted() {
    return completed;
  }

  public LocalDate getDue() {
    return due;
  }

  public Integer getPriority() {
    return priority;
  }

  public String getCategory() {
    return category;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  public void setSortByPriority(boolean sortByPriority) {
    this.sortByPriority = sortByPriority;
  }


  @Override
  public String toString() {
    String due_string = this.due==null? "?" : this.due.toString();
    String priority_string = this.priority == null? "3": this.priority.toString();
    String category_string = this.category == null? "?": this.category;

    return  "\"" + id + "\", "
            + text + "\", "
            + completed +  "\", "
            + due_string + "\", "
            + priority_string + "\", "
            + category_string + "\", ";
  }

  @Override
  public int compareTo(Todo todo) {

    if(sortByPriority) {
      return this.priority - todo.priority;
    }else{
      return this.due.compareTo(todo.due);
    }
  }
}
