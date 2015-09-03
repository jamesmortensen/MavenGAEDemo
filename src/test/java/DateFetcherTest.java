import com.setmore.myapp.DateFetcher;

import junit.framework.TestCase;
//import com.setmore.myapp.*;


public class DateFetcherTest extends TestCase {
	
	public void testOne() {

		DateFetcher dateFetcher = new DateFetcher();
		int result = dateFetcher.addOne(5);

		assertEquals(result, 6);
	}
	
	
	public static void main(String args[]) {
		DateFetcherTest dateFetcherTest = new DateFetcherTest();
		dateFetcherTest.testOne();
	}
}