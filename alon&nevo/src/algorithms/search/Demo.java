package algorithms.search;

import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Postion;

/**
 * This class is the run class
 * @return  nothing
 */
public class Demo {
	/**
	 * This method is the run method
	 * @return  nothing
	 */
	private static void run()
	{
		SearchableAdapter maze = new SearchableAdapter(new MyMaze3dGenerator().generate(10,10,10));
		maze.getM3d().printM3d();
		Searcher<Postion> bfs = new Bfs<Postion>(null);
		bfs.search(maze);
		System.out.println("bfs:");
		System.out.println(bfs.getNumberOfNodesEvaluated());
	}
	/**
	 * This method is the main he get String that he doesnt use
	 * @param args is the string
	 * @return  nothing
	 */
	public static void main(String[] args) {
		run();

	}

}
