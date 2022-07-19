package a2jedi;

public class InvoiceItem {
	private String name;
	private double price_per_unit;
	private int unit_count;
	private double cost;

	public InvoiceItem(String name, double price_per_unit, int unit_count) {

		name = name.trim();

		// Before any values are assigned to the instance variables, every
		// condition is checked to make sure that no rules were broken.
		// Only after we have done that do we assign values to the instance
		// variables.
		if (name.isEmpty() || !Character.isUpperCase(name.charAt(0))
				|| checkAlphaNumeric(name) || price_per_unit <= 0
				|| unit_count <= 0) {
			throw new RuntimeException("Illegal invoice item");
		}
		else {
			this.name = name;
			this.price_per_unit = price_per_unit;
			this.unit_count = unit_count;
			this.cost = price_per_unit * unit_count;
		}
	}

	// This helper method converts the name of the item into a character array
	// and checks to see if any of the characters in the array are not
	// alphanumeric. As soon as it finds a character that is not alphanumeric it
	// returns true.
	private boolean checkAlphaNumeric(String name) {
		char[] nameArray = name.toCharArray();
		for (char s : nameArray) {
			if (!Character.isLetterOrDigit(s)) {
				return true;
			}
		}

		return false;
	}

	public String getName() {
		return name;
	}

	public double getPricePerUnit() {
		return price_per_unit;
	}

	public int getUnitCount() {
		return unit_count;
	}

	public double getCost() {
		return cost;
	}
}