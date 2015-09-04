import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.setmore.myapp.DateFetcher;

import junit.framework.TestCase;
//import com.setmore.myapp.*;


public class DateFetcherTest extends TestCase {
	
	public void testOne() {

		DateFetcher dateFetcher = new DateFetcher();
		int result = dateFetcher.addOne(5);

		assertEquals(result, 6);
	}
	
	public void testTwo() {

		HashMap map = new HashMap();
		
		map.put("one", "test1");
		map.put("two", "test1");
		map.put(null, "test1");
		
		Set keys = map.keySet();
		Iterator iter = keys.iterator();
		String key = "";
		boolean isNull = false;
		while(iter.hasNext()) {
			key = (String) iter.next();
			if(key == null) {
				isNull = true;
				System.out.println("WHOA!  NULL VALUE!!!!");
			}
		}
		assertEquals(isNull, false);
	}
	
	
	public static void main(String args[]) {
		DateFetcherTest dateFetcherTest = new DateFetcherTest();
		dateFetcherTest.testOne();
		dateFetcherTest.testTwo();
	}
}