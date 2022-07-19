package comp401.sushi;

public abstract class TypeOfIngredient
implements Ingredient {

	private double amount;
	private double cost;
	private boolean isRice;
	private boolean isShellfish;
	private boolean isVegetarian;
	private String name;

	public TypeOfIngredient(double pricePerOunce,
			double amount,
			boolean isRice,
			boolean isShellfish,
			boolean isVegetarian,
			String name) {

		if(amount <= 0.0) {
			throw new RuntimeException("Amount should be greater than zero");
		}

		this.amount = amount;
		this.cost = pricePerOunce * amount;
		this.isRice = isRice;
		this.isShellfish = isShellfish;
		this.isVegetarian = isVegetarian;
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public double getCost() {
		return cost;
	}

	public boolean isRice() {
		return isRice;
	}

	public boolean isShellfish() {
		return isShellfish;
	}

	public boolean isVegetarian() {
		return isVegetarian;
	}

	public String getName() {
		return name;
	}
}