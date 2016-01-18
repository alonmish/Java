package presenter;

import modelMVP.Model;

/**
 * this method is solve maze 3d with the algorithm from searcher and put in the hash map solver
 * @param name is the name of the maze 3d
 * @param s is the algorithm we want to solve the maze 3d with
 * @return nothing
 */
public class Solve<Position> implements Command{
	private Model m;
	
	/**
	 * this is the constructor that put the name of the maze 3d and view in ours
	 * @param s is the searcher we want to solve the maze with
	 * @param SolveM3d is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public Solve(Model m) 
	{
		this.m = m;
	}
	
	@Override
	public void doCommand(String[] st)
	{
		m.solveM3d(st[1],st[3]);
	}
	

}
