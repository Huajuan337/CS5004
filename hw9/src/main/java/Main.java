import java.util.Map;

/**
 * main is only responsible to trigger the command line arguments parsing and file read and write
 */
public class Main {

  /**
   * trigger the command line arguments parsing,
   * add new todo, completed todo or display the todo
   * based on the flag is provided
   *
   * @param args String[], command line arguments
   * @throws CMDLineParserException - if command lind arguments is not provided correctly
   * @throws FileParsingException - if parsing command line have any error
   */
  public static void main(String[] args) throws CMDLineParserException, FileParsingException {
    CMDLineParser parser = new CMDLineParser();
    Map<Flag, Object> todoCommand = null;

    try{
      todoCommand = parser.parseCommandLineArgs(args);
      TodoParser todoParser = new TodoParser(todoCommand);
      todoParser.processCommandBasedOnOption();
    }catch (CMDLineParserException cmde){
      System.out.println(cmde.getMessage());
    }catch (FileParsingException ioe){
      System.out.println(ioe.getMessage());
    }
  }
}
