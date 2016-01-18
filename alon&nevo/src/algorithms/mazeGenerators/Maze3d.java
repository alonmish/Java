package algorithms.mazeGenerators;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
/**
* THE Maze3d program crating a maze that he is 3d 
* and do a lot of thing in the maze
*/

public class Maze3d 
{
	private int[][][] m3d;
	private Postion start;
	private Postion goal;
	
	/**
	 * This method is used to add three integers to crate a maze
	 * @param x This is the first parameter to Maze3d method
	 * @param y  This is the second parameter to Maze3d method
	 * @param z This is the third parameter to Maze3d method
	 * @return  nothing
	 */
	public Maze3d(int x, int y, int z)
	{
		m3d = new int[x][y][z];
	}
	
	
	/**
	 * This method is used Maze3d to create a maze 3d
	 * @param m3d1 is the Maze3d we used to create a maze
	 * @return  nothing
	 */
	public Maze3d(Maze3d m3d1)
	{
		m3d = new int[m3d1.getM3d().length][m3d1.getM3d()[0].length][m3d1.getM3d()[0][0].length];
		for (int i = 0; i < m3d1.getM3d().length; i++)
		{
			for (int j = 0; j < m3d1.getM3d()[0].length; j++) 
			{
				for (int j2 = 0; j2 < m3d1.getM3d()[0][0].length; j2++) 
				{
					m3d[i][j][j2] = m3d1.getM3d()[i][j][j2];
				}
			}
		}
	}
	
	/**
	 * This method is used crate a defult constractor
	 * @return  nothing
	 */
	public Maze3d(){}
	
	/**
	 * This method get the maze
	 * @return  int[][][]
	 */
	public int[][][] getM3d() 
	{
		return m3d;
	}
	
	/**
	   * This function is a contractor that used a array of bytes
	   * in the array their is the start,goal maze position , the length of the lines and the maze
	   * @param b is the byte array with all the things to create a maze
	   * @return nothing
	   */
	public Maze3d(byte []b)
	{
		int[] arr = new int[b.length];
		for (int i = 0; i < b.length; i++) {
			arr[i] = (int)b[i];
		}
		this.start = new Postion(arr[13], arr[19], arr[23]);
		this.goal = new Postion(arr[27], arr[31], arr[35]);
		int i = 36;
		this.m3d = new int[arr[3]][arr[7]][arr[11]];
		
		for (int j = 0; j < arr[3]; j++) 
		{
			for (int j2 = 0; j2 < arr[7]; j2++) 
			{
				for (int k = 0; k < arr[11]; k++) 
				{
					this.m3d[j][j2][k] = arr[i];
					i++;
				}
			}
		}
		
	}
	
	/**
	 * This method is used int[][][] to set the maze
	 * @param maze3d is the maze 3d we want to set to our maze 3d
	 * @return  nothing
	 */
	public void setm3d(int[][][] maze3d) 
	{
		this.m3d = maze3d;
	}
	
	/**
	 * This method get the start maze
	 * @return  Postion
	 */
	public Postion getStart() {
		return start;
	}
	
	/**
	 * This method is used Postion to set the start maze
	 * @param start is the start Postion of the maze 3d
	 * @return  nothing
	 */
	public void setStart(Postion start) {
		this.start = start;
	}
	

	/**
	 * This method get the goal maze
	 * @return  Postion
	 */
	public Postion getGoal() {
		return goal;
	}
	

	/**
	 * This method is used Postion to set the goal maze
	 * @param goal is the goal Postion of the maze 3d
	 * @return  nothing
	 */
	public void setGoal(Postion goal) {
		this.goal = goal;
	}
	
	/**
	 * This method Postion to get the possible moves we can move from their
	 * @param state is the postion from where we are now in the maze 3d
	 * @return  ArrayList<Postion>
	 */
	public ArrayList<Postion> getArrayPossibleMoves(Postion p)
	{
		Postion temp ;
		ArrayList<Postion> a = new ArrayList<Postion>() ;
		if(canGoUp(p, 1))
		{
			temp = new Postion(p) ;
			changePosition(temp, 1) ;
			a.add(temp) ;
		}
		if(canGoDown(p, 1))
		{
			temp = new Postion(p) ;
			changePosition(temp, 2) ;
			a.add(temp) ;
		}
		if(canGoForward(p, 1))
		{
			temp = new Postion(p) ;
			changePosition(temp, 3) ;
			a.add(temp) ;
		}
		if(canGoBackward(p, 1))
		{
			temp = new Postion(p) ;
			changePosition(temp, 4) ;
			a.add(temp) ;
		}
		if(canGoRight(p, 1))
		{
			temp = new Postion(p) ;
			changePosition(temp, 5) ;
			a.add(temp) ;
		}
		if(canGoLeft(p, 1))
		{
			temp = new Postion(p) ;
			changePosition(temp, 6) ;
			a.add(temp) ;
		}
		if(a.isEmpty())
			return null ;
		return  a ;
	}
	
	/**
	   * this function get postion and bring as the moves we can move from the maze
	   * @param Postion p
	   * @return String[]
	   */
	public String[] getPossibleMoves(Postion p)
	{
		ArrayList<String> a = new ArrayList<>() ;
		if(canGoUp(p, 1))
			a.add("Up") ;
		if(canGoDown(p, 1))
			a.add("Down") ;
		if(canGoForward(p, 1))
			a.add("Forward") ;
		if(canGoBackward(p, 1))
			a.add("Backward") ;
		if(canGoRight(p, 1))
			a.add("Right") ;
		if(canGoLeft(p, 1))
			a.add("Left") ;
		if(a.isEmpty())
			return null ;
		return  a.toArray(new String[a.size()]);
	}
	/**
	 * all the methods from here is to help the getArrayPosibleMoves to be complete more nicely
	 */
	public int getFloors() { return this.getM3d().length ; }
	
	public int getRows() { return this.getM3d()[0].length ;}
	
	public int getCols() { return this.getM3d()[0][0].length ;}
	
	public Postion changeRandomalyPosition(Postion p)
	{
		ArrayList<Integer> swap = new ArrayList<Integer>() ;
		
		if(canGoUp(p,1)) {swap.add(1);} // 1 will be move up
		if(canGoDown(p,1)) {swap.add(2);}  // 2 will be move down
		if(canGoForward(p,1)) {swap.add(3);} // 3 will be move forward 
		if(canGoBackward(p,1)) {swap.add(4);}  // 4 will be move backward
		if(canGoRight(p,1)) {swap.add(5);} // 5 will be move right
		if(canGoLeft(p,1)) {swap.add(6);}  // 6 will be move left
		
		Collections.shuffle(swap);
		
		if(swap.get(0) == null)
			return null ;
		
		changePosition(p,swap.get(0));
		return p ;
		
		
	}
	
	public boolean changePosition(Postion p ,int i) 
	{
		switch(i){
		case 1: p.setX(p.getX()+1); if(!(p.getX()<this.getFloors())) return false ; break ;
		case 2: p.setX(p.getX()-1); if(!(0<=p.getX())) return false ; break ;
		case 3: p.setY(p.getY()+1); if(!(p.getY()<this.getRows())) return false ; break ;
		case 4: p.setY(p.getY()-1); if(!(0<=p.getX())) return false ; break ;
		case 5: p.setZ(p.getZ()+1); if(!(p.getZ()<this.getCols())) return false ; break ;
		case 6: p.setZ(p.getZ()-1); if(!(0<=p.getX())) return false ; break ;
		}
		
		return true ;
	}
	
	public boolean canGoUp(Postion p , int i) { 
		if(p.getX()+1 < getFloors())
			return (getMazePosition(new Postion(p.getX()+1, p.getY(), p.getZ())) != i) ;
		return false ;
	}
	
	public int getMazePosition(Postion p)
	{
		return this.m3d[p.getX()][p.getY()][p.getZ()] ;
	}


	public boolean canGoDown(Postion p , int i) {
		if(0<=p.getX()-1)
			return getMazePosition(new Postion(p.getX()-1, p.getY(), p.getZ())) != i ;
		return false ;
	}
	
	public boolean canGoForward(Postion p , int i) {
		if(p.getY()+1<getRows())
			return getMazePosition(new Postion(p.getX(), p.getY()+1, p.getZ())) != i ;
		return false ;
	}
	
	public boolean canGoBackward(Postion p , int i) { 
		if(0<=p.getY()-1)
			return getMazePosition(new Postion(p.getX(), p.getY()-1, p.getZ())) != i ;
		return false ;
	}
	
	public boolean canGoRight(Postion p , int i) {
		if(p.getZ()+1<getCols())
			return getMazePosition(new Postion(p.getX(), p.getY(), p.getZ()+1)) != i ;
		return false ;
		}
	
	public boolean canGoLeft(Postion p , int i) {
		if(0<=p.getZ()-1)
			return getMazePosition(new Postion(p.getX(), p.getY(), p.getZ()-1)) != i ;
		return false ;
		}

	public boolean canGoTo(Postion p , int i , int direction)
	{
		switch(direction){
		case 1: return canGoUp(p,i) ; // 1 will be move up
		case 2: return canGoDown(p,i) ; // 2 will be move down
		case 3: return canGoForward(p,i) ; // 3 will be move forward
		case 4: return canGoBackward(p,i) ; // 4 will be move backward
		case 5: return canGoRight(p,i) ; // 5 will be move right
		case 6: return canGoLeft(p,i) ; // 6 will be move left
		}
		
		return false ;
	}
	
	
	
	
	/**
	   * This function is used one int
	   * he bring as the maze 2d with the index in the x line
	   * @param int index
	   * @return int[][]
	   */
    public int[][] getCrossSectionByX(int index)
    {
    	int [][] Sec= new int [this.getM3d()[0].length][this.getM3d()[0][0].length];
    	if(index<0||index>(this.getM3d().length))
    		  throw new IndexOutOfBoundsException();
      else
      {
    	 for (int i = 0; i < (Sec.length); i++) 
              for (int j = 0; j < Sec[0].length; j++) 
              {
				Sec[i][j]=this.getM3d()[index][i][j];
			  }
      }
      return Sec;    
    }
    
    /**
	   * This function is used one int
	   * he bring as the maze 2d with the index in the y line
	   * @param int index
	   * @return int[][]
	   */
    public int[][] getCrossSectionByY(int index)
    {
    	int [][] Sec= new int [this.getM3d().length][this.getM3d()[0][0].length];
    	if(index<0||index>(this.getM3d()[0].length))
    		  throw new IndexOutOfBoundsException();
      else
      {
    	 for (int i = 0; i < (Sec.length); i++) 
              for (int j = 0; j < Sec[0].length; j++) 
              {
				Sec[i][j]=this.getM3d()[i][index][j];
			  }
      }
      return Sec;    
    }
    
    /**
	   * This function is used one int
	   * he bring as the maze 2d with the index in the z line
	   * @param int index
	   * @return int[][]
	   */
    public int[][] getCrossSectionByZ(int index)
    {
    	int [][] Sec= new int [this.getM3d().length][this.getM3d()[0].length];
    	if(index<0||index>(this.getM3d()[0][0].length))
    		  throw new IndexOutOfBoundsException();
      else
      {
    	 for (int i = 0; i < (Sec.length); i++) 
              for (int j = 0; j < Sec[0].length; j++) 
              {
				Sec[i][j]=this.getM3d()[i][j][index];
			  }
      }
      return Sec;    
    }	
  
    /**
	   * This function bring as the m3d in string int after int
	   * @return String
	   */
  public String toString()
  {
	  String s= new String();
	  for (int i = 0; i < m3d.length; i++)
	  {
		  for (int j = 0; j < m3d[0].length; j++)
		  {
			  for (int k = 0; k < m3d[0][0].length; k++) 
			  {
				  s+=m3d[i][j][k];
			  }
			  s += "\n";
		  }
		  s+= "\n\n\n";
	  }
               
	  return s;
	  	
    }
  
  /**
   * This function is used postion and bring as the m3d value int the postion we want
   * @param p the Postion of the m3d
   * @return int
   */
	public int getValue(Postion p)
	{
		return (m3d[p.getX()][p.getY()][p.getZ()]);
	}
	
	/**
	   * This function is used postion and int and set the int in the Postion in maze
	   * @param p the Postion of the m3d
	   * @param v the value we want to put
	   * @return nothing
	   */
	public void setValue(Postion p,int v)
	{
		m3d[p.getX()][p.getY()][p.getZ()] = v;
	}
	
	/**
	   * This function is used Maze3d to pring as the maze
	   * @param m3d is the maze 3d we want to print
	   * @return nothing
	   */
	public static void printM3d(Maze3d m3d)
	{
		for (int i = 0; i < m3d.m3d.length; i++) 
		{
			for (int j = 0; j < m3d.m3d[i].length; j++) 
			{
				for (int j2 = 0; j2 < m3d.m3d[i][j].length; j2++) 
				{
					System.out.println(m3d.m3d[i][j][j2]+" ");
				}
			}
		}
	}
	
	/**
	   * This function is pring as the maze3d we have
	   * @return nothing
	   */
	public void printM3d()
	{
		for (int i = 0; i < this.m3d.length; i++) 
		{
			System.out.println("you are in flour : "+ i);
			for (int j = 0; j < this.m3d[i].length; j++) 
			{
				for (int j2 = 0; j2 < this.m3d[i][j].length; j2++) 
				{
					System.out.println(this.m3d[i][j][j2]+" ");
				}
				System.out.println("");
			}
		}
	}
	
	/**
	   * This function is used Maze3d and three ints to put 1(walls) in the maze
	   * @param m3d is the maze 3d we want to put walls
	   * @param x the lenght of x line
	   * @param y the lenght of y line
	   * @param z the lenght of z line
	   * @return nothing
	   */
	public void allWalls(int [][][] m3d,int x , int y , int z)
	{
		for (int i = 0; i < x; i++)
		{
			for (int j = 0; j < y; j++)
			{
				for (int j2 = 0; j2 < z; j2++) 
				{
					m3d[x][y][z] = 1;
				}
			}
		}
	}
	
	private void intToBytes(byte[] byte_maze , int start ,int value)
	{
		for (int i = 0; i < 4; i++) 
			byte_maze[i+start] = ByteBuffer.allocate(4).putInt(value).array()[i] ;
	}
	
	/**
	   * This function bring as the start,goal,lenghts of lines and the maze int array of bytes
	   * @return byte[]
	   */
	public byte[] toByteArray()
	{
		byte[] byte_maze = new byte[36+this.getM3d().length*this.getM3d()[0].length*this.getM3d()[0][0].length] ;
		int count = 36 ;
		//enter the sizes of the maze
		intToBytes(byte_maze, 0, this.getM3d().length);
		intToBytes(byte_maze, 4, this.getM3d()[0].length);
		intToBytes(byte_maze, 8, this.getM3d()[0][0].length);
		
		//enter the start position
		intToBytes(byte_maze, 12, this.start.getX());
		intToBytes(byte_maze, 16, this.start.getY());
		intToBytes(byte_maze, 20, this.start.getZ());
		
		//enter the start position
		intToBytes(byte_maze, 24, this.goal.getX());
		intToBytes(byte_maze, 28, this.goal.getY());
		intToBytes(byte_maze, 32, this.goal.getZ());
		
		for (int i = 0; i < this.getM3d().length; i++) 
			for (int j = 0; j < this.getM3d()[0].length; j++) 
				for (int j2 = 0; j2 < this.getM3d()[0][0].length; j2++)
					byte_maze[count++] = new Integer(m3d[i][j][j2]).byteValue();
					
		return byte_maze ;
		//the size is the start postion goal postion sizes of the m3d and is values
		/*byte [] b = new byte[9+(this.getM3d().length*this.getM3d()[0].length*this.getM3d()[0][0].length)];
		b[0] = (byte)this.start.getX();
		b[1] = (byte)this.start.getY();
		b[2] = (byte)this.start.getZ();
		b[3] = (byte)this.goal.getX();
		b[4] = (byte)this.goal.getY();
		b[5] = (byte)this.goal.getZ();
		b[6] = (byte)this.getM3d().length;
		b[7] = (byte)this.getM3d()[0].length;
		b[8] = (byte)this.getM3d()[0][0].length;
		int i = 9;
		
		for (int j = 0; j < this.getM3d().length; j++) 
		{
			for (int j2 = 0; j2 < this.getM3d()[0].length; j2++) 
			{
				for (int k = 0; k < this.getM3d()[0][0].length; k++) 
				{
					b[i] = (byte)this.m3d[j][j2][k];
					//System.out.println(b[i]);
					i++;
				}
			}
		}
		return b;*/
	}
	
}
