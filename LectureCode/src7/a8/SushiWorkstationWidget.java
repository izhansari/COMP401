package a8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import comp401.sushi.*;
import comp401.sushi.Nigiri.NigiriType;
import comp401.sushi.Sashimi.SashimiType;

public class SushiWorkstationWidget extends JPanel implements ActionListener {

	/* Do not change the following line. */
	private List<WorkstationListener> listeners;

	private JComboBox<String> sashimiType;
	private JComboBox<String> nigiriType;
	private JComboBox<String> Colors;
	private JSlider goldSlider;
	private JSlider AvocadoSlider;
	private JSlider CrabSlider;
	private JSlider EelSlider;
	private JSlider RiceSlider;
	private JSlider SalmonSlider;
	private JSlider SeaweedSlider;
	private JSlider ShrimpSlider;
	private JSlider TunaSlider;

	private ArrayList<Ingredient> Ingredients;

	public SushiWorkstationWidget() {
		/* Do not change the following line */
		listeners = new ArrayList<WorkstationListener>();

		String ingredients[] = { "Avocado:", "Crab:", "Eel:", "Rice:",
				"Salmon:", "Seaweed:", "Shrimp:", "Tuna:" };
		String plateColors[] = { "Gold", "Red", "Green", "Blue" };

		setLayout(new BorderLayout());

		JPanel optionsMenu = new JPanel();
		optionsMenu.setLayout(new GridLayout(2, 2));

		Colors = new JComboBox<String>(plateColors);
		Colors.addActionListener(this);
		Colors.setActionCommand("gold");
		Colors.setPreferredSize(new Dimension(100, 20));
		optionsMenu.add(new JLabel("Plate Color: "));
		optionsMenu.add(Colors);

		goldSlider = new JSlider(5, 15, 5);
		goldSlider.setPreferredSize(new Dimension(100, 45));
		goldSlider.setMajorTickSpacing(10);
		goldSlider.setMinorTickSpacing(2);
		goldSlider.setPaintLabels(true);
		goldSlider.setPaintTicks(true);
		goldSlider.setMaximum(15);
		optionsMenu.add(new JLabel("Gold Price: "));
		optionsMenu.add(goldSlider);

		add(optionsMenu, BorderLayout.NORTH);

		JPanel ingredientOptions = new JPanel();
		ingredientOptions.setLayout(new GridLayout(8, 2));

		AvocadoSlider = new JSlider(0, 100, 0);
		AvocadoSlider.setName("AvocadoSlider");
		AvocadoSlider.setPreferredSize(new Dimension(100, 20));
		ingredientOptions.add(new JLabel("Avocado"));
		ingredientOptions.add(AvocadoSlider);

		CrabSlider = new JSlider(0, 100, 0);
		CrabSlider.setName("CrabSlider");
		CrabSlider.setPreferredSize(new Dimension(100, 20));
		ingredientOptions.add(new JLabel("Crab"));
		ingredientOptions.add(CrabSlider);

		EelSlider = new JSlider(0, 100, 0);
		EelSlider.setName("EelSlider");
		EelSlider.setPreferredSize(new Dimension(100, 20));
		ingredientOptions.add(new JLabel("Eel"));
		ingredientOptions.add(EelSlider);

		RiceSlider = new JSlider(0, 100, 0);
		RiceSlider.setName("RiceSlider");
		RiceSlider.setPreferredSize(new Dimension(100, 20));
		ingredientOptions.add(new JLabel("Rice"));
		ingredientOptions.add(RiceSlider);

		SalmonSlider = new JSlider(0, 100, 0);
		SalmonSlider.setName("SalmonSlider");
		SalmonSlider.setPreferredSize(new Dimension(100, 20));
		ingredientOptions.add(new JLabel("Salmon"));
		ingredientOptions.add(SalmonSlider);

		SeaweedSlider = new JSlider(0, 100, 0);
		SeaweedSlider.setName("SeaweedSlider");
		SeaweedSlider.setPreferredSize(new Dimension(100, 20));
		ingredientOptions.add(new JLabel("Seaweed"));
		ingredientOptions.add(SeaweedSlider);

		ShrimpSlider = new JSlider(0, 100, 0);
		ShrimpSlider.setName("ShrimpSlider");
		ShrimpSlider.setPreferredSize(new Dimension(100, 20));
		ingredientOptions.add(new JLabel("Shrimp"));
		ingredientOptions.add(ShrimpSlider);

		TunaSlider = new JSlider(0, 100, 0);
		TunaSlider.setName("TunaSlider");
		TunaSlider.setPreferredSize(new Dimension(100, 20));
		ingredientOptions.add(new JLabel("Tuna"));
		ingredientOptions.add(TunaSlider);

		add(ingredientOptions, BorderLayout.CENTER);

		String sashNigiriIngredients[] = { "Tuna", "Salmon", "Eel", "Crab",
				"Shrimp" };

		JPanel sushiOptions = new JPanel();
		sushiOptions.setLayout(new BorderLayout());
		JButton makeRoll = new JButton("Make Roll");
		makeRoll.setActionCommand("roll");
		makeRoll.addActionListener(this);
		makeRoll.setPreferredSize(new Dimension(350, 20));
		sushiOptions.add(makeRoll, BorderLayout.NORTH);

		JPanel sashNigiriOptions = new JPanel();
		sashNigiriOptions.setLayout(new GridLayout(2, 3));
		sashimiType = new JComboBox<String>(sashNigiriIngredients);
		sashimiType.setPreferredSize(new Dimension(46, 20));
		sashNigiriOptions.add(new JLabel("Sashimi Type: "));
		sashNigiriOptions.add(sashimiType);
		JButton makeSashimi = new JButton("Make Sashimi");
		makeSashimi.setActionCommand("sashimi");
		makeSashimi.addActionListener(this);
		makeSashimi.setPreferredSize(new Dimension(76, 20));
		sashNigiriOptions.add(makeSashimi);
		sashNigiriOptions.add(new JLabel("Nigiri Type:"));
		nigiriType = new JComboBox<String>(sashNigiriIngredients);
		sashNigiriOptions.add(nigiriType);
		JButton makeNigiri = new JButton("Make Nigiri");
		makeNigiri.setActionCommand("Nigiri");
		makeNigiri.addActionListener(this);
		sashNigiriOptions.add(makeNigiri);

		sushiOptions.add(sashNigiriOptions, BorderLayout.SOUTH);
		add(sushiOptions, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Plate plateCreated = null;
		Sushi sushiType = null;
		String ingredient = null;

		String colorOfPlate = (String) Colors.getSelectedItem();

		if (e.getActionCommand().equals("sashimi")) {         
			ingredient = (String) sashimiType.getSelectedItem();
			SashimiType ingredientType;

			if (ingredient.equals("Tuna"))
				ingredientType = SashimiType.TUNA;
			else if (ingredient.equals("Salmon"))
				ingredientType = SashimiType.SALMON;
			else if (ingredient.equals("Eel"))
				ingredientType = SashimiType.EEL;
			else if (ingredient.equals("Crab"))
				ingredientType = SashimiType.CRAB;
			else
				ingredientType = SashimiType.SHRIMP;

			sushiType = new Sashimi(ingredientType);
		} else if (e.getActionCommand().equals("Nigiri")) {
			NigiriType ingredientType;
			ingredient = (String) nigiriType.getSelectedItem();

			if (ingredient.equals("Tuna"))
				ingredientType = NigiriType.TUNA;
			else if (ingredient.equals("Salmon"))
				ingredientType = NigiriType.SALMON;
			else if (ingredient.equals("Eel"))
				ingredientType = NigiriType.EEL;
			else if (ingredient.equals("Crab"))
				ingredientType = NigiriType.CRAB;
			else
				ingredientType = NigiriType.SHRIMP;

			sushiType = new Nigiri(ingredientType);
		} else if (e.getActionCommand().equals("gold")) {

		}

		else if (e.getActionCommand().equals("roll")) {
			String ingredientSliders[] = { "AvocadoSlider", "CrabSlider",
					"EelSlider", "RiceSlider", "SalmonSlider", "SeaweedSlider",
					"ShrimpSlider", "TunaSlider" };
			for (String x : ingredientSliders) {
				
				if (x.equals("TunaSlider")) {
					Ingredients.add(new Tuna((double)TunaSlider.getValue()/100));
					continue;
				} else if (x.equals("SalmonSlider")) {
					Ingredients
							.add(new Salmon((double) SalmonSlider.getValue()/100));
					continue;
				} else if (x.equals("EelSlider")) {
					Ingredients.add(new Eel((double) EelSlider.getValue()/100));
					continue;
				} else if (x.equals("CrabSlider")) {
					Ingredients.add(new Crab((double) CrabSlider.getValue()/100));
					continue;
				} else if (x.equals("RiceSlider")) {
					Ingredients.add(new Rice((double) RiceSlider.getValue()/100));
					continue;
				} else if (x.equals("SeaweedSlider")) {
					Ingredients.add(new Seaweed((double) SeaweedSlider
							.getValue()/100));
					continue;
				} else if (x.equals("AvocadoSlider")) {
					Ingredients.add(new Avocado((double) AvocadoSlider
							.getValue()/100));
					continue;
				} else {
					Ingredients
							.add(new Shrimp((double) ShrimpSlider.getValue()/100));
					continue;
				}
			}
			Ingredient[] ingredientList = Ingredients
					.toArray(new Ingredient[Ingredients.size()]); 
			sushiType = new Roll(ingredientList);
		}

		try {
			if (colorOfPlate.equals("Red")) {
				// System.out.println(sushiType);
				plateCreated = new RedPlate(sushiType);
			} else if (colorOfPlate.equals("Green"))
				plateCreated = new GreenPlate(sushiType);
			else if (colorOfPlate.equals("Blue"))
				plateCreated = new BluePlate(sushiType);
			else if (colorOfPlate.equals("Gold"))
				plateCreated = new GoldPlate(sushiType,
						(double) goldSlider.getValue()/100); // gets value from
															// slider, casts to
															// double
		} catch (PlatePriceException i) {
			return;
		}
		publishPlateToListeners(plateCreated);}

	/*
	 * Do not change the following three methods: addWorkstationListener
	 * removeWorkstationListener publicPlateToListeners
	 */

	public void addWorkstationListener(WorkstationListener l) {
		listeners.add(l);
	}

	public void removeWorkstationListener(WorkstationListener l) {
		listeners.remove(l);
	}

	private void publishPlateToListeners(Plate p) {
		for (WorkstationListener l : listeners) {
			l.handleMadePlate(p);
		}
	}
}
