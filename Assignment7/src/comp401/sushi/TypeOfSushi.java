package comp401.sushi;

public abstract class TypeOfSushi
implements Sushi {

	protected Ingredient[] ingredients;
	private double cost;
	private boolean hasRice;
	private boolean hasShellfish;
	private boolean isVegetarian;

	public Ingredient[] getIngredients() {
		return ingredients.clone();
	}

	public double getCost() {
		cost = 0.0;

		for (Ingredient ingredient : ingredients) {
			cost += ingredient.getCost();
		}

		return cost;
	}

	public boolean hasRice() {
		for (Ingredient ingredient : ingredients) {
			if (ingredient.isRice() == true) {
				hasRice = true;
				break;
			}
			else {
				hasRice = false;
			}
		}

		return hasRice;
	}

	public boolean hasShellfish() {
		for (Ingredient ingredient : ingredients) {
			if (ingredient.isShellfish() == true) {
				hasShellfish = true;
				break;
			}
			else {
				hasShellfish = false;
			}
		}

		return hasShellfish;
	}

	public boolean isVegetarian() {
		for (Ingredient ingredient : ingredients) {
			if (ingredient.isVegetarian() == false) {
				isVegetarian = false;
				break;
			}
			else {
				isVegetarian = true;
			}
		}

		return isVegetarian;
	}
}