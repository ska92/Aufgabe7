package aufgabe7.events;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

public abstract class WindowAdapter implements WindowListener, WindowStateListener, WindowFocusListener {
	public void windowOpened( WindowEvent e ) { }
    public void windowClosing( WindowEvent e ) { }
    public void windowClosed( WindowEvent e ) { }
    public void windowIconified( WindowEvent e ) { }
    public void windowDeiconified( WindowEvent e ) { }
    public void windowActivated( WindowEvent e ) { }
    public void windowDeactivated( WindowEvent e ) { }
    public void windowStateChanged( WindowEvent e ) { }
    public void windowGainedFocus( WindowEvent e ) { }
    public void windowLostFocus( WindowEvent e ) { }
}
