package aufgabe7.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Gui extends JFrame implements ActionListener, MouseListener{
private JFrame start;
private JPanel panel1;	
private JMenuBar menu;
private JMenu hp,hilfe;
private JMenuItem oeffnen,beenden,help;

	public Gui(String name) {
		
		
		start = new JFrame(name);
		start.addMouseListener(this);
		start.setLayout(new GridLayout(3,1));
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.setSize(400, 400);
		panel1 = new JPanel();
		menu();
		start.setJMenuBar(menu);
		start.setVisible(true);
	}
	
	
public void menu(){
		
		// Menüleiste erzeugen
		menu = new JMenuBar();
		menu.setSize(getWidth(), 10);
		menu.setAlignmentX(LEFT_ALIGNMENT);
		
		// Menüpunkte erzeugen
		
		hp = new JMenu("Hauptmenue");
		hilfe = new JMenu("Help");
		
		// Untermenüelemente erzeugen
        oeffnen = new JMenuItem("Neustart");
        oeffnen.addActionListener(this);
        beenden = new JMenuItem("Beenden");
        beenden.addActionListener(this);
        help = new JMenuItem("hilfe");
        help.addActionListener(this);
        
     // Menüelemente hinzufügen
        menu.add(hp);
        menu.add(hilfe);
        
     // Untermenüelemente hinzufügen
        hp.add(oeffnen);
        hp.add(beenden);
     
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gui gui= new Gui("Pong");
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseEntered");
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseExited");
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
