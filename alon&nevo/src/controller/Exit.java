package controller;

import viewMVC.view;

/**
 * finish all the program and taking care of closing all of the 
 * Thread and files
 * @return nothing
 */
public class Exit implements Command {
	private view v;
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doCommand(String[] st) 
	{
		v.exit();
	}

}
