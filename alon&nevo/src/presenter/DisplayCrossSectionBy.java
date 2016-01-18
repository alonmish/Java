package presenter;

import modelMVP.Model;

/**
 * this method is bring us the maze 2d in the line we want he used String (the maze)
 * int (the index we want in the line) and char (what line)
 * @param name is the name of the maze
 * @param index is the number in the place
 * @param is the line we want
 * @return nothing
 */
public class DisplayCrossSectionBy implements Command
{
	private Model m;
	
	/**
	 * this is the constructor that put the name of the maze 3d and the index we want
	 * and the place of line view in ours
	 * @param m3d is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public DisplayCrossSectionBy(Model m) 
	{
		this.m = m;
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st) 
	{
		m.getCrossBY(st[1],Integer.parseInt(st[2]), st[3].charAt(0),st[4]);
	}

	
}
