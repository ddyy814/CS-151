import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
public class BusIcon implements Icon{

    /**
     Constructs a car of a given width.
     @param width the width of the car
     */
    public BusIcon(int aWidth)
    {
        width = aWidth;
    }

    public int getIconWidth()
    {
        return width;
    }

    public int getIconHeight()
    {
        return width / 2;
    }

    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double body
                = new Rectangle2D.Double(x, y + width / 6,
                width - 1, width / 6);
        Ellipse2D.Double frontTire
                = new Ellipse2D.Double(x + width / 6, y + width / 3,
                width / 6, width / 6);
        Ellipse2D.Double rearTire
                = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3,
                width / 6, width / 6);

        Rectangle2D.Double roof
                = new Rectangle2D.Double(x, y ,
                width - 1, width / 6);

        g2.fill(frontTire);
        g2.fill(rearTire);
        g2.setColor(Color.red);
        g2.fill(body);
        g2.draw(roof);
    }

    public void zoomin()
    {
        width += 5;
    }

    public void zoomout()
    {
        width -= 5;
    }


    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getWidth()
    {
        return width;
    }
    private int width;
}
