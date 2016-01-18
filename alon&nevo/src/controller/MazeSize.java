package controller;

import viewMVC.view;

/**
 * this method is bring us the size of the maze 3d in the memory by his name
 * @param name is the name of maze 3d we want to get his size
 * @return nothing
 */
public class MazeSize implements Command {
	private String NameM3d;
	private view v;
	
	/**
	 * this is the constructor that put the name of the maze 3d and view in ours
	 * @param m3d is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public MazeSize(view v , String m3d) 
	{
		this.v = v;
		this.NameM3d = m3d;
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st)
	{
		NameM3d=st[0];
		this.v.mazeSize(this.NameM3d);
	}

}
