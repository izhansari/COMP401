package a6jedi;

import comp401.sushi.Plate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BeltIterator
implements Iterator<Plate> {

	private Belt belt;
	private int startPosition;
	private int beltSize;
	private int nextCounter;

	// This is to store the position of the plate returned by next(), so that
	// remove() can remove it if called. The reason we use Integer and not int
	// is so that we can are able to set the value to null.
	private Integer nextPlatePosition;

	private boolean checkMaxPrice;
	private double maxPrice;
	private boolean checkColorFilter;
	private Plate.Color colorFilter;

	public BeltIterator(Belt belt, int startPosition) {
		this.belt = belt;
		this.startPosition = belt.alterPosition(startPosition);
		this.beltSize = belt.getSize();
		this.nextCounter = this.startPosition;
	}

	public BeltIterator(Belt belt, int startPosition,
			double maxPrice) {

		this.belt = belt;
		this.startPosition = belt.alterPosition(startPosition);
		this.beltSize = belt.getSize();
		this.nextCounter = this.startPosition;
		this.checkMaxPrice = true;
		this.maxPrice = maxPrice;
	}

	public BeltIterator(Belt belt, int startPosition,
			Plate.Color colorFilter) {

		this.belt = belt;
		this.startPosition = belt.alterPosition(startPosition);
		this.beltSize = belt.getSize();
		this.nextCounter = this.startPosition;
		this.checkColorFilter = true;
		this.colorFilter = colorFilter;
	}

	// Depending on which constructor was called, only one (or none) of the boolean
	// variables we created to check if a condition is imposed will be true (since
	// the default value for a boolean is false).
	public boolean hasNext() {

		if (checkMaxPrice) {
			for (int i = startPosition; i < beltSize; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getPrice() <= maxPrice) {

					return true;
				}
			}

			for (int i = 0; i < startPosition; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getPrice() <= maxPrice) {

					return true;
				}
			}

			return false;
		}

		else if (checkColorFilter) {
			for (int i = startPosition; i < beltSize; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getColor() == colorFilter) {

					return true;
				}
			}

			for (int i = 0; i < startPosition; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getColor() == colorFilter) {

					return true;
				}
			}

			return false;
		}

		else {
			for (int i = startPosition; i < beltSize; i++) {
				if (belt.getPlateAtPosition(i) != null) {
					return true;
				}
			}

			for (int i = 0; i < startPosition; i++) {
				if (belt.getPlateAtPosition(i) != null) {
					return true;
				}
			}

			return false;
		}
	}

	// Depending on which constructor was called, only one (or none) of the boolean
	// variables we created to check if a condition is imposed will be true (since
	// the default value for a boolean is false). The position of the last plate
	// iterated over by next() is stored in nextPlatePosition. The reason we have
	// nextCounter and why we start the for-loop there is because once next() is called
	// and returns a plate, we want next() to start its iteration beginning with the next
	// spot on the belt. That is why we set it to i+1, because if the for-loop starts at i,
	// the position of the last plate returned by next(), we will only iterate over that
	// plate and keep on returning it.
	public Plate next() {

		if (checkMaxPrice) {
			for (int i = nextCounter; i < beltSize; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getPrice() <= maxPrice) {

					nextPlatePosition = i;
					nextCounter = i + 1;
					return belt.getPlateAtPosition(i);
				}
			}

			for (int i = 0; i < nextCounter; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getPrice() <= maxPrice) {

					nextPlatePosition = i;
					nextCounter = i + 1;
					return belt.getPlateAtPosition(i);
				}
			}

			throw new NoSuchElementException();
		}

		else if (checkColorFilter) {
			for (int i = nextCounter; i < beltSize; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getColor() == colorFilter) {

					nextPlatePosition = i;
					nextCounter = i + 1;
					return belt.getPlateAtPosition(i);
				}
			}

			for (int i = 0; i < nextCounter; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getColor() == colorFilter) {

					nextPlatePosition = i;
					nextCounter = i + 1;
					return belt.getPlateAtPosition(i);
				}
			}

			throw new NoSuchElementException();
		}

		else {
			for (int i = nextCounter; i < beltSize; i++) {
				if (belt.getPlateAtPosition(i) != null) {
					nextPlatePosition = i;
					nextCounter = i + 1;
					return belt.getPlateAtPosition(i);
				}
			}

			for (int i = 0; i < nextCounter; i++) {
				if (belt.getPlateAtPosition(i) != null) {
					nextPlatePosition = i;
					nextCounter = i + 1;
					return belt.getPlateAtPosition(i);
				}
			}

			throw new NoSuchElementException();
		}
	}

	public void remove() {
		if (nextPlatePosition == null) {
			throw new IllegalStateException();
		}

		belt.clearPlateAtPosition(nextPlatePosition);

		// This ensures that next() will have to be called again
		// or else remove() will throw an IllegalStateException error.
		nextPlatePosition = null;
	}
}