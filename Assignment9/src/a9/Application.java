package a9;
import comp401.sushi.*;
import java.util.Random;
import java.math.BigDecimal;
import java.math.MathContext;

public class Application {

	public static void main(String[] args) {
	
		SushiChef720399065 chef = new SushiChef720399065(); 
		/*System.out.println(chef.getName());
		System.out.println(chef.getPID());
		Random generator = new Random();
		System.out.println(generator.nextDouble());
		BigDecimal bg1 = new BigDecimal(Double.toString(generator.nextDouble()));
		System.out.println(bg1);
		bg1 = bg1.round(new MathContext(2));
		System.out.println(bg1);
		System.out.println(bg1.doubleValue());*/
		chef.makePlate();
		chef.makePlate();
		chef.makePlate();
		chef.makePlate();
		chef.makePlate();
		System.out.println(chef.getOutstandingCost());
		System.out.println(chef.getProfit());
	}
}