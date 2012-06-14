package aufgabe7.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Gui extends JFrame implements ActionListener{
private JFrame f;
	
	public Gui(String name) {
		
		
		f = new JFrame(name);
		f.setLayout(new GridLayout(3,1));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 600);
		f.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gui gui= new Gui("Hallo");
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
