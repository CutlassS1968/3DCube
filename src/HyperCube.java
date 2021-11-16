import java.awt.geom.Point2D;
import java.util.ArrayList;

// TODO: something's wrong with the vertex-graycode mapping OR drawing for non 3 dimensional cubes

public class HyperCube {

  private ArrayList<Edge> edges;
  private Vertex[] vertices;
  private ArrayList<String> labels;

  public HyperCube(int n) {
    // number of vertices is n^2 - 1
    vertices = new Vertex[((int)Math.pow(n, 2) - 1)];
    edges = new ArrayList<>();

    // generate n-bit gray code
    labels = nBitCode(n, new ArrayList<>());

    // map code onto vertices
    for (int i = 0; i < vertices.length; i++) {
      vertices[i] = new Vertex(labels.get(i));
    }

    plot();

    // map vertices onto edges
    for (int i = 0; i < vertices.length; i++) {
      for (int j = i + 1; j < vertices.length; j++) {
        if (adjacency(vertices[i].getCode(), vertices[j].getCode())) {
          edges.add(new Edge(vertices[i], vertices[j]));
//          System.out.println(i + ", " + j);
        }
      }
    }
  }

  public void plot() {
    double d = (360.0/vertices.length) * (Math.PI/180);
    for (int i = 0; i < vertices.length; i++) {
      int x = (int)((250) + (100*Math.cos(d*i)));
      int y = (int)((250) + (100*Math.sin(d*i)));
      vertices[i].setCenter(new Point2D.Double(x, y));
      System.out.println(vertices[i].getX() + ", " + vertices[i].getY());
    }
  }

  /**
   * returns false if difference is greater than 1 char
   * @param l Code 1
   * @param t Code 2
   * @return adjacency
   */
  private boolean adjacency(String l, String t) {
    int c = 0;
    for (int i = 0; i < l.length(); i++) {
      if (!l.substring(i,i+1).equals(t.substring(i,i+1))) c++;
    }
    return c <= 1;
  }

  public ArrayList<String> nBitCode(int n, ArrayList<String> l) {
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

  public ArrayList<Edge> getEdges() {
    return edges;
  }

  public void setEdges(ArrayList<Edge> edges) {
    this.edges = edges;
  }

  public Vertex[] getVertices() {
    return vertices;
  }

  public void setVertices(Vertex[] vertices) {
    this.vertices = vertices;
  }

  public ArrayList<String> getLabels() {
    return labels;
  }

  public void setLabels(ArrayList<String> labels) {
    this.labels = labels;
  }

}
