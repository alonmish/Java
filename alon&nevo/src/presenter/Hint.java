package presenter;

import algorithms.mazeGenerators.Postion;
import modelMVP.Model;

public class Hint implements Command {
	
	private Model m;
	
	public Hint(Model m) 
	{
		this.m = m;
	}
	
	@Override
	public void doCommand(String[] st) 
	{
		m.hint(st[1],new Postion(st[3].charAt(1)-'0',st[3].charAt(3)-'0',st[3].charAt(5)-'0'));
	}

}
