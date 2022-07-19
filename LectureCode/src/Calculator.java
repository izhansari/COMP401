import java.util.Scanner;

public class Calculator {
	
	public static void main( String[] args ) {

		Scanner input = new Scanner( System.in );
		
		System.out.println( "Enter a number: " );
		int numberOne = input.nextInt();
		input.nextLine();
		
		System.out.println( "Enter another number: " );
		int numberTwo = input.nextInt();
		input.nextLine();
		
		System.out.println( "What operation do you want to perform?" );
		String operation = input.nextLine();
		
		switch( operation ) {
			case "add":
				System.out.printf( "The sum is %d", numberOne+numberTwo );
				break;
			
			case "multiply":
				System.out.printf( "The product is %d", numberOne*numberTwo );
				break;
				
			case "subtract":
				System.out.printf( "The difference is %d", numberOne-numberTwo );
				break;
				
			case "divide":
				System.out.printf( "The quotient is %d", numberOne/numberTwo );
				break;
				
			default:
				System.out.println( "Please enter a legitimate operation." );
		}
	}
}