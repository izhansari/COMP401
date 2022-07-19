package a8;

import comp401.sushi.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SashimiAndNigiriPanel extends JPanel{

	private JComboBox<Sashimi.SashimiType> sashimiType;
	private JComboBox<Nigiri.NigiriType> nigiriType;
	private JButton makeSashimiButton;
	private JButton makeNigiriButton;

	// We have the constructor accept an ActionListener object as a parameter since
	// we do not want this class to be the one that listens for any changes.
	SashimiAndNigiriPanel(ActionListener listener) {
		setLayout(new GridLayout(0,3));

		sashimiType = new JComboBox<Sashimi.SashimiType>(new Sashimi.SashimiType[]
				{Sashimi.SashimiType.CRAB, Sashimi.SashimiType.EEL, Sashimi.SashimiType.SALMON,
				Sashimi.SashimiType.SHRIMP, Sashimi.SashimiType.TUNA});

		add(new JLabel("   Sashimi Type: "));
		add(sashimiType);

		makeSashimiButton = new JButton("Make Sashimi");
		makeSashimiButton.addActionListener(listener);
		add(makeSashimiButton);

		nigiriType = new JComboBox<Nigiri.NigiriType>(new Nigiri.NigiriType[]
				{Nigiri.NigiriType.CRAB, Nigiri.NigiriType.EEL, Nigiri.NigiriType.SALMON,
				Nigiri.NigiriType.SHRIMP, Nigiri.NigiriType.TUNA});

		add(new JLabel("   Nigiri Type: "));
		add(nigiriType);

		makeNigiriButton = new JButton("Make Nigiri");
		makeNigiriButton.addActionListener(listener);
		add(makeNigiriButton);
	}

	public JComboBox<Sashimi.SashimiType> getSashimiType() {
		return sashimiType;
	}

	public JComboBox<Nigiri.NigiriType> getNigiriType() {
		return nigiriType;
	}

	public JButton getSashimiButton() {
		return makeSashimiButton;
	}

	public JButton getNigiriButton() {
		return makeNigiriButton;
	}
}