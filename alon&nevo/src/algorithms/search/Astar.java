package algorithms.search;

import java.util.Comparator;

/**
* THE Astar is solving a maze 3d with the Astar software
*/
public class Astar<T> extends Bfs<T>
{
	private Heuristic<T> h;
	
	/**
	 * This method is used Comparator and heuristic to create a maze 3d with Astar
	 *@param h is the heuristic we put in our
	 *@param c is the comparator to create the maze 3d
	 * @return  nothing
	 */
	public Astar(Heuristic<T> h , Comparator<State<T>> c)
	{
		super(c);
		this.h = h;
	}
	
	/**
	 * This method is used state to calculate the cost
	 *@param s is the state we want to calculate the cost
	 * @return  double
	 */
	@Override
	public double calculateCost(State<T> s)
	{
		return super.calculateCost(s) + this.h.heu(s);
	}
}
