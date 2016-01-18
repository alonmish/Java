package presenter;

import algorithms.mazeGenerators.Postion;
import algorithms.search.Bfs;
import algorithms.search.CostComp;
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
