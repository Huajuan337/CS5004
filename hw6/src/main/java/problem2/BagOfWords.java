package problem2;

import problem1.EmptyPqException;

public interface BagOfWords {

  BagOfWords emptyBagOfWords();
  Boolean isEmpty();
  Integer size();
  BagOfWords add(String s);
  Boolean contains(String s);
  BagOfWords remove(String s);
}
