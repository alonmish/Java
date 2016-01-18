package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import viewMVC.view;

/**
 * this method is load(bring us) the maze3d by the String we get in the file by the FileInputStream we get
 * @param name is the name of the maze 3d we want to save in the file
 * @param fis is the FileOutputStream we used to load the maze
 * @return nothing
 */
public class LoadMaze implements Command {
	private String LoadNameM3d;
	private FileInputStream fis;
	private view v;
	
	/**
	 * this is the constructor that put the name of the maze 3d and view in ours
	 * @param fis is the file input stream to put the maze
	 * @param m3d is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public LoadMaze(view v,String m3d, FileInputStream fis)
	{
		this.v = v;
		this.LoadNameM3d = m3d;
		this.fis = fis;
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st)
	{
		LoadNameM3d=st[1];
		try {
			fis.close();
		} catch (IOException e) {}
		try {
			fis= new FileInputStream(st[0]);
		} catch (FileNotFoundException e) {}
		this.v.loadM3d(fis, this.LoadNameM3d);
	}

}
