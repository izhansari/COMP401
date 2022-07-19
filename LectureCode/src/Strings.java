
class Course {
	
	private String subject;
	private int prefix;
	
	public void setSubject( String subject ) {
		this.subject = subject;
	}
	
	public void setPrefix( int prefix ) {
		this.prefix = prefix;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public int getPrefix() {
		return prefix;
	}
	
	boolean Compare() {
		
		if( prefix > 200 ) {
			return true;
		}
		else return false;
	}
}

public class Strings {

	public static void main( String[] args ) {
		
		String text = null;
		
		System.out.println( text );
		
		Course calculusOne = new Course();
		Course introArabic = new Course();
		
		calculusOne.setSubject( "MATH" );
		calculusOne.setPrefix( 231 );
		
		introArabic.setSubject( "ARAB" );
		introArabic.setPrefix( 101 );
		
		 boolean testCalc = calculusOne.Compare();
		 boolean testArab = introArabic.Compare();
		
		 System.out.println(testCalc);
		 System.out.println(testArab);
		 
		 
		 Integer num = 1;
		 System.out.println(num);
		 
		 num = null;
		 System.out.println(num);
		 
		 num = 2;
		 System.out.println(num);
	}
}
