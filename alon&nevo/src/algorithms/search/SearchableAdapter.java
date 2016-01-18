package algorithms.search;
import java.util.ArrayList;
import algorithms.mazeGenerators.*;

/**
 * This class is the SearchableAdapter he find the best search for maze 3d he used Maze3d
 * @return  nothing
 */
public class SearchableAdapter implements Searchable<Postion> {
	private Maze3d m3d;
	
	/**
	 * This method is the get of the maze 3d
	 * @return  Maze3d
	 */
	public Maze3d getM3d() {
		return m3d;
	}
	
	/**
	 * This method is the set of the maze 3d he used Maze3d
	 * @param m3d to put in the class maze 3d
	 * @return  nothing
	 */
	public void setM3d(Maze3d m3d) {
		this.m3d = m3d;
	}
	
	/**
	 * This method is the constractor used Maze3d to put in the class Maze3d
	 * @param m3d to put in the class maze 3d
	 * @return  nothing
	 */
	public SearchableAdapter(Maze3d m3d)
	{
		this.m3d = m3d;
	}
	
	/**
	 * This method is the get of the initial state
	 * @return  State
	 */
	@Override
	public State<Postion> getInitialstate()
	{
		return new State<Postion>(this.m3d.getStart());
	}
	
	/**
	 * This method is the get of the goal state
	 * @return  State
	 */
	@Override
	public State<Postion> getGoalState()
	{
		return new State<Postion>(this.m3d.getGoal());
	}
	
	/**
	 * This method is to get all the possible states we can and used state to check about it
	 * @param sp is the state we check about 
	 * @return  ArrayList
	 */
	@Override
	public ArrayList<State<Postion>> getAllPossibleStates(State<Postion> sp)
	{
		ArrayList<Postion> ap =  this.m3d.getArrayPossibleMoves(sp.getState());
		ArrayList<State<Postion>> asp = new ArrayList<State<Postion>>() ;
		if(ap == null) return null ;
		for(Postion p : ap)
			asp.add(new State<Postion>(p));
		return asp ;
	}

}
