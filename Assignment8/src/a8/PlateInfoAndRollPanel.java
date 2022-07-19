package a8;

import comp401.sushi.*;
import java.awt.*;
import java.lang.IllegalArgumentException;
import java.util.Hashtable;
import javax.swing.*;

@SuppressWarnings("serial")
public class PlateInfoAndRollPanel extends JPanel{

	private JComboBox<Plate.Color> plateColor;
	private JTextField goldPrice;
	private IngredientSlider avocadoSlider;
	private IngredientSlider crabSlider;
	private IngredientSlider eelSlider;
	private IngredientSlider riceSlider;
	private IngredientSlider salmonSlider;
	private IngredientSlider seaweedSlider;
	private IngredientSlider shrimpSlider;
	private IngredientSlider tunaSlider;

	PlateInfoAndRollPanel() {
		setLayout(new GridLayout(0,2));
		
		plateColor = new JComboBox<Plate.Color>(new Plate.Color[]
				{Plate.Color.BLUE, Plate.Color.GOLD, Plate.Color.GREEN,
				Plate.Color.RED});

		add(new JLabel("   Plate Color: "));
		add(plateColor);
		
		goldPrice = new JTextField(5);
		add(new JLabel("   Gold Price: $"));
		add(goldPrice);
		
		avocadoSlider = new IngredientSlider();
		add(new JLabel("   Avocado: "));
		add(avocadoSlider);
		
		crabSlider = new IngredientSlider();
		add(new JLabel("   Crab: "));
		add(crabSlider);
		
		eelSlider = new IngredientSlider();
		add(new JLabel("   Eel: "));
		add(eelSlider);
		
		riceSlider = new IngredientSlider();
		add(new JLabel("   Rice: "));
		add(riceSlider);
		
		salmonSlider = new IngredientSlider();
		add(new JLabel("   Salmon: "));
		add(salmonSlider);
		
		seaweedSlider = new IngredientSlider();
		add(new JLabel("   Seaweed: "));
		add(seaweedSlider);
		
		shrimpSlider = new IngredientSlider();
		add(new JLabel("   Shrimp: "));
		add(shrimpSlider);
		
		tunaSlider = new IngredientSlider();
		add(new JLabel("   Tuna: "));
		add(tunaSlider);
	}

	public Plate.Color getPlateColor() {
		return (Plate.Color) plateColor.getSelectedItem();
	}

	// Since we used a text field to get the price of the gold plate,
	// we need to use parseDouble() to turn it into a double. If the
	// amount entered does not fall within our range, or if it is not
	// a number at all (which will cause it to throw a NumberFormatException,
	// we continue on and catch the exception later.
	public Double getGoldPrice() {
		if ((Double.parseDouble(goldPrice.getText()) >= 5.0 &&
				(Double.parseDouble(goldPrice.getText()) <= 15.0))) {

			return (Double.parseDouble(goldPrice.getText()));
		}

		throw new IllegalArgumentException();
	}

	// We need getter methods to fetch the values of the sliders.
	// We need to cast the slider values to double and then divide
	// by 10 to return the amount in ounces.
	public double getAvocado() {
		return ((double) avocadoSlider.getValue()) / 10.0;
	}

	public double getCrab() {
		return ((double) crabSlider.getValue()) / 10.0;
	}

	public double getEel() {
		return ((double) eelSlider.getValue()) / 10.0;
	}

	public double getRice() {
		return ((double) riceSlider.getValue()) / 10.0;
	}

	public double getSalmon() {
		return ((double) salmonSlider.getValue()) / 10.0;
	}

	public double getSeaweed() {
		return ((double) seaweedSlider.getValue()) / 10.0;
	}

	public double getShrimp() {
		return ((double) shrimpSlider.getValue()) / 10.0;
	}

	public double getTuna() {
		return ((double) tunaSlider.getValue()) / 10.0;
	}

	// We create an inner class for the sliders for the different ingredients since
	// they all have the same properties.
	class IngredientSlider extends JSlider {

		// Since sliders only take integer values, we store the values of the tick marks
		// from 0 to 10 and we will just divide by 10 later when retrieving the values.
		IngredientSlider() {
			super(0, 10);

			// The hashtable is used to store the labels for the slider ticks, which
			// we only put at 0.0 oz, 0.5 oz, and 1.0 oz.
			Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();

			labels.put(0, new JLabel("0.0"));
			labels.put(5, new JLabel("0.5"));
			labels.put(10, new JLabel("1.0"));

			setLabelTable(labels);
			setPaintLabels(true);
			setPaintTicks(true);
			setMajorTickSpacing(1);
			setSnapToTicks(true);
		}
	}
}