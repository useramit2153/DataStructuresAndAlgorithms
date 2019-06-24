
public class Player {
	private String name;
	private char symbol;
	
	public Player(String name, char symbol) {
		setName(name);
		setSymbol(symbol);
	}

	public void setSymbol(char symbol2) {
		if(symbol2 != '\0')
			this.symbol = symbol2;
	}

	public void setName(String name2) {
		if(!name2.isEmpty())
			this.name = name2;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public String getName() {
		return this.name;
	}
}
