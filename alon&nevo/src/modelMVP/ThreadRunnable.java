package modelMVP;

/**
 * the class that connect between the interface runnable
 * and the interface task
 * @return nothing
 */
public class ThreadRunnable implements Runnable 
{
	private Task t;
	
	/**
	 * the constructor is using task to put in our task
	 * @param t is the task we want to put in our
	 * @return nothing
	 */
	public ThreadRunnable(Task t) 
	{
		this.t= t;
	}
	
	/**
	 * the function that starting "do task"
	 * @return nothing
	 */
	@Override
	public void run() 
	{
		t.doTask();
	}

}
