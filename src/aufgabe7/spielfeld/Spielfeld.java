package aufgabe7.spielfeld;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Spielfeld extends JFrame implements KeyListener, MouseListener{

	class SpielfeldPanel extends JPanel{

		private static final long serialVersionUID = 1L;
		
		public SpielfeldPanel(){
			setForeground(Color.WHITE);
		}
		
		@Override
		//Zeichnet das Spielfeld 
		protected void paintComponent(Graphics g) {
			
			//Oberer und Unterer Rahmen
			g.fillRect(0, 0, 500, 10);
			g.fillRect(0, 300, 500, 10);
			
			
			//Spieler1
			g.fillRect( 5, 150, 10, 40);
			
			//Spieler2
			g.fillRect(480, position, 10, 40);
			
			
			//Spielstand
			g.drawString("Spieler1: 0", 40, 340);
			g.drawString("Spieler2: 0", 380, 340);
			
			
		}
		
	}
	
	private static final long serialVersionUID = 1L;
	
	private boolean isPause = false;
	
	private int position = 150;
	
	public Spielfeld(String s){
		super(s);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(500, 400);
		
		addKeyListener(this);
		addMouseListener(this);
		
		setBackground(Color.BLACK);
		
		SpielfeldPanel sp = new SpielfeldPanel();
		setContentPane(sp);
		
		setResizable(false);
		setVisible(true);
	}


	
	
	public static void main(String args[]){
		new Spielfeld("Pong");
	}


	@Override
	/**
	 * Wird aufgerufen, solange wie eine Taste gedrückt wird.
	 */
	public void keyPressed(KeyEvent arg0) {
		if(isPause)
			return;
		
		//Pfeil-Hoch taste
		if(arg0.getKeyCode() == KeyEvent.VK_UP){
			if(position - 10 >= 10)
				position -= 10;
		}
		
		//Pfeil-Runter taste
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN){
			if( (position + 10 + 40) <=300)
				position += 10;
		}
		
		repaint();
	}


	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}



	@Override 
	public void mouseEntered(MouseEvent arg0) {
		// Spiel fortsetzen
		isPause = false;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// Spiel pausieren
		isPause = true;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {}

}
