package aufgabe7.spielfeld;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import aufgabe7.events.WindowFocusState;
import aufgabe7.gui.Gui;
import aufgabe7.spiel.Ball;
import aufgabe7.spiel.GameObject;
import aufgabe7.spiel.Hindernis;
import aufgabe7.spiel.Rahmen;
import aufgabe7.spiel.Spieler;

public class Spielfeld extends JFrame {

	private static final long serialVersionUID = 1L;
	
	class SpielfeldPanel extends JPanel {

		private static final long serialVersionUID = 1L;
		
		private Font defaultFont = new Font(Font.SANS_SERIF, Font.BOLD, 16);

		/**
		 * Erzeugt ein neues SpielfeldPanel und setzt die Vordergrundfarbe auf Weiß
		 */
		public SpielfeldPanel() {
			setForeground(Color.WHITE);
		}

		@Override
		/**
		 * Wird aufgerufen, wenn das Spielfeld neu gezeichnet werden soll
		 */
		protected void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			
			//Ausgabe wenn das Spiel zuende ist.
			if(spielende){
				g.setFont(new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 30));
				g.drawString("Spielende", 200, 200);
			}
			
			//Font für die Textausgabe setzen
			g.setFont(defaultFont);	
			
			
			//Ball
			ball.paintComponent(g);
			
			//Zeichnet alle Komponenten auf das Spielfeld
			for(GameObject go : gameObjects){
				go.paintComponent(g);
			}
			
			
			g.setColor(Color.WHITE);
			// Spielstand
			g.drawString(spieler1.getName() +":" + spieler1.getSpielstand(), 40, 340);
			g.drawString(spieler2.getName() +":" + spieler2.getSpielstand(), 380, 340);
			
			//Ausgaben, wenn das Spiel pausiert ist
			if(windowState.isPause()){
				g.drawString("PAUSE", 210, 350);
			}
			
		}

	}
	
	private ArrayList<GameObject> gameObjects;
	
	private WindowFocusState windowState;

	private Spieler spieler1, spieler2;
	private Ball ball;
	
	private String level = "Leicht";
	
	private boolean spielende = false;

	public Spielfeld(String s) {
		super(s);
		
		gameObjects = new ArrayList<GameObject>();
		
		//Rahmen hinzufügen
		gameObjects.add(new Rahmen(0, 0, 500, 10));
		gameObjects.add(new Rahmen(0, 300, 500, 10));
		
		//Spieler & Ball initialisieren
		spieler1 = new Spieler("Spieler1", 5, 140, 10, 40);
		spieler1.setMovementKeys(KeyEvent.VK_W, KeyEvent.VK_S);
		
		spieler2 = new Spieler("Spieler2", 480, 140, 10, 40);
		spieler2.setMovementKeys(KeyEvent.VK_UP, KeyEvent.VK_DOWN);
		
		ball = new Ball(250, 150, 10, 10);
		
		gameObjects.add(spieler1);
		gameObjects.add(spieler2);
		
		
		//Hindernis setzen
		//gameObjects.add(new Hindernis(245, 10, 15, 120));
		
		//Key- & Mouselistener registrieren
		addKeyListener(spieler1);
		addKeyListener(spieler2);
		
		windowState = new WindowFocusState();
		addMouseListener(windowState);

		setBackground(Color.BLACK);

		SpielfeldPanel sp = new SpielfeldPanel();
		setContentPane(sp);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 400);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String args[]) {
		Gui gui = new Gui("Pong Menü");
		
		while(!gui.startSpiel){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
		}
		
		gui.setVisible(false);
		
		Spielfeld sp = new Spielfeld("Pong");
		
		sp.getSpieler1().setName(gui.getSpieler1Name());
		sp.getSpieler2().setName(gui.getSpieler2Name());
		
		sp.getSpieler1().setFarbe(gui.getSpieler1Color());
		sp.getSpieler2().setFarbe(gui.getSpieler2Color());
		
		sp.setLevel(gui.getLevel());
		
		
		sp.startGame();
	}
	
	/*
	 * Setzt Spieler und Ball auf ihre Startwerte zurück.
	 */
	private void resetGame(){
		ball.setX(250);
		ball.setY(150);
		spieler1.setY(140);
		spieler2.setY(140);
	}

	public void startGame() {
		
		while (!spielende) {
			//Spielfeld neuzeichnen
			repaint();
			
			//Abfragen, ob das Spiel pausiert ist.
			if (windowState.isPause())
				continue;
			
			//Spieler bewegen
			spieler1.move(10, 300);
			spieler2.move(10, 300);
				
			//Ball bewegen
			ball.move(gameObjects);
			
			//Prüfen, ob ein Tor gefallen ist.
			Spieler spielerTor = ball.tor(spieler1, spieler2, 0, 500);
			if(spielerTor != null){
				spielerTor.setSpielstand(spielerTor.getSpielstand() + 1);
				resetGame();
			}
			
			//Auf Sieg prüfen
			if(spieler1.getSpielstand() >= 10 || spieler2.getSpielstand() >= 10){
				spielende = true;
				continue;
			}
			
			//Thread pausieren, um vernünftiges Spieltempo zu realisieren
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}

	}
	
	public Spieler getSpieler1(){
		return spieler1;
	}
	
	public Spieler getSpieler2(){
		return spieler2;
	}
	
	public void setLevel(String level){
		this.level = level;
	}

}
