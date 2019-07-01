import java.util.Comparator;

public class SortObject implements Comparator<Edge> {

	@Override
	public int compare(Edge e1, Edge e2) {
		return e1.getCost() - e2.getCost();
	}

}
