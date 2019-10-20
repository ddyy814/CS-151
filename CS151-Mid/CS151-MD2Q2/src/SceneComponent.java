import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

import java.util.*;

/**
 A component that shows a scene composed of shapes.
 */
public class SceneComponent extends JComponent implements Runnable
{
    private Thread t;
    final int DELAY = 100;

    public SceneComponent()
    {
        shapes = new ArrayList<>();

        addMouseListener(new MousePressedListener());
        addMouseMotionListener(new MouseDraggedListener());
    }

    private class MousePressedListener extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent event)
        {
            mousePoint = event.getPoint();
            for (SceneShape s: shapes)
            {
                if (s.contains(mousePoint))
                    s.setSelected(!s.isSelected());
            }
            repaint();
        }
    }

    private class MouseDraggedListener extends MouseMotionAdapter
    {
        @Override
        public void mouseDragged(MouseEvent event)
        {
            Point lastMousePoint = mousePoint;
            mousePoint = event.getPoint();
            for (SceneShape s : shapes)
            {
                if (s.isSelected())
                {
                    double dx = mousePoint.getX() - lastMousePoint.getX();
                    double dy = mousePoint.getY() - lastMousePoint.getY();
                    s.translate((int) dx, (int) dy);
                }
            }
            repaint();
        }
    }


    /**
     Adds an shape to the scene.
     @param s the shape to add
     */
    public void add(SceneShape s)
    {
        shapes.add(s);
        repaint();
    }

    /**
     Removes all selected shapes from the scene.
     */
    public void removeSelected()
    {
        for (int i = shapes.size() - 1; i >= 0; i--)
        {
            SceneShape s = shapes.get(i);
            if (s.isSelected()) shapes.remove(i);
        }
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        for (SceneShape s : shapes)
        {
            s.draw(g2);
            if (s.isSelected())
                s.drawSelection(g2);
        }
    }


        void move() {
            for (SceneShape s : shapes) {
                if (s.isSelected())
                    s.setMove(true);
            }
        }

        private void interrupt(int ms) throws InterruptedException {
            Thread.sleep(ms);
        }

        public void run() {
            Thread thread = Thread.currentThread();
            while(t == thread) {
                    repaint();
                    try {
                        interrupt(DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        public void start() {
            t = new Thread(this);
            t.start();
    }

    private ArrayList<SceneShape> shapes;
    private Point mousePoint;
}
