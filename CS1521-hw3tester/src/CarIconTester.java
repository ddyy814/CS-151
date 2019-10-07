import javax.swing.*;
import java.awt.*;

public class CarIconTester {
    public static void main(String[] args){
        JFrame frame = new JFrame();


        JButton zoomInButton = new JButton("Zoom In");
        JButton zoomOutButton = new JButton("Zoom Out");

        frame.setLayout(new FlowLayout());
        frame.add(zoomInButton);
        frame.add(zoomOutButton);


        CarIcon icon = new CarIcon(100);
        JLabel label = new JLabel(icon);
        frame.setLayout(new FlowLayout());
        frame.add(label);

        //zoom in
        zoomInButton.addActionListener(event->{
                icon.setIconWidth(icon.getIconWidth() + 10);
                label.repaint();
        });
        // zoom out
        zoomOutButton.addActionListener(event->{
                icon.setIconWidth(icon.getIconWidth() - 10);
                label.repaint();
        });


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
