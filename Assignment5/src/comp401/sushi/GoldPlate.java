package comp401.sushi;

public class GoldPlate
extends TypeOfPlate {

	public GoldPlate(Sushi contents, double price)
			throws PlatePriceException {

		super(contents, Plate.Color.GOLD, price);
	}
}