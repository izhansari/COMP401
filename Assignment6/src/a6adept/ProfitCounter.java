package a6adept;

import java.util.Observable;
import java.util.Observer;

public class ProfitCounter
implements Observer{

	private double totalBeltProfit;
	private int numberOfPlates;

	public ProfitCounter() {

	}

	// Depending on whether a plate is added or removed, the profit
	// from that plate is added/subtracted to the total profit of
	// the belt we are keeping track of. We also keep track of the
	// total number of plates that are on the belt so that we can
	// easily calculate the average profit of the belt later on.
	public void update(Observable o, Object arg) {
		PlateEvent action = (PlateEvent) arg;

		if (action.getType() == PlateEvent.EventType.PLATE_PLACED) {
			totalBeltProfit += (action.getPlate().getProfit());
			numberOfPlates++;
		}

		if (action.getType() == PlateEvent.EventType.PLATE_REMOVED) {
			totalBeltProfit -= (action.getPlate().getProfit());
			numberOfPlates--;
		}
	}

	public double getTotalBeltProfit() {
		return totalBeltProfit;
	}

	public double getAverageBeltProfit() {
		return numberOfPlates == 0 ? 0 : totalBeltProfit/numberOfPlates;
	}
}