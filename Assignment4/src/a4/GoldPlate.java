package a4;

public class GoldPlate
extends TypeOfPlate {

	public GoldPlate(Sushi contents, double price)
			throws PlatePriceException {

		super(contents, Plate.Color.GOLD, price);
	}
}