import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;
//import org.jgrapht.generate;

public class Vertex extends Point2D.Double {
  /* What data structure to use for labels:
    - Order matters
    - Flexible in size
    - Copy and switch values easily
    - Easily manipulate values

    Arrays cant change in size easily
    ArrayList of Chars
   */

  private ArrayList<String> label;

  public Vertex() {
    super(0, 0);
  }

  public void setLabel(ArrayList<String> label) {
    this.label = label;
  }

  public ArrayList<String> getLabel() {
    return label;
  }
}
