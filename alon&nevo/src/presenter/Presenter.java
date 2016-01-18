package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import ViewMVP.CLI;
import ViewMVP.MazeWindow;
import ViewMVP.SettingsWindow;
import ViewMVP.View;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Postion;
import algorithms.search.Solution;
import modelMVP.Model;

public class Presenter implements Observer 
{
	private HashMap<String,Command> hs;
	private View v;
	private Model m;
	private MazeWindow mw;
	private String as;
	
	
	public Presenter(Model m)
	{
	 this.m =m;
	}
	public Presenter(Model m,HashMap<String,Command> hs, MazeWindow mw,String as) 
	{
		this.m=m;
		this.hs = new HashMap<String,Command>();
		this.hs.putAll(hs);
		this.mw = mw;
		this.as = as;
	    
	}
	
	public Presenter(View v,Model m,HashMap<String,Command> hs,String as) 
	{
		this.v=v;
		this.m=m;
		this.hs = new HashMap<String,Command>();
		this.hs.putAll(hs);
		this.as = as;
	}
	
	

	public View getV()
	{
		return v;
	}

	public void setV(View v)
	{
		this.v = v;
	}

	public Model getM() {
		return m;
	}

	public void setM(Model m)
	{
		this.m = m;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable arg0, Object arg1) 
	{
		if(arg0 instanceof CLI)
		{
			String s = ((String[])arg1)[0];
			String []cs = ((String[])arg1);
			arg1 = new Object();
			hs.get(s).doCommand(cs);
		}

		if(arg0 instanceof MazeWindow)
		{
			String s = ((String[])arg1)[0];
			String []cs = ((String[])arg1);
			arg1 = new Object();
			hs.get(s).doCommand(cs);
		}
		
		if(arg1 instanceof int[][])
		{
			v.PrintM2d((int[][])arg1);
		}
		if(arg1 instanceof String)
		{
			
			if(as.equals("CLI"))
				v.printToUser(arg1.toString());
			if(as.equals("GUI"))
			{
				if(arg0 instanceof SettingsWindow )
				 {
					m.changeXMLFile(arg1.toString());
					
				 }
				else
					mw.mb(arg1.toString());
			}
		}
		if(arg1 instanceof Maze3d)
		{
			if(as.equals("GUI"))
			{
				mw.m3d((Maze3d)arg1);
			}
		}
		if(arg1 instanceof Solution<?>)
		{
			for (int i = 0; i < ((Solution<Postion>)arg1).getS().size();i++) {
				System.out.println(((Solution<Postion>)arg1).getS().get(i).toString());
			}
			if(as.equals("GUI"))
			{
				mw.ss((Solution<Postion>)arg1);
			}
			if(as.equals("CLI"))
			{
				v.PrintStringArray((Solution<Postion>)arg1);
			}
		}
		
			if(arg1 instanceof Postion)
			{
				mw.hint((Postion)arg1);
			}
			if(arg0 instanceof SettingsWindow)
			{
			 
			 
			 if(arg1 instanceof Properties )
			 {
				 System.out.println("Good");
				 m.NewXml((Properties)arg1);
			 } 
			if(arg1 instanceof String[])
				{
				    String s = ((String[])arg1)[0];
					String []cs = ((String[])arg1);
					arg1 = new Object();
					hs.get(s).doCommand(cs);
				}
			}
			
			
		}
		
	}


