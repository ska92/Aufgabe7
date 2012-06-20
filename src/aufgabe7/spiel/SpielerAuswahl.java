package aufgabe7.spiel;

public enum SpielerAuswahl {
	
	Computer("Computer"),
	Mensch("Mensch");
	
	String s;
	
	SpielerAuswahl(String s){
		this.s = s;
	}
	
	public String toString(){
		return this.s;
	}

}
