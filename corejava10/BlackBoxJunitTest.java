import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Created by wuyupku  on 2019年4月21日16:12:11
 */
public class BlackBoxJunitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTestOfRange() {
		 BlackBoxDemo. testOfRange(30,10);
		 }

	@Test
	public void testTestOfEqualClass() {
		BlackBoxDemo. testOfEqualClass(30,10);
	       
	}
	
@Test
	public void testTestOfBoundry() {
		BlackBoxDemo.testOfBoundry(30,10,5);
	}


	@Test
	public void testTestOfRandom() {
		BlackBoxDemo. testOfRandom(30,10,50);
	}

}
