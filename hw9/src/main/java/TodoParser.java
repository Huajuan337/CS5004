import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoParser {

  private static final String CSV_FILE_DELIMITER = "\" *, *\"";
  private final Map<Flag, Object> options;
  private List<String> csvFileHeader = new ArrayList<>();
  private List<Map<String, String>> fileInfo = new ArrayList<>();
  private Integer maxId = -99;

  /**
   * constructor to create a TodoParse with the specified options
   *
   * @param options -Map<String, Object>, a map of the flag to the possible actions
   */
  public TodoParser(Map<Flag, Object> options) {
    this.options = options;
  }

  /**
   * run the tasks based on command information
   *
   * @throws FileParsingException if any of the writing or reading to or from file fails
   */
  public void processCommandBasedOnOption() throws FileParsingException {

    if(options.containsKey(Flag.ADD_TODO)){
      processAddTodo();
    }
    if(options.containsKey(Flag.COMPLETED_TODO)){
      processCompletedTodo();
    }
    if(options.containsKey(Flag.DISPLAY)) {
      processDisplay();
    }
  }

  /**
   * parse the csv input file with all the supporter's information and store it
   *
   * @throws FileParsingException if the parsing of csv input file is incorrect
   */
  private void readCSVFile() throws FileParsingException {
    String csvFilePath = (String) options.get(Flag.CSV_FILE);
    try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))){
      String line;
      int index = 0;
      while((line = csvReader.readLine()) != null){
        line = line.substring(1, line.length()-1);
        String[] splitLine = line.split(CSV_FILE_DELIMITER);
        if(index == 0){
          csvFileHeader = Arrays.asList(splitLine);
        }else{
          Map<String, String> supporterInfo = new HashMap<>();
          for(int i = 0; i < csvFileHeader.size(); i++){
            supporterInfo.put(csvFileHeader.get(i), splitLine[i]);
          }
          fileInfo.add(supporterInfo);
        }
        index ++;
      }

      this.maxId = index;
    } catch (IOException e) {
        throw new FileParsingException("Error: Something went wrong while parsing csv input file");
    }
  }

  /**
   * Write everything to the csv file
   *
   * @throws FileParsingException if any of writing ot reading to or from file fails
   */
  private void writeToCSVFile() throws FileParsingException {
    String csvFilePath = (String) options.get(Flag.CSV_FILE);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
      for(int i=0; i<csvFileHeader.size(); i++){
        String header = "\"" + csvFileHeader.get(i) + "\"";
        writer.write( header + ", " ); // todo remove the last ','
      }

      for (int i = 0; i < fileInfo.size(); i++) {
        Map<String, String> lineMap = fileInfo.get(i);
        String updatedLine = convertMapToTodo(lineMap).toString();
        writer.write(updatedLine + System.lineSeparator());
      }
    } catch (IOException e) {
      throw new FileParsingException(
          "Error: Something went wrong when writing to the " + csvFilePath
              + " file.");
    }
  }

  /**
   * Append a line to the bottom of csv input file
   *
   * @param addString  -string, append the string to the file
   * @throws FileParsingException if writing to the file fails
   */
  private void appendToCSVFile(String addString) throws FileParsingException {
    String csvFilePath = (String) options.get(Flag.CSV_FILE);
    try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(csvFilePath, true))){
      csvWriter.write(addString);
    } catch (IOException e) {
      throw new FileParsingException("Error: Something went wrong when writing to csv file");
    }
  }

  /**
   * Add new todo to the csv input file based on the flag option
   *
   * @throws FileParsingException
   */
  private void processAddTodo() throws FileParsingException {
    readCSVFile();

    String textDescription = (String) options.get(Flag.ADD_TODO);
    LocalDate due = null;
    String category = null;
    if(options.containsKey(Flag.DUE)) {
      due = (LocalDate) options.get(Flag.DUE);
    }

    if(options.containsKey(Flag.CATEGORY)){
      category =  (String) options.get(Flag.CATEGORY);
    }

    Todo newTodo = new Todo(maxId+1, textDescription, (Boolean) options.get(Flag.COMPLETED),
        (Integer) options.get(Flag.PRIORITY), due, category);

    // todo: if the csv file does not exist, we need to write header to the file
    appendToCSVFile(newTodo.toString());
  }

  /**
   * Change complete status to true if completed todo id exist in file, and update the csv file
   *
   * @throws FileParsingException if completed-todo id is not exist
   */
  private void processCompletedTodo() throws FileParsingException {
    readCSVFile();
    ArrayList<Integer> ids = (ArrayList<Integer>) options.get(Flag.COMPLETED_TODO);  // not an integer, but arraylist of int
    for(int i = 0; i < fileInfo.size(); i++){
      Map<String, String> todoMap = fileInfo.get(i);
      if(ids.contains(todoMap.get(csvFileHeader.get(0)))){ // contain todolist.get("id")
        todoMap.put("completed", "true"); // put todoMap["complete"] = "true"
      }else{
        throw new FileParsingException("Error: Todo ID is not exist");
      }
    }
    writeToCSVFile();
  }

  /**
   *display the csv file based on the flag options
   *
   * @throws FileParsingException if todo list is empty after filtering
   */
  private void processDisplay() throws FileParsingException {
    ArrayList<Todo> todoList = null;
    for(int i = 0; i < fileInfo.size(); i++){
      Todo todo = convertMapToTodo( fileInfo.get(i));  // convert map<string, string> => todo class
      boolean filter = true;

      //filter the list to only incompleted todo
      if(options.containsKey(Flag.SHOW_INCOMPLETED) && todo.getCompleted()) {
        filter = false;
      }

      //filter the list to the only with particular category
      if(options.containsKey(Flag.SHOW_CATEGORY) && !todo.getCategory().equals(options.get(Flag.SHOW_CATEGORY))) {
        filter = false;
      }

      if(filter) {
        if(options.containsKey(Flag.SORT_BY_PRIORITY)){
          todo.setSortByPriority(true);
        }
        else if(options.containsKey(Flag.SORT_BY_DATE)){
          todo.setSortByPriority(false);
        }
        todoList.add(todo);
      }

    }

    // sort
    if(options.containsKey(Flag.SORT_BY_DATE) || options.containsKey(Flag.SORT_BY_PRIORITY)) {
      Collections.sort(todoList);
    }

    //display
    if(todoList.size() > 0 ) {
      for (int i = 0; i < csvFileHeader.size(); i++) {
        System.out.printf(csvFileHeader.get(i) + ", "); // todo: remove the last ','
      }
      System.out.println("");
      for (int i = 0; i < todoList.size(); i++) {
        System.out.println(todoList.get(i).toString());
      }
    }else{
      throw new FileParsingException("Error: It's empty in todo list after filtering");
    }
  }

  /**
   * convert the map information to Todo class
   *
   * @param todoMap - Map<String, String>, store command line information
   * @return - todo class with command line information
   */
  private Todo convertMapToTodo(Map<String, String> todoMap){

    LocalDate due = null;
    if(!todoMap.get("due").equals("?")) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
      due = LocalDate.parse(todoMap.get("due"), formatter);
    }

    String category = null;
    if(!todoMap.get("category").equals("?")){
      category = todoMap.get("category");
    }

    Todo todo = new Todo( Integer.parseInt((todoMap.get("id"))),
                          todoMap.get("text"),
                          Boolean.parseBoolean(todoMap.get("completed")),
                          Integer.parseInt(todoMap.get("priority")),
                          due,
                          category
        );
    return todo;
  }
}
