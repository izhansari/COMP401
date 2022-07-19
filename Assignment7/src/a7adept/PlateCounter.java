package a7adept;

import comp401.sushi.Plate;
import java.util.Observable;
import java.util.Observer;

public class PlateCounter
implements Observer{

	private int redPlateCount;
	private int greenPlateCount;
	private int bluePlateCount;
	private int goldPlateCount;

	public PlateCounter() {

	}

	// Depending on whether a plate is added or removed, a different
	// if statement is called which finds the color of the plate and
	// increments/decrements the appropriate counter.
	public void update(Observable o, Object arg) {
		PlateEvent action = (PlateEvent) arg;

		if (action.getType() == PlateEvent.EventType.PLATE_PLACED) {

			if (action.getPlate().getColor() == Plate.Color.RED) {
				redPlateCount++;
			}
			if (action.getPlate().getColor() == Plate.Color.GREEN) {
				greenPlateCount++;
			}
			if (action.getPlate().getColor() == Plate.Color.BLUE) {
				bluePlateCount++;
			}
			if (action.getPlate().getColor() == Plate.Color.GOLD) {
				goldPlateCount++;
			}
		}

		if (action.getType() == PlateEvent.EventType.PLATE_REMOVED) {

			if (action.getPlate().getColor() == Plate.Color.RED) {
				redPlateCount--;
			}
			if (action.getPlate().getColor() == Plate.Color.GREEN) {
				greenPlateCount--;
			}
			if (action.getPlate().getColor() == Plate.Color.BLUE) {
				bluePlateCount--;
			}
			if (action.getPlate().getColor() == Plate.Color.GOLD) {
				goldPlateCount--;
			}
		}
	}

	public int getRedPlateCount() {
		return redPlateCount;
	}

	public int getGreenPlateCount() {
		return greenPlateCount;
	}

	public int getBluePlateCount() {
		return bluePlateCount;
	}

	public int getGoldPlateCount() {
		return goldPlateCount;
	}
}