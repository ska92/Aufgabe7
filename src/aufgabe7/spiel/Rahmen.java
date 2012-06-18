package aufgabe7.spiel;

import java.awt.Graphics;

public class Rahmen extends GameObject{

	public Rahmen(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(x, y, width, height);
	}

}
