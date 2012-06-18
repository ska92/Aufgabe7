package aufgabe7.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4108891482803446829L;
	
	public boolean startSpiel = false;

	private JFrame start;
	private JMenuBar menu;
	private JMenu hp, hilfe;
	private JMenuItem oeffnen, beenden, help;
	
	private JTextField textfeld_Sp1, textfeld_Sp2;
	private JComboBox<String> combo_Sp1, combo_Sp2;
	private JComboBox<String> levelBox;
	
	private String[] levels = { "Leicht", "Mittel", "Schwer" };
	
	
	public String getLevel(){
		return levelBox.getSelectedItem().toString();
	}

	public String getSpieler1Name() {
		return textfeld_Sp1.getText();
	}

	public String getSpieler2Name() {
		return textfeld_Sp2.getText();
	}
	
	public Color getSpieler1Color(){
		String auswahl = combo_Sp1.getSelectedItem().toString();
		
		if(farben.containsKey(auswahl)){
			return farben.get(auswahl);
		} else {
			return Color.WHITE;
		}
	}
	
	public Color getSpieler2Color(){
		String auswahl = combo_Sp2.getSelectedItem().toString();

		if(farben.containsKey(auswahl)){
			return farben.get(auswahl);
		} else {
			return Color.WHITE;
		}
	}
	
	
	private HashMap<String, Color> farben;
	
	private void baueHashMap(){
		farben = new HashMap<String, Color>();
		farben.put("Weiß", Color.WHITE);
		farben.put("Rot", Color.RED);
		farben.put("Grün", Color.GREEN);
		farben.put("Gelb", Color.YELLOW);
		farben.put("Blau", Color.BLUE);
		farben.put("Cyan", Color.CYAN);
	}

	public Gui(String name) {
		baueHashMap();
		JButton gamestart = new JButton("Start");
		JLabel beschriftung_Sp1 = new JLabel("Spieler 1: ");
		JLabel beschriftung_Sp2 = new JLabel("Spieler 2: ");
		
		
		combo_Sp1 = new JComboBox<String>();
		combo_Sp2 = new JComboBox<String>();
		for(String s : farben.keySet()){
			combo_Sp1.addItem(s);
			combo_Sp2.addItem(s);
		}
		
		textfeld_Sp1 = new JTextField();
		textfeld_Sp2 = new JTextField();
		
		levelBox = new JComboBox<String>();
		for( String s : levels){
			levelBox.addItem(s);
		}

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		

		start = new JFrame(name);
		start.setLayout(new GridLayout(4, 1));
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.setSize(400, 400);

		jp1.setLayout(new GridLayout(1, 3));
		jp1.setSize(400, 20);
		jp1.add(beschriftung_Sp1);
		jp1.add(textfeld_Sp1);
		jp1.add(combo_Sp1);

		jp2.setLayout(new GridLayout(1, 3));
		jp2.add(beschriftung_Sp2);
		jp2.add(textfeld_Sp2);
		jp2.add(combo_Sp2);

		jp3.setLayout(new GridLayout(1, 1));

		jp3.add(new JLabel("Schwierigkeit: " ));
		jp3.add(levelBox);

		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				startSpiel = true;
			}
		};
		gamestart.addActionListener(al);

		start.add(jp1);
		start.add(jp2);
		start.add(jp3);
		start.add(gamestart);
		menu();
		start.setJMenuBar(menu);
		start.setVisible(true);
	}

	public void menu() {

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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
