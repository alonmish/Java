package model;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.Postion;
import algorithms.search.SearchableAdapter;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import algorithms.search.State;
import controller.controller;

/**
 * this class is bring us all the calculate and put them in the HashMaps we have
 */
public class MyModel implements model 
{
	controller c;
	private HashMap<String, Maze3d> hm;
	private HashMap<String, Solution<Postion>> hms;
	
	/**
	 * this method is bring us the maze 2d in the line we want he used String (the maze)
	 * int (the index we want in the line) and char (what line)
	 * @param name is the name of the maze
	 * @param index is the number in the place
	 * @param is the line we want
	 * @return nothing
	 */
	public void getCrossBY(String name, int index,char place)
	{
		if(this.hm.containsKey(name))
		{
			try{
				switch(place){
				case 'x' : 
					c.PrintM2D(hm.get(name).getCrossSectionByX(index));
				case 'y' : 
					c.PrintM2D(hm.get(name).getCrossSectionByY(index));
				case 'z' : 
					c.PrintM2D(hm.get(name).getCrossSectionByZ(index));
				default :
					c.printToUser("enter x or y or z");
				}
				
			}catch(IndexOutOfBoundsException e){
				c.printToUser("the index is out of bounds");
			}
		}
	}
	
	/**
	 * this method prints us all the folders in the file to the controller
	 * @param f is the file we want to get all his folders
	 * @return nothing
	 */
	public void dir(File f) 
	{
		 String [] arr;
		 if(f.exists())
		 {
			 arr = f.list();
			 c.PrintStringArray(arr);
		 }
		 else
			 c.printToUser("The path " + f.getPath() + " is not exists");
	}
	
	/**
	 * this method is bring us the solution for String maze3d we want
	 * @param name is the name of the maze 3d
	 * @return nothing
	 */
	public void displaySolution(String name)
	{
		for (State<Postion> s: hms.get(name).getS()) 
		{
			c.printToUser(s.toString());	
		}
		
	}
	
	/**
	 * this method is print to user the maze by his name we want
	 * @param name is name of the maze 3d we want to display
	 * @return nothing
	 */
	public void display(String name)
	{
		c.printToUser(hm.get(name).toString());
	}
	
	/**
	 * this method is save the maze3d by the String we get in the file by the FileOutputStream we get
	 * @param name is the name of the maze 3d we want to save in the file
	 * @param fos is the FileOutputStream we used to save the maze
	 * @return nothing
	 */
	public void saveM3d(String name,FileOutputStream fos)
	{
		try {
			fos.write(hm.get(name).toByteArray());
		} catch (IOException e) {
			c.printToUser("fail to open a file");
		}
	}
	
	/**
	 * this method is load(bring us) the maze3d by the String we get in the file by the FileInputStream we get
	 * @param name is the name of the maze 3d we want to save in the file
	 * @param fis is the FileOutputStream we used to load the maze
	 * @return nothing
	 */
	public void loadM3d(FileInputStream fis, String name)
	{
		byte []b = new byte[127];//max length
		try {
			fis.read(b);
		} catch (IOException e) {
			c.printToUser("fail to open file");
		}
		hm.put(name,new Maze3d());
	}
	
	/**
	 * this method is bring us the size of the maze 3d in the memory by his name
	 * @param name is the name of maze 3d we want to get his size
	 * @return nothing
	 */
	public void mazeSize(String name)
	{
		//9 for start goal and sizes and 1 for size of x 1 for size y and 1 for size z
		c.printToUser((4*(9+(hm.get(name).getM3d().length)*(hm.get(name).getM3d()[0].length)*(hm.get(name).getM3d()[0][0].length)))+"");
	}
	
	/**
	 * this method is bring us the size of the maze 3d in the file by his name
	 * @param name is the name of maze 3d we want to get his size
	 * @return nothing
	 */
	public void fileMazeSize(String name)
	{
		c.printToUser(hm.get(name).toByteArray().length+"");
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
		hm.put(name, m3dG.generate(x, y, z));
		c.printToUser("maze <"+name+"> is ready");
	}
	
	/**
	 * this method is solve maze 3d with the algorithm from searcher and put in the hash map solver
	 * @param name is the name of the maze 3d
	 * @param s is the algorithm we want to solve the maze 3d with
	 * @return nothing
	 */
	@Override
	public void solveM3d(String name, Searcher<Postion> s)
	{
		hms.put(name+"Solution", s.search(new SearchableAdapter(hm.get(name))));
	}
	
	/**
	 * finish all the program and taking care of closing all of the 
	 * Thread and files
	 * @return nothing
	 */
	@Override
	public void exit()
	{
		System.exit(0);
	}
	

}
