package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.Postion;
import algorithms.search.Searcher;

public interface model 
{
	public void dir(File dir);
	public void getCrossBY(String name, int index,char place);
	public void generateM3d(String name,int x,int y,int z,Maze3dGenerator m3dG);
	public void display(String name);
	public void saveM3d(String name,FileOutputStream fos);
	public void loadM3d(FileInputStream fis, String name);
	public void mazeSize(String name);
	public void fileMazeSize(String name);
	public void solveM3d(String name,Searcher<Postion> s);
	public void displaySolution(String name);
	public void exit();

}
