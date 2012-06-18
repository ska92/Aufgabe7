package aufgabe7.spiel;

import java.awt.Graphics;
import java.util.ArrayList;

public class Ball extends GameObject{
	
	// Die Geschwindigkeit des Balles in X und Y-Richtung
	private int movementX = 3, movementY = 0;
	
	//Richtungskonstanten, die angeben in welcher Richtung das n�chste Hindernis liegt
	private static final int NORDEN = 1, WESTEN = 2, SUEDEN = 3, OSTEN = 4;
	
	/**
	 * Erzeugt einen neuen Ball an den X & Y angegebenen Koordinaten mit der
	 * H�he height und Breite width,
	 * 
	 * @param x
	 *            X-Koorinate
	 * @param y
	 *            Y-Koordinate
	 * @param width
	 *            Breite
	 * @param height
	 *            H�he
	 */
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * Bewegt den Ball mit der in movementSpeed gespeicherten geschwindigkeit in
	 * eine Richtung
	 * @param gameObjects ArrayListe, die alle Objekte/Gegenst�nde und Hindernisse, 
	 * 			mit die der Ball 'kollidieren' kann enth�lt.
	 */
	public void move(ArrayList<GameObject> gameObjects) {
		//Die X- und Y-Koordinaten des n�chsten Punktes
		int nextX = x+movementX + width/2,
			nextY = y+movementY + height/2;
		
		//Pr�fen, ob ein Hinderniss im weg ist und die flugbahn des balles
		//korrigiert werden muss
		for(GameObject go : gameObjects){
			//Kollisionen mit anderen b�llen werden nicht beachtet
			if(go instanceof Ball)
				continue;
			
			//Spieler k�nnen die Flugbahn des balles ver�ndern
			if(go instanceof Spieler){
				
			}
			
			//Hindernisse wie Rahmen
			if( trifftObjekt( nextX, nextY, go )){
				//Flugrichtung anpassen (invertieren?)
				
				
				return;
			}
			
			
		}

		//Wenn keine Hinderniss im weg, weiterfliegen
		x += movementX;
		y += movementY;
	}
	
	
	
	//Pr�ft, ob die n�chste bewegung des Balles mit einem objekt kollidiert.
	private boolean trifftObjekt(int x1, int y1, GameObject go){
		
		if( (x1 >= go.getX()) && (x1 <= go.getX() + go.getWidth()) ){
			if( (y1 >= go.getY()) && (y1 <= go.getY() + go.getHeight()) ){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Pr�ft, ob ein tor gefallen ist und gibt den Spieler zur�ck
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
