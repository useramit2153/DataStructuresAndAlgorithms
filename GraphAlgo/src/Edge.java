
public class Edge {
	
	private int sv;
	private int ev;
	private int cost;
	
	public Edge(int sv, int ev, int cost) {
		this.sv = sv;
		this.ev = ev;
		this.cost = cost;
	}
	
	public int getSV() {
		return sv;
	}
	
	public int getEV() {
		return ev;
	}
	
	public int getCost() {
		return cost;
	}
	
}
