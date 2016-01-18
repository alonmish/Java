package algorithms.mazeGenerators;

/**
* THE Postion program creating a postion of a spot in the maze 3d
*/

public class Postion extends AMaze3dGenerator{
	private int x;
	private int y;
	private int z;
	
	/**
	 * This method get the x postion
	 * @return  int
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * This method is used int to set the x postion int x
	 * @param x is the x postion
	 * @return  int
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * This method get the y postion
	 * @return  int
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * This method is used int to set the y postion int y
	 * @param y is the x postion
	 * @return  int
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * This method get the z postion
	 * @return  int
	 */
	public int getZ() {
		return z;
	}
	
	/**
	 * This method is used int to set the z postion int z
	 * @param x is the z postion
	 * @return  int
	 */
	public void setZ(int z) {
		this.z = z;
	}
	
	/**
	 * This method is used three ints to create a maze
	 * @param x is the x lenght
	 * @param y is the y lenght
	 * @param z is the z lenght
	 * @return  Maze3d
	 */
	public Maze3d generate(int x,int y,int z)
	{
		Maze3d m3d = new Maze3d();
		return m3d;
	}
	
	/**
	 * This method is used three ints to set a postion
	 * @param x is the x Postion
	 * @param y is the y Postion
	 * @param z is the z Postion
	 * @return  nothing
	 */
	public Postion(int x,int y,int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Postion(Postion p)
	{
		this.x = p.getX();
		this.y = p.getY();
		this.z = p.getZ();
	}

	@Override
	/**
	 * This method give as string that is the place we are in
	 * @return  string
	 */
	public String toString() {
		return "{"+x+","+y+","+z+"}";
	}
	
	public void setXYZ(int x,int y,int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if((this.x == ((Postion)obj).x )&&(this.y == ((Postion)obj).y)&&(this.z == ((Postion)obj).z))
			return true;
		return false;
	}


}
