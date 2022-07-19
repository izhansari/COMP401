package a8;

import comp401.sushi.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class SushiWorkstationWidget extends JPanel
implements ActionListener {

	private List<WorkstationListener> listeners;
	private PlateInfoAndRollPanel panelOne;
	private JButton makeRollButton;
	private SashimiAndNigiriPanel panelTwo;

	// We created the widgets in different panels and then
	// added them here, instead of creating them all here.
	public SushiWorkstationWidget() {
		listeners = new ArrayList<WorkstationListener>();
		setLayout(new BorderLayout());

		panelOne = new PlateInfoAndRollPanel();
		add(panelOne, BorderLayout.CENTER);

		makeRollButton = new JButton("Make Roll");
		makeRollButton.addActionListener(this);
		add(makeRollButton, BorderLayout.EAST);

		// We pass in this object as the ActionListener parameter
		// so that it can listen for actions from the buttons.
		panelTwo = new SashimiAndNigiriPanel(this);
		add(panelTwo, BorderLayout.SOUTH);
	}

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

	// Our statement blocks that create the plates and publish them to
	// the registered listeners are surrounded by try-catch blocks so that
	// if an exception does occur, we can catch it and have the program just
	// not create a plate and continue running as usual.
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == makeRollButton) {
			ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

			// We only add an ingredient to our ingredients[] array if it has
			// a non-zero weight.
			if (panelOne.getAvocado() > 0) {
				ingredients.add(new Avocado(panelOne.getAvocado()));
			}
			if (panelOne.getCrab() > 0) {
				ingredients.add(new Crab(panelOne.getCrab()));
			}
			if (panelOne.getEel() > 0) {
				ingredients.add(new Eel(panelOne.getEel()));
			}
			if (panelOne.getRice() > 0) {
				ingredients.add(new Rice(panelOne.getRice()));
			}
			if (panelOne.getSalmon() > 0) {
				ingredients.add(new Salmon(panelOne.getSalmon()));
			}
			if (panelOne.getSeaweed() > 0) {
				ingredients.add(new Seaweed(panelOne.getSeaweed()));
			}
			if (panelOne.getShrimp() > 0) {
				ingredients.add(new Shrimp(panelOne.getShrimp()));
			}
			if (panelOne.getTuna() > 0) {
				ingredients.add(new Tuna(panelOne.getTuna()));
			}

			// This is so that we only create a plate if the roll of sushi is not empty.
			if (ingredients.size() > 0) {
				Roll sushi = new Roll(
						ingredients.toArray(new Ingredient[ingredients.size()]));

				try {
					switch (panelOne.getPlateColor()) {
						case BLUE:
							publishPlateToListeners(new BluePlate(sushi));
							break;
						case GOLD:
							publishPlateToListeners(new GoldPlate(sushi,
									panelOne.getGoldPrice()));
							break;
						case GREEN:
							publishPlateToListeners(new GreenPlate(sushi));
							break;
						case RED:
							publishPlateToListeners(new RedPlate(sushi));
							break;
					}

				} catch (Exception e1) {}
			}
		}

		if (e.getSource() == panelTwo.getSashimiButton()) {
			Sashimi sushi;

			try {
				switch ((Sashimi.SashimiType) panelTwo.getSashimiType().getSelectedItem()) {
					case CRAB:
						sushi = new Sashimi(Sashimi.SashimiType.CRAB);
						break;
					case EEL:
						sushi = new Sashimi(Sashimi.SashimiType.EEL);
						break;
					case SALMON:
						sushi = new Sashimi(Sashimi.SashimiType.SALMON);
						break;
					case SHRIMP:
						sushi = new Sashimi(Sashimi.SashimiType.SHRIMP);
						break;
					case TUNA:
						sushi = new Sashimi(Sashimi.SashimiType.TUNA);
						break;
					default:
						sushi = null;
				}

				switch (panelOne.getPlateColor()) {
					case BLUE:
						publishPlateToListeners(new BluePlate(sushi));
						break;
					case GOLD:
						publishPlateToListeners(new GoldPlate(sushi,
								panelOne.getGoldPrice()));
						break;
					case GREEN:
						publishPlateToListeners(new GreenPlate(sushi));
						break;
					case RED:
						publishPlateToListeners(new RedPlate(sushi));
						break;
				}
			} catch (Exception e1) {}
		}

		if (e.getSource() == panelTwo.getNigiriButton()) {
			Nigiri sushi;

			try {
				switch ((Nigiri.NigiriType) panelTwo.getNigiriType().getSelectedItem()) {
					case CRAB:
						sushi = new Nigiri(Nigiri.NigiriType.CRAB);
						break;
					case EEL:
						sushi = new Nigiri(Nigiri.NigiriType.EEL);
						break;
					case SALMON:
						sushi = new Nigiri(Nigiri.NigiriType.SALMON);
						break;
					case SHRIMP:
						sushi = new Nigiri(Nigiri.NigiriType.SHRIMP);
						break;
					case TUNA:
						sushi = new Nigiri(Nigiri.NigiriType.TUNA);
						break;
					default:
						sushi = null;
				}

				switch (panelOne.getPlateColor()) {
					case BLUE:
						publishPlateToListeners(new BluePlate(sushi));
						break;
					case GOLD:
						publishPlateToListeners(new GoldPlate(sushi,
								panelOne.getGoldPrice()));
						break;
					case GREEN:
						publishPlateToListeners(new GreenPlate(sushi));
						break;
					case RED:
						publishPlateToListeners(new RedPlate(sushi));
						break;
				}
			} catch (Exception e1) {}
		}
	}
}