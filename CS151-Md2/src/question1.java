import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class question1 {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(700,200));

        BusIcon bus = new BusIcon(200);
        CarIcon car = new CarIcon(100);

        JButton Car = new JButton("Car");

        Car.addActionListener(event ->
        {
            bus.setWidth(0);
            car.setWidth(100);
            frame.repaint();
        });

        JButton Bus = new JButton("Bus");
        Bus.addActionListener(event ->
        {
            car.setWidth(0);
            bus.setWidth(100);
            frame.repaint();
        });

        JButton in = new JButton("Zoom in");
        in.addActionListener(event ->
        {
            if(car.getWidth() != 0)
            {
                car.zoomin();
                frame.repaint();
            }
            else
            {
                bus.zoomin();
                frame.repaint();
            }
        });


        JButton out = new JButton("Zoom out");
        out.addActionListener(event ->
        {
            if(car.getWidth() != 0)
            {
                car.zoomout();
                frame.repaint();
            }
            else
            {
                bus.zoomout();
                frame.repaint();
            }
        });

        JPanel zoom = new JPanel();
        zoom.add(in);
        zoom.add(out);
        frame.add(zoom, BorderLayout.NORTH);


        final JLabel caricon = new JLabel(car);
        final JLabel busicon = new JLabel(bus);
        JPanel icon = new JPanel();
        icon.add(caricon);
        icon.add(busicon);
        frame.add(icon, BorderLayout.CENTER);

        JPanel type = new JPanel();
        type.add(Car);
        type.add(Bus);
        frame.add(type, BorderLayout.WEST);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
