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

  private String code;

  public Vertex(String code) {
    super(0, 0);
    this.code = code;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}
