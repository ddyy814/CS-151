import java.awt.*;
import java.awt.geom.*;

/**
 A shape that manages its selection state.
 */
public abstract class SelectableShape implements SceneShape
{
    public void setSelected(boolean b)
    {
        selected = b;
        if(!b)
            setMove(false);
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void drawSelection(Graphics2D g2)
    {
        translate(1, 1);
        draw(g2);
        translate(1, 1);
        draw(g2);
        translate(-2, -2);
    }

    public void setMove(boolean move)
    {
        this.move = move;
    }

    public boolean getMove()
    {
        return move;
    }

    private boolean selected;
    private boolean move;
}
