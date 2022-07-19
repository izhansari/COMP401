package a3adept;

public class Nigiri
extends TypeOfSushi {

	public enum NigiriType {
		TUNA, SALMON, EEL, CRAB, SHRIMP
	}

	public Nigiri(NigiriType type) {
		ingredients = new Ingredient[2];
		ingredients[1] = new Rice(0.5);

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