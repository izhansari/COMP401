package comp401.sushi;

public abstract class TypeOfPlate
implements Plate {

	private Sushi s;
	private Plate.Color color;
	private double price;

	public TypeOfPlate(Sushi s, Plate.Color color, double price)
	throws PlatePriceException {

		if (color == Plate.Color.GOLD && price < 5.0) {
			throw new IllegalArgumentException("The price must be at least five dollars");
		}

		// This is so that we do not get the NullPointerException error. If s is null
		// however, the instance variable s is not set but the plate is still created
		// and is empty.
		if (s != null) {
			if (s.getCost() >= price) {
				throw new PlatePriceException();
			}

			this.s = s;
		}

		this.color = color;
		this.price = price;
	}

	public Sushi getContents() {
		if (hasContents()) {
			return s;
		}
		else {
			return null;
		}
	}

	public Sushi removeContents() {
		if (!hasContents()) {
			return null;
		}
		else {
			Sushi oldS = s;
			s = null;
			return oldS;
		}
	}

	public void setContents(Sushi s) throws PlatePriceException {
		if (s == null) {
			throw new IllegalArgumentException("The contents can not be null");
		}

		if (s.getCost() >= price ){
			throw new PlatePriceException();
		}

		this.s = s;
	}

	public boolean hasContents() {
		if (s == null) {
			return false;
		}
		else {
			return true;
		}
	}

	public double getPrice() {
		return price;
	}

	public Plate.Color getColor() {
		return color;
	}

	public double getProfit() {
		if (!hasContents()) {
			return 0.0;
		}
		else {
			return price - s.getCost();
		}
	}
}