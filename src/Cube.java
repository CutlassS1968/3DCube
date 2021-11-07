import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Cube implements Shape {
  private ArrayList<Edge> edges;
  private Vertex[] vertices;

  public Cube() {
    vertices = new Vertex[8];
    for (int i = 0; i < vertices.length; i++) {
      vertices[i] = new Vertex();
    }
    edges = new ArrayList<Edge>();
    for (int i = 0; i < vertices.length; i++) {
      for (int j = i+1; j < vertices.length; j++) {
        if (i!=0 && i != vertices.length) {
          if (i % 2 == 0) { //i is even
            if (j % 2 != 0 && i + 3 != j) {
              edges.add(new Edge(vertices[i], vertices[j]));
              System.out.println("Draw Edge:" + i + ", " + j);
            }
          } else { //i is odd
            if (j % 2 == 0 && i - 3 != j) {
              edges.add(new Edge(vertices[i], vertices[j]));
              System.out.println("Draw Edge:" + i + ", " + j);
            }
          }
        } else {
          if (i%2==0) {
            if (j % 2 != 0 && i + 7 != j) {
              edges.add(new Edge(vertices[i], vertices[j]));
              System.out.println("Draw Edge:" + i + ", " + j);
            }
          } else {
            if (j%2==0 && i - 7 == j) {
              edges.add(new Edge(vertices[i], vertices[j]));
              System.out.println("Draw Edge:" + i + ", " + j);
            }
          }
        }
      }
    }
  }

  @Override
  public Rectangle getBounds() {
    return null;
  }

  @Override
  public Rectangle2D getBounds2D() {
    return null;
  }

  @Override
  public boolean contains(double x, double y) {
    return false;
  }

  @Override
  public boolean contains(Point2D p) {
    return false;
  }

  @Override
  public boolean intersects(double x, double y, double w, double h) {
    return false;
  }

  @Override
  public boolean intersects(Rectangle2D r) {
    return false;
  }

  @Override
  public boolean contains(double x, double y, double w, double h) {
    return false;
  }

  @Override
  public boolean contains(Rectangle2D r) {
    return false;
  }

  @Override
  public PathIterator getPathIterator(AffineTransform at) {
    return null;
  }

  @Override
  public PathIterator getPathIterator(AffineTransform at, double flatness) {
    return null;
  }
}
