package aufgabe7.spielfeld;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import aufgabe7.events.WindowFocusState;
import aufgabe7.spiel.Ball;
import aufgabe7.spiel.GameObject;
import aufgabe7.spiel.Hindernis;
import aufgabe7.spiel.Level;
import aufgabe7.spiel.Rahmen;
import aufgabe7.spiel.Spieler;

public class Spielfeld extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	
	class SpielfeldPanel extends JPanel {

		private static final long serialVersionUID = 1L;
		
		private Font defaultFont = new Font(Font.SANS_SERIF, Font.BOLD, 16);

		/**
		 * Erzeugt ein neues SpielfeldPanel und setzt die Vordergrundfarbe auf Wei�
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
			
			//Font f�r die Textausgabe setzen
			g.setFont(defaultFont);	
			
			//Ball
			ball.paintComponent(g);
			
			//Zeichnet alle Komponenten auf das Spielfeld
			for(GameObject go : gameObjects){
				go.paintComponent(g);
				g.setColor(Color.WHITE);
			}
			
			
			//Mittelfeld Linie
			g.drawLine(250, 0, 250, 300);
			
			
			// Spielstand
			g.drawString(spieler1.getName() +":" + spieler1.getSpielstand(), 40, 340);
			g.drawString(spieler2.getName() +":" + spieler2.getSpielstand(), 380, 340);
			
			//Ausgaben, wenn das Spiel pausiert ist
			if(windowState.isPause()){
				g.drawString("PAUSE", 222, 330);
			}
			
			//Level ausgeben
			g.setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 15));
			g.drawString(level.getName(), 230, 370);
			
		}

	}
	
	//Liste, die alle Objekte auf dem Spielfeld enth�lt
	private ArrayList<GameObject> gameObjects;
	
	//Gibt an, ob das Spiel pausiert ist
	private WindowFocusState windowState;

	//Spieler 1 (links) und 2 (rechts)
	private Spieler spieler1, spieler2;
	
	//Der Ball auf dem Spielfeld
	private Ball ball;
	
	//Speichert das Aktuelle Level des Spieles
	private Level level = Level.Leicht;
	
	//Gibt an, ob das Spiel zuende ist
	private boolean spielende = false;

	public Spielfeld(String s) {
		super(s);
		
		gameObjects = new ArrayList<GameObject>();
		
		//Rahmen hinzuf�gen
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
	
	/*
	 * Setzt Spieler und Ball auf ihre Startwerte zur�ck.
	 */
	private void resetGame(){
		ball.setX(250);
		ball.setY(150);
		spieler1.setY(140);
		spieler2.setY(140);
	}

	public void startGame() {
		
		//Hindernis setzen
		if(level == Level.MITTEL){
			gameObjects.add(new Hindernis(242, 10, 15, 120));
		}
		
		
		while (!spielende) {
			//Spielfeld neuzeichnen
			repaint();
			
			//Thread pausieren, um vern�nftiges Spieltempo zu realisieren
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { return; }
			
			//Abfragen, ob das Spiel pausiert ist.
			if (windowState.isPause())
				continue;
			
			//Spieler bewegen
			spieler1.move(10, 300);
			spieler2.move(10, 300);
				
			//Ball bewegen
			ball.move(gameObjects);
			
			//Pr�fen, ob ein Tor gefallen ist.
			Spieler spielerTor = ball.tor(spieler1, spieler2, 0, 500);
			if(spielerTor != null){
				spielerTor.setSpielstand(spielerTor.getSpielstand() + 1);
				resetGame();
			}
			
			//Auf Sieg pr�fen
			if(spieler1.getSpielstand() >= 10 || spieler2.getSpielstand() >= 10){
				spielende = true;
				repaint();
				continue;
			}
		}

	}
	
	public Spieler getSpieler1(){
		return spieler1;
	}
	
	public Spieler getSpieler2(){
		return spieler2;
	}
	
	public void setLevel(Level level){
		this.level = level;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		startGame();
	}

}
