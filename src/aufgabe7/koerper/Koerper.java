package aufgabe7.koerper;

import java.awt.event.KeyEvent;

public abstract class Koerper {

	protected int x,y;
	
	public Koerper(int tempx,int tempy)
	{
		this.x=tempx;
		this.y=tempy;
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT)
			this.y = -1;

		if (key == KeyEvent.VK_RIGHT)
			this.y = 1;
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT)
			this.y = 0;

		if (key == KeyEvent.VK_RIGHT)
			this.y = 0;
	}

}
