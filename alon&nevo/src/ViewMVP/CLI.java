package ViewMVP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;
import presenter.Command;

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
		this.hm = new HashMap<String,Command>();
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
			@Override
			public void run()
			{
				Scanner s;
				String [] choise = new String[10];//all the command values and names don't go to 10 values
				int i = 0;
				do{
					System.out.println("Enter The commnad you want and its parameters (separated with backspace)");
					System.out.println("1) Dir: dir <path>");
					System.out.println("2) Generate3DMaze: generate_3d_maze <name> <x size> <y size> <z size> <algorithm: simple/myAlogrithm>");
					System.out.println("3) Display <name>");
					System.out.println("4) DisplayCrossSectionBy: display maze <name> section <index> in sector <x/y/z> ");
					System.out.println("5) SaveMaze: save maze<name> <file name>");
					System.out.println("6) LoadMaze: load maze <file name> <name> ");
					System.out.println("7) MazeSize: maze size <name>");
					System.out.println("8) FileSize: file size <name>");
					System.out.println("9) Solve: solve <name> <algorithm:Bfs/Astar>");
					System.out.println("10)DisplaySolution: display solution<name>");
					System.out.println("11)Exit: Shalom motherfuc*er");
					try{
					 s= new Scanner(in.readLine());
					 s.useDelimiter(" ");
					while(s.hasNext())
					{
						choise[i] = s.next();
						i++;
					}
					choise[i] = "CLI";
					    if(hm.containsKey(choise[0]))
					    {
					    	setChanged();
					    	notifyObservers(choise);
					    }
					}
					catch(IOException e){out.println("Enter valid Command");}
					i=0;
				}while(choise[0] != "exit");
			 
			}
		}).start();
	}
}
   
