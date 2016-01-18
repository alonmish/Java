package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.SimpleMaze3dGenerator;

public class bobo {

	public static void main(String[] args) throws Exception  
	{	
		SimpleMaze3dGenerator bobo = new SimpleMaze3dGenerator();
		Maze3d maze = bobo.generate(5,5,5) ; 
		// save it to a file
		OutputStream out=new MyCompressorOutputStream(
		new FileOutputStream("1.maz"));
		out.write(maze.toByteArray());
		out.flush();
		out.close();
		InputStream in=new MyDecompressorInputStream(
		new FileInputStream("1.maz"));
		byte b[]=new byte[maze.toByteArray().length];
		in.read(b);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		in.close();
		//Maze3d loaded=new Maze3d(b);
		//System.out.println(loaded.equals(maze)); 

	}
		
}



