package a1;

import java.util.Scanner;

public class A1Adept {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
	}

	public static void process(Scanner s) {
		
		// A double array is used to store the count and cost of each item.
		double[][] array;
		array = new double[3][10];

		for (int i = 0; i <= 9; i++) {
			array[0][i] = ((double) i);
		}

		String input = s.next();

		while (!input.equals("end")) {
			int category = s.nextInt();
			int quantity = s.nextInt();
			double unitCost = s.nextDouble();
			double totalCost = unitCost * quantity;

			array[1][category] = array[1][category] + ((double) quantity);
			array[2][category] = array[2][category] + ((double) totalCost);

			input = s.next();
		}

		double mostItems = 0;
		double leastItems = 10000000;
		double largestCost = 0;
		double leastCost = 10000000;

		int catMostItems = 0;
		int catLeastItems = 0;
		int catLargestCost = 0;
		int catLeastCost = 0;

		for (int i = 9; i >= 0; i--) {
			if (array[1][i] >= mostItems) {
				mostItems = array[1][i];
				catMostItems = i;
			}

			if (array[1][i] != 0) {
				if (array[1][i] <= leastItems) {
					leastItems = array[1][i];
					catLeastItems = i;
				}
			}

			if (array[2][i] >= largestCost) {
				largestCost = array[2][i];
				catLargestCost = i;
			}

			if (array[2][i] != 0) {
				if (array[2][i] <= leastCost) {
					leastCost = array[2][i];
					catLeastCost = i;
				}
			}
		}

		System.out.println("Category with most items: " + catMostItems);
		System.out.println("Category with least items: " + catLeastItems);
		System.out.println("Category with largest cost: " + catLargestCost);
		System.out.println("Category with least cost: " + catLeastCost);
	}
}