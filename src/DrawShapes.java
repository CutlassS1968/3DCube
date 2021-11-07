import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class DrawShapes {

  JFrame frame;
  Canvas canvas;
  Graphics graphics;
  Graphics2D g2D;
  BufferStrategy b;
  BufferedImage buffer;
  GraphicsDevice gd;
  GraphicsEnvironment ge;
  GraphicsConfiguration gc;

  boolean isRunning = false;

  public DrawShapes() {
    frame = new JFrame("Demo");
    frame.setIgnoreRepaint(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);

    canvas = new Canvas();
    canvas.setIgnoreRepaint(true);
    canvas.setSize(500, 500);
    canvas.setBackground(Color.WHITE);

    Container content = new Container();
    content.add(canvas);
    content.setPreferredSize(new Dimension(500, 500));
    frame.setContentPane(content);
    frame.pack();

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    canvas.createBufferStrategy(2);
    b = canvas.getBufferStrategy();

    ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    gd = ge.getDefaultScreenDevice();
    gc = gd.getDefaultConfiguration();
    buffer = gc.createCompatibleImage(500, 500);

    graphics = null;
    g2D = null;
    isRunning = true;

    Cube cube = new Cube();

    draw();
  }

  private void draw() {
    while (isRunning) {
      try {
        canvas.setSize(500, 500);
        buffer = gc.createCompatibleImage(500, 500);
        g2D = buffer.createGraphics();

        g2D.setColor(Color.WHITE);
        g2D.fillRect(0, 0, 500, 500);

        g2D.setColor(Color.DARK_GRAY);
        g2D.fill(new Ellipse2D.Double(250, 250, 30, 30));

//        g2D.draw(new Cube());

        graphics = b.getDrawGraphics();
        graphics.drawImage(buffer, 0, 0, null);
        if (!b.contentsLost())
          b.show();
        Thread.sleep(15);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    DrawShapes application = new DrawShapes();
  }
}
