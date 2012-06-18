package aufgabe7.spiel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;

public class Ball extends GameObject{
	
	// Die Geschwindigkeit des Balles in X und Y-Richtung
	private int movementX = 4, movementY = 0;
	
	//Bild
	private Image img;
	
	private static final int HORIZONTAL = 1, VERTIKAL = 2;
	
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
		
		File ballFile = new File("Ball1.png");
		if(ballFile.exists()){
			img = Toolkit.getDefaultToolkit().getImage(ballFile.getAbsolutePath());
		}
	}

	/**
	 * Bewegt den Ball mit der in movementSpeed gespeicherten geschwindigkeit in
	 * eine Richtung
	 * @param gameObjects ArrayListe, die alle Objekte/Gegenstände und Hindernisse, 
	 * 			mit die der Ball 'kollidieren' kann enthält.
	 */
	public void move(ArrayList<GameObject> gameObjects) {
		//Die X- und Y-Koordinaten des nächsten Punktes
		int nextX = x+movementX + width/2,
			nextY = y+movementY + height/2;
		
		//Prüfen, ob ein Hinderniss im weg ist und die flugbahn des balles
		//korrigiert werden muss
		for(GameObject go : gameObjects){
			//Kollisionen mit anderen bällen werden nicht beachtet
			if(go instanceof Ball)
				continue;
			
			//Spieler können die Flugbahn des balles verändern
			if(go instanceof Spieler){
				if( trifftObjekt( nextX, nextY, go) ){
					Spieler s = (Spieler)go;
					if( s.isMoving() ){
						//Spieler bewegt sicht
						movementY += 1;
					}
					
					
					movementX *= -1;
					
					
					return;
				}
			}
			
			//Hindernisse wie Rahmen
			if( trifftObjekt( nextX, nextY, go )){
				//Flugrichtung anpassen (invertieren?)
				switch(getEinschlagRichtung(nextX, nextY, go)){
				case Ball.HORIZONTAL:
					movementX *= -1;
					break;
				case Ball.VERTIKAL:
					movementY *= -1;
					break;
				case -1:
					
				}
				
				return;
			}
			
			
		}

		//Wenn keine Hinderniss im weg, weiterfliegen
		x += movementX;
		y += movementY;
	}
	
	
	public int getEinschlagRichtung(int x1, int y1, GameObject go){
		
		//Rechte Seite
		int rechteSeite = go.getX() + go.getWidth();
		
		if( x1 >= rechteSeite - 5 && x1 <= rechteSeite + 5){
			if( y1 >= go.getY() -5 && y1  <= go.getY() + go.getHeight() -5){
				return Ball.HORIZONTAL;
			}
		}
		
		
		//Linke Seite
		int linkeSeite = go.getX();
		
		if( x1 >= linkeSeite - 5 && x1 <= linkeSeite + 5){
			if( y1 >= go.getY() -5 && y1  <= go.getY() + go.getHeight() -5){
				return Ball.HORIZONTAL;
			}
		}
		
		//Obere Seite
		int obereSeite = go.getY();
		
		if( x1 >= go.getX() && x1 <= go.getX() + go.getWidth()){
			if( y1 >= obereSeite - 5 && y1 <= obereSeite + 5){
				return Ball.VERTIKAL;
			}
		}
		
		//Untere Seite
		int untereSeite = go.getY() + go.getHeight();
		
		if( x1 >= go.getX() && x1 <= go.getX() + go.getWidth()){
			if( y1 >= untereSeite - 5 && y1 <= untereSeite + 5){
				return Ball.VERTIKAL;
			}
		}
		
		return -1;
	}
	
	//Prüft, ob die nächste bewegung des Balles mit einem objekt kollidiert.
	private boolean trifftObjekt(int x1, int y1, GameObject go){
		
		if( (x1 >= go.getX()) && (x1 <= go.getX() + go.getWidth()) ){
			if( (y1 >= go.getY()) && (y1 <= go.getY() + go.getHeight()) ){
				return true;
			}
		}
		return false;
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
		if(x <= torLinks){
			resetMovement(-5);
			return spieler2;
		}
			
		if(x >= torRechts){
			resetMovement(5);
			return spieler1;
		}
			
		return null;
	}

	@Override
	/**
	 * Zeichnet den Ball auf das Spielfeld
	 */
	public void paintComponent(Graphics g) {
		
		if(img != null){
			g.drawImage(img, x, y, width, height, null);
		} else {
			g.fillOval(x, y, width, height);
		}
	}
	
	public void resetMovement(int richtung){
		movementX = richtung;
		movementY = 0;
	}



}
