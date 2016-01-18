package algorithms.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

/**
 * This class is the bfs class he give as sultion to create a maze 3d
 */
public class Bfs<T> extends CommonSearcher<T>
{
	
	/**
	 * This method is used comparator to create maze 3d with bfs
	 *@param c is the comparator we used to create the bfs 
	 * @return  nothing
	 */
	public Bfs(Comparator<State<T>> c) {
		// TODO Auto-generated constructor stub
		super(c);
	}
	
	/**
	 * This method is used searchable to search the solution of the problem
	 *@param s is the search of the problem
	 * @return  Solution
	 */
	@Override
	public Solution<T> search(Searchable<T> s)
	{	
		System.out.println("1");
		State<T> start = s.getInitialstate() ;
		start.setCost(calculateCost(start));
		openList.add(start) ;  
		HashSet<State<T>> closedSet = new HashSet<State<T>>() ;
		while(openList.size()>0)
		{
			//System.out.println("2");
			State<T> n = popOpenList() ;
			//n.setCost(calculateCost(n)) ;
			closedSet.add(n);
			
			if(n.equals(s.getGoalState()))
			{
				System.out.println("3");
				return backTrace(n,s.getInitialstate()) ;
			}
			
			ArrayList<State<T>> successors = s.getAllPossibleStates(n);
			if(successors == null)
				{
					System.out.println("8");
					return null ;
				}
			for(State<T> state : successors)
				
				if( (!closedSet.contains(state)) && (!openList.contains(state)) ){
					//System.out.println("6");
					state.setCameFrom(n);
					openList.add(state);
					
				}
				else{
					State<T> temp = new State<T>(state.getState()) ; 
					temp.setCameFrom(n);
					if(calculateCost(temp) < state.getCost())
					{ 
						if(!openList.contains(state))
						{
							openList.add(state); 
							
						}else{
							openList.remove(state) ;
							state.setCost(calculateCost(n));
							state.setCameFrom(n);
							openList.add(state);
						}
					}
					
				}
		}
		System.out.println("7");
		return null;
		
	}
	
	/**
	 * This method is used state to calculate the cost
	 *@param s is the state we want to calculate the cost
	 * @return  double
	 */
	public double calculateCost(State<T> s)
	{
		if(s.getCameFrom() == null)
		{
			return 0;
		}
		else if(s.getCameFrom() != null)
		{
			return s.getCameFrom().getCost()+1;
		}
		return 0;
	}

}
	
