import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class IOHandler {
    MyCanvas mc;
    String savename;

    IOHandler(MyCanvas myc){
        this.mc = myc;
    }
    IOHandler(MyCanvas myc, String s){
        this.mc = myc;
        savename = s;
    }

    public void saveAsPNG(){
        try {
            if (ImageIO.write(mc.getTopImg(), "png", new File("./" + savename + ".png")))
            {
                System.out.println("-- saved");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
