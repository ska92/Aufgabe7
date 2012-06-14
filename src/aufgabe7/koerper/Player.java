package aufgabe7.koerper;

public class Player extends Koerper
{

	private int punkte;
	private String name;
	
	public Player(String tempname,int tempx,int tempy)
	{
		super(tempx,tempy);
		this.name=tempname;
		this.punkte=0;
		
	}
	
	
	public void setpunkte()
	{
		this.punkte=this.punkte+1;
	}
	
	public int getpunkte()
	{
		return this.punkte;
	}
}
