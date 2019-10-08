import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeIcon {



    public static void main(String[] args) {


        JFrame frame = new JFrame();

        JButton redButton = new JButton("RED");
        JButton greenButton = new JButton("GREEN");
        JButton blueButton = new JButton("BLUE");


        MarIcon icon = new MarIcon(50);
        JLabel label = new JLabel(icon);
        frame.setLayout(new FlowLayout());
        frame.add(label);


        frame.add(redButton);
        frame.add(greenButton);
        frame.add(blueButton);

        redButton.addActionListener(event ->{
            icon.setColor(Color.RED);
            label.repaint();
        });

        greenButton.addActionListener(event->{
            icon.setColor(Color.GREEN);
            label.repaint();
        });

        blueButton.addActionListener(event->{
            icon.setColor(Color.BLUE);
            label.repaint();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}