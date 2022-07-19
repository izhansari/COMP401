package a1;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class A1Jedi {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
	}

	public static void process(Scanner s) {
		String input = s.next();

		// Two hashmaps and an array are used. The two hashmaps are used to store the number
		// of items and the costs of those items. The array is used to store the items,
		// which are keys in the hashmaps and used to retrieve the values.
		Map<String, Integer> totalCount = new HashMap<String, Integer>(100);
		Map<String, Double> totalCost = new HashMap<String, Double>(100);

		String[] items;
		items = new String[100];

		int i = 0;

		double avgCost = 0;
		String avgCostItem = "";

		while (!input.equals("end")) {

			int quantity = s.nextInt();
			double unitCost = s.nextDouble();

			if (totalCount.get(input) == null || totalCost.get(input) == null) {
				totalCount.put(input, 0);
				totalCost.put(input, 0.0);
			}

			int count = totalCount.get(input) + quantity;
			double cost = totalCost.get(input) + quantity * unitCost;
			totalCount.put(input, count);
			totalCost.put(input, cost);

			items[i] = input;
			i++;

			input = s.next();
		}

		int largestCount = 0;
		String largestCountItem = "";

		double largestCost = 0;
		String largestCostItem = "";

		for (int j = 0; j < items.length; j++) {

			if (items[j] != null) {
				if (totalCount.get(items[j]) >= largestCount) {
					largestCount = totalCount.get(items[j]);
					largestCountItem = items[j];
				}

				if (totalCost.get(items[j]) >= largestCost) {
					largestCost = totalCost.get(items[j]);
					largestCostItem = items[j];
				}

				if (totalCost.get(items[j]) / totalCount.get(items[j]) >= avgCost) {
					avgCost = totalCost.get(items[j])
							/ totalCount.get(items[j]);
					avgCostItem = items[j];
				}
			}
		}

		System.out.printf("The largest count item with %d was: %s%n",
				largestCount, largestCountItem);
		System.out.printf("The largest total cost item at %f was: %s%n",
				largestCost, largestCostItem);
		System.out.printf("The largest average cost item at %f was: %s",
				avgCost, avgCostItem);
	}
}