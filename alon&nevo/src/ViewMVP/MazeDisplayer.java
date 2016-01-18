package ViewMVP;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Postion;


// this is (1) the common type, and (2) a type of widget
// (1) we can switch among different MazeDisplayers
// (2) other programmers can use it naturally
public abstract class MazeDisplayer extends Canvas{
	
	
	int[][] mazeData2D={
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	};
	 Maze3d m3d;
	 String nameMaze;

	 /**
	   * This function is used one int
	   * he bring as the maze 2d with the index in the x line
	   * @param int index
	   * @return int[][]
	   */
	public int[][] getMaze2Dsector(int index)
	{
		int [][] Sec= new int [this.m3d.getM3d()[0].length][this.m3d.getM3d()[0][0].length];
    	if(index<0||index>(this.m3d.getM3d()[0][0].length))
    		  throw new IndexOutOfBoundsException();
      else
      {
    	 for (int i = 0; i < (Sec.length); i++) 
              for (int j = 0; j < Sec[0].length; j++) 
              {
				Sec[i][j]=this.m3d.getM3d()[index][i][j];
			  }
      }
      return Sec;  
	}
	
	/**
	   *bring us the maze 2d
	   * @return int[][]
	   */
	public int[][] getMazeData2D() {
		return mazeData2D;
	}
	
	/**
	   * set the maze 2d
	   * @param mazeDate2d is the maze we wwant to set
	   * @return nothing
	   */
	public void setMazeData2D(int[][] mazeData2D) {
		this.mazeData2D = mazeData2D;
		this.getDisplay().asyncExec(new Runnable() {
			
			@Override
			public void run()
			{
				redraw();
			}
		});
	}
	

	/**
	   *bring us the maze name
	   * @return string
	   */
	public String getnameMaze() {
		return nameMaze;
	}
	

	/**
	   *set the maze name
	   *@param nameMaze is the name we want to put
	   * @return nothing
	   */
	public void setnameMaze(String nameMaze) {
		this.nameMaze = nameMaze;
	}

	public MazeDisplayer(Composite parent, int style)
	{
		super(parent, SWT.DOUBLE_BUFFERED);
	}
	
	/**
	   *set the maze 3d
	   *@param m3d is the maze we want to set
	   * @return nothing
	   */
	public void setM3d(Maze3d m3d){
		this.m3d=m3d;
	}
	
	/**
	   *get the maze 3d
	   * @return Maze3d
	   */
	public Maze3d getM3d(){
		return this.m3d;
	}	
	
	public abstract Postion getCharachterPos();
	
	public abstract  void setCharacterPosition(int row,int col,int up);
	
	public abstract  void setCharacterGoalPosition(int row,int col,int up);

	public abstract void moveUp();

	public abstract  void moveDown();

	public abstract  void moveLeft();

	public  abstract void moveRight();
	
	public  abstract void upSector();
	
	public  abstract void downSector();

}