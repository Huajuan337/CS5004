import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.Arrays;

/**
 * CMDLineParse parse the command line arguments and check for errors
 */
public class CMDLineParser {

  private static final String CSV_FILE_FLAG = "--csv-file";
  private static final String ADD_TODO_FLAG = "--add-todo";
  private static final String TODO_TEXT_FLAG = "--todo-text";
  private static final String COMPLETED_FLAG = "--completed";
  private static final String DUE_FLAG = "--due";
  private static final String PRIORITY_FLAG = "--priority";
  private static final String CATEGORY_FLAG = "--category";
  private static final String COMPLETE_TODO_FLAG = "--complete-todo";
  private static final String DISPLAY_FLAG = "--display";
  private static final String SHOW_INCOMPLETE_FLAG = "--show-complete";
  private static final String SHOW_CATEGORY_FLAG = "--show-category";
  private static final String SORT__BY_DATE_FLAG = "--sort-by-date";
  private static final String SORT__BY_PRIORITY_FLAG = "--sort-by-category";
  private static final int ARGS_MIN = 3;
  private static final int LowestPriority = 3;


  /**
   * parse the command line arguments and check for possible error
   *
   * @param args - string[], command line arguments
   * @return - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if command line arguments is not provided correctly
   */
  public Map<Flag, Object> parseCommandLineArgs(String[] args) throws CMDLineParserException {
    Map<Flag, Object> todoOption = new HashMap<>();
    checkCMDArgsNumValid(args);
    checkNumForAddToDoCommandLineArg(args);
    checkCSVFile(args, todoOption);
    checkAddTodoAndTodoText(args, todoOption);
    checkCompleted(args, todoOption);
    checkDue(args, todoOption);
    checkPriority(args, todoOption);
    checkCategory(args, todoOption);
    checkCompletedTodo(args, todoOption);
    checkDisplay(args, todoOption);
    checkShowIncompleted(args, todoOption);
    checkShowCategory(args, todoOption);
    checkSortByDate(args, todoOption);
    checkSortByPriority(args, todoOption);

    return todoOption;
  }

  /**
   * check if command line arguments number is larger than 3. The --display can without any arguments,
   * but it also need to read the csv file and its path.
   * so the minimum command line argument is 3. There is no maximum command line arguments since user can
   * complete multiple todo tasks by repeating.
   *
   * @param args - string[], command line arguments
   * @throws CMDLineParserException if there is a command ar
   */
  private void checkCMDArgsNumValid(String[] args) throws CMDLineParserException{
    if(args.length < ARGS_MIN ){
      throw new CMDLineParserException(
          "Error: The number of command line arguments need to be greater or equal to 3");
    }
  }

  /**
   * check --add-todo only occur once. User can only add one Todo at a time
   *
   * @param args - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if --add-todo occurs more than one
   */
  private void checkNumForAddToDoCommandLineArg(String[] args) throws CMDLineParserException {
    Map<String, Integer> flagCurrentCounter = new HashMap<>();

    for(int i = 0; i < args.length; i++){
      flagCurrentCounter.put(args[i], flagCurrentCounter.getOrDefault(args[i], 0) + 1);
      if(flagCurrentCounter.get(args[i]) > 1 && args[i].equals(ADD_TODO_FLAG)){
        throw new CMDLineParserException(
            "Error: Do not provide the add-todo command more than once");
      }
    }
  }

  /**
   * check if the csv file exists. if --csv file is provided and the path is also provided,
   * save it in the todoOption
   *
   * @param args - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if either --csv-file is not provided ir the file path is invalid
   */
  private void checkCSVFile(String[] args, Map<Flag, Object> todoOption) throws CMDLineParserException{
    boolean hasCSVFile = false;
    boolean hasCSVFilePath = false;
    String CSVFIlePath = null;

    for(int i =0; i <args.length; i++){
      if(hasCSVFile && hasCSVFilePath){
        break;
      }
      if(args[i].equals(CSV_FILE_FLAG)){
        hasCSVFile = true;
        if(i+1 < args.length){
          String possibleCVSFilePath = args[i+1];
          try{
            Paths.get(possibleCVSFilePath);
            hasCSVFilePath = true;
            CSVFIlePath = possibleCVSFilePath;
          }catch(InvalidPathException ipe){
            throw new CMDLineParserException("Error: -- csv-file is provided but the csv file path is either not provided or not correct");
          }
        }else{
          throw new CMDLineParserException("Error: --csv-file is provided but the csv file path is not provided");
        }
      }
    }if(!hasCSVFile){
      throw new CMDLineParserException("Error: --csv-file is required but not provided");
    }
    todoOption.put(Flag.CSV_FILE, CSVFIlePath);
  }

  /**
   * check if --add-todo and --todo-text exists. if they both exist and description of text,
   * save it in todoOption
   *
   * @param args - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if either --add-todo is not provided, or --todo-text or text are not provided
   */
  private void checkAddTodoAndTodoText(String[] args, Map<Flag, Object> todoOption) throws CMDLineParserException {
    boolean hasAddTodo = false;
    boolean hasTodoText = false;
    boolean hasTextDescription = false;
    String textDescription = null;

    for(int i =0; i< args.length; i++){
      if(hasAddTodo && hasTodoText && hasTextDescription){
        break; // only one addtodo per command
      }
      if(args[i].equals(ADD_TODO_FLAG)){
        hasAddTodo = true;
      }else if(args[i].equals(TODO_TEXT_FLAG)){
        hasTodoText = true;
        if(i+1 < args.length){
          String possibleTextDescription = args[i+1];
          if(possibleTextDescription.length()==0 || isCommand(possibleTextDescription)){
            throw new CMDLineParserException("Error: Text description is either not provided or not correct");
          }
          else{
            textDescription = possibleTextDescription;
          }
        }else{
          throw new CMDLineParserException("Error: Text description is not provided");
        }
      }
    }
    if(hasAddTodo && hasTodoText && hasTextDescription){
      todoOption.put(Flag.ADD_TODO, textDescription);
    }else if(hasAddTodo){
      throw new CMDLineParserException("Error: --add-todo provided but no --todo-text was given");
    } else if (hasTodoText){
      throw new CMDLineParserException("Error: --todo-text provided but no --add-todo");
    }
  }

  /**
   * check if --completed exists. if it exists, mark it true, and save it in todoOption
   *
   * @param args - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   */
  private void checkCompleted(String[] args, Map<Flag, Object> todoOption){
    boolean hasCompleted = false;
    boolean completed = false;

    for(int i =0; i< args.length; i++) {
      if (hasCompleted) {
        break;
      }

      if(args[i].equals(COMPLETED_FLAG)){
        hasCompleted = true;
        completed = true;
      }
    }

    todoOption.put(Flag.COMPLETED, completed);
  }

  /**
   * check if --due exists. if --due and date format are provided, save it to todoOption
   *
   * @param args - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if either --due is not provided or date format is not correct
   */
  private void checkDue(String[] args, Map<Flag, Object> todoOption) throws CMDLineParserException {
    boolean hasDue = false;
    boolean hasDate = false;
    //    LocalDate dueDate = null;  //dueDate "2021-05-05"
    LocalDate dueDate = null;

    for(int i = 0; i < args.length; i++){
      if(hasDue && hasDate){
        break;
      }
      if(args[i].equals(DUE_FLAG)){
        hasDue = true;
        if(i+1 < args.length){
          String possibleDate = args[i+1];
          // check if possibleDate has a correct format, "M/D/Y", i.e. "12/08/2021"
          try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            dueDate = LocalDate.parse(possibleDate, formatter);
            hasDate = true;
          }catch (InvalidPathException ipe){
            throw new CMDLineParserException("Error: The due date is either not provided ot not correct");
          }
        }else{
          throw new CMDLineParserException("Error: The due date is not provided");
        }
      }
    }

    if(hasDue && hasDate){
      todoOption.put(Flag.DUE, dueDate);
    }
  }

  /**
   * check if priority exists. if --priority and priority number exist, save them in the todoOption
   *
   * @param args - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if either --priority is not provided or priority number is not "1","2","3"
   */
  private void checkPriority(String[] args, Map<Flag, Object> todoOption) throws CMDLineParserException {

    boolean hasPriority = false;
    boolean hasPriorityNum = false;
    int priorityNum = LowestPriority;

    Set<String> priorityOptions = new HashSet<>( Arrays.asList("1", "2", "3"));

    for(int i = 0; i < args.length; i++){
      if(hasPriority && hasPriorityNum){
        break;
      }

      if(args[i].equals(PRIORITY_FLAG)){
        hasPriority = true;
        if(i+1 < args.length){
          String possiblePriorityNum = args[i+1];
          // check if possiblePriorityNum is a number between 1 and 3
          if(priorityOptions.contains(possiblePriorityNum)){
            hasPriorityNum = true;
            priorityNum = Integer.valueOf(possiblePriorityNum);
          }
          else{
            throw new CMDLineParserException("Error: The priority number is not 1, 2 or 3");
          }
        }else{
          throw new CMDLineParserException("Error: --priority is provided but no value is given");
        }
      }
    }

    todoOption.put(Flag.PRIORITY, priorityNum);

  }

  /**
   *  check if category exists. if --category and category name exist, save them in the todoOption
   *
   * @param args - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if either --category is not provided or priority name is not provided
   */
  private void checkCategory(String[] args, Map<Flag, Object> todoOption) throws CMDLineParserException {
    boolean hasCategory = false;
    boolean hasCategoryName = false;
    String categoryName = null;

    for(int i = 0; i < args.length; i++){
      if(hasCategory && hasCategoryName){
        break;
      }
      if(args[i].equals(CATEGORY_FLAG)){
        hasCategory = true;
        if(i+1 < args.length){
          String possibleCategoryName = args[i+1];
          if(isCommand(possibleCategoryName)){
            throw new CMDLineParserException("Error: The category name cannot be a command");
          }else{
            categoryName = possibleCategoryName;
            hasCategoryName = true;
          }
        }else{
          throw new CMDLineParserException("Error: The category name is either not provided");
        }
      }
    }

    if(hasCategory && hasCategoryName){
      todoOption.put(Flag.CATEGORY, categoryName);
    }
  }

  /**
   *  check if --completed-todo exists. if ---completed-todo and id exist, save them in the todoOption
   *
   * @param args - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if either --completed-todo is not provided or id is not provided
   */
  private void checkCompletedTodo(String[] args, Map<Flag, Object> todoOption) throws CMDLineParserException {
    // String completedId = null;
    ArrayList<Integer> completedIds = new ArrayList<>();

    for(int i = 0; i < args.length; i++){
      if(args[i].equals(COMPLETE_TODO_FLAG)){
        if(i+1 < args.length){
          String possibleId = args[i+1];
          try{
            int id = Integer.parseInt(possibleId);
            completedIds.add(id);
          }catch (InvalidPathException ipe){
            throw new CMDLineParserException("Error: The id is either not provided or not correct");
          }
        }else{
          throw new CMDLineParserException("Error: The id is not provided");
        }
      }
    }

    todoOption.put(Flag.COMPLETED_TODO, completedIds);
  }


  /**
   *  check if --display exists. if ---display exist, mark true, else mark false in the todoOption
   *
   * @param args - string[], command line arguments
   */
  private void checkDisplay(String[] args, Map<Flag, Object> todoOption) {
    boolean hasDisplay = false;

    for(int i = 0; i <args.length; i++) {
      if (hasDisplay) {
        break;
      }

      if (args[i].equals(DISPLAY_FLAG)) {
        hasDisplay = true;
      }
    }

    todoOption.put(Flag.DISPLAY, hasDisplay);
  }

  /**
   *  check if --show-incompleted. if --show-incompleted exist, mark true, else mark false in the todoOption
   *
   * @param args - string[], command line arguments
   */
  private void checkShowIncompleted(String[] args, Map<Flag, Object> todoOption) {
    boolean hasShowIncompleted = false;
    boolean showIncompleted = false;

    for(int i = 0; i < args.length; i++){
      if(hasShowIncompleted){
        break;
      }

      if(args[i].equals(SHOW_INCOMPLETE_FLAG)){
        hasShowIncompleted = true;
        showIncompleted = true;
      }
    }

    if(hasShowIncompleted){
      todoOption.put(Flag.SHOW_INCOMPLETED, showIncompleted);
    }
  }

  /**
   * check if --show-category exist. if --show-category  and category name exist, save them in the todoOption
   * @param args - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   * @throws CMDLineParserException if either priority name is not provided or incorrect
   */
  private void checkShowCategory(String[] args, Map<Flag, Object> todoOption) throws CMDLineParserException{
    boolean hasShowCategory = false;
    boolean hasCategory = false;
    String showCategory = null;

    for(int i = 0; i < args.length; i++){
      if(hasShowCategory){
        break;
      }
      // need to check next arg, let it be showCategory
      if(args[i].equals(SHOW_CATEGORY_FLAG)){
        hasShowCategory = true;
        if(i+1 < args.length){
          String possibleCategory = args[i+1];
          if(isCommand(possibleCategory)){
            throw new CMDLineParserException("Error: The category name cannot be a command");
          }else{
            showCategory = possibleCategory;
            hasCategory = true;
          }
        }else {
          throw new CMDLineParserException("Error: The category name is either not provided");
        }
      }
    }

    if(hasShowCategory && hasCategory){
      todoOption.put(Flag.SHOW_CATEGORY, showCategory);
    }

  }

  /**
   * check if the --sort-by-date exist. if --sort-by-date exist, save it in todoOption
   *
   * @param args - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   */
  private void checkSortByDate(String[] args, Map<Flag, Object> todoOption) {
    boolean hasCheckSortByDate = false;
    String sortByDate = null;

    for(int i = 0; i < args.length; i++){
      if(hasCheckSortByDate){
        break;
      }

      if(args[i].equals(SORT__BY_DATE_FLAG)){
        hasCheckSortByDate = true;
        sortByDate = "true";
      }
    }

    if(hasCheckSortByDate){
      todoOption.put(Flag.SORT_BY_DATE, sortByDate);
    }
  }

  /**
   *  check if the --sort-by-priority exist. if --sort-by-date exist, save it in todoOption
   *
   * @param args - string[], command line arguments
   * @param todoOption - map<Flag, Object>, a mapping of the provided flag to the possible actions
   */
  private void checkSortByPriority(String[] args, Map<Flag, Object> todoOption) {
    boolean hasSortByPriority = false;
    boolean sortByPriority = false;

    for(int i = 0; i < args.length; i++){
      if(hasSortByPriority){
        break;
      }

      if(args[i].equals(SORT__BY_PRIORITY_FLAG)){
        hasSortByPriority = true;
        sortByPriority = true;
      }
    }

    if(hasSortByPriority){
      todoOption.put(Flag.SORT_BY_PRIORITY, sortByPriority);
    }
  }

  /**
   * helper method to check whether the string argument is in the command line flag list
   *
   * @param arg - string,
   * @return - boolean true if the string argument in the command line flag list, else false
   */
  private boolean isCommand(String arg){
      Set<String> commands = new HashSet<>( Arrays.asList(CSV_FILE_FLAG, ADD_TODO_FLAG, TODO_TEXT_FLAG, COMPLETED_FLAG, DUE_FLAG, PRIORITY_FLAG, CATEGORY_FLAG,
        COMPLETE_TODO_FLAG, DISPLAY_FLAG, SHOW_INCOMPLETE_FLAG, SHOW_CATEGORY_FLAG, SORT__BY_DATE_FLAG, SORT__BY_PRIORITY_FLAG) );

      if(commands.contains(arg)){
        return true;
      }
      return false;
  }
}

