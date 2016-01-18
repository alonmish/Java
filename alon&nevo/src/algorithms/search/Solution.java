package algorithms.search;

import java.util.ArrayList;

/**
 * This class is all the solutions we have
 * @param s all the solutions
 * @return  nothing
 */
public class Solution<T> {
	private ArrayList<State<T>> s;
	
	/**
	 * This method is default contractor for solution
	 * @return  nothing
	 */
	public Solution()
	{
		this.s = null;
	}
	public String[] toStringArray()
	{
		String[] st= new String[this.getS().size()];
		for (int i = 0; i < st.length; i++) 
		{
			st[i]=this.getS().get(i).toString();
		}
		return st;
	}
	
	
	/**
	 * This method is the contractor that give as all the solution with arraylist
	 * @param s is the arraylist of the solutions
	 * @return  nothing
	 */
	public Solution(ArrayList<State<T>> s)
	{
		this.s = s;
	}
	
	/**
	 * This method is the get of the arraylist of solution
	 * @return  ArrayList
	 */
	public ArrayList<State<T>> getS() {
		return s;
	}
	
	/**
	 * This method is the set of of the ArrayList of the solutions
	 * @return  nothing
	 */
	public void setS(ArrayList<State<T>> s) {
		this.s = s;
	}
	

}
