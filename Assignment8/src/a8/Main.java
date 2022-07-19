package a8;

import comp401.sushi.*;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame main_frame = new JFrame();
		main_frame.setTitle("A8");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SushiWorkstationWidget sushi_workstation = new SushiWorkstationWidget();
		main_frame.setContentPane(sushi_workstation);

		sushi_workstation.addWorkstationListener(new SimpleWorkstationListener());

		main_frame.pack();
		main_frame.setVisible(true);
	}
}

class SimpleWorkstationListener implements WorkstationListener {

	public void handleMadePlate(Plate p) {
		System.out.println(p);
	}
}