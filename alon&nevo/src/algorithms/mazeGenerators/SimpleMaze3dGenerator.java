package algorithms.mazeGenerators;

import java.util.Random;
/**
* THE SimpleMaze3dGenerator program crating a normal maze 
* and doesnt use anything
*/

public class SimpleMaze3dGenerator extends AMaze3dGenerator{
	
	/**
	 * This method is used three ints to create a maze
	 * @param x is the x lenght
	 * @param y is the y lenght
	 * @param z is the z lenght
	 * @return  Maze3d
	 */
	public Maze3d generate(int x,int y,int z)
	{
		Random r= new Random();
		Maze3d m= new Maze3d(x,y,z);
		for(int i=0;i<x;i++)
		  for (int j=0;j<y;j++)
			 for(int k=0;k<z;k++)
			 {
				 m.getM3d()[i][j][k]=r.nextInt(2);
			 }
		// Choosing the start and the end  points of the maze 
		Postion start= new Postion(r.nextInt(x),r.nextInt(y),r.nextInt(z));
		Postion end  = new Postion(r.nextInt(x),r.nextInt(y),r.nextInt(z));
		System.out.println(start.toString());
	    m.setStart(start);
	    m.setGoal(end);
		//Setting these points in the maze : setMaze3d(int x, int y, int z, int val) 
		m.getM3d()[start.getX()] [start.getY()] [start.getZ()]= 0;
		m.getM3d()[end.getX()] [end.getY()] [end.getZ()]= 0;
		Postion temp = new Postion(start);
	    //Creating default path 
	    while(temp.getX()!=end.getX())
	    {
	    	if(temp.getX()>end.getX())
	    		temp.setX(temp.getX()-1);
	    	else
	    		temp.setX(temp.getX()+1);
	    	
	    	m.getM3d()[temp.getX()] [temp.getY()] [temp.getZ()]= 0;
	    		
	    }
	    while(temp.getY()!=end.getY())
	    {
	    	if(temp.getY()>end.getY())
	    		temp.setY(temp.getY()-1);
	    	else
	    		temp.setY(temp.getY()+1);
	    	
	    	m.getM3d()[temp.getX()] [temp.getY()] [temp.getZ()]= 0;
	    		
	    }
	    while(temp.getZ()!=end.getZ())
	    {
	    	if(temp.getZ()>end.getZ())
	    		temp.setZ(temp.getZ()-1);
	    	else
	    		temp.setZ(temp.getZ()+1);
	        
	    	m.getM3d()[temp.getX()] [temp.getY()] [temp.getZ()]= 0;	    
	    }
		return m;
	}
	
	/**
	 * This method is used three ints and Maze3d to create a random walls in the maze (0,1)
	 * @param m3d is the maze 3d we want to do it the function
	 * @param x is the x lenght
	 * @param y is the y lenght
	 * @param z is the z lenght
	 * @return  Maze3d
	 */
	public Maze3d randomWall(Maze3d m3d,int x,int y,int z)
	{
		
		for (int i = 0; i < x; i++)
		{
			for (int j = 0; j < y; j++)
			{
				for (int k = 0; k < z; k++)
				{
					m3d.getM3d()[i][j][k] = (int) ((Math.random()*(1-0+1))+0);
				}
			}
		}
		return m3d;
	}
	
	/**
	 * This method is used Maze3d and two Postion the bring as the best way one to other
	 * @param m3d is the maze 3d we want to check the way
	 * @param p1 is the first postion
	 * @param p2 is the goal postion
	 * @return  Maze3d
	 */
	public Maze3d maslul(Maze3d m3d,Postion p1, Postion p2)
	{	
		int x = p1.getX();
		int y = p1.getY();
		int z = p1.getZ();
		int x1 = p2.getX();
		int y1 = p2.getY();
		int z1 = p2.getZ();
		m3d.getM3d()[x][y][z] = 0;
		m3d.getM3d()[x1][y1][z1] = 0;
		for (int i = 0; i < x1; i++)
		{
			for (int j = 0; j < y1; j++) 
			{
				for (int j2 = 0; j2 < z1; j2++) 
				{
					if(z < z1)
					{
						m3d.getM3d()[x][y][z+1] = 0;
						z++;
					}
					else if(z > z1)
					{
						m3d.getM3d()[x][y][z-1] = 0;
						z--;
					}
					else
					{
						j2 = z1;
					}
				}
				if(y < y1)
				{
					m3d.getM3d()[x][y+1][z] = 0;
					y++;
				}
				else if(y > y)
				{
					m3d.getM3d()[x][y-1][z] = 0;
					y--;
				}
				else
				{
					j = y;
				}
			}
			if(x < x1)
			{
				m3d.getM3d()[x+1][y][z] = 0;
				x++;
			}
			else if(x > x1)
			{
				m3d.getM3d()[x-1][y][z] = 0;
				x--;
			}
			else
			{
				i = x1;
			}
		}
		return m3d;
	}
}
