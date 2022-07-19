package a7jedi;

import comp401.sushi.*;

public class Application {

	@SuppressWarnings("all")
	public static void main(String[] args)
			throws PlatePriceException, BeltPlateException, BeltFullException {
		
		Belt belt = new Belt(3);
		
		System.out.println(belt.getSize());
		
		Sashimi sushi1 = new Sashimi(Sashimi.SashimiType.CRAB);		
		Sashimi sushi2 = new Sashimi(Sashimi.SashimiType.TUNA);
		Sashimi sushi3 = new Sashimi(Sashimi.SashimiType.EEL);
		
		BluePlate plate1 = new BluePlate(sushi1);
		GreenPlate plate2 = new GreenPlate(sushi2);
		RedPlate plate3 = new RedPlate(sushi3);
		
		belt.setPlateAtPosition(plate1, 0);
		//belt.setPlateAtPosition(plate2, 2);
		
		System.out.println(belt.getPlateAtPosition(0).getColor());
		
		//System.out.println(belt.getPlateAtPosition(-4));
		
		//belt.setPlateNearestToPosition(plate2, 0);
		//System.out.println(belt.getPlateAtPosition(1));
		
		//belt.setPlateNearestToPosition(plate3, 0);
		/*
		System.out.println(belt.iteratorFromPosition(2).hasNext());
		
		belt.iterator().next();
		belt.iterator().remove();
		
		
		System.out.println(belt.getPlateAtPosition(0));
		*/
		
		SpoilageCollector counter = new SpoilageCollector();
		belt.addObserver(counter);
		
		System.out.println(belt.getAgeOfPlateAtPosition(0));
		belt.rotate();
		System.out.println(belt.getAgeOfPlateAtPosition(1));
		belt.rotate();
		System.out.println(belt.getAgeOfPlateAtPosition(2));
		belt.rotate();
		System.out.println(belt.getAgeOfPlateAtPosition(0));
		
		/*System.out.println(counter.getTotalSpoiledCost());
		System.out.println(counter.getTotalSpoiledFood());
		System.out.println(counter.getTotalSpoiledSeafood());
		System.out.println(counter.getTotalSpoiledShellfish());*/
	}

}
