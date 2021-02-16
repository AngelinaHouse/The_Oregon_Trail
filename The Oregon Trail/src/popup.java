import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.*;

public class popup {

	public static void main(String[] args) throws FileNotFoundException {
		JFrame f= new JFrame();
		JLabel l = new JLabel();
		l.setText("label text");
		f.setTitle("The Oregon Trail");
		f.setVisible(true);
		f.setSize(700,500);
		//f.setLocation(600,200);
		f.setLocationRelativeTo(null);
		Container c= f.getContentPane();
		c.setBackground(Color.black);
		f.setResizable(false);
		f.add(l);
		//JOptionPane.showMessageDialog(null, "Your message goes here!","Message", JOptionPane.ERROR_MESSAGE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}

}
		