package presenter;


import modelMVP.Model;


/**
 * this method is create a maze 3d and put it in the hash map with the controller
 * @param name is the name of the maze 3d
 * @param x is the size of x line
 * @param y is the size of y line
 * @param z is the size of z line
 * @param m3dG is how we create the maze
 * @param return nothing
 */
public class Generate3DMaze implements Command 
{
	private Model m;
	
	/**
	 * this is the constructor that put the name of the maze 3d and view in ours
	 * by using 3 integers for the length of lines and and creator for the maze 3d
	 * @param m3d is the name of the maze 3d we want to put
	 * @param v is the view we want to put
	 * @return nothing
	 */
	public Generate3DMaze(Model m) 
	{
		this.m = m;
	}
	
	/**
	 * run the command line that the user chose
	 */	
	@Override
	public void doCommand(String[] st) 
	{
		m.generateM3d(st[1], Integer.parseInt(st[2]), Integer.parseInt(st[3]), Integer.parseInt(st[4]), st[5]);
		//ExecutorService exe= Executors.newFixedThreadPool(10);
		//Future<Maze3d> f= exe.submit(new MyCallable());
	}

	
	

}
