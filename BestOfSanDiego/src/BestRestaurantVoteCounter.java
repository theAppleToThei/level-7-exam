import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class BestRestaurantVoteCounter {
	String winningRestaurant;
	
	public static void main(String[] args) throws IOException {
		new BestRestaurantVoteCounter().getGoing();
	}

	public void getGoing() throws IOException {
		URL fileWithVotes = getClass().getResource("sample-votes.txt");

		ArrayList<String> votes = new ArrayList();
		Scanner scanner = new Scanner(fileWithVotes.openStream());

		while (scanner.hasNextLine()) {
			votes.add(scanner.nextLine());
		}
		scanner.close();

		int votesForSangDeuan = 0, votesForOceanaCoastalKitchen = 0, votesForWerewolf = 0, votesForHomeAndAway = 0, votesForCLevel = 0;
		for (String vote : votes) {
			if (matchesSangDeuan(vote))
				votesForSangDeuan++;
			if (matchesOceanaCoastalKitchen(vote))
				votesForOceanaCoastalKitchen++;
			if (matchesWerewolf(vote))
				votesForWerewolf++;
			if (matchesHomeAndAway(vote))
				votesForHomeAndAway++;
			if (matchesCLevel(vote))
				votesForCLevel++;
		}

		winningRestaurant = calculateWinner(votesForSangDeuan, votesForOceanaCoastalKitchen, votesForWerewolf, votesForHomeAndAway, votesForCLevel);
		System.out.println("Reader's favorite restaurant is: "  + winningRestaurant);
		//TODO: Tweet the result.
	}

	private String calculateWinner(int votesForSangDeuan, int votesForOceanaCoastalKitchen, int votesForWerewolf, int votesForHomeAndAway, int votesForCLevel) {
		int mostVotes = 0;
		String winningRestaurant = null;
		if (votesForSangDeuan > mostVotes) {
			mostVotes = votesForSangDeuan;
			winningRestaurant = "Sang Deuan";
		}
		if (votesForOceanaCoastalKitchen > mostVotes) {
			mostVotes = votesForOceanaCoastalKitchen;
			winningRestaurant = "Oceana Coastal Kitchen";
		}
		if (votesForWerewolf > mostVotes) {
			mostVotes = votesForWerewolf;
			winningRestaurant = "Werewolf";
		}
		if (votesForHomeAndAway > mostVotes) {
			mostVotes = votesForHomeAndAway;
			winningRestaurant = "Home & Away";
		}
		if (votesForCLevel > mostVotes) {
			mostVotes = votesForCLevel;
			winningRestaurant = "C Level";
		}
		return winningRestaurant;
	}

	boolean matchesSangDeuan(String possibleMatch) {
		if (possibleMatch.equalsIgnoreCase("Sang Deuan") || possibleMatch.equalsIgnoreCase("Sang Duan"))
			return true;
		else
			return false;
	}

	boolean matchesOceanaCoastalKitchen(String possibleMatch) {
		if (possibleMatch.equalsIgnoreCase("Oceana Coastal Kitchen") || possibleMatch.equalsIgnoreCase("Ocean Coastal"))
			return true;
		else
			return false;
	}

	boolean matchesWerewolf(String possibleMatch) {
		if (possibleMatch.equalsIgnoreCase("Wherewolf") || possibleMatch.equalsIgnoreCase("Werewolf"))
			return true;
		else
			return false;
	}

	boolean matchesHomeAndAway(String possibleMatch) {
		if (possibleMatch.equalsIgnoreCase("HomeAndAway") || possibleMatch.equalsIgnoreCase("Home And Away") || possibleMatch.equalsIgnoreCase("Home & Away"))
			return true;
		else
			return false;
	}

	boolean matchesCLevel(String possibleMatch) {
		if (possibleMatch.substring(0, 7).equalsIgnoreCase("C Level") || possibleMatch.substring(0, 7).equalsIgnoreCase("c-level") || possibleMatch.substring(0, 7).equalsIgnoreCase("c level lounge"))
//		if (possibleMatch.equalsIgnoreCase("C Level") || possibleMatch.equalsIgnoreCase("c-level") || possibleMatch.equalsIgnoreCase("c level lounge"))
			return true;
		else
			return false;
	}

}
