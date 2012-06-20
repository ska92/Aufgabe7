package aufgabe7.strategie;

import java.util.ArrayList;

import aufgabe7.spiel.Ball;
import aufgabe7.spiel.GameObject;
import aufgabe7.spiel.Spieler;
import aufgabe7.spiel.Rahmen;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;



public class HardKI extends Spieler {
	
	//Speichert das Ballobject
			Ball ball,simball;
	//Speichert den Rahmen
			Rahmen rahmen;
	//Speichert das Gameobject
			 ArrayList<GameObject> gameObjects;
	//Speichert den Movemmentspeed
			 int movementSpeed = 20;
	//Speichert den Gegenspieler
			 Spieler spieler;
	//Logger für die Koordinaten		 
	private static Logger klog =  Logger.getLogger("Koordinaten");
	//Logger für die Movements
	private static Logger mlog = Logger.getLogger("Movement");
	//Handler für den Koordinatenlogger
	private static ConsoleHandler koordinatenhandler ;
	//Handler für den Movementlogger
	private static ConsoleHandler movementhandler ;
			
	/*
	 * Konstruktor für MiddleKI
	 * 
	 */
	public HardKI(String name, int x, int y, int width, int height, Ball newball, ArrayList<GameObject> newgameObjects,Spieler newspieler ) {
		super(name, x, y, width, height);
		ball = newball;
		gameObjects = newgameObjects;
		spieler = newspieler;
		koordinatenhandler = new ConsoleHandler();
		movementhandler = new ConsoleHandler();
		klog.addHandler(koordinatenhandler);
		mlog.addHandler(movementhandler);
		klog.setUseParentHandlers(false);
		mlog.setUseParentHandlers(false);
		koordinatenhandler.setLevel(Level.OFF);
		movementhandler.setLevel(Level.INFO);
		
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see aufgabe7.spiel.Spieler#move(int, int)
	 */
	
	public void move(int minY, int maxY){
		simulate();

		if(simball.getY()+ 5 < this.getY()){
			
				
				this.y =this.y - movementSpeed+5;
				andrehen();
				
			}
		
		else if(simball.getY()+ 5 > this.getY()){
			if(this.y + movementSpeed <= maxY){
				this.y = this.y + movementSpeed;
				andrehen();
				
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
	/*
	 * Dreht den Ball je nach Gegenspielerposition an
	 */
	
	public void andrehen(){
		if(ball.trifftObjekt(ball.getX(), ball.getY(), this)){
			if(spieler.getY()> 100){
			ball.changeYMovement(-2);
			mlog.log(Level.INFO,"-1");
			}
			else{
				ball.changeYMovement(2);
				mlog.log(Level.INFO,"1");
			}
		}
	}
	
	
	
	

}
