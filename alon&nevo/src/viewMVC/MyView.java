package viewMVC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.Postion;
import algorithms.search.Searcher;
import algorithms.search.State;
//import controller.Command;
import controller.controller;

/**
 * this class is view the user all we want from the controller
 */
public class MyView implements view {
	controller c;
	private PrintWriter out;
	//private BufferedReader in;
	//private CLI cli;
	
	public MyView()
	{
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * this method the constructor for put in our values what we get
	 * @param c is the controller to put in our
	 * @param out is the print writer to put in our
	 * @param in is the bufferedReader to put in our
	 * @return nothing
	 */
	public MyView(controller c,PrintWriter out,BufferedReader in) 
	{
		this.c = c;
		//this.in = in;
		this.out = out;
	    //this.cli = new CLI(out, in);
	}
	
	/**
	 * this method is go to the controller to do this function by String int and char
	 * @param name is the name of maze 3d we want to do the function on
	 * @param index is the index line we want to do
	 * @param place is the line we want to do on
	 * @return nothing
	 */
	public void getCrossBY(String name, int index,char place)
	{
		c.getCrossBY(name, index, place);
	}
	
	/**
	 * this method is print to user the String he gets
	 * @param str is the string to print to user
	 * @return nothing
	 */
	public void printToUser(String str) 
	{
		out.println(str);
		out.flush();
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
	 * this method is print to user the maze 3d we have
	 * @param m3d is the maze 3d we have to print
	 * @return nothing
	 */
	public void printM3d(Maze3d m3d) 
	{
		for (int i = 0; i < m3d.getM3d().length; i++) {
				out.println();
				out.flush();
			for (int j = 0; j < m3d.getM3d()[0].length; j++) {
				out.println();
				out.flush();
				for (int z = 0; z < m3d.getM3d()[0][0].length; z++) {
					out.print(m3d.getM3d()[i][j][z]);
					out.flush();
				}
			}
		}
		out.println();
		out.flush();
	}
	
	/**
	 * this method is print to user the ArrayList<String> he get
	 * @param arr1 is the ArrayList<String> we want to print
	 * @return nothing
	 */
	public void printStringArrayList(ArrayList<String> arrl)
	{
		for(String str : arrl){
			out.println(str);
			out.flush();
		}
			
	}
	
	/**
	 * this method is print the solution from the ArrayList<state<Postion>> he have
	 * @param als is the ArrayList<State<Position>> from where to print
	 * @return nothing
	 */
	public void printSolution(ArrayList<State<Postion>> als) 
	{
		for(State<Postion> st : als){
			out.println(st.getState());
			out.flush();
		}
	}
	
	/**
	 * this method prints us all the folders in the file to the controller
	 * @param f is the file we want to get all his folders
	 * @return nothing
	 */
	public void dir(File f) 
	{
		c.dir(f);
	}
	
	/**
	 * this method is go to the controller to bring us the solution from the name of the maze 3d
	 * from the controller
	 * @param name is the name of the maze 3d we want to print the solution
	 * @return nothing
	 */
	public void displaySolution(String name)
	{
		c.displaySolution(name);
	}
	
	/**
	 * this method is bring us the mazes 3d from the controller from the name of the maze 3d we want
	 * from the controller
	 * @param name is the name of the maze 3d we want to print
	 * @return nothing
	 */
	public void display(String name)
	{
		c.display(name);
	}
	
	/**
	 * this method is save us the maze 3d by his name in the File 
	 * from the controller
	 * @param name is the name of the maze 3d we want to save in the file
	 * @param fos is how we save in the file
	 * @return nothing
	 */
	public void saveM3d(String name,FileOutputStream fos)
	{
		c.saveM3d(name, fos);
	}
	
	/**
	 * this method is load(bring us) the maze 3d by his name from the File 
	 * from the controller
	 * @param name is the name of the maze 3d we want to load from the file
	 * @param fos is how we load from the file
	 * @return nothing
	 */
	public void loadM3d(FileInputStream fis, String name)
	{
		c.loadM3d(fis, name);
	}
	
	/**
	 * this method is bring us the size of the maze 3d in the memory by his name 
	 * from the controller
	 * @param name is the name of maze 3d we want to get his size
	 * @return nothing
	 */
	public void mazeSize(String name)
	{
		c.mazeSize(name);
	}
	
	/**
	 * this method is bring us the size of the maze 3d in the file by his name 
	 * from the controller
	 * @param name is the name of maze 3d we want to get his size
	 * @return nothing
	 */
	public void fileMazeSize(String name)
	{
		c.fileMazeSize(name);
	}
	
	/**
	 * this method is create a maze 3d and put it in the hash map with the controller
	 * @param name is the name of the maze 3d
	 * @param x is the size of x line
	 * @param y is the size of y line
	 * @param z is the size of z line
	 * @param m3dG is how we create the maze
	 * @param return nothing
	 */
	@Override
	public void generateM3d(String name, int x, int y, int z, Maze3dGenerator m3dG)
	{
		c.generateM3d(name, x, y, z, m3dG);
	}
	
	/**
	 * this method is solve maze 3d with the algorithm from searcher and
	 * bring it to the controller
	 * @param name is the name of the maze 3d
	 * @param s is the algorithm we want to solve the maze 3d with
	 * @return nothing
	 */
	@Override
	public void solveM3d(String name, Searcher<Postion> s) 
	{
		c.solveM3d(name, s);
	}
	
	/**
	 * finish all the program and taking care of closing all of the 
	 * Thread and files
	 * @return nothing
	 */
	@Override
	public void exit()
	{
		this.c.exit();
	}
	
	/**
	 * this method prints us the string array
	 * @param arr is the string array
	 * @return nothing
	 */
	@Override
	public void PrintStringArray(String[] arr)
	{
		for(String s : arr){
			this.printToUser(s);
		}
	}

}
