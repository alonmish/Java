package io;

import java.io.IOException;
import java.io.InputStream;

/**
 * this class is used InputStream to read from file
 * @param in is the InputStream we used to read from the file
 */
public class MyDecompressorInputStream extends InputStream 
{
	private InputStream in;
	
	/**
	 * this is default contractor for the class does nothing
	 * @return nothing
	 */
	public MyDecompressorInputStream()
	{
		
	}
	
	/**
	 * this is default contractor for the class that used InputStream to put in our InputStream
	 * @param i is the InputStream we put in our
	 * @return nothing
	 */
	public MyDecompressorInputStream(InputStream i)
	{
		this.in = i;
	}
	
	/**
	 * this method is bring us the InputStream
	 * @return InputStream
	 */
	public InputStream getIn()
	{
		return in;
	}
	
	/**
	 * this method is set us the InputStream by using him
	 * @param in is the InputStream we put in ours
	 * @return nothing
	 */
	public void setIn(InputStream in) 
	{
		this.in = in;
	}
	
	/**
	 * this method is read from the file array of bytes and bring us what he read
	 * @param b is the array we want to read
	 * @return int
	 */
	@Override
	public int read(byte[] b) throws IOException
	{
		byte by ;
		int temp ;
		int count = 0 ;
		int i =0;
		while( (temp = in.read()) != -1) {
			by =  new Integer(temp).byteValue() ;
			count = in.read() ;
			while(count>0)
			{
				b[i] = by ;
				count-- ;
				i++ ;
			}
		}
		
		return 1 ;
	}
	
	/**
	 * this method is read from the file and bring us what he get
	 * @return int
	 */
	@Override
	public int read() throws IOException 
	{		
		return (int)in.read();
		
	}
	
	

}
