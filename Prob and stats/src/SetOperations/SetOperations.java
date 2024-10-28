package SetOperations;

import java.util.ArrayList;

public class SetOperations {

	/**
	 * A method to find the union of 2 sets
	 * @param setOne The first set
	 * @param setTwo The second set
	 * @return The union of the 2 sets
	 */
	public static <E> ArrayList<E> union(ArrayList<E> setOne, ArrayList<E> setTwo) {
		ArrayList<E> resultSet = new ArrayList<E>();
		for (E element : setOne) {
			if (!setTwo.contains(element)) resultSet.add(element);
		}
		resultSet.addAll(setTwo);
		return resultSet;
	}
	
	/**
	 * A method to find the intersection of 2 sets
	 * @param setOne The first set
	 * @param setTwo The second set
	 * @return The intersection of the 2 sets
	 */
	public static <E> ArrayList<E> intersect(ArrayList<E> setOne, ArrayList<E> setTwo) {
		ArrayList<E> resultSet = new ArrayList<E>();
		for (E element : setOne) {
			if (setTwo.contains(element)) resultSet.add(element);
		}
		return resultSet;
	}
	
	/**
	 * A method to find the complement of a set given a global set
	 * @param inputSet The set to find the complement of
	 * @param globalSet The global set
	 * @return The complement of the input set
	 */
	public static <E> ArrayList<E> complement(ArrayList<E> inputSet, ArrayList<E> globalSet) {
		ArrayList<E> resultSet = new ArrayList<E>();
		for (E element : globalSet) {
			if (!inputSet.contains(element)) resultSet.add(element);
		}
		return resultSet;
	}
}
