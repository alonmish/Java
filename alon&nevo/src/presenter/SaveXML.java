package presenter;

import modelMVP.Model;

public class SaveXML implements Command {
	private Model m; 
	
	public SaveXML(Model m) 
	{
	  this.m=m; 
	}
	@Override
	public void doCommand(String[] st) 
	{
      m.SaveXML(st[1]); 
	}

}
