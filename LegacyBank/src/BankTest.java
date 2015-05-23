import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;


public class BankTest {

	Bank b = new Bank();
	
	double perc = 2.54 / 100;
	
	@Test
	public void test() {
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2014);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 21);
		
		Date dateOpened = myCal.getTime();
		
		assertEquals(2680.24 * perc * 0.9998810778, b.calculateInterest(new BankAccount(dateOpened, 2680.24)), 1);
	}

}
