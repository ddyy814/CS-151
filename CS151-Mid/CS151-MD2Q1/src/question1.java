import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class question1{

    private JFrame frame = new JFrame();
    private JButton zoomInButton = new JButton("Zoom In");
    private JButton zoomOutButton = new JButton("Zoom Out");
    private JButton carButton = new JButton("Car");
    private JButton busButton = new JButton("Bus");
    private static  Myicon myicon = new Myicon(200);


    private static JLabel mylabel =  new JLabel(myicon);
    private static JLabel label1 = mylabel;

    public void init(){
        // location for buttons
        carButton.setBounds(20,50,100,50);
        busButton.setBounds(20,130,100,50);
        zoomInButton.setBounds(250,50,120,30);
        zoomOutButton.setBounds(400,50,120,30);
        frame.add(carButton);
        frame.add(busButton);
        frame.add(zoomInButton);
        frame.add(zoomOutButton);

        frame.add(label1);//add car and state =1


        ActionListener listenercar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myicon.state = 1;//change state and repaint
                label1.repaint();
            }
        };
        carButton.addActionListener(listenercar);

        ActionListener listenerbus = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myicon.state = 0;
                label1.repaint();
            }
        };
        busButton.addActionListener(listenerbus);


        //zoom in
        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myicon.setIconWidth(myicon.getIconWidth() + 10);
                label1.repaint();
            }
        };
        zoomInButton.addActionListener(listener1);


        // zoom out
        zoomOutButton.addActionListener(event->{// another way to bind listener
            myicon.setIconWidth(myicon.getIconWidth() - 10);
            label1.repaint();
        });



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,500));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        question1 cit = new question1();
        cit.init();
    }
}








