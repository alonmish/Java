package ViewMVP;

import algorithms.mazeGenerators.Postion;
import algorithms.search.Solution;

public interface View 
{
	public void PrintStringArray(Solution<Postion> arr);
	public void printToUser(String str);
	public void PrintM2d(int [][] m2d);
}
