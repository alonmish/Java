package viewMVC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.Postion;
import algorithms.search.Searcher;
import algorithms.search.State;

public interface view 
{
	public void dir(File dir);
	public void printToUser(String str);
	public void PrintM2d(int [][] m2d);
	public void getCrossBY(String name, int index,char place);
	public void generateM3d(String name,int x,int y,int z,Maze3dGenerator m3dG);
	public void display(String name);
	public void saveM3d(String name,FileOutputStream fos);
	public void loadM3d(FileInputStream fis, String name);
	public void mazeSize(String name);
	public void fileMazeSize(String name);
	public void displaySolution(String name);
	public void exit();
	public void printM3d(Maze3d m3d);
	public void printStringArrayList(ArrayList<String> arrl);
	public void printSolution(ArrayList<State<Postion>> als);
	public void PrintStringArray(String[] arr);
	public void solveM3d(String name, Searcher<Postion> s);
}
