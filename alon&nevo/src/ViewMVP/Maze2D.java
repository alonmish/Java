package ViewMVP;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Postion;

public class Maze2D extends MazeDisplayer
{
	public Postion character = new Postion(2,1,2);
	public Postion goal = new Postion(1,8,2);
	public Image ilu,wall,dor,sium,mlg;
	
	/**
	 * in the constructor we create the maze 2d we want to view
	 * @return nothing
	 */
	 public Maze2D(Composite parent,int style){
	        super(parent, style);
	        try {
	        	ilu = new Image(getDisplay(), new FileInputStream("res/illuminati.png"));
	        	sium = new Image(getDisplay(), new FileInputStream("res/sium.jpg"));
	        	dor = new Image(getDisplay(), new FileInputStream("res/dor.png"));
	        	wall = new Image(this.getDisplay(), new FileInputStream("res/mountaindew.jpg"));
	        	mlg = new Image(this.getDisplay(), new FileInputStream("res/mlg.jpg"));
	        	} catch (FileNotFoundException e1) {
	        	e1.printStackTrace();
	        	}
	        	// set a white background   (red, green, blue)
	        	setBackground(new Color(null, 255, 255, 255));
	   	    	addPaintListener(new PaintListener() {
	        	public void paintControl(PaintEvent e) {
	        	int width=getSize().x;
	        	int height=getSize().y;
	        	int w=width/mazeData2D[0].length;
	        	int h=height/mazeData2D.length;
	        	for(int i=0;i<mazeData2D.length;i++)
	        	for(int j=0;j<mazeData2D[i].length;j++){
	        	int x=j*w;
	        	int y=i*h;
	        	if(mazeData2D[i][j] == 1)
	        	e.gc.drawImage(wall, 0, 0, wall.getBounds().width,  wall.getBounds().height, x, y, w, h);
	        	if(character.getY() == i && character.getZ() == j)
	        		e.gc.drawImage(ilu,0,0,ilu.getBounds().width,ilu.getBounds().height,x, y, w, h);
	        	if(i == goal.getY() && j == goal.getZ() && goal.getX() == character.getX())
	        	{
	        		e.gc.drawImage(dor,0,0,dor.getBounds().width,dor.getBounds().height,x, y, w, h);
	        		mazeData2D[i][j] = 0;
	        	}
	        	if(character.getX() == goal.getX() && character.getY() == goal.getY() && character.getZ() == goal.getZ())
	        	{
	        		e.gc.drawImage(sium,0,0,sium.getBounds().width,sium.getBounds().height,0, 0, width, height);
	        	}	
	        	if(mazeData2D[i][j] == 3)
	        	{
	        		e.gc.drawImage(mlg,0,0,mlg.getBounds().width,mlg.getBounds().height,x, y, w, h);
	        		mazeData2D[i][j] = 0;
	        	}
	        	}
	        	}
	        	});    	
	   	    	addKeyListener(new KeyListener() {
	   				
	   				@Override
	   				public void keyReleased(KeyEvent arg0) {
	   					if(arg0.keyCode == SWT.ARROW_UP)
	   						moveUp();
	   					if(arg0.keyCode == SWT.ARROW_DOWN)
	   						moveDown();
	   					if(arg0.keyCode == SWT.ARROW_RIGHT)
	   						moveRight();
	   					if(arg0.keyCode == SWT.ARROW_LEFT)
	   						moveLeft();
	   					if(arg0.keyCode == SWT.PAGE_UP)
	   					{
	   						upSector();
	   					}
	   					if(arg0.keyCode == SWT.PAGE_DOWN)
	   					{
	   						downSector();
	   					}
	   				
	   				}
	   				
	   				@Override
	   				public void keyPressed(KeyEvent arg0) {			
	   				}
	   			});
	   		}
	 	
	 /**
		 * move the characther to line and colom you want
		 * @param y the colom
		 * @param x the line
		 * @return nothing
		 */
		private void moveCharacter(int x,int y){
			if(x>=0 && x<mazeData2D[0].length && y>=0 && y<mazeData2D.length && mazeData2D[y][x]==0){
				character.setZ(x);
				character.setY(y);
				getDisplay().syncExec(new Runnable() {
					
					@Override
					public void run() {
						redraw();
					}
				});
			}
		}
		
		/**
		 * move the character to floor you want
		 * @param x the floor
		 * @return nothing
		 */
		private void moveCharacterZ(int x){
			if((x>=0) && (x<this.getM3d().getM3d().length) && (getMaze2Dsector(x)[character.getY()][character.getZ()] == 0)){
				character.setX(x);
				setMazeData2D(getMaze2Dsector(x));
				getDisplay().syncExec(new Runnable() {
					
					@Override
					public void run() {
						redraw();
					}
				});
			}
		}
		
		/**
		 * move the character up
		 * @return nothing
		 */
		@Override
		public void moveUp() {
			int x=character.getZ();
			int y=character.getY();
			y=y-1;
			moveCharacter(x, y);
		}
		/**
		 * move the character down
		 * @return nothing
		 */
		@Override
		public void moveDown() {
			int x=character.getZ();
			int y=character.getY();
			y=y+1;
			moveCharacter(x, y);
		}
		/**
		 * move the character left
		 * @return nothing
		 */
		@Override
		public void moveLeft() {
			int x=character.getZ();
			int y=character.getY();
			x=x-1;
			moveCharacter(x, y);
		}
		/**
		 * move the character right
		 * @return nothing
		 */
		@Override
		public void moveRight() {
			int x=character.getZ();
			int y=character.getY();
			x=x+1;
			moveCharacter(x, y);
		}
		
		/**
		 * move the character upSector
		 * @return nothing
		 */
		@Override
		public void upSector()
		{
			int x = character.getX();
			x = x+1;
			moveCharacterZ(x);
		}
		/**
		 * move the character downSector
		 * @return nothing
		 */
		@Override
		public void downSector()
		{
			int x = character.getX();
			x = x -1 ;
			moveCharacterZ(x);
		}
		
		/**
		 * set character position
		 * @param row is the row we want the char to be
		 * @param col is the colom we want the char to be
		 * @param up is the floor we want the char to be
		 * @return nothing
		 */
		@Override
		public void setCharacterPosition(int row, int col,int up) {
			character.setX(col);
			character.setY(row);
			character.setZ(up);
			moveCharacter(up,row,col);
		}
		
		/**
		 * move character to position
		 * @param x is the row we want the char to be
		 * @param y is the colom we want the char to be
		 * @param z is the floor we want the char to be
		 * @return nothing
		 */
		private void moveCharacter(int x,int y,int z){
			if(x>=0 && x<mazeData2D[0].length && y>=0 && y<mazeData2D.length && mazeData2D[y][x]==0){
				m3d.getCrossSectionByX(z);
				character.setZ(x);
				character.setY(y);
				getDisplay().syncExec(new Runnable() {
					
					@Override
					public void run() {
						redraw();
					}
				});
			}
		}
		
		/**
		 * get character position
		 * @return Position
		 */
		@Override
		public Postion getCharachterPos()
		{
			Postion p = new Postion(character.getX(),character.getY(),character.getZ());
			return p;
		}

		@Override
		public void setCharacterGoalPosition(int row, int col, int up) 
		{
			goal.setX(col);
			goal.setY(row);
			goal.setZ(up);
		}
}
