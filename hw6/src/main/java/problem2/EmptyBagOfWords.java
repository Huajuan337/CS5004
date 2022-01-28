package problem2;

import problem1.EmptyPqException;

public class EmptyBagOfWords implements BagOfWords{

  /**
   * @return an empty BagOfWords
   */
  @Override
  public BagOfWords emptyBagOfWords() {
    return new EmptyBagOfWords();
  }

  /**
   * @return true if BagOfWords is empty else false
   */
  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }

  /**
   * @return size of BagOfWords as integer
   */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * @param s expressed as string
   * @return a new BagOfWords after adding a nw string
   */
  @Override
  public BagOfWords add(String s) {
    return new NonEmptyBagOfWords(s, this);
  }

  /**
   * @param s expressed as string
   * @return true if BagOfWords contains the string s, else false
   */
  @Override
  public Boolean contains(String s) {
    return Boolean.FALSE;
  }

  @Override
  public BagOfWords remove(String s)  {
    return this;
  }

  /**
   * @param o two objects
   * @return true if two object is the same else return false
   */
  public boolean equals(Object o){
    if(o instanceof EmptyBagOfWords)
      return true;
    else
      return false;
  }
}
