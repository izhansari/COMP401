package a5novice;

import comp401.sushi.*;

public class Application {

	public static void main(String[] args)
			throws PlatePriceException, BeltPlateException {
		
		Belt belt = new Belt(3);
		
		System.out.println(belt.getSize());
		
		Sashimi sushi1 = new Sashimi(Sashimi.SashimiType.CRAB);		
		Sashimi sushi2 = new Sashimi(Sashimi.SashimiType.TUNA);
		
		BluePlate plate1 = new BluePlate(sushi1);
		GreenPlate plate2 = new GreenPlate(sushi2);
		
		belt.setPlateAtPosition(plate1, 0);
		belt.setPlateAtPosition(plate2, 2);
		
		System.out.println(belt.getPlateAtPosition(0).getColor());
		
		System.out.println(belt.removePlateAtPosition(2).getColor());
		
		System.out.println(belt.getPlateAtPosition(2));
	}

}
