package aufgabe7.koerper;

import javax.swing.ImageIcon;

public class Hindernis extends Koerper {

	public Hindernis(int tempx, int tempy)
	{
		super(tempx, tempy);
		bildladen();
	// grosse
	}

	
	public void bildladen()
	{
		try
		{
		//richtiger Pfad????
		ImageIcon icon = new ImageIcon( "pic/Hindernis_klein.gif" );
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
