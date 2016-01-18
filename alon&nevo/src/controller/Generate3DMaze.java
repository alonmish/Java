package controller;

import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.SimpleMaze3dGenerator;
import model.Task;
import model.ThreadRunnable;
import viewMVC.view;

/**
 * this method is create a maze 3d and put it in the hash map with the controller
 * @param name is the name of the maze 3d
 * @param x is the size of x line
 * @param y is the size of y line
 * @param z is the size of z line
 * @param m3dG is how we create the maze
 * @param return nothing
 */
public class Generate3DMaze implements Command , Task 
{
	private String m3d;
	private int x,y,z;
	private Maze3dGenerator m3dG;
	private view v;
	
	/**
	 * this is the constructor that put the name of the maze 3d and view in ours
	 * by using 3 integers for the length of lines and and creator for the maze 3d
	 * @param m3d is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public Generate3DMaze(String m3d,int x,int y,int z,Maze3dGenerator m3dG, view v) 
	{
		this.m3d = m3d;
		this.x = x;
		this.y = y;
		this.z = z;
		this.m3dG = m3dG;
		this.v = v;
	}
	
	/**
	 * run the command line that the user chose
	 */	
	@Override
	public void doCommand(String[] st) 
	{
		this.m3d=(st[0]);
		this.x=Integer.valueOf(st[1]);
		this.y=(Integer.valueOf(st[2]));
		this.z=(Integer.valueOf(st[3]));
		switch (st[4])
		{
		case "simple":
			this.m3dG=(new SimpleMaze3dGenerator());
		case "myAlogrithm":
			this.m3dG=(new MyMaze3dGenerator());
			default: 
				v.printToUser("Enter a valid algorithm");
		}
		Thread t = new Thread(new ThreadRunnable(new Generate3DMaze(this.m3d, this.x,this.y,this.z,this.m3dG,this.v)));
		t.start();
	}

	@Override
	public void doTask() 
	{
		v.generateM3d(m3d, x, y, z, m3dG);
	}

	

}
