package presenter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import modelMVP.Model;

/**
 * this method is save the maze3d by the String we get in the file by the FileOutputStream we get
 * @param name is the name of the maze 3d we want to save in the file
 * @param fos is the FileOutputStream we used to save the maze
 * @return nothing
 */
public class SaveMaze implements Command {
	private Model m;
	
	/**
	 * this is the constructor that put the name of the maze 3d and view in ours
	 * @param fos is the file out put stream to print the file 
	 * @param m3d is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public SaveMaze(Model m) 
	{
		this.m = m;
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st) 
	{
		try {
			m.saveM3d(st[1],new FileOutputStream(st[2]),st[3]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
