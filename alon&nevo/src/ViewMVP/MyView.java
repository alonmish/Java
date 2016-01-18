package ViewMVP;

import java.io.PrintWriter;
import java.util.Observable;

import algorithms.mazeGenerators.Postion;
import algorithms.search.Solution;

public class MyView extends Observable implements View 
{
	private PrintWriter out;

	public MyView(PrintWriter out)
	{
		this.out = out;
	}
	
	/**
	 * this method is print to user the maze 2d he get
	 * @param m2d is the maze 2d to print
	 * @return nothing
	 */
	public void PrintM2d(int [][] m2d)
	{
		this.out.println();
		for(int [] arr : m2d){
			for(int i : arr){
				out.print(i);
				out.flush();
			}
				out.println();
				out.flush();
		}
		out.println();
		out.flush();
	}
	
	/**
	 * this method prints us the string array
	 * @param arr is the string array
	 * @return nothing
	 */
	@Override
	public void PrintStringArray(Solution<Postion> arr) 
	{
		for (int i = 0; i < arr.getS().size(); i++) {
			printToUser(arr.getS().get(arr.getS().size()-i-1).toString());
		}
	}
	
	/**
	 * this method is print to user the String he gets
	 * @param str is the string to print to user
	 * @return nothing
	 */
	@Override
	public void printToUser(String str) 
	{
		out.println(str);
		out.flush();
	}
}
