package StatsLibrary;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import SetOperations.SetOperations;

public class StatsLibrary {
	/**
	 * A method to find the mean of an ArrayList
	 * @param inputList The list to find the mean of
	 * @return The mean of the input list
	 */
	public static Integer mean(ArrayList<Integer> inputList) {
		Integer total = 0;
		for (Integer element : inputList) {
			total+=element;
		}
		return (total/inputList.size());
	}
	
	/**
	 * A method to find the median of an ArrayList
	 * @param inputList The list to find the median of
	 * @return The median of the list
	 */
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
	
	/**
	 * A method to find the mode of a list
	 * @param inputList The list to find the mode of
	 * @return The mode of the list
	 */
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
	
	/**
	 * A method to find the variance of a list
	 * @param inputList The list to find the variance of
	 * @return The variance of the list
	 */
	public static Double variance(ArrayList<Integer> inputList) {
		double sum = 0;
		int mean = mean(inputList);
		for (int i = 0; i < inputList.size(); i++) {
			sum+=Math.pow(inputList.get(i)-mean, 2);
		}
		return (sum/(inputList.size()-1));
	}
	
	/**
	 * A method to find the Standard Deviation of a list
	 * @param inputList The list to find the Standard Deviation of
	 * @return The Standard Deviation of the list
	 */
	public static Double stdev(ArrayList<Integer> inputList) {
		return Math.sqrt(variance(inputList));
	}
	
	/**
	 * A method to find the factorial of a number
	 * @param num The number to find the factorial of
	 * @return The factorial of the input number
	 */
	public static BigInteger factorial(int num) {
		BigInteger factorial = new BigInteger("0");
		for (Integer i = 1; i < num+1; i++) {
			factorial = factorial.multiply(new BigInteger(i.toString()));
		}
		return factorial;
	}
	
	/**
	 * A method to find number of arrangements of r objects with n orders
	 * @param r The number of objects
	 * @param n The number of orders
	 * @return The permutation of r and n
	 */
	public static BigInteger permutation(int r, int n) {
		BigInteger numerator = factorial(n);
		BigInteger denominator = factorial(n-r);
		return numerator.divide(denominator);
	}
	
	/**
	 * A method to find the combination of 2 numbers
	 * @param r The size of the subsets
	 * @param n The number of objects
	 * @return r choose n
	 */
	public static BigInteger combination(int r, int n) {
		return permutation(r, n).divide(factorial(r));
	}
	
	public static <E> double pOfAIntersectB(ArrayList<E> a, ArrayList<E> b, int sampleSpaceSize) {
		return SetOperations.intersect(a, b).size()/sampleSpaceSize;
	}
	
	public static <E> double pOfAGivenB(double pOfAIntersectB, double pOfB) {
		return pOfAIntersectB/pOfB;
	}
	
	public static <E> boolean independent(double pOfA, double pOfB, double pOfAGivenB, double pOfBGivenA, double pOfAIntersectB) {
		if (pOfAGivenB != pOfA) return false;
		if (pOfBGivenA != pOfB) return false;
		if (pOfAIntersectB != pOfA*pOfB) return false;
		return true;
	}
	
	public static <E> double pOfAUnionB(double pOfAIntersectB, double pOfA, double pOfB) {
		return pOfA+pOfB-pOfAIntersectB;
	}
	
	public static double inverse(double pOfA) {
		return 1-pOfA;
	}
	
	public static double bayesTheorem(double pOfAGivenB, double pOfB, double pOfA) {
		if (pOfA == 0 || pOfB == 0) throw new Error("Probability is zero");
		return (pOfAGivenB*pOfB)/pOfA;
	}
	
	public static Double probabilityExpectedValue(int n, double p, double q) {
		double sum = 0;
		for (int y = 0; y < n; y++) {
			sum+=y*Math.pow(p, y)*Math.pow(q, n-y)*(combination(n, y).doubleValue());
		}
		return sum;
	}
}