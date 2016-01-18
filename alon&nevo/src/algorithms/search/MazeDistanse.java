package algorithms.search;


import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Postion;

/**
 * This method is the MazeDistanse he used the goal state and bring ass the distance
 * @param goalstate is the the goal the end of the distance
 * @return  nothing
 */
public class MazeDistanse implements Heuristic
{
	private State<Postion> goalState;
	
	/**
	 * This method bring us the distance from the goal he used the state to do it
	 * @param c is the state to bring us
	 * @return  double
	 */
	public double heu(State c)
	{
		Maze3d m3d = new Maze3d();
		int x = m3d.getGoal().getX();
		int y = m3d.getGoal().getY();
		int z = m3d.getGoal().getZ();
		double result = x*x + y*y + z*z;
		return Math.sqrt(result);
	}
	
	/**
	 * This method is the get of the goal
	 * @return  PriorityQueue
	 */
	public State<Postion> getGoalState() {
		return goalState;
	}
	
	/**
	 * This method is the set of the goal he used state
	 * @param goalstate to put in the goal state class
	 * @return  nothing
	 */
	public void setGoalState(State<Postion> goalState) {
		this.goalState = goalState;
	}
}
