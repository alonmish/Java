package presenter;

import modelMVP.Model;

public class LoadXML implements Command 
{
	private Model m;
	
	public LoadXML(Model m)
	{
		this.m = m;
	}
	
	@Override
	public void doCommand(String[] st) 
	{
		m.changeXMLFile(st[1]);
	}

}
