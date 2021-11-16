import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Vertex extends Ellipse2D.Double {
  private String code;
  private int r;

  public Vertex(String code) {
    super(0.0, 0.0, 20, 20);
    r = 10;
    this.code = code;
  }

  public int getRadius() {
    return r;
  }

  public void setRadius(int r) {
    this.height = 2*r;
    this.width = 2*r;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Point2D.Double getCenter() {
    return new Point2D.Double(this.x + r, this.y + r);
  }

  public void setCenter(Point2D.Double center) {
    this.x = center.getX();
    this.y = center.getY();
  }

}
