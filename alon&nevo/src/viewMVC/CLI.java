package viewMVC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;

import controller.Command;

/**
 * this class is the graphic user interface
 * @return nothing
 */
public class CLI extends Observable
{
	private HashMap<String,Command> hm;
	private PrintWriter out;
	private BufferedReader in;
	
	/**
	 * in the constructor we use print writer and buffered reader
	 * to put in ours
	 * @param out is the print writer we put
	 * @param in is the buffered reader we put
	 * @return nothing
	 */
	public CLI(PrintWriter out , BufferedReader in,HashMap<String,Command> hm)
	{
		this.in = new BufferedReader(in);
		this.out = new PrintWriter(out);
		this.hm.putAll(hm);
	}
	
	public CLI(BufferedReader in)
	{
		this.in = in;
	}
	
	/**
	 * this function run the command the user chose to do
	 * @return nothing
	 */
	public void runCommand()  
	{
		new Thread(new Runnable(){
			@SuppressWarnings("null")
			@Override
			public void run()
			{
				Scanner s;
				ArrayList<String> choise = null;
				String [] st = null;			
				do{
					System.out.println("Enter The commnad you want and its parameters (separated with backspace)");
					System.out.println("1) dir: dir <path>");
					System.out.println("2) generate: generate_3d_maze <name> <x size> <y size> <z size> <algorithm: simple/myAlogrithm>");
					System.out.println("3) display <name>");
					System.out.println("4) display_cross: display maze <name> section <index> in sector <x/y/z> ");
					System.out.println("5) save_maze: save maze<name> <file name>");
					System.out.println("6) load_maze: load maze <file name> <name> ");
					System.out.println("7) maze_size: maze size <name>");
					System.out.println("8) fie_size: file size <name>");
					System.out.println("9) solve: solve <name> <algorithm:Bfs/Astar>");
					System.out.println("10)display_solution: display solution<name>");
					System.out.println("11)exit: Shalom motherfuc*er");
					try{
					 s= new Scanner(in.readLine());
					 s.useDelimiter(" ");
					while(s.hasNext())
						choise.add(s.next());
					    if(hm.containsValue(choise.get(0)))
					    {
					    	choise.remove(0);
					    	hm.get(choise.get(0)).doCommand(choise.toArray(st));
					    }
					}
					catch(IOException e){out.println("Enter valid Command");}
					
				}while(choise.contains("exit"));
			 
			}
		}).start();
	}
}
   
