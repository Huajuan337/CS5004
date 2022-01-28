package Problem2;

public class Music extends Item{

  /**
   *
   * @param creators  music's creator
   * @param title music's title, expressed as String
   * @param year music's released year, expressed as Integer
   */
  public Music(Creator creators, String title, Integer year) {
    super(creators, title, year);
  }
}
