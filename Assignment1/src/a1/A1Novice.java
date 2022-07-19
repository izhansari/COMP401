package a1;

import java.util.Scanner;

public class A1Novice {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
	}

	public static void process(Scanner s) {
		int count = s.nextInt();

		int highestQuantity = 0;
		String itemHighestQuantity = "";

		double highestCost = 0;
		String itemHighestCost = "";

		double totalCost = 0;
		int totalQuantityItems = 0;

		for (int i = 1; i <= count; i++) {
			String item = s.next();
			int quantity = s.nextInt();
			double unitCost = s.nextDouble();

			if (quantity >= highestQuantity) {
				itemHighestQuantity = item;
				highestQuantity = quantity;
			}

			if (quantity * unitCost >= highestCost) {
				itemHighestCost = item;
				highestCost = quantity * unitCost;
			}

			totalCost = totalCost + quantity * unitCost;
			totalQuantityItems = totalQuantityItems + quantity;
		}

		System.out.println("The largest quantity item was: "
				+ itemHighestQuantity);
		System.out.println("The largest cost item was: " + itemHighestCost);
		System.out.println("Total cost: " + totalCost);
		System.out.println("Average cost: " + totalCost / totalQuantityItems);
	}
}