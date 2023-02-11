import java.awt.*;

public class CircleDraw extends Draw {
    @Override
    protected void makeDraw(Graphics g) {
        Point start = new Point(startx,starty);
        Point end = new Point(endx,endy);
        int rad = (int) start.distance(end);
        Point middle = new Point(startx-rad,starty-rad);
        g.drawOval(middle.x,middle.y,rad*2,rad*2);
    }
}
