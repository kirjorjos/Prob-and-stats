package StatsLibrary;

import java.util.ArrayList;
import java.util.Random;

public class StatsLibraryTester {

	public static void main(String args[]) {
		Random rand = new Random();
		ArrayList<Integer> intList = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			intList.add(rand.nextInt(1000));
		}

		System.out.print("List: ");
		System.out.println(intList);
		System.out.printf("Mean: %d%n", StatsLibrary.mean(intList));
		System.out.printf("Median: %d%n", StatsLibrary.median(intList));
		System.out.printf("Mode: %d%n", StatsLibrary.mode(intList));
	}
}