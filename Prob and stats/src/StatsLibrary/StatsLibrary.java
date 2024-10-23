package StatsLibrary;

import java.util.ArrayList;
import java.util.Arrays;

public class StatsLibrary {
	public static Integer mean(ArrayList<Integer> inputList) {
		Integer total = 0;
		for (Integer element : inputList) {
			total+=element;
		}
		return (total/inputList.size());
	}
	
	public static Integer median(ArrayList<Integer> inputList) {
		if (inputList.size()%2 == 1) {	//list length is odd, return middle
			return inputList.get(inputList.size()/2);
		} else {	//list length is even, return mean of middle 2
			int lowerIndex = inputList.size()/2;
			int higherIndex = lowerIndex+1;
			ArrayList<Integer> middleTwo = new ArrayList<Integer>();
			middleTwo.add(inputList.get(lowerIndex));
			middleTwo.add(inputList.get(higherIndex));
			return mean(middleTwo);
		}
	}
	
	public static Integer mode(ArrayList<Integer> inputList) {
		int maxTimesFound = 0;
		int largestElement = 0;
		int[] workingList = new int[inputList.get(0)];	//for a non-integer array list, make workingList a hashmap with a key type whatever type the array is and value type integer
		for (int element : inputList) {
			if (workingList.length <= element) {	//increase list size when required, can forgoe if using hashmap as described above
				workingList = Arrays.copyOf(workingList, element+1);
			}
			int timesElementHit = workingList[element];
			timesElementHit++;
			if (timesElementHit -1 <= maxTimesFound) {
				largestElement = element;
				maxTimesFound = timesElementHit;
			}
			workingList[element] = timesElementHit;
		}
		return largestElement;
	}
	
	public static Double stdev(ArrayList<Integer> inputList) {
		int mean = mean(inputList);
		double sum = 0;
		for (int i = 0; i < inputList.size(); i++) {
			sum+=(Math.pow(inputList.get(i)-mean, 2));
		}
		return Math.sqrt(sum/(inputList.size()-1));
	}
}