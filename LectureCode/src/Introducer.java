//import java.util.Scanner;

public class Introducer {

	public static void main(String[] args) {
		/*Scanner s = new Scanner(System.in);
		StringBuilder sentence = new StringBuilder();
		
		System.out.println("What is your name?");
		sentence.append(s.nextLine());
		
		sentence.append(" is a ");
		
		System.out.println("What is your job?");
		sentence.append(s.nextLine().toLowerCase());
		
		sentence.append(".");
		
		System.out.println(sentence.toString());
		
		s.close();*/
		System.out.println(bitCount(10));
		
	}
	public static int bitCount(int n) {
		if (n == 0) {
			return 0;
		}
		return n%2 + bitCount(n/2);
	}
	
}
