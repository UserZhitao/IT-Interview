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


		 BlackBoxJunitTest test1 = new  BlackBoxJunitTest();
		 BlackBoxDemo. testOfEqualClass(-10,30);
		 }

	@Test
	public void testTestOfEqualClass() {
		BlackBoxDemo. testOfEqualClass(-10,30);
	       
	}
	
@Test
	public void testTestOfBoundry() {
		BlackBoxDemo.testOfBoundry(-10,30,29);
	}


	@Test
	public void testTestOfRandom() {
		BlackBoxDemo. testOfRandom(-10,30,5);
	}

}
