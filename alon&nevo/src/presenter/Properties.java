package presenter;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Properties implements Serializable 
{
	private int numberOfThread;
	private String view;
	private String defultSolAlgo;
	private String algocreate;
	
	public Properties() 
	{
		this.numberOfThread = 10;
		this.view = "GUI";
		this.defultSolAlgo = "Bfs";
		this.algocreate = "simple";
	}	
	
	public String getAlgocreate() {
		return algocreate;
	}

	public void setAlgocreate(String algocreate) {
		this.algocreate = algocreate;
	}

	public int getNumberOfThread() 
	{
		return numberOfThread;
	}
	
	public void setNumberOfThread(int numberOfThread) 
	{
		this.numberOfThread = numberOfThread;
	}
	
	public String getView()
	{
		return view;
	}
	
	public void setView(String view)
	{
		this.view = view;
	}
	
	public String getDefultSolAlgo()
	{
		return defultSolAlgo;
	}
	
	public void setDefultSolAlgo(String defultSolAlgo) 
	{
		this.defultSolAlgo = defultSolAlgo;
	}
	
	
}
