import junit.framework.TestCase;
import com.setmore.myapp.*;

public class DateFetcherTest extends TestCase {
	
	public void testOne() {

		DateFetcher dateFetcher = new DateFetcher();
		int result = dateFetcher.addOne(5);

		assertEquals(result, 6);
	}
}