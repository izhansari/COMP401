package a4;

public class GreenPlate
extends TypeOfPlate {

	public GreenPlate(Sushi contents) throws PlatePriceException {
		super(contents, Plate.Color.GREEN, 2.0);
	}
}