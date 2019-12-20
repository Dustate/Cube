import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Viewer extends JFrame {
    public static final int width = 800;
    public static final int height = 800;
    private Cube cube;
    public Viewer(Cube cube) {
        this.cube = cube;
        this.setSize(width, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(" Û·");
        this.setLocationRelativeTo(null);
        this.setState(JFrame.ICONIFIED);
    }
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D)gr;
        BasicStroke pen1 = new BasicStroke(2);
        g.setStroke(pen1);     
        g.translate(Viewer.width/2, Viewer.height/2);
        gr.drawLine(-Viewer.width / 2, 0, Viewer.width / 2, 0);
        gr.drawLine(0, Viewer.height/2, 0, -Viewer.height/2);
        g.setColor(Color.white);
        g.fillRect(-width/2,-height/2, width, height);
        g.setColor(Color.black);
        g.drawLine(-Viewer.width / 2, 0, Viewer.width / 2, 0);
        g.drawLine(0, Viewer.height/2, 0, -Viewer.height/2);
        //cube.draw(g);
        cube.drawPers(g);
    }
}
