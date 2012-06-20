package aufgabe7.strategie;

import aufgabe7.spiel.Ball;

public class EasyKI extends aufgabe7.spiel.Spieler {
	
	//Speichert das Ballobject
		Ball ball;

	public EasyKI(String name, int x, int y, int width, int height,Ball newball) {
		super(name, x, y, width, height);
		ball = newball;
	}
	
	/*
	 * (non-Javadoc)
	 * @see aufgabe7.spiel.Spieler#move(int, int)
	 */
	public void move(int minY, int maxY){
		
		if(ball.getY() < this.getY()){
			this.y =this.y - 1;
		}
		
		else if(ball.getY()> this.getY()){
			this.y = this.y +1;
		}
		
		
	}
	

}
