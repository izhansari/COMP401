package a4;

public class BluePlate
extends TypeOfPlate {

	public BluePlate(Sushi contents) throws PlatePriceException {
		super(contents, Plate.Color.BLUE, 4.0);
	}
}