package Problem2;

import java.util.Arrays;
import java.util.Objects;

public class Catalog {

  private Item collectionItem[];
  private int Max_SIZE = 100;
  private int size;

  public Catalog() {
    collectionItem = new Item[Max_SIZE];
    size = 0;
  }

  /**
   *
   * @param addItem add item to collectionItem list
   */
  public void Add(Item addItem){
    collectionItem[size] = addItem;
    size++;
  }

  /**
   *
    * @return the size of collectionItem
   */
  public int getSize() {
    return size;
  }

  /**
   *
   * @param removeItem item from the collectionItem list
   */
  public void Remove(Item removeItem){
    int index = 0;
    for(int i = 0; i < size; i++){
      if(removeItem == collectionItem[i]){
        index = i;
        break;
      }
    }
    for(int i = index; i < size; i++){
      collectionItem[i] = collectionItem[i+1];
    }
    size -= 1;
  }

  /**
   *
   * @param keyword an argument expressed as String
   * @return subCollection of collectionItem if it meets the conditions
   */

  public Catalog Search(String keyword){
    Catalog subCollection = new Catalog();
    for(int i = 0; i < size; i++){
      if(collectionItem[i].getTitle().contains(keyword.toLowerCase()) ||
          collectionItem[i].getTitle().contains(keyword.toUpperCase())){
        subCollection.Add(collectionItem[i]);
      }
    }
    return subCollection;
  }

  /**
   *
   * @param author an argument expressed as Author
   * @return subCollection of collectionItem if it meets the conditions
   */
  public Catalog Search(Author author){ // you didn't use the author here
    Catalog findAuthor = new Catalog();

    for(int i = 0; i < size; i++){
      if(collectionItem[i].getCreators() instanceof Author){
        if(((Author) collectionItem[i].getCreators()).getFirstName().equals(author.getFirstName())
            && ((Author) collectionItem[i].getCreators()).getLastName().equals(author.getLastName())) {
          findAuthor.Add(collectionItem[i]);
        }
      }
    }
    return findAuthor;
  }

  /**
   *
   * @param artist an argument expressed as RecordingArtist
   * @return subCollection of collectionItem if it meets the conditions
   */
  public Catalog Search(RecordingArtist artist){
    Catalog findArtist = new Catalog();
    for(int i = 0; i < size; i++){
      if(collectionItem[i].getCreators() instanceof  RecordingArtist){
        if(((RecordingArtist) collectionItem[i].getCreators()).getFirstName().equals(artist.getFirstName())
            && ((RecordingArtist) collectionItem[i].getCreators()).getLastName().equals(artist.getLastName())) {
          findArtist.Add(collectionItem[i]);
        }
      }

      if(collectionItem[i].getCreators() instanceof Band){
        RecordingArtist[] members = ((Band) collectionItem[i].getCreators()).getMembers();
        for(int j=0; j< members.length; j++){
          if(members[j].getFirstName().equals(artist.getFirstName()) && members[j].getLastName().equals(artist.getLastName())){
            findArtist.Add(collectionItem[i]);
            break; // for j loop
          }
        }
      }
    }
    return findArtist;
  }

  /**
   *
   * @param o objects
   * @return true if two objects are the same, else return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Catalog)) {
      return false;
    }
    Catalog catalog = (Catalog) o;
    return Max_SIZE == catalog.Max_SIZE && getSize() == catalog.getSize() && Arrays.equals(
        collectionItem, catalog.collectionItem);
  }

  /**
   *
   * @return true if two objects are in the same position, else return false
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(Max_SIZE, getSize());
    result = 31 * result + Arrays.hashCode(collectionItem);
    return result;
  }

  /**
   *
   * @return catalog information expressed as string
   */
  @Override
  public String toString() {
    return "Catalog{" +
        "collectionItem=" + Arrays.toString(collectionItem) +
        ", Max_SIZE=" + Max_SIZE +
        ", size=" + size +
        '}';
  }
}

