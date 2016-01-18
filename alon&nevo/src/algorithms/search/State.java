package algorithms.search;

/**
 * This class is the state for the maze
 * @return  nothing
 */
public class State<T> {
	private T state;
	private double cost;
	private State<T> cameFrom;
	
	/**
	 * This method is contractor that used T state
	 * @param state is the state we want to put in the state class
	 * @return  nothing
	 */
	public State(T state)
	{
		this.state = state;
		this.cost = -1;
		this.cameFrom = null;
	}
	
	public String toString()
	{
		return this.state.toString();
	}
	
	/**
	 * This method is contractor that used state
	 * @param s is the state we want to put in the state class where he have cost and camefrom
	 * @return  nothing
	 */
	public State(State<T> s) 
	{
		 this.state = s.state ;
		 this.cost = s.cost ;
		 this.cameFrom = s.cameFrom ;
		
	}
	
	/**
	 * This method is the get of the state
	 * @return  T
	 */
	public T getState() 
	{
		return state;
	}
	
	/**
	 * This method is the set of the T state that used T state
	 * @return  nothing
	 */
	public void setState(T state)
	{
		this.state = state;
	}
	
	/**
	 * This method is the get of the state cost
	 * @return  double
	 */
	public double getCost() 
	{
		return cost;
	}
	
	/**
	 * This method is the set of the state cost he used double to set it
	 * @param cost is the cost we want to set
	 * @return  nothing
	 */
	public void setCost(double cost) 
	{
		this.cost = cost;
	}
	
	/**
	 * This method is the get from where the state came from
	 * @return  State
	 */
	public State<T> getCameFrom() 
	{
		return cameFrom;
	}
	
	/**
	 * This method is the set that where the state came from he used State to do it
	 * @param camefrom is where the state came from
	 * @return  nothing
	 */
	public void setCameFrom(State<T> cameFrom) 
	{
		this.cameFrom = cameFrom;
	}
	
	/**
	 * This method is to check if the state equals with object
	 * @param obj what we want to check if it equals
	 * @return  boolean
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == this.getClass()) 
		{
			return state.equals(((State<T>)obj).state);
		}
		return false ;
	}
	
	/**
	 * This method is to check if the state equals with state
	 * @param s what we want to check if it equals
	 * @return  boolean
	 */
	public boolean equals(State<T> s)
	{
		return this.state.equals(s.state);
		/*if(s.state == this.state)
			return true;
		return false;*/
	}

}
