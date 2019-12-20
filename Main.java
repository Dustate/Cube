import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Facet f = new Facet(new R3Vector(0,0,0), new R3Vector(1,0,0), new R3Vector(1,1,0),
                new R3Vector(0,1,0));
        f.out();
        /* f.rotate(90,90,90);
        f.out();
        f.scale(3);
        f.out();
        f.translate(15,10,12);
        f.out();*/
        Cube c = new Cube();
        c.scale(130);
        c.rotate(-40,20,0);
        Viewer v = new Viewer(c);
    }
}
