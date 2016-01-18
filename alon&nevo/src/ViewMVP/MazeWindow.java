package ViewMVP;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Postion;
import algorithms.search.Solution;

public class MazeWindow extends BasicWindow
{
	private Maze3d m3d;
	private MazeDisplayer md;
	private String mazeName;
	public Maze3d getM3d() {
		return m3d;
	}

	public void setM3d(Maze3d m3d) {
		this.m3d = m3d;
	}

	public MazeWindow(String title, int width, int height) {
		super(title, width, height);
	}
	
	/**
	 * show as message in messagebox
	 * @param s is the string we want to show in the messegebox
	 * @return  nothing
	 */
	public void mb(String s)
	{
		JOptionPane.showMessageDialog(null,s);
	}
	
	/**
	 * show as the solve
	 * @param x is the postions of solve
	 * @return  nothing
	 */
	public void ss(Solution<Postion> x)
	{
		
			try {
				for (int i = 0; i < x.getS().size(); i++) 
				{
					Postion p = new Postion(x.getS().get(x.getS().size()-i-1).getState());
					hint(p);
					Thread.sleep(3000);
					if(p.equals(m3d.getGoal()))
					{
						return;
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
		/*Timer timer=new Timer();
		TimerTask task=new TimerTask() {
			
			@Override
			public void run() {
				for (int i = 0; i < x.getS().size(); i++) 
				{
					Postion p = new Postion(x.getS().get(x.getS().size()-i-1).getState());
					md.setMazeData2D(m3d.getCrossSectionByX(p.getX()));
					md.setCharacterPosition(p.getY(), p.getX(), p.getZ());
					if(p.equals(m3d.getGoal()))
					{
						return;
					}
				}
			}
		};
		timer.scheduleAtFixedRate(task, 0, 100);
		task.cancel();
		timer.cancel();
		}*/
		  
		
			
		//hint(this.m3d.getStart());
				//System.out.println(p.toString());
				//this.hint(p);
		/*for (int i = 0; i < x.getS().size(); i++) {
			System.out.println(x.getS().get(i).toString());
		}*/
		//md.setCharacterPosition(m3d.getStart().getX(), m3d.getStart().getZ(), m3d.getStart().getY());
		/*Timer timer=new Timer();
		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				display.syncExec(new Runnable() {
					@Override
					public void run() {
						for (int i = 0; i < x.getS().size(); i++) 
						{
							Postion p = new Postion(x.getS().get(x.getS().size()-i-1).getState());
							hint(p);
						}
					}
				});
			}
		};	
		timer.scheduleAtFixedRate(task, 0, 100);
		task.cancel();
		timer.cancel();*/
	
	/**
	 * show as the hint
	 * @param p is the hint we want to show
	 * @return  nothing
	 */
	public void hint(Postion p)
	{
		md.setMazeData2D(m3d.getCrossSectionByX(p.getX()));
		md.setCharacterPosition(p.getY(), p.getX(), p.getZ());
	}
	
	/**
	 * show as the maze 3d
	 * @param m3d is the maze3d we want to show
	 * @return  nothing
	 */
	public void m3d(Maze3d m3d)
	{		
		System.out.println(m3d.getStart().toString()+"123");
		System.out.println(m3d.getGoal()+"456");
		if(md != null)
			md.dispose();
		this.setM3d(m3d);
		md = new Maze2D(shell,SWT.FILL);
		md.setM3d(m3d);
		md.setCharacterGoalPosition(m3d.getGoal().getY(), m3d.getGoal().getX(), m3d.getGoal().getZ());
		md.setCharacterPosition(m3d.getStart().getY(), m3d.getStart().getX(), m3d.getStart().getZ());
		md.setMazeData2D(m3d.getCrossSectionByX(m3d.getStart().getX()));
		md.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true,1,2));
	}
	
	@Override
	void initWidgets() 
	{
		
		Menu menuBar = new Menu(shell, SWT.BAR);
		Menu file = new Menu(shell, SWT.DROP_DOWN);
		Menu help = new Menu(shell, SWT.DROP_DOWN);
		MenuItem fileHeader = new MenuItem(menuBar,SWT.CASCADE);
		MenuItem helpHeader = new MenuItem(menuBar,SWT.CASCADE);
		helpHeader.setText("help");
		helpHeader.setMenu(help);
		fileHeader.setText("File");
		fileHeader.setMenu(file);
		MenuItem save = new MenuItem(file, SWT.PUSH);
		save.setText("Save");
		MenuItem load = new MenuItem(file, SWT.PUSH);
		load.setText("Load");
		MenuItem loadXMLFile = new MenuItem(file, SWT.PUSH);
		loadXMLFile.setText("Load XML File");
		MenuItem exit = new MenuItem(file, SWT.PUSH);
		exit.setText("Exit");
		MenuItem hint = new MenuItem(help, SWT.PUSH);
		hint.setText("Hint");
		MenuItem solve = new MenuItem(help, SWT.PUSH);
		solve.setText("Solve");
		shell.setMenuBar(menuBar);
		
		shell.setLayout(new GridLayout(2,false));
		
		Button Generate=new Button(shell, SWT.PUSH);
		Generate.setText("Generate");
		Generate.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 1, 1));
		
		MazeDisplayer maze=new Maze2D(shell, SWT.BORDER);		
		//MazeDisplayer maze=new Maze3D(shell, SWT.BORDER);
		maze.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true,1,2));
		
		
		
		Generate.addSelectionListener(new SelectionListener() {
			
					@Override
					public void widgetSelected(SelectionEvent arg0) {
					{
						Shell s = new Shell(display);
						s.setSize(500,300);
				 		s.setText("Generate");
				 		s.setLayout(new GridLayout(2,false));
						Label l = new Label(s, SWT.NONE);
						l.setText("name : ");
						Text t = new Text(s, SWT.BORDER);
						Label l1 = new Label(s, SWT.NONE);
						l1.setText("x size : ");
						Text t1 = new Text(s, SWT.BORDER);
						Label l2 = new Label(s, SWT.NONE);
						l2.setText("y size : ");
						Text t2 = new Text(s, SWT.BORDER);
						Label l3 = new Label(s, SWT.NONE);
						l3.setText("z size : ");
						Text t3 = new Text(s, SWT.BORDER);
						Button ok=new Button(s, SWT.PUSH);
						ok.setText("ok");
						ok.addSelectionListener(new SelectionListener() {
							
							@Override
							public void widgetSelected(SelectionEvent arg0) 
							{
								String[] x = new String[6];
								x[0] = "Generate3DMaze";
								x[1] = t.getText();
								x[2] = t1.getText();
								x[3] = t2.getText();
								x[4] = t3.getText();
								x[5] = "GUI";
								maze.setnameMaze(t.getText());
								s.close();
								mazeName=x[1];
								if((Integer.parseInt(x[2])>0)&&(Integer.parseInt(x[3])>0)&&(Integer.parseInt(x[4])>0))
								{
									setChanged();
									notifyObservers(x);
									maze.dispose();
								}
								else
									JOptionPane.showMessageDialog(null,"plz put numbers more then 0");
									
							}
							
							@Override
							public void widgetDefaultSelected(SelectionEvent arg0){} 
						});
						s.open();
					}
				};								
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});	
		
		loadXMLFile.addSelectionListener(new SelectionListener() {
			
			@SuppressWarnings("unused")
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String[] s = new String[1] ;
				s[0] = "*.xml" ;
				FileDialog fd = new FileDialog(shell) ;
				fd.setText("Load XML File");
				fd.setFilterExtensions(s);
				String fileName = fd.open();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
		
			exit.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				String[] x = new String[1];
				x[0] = "Exit";
				setChanged();
				notifyObservers(x);
				maze.dispose();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
			solve.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) 
				{
					String[] x = new String[4];
					x[0] = "Solve";
					x[1] = maze.getnameMaze()+"";
					x[2] = "Bfs";
					x[3] = "GUI";
					setChanged();
					notifyObservers(x);
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0){}
			});
			
			save.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) 
				{
					
					FileDialog fd=new FileDialog(shell,SWT.SAVE);
					fd.setText("Save");
					fd.setFilterPath("C:/Users/user/Desktop/sixteenone/alon&nevo");
					String[] filterExt = {  "*.*" };
					fd.setFilterExtensions(filterExt);
					String selected = fd.open();
                    if(selected!=null)
                    {
                    	String[] x = new String[4];
						x[0] = "SaveMaze";
						x[1] = mazeName;
						x[2] = selected;;
						x[3] = "GUI";
						setChanged();
						notifyObservers(x);
						maze.dispose();
                    }
					/*Shell s1 = new Shell(display);
					s1.setSize(500,300);
			 		s1.setText("saveMaze");
			 		s1.setLayout(new GridLayout(2,false));
					Label l = new Label(s1, SWT.NONE);
					l.setText("name of file to save: ");
					Text t = new Text(s1, SWT.BORDER);
					Label l1 = new Label(s1, SWT.NONE);
					l1.setText("name of the maze you want to save : ");
					Text t1 = new Text(s1, SWT.BORDER);
					Button ok=new Button(s1, SWT.PUSH);
					ok.setText("ok");
					ok.addSelectionListener(new SelectionListener() {
						
						@Override
						public void widgetSelected(SelectionEvent arg0) 
						{
							String[] x = new String[4];
							x[0] = "SaveMaze";
							x[1] = t1.getText();
							x[2] = t.getText();
							x[3] = "GUI";
							maze.setnameMaze(t1.getText());
							s1.close();
							setChanged();
							notifyObservers(x);
							maze.dispose();
						}
						
						@Override
						public void widgetDefaultSelected(SelectionEvent arg0){} 
					});
					s1.open();*/
			};							
		
		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {}
	});	
		
			hint.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) 
				{
					String[] x = new String[4];
					x[0] = "Hint";
					x[1] = maze.getnameMaze()+"";
					x[2] = "Bfs";
					x[3] = md.getCharachterPos().toString();
					setChanged();
					notifyObservers(x);
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0){}
			});
	
			
			load.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) 
				{
					FileDialog fd=new FileDialog(shell,SWT.OPEN);
					fd.setText("Load");
					fd.setFilterPath("C:/Users/user/Desktop/sixteen/alon&nevo");
					String[] filterExt = {  "*.*" };
					fd.setFilterExtensions(filterExt);
					String selected = fd.open();
                    if(selected!=null)
                    {
                    	String[] x = new String[4];
						x[0] = "LoadMaze";
						x[1] = selected;
						x[2] =  mazeName;
						x[3] = "GUI";
						maze.setnameMaze(x[1]);
						setChanged();
						notifyObservers(x);
						maze.dispose();
                    }
					/*Shell s1 = new Shell(display);
					s1.setSize(500,300);
			 		s1.setText("saveMaze");
			 		s1.setLayout(new GridLayout(2,false));
					Label l = new Label(s1, SWT.NONE);
					l.setText("name of file to load: ");
					Text t = new Text(s1, SWT.BORDER);
					Label l1 = new Label(s1, SWT.NONE);
					l1.setText("name of the maze you want to load : ");
					Text t1 = new Text(s1, SWT.BORDER);
					Button ok=new Button(s1, SWT.PUSH);
					ok.setText("ok");
					ok.addSelectionListener(new SelectionListener() {
						
						@Override
						public void widgetSelected(SelectionEvent arg0) 
						{
							String[] x = new String[4];
							x[0] = "LoadMaze";
							x[1] = t.getText();
							x[2] = t1.getText();
							x[3] = "GUI";
							maze.setnameMaze(t.getText());
							s1.close();
							setChanged();
							notifyObservers(x);
							maze.dispose();
						}
						
						@Override
						public void widgetDefaultSelected(SelectionEvent arg0){} 
					});
					s1.open();*/
			};								
		
		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {}
	});	
	}
	
	
	
	public static void main(String[] args) {
		MazeWindow win=new MazeWindow("maze example", 500, 300);
		win.run();
	}

}
