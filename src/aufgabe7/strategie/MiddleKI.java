package aufgabe7.strategie;

import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import aufgabe7.spiel.Ball;
import aufgabe7.spiel.GameObject;
import aufgabe7.spiel.Spieler;
import aufgabe7.spiel.Rahmen;

public class MiddleKI extends Spieler {
	
	//Speichert das Ballobject
			Ball ball,simball;
	//Speichert den Rahmen
			Rahmen rahmen;
	//Speichert das Gameobject
			 ArrayList<GameObject> gameObjects;
	//Speichert den Movemmentspeed
			 int movementSpeed = 20;
	//Logger für die Koordinaten
			 private static Logger klog =  Logger.getLogger("Koordinaten");
	//Handler für den Koordinatenlogger
			 private static ConsoleHandler koordinatenhandler ;
			
	/*
	 * Konstruktor für MiddleKI
	 * 
	 */
	public MiddleKI(String name, int x, int y, int width, int height, Ball newball, ArrayList<GameObject> newgameObjects ) {
		super(name, x, y, width, height);
		ball = newball;
		gameObjects = newgameObjects;
		koordinatenhandler = new ConsoleHandler();
		klog.addHandler(koordinatenhandler);
		klog.setUseParentHandlers(false);
		koordinatenhandler.setLevel(Level.INFO);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see aufgabe7.spiel.Spieler#move(int, int)
	 */
	
	public void move(int minY, int maxY){
		simulate();

		if(simball.getY()+ 5 < this.getY()){
			if(this.y - movementSpeed >= minY){
				this.y =this.y - movementSpeed;
				}
			}
		
		else if(simball.getY()+ 5 > this.getY()){
			if(this.y + movementSpeed <= maxY){
				this.y = this.y + movementSpeed;
			}
		}
		
	}
	
	/*
	 * Simuliert mehrere Spielzüge
	 */
	
	public void simulate(){
		simball = new Ball(ball.getX(), ball.getY(), 10, 10);
		simball.move(gameObjects);
		klog.log(Level.INFO,simball.getX()+"-"+simball.getY() );
		simball.move(gameObjects);
		klog.log(Level.INFO,simball.getX()+"-"+simball.getY() );
		simball.move(gameObjects);
		klog.log(Level.INFO,simball.getX()+"-"+simball.getY() );
		simball.move(gameObjects);
		klog.log(Level.INFO,simball.getX()+"-"+simball.getY() );
		
		
		
	}
	

}
