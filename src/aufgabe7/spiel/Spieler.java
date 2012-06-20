package aufgabe7.spiel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Spieler extends GameObject implements KeyListener{
	
	//Speichert den Spielstand des Spielers
	private int spielstand = 0;
	
	//Der Name des Spielers
	private String name;
	
	//Bewegt sich der Spieler Hoch oder Runter
	private boolean moveUp = false, moveDown = false;
	
	//Die Keycodes des Spielers zum Hoch- und Runterbewegen.
	private int moveUpKey = 0, moveDownKey = 0;
	
	//Bewegungsgeschwindigkeit des Spielers
	private int movementSpeed = 2;
	
	//Spielerfarbe
	private Color spielerfarbe = Color.WHITE;
	
	/**
	 * Erzeugt einen neuen Spieler an der X & Y Koordinate mit der angegebenen Breite width und Höhe height
	 * @param name Name des Spielers
	 * @param x X-Koordinate
	 * @param y Y-Koordinate
	 * @param width Breite
	 * @param height Höhe
	 */
	public Spieler(String name ,int x, int y, int width, int height){
		super(x, y, width, height);
		this.name = name;
	}
	
	/**
	 * Setzt die Farbe des Spieler
	 * @param neueFarbe Farbe
	 */
	public void setFarbe(Color neueFarbe){
		this.spielerfarbe = neueFarbe;
	}
	
	/**
	 * Gibt zurück, ob sich der Spieler gerade bewegt
	 * @return true, wenn sich der Spieler aktuell bewegt, sonst false
	 */
	public boolean isMoving(){
		return moveUp || moveDown;
	}
	
	/**
	 * Gibt zurück, ob sich der Spieler nach oben bewegt
	 * @return true, wenn sich der Spieler nach oben bewegt, sonst false.
	 */
	public boolean isMovinUp(){
		return moveUp;
	}
	
	/**
	 * Gibt zurück, ob sich der Spieler nach unten bewegt
	 * @return true, wenn sich der Spieler nach unten bewegt, sonst false.
	 */
	public boolean isMovingDown(){
		return moveDown;
	}
	
	/**
	 * Bewegt den Spieler anhand der Tastatureingaben.
	 * @param minY - Die minimale Y-Koordinate die der Spieler erreichen darf.
	 * @param maxY - Die Maximale Y-Koorinate die der Spieler erreichen darf.
	 */
	public void move(int minY, int maxY){
		if(moveUp){
			if(y - movementSpeed >= minY)
				y -= movementSpeed;
		}
		
		if(moveDown){
			if( (y + movementSpeed + height) <= maxY)
				y += movementSpeed;
		}
		
	}
	
	/**
	 * Setzte die Tasten für die Auf- und Abwärtsbewegung des Spielers
	 * @param moveUpKey Taste für die Aufwärtsbewegung
	 * @param moveDownKey Taste für die Abwärtsbewegung
	 */
	public void setMovementKeys(int moveUpKey, int moveDownKey){
		this.moveUpKey = moveUpKey;
		this.moveDownKey = moveDownKey;
	}

	/**
	 * Setzt die breite des Spielers
	 * @param width Die neue Breite
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Setzte die höhe des Spielers
	 * @param height Die neue Höhe
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Setzte den Punktestand des Spielers
	 * @param spielstand Der neue Punktestand
	 */
	public void setSpielstand(int spielstand) {
		this.spielstand = spielstand;
	}

	/**
	 * Liefert den Punktestand des Spielers
	 * @return Der aktuelle Punktestand
	 */
	public int getSpielstand() {
		return spielstand;
	}

	/**
	 * Liefert den Namen des Spielers
	 * @return Den Namen des Spielers
	 */
	public String getName() {
		return name;
	}

	@Override
	/**
	 * Zeichnet die Komponente auf das Graphics Objekt
	 */
	public void paintComponent(Graphics g) {
		g.setColor(spielerfarbe);
		g.fillRect(x, y, width, height);
	}

	@Override
	/**
	 * Wird aufgerufen, wenn eine Taste gedrückt wird.
	 */
	public void keyPressed(KeyEvent arg0) {
		//Aufwärtsbewegung
		if(arg0.getKeyCode() == moveUpKey){
			moveUp = true;
		}
		
		//Abwärtsbewegung
		if(arg0.getKeyCode() == moveDownKey){
			moveDown = true;
		}
	}

	@Override
	/**
	 * Wird aufgerufen, wenn eine Taste losgelassen wird.
	 */
	public void keyReleased(KeyEvent arg0) {
		//Aufwärtsbewegung
		if(arg0.getKeyCode() == moveUpKey){
			moveUp = false;
		}
		
		//Abwärtsbewegung
		if(arg0.getKeyCode() == moveDownKey){
			moveDown = false;
		}
	}

	@Override
	/**
	 * Tut nichts.
	 */
	public void keyTyped(KeyEvent arg0) {}

	/**
	 * Setzt die Bewegungsgeschwindigkeit des Spielers
	 * @param movementSpeed Die neue Bewegungsgeschwindigkeit
	 */
	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	/**
	 * Liefert die Bewegungsgeschwindigkeit des Spielers
	 * @return Die aktuelle Bewegungsgeschwindigkeit
	 */
	public int getMovementSpeed() {
		return movementSpeed;
	}
	
	/**
	 * Setzt den Name des Spieler
	 * @param name Den Namen des Spielers
	 */
	public void setName(String name){
		if(name == null || name.equals("")){
			this.name = "Spieler";
		} else {
			this.name = name;
		}
	}
	
	/**
	 * Gibt die Farbe des Spielers zurück
	 * @return Farbe
	 */
	public Color getFarbe(){
		return spielerfarbe;
	}

}
