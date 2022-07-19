package a7jedi;

import comp401.sushi.*;
import java.util.Observable;
import java.util.Observer;

public class SpoilageCollector
implements Observer {

	private double totalSpoiledCost;
	private double totalSpoiledShellfish;
	private double totalSpoiledSeafood;
	private double totalSpoiledFood;

	public SpoilageCollector() {}

	public void update(Observable o, Object arg) {
		PlateEvent action = (PlateEvent) arg;
		Belt belt = (Belt) o;

		if (action.getType() == PlateEvent.EventType.PLATE_SPOILED) {
			totalSpoiledCost += action.getPlate().getContents().getCost();
			
			for (Ingredient ingredient :
				action.getPlate().getContents().getIngredients()) {

				if (ingredient.isShellfish()) {
					totalSpoiledShellfish += ingredient.getAmount();
				}

				if (ingredient.getName().equals("crab") ||
						ingredient.getName().equals("shrimp") ||
						ingredient.getName().equals("salmon") ||
						ingredient.getName().equals("tuna") ||
						ingredient.getName().equals("eel")) {

					totalSpoiledSeafood += ingredient.getAmount();
				}

				totalSpoiledFood += ingredient.getAmount();
			}

			belt.removePlateAtPosition(action.getPosition());
		}
	}

	public double getTotalSpoiledCost() {
		return totalSpoiledCost;
	}

	public double getTotalSpoiledShellfish() {
		return totalSpoiledShellfish;
	}

	public double getTotalSpoiledSeafood() {
		return totalSpoiledSeafood;
	}

	public double getTotalSpoiledFood() {
		return totalSpoiledFood;
	}
}