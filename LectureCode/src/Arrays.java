import java.util.ArrayList;

public class Arrays {

	public static void main( String[] args ) {
		
		int[][] numbers = {
				{4,5,2},
				{123,54,32,65},
				{545,65,324,654},
				{23,3}
		};
		
		for( int i = 0; i < numbers.length; i++  ) {
			
			int j = 0;
			
			while( j < numbers[i].length ) {
				
				System.out.print( numbers[i][j] );
				System.out.print(" ");
				j++;
			}
			
			System.out.print("\n");
		}
		
		String[] test = new String[3];
		System.out.println(test[0]);
		//System.out.println(test[5] == null);
		
		ArrayList<String> belt = new ArrayList<String>();
		belt.add("Hello");
		System.out.println(belt.get(0));
		//System.out.println(belt.get(1));
		
		//System.out.println(3%10);
		
		Integer testing;
		//System.out.println(testing);
	}
}