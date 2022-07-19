package a6jedi;

import comp401.sushi.Plate;
import java.lang.Iterable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Observable;

public class Belt
extends Observable
implements Iterable<Plate> {

	private int beltSize;

	// The reason an array is used versus an ArrayList is because the size of the
	// belt is not dynamic and will not change. Also, since the default values of
	// the unpopulated fields of the array are null, this helps in the later methods
	// we create.
	private Plate[] belt;

	private Customer[] customers;

	public Belt(int beltSize) {
		if (beltSize <= 0) {
			throw new IllegalArgumentException();
		}

		this.beltSize = beltSize;
		this.belt = new Plate[beltSize];
		this.customers = new Customer[beltSize];
	}

	// Since the belt is circular, this method transforms any given parameter for
	// a position on the belt into its corresponding position as if the belt was just
	// a straight line. The reason this method is protected and not private is so that
	// it can be accessed in the BeltIterator class.
	protected int alterPosition(int position) {
		if (position >= 0) {
			position = position % beltSize;
			return position;
		}
		else {
			position = ((position % beltSize) + beltSize) % beltSize;
			return position;
		}
	}

	public Plate getPlateAtPosition(int position) {
		position = alterPosition(position);

		return belt[position];
	}

	public void clearPlateAtPosition(int position) {
		position = alterPosition(position);

		if (belt[position] != null) {
			setChanged();
			notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_REMOVED,
					belt[position], position));
		}

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

		setChanged();
		notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_PLACED,
				plate, position));
	}

	public int setPlateNearestToPosition(Plate plate, int position)
			throws BeltFullException, BeltPlateException {

		position = alterPosition(position);

		// Since our belt is circular, we have to "break" it in to two separate parts
		// in order to operate on it as we would other arrays. This for loop goes through
		// the positions on the belt from the given start position to the last position
		// in the array.
		for (int i = position; i < beltSize; i++) {
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

		for (int i = 0; i < beltSize; i++) {

			// We check to make sure that there is both a customer registered
			// at the position and that after the rotation, there is a plate
			// at that position. Once we do so we call the observePlateOnBelt()
			// method.
			if (customers[i] != null && belt[i] != null) {
				customers[i].observePlateOnBelt(this, belt[i], i);
			}
		}
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

	// To register a customer to a position on the belt, we created in the
	// constructor an array of Customer objects with the same length as the
	// belt. In this array, each position represents the Customer who is
	// registered to the corresponding position in the belt array.
	public void registerCustomerAtPosition(Customer c, int position) {
		position = alterPosition(position);

		if (customers[position] != null) {
			throw new RuntimeException("There is already a customer registered at this position.");
		}

		for (int i = 0; i < customers.length; i++) {
			if (c == customers[i]) {
				throw new RuntimeException("This customer is already registered at a different position.");
			}
		}

		customers[position] = c;
	}

	public Customer unregisterCustomerAtPosition(int position) {
		position = alterPosition(position);

		if (customers[position] == null) {
			return null;
		}

		Customer c = customers[position];
		customers[position] = null;

		return c;
	}

	public int getSize() {
		return beltSize;
	}
}