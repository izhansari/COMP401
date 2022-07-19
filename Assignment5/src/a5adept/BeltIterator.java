package a5adept;

import comp401.sushi.Plate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BeltIterator
implements Iterator<Plate> {

	private Belt belt;
	private int start_position;
	private int belt_size;
	private int next_counter;

	public BeltIterator(Belt belt, int start_position) {
		this.belt = belt;
		this.start_position = belt.alterPosition(start_position);
		this.belt_size = belt.getSize();
		this.next_counter = this.start_position;
	}

	public boolean hasNext() {
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

	// The reason we have next_counter and why we start the for-loop there is
	// because once next() is called and returns a plate, we want next() to start
	// its iteration beginning with the next spot on the belt. That is why we set
	// it to i+1, because if the for-loop starts at i, the position of the last
	// plate returned by next(), we will only iterate over that plate and keep on
	// returning it.
	public Plate next() {

		for (int i = next_counter; i < belt_size; i++) {
			if (belt.getPlateAtPosition(i) != null) {
				next_counter = i + 1;
				return belt.getPlateAtPosition(i);
			}
		}

		for (int i = 0; i < next_counter; i++) {
			if (belt.getPlateAtPosition(i) != null) {
				next_counter = i + 1;
				return belt.getPlateAtPosition(i);
			}
		}

		throw new NoSuchElementException();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}