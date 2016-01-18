package presenter;

import modelMVP.Model;

/**
 * finish all the program and taking care of closing all of the 
 * Thread and files
 * @return nothing
 */
public class Exit implements Command 
{
	private Model m;
	
	public Exit(Model m)
	{
		this.m = m;
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st) 
	{
		m.exit();
	}

}
