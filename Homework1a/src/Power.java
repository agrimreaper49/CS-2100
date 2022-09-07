import java.util.Scanner;

public class Power {
	public static long power ( int base , int exp ) {
		if (exp == 0) {
			return 1;
		} else if (exp == 1) {
			return base;
		}
		long ans = base;
		for (int i = 0; i < exp - 1; i++) {
			ans *= base;
		}
		return ans;
	}
	
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		int base = scan.nextInt();
		int power = scan.nextInt();
		System.out.println(power(base, power));
	}
}
