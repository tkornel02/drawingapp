import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

/**
 * This class contains the entry point to the application. It initializes the
 * application in its show method.
 */
public class Main implements Runnable {
	/** Entry point of the setup of the GUI */
	public void run() {
		JFrame frame = new JFrame();

		JButton line = new JButton("Line");

		JButton color = new JButton("Color");
		JButton rect = new JButton("Rectangle");
		JButton circle = new JButton("Circle");
		JButton curve = new JButton("Curve");
		JButton eraser = new JButton("Eraser");
		JButton clear = new JButton("Clear Canvas");
		JButton save = new JButton("Save as PNG");
		JPanel buttonPanelNorth = new JPanel();
		BoxLayout box = new BoxLayout(buttonPanelNorth, BoxLayout.X_AXIS);
		buttonPanelNorth.setLayout(box);

		buttonPanelNorth.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		buttonPanelNorth.add(line);
		buttonPanelNorth.add(rect);
		buttonPanelNorth.add(circle);
		buttonPanelNorth.add(curve);
		buttonPanelNorth.add(eraser);
		buttonPanelNorth.add(clear);
		buttonPanelNorth.add(save);
		buttonPanelNorth.add(Box.createRigidArea(new Dimension(15, 0)));
		buttonPanelNorth.add(color);

		frame.add(buttonPanelNorth, BorderLayout.NORTH);

		MyCanvas mc = new MyCanvas();
		JScrollPane jsp = new JScrollPane(mc);
		frame.add(jsp);

		MouseListenerDelegator mld = new MouseListenerDelegator(mc);
		mld.setDelegate(new RectDraw());

		ButtonListener bl = new ButtonListener(mld);

		rect.addActionListener(bl);
		circle.addActionListener(bl);
		line.addActionListener(bl);
		curve.addActionListener(bl);
		eraser.addActionListener(bl);
		clear.addActionListener(e->mc.clearCanvas());

		class SaveButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				String userInput = JOptionPane.showInputDialog(null, "Enter name of file (.jpg not needed):");

				IOHandler ioh = new IOHandler(mc,userInput);
				ioh.saveAsPNG();
			}
		};

		save.addActionListener(new SaveButtonListener());

		ColorChanger cch = new ColorChanger();
		color.addActionListener(cch);


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		Main m = new Main();
		javax.swing.SwingUtilities.invokeLater(m);
	}

}
