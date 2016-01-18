package algorithms.mazeGenerators;

public interface Maze3dGenerator {
		public Maze3d generate(int xsize,int ysize,int zsize);
		public String measureAlgorithmTime(int xsize,int ysize,int zsize);
}
