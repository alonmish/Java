package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

/**
* THE MyMaze3dGenerator is using prim to solve the maze 3d we need
*/
public class MyMaze3dGenerator extends AMaze3dGenerator{
	
	/**
	 * This method is used to add three integers to crate a maze
	 * @param x This is the first paramter to Maze3d method
	 * @param y  This is the second parameter to Maze3d method
	 * @param z This is the third paramter to Maze3d method
	 * @return  nothing
	 */
	@Override
	public Maze3d generate(int x,int y,int z)
	{	
		int index;
		int index2;
		Random r= new Random();
		Maze3d m= new Maze3d(x, y, z);
	   for (int i = 0; i < x; i++) 
		  for (int j = 0; j < y; j++)
			  for (int k = 0; k < z; k++) 
                   m.getM3d()[i][j][k]=1;				
	   Postion p = new Postion(r.nextInt(x),r.nextInt(y),r.nextInt(z))	;
		m.setStart(p);
		ArrayList<Postion>Walls= getNeighbours(p, x, y, z,m);
		ArrayList<Postion>n=new ArrayList<Postion>();
		ArrayList<Postion>n2=new ArrayList<Postion>();
        m.getM3d()[p.getX()][p.getY()][p.getZ()]=0;
		while(!Walls.isEmpty())
		{
		  index =r.nextInt(Walls.size());
		  p=Walls.get(index);
		  n.addAll(getNeighbours(p, x, y, z, m));
		  index2=r.nextInt(n.size());
		  if(m.getM3d()[n.get(index2).getX()][n.get(index2).getY()][n.get(index2).getZ()]!=0)
		  {
		   m.getM3d()[n.get(index2).getX()][n.get(index2).getY()][n.get(index2).getZ()]=0;
		   m.getM3d()[p.getX()][p.getY()][p.getZ()]=0;
		   n2.addAll(getNeighbours(n.get(index2), x, y, z, m));
		   Walls.add(n2.get(r.nextInt(n2.size())));
		 
		   
		  }
			Walls.remove(index); 
		 }
		m.setGoal(p);
	    return m;
	}
	
	/**
	 * This method is used three ints Postion and Maze3d to returns all the "legal" neighbours of a point in the maze. 
	 * @param p is the postion in the maze 3d
	 * @param sizex This is the first paramter to Maze3d method
	 * @param sizey  This is the second parameter to Maze3d method
	 * @param sizez This is the third paramter to Maze3d method
	 * @param m is the Maze3d we want to check
	 * @return  nothing
	 */
    public ArrayList<Postion> getNeighbours(Postion p,int sizex, int sizey, int sizez,Maze3d m)
	{
		ArrayList<Postion> neighbours= new ArrayList<Postion>();
		if(p.getX()+1<sizex)
			if(m.getM3d()[p.getX()+1][p.getY()][p.getZ()]!=0)
			neighbours.add(new Postion(p.getX()+1,p.getY(),p.getZ()));
		if(p.getX()-1>=0)
			if(m.getM3d()[p.getX()-1][p.getY()][p.getZ()]!=0)
			neighbours.add(new Postion(p.getX()-1,p.getY(),p.getZ()));
		if(p.getY()+1<sizey)
			if(m.getM3d()[p.getX()][p.getY()+1][p.getZ()]!=0)
			neighbours.add(new Postion(p.getX(),p.getY()+1,p.getZ()));
		if(p.getY()-1>=0)
			if(m.getM3d()[p.getX()][p.getY()-1][p.getZ()]!=0)
			neighbours.add(new Postion(p.getX(),p.getY()-1,p.getZ()));
		if(p.getZ()+1<sizez)
			if(m.getM3d()[p.getX()][p.getY()][p.getZ()+1]!=0)
			neighbours.add(new Postion(p.getX(),p.getY(),p.getZ()+1));
		if(p.getZ()-1>=0)
			if(m.getM3d()[p.getX()][p.getY()][p.getZ()-1]!=0)
			neighbours.add(new Postion(p.getX(),p.getY(),p.getZ()-1));
        return neighbours;
	}
}
