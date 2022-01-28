package Problem2;

import java.util.Arrays;
import java.util.Objects;

public class Set implements SetInterface {

  private Integer size;
  private Integer arraySet[];
  private Integer MAX_SIZE = 100;

  public Set() {
    this.size = 0;
    arraySet = new Integer[MAX_SIZE];
  }

  @Override
  public Set emptySet() {
    return new Set();
  }


  @Override
  public Boolean isEmpty() {
    return size == 0;
  }

  @Override
  public Set add(Integer n) {
    if(!contains(n)){
      arraySet[this.size] = n;
      size ++;
    }
    return this;
  }

  @Override
  public Boolean contains(Integer n) {
    for(int i = 0; i < size; i++){
      if(arraySet[i].equals(n))
        return true;
    }
      return false;
  }

  @Override
//  我记得我是先copy了array，然后remove，最后new class Set 里面装remove过后的set，返回new Set
  public Set remove(Integer n) {
    Integer index = 0;
    Integer[] copy = new Integer[MAX_SIZE];

    if(!contains(n))
      return this;

    // copy the set, and remove the integer in the copy array
    for(int i = 0; i < this.size; i++){
      copy[i] = arraySet[i];
    }
    // find the removed integer index
    for(int i = 0; i < this.size; i++){
      if(copy[i].equals(n))
        index = i;
    }

    Integer copySize = this.size - 1;

    // remove the integer, copy the other number forward
    for(int i = index; i < copySize; i++){
      copy[i] = copy[i+1];
    }

    // set a new set and copy removed array to the new set
    Set copySet = new Set();
    for(int i = 0; i < copySize; i++){
      copySet.add(copy[i]);
    }

    return copySet;
  }

  @Override
  public Integer size() {
    return this.size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Set)) {
      return false;
    }
    Set setArray = (Set) o;
    return Objects.equals(size, setArray.size) && Arrays.equals(arraySet,
        setArray.arraySet);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(size);
    result = 31 * result + Arrays.hashCode(arraySet);
    return result;
  }

  @Override
  public String toString() {
    return "Set{" +
        "size=" + size +
        ", arraySet=" + Arrays.toString(arraySet) +
        ", MAX_SIZE=" + MAX_SIZE +
        '}';
  }
}
