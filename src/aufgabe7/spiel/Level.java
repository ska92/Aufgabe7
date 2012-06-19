package aufgabe7.spiel;

public enum Level {
	
	Leicht("Leicht"),
	MITTEL("Mittel"),
	SCHWER("Schwer");
	
	private String name;
	
	Level(String s)
	{
		name = s;
	}
	
	public String getName(){
		return name;
	}
}
