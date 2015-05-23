import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class BestRestaurantVoteTest {

	BestRestaurantVoteCounter counter = new BestRestaurantVoteCounter();

	@Test
	public void testLevelC() throws Exception {
		counter.getGoing();
		assertEquals("C Level", counter.winningRestaurant);
	}

}
