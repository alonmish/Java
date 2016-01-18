package presenter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import modelMVP.Model;

/**
 * this method is load(bring us) the maze3d by the String we get in the file by the FileInputStream we get
 * @param name is the name of the maze 3d we want to save in the file
 * @param fis is the FileOutputStream we used to load the maze
 * @return nothing
 */
public class LoadMaze implements Command {
	private Model m;
	
	/**
	 * this is the constructor that put the name of the maze 3d and view in ours
	 * @param fis is the file input stream to put the maze
	 * @param m3d is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public LoadMaze(Model m)
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
			m.loadM3d(new FileInputStream(st[1]), st[2],st[3]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
