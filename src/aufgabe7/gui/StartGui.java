package aufgabe7.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import aufgabe7.events.WindowAdapter;
import aufgabe7.spiel.Level;
import aufgabe7.spiel.SpielerAuswahl;
import aufgabe7.spielfeld.Spielfeld;

public class StartGui extends JFrame implements ActionListener, ItemListener{
	
	class CloseAction extends WindowAdapter{
		
		public void windowClosing(WindowEvent e){
			if(gameThread != null){
				gameThread.interrupt();
			}
		}
	}
	
	private static final long serialVersionUID = 1L;
	
	//Thread, in dem das Spiel abläuft
	Thread gameThread = null;
	
	//Auswahl der Level
	private JComboBox<String> levelBox;
	private HashMap<String, Level> levelMap;
	
	//Auswahl Spieler/Computer
	private JCheckBox spielerAuswahlBox;
	
	//Textfelder für die Spielernamen
	private JTextField spieler1Name, spieler2Name;
	
	//Buttons für die Spielerfarben
	private JButton spieler1Farbe, spieler2Farbe;
	
	/**
	 * Erzeugt ein neues Startfenster mit dem angegebenen Fenstertitel	
	 * @param frameTitle Titel des Frames
	 */
	public StartGui(String frameTitle){
		super(frameTitle);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//Level Panel
		JPanel levelPanel = new JPanel();
		levelPanel.setLayout(new BorderLayout());
		levelPanel.add(new JLabel("Schwierigkeit: "), BorderLayout.WEST);
		
		levelBox = new JComboBox<String>();
		levelMap = new HashMap<String, Level>();
		for(Level l : Level.values()){
			levelMap.put(l.getName(), l);
			levelBox.addItem(l.getName());
		}
		levelPanel.add(levelBox, BorderLayout.CENTER);
		
		//KI-Panel
		JPanel computerPanel = new JPanel();
		computerPanel.setLayout(new BorderLayout());
		computerPanel.add(new JLabel("Computergegner: "), BorderLayout.WEST);
		spielerAuswahlBox = new JCheckBox(" Ja");
		spielerAuswahlBox.addItemListener(this);
		
		computerPanel.add(spielerAuswahlBox, BorderLayout.EAST);
		
		
		//Nord-Panel
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2,1));
		
		northPanel.add(levelPanel);
		northPanel.add(computerPanel);
		add(northPanel, BorderLayout.NORTH);
		
		//Spieler Panel für Namen & Farben
		JPanel spielerPanel = new JPanel();
		spielerPanel.setBorder( BorderFactory.createTitledBorder("Spieler"));
		spielerPanel.setLayout(new GridLayout(2,3));
		
		spielerPanel.add(new JLabel("Spieler1: "));
		spieler1Name = new JTextField();
		spielerPanel.add(spieler1Name);
		
		spieler1Farbe = new JButton("Farbe");
		spieler1Farbe.setBackground( Color.WHITE );
		spieler1Farbe.addActionListener(this);
		spielerPanel.add(spieler1Farbe);
		
		
		spielerPanel.add(new JLabel("Spieler2: "));
		spieler2Name = new JTextField();
		spielerPanel.add(spieler2Name);
		
		spieler2Farbe = new JButton("Farbe");
		spieler2Farbe.setBackground( Color.WHITE );
		spieler2Farbe.addActionListener(this);
		spielerPanel.add(spieler2Farbe);
		
		add(spielerPanel, BorderLayout.CENTER);
		
		//Button zum Spielstart
		JButton startButton = new JButton("Starte Spiel");
		startButton.addActionListener(this);
		add(startButton, BorderLayout.SOUTH);
		
		setSize(250, 180);
		setResizable(false);
		setVisible(true);
	}

	//Gibt das aktuell ausgewählte Level zurück
	private Level getLevel(){
		return levelMap.get(levelBox.getSelectedItem().toString());
	}
	
	//Gibt die Auswahl Zurück, ob gegen einen Computer oder Menschen gespielt wird.
	private SpielerAuswahl getSpielerAuswahl(){
		if(spielerAuswahlBox.isSelected())
			return SpielerAuswahl.Computer;
		else
			return SpielerAuswahl.Mensch;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new StartGui("Pong Menü");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == spieler1Farbe){
			Component comp = (Component)arg0.getSource();
			Color newColor = JColorChooser.showDialog(null, "Farbe Spieler1 Wählen", comp.getBackground());
			if(newColor != null)
				comp.setBackground(newColor);
			return;
		}
		
		if(arg0.getSource() == spieler2Farbe){
			Component comp = (Component)arg0.getSource();
			Color newColor = JColorChooser.showDialog(null, "Farbe Spieler2 Wählen", comp.getBackground());
			if(newColor != null)
				comp.setBackground(newColor);
			return;
		}
		
		//Neues Spiel starten
		Spielfeld sp = new Spielfeld("Pong");
		sp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		sp.getSpieler1().setFarbe(spieler1Farbe.getBackground());
		sp.getSpieler1().setName(spieler1Name.getText());
		
		sp.getSpieler2().setFarbe(spieler2Farbe.getBackground());
		sp.getSpieler2().setName(spieler2Name.getText());
		
		sp.setLevel(getLevel());
		sp.setSpielerAuswahl(getSpielerAuswahl());
		
		sp.addWindowListener(new CloseAction());
		
		gameThread = new Thread( sp );
		gameThread.start();
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if(arg0.getSource() == spielerAuswahlBox){
			if(spielerAuswahlBox.isSelected()){
				spieler1Name.setText("Computer");
				spieler1Name.setEditable(false);
			} else {
				spieler1Name.setText("");
				spieler1Name.setEditable(true);
			}
		}
		
	}



}
