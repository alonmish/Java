package presenter;


import modelMVP.Model;

/**
 * this method is bring us the solution for String maze3d we want
 * @param name is the name of the maze 3d
 * @return nothing
 */
public class DisplaySolution implements Command 
{
	private Model m;
	
	/**
	 * this is the constructor that put the name of the maze 3d and view in ours
	 * @param s is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public DisplaySolution(Model m) 
	{
		this.m = m;
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st) 
	{
		m.displaySolution(st[1],st[2]);
	}

}
