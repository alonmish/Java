package algorithms.search;

import static org.junit.Assert.*;

import org.junit.Test;

public class AstarTest<T>
{
	private Heuristic<T> h;
	
	public AstarTest(Heuristic<T> h)
	{
		this.h = h;
	}
	
	@Test
	public void testCalculateCost()
	{
		if(this.h == null)
		{
			fail("ok");
		}
	}

	@Test
	public void testSearch()
	{
		if(this.h == null)
		{
			fail("ok");
		}
	}

}
