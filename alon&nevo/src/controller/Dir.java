package controller;

import java.io.File;

import viewMVC.view;

/**
 * this method prints us all the folders in the file to the controller
 * @param f is the file we want to get all his folders
 * @return nothing
 */
public class Dir implements Command{
	private File file;
	private view v;
	
	/**
	 * this is the constructor that put the file and view in ours
	 * @param f is the file we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public Dir(File f , view v)
	{
		this.file = f;
		this.v = v;
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st)
	{
		this.file= new File(st[0]);
		v.dir(this.file);
	}

	

}
