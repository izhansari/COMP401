package a1;

public class App {
	public static void main(String[] args) {
		int a = 0;
		for (int i = 0; i<4; i++) {
			int k = i*2;
			int b = 0;
			for (int j=i; j<k; j++) {
				b += 1;
			}
			a += i + b;
		}
		System.out.println(a);
	}
}
