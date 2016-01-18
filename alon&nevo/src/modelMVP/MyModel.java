package modelMVP;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Postion;
import algorithms.mazeGenerators.SimpleMaze3dGenerator;
import algorithms.search.Astar;
import algorithms.search.Bfs;
import algorithms.search.CommonSearcher;
import algorithms.search.CostComp;
import algorithms.search.MazeDistanse;
import algorithms.search.SearchableAdapter;
import algorithms.search.Solution;
import presenter.Properties;

public class MyModel extends Observable implements Model
{
	private HashMap<String, Maze3d> hm;
	private HashMap<String, Solution<Postion>> hms;
	private HashMap<Maze3d, Solution<Postion>> hmsm;
	private ExecutorService ex;
	private Properties st;

	public MyModel() 
	{
		this.hm = new HashMap<String, Maze3d>();
		this.hms = new HashMap<String, Solution<Postion>>();
		this.hmsm= new HashMap<Maze3d, Solution<Postion>>();
	    this.ex= Executors.newFixedThreadPool(10);
	    this.st= new Properties();
	    /*ObjectInputStream o;
		try {
			o = new ObjectInputStream(new GZIPInputStream(new FileInputStream("MSHM")));
			try {
				this.hmsm = (HashMap<Maze3d, Solution<Postion>>)o.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public Properties getSt() {
		return st;
	}

	public void setSt(Properties st) {
		this.st.setAlgocreate(st.getAlgocreate());
		this.st.setDefultSolAlgo(st.getDefultSolAlgo());
		this.st.setNumberOfThread(st.getNumberOfThread());
		this.st.setView(st.getView());
	}

	public HashMap<String, Maze3d> getHm() 
	{
		return hm;
	}
	
	
	/**
	 * this method prints us all the folders in the file to the controller
	 * @param f is the file we want to get all his folders
	 * @return nothing
	 */
	@Override
	public void dir(File f,String s) 
	{
		String [] arr;
		 if(f.exists())
		 {
			 arr = f.list();
			 setChanged();
			 notifyObservers(arr.toString());
		 }
		 else
		 {
			 setChanged();
			 notifyObservers("The path " + f.getPath() + " is not exists");
		 }
	}
	
	/**
	 * this method is bring us the maze 2d in the line we want he used String (the maze)
	 * int (the index we want in the line) and char (what line)
	 * @param name is the name of the maze
	 * @param index is the number in the place
	 * @param is the line we want
	 * @return nothing
	 */
	@Override
	public void getCrossBY(String name, int index, char place,String s) 
	{
		if(this.hm.containsKey(name))
		{
			try{
				switch(place){
				case 'x' : 
				{
					setChanged();
					notifyObservers(hm.get(name).getCrossSectionByX(index));
					break;
				}
				case 'y' : 
				{
					setChanged();
					notifyObservers(hm.get(name).getCrossSectionByY(index));
					break;
				}
				case 'z' : 
				{
					setChanged();
					notifyObservers(hm.get(name).getCrossSectionByZ(index));
					break;
				}
				default :
				{
					setChanged();
					notifyObservers("wrong char");
					break;
				}
				}
				
			}catch(IndexOutOfBoundsException e){
				setChanged();
				notifyObservers("fail1");
			}
		}
		else if(!hm.containsKey(name))
		{
			setChanged();
			notifyObservers("their is no name you ask to do it");
		}
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
	public void generateM3d(String name, int x, int y, int z,String s) 
	{
		if(!hm.containsKey(name))
		{
			Future <Maze3d> f= ex.submit(new Callable<Maze3d>()
			{
				@Override
				public Maze3d call()
				{
			 		 Maze3dGenerator m3dG;
			         if(st.getAlgocreate().equals("Simple"))
						 m3dG= new SimpleMaze3dGenerator();
					else
						 m3dG= new MyMaze3dGenerator();
			        Maze3d m = m3dG.generate(x, y, z);
					hm.put(name, m);
					hmsm.put(m, null);
					return m;
				}
			});
				try {
					if(s.equals("GUI"))
					{
						setChanged();
					notifyObservers(f.get());
					}
				if(s.equals("CLI"))
				{
					setChanged();
					notifyObservers("the maze <"+name+"> is ready");
				}
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else if(hm.containsKey(name))
		{
			setChanged();
			notifyObservers("The maze is already exist");
		}	    
	}
	
	/**
	 * this method is print to user the maze by his name we want
	 * @param name is name of the maze 3d we want to display
	 * @return nothing
	 */
	@Override
	public void display(String name,String s) 
	{
		if(hm.containsKey(name))
		{
			setChanged();
			notifyObservers(hm.get(name)+"");
		}
		else if(!hm.containsKey(name))
		{
			setChanged();
			notifyObservers("their is no maze you want to display");
		}
	}
	
	/**
	 * this method is save the maze3d by the String we get in the file by the FileOutputStream we get
	 * @param name is the name of the maze 3d we want to save in the file
	 * @param fos is the FileOutputStream we used to save the maze
	 * @return nothing
	 */
	@Override
	public void saveM3d(String name, FileOutputStream fos,String s) 
	{
		if(hm.containsKey(name))
		{
			try {
				fos.write(hm.get(name).toByteArray());
				setChanged();
				notifyObservers("the maze <"+name+">save succ");
			} catch (IOException e) {
				setChanged();
				notifyObservers("fail to open a file");
			}
		}
		else if(!hm.containsKey(name))
		{
			setChanged();
			notifyObservers("The name contains plz choose another name");
		}
	}
	
	/**
	 * this method is load(bring us) the maze3d by the String we get in the file by the FileInputStream we get
	 * @param name is the name of the maze 3d we want to save in the file
	 * @param fis is the FileOutputStream we used to load the maze
	 * @return nothing
	 */
	@Override
	public void loadM3d(FileInputStream fis, String name,String s) 
	{
		byte []b = new byte[100000];//max length
		try {
			fis.read(b);
			hm.put(name, new Maze3d(b));
			setChanged();
			notifyObservers(hm.get(name));
		} catch (IOException e) {
			setChanged();
			notifyObservers("fail to open file");
		}
	}
	
	/**
	 * this method is bring us the size of the maze 3d in the memory by his name
	 * @param name is the name of maze 3d we want to get his size
	 * @return nothing
	 */
	@Override
	public void mazeSize(String name,String s) 
	{
		if(hm.containsKey(name))
		{
			//9 for start goal and sizes and 1 for size of x 1 for size y and 1 for size z
			setChanged();
			notifyObservers((4*(9+(hm.get(name).getM3d().length)*(hm.get(name).getM3d()[0].length)*(hm.get(name).getM3d()[0][0].length)))+"");
		}
		else if(!hms.containsKey(name))
		{
			setChanged();
			notifyObservers("their is no name you want");
		}
	}
	
	/**
	 * this method is bring us the size of the maze 3d in the file by his name
	 * @param name is the name of maze 3d we want to get his size
	 * @return nothing
	 */
	@Override
	public void fileMazeSize(String name,String s) 
	{
		if(hm.containsKey(name))
		{
			setChanged();
			notifyObservers(hm.get(name).toByteArray().length+"");
		}
		else if(!hms.containsKey(name))
		{
			setChanged();
			notifyObservers("their is no name you want");
		}
			
	}
	
	/**
	 * this method is solve maze 3d with the algorithm from searcher and put in the hash map solver
	 * @param name is the name of the maze 3d
	 * @param s is the algorithm we want to solve the maze 3d with
	 * @return nothing
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void solveM3d(String name,String as)
	{
		if(hm.containsKey(name))
		{
			
			if(hmsm.get(hm.get(name))==null)
			{
				Future <Solution<Postion>> f = ex.submit(new Callable<Solution<Postion>>() {

					@Override
					public Solution<Postion> call() throws Exception {
						CommonSearcher<Postion> s;
						if(st.getDefultSolAlgo().equals("Bfs"))
							s=new Bfs<Postion>(new CostComp<Postion>());
						else
							s=new Astar<Postion>(new MazeDistanse(), new CostComp<Postion>());
						Solution<Postion> a = new Solution<Postion>();
						a = s.search(new SearchableAdapter(hm.get(name)));
						hms.put(name, a);
						hms.put(name+"Solution",a);
						hmsm.put(hm.get(name),a);
						return a;
					}
				});
					try {
						if(as.equals("GUI"))
						{
							setChanged();
							notifyObservers(f.get());
						}
						if(as.equals("CLI"))
						{
							setChanged();
							notifyObservers("Solution for the maze < "+name+" > is ready");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
			else if(hmsm.get(hm.get(name)) != null)
			 {
				if(as.equals("GUI"))
				{
					setChanged();
					notifyObservers(hmsm.get(hm.get(name)));
				}
				if(as.equals("CLI"))
				{
					setChanged();
					notifyObservers("Solution for the maze <"+name+"> is already exist");
				}

			 }
		else
		{
			setChanged();
			notifyObservers("The maze dosen't exist");
		}
		
		
	}
	
	/**
	 * this method is bring us the solution for String maze3d we want
	 * @param name is the name of the maze 3d
	 * @return nothing
	 */
	@Override
	public void displaySolution(String name,String s) 
	{
		if(hms.containsKey(name))
		{
			setChanged();
			notifyObservers(hms.get(name).getS());
		}
		else if(!hms.containsKey(name))
		{
			setChanged();
			notifyObservers("their is no name that you want");
		}
	}
	
	/**
	 * this methods try to get hint to the maze
	 * @param name is the name of the maze
	 * @param s is the algo we want to solve the maze with
	 * @param p is the position we are in the maze
	 * @return  nothing
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public void hint(String name, Postion p)
	{
		
		if(hm.containsKey(name))
		{
			if(hmsm.get(hm.get(name))==null)
			{
				Future <Postion> f = ex.submit(new Callable<Postion>() {

					@Override
					public algorithms.mazeGenerators.Postion call() throws Exception {
						CommonSearcher<Postion> s;
						if(st.getDefultSolAlgo().equals("Bfs"))
							s=new Bfs<Postion>(new CostComp<Postion>());
						else
							s=new Astar<>(new MazeDistanse(), new CostComp<Postion>());
						Solution<Postion> a = new Solution<Postion>();
						a = s.search(new SearchableAdapter(hm.get(name)));
						hms.put(name+"Solution", a);
						Postion p1 = new Postion(dis(p,a));
						setChanged();
						notifyObservers(p1);
						return p1;
					}
				});	 
			}
			else if(hmsm.get(hm.get(name)) != null)
			 {
				setChanged();
				notifyObservers(dis(p,hmsm.get(hm.get(name))));
			 }
		}
		else
		{
			setChanged();
			notifyObservers("The maze dosen't exist");
		}
	}
	
	/**
	 * this methods give us the smallest distance to the postion in solve
	 * @param x is the postions to solve
	 * @param p is the postion we are now
	 * @return  nothing
	 */
	public Postion dis(Postion p,Solution<Postion> x)
	{
		Postion a = new Postion(x.getS().get(0).getState());
		Postion b = new Postion(a);
		int sum = Math.abs(a.getX()-p.getX())+Math.abs(a.getY()-p.getY())+Math.abs(a.getZ()-p.getZ());
		for (int i = 0; i < x.getS().size(); i++) {
			a = new Postion(x.getS().get(x.getS().size()-i-1).getState());
			if(((Math.abs(a.getX()-p.getX())+Math.abs(a.getY()-p.getY())+Math.abs(a.getZ()-p.getZ())) < sum)&& !p.equals(a))
			{
				b = new Postion(a);
				sum = Math.abs(a.getX()-p.getX())+Math.abs(a.getY()-p.getY())+Math.abs(a.getZ()-p.getZ());
			}
		}
		return b;
	}
	/**
	 * close the program
	 * @return  nothing
	 */
	@Override
	public void exit() 
	{
		/*try {
			ObjectOutputStream o = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("MSHM")));
			o.writeObject(this.hmsm);
			o.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}*/
		System.exit(0);
	}
	public void putM(Maze3d m)
	{
		
	}
	
	/**
	 * give us the information to the xml file
	 * @param name is the name of the maze
	 * @return  nothing
	 */
	@Override
	public void changeXMLFile(String name) {
			System.out.println(2);
			Properties properties ; 
			XMLDecoder read = null;
			try {
				read = new XMLDecoder(new FileInputStream(name));
				properties = (Properties)read.readObject() ;
				/*int numberOfThread = properties.getNumberOfThread();
				String defultSolAlgo = properties.getDefultSolAlgo() ;*/
				setSt(properties);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			finally{
				read.close(); 
			}
		}

	@Override
	public void NewXml(Properties st) 
	{
	  	setSt(st);
		

	  	
	}
	@Override
	 public void SaveXML(String name)
	{
	  try {
		XMLEncoder write = new XMLEncoder(new FileOutputStream(name));
		write.writeObject(st);
		write.flush();
		write.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		
	}
	  	
	}
		
	}
