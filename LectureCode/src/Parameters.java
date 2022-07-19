// So we can accept user input
import java.util.Scanner;

// Define a new class Lecture (couldn't use Course because it's already been defined
class Lecture {
	private String title;
	private int level;
	
	public void setTitle( String title ) {
		this.title = title;
	}
	
	public void setLevel( int level ) {
		this.level = level;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getLevel() {
		return level;
	}
	
	boolean IntensityLevel( int comparison ) {
		if( level > comparison ) {
			return true;
		}
		else return false;
	}
}

public class Parameters {
	
	public static void main( String[] args ) {
		
		Scanner input = new Scanner( System.in );
		
		System.out.println( "Enter the level you would like to compare to: " );
		int base = input.nextInt();
		// To account for the new line character
		input.nextLine();
		
		Lecture macroEcon = new Lecture();
		macroEcon.setTitle( "Macroeconomics" );
		macroEcon.setLevel( 400 );
		
		if( macroEcon.IntensityLevel( base ) ) {
			System.out.printf( "%s is a %d level class, which is tougher than a %d level class.", macroEcon.getTitle(), macroEcon.getLevel(), base );
		}
		else System.out.printf( "%s is a %d level class, which is easier than a %d level class.", macroEcon.getTitle(), macroEcon.getLevel(), base );
	}
}
