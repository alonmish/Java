package algorithms.mazeGenerators;

public abstract class AMaze3dGenerator implements Maze3dGenerator{
		abstract public Maze3d generate(int xsize,int ysize,int zsize);
		
		/**
		   * This function used int[][][] to create a maze 3d full of walls
		   * @param m3d is the maze 3d we want to put all walls in
		   * @return int[][][]
		   */
		public int[][][] AllWalls(int [][][]m3d)
		{
			
						int [][][]m3d1={
								{
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								},
								{
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								},
								{
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								{1,1,1,1,1,1,1,1,1},
								}
								};
			return m3d1;
		}
		
		/**
		   * This function used three ints to measure the time to do generate
		   * @param x is the x line lenght
		   * @param y is the y line lenght
		   * @param z is the z line lenght
		   * @return int[][][]
		   */
		public String measureAlgorithmTime(int x,int y,int z)
		{
			long x1 = System.currentTimeMillis();
			generate(x,y,z);
			long y1 = System.currentTimeMillis();
			String s = String.valueOf(y1-x1);
			return s;
		}
}
