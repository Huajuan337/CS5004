package problem2;

import java.util.Objects;
import problem1.EmptyPqException;

public class NonEmptyBagOfWords implements BagOfWords {

  private String words;
  private BagOfWords rest;

  /**
   * @param words expressed as string
   * @param rest the rest of the words expressed as BagOfWords
   */
  public NonEmptyBagOfWords(String words, BagOfWords rest) {
    this.words = words;
    this.rest = rest;
  }

  /**
   * @return words expressed as string
   */
  public String getWords() {
    return this.words;
  }

  /**
   * @return the rest of the words expressed as BagOfWords
   */
  public BagOfWords getRest() {
    return this.rest;
  }

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
    return Boolean.FALSE;
  }

  /**
   * @return size of BagOfWords as integer
   */
  @Override
  public Integer size() {
    return 1+this.rest.size();
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
    if(this.words.equals(s)){
      return Boolean.TRUE;
    }else{
      return this.rest.contains(s);
    }
  }

  public BagOfWords remove(String element) {
    if(!this.contains(element))
      return this;
    else if(this.getWords().equals(element))
      return this.rest;
    else
      return new NonEmptyBagOfWords(this.getWords(), this.rest.remove(element));
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
    if (!(o instanceof NonEmptyBagOfWords)) {
      return false;
    }
    NonEmptyBagOfWords that = (NonEmptyBagOfWords) o;
    NonEmptyBagOfWords current = this;

    if(this.size().equals(that.size())) {
      while (that instanceof NonEmptyBagOfWords) {
        if (!current.size().equals(that.size()))
          return Boolean.FALSE;
        else
          current = (NonEmptyBagOfWords) current.remove(that.words);
          that = (NonEmptyBagOfWords) that.rest;

        if(current.size()==1 && that.size()==1 && Objects.equals(current.getWords(), that.getWords())){
          return true;
        }
      }
    }
    return Boolean.FALSE;
  }

  /**
   * @return integer representation of the object based on the object current state
   */
  @Override
  public int hashCode() {
    return Objects.hash(getWords(), getRest());
  }

  @Override
  public String toString() {
    return "NonEmptyBagOfWords{" +
        "words='" + words + '\'' +
        ", rest=" + rest +
        '}';
  }
}
