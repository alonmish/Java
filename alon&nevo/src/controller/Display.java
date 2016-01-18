package controller;

import viewMVC.view;

/**
 * this method is print to user the maze by his name we want
 * @param name is name of the maze 3d we want to display
 * @return nothing
 */
public class Display implements Command 
{
	private String m3d;
	private view v;
	
	/**
	 * this is the constructor that put the name of the maze 3d and view in ours
	 * @param m3d is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public Display(view v,String m3d)
	{
		this.v = v;
		this.m3d = m3d;
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st) 
	{
		this.m3d=(st[0]);
		this.v.display(this.m3d);
	}


}
