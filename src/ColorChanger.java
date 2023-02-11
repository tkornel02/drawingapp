import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChanger extends JColorChooser implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Draw.color = JColorChooser.showDialog(this,"COLORS", Color.black);

    }



}
