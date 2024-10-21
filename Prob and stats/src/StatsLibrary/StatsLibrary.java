package StatsLibrary;

import java.util.ArrayList;

public class StatsLibrary {
	public static Double mean(ArrayList<Double> inputList) {
		double total = 0;
		for (Double element : inputList) {
			total+=element;
		}
		return (total/inputList.size());
	}
}
