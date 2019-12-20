//import javafx.scene.shape.Path;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.Random;

public class Facet {
    private R3Vector[] vertex;
    private Color color;
    private Random r = new Random();
    double[] t = new double[4];
    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4){
        vertex = new R3Vector[4];
        vertex[0] = v1;
        vertex[1] = v2;
        vertex[2] = v3;
        vertex[3] = v4;
        color = new Color(r.nextInt(255), r.nextInt(255) , r.nextInt(255));
    }
    public void out(){
        for(int i = 0; i<vertex.length; i++) {
            vertex[i].out();
            System.out.print(" - ");
            if(i==3){
                vertex[0].out();
            }else{
                vertex[i + 1].out();
            }
            System.out.print("\n");
        }
    }
    public void rotate(double ux, double uy, double uz){
        for(int i=0; i<vertex.length; i++){
            vertex[i].rotate(ux,uy,uz);
        }
    }
    public void scale(double k){
        for(int i=0; i<vertex.length; i++){
            vertex[i].scale(k);
        }
    }
    public void translate(double dx, double dy, double dz){
        for(int i=0; i<vertex.length; i++){
            vertex[i].translate(dx,dy,dz);
        }
    }
    
    public void draw(Graphics2D g){
        Path2D path = new Path2D.Double();
        path.moveTo(vertex[0].getX(), vertex[0].getY());
        path.lineTo(vertex[1].getX(), vertex[1].getY());
        path.lineTo(vertex[2].getX(), vertex[2].getY());
        path.lineTo(vertex[3].getX(), vertex[3].getY());
        path.lineTo(vertex[0].getX(), vertex[0].getY());
        path.closePath();
        if(light()) {
            g.setColor(this.color);
            g.fill(path);
        }
    }
    public void drawPers(Graphics2D g){
    	double c = -500;
        Path2D path = new Path2D.Double();
        t[0] = (vertex[0].getZ() - c) / -c;
        t[1] = (vertex[1].getZ() - c) / -c;
        t[2] = (vertex[2].getZ() - c) / -c;
        t[3] = (vertex[3].getZ() - c) / -c;
        g.setColor(Color.black);
        path.moveTo(vertex[0].getX() * t[0], vertex[0].getY() * t[0]);
        path.lineTo(vertex[1].getX() * t[1], vertex[1].getY() * t[1]);
        path.lineTo(vertex[2].getX() * t[2], vertex[2].getY() * t[2]);
        path.lineTo(vertex[3].getX() * t[3], vertex[3].getY() * t[3]);
        path.lineTo(vertex[0].getX() * t[0], vertex[0].getY() * t[0]);
        path.closePath();
        if(light()) {
            g.setColor(this.color);
            g.fill(path);
        }
       // g.draw(path);
    }

     


    
    
  public boolean light(){
  if (R3Vector.normal(R3Vector.diagonals(R3Vector.iskaz(vertex[0], t[0]), R3Vector.iskaz(vertex[1], t[1])), 
		  R3Vector.diagonals(R3Vector.iskaz(vertex[0], t[0]), R3Vector.iskaz(vertex[3], t[3]))).getZ() < 0) {
      return true;
  }else
      return false;
}
}
