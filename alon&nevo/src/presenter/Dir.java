package presenter;

import java.io.File;
import modelMVP.Model;

/**
 * this method prints us all the folders in the file to the controller
 * @param f is the file we want to get all his folders
 * @return nothing
 */
public class Dir implements Command{
	private Model m;
	
	/**
	 * this is the constructor that put the file and view in ours
	 * @param f is the file we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public Dir(Model m)
	{
		this.m = m;
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st)
	{
		m.dir(new File(st[1]),st[2]);
	}

	

}
