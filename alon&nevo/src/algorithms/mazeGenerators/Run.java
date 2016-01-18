package algorithms.mazeGenerators;
/**
* THE run class is the class that crate all the maze 3d 
*/
public class Run {
	private static void testMazeGenerator(Maze3dGenerator mg){
			// prints the time it takes the algorithm to run
			System.out.println(mg.measureAlgorithmTime(7,7,7));
			// generate another 3d maze
			Maze3d maze=mg.generate(7,7,7);
			// get the maze entrance
			Postion p=maze.getStart();
			// print the position
			System.out.println(p); // format "{x,y,z}"
			// get all the possible moves from a position
			String[] moves=maze.getPossibleMoves(p);
			// print the moves
			for(String move : moves)
			System.out.println(move);
			// prints the maze exit position
			System.out.println(maze.getGoal());
			try{
			// get 2d cross sections of the 3d maze
			int[][] maze2dx=maze.getCrossSectionByX(2);
			// TODO add code to print the array
			int[][] maze2dy=maze.getCrossSectionByX(5);
			// TODO add code to print the array
			int[][] maze2dz=maze.getCrossSectionByX(0);
			// TODO add code to print the array
			// this should throw an exception!
			maze.getCrossSectionByX(-1);
			} catch (IndexOutOfBoundsException e){
			System.out.println("good!");
			}
			}
	/**
	* THE main program is used String that doesnt being used and call the run class
	*/
		public static void main(String[] args) 
		{
			testMazeGenerator(new SimpleMaze3dGenerator());
			testMazeGenerator(new MyMaze3dGenerator());

		}


}
