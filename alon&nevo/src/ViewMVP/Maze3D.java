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

public class Maze3D extends MazeDisplayer {

	public Image ilu,wall;
	public int characterX=1;
	public int characterY=3;
	public int characterZ=5;
	public int exitX=0;
	public int exitY=2;
	
	private void paintCube(double[] p,double h,PaintEvent e){
        int[] f=new int[p.length];
        for(int k=0;k<f.length;f[k]=(int)Math.round(p[k]),k++);
        
        e.gc.drawPolygon(f);
        
        int[] r=f.clone();
        for(int k=1;k<r.length;r[k]=f[k]-(int)(h),k+=2);
        

        int[] b={r[0],r[1],r[2],r[3],f[2],f[3],f[0],f[1]};
        e.gc.drawPolygon(b);
        int[] fr={r[6],r[7],r[4],r[5],f[4],f[5],f[6],f[7]};
        e.gc.drawPolygon(fr);
        
        e.gc.fillPolygon(r);
		
	}
	@SuppressWarnings("unused")
	public Maze3D(Composite parent, int style) {
		super(parent, style);
		
		try {
			ilu = new Image(getDisplay(), new FileInputStream("res/illuminati.png"));
        	wall = new Image(this.getDisplay(), new FileInputStream("res/mountaindew.jpg"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final Color white=new Color(null, 255, 255, 255);
		final Color black=new Color(null, 0,150,150);
		setBackground(white);
		addPaintListener(new PaintListener() {
	
			
			@Override
			public void paintControl(PaintEvent e) {
				   e.gc.setForeground(new Color(null,0,0,0));
				   e.gc.setBackground(new Color(null,0,0,0));

				   int width=getSize().x;
				   int height=getSize().y;
				   
				   int mx=width/2;

				   double w=(double)width/mazeData2D[0].length;
				   double h=(double)height/mazeData2D.length;

				   for(int i=0;i<mazeData2D.length;i++){
					   double w0=0.7*w +0.3*w*i/mazeData2D.length;
					   double w1=0.7*w +0.3*w*(i+1)/mazeData2D.length;
					   double start=mx-w0*mazeData2D[i].length/2;
					   double start1=mx-w1*mazeData2D[i].length/2;
				      for(int j=0;j<mazeData2D[i].length;j++){
				    	  int x=(int)(j*w);
				    	  int y=(int)(i*h);
				          double []dpoints={start+j*w0,i*h,start+j*w0+w0,i*h,start1+j*w1+w1,i*h+h,start1+j*w1,i*h+h};
				          double cheight=h/2;
				          if(mazeData2D[i][j] == 1)
					        	e.gc.drawImage(wall, 0, 0, wall.getBounds().width,  wall.getBounds().height,(int)Math.round(dpoints[0]), (int)Math.round(dpoints[1]-cheight/2), (int)Math.round((w0+w1)/2), (int)Math.round(h));
				          
				          if(i==characterY && j==characterX)
				          {
							   e.gc.drawImage(ilu,0,0,ilu.getBounds().width,ilu.getBounds().height,(int)Math.round(dpoints[0]), (int)Math.round(dpoints[1]-cheight/2), (int)Math.round((w0+w1)/2), (int)Math.round(h));
				          }
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
	
	private void moveCharacter(int x,int y){
		if(x>=0 && x<mazeData2D[0].length && y>=0 && y<mazeData2D.length && mazeData2D[y][x]==0){
			characterX=x;
			characterY=y;
			getDisplay().syncExec(new Runnable() {
				
				@Override
				public void run() {
					redraw();
				}
			});
		}
	}
	
	private void moveCharacterZ(int x){
		if(x>=0 && x<this.getM3d().getM3d().length && this.getM3d().getM3d()[x][characterX][characterY]==0){
			characterZ = x;
			setMazeData2D(getMaze2Dsector(x));
			getDisplay().syncExec(new Runnable() {
				
				@Override
				public void run() {
					redraw();
				}
			});
		}
	}
	
	/* (non-Javadoc)
	 * @see view.MazeDisplayer#moveUp()
	 */
	@Override
	public void moveUp() {
		int x=characterX;
		int y=characterY;
		y=y-1;
		moveCharacter(x, y);
	}
	/* (non-Javadoc)
	 * @see view.MazeDisplayer#moveDown()
	 */
	@Override
	public void moveDown() {
		int x=characterX;
		int y=characterY;
		y=y+1;
		moveCharacter(x, y);
	}
	/* (non-Javadoc)
	 * @see view.MazeDisplayer#moveLeft()
	 */
	@Override
	public void moveLeft() {
		int x=characterX;
		int y=characterY;
		x=x-1;
		moveCharacter(x, y);
	}
	/* (non-Javadoc)
	 * @see view.MazeDisplayer#moveRight()
	 */
	@Override
	public void moveRight() {
		int x=characterX;
		int y=characterY;
		x=x+1;
		moveCharacter(x, y);
	}
	
	public void upSector()
	{
		int x = characterZ;
		x = x+1;
		moveCharacterZ(x);
	}
	
	public void downSector()
	{
		int x = characterZ;
		x = x -1 ;
		moveCharacterZ(x);
	}
	
	@Override
	public void setCharacterPosition(int row, int col,int up) {
		characterX=col;
		characterY=row;
		characterZ = up;
		moveCharacter(col,row);
	}
	public Postion getCharachterPos()
	{
		Postion p = new Postion(this.characterX,this.characterY,this.characterZ);
		return p;
	}
	@Override
	public void setCharacterGoalPosition(int row, int col, int up) {
		// TODO Auto-generated method stub
		
	}
}
