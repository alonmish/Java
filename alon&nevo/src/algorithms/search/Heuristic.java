package algorithms.search;


public interface Heuristic<T>
{
	public double heu(State<T> c);
}
