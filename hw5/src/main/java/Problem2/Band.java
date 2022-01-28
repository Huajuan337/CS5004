package Problem2;

import java.util.Arrays;
import java.util.Objects;

public class Band extends Group{

  private String name;
  private RecordingArtist members[];

  /**
   *
   * @param name band's name expressed as String
   * @param members band's member expressed as list of recordingArtist
   */
  public Band(String name, RecordingArtist[] members) {
    this.name = name;
    this.members = members;
  }

  /**
   * @return name as string
   */
  public String getName() {
    return name;
  }

  /**
   * @return list of recordingArtist
   */
  public RecordingArtist[] getMembers() {
    return members;
  }

  /**
   * @param o objects
   * @return true if two objects are the same, else return true
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Band)) {
      return false;
    }
    Band band = (Band) o;
    return Objects.equals(getName(), band.getName()) && Arrays.equals(
        getMembers(), band.getMembers());
  }

  /**
   * @return true if two objects are in the same position, else return false
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(getName());
    result = 31 * result + Arrays.hashCode(getMembers());
    return result;
  }

  /**
   *
   * @return band information as string
   */
  @Override
  public String toString() {
    return "Band{" +
        "name='" + name + '\'' +
        ", members=" + Arrays.toString(members) +
        '}';
  }
}
