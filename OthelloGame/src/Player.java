
public class Player {
	private String name;
	private char color;
	
	public Player(String name, char color) {
		setPlayerName(name);
		setColor(color);
	}

	public void setPlayerName(String name2) {
		this.name = name2;
	}
	
	public String getPlayerName() {
		return this.name;
	}
	
	public void setColor(char color2) {
		this.color = color2;
	}
	
	public char getColor() {
		return this.color;
	}
}
