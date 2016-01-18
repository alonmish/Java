package modelMVP;

import java.util.concurrent.Callable;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;

public class MyCallable implements Callable<Maze3d> 
{
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private int x,y,z;
	@SuppressWarnings("unused")
	private Maze3dGenerator m3dG;
	public MyCallable(){}
   public MyCallable( String name,int x,int y, int z, Maze3dGenerator m3dG)
   {
	   this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
		this.m3dG = m3dG;
   }
	@Override
	public Maze3d call() throws Exception 
	{
		
		return null;
	}

}
