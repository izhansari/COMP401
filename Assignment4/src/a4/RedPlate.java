package a4;

public class RedPlate
extends TypeOfPlate {

	public RedPlate(Sushi contents) throws PlatePriceException {
		super(contents, Plate.Color.RED, 1.0);
	}
}