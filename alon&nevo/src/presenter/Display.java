package presenter;

import modelMVP.Model;

/**
 * this method is print to user the maze by his name we want
 * @param name is name of the maze 3d we want to display
 * @return nothing
 */
public class Display implements Command 
{
	private Model m;
	
	/**
	 * this is the constructor that put the name of the maze 3d and view in ours
	 * @param m3d is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public Display(Model m)
	{
		this.m = m;
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st) 
	{
		m.display(st[1],st[2]);
	}


}
