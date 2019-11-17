import java.awt.*;
import javax.swing.*;

/**
 This program implements an animation that moves
 a car shape.
 */
public class AnimationTester
{

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());

        for(int i = 0; i < CARS; i++){
            CarShape shape = new CarShape(0,0,CAR_WIDTH);
            ShapeIcon icon = new ShapeIcon(shape,ICON_WIDTH,ICON_HEIGHT);
            JLabel label = new JLabel(icon);
            frame.add(label);

            CarRunnable carR = new CarRunnable((i + 1) * DELAY,shape,label);
            Thread t = new Thread(carR);
            t.start();
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(ICON_WIDTH,CARS * ICON_HEIGHT);
        frame.setVisible(true);
    }

    private static final int ICON_WIDTH = 500;
    private static final int ICON_HEIGHT = 100;
    private static final int CAR_WIDTH = 100;
    private static final int CARS = 3;
    private static final int DELAY = 50;

}
