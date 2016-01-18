package ViewMVP;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;

public class MessageWin extends BasicWindow
{

	public MessageWin(String title, int width, int height) {
		super(title, width, height);
		// TODO Auto-generated constructor stub
	}

		@Override
		void initWidgets() 
		{
			shell.setLayout(new GridLayout(1,true));
		}
			
		public void display(String x)
		{
			Text text = new Text(shell, SWT.BORDER);
			text.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
			text.setText(x);
		}
	}

