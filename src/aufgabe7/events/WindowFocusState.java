package aufgabe7.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WindowFocusState implements MouseListener{
	
	private boolean isPause = false;


	public boolean isPause() {
		return isPause;
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		isPause = false;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		isPause = true;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

}
