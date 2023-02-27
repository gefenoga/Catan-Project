import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.Line2D;

public class Hexagon
{
    Point pos;
    Color color;
    String resource;
    int number;
    int prop;

    public Hexagon(int x, int y, int prop, Color color, String resource)
    {
        pos = new Point(x, y);
        this.color = color;
        this.prop = prop;
        this.resource = resource;



    }

    public void paint(Graphics g, int num)
    {
        this.number = num;

        int[] xPoints = {pos.x, pos.x + prop, pos.x + prop, pos.x, pos.x - prop, pos.x - prop};
        int[] yPoints = { pos.y, pos.y - (int) (0.5 * prop), pos.y - (int) (1.5 * prop), pos.y - 2 * prop, pos.y - (int) (1.5 * prop), pos.y - (int) (0.5 * prop)};


        Polygon p = new Polygon(xPoints, yPoints, xPoints.length);
        g.setColor(color);


        g.fillPolygon(p);
        g.setColor(Color.black);
        g.drawLine(pos.x, pos.y, pos.x + prop, pos.y - (int) (0.5 * prop));
        g.drawLine(pos.x + prop, pos.y - (int) (0.5 * prop), pos.x + prop, pos.y - (int) (1.5 * prop));
        g.drawLine(pos.x + prop, pos.y - (int) (1.5 * prop), pos.x, pos.y - 2 * prop);
        g.drawLine(pos.x, pos.y - 2 * prop, pos.x - prop, pos.y - (int) (1.5 * prop));
        g.drawLine(pos.x - prop, pos.y - (int) (1.5 * prop), pos.x - prop, pos.y - (int) (0.5 * prop));
        g.drawLine(pos.x - prop, pos.y - (int) (0.5 * prop), pos.x, pos.y);

        g.setColor(Color.lightGray.brighter());
        g.fillOval(pos.x - (int) (0.27 * prop), pos.y - (int) (1.3 * prop), (int) (0.6 * prop), (int) (0.6 * prop));

        g.setColor(Color.black);
        g.drawString(String.valueOf(num), pos.x - (int) (0.02 * prop), pos.y - (int) (0.95 * prop));

    }

}

