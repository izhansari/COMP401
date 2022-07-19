package a4;

import java.util.ArrayList;
import java.util.Arrays;

public class Roll
extends TypeOfSushi {

private ArrayList<Ingredient> tempIngredients;
private int[] repeats;

	public Roll(Ingredient[] rollIngredients) {

		// An arraylist is created from the given parameter array and used instead
		// because it is easier for us to manipulate.
		tempIngredients =
				new ArrayList<Ingredient>(Arrays.asList(rollIngredients.clone()));

		for (Ingredient ingredient : tempIngredients) {
			if (ingredient == null) {
				throw new RuntimeException("You cannot have a null ingredient.");
			}
		}

		// The repeats array will be used in the findIngredient() method to store the
		// index of every repeat of whichever ingredient we are checking for. The repeats
		// array has a size that is the same as the tempIngredients array list to allow
		// for the case that every ingredient in the given sushi is a repeat.
		// In addition, repeats is filled with -1's to help us later on.
		repeats = new int[tempIngredients.size()];
		Arrays.fill(repeats, -1);

		tempIngredients = repeatedIngredients(tempIngredients);
		tempIngredients = hasSeaweed(tempIngredients);

		// After we are done manipulating the tempIngredients arraylist, we create an
		// Ingredient array and populate it with the elements of tempIngredients.
		Ingredient[] ingredients = new Ingredient[tempIngredients.size()];
		ingredients = tempIngredients.toArray(ingredients);

		this.ingredients = ingredients;
	}

	// The repeatedIngredients() method passes along the name of the current ingredient
	// it is checking to this findIngredient() method. Then findIngredient() goes
	// through every element in the tempIngredients arraylist (a for loop is used instead
	// of a for-each loop because it is easier to get the indexes of the elements we want
	// this way) and stores the index of every ingredient whose name matches the String
	// parameter that was given. If more than one match was found, findIngredient() returns
	// true. If not, this means that only one ingredient of this type exists and so it
	// returns false.
	private boolean findIngredient(String name) {
		int counter = 0;

		for (int i = 0; i < tempIngredients.size(); i++) {
			if (tempIngredients.get(i).getName().equals(name)) {
				repeats[counter] = i;
				counter++;
			}
		}

		if (counter > 1) {
			return true;
		}

		return false;
	}

	private ArrayList<Ingredient> repeatedIngredients(ArrayList<Ingredient> tempIngredients) {

		// A for-each loop is not used because we are manipulating the arraylist as we are
		// iterating through it.
		for (int i = 0; i < tempIngredients.size(); i++) {
			while (findIngredient(tempIngredients.get(i).getName())) {
				double newAmount = 0;

				for (int j = 0; j < repeats.length; j++) {

					// The reason we filled the repeats array with -1's earlier was because
					// the default value that would have populated all the empty spaces inside
					// the array was 0, and 0 is a legitimate index that should be checked while
					// -1 is not.
					if (repeats[j] != -1) {
						newAmount += tempIngredients.get(repeats[j]).getAmount();
					}
					else {
						break;
					}
				}

				switch (tempIngredients.get(i).getName()) {
					case "avocado":
						tempIngredients.add(new Avocado(newAmount));
						break;

					case "crab":
						tempIngredients.add(new Crab(newAmount));
						break;

					case "eel":
						tempIngredients.add(new Eel(newAmount));
						break;

					case "rice":
						tempIngredients.add(new Rice(newAmount));
						break;

					case "salmon":
						tempIngredients.add(new Salmon(newAmount));
						break;

					case "seaweed":
						tempIngredients.add(new Seaweed(newAmount));
						break;

					case "shrimp":
						tempIngredients.add(new Shrimp(newAmount));
						break;

					case "tuna":
						tempIngredients.add(new Tuna(newAmount));
						break;
				}

				for (int j = repeats.length - 1; j >= 0; j--) {
					if (repeats[j] != -1) {
						tempIngredients.remove(repeats[j]);
					}
				}
			}
		}

		return tempIngredients;
	}

	private ArrayList<Ingredient> hasSeaweed(ArrayList<Ingredient> tempIngredients) {
		boolean foundSeaweed = false;

		for (int i = 0; i < tempIngredients.size(); i++) {
			if (tempIngredients.get(i).getName().equals("seaweed")) {
				foundSeaweed = true;
				if (tempIngredients.get(i).getAmount() < 0.1) {
					tempIngredients.remove(tempIngredients.get(i));;
					tempIngredients.add(new Seaweed(0.1));
				}
			}
		}

		if (!foundSeaweed) {
			tempIngredients.add(new Seaweed(0.1));
		}

		return tempIngredients;
	}
}