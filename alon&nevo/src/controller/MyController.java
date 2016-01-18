package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.Postion;
import algorithms.search.Searcher;
import algorithms.search.State;
import model.model;
import viewMVC.view;

/**
 * this class is the connection from the view to the user
 * and the model(the brain of the process)
 */
public class MyController implements controller {
	private model m;
	private view v;
	
	public MyController(model m,view v) 
	{
		this.v = v;
		this.m = m;
	}
	
	/**
	 * This method is used model to put in our model
	 * @param m is the model we get
	 * @return  nothing
	 */
	public void setM(model m) {
		this.m = m;
	}

	/**
	 * This method is used view to put in our view
	 * @param m is the view we get
	 * @return  nothing
	 */
	public void setV(view v) {
		this.v = v;
	}
	
	/**
	 * this method is print to user the maze 3d we have
	 * from the view
	 * @param m3d is the maze 3d we have to print
	 * @return nothing
	 */
	public void printM3d(Maze3d m3d) 
	{
		v.printM3d(m3d);
	}
	
	/**
	 * this method is print to user the ArrayList<String> he get
	 * from the view
	 * @param arr1 is the ArrayList<String> we want to print
	 * @return nothing
	 */
	public void printStringArrayList(ArrayList<String> arrl)
	{
		v.printStringArrayList(arrl);
			
	}
	
	/**
	 * this method is print the solution from the ArrayList<state<Postion>> he have
	 * from the view
	 * @param als is the ArrayList<State<Position>> from where to print
	 * @return nothing
	 */
	public void printSolution(ArrayList<State<Postion>> als) 
	{
		v.printSolution(als);
	}
	
	/**
	 * this method is print to user the String he gets
	 * from the view
	 * @param str is the string to print to user
	 * @return nothing
	 */
	public void printToUser(String str) {
		v.printToUser(str);
	}
	
	/**
	 * this method is print to user the maze 2d he get
	 * from the view
	 * @param m2d is the maze 2d to print
	 * @return nothing
	 */
	public void PrintM2D(int [][] m2d)
	{
		v.PrintM2d(m2d);
	}
	
	
	public void getCrossBY(String name, int index,char place)
	{
		m.getCrossBY(name, index,place);
	}
	
	/**
	 * this method is go to the model to do this function by String int and char
	 * @param name is the name of maze 3d we want to do the function on
	 * @param index is the index line we want to do
	 * @param place is the line we want to do on
	 * @return nothing
	 */
	public void dir(File dir) 
	{
		m.dir(dir);
	}
	
	/**
	 * this method is go to the model to bring us the solution from the name of the maze 3d
	 * from the model
	 * @param name is the name of the maze 3d we want to print the solution
	 * @return nothing
	 */
	public void displaySolution(String name)
	{
		m.displaySolution(name);
	}
	
	/**
	 * this method is bring us the mazes 3d from the controller from the name of the maze 3d we want
	 * from the model
	 * @param name is the name of the maze 3d we want to print
	 * @return nothing
	 */
	public void display(String name)
	{
		m.display(name);
	}
	
	/**
	 * this method is save us the maze 3d by his name in the File 
	 * from the model
	 * @param name is the name of the maze 3d we want to save in the file
	 * @param fos is how we save in the file
	 * @return nothing
	 */
	public void saveM3d(String name,FileOutputStream fos)
	{
		m.saveM3d(name, fos);
	}
	
	/**
	 * this method is load(bring us) the maze 3d by his name from the File 
	 * from the model
	 * @param name is the name of the maze 3d we want to load from the file
	 * @param fos is how we load from the file
	 * @return nothing
	 */
	public void loadM3d(FileInputStream fis, String name)
	{
		m.loadM3d(fis, name);
	}
	
	/**
	 * this method is bring us the size of the maze 3d in the memory by his name 
	 * from the model
	 * @param name is the name of maze 3d we want to get his size
	 * @return nothing
	 */
	public void mazeSize(String name)
	{
		m.mazeSize(name);
	}
	
	/**
	 * this method is bring us the size of the maze 3d in the file by his name 
	 * from the model
	 * @param name is the name of maze 3d we want to get his size
	 * @return nothing
	 */
	public void fileMazeSize(String name)
	{
		m.fileMazeSize(name);
	}
	
	/**
	 * this method is create a maze 3d and put it in the hash map with the model
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
		m.generateM3d(name, x, y, z, m3dG);
	}
	
	/**
	 * this method is solve maze 3d with the algorithm from searcher and
	 * bring it to the model
	 * @param name is the name of the maze 3d
	 * @param s is the algorithm we want to solve the maze 3d with
	 * @return nothing
	 */
	@Override
	public void solveM3d(String name, Searcher<Postion> s)
	{
		m.solveM3d(name, s);
	}
	
	/**
	 * finish all the program and taking care of closing all of the 
	 * Thread and files
	 * @return nothing
	 */
	@Override
	public void exit()
	{
		this.m.exit();
	}
	
	/**
	 * this method prints us the string array from the view
	 * @param arr is the string array
	 * @return nothing
	 */
	@Override
	public void PrintStringArray(String[] arr) 
	{
		v.PrintStringArray(arr);
	}
	
	

}
