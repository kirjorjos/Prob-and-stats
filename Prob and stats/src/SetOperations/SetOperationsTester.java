package SetOperations;

import java.util.ArrayList;

public class SetOperationsTester {
	public static void main(String args[]) {
		ArrayList<Integer> setOne = new ArrayList<Integer>();
		ArrayList<Integer> setTwo = new ArrayList<Integer>();
		ArrayList<Integer> globalSet = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			setOne.add((int) Math.pow(2, i));
			if (i%2 == 0) setTwo.add(i);	//add even numbers
			globalSet.add(i);
		}
		

		System.out.printf("Set 1: %s%n", setOne);
		System.out.printf("Set 2: %s%n", setTwo);
		System.out.printf("Global Set: %s%n", globalSet);
		System.out.printf("Union: %s%n", SetOperations.union(setOne, setTwo));
		System.out.printf("Intersection: %s%n", SetOperations.intersect(setOne, setTwo));
		System.out.printf("Union: %s%n", SetOperations.union(setOne, setTwo));
		System.out.printf("Complement of set 2: %s%n", SetOperations.complement(setTwo, globalSet));
	}
}
