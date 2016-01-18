package presenter;

import java.util.concurrent.Callable;

import algorithms.mazeGenerators.Postion;
import algorithms.search.Searchable;
import algorithms.search.Searcher;
import algorithms.search.Solution;

public class Solve_Callable implements Callable<Solution<Postion>> {

	Searcher<Postion> s;
    Searchable <Postion> sa;
    public Solve_Callable(Searcher<Postion> s, Searchable <Postion> sa) 
    {
    	this.s=s;
    	this.sa=sa;
	}
	@Override
	public Solution<Postion> call() throws Exception 
	{
		return s.search(sa);
	}

}
