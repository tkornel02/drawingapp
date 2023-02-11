import java.awt.*;
import java.awt.event.MouseEvent;

public class CurveDraw extends Draw{
    @Override
    protected void makeDraw(Graphics g) {
        g.drawLine(endx,endy,endx,endy);
    }
    @Override
    public void mouseDragged(MouseEvent arg0){
        realDraw(arg0, canvas.getBottom());
    }
}
