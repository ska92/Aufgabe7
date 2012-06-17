package aufgabe7.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame implements ActionListener, MouseListener{
private JFrame start;
private JPanel panel1;	
private JMenuBar menu;
private JMenu hp,hilfe;
private JMenuItem oeffnen,beenden,help;

	public Gui(String name) {
		
		JLabel beschriftung_Sp1 = new JLabel( "Spieler 1: " );
		JLabel beschriftung_Sp2 = new JLabel( "Spieler 2: " );
		JTextField textfeld_Sp1 = new JTextField();
		JTextField textfeld_Sp2 = new JTextField();
		JComboBox combo_Sp1 = new JComboBox();
		JComboBox combo_Sp2 = new JComboBox();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		
		start = new JFrame(name);
		start.addMouseListener(this);
		start.setLayout(new GridLayout(4,1));
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.setSize(400, 400);
		
		jp1.setLayout(new GridLayout(1,3));
		jp1.setSize(400, 20);
		jp1.add(beschriftung_Sp1);
		jp1.add(textfeld_Sp1);
		jp1.add(combo_Sp1);
		
		jp2.setLayout(new GridLayout(1,3));
		jp2.add(beschriftung_Sp2);
		jp2.add(textfeld_Sp2);
		jp2.add(combo_Sp2);
		
		start.add(jp1);
		start.add(jp2);
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
