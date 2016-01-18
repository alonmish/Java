package BootMVP;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import ViewMVP.CLI;
import ViewMVP.MazeWindow;
import ViewMVP.MyView;
import ViewMVP.SettingsWindow;
import algorithms.mazeGenerators.Postion;
import modelMVP.MyModel;
import presenter.Command;
import presenter.Dir;
import presenter.Display;
import presenter.DisplayCrossSectionBy;
import presenter.DisplaySolution;
import presenter.Exit;
import presenter.FileSize;
import presenter.Generate3DMaze;
import presenter.Hint;
import presenter.LoadMaze;
import presenter.MazeSize;
import presenter.Presenter;
import presenter.SaveMaze;
import presenter.SaveXML;
import presenter.Solve;

public class run {

	public static void main(String[] args) 
	{
		
		new File("alon");
		//System.out.println("plz enter the GUI/CLI and Bfs/Astar and simple/myAlogrithm");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter out = new PrintWriter(System.out);
				in = new BufferedReader(new InputStreamReader(System.in));
				MyView my = new MyView(out);
				MyModel mm = new MyModel();
				HashMap<String,Command> hm = new HashMap<String,Command>();
				hm.put("Dir", new Dir(mm));
				hm.put("Generate3DMaze", new Generate3DMaze(mm));
				hm.put("Display", new Display(mm));
				hm.put("DisplayCrossSectionBy", new DisplayCrossSectionBy(mm));
				hm.put("SaveMaze", new SaveMaze(mm));
				hm.put("LoadMaze", new LoadMaze(mm));
				hm.put("MazeSize", new MazeSize(mm));
				hm.put("FileSize", new FileSize(mm));
				hm.put("Solve", new Solve<Postion>(mm));
				hm.put("DisplaySolution", new DisplaySolution(mm));
				hm.put("Exit", new Exit(mm));
				hm.put("Hint", new Hint(mm));
				hm.put("SaveXML", new SaveXML(mm));
				SettingsWindow st= new SettingsWindow("Settings", 500, 300);
				Presenter p  = new Presenter(mm,hm,null,mm.getSt().getView());
				st.addObserver(p);
				st.run();
				System.out.println((mm.getSt().getView()));
				if(mm.getSt().getView().equals("CLI"))
				{
					System.out.println((mm.getSt().getView()));
					p = new Presenter(my,mm,hm,mm.getSt().getView());
					my.addObserver(p);
					mm.addObserver(p);
					CLI ci = new CLI(out,in,hm);
					ci.addObserver(p);
					ci.runCommand();
				}
				if(mm.getSt().getView().equals("GUI"))
				{
				
					System.out.println("IN");
					MazeWindow win=new MazeWindow("maze example", 500, 300);
					p = new Presenter(mm,hm,win,mm.getSt().getView());
					//Presenter p = new Presenter(mm,hm,null,choice[0]);
                   
					mm.addObserver(p);
					win.addObserver(p);
					
					
					win.run();
				}
				
				
		} /*catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	}


