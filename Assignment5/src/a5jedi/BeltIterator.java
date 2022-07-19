package a5jedi;

import comp401.sushi.Plate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BeltIterator
implements Iterator<Plate> {

	private Belt belt;
	private int start_position;
	private int belt_size;
	private int next_counter;

	// This is to store the position of the plate returned by next(), so that
	// remove() can remove it if called. The reason we use Integer and not int
	// is so that we can are able to set the value to null.
	private Integer next_plate_position;

	private boolean check_max_price;
	private double max_price;
	private boolean check_color_filter;
	private Plate.Color color_filter;

	public BeltIterator(Belt belt, int start_position) {
		this.belt = belt;
		this.start_position = belt.alterPosition(start_position);
		this.belt_size = belt.getSize();
		this.next_counter = this.start_position;
	}

	public BeltIterator(Belt belt, int start_position,
			double max_price) {

		this.belt = belt;
		this.start_position = belt.alterPosition(start_position);
		this.belt_size = belt.getSize();
		this.next_counter = this.start_position;
		this.check_max_price = true;
		this.max_price = max_price;
	}

	public BeltIterator(Belt belt, int start_position,
			Plate.Color color_filter) {

		this.belt = belt;
		this.start_position = belt.alterPosition(start_position);
		this.belt_size = belt.getSize();
		this.next_counter = this.start_position;
		this.check_color_filter = true;
		this.color_filter = color_filter;
	}

	// Depending on which constructor was called, only one (or none) of the boolean
	// variables we created to check if a condition is imposed will be true (since
	// the default value for a boolean is false).
	public boolean hasNext() {

		if (check_max_price) {
			for (int i = start_position; i < belt_size; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getPrice() <= max_price) {

					return true;
				}
			}

			for (int i = 0; i < start_position; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getPrice() <= max_price) {

					return true;
				}
			}

			return false;
		}

		else if (check_color_filter) {
			for (int i = start_position; i < belt_size; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getColor() == color_filter) {

					return true;
				}
			}

			for (int i = 0; i < start_position; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getColor() == color_filter) {

					return true;
				}
			}

			return false;
		}

		else {
			for (int i = start_position; i < belt_size; i++) {
				if (belt.getPlateAtPosition(i) != null) {
					return true;
				}
			}

			for (int i = 0; i < start_position; i++) {
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
	// iterated over by next() is stored in next_plate_position. The reason we have
	// next_counter and why we start the for-loop there is because once next() is called
	// and returns a plate, we want next() to start its iteration beginning with the next
	// spot on the belt. That is why we set it to i+1, because if the for-loop starts at i,
	// the position of the last plate returned by next(), we will only iterate over that
	// plate and keep on returning it.
	public Plate next() {

		if (check_max_price) {
			for (int i = next_counter; i < belt_size; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getPrice() <= max_price) {

					next_plate_position = i;
					next_counter = i + 1;
					return belt.getPlateAtPosition(i);
				}
			}

			for (int i = 0; i < next_counter; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getPrice() <= max_price) {

					next_plate_position = i;
					next_counter = i + 1;
					return belt.getPlateAtPosition(i);
				}
			}

			throw new NoSuchElementException();
		}

		else if (check_color_filter) {
			for (int i = next_counter; i < belt_size; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getColor() == color_filter) {

					next_plate_position = i;
					next_counter = i + 1;
					return belt.getPlateAtPosition(i);
				}
			}

			for (int i = 0; i < next_counter; i++) {
				if (belt.getPlateAtPosition(i) != null &&
						belt.getPlateAtPosition(i).getColor() == color_filter) {

					next_plate_position = i;
					next_counter = i + 1;
					return belt.getPlateAtPosition(i);
				}
			}

			throw new NoSuchElementException();
		}

		else {
			for (int i = next_counter; i < belt_size; i++) {
				if (belt.getPlateAtPosition(i) != null) {
					next_plate_position = i;
					next_counter = i + 1;
					return belt.getPlateAtPosition(i);
				}
			}

			for (int i = 0; i < next_counter; i++) {
				if (belt.getPlateAtPosition(i) != null) {
					next_plate_position = i;
					next_counter = i + 1;
					return belt.getPlateAtPosition(i);
				}
			}

			throw new NoSuchElementException();
		}
	}

	public void remove() {
		if (next_plate_position == null) {
			throw new IllegalStateException();
		}

		belt.clearPlateAtPosition(next_plate_position);

		// This ensures that next() will have to be called again
		// or else remove() will throw an IllegalStateException error.
		next_plate_position = null;
	}
}