package aufgabe7.spiel;

import java.awt.Graphics;
import java.util.ArrayList;

public class Ball extends GameObject{

	// Geschwindigkeit des Balls
	private int movementSpeed;
	
	// Die aktuelle Richtung des Balles
	private int aktuelleRichtung;
	
	public static final int NORDEN = 1;
	public static final int WESTEN = 2;
	public static final int SUEDEN = -1;
	public static final int OSTEN = -2;

	/**
	 * Erzeugt einen neuen Ball an den X & Y angegebenen Koordinaten mit der
	 * Höhe height und Breite width,
	 * 
	 * @param x
	 *            X-Koorinate
	 * @param y
	 *            Y-Koordinate
	 * @param width
	 *            Breite
	 * @param height
	 *            Höhe
	 */
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		movementSpeed = 2;
		aktuelleRichtung = Ball.WESTEN;
	}

	/**
	 * Bewegt den Ball mit der in movementSpeed gespeicherten geschwindigkeit in
	 * eine Richtung
	 * @param gameObjects ArrayListe, die alle Objekte/Gegenstände und Hindernisse, 
	 * 			mit die der Ball 'kollidieren' kann enthält.
	 */
	public void move(ArrayList<GameObject> gameObjects) {
		
		//Prüfen, ob ein Hinderniss im weg ist und die flugbahn des balles
		//korrigiert werden muss
		for(GameObject go : gameObjects){
			//Kollisionen mit anderen bällen werden nicht beachtet
			if(go instanceof Ball)
				continue;
			
		}

		//Wenn keine Hinderniss im weg, weiterfliegen
		switch(aktuelleRichtung){
		case Ball.OSTEN:
			x += movementSpeed;
			break;
		case Ball.WESTEN:
			x -= movementSpeed;
			break;
		}
	}
	
	/**
	 * Prüft, ob ein tor gefallen ist und gibt den Spieler zurück
	 * der ein tor erzielt hat.
	 * @param spieler1 Spieler1
	 * @param spieler2 Spieler2
	 * @param torLinks Die X-Koordinate des Linken Tores
	 * @param torRechts Die X-Koordinate des Rechten Tores
	 * @return null, wenn kein tor gefallen ist, sonst den Spieler, der das tor erzielt hat.
	 */
	public Spieler tor(Spieler spieler1, Spieler spieler2, int torLinks, int torRechts){
		if(x <= torLinks)
			return spieler2;
		
		if(x >= torRechts)
			return spieler1;
		
		return null;
	}

	@Override
	/**
	 * Zeichnet den Ball auf das Spielfeld
	 */
	public void paintComponent(Graphics g) {
		g.fillOval(x, y, width, height);
	}



}
