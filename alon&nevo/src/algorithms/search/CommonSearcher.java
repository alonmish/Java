package algorithms.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This class is commonsearcher he used priorityqueue to bring as the best searcher
 *@param openlist is the priority q
 *@param evaluatednodes is the nodes for the queue
 * @return  nothing
 */
public abstract class CommonSearcher<T> implements Searcher<T>{
	protected PriorityQueue<State<T>> openList;
	private int evaluatedNodes;
	
	
	/**
	 * This method is the default contractor of the class
	 * @return  nothing
	 */
	public CommonSearcher()
	{
		openList = new PriorityQueue<State<T>>();
		evaluatedNodes = 0;
	}
	
	/**
	 * This method is contractor of the class with comparator
	 *@param c is the comparator we put
	 * @return  nothing
	 */
	public CommonSearcher(Comparator<State<T>> c) {
		// TODO Auto-generated constructor stub
		this.openList = new PriorityQueue<State<T>>(1,c);
		this.evaluatedNodes = 0;
	}
	
	/**
	 * This method is bring as the list we want and add the evalutednodes
	 * @return  State
	 */
	public State<T> popOpenList()
	{
		evaluatedNodes++;
		return openList.poll();
	}
	
	/**
	 * This method is search the problem and give as solution with searchable
	 *@param s is the searchable we search with
	 * @return  Solution
	 */
	@Override
	public abstract Solution<T> search(Searchable<T> s);
	
	/**
	 * This method is the get of number of nodes
	 * @return  int
	 */
	@Override
	public int getNumberOfNodesEvaluated()
	{
		return this.evaluatedNodes;
	}
	
	/**
	 * This method is the get of the queue
	 * @return  PriorityQueue
	 */
	public PriorityQueue<State<T>> getOpenList() {
		return openList;
	}
	
	/**
	 * This method is the set of the list with list we give him
	 * @param openlist is the list we want to put in our list
	 * @return  nothing
	 */
	public void setOpenList(PriorityQueue<State<T>> openList) {
		this.openList = openList;
	}
	
	/**
	 * This method is the get of the number of nodes
	 * @return  int
	 */
	public int getEvaluatedNodes() {
		return evaluatedNodes;
	}
	
	/**
	 * This method is the set of the number of nodes
	 * @param evaluatednodes are the number of nodes
	 * @return  nothing
	 */
	public void setEvaluatedNodes(int evaluatedNodes) {
		this.evaluatedNodes = evaluatedNodes;
	}
	
	/**
	 * This method is give as the array of all solution
	 * @param goal is the goal
	 * @param start is the start
	 * @return  Solution
	 */
	public Solution<T> backTrace(State<T> goal,State<T> start)
	{
		ArrayList<State<T>> s = new ArrayList<State<T>>();
		while (!goal.equals(start))
		{
			s.add(new State<T>(goal));
			goal = goal.getCameFrom();
		}
		return new Solution<T>(s);
	}	
	
}
