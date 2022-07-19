package a7adept;

import comp401.sushi.*;

public class TypeOfDecoratedPlate
implements DecoratedPlate {

	private Plate plate;
	private int originalRotationNumber;

	public TypeOfDecoratedPlate(Plate plate, int originalRotationNumber) {
		this.plate = plate;
		this.originalRotationNumber = originalRotationNumber;
	}

	// This is the unwrapper method to get the original, undecorated Plate object.
	public Plate getPlate() {
		return plate;
	}

	public int getAge(int numberOfRotations) {
		return numberOfRotations - originalRotationNumber;
	}

	public Sushi getContents() {
		return plate.getContents();
	}

	public Sushi removeContents() {
		return plate.removeContents();
	}

	public void setContents(Sushi s) throws PlatePriceException {
		plate.setContents(s);
	}

	public boolean hasContents() {
		return plate.hasContents();
	}

	public double getPrice() {
		return plate.getPrice();
	}

	public Plate.Color getColor() {
		return plate.getColor();
	}

	public double getProfit() {
		return plate.getProfit();
	}
}