package controller;


import algorithms.mazeGenerators.Postion;
import algorithms.search.Astar;
import algorithms.search.Bfs;
import algorithms.search.CostComp;
import algorithms.search.MazeDistanse;
import algorithms.search.Searcher;
import model.Task;
import model.ThreadRunnable;
import viewMVC.view;

/**
 * this method is solve maze 3d with the algorithm from searcher and put in the hash map solver
 * @param name is the name of the maze 3d
 * @param s is the algorithm we want to solve the maze 3d with
 * @return nothing
 */
public class Solve<Position> implements Command , Task {
	private String SolveM3d;
	private Searcher<Postion> s;
	private view v;
	
	/**
	 * this is the constructor that put the name of the maze 3d and view in ours
	 * @param s is the searcher we want to solve the maze with
	 * @param SolveM3d is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public Solve(String SolveM3d ,Searcher<Postion> s ,view v) 
	{
		this.SolveM3d = SolveM3d;
		this.s = s;
		this.v = v;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void doCommand(String[] st)
	{
		SolveM3d=st[0];
		switch (st[1]) {
		case "Astar":
			s=new Astar<Postion>(new MazeDistanse(), new CostComp());
			break;
		case "Bfs":
			s=new Bfs<Postion>(new CostComp());
			break;
      default:
    	  v.printToUser("Enter a valid algorithm");
			break;
		}
		Thread t = new Thread(new ThreadRunnable(new Solve<Position>(this.SolveM3d , this.s,this.v)));
		t.start();
	}
	
	/**
	 * run the command line that the user chose
	 */
	@Override
	public void doTask() 
	{
		v.solveM3d(this.SolveM3d, this.s);		
	}

}
