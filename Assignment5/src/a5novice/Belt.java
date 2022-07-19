package a5novice;

import comp401.sushi.Plate;
import java.util.NoSuchElementException;

public class Belt {
	private int belt_size;

	// The reason an array is used versus an ArrayList is because the size of the
	// belt is not dynamic and will not change. Also, since the default values of
	// the unpopulated fields of the array are null, this helps in the later methods
	// we create.
	private Plate[] belt;

	public Belt(int belt_size) {
		if (belt_size <= 0) {
			throw new IllegalArgumentException();
		}

		this.belt_size = belt_size;
		this.belt = new Plate[belt_size];
	}

	public Plate getPlateAtPosition(int position) {
		if (position < 0 || position > belt_size - 1) {
			throw new IllegalArgumentException();
		}

		return belt[position];
	}

	public void clearPlateAtPosition(int position) {
		if (position < 0 || position > belt_size - 1) {
			throw new IllegalArgumentException();
		}

		belt[position] = null;
	}

	public Plate removePlateAtPosition(int position) {
		if (belt[position] == null) {
			throw new NoSuchElementException();
		}

		// We need to store a copy of the plate before we remove it, because
		// we are expected to return the plate.
		Plate plate = getPlateAtPosition(position);

		clearPlateAtPosition(position);

		return plate;
	}

	public void setPlateAtPosition(Plate plate, int position)
			throws BeltPlateException {

		if (plate == null) {
			throw new IllegalArgumentException();
		}

		if (position < 0 || position > belt_size - 1) {
			throw new IllegalArgumentException();
		}

		if (belt[position] != null) {
			throw new BeltPlateException(position, plate, this);
		}

		belt[position] = plate;
	}

	public int getSize() {
		return belt_size;
	}
}