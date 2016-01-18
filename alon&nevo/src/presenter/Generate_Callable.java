package presenter;

import java.util.concurrent.Callable;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;

public class Generate_Callable implements Callable<Maze3d> {
    private int x;
    private int y;
    private int z;
    private Maze3dGenerator mg;
	public Generate_Callable(int x, int y, int z,Maze3dGenerator mg ) 
	{
		this.x=x;
		this.y=y;
		this.z=z;
		this.mg=mg;
		
	}
    @Override
	public Maze3d call() throws Exception {
		return this.mg.generate(this.x, this.y, this.z);
    }

}
