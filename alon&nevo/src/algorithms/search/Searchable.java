package algorithms.search;

import java.util.ArrayList;

public interface Searchable<T> {
	public State<T> getInitialstate();
	public State<T> getGoalState();
	public ArrayList<State<T>> getAllPossibleStates(State<T> s);

}
