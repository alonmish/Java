package algorithms.search;

import java.util.Comparator;

/**
 * This class is compare costs
 * @return  nothing
 */
public class CostComp<T> implements Comparator<State<T>>
{
	/**
	 * Default C'tor
	 */
	public CostComp() {
	}
	/**
	 * This method compare two costs
	 * @param s1 the first cost
	 * @param s2 the second cost
	 * @return  int
	 */
	@Override
	public int compare(State<T> s1 , State<T> s2)
	{
		if(s1.getCost() < s2.getCost())
			return -1;
		else if(s1.getCost() == s2.getCost())
			return 0;
		else
			return 1;
	}
	
}
