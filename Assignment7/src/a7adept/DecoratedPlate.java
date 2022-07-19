package a7adept;

import comp401.sushi.Plate;

public interface DecoratedPlate
extends Plate{

	public Plate getPlate();
	public int getAge(int numberOfRotations);
}