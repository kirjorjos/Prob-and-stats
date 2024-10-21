package StatsLibrary;

import java.util.ArrayList;
import java.util.Random;

public class StatsLibraryTester {

	public static void main(String args[]) {
		Random rand = new Random();
		ArrayList<Double> doubleList = new ArrayList<>();
		ArrayList<Integer> intList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			doubleList.set(i, rand.nextDouble());
		}

		for (double element : doubleList) {
			intList.add((int)element);
		}

		System.out.print("List: ");
		System.out.println(doubleList);
		System.out.printf("Mean: %.2f%n", StatsLibrary.mean(doubleList));
//		System.out.printf("Median: %.2f%n", median(doubleList));
//		System.out.printf("Mode: %.2f%n", mode(intList));
	}
}