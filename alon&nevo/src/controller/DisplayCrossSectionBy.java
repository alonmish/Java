package controller;

import viewMVC.view;

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
	private int index;
	private char place;
	private String M3d;
	private view view;
	
	/**
	 * this is the constructor that put the name of the maze 3d and the index we want
	 * and the place of line view in ours
	 * @param m3d is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public DisplayCrossSectionBy(view v , String m3d ,int index , char place) 
	{
		this.view = v;
		this.M3d = m3d;
		this.index = index;
		this.place = place;
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st) 
	{
		this.index=(Integer.valueOf(st[1]));
		this.M3d=(st[2]);
		this.place=(st[0].charAt(0));
		this.view.getCrossBY(this.M3d, this.index, this.place);
	}

	
}
