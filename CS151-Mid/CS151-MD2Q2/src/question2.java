import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 A program that allows users to edit a scene composed
 of items.
 */
public class question2
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final SceneComponent scene = new SceneComponent();

        JButton AnimateButton = new JButton("Animate");
        AnimateButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {

                scene.move();
            }
        });

        JButton carButton = new JButton("Car");
        carButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                scene.add(new CarShape(20, 20, 50));
            }
        });

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                scene.removeSelected();
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(AnimateButton);
        buttons.add(carButton);
        buttons.add(removeButton);

        frame.add(scene, BorderLayout.CENTER);
        frame.add(buttons, BorderLayout.NORTH);

        frame.setSize(300, 300);
        frame.setVisible(true);
        scene.start();
    }
}


