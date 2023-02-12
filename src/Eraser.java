import java.awt.*;
import java.awt.event.MouseEvent;

public class Eraser extends Draw{
    @Override
    protected void makeDraw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(endx, endy, 15,15);
    }
    @Override
    public void mouseDragged(MouseEvent arg0){
        realDraw(arg0, canvas.getBottom());
    }
}
