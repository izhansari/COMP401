package a3adept;

public class Sashimi
extends TypeOfSushi {

	public enum SashimiType {
		TUNA, SALMON, EEL, CRAB, SHRIMP
	}

	public Sashimi(SashimiType type) {
		ingredients = new Ingredient[1];

		switch (type) {
			case TUNA:
				ingredients[0] = new Tuna(0.75);
				break;

			case SALMON:
				ingredients[0] = new Salmon(0.75);
				break;

			case EEL:
				ingredients[0] = new Eel(0.75);
				break;

			case CRAB:
				ingredients[0] = new Crab(0.75);
				break;

			case SHRIMP:
				ingredients[0] = new Shrimp(0.75);
				break;
		}
	}
}