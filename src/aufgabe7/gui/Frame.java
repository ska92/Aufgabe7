package aufgabe7.gui;

import javax.swing.*;

public class Frame {

	public Frame(){
		JFrame frame = new JFrame();
		//frame.add(new Board());
		frame.setTitle("Pong Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
}