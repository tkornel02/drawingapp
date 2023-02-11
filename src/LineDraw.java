import java.awt.*;

public class LineDraw extends Draw {

    @Override
    protected void makeDraw(Graphics g) {
        g.drawLine(startx,starty,endx,endy);
    }
}
