package ViewMVP;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import presenter.Properties;

public class SettingsWindow extends BasicWindow {

	private Properties settings;
	public SettingsWindow(String title, int width, int height) {
		super(title, width, height);
	  settings= new Properties();
	}

	@Override
	void initWidgets() 
	{
		shell.setLayout(new GridLayout(2,false));
		Button load=new Button(shell, SWT.PUSH);
		load.setText("Load");
		load.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 1, 1));
		Button create=new Button(shell, SWT.PUSH);
		create.setText("Create");
		create.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 1, 1));
		Button play=new Button(shell, SWT.PUSH);
		play.setText("Play");
		play.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 1, 1));
        play.setEnabled(false);
	    load.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) 
			{
				FileDialog fd=new FileDialog(shell,SWT.OPEN);
				fd.setText("Load XML");
				fd.setFilterPath("C:/Users/user/Desktop/sixteenone/alon&nevo");
				String[] filterExt = {"*.xml"};
				fd.setFilterExtensions(filterExt);
				String selected = fd.open();
                if(selected!=null)
                {
                	String x = selected;
                    setChanged();
					notifyObservers(x);
					play.setEnabled(true);
					
                }
			
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
	    create.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				Shell s1 = new Shell(display);
				s1.setSize(500,300);
		 		s1.setText("New Settings");
		 		s1.setLayout(new GridLayout(2,false));
		 		Label l = new Label(s1, SWT.NONE);
				l.setText("Number of threads : ");
				String[] num_of_Threads = "1 2 3 4 5 6 7 8 9 10".split(" ");
				Combo combo = new Combo(s1, SWT.DROP_DOWN | SWT.READ_ONLY);
				combo.setItems(num_of_Threads);
                Label l1 = new Label(s1, SWT.NONE);
				l1.setText("Generate algorithm: ");
		 		String[] GAlgorithms = "MyAlgorithm Simple".split(" ");
				Combo combo2 = new Combo(s1, SWT.DROP_DOWN | SWT.READ_ONLY);
				combo2.setItems(GAlgorithms);
                Label l2 = new Label(s1, SWT.NONE);
				l2.setText("Search algorithm: ");
		 		String[] SAlgorithms = "Bfs A*".split(" ");
				Combo combo3 = new Combo(s1, SWT.DROP_DOWN | SWT.READ_ONLY);
				combo3.setItems(SAlgorithms);
                Label l3 = new Label(s1, SWT.NONE);
				l3.setText("Interface: ");
		 		String[] Iterfaces = "CLI GUI".split(" ");
				Combo combo4 = new Combo(s1, SWT.DROP_DOWN | SWT.READ_ONLY);
				combo4.setItems(Iterfaces);
				Button ok=new Button(s1, SWT.PUSH);
				ok.setText("ok"); 
				s1.open();
                ok.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
					 if(combo.getText()!=""&&combo2.getText()!=""&&combo3.getText()!=""&&combo4.getText()!="")
						{
							settings.setNumberOfThread(Integer.valueOf(combo.getText()));
							settings.setAlgocreate(combo2.getText());
							settings.setDefultSolAlgo(combo3.getText());
							settings.setView(combo4.getText());
							setChanged();
							notifyObservers(settings);
							FileDialog fd=new FileDialog(s1,SWT.SAVE);
							fd.setText("Save settings");
							fd.setFilterPath("C:/Users/user/Desktop/sixteenone/alon&nevo");
							String[] filterExt = {"*.xml"};
							fd.setFilterExtensions(filterExt);
							String selected = fd.open();
							if(selected!=null)
							{
								System.out.println("Selected not null");
								System.out.println(selected);
								String[] x= new String[2];
								x[0]="SaveXML";
								x[1]=selected;
								setChanged();
								notifyObservers(x);
								play.setEnabled(true);
								
							}
						}s1.close();
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
               }
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	    play.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				 shell.dispose();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
