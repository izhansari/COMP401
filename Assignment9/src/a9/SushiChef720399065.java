package a9;

import comp401.sushi.*;

import java.math.BigDecimal;
import java.math.MathContext;

import java.util.ArrayList;
import java.util.Random;

public class SushiChef720399065
implements SushiChef {

	private static final int PID = 720399065;

	// Shout out to South Park
	private static final String NAME = "Jerome \"Chef\" McElroy";

	private double outstandingCost;
	private double profit;
	private Sushi sushi;

	// We use the Random class to determine what type of sushi to make.
	private Random generator;

	// We use the MathContext class with BigDecimal in order to round perfectly
	// to two decimal places.
	private MathContext mc;
 
	// For our case, we set this to be equal to 0, but when set to any other number, it sets
	// a floor on the amount of profit possible per plate. For instance, if we want to be
	// guaranteed a profit of at least $2 per plate we sell, we set this equal to 2.0 in the
	// constructor.
	private double profitModifier;

	public SushiChef720399065() {
		generator = new Random();
		mc = new MathContext(2);
		profitModifier = 0.0;
	}

	// To determine whether to make a roll, a sashimi, or a nigiri, we use the nextGaussian() method.
	// In our case, we want 75% of the sushi we create to be rolls, and the other 25% to be split evenly
	// between sashimis and nigiris (so 12.5% each). Since 75% of the area under the standard normal curve
	// falls between -1.15 and 1.15, if the random number we generated earlier with nextGaussian() is between
	// those two we create a roll. If it is less than -1.15 or greater than 1.15 we create a nigiri and sashimi,
	// respectively.
	private void randomizeSushi() {
		double whichTypeSushi = generator.nextGaussian();
		
		if (whichTypeSushi >= -1.15 && whichTypeSushi <= 1.15) {
			ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
			double[] amounts = new double[8]; 

			// We randomize the amounts of each ingredient in the roll as well. The BigDecimal class is used
			// since it is more precise to round with and we want to round each ingredient to the nearest tenth place
			// (so two decimal places). Also, we do not want an ingredient to be in our roll if its weight is less than
			// 0.1oz, so if that is the case we do not add it to our arraylist of ingredients.
			for (int i = 0; i < amounts.length; i++) {
				BigDecimal tempValue = new BigDecimal(Double.toString(generator.nextDouble()));
				tempValue.round(mc);
				if (tempValue.compareTo(new BigDecimal("0.1")) == -1) {
					amounts[i] = 0;
				}
				else {
					amounts[i] = tempValue.doubleValue();
				}
			}

			if (amounts[0] > 0) {
				ingredients.add(new Avocado(amounts[0]));
			}
			if (amounts[1] > 0) {
				ingredients.add(new Crab(amounts[1]));
			}
			if (amounts[2] > 0) {
				ingredients.add(new Eel(amounts[2]));
			}
			if (amounts[3] > 0) {
				ingredients.add(new Rice(amounts[3]));
			}
			if (amounts[4] > 0) {
				ingredients.add(new Salmon(amounts[4]));
			}
			if (amounts[5] > 0) {
				ingredients.add(new Seaweed(amounts[5]));
			}
			if (amounts[6] > 0) {
				ingredients.add(new Shrimp(amounts[6]));
			}
			if (amounts[7] > 0) {
				ingredients.add(new Tuna(amounts[7]));
			}

			sushi = new Roll(
					ingredients.toArray(new Ingredient[ingredients.size()]));
		}

		if (whichTypeSushi < -1.15) {
			int whichTypeNigiri = generator.nextInt(5);

			switch(whichTypeNigiri) {
			case 0: sushi = new Nigiri(Nigiri.NigiriType.CRAB); break;
			case 1: sushi = new Nigiri(Nigiri.NigiriType.EEL); break;
			case 2: sushi = new Nigiri(Nigiri.NigiriType.SALMON); break;
			case 3: sushi = new Nigiri(Nigiri.NigiriType.SHRIMP); break;
			case 4: sushi = new Nigiri(Nigiri.NigiriType.TUNA); break;
			}
		}

		if (whichTypeSushi > 1.15) {
			int whichTypeSashimi = generator.nextInt(5);
			
			switch(whichTypeSashimi) {
			case 0: sushi = new Sashimi(Sashimi.SashimiType.CRAB); break;
			case 1: sushi = new Sashimi(Sashimi.SashimiType.EEL); break;
			case 2: sushi = new Sashimi(Sashimi.SashimiType.SALMON); break;
			case 3: sushi = new Sashimi(Sashimi.SashimiType.SHRIMP); break;
			case 4: sushi = new Sashimi(Sashimi.SashimiType.TUNA); break;
			}
		}
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public int getPID() {
		return PID;
	}

	@Override
	public Plate makePlate() {
		Plate plate = null;
		randomizeSushi();
		double plateCost = Math.ceil(sushi.getCost() + profitModifier);

		try {
			switch((int) plateCost) {
			case 1: plate = new RedPlate(sushi); break;
			case 2: plate = new GreenPlate(sushi); break;
			case 3: plate = new BluePlate(sushi); break;
			case 4: plate = new BluePlate(sushi); break;
			default: plate = new GoldPlate(sushi, plateCost); break;
			}
		}
		catch (PlatePriceException e) {}

		outstandingCost += sushi.getCost();
		return plate;
	}

	@Override
	public void observePurchase(String customer, Plate plate, int chef_pid) {
		if (chef_pid == PID) {
			outstandingCost -= plate.getContents().getCost();
			profit += plate.getProfit();
		}
	}

	@Override
	public void observeSpoilage(Plate plate, int chef_pid) {
		if (chef_pid == PID) {
			outstandingCost -= plate.getContents().getCost();
			profit -= plate.getContents().getCost();
		}
	}

	@Override
	public double getOutstandingCost() {
		return outstandingCost;
	}

	@Override
	public double getProfit() {
		return profit;
	}
}