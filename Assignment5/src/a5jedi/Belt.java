package a5jedi;

import comp401.sushi.Plate;
import java.lang.Iterable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Belt
implements Iterable<Plate> {

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

	// Since the belt is circular, this method transforms any given parameter for
	// a position on the belt into its corresponding position as if the belt was just
	// a straight line. The reason this method is protected and not private is so that
	// it can be accessed in the BeltIterator class.
	protected int alterPosition(int position) {
		if (position >= 0) {
			position = position % belt_size;
			return position;
		}
		else {
			position = ((position % belt_size) + belt_size) % belt_size;
			return position;
		}
	}

	public Plate getPlateAtPosition(int position) {
		position = alterPosition(position);

		return belt[position];
	}

	public void clearPlateAtPosition(int position) {
		position = alterPosition(position);

		belt[position] = null;
	}

	public Plate removePlateAtPosition(int position) {
		position = alterPosition(position);

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

		position = alterPosition(position);

		if (plate == null) {
			throw new IllegalArgumentException();
		}

		if (belt[position] != null) {
			throw new BeltPlateException(position, plate, this);
		}

		belt[position] = plate;
	}

	public int setPlateNearestToPosition(Plate plate, int position)
			throws BeltFullException, BeltPlateException {

		position = alterPosition(position);

		// Since our belt is circular, we have to "break" it in to two separate parts
		// in order to operate on it as we would other arrays. This for loop goes through
		// the positions on the belt from the given start position to the last position
		// in the array.
		for (int i = position; i < belt_size; i++) {
			if (getPlateAtPosition(i) == null) {
				setPlateAtPosition(plate, i);
				return i;
			}
		}

		// This for loop, on the other hand, goes through the belt from the beginning all
		// the way up to the given start position that we started with in our previous for
		// loop. This ensures that we go through all the positions on the belt.
		for (int i = 0; i < position; i++) {
			if (getPlateAtPosition(i) == null) {
				setPlateAtPosition(plate, i);
				return i;
			}
		}

		throw new BeltFullException(this);
	}

	public void rotate() {

		// Since Collections will operate on lists but not on arrays, using
		// Arrays.asList() sends to Collections.rotate() a list form of our
		// array belt. Any changes applied to this list are also applied to
		// our array, which in this case means rotating the elements of belt
		// by one.
		Collections.rotate(Arrays.asList(belt), 1);
	}

	public Iterator<Plate> iterator() {
		return new BeltIterator(this, 0);
	}

	public Iterator<Plate> iteratorFromPosition(int position) {
		return new BeltIterator(this, position);
	}

	public Iterator<Plate> iteratorFromPosition(int position,
			double max_price) {

		return new BeltIterator(this, position, max_price);
	}

	public Iterator<Plate> iteratorFromPosition(int position,
			Plate.Color color) {

		return new BeltIterator(this, position, color);
	}

	public int getSize() {
		return belt_size;
	}
}