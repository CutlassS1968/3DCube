import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Set;

public class Cube implements Shape {
  private ArrayList<Edge> edges;
  private Vertex[] vertices;
  private ArrayList<String> labels;

  public Cube() {
    vertices = new Vertex[8];
    edges = new ArrayList<>();
    labels = new ArrayList<String>();
    for (int i = 0; i < vertices.length; i++) vertices[i] = new Vertex();

    edges = new ArrayList<>();
    labelVertices();
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
