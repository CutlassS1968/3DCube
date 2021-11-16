import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Set;

public class HyperCube implements Shape {
  private ArrayList<Edge> edges;
  private Vertex[] vertices;
  private ArrayList<String> labels;

  public HyperCube(int n) {
    vertices = new Vertex[8];
    edges = new ArrayList<>();

    labels = grayCode(n, new ArrayList<>());

    for (int i = 0; i < vertices.length; i++) {
      vertices[i] = new Vertex(labels.get(i));
    }

    System.out.println(grayCode(3, new ArrayList<String>()));


    edges = new ArrayList<>();
    labelVertices();
  }

  public ArrayList<String> grayCode(int n, ArrayList<String> l) {
    l.add("");
    for (int i = 0; i < n; i++) {
      ArrayList<String> t = flip(l);
      concat(t, "1");
      concat(l, "0");
      l.addAll(t);
    }
    return l;
  }

  private ArrayList<String> concat(ArrayList<String> l, String n) {
    for (int i = 0; i < l.size(); i++) {
      String str;
      str = l.get(i);
      str = n + str;
      l.set(i, str);
    }
    return l;
  }

  private ArrayList<String> flip(ArrayList<String> l) {
    ArrayList<String> t = new ArrayList<>();
    for (int i = l.size() - 1; i >= 0; i--) {
      t.add(l.get(i));
    }
    return t;
  }

  // Create a list of labels, after calculated, translate to vertices
  private void labelVertices() {

  }

  private void resizeLabels() {
    for (int i = 0; i < labels.size(); i++) {


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
