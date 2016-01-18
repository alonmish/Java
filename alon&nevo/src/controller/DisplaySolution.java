package controller;

import viewMVC.view;

/**
 * this method is bring us the sultion for String maze3d we want
 * @param name is the name of the maze 3d
 * @return nothing
 */
public class DisplaySolution implements Command 
{
	private String solName;
	private view v;
	
	/**
	 * this is the constructor that put the name of the maze 3d and view in ours
	 * @param s is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public DisplaySolution(String s, view v) 
	{
		this.v = v;
		this.solName = s;
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st) 
	{
		solName=st[0];
		v.displaySolution(solName);
	}

}
