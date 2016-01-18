package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import viewMVC.view;

/**
 * this method is save the maze3d by the String we get in the file by the FileOutputStream we get
 * @param name is the name of the maze 3d we want to save in the file
 * @param fos is the FileOutputStream we used to save the maze
 * @return nothing
 */
public class SaveMaze implements Command {
	private String SaveNameM3d;
	private FileOutputStream fos;
	private view v;
	
	/**
	 * this is the constructor that put the name of the maze 3d and view in ours
	 * @param fos is the file out put stream to print the file 
	 * @param m3d is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public SaveMaze(view v, String m3d ,FileOutputStream fos) 
	{
		this.v = v;
		this.SaveNameM3d = m3d;
		this.fos = fos;
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st) 
	{
		this.SaveNameM3d=st[0];
		try {
			fos.close();
		} catch (IOException e) {}
		try {
			fos=new FileOutputStream(st[1]);
		} catch (FileNotFoundException e) {}
		this.v.saveM3d(this.SaveNameM3d, this.fos);
	}

}
