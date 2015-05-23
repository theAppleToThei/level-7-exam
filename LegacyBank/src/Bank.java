import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Bank {

	void updateBalances(List accounts) {
		for (Object object : accounts) {
			double xtra = calculateInterest((BankAccount) object);
			BankAccount acc = (BankAccount) object;
			acc.money = acc.money + xtra;
		}

	}

	double calculateInterest(BankAccount account) {

		Date dateOpened = account.date;
		double amount = account.getBalance();

		final double perc = 2.54 / 100;

		Calendar today = Calendar.getInstance(Locale.US);
		today.setTime(new Date());
		Calendar calOpened = Calendar.getInstance(Locale.US);
		calOpened.setTime(dateOpened);
		int currentMonth = today.get(Calendar.MONTH);
		int monthOpened = calOpened.get(Calendar.MONTH);
		int yearOpened = calOpened.get(Calendar.YEAR);
		int currentYear = today.get(Calendar.YEAR);
		int currentDate = today.get(Calendar.DATE);
		int diff = yearOpened - currentYear;
		
		if (currentMonth > monthOpened
				|| (currentMonth == monthOpened && currentDate > calOpened.get(Calendar.DATE))) {
			diff--;
		}

		if (diff < 0)
			diff *= -1;

		return diff * perc * amount;
	}

}

class BankAccount {

	Date date;
	double money;

	BankAccount(Date date, double money) {
		this.date = date;
		this.money = money;
	}

	public double getBalance() {
		return money;
	}

}
