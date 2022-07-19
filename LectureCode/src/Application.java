import java.util.Arrays;
import java.util.Random;
//import java.util.Scanner;

public class Application {

	private static int invoice_number = 1;
	private int id;
	
	public Application() {
		this.id = invoice_number;
		invoice_number++;
	}

	public int getInvoiceNumber() {
		return id;
	}
	
	public static void main( String[] args ) {
		/*
		int[] array;
		array = new int[10];
		
		for( int i = 0; i < array.length ; i++ ) {
			array[i] = i;
			System.out.println( array[i] );
		}
		
		String hello = "Hello";
		if(Character.isUpperCase(hello.charAt(0))) {
			System.out.println("Uppercase");
		}
		else System.out.println("Not uppercase");
		
		char[] charArray = hello.toCharArray();
		for(char s : charArray) {
			System.out.println(s);
		}
		*/
		Application one = new Application();
		Application two = new Application();
		Application three = new Application();
		Application four = new Application();
		Application five = new Application();
		Application six = new Application();
		Application seven = new Application();
		Application eight = new Application();
		
		
		System.out.println(one.getInvoiceNumber());
		System.out.println(two.getInvoiceNumber());
		System.out.println(three.getInvoiceNumber());
		System.out.println(four.getInvoiceNumber());
		System.out.println(five.getInvoiceNumber());
		System.out.println(six.getInvoiceNumber());
		System.out.println(seven.getInvoiceNumber());
		System.out.println(eight.getInvoiceNumber());
		
		int num = 7;
		num += 3;
		System.out.println(num);
		num -= 5;
		System.out.println(num);
		
		int sum = 0;
		for (int i = 0; i <4; i++) {
			for (int j = i; j < i*2; j++) {
				if (j < 4) {
					sum++;
				}
				else {
					sum--;
				}
			}
		}
		System.out.println("Sum is: " + sum);
		
		
		Integer[] a = new Integer[] {1,2,3};
		//int[] b = a;
		//b[0] = 15;
		System.out.println(a[0]);
		System.out.println(4%2);
		System.out.println("-----------");

		Application[] testing = new Application[3];
		testing[1] = one;
		testing[2] = two;
		
		if (one == testing[1]) {
			System.out.println("Equivalent!");
		}
		
		if (one != testing[2]) {
			System.out.println("Not equivalent!");
		}
		
		System.out.println("-----------");
		
		int stayssame1 = 5;
		int stayssame2 = stayssame1;
		System.out.println(stayssame2);
		stayssame1++;
		System.out.println(stayssame2);
		
		Integer[] intarray = new Integer[3];
		
		for (Integer i : intarray) {
			System.out.println(i);
		}
		
		System.out.println(String.valueOf(((double) 150) / 100));
		
		System.out.println("---------------");
		
		System.out.println(Arrays.asList(a).indexOf(1));
		
		Random generator = new Random();
		System.out.println(generator.nextInt(2));
		/*
		Scanner input = new Scanner( System.in );
		
		int value = 0;
		
		do {
			System.out.println( "Guess my age: " );
			value = input.nextInt();
		}
		
		while( value != 19 );
		
		System.out.println( "You got it!" ); */
	}
}
