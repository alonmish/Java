package io;
import java.io.IOException;
import java.io.OutputStream;


/**
 * this class is used OutputStream to write to file
 * @param out is the OutputStream we used to put in the file
 */
public class MyCompressorOutputStream extends OutputStream
{
	private OutputStream out;
	
	/**
	 * this is default contractor for the class does nothing
	 * @return nothing
	 */
	public MyCompressorOutputStream()
	{
		
	}
	
	/**
	 * this is default contractor for the class that used OutputStream to put in our OutputStream
	 * @param o is the OutputStream we put in our
	 * @return nothing
	 */
	public MyCompressorOutputStream(OutputStream o)
	{
		this.out = o;
	}
	
	/**
	 * this method is bring us the OutputStream
	 * @return OutputStream
	 */
	public OutputStream getOut() {
		return out;
	}
	
	/**
	 * this method is set us the OutputStream by using him
	 * @param out is the OutputStream we put in ours
	 * @return nothing
	 */
	public void setOut(OutputStream out) {
		this.out = out;
	}
	
	/**
	 * this method is writing to file he gets int that he write it
	 * @param arg0 this is the value we write in the file
	 * @return nothing
	 */
	@Override
	public void write(int arg0) throws IOException
	{
		out.write(arg0);
	}
	
	/**
	 * this method is writing to file he gets array of bytes that he write it
	 * @param b this is the array value we write in the file
	 * @return nothing
	 */
	@Override
	public void write(byte[] b) throws IOException
	{
		byte prev  = 0  ; 
		int count = 0 ;
		for (int i = 0; i < b.length; i++) 
		{
			prev= b[i] ;
			count = 0;
			
			while(b[i] == prev)
			{
				i++ ;
				count++ ;
				if(i>=b.length)
				{
					out.write(prev);
					out.write(count);
					return ;
				}
				if(count == 127)
				{
					out.write(prev);
					out.write(count);
					count =0 ; 
				}
			}
			i-- ;
			out.write(prev);
			out.write(count);
	}
		
	
}
}

