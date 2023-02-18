import java.awt.*;
import java.awt.event.MouseEvent;

public class CurveDraw extends Draw {
    @Override
    protected void makeDraw(Graphics g) {
        g.drawLine(startx,starty,endx,endy);

    }
    @Override
    public void mouseDragged(MouseEvent arg0){
        realDraw(arg0, canvas.getBottom());
        startx = endx;
        starty = endy;
        endx = arg0.getX();
        endy = arg0.getY();


    }

}
