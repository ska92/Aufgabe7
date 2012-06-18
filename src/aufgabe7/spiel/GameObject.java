package aufgabe7.spiel;

public abstract class GameObject implements IPaintable {

	// Speichert die X- und Y-Koordinaten sowie breite und höhe eines Objektes
	protected int x, y, width, height;

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}

}
