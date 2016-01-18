package modelMVP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.Postion;
import algorithms.search.CommonSearcher;
import presenter.Properties;

public interface Model 
{
	public void dir(File dir,String s);
	public void getCrossBY(String name, int index,char place,String s);
	public void generateM3d(String name,int x,int y,int z,String s);
	public void display(String name,String s);
	public void saveM3d(String name,FileOutputStream fos,String s);
	public void loadM3d(FileInputStream fis, String name,String s);
	public void mazeSize(String name,String s);
	public void fileMazeSize(String name,String s);
	public void solveM3d(String name,String as);
	public void displaySolution(String name,String s);
	public void exit();
	public HashMap<String, Maze3d> getHm();
	public void changeXMLFile(String name);
	public void hint(String name,Postion p);
    public void NewXml(Properties st);
    public void SaveXML(String name);
}
